package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.helloword.customFunc.ImageViewRoundCystom;

public class ImageViewActivity extends AppCompatActivity {


    // 导入自定义的ImageView；
    private ImageViewRoundCystom mImage3;
    private ImageViewRoundCystom mImage4;
    private ImageViewRoundCystom mImage5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        initViews();
    }
    /**
     * 初始化Views
     */



    @SuppressLint("WrongViewCast")
    private void initViews(){
//        mImage3 = (ImageViewRoundCystom) findViewById(R.id.image3);
        mImage4 = (ImageViewRoundCystom) findViewById(R.id.image4);
        mImage5 = (ImageViewRoundCystom) findViewById(R.id.image5);


        mImage4.setType(ImageViewRoundCystom.TYPE_ROUND);
        mImage4.setRoundRadius(6);//矩形凹行 半径大小

        mImage5.setType(ImageViewRoundCystom.TYPE_OVAL);
        mImage5.setRoundRadius(45);//圆角大小
    }


}
