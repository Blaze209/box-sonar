package com.microsoft.identity.common.internal.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertPathValidator;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes14.dex */
public final class PackageUtils {
    private static final Pattern HEX_PATTERN = Pattern.compile("([A-Fa-f0-9]{2}:)*[A-Fa-f0-9]{2}");

    private PackageUtils() {
    }

    public static List<X509Certificate> readCertDataForApp(String str, Context context) throws GeneralSecurityException, PackageManager.NameNotFoundException, IOException, ClientException {
        PackageInfo packageInfo = PackageHelper.getPackageInfo(context.getPackageManager(), str);
        if (packageInfo == null) {
            throw new ClientException(ErrorStrings.APP_PACKAGE_NAME_NOT_FOUND, "No broker package existed.");
        }
        Signature[] signatures = PackageHelper.getSignatures(packageInfo);
        if (signatures == null || signatures.length == 0) {
            throw new ClientException(ErrorStrings.BROKER_APP_VERIFICATION_FAILED, "No signature associated with the broker package.");
        }
        ArrayList arrayList = new ArrayList(signatures.length);
        for (Signature signature : signatures) {
            try {
                arrayList.add(createCertificateFromByteArray(signature.toByteArray()));
            } catch (CertificateException unused) {
                throw new ClientException(ErrorStrings.BROKER_APP_VERIFICATION_FAILED);
            }
        }
        return arrayList;
    }

    public static X509Certificate createCertificateFromByteArray(byte[] bArr) throws CertificateException {
        return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(bArr));
    }

    public static String verifySignatureHash(List<X509Certificate> list, Iterator<String> it) throws NoSuchAlgorithmException, ClientException, CertificateEncodingException {
        StringBuilder sb = new StringBuilder();
        for (X509Certificate x509Certificate : list) {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_512);
            messageDigest.update(x509Certificate.getEncoded());
            String strEncodeToString = Base64.encodeToString(messageDigest.digest(), 2);
            sb.append(strEncodeToString);
            sb.append(AbstractJsonLexerKt.COMMA);
            while (it.hasNext()) {
                String next = it.next();
                if (HEX_PATTERN.matcher(next).matches()) {
                    next = convertToBase64(next);
                }
                if (!TextUtils.isEmpty(next) && next.equals(strEncodeToString)) {
                    return strEncodeToString;
                }
            }
        }
        throw new ClientException(ClientException.BROKER_VERIFICATION_FAILED_ERROR, "Calling app could not be verified SignatureHashes: " + sb.toString());
    }

    public static String convertToBase64(String str) {
        String[] strArrSplit = str.split(":");
        byte[] bArr = new byte[strArrSplit.length];
        int length = strArrSplit.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) (Long.parseLong(strArrSplit[i], 16) & 255);
            i++;
            i2++;
        }
        return Base64.encodeToString(bArr, 2);
    }

    public static void verifyCertificateChain(List<X509Certificate> list) throws GeneralSecurityException, ClientException {
        PKIXParameters pKIXParameters = new PKIXParameters((Set<TrustAnchor>) Collections.singleton(new TrustAnchor(getSelfSignedCert(list), null)));
        pKIXParameters.setRevocationEnabled(false);
        CertPathValidator.getInstance("PKIX").validate(CertificateFactory.getInstance("X.509").generateCertPath(list), pKIXParameters);
    }

    public static final X509Certificate getSelfSignedCert(List<X509Certificate> list) throws ClientException {
        int i = 0;
        X509Certificate x509Certificate = null;
        for (X509Certificate x509Certificate2 : list) {
            if (x509Certificate2.getSubjectDN().equals(x509Certificate2.getIssuerDN())) {
                i++;
                x509Certificate = x509Certificate2;
            }
        }
        if (i > 1 || x509Certificate == null) {
            throw new ClientException(ErrorStrings.BROKER_APP_VERIFICATION_FAILED, "Multiple self signed certs found or no self signed cert existed.");
        }
        return x509Certificate;
    }
}
