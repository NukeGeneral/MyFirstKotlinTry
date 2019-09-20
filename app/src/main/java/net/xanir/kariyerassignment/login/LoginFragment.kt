package net.xanir.kariyerassignment.login

import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.lifecycle.Observer

import net.xanir.kariyerassignment.MainActivity
import net.xanir.kariyerassignment.R
import net.xanir.kariyerassignment.databinding.LoginFragmentBinding
import net.xanir.kariyerassignment.orders.OrdersFragment

class LoginFragment : Fragment() {

    private lateinit var mViewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        mViewModel.passwordErrorMessage.observe(viewLifecycleOwner, Observer{ integer ->
            if (integer == null) {
                binding.password.clearFocus()
                binding.password.error = null
            } else {
                binding.password.requestFocus()
                binding.password.error = getString(integer)
            }
        })
        mViewModel.userNameErrorMessage.observe(viewLifecycleOwner, Observer{ integer ->
            if (integer == null) {
                binding.userName.clearFocus()
                binding.userName.error = null
            } else {
                binding.userName.requestFocus()
                binding.userName.error = getString(integer)
            }
        })
        binding.viewModel = mViewModel
        binding.rememberMeSwitch.setOnClickListener{switchChange(it)}
        binding.rememberMeText.setOnClickListener{switchChange(it)}
        binding.login.setOnClickListener{login()}
    }

    private fun login() {
        if (mViewModel.login()) {
            activity!!.supportFragmentManager.beginTransaction().replace(R.id.main_container,OrdersFragment.newInstance()).commitAllowingStateLoss()
        }
    }

    private fun switchChange(view: View){
        if(!(view is Switch)){
            binding.rememberMeSwitch.isChecked = !binding.rememberMeSwitch.isChecked
        }
        mViewModel.saveRememberMeStatus(binding.rememberMeSwitch.isChecked)
    }

    companion object {
        fun newInstance(): LoginFragment {

            val args = Bundle()
            val fragment = LoginFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
