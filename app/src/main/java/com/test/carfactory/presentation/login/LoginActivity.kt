package com.test.carfactory.presentation.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.test.carfactory.R
import com.test.carfactory.presentation.main.MainActivity
import com.test.carfactory.presentation.registration.RegistrationActivity

class LoginActivity : MvpAppCompatActivity(), LoginView {
    @InjectPresenter
    lateinit var mLoginPresenter: LoginPresenter

    private lateinit var mLoginUsername: EditText
    private lateinit var mLoginPassword: EditText
    private lateinit var mLoginProgress: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        setContentView(R.layout.activity_login)
        mLoginUsername = findViewById(R.id.loginUsername)
        mLoginPassword = findViewById(R.id.loginPassword)
        mLoginProgress = findViewById(R.id.loginProgress)
        val loginOkButton: Button = findViewById(R.id.loginOkButton)
        loginOkButton.setOnClickListener {
            mLoginPresenter.onLoginClick(mLoginUsername.text.toString(), mLoginPassword.text.toString())
        }
        val loginRegistrationButton: Button = findViewById(R.id.loginRegistrationButton)
        loginRegistrationButton.setOnClickListener {
            mLoginPresenter.onRegistrationClick()
        }
    }

    override fun onStartMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStartRegistration() {
        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
    }

    override fun onShowMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onShowProgress(show: Boolean) {
        mLoginProgress.visibility = when(show) {
            true -> View.VISIBLE
            false -> View.GONE
        }
    }
}
