package fr.isen.dobosz.androidtoolbox


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        lifeCycleButton.setOnClickListener{
            Toast.makeText(this,"Coucou", Toast.LENGTH_LONG).show()
        val intent = Intent(this,LifeCycle::class.java)
        startActivity(intent)
        }

        disconnection.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            var sharedPref =  this.getSharedPreferences("LOG", MODE_PRIVATE);
            sharedPref
                .edit()
                .clear()
                .apply()
        }
        saveButton.setOnClickListener{
            val intent = Intent(this, SaveActivity::class.java)
            startActivity(intent)
        }
        permissionButton.setOnClickListener{
            val intent = Intent(this, PermissionActivity::class.java)
            startActivity(intent)
        }

        webServiceButton.setOnClickListener {
            startActivity(Intent(this, WebServiceActivity::class.java))
        }


    }
}
