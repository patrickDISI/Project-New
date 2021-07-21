package live.patrick.networkcall.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import live.patrick.networkcall.databinding.UserItemBinding
import live.patrick.networkcall.models.User

class UserAdapter(var users: List<User>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(private val binding: UserItemBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bindUser(user: User){
                    binding.apply {
                        nameDisplay.text = user.name
                        emailDisplay.text = user.email
                        streetDisplay.text = user.address.street
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindUser(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}