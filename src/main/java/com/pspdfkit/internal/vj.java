package com.pspdfkit.internal;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class vj {
    public static /* synthetic */ String a(int i) {
        if (i == 1) {
            return "GET";
        }
        if (i == 2) {
            return "POST";
        }
        if (i != 3) {
            return i != 4 ? AbstractJsonLexerKt.NULL : "DELETE";
        }
        return "PUT";
    }
}
