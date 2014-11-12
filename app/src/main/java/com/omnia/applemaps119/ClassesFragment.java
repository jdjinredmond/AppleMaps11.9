package com.omnia.applemaps119;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ClassesFragment extends ActionBarFragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_classes, container, false);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container_classes,
                new ClassesListFragment()).commit();
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_classes);
        mToolbar.setTitle(R.string.title_classes);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    public static class ClassesListFragment extends Fragment
    {
        ListView mListView;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState)
        {
            mListView = (ListView) inflater.inflate(R.layout.fragment_classes_list, container,
                    false);
            mListView.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(),
                    R.layout.fragment_classes_list_item, R.id.fragment_classes_list_item_text,
                    new String[]{"APUSH", "AP Calculus BC", "AP Chemistry", "Anatomy and Physiology", "Advanced Biomedical Lab", "World Literature"}));
            return mListView;
        }
    }

    public static class ClassFragment extends Fragment
    {
        public void setUp(Toolbar toolbar, String title)
        {
            toolbar.setTitle(title);
            //toolbar.setNavigationIcon();
        }
    }
}
