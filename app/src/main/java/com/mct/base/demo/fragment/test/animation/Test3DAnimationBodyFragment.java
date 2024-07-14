package com.mct.base.demo.fragment.test.animation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mct.base.demo.R;
import com.mct.base.demo.databinding.FragmentTest3dAnimationBodyBinding;
import com.mct.base.demo.utils.Utils;
import com.mct.base.ui.binding.BaseBindingFragment;
import com.mct.base.ui.core.IExtraTransaction;
import com.mct.base.ui.transition.FragmentTransitionFactory;
import com.mct.base.ui.transition.annotation.AnimDirection;
import com.mct.base.ui.transition.options.AnimOptions;

public class Test3DAnimationBodyFragment extends BaseBindingFragment<FragmentTest3dAnimationBodyBinding> implements View.OnClickListener {

    private final int color = Utils.generateBrightColor();

    @NonNull
    @Override
    public Class<FragmentTest3dAnimationBodyBinding> getBindingClass() {
        return FragmentTest3dAnimationBodyBinding.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(color);

        binding.tvAnimationStyle.setText(Test3DAnimationFragment.sAnimationStyleName);

        binding.btnLeft.setOnClickListener(this);
        binding.btnRight.setOnClickListener(this);
        binding.btnUp.setOnClickListener(this);
        binding.btnDown.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(@NonNull View v) {
        IExtraTransaction extraTransaction = parentExtraTransaction();
        int direction;
        int id = v.getId();
        if (id == R.id.btn_Left) {
            direction = AnimDirection.LEFT;
        } else if (id == R.id.btn_Right) {
            direction = AnimDirection.RIGHT;
        } else if (id == R.id.btn_Up) {
            direction = AnimDirection.UP;
        } else if (id == R.id.btn_Down) {
            direction = AnimDirection.DOWN;
        } else {
            direction = AnimDirection.NONE;
        }
        AnimOptions anim = AnimOptions.animation(Test3DAnimationFragment.sAnimationStyle).direction(direction).build();
        extraTransaction.replaceFragment(
                new Test3DAnimationBodyFragment(),
                FragmentTransitionFactory.createTransition(anim, anim)
        );
    }

}
