package com.omnia.applemaps119;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends ActionBarFragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_home);
        mToolbar.setTitle(R.string.title_home);
        super.onCreateView(inflater, container, savedInstanceState);
        String date = "Wednesday, November 12";
        TextView dateText = (TextView) view.findViewById(R.id.text_home);
        dateText.setText(date);
        return view;
    }
}
