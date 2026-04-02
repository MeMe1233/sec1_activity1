package com.example.activity1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.activity1.DataAccess.Chocolates;
import com.example.activity1.DataAccess.ChocolatesDA;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lstCH;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //write my code start from here
        lstCH = findViewById(R.id.lstCH);//وسيط R
        searchView = findViewById(R.id.searchView);

        ChocolatesDA da = new ChocolatesDA();
        List<Chocolates> CH = da.getCH();

        ArrayAdapter<Chocolates>adapter = new ArrayAdapter<>( this,
                android.R.layout.simple_list_item_1, CH
        );

        lstCH.setAdapter(adapter);

        lstCH.setOnItemClickListener((parent, view, position, id) -> {

            Chocolates selectedChocolate = CH.get(position);

            String msg = "Name: " + selectedChocolate.getName() + "\n" +
                    "Price: " + selectedChocolate.getPrice();

            Toast.makeText(MainActivity.this, msg,
                    Toast.LENGTH_SHORT).show();

        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //https://youtu.be/VTrQ4hRAwqI?si=8YisJYnEimq9ti-4
                adapter.getFilter().filter(newText);
                return true;
            }
        });
    }
}