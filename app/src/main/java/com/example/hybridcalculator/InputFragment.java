package com.example.hybridcalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class InputFragment extends Fragment {
    private ViewModel viewModel;

    EditText ip_a, ip_b;
    Integer num1, num2;
    int answer;
    Button add, sub, multiply, div;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_input,container, false);
        ip_a = v.findViewById(R.id.input1);
        ip_b = v.findViewById(R.id.input2);
        add = v.findViewById(R.id.add_btn);
        sub = v.findViewById(R.id.sub_btn);
        multiply = v.findViewById(R.id.mul_btn);
        div = v.findViewById(R.id.div_btn);

        //viewModel = new ViewModelProvider(getActivity()).get(ViewModel.class);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_Num()) {
                    answer = num1 + num2;
                    Toast.makeText(getContext(), answer , Toast.LENGTH_SHORT).show();
                    viewModel.setData(answer);
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_Num()) {
                    answer = (num1 - num2);
                    Toast.makeText(getContext(), answer , Toast.LENGTH_SHORT).show();
                    viewModel.setData(answer);

                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_Num()) {
                    answer = (num1 * num2);
                    Toast.makeText(getContext(), answer , Toast.LENGTH_SHORT).show();
                    viewModel.setData(answer);

                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_Num()) {
                    answer = (num1 / num2);
                    Toast.makeText(getContext(), answer , Toast.LENGTH_SHORT).show();
                    viewModel.setData(answer);

                }
            }
        });


        return v;
    }




    public boolean check_Num(){
        String s1 = ip_a.getText().toString();

        String s2 = ip_b.getText().toString();
        if ((s1.equals(null) && s2.equals(null)) || (s1.equals("") && s2.equals("")))  {

            Toast.makeText(getContext(), "Please enter some Numbers", Toast.LENGTH_SHORT).show();
            return false;

        } else {
            num1 = Integer.parseInt(s1);
            num2 = Integer.parseInt(s2);
        }
        return true;

    }
}

