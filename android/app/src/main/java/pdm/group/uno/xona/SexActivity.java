package pdm.group.uno.xona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SexActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_woman, btn_man, btn_other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sex);

        btn_woman = (Button) findViewById(R.id.button_woman);
        btn_woman.setOnClickListener(this);

        btn_man = (Button) findViewById(R.id.button_man);
        btn_man.setOnClickListener(this);

        btn_other = (Button) findViewById(R.id.button_other);
        btn_other.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_woman:
                openRelationshipActivity("female");
                break;
            case R.id.button_man:
                openRelationshipActivity("male");
                break;
            case R.id.button_other:
                openRelationshipActivity("other");
                break;
        }
    }

    private void openRelationshipActivity(String sex){

//        Intent intent = new Intent(this,RelationshipActivity.class);
//
//        intent.putExtra("sex",sex);
//        startActivity(intent);

    }
}