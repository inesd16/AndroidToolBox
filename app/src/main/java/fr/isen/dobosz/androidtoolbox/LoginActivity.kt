package fr.isen.dobosz.androidtoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var goodIdentifier = "admin"
    var goodPassword = "123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        fun canLog(identifier:String, password:String):Boolean{
            return (identifier == goodIdentifier && password == goodPassword)

        }
        fun doLogin(){
            if (canLog(editText3.text.toString(),editText.text.toString())){
                Toast.makeText(this,"Coucou", Toast.LENGTH_LONG).show()
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
            }
        }
        button2.setOnClickListener{
            doLogin()
            Toast.makeText(this,"Coucou ${editText3.text}", Toast.LENGTH_LONG).show()
        }

    }
}
