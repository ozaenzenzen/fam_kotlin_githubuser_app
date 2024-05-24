package com.example.famgithubuser.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.famgithubuser.data.remote.UserRepository
import com.example.famgithubuser.model.response.UserModel
import com.example.famgithubuser.model.StatusProgress
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

//    val themeSetting: Flow<Boolean> = repository.getThemeSetting()

    private val _users = MutableStateFlow<StatusProgress<ArrayList<UserModel>>>(StatusProgress.Loading)
    val users = _users.asStateFlow()

    init {
        searchUserByUsername("\"\"")
    }

    /**
     * Search GitHub user
     *
     * @param query GitHub username
     * @return LiveData<Result<ArrayList<SimpleUser>
     */
    fun searchUserByUsername(query: String) {
        _users.value = StatusProgress.Loading
        viewModelScope.launch {
            repository.searchUserByUsername(query).collect {
                _users.value = it
            }
        }
    }
}