package com.mct.base.demo.fragment.test.dialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mct.base.demo.R;
import com.mct.base.demo.databinding.FragmentTestDialogBinding;
import com.mct.base.demo.utils.Utils;
import com.mct.base.ui.binding.BaseBindingFragment;

public class TestDialogFragment extends BaseBindingFragment<FragmentTestDialogBinding> implements View.OnClickListener {

    private final int color = Utils.generateBrightColor();

    @NonNull
    @Override
    protected Class<FragmentTestDialogBinding> getBindingClass() {
        return FragmentTestDialogBinding.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(color);

        binding.toolbar.setNavigationOnClickListener(v -> extraTransaction().popFragment());

        binding.btnDialogNormal.setOnClickListener(this);
        binding.btnDialogRounded.setOnClickListener(this);
        binding.btnBtsDialogNormal.setOnClickListener(this);
        binding.btnBtsDialogRounded.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(@NonNull View v) {
        switch (v.getId()) {
            case R.id.btn_dialog_Normal:
                new NormalDialog(requireContext()).setLifecycle(getLifecycle()).show();
                break;
            case R.id.btn_dialog_Rounded:
                new RoundedCornerDialog(requireContext()).show();
                break;
            case R.id.btn_bts_dialog_Normal:
                new NormalBottomSheet(requireContext()).show();
                break;
            case R.id.btn_bts_dialog_Rounded:
                new RoundedCornerBottomSheet(requireContext()).show();
                break;
        }
    }
}
