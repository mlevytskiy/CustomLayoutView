package com.example.maksbkstgcom.customlayoutview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CustomLayoutView customLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customLayout = (CustomLayoutView) findViewById(R.id.custom_layout);
        ((Button) findViewById(R.id.plus)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) findViewById(R.id.text_view);
                int newValue = Integer.valueOf(textView.getText().toString()) + 1;
                if (newValue <= 10) {
                    textView.setText(String.valueOf(newValue));
                    customLayout.setCustomCount(newValue);
                    customLayout.requestLayout();
                }
            }
        });
        ((Button) findViewById(R.id.minus)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) findViewById(R.id.text_view);
                int newValue = Integer.valueOf(textView.getText().toString()) - 1;
                if (newValue > 0) {
                    textView.setText(String.valueOf(newValue));
                    customLayout.setCustomCount(newValue);
                    customLayout.requestLayout();
                }
            }
        });

    }

}
