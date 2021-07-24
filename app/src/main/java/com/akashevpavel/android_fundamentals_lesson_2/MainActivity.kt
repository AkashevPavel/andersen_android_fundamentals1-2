package com.akashevpavel.android_fundamentals_lesson_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

const val EXTRA_MESSAGE = "111"
const val EXTRA_REPLY = "222"
const val REQUEST_CODE = 1

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    private lateinit var mEditTextMain: TextView
    private lateinit var mReplyHeader: TextView
    private lateinit var mReplyBody: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditTextMain = findViewById(R.id.editText_main)
        mReplyHeader = findViewById(R.id.text_header_reply)
        mReplyBody = findViewById(R.id.text_message_reply)



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

    fun launchSecondActivity(view: View) {
        Log.d(TAG, "Button clicked!")
        startActivityForResult(Intent(applicationContext, SecondActivity::class.java).putExtra(EXTRA_MESSAGE, mEditTextMain.text.toString()), REQUEST_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            mReplyHeader.visibility = View.VISIBLE
            mReplyBody.visibility = View.VISIBLE
            mReplyBody.text = data?.getStringExtra(EXTRA_REPLY)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(mReplyHeader.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", mReplyBody.text.toString())
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.getBoolean("reply_visible")) {
            mReplyHeader.visibility = View.VISIBLE
            mReplyBody.visibility = View.VISIBLE
            mReplyBody.text = savedInstanceState.getString("reply_text")
        }
    }
}