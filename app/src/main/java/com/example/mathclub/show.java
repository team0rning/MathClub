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


//    TextView taskDescription;
    TextView taskDescriptionName;
    EditText taskNumberGet2;


    TextView errorMessage;
//    TextView taskNumber;

    ImageView imageView;

    TextView error;

//    int[] menuListTasks = {3};
    int[] oralTasks = {2, 5, 7, 211, 202, 206};

    public int truee;

    public String[] allTasksName = new String[100];
    public String[] allTasksanswer = new String[100];
    public int[] allTasksN = new int[592];


    public String[] allTasks = new String[592];
    public String[] allTasksR = new String[592];

    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


//        taskDescription = findViewById(R.id.taskDescription);

        Resources resources = getResources();

        imageView = findViewById(R.id.imageView);

        error = findViewById(R.id.error);

        errorMessage = findViewById(R.id.errorMessage);

        taskNumberGet2 = findViewById(R.id.taskNumberGet2);

        taskDescriptionName = findViewById(R.id.taskDescriptionName);

        for (int i = 0; i < allTasksN.length; i++) {
            allTasksN[i] = i + 1;
        }
        for (int i = 0; i < 593; i++) {

        }






//        allTasks[0] = "Задача 1\n";
//        allTasks[1] = "Задача 2\n";
//        allTasks[2] = "Задача 3\n";
//        allTasks[3] = "Задача 4\n";
//
//
//        allTasksR[0] = "1) 259200сек. = 72часа.- пища. 2)48600мин. = 810час.- сон. 3) 162час.- чтение. 4) 10800мин. = 180час.- набл. за природ. 5) 4ч * 92дня = 368ч.- работа. 6) 2.2ч * 92дня = 202.4ч. - спорт. 7) 2208час. - 1,794.4час. = 413.6час. - развлечения. 8) 1.еда, 2.чтение, 3.набл. за природ. 4.спорт, 5.работа, 6.развлечения, 7.сон";
//        allTasksR[1] = "8040 - Восемь тысяч сорок.\n" +
//                "1/2 - Одна вторая или половина.\n" +
//                "30007 - Тридцать тысяч семь.\n" +
//                "0,508 - Пятьсот восемь тысячных или ноль целых, пятьсот восемь тысячных.\n" +
//                "2/3 - Две третьих или две из трех частей.\n" +
//                "450000000 - Четыреста пятьдесят миллионов.\n" +
//                "8,02 - Восемь целых, две сотых.\n" +
//                "2300100000 - Два миллиарда триста миллиона десять тысяч.";
//        allTasksR[2] = "1) груши - 2 из 10 - 2/10, яблоки - 3 из 10 - 3/10, сливы - 5 из 10 - 5/10(половина). 2) мальчики - 3 из 8 - 3/8, чёр. вол. - 4 из 8 -4/8(половина). 3) чёрные - 3 из 8 - 3/8, не красные - 5/10(половина). 4) не закрашено - 3/8";
//        allTasksR[3] = "1) на 2 части, не закраш. - 4/6. 2) на 5 частей, не закраш. - 4/5. 3) на 4 части - 1/4";







        // Попытка открыть текстовый файл и считать его содержимое
        try {
            InputStream inputStream = resources.openRawResource(R.raw.alltasksdescription);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);



            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                allTasksName[i] = line;
                i++;
            }


            // Закрываем потоки
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();


            //решение

            InputStream inputStreamresult = resources.openRawResource(R.raw.alltasksanswer);
            InputStreamReader inputStreamReaderesult = new InputStreamReader(inputStreamresult);
            BufferedReader bufferedReaderresult = new BufferedReader(inputStreamReaderesult);

            String linee;
            int in = 0;
            while ((linee = bufferedReaderresult.readLine()) != null) {
                allTasksanswer[in] = linee;
                in++;
            }

            bufferedReaderresult.close();
            inputStreamReaderesult.close();
            inputStreamresult.close();

        } catch (IOException e) {
            // Обработка исключения, если что-то пошло не так
            e.printStackTrace();
        }















//        Intent intent = getIntent();
//        int taskGot = intent.getIntExtra("num", 0);

//    if (taskGot > 0 && taskGot < 593){
//        try {
//            taskDescriptionName.setText("Упражнение № " + allTasksN[taskGot-1]);
//            taskDescription.setText(allTasksName[taskGot-1]);
////            taskNumber.setText(allTasksN[taskGot-1]);
//
//        }catch (Exception e){
//            System.out.println("press f");
//        }
//    }
//    else {
//        taskDescription.setText("Не верное задание");
//        taskDescriptionName.setText("Не верный номер");
//    }






    } //main end


//    public void setResult(View view){
//        Intent intent = getIntent();
//
//        if (truee > 0){
//            try {
//                taskDescription.setText(allTasksanswer[truee-1]);
//            }catch (Exception e){
//                System.out.println("press fe");
//            }
//        }
//
//
//        else {
//
//            int taskGot = intent.getIntExtra("num", 0);
//            try {
//                taskDescription.setText(allTasksanswer[taskGot-1]);
//            }catch (Exception e){
//                System.out.println("press fe");
//            }
//        }


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
//
//
//
//
//
//        }


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


            truee = al;


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

//                errorMessage.setText("Данное задание устное, \n переходи к следующему! \n устно - значит можно не делать :)");
                    imageView.setVisibility(View.INVISIBLE);
//                taskDescriptionName.setText("Устное задание");
//                imageView.setImageResource(R.drawable.anythinsfound);
//                showInfoAlert("Переходи к следующему", "Устно - значит можно не делать :)");

                }
                else{
                    displayMessage("Задание не найдено. \n Проверьте номер задания");
                    imageView.setVisibility(View.INVISIBLE);
//                taskDescriptionName.setText("Не верный номер");
//                imageView.setImageResource(R.drawable.anythinsfound);
//                showInfoAlert("Задание не найдено", "Проверьте номер задания");
                }
                // Обработка случая, если ресурс не найден
                // Можно установить изображение по умолчанию или выполнить другие действия
            }
        }












        if (al > 0 && al < 593){
            try {
                taskDescriptionName.setText("Упражнение № " + allTasksN[al-1]);
//                taskDescription.setText(allTasksName[al-1]);
//            taskNumber.setText(allTasksN[taskGot-1]);

            }catch (Exception e){
                System.out.println("press f");
            }
        }
//        else {
////            taskDescription.setText("Не верное задание");
//            taskDescriptionName.setText("Не верный номер");
//            imageView.setImageResource(R.drawable.anythinsfound);
//            showInfoAlert("Задание не найдено", "Проверьте номер задания");
//        }
//
//
//        for (int i = 0; i < oralTasks.length; i++) {
//            if (al == oralTasks[i]){
//                taskDescriptionName.setText("Устное задание");
//                imageView.setImageResource(R.drawable.anythinsfound);
//                showInfoAlert("Переходи к следующему", "Устно - значит можно не делать :)");
//            }
//        }




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