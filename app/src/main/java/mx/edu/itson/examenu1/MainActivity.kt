package mx.edu.itson.examenu1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Variables UI
        val etCel = findViewById<EditText>(R.id.etC)
        val etFan = findViewById<EditText>(R.id.etF)
        val etKel = findViewById<EditText>(R.id.etK)

        // Buttons
        val btnCalculateC = findViewById<Button>(R.id.btnGC)
        val btnCalculateF = findViewById<Button>(R.id.btnGF)
        val btnCalculateK = findViewById<Button>(R.id.btnGK)

        btnCalculateC.setOnClickListener {
            val f = etFan.text.toString().toDoubleOrNull()
            val k = etKel.text.toString().toDoubleOrNull()

            if (f != null) {
                val res = (f - 32) / 1.8
                etCel.setText(String.format("%.2f", res))
            } else if (k != null) {
                val res = k - 273.15
                etCel.setText(String.format("%.2f", res))
            }
        }

        btnCalculateF.setOnClickListener {
            val c = etCel.text.toString().toDoubleOrNull()
            val k = etKel.text.toString().toDoubleOrNull()

            if (c != null) {
                val res = (c * 1.8) + 32
                etFan.setText(String.format("%.2f", res))
            } else if (k != null) {
                val res = ((9 * (k - 273.15)) / 5) + 32
                etFan.setText(String.format("%.2f", res))
            }
        }

        btnCalculateK.setOnClickListener {
            val c = etCel.text.toString().toDoubleOrNull()
            val f = etFan.text.toString().toDoubleOrNull()

            if (c != null) {
                val res = c + 273.15
                etKel.setText(String.format("%.2f", res))
            } else if (f != null) {
                val res = ((5 * (f - 32)) / 9) + 273.15
                etKel.setText(String.format("%.2f", res))
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}