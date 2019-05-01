package com.example.ap_star.EyeDentify;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.InputDevice;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import com.microsoft.projectoxford.vision.VisionServiceClient;
import com.microsoft.projectoxford.vision.VisionServiceRestClient;
import com.microsoft.projectoxford.vision.contract.AnalysisResult;
import com.microsoft.projectoxford.vision.contract.Caption;

import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class Result extends AppCompatActivity {

    public final VisionServiceClient visionServiceClient = new VisionServiceRestClient("be9d7b78d0d542699f14b7ceb8fd53f9","https://westcentralus.api.cognitive.microsoft.com/vision/v2.0");


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        final Uri myUri = Uri.parse(getIntent().getStringExtra("imageUri"));
       final ImageView resultImage=(ImageView)findViewById(R.id.resultImage);
        Button detectButton=(Button)findViewById(R.id.btnProcess);
        TextView description=(TextView)findViewById(R.id.txtDescription);

       resultImage.setImageURI(myUri);



        //---Associate this Uri value with a name
        Bundle extra=new Bundle();
        extra.putString("IMAGE_FILENAME",myUri.toString());

        /*
        detectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AsyncTask<InputStream,String,String> visionTask=new AsyncTask<InputStream, String, String>() {
                    @Override
                    protected String doInBackground(InputStream... inputStreams) {
                        try{

                            Bitmap ImageBitmap;
                            InputStream ImageStream;
                            ByteArrayInputStream inputStream;

                            //---convert a Uri to a stream
                                ImageStream = getContentResolver().openInputStream(myUri);
                                //---Get the image as Bitmap.
                                ImageBitmap=BitmapFactory.decodeStream(ImageStream);

                            //convert image to stream
                            ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
                            ImageBitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
                            inputStream=new ByteArrayInputStream(outputStream.toByteArray());

                            publishProgress("Recognizing...");
                            String[] features= {"Description"};
                            String[] details={};

                            AnalysisResult result= visionServiceClient.analyzeImage(inputStream,features,details);


                        }catch(FileNotFoundException e){
                        e.printStackTrace();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    }
                }




            }
        });*/


    }





}
