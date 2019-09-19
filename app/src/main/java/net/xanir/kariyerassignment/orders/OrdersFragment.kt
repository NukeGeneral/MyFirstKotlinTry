package net.xanir.kariyerassignment.orders

import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import net.xanir.kariyerassignment.R
import net.xanir.kariyerassignment.login.LoginFragment

class OrdersFragment : Fragment() {

    private lateinit var mViewModel: OrdersViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mViewModel = ViewModelProviders.of(this).get(OrdersViewModel::class.java)
        return inflater.inflate(R.layout.orders_fragment, container, false)
    }

    companion object {
        fun newInstance(): OrdersFragment {
            val args = Bundle()
            val fragment = OrdersFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
