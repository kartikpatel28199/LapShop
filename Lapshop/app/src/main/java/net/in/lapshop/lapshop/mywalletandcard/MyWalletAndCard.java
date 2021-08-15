package net.in.lapshop.lapshop.mywalletandcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import net.in.lapshop.lapshop.R;

public class MyWalletAndCard extends AppCompatActivity {

    TextView addcard,addgiftcard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet_and_card);
        addcard=findViewById(R.id.mywalletandcard_addcard);
        addgiftcard=findViewById(R.id.mywalletandcard_addgiftcard);
        addcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyWalletAndCard.this,AddCardDetails.class));
            }
        });
        addgiftcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyWalletAndCard.this,AddGiftCard.class));
            }
        });
    }
}
