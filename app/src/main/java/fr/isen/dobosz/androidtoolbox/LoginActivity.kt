package fr.isen.dobosz.androidtoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var goodIdentifier = "admin"
    var goodPassword = "123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var sLog = getBaseContext().getSharedPreferences("LOG", MODE_PRIVATE);
        if(sLog.contains("login") && sLog.contains("passw")){
            if(goodIdentifier == sLog.getString("login", null) && goodPassword == sLog.getString("passw", null));
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        fun SaveData() {
            var sharedLog = getBaseContext().getSharedPreferences("LOG", MODE_PRIVATE);
            sharedLog
                .edit()
                .putString("login", userNameField.text.toString())
                .putString("passw", passwField.text.toString())
                .apply();
        }
        fun canLog(identifier:String, password:String):Boolean{
            return (identifier == goodIdentifier && password == goodPassword)

        }
        fun doLogin(){
            if (canLog(userNameField.text.toString(),passwField.text.toString())){
                Toast.makeText(this, "Hello ${userNameField.text}, you connected successfully", Toast.LENGTH_LONG).show()
                val intent = Intent(this,HomeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                SaveData()
            }
        }
        saveButton.setOnClickListener{
            if(passwField.getText().toString() == "" || userNameField.getText().toString() == ""){
                infoText.setText("Please fill all fields")
            } else {
                infoText.setText("")
                doLogin()
            }
        }
    }
}
