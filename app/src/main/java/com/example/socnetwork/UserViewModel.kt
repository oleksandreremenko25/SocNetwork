package com.example.socnetwork

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.socnetwork.UserData

class UserViewModel : ViewModel() {
    private var _allUserList = MutableLiveData<List<User>>()
    var allUserList: LiveData<List<User>> = _allUserList

    private var _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    init {
        _allUserList.value = UserData().usersList
    }

    fun setUserId(key: Int) {
        _user.value = UserData().usersList[key]
    }
}