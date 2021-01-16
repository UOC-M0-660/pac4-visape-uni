package edu.uoc.pac4.ui.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.uoc.pac4.data.oauth.AuthenticationRepository
import edu.uoc.pac4.data.user.User
import edu.uoc.pac4.data.user.UserRepository
import kotlinx.coroutines.launch

class ProfileViewModel (
    private val userRepository: UserRepository,
    private val oAuthRepository: AuthenticationRepository
) : ViewModel() {
    val user: MutableLiveData<User> = MutableLiveData()

    fun getUser() {
        viewModelScope.launch {
            user.postValue(userRepository.getUser())
        }
    }

    fun updateUser(description: String) {
        viewModelScope.launch {
            user.postValue(userRepository.updateUser(description))
        }
    }

    fun logOut() {
        viewModelScope.launch {
            oAuthRepository.logout()
        }
    }

    fun clearAccessToken() {
        viewModelScope.launch {
            oAuthRepository.clearAccessToken()
        }
    }
}