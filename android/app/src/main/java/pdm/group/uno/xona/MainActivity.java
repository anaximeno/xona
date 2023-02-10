package pdm.group.uno.xona;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cometchat.pro.core.AppSettings;
import com.cometchat.pro.core.CometChat;
import com.cometchat.pro.exceptions.CometChatException;

import com.cometchat.pro.uikit.ui_components.cometchat_ui.CometChatUI;
import com.cometchat.pro.uikit.ui_settings.UIKitSettings;
import com.cometchat.pro.uikit.ui_settings.enums.UserMode;

import pdm.group.uno.xona.constants.AppConfig;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createUserBnt = findViewById(R.id.button);
        Button iAgreeButton = findViewById(R.id.i_agree);

        intiCometChat();
        UIKitSettings.setUsersMode(UserMode.FRIENDS);

        //Verify if the user is loged
//        if (!(CometChat.getLoggedInUser() == null)) {
//
//            Intent i = new Intent(MainActivity.this, TinderActivity.class);
//            startActivity(i);
//
//        } else {
//            Intent i = new Intent(MainActivity.this, InitialActivity.class);
//            startActivity(i);
//        }


        createUserBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AvatarActivity2.class);
//                Intent i = new Intent(MainActivity.this, InitialActivity.class);
                startActivity(i);
            }
        });


        iAgreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AgreeToRulesActivity.class);
                startActivity(i);
            }
        });
    }


    private void intiCometChat() {
        AppSettings appSettings = new AppSettings.AppSettingsBuilder().subscribePresenceForAllUsers().setRegion(AppConfig.AppDetails.REGION).build();

        CometChat.init(this, AppConfig.AppDetails.APP_ID, appSettings, new CometChat.CallbackListener<String>() {
            @Override
            public void onSuccess(String successMessage) {
                UIKitSettings.setAuthKey(AppConfig.AppDetails.AUTH_KEY);
                CometChat.setSource("ui-kit", "android", "java");
                Log.d(TAG, "Initialization completed successfully");
            }

            @Override
            public void onError(CometChatException e) {
                Log.d(TAG, "Initialization failed with exception: " + e.getMessage());
            }
        });
    }
}