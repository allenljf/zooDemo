package com.allenli.zoo.contract;

import com.allenli.zoo.model.bean.MainBean;

public class MainContract {
    public interface IView{
        void onDataSuccess(MainBean data);

        void onDataFail(String errorInfo);
    }

    public interface IModel{
        void getData(ICallBack callBack);
    }

    public interface ICallBack{
        void onSuccess(MainBean data);

        void onFail(String errorMessage);
    }

    public interface IPresenter{
        void getData();
    }
}
