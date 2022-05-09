package android.example.beverageshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantity = 0;
    Spinner spinnerCategories;
    Spinner spinnerItem;
    ArrayList spinnerArrayListCategories;
    ArrayList spinnerArrayListItem;
    ArrayAdapter spinnerAdapterCategories;
    ArrayAdapter spinnerAdapterItem;
    String itemName;
    HashMap itemMap;
    double price;
    EditText userName;
    EditText address;
    EditText phoneNumber;
    ImageView imageItemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.editTextPersonName);
        address = findViewById(R.id.editTextAddress);
        phoneNumber = findViewById(R.id.editTextPhoneNumber);
        HashMapItem();
        createSpinnerCategories();

    }

    void createSpinnerCategories() {
        spinnerCategories = findViewById(R.id.spinnerCategories);
        spinnerCategories.setOnItemSelectedListener(this);
        spinnerArrayListCategories = new ArrayList();
        spinnerArrayListCategories.add("Чай");
        spinnerArrayListCategories.add("Кофе");
        spinnerArrayListCategories.add( "Вода");
        spinnerArrayListCategories.add("Сок");
        spinnerAdapterCategories = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayListCategories);
        spinnerAdapterCategories.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategories.setAdapter(spinnerAdapterCategories);
        createSpinnerItem();

    }


    public void HashMapItem() {
        itemMap = new HashMap();
        itemMap.put("Greenfield english edition", 400.00);
        itemMap.put("Greenfield magic yunnan", 400.00);
        itemMap.put("Richard royal english", 345.00);
        itemMap.put("Tess earl grey", 420.00);


        itemMap.put("Carte noire", 320.00);
        itemMap.put("Jackobs", 300.00);
        itemMap.put("Mackcoffee", 250.00);


        itemMap.put("Aqua", 60.00);
        itemMap.put("Святой источник", 40.00);


        itemMap.put("Добрый", 100.00);
        itemMap.put("Фруктовый сад", 120.00);
        itemMap.put("Rich", 200.00);
    }
        //стоимость позиций


    void itemPrice(){
        itemName = spinnerItem.getSelectedItem().toString();
        price = (double) itemMap.get(itemName);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price + " ₽");

    }
    //общая стоимость, калькуляция

    void createSpinnerItem() {
        spinnerItem = findViewById(R.id.spinnerItem);
        spinnerItem.setOnItemSelectedListener(this);
        spinnerArrayListItem = new ArrayList();

        if (spinnerCategories.getSelectedItem().equals("Чай")) {
            spinnerArrayListItem.add("Greenfield english edition");
            spinnerArrayListItem.add("Greenfield magic yunnan");
            spinnerArrayListItem.add("Richard royal english");
            spinnerArrayListItem.add("Tess earl grey");
        } else if (spinnerCategories.getSelectedItem().equals("Кофе")) {
            spinnerArrayListItem.add("Carte noire");
            spinnerArrayListItem.add("Jackobs");
            spinnerArrayListItem.add("Mackcoffee");
        } else if (spinnerCategories.getSelectedItem().equals("Вода")) {
            spinnerArrayListItem.add("Aqua");
            spinnerArrayListItem.add("Святой источник");
        } else if (spinnerCategories.getSelectedItem().equals("Сок")) {
            spinnerArrayListItem.add("Добрый");
            spinnerArrayListItem.add("Фруктовый сад");
            spinnerArrayListItem.add("Rich");
        }

        spinnerAdapterItem = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayListItem);
        spinnerAdapterItem.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerItem.setAdapter(spinnerAdapterItem);
        spinnerCategoriesListener();

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        itemPrice();

        imageItemView = findViewById(R.id.imageItemView);

            itemName = spinnerItem.getSelectedItem().toString();

            switch (itemName) {
                case "Greenfield english edition":
                    imageItemView.setImageResource(R.drawable.tea_greenfield_english_edition);
                    itemPrice();
                    break;
                case "Greenfield magic yunnan":
                    imageItemView.setImageResource(R.drawable.tea_greenfield_magic_yunnan);
                    itemPrice();
                    break;
                case "Richard royal english":
                    imageItemView.setImageResource(R.drawable.tea_richard_royal_english);
                    itemPrice();
                    break;
                case "Tess earl grey":
                    imageItemView.setImageResource(R.drawable.tea_tess_earl_grey);
                    itemPrice();
                    break;

                case "Carte noire":
                    imageItemView.setImageResource(R.drawable.coffe_carte_noire);
                    itemPrice();
                    break;
                case "Jackobs":
                    imageItemView.setImageResource(R.drawable.coffe_jackobs);
                    itemPrice();
                    break;
                case "Mackcoffee":
                    imageItemView.setImageResource(R.drawable.coffe_mackcoffe);
                    itemPrice();
                    break;

                case "Aqua":
                    imageItemView.setImageResource(R.drawable.water_aqua);
                    itemPrice();
                    break;
                case "Святой источник":
                    imageItemView.setImageResource(R.drawable.water_svyatoi_istochnik);
                    itemPrice();
                    break;

                case "Добрый":
                    imageItemView.setImageResource(R.drawable.juice_dobrii);
                    itemPrice();
                    break;
                case "Фруктовый сад":
                    imageItemView.setImageResource(R.drawable.juice_fruktovii_sad);
                    itemPrice();
                    break;
                case "Rich":
                    imageItemView.setImageResource(R.drawable.juice_rich);
                    itemPrice();
                    break;

                default:
                    imageItemView.setImageResource(R.drawable.none);
                    itemPrice();
                    break;
            }
    }

    @Override
    public void onNothingSelected (AdapterView < ? > adapterView){
    }

    private void spinnerCategoriesListener() {
        spinnerCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                createSpinnerItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void decreaseQuantity (View view){
            quantity = quantity - 1;
            if (quantity < 0) {
                quantity = 0;
            }

            TextView quantityTextView = findViewById(R.id.quantityTextView);
            quantityTextView.setText("" + quantity);
            TextView priceTextView = findViewById(R.id.priceTextView);
            priceTextView.setText("" + quantity * price + " ₽");
        }
        //уменьшение количества товара

        public void increaseQuantity (View view){
            quantity = quantity + 1;
            TextView quantityTextView = findViewById(R.id.quantityTextView);
            quantityTextView.setText("" + quantity);
            TextView priceTextView = findViewById(R.id.priceTextView);
            priceTextView.setText("" + quantity * price + " ₽");
        }
        //увеличение количества товара



        public void addToCart (View view){
            Order order = new Order();
            order.userName = userName.getText().toString();
            order.address = address.getText().toString();
            order.phoneNumber = phoneNumber.getText().toString();
            order.itemName = itemName;
            order.quantity = quantity;
            order.price = price;
            order.orderPrice = quantity * price;


            Intent orderIntent = new Intent(MainActivity.this, OrderActivity.class);
            orderIntent.putExtra("userNameForIntent", order.userName);
            orderIntent.putExtra("addressForIntent", order.address);
            orderIntent.putExtra("phoneNumberForIntent", order.phoneNumber);
            orderIntent.putExtra("itemNameForIntent", order.itemName);
            orderIntent.putExtra("quantityForIntent", order.quantity);
            orderIntent.putExtra("priceForIntent", order.price);
            orderIntent.putExtra("orderPriceForIntent", order.orderPrice);

            startActivity(orderIntent);
        }
        //данные на отправку на второй экран
    }