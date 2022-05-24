package tdc.edu.tromoiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText textMail;
    private  EditText textPass;
    private Button DangNhap;
    private Button QuenMK;
    private TextView DangKi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
        QuenMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToVerifyActivity();
            }
        });
        DangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToregisterActivity();
            }
        });

    }
    private void goToVerifyActivity() {
        Intent intent = new Intent(this, VeryPhoneNumberActivity.class);
        startActivity(intent);
    }
    private void goToregisterActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    public void getDataIntent(){
        String strphoneNumber = getIntent().getStringExtra("phone_number");
        EditText text =findViewById(R.id.TextMail);
        text.setText(strphoneNumber);

    }
    private  void initUI(){
        textMail = findViewById(R.id.TextMail);
        textPass = findViewById(R.id.editpassword);
        DangNhap = findViewById(R.id.btnlogin);
        DangKi = findViewById(R.id.edtDangKi);
        QuenMK = findViewById(R.id.textQuenPass);
    }
}