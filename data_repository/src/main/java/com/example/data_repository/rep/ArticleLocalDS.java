package com.example.data_repository.rep;

import com.demo.sdk.common_base.BaseApplication;
import com.demo.sdk.common_base.mvvm.BaseLocalDataSource;
import com.demo.sdk.common_base.utils.LogUtil;
import com.example.data_repository.greendao.DaoMaster;
import com.example.data_repository.greendao.DaoSession;

public class ArticleLocalDS extends BaseLocalDataSource<DaoMaster, DaoSession> {

    @Override
    public DaoMaster getDaoMaster() {
        LogUtil.d("don test", "don getDaoMaster");
        DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(BaseApplication.getInstance(), "don001.db", null);
//        Database database = helper.getEncryptedWritableDb("123");
//        mDaoMaster = new DaoMaster(database);
//        mDaoMaster = new DaoMaster(helper.getEncryptedWritableDb("123"));
        mDaoMaster = new DaoMaster(helper.getWritableDb());
        return mDaoMaster;
    }

    @Override
    public DaoSession getDaoSession() {
        if (mDaoSession == null) {
            synchronized (DaoSession.class) {
                if (mDaoMaster == null) {
                    synchronized (DaoMaster.class) {
                        if (mDaoMaster == null) {
                            mDaoMaster = getDaoMaster();
                        }
                    }
                    if (mDaoSession == null) {
                        mDaoSession = mDaoMaster.newSession();
                    }
                }
            }
        }
        return mDaoSession;
    }

    @Override
    public void clearAllCache() {

    }
}