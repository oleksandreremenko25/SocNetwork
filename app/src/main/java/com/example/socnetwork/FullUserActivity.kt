package com.example.socnetwork

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso

class FullUserActivity : AppCompatActivity()  {
    private lateinit var userViewModel: UserViewModel
    var nameUser: TextView? = null
    var lastOnlineUser: TextView? = null
    var emailUser: TextView? = null
    var photoUser: ImageView? = null
    var aboutUser: TextView? = null
    var numberFollowing: TextView? = null
    var numberFollowers: TextView? = null
    var numberPosts: TextView? = null
    var numberLikes: TextView? = null
    var authorPostsIcon: ImageView? = null
    var authorPostsName: TextView? = null
    var authorPostsLastOnline: TextView? = null

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_full)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        photoUser = findViewById(R.id.photoUser)
        nameUser = findViewById(R.id.nameUser)
        aboutUser = findViewById(R.id.aboutUser)
        numberFollowing = findViewById(R.id.numberFollowing)
        numberFollowers = findViewById(R.id.numberFollowers)
        numberPosts = findViewById(R.id.numberPosts)
        numberLikes = findViewById(R.id.numberLikes)
        authorPostsIcon = findViewById(R.id.authorPostsIcon)
        authorPostsName = findViewById(R.id.authorPostsName)
        authorPostsLastOnline = findViewById(R.id.authorPostsLastOnline)

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
        Picasso.get().load(oneUser.photo).placeholder(R.drawable.no).into(photoUser);

        nameUser?.text = oneUser.name
        lastOnlineUser?.text = oneUser.lastOnline
        emailUser?.text = oneUser.email
        aboutUser?.text = oneUser.about
        numberFollowing?.text = oneUser.following.toString()
        numberFollowers?.text = oneUser.followers.toString()

        val textForNumberPosts: String = getString(R.string.tittlePosts, oneUser.posts.toString())
        numberPosts?.text = textForNumberPosts

        val textForNumberLikes: String = getString(R.string.tittlePosts, oneUser.likes.toString())
        numberLikes?.text = textForNumberLikes

        Picasso.get().load(oneUser.photo).placeholder(R.drawable.no).into(authorPostsIcon);
        authorPostsName?.text = oneUser.name
        authorPostsLastOnline?.text = oneUser.lastOnline
    }
}

