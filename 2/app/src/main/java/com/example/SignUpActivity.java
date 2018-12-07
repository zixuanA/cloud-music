package com.example;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SignUpActivity extends AppCompatActivity {
    //public int a=0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = findViewById(R.id.tb_up);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button button = findViewById(R.id.btn_sign_up_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextName = findViewById(R.id.edt_name);
                EditText editTextPassword = findViewById(R.id.edt_password);
                String userName = editTextName.getText().toString();
                String passWord = editTextPassword.getText().toString();
                String _userName =userName;
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
                if(userName.length()==11 && userName==_userName)//No Login
                {
                    FileOutputStream fileOutputStream = null;
                    BufferedWriter bufferedWriter = null;
                    try {
                        fileOutputStream = openFileOutput("Data",Context.MODE_APPEND);
                        bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                        bufferedWriter.write(userName+" "+passWord);

                        bufferedWriter.newLine();
                        Toast.makeText(SignUpActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {
                        try{
                            if(bufferedWriter!=null)
                                bufferedWriter.close();
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
                else{
                    if(_userName.length()<11)
                        Toast.makeText(SignUpActivity.this,"您输入的电话号码不足十一位",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(SignUpActivity.this,"你的电话已经注册",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

}
