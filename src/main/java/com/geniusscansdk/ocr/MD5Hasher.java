package com.geniusscansdk.ocr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: MD5Hasher.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/geniusscansdk/ocr/MD5Hasher;", "", "<init>", "()V", "md5", "", "file", "Ljava/io/File;", "inputStream", "Ljava/io/InputStream;", "bytesToHex", "bytes", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MD5Hasher {
    public final String md5(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return md5(new FileInputStream(file));
    }

    public final String md5(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        byte[] bArr = new byte[8192];
        DigestInputStream digestInputStream = new DigestInputStream(inputStream, messageDigest);
        try {
            while (digestInputStream.read(bArr) >= 0) {
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(digestInputStream, null);
            byte[] bArrDigest = messageDigest.digest();
            Intrinsics.checkNotNull(bArrDigest);
            return bytesToHex(bArrDigest);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(digestInputStream, th);
                throw th2;
            }
        }
    }

    private final String bytesToHex(byte[] bytes) {
        return ArraysKt.joinToString$default(bytes, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.geniusscansdk.ocr.MD5Hasher$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MD5Hasher.bytesToHex$lambda$1(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence bytesToHex$lambda$1(byte b) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
