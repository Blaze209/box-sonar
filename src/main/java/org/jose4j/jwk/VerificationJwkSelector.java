package org.jose4j.jwk;

import java.util.Collection;
import java.util.List;
import org.jose4j.jws.EcdsaUsingShaAlgorithm;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.lang.JoseException;

/* JADX INFO: loaded from: classes5.dex */
public class VerificationJwkSelector {
    public JsonWebKey select(JsonWebSignature jsonWebSignature, Collection<JsonWebKey> collection) throws JoseException {
        List<JsonWebKey> listSelectList = selectList(jsonWebSignature, collection);
        if (listSelectList.isEmpty()) {
            return null;
        }
        return listSelectList.get(0);
    }

    public List<JsonWebKey> selectList(JsonWebSignature jsonWebSignature, Collection<JsonWebKey> collection) throws JoseException {
        SimpleJwkFilter simpleJwkFilterFilterForInboundSigned = SelectorSupport.filterForInboundSigned(jsonWebSignature);
        List<JsonWebKey> listFilter = simpleJwkFilterFilterForInboundSigned.filter(collection);
        if (hasMoreThanOne(listFilter)) {
            simpleJwkFilterFilterForInboundSigned.setAlg(jsonWebSignature.getAlgorithmHeaderValue(), SimpleJwkFilter.OMITTED_OKAY);
            listFilter = simpleJwkFilterFilterForInboundSigned.filter(listFilter);
        }
        if (!hasMoreThanOne(listFilter) || !"EC".equals(jsonWebSignature.getKeyType())) {
            return listFilter;
        }
        simpleJwkFilterFilterForInboundSigned.setCrv(((EcdsaUsingShaAlgorithm) jsonWebSignature.getAlgorithmNoConstraintCheck()).getCurveName(), SimpleJwkFilter.OMITTED_OKAY);
        return simpleJwkFilterFilterForInboundSigned.filter(listFilter);
    }

    public JsonWebKey selectWithVerifySignatureDisambiguate(JsonWebSignature jsonWebSignature, Collection<JsonWebKey> collection) throws JoseException {
        List<JsonWebKey> listSelectList = selectList(jsonWebSignature, collection);
        if (listSelectList.isEmpty()) {
            return null;
        }
        if (listSelectList.size() == 1) {
            return listSelectList.get(0);
        }
        for (JsonWebKey jsonWebKey : listSelectList) {
            jsonWebSignature.setKey(jsonWebKey.getKey());
            if (jsonWebSignature.verifySignature()) {
                return jsonWebKey;
            }
        }
        return null;
    }

    private boolean hasMoreThanOne(List<JsonWebKey> list) {
        return list.size() > 1;
    }
}
