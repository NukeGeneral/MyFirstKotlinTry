package net.xanir.kariyerassignment

import android.content.SharedPreferences
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.*
import net.xanir.kariyerassignment.login.LoginViewModel
import net.xanir.kariyerassignment.utils.SharedPrefKeys
import net.xanir.kariyerassignment.utils.SharedPrefUtils
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule


/**
 * Created by Umur Kaya on 20-Sep-19.
 */
class LoginViewModelTest {

    private lateinit var viewModel: LoginViewModel
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup(){
        viewModel = LoginViewModel()
        viewModel.userNameErrorMessage.observeForever{}
        viewModel.passwordErrorMessage.observeForever{}
    }

    @Test
    fun checkUserName(){
        viewModel.userName = "kariyer"
        assertEquals(true,viewModel.checkNameIsValid())
        viewModel.userName = "margin"
        assertEquals(true,viewModel.checkNameIsValid())
        viewModel.userName = ""
        assertEquals(false,viewModel.checkNameIsValid())
        assertEquals(R.string.empty_user_name,viewModel.userNameErrorMessage.value)

    }

    @Test
    fun checkPassword(){
        viewModel.password = "2019ADev"
        assertEquals(true,viewModel.checkPasswordIsValid())
        viewModel.password = "perfect"
        assertEquals(true,viewModel.checkPasswordIsValid())
        viewModel.password = ""
        assertEquals(false,viewModel.checkPasswordIsValid())
        assertEquals(R.string.empty_password,viewModel.passwordErrorMessage.value)
    }

    @Test
    fun checkSuccessLogin(){
        viewModel.userName = "kariyer"
        viewModel.password = "2019ADev"
        assertEquals(true,viewModel.login())
    }

    @Test
    fun checkFailLogin(){
        viewModel.userName = "test"
        viewModel.password = ">£#£>*0dfıkw912"
        assertEquals(false,viewModel.login())
        assertEquals(R.string.wrong_information,viewModel.passwordErrorMessage.value)
    }

    @Test
    fun checkEmptyLogin(){
        viewModel.userName = ""
        viewModel.password = ""
        assertEquals(false,viewModel.login())
        assertEquals(R.string.empty_user_name,viewModel.userNameErrorMessage.value)
        assertEquals(R.string.empty_password,viewModel.passwordErrorMessage.value)
    }
}