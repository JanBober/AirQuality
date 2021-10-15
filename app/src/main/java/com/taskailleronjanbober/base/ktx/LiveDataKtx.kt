package com.taskailleronjanbober.base.ktx

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.default(value: T): MutableLiveData<T> = this.also { this.value = value }
fun <T> mutableLiveData(initialValue: T): MutableLiveData<T> =
    MutableLiveData<T>().default(initialValue)