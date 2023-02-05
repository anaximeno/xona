package pdm.group.uno.xona;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.cometchat.pro.core.CometChat;
import com.cometchat.pro.exceptions.CometChatException;
import com.cometchat.pro.models.User;

import pdm.group.uno.xona.constants.AppConfig;

public class CreateAccountActivity extends AppCompatActivity {

    private Button create_account;
    private EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        create_account = (Button) findViewById(R.id.button_create);
        email = findViewById(R.id.editTextInputEmail);
        password = findViewById(R.id.editTextInputPassword);



        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    //Create Account in CometChat
    private void createCometChatAccount(String uid, String name){

        User user = new User();

        user.setUid(String.valueOf(uid));
        user.setName(String.valueOf(name));

        CometChat.createUser(user, AppConfig.AppDetails.AUTH_KEY, new CometChat.CallbackListener<User>() {
            @Override
            public void onSuccess(User user) {
                Log.d("createUser", user.toString());

            }

            @Override
            public void onError(CometChatException e) {
                Log.e("createUser", e.getMessage());
            }
        });

    }


}
