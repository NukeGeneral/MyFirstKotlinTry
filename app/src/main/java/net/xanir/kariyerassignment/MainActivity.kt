package net.xanir.kariyerassignment

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import android.os.Bundle

import net.xanir.kariyerassignment.login.LoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = findFragmentByTag(LoginFragment::class.java)
        if (fragment == null) {
            replaceFragment(LoginFragment.newInstance())
        } else {
            replaceFragment(fragment)
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
