package pdm.group.uno.xona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RelationshipActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_long, btn_long_to_short, btn_short_to_long, btn_fun, btn_friends, btn_figuring_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relationship);

        btn_long = (Button) findViewById(R.id.imageButtonLong);
        btn_long.setOnClickListener(this);

        btn_long_to_short = (Button) findViewById(R.id.imageButtonLongToShort);
        btn_long_to_short.setOnClickListener(this);

        btn_short_to_long = (Button) findViewById(R.id.imageButtonShortToLong);
        btn_short_to_long.setOnClickListener(this);

        btn_fun = (Button) findViewById(R.id.imageButtonFun);
        btn_fun.setOnClickListener(this);

        btn_friends = (Button) findViewById(R.id.imageButtonNewFriends);
        btn_friends.setOnClickListener(this);

        btn_figuring_out = (Button) findViewById(R.id.imageButtonFiguringOut);
        btn_figuring_out.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButtonLong:
                openAvatarActivity("LongTerm");
                break;
            case R.id.imageButtonLongToShort:

                openAvatarActivity("LongTermOpenToShort");
                break;
            case R.id.imageButtonShortToLong:
                openAvatarActivity("ShotTermOpenToLong");

                break;
            case R.id.imageButtonFun:
                openAvatarActivity("ShortTermFun");

                break;
            case R.id.imageButtonNewFriends:
                openAvatarActivity("Friendship");

                break;
            case R.id.imageButtonFiguringOut:
                openAvatarActivity("FiguringOut");

                break;
        }

    }
    private void openAvatarActivity (String relationship){

//        Intent intent = new Intent(this,AvatarActivity.class);
//
//        intent.putExtra("relationType",relationship);
//        startActivity(intent);

    }
}