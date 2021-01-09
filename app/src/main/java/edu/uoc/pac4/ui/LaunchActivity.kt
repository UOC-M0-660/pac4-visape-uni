package edu.uoc.pac4.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import edu.uoc.pac4.R
import edu.uoc.pac4.ui.login.LoginActivity
import edu.uoc.pac4.ui.streams.StreamsActivity
import org.koin.android.viewmodel.ext.android.viewModel

class LaunchActivity : AppCompatActivity() {
    private val viewModel: LaunchViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        viewModel.isUserAvailable.observe(this, Observer { isAvailable ->
            if (isAvailable) {
                // User is available, open Streams Activity
                startActivity(Intent(this, StreamsActivity::class.java))
            } else {
                // User not available, request Login
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        })

        checkUserSession()
    }

    private fun checkUserSession() {
        viewModel.getUserAvailability()
    }
}