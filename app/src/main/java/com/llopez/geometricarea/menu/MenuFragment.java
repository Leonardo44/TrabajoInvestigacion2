package com.llopez.geometricarea.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.llopez.geometricarea.R;

public class MenuFragment extends Fragment {
    private Button btnExerciseOne;
    private Button btnExerciseTwo;
    private Button btnExerciseThree;
    private Button btnExerciseFour;

    public MenuFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_menu, container, false);

        btnExerciseOne = layout.findViewById(R.id.btnToExerciseOne);
        btnExerciseTwo = layout.findViewById(R.id.btnToExerciseTwo);
        btnExerciseThree = layout.findViewById(R.id.btnToExerciseThree);
        btnExerciseFour = layout.findViewById(R.id.btnToExerciseFour);

        btnExerciseOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toExerciseOne();
            }
        });

        btnExerciseTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toExerciseTwo();
            }
        });

        btnExerciseThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toExerciseThree();
            }
        });

        btnExerciseFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toExerciseFour();
            }
        });

        return layout;
    }

    private void toExerciseOne() {
        // NavHostFragment.findNavController(this).navigate(R.id.action_menuFragment_to_excerciseOneFragment);
    }

    private void toExerciseTwo() {
        // NavHostFragment.findNavController(this).navigate(R.id.action_menuFragment_to_excerciseTwoFragment);
    }

    private void toExerciseThree() {
        // NavHostFragment.findNavController(this).navigate(R.id.action_menuFragment_to_excerciseOneFragment);
    }

    private void toExerciseFour() {
        // NavHostFragment.findNavController(this).navigate(R.id.action_menuFragment_to_excerciseTwoFragment);
    }
}