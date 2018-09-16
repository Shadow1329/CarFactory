package com.test.carfactory.internal.di

import android.content.Context
import dagger.Module
import io.realm.Realm

@Module
class RealmModule(context: Context) {
    init {
        Realm.init(context)
    }
}