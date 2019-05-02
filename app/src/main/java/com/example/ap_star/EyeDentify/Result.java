package com.example.ap_star.EyeDentify;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageHelper;
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


import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.google.gson.Gson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import edmt.dev.edmtdevcognitivevision.Contract.AnalysisResult;
import edmt.dev.edmtdevcognitivevision.Contract.Caption;
import edmt.dev.edmtdevcognitivevision.Rest.VisionServiceException;
import edmt.dev.edmtdevcognitivevision.VisionServiceClient;
import edmt.dev.edmtdevcognitivevision.VisionServiceRestClient;


public class Result extends AppCompatActivity {

    private final String API_Key = "d53d085a41ef478d8609ce9aa9aa55ce";
    private final String API_Link = "https://centralus.api.cognitive.microsoft.com/vision/v2.0";

    //Declare VisionClient
    VisionServiceClient visionServiceClient = new VisionServiceRestClient(API_Key, API_Link);

    private Bitmap bitmap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout..layout.activity_result);

        final Uri myUri = Uri.parse(getIntent().getStringExtra("imageUri"));



        final ImageView resultImage=(ImageView)findViewById(R.id.resultImage);
        Button detectButton=(Button)findViewById(R.id.btnProcess);
        final TextView description=(TextView)findViewById(R.id.txtDescription);

        //resultImage.setImageURI(myUri);

        try {
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), myUri);
            resultImage.setImageBitmap(bitmap);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        /*
        //---Associate this Uri value with a name
        Bundle extra=new Bundle();
        extra.putString("IMAGE_FILENAME",myUri.toString());
        */

        final ByteArrayOutputStream outputStream=new ByteArrayOutputStream();;
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        detectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {{
                AsyncTask<InputStream, String, String> visionTask = new AsyncTask<InputStream, String, String>() {
                    ProgressDialog progressDialog = new ProgressDialog(Result.this);


                    @Override
                    protected void onPreExecute() {
                        progressDialog.show();
                    }

                    @Override
                    protected String doInBackground(InputStream... inputStreams) {



                        try {
                            publishProgress("Recognizing");
                            String[] features = {"Description"};
                            String[] details = {};

                            ByteArrayOutputStream output = new ByteArrayOutputStream();

                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, output);
                            ByteArrayInputStream inputStream = new ByteArrayInputStream(output.toByteArray());

                            AnalysisResult visionResult = visionServiceClient.analyzeImage(inputStream, features, details);

                            // AnalysisResult visionResult = visionServiceClient.analyzeImage(inputStream, features, details);

                            String jsonResult = new Gson().toJson(visionResult);
                            return jsonResult;

                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (VisionServiceException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        progressDialog.dismiss();

                        AnalysisResult result = new Gson().fromJson(s, AnalysisResult.class);
                        StringBuilder result_Text = new StringBuilder();
                        for (Caption caption : result.description.captions)
                            result_Text.append(caption.text);
                        description.setText(result_Text.toString());

                    }

                    @Override
                    protected void onProgressUpdate(String... values) {
                        progressDialog.setMessage(values[0]);
                    }


                };

                visionTask.execute(inputStream);
            }



            }
        });


    }





}
