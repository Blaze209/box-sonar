package com.pspdfkit.signatures;

import android.content.Context;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.j20;
import com.pspdfkit.internal.jni.NativeKeyStore;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.n5;
import com.pspdfkit.utils.PdfLog;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fJ\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\rH\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/pspdfkit/signatures/TrustedKeyStore;", "", "<init>", "()V", "LOG_TAG", "", "trustedCertificates", "", "Ljava/security/cert/X509Certificate;", "ANDROID_KEYSTORE_NAME", "isDirty", "Ljava/util/concurrent/atomic/AtomicBoolean;", "nativeKeyStore", "Lcom/pspdfkit/internal/jni/NativeKeyStore;", "addTrustedCertificates", "", "certificates", "", "getTrustedCertificates", "clearTrustedCertificates", "restoreDefaults", "loadOsTrustedCertificates", "loadAdobeTrustedCertificates", "loadKeystoreCertificates", "keyStore", "Ljava/security/KeyStore;", "toNativeKeystore", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TrustedKeyStore {
    public static final int $stable;
    private static final String ANDROID_KEYSTORE_NAME = "AndroidCAStore";
    public static final TrustedKeyStore INSTANCE;
    private static final String LOG_TAG = "Nutri.KeyStore";
    private static final AtomicBoolean isDirty;
    private static NativeKeyStore nativeKeyStore;
    private static List<X509Certificate> trustedCertificates;

    static {
        TrustedKeyStore trustedKeyStore = new TrustedKeyStore();
        INSTANCE = trustedKeyStore;
        trustedCertificates = new ArrayList();
        isDirty = new AtomicBoolean(true);
        trustedKeyStore.restoreDefaults();
        $stable = 8;
    }

    private TrustedKeyStore() {
    }

    private final void loadAdobeTrustedCertificates() {
        Context context = n5.a;
        if (context == null) {
            throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
        }
        try {
            InputStream inputStreamOpen = context.getAssets().open("nutrient/AdobeCA.p12", 2);
            try {
                KeyStore keyStore = KeyStore.getInstance("PKCS12");
                char[] charArray = "pspdfadobeca".toCharArray();
                charArray.getClass();
                keyStore.load(inputStreamOpen, charArray);
                INSTANCE.loadKeystoreCertificates(keyStore);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(inputStreamOpen, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpen, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            PdfLog.w(LOG_TAG, e, "Couldn't load AdobeCA certificate store, make sure your APK still contains assets/nutrient/AdobeCA.p12 file!", new Object[0]);
        }
    }

    private final void loadKeystoreCertificates(KeyStore keyStore) throws KeyStoreException {
        Enumeration<String> enumerationAliases = keyStore.aliases();
        while (enumerationAliases.hasMoreElements()) {
            String strNextElement = enumerationAliases.nextElement();
            if (keyStore.isCertificateEntry(strNextElement)) {
                PdfLog.d(LOG_TAG, "Certificate alias: %s", strNextElement);
                Certificate certificate = keyStore.getCertificate(strNextElement);
                if (Intrinsics.areEqual("X.509", certificate.getType())) {
                    X509Certificate x509Certificate = (X509Certificate) certificate;
                    PdfLog.d(LOG_TAG, "X.509 CA certificate, subject: %s issuer: %s version: %d", x509Certificate.getSubjectDN().toString(), x509Certificate.getIssuerDN().toString(), Integer.valueOf(x509Certificate.getVersion()));
                    trustedCertificates.add(x509Certificate);
                } else {
                    PdfLog.w(LOG_TAG, "Can't load certificate type '%s' for certificate %s.", certificate.getType(), certificate.toString());
                }
            }
        }
    }

    private final void loadOsTrustedCertificates() {
        try {
            KeyStore keyStore = KeyStore.getInstance(ANDROID_KEYSTORE_NAME);
            keyStore.load(null, null);
            loadKeystoreCertificates(keyStore);
        } catch (Exception e) {
            PdfLog.e(LOG_TAG, e, "Failed to load operating system CA keystore.", new Object[0]);
        }
    }

    @JvmStatic
    public static final NativeKeyStore toNativeKeystore() {
        NativeKeyStore nativeKeyStore2;
        synchronized (INSTANCE) {
            if (nativeKeyStore == null) {
                nativeKeyStore = NativeKeyStore.create();
            }
            nativeKeyStore2 = nativeKeyStore;
            if (nativeKeyStore2 == null) {
                throw new IllegalStateException("NativeKeyStore is null!");
            }
            if (isDirty.get()) {
                for (X509Certificate x509Certificate : trustedCertificates) {
                    try {
                        nativeKeyStore2.addCertificate(j20.a(x509Certificate));
                    } catch (CertificateEncodingException e) {
                        PdfLog.d(LOG_TAG, e, "Couldn't encode certificate: %s", x509Certificate.toString());
                    }
                }
                isDirty.set(false);
            }
        }
        return nativeKeyStore2;
    }

    public final void addTrustedCertificates(List<? extends X509Certificate> certificates) {
        certificates.getClass();
        if (!ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES)) {
            throw new InvalidNutrientLicenseException("Digital signatures are not enabled in your license.");
        }
        trustedCertificates.addAll(certificates);
        List<X509Certificate> list = trustedCertificates;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (hashSet.add(((X509Certificate) obj).getSerialNumber())) {
                arrayList.add(obj);
            }
        }
        trustedCertificates = CollectionsKt.toMutableList((Collection) arrayList);
        isDirty.set(true);
    }

    public final void clearTrustedCertificates() {
        trustedCertificates.clear();
        nativeKeyStore = null;
        isDirty.set(true);
    }

    public final List<X509Certificate> getTrustedCertificates() {
        return trustedCertificates;
    }

    public final void restoreDefaults() {
        if (!ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES)) {
            throw new InvalidNutrientLicenseException("Digital signatures are not enabled in your license.");
        }
        trustedCertificates.clear();
        loadOsTrustedCertificates();
        loadAdobeTrustedCertificates();
        List<X509Certificate> list = trustedCertificates;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (hashSet.add(((X509Certificate) obj).getSerialNumber())) {
                arrayList.add(obj);
            }
        }
        trustedCertificates = CollectionsKt.toMutableList((Collection) arrayList);
        isDirty.set(true);
    }
}
