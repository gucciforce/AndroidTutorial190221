package com.example.a.asyncktask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    //핸들러까지 동시에
    TextView textView;
    class MyTask extends AsyncTask<Integer,Float,String>{

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            super.onProgressUpdate(values);
            textView.setText("count : " + values[0]);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            int value = integers[0];
            for(int i=value;i<100;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("count","count:"+i);
                publishProgress((float)i);

            }
            return "done";
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        MyTask myTask = new MyTask();
        myTask.execute(30);
    }
}
