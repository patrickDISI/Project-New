package live.patrick.networkcall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import live.patrick.networkcall.databinding.ActivityMainBinding
import live.patrick.networkcall.ui.MainViewModel
import live.patrick.networkcall.ui.UserAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.userRv.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewModel.run {
            getUsers()
            usersLiveData.observe(this@MainActivity, {users ->
                userAdapter.users = users
                userAdapter.notifyDataSetChanged()
            })
        }


    }
}