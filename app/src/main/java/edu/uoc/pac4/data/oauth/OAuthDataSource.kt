package edu.uoc.pac4.data.oauth

import android.util.Log
import edu.uoc.pac4.data.network.Endpoints
import io.ktor.client.*
import io.ktor.client.request.*

class OAuthDataSource(private val httpClient: HttpClient) {
    private val TAG = "StreamsDataSource"
    suspend fun getTokens(authorizationCode: String): OAuthTokensResponse? {
        // Get Tokens from Twitch
        try {
            val response = httpClient
                .post<OAuthTokensResponse>(Endpoints.tokenUrl) {
                    parameter("client_id", OAuthConstants.clientID)
                    parameter("client_secret", OAuthConstants.clientSecret)
                    parameter("code", authorizationCode)
                    parameter("grant_type", "authorization_code")
                    parameter("redirect_uri", OAuthConstants.redirectUri)
                }

            return response

        } catch (t: Throwable) {
            Log.w(TAG, "Error Getting Access token", t)
            return null
        }
    }
}