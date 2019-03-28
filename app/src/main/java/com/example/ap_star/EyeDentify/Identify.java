package com.example.ap_star.EyeDentify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Identify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify);

        Button bt_cam=(Button)findViewById(R.id.btn_camera);
        Button bt_gal=(Button)findViewById(R.id.btn_gallery);

        bt_cam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent int1=new Intent(Identify.this ,Result.class);
                startActivity(int1);
            }
        });

        bt_gal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent int2=new Intent(Identify.this ,Result.class);
                startActivity(int2);
            }
        });

    }


}
