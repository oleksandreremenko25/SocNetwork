package com.example.socnetwork

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer

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

        userViewModel.allUserList.observe(this, Observer { user ->
            showUser(user)
        })
    }

    private fun showUser(user: List<User>) {
            val context: Context = this
            val textBeforeNameUser: String = context.getString(R.string.beforeNameUser);
            val textBeforeEmailUser: String = context.getString(R.string.beforeEmailUser);
            val textBeforeHobbyUser: String = context.getString(R.string.beforeHobbyUser);
            val textBeforeLastOnlineUser: String = context.getString(R.string.beforeLastOnlineUser);
            val oneUser: User = user.get(0)
            var photo = resources.getIdentifier("com.example.socnetwork:drawable/" + oneUser.photo, null, null)

            if(photo == 0) {
                photo = resources.getIdentifier("com.example.socnetwork:drawable/no", null, null)
            }

            photoUser?.setImageResource(photo);
            nameUser?.text = (textBeforeNameUser + " " + oneUser.name)
            lastOnlineUser?.text = (textBeforeEmailUser + " " + oneUser.lastOnline)
            emailUser?.text = (textBeforeHobbyUser + " " + oneUser.email)
            hobbyUser?.text = (textBeforeLastOnlineUser + " " + oneUser.hobby)
    }
}