package io.opentelemetry.exporter.internal;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes4.dex */
public final class TlsUtil {
    private static final String PEM_KEY_FOOTER = "-----END PRIVATE KEY-----";
    private static final String PEM_KEY_HEADER = "-----BEGIN PRIVATE KEY-----";
    private static final List<KeyFactory> SUPPORTED_KEY_FACTORIES;

    static {
        ArrayList arrayList = new ArrayList();
        SUPPORTED_KEY_FACTORIES = arrayList;
        try {
            arrayList.add(KeyFactory.getInstance("RSA"));
        } catch (NoSuchAlgorithmException unused) {
        }
        try {
            SUPPORTED_KEY_FACTORIES.add(KeyFactory.getInstance("EC"));
        } catch (NoSuchAlgorithmException unused2) {
        }
    }

    private TlsUtil() {
    }

    public static SSLSocketFactory sslSocketFactory(@Nullable KeyManager keyManager, TrustManager trustManager) throws SSLException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            if (keyManager == null) {
                sSLContext.init(null, new TrustManager[]{trustManager}, null);
            } else {
                sSLContext.init(new KeyManager[]{keyManager}, new TrustManager[]{trustManager}, null);
            }
            return sSLContext.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            throw new SSLException("Could not set trusted certificates for TLS connection, are they valid X.509 in PEM format?", e);
        }
    }

    public static X509KeyManager keyManager(byte[] bArr, byte[] bArr2) throws SSLException {
        Objects.requireNonNull(bArr, "privateKeyPem");
        Objects.requireNonNull(bArr2, "certificatePem");
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            PrivateKey privateKeyGeneratePrivateKey = generatePrivateKey(new PKCS8EncodedKeySpec(decodePem(bArr)), SUPPORTED_KEY_FACTORIES);
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ArrayList arrayList = new ArrayList();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2);
            while (byteArrayInputStream.available() > 0) {
                arrayList.add(certificateFactory.generateCertificate(byteArrayInputStream));
            }
            keyStore.setKeyEntry("trusted", privateKeyGeneratePrivateKey, "".toCharArray(), (Certificate[]) arrayList.toArray(new Certificate[0]));
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "".toCharArray());
            return (X509KeyManager) keyManagerFactory.getKeyManagers()[0];
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e) {
            throw new SSLException("Could not build KeyManagerFactory from clientKeysPem.", e);
        }
    }

    static PrivateKey generatePrivateKey(PKCS8EncodedKeySpec pKCS8EncodedKeySpec, List<KeyFactory> list) throws SSLException {
        Iterator<KeyFactory> it = list.iterator();
        while (it.hasNext()) {
            try {
                return it.next().generatePrivate(pKCS8EncodedKeySpec);
            } catch (InvalidKeySpecException unused) {
            }
        }
        throw new SSLException("Unable to generate key from supported algorithms: " + ((String) list.stream().map(new Function() { // from class: io.opentelemetry.exporter.internal.TlsUtil$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((KeyFactory) obj).getAlgorithm();
            }
        }).collect(Collectors.joining(",", "[", "]"))));
    }

    public static X509TrustManager trustManager(byte[] bArr) throws SSLException {
        Objects.requireNonNull(bArr, "trustedCertificatesPem");
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            int i = 0;
            while (byteArrayInputStream.available() > 0) {
                keyStore.setCertificateEntry("cert_" + i, (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream));
                i++;
            }
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            return (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            throw new SSLException("Could not build TrustManagerFactory from trustedCertificatesPem.", e);
        }
    }

    static byte[] decodePem(byte[] bArr) {
        String strTrim = new String(bArr, StandardCharsets.UTF_8).trim();
        if (!strTrim.startsWith("-----BEGIN PRIVATE KEY-----") || !strTrim.endsWith("-----END PRIVATE KEY-----")) {
            return bArr;
        }
        try {
            return Base64.getDecoder().decode(strTrim.substring("-----BEGIN PRIVATE KEY-----".length(), strTrim.length() - "-----END PRIVATE KEY-----".length()).replaceAll("\\s", ""));
        } catch (LinkageError unused) {
            throw new IllegalArgumentException("PEM private keys are currently not supported on Android. You may try a key encoded as DER.");
        }
    }
}
