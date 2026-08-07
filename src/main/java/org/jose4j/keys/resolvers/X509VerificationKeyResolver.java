package org.jose4j.keys.resolvers;

import java.security.Key;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwx.JsonWebStructure;
import org.jose4j.keys.X509Util;
import org.jose4j.lang.ExceptionHelp;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UncheckedJoseException;
import org.jose4j.lang.UnresolvableKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class X509VerificationKeyResolver implements VerificationKeyResolver {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) X509VerificationKeyResolver.class);
    private boolean tryAllOnNoThumbHeader;
    private Map<String, X509Certificate> x5tMap;
    private Map<String, X509Certificate> x5tS256Map;

    public X509VerificationKeyResolver(List<X509Certificate> list) {
        this.x5tMap = new LinkedHashMap();
        this.x5tS256Map = new LinkedHashMap();
        for (X509Certificate x509Certificate : list) {
            try {
                this.x5tMap.put(X509Util.x5t(x509Certificate), x509Certificate);
                this.x5tS256Map.put(X509Util.x5tS256(x509Certificate), x509Certificate);
            } catch (UncheckedJoseException e) {
                log.warn("Unable to get certificate thumbprint.", (Throwable) e);
            }
        }
    }

    public X509VerificationKeyResolver(X509Certificate... x509CertificateArr) {
        this((List<X509Certificate>) Arrays.asList(x509CertificateArr));
    }

    public void setTryAllOnNoThumbHeader(boolean z) {
        this.tryAllOnNoThumbHeader = z;
    }

    @Override // org.jose4j.keys.resolvers.VerificationKeyResolver
    public Key resolveKey(JsonWebSignature jsonWebSignature, List<JsonWebStructure> list) throws UnresolvableKeyException {
        String x509CertSha1ThumbprintHeaderValue = jsonWebSignature.getX509CertSha1ThumbprintHeaderValue();
        String x509CertSha256ThumbprintHeaderValue = jsonWebSignature.getX509CertSha256ThumbprintHeaderValue();
        if (x509CertSha1ThumbprintHeaderValue == null && x509CertSha256ThumbprintHeaderValue == null) {
            if (this.tryAllOnNoThumbHeader) {
                return attemptAll(jsonWebSignature);
            }
            throw new UnresolvableKeyException("Neither the x5t header nor the x5t#S256 header are present in the JWS.");
        }
        X509Certificate x509Certificate = this.x5tMap.get(x509CertSha1ThumbprintHeaderValue);
        if (x509Certificate == null) {
            x509Certificate = this.x5tS256Map.get(x509CertSha256ThumbprintHeaderValue);
        }
        if (x509Certificate == null) {
            StringBuilder sb = new StringBuilder("The X.509 Certificate Thumbprint header(s) in the JWS do not identify any of the provided Certificates -");
            if (x509CertSha1ThumbprintHeaderValue != null) {
                sb.append(" x5t=").append(x509CertSha1ThumbprintHeaderValue);
                sb.append(" vs. SHA-1 thumbs:").append(this.x5tMap.keySet());
            }
            if (x509CertSha256ThumbprintHeaderValue != null) {
                sb.append(" x5t#S256=").append(x509CertSha256ThumbprintHeaderValue);
                sb.append(" vs. SHA-256 thumbs:").append(this.x5tS256Map.keySet());
            }
            sb.append(".");
            throw new UnresolvableKeyException(sb.toString());
        }
        return x509Certificate.getPublicKey();
    }

    private Key attemptAll(JsonWebSignature jsonWebSignature) throws UnresolvableKeyException {
        Iterator<X509Certificate> it = this.x5tMap.values().iterator();
        while (it.hasNext()) {
            PublicKey publicKey = it.next().getPublicKey();
            jsonWebSignature.setKey(publicKey);
            try {
                if (jsonWebSignature.verifySignature()) {
                    return publicKey;
                }
            } catch (JoseException e) {
                log.debug("Verify signature didn't work: {}", ExceptionHelp.toStringWithCauses(e));
            }
        }
        throw new UnresolvableKeyException("Unable to verify the signature with any of the provided keys - SHA-1 thumbs of provided certificates: " + this.x5tMap.keySet() + ".");
    }
}
