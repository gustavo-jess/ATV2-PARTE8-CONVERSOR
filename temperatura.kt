package br.unipar.atividade08

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val temperatureInput = findViewById<EditText>(R.id.temperatureInput)
        val conversionRadioGroup = findViewById<RadioGroup>(R.id.conversionRadioGroup)
        val celsiusToFahrenheitRadioButton = findViewById<RadioButton>(R.id.celsiusToFahrenheit)
        val fahrenheitToCelsiusRadioButton = findViewById<RadioButton>(R.id.fahrenheitToCelsius)
        val convertButton = findViewById<Button>(R.id.convertButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        convertButton.setOnClickListener {
            val input = temperatureInput.text.toString()
            if (input.isNotEmpty()) {
                val temperature = input.toDouble()
                val conversionType = conversionRadioGroup.checkedRadioButtonId

                val result = when (conversionType) {
                    R.id.celsiusToFahrenheit -> (temperature * 9 / 5) + 32
                    R.id.fahrenheitToCelsius -> (temperature - 32) * 5 / 9
                    else -> null
                }

                result?.let {
                    resultTextView.text = "Resultado: %.2f".format(it)
                } ?: run {
                    resultTextView.text = "Please select a conversion type."
                }
            } else {
                resultTextView.text = "Please enter a temperature."
            }
        }
    }
}



<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/temperatureInput"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Enter temperature"
        android:inputType="numberDecimal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toTopOf="@id/conversionRadioGroup" />

    <RadioGroup
        android:id="@+id/conversionRadioGroup"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/temperatureInput">

        <RadioButton
            android:id="@+id/celsiusToFahrenheit"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Celsius to Fahrenheit" />

        <RadioButton
            android:id="@+id/fahrenheitToCelsius"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Fahrenheit to Celsius" />
    </RadioGroup>

    <Button
        android:id="@+id/convertButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Convert"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/conversionRadioGroup" />

    <TextView
        android:id="@+id/resultTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Result will be displayed here"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/convertButton" />

</androidx.constraintlayout.widget.ConstraintLayout>
