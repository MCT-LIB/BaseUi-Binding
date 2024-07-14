package com.mct.base.demo.fragment.test.transaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mct.base.demo.R;
import com.mct.base.demo.databinding.FragmentTestTransactionBodyBinding;
import com.mct.base.demo.utils.Utils;
import com.mct.base.ui.binding.BaseBindingFragment;
import com.mct.base.ui.core.IExtraTransaction;
import com.mct.base.ui.transition.FragmentTransitionFactory;
import com.mct.base.ui.transition.annotation.AnimationStyle;
import com.mct.base.ui.transition.options.AnimOptions;

public class TestTransactionBodyFragment extends BaseBindingFragment<FragmentTestTransactionBodyBinding> implements View.OnClickListener {

    private final int color = Utils.generateBrightColor();

    @NonNull
    @Override
    public Class<FragmentTestTransactionBodyBinding> getBindingClass() {
        return FragmentTestTransactionBodyBinding.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(color);

        binding.tvBackstackCount.setText(String.valueOf(parentExtraTransaction().getBackStackCount()));

        binding.btnReplaceFragment.setOnClickListener(this);
        binding.btnReplaceFragmentToStack.setOnClickListener(this);
        binding.btnReplaceAndClearBackStack.setOnClickListener(this);
        binding.btnClearBackStack.setOnClickListener(this);
        binding.btnPopFragment.setOnClickListener(this);
        binding.btnPopFragmentToPosition.setOnClickListener(this);
        binding.btnPopFragmentByAmount.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(@NonNull View v) {
        IExtraTransaction extraTransaction = parentExtraTransaction();
        int id = v.getId();
        if (id == R.id.btn_replaceFragment) {
            extraTransaction.replaceFragment(
                    new TestTransactionBodyFragment(),
                    FragmentTransitionFactory.createCircularRevealTransition()
            );
        } else if (id == R.id.btn_replaceFragmentToStack) {
            extraTransaction.replaceFragmentToStack(
                    new TestTransactionBodyFragment(),
                    FragmentTransitionFactory.createTransition(
                            AnimOptions.animation(AnimationStyle.CUBE).left().build(),
                            AnimOptions.animation(AnimationStyle.CUBE).left().build(),
                            AnimOptions.animation(AnimationStyle.CUBE).right().build(),
                            AnimOptions.animation(AnimationStyle.CUBE).right().build()
                    )
            );
        } else if (id == R.id.btn_replaceAndClearBackStack) {
            extraTransaction.replaceAndClearBackStack(
                    new TestTransactionBodyFragment(),
                    FragmentTransitionFactory.createTransition(
                            AnimOptions.animation(AnimationStyle.CUBE).up().build(),
                            AnimOptions.animation(AnimationStyle.CUBE).up().build(),
                            AnimOptions.animation(AnimationStyle.CUBE).right().build(),
                            AnimOptions.animation(AnimationStyle.CUBE).right().build()
                    )
            );
        } else if (id == R.id.btn_clearBackStack) {
            extraTransaction.clearBackStack();
        } else if (id == R.id.btn_popFragment) {
            extraTransaction.popFragment();
        } else if (id == R.id.btn_popFragmentToPosition) {
            extraTransaction.popFragmentToPosition(getNumberFromEditText());
        } else if (id == R.id.btn_popFragmentByAmount) {
            extraTransaction.popFragmentByAmount(getNumberFromEditText());
        }
    }

    private int getNumberFromEditText() {
        if (getView() != null) {
            EditText editText = getView().findViewById(R.id.edt_number);
            try {
                return Integer.parseInt(editText.getText().toString());
            } catch (Throwable t) {
                return 0;
            }
        }
        return 0;
    }

}
