package com.example.gio.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity4 extends AppCompatActivity {
//
    private ImageView ivLogo;
    private EditText etName;
    private EditText etPassword;
    private TextView tvRegister;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main24);

        ivLogo = (ImageView) findViewById(R.id.ivLogo);

        // igivea ro onclick gavuwerot layoutShi
        ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  trialis animacia         . romelic res>>anim   foldershia
                Animation animation = AnimationUtils.loadAnimation(Main2Activity4.this, R.anim.rotate);
                ivLogo.startAnimation(animation);
            }
        });

        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //=========================================================================
                // get data from sharedPreferance
                SharedPreferences prefs = getSharedPreferences(MyCOnsts.MyPREFERENCES, MODE_PRIVATE);
                String name = prefs.getString(MyCOnsts.NAME, "No name defined");//"No name defined" is the default value.  ||  MyCOnsts is Class For Final Variables
                String passord = prefs.getString(MyCOnsts.Password, "No name defined");//"No name defined" is the default value.
                //=========================================================================

                if(name.equals(etName.getText().toString() ) && passord.equals(etPassword.getText().toString())) {
                    Intent intent = new Intent(Main2Activity4.this, HomeActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Main2Activity4.this, "Not Registered", Toast.LENGTH_SHORT).show();
                }

            }
        });
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main2Activity4.this, RegisterActivity.class));
            }
        });
    }




}
