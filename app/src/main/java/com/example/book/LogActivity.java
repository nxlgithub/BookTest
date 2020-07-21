package com.example.book;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.book.buttomfragment.MineFragment;

public class LogActivity extends AppCompatActivity {
    private Button log_button;
    private EditText user_name;
    private EditText key;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log);
        log_button = (Button)findViewById(R.id.log_button);
        user_name = (EditText)findViewById(R.id.username);
        key = (EditText)findViewById(R.id.key);
        log_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user_name.getText().toString();
                String key_= key.getText().toString();
                if(username.equals("admin") && key_.equals("123456")){
                    Toast.makeText(LogActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("com.example.book.buttomfragment.MineFragment");
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LogActivity.this,"用户名或密码错误，请重新输入",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
