package pdm.group.uno.xona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Birthday extends AppCompatActivity {
    EditText editTextDate;
    Button btnContinue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);

        editTextDate = findViewById(R.id.editTextDate);
        btnContinue2 = findViewById(R.id.btnContinue2);

        editTextDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editTextDate.getText().length() > 0) {
                    btnContinue2.setBackgroundColor(getResources().getColor(R.color.pink));
                }else  {
                    btnContinue2.setBackgroundColor(getResources().getColor(com.cometchat.pro.uikit.R.color.grey_100));
                }
            }
        });
    }
}