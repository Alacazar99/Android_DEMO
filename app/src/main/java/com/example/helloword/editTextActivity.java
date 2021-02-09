package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class editTextActivity extends AppCompatActivity {

    private Button mBtn3;
    private Button mBtn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        mBtn3 = this.<Button>findViewById(R.id.btn3);
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(editTextActivity.this, "Button3被点击了", Toast.LENGTH_SHORT).show();
            }
        });

        mBtn4 = this.<Button>findViewById(R.id.btn4);
        mBtn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(editTextActivity.this, "Button444被点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
