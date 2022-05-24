package tdc.edu.tromoiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OtpNumberActivity extends AppCompatActivity {
    private  final  String TAG = OtpNumberActivity.class.getName();
    private EditText OTP;
    private Button SendOTP;
    private TextView again;
    private String mPhone;
    private FirebaseAuth mAuth;
    private  String mVarify;
    private  PhoneAuthProvider.ForceResendingToken mtoken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_number);
        GetdataIntent();
        SetTitleToolsBar();
        initUI();
        mAuth = FirebaseAuth.getInstance();
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
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(mPhone)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setForceResendingToken(mtoken)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                signInWithPhoneAuthCredential(phoneAuthCredential);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(OtpNumberActivity.this, "oVerification Failed", Toast.LENGTH_SHORT).show();

                            }
                            @Override
                            public void onCodeSent(@NonNull String verificationId,
                                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                                super.onCodeSent(verificationId,token);
                               mVarify = verificationId;

                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

    }
    private  void GetdataIntent(){
    mPhone =getIntent().getStringExtra("phone_number");
    mVarify = getIntent().getStringExtra("verify_cation_ID");
    }
    private void onClickVeryfy(String strotp) {

        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVarify, strotp);
        signInWithPhoneAuthCredential(credential);
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.e(TAG, "signInWithCredential:success");

                            FirebaseUser user = task.getResult().getUser();
                            // Update UI
                            goToMainActivity(user.getPhoneNumber());
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(OtpNumberActivity.this,
                                        "The verification code entered was invalid", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }
    private void goToMainActivity(String phoneNumber) {
        Intent intent = new Intent(this,LoginActivity.class);
        intent.putExtra("phone number", phoneNumber);
        startActivity(intent);
    }
}