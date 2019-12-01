package com.unipi.p15120.androidproject1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity {

    public EditText editText1;
    public EditText editText2;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();

        editText1 = findViewById(R.id.etNickname);
        editText2 = findViewById(R.id.etPassword);

        editor.putString("name", "Admin");
        editor.putString("pass", "1234");
        editor.putString("mail", "admin@mail.com");
        editor.putString("phone", "12341234");
        editor.apply();

    }

    public void login(View view){
        if ((editText1.getText().toString()).equals(preferences.getString("name","")) && (editText2.getText().toString()).equals(preferences.getString("pass",""))){
            startActivity(new Intent(this,Activity2.class));
        }
        else if (!(editText1.getText().toString()).equals(preferences.getString("name","")) && !(editText1.getText().toString()).matches(""))
            Toast.makeText(this,"Name is wrong",Toast.LENGTH_SHORT).show();
        else if ((editText1.getText().toString()).matches(""))
            Toast.makeText(this,"Name can't be empty",Toast.LENGTH_SHORT).show();
        else if (!(editText2.getText().toString()).equals(preferences.getString("pass","")) && !(editText2.getText().toString()).matches(""))
            Toast.makeText(this,"Password is wrong",Toast.LENGTH_SHORT).show();
        else if ((editText2.getText().toString()).matches(""))
            Toast.makeText(this,"Password can't be empty",Toast.LENGTH_SHORT).show();
    }

}
