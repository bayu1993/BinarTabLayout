package io.github.bayu1993.binartablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import io.github.bayu1993.binartablayout.adapter.TabFragmentPagerAdapter;
import io.github.bayu1993.binartablayout.fragment.TabArtikelFragment;
import io.github.bayu1993.binartablayout.fragment.TabHomeFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar myToolbar;
    private ViewPager vpMyPager;
    private TabLayout tlTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        vpMyPager.setAdapter(new TabFragmentPagerAdapter(getSupportFragmentManager()));
        tlTabs.setTabTextColors(getResources().getColor(R.color.titleTabNonActive),
                getResources().getColor(R.color.titleTabActive));
        tlTabs.setupWithViewPager(vpMyPager);
        tlTabs.setTabGravity(TabLayout.GRAVITY_FILL);

    }


    private void initView() {
        // setup toolbar
        myToolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Tab Tutorial");
        //instansiasi
        vpMyPager = findViewById(R.id.vp_my_pager);
        tlTabs = findViewById(R.id.tl_tabs);
    }
}
