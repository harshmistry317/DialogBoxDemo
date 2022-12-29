package com.harsh_mistry.dialogbox

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custome_dialog_layput.*
import java.util.Calendar

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
        val c = Calendar.getInstance()
        val year =  c.get(Calendar.YEAR)
        val month =  c.get(Calendar.MONTH)
        val day =  c.get(Calendar.DAY_OF_MONTH)

        btn_date.setOnClickListener {

            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                txt_date.setText(""+mDay+"/"+mMonth+"/"+mYear)
            },year,month,day)
            dpd.show()
        }
        val starttime = c.get(Calendar.HOUR_OF_DAY)
        val startminut =  c.get(Calendar.MINUTE)
        btn_time.setOnClickListener {
           val tpd = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener { view, hourofday, minut ->
               txt_time.setText("${hourofday}:${minut}")
           }, starttime,startminut,false)

            tpd.show()

        }


        btn_cutom.setOnClickListener {

            var dialog =  Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.custome_dialog_layput)
            dialog.setCancelable(false)

            dialog.show()

            dialog.btn_cust_sub.setOnClickListener {
                dialog.dismiss()
                val name =  dialog.et_custom_dialog.text.toString()
                Toast.makeText(applicationContext, "Heloo $name",Toast.LENGTH_LONG).show()
            }




        }

    }
}