package pdm.group.uno.xona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MoreUsersInfoActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_straight, btn_gay, btn_lesbian, btn_bisexual, btn_asexual,
    btn_demisexual,btn_pansexual,btn_queer,btn_questioning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_users_info);


        btn_straight = (Button) findViewById(R.id.button_straight);
        btn_straight.setOnClickListener(this);

        btn_gay = (Button) findViewById(R.id.button_gay);
        btn_gay .setOnClickListener(this);

        btn_lesbian = (Button) findViewById(R.id.button_lesbian);
        btn_lesbian.setOnClickListener(this);

        btn_bisexual = (Button) findViewById(R.id.button_bisexual);
        btn_bisexual.setOnClickListener(this);

        btn_asexual = (Button) findViewById(R.id.button_asexual);
        btn_asexual.setOnClickListener(this);

        btn_demisexual = (Button) findViewById(R.id.button_demisexual);
        btn_demisexual.setOnClickListener(this);

        btn_pansexual= (Button) findViewById(R.id.button_pansexual);
        btn_pansexual.setOnClickListener(this);

        btn_queer = (Button) findViewById(R.id.button_queer);
        btn_queer.setOnClickListener(this);

        btn_questioning = (Button) findViewById(R.id.button_questioning);
        btn_questioning.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button_straight:

                openInterestActivity(btn_straight.getText().toString());

                break;
            case R.id.button_gay:
                openInterestActivity(btn_gay.getText().toString());

                break;
            case R.id.button_lesbian:
                openInterestActivity(btn_lesbian.getText().toString());

                break;
            case R.id.button_bisexual:
                openInterestActivity(btn_bisexual.getText().toString());

                break;
            case R.id.button_asexual:

                openInterestActivity(btn_asexual.getText().toString());
                break;
            case R.id.button_demisexual:
                openInterestActivity(btn_demisexual.getText().toString());

                break;
            case R.id.button_pansexual:
                openInterestActivity(btn_pansexual.getText().toString());

                break;
            case R.id.button_queer:
                openInterestActivity(btn_queer.getText().toString());

                break;
            case R.id.button_questioning:
                openInterestActivity(btn_questioning.getText().toString());

                break;

            default:
                break;
        }

    }

    private void openInterestActivity(String orientation){

//        Intent intent = new Intent(this,InterestActivity.class);
//
//        intent.putExtra("orientation",orientation);
//        startActivity(intent);

    }

}