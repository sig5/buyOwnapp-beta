package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maindetailpage);
        int p=getIntent().getIntExtra("position",0);
        TextView bookname=findViewById(R.id.bookname);
        TextView bookauthor=findViewById(R.id.bookauthor);
        TextView bookdescription=findViewById(R.id.bookdescription);
        TextView bookprice=findViewById(R.id.bookprice);
        TextView bookgenre=findViewById(R.id.bookgenre);
        ImageView frontcover=findViewById(R.id.frontcover);
        {bookname.setText(MyData.name.get(p));
        bookauthor.setText(MyData.authorname.get(p));
        bookprice.setText(MyData.price.get(p));
        bookdescription.setText(MyData.description.get(p));}
        ImageButton back=findViewById(R.id.backimage);
        MenuItem logout=findViewById(R.id.logout);
        Button seller_button=findViewById(R.id.sellerbutton);
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        TextView address=dialog.findViewById(R.id.address);
        address.setText(MyData.address.get(p));
        dialog.setTitle("hehe");
        seller_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


dialog.show();

            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        byte[] decode= Base64.decode(MyData.image.get(p),Base64.DEFAULT);

        Bitmap decoded= BitmapFactory.decodeByteArray(decode,0,decode.length);
        if(decoded!=null)
        frontcover.setImageBitmap(decoded);
        else {
           frontcover.setImageDrawable(getDrawable(R.drawable.pic2));
        }
    }
}
