package com.example.socnetwork

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.socnetwork.UserData

class UserViewModel : ViewModel() {
    private var usersList = listOf(
        UserData("Sasha", "sasha@gmail.com", "нічого", "yesterday", ""),
        UserData("Inna", "inna@gmail.com", "читання книги", "two day ago", "photo4"),
        UserData("Stefaniya", "stefaniya@gmail.com", "ігри", "five minutes ago", "photo3"),
    )

    private val _allUserList = MutableLiveData<List<UserData>>()
    val allUserList: LiveData<List<UserData>> = _allUserList

    init {
        _allUserList.value = usersList
    }

    fun getUsersList() : List<UserData> {
        return allUserList.value!!
    }
}