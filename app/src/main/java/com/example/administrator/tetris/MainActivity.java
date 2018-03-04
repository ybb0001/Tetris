package com.example.administrator.tetris;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {


    private MyView mv;
    private Button btnChange;
    private Button btnLeft;
    private Button btnDown;
    private Button btnRight;
    private TextView tv1;


    public void checkLeft(){
        boolean mark1=true;
        for(int j=0;j<4;j++)
            if(mv.CC[j][1]==0||mv.AA[mv.CC[j][0]][mv.CC[j][1]-1]==1){
                mark1=false;
                break;}
        if(mark1&&mv.CC[0][0]>0)
            for(int j=0;j<4;j++)
                mv.CC[j][1]--;
        mv.postInvalidate();
    }

    public void checkRight(){
        boolean mark1=true;
        for(int j=0;j<4;j++)
            if(mv.CC[j][1]==9||mv.AA[mv.CC[j][0]][mv.CC[j][1]+1]==1){
                mark1=false;
                break;}
        if(mark1&&mv.CC[0][0]>0)
            for(int j=0;j<4;j++)
                mv.CC[j][1]++;
        mv.postInvalidate();

    }
    public void checkChange(){


        if(mv.Current/10==1) {
            if(mv.Current%10==0&&mv.CC[1][0]>1&&mv.CC[1][0]<19){
                mv.CC[0][0]+=1;
                mv.CC[0][1]+=1;
                mv.CC[2][0]-=1;
                mv.CC[2][1]-=1;
                mv.CC[3][0]-=2;
                mv.CC[3][1]-=2;
                mv.Current=11;
            }
            else if(mv.Current%10==1&&mv.CC[1][1]>0&&mv.CC[1][1]<8){
                mv.CC[0][0]-=1;
                mv.CC[0][1]-=1;
                mv.CC[2][0]+=1;
                mv.CC[2][1]+=1;
                mv.CC[3][0]+=2;
                mv.CC[3][1]+=2;

                mv.Current=10;
            }
            mv.postInvalidate();
        }



        if(mv.Current/10==2) {

            if(mv.Current%10==0&&mv.CC[1][0]>0){
                mv.CC[0][0]++;
                //		mv.CC[0][1]++;
                //		mv.CC[1][0]++;
                mv.CC[1][1]-=1;
                mv.CC[2][0]-=1;
                mv.CC[2][1]-=2;
                //		mv.CC[3][0]+=2;
                mv.CC[3][1]++;
                mv.Current=21;
            }else if(mv.Current%10==1&&mv.CC[2][1]>0){

                //				mv.CC[0][0]++;
                mv.CC[0][1]++;

                mv.CC[1][0]++;
                //				mv.CC[1][1]-=1;

                mv.CC[2][0]+=2;
                mv.CC[2][1]-=1;

                mv.CC[3][0]-=1;
                //				mv.CC[3][1]++;

                mv.Current=22;
            }else if(mv.Current%10==2){
                mv.CC[0][0]--;
                //			mv.CC[0][1]++;

                //			mv.CC[1][0]++;
                mv.CC[1][1]+=1;

                mv.CC[2][0]+=1;
                mv.CC[2][1]+=2;

                //			mv.CC[3][0]+=2;
                mv.CC[3][1]--;
                mv.Current=23;
            }else if(mv.Current%10==3&&mv.CC[0][1]<9){

                //		mv.CC[0][0]++;
                mv.CC[0][1]-=1;

                mv.CC[1][0]-=1;
                // 		mv.CC[1][1]+=1;

                mv.CC[2][0]-=2;
                mv.CC[2][1]+=1;

                mv.CC[3][0]+=1;
                //		mv.CC[3][1]+=1;

                mv.Current=20;
            }
            mv.postInvalidate();
        }




        if(mv.Current/10==3) {
            if(mv.Current%10==0&&mv.CC[3][0]<19){
                mv.CC[0][0]+=2;
                mv.CC[0][1]++;

                mv.CC[1][0]++;
                //	mv.CC[1][1]-=1;

                //	mv.CC[2][0]-=1;
                mv.CC[2][1]-=1;

                mv.CC[3][0]-=1;
                //	mv.CC[3][1]++;
                mv.Current=31;
            }else if(mv.Current%10==1&&mv.CC[3][1]<9){

                mv.CC[0][0]-=1;
                mv.CC[0][1]+=2;

                //		mv.CC[1][0]++;
                mv.CC[1][1]+=1;

                mv.CC[2][0]+=1;
                //		mv.CC[2][1]-=1;

                //		mv.CC[3][0]-=1;
                mv.CC[3][1]-=1;

                mv.Current=32;
            }else if(mv.Current%10==2&&mv.CC[3][0]>0){
                mv.CC[0][0]-=2;
                mv.CC[0][1]-=1;

                mv.CC[1][0]--;
                //		mv.CC[1][1]+=1;

                //		mv.CC[2][0]+=1;
                mv.CC[2][1]+=1;

                mv.CC[3][0]+=1;
                //		mv.CC[3][1]++;
                mv.Current=33;
            }else if(mv.Current%10==3&&mv.CC[3][1]>0){

                mv.CC[0][0]++;
                mv.CC[0][1]-=2;

                //		mv.CC[1][0]-=1;
                mv.CC[1][1]-=1;

                mv.CC[2][0]-=1;
                //		mv.CC[2][1]+=1;

                //		mv.CC[3][0]+=1;
                mv.CC[3][1]+=1;

                mv.Current=30;
            }
            mv.postInvalidate();
        }



        if(mv.Current/10==5) {
            if(mv.Current%10==0&&mv.CC[1][0]>0){
                mv.CC[0][0]-=1;
                mv.CC[0][1]++;

                //	mv.CC[1][0]++;
                //	mv.CC[1][1]-=1;

                //	mv.CC[2][0]-=1;
                //	mv.CC[2][1]-=1;

                //	mv.CC[3][0]-=1;
                //	mv.CC[3][1]++;
                mv.Current=51;
            }else if(mv.Current%10==1&&mv.CC[1][1]>0){

                //		mv.CC[0][0]-=1;
                //		mv.CC[0][1]+=2;

                //		mv.CC[1][0]++;
                //		mv.CC[1][1]+=1;

                //		mv.CC[2][0]+=1;
                //		mv.CC[2][1]-=1;

                mv.CC[3][0]-=1;
                mv.CC[3][1]-=1;

                mv.Current=52;
            }else if(mv.Current%10==2&&mv.CC[1][0]<19){
                //		mv.CC[0][0]-=2;
                //		mv.CC[0][1]-=1;

                //		mv.CC[1][0]--;
                //		mv.CC[1][1]+=1;

                mv.CC[2][0]+=1;
                mv.CC[2][1]-=1;

                //		mv.CC[3][0]+=1;
                //		mv.CC[3][1]++;
                mv.Current=53;
            }else if(mv.Current%10==3&&mv.CC[1][1]<9){

                mv.CC[0][0]++;
                mv.CC[0][1]-=1;

                //		mv.CC[1][0]-=1;
                // 		mv.CC[1][1]-=1;

                mv.CC[2][0]-=1;
                mv.CC[2][1]+=1;

                mv.CC[3][0]+=1;
                mv.CC[3][1]+=1;

                mv.Current=50;
            }
            mv.postInvalidate();
        }



        if(mv.Current/10==6) {
            if(mv.Current%10==0&&mv.CC[2][0]>0){
                mv.CC[0][0]+=2;
                //	mv.CC[0][1]++;

                mv.CC[1][0]++;
                mv.CC[1][1]-=1;

                //	mv.CC[2][0]-=1;
                //	mv.CC[2][1]-=1;

                mv.CC[3][0]-=1;
                mv.CC[3][1]-=1;
                mv.Current=61;
            }else if(mv.Current%10==1&&mv.CC[2][1]<9){

                mv.CC[0][0]-=2;
                //	mv.CC[0][1]++;

                mv.CC[1][0]--;
                mv.CC[1][1]+=1;

                //	mv.CC[2][0]-=1;
                //	mv.CC[2][1]-=1;

                mv.CC[3][0]+=1;
                mv.CC[3][1]+=1;
                mv.Current=60;
            }
            mv.postInvalidate();
        }



        if(mv.Current/10==7) {
            if(mv.Current%10==0&&mv.CC[2][0]>0){
                mv.CC[0][0]+=1;
                mv.CC[0][1]-=1;

                //	mv.CC[1][0]++;
                mv.CC[1][1]-=2;

                mv.CC[2][0]+=1;
                mv.CC[2][1]+=1;

                //	mv.CC[3][0]-=1;
                //	mv.CC[3][1]-=1;
                mv.Current=71;
            }else if(mv.Current%10==1&&mv.CC[2][1]<9){

                mv.CC[0][0]-=1;
                mv.CC[0][1]+=1;

                //	mv.CC[1][0]++;
                mv.CC[1][1]+=2;

                mv.CC[2][0]-=1;
                mv.CC[2][1]-=1;

                mv.Current=70;
            }
            mv.postInvalidate();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnChange=(Button)findViewById(R.id.button1);
        this.btnLeft=(Button)findViewById(R.id.button2);
        this.btnDown=(Button)findViewById(R.id.button3);
        this.btnRight=(Button)findViewById(R.id.button4);
        this.tv1=(TextView) findViewById(R.id.textView1);
        tv1.setText("Ver1.3   ");

        mv=(MyView) findViewById(R.id.myView1);
        mv.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                // TODO Auto-generated method stub
                float x1 = 0;
                float x2 = 0;
                float y1 = 0;
                float y2 = 0;

                if(arg1.getAction()== MotionEvent.ACTION_DOWN){
                    x1 = arg1.getX();
                    y1 = arg1.getY();
                    if(x1>280&&x1<490&&mv.pass==0)
                        if(y1>940&&y1<1150){
                            mv.sleep=30;
                            mv.a=0;
                            mv.postInvalidate();
                        }
                }

                if(arg1.getAction()==MotionEvent.ACTION_UP){
                    x2 = arg1.getX();
                    y2 = arg1.getY();
                    mv.sleep=mv.st;
                }
                if(mv.pass==0){

                    if(x2>70&&x2<280)
                        if(y2>730&&y2<940)
                            checkLeft();
                    if(x2>490&&x2<700)
                        if(y2>730&&y2<940)
                            checkRight();
                    if(x2>280&&x2<490)
                        if(y2>730&&y2<940)
                            checkChange();

                }
                else if(x2>140&&x2<140+420)
                    if(y2>670&&y2<835){
                        mv.pass=0;
                        mv.AA= new int[20][10];
                        mv.score=0;
                        mv.line=0;
                        mv.speed=1;
                        mv.sleep=800;
                        mv.st=800;
                        mv.preView=(int)(Math.random()*7)+1;
                        mv.over=0;
                        mv.p=10;
                    }
                return true;
            }
        });

        btnChange.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                checkChange();

            }
        });

        btnLeft.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                checkLeft();
            }
        });

        btnDown.setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                // TODO Auto-generated method stub

                if(arg1.getAction()== MotionEvent.ACTION_DOWN){
                    mv.sleep=30;
                    mv.a=0;
                    mv.postInvalidate();
                }
                if(arg1.getAction()==MotionEvent.ACTION_UP)
                    mv.sleep=mv.st;

                return true;
            }
        });
        btnRight.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                checkRight();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}