package com.allenli.zoo.presenter;

import com.allenli.zoo.base.BasePresenter;
import com.allenli.zoo.contract.AnimalContract;
import com.allenli.zoo.contract.MainContract;
import com.allenli.zoo.model.bean.AnimalBean;
import com.allenli.zoo.model.bean.MainBean;
import com.allenli.zoo.model.repo.AnimalModel;
import com.allenli.zoo.model.repo.MainModel;

public class AnimalPresenter extends BasePresenter<AnimalContract.IView> implements AnimalContract.IPresenter {
    private AnimalModel model;

    public AnimalPresenter() {
        model = new AnimalModel();
    }

    public void getData(String query){
        model.getData(query, new AnimalContract.ICallBack(){
            @Override
            public void onSuccess(AnimalBean data) {
                getView().onDataSuccess(data);
            }

            @Override
            public void onFail(String errorMessage) {
                getView().onDataFail(errorMessage);
            }
        });
    }
}
