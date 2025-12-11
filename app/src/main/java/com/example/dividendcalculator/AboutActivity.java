package com.example.dividendcalculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Set the title and enable the Back arrow
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("About");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // Handle the GitHub link click
        TextView tvGithub = findViewById(R.id.tvGithub);
        tvGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // REPLACE THIS URL with your actual GitHub link later
                String url = "https://github.com/YourUsername/DividendCalculator";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    // Handle the Back Arrow button click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Close this activity and go back
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}