package com.example.socnetwork

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.user_short.view.*
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        observeUsers()
    }

    private fun observeUsers() {
        userViewModel.allUserList.observe(this, Observer { users ->
            showUsers(users)
        })
    }

    private fun showUsers(users: List<User>) {
        var generatedId: Int = 0
        val context: Context = this
        val textBeforeNameUser: String = context.getString(R.string.beforeNameUser);
        val textBeforeEmailUser: String = context.getString(R.string.beforeEmailUser);
        val textBeforeHobbyUser: String = context.getString(R.string.beforeHobbyUser);
        val textBeforeLastOnlineUser: String = context.getString(R.string.beforeLastOnlineUser);

        for (oneUser in users) {
            val view: View = layoutInflater.inflate(R.layout.user_short, null)
            val layout = findViewById<LinearLayout>(R.id.users_list_wrapper)
            var photo = resources.getIdentifier("com.example.socnetwork:drawable/" + oneUser.photo, null, null)

            if(photo == 0) {
                photo = resources.getIdentifier("com.example.socnetwork:drawable/no", null, null)
            }

            view.photoUser.setImageResource(photo);
            view.nameUser.text = (textBeforeNameUser + " " + oneUser.name)
            view.lastOnlinelUser.text = (textBeforeEmailUser + " " + oneUser.lastOnline)
            view.setId(generatedId);
            layout.addView(view)
            generatedId++
        }
    }

    fun userShortClick(views: View) {
        val intent = Intent(this, FullUserActivity::class.java)
        val idUser: Int = views.id
        intent.putExtra("myKey", idUser)
        startActivity(intent)
    }
}

