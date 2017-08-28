package com.basicactivity.luiscaicedo.basicactivity_luiscaicedo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static LinearLayout contentLayout;
    ArrayList<Form> forms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contentLayout = (LinearLayout)findViewById(R.id.content_layout);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                forms.add(new Form());

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void OnButtonClick(View view) {
        Log.d("Mensajes", "Button Click");
    }


    class Form{

        TextView tView;
        EditText eText;
        Button button;

        public Form(){
            createTextView();
            createEditText();
            createButton();

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("Mensajes", eText.getText().toString());
                }
            });
        }

        void createTextView(){
            tView = new TextView(MainActivity.this);
            tView.setText("Write Something");
            tView.setHeight(100);
            MainActivity.contentLayout.addView(tView);
        }

        void createEditText(){
            eText = new EditText(MainActivity.this);
            MainActivity.contentLayout.addView(eText);
        }

        void createButton(){
            button = new Button(MainActivity.this);
            button.setText("Log");
            MainActivity.contentLayout.addView(button);
        }
    }

}
