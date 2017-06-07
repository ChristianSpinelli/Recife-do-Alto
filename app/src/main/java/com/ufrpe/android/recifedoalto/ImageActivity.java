package com.ufrpe.android.recifedoalto;

import android.content.Context;
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

        final int image = getIntent().getIntExtra("image",R.drawable.riomar);

        mImgLocal = (ImageView) findViewById(R.id.img_local);
        mImgLocal.setImageResource(image);
        mImgLocal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    if(image == R.drawable.riomar) {
                        Local local;
                        if ((event.getY() >= 1120 && event.getY() <= 1180) ||
                                (event.getX() >= 1530 && event.getX() <= 1730 &&
                                        (event.getY() >= 560 && event.getY() <= 1180))) {
                            local = LocalLab.get().getLocals().get(0);
                            openInfoActivity(local);

                        }
                        if ((event.getX() >= 470 && event.getX() <= 540) && (event.getY() <= 1060 && event.getY() >= 1020)) {
                            local = LocalLab.get().getLocals().get(1);
                            openInfoActivity(local);

                        }

                    }if(image == R.drawable.img_map1){
                        Local local;
                        if((event.getY()>=1120 && event.getY() <= 1150) ||
                                (event.getX()>=640 && event.getX()<=860) &&
                                        (event.getY()>=560 && event.getY()<=1170)){
                            local = LocalLab.get().getLocals().get(0);
                            openInfoActivity(local);

                        }
                    }if(image == R.drawable.forte_das_cinco_pontas){
                        Local local;
                        if( (event.getX()>=310 && event.getX()<=790) &&
                                (event.getY()>=420 && event.getY()<=940 ) ){
                            local = LocalLab.get().getLocals().get(1);
                            openInfoActivity(local);
                        }

                    }

                    Log.d("Position",event.getX()+" "+event.getY());
                }

                return true;
            }
        });


    }

    private void openInfoActivity(Local local){
        Intent intent = InfoWindowFragmentActivity.newIntent(this);
        intent.putExtra("images",local.getInfoImages());
        startActivity(intent);
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,ImageActivity.class);
        return intent;
    }
}
