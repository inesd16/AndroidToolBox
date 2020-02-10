package fr.isen.dobosz.androidtoolbox

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_life_cycle.*
import kotlinx.android.synthetic.main.activity_login.*

class LifeCycle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var a = 1
        setContentView(R.layout.activity_life_cycle)
        System.out.println("Activity onCreate")
        actState.setText("string/actOnCreate")
        changeFrag.setOnClickListener {
            var newFragment: Fragment?
            if (a == 1){
                newFragment = Fragment1()
                a = 2;
            } else{
            newFragment = MainFragment()
            a = 1;
        }
            supportFragmentManager.beginTransaction().replace(R.id.fragment, newFragment).commit()
        }
    }
    override fun onStart(){
        super.onStart()
        //actState.setText("@string/actOnStart")
        actState.setText("Actually : Activity onStart")
    }
    override fun onResume(){
        super.onResume()
       // actState.setText("@string/actOnResume")
        actState.setText("Actually : Activity onResume")
    }
    override fun onPause(){
        super.onPause()
       // actState.setText("Activity onPause")
        actState.setText("Actually : Activity onPause")
    }
    override fun onStop(){
        super.onStop()
       // actState.setText("Activity onStop")
        actState.setText("Actually : Activity onStop")
    }
    override fun onDestroy(){
        super.onDestroy()
        Toast.makeText(this,"Activity destroyed", Toast.LENGTH_LONG).show()
      //  actState.setText("Activity onDestroy")
        actState.setText("Actually : Activity onDestroy")
    }
}
