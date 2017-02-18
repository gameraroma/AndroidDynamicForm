package com.example.game.androiddynamicsform

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.example.game.androiddynamicsform.R.id.*
import java.util.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 1

        val formData: LinkedHashMap<Int, String> = linkedMapOf()

        addButton.setOnClickListener {
            val formLayout = LinearLayout(this)

            // initial value
            val textView1 = TextView(this)
            textView1.text = "hello world $count"

            // for identify this view
            val viewValue = TextView(this)
            viewValue.text = count.toString()

            formData[count] = textView1.text.toString()

            count += 1

            println(formData)

            val editButton = Button(this)
            editButton.text = "Edit"

            val editTextView = EditText(this)
            editTextView.setText(textView1.text.toString())
            editTextView.visibility = View.GONE

            val doneButton = Button(this)
            doneButton.text = "Done"
            doneButton.visibility = View.GONE

            val deleteButton = Button(this)
            deleteButton.text = "Delete"
            deleteButton.visibility = View.GONE

            formLayout.addView(textView1)
            formLayout.addView(editButton)
            formLayout.addView(editTextView)
            formLayout.addView(doneButton)
            formLayout.addView(deleteButton)

            activity_main.addView(formLayout)

            editButton.setOnClickListener {
                textView1.visibility = View.GONE
                editButton.visibility = View.GONE
                editTextView.visibility = View.VISIBLE
                doneButton.visibility = View.VISIBLE
                deleteButton.visibility = View.VISIBLE
            }

            doneButton.setOnClickListener {
                textView1.text = editTextView.text.toString()

                textView1.visibility = View.VISIBLE
                editButton.visibility = View.VISIBLE
                editTextView.visibility = View.GONE
                doneButton.visibility = View.GONE
                deleteButton.visibility = View.GONE

                formData[viewValue.text.toString().toInt()] = textView1.text.toString()

                println(formData)
            }

            deleteButton.setOnClickListener {
                activity_main.removeView(formLayout)

                formData.remove(viewValue.text.toString().toInt())

                println(formData)
            }
        }
    }
}
