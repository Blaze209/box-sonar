package io.split.android.client.network;

import io.split.android.client.utils.logger.Logger;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
class CertificateCheckerHelper {
    CertificateCheckerHelper() {
    }

    static Set<CertificatePin> getPinsForHost(String pattern, Map<String, Set<CertificatePin>> configuredPins) {
        String strSubstring;
        int iLastIndexOf;
        Set<CertificatePin> set = configuredPins.get(pattern);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : configuredPins.keySet()) {
            if (str.startsWith("**.")) {
                String strSubstring2 = str.substring(3);
                if (pattern.regionMatches(pattern.length() - strSubstring2.length(), strSubstring2, 0, strSubstring2.length())) {
                    linkedHashSet.addAll(configuredPins.get(str));
                }
            } else if (str.startsWith("*.") && (iLastIndexOf = pattern.lastIndexOf((strSubstring = str.substring(2)))) != -1) {
                int i = iLastIndexOf - 1;
                if (pattern.charAt(i) == '.' && pattern.regionMatches(iLastIndexOf, strSubstring, 0, strSubstring.length()) && pattern.substring(0, i).split("\\.").length == 1) {
                    linkedHashSet.addAll(configuredPins.get(str));
                }
            }
        }
        if (set == null && linkedHashSet.isEmpty()) {
            return null;
        }
        if (set != null) {
            linkedHashSet.addAll(set);
        }
        return linkedHashSet;
    }

    static Set<CertificatePin> getPinsFromInputStream(InputStream inputStream, PinEncoder pinEncoder) {
        try {
            try {
                Collection<? extends Certificate> collectionGenerateCertificates = CertificateFactory.getInstance("X.509").generateCertificates(inputStream);
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (Certificate certificate : collectionGenerateCertificates) {
                    if (certificate instanceof X509Certificate) {
                        linkedHashSet.add(new CertificatePin(pinEncoder.encodeCertPin("sha256", certificate.getPublicKey().getEncoded()), "sha256"));
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return linkedHashSet;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            Logger.e("Error parsing certificate pins from input stream: " + e.getLocalizedMessage());
            return new HashSet();
        }
    }
}
