package org.jose4j.keys.resolvers;

import java.io.IOException;
import java.security.Key;
import java.util.List;
import org.jose4j.jwk.HttpsJwks;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.VerificationJwkSelector;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwx.JsonWebStructure;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UnresolvableKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class HttpsJwksVerificationKeyResolver implements VerificationKeyResolver {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) HttpsJwksVerificationKeyResolver.class);
    private boolean disambiguateWithVerifySignature;
    private HttpsJwks httpsJkws;
    private VerificationJwkSelector verificationJwkSelector = new VerificationJwkSelector();

    public HttpsJwksVerificationKeyResolver(HttpsJwks httpsJwks) {
        this.httpsJkws = httpsJwks;
    }

    @Override // org.jose4j.keys.resolvers.VerificationKeyResolver
    public Key resolveKey(JsonWebSignature jsonWebSignature, List<JsonWebStructure> list) throws UnresolvableKeyException {
        try {
            List<JsonWebKey> jsonWebKeys = this.httpsJkws.getJsonWebKeys();
            JsonWebKey jsonWebKeySelect = select(jsonWebSignature, jsonWebKeys);
            if (jsonWebKeySelect == null) {
                log.debug("Refreshing JWKs from {} as no suitable verification key for JWS w/ header {} was found in {}", this.httpsJkws.getLocation(), jsonWebSignature.getHeaders().getFullHeaderAsJsonString(), jsonWebKeys);
                this.httpsJkws.refresh();
                jsonWebKeys = this.httpsJkws.getJsonWebKeys();
                jsonWebKeySelect = select(jsonWebSignature, jsonWebKeys);
            }
            if (jsonWebKeySelect == null) {
                StringBuilder sb = new StringBuilder("Unable to find a suitable verification key for JWS w/ header ");
                sb.append(jsonWebSignature.getHeaders().getFullHeaderAsJsonString());
                sb.append(" from JWKs ").append(jsonWebKeys).append(" obtained from ").append(this.httpsJkws.getLocation());
                throw new UnresolvableKeyException(sb.toString());
            }
            return jsonWebKeySelect.getKey();
        } catch (IOException | JoseException e) {
            StringBuilder sb2 = new StringBuilder("Unable to find a suitable verification key for JWS w/ header ");
            sb2.append(jsonWebSignature.getHeaders().getFullHeaderAsJsonString());
            sb2.append(" due to an unexpected exception (").append(e).append(") while obtaining or using keys from JWKS endpoint at ").append(this.httpsJkws.getLocation());
            throw new UnresolvableKeyException(sb2.toString(), e);
        }
    }

    protected JsonWebKey select(JsonWebSignature jsonWebSignature, List<JsonWebKey> list) throws JoseException {
        if (this.disambiguateWithVerifySignature) {
            return this.verificationJwkSelector.selectWithVerifySignatureDisambiguate(jsonWebSignature, list);
        }
        return this.verificationJwkSelector.select(jsonWebSignature, list);
    }

    public void setDisambiguateWithVerifySignature(boolean z) {
        this.disambiguateWithVerifySignature = z;
    }
}
