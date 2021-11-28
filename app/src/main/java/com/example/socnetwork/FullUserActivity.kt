package com.example.socnetwork

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
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
    var autorPostsIcon: ImageView? = null
    var autorPostsName: TextView? = null
    var autorPostsLastOnline: TextView? = null
    var video: VideoView? = null
    var mediaController: MediaController? = null

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
        autorPostsIcon = findViewById(R.id.autorPostsIcon)
        autorPostsName = findViewById(R.id.autorPostsName)
        autorPostsLastOnline = findViewById(R.id.autorPostsLastOnline)
        video = findViewById(R.id.videoPost)
        video?.clearFocus()
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
        numberPosts?.text = oneUser.posts.toString()
        numberLikes?.text = oneUser.likes.toString()

        Picasso.get().load(oneUser.photo).placeholder(R.drawable.no).into(autorPostsIcon);
        autorPostsName?.text = oneUser.name
        autorPostsLastOnline?.text = oneUser.lastOnline

        mediaController = MediaController(this)
        mediaController!!.setAnchorView(this.video)
        video!!.setMediaController(mediaController)
        //video!!.setVideoURI(Uri.parse("https://www.youtube.com/embed/srMFb6zpx2Y"))

    }
}

