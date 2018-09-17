package com.test.carfactory.presentation.cars

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
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

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mCarsProgress: ProgressBar

    @ProvidePresenter
    fun providePresenter(): CarsPresenter {
        return mCarsPresenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity?.application as CarFactoryApplication).getApplicationComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_cars, container, false)

        mRecyclerView = rootView.findViewById(R.id.carsRecyclerView)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(activity)

        mCarsProgress = rootView.findViewById(R.id.carsProgress)

        return rootView
    }

    override fun onShowProgress(show: Boolean) {
        mCarsProgress.visibility = when(show) {
            true -> View.VISIBLE
            false -> View.GONE
        }
    }

    override fun onShowCars(cars: List<Car>) {
        val carsAdapter = CarsAdapter(cars)
        mRecyclerView.adapter = carsAdapter
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
