package com.example.dongikshin.myclass0;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    EditText editText2;
    ImageView imageView;
    person person1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText2 = (EditText) findViewById(R.id.editText2);
        imageView = (ImageView) findViewById(R.id.imageView);

    }

    public void onButton1Clicked(View v) {
        String name = editText2.getText().toString();
        person1 = new person(name);
    }

    public void onButton2Clicked(View v) {
        person1.walk(40);
    }

    public void onButton3Clicked(View v) {
        person1.run(100);
    }
    class person {

        String name;

        public person() {
        }

        public person(String name) {
            this.name = name;
        }

        public void walk(int speed) {
            imageView.setImageResource(R.drawable.person_walk);
        }

        public void run(int speed) {
            imageView.setImageResource(R.drawable.person_run);
        }
    }
}


