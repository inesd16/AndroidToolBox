package fr.isen.dobosz.androidtoolbox

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_life_cycle.*
import kotlinx.android.synthetic.main.activity_login.*

class LifeCycle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        System.out.println("Activity onCreate")

    }
    @SuppressLint("MissingSuperCall")
    override fun onStart(){
        System.out.println("Activity onStart")
        actState.setText("Activity onStart")

    }
    @SuppressLint("MissingSuperCall")
    override fun onResume(){
        System.out.println("Activity onResume")
        actState.setText("Activity onResume")

    }
    @SuppressLint("MissingSuperCall")
    override fun onPause(){
        System.out.println("Activity onPause")
        actState.setText("Activity onPause")


    }
    @SuppressLint("MissingSuperCall")
    override fun onStop(){
        System.out.println("Activity onStop")
        actState.setText("Activity onStop")


    }
    @SuppressLint("MissingSuperCall")
    override fun onDestroy(){
        System.out.println("Activity onDestroy")
        actState.setText("Activity onDestroy")


    }
}
