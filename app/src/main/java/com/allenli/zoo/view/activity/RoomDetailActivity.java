package com.allenli.zoo.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.allenli.zoo.Constant;
import com.allenli.zoo.R;
import com.allenli.zoo.model.bean.MainBean;
import com.allenli.zoo.view.fragment.AnimalFragment;
import com.allenli.zoo.view.fragment.PlantFragment;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class RoomDetailActivity extends AppCompatActivity {
    private ViewPager vp_detial_list;
    private List<Fragment> fragmentList;
    private ContentPagerAdapter adapter;

    private MainBean.ResultBean.ResultsBean mData;

    private ImageView iv_pic;
    private TextView tv_name, tv_category, tv_memo, tv_info;
    private AppCompatButton btn_link, btn_share, btn_map;
    private TabLayout tabs;
    private String[] tabTitle = {"動物", "植物"};
    private int[] tabImg = {R.drawable.animal, R.drawable.plant};
    private Double latitude = 0.0;
    private Double longitude = 0.0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);

        initView();
    }

    private void initView() {
        mData = (MainBean.ResultBean.ResultsBean) getIntent().getSerializableExtra(Constant.ARG_ROOM);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        initData();

        fragmentList = new ArrayList<>();
        fragmentList.add(AnimalFragment.newInstance(mData.getE_Name()));
        fragmentList.add(PlantFragment.newInstance(mData.getE_Name()));

        adapter = new ContentPagerAdapter(getSupportFragmentManager());
        vp_detial_list = findViewById(R.id.vp_detial_list);
        vp_detial_list.setAdapter(adapter);

        initTab();
    }

    private void initData() {
        iv_pic = findViewById(R.id.iv_pic);
        Glide.with(this).load(mData.getE_Pic_URL()).into(iv_pic);

        tv_name = findViewById(R.id.tv_name);
        tv_name.setText(mData.getE_Name());

        tv_memo = findViewById(R.id.tv_memo);
        tv_memo.setText(mData.getE_Memo());

        tv_category = findViewById(R.id.tv_category);
        tv_category.setText(mData.getE_Category());

        tv_info = findViewById(R.id.tv_info);
        tv_info.setText(mData.getE_Info());

        btn_link = findViewById(R.id.btn_link);
        btn_link.setOnClickListener((View view) -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(mData.getE_URL()));
            startActivity(intent);
        });

        btn_share = findViewById(R.id.btn_share);
        btn_share.setOnClickListener((View view) -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, mData.getE_Name());
            intent.putExtra(android.content.Intent.EXTRA_TEXT, mData.getE_URL());
            startActivity(intent);
        });

        try {
            String location = mData.getE_Geo().substring(
                    mData.getE_Geo().indexOf("((") + 2, mData.getE_Geo().indexOf("))") - 2);
            String[] geoArray = location.split(" ");
            latitude = Double.parseDouble(geoArray[1]);
            longitude = Double.parseDouble(geoArray[0]);
        } catch (Exception e) {

        }

        btn_map = findViewById(R.id.btn_map);
        btn_map.setOnClickListener((View view) -> {
            Uri uri = Uri.parse("geo:0,0?q=" + latitude + "," + longitude);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });
    }

    private void initTab() {
        tabs = findViewById(R.id.tabs);
        tabs.setSmoothScrollingEnabled(true);
        LayoutInflater mLayoutInflater = this.getLayoutInflater();

        for (int i = 0; i < tabTitle.length; i++) {
            TabLayout.Tab tab = tabs.newTab();
            View view = mLayoutInflater.inflate(R.layout.tab_item, null);
            tab.setCustomView(view);

            ImageView iv_pic = view.findViewById(R.id.iv_pic);
            iv_pic.setImageResource(tabImg[i]);

            TextView tv_tab_title = view.findViewById(R.id.tv_tab_title);
            tv_tab_title.setText(tabTitle[i]);
            tabs.addTab(tab);
        }

        vp_detial_list.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(vp_detial_list));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                Animatoo.animateZoom(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateZoom(this);
    }

    private class ContentPagerAdapter extends FragmentPagerAdapter {

        private FragmentManager fragmentManager;

        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
            this.fragmentManager = fm;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            this.fragmentManager.beginTransaction().show(fragment).commit();
            return fragment;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Fragment fragment = fragmentList.get(position);
            fragmentManager.beginTransaction().hide(fragment).commit();
        }
    }
}
