package com.omnia.applemaps119;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class ClassesFragment extends ActionBarFragment
{
    ListView mListView;
    ViewSwitcher mViewSwitcher;
    String[] classes;
    int mTitle = R.string.title_classes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_classes, container, false);
        mViewSwitcher = (ViewSwitcher) view.findViewById(R.id.fragment_classes_switcher);
        /*mViewSwitcher.setInAnimation(getActivity().getApplicationContext(), android.support.v7.appcompat.R.anim.abc_slide_in_top);
        mViewSwitcher.setOutAnimation(getActivity().getApplicationContext(), android.support.v7.appcompat.R.anim.abc_slide_out_top);*/
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar_classes);
        mToolbar.setTitle(mTitle);
        classes = new String[]{"AP US History", "AP Calculus BC", "AP Chemistry", "Anatomy and Physiology", "Advanced Biomedical Lab", "World Literature"};
        mListView = (ListView) view.findViewById(R.id.classes_list);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                FragmentManager fragmentManager = getFragmentManager();
                ClassFragment classFragment = new ClassFragment();
                Bundle args = new Bundle();
                args.putString("class", classes[position]);
                classFragment.setArguments(args);
                fragmentManager.beginTransaction().replace(R.id.container_classes, classFragment).commit();
                mViewSwitcher.showNext();
                mToolbar.setTitle(/*mViewSwitcher.getChildCount() + ""*/classes[position]);
                mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
                mToolbar.setNavigationOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        mViewSwitcher.showPrevious();
                        mToolbar.setTitle(mTitle);
                        mToolbar.setNavigationIcon(R.drawable.ic_menu);
                        mNavigationDrawerFragment.setDrawerToggle(mToolbar);
                    }
                });
            }
        });
        mListView.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(),
                R.layout.fragment_classes_list_item, R.id.fragment_classes_list_item_text,
                classes));
        //mViewSwitcher.showPrevious();
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    public static class ClassFragment extends Fragment
    {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            View view = inflater.inflate(R.layout.fragment_classes_class, container, false);
            TextView textView = (TextView) view.findViewById(R.id.class_title);
            textView.setText(getArguments().getString("class"));
            return view;
        }
    }
}
