package com.example.casper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditTextActivity extends AppCompatActivity {

    private TextView txt;
    private EditText edt;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_change);

        txt=findViewById(R.id.text_view_language);
        edt=findViewById(R.id.edit_text_country);
        btn=findViewById(R.id.button_change_language);

        btn.setOnClickListener(new myClick());
    }

    class myClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String word=edt.getText().toString();
            String res_text="language_"+word;
            String res_button="change_language_"+word;

            int res_text_id=getResources().getIdentifier(res_text,"string",getPackageName());
            txt.setText(res_text_id);
            int res_button_id=getResources().getIdentifier(res_button,"string",getPackageName());
            btn.setText(res_button_id);
        }
    }
}
