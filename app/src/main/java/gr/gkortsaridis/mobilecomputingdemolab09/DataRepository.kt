package gr.gkortsaridis.mobilecomputingdemolab09

class DataRepository {
    suspend fun retrieveJokes() : List<Joke>{
        return JokesApi.retrofitService.fetchJokes()
    }
}