package vn.edu.tdc.nhatro360;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    AppCompatRadioButton btnChothue, btnOghep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motelinfo_layout);
        btnChothue.findViewById(R.id.btnChothue);
        btnOghep.findViewById(R.id.btnOghep);
    }

    public void onRadiobuttonChecked(View view){
        boolean isSeleted = ((AppCompatRadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.btnChothue:

        }
    }
}