package com.llopez.geometricarea.square_area;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.llopez.geometricarea.R;

import java.text.ParseException;

public class SquareAreaFragment extends Fragment {

    private EditText edtSide;
    private Button btnCalculate;
    private TextView txtResult;
    private SquareViewModel viewModel;

    public SquareAreaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SquareViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_square_area, container, false);
        edtSide = layout.findViewById(R.id.edtSide);
        btnCalculate = layout.findViewById(R.id.btnCalculate);
        txtResult = layout.findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(view -> calculateArea());

        final Observer<Double> areaObserver = newValue -> {
            txtResult.setText("Área: " + String.format("%.2f", newValue) + " metros cuadrados");
        };
        this.viewModel.getCurrentData().observe(this.getActivity(), areaObserver);

        return layout;
    }

    private void calculateArea() {
        try {
            Double side = Double.parseDouble(edtSide.getText().toString());
            if (side <= 0) {
                errorMessage();
            }
            viewModel.calculateArea(side);
        } catch (Exception e) {
            errorMessage();
        }
    }

    private void errorMessage() {
        Toast toast= Toast.makeText(getContext(), "Por favor, ingresar valores validos", Toast.LENGTH_SHORT);
        toast.show();
    }
}