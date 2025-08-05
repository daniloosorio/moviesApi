package com.example.moviesapi.data

sealed class Status<out T> {
    class Done<out T>(val data : T) : Status<T>()
    class Loading() : Status<Nothing>()
    class Error(val messageError:String ) : Status<Nothing>()
}