package tdc.edu.tromoiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    AppCompatRadioButton btnChothue, btnOghep , btnPhong , btnCangho, btnCanghomini , btnNguyenCang;

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