package pdm.group.uno.xona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import pdm.group.uno.xona.entities.User;

public class AgreeToRulesActivity extends AppCompatActivity {

    Button btn_i_agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agree_to_rules);

        btn_i_agree = findViewById(R.id.btn_i_agree);

        btn_i_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = (User) getIntent().getSerializableExtra("user");
                Intent i = new Intent(AgreeToRulesActivity.this, FirstName.class);
                i.putExtra("user", user);
                startActivity(i);
            }
        });

    }
}