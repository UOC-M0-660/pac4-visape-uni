package edu.uoc.pac4.data.di

import edu.uoc.pac4.data.SessionManager
import edu.uoc.pac4.data.network.Network
import edu.uoc.pac4.data.oauth.AuthenticationRepository
import edu.uoc.pac4.data.oauth.OAuthAuthenticationRepository
import edu.uoc.pac4.data.oauth.OAuthDataSource
import edu.uoc.pac4.data.streams.StreamsDataSource
import edu.uoc.pac4.data.streams.StreamsRepository
import edu.uoc.pac4.data.streams.TwitchStreamsRepository
import edu.uoc.pac4.data.user.TwitchUserRepository
import edu.uoc.pac4.data.user.UserDataSource
import edu.uoc.pac4.data.user.UserRepository
import edu.uoc.pac4.data.user.UsersResponse
import io.ktor.client.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by alex on 11/21/20.
 */

val dataModule = module {
    factory { Network.createHttpClient(androidContext())}

    //Streams
    single { StreamsDataSource(get())}
    single<StreamsRepository> { TwitchStreamsRepository(get())}

    //OAuth
    single { SessionManager(get())}
    single { OAuthDataSource(get())}
    single<AuthenticationRepository> { OAuthAuthenticationRepository(get(),get())}

    //User
    single {UserDataSource(get())}
    single<UserRepository> { TwitchUserRepository(get()) }

}