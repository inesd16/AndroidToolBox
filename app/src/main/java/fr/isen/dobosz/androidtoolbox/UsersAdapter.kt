package fr.isen.dobosz.androidtoolbox

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.recycler_view_user_cell.view.*

class UsersAdapter(val users: ArrayList<UserModel>): RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersAdapter.UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_user_cell, parent, false)
        return UserViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return users.count()
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user : UserModel = users[position]
        holder.bind(user)
    }
/////////////////////////////////////
    class UserViewHolder(val view: View, val context: Context): RecyclerView.ViewHolder(view) {
        fun bind(user: UserModel) {
            var famName = user.name?.last?.toUpperCase()
            var string = user.name?.first+" "+famName
            view.title.text = user.name?.title
            view.firstNameTextView.text = string
            //view.fNameTextView.text = user.name?.last
            view.emailTextView.text = user.email
            view.locationTextView.text = user.location?.country

            Picasso
                .with(context)
                .load(user.picture?.large)
                .into(view.contactPicture)

            Log.i("URL picture", user.picture?.large)

        }
    }
}