package com.example.dailygoals;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<CheckBox> goalsList = new ArrayList<CheckBox>();

        EditText txtInputGoals = findViewById(R.id.txtInputGoals);
        Button btnGoals = findViewById(R.id.btnGoals);
        ProgressBar proBarGoals = findViewById(R.id.proBarGoals);

        proBarGoals.setMax(goalsList.size());
        proBarGoals.setProgress(95);

        btnGoals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                CheckBox check = new CheckBox(MainActivity.this);
                check.setText(txtInputGoals.getText().toString());

                goalsList.add(check);
                addGoals(goalsList, proBarGoals);
            }
        });
    }

    protected void addGoals(ArrayList<CheckBox> goalsList,  ProgressBar proBarGoals){
        LinearLayout linearGoals = findViewById(R.id.linearGoals);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        float density = getResources().getDisplayMetrics().density;
        params.setMargins((int)(16 * density), (int)(8 * density), (int)(16 * density), (int)(8 * density));

        Typeface myFont = ResourcesCompat.getFont(this, R.font.adlam_display);


        for(CheckBox checkbx : goalsList){
            linearGoals.removeView(checkbx);

            checkbx.setOnClickListener((View v) ->{


                CheckBox check = (CheckBox) v;

                if(check.isChecked()) {
                    System.out.println("COOLL");
                    proBarGoals.setProgress(proBarGoals.getProgress() + 1);
                } else{
                    proBarGoals.setProgress(proBarGoals.getProgress() - 1);
                }


            });

            checkbx.setTypeface(myFont);

            linearGoals.addView(checkbx, params);

        }

        proBarGoals.setMax(goalsList.size());
    }


}