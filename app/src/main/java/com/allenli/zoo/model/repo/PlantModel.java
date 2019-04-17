package com.allenli.zoo.model.repo;

import com.allenli.zoo.api.RetrofitClient;
import com.allenli.zoo.contract.PlantContract;
import com.allenli.zoo.model.bean.PlantBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class PlantModel implements PlantContract.IModel {
    private CompositeDisposable disposables = new CompositeDisposable();

    public void getData(String query, final PlantContract.ICallBack callBack) {
        disposables.add(RetrofitClient.apiService.getPlant(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<PlantBean>() {
                    @Override
                    public void onNext(PlantBean data) {
                        callBack.onSuccess(data);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    public void destroy() {
        disposables.clear();
    }
}
