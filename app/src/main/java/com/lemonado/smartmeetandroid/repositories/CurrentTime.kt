package com.lemonado.smartmeetandroid.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.time.LocalDate
import java.util.*

object CurrentTime {

    private val _date = MutableLiveData<Date>().apply {
        value = Date()
    }

    val date: LiveData<Date> = _date

    fun updateDate(date: Date = Date()) = _date.postValue(date)

}