package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class v {
    private static o a;

    static synchronized o a(Context context) {
        if (a == null) {
            m mVar = new m(null);
            mVar.a(com.google.android.play.integrity.internal.ae.a(context));
            a = mVar.b();
        }
        return a;
    }
}
