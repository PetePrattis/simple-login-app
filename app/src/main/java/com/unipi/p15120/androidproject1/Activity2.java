package com.unipi.p15120.androidproject1;


import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    SharedPreferences preferences;
    public EditText editText1, editText2, editText3, editText4, editText5;
    public boolean apply = false;

    public String name, password, mail, phone;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        editText1 = findViewById(R.id.etNickname);
        editText2 = findViewById(R.id.etPassword1);
        editText3 = findViewById(R.id.etPassword2);
        editText4 = findViewById(R.id.etMail);
        editText5 = findViewById(R.id.etPhone);

        ((TextView)findViewById(R.id.etNickname)).setText(preferences.getString("name",""));
        ((TextView)findViewById(R.id.etPassword1)).setText(preferences.getString("pass",""));
        ((TextView)findViewById(R.id.etMail)).setText(preferences.getString("mail",""));
        ((TextView)findViewById(R.id.etPhone)).setText(preferences.getString("phone",""));



    }



    public void apply(View view){
        apply = true;

        if(!editText1.getText().toString().equals(preferences.getString("name","")) && !editText1.getText().toString().matches("")){
            String toWrite1 = editText1.getText().toString();
            name = toWrite1;
        }
        else if (editText1.getText().toString().matches("")){
            Toast.makeText(this,"Name can't be empty",Toast.LENGTH_SHORT).show();
            apply=false;
        }
        else if (editText1.getText().toString().equals(preferences.getString("name",""))){
            String toWrite1 = editText1.getText().toString();
            name = toWrite1;
        }

        if(editText2.getText().toString().equals(preferences.getString("pass",""))){
            if(!editText3.equals("")){
                String toWrite2 = editText3.getText().toString();
                password = toWrite2;
            }
            else if(editText3.equals("")){
                String toWrite2 = editText3.getText().toString();
                password = toWrite2;
            }

        }
        else if (editText2.getText().toString().matches("")){
            Toast.makeText(this,"Password can't be empty",Toast.LENGTH_SHORT).show();
            apply=false;
        }
        else if (!editText2.getText().toString().equals(preferences.getString("pass",""))){
            Toast.makeText(this,"Password is wrong",Toast.LENGTH_SHORT).show();
            apply=false;
        }

        if(!editText4.getText().toString().matches("")){
            String toWrite3 = editText4.getText().toString();
            mail = toWrite3;
        }
        else
            mail = "";

        if(!editText5.getText().toString().matches("")){
            String toWrite4 = editText5.getText().toString();
            phone = toWrite4;
        }
        else
            phone = "";

        if (apply){
            ((TextView)findViewById(R.id.etNickname)).setText(name);
            ((TextView)findViewById(R.id.etPassword1)).setText(password);
            ((TextView)findViewById(R.id.etPassword2)).setText("");
            ((TextView)findViewById(R.id.etMail)).setText(mail);
            ((TextView)findViewById(R.id.etPhone)).setText(phone);

            Toast.makeText(this,"Changes haven't been saved",Toast.LENGTH_SHORT).show();
        }


    }

    public void back(View view){
        Toast.makeText(this,"Changes have been discarded",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,Activity1.class));
    }
}
