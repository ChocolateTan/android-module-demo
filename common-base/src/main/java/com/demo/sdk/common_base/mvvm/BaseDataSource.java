package com.demo.sdk.common_base.mvvm;

public abstract class BaseDataSource<R extends BaseRemoteDataSource, L extends BaseLocalDataSource> {
    public BaseDataSource() {
        this.remoteDataSource = createRemoteDataSource();
        this.localDataSource = createLocalDataSource();
    }

    //持有对应的本地和远程源数据
    public abstract R createRemoteDataSource();

    public abstract L createLocalDataSource();

    public R remoteDataSource;
    public L localDataSource;

    public R provideRemoteDataSource() {
        return this.remoteDataSource;
    }

    public L provideLocalDataSource() {
        return this.localDataSource;
    }
}
