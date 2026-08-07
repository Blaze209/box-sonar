package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeDocument;
import com.pspdfkit.internal.jni.NativePage;
import com.pspdfkit.internal.jni.NativeTextParser;
import com.pspdfkit.internal.jni.NativeTextParserResult;
import com.pspdfkit.utils.PdfLog;

/* JADX INFO: loaded from: classes3.dex */
public final class vv {
    public final NativeDocument a;
    public final int b;
    public final NativePage c;
    public String d;

    public vv(NativeDocument nativeDocument, int i, int i2) {
        NativePage page = nativeDocument.getPage(i);
        this.a = nativeDocument;
        this.b = i2;
        this.c = page;
        PdfLog.d("Nutri.PdfPage", "Loading page %d.", Integer.valueOf(i));
    }

    public final NativeTextParser a() {
        try {
            NativePage nativePage = this.c;
            if (nativePage != null) {
                NativeTextParserResult textParser = nativePage.getTextParser();
                textParser.getClass();
                if (textParser.getError() == null) {
                    return textParser.getTextParser();
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
