package com.armstring.linkchattingapplication.ui.view.register_view;

import com.armstring.linkchattingapplication.ui.view.mvp_contracts.RegisterContract;

/**
 * Created by Darkwood on 12/25/2017.
 */

public class Registerpresenter implements RegisterContract.RegisterPresenter{
    private RegisterContract.RegisterView registerView;

    public Registerpresenter(RegisterContract.RegisterView registerView) {
        this.registerView = registerView;
    }
}
