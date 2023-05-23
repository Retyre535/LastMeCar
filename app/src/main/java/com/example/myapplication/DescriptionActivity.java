package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityDescriptionBinding;

import java.util.ArrayList;
import java.util.List;

public class DescriptionActivity extends AppCompatActivity {

    ActivityDescriptionBinding binding;
    List<String> descriptions = new ArrayList<>();
    List<Uri> yandex = new ArrayList<>();
    List<Uri> aliexpress = new ArrayList<>();
    List<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        descriptions.add("A car model with 4 motors, one for each wheel, with 3 series-connected 18650 batteries, an Arduino Uno board, an L298P expansion board, as well as an ESP-8266 WIFI module");
        descriptions.add("Arduino Uno is a microcontroller board based on the ATmega328P");
        descriptions.add("Piranha UNO R3 is an analogue Arduino Uno");
        descriptions.add("TF Mini Plus is a laser rangefinder module.");
        descriptions.add("A speaker with a resistance of 8 ohms and a power of 0.5 watts");
        descriptions.add("A motor with a gearbox with an increased torque.");
        descriptions.add("MG90S micro size servo.");
        descriptions.add("ESP8266-12F is an improved version of ESP8266-12 which is a Wi-Fi module for a network solution that allows you to use it without an additional controller.");
        descriptions.add("stl case file for editing and self-printing");
        descriptions.add("Finished case printed with pla plastic according to the original table file");
        descriptions.add("3 series connected 18650 form factor batteries. Voltage 3.7 V, capacity 3000 mAh");
        descriptions.add("The Motor Shield L298P expansion board is a DC motor driver based on the L298P chip.");

        yandex.add(Uri.parse("https://market.yandex.ru/"));
        yandex.add(Uri.parse("https://market.yandex.ru/product--uno-r3-arduino-sovmestimaia-s-provodom/1401531643?text=arduino%20uno&cpa=1&cpc=HQ1-o7OyARBfxwtzijr6KFF9jeyoxNmBQ6pscJK0r2AmXal9Txam8JARWeebmYH-Pm4Wo3vgTkZBcGwwcyvfS7YEzjLPku1Gh2hFS2zPNYnAPv0fxDrdoGx8UWJHw_8zh-TJx8BySVfRbd47L9KwuO3YOyKk_4HqdfUHoyyHq-a0PsjE2DlSNkLtFZ8TKoudDVZw19GQLTGkHKzmGPV2KzyjTdyPECjqct8j08txZxkIfEEvm-Cacw%2C%2C&rs=eJwzEg9grGLlOPd1PfMsRu7EopTSzLx8hdK8fABm1Qih&sku=101392736557&do-waremd5=lf1qVWxrCZfDbLZAs_SG_g&nid=61856"));
        yandex.add(Uri.parse("https://iarduino.ru/shop/boards/piranha-uno-r3.html"));
        yandex.add(Uri.parse("https://market.yandex.ru/"));
        yandex.add(Uri.parse("https://market.yandex.ru/product--dinamik-8-om-0-5-vt-40-mm/1455989961?cpa=1&sku=101470676025"));
        yandex.add(Uri.parse("https://market.yandex.ru/product--tt-motor-dvukhosevoi-motor-s-reduktorom-1-120/1455976054?text=мотор%20с%20редуктором%201%20120&cpa=1&cpc=hgJMWEpNiP2QS-NjQjzHVlOwjknUMkNlviIxaGVVTe5M3LZ_NPe6ze3gIXN1Y4AqH3jts7O6dooq1PaSTsLz19gv3MbdhSgvCpMWWUu7VquYRoYAwyzw9R8zRwyXinNALuHnyAl78OgvfLYHn_DJjs_qsed3Ci8F2nskSENWbFSX9YSQap1sFeYFHtlsBheaQ-XHAyBpSvc%2C&sku=101470649995&do-waremd5=krnoHpA0YBh98nsSvp-b9g&nid=61856"));
        yandex.add(Uri.parse("https://market.yandex.ru/product--servoprivod-mg90s-micro/1816008237?text=Серводвигатель%20MG90S&cpa=1&cpc=3u4IRlpXDtLfRzA77UqJnS7mP0tuTBQJYu3cXs3zhqcNSOFXUHIJiz5iqJxlno3ul9sHFJRhKNU1hBk5kDLJGuLBnhUX031Rut-g-uYyF86idlkjhKr0a8pfaxfI3tR7Rw0kuQbdMLOGTfxaiviR-UIEMeHHUF-xDb4-43cAXP6Lggh1DE3LEcwc3sKT3azErFsjZySuD8U%2C&sku=101933975611&do-waremd5=-QzBn8DXXQFRmCms312jPQ&nid=18042100"));
        yandex.add(Uri.parse("https://market.yandex.ru/"));
        yandex.add(Uri.parse("https://market.yandex.ru/"));
        yandex.add(Uri.parse("https://market.yandex.ru/"));
        yandex.add(Uri.parse("https://market.yandex.ru/product--akkumuliator-li-ion-3400-ma-ch-3-7-v-liitokala-ncr18650b/673330918?glfilter=14866265%3A16411798_101569450747&text=18650&cpa=1&cpc=LX1NKXvf1Od71VCiV_1Rhqd_YAkMonIoR4ek-oYBMqJrTs2_6mNGAhWm_Y_JG9C2TQ1VYnMHw8v0l49laxFrhgcam_P9TDx72hgjiIuofjIj-JU7bo_sIazY8iPjaHdHgI7m9fRbRQ5VxQsqrUVTpINr5jj1Mu1tmEjECiSUGNH9Jt-B6gWM_iVDKZKPADqkq9NbW-u28MuqVhO04Zz2tgpqicDe7p1sfZnNCyjNRSTYaJXfAQ82XA%2C%2C&rs=eJwzEghgrGLhaDrCOouR1dDCzNQAACZmBAk%2C&sku=101569450747&do-waremd5=rEV_47ZTcQwzA1ad8ptVvQ&nid=26914470"));
        yandex.add(Uri.parse("https://www.yourduino.ru/product/plata-rasshireniya-motor-shield-l298p "));

        aliexpress.add(Uri.parse("https://aliexpress.ru/"));
        aliexpress.add(Uri.parse("https://aliexpress.ru/item/32556087234.html?sku_id=65187219707&spm=a2g2w.productlist.search_results.0.796c4aa6FpoemG"));
        aliexpress.add(Uri.parse("https://aliexpress.ru/"));
        aliexpress.add(Uri.parse("https://aliexpress.ru/item/1005004639041113.html?sku_id=12000031769729740&spm=a2g2w.productlist.search_results.0.45de4aa6e2dVQm "));
        aliexpress.add(Uri.parse("https://aliexpress.ru/item/4000846720000.html?sku_id=10000009338838557&spm=a2g2w.productlist.search_results.0.22bb4aa6nyQ9mK/"));
        aliexpress.add(Uri.parse("https://aliexpress.ru/item/1005004866887109.html?sku_id=12000030808776446&spm=a2g2w.productlist.search_results.3.1e5d4aa65zGAO0"));
        aliexpress.add(Uri.parse("https://aliexpress.ru/item/1005003027312150.html?sku_id=12000023313941703&spm=a2g2w.productlist.search_results.0.7c644aa63JYKAO"));
        aliexpress.add(Uri.parse("https://aliexpress.ru/item/32339917567.html?sku=undefined&sku_id=10000001896064161"));
        aliexpress.add(Uri.parse("https://aliexpress.ru/"));
        aliexpress.add(Uri.parse("https://aliexpress.ru/"));
        aliexpress.add(Uri.parse("https://aliexpress.ru/item/32817391455.html?spm=a2g2w.home.10009201.0.75df5931OcQSD4&_evo_buckets=165609,165598,194275&sku_id=64625047821&gps-id=appJustForYouNewRuSellTab&scm=1007.34525.334770.0&scm_id=1007.34525.334770.0&scm-url=1007.34525.334770.0&pvid=e28a30c5-a90d-40f7-becc-e7cca16c3966&_t=gps-id:appJustForYouNewRuSellTab,scm-url:1007.34525.334770.0,pvid:e28a30c5-a90d-40f7-becc-e7cca16c3966,tpp_buckets:24525%230%23334770%2341_21387%230%23292317%230_21387%239507%23434564%239_21387%2314793%23456925%238&ru_algo_pv_id=e28a30c5-a90d-40f7-becc-e7cca16c3966&scenario=appJustForYouNewRuSellTab&tpp_rcmd_bucket_id=334770&traffic_source=recommendation"));
        aliexpress.add(Uri.parse("https://aliexpress.ru/item/32788447391.html?sku_id=63321907947&spm=a2g2w.productlist.search_results.3.3dad4aa6WAleKX"));

        titles.add("Car");
        titles.add("Arduino UNO");
        titles.add("Piranha UNO");
        titles.add("LiDAR");
        titles.add("Sound module");
        titles.add("Engine");
        titles.add("Servo");
        titles.add("Wi-Fi module");
        titles.add("STL");
        titles.add("Machine body");
        titles.add("Batteries");
        titles.add("Engines Shield");

        Bundle arguments = getIntent().getExtras();
        int a = arguments.getInt("key");
        binding.description.setText(descriptions.get(a));
        binding.title.setText(titles.get(a));
        if (a == 0 || a == 3 || a == 7 || a == 8 || a == 9) binding.yandexMarket.setImageResource(R.drawable.yandex_no);
        if (a == 0 || a == 8 || a == 9 || a == 2) binding.aliexpress.setImageResource(R.drawable.aliexpress_no);
        if (a == 2) binding.yandexMarket.setImageResource(R.drawable.iarduino);
        if (a == 11) binding.yandexMarket.setImageResource(R.drawable.yourduino);
        binding.telegram.setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/retyre535"));
            view.getContext().startActivity(browserIntent);
        });
        binding.yandexMarket.setOnClickListener(view -> {
            if (a == 0 || a == 8 || a == 9 || a == 3 || a == 7)
                Toast.makeText(this, "The product is not available on the Yandex market", Toast.LENGTH_SHORT).show();
            else {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, yandex.get(a));
                view.getContext().startActivity(browserIntent);
            }
        });
        binding.aliexpress.setOnClickListener(view -> {
            if (a == 0 || a == 8 || a == 9 || a == 2)
                Toast.makeText(this, "The product is not available on the aliexpress", Toast.LENGTH_SHORT).show();
            else {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, aliexpress.get(a));
                view.getContext().startActivity(browserIntent);
            }
        });
    }
}