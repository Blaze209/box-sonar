package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class bd {
    private final ax a;

    bd(ax axVar) {
        this.a = axVar;
    }

    final /* synthetic */ Task a(long j, long j2, StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
        return this.a.c(standardIntegrityTokenRequest.a(), j, j2);
    }
}
