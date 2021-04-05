package com.example.letschat.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.letschat.Fragments_Tabs.CallsFragments;
import com.example.letschat.Fragments_Tabs.ChatsFragments;
import com.example.letschat.Fragments_Tabs.StatusFragments;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ChatsFragments();
            case 1:
                return new StatusFragments();
            case 2:
                return new CallsFragments();
            default:
                return new ChatsFragments();


        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String title = null;
        if(position == 0)
            title = "CHATS";
        if(position == 1)
            title = "STATUS";
        if(position == 2)
            title = "CALLS";

        return title;
    }
}
