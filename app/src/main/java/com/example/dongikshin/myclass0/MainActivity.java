package com.example.dongikshin.myclass0;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

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

        RadioButton radio1 = (RadioButton) findViewById(R.id.radioButton1);
        boolean personChecked = radio1.isChecked();

        if(personChecked) {
            person1 = new person(name);
            imageView.setImageResource(R.drawable.person);

                Toast.makeText(getApplicationContext(), "아기가 성장했어요.." + name, Toast.LENGTH_LONG).show();

        }
        else
        {
            person1 = new baby(name);
            imageView.setImageResource(R.drawable.baby);
        }

    }

    public void onButton2Clicked(View v) {
        if(person1 != null) {
            person1.walk(40);
        }
    }

    public void onButton3Clicked(View v) {
        if(person1 != null) {
            person1.run(100);
        }
    }


    public class person {
        String name;
        public person() {
        }

        public person(String name) {
            this.name = name;
        }

        public void walk(int speed) {
            imageView.setImageResource(R.drawable.person_walk);
            Toast.makeText(getApplicationContext(), name + "이(가) 걸어갑니다", Toast.LENGTH_LONG).show();
        }

        public void run(int speed) {
            imageView.setImageResource(R.drawable.person_run);
            Toast.makeText(getApplicationContext(), name + "이(가) 뛰어갑니다", Toast.LENGTH_LONG).show();

        }
    }
   public class baby extends person{
        public baby(String name){
            super.name = name;
            Toast.makeText(getApplicationContext(),"아기를 만들었어요.." + name, Toast.LENGTH_LONG).show();

        }
    }
}


