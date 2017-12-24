package com.armstring.linkchattingapplication.ui.view.login_view;

import com.armstring.linkchattingapplication.ui.view.mvp_contracts.LoginContract;

/**
 * Created by Darkwood on 12/25/2017.
 */

public class LoginPresenter implements LoginContract.LoginView{
    private LoginContract.LoginView loginView;

    public LoginPresenter(LoginContract.LoginView loginView) {
        this.loginView = loginView;
    }
}
