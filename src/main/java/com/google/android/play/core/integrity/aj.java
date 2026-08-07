package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class aj {
    private static s a;

    static synchronized s a(Context context) {
        if (a == null) {
            q qVar = new q(null);
            qVar.a(com.google.android.play.integrity.internal.ae.a(context));
            a = qVar.b();
        }
        return a;
    }
}
