package com.demo.sdk.common_base.mvvm;

public interface ILocalDataSource<M, S> {

    M getDaoMaster();
    S getDaoSession();

    void clearAllCache();
}
