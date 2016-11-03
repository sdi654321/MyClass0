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
    public static int total=1;
    public int age =0;

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
                Toast.makeText(getApplicationContext(), "어른을 만들었어요.. 이름은 " + name, Toast.LENGTH_LONG).show();
            age = 20;
        }
        else
        {
            person1 = new baby(name);
            imageView.setImageResource(R.drawable.baby);
            age = 0;
        }
        Toast.makeText(getApplicationContext(),total +" 번 째 사람", Toast.LENGTH_LONG).show();
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

    public void onButton4Clicked(View v) {
        if(person1 instanceof baby) {
            ((baby) person1).smile();
        }
        else{
            Toast.makeText(getApplicationContext(),"이 어른은 웃지 않아요", Toast.LENGTH_LONG).show();
        }
    }

    public class person {
        String name;

        public person() {
        }

        public person(String name) {
            this.name = name;
            total = total +1;
        }

        public void walk(int speed) {
            if(age == 20) {
                imageView.setImageResource(R.drawable.person_walk);
                Toast.makeText(getApplicationContext(), name + "이(가) 걸어갑니다", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), name + "는 아기라 걷지 못해요", Toast.LENGTH_LONG).show();
            }
        }

        public void run(int speed) {
            if(age == 20) {
                imageView.setImageResource(R.drawable.person_run);
                Toast.makeText(getApplicationContext(), name + "이(가) 뛰어갑니다", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(getApplicationContext(), name + "는 아기라 뛰지 못해요", Toast.LENGTH_LONG).show();
            }

        }
    }

        public class baby extends person {
            public baby(String name) {
                super.name = name;
                Toast.makeText(getApplicationContext(), "아기를 만들었어요.. 이름은"  + name, Toast.LENGTH_LONG).show();

            }

            public void smile() {
                imageView.setImageResource(R.drawable.baby_smile);
                Toast.makeText(getApplicationContext(), "아기가 웃어요" + name, Toast.LENGTH_LONG).show();
            }
        }
    }



