package com.milkyway.gbusiness.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.adaptor.BusinessCategoryAdaptor
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.CategoryDataClass
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.AppConstants.SPEECH_REQUEST_CODE
import com.milkyway.gbusiness.utils.CommonUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class BusinessCategoryFragment : Fragment(), BusinessCategoryAdaptor.OnBusinessCatAdaptorClick {

    private lateinit var rvCategory: RecyclerView
    private lateinit var myBusinessCatBack: ImageView
    lateinit var mContext: Context
    lateinit var catDataResponse: CategoryDataClass
    private lateinit var categoryDataList: List<CategoryDataClass.Data>

    private lateinit var etSearch: AppCompatEditText
    private lateinit var noSearchResultsFoundText: TextView
    private lateinit var searchEditText: TextView
    private lateinit var clearQueryImageView: ImageView
    private lateinit var voiceSearchImageView: ImageView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_business_category, container, false)
        initializeViews(view)
        clickListener(view)
        return view
    }

    private fun clickListener(view: View) {
        myBusinessCatBack.setOnClickListener { MainActivity.navController.navigate(R.id.action_myCategoryFragment_to_mainFragment) }

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
            setCategoryAdaptor(categoryDataList)
        }
    }

    private fun initializeViews(view: View) {
        rvCategory = view.findViewById(R.id.businessCategoryRecyclerView)
        myBusinessCatBack = view.findViewById(R.id.myBusinessCatBack)

        etSearch = view.findViewById(R.id.search_edit_text)
        noSearchResultsFoundText = view.findViewById(R.id.no_search_results_found_text)
        clearQueryImageView = view.findViewById(R.id.clear_search_query)
        voiceSearchImageView = view.findViewById(R.id.voice_search_query)
        searchEditText = view.findViewById(R.id.search_edit_text)
        searchEditText.hint = "Search Category"

        callCategoryApi()

    }

    private fun filterWithQuery(query: String) {
        if (query.isNotEmpty()) {
            val filteredList: List<CategoryDataClass.Data> = onFilterChanged(query)
            //attachAdapter(filteredList)
            setCategoryAdaptor(filteredList)
            toggleRecyclerView(filteredList)
        } else if (query.isEmpty()) {
            //attachAdapter(sportsList)
            setCategoryAdaptor(categoryDataList)
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

    private fun toggleRecyclerView(catList: List<CategoryDataClass.Data>) {
        if (catList.isEmpty()) {
            rvCategory.visibility = View.INVISIBLE
            noSearchResultsFoundText.visibility = View.VISIBLE
        } else {
            rvCategory.visibility = View.VISIBLE
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

    private fun onFilterChanged(filterQuery: String): List<CategoryDataClass.Data> {
        val filteredList = ArrayList<CategoryDataClass.Data>()
        for (searchList in categoryDataList) {
            if (searchList.name.lowercase().contains(filterQuery)) {
                filteredList.add(searchList)
            }
        }
        return filteredList
    }

    private fun callCategoryApi() {

        if (CommonUtil.checkNetwork(mContext)) {
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)

            dataNotic.getCategoryList().enqueue(object : Callback<CategoryDataClass> {
                override fun onResponse(call: Call<CategoryDataClass>, response: Response<CategoryDataClass>) {
                    CommonUtil.hideDialog(mContext)
                    // Log.i("TAGad", response.body()?.success.toString())
                    catDataResponse = response.body()!!

                    if (catDataResponse.code == 200) {
                        if (catDataResponse.data != null && catDataResponse.data.isNotEmpty()) {
                            categoryDataList = catDataResponse.data
                            setCategoryAdaptor(categoryDataList)

                        }
                    }
                }

                override fun onFailure(call: Call<CategoryDataClass>, t: Throwable) {
                    CommonUtil.hideDialog(mContext)
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                    CommonUtil.logi(t.localizedMessage.toString())
                }
            })

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }


    }

    private fun setCategoryAdaptor(categoryDataList: List<CategoryDataClass.Data>) {

        rvCategory.layoutManager = GridLayoutManager(context, 1)

        // This will pass the ArrayList to our Adapter
        val adapter = BusinessCategoryAdaptor(requireActivity(), this, categoryDataList)

        // Setting the Adapter with the recyclerview
        rvCategory.adapter = adapter
    }

    override fun onItemClicked(position: Int, data: CategoryDataClass.Data) {
        val id = data.id
        val catName = data.name
        val imgName = data.image
        val imgUrl = "${GbusinessService.BASE_SUB_CAT_IMG_URL}$imgName"
        CommonUtil.saveIntPreferences(mContext, AppConstants.CAT_ID, id)
        val bundle = Bundle()
        bundle.putInt("position", position)
        bundle.putInt("cat_id", id)
        bundle.putString("cat_name", catName)
        bundle.putString("img_url", imgUrl)

        findNavController().navigate(R.id.action_myCategoryFragment_to_myCategoryDetailsFragment, bundle)
    }
}