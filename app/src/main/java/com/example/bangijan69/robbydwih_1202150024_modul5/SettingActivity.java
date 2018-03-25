package com.example.bangijan69.robbydwih_1202150024_modul5;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    AlertDialog alertDialog1;
    int count=3;
    String color="#ffff";
    CharSequence[] values = {" Red "," Blue"," Green ","White"};

    TextView text_color;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    text_color =(TextView)findViewById(R.id.color_text);
    linearLayout =(LinearLayout)findViewById(R.id.Background_setting);
    linearLayout.setBackgroundColor(Color.parseColor(get_pref("color","color")));
    }


    public void Setting_color(View view) {


        AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);

        builder.setTitle("Shape Color");


        builder.setSingleChoiceItems(values, count, new DialogInterface.OnClickListener() {


            public void onClick(DialogInterface dialog, int item) {

                switch(item)
                {
                    case 0:
                        count=0;
                        save_shared("color","color","#f44242");
                        Toast.makeText(SettingActivity.this, "First Item Clicked", Toast.LENGTH_LONG).show();
                        linearLayout.setBackgroundColor(Color.parseColor("#f44242"));
                        text_color.setText("Red");
                        break;
                    case 1:
                        count=1;
                        save_shared("color","color","#425cf4");
                        Toast.makeText(SettingActivity.this, "Second Item Clicked", Toast.LENGTH_LONG).show();
                        text_color.setText("Blue");
                        linearLayout.setBackgroundColor(Color.parseColor("#425cf4"));
                        break;
                    case 2:
                        count=2;
                        save_shared("color","color","#44f441");
                        Toast.makeText(SettingActivity.this, "Third Item Clicked", Toast.LENGTH_LONG).show();
                        text_color.setText("Green");
                        linearLayout.setBackgroundColor(Color.parseColor("#44f441"));
                        break;

                    case 3:
                        count=3;
                        save_shared("color","color","#ffffff");
                        Toast.makeText(SettingActivity.this, "Third Item Clicked", Toast.LENGTH_LONG).show();
                        text_color.setText("White");
                        linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
                        break;
                }
                alertDialog1.dismiss();
            }

        });

        alertDialog1 = builder.create();
        alertDialog1.show();
    }
    String get_pref(String nama_file, String nama_variable){
        SharedPreferences pref = getSharedPreferences(nama_file, 0); // 0 - for private mode
        String nilai=pref.getString(nama_file,null);
        return nilai;

    }void save_shared(String nama_file,String nama_variable,String values){
        SharedPreferences pref = getSharedPreferences(nama_file, 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(nama_variable,values);
        editor.commit();
    }

}
