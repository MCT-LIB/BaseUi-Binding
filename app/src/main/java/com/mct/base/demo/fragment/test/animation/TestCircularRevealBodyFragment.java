package com.mct.base.demo.fragment.test.animation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mct.base.demo.R;
import com.mct.base.demo.databinding.FragmentTestCircularRevealBodyBinding;
import com.mct.base.demo.utils.Utils;
import com.mct.base.ui.binding.BaseBindingFragment;
import com.mct.base.ui.transition.FragmentTransitionFactory;

public class TestCircularRevealBodyFragment extends BaseBindingFragment<FragmentTestCircularRevealBodyBinding> implements View.OnClickListener {
    public static final String KEY_ARGS_CIRCULAR_POSITION = "circularPosition";

    @NonNull
    public static TestCircularRevealBodyFragment newInstance(Point circularPosition) {
        Bundle args = new Bundle();
        args.putParcelable(KEY_ARGS_CIRCULAR_POSITION, circularPosition);
        TestCircularRevealBodyFragment fragment = new TestCircularRevealBodyFragment();
        fragment.setArguments(args);
        return fragment;
    }


    private Point point;
    private final int color = Utils.generateBrightColor();

    @NonNull
    @Override
    protected Class<FragmentTestCircularRevealBodyBinding> getBindingClass() {
        return FragmentTestCircularRevealBodyBinding.class;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Bundle bundle = getArguments();
        if (bundle != null) {
            point = bundle.getParcelable(KEY_ARGS_CIRCULAR_POSITION);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(color);

        binding.tvBackstackCount.setText(String.valueOf(parentExtraTransaction().getBackStackCount()));

        binding.btnTopLeft.setOnClickListener(this);
        binding.btnTopCenter.setOnClickListener(this);
        binding.btnTopRight.setOnClickListener(this);
        binding.btnCenterLeft.setOnClickListener(this);
        binding.btnCenter.setOnClickListener(this);
        binding.btnCenterRight.setOnClickListener(this);
        binding.btnBottomLeft.setOnClickListener(this);
        binding.btnBottomCenter.setOnClickListener(this);
        binding.btnBottomRight.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(@NonNull View v) {
        int x = (int) (v.getX() + v.getWidth() / 2);
        int y = (int) (v.getY() + v.getHeight() / 2);
        Point point = new Point(x, y);
        parentExtraTransaction().replaceFragmentToStack(
                TestCircularRevealBodyFragment.newInstance(point),
                FragmentTransitionFactory.createCircularRevealTransition()
        );
    }

    @Override
    public int getContainerId() {
        return R.id.test_container;
    }

    @NonNull
    @Override
    protected Point getCircularPosition() {
        if (point != null) {
            return point;
        }
        return super.getCircularPosition();
    }

    @Override
    protected int getAnimationDuration() {
        return 400;
    }
}
