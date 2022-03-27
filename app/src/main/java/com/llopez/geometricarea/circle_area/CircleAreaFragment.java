package com.llopez.geometricarea.circle_area;

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

public class CircleAreaFragment extends Fragment {
    private EditText radiusEditText;
    private Button btnCalculateArea;
    private TextView tvAreaResult;

    private CircleAreaViewModel viewModel;

    public CircleAreaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the ViewModel.
        viewModel = new ViewModelProvider(this).get(CircleAreaViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_circle_area, container, false);
        radiusEditText = layout.findViewById(R.id.editTextCircleRadius);
        btnCalculateArea = layout.findViewById(R.id.btnCalculateCircleArea);
        tvAreaResult = layout.findViewById(R.id.tvResultCircleArea);

        btnCalculateArea.setOnClickListener(view -> calculateArea());

        radiusEditText.setOnEditorActionListener((v, actionId, event) -> {
            if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                calculateArea();
            }
            return false;
        });

        // Create the observer which updates the UI.
        final Observer<Double> areaObserver = new Observer<Double>() {
            @Override
            public void onChanged(@Nullable final Double newValue) {
                // Update the UI, in this case, a TextView.
                tvAreaResult.setText("Área: " + String.format("%.2f", newValue));
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.getCurrentArea().observe(this.getActivity(), areaObserver);

        tvAreaResult.setText("");
        return layout;
    }

    private void calculateArea() {
        try {
            Double radius = Double.parseDouble(radiusEditText.getText().toString());

            if (radius >= 0) {
                viewModel.calculateArea(radius);
            } else {
                errorMessage();
            }
        } catch (Exception err) {
            errorMessage();
        }
    }

    private void errorMessage() {
        Toast toast= Toast.makeText(getContext(), R.string.error_message, Toast.LENGTH_SHORT);
        toast.show();
    }
}