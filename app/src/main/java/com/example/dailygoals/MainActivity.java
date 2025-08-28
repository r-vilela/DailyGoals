package com.example.dailygoals;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
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
        btnGoals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String mensagem = "Texto informado: ";
                if (!txtInputGoals.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, mensagem + txtInputGoals.getText().toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    protected void addGoals(ArrayList<CheckBox> goalsList){
        LinearLayout linearGoals = findViewById(R.id.linearGoals);

        LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        for(CheckBox checkbx : goalsList){
            checkbx.setLayoutParams(layoutParam);

            linearGoals.addView(checkbx);

        }
    }
}