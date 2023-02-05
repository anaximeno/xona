package pdm.group.uno.xona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class InitialActivity extends AppCompatActivity {

    private Button create_account, sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_initial);

        create_account = (Button) findViewById(R.id.button_create);
        sign = (Button) findViewById(R.id.button_sign);

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InitialActivity.this, CreateAccountActivity.class);
                startActivity(i);


            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(InitialActivity.this, SignActivity.class);
                startActivity(i);


            }
        });

    }
}