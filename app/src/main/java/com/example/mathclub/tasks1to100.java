package com.example.mathclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class tasks1to100 extends AppCompatActivity {

    private fragment_first firstFragment = new fragment_first();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks1to100);


    }

    public void showT1(View view){
        Intent intent = new Intent(this, show.class);
//        String ff = allTasks[0];
//        intent.putExtra("task", ff);
        startActivity(intent);
    }

    public void showT2(View view){
        Intent intent = new Intent(this, show.class);
//        String ff = allTasks[1];
//        intent.putExtra("task", ff);
        startActivity(intent);
    }

    public void showT3(View view){
        Intent intent = new Intent(this, show.class);
//        String ff = allTasks[2];
//        intent.putExtra("task", ff);
        startActivity(intent);
    }

    public void showT4(View view){
        Intent intent = new Intent(this, show.class);
//        String ff = allTasks[3];
//        intent.putExtra("task", ff);
        startActivity(intent);
    }

    public void showT5(View view){
        Intent intent = new Intent(this, show.class);
//        String ff = allTasks[4];
//        intent.putExtra("task", ff);
        startActivity(intent);
    }


    private void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}