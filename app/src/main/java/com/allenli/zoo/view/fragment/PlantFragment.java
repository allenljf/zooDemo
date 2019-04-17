package com.allenli.zoo.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.allenli.zoo.Constant;
import com.allenli.zoo.R;
import com.allenli.zoo.base.BaseFragment;
import com.allenli.zoo.contract.PlantContract;
import com.allenli.zoo.model.bean.PlantBean;
import com.allenli.zoo.presenter.PlantPresenter;
import com.allenli.zoo.util.CommonAdapter;
import com.allenli.zoo.util.ViewHolder;
import com.allenli.zoo.view.activity.PlantDetailActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.dyhdyh.widget.loadingbar2.LoadingBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;


public class PlantFragment extends BaseFragment<PlantContract.IView, PlantPresenter> implements PlantContract.IView {
    private RelativeLayout parent;
    private RecyclerView rv_list;
    private String queryName;

    public static PlantFragment newInstance(String query){
        PlantFragment f = new PlantFragment();
        Bundle args = new Bundle();
        args.putString(Constant.ARG_ROOM_NAME, query);
        f.setArguments(args);
        return f;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_plant;
    }

    @Override
    protected PlantPresenter initPresenter() {
        return new PlantPresenter();
    }

    @Override
    protected void initView() {
        parent = view.findViewById(R.id.parent);
        rv_list = view.findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(mContext));

        queryName = getArguments().getString(Constant.ARG_ROOM_NAME, "");
    }

    @Override
    protected void getData(){
        LoadingBar.view(parent).show();
        mPresenter.getData(queryName);
    }

    private void finishData(){
        LoadingBar.view(parent).cancel();
    }

    @Override
    public void onDataSuccess(PlantBean data) {
        finishData();

        if(data.getResult().getCount() == 0){
            view.findViewById(R.id.tv_no_data).setVisibility(View.VISIBLE);
            return;
        }

        CommonAdapter<PlantBean.ResultBean.ResultsBean> adapter =
        new CommonAdapter<PlantBean.ResultBean.ResultsBean>(mContext,
                R.layout.list_item_animal, data.getResult().getResults()) {
            @Override
            public void convert(ViewHolder holder, PlantBean.ResultBean.ResultsBean data) {
                ImageView iv_pic = holder.getView(R.id.iv_pic);
                Glide.with(mContext)
                        .applyDefaultRequestOptions(new RequestOptions()
                                .placeholder(R.drawable.plant)
                                .error(R.drawable.plant))
                        .load(data.getF_Pic01_URL())
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                        .into(iv_pic);

                TextView tv_name = holder.getView(R.id.tv_name);
                tv_name.setText(data.getF_Name_Ch());

                TextView tv_name_en = holder.getView(R.id.tv_name_en);
                tv_name_en.setText(data.getF_Name_En());

                TextView tv_behavior = holder.getView(R.id.tv_behavior);
                tv_behavior.setText(data.getF_Feature());

                holder.itemView.setOnClickListener((View view) ->{
                            Intent intent = new Intent(mContext, PlantDetailActivity.class);
                            Bundle mBundle = new Bundle();
                            mBundle.putSerializable(Constant.ARG_PLANT, data);
                            intent.putExtras(mBundle);
                            startActivity(intent);
                        }
                );
            }
        };

        ScaleInAnimationAdapter animationAdapter = new ScaleInAnimationAdapter(adapter);
        rv_list.setAdapter(animationAdapter);
    }

    @Override
    public void onDataFail(String errorMessage) {
        Toast.makeText(mContext, errorMessage, Toast.LENGTH_LONG).show();
        finishData();
    }
}
