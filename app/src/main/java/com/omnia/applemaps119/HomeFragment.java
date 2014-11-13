package com.omnia.applemaps119;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeFragment extends ActionBarFragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_home);
        mToolbar.setTitle(R.string.title_home);
        super.onCreateView(inflater, container, savedInstanceState);
        Date nDate = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("EEEE,\nMMMM dd");
        String date = ft.format(nDate);
        TextView dateText = (TextView) view.findViewById(R.id.text_home);
        dateText.setText(date);
        return view;
    }
}
