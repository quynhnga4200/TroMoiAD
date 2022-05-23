package tdc.edu.tromoiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import tdc.edu.tromoiproject.fcm.MyFirebaseMessagingService;

public class MainActivity extends AppCompatActivity {
    AppCompatRadioButton btnChothue, btnOghep , btnPhong , btnCangho, btnCanghomini , btnNguyenCang;
    private static final String TAG = MyFirebaseMessagingService.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motelinfo_layout);
        btnChothue = findViewById(R.id.btnChothue);
        btnOghep = findViewById(R.id.btnOghep);
        btnPhong = findViewById(R.id.btnPhong);
        btnCangho = findViewById(R.id.btnCangho);
        btnCanghomini = findViewById(R.id.btnCanghoMini);
        btnNguyenCang = findViewById(R.id.btnNguyenCan);
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast

                        Log.d(TAG, token);

                    }
                });
    }

    public void onRadiobuttonChecked(View view){
        boolean isSeleted = ((AppCompatRadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.btnChothue:
                if(isSeleted){
                    btnChothue.setTextColor(Color.WHITE);
                    btnOghep.setTextColor(Color.RED);
                }
                break;
            case R.id.btnOghep:
                if(isSeleted){
                    btnChothue.setTextColor(Color.RED);
                    btnOghep.setTextColor(Color.WHITE);
                }
                break;

            case R.id.btnPhong:
                if(isSeleted){
                    btnPhong.setTextColor(Color.WHITE);
                    btnCangho.setTextColor(Color.RED);
                    btnCanghomini.setTextColor(Color.RED);
                    btnNguyenCang.setTextColor(Color.RED);
                }
                break;

            case R.id.btnCangho:
                if(isSeleted){
                    btnPhong.setTextColor(Color.RED);
                    btnCangho.setTextColor(Color.WHITE);
                    btnCanghomini.setTextColor(Color.RED);
                    btnNguyenCang.setTextColor(Color.RED);
                }
                break;
            case R.id.btnCanghoMini:
                if(isSeleted){
                    btnPhong.setTextColor(Color.RED);
                    btnCangho.setTextColor(Color.RED);
                    btnCanghomini.setTextColor(Color.WHITE);
                    btnNguyenCang.setTextColor(Color.RED);
                }
                break;
            case R.id.btnNguyenCan:
                if(isSeleted){
                    btnPhong.setTextColor(Color.RED);
                    btnCangho.setTextColor(Color.RED);
                    btnCanghomini.setTextColor(Color.RED);
                    btnNguyenCang.setTextColor(Color.WHITE);
                }
                break;
        }
    }
}