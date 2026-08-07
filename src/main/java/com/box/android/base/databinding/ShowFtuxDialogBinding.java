package com.box.android.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public final class ShowFtuxDialogBinding implements ViewBinding {
    public final Button btnNegative;
    public final Button btnPositive;
    public final RelativeLayout buttons;
    private final RelativeLayout rootView;
    public final FrameLayout sceneRoot;

    private ShowFtuxDialogBinding(RelativeLayout relativeLayout, Button button, Button button2, RelativeLayout relativeLayout2, FrameLayout frameLayout) {
        this.rootView = relativeLayout;
        this.btnNegative = button;
        this.btnPositive = button2;
        this.buttons = relativeLayout2;
        this.sceneRoot = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ShowFtuxDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ShowFtuxDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.show_ftux_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ShowFtuxDialogBinding bind(View view) {
        int i = R.id.btnNegative;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.btnPositive;
            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
            if (button2 != null) {
                i = R.id.buttons;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.sceneRoot;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        return new ShowFtuxDialogBinding((RelativeLayout) view, button, button2, relativeLayout, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
