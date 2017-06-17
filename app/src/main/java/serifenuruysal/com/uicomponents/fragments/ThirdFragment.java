package serifenuruysal.com.uicomponents.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import serifenuruysal.com.uicomponents.R;
import serifenuruysal.com.uicomponents.adapters.ViewPagerAdapter;

/**
 * Created by serifenuruysal on 16/06/17.
 */

public class ThirdFragment extends Fragment {
    private ViewPager vpPager;
    private TabLayout tabs;

    public static final String EXTRA_MESSAGE="extra_message";
    public static final ThirdFragment newInstance(String param) {
        ThirdFragment f = new ThirdFragment();
        Bundle localBundle = new Bundle(1);
        localBundle.putString(EXTRA_MESSAGE, param);
        f.setArguments(localBundle);
        return f;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        vpPager=(ViewPager)view.findViewById(R.id.vpViewPager);
        tabs=(TabLayout)view.findViewById(R.id.tabs);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getFragmentManager());
        adapter.addFrag(FragmentSecondDetail.newInstance(),"tab1");
        adapter.addFrag(FragmentSecondDetail.newInstance(),"tab2");
        adapter.addFrag(FragmentSecondDetail.newInstance(),"tab3");
        adapter.addFrag(FragmentSecondDetail.newInstance(),"tab4");
        vpPager.setAdapter(adapter );
        tabs.setupWithViewPager(vpPager);


        return view;
    }
}
