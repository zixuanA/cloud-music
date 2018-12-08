package com.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Button button = findViewById(R.id.btn_sign_in_back);
        Toolbar toolbar = findViewById(R.id.tb_in);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextName = findViewById(R.id.edit_name);
                EditText editTextPassword = findViewById(R.id.edit_password);
                String userName = editTextName.getText().toString();
                String passWord = editTextPassword.getText().toString();

                FileInputStream fileInputStream = null;
                BufferedReader bufferedReader = null;
                try {
                    fileInputStream = openFileInput("Data");
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    while(true)
                    {
                        String flag=bufferedReader.readLine();//Read the data

                        if(flag.startsWith(userName))//If there is already Login
                        {
                            userName = flag.replace(userName + " ", "password:");//replace

                            break;
                        }
                        if(flag.equals(null))
                        {
                            break;
                        }
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                    finish();
                }
                finally {
                    try{
                        fileInputStream.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(userName.startsWith("password:")){
                    if(!passWord.equals(userName.replace("password:",""))){
                    Toast.makeText(SignInActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent = new Intent(SignInActivity.this,SongSheetActivity.class);
                        startActivity(intent);
                        }
                    }
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.toolbar,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.backup:
//                Intent intent = new Intent(SignInActivity.this,MainActivity.class);
//                startActivity(intent);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
