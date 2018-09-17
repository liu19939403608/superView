package com.asuper.superview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asuper.superview.R;
import com.asuper.superview.util.stringCut;
import com.asuper.superview.view.HistogramView;
import com.asuper.superview.view.waveview.WaveView;



/**
 * 实战演示
 * A simple {@link Fragment} subclass.
 */
public class PractiveFragment extends BaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_practive;
    }

    @Override
    protected void initParams() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        assert rootView != null;
        HistogramView histogramView = (HistogramView) rootView.findViewById(R.id.histogramView);
        histogramView.setPercent(80);
        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
