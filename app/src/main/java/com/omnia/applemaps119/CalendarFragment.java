package com.omnia.applemaps119;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CalendarFragment extends Fragment
{
    public Toolbar mToolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_calendar);
        mToolbar.setTitle(R.string.title_calendar);
        mToolbar.setTitleTextAppearance(mToolbar.getContext(), R.style.AppTheme_Toolbar_Title);
        return view;
    }
}
