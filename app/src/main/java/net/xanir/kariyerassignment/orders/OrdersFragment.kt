package net.xanir.kariyerassignment.orders

import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import net.xanir.kariyerassignment.R
import net.xanir.kariyerassignment.databinding.OrdersFragmentBinding
import net.xanir.kariyerassignment.login.LoginFragment

class OrdersFragment : Fragment() {

    private lateinit var mViewModel: OrdersViewModel
    private lateinit var binding: OrdersFragmentBinding
    private lateinit var adapter: OrdersAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = OrdersFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(OrdersViewModel::class.java)
        adapter = OrdersAdapter()
        adapter.viewModel = mViewModel
        binding.orderView.adapter = adapter
        mViewModel.productList.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it!!)
        })
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
