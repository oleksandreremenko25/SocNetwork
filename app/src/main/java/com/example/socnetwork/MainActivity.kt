package com.example.socnetwork

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.graphics.Bitmap
import android.provider.AlarmClock.EXTRA_MESSAGE

import android.view.LayoutInflater

import android.view.ViewGroup
import android.widget.ImageView

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.user_short.view.*

import java.net.HttpCookie.parse
import java.net.URI
import java.util.logging.Level.parse


class MainActivity : AppCompatActivity() {

    // посилання на ViewModel - це потрібно щоб повязати ViewModel з даним Fragment (контролером інтерфейсу користувача)
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        createOneElement()
    }

    private fun createOneElement() {
        val allUser: List<UserData> = userViewModel.getUsersList()
        var generatedId: Int = 0
        for (oneUser in allUser) {
            // Готуєм елемент який буде вставлятись
            val view: View = layoutInflater.inflate(R.layout.user_short, null)
            // Знаходим батьківський елемент куди буде вставлятись user_short.xml
            val layout = findViewById<LinearLayout>(R.id.users_list_wrapper)



            // assets folder image file name with extension
            val fileName = "flower6.jpg"


            // show bitmap on first image view

            // get the bitmap from assets folder and show on second image view
            val photo = resources.getIdentifier("com.example.socnetwork:drawable/" + oneUser.photo, null, null)
            view.photoUser.setImageResource(photo);
            view.nameUser.text = oneUser.name
            view.lastOnlinelUser.text = oneUser.lastOnline
            view.setId(generatedId);
            //Вставляєм user_short.xml в users_list_wrapper (він знаходиться в activity_main.xml)
            layout.addView(view)
            generatedId++
        }
    }

    fun userShortClick(views: View) {
        val intent = Intent(this, FullUser::class.java)
        val idUser: Int = views.id
        intent.putExtra("myKey", idUser)
        startActivity(intent)
    }

}

