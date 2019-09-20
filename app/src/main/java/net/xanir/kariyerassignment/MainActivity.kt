package net.xanir.kariyerassignment

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import android.os.Bundle

import net.xanir.kariyerassignment.login.LoginFragment
import net.xanir.kariyerassignment.orders.OrdersFragment
import net.xanir.kariyerassignment.utils.SharedPrefKeys
import net.xanir.kariyerassignment.utils.SharedPrefUtils

class MainActivity : AppCompatActivity() {

    private var fragment : Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val savedSession = SharedPrefUtils.instance(SharedPrefUtils.PreferenceMode.TEMPORARY).loadBoolean(SharedPrefKeys.REMEMBER_ME)
        if(savedSession){
            fragment = findFragmentByTag(OrdersFragment::class.java)
            if(fragment == null){
                replaceFragment(OrdersFragment.newInstance())
            }
            else{
                replaceFragment(fragment!!)
            }
        }
        else{
            fragment = findFragmentByTag(LoginFragment::class.java)
            if (fragment == null) {
                replaceFragment(LoginFragment.newInstance())
            } else {
                replaceFragment(fragment!!)
            }
        }
    }

    fun findFragmentByTag(className: Class<*>): Fragment? {
        return supportFragmentManager.findFragmentByTag(className.name)
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment, fragment.javaClass.name).addToBackStack(fragment.javaClass.name).commitAllowingStateLoss()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            moveTaskToBack(true)
        } else {
            super.onBackPressed()
        }
    }
}
