package com.microsoft.identity.common.java.cache;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountCredentialBase;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.PrimaryRefreshTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import com.microsoft.identity.common.java.util.StringUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public class CacheKeyValueDelegate implements ICacheKeyValueDelegate {
    public static final String CACHE_VALUE_SEPARATOR = "-";
    private static final String FOCI_PREFIX = "foci-";
    private static final String TAG = "CacheKeyValueDelegate";
    private final Gson mGson = new Gson();

    public CacheKeyValueDelegate() {
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
    }

    static class CacheKeyReplacements {
        static final String APPLICATION_IDENTIFIER = "<application_identifier>";
        static final String AUTH_SCHEME = "<auth_scheme>";
        static final String CLIENT_ID = "<client_id>";
        static final String CREDENTIAL_TYPE = "<credential_type>";
        static final String ENVIRONMENT = "<environment>";
        static final String HOME_ACCOUNT_ID = "<home_account_id>";
        static final String MAM_ENROLLMENT_IDENTIFIER = "<mam_enrollment_identifier>";
        static final String REALM = "<realm>";
        static final String REQUESTED_CLAIMS = "<requested_claims>";
        static final String TARGET = "<target>";

        CacheKeyReplacements() {
        }
    }

    @Override // com.microsoft.identity.common.java.cache.ICacheKeyValueDelegate
    public String generateCacheKey(AccountRecord accountRecord) {
        return "<home_account_id>-<environment>-<realm>".replace("<home_account_id>", StringUtil.sanitizeNullAndLowercaseAndTrim(accountRecord.getHomeAccountId())).replace("<environment>", StringUtil.sanitizeNullAndLowercaseAndTrim(accountRecord.getEnvironment())).replace("<realm>", StringUtil.sanitizeNullAndLowercaseAndTrim(accountRecord.getRealm()));
    }

    private String generateCacheValueInternal(Object obj) {
        JsonObject asJsonObject = this.mGson.toJsonTree(obj).getAsJsonObject();
        if (obj instanceof AccountCredentialBase) {
            AccountCredentialBase accountCredentialBase = (AccountCredentialBase) obj;
            for (String str : accountCredentialBase.getAdditionalFields().keySet()) {
                asJsonObject.add(str, accountCredentialBase.getAdditionalFields().get(str));
            }
        }
        return this.mGson.toJson((JsonElement) asJsonObject);
    }

    @Override // com.microsoft.identity.common.java.cache.ICacheKeyValueDelegate
    public String generateCacheValue(AccountRecord accountRecord) {
        return generateCacheValueInternal(accountRecord);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0056  */
    @Override // com.microsoft.identity.common.java.cache.ICacheKeyValueDelegate
    public String generateCacheKey(Credential credential) {
        String strReplace;
        String strReplace2 = "<home_account_id>-<environment>-<credential_type>-<client_id>-<realm>-<target>".replace("<home_account_id>", StringUtil.sanitizeNullAndLowercaseAndTrim(credential.getHomeAccountId())).replace("<environment>", StringUtil.sanitizeNullAndLowercaseAndTrim(credential.getEnvironment())).replace("<credential_type>", StringUtil.sanitizeNullAndLowercaseAndTrim(credential.getCredentialType()));
        boolean z = credential instanceof RefreshTokenRecord;
        if (z) {
            RefreshTokenRecord refreshTokenRecord = (RefreshTokenRecord) credential;
            if (!StringUtil.isNullOrEmpty(refreshTokenRecord.getFamilyId())) {
                String familyId = refreshTokenRecord.getFamilyId();
                if (familyId.startsWith(FOCI_PREFIX)) {
                    familyId = familyId.replace(FOCI_PREFIX, "");
                }
                strReplace = strReplace2.replace("<client_id>", familyId);
            } else {
                strReplace = strReplace2.replace("<client_id>", StringUtil.sanitizeNullAndLowercaseAndTrim(credential.getClientId()));
            }
        } else {
            strReplace = strReplace2.replace("<client_id>", StringUtil.sanitizeNullAndLowercaseAndTrim(credential.getClientId()));
        }
        if (!(credential instanceof AccessTokenRecord)) {
            if (z) {
                return strReplace.replace("<realm>", "").replace("<target>", StringUtil.sanitizeNullAndLowercaseAndTrim(((RefreshTokenRecord) credential).getTarget()));
            }
            if (credential instanceof IdTokenRecord) {
                return strReplace.replace("<realm>", StringUtil.sanitizeNullAndLowercaseAndTrim(((IdTokenRecord) credential).getRealm())).replace("<target>", "");
            }
            return credential instanceof PrimaryRefreshTokenRecord ? strReplace.replace("<realm>", "").replace("<target>", "") : strReplace;
        }
        AccessTokenRecord accessTokenRecord = (AccessTokenRecord) credential;
        String strReplace3 = strReplace.replace("<realm>", StringUtil.sanitizeNullAndLowercaseAndTrim(accessTokenRecord.getRealm())).replace("<target>", StringUtil.sanitizeNullAndLowercaseAndTrim(accessTokenRecord.getTarget()));
        if (!StringUtil.isNullOrEmpty(accessTokenRecord.getApplicationIdentifier())) {
            strReplace3 = (strReplace3 + "-<application_identifier>").replace("<application_identifier>", StringUtil.sanitizeNullAndLowercaseAndTrim(accessTokenRecord.getApplicationIdentifier()));
        }
        if (!StringUtil.isNullOrEmpty(accessTokenRecord.getMamEnrollmentIdentifier())) {
            strReplace3 = (strReplace3 + "-<mam_enrollment_identifier>").replace("<mam_enrollment_identifier>", StringUtil.sanitizeNullAndLowercaseAndTrim(accessTokenRecord.getMamEnrollmentIdentifier()));
        }
        if (TokenRequest.TokenType.POP.equalsIgnoreCase(accessTokenRecord.getAccessTokenType())) {
            strReplace3 = (strReplace3 + "-<auth_scheme>").replace("<auth_scheme>", StringUtil.sanitizeNullAndLowercaseAndTrim(accessTokenRecord.getAccessTokenType()));
        }
        return !StringUtil.isNullOrEmpty(accessTokenRecord.getRequestedClaims()) ? (strReplace3 + "-<requested_claims>").replace("<requested_claims>", StringUtil.sanitizeNullAndLowercaseAndTrim(String.valueOf(StringUtil.sanitizeNullAndLowercaseAndTrim(accessTokenRecord.getRequestedClaims()).hashCode()))) : strReplace3;
    }

    @Override // com.microsoft.identity.common.java.cache.ICacheKeyValueDelegate
    public String generateCacheValue(Credential credential) {
        return generateCacheValueInternal(credential);
    }

    @Override // com.microsoft.identity.common.java.cache.ICacheKeyValueDelegate
    public <T extends AccountCredentialBase> T fromCacheValue(String str, Class<? extends AccountCredentialBase> cls) {
        try {
            T t = (T) this.mGson.fromJson(str, (Class) cls);
            if (!StringUtil.isNullOrEmpty(str)) {
                JsonObject asJsonObject = new JsonParser().parse(str).getAsJsonObject();
                Iterator<String> it = getExpectedJsonFields(cls).iterator();
                while (it.hasNext()) {
                    asJsonObject.remove(it.next());
                }
                HashMap map = new HashMap();
                for (String str2 : asJsonObject.keySet()) {
                    map.put(str2, asJsonObject.get(str2));
                }
                t.setAdditionalFields(map);
            }
            return t;
        } catch (JsonSyntaxException unused) {
            Logger.error(TAG + ":fromCacheValue", "Failed to parse cache value.", null);
            return null;
        }
    }

    private static Set<String> getExpectedJsonFields(Class<? extends AccountCredentialBase> cls) {
        HashSet hashSet = new HashSet();
        Iterator<Field> it = getSerializedNameAnnotatedFields(getFieldsUpTo(cls, AccountCredentialBase.class)).iterator();
        while (it.hasNext()) {
            hashSet.add(((SerializedName) it.next().getAnnotation(SerializedName.class)).value());
        }
        return hashSet;
    }

    private static List<Field> getSerializedNameAnnotatedFields(List<Field> list) {
        ArrayList arrayList = new ArrayList();
        for (Field field : list) {
            if (((SerializedName) field.getAnnotation(SerializedName.class)) != null) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    private static List<Field> getFieldsUpTo(Class<?> cls, Class<?> cls2) {
        ArrayList arrayList = new ArrayList(Arrays.asList(cls.getDeclaredFields()));
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && (cls2 == null || !superclass.equals(cls2))) {
            arrayList.addAll(getFieldsUpTo(superclass, cls2));
        }
        return arrayList;
    }
}
