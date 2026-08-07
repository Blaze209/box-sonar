package org.jose4j.jwk;

import java.util.Collection;
import java.util.List;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public class DecryptionJwkSelector {
    public JsonWebKey select(JsonWebEncryption jsonWebEncryption, Collection<JsonWebKey> collection) throws JoseException {
        List<JsonWebKey> listSelectList = selectList(jsonWebEncryption, collection);
        if (listSelectList.isEmpty()) {
            return null;
        }
        return listSelectList.get(0);
    }

    public List<JsonWebKey> selectList(JsonWebEncryption jsonWebEncryption, Collection<JsonWebKey> collection) throws JoseException {
        return SelectorSupport.filterForInboundEncrypted(jsonWebEncryption).filter(collection);
    }
}
