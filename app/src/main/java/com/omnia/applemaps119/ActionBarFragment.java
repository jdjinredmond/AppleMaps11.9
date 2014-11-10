package com.omnia.applemaps119;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ActionBarFragment extends Fragment
{
    Toolbar mToolbar;

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mToolbar.setTitleTextAppearance(mToolbar.getContext(), R.style.AppTheme_Toolbar_Title);
        mToolbar.getChildAt(0).getBackground().setAlpha(0);
        mToolbar.setNavigationIcon(R.drawable.ic_menu);
        return null;
    }

    @Nullable
    public Toolbar getToolbar()
    {
        return mToolbar;
    }
}
