package edu.uoc.pac4.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import edu.uoc.pac4.R
import edu.uoc.pac4.ui.login.LoginActivity
import edu.uoc.pac4.data.SessionManager
import edu.uoc.pac4.ui.streams.StreamsActivity

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        checkUserSession()
    }

    private fun checkUserSession() {
        Log.d("TEEEEST", "CHECK USER")
        if (SessionManager(this).isUserAvailable()) {
            Log.d("TEEEEST", "USER AV")
            // User is available, open Streams Activity
            startActivity(Intent(this, StreamsActivity::class.java))
        } else {
            Log.d("TEEEEST", "USER UNAV")
            // User not available, request Login
            startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()
    }
}