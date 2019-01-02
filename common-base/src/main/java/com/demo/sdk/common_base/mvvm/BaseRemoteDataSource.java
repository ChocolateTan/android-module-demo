package com.demo.sdk.common_base.mvvm;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;

public class BaseRemoteDataSource implements IRemoteDataSource {

    protected Retrofit retrofit;
    private Map<String, Object> stringRetrofitMap;

    public BaseRemoteDataSource(Retrofit retrofit) {
        this.retrofit = retrofit;
        stringRetrofitMap = new HashMap<>();
    }

    @Override
    public <T> T getApi(Class<T> retrofitClass) {
        T result = null;
        if (stringRetrofitMap != null) {
            synchronized (stringRetrofitMap) {
                result = (T) stringRetrofitMap.get(retrofitClass.getName());
                if (result == null) {
                    result = retrofit.create(retrofitClass);
                    stringRetrofitMap.put(retrofitClass.getName(), result);
                }
            }
        }
        return result;
    }

    @Override
    public <T> void clearApi(Class<T> retrofitClass) {
        if (stringRetrofitMap != null) {
            synchronized (stringRetrofitMap) {
                if (stringRetrofitMap.containsKey(retrofitClass.getName())) {
                    stringRetrofitMap.remove(retrofitClass.getName());
                }
            }
        }
    }

    @Override
    public void clearAllCache() {
        if (stringRetrofitMap != null) {
            synchronized (stringRetrofitMap) {
                stringRetrofitMap.clear();
            }
        }

    }
}
