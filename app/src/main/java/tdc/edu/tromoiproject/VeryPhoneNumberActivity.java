package tdc.edu.tromoiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class VeryPhoneNumberActivity extends AppCompatActivity {
    private  final  String TAG = VeryPhoneNumberActivity.class.getName();
    private EditText editphone;
    private Button buttonvery;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_very_phone_number);
        SetTitleToolsBar();
        initUI();
        mAuth = FirebaseAuth.getInstance();
        buttonvery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strNumber = editphone.getText().toString().trim();
                onClickVeryfy(strNumber);
            }


        });
    }
    private void onClickVeryfy(String strNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(strNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                signInWithPhoneAuthCredential(phoneAuthCredential);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(VeryPhoneNumberActivity.this, "OVerification Failed", Toast.LENGTH_SHORT).show();

                            }
                            @Override
                            public void onCodeSent(@NonNull String verificationId,
                                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                                super.onCodeSent(verificationId,token);
                                goToEnterOTP(strNumber,verificationId);

                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
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
                                Toast.makeText(VeryPhoneNumberActivity.this,
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
    private void goToEnterOTP(String strNumber, String verificationId) {
        Intent intent = new Intent(this,OtpNumberActivity.class);
        intent.putExtra("phone_number", strNumber);
        intent.putExtra("verify_cation_ID", verificationId);
        startActivity(intent);
    }
    private  void initUI(){
        editphone = findViewById(R.id.forgetphone);
        buttonvery = findViewById(R.id.veryphonenumber);

    }

    private  void  SetTitleToolsBar(){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Verify Phone");
        }
    }
}