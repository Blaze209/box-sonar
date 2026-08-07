package sdk.pendo.io.c1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.jose4j.zip.CompressionAlgorithmIdentifiers;
import sdk.pendo.io.a1.g;

/* JADX INFO: loaded from: classes4.dex */
public class b implements a {
    @Override // sdk.pendo.io.c1.a
    public byte[] a(byte[] bArr) {
        Inflater inflater = new Inflater(true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr), inflater);
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int i = inflaterInputStream.read(bArr2);
                        if (i == -1) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            inflaterInputStream.close();
                            inflater.end();
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr2, 0, i);
                    }
                } catch (Throwable th) {
                    try {
                        inflaterInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                throw new g("Problem decompressing data.", e);
            }
        } catch (Throwable th3) {
            inflater.end();
            throw th3;
        }
    }

    @Override // sdk.pendo.io.q0.a
    public String c() {
        return CompressionAlgorithmIdentifiers.DEFLATE;
    }

    @Override // sdk.pendo.io.q0.a
    public boolean d() {
        return true;
    }
}
