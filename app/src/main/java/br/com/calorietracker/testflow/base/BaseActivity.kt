package br.com.calorietracker.testflow.base

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getToolbarTitle(): String

    override fun onStart() {
        super.onStart()
        setToolbarTitle(getToolbarTitle())
//        getUpButton().setOnClickListener {
//            finish()
//        }
    }

//    private fun getUpButton(): ImageView = findViewById(R.id.btnToolbarBack)
//    private fun getToolbar(): TextView = findViewById(R.id.toolbarTitle)

    fun hideUpButton() {
       // getUpButton().setGone()
    }

    private fun setToolbarTitle(toolbarTitle: String) {
        //getToolbar().text = toolbarTitle
    }
}