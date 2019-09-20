package net.xanir.kariyerassignment

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import android.os.Bundle

import net.xanir.kariyerassignment.login.LoginFragment
import net.xanir.kariyerassignment.orders.OrdersFragment
import net.xanir.kariyerassignment.utils.SharedPrefKeys
import net.xanir.kariyerassignment.utils.SharedPrefUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val savedSession = SharedPrefUtils.instance(SharedPrefUtils.PreferenceMode.TEMPORARY).loadBoolean(SharedPrefKeys.REMEMBER_ME)
        if(savedSession){
            replaceFragment(OrdersFragment.newInstance())
        }
        else{
            replaceFragment(LoginFragment.newInstance())
        }
    }

    //This can be used to find fragment which might added to backstack
    fun findFragmentByTag(className: Class<*>): Fragment? {
        return supportFragmentManager.findFragmentByTag(className.name)
    }

    //It is possible that we can add fragments backstack with tags too
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.main_container, fragment).commitAllowingStateLoss()
    }

    //It can be useful for saving last ui in background,keep application running
    //This requires fragments should added to backstack
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            moveTaskToBack(true)
        } else {
            super.onBackPressed()
        }
    }
}
