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
import com.allenli.zoo.contract.AnimalContract;
import com.allenli.zoo.model.bean.AnimalBean;
import com.allenli.zoo.presenter.AnimalPresenter;
import com.allenli.zoo.util.CommonAdapter;
import com.allenli.zoo.util.ViewHolder;
import com.allenli.zoo.view.activity.AnimalDetailActivity;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.dyhdyh.widget.loadingbar2.LoadingBar;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;


public class AnimalFragment extends BaseFragment<AnimalContract.IView, AnimalPresenter> implements AnimalContract.IView {
    private RelativeLayout parent;
    private RecyclerView rv_list;
    private String queryName;

    public static AnimalFragment newInstance(String query) {
        AnimalFragment f = new AnimalFragment();
        Bundle args = new Bundle();
        args.putString(Constant.ARG_ROOM_NAME, query);
        f.setArguments(args);
        return f;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_animal;
    }

    @Override
    protected AnimalPresenter initPresenter() {
        return new AnimalPresenter();
    }

    @Override
    protected void initView() {
        parent = view.findViewById(R.id.parent);
        rv_list = view.findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(mContext));
        rv_list.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));

        queryName = getArguments().getString(Constant.ARG_ROOM_NAME, "");
    }

    @Override
    protected void getData() {
        LoadingBar.view(parent).show();
        mPresenter.getData(queryName);
    }

    private void finishData() {
        LoadingBar.view(parent).cancel();
    }

    @Override
    public void onDataSuccess(AnimalBean data) {
        finishData();

        if (data.getResult().getCount() == 0) {
            view.findViewById(R.id.tv_no_data).setVisibility(View.VISIBLE);
            return;
        }

        CommonAdapter<AnimalBean.ResultBean.ResultsBean> adapter =
                new CommonAdapter<AnimalBean.ResultBean.ResultsBean>(mContext,
                        R.layout.list_item_animal, data.getResult().getResults()) {
                    @Override
                    public void convert(ViewHolder holder, AnimalBean.ResultBean.ResultsBean data) {
                        ImageView iv_pic = holder.getView(R.id.iv_pic);
                        Glide.with(mContext)
                                .applyDefaultRequestOptions(new RequestOptions()
                                        .placeholder(R.drawable.animal)
                                        .error(R.drawable.animal))
                                .load(data.getA_Pic01_URL())
                                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                                .into(iv_pic);

                        TextView tv_name = holder.getView(R.id.tv_name);
                        tv_name.setText(data.getA_Name_Ch());

                        TextView tv_name_en = holder.getView(R.id.tv_name_en);
                        tv_name_en.setText(data.getA_Name_En());

                        TextView tv_behavior = holder.getView(R.id.tv_behavior);
                        tv_behavior.setText(data.getA_Behavior());

                        holder.itemView.setOnClickListener((View view) -> {
                                    Intent intent = new Intent(mContext, AnimalDetailActivity.class);
                                    Bundle mBundle = new Bundle();
                                    mBundle.putSerializable(Constant.ARG_ANIMAL, data);
                                    intent.putExtras(mBundle);
                                    startActivity(intent);
                                    Animatoo.animateInAndOut(mContext);
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
