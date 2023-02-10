package pdm.group.uno.xona;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cometchat.pro.core.CometChat;
import com.cometchat.pro.exceptions.CometChatException;
import com.cometchat.pro.models.User;

import java.io.IOException;
import java.util.regex.Pattern;

import pdm.group.uno.xona.constants.AppConfig;
import pdm.group.uno.xona.http.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateAccountActivity extends AppCompatActivity {

    private Button create_account;
    private EditText email,password,confirmpass;
    private pdm.group.uno.xona.entities.User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        create_account = (Button) findViewById(R.id.button_create);
        email = findViewById(R.id.editTextInputEmail);
        password = findViewById(R.id.editTextInputPassword);
        confirmpass = findViewById(R.id.editTextInputConfirmPassword);



        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //replace with the right code later
                if(passValidation()){
                Intent i = new Intent(CreateAccountActivity.this, AgreeToRulesActivity.class);

                user = new pdm.group.uno.xona.entities.User();
                user.setEmail(email.getText().toString());
                user.setPassword(password.getText().toString());
                    Call<pdm.group.uno.xona.entities.User> cal = RetrofitClient.getInstance().getApi().createUser(user);
                    cal.enqueue(new Callback<pdm.group.uno.xona.entities.User>() {
                        @Override
                        public void onResponse(Call<pdm.group.uno.xona.entities.User> call, Response<pdm.group.uno.xona.entities.User> response) {
                            Log.d("retrofit", "success");
                        }

                        @Override
                        public void onFailure(Call<pdm.group.uno.xona.entities.User> call, Throwable t) {
                            Log.d("retrofit", "failure");

                        }
                    });

                i.putExtra("user",  user);

                i.putExtra("password",password.getText().toString());
                i.putExtra("email",email.getText().toString());

                startActivity(i);
                }
            }
        });


    }

    private Boolean passValidation() {
        String pw = password.getText().toString();
        String cpw = confirmpass.getText().toString();
        String mail = email.getText().toString();
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern EmailValidation = Pattern.compile(regexPattern);
//        Pattern EmailValidation;
        Boolean val = true;

        if(!pw.equals(cpw)){
            Toast.makeText(CreateAccountActivity.this,"Password Not matching",Toast.LENGTH_SHORT).show();
            val = false;
        }
        //Verify if the email exist
//        else if () {
//            val = false
//        }
        //Verify the extructure of the email
//        else if ((!TextUtils.isEmpty(mail) && !Patterns.EMAIL_ADDRESS.matcher(mail).matches())) {
//
//            Toast.makeText(CreateAccountActivity.this,"Invalid Email",Toast.LENGTH_SHORT).show();
//            val = false;
//        }
        return val;

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
