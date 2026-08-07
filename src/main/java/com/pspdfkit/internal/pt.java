package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeDataSink;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class pt extends NativeDataSink {
    public final OutputStream a;

    public pt(OutputStream outputStream) {
        this.a = outputStream;
    }

    @Override // com.pspdfkit.internal.jni.NativeDataSink
    public final boolean finish() {
        try {
            this.a.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.pspdfkit.internal.jni.NativeDataSink
    public final boolean writeData(byte[] bArr) {
        try {
            this.a.write(bArr);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
