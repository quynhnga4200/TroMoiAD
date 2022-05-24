package tdc.edu.tromoiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OtpNumberActivity extends AppCompatActivity {
    private EditText OTP;
    private Button SendOTP;
    private TextView again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_number);
        SetTitleToolsBar();
        initUI();
        SendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strotp = OTP.getText().toString().trim();
                onClickVeryfy(strotp);
            }


        });
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnLickSendOTPAgain();
            }
        });
    }


    private  void initUI(){
        OTP = findViewById(R.id.otp);
        SendOTP = findViewById(R.id.verify_OTP);
        again = findViewById(R.id.otpagain);

    }
    private  void  SetTitleToolsBar(){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("OTP");
        }
    }
    private void OnLickSendOTPAgain() {
    }

    private void onClickVeryfy(String strotp) {

    }
}