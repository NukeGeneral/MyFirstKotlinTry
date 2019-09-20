package net.xanir.kariyerassignment.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import net.xanir.kariyerassignment.R
import net.xanir.kariyerassignment.utils.SharedPrefKeys
import net.xanir.kariyerassignment.utils.SharedPrefUtils

class LoginViewModel : ViewModel() {
    var userName = ""
    var password = ""
    private val correctPassword = "2019ADev"
    val userNameErrorMessage = MutableLiveData<Int>()
    val passwordErrorMessage = MutableLiveData<Int>()
    private val correctUserName = "kariyer"

    //Check informations are correct(Like mocking API)
    private fun checkValidInformation(userName: String, password: String): Boolean {
        if (userName != correctUserName) {
            passwordErrorMessage.value = R.string.wrong_information
            return false
        } else if (password != correctPassword) {
            passwordErrorMessage.value = R.string.wrong_information
            return false
        }
        return true
    }

    //Try to login via button
    fun login(): Boolean {
        val nameValid = checkNameIsValid()
        val passValid = checkPasswordIsValid()
        return nameValid && passValid && checkValidInformation(userName, password)
    }

    //Just check if it's empty or not
    fun checkNameIsValid(): Boolean {
        if (userName.isEmpty()) {
            userNameErrorMessage.value = R.string.empty_user_name
            return false
        }
        return true
    }

    //Just check if it's empty or not
    fun checkPasswordIsValid(): Boolean {
        if (password.isEmpty()) {
            passwordErrorMessage.value = R.string.empty_password
            return false
        }
        return true
    }

    fun onUserNameChanged(sequence: CharSequence) {
        userName = sequence.toString()
    }

    fun onPasswordChanged(sequence: CharSequence) {
        password = sequence.toString()
    }

    //Change session storing state for future
    fun saveRememberMeStatus(boolean: Boolean){
        SharedPrefUtils.instance(SharedPrefUtils.PreferenceMode.TEMPORARY).saveBoolean(SharedPrefKeys.REMEMBER_ME,boolean)
    }
}
