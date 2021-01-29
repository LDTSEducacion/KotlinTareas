package com.example.miprimeraapp

import android.content.Context
import android.content.SharedPreferences

class Preferences(context:Context) {
    companion object {
        const val PREFS_NAME = "MyDatabase"
        const val TASKS = "tasks_value"
    }

    val prefs:SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

//    fun saveInformation() {
//        prefs.edit().putString(VALUE, "ejempo").apply()
//    }

    fun saveTasks(tasks:List<String>) {
        prefs.edit().putStringSet(TASKS, tasks.toSet()).apply()
    }

    fun getTasks():MutableList<String> {
        return prefs.getStringSet(TASKS, emptySet<String>())?.toMutableList() ?: mutableListOf()
    }
}