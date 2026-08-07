package com.bumptech.glide.manager;

import android.content.Context;

/* JADX INFO: loaded from: classes13.dex */
public interface ConnectivityMonitorFactory {
    ConnectivityMonitor build(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener);
}
