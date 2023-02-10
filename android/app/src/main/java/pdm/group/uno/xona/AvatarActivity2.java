package pdm.group.uno.xona;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.cometchat.pro.core.CometChat;
import com.cometchat.pro.exceptions.CometChatException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;


public class AvatarActivity2 extends AppCompatActivity {

    private ImageView inputImage;
    private Button btn_tst;

    private final int gallery_req_code = 1000;


    JSONObject body = new JSONObject();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar2);


        inputImage = findViewById(R.id.image);
        btn_tst = (Button) findViewById(R.id.buttontt);

        btn_tst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_PICK);
                i.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, gallery_req_code);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == gallery_req_code) {
            inputImage.setImageURI(data.getData());

//            String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);
            Bitmap bm = BitmapFactory.decodeFile(String.valueOf(data.getData()));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); // bm is the bitmap object
            byte[] b = baos.toByteArray();

            // bytes refer to the selected image bytes
            String imageString = Base64.encodeToString(b, Base64.NO_WRAP);

//             The image type can image/jpg, image/png, etc.
//             based on the image file under consideration.
            try {
                body.put("avatar", "data:image/png;base64,"+imageString);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            CometChat.callExtension("avatar", "POST", "/v1/upload", body,
                    new CometChat.CallbackListener<JSONObject>() {
                        @Override
                        public void onSuccess(JSONObject jsonObject) {

                        }

                        @Override
                        public void onError(CometChatException e) {
                            // Some error occured
                        }
                    });
        }
    }


}