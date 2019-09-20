package net.xanir.kariyerassignment.orders

import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import net.xanir.kariyerassignment.MainActivity

import net.xanir.kariyerassignment.R
import net.xanir.kariyerassignment.databinding.OrdersFragmentBinding
import net.xanir.kariyerassignment.login.LoginFragment
import net.xanir.kariyerassignment.utils.SharedPrefUtils

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
        binding.logout.setOnClickListener{
            val builder = AlertDialog.Builder(it.context)
            builder.setPositiveButton(R.string.dismiss) { dialog, _ ->
                dialog.dismiss()
            }
            builder.setNegativeButton(R.string.logout) { dialog, _ ->
                dialog.dismiss()
                activity!!.supportFragmentManager.beginTransaction().replace(R.id.main_container,LoginFragment.newInstance()).commitAllowingStateLoss()
                SharedPrefUtils.instance(SharedPrefUtils.PreferenceMode.TEMPORARY).clearData()
            }
            builder.setMessage(R.string.are_you_sure_logout)
            builder.setTitle(R.string.warning)
            builder.show()
        }
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
