package com.test.carfactory.presentation.registration

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.test.carfactory.R

class RegistrationActivity : MvpAppCompatActivity(), RegistrationView {
    @InjectPresenter
    lateinit var mRegistrationPresenter: RegistrationPresenter

    private lateinit var mRegistrationUsername: EditText
    private lateinit var mRegistrationPassword: EditText
    private lateinit var mRegistrationProgress: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()

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
        val registrationCancelButton: Button = findViewById(R.id.registrationCancelButton)
        registrationCancelButton.setOnClickListener {
            mRegistrationPresenter.onCancelClick()
        }
    }

    override fun onBack() {
        finish()
    }

    override fun onShowError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun onShowProgress(show: Boolean) {
        mRegistrationProgress.visibility = when(show) {
            true -> View.VISIBLE
            false -> View.GONE
        }
    }
}
