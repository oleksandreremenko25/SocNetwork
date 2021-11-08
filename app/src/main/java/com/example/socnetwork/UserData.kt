package com.example.socnetwork

data class UserData(var name: String, var email: String, var hobby: String, var lastOnline: String, var photo: String) {
    init {
        testCreatePhoto()
    }

    fun testCreatePhoto() {
        if (photo.length == 0) {
            photo = "no"
        }
    }

}