package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewActivity extends AppCompatActivity {
    private int REQUESR_RE = 202;

    PreferenceManager pref;
    TextView view_title;
    TextView view_content;
    Button back_list_btn;
    Button re_btn;

    String title;
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        pref = new PreferenceManager();
        view_title = findViewById(R.id.view_title);
        view_content = findViewById(R.id.view_content);
        back_list_btn = findViewById(R.id.back_list_btn);
        re_btn = findViewById(R.id.re_btn);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        String value = pref.getString(getApplication(),key);
        try {
            JSONObject jsonObject = new JSONObject(value);
            String title = (String) jsonObject.getString("title");
            String content = (String) jsonObject.getString("content");
            view_title.setText(title);
            view_content.setText(content);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        back_list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}