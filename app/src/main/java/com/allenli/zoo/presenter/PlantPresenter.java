package com.allenli.zoo.presenter;

import com.allenli.zoo.base.BasePresenter;
import com.allenli.zoo.contract.PlantContract;
import com.allenli.zoo.model.bean.PlantBean;
import com.allenli.zoo.model.repo.PlantModel;

public class PlantPresenter extends BasePresenter<PlantContract.IView> implements PlantContract.IPresenter {
    private PlantModel model;

    public PlantPresenter() {
        model = new PlantModel();
    }

    public void getData(String query) {
        model.getData(query, new PlantContract.ICallBack() {
            @Override
            public void onSuccess(PlantBean data) {
                if (isViewAttached()) {
                    getView().onDataSuccess(data);
                }
            }

            @Override
            public void onFail(String errorMessage) {
                getView().onDataFail(errorMessage);
            }
        });
    }

    @Override
    public void detachView() {
        super.detachView();
        model.destroy();
    }
}
