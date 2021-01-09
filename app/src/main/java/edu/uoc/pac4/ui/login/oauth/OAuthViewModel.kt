package edu.uoc.pac4.ui.login.oauth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.uoc.pac4.data.oauth.AuthenticationRepository
import kotlinx.coroutines.launch

class OAuthViewModel (
    private val repository: AuthenticationRepository
) : ViewModel() {
    val isLogged = MutableLiveData<Boolean>()

    fun login(authorizationCode: String) {
        viewModelScope.launch {
            isLogged.postValue(repository.login(authorizationCode))
        }
    }
}