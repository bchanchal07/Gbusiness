package com.milkyway.gbusiness.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.adaptor.DomainCartItemAdapter
import com.milkyway.gbusiness.models.SearchDomainDataDetailsClass
import com.milkyway.gbusiness.extension.alert
import com.milkyway.gbusiness.global.CommonUtil
import kotlinx.android.synthetic.main.fragment_business_cat_details.*

/**
 * A simple [Fragment] subclass.
 * Use the [CartItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartItemFragment : Fragment(), DomainCartItemAdapter.OnDomainListAdaptorClick {

    private lateinit var myCartItemBack: ImageView
    lateinit var mContext: Context
    private lateinit var rvCartItem: RecyclerView
    private lateinit var ivEmptyCart: ImageView
    private lateinit var layoutEmptyCart: LinearLayoutCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart_item, container, false)
        initializeViews(view)
        return view
    }

    private fun initializeViews(view: View) {
        myCartItemBack = view.findViewById(R.id.myCartItemBack)
        rvCartItem = view.findViewById(R.id.rvCartItem)
        ivEmptyCart = view.findViewById(R.id.ivEmptyCart)
        layoutEmptyCart = view.findViewById(R.id.layoutEmptyCart)
        myCartItemBack.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_cartItemFragment_to_searchDomainFragment)
        }

        Glide.with(this)
            .load("file:///android_asset/empty-cart.gif")
            .into(ivEmptyCart);
        if (!CommonUtil.getCartItems(mContext).isNullOrEmpty()) {
            setCartItemAdapter()
            layoutEmptyCart.visibility = View.INVISIBLE
        } else {
            layoutEmptyCart.visibility = View.VISIBLE
        }
    }

    private fun setCartItemAdapter() {
        rvCartItem.layoutManager = LinearLayoutManager(context)
        val adapter = CommonUtil.getCartItems(mContext)?.let { DomainCartItemAdapter(requireActivity(), it, this) }
        // Setting the Adapter with the recyclerview
        rvCartItem.adapter = adapter
    }

    override fun onBtnClickedRemoveFromCart(pos: Int, list: SearchDomainDataDetailsClass.DomainList) {

        callAlertDialog(list)

        //CommonUtil.toast("Cart item removed successfully.", mContext)
    }

    private fun callAlertDialog(list: SearchDomainDataDetailsClass.DomainList) {
        alert("Cart Item!", "Are you sure, want to delete cart item?") {
            positiveButton("YES") {
                CommonUtil.removeCartItem(mContext, list)
                setCartItemAdapter()
                if (!CommonUtil.getCartItems(mContext).isNullOrEmpty()) {
                    layoutEmptyCart.visibility = View.INVISIBLE
                } else {
                    layoutEmptyCart.visibility = View.VISIBLE
                }
                CommonUtil.toast("Cart item removed successfully.", mContext)
            }
            negativeButton("NO") {
            }
        }.show()
    }

    override fun onBtnClickedCheckoutCart(pos: Int, list: SearchDomainDataDetailsClass.DomainList) {
        //CommonUtil.toast("Working on this functionality. Coming soon", mContext)
        MainActivity.navController.navigate(R.id.action_cartItemFragment_to_orderSummaryFragment)
    }

}