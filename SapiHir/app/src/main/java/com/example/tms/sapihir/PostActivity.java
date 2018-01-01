package com.example.tms.sapihir;

import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PostActivity extends AppCompatActivity {
    private static final int GALLERY_REQUEST=1;
    private ImageButton mSelectImage;
    private EditText mPostTitle;
    private EditText mPostDescription;
    private EditText mPostTelnumber;
    private Button mSubmitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        mSelectImage=(ImageButton) findViewById(R.id.ImageSelect);
        mPostTitle=(EditText)findViewById(R.id.HirCim);
        mPostDescription=(EditText)findViewById(R.id.HirLeiras);
        mPostTelnumber=(EditText)findViewById(R.id.HirTelefonszam);
        mSubmitButton=(Button)findViewById(R.id.SubmitBtn);
        mSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galerryintent=new Intent(Intent.ACTION_GET_CONTENT);
                galerryintent.setType("image/*");
                startActivityForResult(galerryintent,GALLERY_REQUEST);
            }
        });

        mPostTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startPosting();

            }
        })
    }

    private void startPosting() {

    }

    @Override
     protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==GALLERY_REQUEST && resultCode==RESULT_OK)
        {
            Uri imageUri=data.getData();
            mSelectImage.setImageURI(imageUri);
        }
    }
}
