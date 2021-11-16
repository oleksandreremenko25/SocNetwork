package com.example.socnetwork

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.socnetwork.UserData

class UserViewModel : ViewModel() {
    private val _allUserList = MutableLiveData<List<User>>()
    val allUserList: LiveData<List<User>> = _allUserList

    init {
        _allUserList.value = UserData().usersList
    }
}