package com.test.carfactory.presentation.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.test.carfactory.R

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {
    fun onNavigationItemClick(itemId: Int) {
        when(itemId) {
            R.id.nav_factory -> {
                viewState.onOpenFactory()
            }
            R.id.nav_cars -> {
                viewState.onOpenCars()
            }
        }
    }
}