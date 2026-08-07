package com.box.android.base.presentation.fragments;

import android.app.Activity;

/* JADX INFO: loaded from: classes9.dex */
public class EmptyFragmentWithCallbackOnResume extends Hilt_EmptyFragmentWithCallbackOnResume {
    OnFragmentAttachedListener mListener = null;

    public interface OnFragmentAttachedListener {
        void OnFragmentAttached();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.base.presentation.fragments.Hilt_EmptyFragmentWithCallbackOnResume, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.mListener = (OnFragmentAttachedListener) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentAttachedListener");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        OnFragmentAttachedListener onFragmentAttachedListener = this.mListener;
        if (onFragmentAttachedListener != null) {
            onFragmentAttachedListener.OnFragmentAttached();
        }
    }
}
