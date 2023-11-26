package com.mct.base.ui.binding;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Method;

public class BindingUtils {

    @SuppressWarnings("unchecked")
    public static <B extends ViewBinding> B inflate(@NonNull Class<B> clazz,
                                                    @NonNull LayoutInflater inflater) {
        if (clazz == ViewDataBinding.class || clazz == ViewBinding.class) {
            return null;
        }
        try {
            Method inflateMethod = clazz.getMethod(
                    "inflate", LayoutInflater.class
            );
            return (B) inflateMethod.invoke(null, inflater);
        } catch (Exception e) {
            throw new RuntimeException("Failed to inflate ViewBinding. ", e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <B extends ViewBinding> B inflate(@NonNull Class<B> clazz,
                                                    @NonNull LayoutInflater inflater,
                                                    @Nullable ViewGroup viewGroup,
                                                    boolean attachToRoot) {
        if (clazz == ViewDataBinding.class || clazz == ViewBinding.class) {
            return null;
        }
        try {
            Method inflateMethod = clazz.getMethod(
                    "inflate", LayoutInflater.class, ViewGroup.class, boolean.class
            );
            return (B) inflateMethod.invoke(null, inflater, viewGroup, attachToRoot);
        } catch (Exception e) {
            throw new RuntimeException("Failed to inflate ViewBinding. ", e);
        }
    }

    private BindingUtils() {
        //no instance
    }
}
