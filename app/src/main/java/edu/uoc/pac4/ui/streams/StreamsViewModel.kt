package edu.uoc.pac4.ui.streams

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.uoc.pac4.data.SessionManager
import edu.uoc.pac4.data.streams.Stream
import edu.uoc.pac4.data.streams.StreamsRepository
import kotlinx.coroutines.launch

class StreamsViewModel (
    private val repository: StreamsRepository,
    private val sessionManager: SessionManager
) : ViewModel() {
    val streams : MutableLiveData<Pair<String?, List<Stream>>> = MutableLiveData()

    private val TAG = "StreamsViewModel"

    fun getStreams(actualCursor: String?) {
        viewModelScope.launch {
            repository.getStreams(actualCursor).let { response ->
                Log.d(TAG, "Got Streams: $response")

                streams.postValue(response)
            }
        }
    }

    fun clearAccessToken() {
        sessionManager.clearAccessToken()
    }


}