package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button tapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tapButton = (Button) findViewById(R.id.myButton);
        tapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

            }
        });

    }
}
