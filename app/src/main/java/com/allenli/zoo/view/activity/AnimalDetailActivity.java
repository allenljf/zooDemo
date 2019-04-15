package com.allenli.zoo.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.allenli.zoo.Constant;
import com.allenli.zoo.R;
import com.allenli.zoo.model.bean.AnimalBean;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class AnimalDetailActivity extends AppCompatActivity {
    AnimalBean.ResultBean.ResultsBean mData;
    List<String> picList = new ArrayList();
    List<Integer> picNumList = new ArrayList();
    MZBannerView banner;
    TextView tv_name, tv_name_ch, tv_name_en, tv_name_latin, tv_behavior, tv_diet, tv_feature, tv_update;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        initView();
        initBanner();
    }


    private void initView() {
        mData = (AnimalBean.ResultBean.ResultsBean) getIntent().getSerializableExtra(Constant.ARG_ANIMAL);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        tv_name = findViewById(R.id.tv_name);
        tv_name.setText(mData.getA_Name_Ch());

        tv_name_ch = findViewById(R.id.tv_name_ch);
        tv_name_ch.setText("中文名稱：" + mData.getA_Name_Ch());

        tv_name_en = findViewById(R.id.tv_name_en);
        tv_name_en.setText("英文名稱：" + mData.getA_Name_En());

        tv_name_latin = findViewById(R.id.tv_name_latin);
        tv_name_latin.setText("拉丁文名稱：" + mData.getA_Name_Latin());

        tv_behavior = findViewById(R.id.tv_behavior);
        tv_behavior.setText("行為：\n" + mData.getA_Behavior());

        tv_diet = findViewById(R.id.tv_diet);
        tv_diet.setText("覓食：\n" + mData.getA_Diet());

        tv_feature = findViewById(R.id.tv_feature);
        tv_feature.setText("特色：\n" + mData.getA_Feature());

        tv_update = findViewById(R.id.tv_update);
        tv_update.setText("更新時間：" + mData.getA_Update());
    }

    private void initBanner() {
        if(!mData.getA_Pic01_URL().equals("")) {
            picList.add(mData.getA_Pic01_URL());
            picNumList.add(0);
        }
        if(!mData.getA_Pic02_URL().equals("")) {
            picList.add(mData.getA_Pic02_URL());
            picNumList.add(1);
        }
        if(!mData.getA_Pic03_URL().equals("")) {
            picList.add(mData.getA_Pic03_URL());
            picNumList.add(2);
        }
        if(!mData.getA_Pic04_URL().equals("")) {
            picList.add(mData.getA_Pic04_URL());
            picNumList.add(3);
        }

        banner = findViewById(R.id.banner);
        banner.setPages(picNumList, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });

        if(picList.size() < 2)
            banner.setCanLoop(false);
    }

    public class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView iv_pic;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            iv_pic = view.findViewById(R.id.iv_pic);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            Glide.with(context)
                .applyDefaultRequestOptions(new RequestOptions()
                .placeholder(R.drawable.plant)
                .error(R.drawable.plant))
                .load(picList.get(data))
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(iv_pic);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        banner.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(picList.size() > 1)
            banner.start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                Animatoo.animateCard(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Animatoo.animateCard(this);
    }
}
