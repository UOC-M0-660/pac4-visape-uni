package edu.uoc.pac4.data.user

/**
 * Created by alex on 11/21/20.
 */

class TwitchUserRepository(
) : UserRepository {

    override suspend fun getUser(): User? {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(description: String): User? {
        TODO("Not yet implemented")
    }
}