package com.microsoft.identity.common.java.providers.oauth2;

import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import com.nimbusds.jwt.JWTParser;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class IDToken {
    public static final String ADDRESS = "address";
    public static final String BIRTHDATE = "birthdate";
    public static final String EMAIL = "email";
    public static final String EMAIL_VERIFIED = "email_verified";
    public static final String FAMILY_NAME = "family_name";
    public static final String GENDER = "gender";
    public static final String GIVEN_NAME = "given_name";
    public static final String LOCALE = "locale";
    public static final String MIDDLE_NAME = "middle_name";
    public static final String NAME = "name";
    public static final String NICKNAME = "nickname";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String PHONE_NUMBER_VERIFIED = "phone_number_verified";
    public static final String PICTURE = "picture";
    public static final String PREFERRED_USERNAME = "preferred_username";
    public static final String PROFILE = "profile";
    public static final String SUBJECT = "sub";
    private static final String TAG = "IDToken";
    public static final String UPDATED_AT = "updated_at";
    public static final String WEBSITE = "website";
    public static final String ZONEINFO = "zoneinfo";
    private final String mRawIdToken;
    private final Map<String, ?> mTokenClaims;

    protected boolean canEqual(Object obj) {
        return obj instanceof IDToken;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IDToken)) {
            return false;
        }
        IDToken iDToken = (IDToken) obj;
        if (!iDToken.canEqual(this)) {
            return false;
        }
        Map<String, ?> map = this.mTokenClaims;
        Map<String, ?> map2 = iDToken.mTokenClaims;
        if (map != null ? !map.equals(map2) : map2 != null) {
            return false;
        }
        String str = this.mRawIdToken;
        String str2 = iDToken.mRawIdToken;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        Map<String, ?> map = this.mTokenClaims;
        int iHashCode = map == null ? 43 : map.hashCode();
        String str = this.mRawIdToken;
        return ((iHashCode + 59) * 59) + (str != null ? str.hashCode() : 43);
    }

    public IDToken(String str) throws ServiceException {
        if (StringUtil.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("null or empty raw idtoken");
        }
        this.mRawIdToken = str;
        this.mTokenClaims = parseJWT(str);
    }

    public String getRawIDToken() {
        return this.mRawIdToken;
    }

    public Map<String, ?> getTokenClaims() {
        Map<String, ?> map = this.mTokenClaims;
        return map == null ? Collections.emptyMap() : Collections.unmodifiableMap(map);
    }

    public static Map<String, ?> parseJWT(String str) throws ServiceException {
        if (str == null) {
            throw new NullPointerException("rawIdToken is marked non-null but is null");
        }
        HashMap map = new HashMap();
        try {
            map.putAll(JWTParser.parse(str).getJWTClaimsSet().getClaims());
            return map;
        } catch (ParseException e) {
            Logger.error(TAG + ":getClaims(String)", "Failed to parse IdToken", e);
            throw new ServiceException("Failed to parse JWT", "invalid_jwt", e);
        }
    }

    public String getStringClaim(String str) {
        if (str == null) {
            throw new NullPointerException("claimName is marked non-null but is null");
        }
        Map<String, ?> map = this.mTokenClaims;
        if (map != null) {
            return (String) map.get(str);
        }
        return null;
    }
}
