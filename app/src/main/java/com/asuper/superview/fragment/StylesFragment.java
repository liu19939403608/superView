package com.asuper.superview.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asuper.superview.R;
import com.asuper.superview.view.HistogramView;
import com.asuper.superview.view.progressbarview.CircleProgressBarView;
import com.asuper.superview.view.progressbarview.HorizontalProgressBar;


/**
 * 实战演示
 * A simple {@link Fragment} subclass.
 */
public class StylesFragment extends BaseFragment {


    private HorizontalProgressBar horizontalProgressBar;
    private CircleProgressBarView circleProgressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        assert rootView != null;
        horizontalProgressBar = (HorizontalProgressBar) rootView.findViewById(R.id.hp_progress);
        circleProgressBar = (CircleProgressBarView) rootView.findViewById(R.id.circle_progress_view);
        horizontalProgressBar.setProgressWithAnimation(60 + "");
        horizontalProgressBar.startProgressAnimation();
        circleProgressBar.setProgressWithAnimation(80);
        circleProgressBar.startProgressAnimation();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        horizontalProgressBar.resumeProgressAnimation();
        circleProgressBar.resumeProgressAnimation();
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        horizontalProgressBar.pauseProgressAnimation();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_progress;
    }

    @Override
    protected void initParams() {

    }

    @Override
    public synchronized void onDestroy() {
        super.onDestroy();
        horizontalProgressBar.stopProgressAnimation();

    }

}
