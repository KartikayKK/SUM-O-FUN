package com.example.jame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button go,b1,b2,b3,b4 ;
    TextView time,que,score,ans;
    String up,down,q1,q2,hell;
    int i1,i2,sc1,sc2,g1,g2,g3,g4,k,p1,p2;
    int lol=0;
    public void start(View view){
        go.setVisibility(View.INVISIBLE);
        time.setVisibility(View.VISIBLE);
        que.setVisibility(View.VISIBLE);
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        new CountDownTimer(31000, 900) {

            //TIMER
            public void onTick(long millisUntilFinished) {
                if((millisUntilFinished/1000)<10){
                    time.setText("0"+millisUntilFinished/1000);
                }
                else{
                    time.setText("" +millisUntilFinished / 1000);
                }
            }

            public void onFinish() {
                time.setText("00");
                ans.setVisibility(View.VISIBLE);
                lol=1;

            }
        }.start();
    }
    public void buttons(int y){
        if (y==0){
            hell=Integer.toString(g1);
            b2.setText(hell);
            hell=Integer.toString(g2);
            b3.setText(hell);
            hell=Integer.toString(g3);
            b4.setText(hell);
        }
        if (y==1){
            hell=Integer.toString(g3);
            b1.setText(hell);
            hell=Integer.toString(g2);
            b3.setText(hell);
            hell=Integer.toString(g1);
            b4.setText(hell);
        }
        if (y==2){
            hell=Integer.toString(g1);
            b2.setText(hell);
            hell=Integer.toString(g2);
            b1.setText(hell);
            hell=Integer.toString(g3);
            b4.setText(hell);
        }
        if (y==3){
            hell=Integer.toString(g3);
            b2.setText(hell);
            hell=Integer.toString(g1);
            b3.setText(hell);
            hell=Integer.toString(g2);
            b1.setText(hell);
        }
    }
    public void MAIN(){
        //New question

        i1 = new Random().nextInt(30) + 5;
        i2 = new Random().nextInt(30) + 5;
        if(p1==i1||p2==i2){

            i1 = new Random().nextInt(30) + 5;
            i2 = new Random().nextInt(30) + 5;

        }
        q1 = Integer.toString(i1);
        q2 = Integer.toString(i2);
        que.setText(q1 + '+' + q2);
        p1=i1;
        p2=i2;

        //Buttons assign

        g4 = i1 + i2;
        g1 = new Random().nextInt(80) + 10;
        if (g1 == g4)
            g1 = new Random().nextInt(35) + 5;
        g2 = new Random().nextInt(80) + 10;
        if (g2 == g4 || g2 == g1)
            g2 = new Random().nextInt(80) + 10;
        g3 = new Random().nextInt(80) + 10;
        if (g3 == g4 || g2 == g3 || g3 == g1)
            g3 = new Random().nextInt(80) + 10;
        if (g1 > g4) {
            hell = Integer.toString(g4);
            b1.setText(hell);
            k = 0;
        } else if (g2 < g4) {
            hell = Integer.toString(g4);
            b2.setText(hell);
            k = 1;
        } else if (g3 > g4) {
            hell = Integer.toString(g4);
            b3.setText(hell);
            k = 2;
        } else {
            hell = Integer.toString(g4);
            b4.setText(hell);
            k = 3;
        }
        buttons(k);
    }
    public void inv(){
        time.setVisibility(View.INVISIBLE);
        que.setVisibility(View.INVISIBLE);
        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        b4.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        ans.setVisibility(View.INVISIBLE);

    }
    public void yo(View view){
        if (lol==0) {
            Button b = (Button) view;

            String text = b.getText().toString();
            int c = Integer.parseInt(text);
            if (c == i1 + i2) {
                sc1 += 1;
                sc2 += 1;
            } else {
                sc2 += 1;
            }
            up = Integer.toString(sc1);
            down = Integer.toString(sc2);
            score.setText(up + '/' + down);

            MAIN();
        }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go =findViewById(R.id.go);
        time=findViewById(R.id.time);
        que=findViewById(R.id.que);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        score=findViewById(R.id.score);
        ans=findViewById(R.id.ans);
        MAIN();
        sc1=0;
        sc2=0;
        inv();
    }
}
