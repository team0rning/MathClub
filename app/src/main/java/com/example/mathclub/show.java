package com.example.mathclub;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class show extends AppCompatActivity {



    TextView taskDescriptionName;
    EditText taskNumberGet2;


    TextView errorMessage;
    ImageView imageView;
    TextView error;




    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


        Resources resources = getResources();
        imageView = findViewById(R.id.imageView);
        error = findViewById(R.id.error);
        errorMessage = findViewById(R.id.errorMessage);
        taskNumberGet2 = findViewById(R.id.taskNumberGet2);
        taskDescriptionName = findViewById(R.id.taskDescriptionName);






    } //main end

    private void displayMessage(String message) {
        errorMessage.setText(message);
        errorMessage.setVisibility(View.VISIBLE);

        // Установите задержку для скрытия сообщения
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                errorMessage.setVisibility(View.GONE);
            }
        }, 3000);
    }






    public void backToList(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void search2(View v){

            // Преобразуем текст в целое число

        String be = taskNumberGet2.getText().toString();

        int al = 0;
        if (TextUtils.isEmpty(be)) {
            taskDescriptionName.setText("номер отсутствует");
            imageView.setImageResource(R.drawable.anythinsfound);
            displayMessage("Введите номер");
        } else {
            al = Integer.parseInt(be);






            ImageView imageView = findViewById(R.id.imageView);

            // Замените 'image_name' на имя ресурса, которое зависит от вашей переменной int
            int yourIntVariable = al; // Ваша переменная int

            String variant = getIntent().getStringExtra("VARIANT");
            String imageName = variant + "n" + yourIntVariable;

            // Получите ресурс по имени
            int resourceId = getResources().getIdentifier(imageName, "drawable", getPackageName());

            // Проверьте, существует ли ресурс с указанным именем
            if (resourceId != 0) {
                errorMessage.setText("");
                // Если ресурс существует, установите его как изображение в ImageView
                imageView.setImageResource(resourceId);
                imageView.setVisibility(View.VISIBLE);
            } else {
                if (al > 0 && al < 593){


                    displayMessage("Данное задание устное, \n переходи к следующему! \n устно - значит можно не делать :)");
                    imageView.setVisibility(View.INVISIBLE);


                }
                else{
                    displayMessage("Задание не найдено. \n Проверьте номер задания");
                    imageView.setVisibility(View.INVISIBLE);
                }
                // Обработка случая, если ресурс не найден
                // Можно установить изображение по умолчанию или выполнить другие действия
            }
        }


















    }



    private void showInfoAlert(String title, String text){
        AlertDialog.Builder builder = new AlertDialog.Builder(show.this);
        builder.setTitle(title)
                .setTitle(Html.fromHtml("<font color='#000000'>" + title + "</font>"))
                .setMessage(text)
                .setMessage(Html.fromHtml("<font color='#000000'>" + text + "</font>"))
                .setCancelable(false)
                .setNegativeButton("Закрыть", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawableResource(R.color.white);

        Button positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        positiveButton.setTextColor(getResources().getColor(R.color.black));
        Button negativeButton = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        negativeButton.setTextColor(getResources().getColor(R.color.black));

    }


}