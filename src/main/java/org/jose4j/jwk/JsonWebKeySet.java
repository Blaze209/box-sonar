package org.jose4j.jwk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jose4j.json.JsonUtil;
import org.jose4j.lang.JoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class JsonWebKeySet {
    public static final String JWK_SET_MEMBER_NAME = "keys";
    private static final Logger log = LoggerFactory.getLogger((Class<?>) JsonWebKeySet.class);
    private List<JsonWebKey> keys;

    public JsonWebKeySet(String str) throws JoseException {
        List<Map> list = (List) JsonUtil.parseJson(str).get("keys");
        if (list == null) {
            throw new JoseException("The JSON JWKS content does not include the keys member.");
        }
        this.keys = new ArrayList(list.size());
        for (Map map : list) {
            try {
                this.keys.add(JsonWebKey.Factory.newJwk((Map<String, Object>) map));
            } catch (Exception e) {
                log.debug("Ignoring an individual JWK in a JWKS due to a problem processing it. JWK params: {} and the full JWKS content: {}. {}", map, str, e);
            }
        }
    }

    public JsonWebKeySet(JsonWebKey... jsonWebKeyArr) {
        this((List<? extends JsonWebKey>) Arrays.asList(jsonWebKeyArr));
    }

    public JsonWebKeySet(List<? extends JsonWebKey> list) {
        this.keys = new ArrayList(list.size());
        Iterator<? extends JsonWebKey> it = list.iterator();
        while (it.hasNext()) {
            this.keys.add(it.next());
        }
    }

    public void addJsonWebKey(JsonWebKey jsonWebKey) {
        this.keys.add(jsonWebKey);
    }

    public List<JsonWebKey> getJsonWebKeys() {
        return this.keys;
    }

    public JsonWebKey findJsonWebKey(String str, String str2, String str3, String str4) {
        List<JsonWebKey> listFindJsonWebKeys = findJsonWebKeys(str, str2, str3, str4);
        if (listFindJsonWebKeys.isEmpty()) {
            return null;
        }
        return listFindJsonWebKeys.iterator().next();
    }

    public List<JsonWebKey> findJsonWebKeys(String str, String str2, String str3, String str4) {
        ArrayList arrayList = new ArrayList();
        for (JsonWebKey jsonWebKey : this.keys) {
            boolean zEquals = str != null ? str.equals(jsonWebKey.getKeyId()) : true;
            if (str3 != null) {
                zEquals &= str3.equals(jsonWebKey.getUse());
            }
            if (str2 != null) {
                zEquals &= str2.equals(jsonWebKey.getKeyType());
            }
            if (str4 != null) {
                zEquals &= str4.equals(jsonWebKey.getAlgorithm());
            }
            if (zEquals) {
                arrayList.add(jsonWebKey);
            }
        }
        return arrayList;
    }

    public String toJson() {
        return toJson(JsonWebKey.OutputControlLevel.INCLUDE_SYMMETRIC);
    }

    public String toJson(JsonWebKey.OutputControlLevel outputControlLevel) {
        ArrayList arrayList = new ArrayList(this.keys.size());
        Iterator<JsonWebKey> it = this.keys.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toParams(outputControlLevel));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("keys", arrayList);
        return JsonUtil.toJson(linkedHashMap);
    }
}
