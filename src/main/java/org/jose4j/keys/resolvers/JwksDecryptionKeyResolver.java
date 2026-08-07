package org.jose4j.keys.resolvers;

import java.security.Key;
import java.util.List;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwk.DecryptionJwkSelector;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.jwx.JsonWebStructure;
import org.jose4j.lang.JoseException;
import org.jose4j.lang.UnresolvableKeyException;

/* JADX INFO: loaded from: classes5.dex */
public class JwksDecryptionKeyResolver implements DecryptionKeyResolver {
    private List<JsonWebKey> jsonWebKeys;
    private DecryptionJwkSelector selector = new DecryptionJwkSelector();

    public JwksDecryptionKeyResolver(List<JsonWebKey> list) {
        this.jsonWebKeys = list;
    }

    @Override // org.jose4j.keys.resolvers.DecryptionKeyResolver
    public Key resolveKey(JsonWebEncryption jsonWebEncryption, List<JsonWebStructure> list) throws UnresolvableKeyException {
        try {
            JsonWebKey jsonWebKeySelect = this.selector.select(jsonWebEncryption, this.jsonWebKeys);
            if (jsonWebKeySelect != null) {
                return jsonWebKeySelect instanceof PublicJsonWebKey ? ((PublicJsonWebKey) jsonWebKeySelect).getPrivateKey() : jsonWebKeySelect.getKey();
            }
            StringBuilder sb = new StringBuilder("Unable to find a suitable key for JWE w/ header ");
            sb.append(jsonWebEncryption.getHeaders().getFullHeaderAsJsonString());
            sb.append(" from JWKs ").append(this.jsonWebKeys);
            throw new UnresolvableKeyException(sb.toString());
        } catch (JoseException e) {
            StringBuilder sb2 = new StringBuilder("Unable to find a suitable key for JWE w/ header ");
            sb2.append(jsonWebEncryption.getHeaders().getFullHeaderAsJsonString());
            sb2.append(" due to an unexpected exception (").append(e).append(") selecting from keys: ").append(this.jsonWebKeys);
            throw new UnresolvableKeyException(sb2.toString(), e);
        }
    }
}
