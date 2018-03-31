package io.github.bayu1993.binartablayout.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import io.github.bayu1993.binartablayout.R;
import io.github.bayu1993.binartablayout.adapter.TabFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private Toolbar myToolbar;
    private ViewPager vpMyPager;
    private TabLayout tlTabs;
    private android.support.v7.widget.SearchView svSearch;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        transparentToolbar();
        disableOnFocusSV();
        vpMyPager.setAdapter(new TabFragmentPagerAdapter(getSupportFragmentManager()));
        tlTabs.setTabTextColors(getResources().getColor(R.color.titleTabNonActive),
                getResources().getColor(R.color.titleTabActive));
        tlTabs.setupWithViewPager(vpMyPager);
        tlTabs.setTabGravity(TabLayout.GRAVITY_FILL);

    }

    private void disableOnFocusSV() {
        svSearch.setQuery("",false);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        rootView.requestFocus();
    }

    @Override
    protected void onResume() {
        disableOnFocusSV();
        super.onResume();
    }

    private void transparentToolbar() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notif,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_notif){
            Toast.makeText(MainActivity.this, "you not have anynotification", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        // setup toolbar
        myToolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Buku Saku");
        //instansiasi
        vpMyPager = findViewById(R.id.vp_my_pager);
        tlTabs = findViewById(R.id.tl_tabs);
        svSearch = findViewById(R.id.sv_search);
        rootView = findViewById(R.id.cl_root);
    }
}
