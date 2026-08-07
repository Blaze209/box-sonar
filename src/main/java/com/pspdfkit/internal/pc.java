package com.pspdfkit.internal;

import com.pspdfkit.utils.LogCatLogger;

/* JADX INFO: loaded from: classes3.dex */
public final class pc extends LogCatLogger {
    @Override // com.pspdfkit.utils.LogCatLogger, com.pspdfkit.utils.PdfLog.Logger
    public final boolean isLogged(int i, String str) {
        return super.isLogged(i, str) && i >= 4;
    }
}
