package serifenuruysal.com.uicomponents.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import serifenuruysal.com.uicomponents.R;

/**
 * Created by serifenuruysal on 17/06/17.
 */

public class FragmentSecondDetail extends Fragment {

    public static final FragmentSecondDetail newInstance() {
        FragmentSecondDetail f = new FragmentSecondDetail();
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_s_d,container,false);
    }
}
