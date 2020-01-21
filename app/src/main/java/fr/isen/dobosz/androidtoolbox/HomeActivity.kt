package fr.isen.dobosz.androidtoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_login.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        button1.setOnClickListener{
            Toast.makeText(this,"Coucou", Toast.LENGTH_LONG).show()
        val intent = Intent(this,LifeCycle::class.java)
        startActivity(intent)
        }
    }
}
