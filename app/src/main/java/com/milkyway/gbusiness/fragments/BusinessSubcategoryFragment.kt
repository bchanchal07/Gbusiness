package com.milkyway.gbusiness.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.adaptor.BusinessSubCategoryAdaptor
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.SubCategoryDataClass
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.AppConstants.SPEECH_REQUEST_CODE
import com.milkyway.gbusiness.global.CommonUtil
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_business_cat_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [BusinessSubcategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BusinessSubcategoryFragment : Fragment(), BusinessSubCategoryAdaptor.OnSubCatAdaptorClick {

    lateinit var mContext: Context
    lateinit var subCatDataResponse: SubCategoryDataClass
    private lateinit var rvSubCategoryData: RecyclerView
    private lateinit var myBusinessSubCatBack: ImageView
    private lateinit var searchImageView: ImageView

    private lateinit var etSearch: AppCompatEditText
    private lateinit var noSearchResultsFoundText: TextView
    private lateinit var searchEditText: TextView
    private lateinit var tvSubCatTitle: TextView
    private lateinit var subCatDataList: List<SubCategoryDataClass.Subcategory>
    private lateinit var clearQueryImageView: ImageView
    private lateinit var voiceSearchImageView: ImageView
    private lateinit var ivSubCatImage: ImageView

    private var catId: Int = 0
    private var catIdSaveState: Int = 0
    private var catName: String = ""
    private var catNameFinal: String = ""
    private var imgUrl: String = ""
    private var imgUrlFinal: String = ""
    private var catNameBack: String = ""
    private var imgUrlBack: String = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments ?: return
        //position = args!!.getInt("position", 0)
        if (args != null) {
            //catId = args.getInt("cat_id", 0)
            //catId=savedInstanceState!!.getInt("cat_id",0)
            catName = args.getString("cat_name", "")
            imgUrl = args.getString("img_url", "")
            catId = args.getInt("cat_id")
            catIdSaveState= args.getInt("cat_id_back")
            catNameBack= args.getString("cat_name_back","")
            imgUrlBack= args.getString("img_url_back","")
            if (catId > 0) {
                callSubCategoryApi(catId)
            } else {
                callSubCategoryApi(CommonUtil.getIntPreferences(mContext, AppConstants.CAT_ID)!!)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_business_subcategory, container, false)
        initializeView(view)
        return view
    }

    private fun callSubCategoryApi(catId: Int) {
        if (CommonUtil.checkNetwork(mContext)) {
            CommonUtil.showDialog(mContext)
            GbusinessService.create(mContext).getSubCategoryList(
                catId
            ).enqueue(object : Callback<SubCategoryDataClass> {
                override fun onResponse(call: Call<SubCategoryDataClass>, response: Response<SubCategoryDataClass>) {
                    CommonUtil.hideDialog(mContext)
                    // Log.i("TAGad", response.body()?.success.toString())
                    subCatDataResponse = response.body()!!

                    if (response.code() == 200) {
                        if (subCatDataResponse.subcategory != null) {

                            if (subCatDataResponse.subcategory.isNotEmpty()) {
                                subCatDataList = subCatDataResponse.subcategory
                                setSubCategoryDataAdaptor(subCatDataList)
                            } else {
                                Toast.makeText(requireActivity(), "Data is not available", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<SubCategoryDataClass>, t: Throwable) {
                    CommonUtil.hideDialog(mContext)
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                    CommonUtil.logi(t.localizedMessage.toString())
                }

            })


        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun setSubCategoryDataAdaptor(subCatDataList: List<SubCategoryDataClass.Subcategory>) {
        rvSubCategoryData.layoutManager = LinearLayoutManager(context)
        val adapter = BusinessSubCategoryAdaptor(requireActivity(), this, subCatDataList)
        // Setting the Adapter with the recyclerview
        rvSubCategoryData.adapter = adapter
    }

    private fun initializeView(view: View) {
        rvSubCategoryData = view.findViewById(R.id.rvSubCatDetails)
        myBusinessSubCatBack = view.findViewById(R.id.mySubCatDetailsBack)

        etSearch = view.findViewById(R.id.search_edit_text)
        noSearchResultsFoundText = view.findViewById(R.id.no_search_results_found_text)
        clearQueryImageView = view.findViewById(R.id.clear_search_query)
        voiceSearchImageView = view.findViewById(R.id.voice_search_query)
        ivSubCatImage = view.findViewById(R.id.ivSubCatImage)
        tvSubCatTitle = view.findViewById(R.id.tvSubCatTitle)
        etSearch.hint = "Search Sub-Category"

        imgUrlFinal = if(imgUrl.isNotEmpty())
            imgUrl
        else
            imgUrlBack

        catNameFinal = if(catName.isNotEmpty())
            catName
        else
            catNameBack


        if (URLUtil.isValidUrl(imgUrlFinal)) {
            Picasso.get()
                .load(imgUrlFinal)
                .placeholder(R.drawable.img_not_available)
                .into(ivSubCatImage)
        }
        tvSubCatTitle.text = catNameFinal
        myBusinessSubCatBack.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_mySubCategoryFragment_to_myCategoryFragment)
        }

        etSearch.doOnTextChanged { text, _, _, _ ->
            val query = text.toString().toLowerCase(Locale.getDefault())
            filterWithQuery(query)
            toggleImageView(query)
        }

        voiceSearchImageView.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(
                    RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                )
            }
            startActivityForResult(intent, SPEECH_REQUEST_CODE)
        }

        clearQueryImageView.setOnClickListener {
            etSearch.setText("")
            setSubCategoryDataAdaptor(subCatDataList)
        }
    }

    private fun filterWithQuery(query: String) {
        if (query.isNotEmpty()) {
            val filteredList: List<SubCategoryDataClass.Subcategory> = onFilterChanged(query)
            //attachAdapter(filteredList)
            setSubCategoryDataAdaptor(filteredList)
            toggleRecyclerView(filteredList)
        } else if (query.isEmpty()) {
            //attachAdapter(sportsList)
            setSubCategoryDataAdaptor(subCatDataList)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val spokenText: String? =
                data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).let { results ->
                    results?.get(0)
                }
            // Do something with spokenText
            etSearch.setText(spokenText)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun toggleRecyclerView(sportsList: List<SubCategoryDataClass.Subcategory>) {
        if (sportsList.isEmpty()) {
            rvSubCategoryData.visibility = View.INVISIBLE
            noSearchResultsFoundText.visibility = View.VISIBLE
        } else {
            rvSubCategoryData.visibility = View.VISIBLE
            noSearchResultsFoundText.visibility = View.INVISIBLE
        }
    }

    private fun toggleImageView(query: String) {
        if (query.isNotEmpty()) {
            clearQueryImageView.visibility = View.VISIBLE
            voiceSearchImageView.visibility = View.INVISIBLE
        } else if (query.isEmpty()) {
            clearQueryImageView.visibility = View.INVISIBLE
            voiceSearchImageView.visibility = View.VISIBLE
        }
    }

    private fun onFilterChanged(filterQuery: String): List<SubCategoryDataClass.Subcategory> {
        val filteredList = ArrayList<SubCategoryDataClass.Subcategory>()
        for (searchList in subCatDataList) {
            if (searchList.name.lowercase().contains(filterQuery)) {
                filteredList.add(searchList)
            }
        }
        return filteredList
    }

    override fun onItemClicked(position: Int, data: SubCategoryDataClass.Subcategory) {
        val subCatId = data.id
        val bundle = Bundle()
        bundle.putInt("sub_cat_id", subCatId)
        CommonUtil.saveIntPreferences(mContext, AppConstants.SUB_CAT_ID,subCatId)
        bundle.putInt("cat_id",catId)
        bundle.putString("cat_name",catName)
        bundle.putString("img_url",imgUrl)

        MainActivity.navController.navigate(R.id.action_mySubCategoryFragment_to_myCategoryDetailsFragment, bundle)
    }

    /*override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //this.catIdSaveState = catId
        outState.putInt("cat_id", catId)
    }*/
}