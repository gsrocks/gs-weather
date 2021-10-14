package com.gsrocks.gsweather.utils

sealed class DataState<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : DataState<T>(data)
    class Loading<T> : DataState<T>()
    class Failure<T>(message: String?) : DataState<T>(message = message)
}
