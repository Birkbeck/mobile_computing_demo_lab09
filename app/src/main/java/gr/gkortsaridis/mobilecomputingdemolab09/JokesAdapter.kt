package gr.gkortsaridis.mobilecomputingdemolab09

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gr.gkortsaridis.mobilecomputingdemolab09.databinding.ListviewItemJokeBinding

class JokesAdapter(private var jokes: List<Joke> = listOf()) :
    RecyclerView.Adapter<JokesAdapter.JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val binding = ListviewItemJokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JokeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(jokes[position])
    }

    override fun getItemCount() = jokes.size

    fun updateJokes(jokes: List<Joke>) {
        this.jokes = jokes
        notifyDataSetChanged()
    }

    inner class JokeViewHolder(private val binding: ListviewItemJokeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(joke: Joke) {
            binding.jokeSetup.text = joke.setup
            binding.jokePunchline.text = joke.punchline
            binding.executePendingBindings()
        }
    }
}