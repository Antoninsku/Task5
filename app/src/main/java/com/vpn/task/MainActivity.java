package com.vpn.task;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    Button hitMe;
    TextView reset;
    TextView hitCounter, visible, creations;
    Counter count = new Counter(0, 100, 0, 1);

    String TAG = "SomeTAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("MyShared", MODE_PRIVATE);

        Log.d(TAG, "onCreate: ");
    //standart button option
        hitMe = findViewById(R.id.hitMe);
        reset = findViewById(R.id.reset);

        creations = findViewById(R.id.creations);
        visible = findViewById(R.id.visible);
        hitCounter = findViewById(R.id.hitCounter);
    //retrieve info
        creations.setText(sharedPreferences.getString("creations", "0"));
        visible.setText(sharedPreferences.getString("visible", "0"));
        hitCounter.setText(sharedPreferences.getString("hit", "0"));

        creations.setText(count.plus(Integer.parseInt(creations.getText().toString())) + "");
        // Counter activity
        hitMe.setOnClickListener(view -> hitCounter.setText(count.plus(Integer.parseInt(hitCounter.getText().toString())) + ""));

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitCounter.setText(count.reset() + "");
                visible.setText(count.reset() + "");
                creations.setText(count.reset() + "");
            }
        });
    }
    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: ");
        visible.setText(count.plus(Integer.parseInt(visible.getText().toString())) + "");
        super.onStart();
    }
    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
    //Save info
        SharedPreferences.Editor editor = getSharedPreferences("MyShared", MODE_PRIVATE).edit();
        editor.putString("creations", creations.getText().toString());
        editor.putString("visible", visible.getText().toString());
        editor.putString("hit", hitCounter.getText().toString());
        editor.apply();
        super.onPause();
    }
    //fir log in LogCat
    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }
    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: ");
        super.onRestart();
    }
    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}



