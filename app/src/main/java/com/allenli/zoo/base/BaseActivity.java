package com.allenli.zoo.base;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends FragmentActivity {
    protected T mPresenter;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mContext = BaseActivity.this;

        mPresenter = initPresenter();
        if (null != mPresenter) {
            mPresenter.attachView((V) this);
        }

        initView();
    }

    protected abstract int getLayoutId();

    protected abstract T initPresenter();

    protected abstract void initView();

    protected abstract void getData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.detachView();
        }
    }
}

