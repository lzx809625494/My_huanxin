package com.example.lizhixin.my_huanxin.utils;

import android.support.v4.app.Fragment;

import com.example.lizhixin.my_huanxin.Fragment.ContactFragment;
import com.example.lizhixin.my_huanxin.Fragment.ConversationFragment;
import com.example.lizhixin.my_huanxin.Fragment.PluginFragment;
import com.example.lizhixin.my_huanxin.common.BaseFragment;

public class FragmentFactory {
    private static ConversationFragment conversationFragment;
    private static ContactFragment contactFragment;
    private static PluginFragment pluginFragment;
    public static ConversationFragment getConversationFragment(){
        if (conversationFragment == null){
            conversationFragment = new ConversationFragment();
        }
        return conversationFragment;
    }
    public static ContactFragment getContactFragment(){
        if (contactFragment == null){
            contactFragment = new ContactFragment();
        }
        return contactFragment;
    }
    public static PluginFragment getPluginFragment(){
        if (pluginFragment == null){
            pluginFragment = new PluginFragment();
        }
        return pluginFragment;
    }
    public static BaseFragment getFragment(int index){
           switch (index){
               case 0:
                   return  getConversationFragment();
               case 1:
                   return getContactFragment();
               case 2:
                   return getPluginFragment();
           }
           return null;
    }
}
