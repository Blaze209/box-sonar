package com.yubico.yubikit.piv.jca;

import com.yubico.yubikit.core.util.Callback;
import com.yubico.yubikit.core.util.Result;
import com.yubico.yubikit.piv.KeyType;
import com.yubico.yubikit.piv.PivSession;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.crypto.NoSuchPaddingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class PivProvider extends Provider {
    private final Map<KeyType, KeyPair> rsaDummyKeys;
    private final Callback<Callback<Result<PivSession, Exception>>> sessionRequester;
    private static final Map<String, String> ecAttributes = Collections.singletonMap("SupportedKeyClasses", PivPrivateKey.EcKey.class.getName());
    private static final Map<String, String> rsaAttributes = Collections.singletonMap("SupportedKeyClasses", PivPrivateKey.RsaKey.class.getName());
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) PivProvider.class);

    public PivProvider(final PivSession pivSession) {
        this((Callback<Callback<Result<PivSession, Exception>>>) new Callback() { // from class: com.yubico.yubikit.piv.jca.PivProvider$$ExternalSyntheticLambda0
            @Override // com.yubico.yubikit.core.util.Callback
            public final void invoke(Object obj) {
                ((Callback) obj).invoke(Result.success(pivSession));
            }
        });
    }

    public PivProvider(final Callback<Callback<Result<PivSession, Exception>>> callback) {
        super("YKPiv", 1.0d, "JCA Provider for YubiKey PIV");
        this.rsaDummyKeys = new HashMap();
        this.sessionRequester = callback;
        Logger logger2 = logger;
        Map<String, String> map = ecAttributes;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "EC attributes: {}", map);
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "RSA attributes: {}", rsaAttributes);
        putService(new Provider.Service(this, "Signature", "NONEwithECDSA", PivEcSignatureSpi.Prehashed.class.getName(), null, map) { // from class: com.yubico.yubikit.piv.jca.PivProvider.1
            @Override // java.security.Provider.Service
            public Object newInstance(Object obj) {
                return new PivEcSignatureSpi.Prehashed(callback);
            }
        });
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            long jCurrentTimeMillis = System.currentTimeMillis();
            KeyType[] keyTypeArr = {KeyType.RSA1024, KeyType.RSA2048};
            for (int i = 0; i < 2; i++) {
                KeyType keyType = keyTypeArr[i];
                keyPairGenerator.initialize(keyType.params.bitLength);
                this.rsaDummyKeys.put(keyType, keyPairGenerator.generateKeyPair());
            }
            com.yubico.yubikit.core.internal.Logger.debug(logger, "Time taken to generate dummy RSA keys: {}ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            putService(new PivRsaCipherService());
        } catch (NoSuchAlgorithmException e) {
            com.yubico.yubikit.core.internal.Logger.error(logger, "Unable to support RSA, no underlying Provider with RSA capability", e);
        }
        Set<String> algorithms = Security.getAlgorithms("MessageDigest");
        Iterator<String> it = Security.getAlgorithms("Signature").iterator();
        while (it.hasNext()) {
            String upperCase = it.next().toUpperCase();
            if (upperCase.endsWith("WITHECDSA")) {
                String strSubstring = upperCase.substring(0, upperCase.length() - 9);
                strSubstring = algorithms.contains(strSubstring) ? strSubstring : strSubstring.replace("SHA", "SHA-");
                if (algorithms.contains(strSubstring)) {
                    putService(new PivEcSignatureService(upperCase, strSubstring, null));
                }
            } else if (!this.rsaDummyKeys.isEmpty() && upperCase.endsWith("WITHRSA")) {
                putService(new PivRsaSignatureService(upperCase));
            } else if (!this.rsaDummyKeys.isEmpty() && upperCase.endsWith("PSS")) {
                putService(new PivRsaSignatureService(upperCase));
            } else if (upperCase.equals("ECDSA")) {
                putService(new PivEcSignatureService("ECDSA", "SHA-1", Collections.singletonList("SHA1withECDSA")));
            }
        }
        List list = null;
        Map map2 = null;
        putService(new Provider.Service(this, "KeyPairGenerator", "YKPivRSA", PivKeyPairGeneratorSpi.Rsa.class.getName(), list, map2) { // from class: com.yubico.yubikit.piv.jca.PivProvider.2
            @Override // java.security.Provider.Service
            public Object newInstance(Object obj) {
                return new PivKeyPairGeneratorSpi.Rsa(callback);
            }
        });
        putService(new Provider.Service(this, "KeyPairGenerator", "YKPivEC", PivKeyPairGeneratorSpi.Ec.class.getName(), list, map2) { // from class: com.yubico.yubikit.piv.jca.PivProvider.3
            @Override // java.security.Provider.Service
            public Object newInstance(Object obj) {
                return new PivKeyPairGeneratorSpi.Ec(callback);
            }
        });
        putService(new Provider.Service(this, "KeyStore", "YKPiv", PivKeyStoreSpi.class.getName(), list, map2) { // from class: com.yubico.yubikit.piv.jca.PivProvider.4
            @Override // java.security.Provider.Service
            public Object newInstance(Object obj) {
                return new PivKeyStoreSpi(callback);
            }
        });
        putService(new Provider.Service(this, "KeyAgreement", "ECDH", PivKeyAgreementSpi.class.getName(), list, ecAttributes) { // from class: com.yubico.yubikit.piv.jca.PivProvider.5
            @Override // java.security.Provider.Service
            public Object newInstance(Object obj) {
                return new PivKeyAgreementSpi(callback);
            }
        });
    }

    @Override // java.util.Hashtable, java.util.Map
    public synchronized boolean equals(Object obj) {
        return (obj instanceof PivProvider) && super.equals(obj);
    }

    private class PivEcSignatureService extends Provider.Service {
        private final String digest;

        public PivEcSignatureService(String str, @Nullable String str2, List<String> list) {
            super(PivProvider.this, "Signature", str, PivEcSignatureSpi.Hashed.class.getName(), list, PivProvider.ecAttributes);
            this.digest = str2;
        }

        @Override // java.security.Provider.Service
        public Object newInstance(Object obj) throws NoSuchAlgorithmException {
            return new PivEcSignatureSpi.Hashed(PivProvider.this.sessionRequester, this.digest);
        }
    }

    private class PivRsaSignatureService extends Provider.Service {
        public PivRsaSignatureService(String str) {
            super(PivProvider.this, "Signature", str, PivRsaSignatureSpi.class.getName(), null, PivProvider.rsaAttributes);
        }

        @Override // java.security.Provider.Service
        public Object newInstance(Object obj) throws NoSuchAlgorithmException {
            try {
                return new PivRsaSignatureSpi(PivProvider.this.sessionRequester, PivProvider.this.rsaDummyKeys, getAlgorithm());
            } catch (NoSuchPaddingException unused) {
                throw new NoSuchAlgorithmException("No underlying Provider supporting " + getAlgorithm() + " available.");
            }
        }
    }

    private class PivRsaCipherService extends Provider.Service {
        public PivRsaCipherService() {
            super(PivProvider.this, "Cipher", "RSA", PivCipherSpi.class.getName(), null, PivProvider.rsaAttributes);
        }

        @Override // java.security.Provider.Service
        public Object newInstance(Object obj) throws NoSuchAlgorithmException {
            try {
                return new PivCipherSpi(PivProvider.this.sessionRequester, PivProvider.this.rsaDummyKeys);
            } catch (NoSuchPaddingException e) {
                throw new NoSuchAlgorithmException(e);
            }
        }
    }
}
