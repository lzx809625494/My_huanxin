package com.example.lizhixin.my_huanxin.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lizhixin.my_huanxin.MainActivity;
import com.example.lizhixin.my_huanxin.P.PiuginPresenterImpl;
import com.example.lizhixin.my_huanxin.R;
import com.example.lizhixin.my_huanxin.V.LoginActivity;
import com.example.lizhixin.my_huanxin.V.PiuginView;
import com.example.lizhixin.my_huanxin.common.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PluginFragment extends BaseFragment implements PiuginView {


    @BindView(R.id.beak_left)
    ImageView beakLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.add_right)
    ImageView addRight;
    @BindView(R.id.plugin_headImg)
    ImageView pluginHeadImg;
    @BindView(R.id.plugin_tui)
    TextView pluginTui;
    Unbinder unbinder;
    PiuginPresenterImpl piuginPresenter;
    public PluginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plugin, container, false);
        unbinder = ButterKnife.bind(this, view);
        piuginPresenter = new PiuginPresenterImpl(this);
        return view;
    }

    @Override
    protected void initTitle(TextView textView) {
        textView.setText("动态");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.plugin_tui)
    public void onViewClicked() {
          piuginPresenter.logout();
    }

    @Override
    public void afterLogout(boolean success, String msg) {
        MainActivity activity = (MainActivity) getActivity();
        activity.startActivity(LoginActivity.class,true);
        if (!success){
          activity.showToast(msg);
        }
    }
}
