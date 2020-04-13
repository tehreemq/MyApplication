package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Context ctx= MainActivity.this;
    Button btnLogin;
    EditText etEmail, etPass;
    SharedPreferences pref;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        cb = (CheckBox) findViewById(R.id.cb);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, SharedPrefActivity.class);
                intent.putExtra("keyEmail",etEmail.getText().toString());
                startActivity(intent);

                finish();
            }
        });

        pref = getSharedPreferences("LoginPref",MODE_PRIVATE);
        boolean cbValue = pref.getBoolean("cb",false);

        if(cbValue)
        {
            String email = pref.getString("email","");
            String pass = pref.getString("pass","");

            etEmail.setText(email);
            etPass.setText(pass);

            cb.setChecked(true);


        }
        else
            cb.setChecked(false);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    SharedPreferences.Editor editor = getSharedPreferences("LoginPref", MODE_PRIVATE).edit();
                    editor.putString("email", etEmail.getText().toString());
                    editor.putString("pass", etPass.getText().toString());
                    editor.putBoolean("cb", true);
                    editor.commit();
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("LoginPref", MODE_PRIVATE).edit();
                    editor.putString("email", "");
                    editor.putString("pass", "");
                    editor.putBoolean("cb", false);
                    editor.commit();

                }
            }
        });


    }
}
