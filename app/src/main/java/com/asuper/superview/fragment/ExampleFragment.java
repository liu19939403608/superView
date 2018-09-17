package com.asuper.superview.fragment;


import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asuper.superview.R;
import com.asuper.superview.view.HistogramView;


/**
 * 实战演示
 * A simple {@link Fragment} subclass.
 */
public class ExampleFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        assert rootView != null;
        TextView tvRote = (TextView) rootView.findViewById(R.id.tv_interest);
        AssetManager assets = getActivity().getAssets();
        //根据路径得到Typeface
        Typeface tf = Typeface.createFromAsset(assets, "DIN Medium.ttf");
        //设置字体
        tvRote.setTypeface(tf);

        SpannableStringBuilder sp = new SpannableStringBuilder(8.5 + "+" + 6.9 + "%");
        //  sp.setSpan(new ForegroundColorSpan(0xFFFF0000), name.length(), str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体颜色
        sp.setSpan(new AbsoluteSizeSpan(30, true), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //字体大小
        tvRote.setText(sp);
        return rootView;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_text;
    }

    @Override
    protected void initParams() {

    }

}
