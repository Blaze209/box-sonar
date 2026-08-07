package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class OkCancelLayoutBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnOK;
    public final RelativeLayout buttons;
    private final RelativeLayout rootView;

    private OkCancelLayoutBinding(RelativeLayout relativeLayout, Button button, Button button2, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.btnCancel = button;
        this.btnOK = button2;
        this.buttons = relativeLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OkCancelLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static OkCancelLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.ok_cancel_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static OkCancelLayoutBinding bind(View view) {
        int i = R.id.btnCancel;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btnOK;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                return new OkCancelLayoutBinding(relativeLayout, button, button2, relativeLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
