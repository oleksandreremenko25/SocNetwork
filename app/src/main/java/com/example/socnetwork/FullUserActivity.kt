package com.example.socnetwork

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_short.view.*



class FullUserActivity : AppCompatActivity()  {
    private lateinit var userViewModel: UserViewModel
    var nameUser: TextView? = null
    var lastOnlineUser: TextView? = null
    var emailUser: TextView? = null
    var hobbyUser: TextView? = null
    var photoUser: ImageView? = null

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_full)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        photoUser = findViewById(R.id.photoUser)
        nameUser = findViewById(R.id.nameUser)
        lastOnlineUser = findViewById(R.id.lastOnlineUser)
        emailUser = findViewById(R.id.emailUser)
        hobbyUser = findViewById(R.id.hobbyUser)

        val intent = intent
        val message: Int = intent.getIntExtra("myKey", 0)

        observeUser(message)
    }

    private fun observeUser(message: Int) {
        userViewModel.setUserId(message)

        userViewModel.user.observe(this, Observer { user ->
            showUser(user)
        })
    }

    private fun showUser(oneUser: User) {
        Picasso.get().load(oneUser.photo).placeholder(resources.getIdentifier("com.example.socnetwork:drawable/no", null, null)).into(photoUser);

        nameUser?.text = oneUser.name
        lastOnlineUser?.text = oneUser.lastOnline
        emailUser?.text = oneUser.email
        hobbyUser?.text = oneUser.hobby
    }
}