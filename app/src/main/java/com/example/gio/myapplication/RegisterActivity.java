package com.example.gio.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPassword;
    private TextView tvSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvSubmit = (TextView) findViewById(R.id.tvSubmit);

        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //=========================================================================
                //  save in sharedPreferances
                SharedPreferences sharedpreferences = getSharedPreferences(MyCOnsts.MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(MyCOnsts.NAME, etName.getText().toString());
                editor.putString(MyCOnsts.Password, etPassword.getText().toString());
                editor.commit();
                //=========================================================================

                finish();  // dabruneba wina Activity ze
            }
        });

    }


}
