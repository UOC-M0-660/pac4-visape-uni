package edu.uoc.pac4.data.streams

/**
 * Created by alex on 11/21/20.
 */

class TwitchStreamsRepository(
    private val streamsDataSource: StreamsDataSource
) : StreamsRepository {

    override suspend fun getStreams(cursor: String?): Pair<String?, List<Stream>> {
        val streamsResponse = streamsDataSource.getStreams()

        return Pair(streamsResponse?.pagination?.cursor, streamsResponse?.data!!)
    }

}