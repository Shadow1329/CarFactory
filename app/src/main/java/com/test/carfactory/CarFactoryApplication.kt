package com.test.carfactory

import android.app.Application
import android.content.Context
import io.realm.Realm

class CarFactoryApplication : Application() {
    private lateinit var mContext: Context

    override fun onCreate() {
        super.onCreate()
        mContext = getApplicationContext()
        Realm.init(mContext)
    }

    fun getContext(): Context {
        return mContext
    }
}