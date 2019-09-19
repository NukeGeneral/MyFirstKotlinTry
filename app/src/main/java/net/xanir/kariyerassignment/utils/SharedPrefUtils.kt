package net.xanir.kariyerassignment.utils

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import net.xanir.kariyerassignment.MyApp
import net.xanir.kariyerassignment.restApi.APIClient
import java.lang.Exception
import java.lang.RuntimeException


/**
 * Created by Umur Kaya on 20-Sep-19.
 */

class SharedPrefUtils
/**
 * Creates instance of SharedPrefUtils that contains permanent(Not-cleanable) and temporary(Cleanable) shared preferences
 */
private constructor() {
    private val tempPreferences: SharedPreferences
    private val permaPreferences: SharedPreferences
    private var instancePreferenceMode: PreferenceMode? = null
    private val gson: Gson

    enum class PreferenceMode {
        /**
         * Temporary means it will reset on every logout or every time requested
         */
        TEMPORARY,

        /**
         * Permanent means it cannot be resetted
         */
        PERMANENT
    }

    init {
        tempPreferences = MyApp.instance.getSharedPreferences(MyApp.instance.packageName + "TempPrefs", Context.MODE_PRIVATE)
        permaPreferences = MyApp.instance.getSharedPreferences(MyApp.instance.packageName + "PermPrefs", Context.MODE_PRIVATE)
        gson = APIClient.getGson()
    }

    fun loadBoolean(key: SharedPrefKeys): Boolean {
        return if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.getBoolean(key.value, false)
        } else {
            tempPreferences.getBoolean(key.value, false)
        }

    }

    fun loadBoolean(key: String): Boolean {
        return if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.getBoolean(key, false)
        } else {
            tempPreferences.getBoolean(key, false)
        }

    }

    fun loadBoolean(key: SharedPrefKeys, defValue: Boolean): Boolean {
        return if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.getBoolean(key.value, defValue)
        } else {
            tempPreferences.getBoolean(key.value, defValue)
        }

    }

    fun loadBoolean(key: String, defValue: Boolean): Boolean {
        return if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.getBoolean(key, defValue)
        } else {
            tempPreferences.getBoolean(key, defValue)
        }

    }

    fun loadString(key: SharedPrefKeys): String? {
        return if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.getString(key.value, null)
        } else {
            tempPreferences.getString(key.value, null)
        }

    }

    fun loadString(key: String): String? {
        return if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.getString(key, null)
        } else {
            tempPreferences.getString(key, null)
        }

    }

    fun loadString(key: SharedPrefKeys, defValue: String?): String? {
        return if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.getString(key.value, defValue)
        } else {
            tempPreferences.getString(key.value, defValue)
        }

    }

    fun loadString(key: String, defValue: String?): String? {
        return if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.getString(key, defValue)
        } else {
            tempPreferences.getString(key, defValue)
        }

    }

    fun loadInt(key: SharedPrefKeys): Int {
        return if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.getInt(key.value, 0)
        } else {
            tempPreferences.getInt(key.value, 0)
        }

    }

    fun loadInt(key: SharedPrefKeys, defValue: Int): Int {
        return if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.getInt(key.value, defValue)
        } else {
            tempPreferences.getInt(key.value, defValue)
        }

    }

    @SuppressLint("ApplySharedPref")
    fun saveInt(key: SharedPrefKeys, value: Int) {
        if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.edit().putInt(key.value, value).commit()
        } else {
            tempPreferences.edit().putInt(key.value, value).commit()
        }

    }

    @SuppressLint("ApplySharedPref")
    fun deleteShared(key: SharedPrefKeys) {
        if (instancePreferenceMode == PreferenceMode.TEMPORARY) {
            tempPreferences.edit().remove(key.value).commit()
        } else {
            throw RuntimeException("Only temporary preferences allowed to be deleted")
        }
    }

    @SuppressLint("ApplySharedPref")
    fun deleteShared(key: String) {
        if (instancePreferenceMode == PreferenceMode.TEMPORARY) {
            tempPreferences.edit().remove(key).commit()
        } else {
            throw RuntimeException("Only temporary preferences allowed to be deleted")
        }
    }

    @SuppressLint("ApplySharedPref")
    fun saveString(key: SharedPrefKeys, string: String?) {
        if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.edit().putString(key.value, string).commit()
        } else {
            tempPreferences.edit().putString(key.value, string).commit()
        }

    }

    @SuppressLint("ApplySharedPref")
    fun saveString(key: String, string: String?) {
        if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.edit().putString(key, string).commit()
        } else {
            tempPreferences.edit().putString(key, string).commit()
        }

    }

    @SuppressLint("ApplySharedPref")
    fun saveBoolean(key: SharedPrefKeys, bool: Boolean) {
        if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.edit().putBoolean(key.value, bool).commit()
        } else {
            tempPreferences.edit().putBoolean(key.value, bool).commit()
        }
    }

    @SuppressLint("ApplySharedPref")
    fun saveBoolean(key: String, bool: Boolean) {
        if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.edit().putBoolean(key, bool).commit()
        } else {
            tempPreferences.edit().putBoolean(key, bool).commit()
        }
    }

    fun loadLong(key: SharedPrefKeys, defValue: Long): Long {
        return if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.getLong(key.value, defValue)
        } else {
            tempPreferences.getLong(key.value, defValue)
        }

    }

    @SuppressLint("ApplySharedPref")
    fun saveLong(key: SharedPrefKeys, value: Long) {
        if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            permaPreferences.edit().putLong(key.value, value).commit()
        } else {
            tempPreferences.edit().putLong(key.value, value).commit()
        }

    }

    fun <T> loadObject(key: SharedPrefKeys, type: Class<T>): T? {
        val `object`: String?
        if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            `object` = permaPreferences.getString(key.value, null)
        } else {
            `object` = tempPreferences.getString(key.value, null)
        }
        return if (`object` != null) {
            gson.fromJson(`object`, type)
        } else {
            null
        }
    }

    fun <T> loadObject(key: String, type: Class<T>): T? {
        val `object`: String?
        if (instancePreferenceMode == PreferenceMode.PERMANENT) {
            `object` = permaPreferences.getString(key, null)
        } else {
            `object` = tempPreferences.getString(key, null)
        }
        return if (`object` != null) {
            gson.fromJson(`object`, type)
        } else {
            null
        }
    }

    fun saveObject(key: SharedPrefKeys, `object`: Any) {
        try {
            val json = gson.toJson(`object`)
            saveString(key.value, json)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun saveObject(key: String, `object`: Any) {
        try {
            val json = gson.toJson(`object`)
            saveString(key, json)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @SuppressLint("ApplySharedPref")
    fun clearData() {
        if (instancePreferenceMode == PreferenceMode.TEMPORARY) {
            tempPreferences.edit().clear().commit()
        } else {
            throw RuntimeException("Only temporary preferences allowed to be deleted")
        }
    }

    companion object {

        lateinit var sharedPrefUtils: SharedPrefUtils
        @Synchronized
        fun instance(preferenceModes: PreferenceMode): SharedPrefUtils {
            sharedPrefUtils.instancePreferenceMode = preferenceModes
            return sharedPrefUtils
        }
    }
}