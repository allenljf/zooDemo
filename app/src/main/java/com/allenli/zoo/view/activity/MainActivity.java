package com.allenli.zoo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.allenli.zoo.Constant;
import com.allenli.zoo.R;
import com.allenli.zoo.base.BaseActivity;
import com.allenli.zoo.contract.MainContract;
import com.allenli.zoo.model.bean.MainBean;
import com.allenli.zoo.presenter.MainPresenter;
import com.allenli.zoo.util.CommonAdapter;
import com.allenli.zoo.util.ViewHolder;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.dyhdyh.widget.loadingbar2.LoadingBar;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;


public class MainActivity extends BaseActivity<MainContract.IView, MainPresenter> implements MainContract.IView {
    RecyclerView rv_main_list;
    LinearLayout parent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        parent = findViewById(R.id.parent);
        rv_main_list = findViewById(R.id.rv_main_list);
        rv_main_list.setLayoutManager(new GridLayoutManager(this, 3));
        getData();
    }

    @Override
    protected void getData() {
        LoadingBar.view(parent).show();
        mPresenter.getData();
    }

    private void finishData() {
        LoadingBar.view(parent).cancel();
    }

    @Override
    public void onDataSuccess(MainBean data) {
        CommonAdapter<MainBean.ResultBean.ResultsBean> adapter =
                new CommonAdapter<MainBean.ResultBean.ResultsBean>(this,
                        R.layout.list_item_main, data.getResult().getResults()) {
                    @Override
                    public void convert(ViewHolder holder, MainBean.ResultBean.ResultsBean data) {
                        ImageView iv_pic = holder.getView(R.id.iv_pic);
                        Glide.with(mContext)
                                .load(data.getE_Pic_URL())
                                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                                .into(iv_pic);

                        TextView tv_name = holder.getView(R.id.tv_name);
                        tv_name.setText(data.getE_Name());

                        TextView tv_category = holder.getView(R.id.tv_category);
                        tv_category.setText(data.getE_Category());

                        holder.itemView.setOnClickListener((View view) -> {
                                    Intent intent = new Intent(mContext, RoomDetailActivity.class);
                                    Bundle mBundle = new Bundle();
                                    mBundle.putSerializable(Constant.ARG_ROOM, data);
                                    intent.putExtras(mBundle);
                                    startActivity(intent);
                                    Animatoo.animateSpin(mContext);
                                }
                        );
                    }
                };

        AlphaInAnimationAdapter animationAdapter = new AlphaInAnimationAdapter(adapter);
        animationAdapter.setDuration(1000);
        rv_main_list.setAdapter(animationAdapter);

        finishData();
    }

    @Override
    public void onDataFail(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        finishData();
    }
}
