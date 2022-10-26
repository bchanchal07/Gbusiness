package com.milkyway.gbusiness.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.milkyway.gbusiness.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_BUSINESS_NAME = "business_name"
private const val ARG_MOBILE = "business_mobile"
private const val ARG_ADDRESS = "business_address"

/**
 * A simple [Fragment] subclass.
 * Use the [AboutUsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutUsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var name: String? = null
    private var phone: String? = null
    private var address: String? = null
    private lateinit var tvTitleBusiness: TextView
    private lateinit var tvLocation: TextView
    private lateinit var tvMobile: TextView
    private lateinit var tvBusinessHrs: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about_us, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        tvTitleBusiness = view.findViewById(R.id.tvTitleBusinessAboutUs)
        tvLocation = view.findViewById(R.id.tvLocationAboutUs)
        tvMobile = view.findViewById(R.id.tvMobileAboutUs)
        tvBusinessHrs = view.findViewById(R.id.tvBusinessHrsAboutUs)
        arguments?.let {
            name = it.getString(ARG_BUSINESS_NAME)
            phone = it.getString(ARG_MOBILE)
            address = it.getString(ARG_ADDRESS)
            tvTitleBusiness.text = name
            tvMobile.text = phone
            tvLocation.text = address
        }

   }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AboutUsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(args: Bundle) =
            AboutUsFragment().apply {
                val businessName = args.getString("businessName")
                val businessEmail = args.getString("businessEmail").toString()
                val businessPhone = args.getString("businessPhone").toString()
                //businessWebUrl = args.getString("businessWebUrl").toString()
                //subDomainUrl = args.getString("subDomainUrl").toString()
                val sellerUrl = args.getString("sellerUrl").toString()
                val facebookUrl = args.getString("facebookUrl").toString()
                val linkedinUrl = args.getString("linkedinUrl").toString()
                val twitterUrl = args.getString("twitterUrl").toString()
                val instagramUrl = args.getString("instagramUrl").toString()
                val businessAboutUs = args.getString("businessAboutUs")
                val city = args.getString("city")
                val address = args.getString("address")

                arguments = Bundle().apply {
                    putString(ARG_BUSINESS_NAME, businessName)
                    putString(ARG_MOBILE, businessPhone)
                    putString(ARG_ADDRESS, address)
                }

            }
    }
}