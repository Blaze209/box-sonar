package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativePublicKey;
import com.pspdfkit.internal.jni.NativeX509Certificate;
import com.pspdfkit.internal.jni.NativeX509ParseOptions;
import com.pspdfkit.signatures.DigitalSignatureType;
import com.pspdfkit.signatures.PublicKey;
import com.pspdfkit.signatures.SignatureAppearance;
import com.pspdfkit.signatures.X509CertificateData;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class j20 {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[DigitalSignatureType.values().length];
            try {
                iArr[DigitalSignatureType.CADES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DigitalSignatureType.BASIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[SignatureAppearance.SignatureAppearanceMode.values().length];
            try {
                iArr2[SignatureAppearance.SignatureAppearanceMode.DESCRIPTION_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[SignatureAppearance.SignatureAppearanceMode.SIGNATURE_AND_DESCRIPTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[SignatureAppearance.SignatureAppearanceMode.SIGNATURE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    public static final List a(List list) throws CertificateEncodingException {
        list.getClass();
        if (list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ArrayList<NativeX509Certificate> arrayListCreateFromData = NativeX509Certificate.createFromData(((X509Certificate) it.next()).getEncoded(), EnumSet.of(NativeX509ParseOptions.ALLOWCACERTIFICATES));
            arrayListCreateFromData.getClass();
            arrayList.addAll(arrayListCreateFromData);
        }
        if (arrayList.isEmpty()) {
            throw new CertificateEncodingException("Couldn't convert certificates!");
        }
        return arrayList;
    }

    public static final NativeX509Certificate a(X509Certificate x509Certificate) throws CertificateEncodingException {
        x509Certificate.getClass();
        ArrayList<NativeX509Certificate> arrayListCreateFromData = NativeX509Certificate.createFromData(x509Certificate.getEncoded(), EnumSet.of(NativeX509ParseOptions.ALLOWCACERTIFICATES));
        arrayListCreateFromData.getClass();
        if (!arrayListCreateFromData.isEmpty()) {
            return arrayListCreateFromData.get(0);
        }
        throw new CertificateEncodingException("Couldn't convert certificate!");
    }

    public static final X509CertificateData a(NativeX509Certificate nativeX509Certificate) {
        PublicKey publicKey;
        nativeX509Certificate.getClass();
        NativePublicKey publicKey2 = nativeX509Certificate.getPublicKey();
        if (publicKey2 == null) {
            publicKey = null;
        } else {
            String strPublicKeyScheme = publicKey2.publicKeyScheme();
            strPublicKeyScheme.getClass();
            publicKey = new PublicKey(strPublicKeyScheme, publicKey2.keyLength());
        }
        byte[] serialNumber = nativeX509Certificate.getSerialNumber();
        serialNumber.getClass();
        Charset charset = StandardCharsets.UTF_8;
        charset.getClass();
        return new X509CertificateData(publicKey, nativeX509Certificate.getIssuerCN(), nativeX509Certificate.getIssuerDN(), nativeX509Certificate.getSubjectCN(), nativeX509Certificate.getSubjectDN(), new String(serialNumber, charset), Boolean.valueOf(nativeX509Certificate.isSelfSigned()), Boolean.valueOf(nativeX509Certificate.isCACertificate()), nativeX509Certificate.getValidFrom(), nativeX509Certificate.getValidUntil());
    }
}
