package com.example.lizhixin.my_huanxin.common;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.example.lizhixin.my_huanxin.R;

public  abstract class BaseFragment extends Fragment {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView)getView().findViewById(R.id.tv_title);
        initTitle(textView);
    }

    protected abstract void initTitle(TextView textView);


}
