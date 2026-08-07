package org.jose4j.jwx;

import java.security.Key;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jose4j.base64url.Base64Url;
import org.jose4j.jca.ProviderContext;
import org.jose4j.jwa.Algorithm;
import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.keys.X509Util;
import org.jose4j.lang.InvalidAlgorithmException;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class JsonWebStructure {
    private static final ProviderContext DEFAULT_PROVIDER_CONTEXT = new ProviderContext();
    private byte[] integrity;
    private Key key;
    protected String rawCompactSerialization;
    protected Base64Url base64url = new Base64Url();
    protected Headers headers = new Headers();
    protected boolean doKeyValidation = true;
    private AlgorithmConstraints algorithmConstraints = AlgorithmConstraints.NO_CONSTRAINTS;
    private Set<String> knownCriticalHeaders = Collections.emptySet();
    private ProviderContext providerCtx = DEFAULT_PROVIDER_CONTEXT;

    public abstract Algorithm getAlgorithm() throws InvalidAlgorithmException;

    public abstract Algorithm getAlgorithmNoConstraintCheck() throws InvalidAlgorithmException;

    public abstract String getCompactSerialization() throws JoseException;

    public abstract String getPayload() throws JoseException;

    protected boolean isSupportedCriticalHeader(String str) {
        return false;
    }

    protected void onNewKey() {
    }

    protected abstract void setCompactSerializationParts(String[] strArr) throws JoseException;

    public abstract void setPayload(String str);

    public static JsonWebStructure fromCompactSerialization(String str) throws JoseException {
        JsonWebStructure jsonWebSignature;
        String[] strArrDeserialize = CompactSerializer.deserialize(str);
        if (strArrDeserialize.length == 5) {
            jsonWebSignature = new JsonWebEncryption();
        } else if (strArrDeserialize.length == 3) {
            jsonWebSignature = new JsonWebSignature();
        } else {
            throw new JoseException("Invalid JOSE Compact Serialization. Expecting either 3 or 5 parts for JWS or JWE respectively but was " + strArrDeserialize.length + ".");
        }
        jsonWebSignature.setCompactSerializationParts(strArrDeserialize);
        jsonWebSignature.rawCompactSerialization = str;
        return jsonWebSignature;
    }

    public void setCompactSerialization(String str) throws JoseException {
        setCompactSerializationParts(CompactSerializer.deserialize(str));
        this.rawCompactSerialization = str;
    }

    public String getHeader() {
        return getHeaders().getFullHeaderAsJsonString();
    }

    protected String getEncodedHeader() {
        return this.headers.getEncodedHeader();
    }

    public void setHeader(String str, String str2) {
        this.headers.setStringHeaderValue(str, str2);
    }

    protected void setEncodedHeader(String str) throws JoseException {
        checkNotEmptyPart(str, "Encoded Header");
        this.headers.setEncodedHeader(str);
    }

    public Headers getHeaders() {
        return this.headers;
    }

    protected void checkNotEmptyPart(String str, String str2) throws JoseException {
        if (str == null || str.length() == 0) {
            throw new JoseException("The " + str2 + " cannot be empty.");
        }
    }

    public String getHeader(String str) {
        return this.headers.getStringHeaderValue(str);
    }

    public void setHeader(String str, Object obj) {
        this.headers.setObjectHeaderValue(str, obj);
    }

    public Object getObjectHeader(String str) {
        return this.headers.getObjectHeaderValue(str);
    }

    public void setAlgorithmHeaderValue(String str) {
        setHeader("alg", str);
    }

    public String getAlgorithmHeaderValue() {
        return getHeader("alg");
    }

    public void setContentTypeHeaderValue(String str) {
        setHeader("cty", str);
    }

    public String getContentTypeHeaderValue() {
        return getHeader("cty");
    }

    public void setKeyIdHeaderValue(String str) {
        setHeader("kid", str);
    }

    public String getKeyIdHeaderValue() {
        return getHeader("kid");
    }

    public PublicJsonWebKey getJwkHeader() throws JoseException {
        return this.headers.getPublicJwkHeaderValue("jwk", null);
    }

    public void setJwkHeader(PublicJsonWebKey publicJsonWebKey) {
        this.headers.setJwkHeaderValue("jwk", publicJsonWebKey);
    }

    public X509Certificate getLeafCertificateHeaderValue() throws JoseException {
        List<X509Certificate> certificateChainHeaderValue = getCertificateChainHeaderValue();
        if (certificateChainHeaderValue == null || certificateChainHeaderValue.isEmpty()) {
            return null;
        }
        return certificateChainHeaderValue.get(0);
    }

    public List<X509Certificate> getCertificateChainHeaderValue() throws JoseException {
        Object objectHeaderValue = this.headers.getObjectHeaderValue("x5c");
        if (!(objectHeaderValue instanceof List)) {
            return null;
        }
        List list = (List) objectHeaderValue;
        ArrayList arrayList = new ArrayList(list.size());
        X509Util x509Util = new X509Util();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(x509Util.fromBase64Der((String) it.next()));
        }
        return arrayList;
    }

    public void setCertificateChainHeaderValue(X509Certificate... x509CertificateArr) {
        ArrayList arrayList = new ArrayList();
        X509Util x509Util = new X509Util();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            arrayList.add(x509Util.toBase64(x509Certificate));
        }
        this.headers.setObjectHeaderValue("x5c", arrayList);
    }

    public String getX509CertSha1ThumbprintHeaderValue() {
        return getHeader("x5t");
    }

    public void setX509CertSha1ThumbprintHeaderValue(String str) {
        setHeader("x5t", str);
    }

    public void setX509CertSha1ThumbprintHeaderValue(X509Certificate x509Certificate) {
        setX509CertSha1ThumbprintHeaderValue(X509Util.x5t(x509Certificate));
    }

    public String getX509CertSha256ThumbprintHeaderValue() {
        return getHeader("x5t#S256");
    }

    public void setX509CertSha256ThumbprintHeaderValue(String str) {
        setHeader("x5t#S256", str);
    }

    public void setX509CertSha256ThumbprintHeaderValue(X509Certificate x509Certificate) {
        setX509CertSha256ThumbprintHeaderValue(X509Util.x5tS256(x509Certificate));
    }

    public Key getKey() {
        return this.key;
    }

    public void setKey(Key key) {
        Key key2 = this.key;
        if (key != null ? key2 == null || !key.equals(key2) : key2 != null) {
            onNewKey();
        }
        this.key = key;
    }

    protected byte[] getIntegrity() {
        return this.integrity;
    }

    protected void setIntegrity(byte[] bArr) {
        this.integrity = bArr;
    }

    public boolean isDoKeyValidation() {
        return this.doKeyValidation;
    }

    public void setDoKeyValidation(boolean z) {
        this.doKeyValidation = z;
    }

    protected AlgorithmConstraints getAlgorithmConstraints() {
        return this.algorithmConstraints;
    }

    public void setAlgorithmConstraints(AlgorithmConstraints algorithmConstraints) {
        this.algorithmConstraints = algorithmConstraints;
    }

    public void setCriticalHeaderNames(String... strArr) {
        this.headers.setObjectHeaderValue("crit", strArr);
    }

    public void setKnownCriticalHeaders(String... strArr) {
        this.knownCriticalHeaders = new HashSet(Arrays.asList(strArr));
    }

    protected void checkCrit() throws JoseException {
        List<String> listAsList;
        Object objectHeaderValue = this.headers.getObjectHeaderValue("crit");
        if (objectHeaderValue != null) {
            if (objectHeaderValue instanceof List) {
                listAsList = (List) objectHeaderValue;
            } else if (objectHeaderValue instanceof String[]) {
                listAsList = Arrays.asList((String[]) objectHeaderValue);
            } else {
                throw new JoseException("crit header value not an array (" + objectHeaderValue.getClass() + ").");
            }
            for (String str : listAsList) {
                if (!this.knownCriticalHeaders.contains(str) && !isSupportedCriticalHeader(str)) {
                    throw new JoseException("Unrecognized header '" + str + "' marked as critical.");
                }
            }
        }
    }

    protected ProviderContext getProviderCtx() {
        return this.providerCtx;
    }

    public void setProviderContext(ProviderContext providerContext) {
        this.providerCtx = providerContext;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(getHeaders().getFullHeaderAsJsonString());
        if (this.rawCompactSerialization != null) {
            sb.append("->").append(this.rawCompactSerialization);
        }
        return sb.toString();
    }
}
