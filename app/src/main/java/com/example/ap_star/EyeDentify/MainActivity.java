package com.example.ap_star.EyeDentify;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ap_star.EyeDentify.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap mBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.statue);
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        Button btnProcess=(Button)findViewById(R.id.btnProcess);

        imageView.setImageBitmap(mBitmap);



    }
	
	
	protected void onCameraClick(Bundle savedInstanceState) {
			
			
	}

}



