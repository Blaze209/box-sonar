package com.box.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.R;

/* JADX INFO: loaded from: classes11.dex */
public final class DialogDiagnosisModeBinding implements ViewBinding {
    public final Barrier barrier1;
    public final Barrier barrier2;
    public final Barrier barrierVertical;
    public final Spinner logsLevelSpinner;
    public final TextView logsLevelText;
    private final ConstraintLayout rootView;
    public final EditText uniqueTagEdit;
    public final TextView uniqueTagText;

    private DialogDiagnosisModeBinding(ConstraintLayout constraintLayout, Barrier barrier, Barrier barrier2, Barrier barrier3, Spinner spinner, TextView textView, EditText editText, TextView textView2) {
        this.rootView = constraintLayout;
        this.barrier1 = barrier;
        this.barrier2 = barrier2;
        this.barrierVertical = barrier3;
        this.logsLevelSpinner = spinner;
        this.logsLevelText = textView;
        this.uniqueTagEdit = editText;
        this.uniqueTagText = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogDiagnosisModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogDiagnosisModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_diagnosis_mode, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogDiagnosisModeBinding bind(View view) {
        int i = R.id.barrier1;
        Barrier barrier = (Barrier) ViewBindings.findChildViewById(view, R.id.barrier1);
        if (barrier != null) {
            i = R.id.barrier2;
            Barrier barrier2 = (Barrier) ViewBindings.findChildViewById(view, R.id.barrier2);
            if (barrier2 != null) {
                i = R.id.barrier_vertical;
                Barrier barrier3 = (Barrier) ViewBindings.findChildViewById(view, R.id.barrier_vertical);
                if (barrier3 != null) {
                    i = R.id.logs_level_spinner;
                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.logs_level_spinner);
                    if (spinner != null) {
                        i = R.id.logs_level_text;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.logs_level_text);
                        if (textView != null) {
                            i = R.id.unique_tag_edit;
                            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.unique_tag_edit);
                            if (editText != null) {
                                i = R.id.unique_tag_text;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.unique_tag_text);
                                if (textView2 != null) {
                                    return new DialogDiagnosisModeBinding((ConstraintLayout) view, barrier, barrier2, barrier3, spinner, textView, editText, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
