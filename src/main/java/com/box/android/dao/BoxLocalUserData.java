package com.box.android.dao;

import com.box.android.coreservices.models.BoxPersistableObject;
import com.box.android.localrepo.LevelDBKeyValueStore;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class BoxLocalUserData extends BoxPersistableObject {
    private static final String FIELD_BASE_DOMAIN = "baseDomain";
    private static final String FIELD_CLIENT_ID = "clientId";
    private static final String FIELD_CLIENT_SECRET = "clientSecret";
    private static final String FIELD_USER_AUTH_TOKEN = "userAuthToken";
    private static final String FIELD_USER_AUTH_TOKEN_EXPIRATION = "userAuthTokenExpiration";
    private static final String FIELD_USER_NAME = "userName";
    private static final String FIELD_USER_REFRESH_TOKEN = "userRefreshToken";
    public static final String SCHEME = "userdata_local";
    private static final long serialVersionUID = 1;

    public BoxLocalUserData() {
    }

    public BoxLocalUserData(String str, String str2) {
        setObjectId(str);
        setType(str2);
    }

    public static BoxLocalUserData createInstance(String str, String str2, String str3, String str4, String str5) {
        BoxLocalUserData boxLocalUserData = new BoxLocalUserData(str, "type");
        boxLocalUserData.setEncryptedAuthToken(str3);
        boxLocalUserData.setUserName(str2);
        boxLocalUserData.setClientId(str4);
        boxLocalUserData.setClientSecret(str5);
        return boxLocalUserData;
    }

    public String getKeyNamerkey() {
        return new LevelDBKeyValueStore.KeyNamer().getKey(SCHEME, getType(), getObjectId());
    }

    public String getObjectId() {
        return (String) get("id");
    }

    private void setObjectId(String str) {
        put("id", str);
    }

    @Override // com.box.android.coreservices.models.BoxPersistableObject, com.box.android.domain.models.IBoxPersistableObject
    public String getType() {
        return (String) get("type");
    }

    private void setType(String str) {
        put("type", str);
    }

    public String getUserName() {
        return (String) get(FIELD_USER_NAME);
    }

    public void setUserName(String str) {
        put(FIELD_USER_NAME, str);
    }

    public String getClientId() {
        return (String) get(FIELD_CLIENT_ID);
    }

    public void setClientId(String str) {
        put(FIELD_CLIENT_ID, str);
    }

    public String getClientSecret() {
        return (String) get(FIELD_CLIENT_SECRET);
    }

    public void setClientSecret(String str) {
        if (str == null || str.length() <= 6) {
            return;
        }
        put(FIELD_CLIENT_SECRET, str.substring(0, 6));
    }

    public String getBaseDomain() {
        return (String) get(FIELD_BASE_DOMAIN);
    }

    public void setBaseDomain(String str) {
        put(FIELD_BASE_DOMAIN, str);
    }

    public String getEncryptedAuthToken() {
        return (String) get(FIELD_USER_AUTH_TOKEN);
    }

    public void setEncryptedAuthToken(String str) {
        put(FIELD_USER_AUTH_TOKEN, str);
    }

    public Long getAuthTokenExpiration() {
        Object obj = get(FIELD_USER_AUTH_TOKEN_EXPIRATION);
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        return (Long) obj;
    }

    public void setAuthTokenExpiration(Long l) {
        put(FIELD_USER_AUTH_TOKEN_EXPIRATION, l);
    }

    public String getEncryptedRefreshToken() {
        return (String) get(FIELD_USER_REFRESH_TOKEN);
    }

    public void setEncryptedRefreshToken(String str) {
        put(FIELD_USER_REFRESH_TOKEN, str);
    }

    public boolean usingOAuth() {
        return StringUtils.isNotEmpty(getEncryptedRefreshToken());
    }

    public String toString() {
        return getUserName();
    }
}
