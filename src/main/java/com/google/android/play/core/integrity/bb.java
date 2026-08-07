package com.google.android.play.core.integrity;

import android.app.PendingIntent;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class bb extends StandardIntegrityManager.StandardIntegrityToken {
    private final String a;
    private final u b;

    bb(String str, com.google.android.play.integrity.internal.q qVar, PendingIntent pendingIntent) {
        this.a = str;
        this.b = new u(qVar, pendingIntent);
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityToken
    public final String token() {
        return this.a;
    }
}
