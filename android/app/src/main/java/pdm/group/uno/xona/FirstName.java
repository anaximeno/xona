package pdm.group.uno.xona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

public class FirstName extends AppCompatActivity {
    TextView textViewName;
    Button btnContinue;
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
    }
}