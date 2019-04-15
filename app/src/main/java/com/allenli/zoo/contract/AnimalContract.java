package com.allenli.zoo.contract;


import com.allenli.zoo.model.bean.AnimalBean;

public class AnimalContract {
    public interface IView{
        void onDataSuccess(AnimalBean data);

        void onDataFail(String errorInfo);
    }

    public interface IModel{
        void getData(String query, ICallBack callBack);
    }

    public interface ICallBack{
        void onSuccess(AnimalBean data);

        void onFail(String errorMessage);
    }

    public interface IPresenter{
        void getData(String query);
    }
}
