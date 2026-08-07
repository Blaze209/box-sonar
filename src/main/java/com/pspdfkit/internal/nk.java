package com.pspdfkit.internal;

import com.pspdfkit.document.providers.DataProvider;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class nk extends InputStream {
    public final DataProvider a;
    public int b = 0;

    public nk(DataProvider dataProvider) {
        uw.a(dataProvider, "dataProvider", null);
        this.a = dataProvider;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        long size = this.a.getSize();
        if (size != -1) {
            return (int) (size - ((long) this.b));
        }
        return 0;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (available() == 0 && this.a.getSize() != -1) {
            return -1;
        }
        byte[] bArr = this.a.read(1L, this.b);
        this.b++;
        if (bArr != DataProvider.NO_DATA_AVAILABLE) {
            return bArr[0] + 127;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2;
        if (this.a.getSize() != -1) {
            i2 = Math.min(available(), i2);
        }
        if (i2 == 0 || (bArr2 = this.a.read(i2, this.b)) == DataProvider.NO_DATA_AVAILABLE) {
            return -1;
        }
        this.b += i2;
        System.arraycopy(bArr2, 0, bArr, i, i2);
        return i2;
    }
}
