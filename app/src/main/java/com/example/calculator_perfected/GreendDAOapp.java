package com.example.calculator_perfected;

import android.app.Application;
import android.util.Log;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class GreendDAOapp extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        daoSession = new DaoMaster(
                new DaoMaster.DevOpenHelper(GreendDAOapp.this, "perfectedCalculator.db").getWritableDb()).newSession();

    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
