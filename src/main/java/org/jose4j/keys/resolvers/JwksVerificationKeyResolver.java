package org.jose4j.keys.resolvers;

import java.security.Key;
import java.util.List;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.VerificationJwkSelector;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwx.JsonWebStructure;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UnresolvableKeyException;

/* JADX INFO: loaded from: classes5.dex */
public class JwksVerificationKeyResolver implements VerificationKeyResolver {
    private boolean disambiguateWithVerifySignature;
    private List<JsonWebKey> jsonWebKeys;
    private VerificationJwkSelector selector = new VerificationJwkSelector();

    public JwksVerificationKeyResolver(List<JsonWebKey> list) {
        this.jsonWebKeys = list;
    }

    @Override // org.jose4j.keys.resolvers.VerificationKeyResolver
    public Key resolveKey(JsonWebSignature jsonWebSignature, List<JsonWebStructure> list) throws UnresolvableKeyException {
        JsonWebKey jsonWebKeySelect;
        try {
            if (this.disambiguateWithVerifySignature) {
                jsonWebKeySelect = this.selector.selectWithVerifySignatureDisambiguate(jsonWebSignature, this.jsonWebKeys);
            } else {
                jsonWebKeySelect = this.selector.select(jsonWebSignature, this.jsonWebKeys);
            }
            if (jsonWebKeySelect == null) {
                StringBuilder sb = new StringBuilder("Unable to find a suitable verification key for JWS w/ header ");
                sb.append(jsonWebSignature.getHeaders().getFullHeaderAsJsonString());
                sb.append(" from JWKs ").append(this.jsonWebKeys);
                throw new UnresolvableKeyException(sb.toString());
            }
            return jsonWebKeySelect.getKey();
        } catch (JoseException e) {
            StringBuilder sb2 = new StringBuilder("Unable to find a suitable verification key for JWS w/ header ");
            sb2.append(jsonWebSignature.getHeaders().getFullHeaderAsJsonString());
            sb2.append(" due to an unexpected exception (").append(e).append(") selecting from keys: ").append(this.jsonWebKeys);
            throw new UnresolvableKeyException(sb2.toString(), e);
        }
    }

    public void setDisambiguateWithVerifySignature(boolean z) {
        this.disambiguateWithVerifySignature = z;
    }
}
