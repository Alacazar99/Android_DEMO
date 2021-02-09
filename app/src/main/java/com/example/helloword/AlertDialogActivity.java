package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helloword.util.ToastUtil;

public class AlertDialogActivity extends AppCompatActivity {

    private Button mstyle1,mstyle2,mstyle3,mstyle4,mstyle5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        mstyle1 = findViewById(R.id.btn_dialog1);
        mstyle2 = findViewById(R.id.btn_dialog2);
        mstyle3 = findViewById(R.id.btn_dialog3);
        mstyle4 = findViewById(R.id.btn_dialog4);
        mstyle5 = findViewById(R.id.btn_dialog5);
        OnClick onClick = new OnClick();
        mstyle1.setOnClickListener(onClick);
        mstyle2.setOnClickListener(onClick);
        mstyle3.setOnClickListener(onClick);
        mstyle4.setOnClickListener(onClick);
        mstyle5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{
        public void onClick(View v){
            switch (v.getId()){
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder1.setTitle("【提问】").setMessage("你认为黄世祥帅么？").setIcon(R.drawable.my_image).
                            setPositiveButton("很帅！", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(AlertDialogActivity.this, "诚实Boy", Toast.LENGTH_SHORT).show();
                        }
                    }).setNeutralButton("还行吧...", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(AlertDialogActivity.this,"你确定不需要仔细看看么...",Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("不好看呢...", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(AlertDialogActivity.this,"你瞎说...",Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;
                case R.id.btn_dialog2:
                    final String[] array2 = new String[]{"男","女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder2.setTitle("【请选择性别】")
                            .setItems(array2, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(AlertDialogActivity.this,array2[which]);
                                    //Toast.makeText(AlertDialogActivity.this,"btn_dialog2",Toast.LENGTH_SHORT).show();
                                }
                            }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] array3 = new String[]{"男","女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder3.setTitle("【请选择性别】")
                            .setSingleChoiceItems(array3, 1, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // dialog消失；
                                    ToastUtil.showMsg(getApplicationContext(),array3[which]);
                                    //Toast.makeText(AlertDialogActivity.this,"btn_dialog3",Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }
                            }).show();
                    break;
                case R.id.btn_dialog4:
                    final String[]  array4 = new String[]{"A","B","C","D"};
                    final boolean[] isSeleceted = new boolean[]{false,false,true,true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder4.setTitle("【选择兴趣】")
                            .setMultiChoiceItems(array4, isSeleceted, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    ToastUtil.showMsg(AlertDialogActivity.this,array4[which]+":"+isChecked);
                                     //Toast.makeText(AlertDialogActivity.this,"btn_dialog4",Toast.LENGTH_LONG).show();
                                    dialog.dismiss();
                                }
                            }).show();
                    break;
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(AlertDialogActivity.this);
                    View view = LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.layout_dialog_login,null);
                    EditText editusername = view.findViewById(R.id.edit1);
                    EditText editpassword = view.findViewById(R.id.edit2);
                    builder5.setView(view).show();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + v.getId());
            }
        }
    }

}
