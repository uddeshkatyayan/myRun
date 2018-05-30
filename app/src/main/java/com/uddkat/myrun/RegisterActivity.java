package com.uddkat.myrun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button reg;
    private EditText etEmail,etPass;
    private TextView tvLogin;
    private DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        reg=(Button)findViewById(R.id.btnReg);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPass=(EditText)findViewById(R.id.etPass);
        tvLogin=(TextView)findViewById(R.id.tvLogin);
        reg.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
        db=new DbHelper(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnReg:
                register();
                break;
            case R.id.tvLogin:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
                break;
                default:

        }
    }
    public void register()
    {
        String email=etEmail.getText().toString();
        String pass=etPass.getText().toString();
        if (email.isEmpty() && pass.isEmpty())
        {
            displayToast("Username/Password field cannot be empty");
        }
        else
        {
            db.addUser(email,pass);
            displayToast("User Registered");
            finish();
        }
    }
    private void displayToast(String s)
    {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
    }
}
