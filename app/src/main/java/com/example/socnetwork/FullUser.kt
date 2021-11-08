package com.example.socnetwork

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent;
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.user_short.view.*

class FullUser : AppCompatActivity()  {
    // посилання на ViewModel - це потрібно щоб повязати ViewModel з даним Fragment (контролером інтерфейсу користувача)
    private lateinit var userViewModel: UserViewModel

    var nameUser: TextView? = null
    var emailUser: TextView? = null
    var hobbyUser: TextView? = null

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_full)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        var photoUser: ImageView = findViewById(R.id.photoUser)
        nameUser = findViewById(R.id.nameUser)
        emailUser = findViewById(R.id.emailUser)
        hobbyUser = findViewById(R.id.hobbyUser)

        val intent = intent
        val message: Int? = intent.getIntExtra("myKey", 0)
        val allUser: List<UserData> = userViewModel.getUsersList()

        val oneUser: UserData = allUser[message!!]
        val photo = resources.getIdentifier("com.example.socnetwork:drawable/" + oneUser.photo, null, null)
        photoUser.setImageResource(photo);
        nameUser?.text = oneUser.name
//        emailUser?.text = oneUser.email
//        hobbyUser?.text = oneUser.hobby

    }
}