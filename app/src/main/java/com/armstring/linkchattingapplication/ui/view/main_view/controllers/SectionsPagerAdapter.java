package com.armstring.linkchattingapplication.ui.view.main_view.controllers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.armstring.linkchattingapplication.ui.view.main_view.fragments.FriendsFragment;
import com.armstring.linkchattingapplication.ui.view.main_view.fragments.RequestFragment;
import com.armstring.linkchattingapplication.ui.view.main_view.fragments.ChatsFragment;

/**
 * Created by Darkwood on 12/24/2017.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter{

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new RequestFragment();
            case 1: return new ChatsFragment();
            case 2: return new FriendsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "REQUESTS";
            case 1: return "CHATS";
            case 2: return "FRIENDS";
        }
        return super.getPageTitle(position);
    }
}
