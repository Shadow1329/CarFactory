package com.test.carfactory.presentation.cars

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.carfactory.R
import com.test.carfactory.domain.model.Car
import kotlinx.android.synthetic.main.item_car.view.*

class CarsAdapter(cars: List<Car>) : RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {
    private val mCarsList = cars

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return CarsViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mCarsList.size
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.setItem(mCarsList[position])
    }

    class CarsViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val mHeader = view.carHeader
        private val mDescription = view.carDescription

        fun setItem(car: Car) {
            mHeader.text = car.mName
            mDescription.text = car.mDescription
        }
    }
}