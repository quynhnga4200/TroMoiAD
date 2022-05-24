package vn.edu.tdc.projectandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import vn.edu.tdc.projectandroid.Models.ProductModel;
import vn.edu.tdc.projectandroid.Models.TempConnectFireBase;
import vn.edu.tdc.projectandroid.Models.UserModel;
import vn.edu.tdc.projectandroid.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TempConnectFireBase.GetData(view.getContext());
                String str = "";
                // lap in ra giữ liệu giả
                for (ProductModel item:
                        ProductModel.productModels) {
                  str+= item.toString()+"\n\n";
                }
//                for (UserModel item:
//                        UserModel.userModels) {
//                    str+= item.toString()+"\n\n";
//
//                }

                binding.textviewFirst.setText(str);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}