package com.akashevpavel.android_fundamentals_lesson_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity() {
    private val TAG = SecondActivity::class.java.simpleName

    private lateinit var mEditTextSecond: TextView
    private lateinit var mRequestHeader: TextView
    private lateinit var mRequestBody: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        mEditTextSecond = findViewById(R.id.editText_second)
        mRequestHeader = findViewById(R.id.text_header)
        mRequestBody = findViewById(R.id.text_message)

        mRequestBody.text = intent.getStringExtra(EXTRA_MESSAGE)

        Log.d(TAG, "onCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    fun returnReply(view: View) {
        setResult(RESULT_OK, Intent(applicationContext, MainActivity::class.java).putExtra(EXTRA_REPLY, mEditTextSecond.text.toString()))
        Log.d(TAG, "End SecondActivity")
        finish()
    }
}