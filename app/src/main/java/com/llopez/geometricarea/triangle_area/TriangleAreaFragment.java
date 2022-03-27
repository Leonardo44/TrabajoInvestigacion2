package com.llopez.geometricarea.triangle_area;

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
import com.llopez.geometricarea.circle_area.CircleAreaViewModel;

public class TriangleAreaFragment extends Fragment {
    private EditText baseEditText;
    private EditText heightEditText;
    private Button btnCalculateArea;
    private TextView tvAreaResult;

    private TriangleViewModel viewModel;
    public TriangleAreaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(TriangleViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_triangle_area, container, false);
        baseEditText = layout.findViewById(R.id.editTextTriangleBase);
        heightEditText = layout.findViewById(R.id.editTextHeightTriangle);
        btnCalculateArea = layout.findViewById(R.id.btnCalculateTriangleArea);
        tvAreaResult = layout.findViewById(R.id.tvResultTriangleArea);

        btnCalculateArea.setOnClickListener(view -> calculateArea());

        heightEditText.setOnEditorActionListener((v, actionId, event) -> {
            if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                calculateArea();
            }
            return false;
        });

        // Create the observer which updates the UI.
        final Observer<Double> areaObserver = newValue -> {
            // Update the UI, in this case, a TextView.
            tvAreaResult.setText("Área: " + String.format("%.2f", newValue));
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.getCurrentArea().observe(this.getActivity(), areaObserver);

        tvAreaResult.setText("");
        return layout;
    }

    private void calculateArea() {
        try {
            Double base = Double.parseDouble(baseEditText.getText().toString());
            Double height = Double.parseDouble(heightEditText.getText().toString());

            if (base >= 0 && height >= 0) {
                viewModel.calculateArea(base, height);
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