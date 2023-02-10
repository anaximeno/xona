package pdm.group.uno.xona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pdm.group.uno.xona.entities.User;

public class FirstName extends AppCompatActivity {
    TextView textViewName;
    Button btnContinue;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_name);

        textViewName = findViewById(R.id.textViewName);
        btnContinue = findViewById(R.id.btnContinue);

        textViewName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(textViewName.getText().length() > 0) {
                    btnContinue.setBackgroundColor(getResources().getColor(R.color.pink));
                }else  {
                    btnContinue.setBackgroundColor(getResources().getColor(com.cometchat.pro.uikit.R.color.grey_100));
                }
            }
        });

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FirstName.this, Birthday.class);
                User user = (User) getIntent().getSerializableExtra("user");
                i.putExtra("user", user);
                startActivity(i);
            }
        });
    }
}