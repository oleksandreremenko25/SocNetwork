package com.example.socnetwork

data class User(var name: String,var email: String,var hobby: String,var lastOnline: String,var photo: String, var about: String, var following: Int, var followers: Int, var posts: Int, var likes: Int) {

    init {
        createPhoto()
    }

    fun createPhoto() {
        if (photo.length == 0) {
            photo = "no"
        }
    }
}