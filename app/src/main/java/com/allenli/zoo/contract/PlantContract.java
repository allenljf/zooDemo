package com.allenli.zoo.contract;


import com.allenli.zoo.model.bean.PlantBean;

public class PlantContract {
    public interface IView{
        void onDataSuccess(PlantBean data);

        void onDataFail(String errorInfo);
    }

    public interface IModel{
        void getData(String query, ICallBack callBack);
    }

    public interface ICallBack{
        void onSuccess(PlantBean data);

        void onFail(String errorMessage);
    }

    public interface IPresenter{
        void getData(String query);
    }
}
