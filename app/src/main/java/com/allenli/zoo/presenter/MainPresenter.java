package com.allenli.zoo.presenter;

import com.allenli.zoo.base.BasePresenter;
import com.allenli.zoo.contract.MainContract;
import com.allenli.zoo.model.bean.MainBean;
import com.allenli.zoo.model.repo.MainModel;

public class MainPresenter extends BasePresenter<MainContract.IView> implements MainContract.IPresenter {
    private MainModel model;

    public MainPresenter() {
        model = new MainModel();
    }

    public void getData(){
        model.getData(new MainContract.ICallBack(){
            @Override
            public void onSuccess(MainBean data) {
                getView().onDataSuccess(data);
            }

            @Override
            public void onFail(String errorMessage) {
                getView().onDataFail(errorMessage);
            }
        });
    }
}
