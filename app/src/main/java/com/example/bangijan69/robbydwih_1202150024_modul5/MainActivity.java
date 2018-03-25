package com.example.bangijan69.robbydwih_1202150024_modul5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DataBase db;
    Cursor cursor;
    ListView listView;
    ArrayList <String> todo = new ArrayList<String>();
    ArrayList <String> disdrip = new ArrayList<String>();
    ArrayList <String> piroty = new ArrayList<String>();

    LinearLayout linearLayout;
    RecyclerView recyclerView;
    List<DataModel> data = new ArrayList<>();
    RecycleAdapter adapter;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting_menu:
                Intent i = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(i);

                break;
        }
        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();
       list();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuiFalter = getMenuInflater();
        menuiFalter.inflate(R.menu.menu_toolbar,menu);
        return  true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db= new DataBase(this);
        refres_list();

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_tambah);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Tambah_list_Activity.class );
                startActivity(i);
            }
        });

        list();


        linearLayout=(LinearLayout)findViewById(R.id.background_main);
        linearLayout.setBackgroundColor(Color.parseColor(get_pref("color","color")));

    }
    void list(){
        tes swipeController = new tes();
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        adapter  = new RecycleAdapter(data);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);



        // listView = (ListView)findViewById(R.id.list_view);
       // listView.
       // listView.setAdapter(new ListAdapter(this,todo,disdrip,piroty));



    }
    void refres_list(){
        SQLiteDatabase database = db.getReadableDatabase();
        cursor =database.rawQuery("SELECT * FROM tb_todo",null);

        if(cursor!=null){
            if(cursor.moveToFirst()){
              do {


                  String nama_todo = cursor.getString(cursor.getColumnIndex("todo_nama"));
                  String Descrip = cursor.getString(cursor.getColumnIndex("description"));
                  String piority = cursor.getString(cursor.getColumnIndex("piority"));
                  todo.add(nama_todo);
                    DataModel dat = new DataModel(nama_todo,Descrip,piority);
                  data.add(dat);

                  disdrip.add(Descrip);
                  piroty.add(piority);
              }while (cursor.moveToNext());





            }


        }



    }


            String get_pref(String nama_file, String nama_variable){
        SharedPreferences pref = getSharedPreferences(nama_file, 0); // 0 - for private mode
        String nilai=pref.getString(nama_file,null);
        return nilai;
}

    @Override
    protected void onPause() {
        super.onPause();
        linearLayout.setBackgroundColor(Color.parseColor(get_pref("color","color")));
    }
}
