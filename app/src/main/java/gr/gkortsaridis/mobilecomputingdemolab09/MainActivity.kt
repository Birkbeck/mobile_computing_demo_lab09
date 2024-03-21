package gr.gkortsaridis.mobilecomputingdemolab09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import gr.gkortsaridis.mobilecomputingdemolab09.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val dataRepository = DataRepository()
    private val adapter = JokesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.jokesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.jokesRecyclerView.adapter = adapter

        viewModel.setupRepository(dataRepository)
        viewModel.retrieveJokes()

        viewModel.jokes.observe(this) { jokes ->
            Log.i("BBK", "Retrieved the following jokes from the Internet: $jokes")
            adapter.updateJokes(jokes)
        }
    }
}