package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    EditText usernameField, passwordField;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameField = findViewById(R.id.uname);
        passwordField = findViewById(R.id.pwd);
        loginButton = findViewById(R.id.lbtn);

        loginButton.setOnClickListener(v -> {
            String user = usernameField.getText().toString().trim();
            String pass = passwordField.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty()) {
                showToast("Please enter both username and password");
            } else if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
                showToast("Login successful!");
            } else {
                showToast("Invalid credentials");
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
