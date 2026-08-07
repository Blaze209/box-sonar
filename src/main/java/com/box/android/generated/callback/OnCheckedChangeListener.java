package com.box.android.generated.callback;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes11.dex */
public final class OnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
    final Listener mListener;
    final int mSourceId;

    public interface Listener {
        void _internalCallbackOnCheckedChanged(int i, CompoundButton compoundButton, boolean z);
    }

    public OnCheckedChangeListener(Listener listener, int i) {
        this.mListener = listener;
        this.mSourceId = i;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.mListener._internalCallbackOnCheckedChanged(this.mSourceId, compoundButton, z);
    }
}
