package com.armstring.linkchattingapplication.ui.view.start_view;

import com.armstring.linkchattingapplication.ui.view.mvp_contracts.StartContract;

/**
 * Created by Darkwood on 12/25/2017.
 */

public class StartPresenter implements StartContract.StartPresenter{
    private StartContract.StartView startView;

    public StartPresenter(StartContract.StartView startView) {
        this.startView = startView;
    }
}
