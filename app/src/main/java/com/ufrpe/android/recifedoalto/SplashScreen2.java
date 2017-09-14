package com.ufrpe.android.recifedoalto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Christian Spinelli on 14/09/2017.
 */

public class SplashScreen2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash2);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(1500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreen2.this,MenuFragmentActivity.class);
                    startActivity(intent);


                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
