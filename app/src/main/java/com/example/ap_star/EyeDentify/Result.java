package com.example.ap_star.EyeDentify;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Result extends AppCompatActivity {

   // private static final int PICK_IMAGE=100;
   // Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

       // ImageView resultImage=(ImageView)findViewById(R.id.resultImage);

        Uri myUri = Uri.parse(getIntent().getStringExtra("imageUri"));
        ImageView resultImage=(ImageView)findViewById(R.id.resultImage);
        resultImage.setImageURI(myUri);

        /*
        Intent getImage =new Intent(this,Identify.class);
        Uri imageUri=getImage.getParcelableExtra("imageUri");

        ImageView resultImage=(ImageView)findViewById(R.id.resultImage);
        resultImage.setImageURI(imageUri);
        */

       // openGallery();

    }

    /*
    private void openGallery(){

        Intent int2=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(int2,PICK_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==RESULT_OK && requestCode==PICK_IMAGE){
            imageUri=data.getData();
            resultImage.setImageURI(imageUri);



        }
    }
    */
}
