package com.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String userName = null;
    String userPassword = null;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonSignin = findViewById(R.id.btn_sign_in);
        Button buttonSignup = findViewById(R.id.btn_sign_up);
        ImageView imageViewQq = findViewById(R.id.img_qq);
        ImageView imageViewWx = findViewById(R.id.img_wx);
        ImageView imageViewWb = findViewById(R.id.img_wb);
        ImageView imageViewWy = findViewById(R.id.img_wy);
        imageViewQq.setOnClickListener(this);
        imageViewWx.setOnClickListener(this);
        imageViewWb.setOnClickListener(this);
        imageViewWy.setOnClickListener(this);
        buttonSignin.setOnClickListener(this);
        buttonSignup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sign_in:
                Intent intentIn = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(intentIn);
                break;
            case R.id.btn_sign_up:
                Intent intentUp = new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intentUp);
                break;
            case R.id.img_qq:
                Toast.makeText(MainActivity.this,"装做有界面的样子",Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_wx:
                Toast.makeText(MainActivity.this,"装做有界面的样子",Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_wb:
                Toast.makeText(MainActivity.this,"装做有界面的样子",Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_wy:
                Toast.makeText(MainActivity.this,"装做有界面的样子",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
