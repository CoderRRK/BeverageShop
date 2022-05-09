package android.example.beverageshop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    String[] addresses = {"rrkomlev@gmail.com"};
    String subject = "Заказ из магазина напитков";
    String emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setTitle("Ваш заказ");


        Intent receivedOrderIntent = getIntent();
        String userName = receivedOrderIntent.getStringExtra("userNameForIntent");
        String address = receivedOrderIntent.getStringExtra("addressForIntent");
        String phoneNumber = receivedOrderIntent.getStringExtra("phoneNumberForIntent");
        String itemName = receivedOrderIntent.getStringExtra("itemNameForIntent");
        int quantity = receivedOrderIntent.getIntExtra("quantityForIntent",0);
        double price = receivedOrderIntent.getDoubleExtra("priceForIntent",0.0);
        double orderPrice = receivedOrderIntent.getDoubleExtra("orderPriceForIntent",0.0);

        emailText =
                " " + "Ваши данные для заказа:" +"\n"+
                "   " + "Имя: " + userName +"\n"+
                "   " + "Адрес доставки: " + address + "\n"+
                "   " + "Контактный номер: " + phoneNumber + "\n"+
                "   " + "Наименование товара: " + itemName + "\n"+
                "   " + "Стоимость товара: " + price + "\n"+
                "   " + "Количество: " + quantity +"\n"+
                "   " + "Общая стоимость: " + orderPrice;

        TextView orderTextView = findViewById(R.id.orderTextView);

        orderTextView.setText(emailText);
    }

    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}

