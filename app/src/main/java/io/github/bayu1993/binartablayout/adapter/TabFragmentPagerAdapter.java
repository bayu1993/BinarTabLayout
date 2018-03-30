package io.github.bayu1993.binartablayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import io.github.bayu1993.binartablayout.fragment.TabArtikelFragment;
import io.github.bayu1993.binartablayout.fragment.TabHomeFragment;

/**
 * Created by dell on 3/30/18.
 */

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] title = new String[]{
            "Home", "Artikel"
    };

    public TabFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new TabHomeFragment();
        }else{
            return new TabArtikelFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public int getCount() {
        return 2;
    }

}
