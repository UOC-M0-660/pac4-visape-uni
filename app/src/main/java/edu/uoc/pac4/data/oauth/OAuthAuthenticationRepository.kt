package edu.uoc.pac4.data.oauth

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import edu.uoc.pac4.R
import edu.uoc.pac4.data.SessionManager
import edu.uoc.pac4.ui.LaunchActivity
import edu.uoc.pac4.ui.login.oauth.OAuthActivity
import kotlinx.android.synthetic.main.activity_oauth.*
import kotlinx.coroutines.launch

/**
 * Created by alex on 11/21/20.
 */
class OAuthAuthenticationRepository(
    private val oAuthDataSource: OAuthDataSource,
    private val sessionManager: SessionManager
) : AuthenticationRepository {

    private val TAG = "OAuthAuthenticationRepository"

    override suspend fun isUserAvailable(): Boolean {
        return sessionManager.isUserAvailable()
    }

    override suspend fun login(authorizationCode: String): Boolean {
        oAuthDataSource.getTokens(authorizationCode)?.let { response ->
            Log.d(TAG, "Got Access token ${response.accessToken}")

            sessionManager.saveAccessToken(response.accessToken)
            response.refreshToken?.let {
                sessionManager.saveAccessToken(it)
            }
            return true
        } ?: run {
            return false
        }

    }

    override suspend fun logout() {
        sessionManager.clearAccessToken()
        sessionManager.clearRefreshToken()
    }
}