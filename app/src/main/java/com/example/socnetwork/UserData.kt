package com.example.socnetwork

data class UserData(private var name: String, private var email: String, private var hobby: String, private var lastOnline: String, private var photo: String) {

    init {
        createPhoto()
    }

    fun getNameUser(): String {
        return name
    }

    fun getEmailUser(): String {
        return email
    }

    fun getHobbyUser(): String {
        return hobby
    }

    fun getLastOnlineUser(): String {
        return lastOnline
    }

    fun getPhotoUser(): String {
        return photo
    }

    fun createPhoto() {
        if (photo.length == 0) {
            photo = "no"
        }
    }
}