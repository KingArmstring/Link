package com.armstring.linkchattingapplication.ui.view.main_view;

import com.armstring.linkchattingapplication.ui.view.mvp_contracts.MainActivityContract;

/**
 * Created by Darkwood on 12/25/2017.
 */

public class MainPresenter implements MainActivityContract.MainPresenter{
    private MainActivityContract.MainView mainView;

    public MainPresenter(MainActivityContract.MainView mainView) {
        this.mainView = mainView;
    }
}
