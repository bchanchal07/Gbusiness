package com.milkyway.gbusiness.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.adaptor.SellerLinksAdaptor
import com.milkyway.gbusiness.models.SellerLinkData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SellerLinksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SellerLinksFragment : Fragment(), SellerLinksAdaptor.SellerLinksAdaptorClick {
    private var rvSellerLink: RecyclerView? = null
    private var sellerLinksAdaptor: SellerLinksAdaptor? = null
    private var sellerLinkList = ArrayList<SellerLinkData>()
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_seller_links, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View?) {
        rvSellerLink= view?.findViewById(R.id.rvSellerLink)
        rvSellerLink?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        sellerLinksAdaptor = SellerLinksAdaptor(requireActivity(),this,sellerLinkList)
        rvSellerLink?.adapter = sellerLinksAdaptor
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SellerLinksFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SellerLinksFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onSellerLinkItemClicked(position: Int, list: SellerLinkData) {

    }
}