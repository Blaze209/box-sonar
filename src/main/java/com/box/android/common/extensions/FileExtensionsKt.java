package com.box.android.common.extensions;

import android.util.Log;
import com.google.common.base.Ascii;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0004\u001a\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"HEX_CHARS", "", "computeFileSha1", "", "Ljava/io/File;", "getUriIfExist", "Ljava/net/URI;", "asHex", "buf", "", "common_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileExtensionsKt {
    private static final char[] HEX_CHARS;

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        HEX_CHARS = charArray;
    }

    public static final String computeFileSha1(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[8192];
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    fileInputStream.close();
                    byte[] bArrDigest = messageDigest.digest();
                    Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
                    return asHex(bArrDigest);
                }
            }
        } catch (Exception e) {
            Log.e("File Extensions", e + " while computing sha1");
            return "";
        }
    }

    public static final URI getUriIfExist(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        if (file.exists()) {
            return file.toURI();
        }
        return null;
    }

    private static final String asHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            char[] cArr2 = HEX_CHARS;
            byte b = bArr[i];
            cArr[i2] = cArr2[(b & CtapException.ERR_VENDOR_FIRST) >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }
}
