package org.jose4j.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.jose4j.keys.KeyPersuasion;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UncheckedJoseException;

/* JADX INFO: loaded from: classes5.dex */
public class DeflateRFC1951CompressionAlgorithm implements CompressionAlgorithm {
    @Override // org.jose4j.jwa.Algorithm
    public String getJavaAlgorithm() {
        return null;
    }

    @Override // org.jose4j.jwa.Algorithm
    public String getKeyType() {
        return null;
    }

    @Override // org.jose4j.jwa.Algorithm
    public boolean isAvailable() {
        return true;
    }

    @Override // org.jose4j.zip.CompressionAlgorithm
    public byte[] compress(byte[] bArr) {
        Deflater deflater = new Deflater(8, true);
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                    try {
                        deflaterOutputStream.write(bArr);
                        deflaterOutputStream.finish();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        deflaterOutputStream.close();
                        byteArrayOutputStream.close();
                        deflater.end();
                        return byteArray;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                deflaterOutputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            } catch (IOException e) {
                throw new UncheckedJoseException("Problem compressing data.", e);
            }
        } catch (Throwable th7) {
            deflater.end();
            throw th7;
        }
    }

    @Override // org.jose4j.zip.CompressionAlgorithm
    public byte[] decompress(byte[] bArr) throws JoseException {
        Inflater inflater = new Inflater(true);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr), inflater);
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int i = inflaterInputStream.read(bArr2);
                        if (i != -1) {
                            byteArrayOutputStream.write(bArr2, 0, i);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            inflaterInputStream.close();
                            inflater.end();
                            return byteArray;
                        }
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            inflaterInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (IOException e) {
                throw new JoseException("Problem decompressing data.", e);
            }
        } catch (Throwable th4) {
            inflater.end();
            throw th4;
        }
    }

    @Override // org.jose4j.jwa.Algorithm
    public String getAlgorithmIdentifier() {
        return CompressionAlgorithmIdentifiers.DEFLATE;
    }

    @Override // org.jose4j.jwa.Algorithm
    public KeyPersuasion getKeyPersuasion() {
        return KeyPersuasion.NONE;
    }
}
