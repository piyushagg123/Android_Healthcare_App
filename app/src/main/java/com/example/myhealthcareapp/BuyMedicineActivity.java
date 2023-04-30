package com.example.myhealthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Uprise-D3 1000IU Capsule","","","","50"},
            {"Healthwit chromium capsules","","","","350"},
            {"Vitamin B complex capsules","","","","540"},
            {"Inlife vitamin E wheat germ oil capsule","","","","506"},
            {"Dolo 650 tablet","","","","750"},
            {"Crocin 650 Advance Tabet","","","","650"},
            {"Strepsils Medicated Lozenges for Sore Throat","","","","250"},
            {"Tata 1mg Calcium + Vitamin D3","","","","508"},
            {"Feronia Tablet","","","","950"}
    };

    private String[] package_details = {
            "Building and keeping the bones and teeth strong\n"+
                    "Reducing fatigue and muscular pain\n"+
                    "Boosting immunity and increasing resistance against infection",
            "Chromium is an essential trace mineral that plays an imp role in helping",
            "Provide releif from vitamin B deficiencies\n"+
                    "Helps in formation of RBCs\n"+
                    "Maintains healthy nervous systems",
            "it promotes health as well as skin benefit\n"+
                    "it reduce skin blemish and pigmentation\n"+
                    "it act as safeguard",
            "Dolo 650 tablet helps releive pain and fever",
            "helps relieve fever and bring down high temp\n"+
                    "Suitable fro people with heart condition or high BP",
            "Relief the symptoms of bacterial throat affection and soothes recovery process\n"+
                    "Provides warm feeling",
            "Reduces risk for calcium deficiency\n"+
                    "Promote mobility of joints",
            "Helps to reduce iron deficiency due to chronic blood loss or low intake of iron"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost: "+packages[i][0]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[position][0]);
                it.putExtra("text2",packages[position]);
                it.putExtra("text3",packages[position][4]);
            }
        });
    }
}