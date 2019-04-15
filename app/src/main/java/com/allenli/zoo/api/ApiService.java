package com.allenli.zoo.api;


import com.allenli.zoo.model.bean.AnimalBean;
import com.allenli.zoo.model.bean.MainBean;
import com.allenli.zoo.model.bean.PlantBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    String mainUrl = "apiAccess?scope=";

    //首頁
    @GET(mainUrl + "resourceAquire&rid=5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
    Observable<MainBean> getMain();

    //動物
    @GET(mainUrl + "resourceAquire&rid=a3e2b221-75e0-45c1-8f97-75acbd43d613")
    Observable<AnimalBean> getAnimal(@Query("q") String q);

    //植物
    @GET(mainUrl + "resourceAquire&rid=f18de02f-b6c9-47c0-8cda-50efad621c14")
    Observable<PlantBean> getPlant(@Query("q") String q);
}
