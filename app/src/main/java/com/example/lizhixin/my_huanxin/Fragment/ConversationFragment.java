package com.example.lizhixin.my_huanxin.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lizhixin.my_huanxin.R;
import com.example.lizhixin.my_huanxin.common.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConversationFragment extends BaseFragment {


    public ConversationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_conversation, container, false);
    }

    @Override
    protected void initTitle(TextView textView) {
                 textView.setText("消息");
    }
}
