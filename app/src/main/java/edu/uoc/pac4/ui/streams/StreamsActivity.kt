package edu.uoc.pac4.ui.streams

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import edu.uoc.pac4.R
import edu.uoc.pac4.data.network.UnauthorizedException
import edu.uoc.pac4.ui.login.LoginActivity
import edu.uoc.pac4.ui.profile.ProfileActivity
import kotlinx.android.synthetic.main.activity_streams.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class StreamsActivity : AppCompatActivity() {

    private val TAG = "StreamsActivity"

    private val adapter = StreamsAdapter()
    private val layoutManager = LinearLayoutManager(this)

    private val viewModel: StreamsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_streams)

        viewModel.streams.observe(this, {
            // Success :)
            val streams = it.second
            if (streams.isNotEmpty()) {
                // Update UI with Streams
                if (nextCursor != null) {
                    // We are adding more items to the list
                    adapter.submitList(adapter.currentList.plus(streams))
                } else {
                    // It's the first n items, no pagination yet
                    adapter.submitList(streams)
                }
                // Save cursor for next request
                nextCursor = it.first
            } else {
                // Show Error message to not leave the page empty
                if (adapter.currentList.isNullOrEmpty()) {
                    Toast.makeText(
                        this@StreamsActivity,
                        getString(R.string.error_streams), Toast.LENGTH_SHORT
                    ).show()
                }
            }

            // Hide Loading
            swipeRefreshLayout.isRefreshing = false
        })


        // Init RecyclerView
        initRecyclerView()
        // Swipe to Refresh Listener
        swipeRefreshLayout.setOnRefreshListener {
            getStreams()
        }
        // Get Streams
        getStreams()
    }

    private fun initRecyclerView() {
        // Set Layout Manager
        recyclerView.layoutManager = layoutManager
        // Set Adapter
        recyclerView.adapter = adapter
        // Set Pagination Listener
        recyclerView.addOnScrollListener(object : PaginationScrollListener(layoutManager) {
            override fun loadMoreItems() {
                getStreams(nextCursor)
            }

            override fun isLastPage(): Boolean {
                return nextCursor == null
            }

            override fun isLoading(): Boolean {
                return swipeRefreshLayout.isRefreshing
            }
        })
    }

    private var nextCursor: String? = null
    private fun getStreams(cursor: String? = null) {
        Log.d(TAG, "Requesting streams with cursor $cursor")

        // Show Loading
        swipeRefreshLayout.isRefreshing = true

        // Get Twitch Streams
        lifecycleScope.launch {
            try {
                viewModel.getStreams(cursor)

            } catch (t: UnauthorizedException) {
                Log.w(TAG, "Unauthorized Error getting streams", t)
                // Clear local access token
                viewModel.clearAccessToken()
                // User was logged out, close screen and open login
                finish()
                startActivity(Intent(this@StreamsActivity, LoginActivity::class.java))
            }
        }
    }

    // region Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate Menu
        menuInflater.inflate(R.menu.menu_streams, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.menu_user -> {
                startActivity(Intent(this, ProfileActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    // endregion
}