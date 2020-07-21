package com.example.mitul.qbscan;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Button androidB;
    public void ScanMode(View view) {
        Intent i = new Intent((Context) MainActivity.this, ScanActivity.class);
        startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidB = (Button)findViewById(R.id.scanmode);


        //Floating send button handle
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Showes the sending media
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"Send copied data"));
            }
        });
    }

    //Actionbar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Handle actiobar item clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.settings){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);

            builder1.setMessage(Html.fromHtml("This section is on under development<br />"));

            builder1.setCancelable(false);
            builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog Alert1 = builder1.create();
            Alert1 .show();
            ((TextView)Alert1.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
        }
        if(id == R.id.manual){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);

            builder1.setMessage(Html.fromHtml("Manual will be updated soon"));

            builder1.setCancelable(false);
            builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog Alert1 = builder1.create();
            Alert1 .show();
        }
        if(id == R.id.update){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);

            builder1.setMessage(Html.fromHtml("Click on the link below to update the app: <br /> <a href=\"https://wwww.google.com/\">Google drive link</a>"));

            builder1.setCancelable(false);
            builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog Alert1 = builder1.create();
            Alert1 .show();
            ((TextView)Alert1.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
        }

        if(id == R.id.feedback){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);

            builder1.setMessage(Html.fromHtml("Please provide your valuable feedback here: <br />Facebook: <a href=\"https://www.facebook.com/\">Facebook</a>"));

            builder1.setCancelable(false);
            builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog Alert1 = builder1.create();
            Alert1 .show();
            ((TextView)Alert1.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
        }
        if(id == R.id.share){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String body = "https://www.google.com/";

            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(intent,"Share my app link"));
        }
        if(id == R.id.about){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);

            builder1.setMessage(Html.fromHtml("Developed by: Md. Kamal Hossain Mitul <br />Facebook: <a href=\"https://www.facebook.com/\">Facebook</a>"));

            builder1.setCancelable(false);
            builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog Alert1 = builder1.create();
            Alert1 .show();
            ((TextView)Alert1.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
        }
        if(id == R.id.quit){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to quit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.super.onBackPressed();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

        return super.onOptionsItemSelected(item);
    }

    //Exit dialog box on backpress button
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }




}
