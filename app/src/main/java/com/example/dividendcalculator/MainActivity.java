package com.example.dividendcalculator; // Make sure this matches your package name!

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etAmount, etRate, etMonths;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind UI components
        etAmount = findViewById(R.id.etAmount);
        etRate = findViewById(R.id.etRate);
        etMonths = findViewById(R.id.etMonths);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        // Calculation Logic
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amountStr = etAmount.getText().toString();
                String rateStr = etRate.getText().toString();
                String monthsStr = etMonths.getText().toString();

                // Check for empty inputs
                if (amountStr.isEmpty() || rateStr.isEmpty() || monthsStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                double amount = Double.parseDouble(amountStr);
                double rate = Double.parseDouble(rateStr);
                int months = Integer.parseInt(monthsStr);

                // Requirement: Max 12 months validation
                if (months > 12 || months < 1) {
                    Toast.makeText(MainActivity.this, "Months must be between 1 and 12", Toast.LENGTH_SHORT).show();
                } else {
                    // Formula: Monthly Dividend = (Rate / 12) * Invested Fund
                    // Note: Rate is percentage, so divide by 100
                    double monthlyDividend = ((rate / 100) / 12) * amount;

                    // Formula: Total Dividend = Monthly Dividend * Months
                    double totalDividend = monthlyDividend * months;

                    // Output formatted to 2 decimals
                    String resultText = String.format("Monthly Dividend: RM %.2f\nTotal Dividend: RM %.2f",
                            monthlyDividend, totalDividend);
                    tvResult.setText(resultText);
                }
            }
        });
    }

    // Navigation Menu Setup
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}