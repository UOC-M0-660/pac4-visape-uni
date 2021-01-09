package edu.uoc.pac4.data.oauth

import java.util.*

/**
 * Created by alex on 07/09/2020.
 */
object OAuthConstants {

    // OAuth2 Variables
    const val clientID = "efwo35z4mgyiyhje8bbp73b98oyavf"//efwo35z4mgyiyhje8bbp73b98oyavf //h3haa2o0glz6rgmzvg3a11l3byoap7
    const val redirectUri = "http://localhost"
    val scopes = listOf("user:read:email user:edit")
    val uniqueState = UUID.randomUUID().toString()
    const val clientSecret = "7fl44yqjm5tjdx73z45dd9ybwuuiez"//7fl44yqjm5tjdx73z45dd9ybwuuiez //8h8x01zcvdocklfw6w086yt6pb6von

}