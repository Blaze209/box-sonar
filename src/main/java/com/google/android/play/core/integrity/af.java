package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class af implements com.google.android.play.integrity.internal.ai {
    private final com.google.android.play.integrity.internal.al a;
    private final com.google.android.play.integrity.internal.al b;

    public af(com.google.android.play.integrity.internal.al alVar, com.google.android.play.integrity.internal.al alVar2) {
        this.a = alVar;
        this.b = alVar2;
    }

    @Override // com.google.android.play.integrity.internal.al
    public final /* bridge */ /* synthetic */ Object a() {
        return new ad((Context) this.a.a(), (com.google.android.play.integrity.internal.q) this.b.a());
    }
}
