package com.example.mathclub;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText taskNumberGet;
//
    private TextView tv;

    public int c;

    String[] avaibleMaterial = {"k61"};

    String variant = "";

    ImageView iv;

    public int part = 0;
    public int classN = 0;
    public String nameBook = "n";

    String[] classArr = {"Выберите класс", "1 класс" , "2 класс", "3 класс", "4 класс", "5 класс", "6 класс" , "7 класс", "8 класс", "9 класс" , "10 класс", "11 класс", "12 класс"};
    String[] partsArr = {"Выберите часть", "1 часть" , "2 часть"};
    String[] prodsArr = {"Выберите издателя", "avita" , "kolibri"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.iv);











        ArrayAdapter<String> adapterClass = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classArr);
        adapterClass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapterPart = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, partsArr);
        adapterPart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> adapterProd = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, prodsArr);
        adapterProd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);






        Spinner spinnerProd = findViewById(R.id.spinnerProd);

        spinnerProd.setAdapter(adapterProd);

        spinnerProd.setSelection(0); // Установите "Выберите класс" как выбранный элемент по умолчанию

        spinnerProd.setPopupBackgroundResource(R.drawable.spinnerlistbg);



        Spinner spinnerPart = findViewById(R.id.spinnerPart);

        spinnerPart.setAdapter(adapterPart);

        spinnerPart.setSelection(0); // Установите "Выберите класс" как выбранный элемент по умолчанию

        spinnerPart.setPopupBackgroundResource(R.drawable.spinnerlistbg);





        Spinner spinnerClass = findViewById(R.id.spinnerClass);

        spinnerClass.setAdapter(adapterClass);

        spinnerClass.setSelection(0); // Установите "Выберите класс" как выбранный элемент по умолчанию

        spinnerClass.setPopupBackgroundResource(R.drawable.spinnerlistbg);



        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedItem = (String) parentView.getItemAtPosition(position);









                if (!selectedItem.equals("Выберите класс")) {


                    if (!selectedItem.equals("Выберите класс")) {
                        if (selectedItem.equals("12 класс") || selectedItem.equals("11 класс") || selectedItem.equals("10 класс")) {
                            try {
                                classN = Integer.parseInt(selectedItem.substring(0, 2)); // Преобразуем в int первые две символа
                            } catch (NumberFormatException e) {
                                e.printStackTrace(); // Вывод исключения в лог
                            }

                        } else {
                            try {
                                classN = Integer.parseInt(selectedItem.substring(0, 1)); // Преобразуем в int первый символ
                            } catch (NumberFormatException e) {
                                e.printStackTrace(); // Вывод исключения в лог
                            }
                        }
                    }


                    updateVariantAndTextView();


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Обработка случая, когда ничего не выбрано
            }
        });











        spinnerPart.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedItem = (String) parentView.getItemAtPosition(position);


                if (!selectedItem.equals("Выберите часть")) {


                    try {
                        part = Integer.parseInt(selectedItem.substring(0, 1)); // Преобразуем в int
                        // Теперь classN содержит целое число из обрезанной строки
                    } catch (NumberFormatException e) {
                        e.printStackTrace(); // Вывод исключения в лог
                    }


                }

                updateVariantAndTextView();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Обработка случая, когда ничего не выбрано
            }
        });









        spinnerProd.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedItem = (String) parentView.getItemAtPosition(position);
                if (!selectedItem.equals("Выберите издателя")) {



                    nameBook = String.valueOf(selectedItem.charAt(0));



                }



                updateVariantAndTextView();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Обработка случая, когда ничего не выбрано
            }
        });













    }

    public void startNewActivity(View v){
        if (classN != 0 && part != 0 && !nameBook.equals(null)){
            for (int i = 0; i < avaibleMaterial.length; i++) {

                if (variant.equals(avaibleMaterial[i])){
                    Intent intent = new Intent(this, show.class);
                    intent.putExtra("VARIANT", variant);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(this, "Пока что нет в наличии", Toast.LENGTH_SHORT).show();
                }

            }

        }
        else{
            Toast.makeText(this, "Пожалуйста выберите свой учебник", Toast.LENGTH_SHORT).show();
        }



    }

    // Метод для обновления variant и TextView
    private void updateVariantAndTextView() {
        String classNum;

        variant = nameBook + classN + "" + part;
        classNum = String.valueOf(classN);


        String imageName = variant.substring(0, variant.length() - 1);

        int resourceId = 0;

//             Получите ресурс по имени
        if (imageName.length() == 2) {
            resourceId = getResources().getIdentifier(imageName, "drawable", getPackageName());


//             Проверьте, существует ли ресурс с указанным именем
//             Если ресурс существует, установите его как изображение в ImageView


            iv.setImageResource(resourceId);
            iv.setVisibility(View.VISIBLE);


        } else if (imageName.length() == 3) {
            Toast.makeText(this, "Пока что нет в наличии", Toast.LENGTH_SHORT).show();
        }

    }
}



//                if (selectedItem.equals("7 класс")){
//                    ArrayAdapter<String> adapterPart = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, new String[]{"Выберите часть", "1 часть"});
//                    adapterPart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    spinnerPart.setAdapter(adapterPart);
//
//                } else if (selectedItem.equals("6 класс")) {
//                    ArrayAdapter<String> adapterPart = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, new String[]{"Выберите часть", "1 часть", "2 часть"});
//                    adapterPart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    spinnerPart.setAdapter(adapterPart);
//                }
//
//                else {
//                    ArrayAdapter<String> adapterPart = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, partsArr);
//                    adapterPart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    spinnerPart.setAdapter(adapterPart);
//                }
// Spinner от Spinner


