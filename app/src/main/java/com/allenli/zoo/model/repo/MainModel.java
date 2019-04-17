package com.allenli.zoo.model.repo;

import com.allenli.zoo.api.RetrofitClient;
import com.allenli.zoo.contract.MainContract;
import com.allenli.zoo.model.bean.MainBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainModel implements MainContract.IModel {
    private CompositeDisposable disposables = new CompositeDisposable();

    public void getData(final MainContract.ICallBack callBack) {
        disposables.add(RetrofitClient.apiService.getMain()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<MainBean>() {
                    @Override
                    public void onNext(MainBean data) {
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
