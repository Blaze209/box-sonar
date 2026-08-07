package com.facebook.common.lifecycle;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public interface AttachDetachListener {
    void onAttachToView(View view);

    void onDetachFromView(View view);
}
