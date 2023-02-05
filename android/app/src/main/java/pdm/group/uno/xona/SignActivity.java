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

public class SignActivity extends AppCompatActivity {

    private Button sign;
    private EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        sign = (Button) findViewById(R.id.button_sign);

        email = findViewById(R.id.editTextInputName);
        password = findViewById(R.id.editTextInputPassword);



        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }

    //Log user in the CometChat
    private void loginCometChat(String UID) {

        if (CometChat.getLoggedInUser()==null){
            CometChat.login(UID, AppConfig.AppDetails.AUTH_KEY, new CometChat.CallbackListener<User>() {
                        @Override
                        public void onSuccess(User user) {
                            Log.d("Login Successful", user.toString());
                            //action
                        }

                        @Override
                        public void onError(CometChatException e) {
                            Log.e("Login failed", e.getMessage());
                        }
                    }

            );
        }else {
            //action
        }

    }


}
