package com.demo.sdk.common_base.mvvm;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.AbstractDaoSession;

public abstract class BaseLocalDataSource<M extends AbstractDaoMaster,S extends AbstractDaoSession>
        implements ILocalDataSource {
    protected M mDaoMaster;
    protected S mDaoSession;
//    protected T mDaoManager;
//
//    public BaseLocalDataSource(T mDaoManager) {
//        this.mDaoManager = mDaoManager;
//    }

    public abstract M getDaoMaster();

    public abstract S getDaoSession();

    public abstract void clearAllCache();
}

