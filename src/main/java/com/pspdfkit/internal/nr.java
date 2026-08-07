package com.pspdfkit.internal;

import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.jni.NativeDataProvider;
import com.pspdfkit.utils.PdfLog;

/* JADX INFO: loaded from: classes3.dex */
public final class nr implements DataProvider {
    public final NativeDataProvider a;

    public nr(NativeDataProvider nativeDataProvider) {
        this.a = nativeDataProvider;
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public final long getSize() {
        try {
            return this.a.getSize();
        } catch (RuntimeException e) {
            PdfLog.e("Nutri.NativeDProvShim", "Exception on getSize: %s", e);
            return -1L;
        }
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public final String getTitle() {
        return null;
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public final String getUid() {
        try {
            return this.a.getUid();
        } catch (RuntimeException e) {
            PdfLog.e("Nutri.NativeDProvShim", "Exception on getUid: %s", e);
            return "";
        }
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public final byte[] read(long j, long j2) {
        try {
            return this.a.read(j, j2).getSpanView();
        } catch (RuntimeException e) {
            PdfLog.e("Nutri.NativeDProvShim", "Exception on read: %s", e);
            return new byte[0];
        }
    }

    @Override // com.pspdfkit.document.providers.DataProvider
    public final void release() {
    }
}
