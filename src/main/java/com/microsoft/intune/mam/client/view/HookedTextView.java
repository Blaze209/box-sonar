package com.microsoft.intune.mam.client.view;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedTextView extends HookedView {
    TextView asTextView();

    void realSetOnLongClickListener(View.OnLongClickListener onLongClickListener);
}
