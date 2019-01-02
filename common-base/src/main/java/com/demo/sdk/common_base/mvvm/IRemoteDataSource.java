package com.demo.sdk.common_base.mvvm;

public interface IRemoteDataSource {
    <T> T getApi(Class<T> retrofitClass);

    <T> void clearApi(Class<T> retrofitClass);

    void clearAllCache();
}
