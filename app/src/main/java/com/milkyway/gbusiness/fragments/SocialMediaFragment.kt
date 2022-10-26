package com.milkyway.gbusiness.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.adaptor.SocialMediaAdaptor
import com.milkyway.gbusiness.models.SocialMediaData

private const val ARG_FACEBOOK = "facebook"
private const val ARG_LINKEDIN = "linkedin"
private const val ARG_TWITTER = "twitter"
private const val ARG_INSTAGRAM = "instagram"

class SocialMediaFragment : Fragment(), SocialMediaAdaptor.SocialMediaAdaptorClick {
    // TODO: Rename and change types of parameters
    private var facebook: String? = null
    private var linkedin: String? = null
    private var twitter: String? = null
    private var instagram: String? = null
    private var rvSocialMedia: RecyclerView? = null
    private var socialMediaAdaptor: SocialMediaAdaptor? = null
    private var socialMediaList = ArrayList<SocialMediaData>()
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_social_media, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View?) {
        rvSocialMedia = view?.findViewById(R.id.rvSocialMedia)
        btnSubmit = view?.findViewById(R.id.btnSubmit)!!
        btnSubmit.setOnClickListener {
            Toast.makeText(requireActivity(), "Clicked on Button", Toast.LENGTH_LONG).show()
        }
        arguments?.let {
            facebook = it.getString(ARG_FACEBOOK)
            linkedin = it.getString(ARG_LINKEDIN)
            twitter = it.getString(ARG_TWITTER)
            instagram = it.getString(ARG_INSTAGRAM)
            //Toast.makeText(requireActivity(), "Facebook:$facebook\nLinkedin:$linkedin\nTwitter:$twitter\nInstagram:$instagram", Toast.LENGTH_LONG).show()
        }
        rvSocialMedia?.layoutManager = GridLayoutManager(context, 2)
        if (!facebook.contentEquals("null"))
            socialMediaList.add(SocialMediaData("Facebook", facebook!!, R.drawable.ic_facebook))
        if (!linkedin.contentEquals("null"))
            socialMediaList.add(SocialMediaData("Linkedin", linkedin!!, R.drawable.ic_linkedin))
        if (!twitter.contentEquals("null"))
            socialMediaList.add(SocialMediaData("Twitter", twitter!!, R.drawable.ic_twitter))
        if (!instagram.contentEquals("null"))
            socialMediaList.add(SocialMediaData("Instagram", instagram!!, R.drawable.ic_instagram))
        socialMediaAdaptor = SocialMediaAdaptor(requireActivity(), this, socialMediaList)
        rvSocialMedia?.adapter = socialMediaAdaptor
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SocialMediaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(args: Bundle) =
            SocialMediaFragment().apply {

                val facebookUrl = args.getString("facebookUrl").toString()
                val linkedinUrl = args.getString("linkedinUrl").toString()
                val twitterUrl = args.getString("twitterUrl").toString()
                val instagramUrl = args.getString("instagramUrl").toString()
                arguments = Bundle().apply {
                    putString(ARG_FACEBOOK, facebookUrl)
                    putString(ARG_LINKEDIN, linkedinUrl)
                    putString(ARG_TWITTER, twitterUrl)
                    putString(ARG_INSTAGRAM, instagramUrl)
                }
            }
    }

    override fun onSocialItemClicked(position: Int, list: SocialMediaData) {
        Toast.makeText(requireActivity(), "Clicked on item $position in Social Fragment", Toast.LENGTH_LONG).show()
        /*arguments = Bundle().apply {
            putString("back", "SocialMediaFragment")
            putString("webUrl", list.media_link)
            //navController.navigate(R.id.action_socialMediaFragment_to_paymentOrInvoiceWebView, this)
            navController.navigate(R.id.action_socialMediaFragment_to_paymentOrInvoiceWebView, this)
        }*/
        val args: Bundle? = null
        args?.putString("back", "SocialMediaFragment")
        args?.putString("webUrl", list.media_link)
        //navController.navigate(R.id.action_socialMediaFragment_to_paymentOrInvoiceWebView, args)
        MainActivity.navController.navigate(R.id.action_subDomainWebsiteFragment_to_paymentOrInvoiceWebView, args)
    }
}