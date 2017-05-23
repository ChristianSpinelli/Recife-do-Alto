package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class ImageActivity extends AppCompatActivity {

    private ImageView mImgLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        mImgLocal = (ImageView) findViewById(R.id.img_local);
        mImgLocal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){

                    if((event.getY()>=1120 && event.getY()<=1180) ||
                            (event.getX()>=1530 && event.getX()<=1730 &&
                                    (event.getY()>=560 && event.getY()<=1180) )){
                        Local local = MapsActivity.getLocals()[0];
                        Intent intent = new Intent(ImageActivity.this,InfoWindowActivity.class);
                        intent.putExtra("title",local.getTitle());
                        intent.putExtra("description",local.getDescription());
                        intent.putExtra("image",local.getImage());
                        startActivity(intent);
                    }

                    Log.d("Position",event.getX()+" "+event.getY());
                }

                return true;
            }
        });


    }
}
