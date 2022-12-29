package com.harsh_mistry.dialogbox

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_exit.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Exit")
            builder.setMessage("Do you Want to Exit?")
            builder.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int -> finish() }
            builder.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->

            }
            builder.show()
        }

    }
}