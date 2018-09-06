package com.test.carfactory.presentation.factory

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.test.carfactory.R

class FactoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_factory, container, false)
    }

    companion object {
        fun newInstance(): FactoryFragment {
            return FactoryFragment()
        }
    }
}
