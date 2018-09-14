package com.test.carfactory.presentation.registration

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.jakewharton.rxbinding2.widget.RxTextView
import com.test.carfactory.R
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction

class RegistrationActivity : MvpAppCompatActivity(), RegistrationView {
    @InjectPresenter
    lateinit var mRegistrationPresenter: RegistrationPresenter

    private lateinit var mRegistrationUsername: EditText
    private lateinit var mRegistrationPassword: EditText
    private lateinit var mRegistrationProgress: View
    private lateinit var mLoginDisposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()

    }

    override fun onDestroy() {
        super.onDestroy()
        destoyUI()

    }

    private fun setupUI() {
        setContentView(R.layout.activity_registration)
        mRegistrationUsername = findViewById(R.id.registrationUsername)
        mRegistrationPassword = findViewById(R.id.registrationPassword)
        mRegistrationProgress = findViewById(R.id.registrationProgress)
        val registrationCreateButton: Button = findViewById(R.id.registrationCreateButton)
        registrationCreateButton.setOnClickListener {
            mRegistrationPresenter.onCreateClick(mRegistrationUsername.text.toString(), mRegistrationPassword.text.toString())
        }
        val registrationButtonEnabled: Observable<Boolean> = Observable.combineLatest(
                RxTextView.textChanges(mRegistrationUsername),
                RxTextView.textChanges(mRegistrationPassword),
                BiFunction { u, p -> u.isNotEmpty() && p.isNotEmpty() })
        mLoginDisposable = registrationButtonEnabled.subscribe { registrationCreateButton.isEnabled = it }
    }

    private fun destoyUI() {
        if (!mLoginDisposable.isDisposed)
            mLoginDisposable.dispose()
    }

    override fun onBack() {
        finish()
    }

    override fun onShowMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onShowProgress(show: Boolean) {
        mRegistrationProgress.visibility = when(show) {
            true -> View.VISIBLE
            false -> View.GONE
        }
    }
}
