package com.pspdfkit.internal;

import com.pspdfkit.document.printing.PrintOptions;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class zu implements dn {
    public final cw a;

    public zu(cw cwVar) {
        this.a = cwVar;
    }

    @Override // com.pspdfkit.internal.dn
    public final boolean a(en enVar) {
        boolean z = enVar.b;
        cw cwVar = this.a;
        if (z) {
            cwVar.showPrintDialog();
            return true;
        }
        cwVar.performPrint(new PrintOptions(enVar.c, CollectionsKt.listOf(enVar.a)));
        return true;
    }
}
