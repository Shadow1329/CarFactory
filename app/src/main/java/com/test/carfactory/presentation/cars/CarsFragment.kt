package com.test.carfactory.presentation.cars

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ProgressBar
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter

import com.test.carfactory.R
import com.test.carfactory.domain.model.Car
import com.test.carfactory.internal.CarFactoryApplication
import javax.inject.Inject

class CarsFragment : MvpAppCompatFragment(), CarsView {
    @Inject
    @InjectPresenter
    lateinit var mCarsPresenter: CarsPresenter

    @BindView(R.id.carsRecyclerView)
    lateinit var mRecyclerView: RecyclerView

    @BindView(R.id.carsProgress)
    lateinit var mCarsProgress: ProgressBar

    @BindView(R.id.carsSwipeRefresh)
    lateinit var mCarsSwipeRefresh: SwipeRefreshLayout

    private lateinit var mUnbinder: Unbinder

    @ProvidePresenter
    fun providePresenter(): CarsPresenter {
        return mCarsPresenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity?.application as CarFactoryApplication).getApplicationComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_cars, container, false)
        mUnbinder = ButterKnife.bind(this, view)

        mCarsSwipeRefresh.setOnRefreshListener {
            mCarsPresenter.onLoadData()
        }

        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mRecyclerView.layoutAnimation = AnimationUtils.loadLayoutAnimation(context, R.anim.cars_list_animaton)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mUnbinder.unbind()
    }

    override fun onShowProgress(show: Boolean) {
        mCarsProgress.visibility = when(show) {
            true -> View.VISIBLE
            false -> View.GONE
        }
        mCarsSwipeRefresh.isRefreshing = false
    }

    override fun onShowCars(cars: List<Car>) {
        val carsAdapter = CarsAdapter(cars)
        mRecyclerView.adapter = carsAdapter
        mRecyclerView.scheduleLayoutAnimation()
    }

    override fun onShowMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance(): CarsFragment {
            return CarsFragment()
        }
    }
}
