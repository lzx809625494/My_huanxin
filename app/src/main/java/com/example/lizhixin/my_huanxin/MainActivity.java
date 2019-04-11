package com.example.lizhixin.my_huanxin;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.ShapeBadgeItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.example.lizhixin.my_huanxin.common.BaseActivity;
import com.example.lizhixin.my_huanxin.common.BaseFragment;
import com.example.lizhixin.my_huanxin.utils.FragmentFactory;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    @BindView(R.id.main_frame)
    FrameLayout mainFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBottom();
        initFragment();
    }

    private void initFragment() {
        BaseFragment fragment = FragmentFactory.getFragment(0);
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame,fragment,"0").commit();
    }

    private void initBottom() {
        ShapeBadgeItem badgeItem = new ShapeBadgeItem();
        badgeItem.setGravity(Gravity.RIGHT)
                .setShapeColor(R.color.them_click)
                .show();
             TextBadgeItem textBadgeItem =  new TextBadgeItem().setBackgroundColor(Color.RED)
                      .setText("5")
                     .setHideOnSelect(false)
                     .setAnimationDuration(100)
                      .show();
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.conversation_selected_2,"消息").setBadgeItem(badgeItem).setBadgeItem(textBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.contact_selected_2,"联系人"))
                .addItem(new BottomNavigationItem(R.mipmap.plugin_selected_2,"动态"))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);

    }

    @Override
    public void onTabSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(FragmentFactory.getFragment(0));
        transaction.hide(FragmentFactory.getFragment(1));
        transaction.hide(FragmentFactory.getFragment(2));
        BaseFragment fragment = FragmentFactory.getFragment(position);
        if (!fragment.isAdded()){
            transaction.add(R.id.main_frame,fragment,position+"");
        }
        transaction.show(fragment);
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
