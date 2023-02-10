package pdm.group.uno.xona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileInfoActivity extends AppCompatActivity {

    private Button btn_continue;
    private EditText first_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);

        btn_continue = (Button) findViewById(R.id.button_continue);
        first_name = findViewById(R.id.editTextInputName);

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProfileInfoActivity.this, AgeActivity.class);

                intent.putExtra("first_name", first_name.getText().toString());
                startActivity(intent);

            }
        });


    }
}