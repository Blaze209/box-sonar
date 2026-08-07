package com.box.android.base.presentation.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.box.android.base.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

/* JADX INFO: loaded from: classes9.dex */
public class PositiveNegativeDialogFragment extends DialogFragment {
    protected static final String ARGUMENT_MESSAGE_ID = "message_res_id";
    protected static final String ARGUMENT_NEGATIVE_ID = "negative_res_id";
    protected static final String ARGUMENT_POSITIVE_ID = "positive_res_id";
    protected static final String ARGUMENT_TITLE_ID = "title_res_id";
    protected boolean mButtonClicked;
    protected OnPositiveOrNegativeButtonClickedListener mButtonClickedListener;

    public interface OnPositiveOrNegativeButtonClickedListener {
        void onNegativeButtonClicked(PositiveNegativeDialogFragment positiveNegativeDialogFragment);

        void onPositiveButtonClicked(PositiveNegativeDialogFragment positiveNegativeDialogFragment);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        setRetainInstance(true);
        this.mButtonClicked = false;
        int i = getArguments().getInt(ARGUMENT_TITLE_ID);
        return new MaterialAlertDialogBuilder(getActivity(), R.style.ShareDialogTheme).setTitle(i).setMessage(getArguments().getInt(ARGUMENT_MESSAGE_ID)).setPositiveButton(getText(getArguments().getInt(ARGUMENT_POSITIVE_ID)), new DialogInterface.OnClickListener() { // from class: com.box.android.base.presentation.fragments.PositiveNegativeDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PositiveNegativeDialogFragment.this.mButtonClicked = true;
                if (PositiveNegativeDialogFragment.this.mButtonClickedListener != null) {
                    PositiveNegativeDialogFragment.this.mButtonClickedListener.onPositiveButtonClicked(PositiveNegativeDialogFragment.this);
                }
            }
        }).setNegativeButton(getText(getArguments().getInt(ARGUMENT_NEGATIVE_ID)), new DialogInterface.OnClickListener() { // from class: com.box.android.base.presentation.fragments.PositiveNegativeDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                PositiveNegativeDialogFragment.this.mButtonClicked = true;
                if (PositiveNegativeDialogFragment.this.mButtonClickedListener != null) {
                    PositiveNegativeDialogFragment.this.mButtonClickedListener.onNegativeButtonClicked(PositiveNegativeDialogFragment.this);
                }
            }
        }).create();
    }

    public void setOnPositiveOrNegativeButtonClickedListener(OnPositiveOrNegativeButtonClickedListener onPositiveOrNegativeButtonClickedListener) {
        this.mButtonClickedListener = onPositiveOrNegativeButtonClickedListener;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        OnPositiveOrNegativeButtonClickedListener onPositiveOrNegativeButtonClickedListener;
        super.onDismiss(dialogInterface);
        if (this.mButtonClicked || (onPositiveOrNegativeButtonClickedListener = this.mButtonClickedListener) == null) {
            return;
        }
        onPositiveOrNegativeButtonClickedListener.onNegativeButtonClicked(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    public static PositiveNegativeDialogFragment createFragment(int i, int i2, int i3, int i4, OnPositiveOrNegativeButtonClickedListener onPositiveOrNegativeButtonClickedListener) {
        PositiveNegativeDialogFragment positiveNegativeDialogFragment = new PositiveNegativeDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARGUMENT_TITLE_ID, i);
        bundle.putInt(ARGUMENT_MESSAGE_ID, i2);
        bundle.putInt(ARGUMENT_POSITIVE_ID, i3);
        bundle.putInt(ARGUMENT_NEGATIVE_ID, i4);
        positiveNegativeDialogFragment.setArguments(bundle);
        positiveNegativeDialogFragment.setOnPositiveOrNegativeButtonClickedListener(onPositiveOrNegativeButtonClickedListener);
        return positiveNegativeDialogFragment;
    }
}
