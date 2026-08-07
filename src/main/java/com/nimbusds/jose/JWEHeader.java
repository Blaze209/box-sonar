package com.nimbusds.jose;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.shaded.jcip.Immutable;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.JSONObjectUtils;
import com.nimbusds.jose.util.X509CertChainUtils;
import java.net.URI;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class JWEHeader extends CommonSEHeader {
    private static final Set<String> REGISTERED_PARAMETER_NAMES;
    private static final long serialVersionUID = 1;
    private final Base64URL apu;
    private final Base64URL apv;
    private final List<String> aud;
    private final EncryptionMethod enc;
    private final JWK epk;
    private final String iss;
    private final Base64URL iv;
    private final int p2c;
    private final Base64URL p2s;
    private final String skid;
    private final String sub;
    private final Base64URL tag;
    private final CompressionAlgorithm zip;

    @Override // com.nimbusds.jose.CommonSEHeader
    public /* bridge */ /* synthetic */ JWK getJWK() {
        return super.getJWK();
    }

    @Override // com.nimbusds.jose.CommonSEHeader
    public /* bridge */ /* synthetic */ URI getJWKURL() {
        return super.getJWKURL();
    }

    @Override // com.nimbusds.jose.CommonSEHeader
    public /* bridge */ /* synthetic */ String getKeyID() {
        return super.getKeyID();
    }

    @Override // com.nimbusds.jose.CommonSEHeader
    public /* bridge */ /* synthetic */ List getX509CertChain() {
        return super.getX509CertChain();
    }

    @Override // com.nimbusds.jose.CommonSEHeader
    public /* bridge */ /* synthetic */ Base64URL getX509CertSHA256Thumbprint() {
        return super.getX509CertSHA256Thumbprint();
    }

    @Override // com.nimbusds.jose.CommonSEHeader
    @Deprecated
    public /* bridge */ /* synthetic */ Base64URL getX509CertThumbprint() {
        return super.getX509CertThumbprint();
    }

    @Override // com.nimbusds.jose.CommonSEHeader
    public /* bridge */ /* synthetic */ URI getX509CertURL() {
        return super.getX509CertURL();
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("alg");
        hashSet.add("enc");
        hashSet.add("epk");
        hashSet.add("zip");
        hashSet.add("jku");
        hashSet.add("jwk");
        hashSet.add("x5u");
        hashSet.add("x5t");
        hashSet.add("x5t#S256");
        hashSet.add("x5c");
        hashSet.add("kid");
        hashSet.add("typ");
        hashSet.add("cty");
        hashSet.add("crit");
        hashSet.add("apu");
        hashSet.add("apv");
        hashSet.add("p2s");
        hashSet.add("p2c");
        hashSet.add("iv");
        hashSet.add("tag");
        hashSet.add(HeaderParameterNames.SENDER_KEY_ID);
        hashSet.add("iss");
        hashSet.add("sub");
        hashSet.add("aud");
        hashSet.add("authTag");
        REGISTERED_PARAMETER_NAMES = Collections.unmodifiableSet(hashSet);
    }

    public static class Builder {
        private JWEAlgorithm alg;
        private Base64URL apu;
        private Base64URL apv;
        private List<String> aud;
        private Set<String> crit;
        private String cty;
        private Map<String, Object> customParams;
        private final EncryptionMethod enc;
        private JWK epk;
        private String iss;
        private Base64URL iv;
        private URI jku;
        private JWK jwk;
        private String kid;
        private int p2c;
        private Base64URL p2s;
        private Base64URL parsedBase64URL;
        private String skid;
        private String sub;
        private Base64URL tag;
        private JOSEObjectType typ;
        private List<Base64> x5c;

        @Deprecated
        private Base64URL x5t;
        private Base64URL x5t256;
        private URI x5u;
        private CompressionAlgorithm zip;

        public Builder(JWEAlgorithm jWEAlgorithm, EncryptionMethod encryptionMethod) {
            if (jWEAlgorithm.getName().equals(Algorithm.NONE.getName())) {
                throw new IllegalArgumentException("The JWE algorithm \"alg\" cannot be \"none\"");
            }
            this.alg = jWEAlgorithm;
            this.enc = (EncryptionMethod) Objects.requireNonNull(encryptionMethod);
        }

        public Builder(EncryptionMethod encryptionMethod) {
            this.enc = (EncryptionMethod) Objects.requireNonNull(encryptionMethod);
        }

        public Builder(JWEHeader jWEHeader) {
            this(jWEHeader.getEncryptionMethod());
            this.alg = jWEHeader.getAlgorithm();
            this.typ = jWEHeader.getType();
            this.cty = jWEHeader.getContentType();
            this.crit = jWEHeader.getCriticalParams();
            this.customParams = jWEHeader.getCustomParams();
            this.jku = jWEHeader.getJWKURL();
            this.jwk = jWEHeader.getJWK();
            this.x5u = jWEHeader.getX509CertURL();
            this.x5t = jWEHeader.getX509CertThumbprint();
            this.x5t256 = jWEHeader.getX509CertSHA256Thumbprint();
            this.x5c = jWEHeader.getX509CertChain();
            this.kid = jWEHeader.getKeyID();
            this.epk = jWEHeader.getEphemeralPublicKey();
            this.zip = jWEHeader.getCompressionAlgorithm();
            this.apu = jWEHeader.getAgreementPartyUInfo();
            this.apv = jWEHeader.getAgreementPartyVInfo();
            this.p2s = jWEHeader.getPBES2Salt();
            this.p2c = jWEHeader.getPBES2Count();
            this.iv = jWEHeader.getIV();
            this.tag = jWEHeader.getAuthTag();
            this.skid = jWEHeader.getSenderKeyID();
            this.iss = jWEHeader.getIssuer();
            this.sub = jWEHeader.getSubject();
            this.aud = jWEHeader.getAudience();
            this.customParams = jWEHeader.getCustomParams();
        }

        public Builder alg(JWEAlgorithm jWEAlgorithm) {
            this.alg = jWEAlgorithm;
            return this;
        }

        public Builder type(JOSEObjectType jOSEObjectType) {
            this.typ = jOSEObjectType;
            return this;
        }

        public Builder contentType(String str) {
            this.cty = str;
            return this;
        }

        public Builder criticalParams(Set<String> set) {
            this.crit = set;
            return this;
        }

        public Builder jwkURL(URI uri) {
            this.jku = uri;
            return this;
        }

        public Builder jwk(JWK jwk) {
            if (jwk != null && jwk.isPrivate()) {
                throw new IllegalArgumentException("The JWK must be public");
            }
            this.jwk = jwk;
            return this;
        }

        public Builder x509CertURL(URI uri) {
            this.x5u = uri;
            return this;
        }

        @Deprecated
        public Builder x509CertThumbprint(Base64URL base64URL) {
            this.x5t = base64URL;
            return this;
        }

        public Builder x509CertSHA256Thumbprint(Base64URL base64URL) {
            this.x5t256 = base64URL;
            return this;
        }

        public Builder x509CertChain(List<Base64> list) {
            this.x5c = list;
            return this;
        }

        public Builder keyID(String str) {
            this.kid = str;
            return this;
        }

        public Builder ephemeralPublicKey(JWK jwk) {
            this.epk = jwk;
            return this;
        }

        public Builder compressionAlgorithm(CompressionAlgorithm compressionAlgorithm) {
            this.zip = compressionAlgorithm;
            return this;
        }

        public Builder agreementPartyUInfo(Base64URL base64URL) {
            this.apu = base64URL;
            return this;
        }

        public Builder agreementPartyVInfo(Base64URL base64URL) {
            this.apv = base64URL;
            return this;
        }

        public Builder pbes2Salt(Base64URL base64URL) {
            this.p2s = base64URL;
            return this;
        }

        public Builder pbes2Count(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("The PBES2 count parameter must not be negative");
            }
            this.p2c = i;
            return this;
        }

        public Builder iv(Base64URL base64URL) {
            this.iv = base64URL;
            return this;
        }

        public Builder senderKeyID(String str) {
            this.skid = str;
            return this;
        }

        public Builder issuer(String str) {
            this.iss = str;
            return this;
        }

        public Builder subject(String str) {
            this.sub = str;
            return this;
        }

        public Builder audience(List<String> list) {
            this.aud = list;
            return this;
        }

        public Builder authTag(Base64URL base64URL) {
            this.tag = base64URL;
            return this;
        }

        public Builder customParam(String str, Object obj) {
            if (JWEHeader.getRegisteredParameterNames().contains(str)) {
                throw new IllegalArgumentException("The parameter name \"" + str + "\" matches a registered name");
            }
            if (this.customParams == null) {
                this.customParams = new HashMap();
            }
            this.customParams.put(str, obj);
            return this;
        }

        public Builder customParams(Map<String, Object> map) {
            this.customParams = map;
            return this;
        }

        public Builder parsedBase64URL(Base64URL base64URL) {
            this.parsedBase64URL = base64URL;
            return this;
        }

        public JWEHeader build() {
            return new JWEHeader(this.alg, this.enc, this.typ, this.cty, this.crit, this.jku, this.jwk, this.x5u, this.x5t, this.x5t256, this.x5c, this.kid, this.epk, this.zip, this.apu, this.apv, this.p2s, this.p2c, this.iv, this.tag, this.skid, this.iss, this.sub, this.aud, this.customParams, this.parsedBase64URL);
        }
    }

    public JWEHeader(EncryptionMethod encryptionMethod) {
        this(null, encryptionMethod, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null);
    }

    public JWEHeader(JWEAlgorithm jWEAlgorithm, EncryptionMethod encryptionMethod) {
        this(jWEAlgorithm, encryptionMethod, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null);
    }

    @Deprecated
    public JWEHeader(Algorithm algorithm, EncryptionMethod encryptionMethod, JOSEObjectType jOSEObjectType, String str, Set<String> set, URI uri, JWK jwk, URI uri2, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, String str2, JWK jwk2, CompressionAlgorithm compressionAlgorithm, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, int i, Base64URL base64URL6, Base64URL base64URL7, String str3, Map<String, Object> map, Base64URL base64URL8) {
        this(algorithm, encryptionMethod, jOSEObjectType, str, set, uri, jwk, uri2, base64URL, base64URL2, list, str2, jwk2, compressionAlgorithm, base64URL3, base64URL4, base64URL5, i, base64URL6, base64URL7, str3, null, null, null, map, base64URL8);
    }

    public JWEHeader(Algorithm algorithm, EncryptionMethod encryptionMethod, JOSEObjectType jOSEObjectType, String str, Set<String> set, URI uri, JWK jwk, URI uri2, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, String str2, JWK jwk2, CompressionAlgorithm compressionAlgorithm, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, int i, Base64URL base64URL6, Base64URL base64URL7, String str3, String str4, String str5, List<String> list2, Map<String, Object> map, Base64URL base64URL8) {
        super(algorithm, jOSEObjectType, str, set, uri, jwk, uri2, base64URL, base64URL2, list, str2, map, base64URL8);
        if (algorithm != null && algorithm.getName().equals(Algorithm.NONE.getName())) {
            throw new IllegalArgumentException("The JWE algorithm cannot be \"none\"");
        }
        if (jwk2 != null && jwk2.isPrivate()) {
            throw new IllegalArgumentException("Ephemeral public key should not be a private key");
        }
        this.enc = (EncryptionMethod) Objects.requireNonNull(encryptionMethod);
        this.epk = jwk2;
        this.zip = compressionAlgorithm;
        this.apu = base64URL3;
        this.apv = base64URL4;
        this.p2s = base64URL5;
        this.p2c = i;
        this.iv = base64URL6;
        this.tag = base64URL7;
        this.skid = str3;
        this.iss = str4;
        this.sub = str5;
        this.aud = list2;
    }

    public JWEHeader(JWEHeader jWEHeader) {
        this(jWEHeader.getAlgorithm(), jWEHeader.getEncryptionMethod(), jWEHeader.getType(), jWEHeader.getContentType(), jWEHeader.getCriticalParams(), jWEHeader.getJWKURL(), jWEHeader.getJWK(), jWEHeader.getX509CertURL(), jWEHeader.getX509CertThumbprint(), jWEHeader.getX509CertSHA256Thumbprint(), jWEHeader.getX509CertChain(), jWEHeader.getKeyID(), jWEHeader.getEphemeralPublicKey(), jWEHeader.getCompressionAlgorithm(), jWEHeader.getAgreementPartyUInfo(), jWEHeader.getAgreementPartyVInfo(), jWEHeader.getPBES2Salt(), jWEHeader.getPBES2Count(), jWEHeader.getIV(), jWEHeader.getAuthTag(), jWEHeader.getSenderKeyID(), jWEHeader.getIssuer(), jWEHeader.getSubject(), jWEHeader.getAudience(), jWEHeader.getCustomParams(), jWEHeader.getParsedBase64URL());
    }

    public static Set<String> getRegisteredParameterNames() {
        return REGISTERED_PARAMETER_NAMES;
    }

    @Override // com.nimbusds.jose.Header
    public JWEAlgorithm getAlgorithm() {
        return (JWEAlgorithm) super.getAlgorithm();
    }

    public EncryptionMethod getEncryptionMethod() {
        return this.enc;
    }

    public JWK getEphemeralPublicKey() {
        return this.epk;
    }

    public CompressionAlgorithm getCompressionAlgorithm() {
        return this.zip;
    }

    public Base64URL getAgreementPartyUInfo() {
        return this.apu;
    }

    public Base64URL getAgreementPartyVInfo() {
        return this.apv;
    }

    public Base64URL getPBES2Salt() {
        return this.p2s;
    }

    public int getPBES2Count() {
        return this.p2c;
    }

    public Base64URL getIV() {
        return this.iv;
    }

    public Base64URL getAuthTag() {
        return this.tag;
    }

    public String getSenderKeyID() {
        return this.skid;
    }

    public String getIssuer() {
        return this.iss;
    }

    public String getSubject() {
        return this.sub;
    }

    public List<String> getAudience() {
        List<String> list = this.aud;
        return list == null ? Collections.emptyList() : list;
    }

    @Override // com.nimbusds.jose.CommonSEHeader, com.nimbusds.jose.Header
    public Set<String> getIncludedParams() {
        Set<String> includedParams = super.getIncludedParams();
        if (this.enc != null) {
            includedParams.add("enc");
        }
        if (this.epk != null) {
            includedParams.add("epk");
        }
        if (this.zip != null) {
            includedParams.add("zip");
        }
        if (this.apu != null) {
            includedParams.add("apu");
        }
        if (this.apv != null) {
            includedParams.add("apv");
        }
        if (this.p2s != null) {
            includedParams.add("p2s");
        }
        if (this.p2c > 0) {
            includedParams.add("p2c");
        }
        if (this.iv != null) {
            includedParams.add("iv");
        }
        if (this.tag != null) {
            includedParams.add("tag");
        }
        if (this.skid != null) {
            includedParams.add(HeaderParameterNames.SENDER_KEY_ID);
        }
        if (this.iss != null) {
            includedParams.add("iss");
        }
        if (this.sub != null) {
            includedParams.add("sub");
        }
        if (this.aud != null) {
            includedParams.add("aud");
        }
        return includedParams;
    }

    @Override // com.nimbusds.jose.CommonSEHeader, com.nimbusds.jose.Header
    public Map<String, Object> toJSONObject() {
        Map<String, Object> jSONObject = super.toJSONObject();
        EncryptionMethod encryptionMethod = this.enc;
        if (encryptionMethod != null) {
            jSONObject.put("enc", encryptionMethod.toString());
        }
        JWK jwk = this.epk;
        if (jwk != null) {
            jSONObject.put("epk", jwk.toJSONObject());
        }
        CompressionAlgorithm compressionAlgorithm = this.zip;
        if (compressionAlgorithm != null) {
            jSONObject.put("zip", compressionAlgorithm.toString());
        }
        Base64URL base64URL = this.apu;
        if (base64URL != null) {
            jSONObject.put("apu", base64URL.toString());
        }
        Base64URL base64URL2 = this.apv;
        if (base64URL2 != null) {
            jSONObject.put("apv", base64URL2.toString());
        }
        Base64URL base64URL3 = this.p2s;
        if (base64URL3 != null) {
            jSONObject.put("p2s", base64URL3.toString());
        }
        int i = this.p2c;
        if (i > 0) {
            jSONObject.put("p2c", Integer.valueOf(i));
        }
        Base64URL base64URL4 = this.iv;
        if (base64URL4 != null) {
            jSONObject.put("iv", base64URL4.toString());
        }
        Base64URL base64URL5 = this.tag;
        if (base64URL5 != null) {
            jSONObject.put("tag", base64URL5.toString());
        }
        String str = this.skid;
        if (str != null) {
            jSONObject.put(HeaderParameterNames.SENDER_KEY_ID, str);
        }
        String str2 = this.iss;
        if (str2 != null) {
            jSONObject.put("iss", str2);
        }
        String str3 = this.sub;
        if (str3 != null) {
            jSONObject.put("sub", str3);
        }
        List<String> list = this.aud;
        if (list != null) {
            if (list.size() == 1) {
                jSONObject.put("aud", this.aud.get(0));
                return jSONObject;
            }
            if (!this.aud.isEmpty()) {
                jSONObject.put("aud", this.aud);
            }
        }
        return jSONObject;
    }

    private static EncryptionMethod parseEncryptionMethod(Map<String, Object> map) throws ParseException {
        return EncryptionMethod.parse(JSONObjectUtils.getString(map, "enc"));
    }

    public static JWEHeader parse(Map<String, Object> map) throws ParseException {
        return parse(map, (Base64URL) null);
    }

    public static JWEHeader parse(Map<String, Object> map, Base64URL base64URL) throws ParseException {
        Builder builderAlg = new Builder(parseEncryptionMethod(map)).parsedBase64URL(base64URL);
        for (String str : map.keySet()) {
            if ("alg".equals(str)) {
                builderAlg = builderAlg.alg(JWEAlgorithm.parse(JSONObjectUtils.getString(map, str)));
            } else if (!"enc".equals(str)) {
                if ("typ".equals(str)) {
                    String string = JSONObjectUtils.getString(map, str);
                    if (string != null) {
                        builderAlg = builderAlg.type(new JOSEObjectType(string));
                    }
                } else if ("cty".equals(str)) {
                    builderAlg = builderAlg.contentType(JSONObjectUtils.getString(map, str));
                } else if ("crit".equals(str)) {
                    List<String> stringList = JSONObjectUtils.getStringList(map, str);
                    if (stringList != null) {
                        builderAlg = builderAlg.criticalParams(new HashSet(stringList));
                    }
                } else if ("jku".equals(str)) {
                    builderAlg = builderAlg.jwkURL(JSONObjectUtils.getURI(map, str));
                } else if ("jwk".equals(str)) {
                    builderAlg = builderAlg.jwk(CommonSEHeader.parsePublicJWK(JSONObjectUtils.getJSONObject(map, str)));
                } else if ("x5u".equals(str)) {
                    builderAlg = builderAlg.x509CertURL(JSONObjectUtils.getURI(map, str));
                } else if ("x5t".equals(str)) {
                    builderAlg = builderAlg.x509CertThumbprint(Base64URL.from(JSONObjectUtils.getString(map, str)));
                } else if ("x5t#S256".equals(str)) {
                    builderAlg = builderAlg.x509CertSHA256Thumbprint(Base64URL.from(JSONObjectUtils.getString(map, str)));
                } else if ("x5c".equals(str)) {
                    builderAlg = builderAlg.x509CertChain(X509CertChainUtils.toBase64List(JSONObjectUtils.getJSONArray(map, str)));
                } else if ("kid".equals(str)) {
                    builderAlg = builderAlg.keyID(JSONObjectUtils.getString(map, str));
                } else if ("epk".equals(str)) {
                    builderAlg = builderAlg.ephemeralPublicKey(JWK.parse(JSONObjectUtils.getJSONObject(map, str)));
                } else if ("zip".equals(str)) {
                    String string2 = JSONObjectUtils.getString(map, str);
                    if (string2 != null) {
                        builderAlg = builderAlg.compressionAlgorithm(new CompressionAlgorithm(string2));
                    }
                } else if ("apu".equals(str)) {
                    builderAlg = builderAlg.agreementPartyUInfo(Base64URL.from(JSONObjectUtils.getString(map, str)));
                } else if ("apv".equals(str)) {
                    builderAlg = builderAlg.agreementPartyVInfo(Base64URL.from(JSONObjectUtils.getString(map, str)));
                } else if ("p2s".equals(str)) {
                    builderAlg = builderAlg.pbes2Salt(Base64URL.from(JSONObjectUtils.getString(map, str)));
                } else if ("p2c".equals(str)) {
                    builderAlg = builderAlg.pbes2Count(JSONObjectUtils.getInt(map, str));
                } else if ("iv".equals(str)) {
                    builderAlg = builderAlg.iv(Base64URL.from(JSONObjectUtils.getString(map, str)));
                } else if ("tag".equals(str)) {
                    builderAlg = builderAlg.authTag(Base64URL.from(JSONObjectUtils.getString(map, str)));
                } else if (HeaderParameterNames.SENDER_KEY_ID.equals(str)) {
                    builderAlg = builderAlg.senderKeyID(JSONObjectUtils.getString(map, str));
                } else if ("iss".equals(str)) {
                    builderAlg = builderAlg.issuer(JSONObjectUtils.getString(map, str));
                } else if ("sub".equals(str)) {
                    builderAlg = builderAlg.subject(JSONObjectUtils.getString(map, str));
                } else if ("aud".equals(str)) {
                    if (map.get(str) instanceof String) {
                        builderAlg = builderAlg.audience(Collections.singletonList(JSONObjectUtils.getString(map, str)));
                    } else {
                        builderAlg = builderAlg.audience(JSONObjectUtils.getStringList(map, str));
                    }
                } else {
                    builderAlg = builderAlg.customParam(str, map.get(str));
                }
            }
        }
        return builderAlg.build();
    }

    public static JWEHeader parse(String str) throws ParseException {
        return parse(JSONObjectUtils.parse(str), (Base64URL) null);
    }

    public static JWEHeader parse(String str, Base64URL base64URL) throws ParseException {
        return parse(JSONObjectUtils.parse(str, 20000), base64URL);
    }

    public static JWEHeader parse(Base64URL base64URL) throws ParseException {
        return parse(base64URL.decodeToString(), base64URL);
    }
}
