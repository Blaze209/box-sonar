package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.viewbinding.ViewBinding;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class SpinnerDropdownItemBinding implements ViewBinding {
    private final CheckedTextView rootView;
    public final CheckedTextView text;

    private SpinnerDropdownItemBinding(CheckedTextView checkedTextView, CheckedTextView checkedTextView2) {
        this.rootView = checkedTextView;
        this.text = checkedTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CheckedTextView getRoot() {
        return this.rootView;
    }

    public static SpinnerDropdownItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SpinnerDropdownItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.spinner_dropdown_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SpinnerDropdownItemBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        CheckedTextView checkedTextView = (CheckedTextView) view;
        return new SpinnerDropdownItemBinding(checkedTextView, checkedTextView);
    }
}
