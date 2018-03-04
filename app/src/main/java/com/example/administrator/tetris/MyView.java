package com.example.administrator.tetris;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View implements Runnable{
    //	public class MyView extends View {

    public  int AA[][]=new int[20][10];
    public  int st=800,over,pass,move=0,sleep=800;
    public  int a=0,preView=0,Current=0,p=10;
    public  int speed=1,line=0,score=0;
    public  int CC[][]=new int[4][2];
    public  int BB[][]= new int[2][4];
    Thread thread = new Thread(this);


    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        thread.start();
        preView=(int)(Math.random()*7)+1;
    }

    public MyView(Context context){
        super(context);

    }

    @SuppressLint("DrawAllocation") @Override
    public void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub

        Paint paint = new Paint();
        canvas.drawColor(Color.LTGRAY);


        paint.setTextSize(50);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        canvas.drawText("Score: "+score, 50,70, paint);
        canvas.drawText("Speed: "+speed, 50,140, paint);
        canvas.drawText("Line: "+line, 50,210, paint);

        pass=0;   //通关标识

        paint.setColor(Color.MAGENTA);

        for(int j=1;j<=7;j=j+3)
            canvas.drawRect(j*70+2, 730+2 ,j*70+210-2 , 940-2,paint);
        canvas.drawRect(280+2, 940+2 ,490-2 , 1150-2,paint);



        paint.setColor(Color.BLACK);
        for(int i=240;i<=1640;i=i+70)
            canvas.drawLine(0, i, 700, i,paint);
        for(int i=0;i<=700;i=i+70)
            canvas.drawLine(i, 240, i,1640,paint);

        for(int i=0;i<4;i++){
            if(CC[i][0]==19){
                for(int j=0;j<4;j++)
                    AA[CC[j][0]][CC[j][1]]=1;
                sleep=st;
                move=0;
                a=0;
                break;
            }
            else if(AA[CC[i][0]+1][CC[i][1]]==1){
                for(int j=0;j<4;j++)
                    AA[CC[j][0]][CC[j][1]]=1;
                sleep=st;
                move=0;
                a=0;
                break;
            }
        }

        int LL=line;
        for(int i=1;i<20;i++)
            check(i);
        if(LL!=line){
            if(line-LL==1)
                score+=10;
            else if(line-LL==2)
                score+=30;
            else if(line-LL==3)
                score+=60;
            else if(line-LL==4)
                score+=100;
        }

        if(line>p){
            speed=line/10+1;
            st=(int)(950*Math.pow(0.85, speed));
            p=p+10;
        }

        if(move==0){
            Current=preView*10;
            preView=(int)(Math.random()*7)+1;

            BB= new int[2][4];
            if(preView==1){
                BB[0][0]=2;
                BB[0][1]=2;
                BB[0][2]=2;
                BB[0][3]=2;
            }
            else if(preView==2){
                BB[0][0]=2;
                BB[0][1]=2;
                BB[0][2]=2;
                BB[1][0]=2;
            }
            else if(preView==3){
                BB[0][0]=2;
                BB[0][1]=2;
                BB[0][2]=2;
                BB[1][2]=2;
            }
            else if(preView==4){
                BB[0][0]=2;
                BB[0][1]=2;
                BB[1][0]=2;
                BB[1][1]=2;
            }
            else if(preView==5){
                BB[0][0]=2;
                BB[0][1]=2;
                BB[0][2]=2;
                BB[1][1]=2;
            }
            else if(preView==6){
                BB[0][0]=2;
                BB[0][1]=2;
                BB[1][1]=2;
                BB[1][2]=2;
            }
            else if(preView==7){
                BB[0][1]=2;
                BB[0][2]=2;
                BB[1][0]=2;
                BB[1][1]=2;
            }

        }
        for(int i=0;i<2;i++)
            for(int j=0;j<4;j++){
                if(BB[i][j]==2)
                    canvas.drawRect(j*50+450, i*50+70 ,j*50+500 , i*50+120,paint);
            }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        for(int i=0;i<2;i++)
            for(int j=0;j<4;j++){
                if(BB[i][j]==2)
                    canvas.drawRect(j*50+450+2, i*50+70+2 ,j*50+500-2 , i*50+120-2,paint);
            }
        if(move==0){
            CC=new int[4][2];
            if(Current/10==1){
                CC[0][0]=0;
                CC[0][1]=3;
                CC[1][0]=0;
                CC[1][1]=4;
                CC[2][0]=0;
                CC[2][1]=5;
                CC[3][0]=0;
                CC[3][1]=6;
            }
            else if(Current/10==2){
                CC[0][0]=0;
                CC[0][1]=3;
                CC[1][0]=0;
                CC[1][1]=4;
                CC[2][0]=0;
                CC[2][1]=5;
                CC[3][0]=1;
                CC[3][1]=3;
            }
            else if(Current/10==3){
                CC[0][0]=0;
                CC[0][1]=3;
                CC[1][0]=0;
                CC[1][1]=4;
                CC[2][0]=0;
                CC[2][1]=5;
                CC[3][0]=1;
                CC[3][1]=5;
            }
            else if(Current/10==4){
                CC[0][0]=0;
                CC[0][1]=4;
                CC[1][0]=0;
                CC[1][1]=5;
                CC[2][0]=1;
                CC[2][1]=4;
                CC[3][0]=1;
                CC[3][1]=5;
            }
            else if(Current/10==5){
                CC[0][0]=0;
                CC[0][1]=3;
                CC[1][0]=0;
                CC[1][1]=4;
                CC[2][0]=0;
                CC[2][1]=5;
                CC[3][0]=1;
                CC[3][1]=4;
            }
            else if(Current/10==6){
                CC[0][0]=0;
                CC[0][1]=3;
                CC[1][0]=0;
                CC[1][1]=4;
                CC[2][0]=1;
                CC[2][1]=4;
                CC[3][0]=1;
                CC[3][1]=5;
            }
            else if(Current/10==7){
                CC[0][0]=0;
                CC[0][1]=4;
                CC[1][0]=0;
                CC[1][1]=5;
                CC[2][0]=1;
                CC[2][1]=3;
                CC[3][0]=1;
                CC[3][1]=4;
            }

            CC[0][0]--;
            CC[1][0]--;
            CC[2][0]--;
            CC[3][0]--;
            move=1;
        }
        if(a==0){
            CC[0][0]++;
            CC[1][0]++;
            CC[2][0]++;
            CC[3][0]++;
            a=1;
        }


        for(int i=0;i<4;i++)
            canvas.drawRect(CC[i][1]*70+2, CC[i][0]*70+240+2 ,CC[i][1]*70+70-2 , CC[i][0]*70+70+240-2,paint);


        for(int i=0;i<20;i++)
            for(int j=0;j<10;j++)
                if(AA[i][j]==1)
                    canvas.drawRect(j*70+2, i*70+240+2 ,j*70+70-2 , i*70+70+240-2,paint);


        for(int j=0;j<10;j++)
            if(AA[0][j]==1)
                pass=1;
        over=0;

        if(pass==1){

            paint.setColor(Color.BLACK);
            paint.setTextSize(100);
            canvas.drawRect(140,  700-30,140+420, 700+135,paint);
            paint.setColor(Color.WHITE);
            canvas.drawText("RESTART", 140, 700+83, paint);
            over=1;
        }

        super.onDraw(canvas);
    }


    public void check(int i){
        boolean xiaochu=true;
        for(int j=0;j<10;j++)
            if(AA[i][j]!=1)
                xiaochu=false;
        if(xiaochu){
            for(int j=0;j<10;j++)
                AA[i][j]=0;

            for(int m=i-1;m>=0;m--)
                for(int n=0;n<10;n++)
                    if(AA[m][n]==1){
                        AA[m+1][n]=1;
                        AA[m][n]=0;
                    }
            line++;
        }
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub

        while (true) {
            try {
                Thread.sleep(sleep);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(over==0){
                a=0;
                this.postInvalidate();
            }
        }
    }
}
