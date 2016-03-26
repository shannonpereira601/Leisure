package com.example.admin.leisure;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    String emailtext;
    EditText email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView signup = (TextView) findViewById(R.id.signup);

        email = (EditText) findViewById(R.id.e1);
        pass = (EditText) findViewById(R.id.e2);

        Button button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailtext = email.getText().toString();
                final String password = pass.getText().toString();
                if (emailtext.length() == 0) {
                    email.setError("Enter an Email Bro");
                }
                if (!isValidEmail(emailtext) && emailtext.length() != 0) {
                    email.setError("Invalid Email Bro");
                }

                if (password.length() == 0) {
                    pass.setError("Enter a Password Bro");

                }
                if (password.length() > 12) {
                    pass.setError("Password should be lesser than 12 characters");

                }

               // if (isValidEmail(emailtext) && (password.length() != 0 && password.length() < 13)) {
                    Intent intent = new Intent(Login.this,Leisure.class);
                    startActivity(intent);
                //}


            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Signup.class);
                startActivity(intent);
            }
        });
        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        usernameWrapper.setHint("EmailId");
        passwordWrapper.setHint("Password");


    }
    private boolean isValidEmail(String emailtext) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(emailtext);
        return matcher.matches();
    }
}
