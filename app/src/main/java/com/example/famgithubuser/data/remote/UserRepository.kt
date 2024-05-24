package com.example.famgithubuser.data.remote

import android.util.Log
import com.example.famgithubuser.config.ApiService
import com.example.famgithubuser.config.BuildConfig
import com.example.famgithubuser.model.response.UserModel
import com.example.famgithubuser.model.StatusProgress
import com.example.famgithubuser.model.response.DetailUserResponseModel
import com.example.famgithubuser.model.response.ListFollowersUserResponseModel
import com.example.famgithubuser.model.response.ListFollowingUserResponseModel
import com.example.famgithubuser.model.response.SearchUserResponseModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val apiService: ApiService,
//    private val userDao: UserDao,
//    private val preferences: AppPreferences
) {

    /**
     * Search GitHub user with API
     *
     * @param q GitHub username query
     * @return LiveData<StatusProgress<ArrayList<SimpleUser>>>
     */
    fun searchUserByUsername(q: String): Flow<StatusProgress<ArrayList<UserModel>>> = flow {
        emit(StatusProgress.Loading)
        try {
            val users = apiService.searchUsername(token = API_TOKEN, q).items
            emit(StatusProgress.Success(users))
        } catch (e: Exception) {
            Log.d(TAG, "searchUserByUsername: ${e.message.toString()}")
            emit(StatusProgress.Error(e.message.toString()))
        }
    }

    /**
     *  Get following information of an user from API
     *
     *  @param id GitHub username
     *  @return Flow<StatusProgress<ArrayList<SimpleUser>>>
     */
    fun getUserFollowing(id: String): Flow<StatusProgress<ArrayList<ListFollowingUserResponseModel>>> = flow {
        emit(StatusProgress.Loading)
        try {
            val users = apiService.getUserFollowing(token = API_TOKEN, id)
            emit(StatusProgress.Success(users))
        } catch (e: Exception) {
            Log.d(TAG, "getUserFollowing: ${e.message.toString()}")
            emit(StatusProgress.Error(e.message.toString()))
        }
    }

    /**
     *  Get followers information of an user from API
     *
     *  @param id GitHub username
     *  @return Flow<StatusProgress<ArrayList<SimpleUser>>>
     */
    fun getUserFollowers(id: String): Flow<StatusProgress<ArrayList<ListFollowersUserResponseModel>>> = flow {
        emit(StatusProgress.Loading)
        try {
            val users = apiService.getUserFollowers(token = API_TOKEN, id)
            emit(StatusProgress.Success(users))
        } catch (e: Exception) {
            Log.d(TAG, "getUserFollowers: ${e.message.toString()}")
            emit(StatusProgress.Error(e.message.toString()))
        }
    }

    /**
     *  Get user detail information from API
     *
     *  @param id GitHub username
     *  @return LiveData<StatusProgress<User>>
     */
    fun getUserDetail(id: String): Flow<StatusProgress<DetailUserResponseModel>> = flow {
        emit(StatusProgress.Loading)
        try {
            val user = apiService.getUserDetail(token = API_TOKEN, id)
            emit(StatusProgress.Success(user))
        } catch (e: Exception) {
            Log.d(TAG, "getUserDetail: ${e.message.toString()}")
            emit(StatusProgress.Error(e.message.toString()))
        }
    }

//    /**
//     * Determine this user is favorite or not
//     *
//     * @param id User id
//     * @return Flow<Boolean>
//     */
//    fun isFavoriteUser(id: String): Flow<Boolean> = userDao.isFavoriteUser(id)
//
//    /**
//     * Get all favorite users from database
//     *
//     * @return LiveData<List<UserEntity>>
//     */
//    fun getAllFavoriteUsers(): Flow<List<UserEntity>> = userDao.getAllUsers()
//
//    /**
//     * Delete a favorite user from database
//     *
//     * @param user User to delete
//     */
//    suspend fun deleteFromFavorite(user: UserEntity) {
//        userDao.delete(user)
//    }
//
//    /**
//     * Save user as favorite to database
//     *
//     * @param user User to save
//     */
//    suspend fun saveUserAsFavorite(user: UserEntity) {
//        userDao.insert(user)
//    }
//
//    /**
//     * Get theme setting for dark mode state from DataStore
//     *
//     * @return Flow<Boolean>
//     */
//    fun getThemeSetting(): Flow<Boolean> = preferences.getThemeSetting()
//
//    /**
//     * Save theme setting for dark mode state to DataStore
//     *
//     * @param isDarkModeActive Dark mode state to save
//     */
//    suspend fun saveThemeSetting(isDarkModeActive: Boolean) {
//        preferences.saveThemeSetting(isDarkModeActive)
//    }

    companion object {
        private const val API_TOKEN = "Bearer ${BuildConfig.API_KEY}"
        private val TAG = UserRepository::class.java.simpleName
    }
}