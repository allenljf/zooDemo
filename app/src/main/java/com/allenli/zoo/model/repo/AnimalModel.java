package com.allenli.zoo.model.repo;

import com.allenli.zoo.api.RetrofitClient;
import com.allenli.zoo.contract.AnimalContract;
import com.allenli.zoo.model.bean.AnimalBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class AnimalModel implements AnimalContract.IModel {
    private CompositeDisposable disposables = new CompositeDisposable();

    public void getData(String query, final AnimalContract.ICallBack callBack) {
        disposables.add(RetrofitClient.apiService.getAnimal(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<AnimalBean>() {
                    @Override
                    public void onNext(AnimalBean data) {
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
