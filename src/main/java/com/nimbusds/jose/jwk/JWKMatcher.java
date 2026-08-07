package com.nimbusds.jose.jwk;

import com.facebook.infer.annotation.ThreadConfined;
import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.shaded.jcip.Immutable;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.X509CertUtils;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public class JWKMatcher {
    private final Set<Algorithm> algs;
    private final Set<Curve> curves;
    private final Set<String> ids;
    private final int maxSizeBits;
    private final int minSizeBits;
    private final boolean nonRevokedOnly;
    private final Set<KeyOperation> ops;
    private final boolean privateOnly;
    private final boolean publicOnly;
    private final boolean revokedOnly;
    private final Set<Integer> sizesBits;
    private final Set<KeyType> types;
    private final Set<KeyUse> uses;
    private final boolean withIDOnly;
    private final boolean withUseOnly;
    private final boolean withX5COnly;
    private final Set<Base64URL> x5tS256s;

    public static class Builder {
        private Set<Algorithm> algs;
        private Set<Curve> curves;
        private Set<String> ids;
        private int maxSizeBits;
        private int minSizeBits;
        private boolean nonRevokedOnly;
        private Set<KeyOperation> ops;
        private boolean privateOnly;
        private boolean publicOnly;
        private boolean revokedOnly;
        private Set<Integer> sizesBits;
        private Set<KeyType> types;
        private Set<KeyUse> uses;
        private boolean withIDOnly;
        private boolean withUseOnly;
        private boolean withX5COnly;
        private Set<Base64URL> x5tS256s;

        public Builder() {
            this.withUseOnly = false;
            this.withIDOnly = false;
            this.privateOnly = false;
            this.publicOnly = false;
            this.nonRevokedOnly = false;
            this.revokedOnly = false;
            this.minSizeBits = 0;
            this.maxSizeBits = 0;
            this.withX5COnly = false;
        }

        public Builder(JWKMatcher jWKMatcher) {
            this.withUseOnly = false;
            this.withIDOnly = false;
            this.privateOnly = false;
            this.publicOnly = false;
            this.nonRevokedOnly = false;
            this.revokedOnly = false;
            this.minSizeBits = 0;
            this.maxSizeBits = 0;
            this.withX5COnly = false;
            this.types = jWKMatcher.getKeyTypes();
            this.uses = jWKMatcher.getKeyUses();
            this.ops = jWKMatcher.getKeyOperations();
            this.algs = jWKMatcher.getAlgorithms();
            this.ids = jWKMatcher.getKeyIDs();
            this.withUseOnly = jWKMatcher.isWithKeyUseOnly();
            this.withIDOnly = jWKMatcher.isWithKeyIDOnly();
            this.privateOnly = jWKMatcher.isPrivateOnly();
            this.publicOnly = jWKMatcher.isPublicOnly();
            this.nonRevokedOnly = jWKMatcher.isNonRevokedOnly();
            this.revokedOnly = jWKMatcher.isNonRevokedOnly();
            this.minSizeBits = jWKMatcher.getMinKeySize();
            this.maxSizeBits = jWKMatcher.getMaxKeySize();
            this.sizesBits = jWKMatcher.getKeySizes();
            this.curves = jWKMatcher.getCurves();
            this.x5tS256s = jWKMatcher.getX509CertSHA256Thumbprints();
            this.withX5COnly = jWKMatcher.isWithX509CertChainOnly();
        }

        public Builder keyType(KeyType keyType) {
            if (keyType == null) {
                this.types = null;
                return this;
            }
            this.types = new HashSet(Collections.singletonList(keyType));
            return this;
        }

        public Builder keyTypes(KeyType... keyTypeArr) {
            keyTypes(new LinkedHashSet(Arrays.asList(keyTypeArr)));
            return this;
        }

        public Builder keyTypes(Set<KeyType> set) {
            this.types = set;
            return this;
        }

        public Builder keyUse(KeyUse keyUse) {
            if (keyUse == null) {
                this.uses = null;
                return this;
            }
            this.uses = new HashSet(Collections.singletonList(keyUse));
            return this;
        }

        public Builder keyUses(KeyUse... keyUseArr) {
            keyUses(new LinkedHashSet(Arrays.asList(keyUseArr)));
            return this;
        }

        public Builder keyUses(Set<KeyUse> set) {
            this.uses = set;
            return this;
        }

        public Builder keyOperation(KeyOperation keyOperation) {
            if (keyOperation == null) {
                this.ops = null;
                return this;
            }
            this.ops = new HashSet(Collections.singletonList(keyOperation));
            return this;
        }

        public Builder keyOperations(KeyOperation... keyOperationArr) {
            keyOperations(new LinkedHashSet(Arrays.asList(keyOperationArr)));
            return this;
        }

        public Builder keyOperations(Set<KeyOperation> set) {
            this.ops = set;
            return this;
        }

        public Builder algorithm(Algorithm algorithm) {
            if (algorithm == null) {
                this.algs = null;
                return this;
            }
            this.algs = new HashSet(Collections.singletonList(algorithm));
            return this;
        }

        public Builder algorithms(Algorithm... algorithmArr) {
            algorithms(new LinkedHashSet(Arrays.asList(algorithmArr)));
            return this;
        }

        public Builder algorithms(Set<Algorithm> set) {
            this.algs = set;
            return this;
        }

        public Builder keyID(String str) {
            if (str == null) {
                this.ids = null;
                return this;
            }
            this.ids = new HashSet(Collections.singletonList(str));
            return this;
        }

        public Builder keyIDs(String... strArr) {
            keyIDs(new LinkedHashSet(Arrays.asList(strArr)));
            return this;
        }

        public Builder keyIDs(Set<String> set) {
            this.ids = set;
            return this;
        }

        @Deprecated
        public Builder hasKeyUse(boolean z) {
            return withKeyUseOnly(z);
        }

        public Builder withKeyUseOnly(boolean z) {
            this.withUseOnly = z;
            return this;
        }

        @Deprecated
        public Builder hasKeyID(boolean z) {
            return withKeyIDOnly(z);
        }

        public Builder withKeyIDOnly(boolean z) {
            this.withIDOnly = z;
            return this;
        }

        public Builder privateOnly(boolean z) {
            this.privateOnly = z;
            return this;
        }

        public Builder publicOnly(boolean z) {
            this.publicOnly = z;
            return this;
        }

        public Builder nonRevokedOnly(boolean z) {
            this.nonRevokedOnly = z;
            return this;
        }

        public Builder revokedOnly(boolean z) {
            this.revokedOnly = z;
            return this;
        }

        public Builder minKeySize(int i) {
            this.minSizeBits = i;
            return this;
        }

        public Builder maxKeySize(int i) {
            this.maxSizeBits = i;
            return this;
        }

        public Builder keySize(int i) {
            if (i <= 0) {
                this.sizesBits = null;
                return this;
            }
            this.sizesBits = Collections.singleton(Integer.valueOf(i));
            return this;
        }

        public Builder keySizes(int... iArr) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (int i : iArr) {
                linkedHashSet.add(Integer.valueOf(i));
            }
            keySizes(linkedHashSet);
            return this;
        }

        public Builder keySizes(Set<Integer> set) {
            this.sizesBits = set;
            return this;
        }

        public Builder curve(Curve curve) {
            if (curve == null) {
                this.curves = null;
                return this;
            }
            this.curves = Collections.singleton(curve);
            return this;
        }

        public Builder curves(Curve... curveArr) {
            curves(new LinkedHashSet(Arrays.asList(curveArr)));
            return this;
        }

        public Builder curves(Set<Curve> set) {
            this.curves = set;
            return this;
        }

        public Builder x509CertSHA256Thumbprint(Base64URL base64URL) {
            if (base64URL == null) {
                this.x5tS256s = null;
                return this;
            }
            this.x5tS256s = Collections.singleton(base64URL);
            return this;
        }

        public Builder x509CertSHA256Thumbprints(Base64URL... base64URLArr) {
            return x509CertSHA256Thumbprints(new LinkedHashSet(Arrays.asList(base64URLArr)));
        }

        public Builder x509CertSHA256Thumbprints(Set<Base64URL> set) {
            this.x5tS256s = set;
            return this;
        }

        @Deprecated
        public Builder hasX509CertChain(boolean z) {
            return withX509CertChainOnly(z);
        }

        public Builder withX509CertChainOnly(boolean z) {
            this.withX5COnly = z;
            return this;
        }

        public JWKMatcher build() {
            return new JWKMatcher(this.types, this.uses, this.ops, this.algs, this.ids, this.withUseOnly, this.withIDOnly, this.privateOnly, this.publicOnly, this.nonRevokedOnly, this.revokedOnly, this.minSizeBits, this.maxSizeBits, this.sizesBits, this.curves, this.x5tS256s, this.withX5COnly);
        }
    }

    @Deprecated
    public JWKMatcher(Set<KeyType> set, Set<KeyUse> set2, Set<KeyOperation> set3, Set<Algorithm> set4, Set<String> set5, boolean z, boolean z2) {
        this(set, set2, set3, set4, set5, z, z2, 0, 0);
    }

    @Deprecated
    public JWKMatcher(Set<KeyType> set, Set<KeyUse> set2, Set<KeyOperation> set3, Set<Algorithm> set4, Set<String> set5, boolean z, boolean z2, int i, int i2) {
        this(set, set2, set3, set4, set5, z, z2, i, i2, null);
    }

    @Deprecated
    public JWKMatcher(Set<KeyType> set, Set<KeyUse> set2, Set<KeyOperation> set3, Set<Algorithm> set4, Set<String> set5, boolean z, boolean z2, int i, int i2, Set<Curve> set6) {
        this(set, set2, set3, set4, set5, z, z2, i, i2, null, set6);
    }

    @Deprecated
    public JWKMatcher(Set<KeyType> set, Set<KeyUse> set2, Set<KeyOperation> set3, Set<Algorithm> set4, Set<String> set5, boolean z, boolean z2, int i, int i2, Set<Integer> set6, Set<Curve> set7) {
        this(set, set2, set3, set4, set5, false, false, z, z2, i, i2, set6, set7);
    }

    @Deprecated
    public JWKMatcher(Set<KeyType> set, Set<KeyUse> set2, Set<KeyOperation> set3, Set<Algorithm> set4, Set<String> set5, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, Set<Integer> set6, Set<Curve> set7) {
        this(set, set2, set3, set4, set5, z, z2, z3, z4, i, i2, set6, set7, null);
    }

    @Deprecated
    public JWKMatcher(Set<KeyType> set, Set<KeyUse> set2, Set<KeyOperation> set3, Set<Algorithm> set4, Set<String> set5, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, Set<Integer> set6, Set<Curve> set7, Set<Base64URL> set8) {
        this(set, set2, set3, set4, set5, z, z2, z3, z4, i, i2, set6, set7, set8, false);
    }

    @Deprecated
    public JWKMatcher(Set<KeyType> set, Set<KeyUse> set2, Set<KeyOperation> set3, Set<Algorithm> set4, Set<String> set5, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, Set<Integer> set6, Set<Curve> set7, Set<Base64URL> set8, boolean z5) {
        this(set, set2, set3, set4, set5, z, z2, z3, z4, false, false, i, i2, set6, set7, set8, z5);
    }

    public JWKMatcher(Set<KeyType> set, Set<KeyUse> set2, Set<KeyOperation> set3, Set<Algorithm> set4, Set<String> set5, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, int i2, Set<Integer> set6, Set<Curve> set7, Set<Base64URL> set8, boolean z7) {
        this.types = set;
        this.uses = set2;
        this.ops = set3;
        this.algs = set4;
        this.ids = set5;
        this.withUseOnly = z;
        this.withIDOnly = z2;
        this.privateOnly = z3;
        this.publicOnly = z4;
        this.nonRevokedOnly = z5;
        this.revokedOnly = z6;
        this.minSizeBits = i;
        this.maxSizeBits = i2;
        this.sizesBits = set6;
        this.curves = set7;
        this.x5tS256s = set8;
        this.withX5COnly = z7;
    }

    public static JWKMatcher forJWEHeader(JWEHeader jWEHeader) {
        return new Builder().keyType(KeyType.forAlgorithm(jWEHeader.getAlgorithm())).keyID(jWEHeader.getKeyID()).keyUses(KeyUse.ENCRYPTION, null).algorithms(jWEHeader.getAlgorithm(), null).build();
    }

    public static JWKMatcher forJWSHeader(JWSHeader jWSHeader) {
        JWSAlgorithm algorithm = jWSHeader.getAlgorithm();
        if (JWSAlgorithm.Family.RSA.contains(algorithm) || JWSAlgorithm.Family.EC.contains(algorithm)) {
            return new Builder().keyType(KeyType.forAlgorithm(algorithm)).keyID(jWSHeader.getKeyID()).keyUses(KeyUse.SIGNATURE, null).algorithms(algorithm, null).x509CertSHA256Thumbprint(jWSHeader.getX509CertSHA256Thumbprint()).build();
        }
        if (JWSAlgorithm.Family.HMAC_SHA.contains(algorithm)) {
            return new Builder().keyType(KeyType.forAlgorithm(algorithm)).keyID(jWSHeader.getKeyID()).privateOnly(true).algorithms(algorithm, null).build();
        }
        if (JWSAlgorithm.Family.ED.contains(algorithm)) {
            return new Builder().keyType(KeyType.forAlgorithm(algorithm)).keyID(jWSHeader.getKeyID()).keyUses(KeyUse.SIGNATURE, null).algorithms(algorithm, null).curves(Curve.forJWSAlgorithm(algorithm)).build();
        }
        return null;
    }

    public Set<KeyType> getKeyTypes() {
        return this.types;
    }

    public Set<KeyUse> getKeyUses() {
        return this.uses;
    }

    public Set<KeyOperation> getKeyOperations() {
        return this.ops;
    }

    public Set<Algorithm> getAlgorithms() {
        return this.algs;
    }

    public Set<String> getKeyIDs() {
        return this.ids;
    }

    @Deprecated
    public boolean hasKeyUse() {
        return isWithKeyUseOnly();
    }

    public boolean isWithKeyUseOnly() {
        return this.withUseOnly;
    }

    @Deprecated
    public boolean hasKeyID() {
        return isWithKeyIDOnly();
    }

    public boolean isWithKeyIDOnly() {
        return this.withIDOnly;
    }

    public boolean isPrivateOnly() {
        return this.privateOnly;
    }

    public boolean isPublicOnly() {
        return this.publicOnly;
    }

    public boolean isNonRevokedOnly() {
        return this.nonRevokedOnly;
    }

    public boolean isRevokedOnly() {
        return this.revokedOnly;
    }

    @Deprecated
    public int getMinSize() {
        return getMinKeySize();
    }

    public int getMinKeySize() {
        return this.minSizeBits;
    }

    @Deprecated
    public int getMaxSize() {
        return getMaxKeySize();
    }

    public int getMaxKeySize() {
        return this.maxSizeBits;
    }

    public Set<Integer> getKeySizes() {
        return this.sizesBits;
    }

    public Set<Curve> getCurves() {
        return this.curves;
    }

    public Set<Base64URL> getX509CertSHA256Thumbprints() {
        return this.x5tS256s;
    }

    @Deprecated
    public boolean hasX509CertChain() {
        return isWithX509CertChainOnly();
    }

    public boolean isWithX509CertChainOnly() {
        return this.withX5COnly;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean matches(JWK jwk) {
        boolean zContains;
        if (this.withUseOnly && jwk.getKeyUse() == null) {
            return false;
        }
        if (this.withIDOnly && (jwk.getKeyID() == null || jwk.getKeyID().trim().isEmpty())) {
            return false;
        }
        if (this.privateOnly && !jwk.isPrivate()) {
            return false;
        }
        if (this.publicOnly && jwk.isPrivate()) {
            return false;
        }
        if (this.nonRevokedOnly && jwk.getKeyRevocation() != null) {
            return false;
        }
        if (this.revokedOnly && jwk.getKeyRevocation() == null) {
            return false;
        }
        Set<KeyType> set = this.types;
        if (set != null && !set.contains(jwk.getKeyType())) {
            return false;
        }
        Set<KeyUse> set2 = this.uses;
        if (set2 != null && !set2.contains(jwk.getKeyUse())) {
            return false;
        }
        Set<KeyOperation> set3 = this.ops;
        if (set3 != null && ((!set3.contains(null) || jwk.getKeyOperations() != null) && (jwk.getKeyOperations() == null || !this.ops.containsAll(jwk.getKeyOperations())))) {
            return false;
        }
        Set<Algorithm> set4 = this.algs;
        if (set4 != null && !set4.contains(jwk.getAlgorithm())) {
            return false;
        }
        Set<String> set5 = this.ids;
        if (set5 != null && !set5.contains(jwk.getKeyID())) {
            return false;
        }
        if (this.minSizeBits > 0 && jwk.size() < this.minSizeBits) {
            return false;
        }
        if (this.maxSizeBits > 0 && jwk.size() > this.maxSizeBits) {
            return false;
        }
        Set<Integer> set6 = this.sizesBits;
        if (set6 != null && !set6.contains(Integer.valueOf(jwk.size()))) {
            return false;
        }
        Set<Curve> set7 = this.curves;
        if (set7 != null && (!(jwk instanceof CurveBasedJWK) || !set7.contains(((CurveBasedJWK) jwk).getCurve()))) {
            return false;
        }
        if (this.x5tS256s != null) {
            if (jwk.getX509CertChain() == null || jwk.getX509CertChain().isEmpty()) {
                zContains = false;
            } else {
                try {
                    zContains = this.x5tS256s.contains(X509CertUtils.computeSHA256Thumbprint(X509CertUtils.parseWithException(jwk.getX509CertChain().get(0).decode())));
                } catch (CertificateException unused) {
                    zContains = false;
                }
            }
            boolean zContains2 = this.x5tS256s.contains(jwk.getX509CertSHA256Thumbprint());
            if (!zContains && !zContains2) {
                return false;
            }
        }
        if (this.withX5COnly) {
            return (jwk.getX509CertChain() == null || jwk.getX509CertChain().isEmpty()) ? false : true;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        append(sb, "kty", this.types);
        append(sb, "use", this.uses);
        append(sb, "key_ops", this.ops);
        append(sb, "alg", this.algs);
        append(sb, "kid", this.ids);
        if (this.withUseOnly) {
            sb.append("with_use_only=true ");
        }
        if (this.withIDOnly) {
            sb.append("with_id_only=true ");
        }
        if (this.privateOnly) {
            sb.append("private_only=true ");
        }
        if (this.publicOnly) {
            sb.append("public_only=true ");
        }
        if (this.nonRevokedOnly) {
            sb.append("non_revoked_only=true ");
        }
        if (this.revokedOnly) {
            sb.append("revoked_only=true ");
        }
        if (this.minSizeBits > 0) {
            sb.append("min_size=" + this.minSizeBits + " ");
        }
        if (this.maxSizeBits > 0) {
            sb.append("max_size=" + this.maxSizeBits + " ");
        }
        append(sb, "size", this.sizesBits);
        append(sb, "crv", this.curves);
        append(sb, "x5t#S256", this.x5tS256s);
        if (this.withX5COnly) {
            sb.append("with_x5c_only=true");
        }
        return sb.toString().trim();
    }

    private static void append(StringBuilder sb, String str, Set<?> set) {
        if (set != null) {
            sb.append(str);
            sb.append('=');
            if (set.size() == 1) {
                Object next = set.iterator().next();
                if (next == null) {
                    sb.append(ThreadConfined.ANY);
                } else {
                    sb.append(next.toString().trim());
                }
            } else {
                sb.append(set.toString().trim());
            }
            sb.append(' ');
        }
    }
}
