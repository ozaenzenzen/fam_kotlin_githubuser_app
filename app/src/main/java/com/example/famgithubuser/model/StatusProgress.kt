package com.example.famgithubuser.model
sealed class StatusProgress<out R> private constructor() {
    data class Success<out T>(val data: T) : StatusProgress<T>()
    data class Error(val error: String) : StatusProgress<Nothing>()
    object Loading : StatusProgress<Nothing>()
}
