package fr.isen.dobosz.androidtoolbox

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_save.*
import org.json.JSONObject;
import java.io.File
import java.util.*
import java.text.SimpleDateFormat


class SaveActivity : AppCompatActivity() {

    companion object{
        var kfirstName = "fName"
        var kName = "Name"
        var kBirth = "Birth"
        var kFileName = "data.json"
        var date = Date()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)


        dateField.setOnFocusChangeListener { view, hasFocus ->
            if(hasFocus) {
                dateField.clearFocus()
                val dialog = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                        onDateChoose(year, month, dayOfMonth)
                    },
                    1997,
                    11,
                    16)
                dialog.show()
            }
        }
        pictureButton.setOnClickListener{
            read()
        }
        register.setOnClickListener{
            save()
        }
    }
    fun save(){ //write in the save file
        if(fNameField.text.toString().isNotEmpty() &&
            nameField.text.toString().isNotEmpty() &&
            dateField.text.toString().isNotEmpty()){
            Toast.makeText(this,R.string.register, Toast.LENGTH_LONG).show()
            val jsonObj =  JSONObject();
            jsonObj.put(kfirstName, fNameField.text.toString())
            jsonObj.put(kName, nameField.text.toString())
            jsonObj.put(kBirth, dateField.text.toString())
            val file = File(cacheDir.absolutePath+"/"+SaveActivity.kFileName)
            file.writeText(jsonObj.toString())
        }
        else
            Toast.makeText(this,R.string.fields_empty, Toast.LENGTH_LONG).show()
    }
    fun read(){
        val file = File(cacheDir.absolutePath+"/"+SaveActivity.kFileName)
        val readString = file.readText()
        val jsonObj = JSONObject(readString)
        val dateString = jsonObj.getString(SaveActivity.kBirth)
        val components = dateString.split("/")
        Toast.makeText(this,jsonObj.getString(SaveActivity.kBirth), Toast.LENGTH_LONG).show()
        var age = getAge(components[2].toInt(), components[1].toInt(), components[0].toInt())
        field_age.setText("Vous avez ${age} ans")
        //Toast.makeText(this,"vous avez ${age} ans", Toast.LENGTH_LONG).show()


    }

    fun onDateChoose(year: Int, month: Int, day: Int) {
        dateField.setText(String.format("%02d/%02d/%04d",day,month+1,year))
        Toast.makeText(this,
            "date : ${dateField.text.toString()}",
            Toast.LENGTH_LONG).show()
    }

   /* fun currentDate(): List<String> {
        var date = Date()
        val pattern = "yyyy/MM/dd"
        val simpleDateFormat = SimpleDateFormat(pattern)
        System.out.println(simpleDateFormat)
        val dateFormated = simpleDateFormat.format(Date())
        val dateString = dateFormated.toString()
        var dateArray = dateString.split("/")
        System.out.println(dateString)
        return (dateArray)
    } */

    fun getAge(year: Int, month: Int, day: Int): Int {
        var currentDate = Date()
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        val dateString = formatter.format(currentDate)
        val components = dateString.split("/")

        var age = components[2].toInt() - year
        if(components[1].toInt() < month) {
            age--
        } else if (components[1].toInt() == month &&
            components[0].toInt() < day){
            age --
        }
        System.out.println("TU AS "+age)
       // field_age.setText("Vous avez ${getAge(components[2].toInt(), components[1].toInt(), components[0].toInt())} ans")
        return age
    }
}
