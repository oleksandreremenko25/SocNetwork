package com.example.socnetwork

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.socnetwork.UserData

class UserViewModel : ViewModel() {
    private var usersList = listOf(
        UserData("Sasha", "sasha@gmail.com", "нічого", "yesterday", "photo1"),
        UserData("Inna", "inna@gmail.com", "читання книги", "two day ago", "photo4"),
        UserData("Oleg", "oleg@gmail.com", "вивчання психології", "five minutes ago", "photo2"),
        UserData("Andriy", "andriy@gmail.com", "прогулянки з друзями", "six minutes ago", "photo3"),
        UserData("Ivan", "ivan@gmail.com", "прогулянки лісом", "five minutes ago", "photo5"),
        UserData("Vasil", "vasil@gmail.com", "садівництво", "five minutes ago", "photo"),
        UserData("Mykola", "mykola@gmail.com", "читання книг", "five minutes ago", ""),
    )

    private val _allUserList = MutableLiveData<List<UserData>>()
    val allUserList: LiveData<List<UserData>> = _allUserList

    init {
        _allUserList.value = usersList
    }
}