package com.pspdfkit.signatures;

import com.box.android.data.datasource.auth.AuthenticationRemoteDataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u001a\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010*\u00020\u0001¨\u0006\u0011"}, d2 = {"getPrivateKeyEntryFromP12Stream", "Ljava/security/KeyStore$PrivateKeyEntry;", "inputStream", "Ljava/io/InputStream;", "password", "", "alias", "keyPassword", "getPrivateKeyFromFile", "Ljava/security/PrivateKey;", "loadCertificateFromFile", "Ljava/security/cert/X509Certificate;", "file", "Ljava/io/File;", "loadCertificateFromStream", "getX509Certificates", "", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class KeyFileHelpersKt {
    /* JADX WARN: Code duplicated, block: B:6:0x0014  */
    public static final KeyStore.PrivateKeyEntry getPrivateKeyEntryFromP12Stream(InputStream inputStream, String str, String str2, String str3) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, UnrecoverableEntryException {
        char[] charArray;
        KeyStore.PasswordProtection passwordProtection;
        inputStream.getClass();
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        if (str != null) {
            charArray = str.toCharArray();
            charArray.getClass();
            if (charArray == null) {
                charArray = "".toCharArray();
                charArray.getClass();
            }
        } else {
            charArray = "".toCharArray();
            charArray.getClass();
        }
        keyStore.load(inputStream, charArray);
        if (str2 == null) {
            str2 = keyStore.aliases().nextElement();
        }
        if (!keyStore.isKeyEntry(str2)) {
            throw new CertificateException("Certificate with alias " + str2 + " doesn't exist in passed keystore!");
        }
        if (str3 == null) {
            passwordProtection = null;
        } else {
            char[] charArray2 = str3.toCharArray();
            charArray2.getClass();
            passwordProtection = new KeyStore.PasswordProtection(charArray2);
        }
        KeyStore.Entry entry = keyStore.getEntry(str2, passwordProtection);
        if (entry == null) {
            throw new CertificateException("Certificate with alias " + str2 + " doesn't exist in passed keystore!");
        }
        KeyStore.PrivateKeyEntry privateKeyEntry = entry instanceof KeyStore.PrivateKeyEntry ? (KeyStore.PrivateKeyEntry) entry : null;
        if (privateKeyEntry != null) {
            return privateKeyEntry;
        }
        throw new CertificateException("Key entry " + str2 + " does not have a private key attached!");
    }

    public static /* synthetic */ KeyStore.PrivateKeyEntry getPrivateKeyEntryFromP12Stream$default(InputStream inputStream, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return getPrivateKeyEntryFromP12Stream(inputStream, str, str2, str3);
    }

    public static final PrivateKey getPrivateKeyFromFile(InputStream inputStream) throws InvalidKeySpecException, IOException {
        inputStream.getClass();
        Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String text = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            String strReplace$default = StringsKt.replace$default(text, AuthenticationRemoteDataSource.PEM_RSA_HEADER, "", false, 4, (Object) null);
            String strLineSeparator = System.lineSeparator();
            strLineSeparator.getClass();
            PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(StringsKt.encodeToByteArray(StringsKt.replace$default(new Regex(strLineSeparator).replace(strReplace$default, ""), AuthenticationRemoteDataSource.PEM_RSA_FOOTER, "", false, 4, (Object) null)))));
            privateKeyGeneratePrivate.getClass();
            return privateKeyGeneratePrivate;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedReader, th);
                throw th2;
            }
        }
    }

    public static final List<X509Certificate> getX509Certificates(KeyStore.PrivateKeyEntry privateKeyEntry) throws CertificateEncodingException {
        privateKeyEntry.getClass();
        Certificate[] certificateChain = privateKeyEntry.getCertificateChain();
        if (certificateChain == null) {
            certificateChain = new Certificate[]{privateKeyEntry.getCertificate()};
        }
        ArrayList arrayList = new ArrayList(certificateChain.length);
        for (Certificate certificate : certificateChain) {
            if (!(certificate instanceof X509Certificate)) {
                throw new CertificateEncodingException("The certificate inside the private key must be a X.509 certificate.");
            }
            arrayList.add((X509Certificate) certificate);
        }
        return CollectionsKt.toList(arrayList);
    }

    public static final X509Certificate loadCertificateFromFile(File file) throws IOException {
        file.getClass();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            X509Certificate x509CertificateLoadCertificateFromStream = loadCertificateFromStream(fileInputStream);
            CloseableKt.closeFinally(fileInputStream, null);
            return x509CertificateLoadCertificateFromStream;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final X509Certificate loadCertificateFromStream(InputStream inputStream) throws CertificateException {
        inputStream.getClass();
        Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
        if (certificateGenerateCertificate == null || !Intrinsics.areEqual("X.509", certificateGenerateCertificate.getType())) {
            throw new CertificateException("Loaded certificate is not an X.509 certificate!");
        }
        return (X509Certificate) certificateGenerateCertificate;
    }
}
