package net.xanir.kariyerassignment.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private String userName;
    private String password;
    private String correctPassword = "2019ADev";
    private String correctUserName = "kariyer";

    public boolean checkNameIsValid(){
        return userName != null && !userName.isEmpty() && userName.equals(correctUserName);
    }

    public boolean checkPasswordIsValid(){
        return password != null && !password.isEmpty() && password.equals(correctPassword);
    }

    public void onUserNameChanged(CharSequence sequence){
        password = sequence.toString();
    }

    public void onPasswordChanged(CharSequence sequence){
        userName = sequence.toString();
    }
}
