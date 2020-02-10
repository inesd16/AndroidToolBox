package fr.isen.dobosz.androidtoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.request.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_web_service.*

class WebServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_service)

        val userApiUrl = "https://randomuser.me/api/?results=20"
        val queue = Volley.newRequestQueue(this)

        val req = StringRequest(Request.Method.GET, userApiUrl, Response.Listener {

            val gson = Gson()
            val result = gson.fromJson(it, RandomUserResult::class.java)

            userRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            userRecyclerView.adapter = UsersAdapter(result.results!!)

            result.results?.let {
                Log.d("volley", it[0].gender)
            }

        }, Response.ErrorListener {
            Log.d("volley", it.toString())
        })

        queue.add(req)
    }
}