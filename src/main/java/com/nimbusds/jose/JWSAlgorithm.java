package com.nimbusds.jose;

import com.nimbusds.jose.shaded.jcip.Immutable;
import com.nimbusds.jose.util.ArrayUtils;
import java.util.Collection;
import org.jose4j.jws.AlgorithmIdentifiers;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
public final class JWSAlgorithm extends Algorithm {
    private static final long serialVersionUID = 1;
    public static final JWSAlgorithm HS256 = new JWSAlgorithm("HS256", Requirement.REQUIRED);
    public static final JWSAlgorithm HS384 = new JWSAlgorithm(AlgorithmIdentifiers.HMAC_SHA384, Requirement.OPTIONAL);
    public static final JWSAlgorithm HS512 = new JWSAlgorithm(AlgorithmIdentifiers.HMAC_SHA512, Requirement.OPTIONAL);
    public static final JWSAlgorithm RS256 = new JWSAlgorithm("RS256", Requirement.RECOMMENDED);
    public static final JWSAlgorithm RS384 = new JWSAlgorithm(AlgorithmIdentifiers.RSA_USING_SHA384, Requirement.OPTIONAL);
    public static final JWSAlgorithm RS512 = new JWSAlgorithm(AlgorithmIdentifiers.RSA_USING_SHA512, Requirement.OPTIONAL);
    public static final JWSAlgorithm ES256 = new JWSAlgorithm(AlgorithmIdentifiers.ECDSA_USING_P256_CURVE_AND_SHA256, Requirement.RECOMMENDED);
    public static final JWSAlgorithm ES256K = new JWSAlgorithm("ES256K", Requirement.OPTIONAL);
    public static final JWSAlgorithm ES384 = new JWSAlgorithm(AlgorithmIdentifiers.ECDSA_USING_P384_CURVE_AND_SHA384, Requirement.OPTIONAL);
    public static final JWSAlgorithm ES512 = new JWSAlgorithm(AlgorithmIdentifiers.ECDSA_USING_P521_CURVE_AND_SHA512, Requirement.OPTIONAL);
    public static final JWSAlgorithm PS256 = new JWSAlgorithm(AlgorithmIdentifiers.RSA_PSS_USING_SHA256, Requirement.OPTIONAL);
    public static final JWSAlgorithm PS384 = new JWSAlgorithm(AlgorithmIdentifiers.RSA_PSS_USING_SHA384, Requirement.OPTIONAL);
    public static final JWSAlgorithm PS512 = new JWSAlgorithm(AlgorithmIdentifiers.RSA_PSS_USING_SHA512, Requirement.OPTIONAL);
    public static final JWSAlgorithm EdDSA = new JWSAlgorithm("EdDSA", Requirement.OPTIONAL);
    public static final JWSAlgorithm Ed25519 = new JWSAlgorithm("Ed25519", Requirement.OPTIONAL);
    public static final JWSAlgorithm Ed448 = new JWSAlgorithm("Ed448", Requirement.OPTIONAL);

    public static final class Family extends AlgorithmFamily<JWSAlgorithm> {
        public static final Family EC;
        public static final Family ED;
        public static final Family HMAC_SHA = new Family(JWSAlgorithm.HS256, JWSAlgorithm.HS384, JWSAlgorithm.HS512);
        public static final Family RSA;
        public static final Family SIGNATURE;
        private static final long serialVersionUID = 1;

        @Override // com.nimbusds.jose.AlgorithmFamily
        public /* bridge */ /* synthetic */ boolean add(Algorithm algorithm) {
            return super.add(algorithm);
        }

        @Override // com.nimbusds.jose.AlgorithmFamily, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
            return super.addAll(collection);
        }

        @Override // com.nimbusds.jose.AlgorithmFamily, java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean remove(Object obj) {
            return super.remove(obj);
        }

        @Override // com.nimbusds.jose.AlgorithmFamily, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
            return super.removeAll(collection);
        }

        @Override // com.nimbusds.jose.AlgorithmFamily, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
            return super.retainAll(collection);
        }

        static {
            Family family = new Family(JWSAlgorithm.RS256, JWSAlgorithm.RS384, JWSAlgorithm.RS512, JWSAlgorithm.PS256, JWSAlgorithm.PS384, JWSAlgorithm.PS512);
            RSA = family;
            Family family2 = new Family(JWSAlgorithm.ES256, JWSAlgorithm.ES256K, JWSAlgorithm.ES384, JWSAlgorithm.ES512);
            EC = family2;
            Family family3 = new Family(JWSAlgorithm.EdDSA, JWSAlgorithm.Ed25519, JWSAlgorithm.Ed448);
            ED = family3;
            SIGNATURE = new Family((JWSAlgorithm[]) ArrayUtils.concat(family.toArray(new JWSAlgorithm[0]), (JWSAlgorithm[]) family2.toArray(new JWSAlgorithm[0]), (JWSAlgorithm[]) family3.toArray(new JWSAlgorithm[0])));
        }

        public Family(JWSAlgorithm... jWSAlgorithmArr) {
            super(jWSAlgorithmArr);
        }
    }

    public JWSAlgorithm(String str, Requirement requirement) {
        super(str, requirement);
    }

    public JWSAlgorithm(String str) {
        super(str, null);
    }

    public static JWSAlgorithm parse(String str) {
        JWSAlgorithm jWSAlgorithm = HS256;
        if (str.equals(jWSAlgorithm.getName())) {
            return jWSAlgorithm;
        }
        JWSAlgorithm jWSAlgorithm2 = HS384;
        if (str.equals(jWSAlgorithm2.getName())) {
            return jWSAlgorithm2;
        }
        JWSAlgorithm jWSAlgorithm3 = HS512;
        if (str.equals(jWSAlgorithm3.getName())) {
            return jWSAlgorithm3;
        }
        JWSAlgorithm jWSAlgorithm4 = RS256;
        if (str.equals(jWSAlgorithm4.getName())) {
            return jWSAlgorithm4;
        }
        JWSAlgorithm jWSAlgorithm5 = RS384;
        if (str.equals(jWSAlgorithm5.getName())) {
            return jWSAlgorithm5;
        }
        JWSAlgorithm jWSAlgorithm6 = RS512;
        if (str.equals(jWSAlgorithm6.getName())) {
            return jWSAlgorithm6;
        }
        JWSAlgorithm jWSAlgorithm7 = ES256;
        if (str.equals(jWSAlgorithm7.getName())) {
            return jWSAlgorithm7;
        }
        JWSAlgorithm jWSAlgorithm8 = ES256K;
        if (str.equals(jWSAlgorithm8.getName())) {
            return jWSAlgorithm8;
        }
        JWSAlgorithm jWSAlgorithm9 = ES384;
        if (str.equals(jWSAlgorithm9.getName())) {
            return jWSAlgorithm9;
        }
        JWSAlgorithm jWSAlgorithm10 = ES512;
        if (str.equals(jWSAlgorithm10.getName())) {
            return jWSAlgorithm10;
        }
        JWSAlgorithm jWSAlgorithm11 = PS256;
        if (str.equals(jWSAlgorithm11.getName())) {
            return jWSAlgorithm11;
        }
        JWSAlgorithm jWSAlgorithm12 = PS384;
        if (str.equals(jWSAlgorithm12.getName())) {
            return jWSAlgorithm12;
        }
        JWSAlgorithm jWSAlgorithm13 = PS512;
        if (str.equals(jWSAlgorithm13.getName())) {
            return jWSAlgorithm13;
        }
        JWSAlgorithm jWSAlgorithm14 = EdDSA;
        if (str.equals(jWSAlgorithm14.getName())) {
            return jWSAlgorithm14;
        }
        JWSAlgorithm jWSAlgorithm15 = Ed25519;
        if (str.equals(jWSAlgorithm15.getName())) {
            return jWSAlgorithm15;
        }
        JWSAlgorithm jWSAlgorithm16 = Ed448;
        return str.equals(jWSAlgorithm16.getName()) ? jWSAlgorithm16 : new JWSAlgorithm(str);
    }
}
