package com.llopez.geometricarea.rectangle_area;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.llopez.geometricarea.R;

public class RectangleAreaFragment extends Fragment {

    private EditText edtLength;
    private EditText edtWidth;
    private TextView txtResult;
    private Button btnCalculate;
    private RectangleViewModel viewModel;

    public RectangleAreaFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RectangleViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_rectangle_area, container, false);
        edtLength = layout.findViewById(R.id.edtLength);
        edtWidth = layout.findViewById(R.id.edtWidth);
        txtResult = layout.findViewById(R.id.txtResult);
        btnCalculate = layout.findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(view -> calculateArea());

        final Observer<Double> areaObserver = newValue -> {
          txtResult.setText("Área: " + String.format("%.2f", newValue) + " metros cuadrados");
        };
        this.viewModel.getCurrentArea().observe(this.getActivity(), areaObserver);

        return layout;
    }

    private void calculateArea() {
        try {
            Double length = Double.parseDouble(edtLength.getText().toString());
            Double width = Double.parseDouble(edtWidth.getText().toString());
            if (length <= 0 || width <= 0) {
                errorMessage();
            }
            viewModel.calculateArea(length, width);
        } catch (Exception e) {
            errorMessage();
        }
    }

    private void errorMessage() {
        Toast toast= Toast.makeText(getContext(), "Por favor, ingresar valores validos", Toast.LENGTH_SHORT);
        toast.show();
    }
}