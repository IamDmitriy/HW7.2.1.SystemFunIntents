package com.example.hw721systemfunintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        final EditText edtSearch = findViewById(R.id.edtSearch);
        Button btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = edtSearch.getText().toString();
                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Введите данные!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Uri uri;
                if (Character.isLetter(input.charAt(0))) {
                    uri = Uri.parse("geo:?q=" + input);
                } else {
                    uri = Uri.parse("geo:" + input);
                }

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
    }
}
