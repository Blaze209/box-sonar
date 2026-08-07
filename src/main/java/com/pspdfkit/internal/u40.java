package com.pspdfkit.internal;

import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.pspdfkit.utils.PdfLog;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class u40 {
    public static final Charset a = StandardCharsets.UTF_8;
    public static final BigInteger b = new BigInteger("cbf29ce484222325", 16);
    public static final BigInteger c = new BigInteger("100000001b3", 16);

    public static long a(String str) {
        byte[] bytes = str.getBytes(a);
        if (bytes.length < 4) {
            throw new IllegalArgumentException("String too short, minimum 4 bytes!");
        }
        BigInteger bigIntegerMultiply = b;
        for (byte b2 : bytes) {
            bigIntegerMultiply = bigIntegerMultiply.xor(BigInteger.valueOf(b2 & 255)).multiply(c);
        }
        return bigIntegerMultiply.longValue();
    }

    public static String b(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bytes, 0, bytes.length);
            byte[] bArrDigest = messageDigest.digest();
            Formatter formatter = new Formatter();
            for (byte b2 : bArrDigest) {
                formatter.format("%02x", Byte.valueOf(b2));
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (NoSuchAlgorithmException unused) {
            throw new RuntimeException("Device is missing SHA-1!");
        }
    }

    public static String c(String str) throws NoSuchAlgorithmException {
        byte[] bytes = str.getBytes(a);
        return a(bytes, bytes.length);
    }

    public static String a(byte[] bArr, int i) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr, 0, Math.min(bArr.length, i));
            byte[] bArrDigest = messageDigest.digest();
            Formatter formatter = new Formatter();
            for (byte b2 : bArrDigest) {
                formatter.format("%02x", Byte.valueOf(b2));
            }
            String string = formatter.toString();
            formatter.close();
            return string;
        } catch (NoSuchAlgorithmException e) {
            PdfLog.e("Nutri.StringUtils", "Algorithm SHA-256 was not found!", e);
            throw new RuntimeException("Algorithm SHA-256 was not found!");
        }
    }

    public static String a(int i, boolean z, boolean z2) {
        String hexString = z2 ? Integer.toHexString(i) : String.format("%06X", Integer.valueOf(i & ViewCompat.MEASURED_SIZE_MASK));
        return z ? "#" + hexString : hexString;
    }

    public static String a(String str, List list) {
        StringBuilder sb = new StringBuilder(20);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!TextUtils.isEmpty(str2)) {
                sb.append(str2).append(str);
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }

    public static ArrayList a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            arrayList.add(num == null ? null : num.toString());
        }
        return arrayList;
    }
}
