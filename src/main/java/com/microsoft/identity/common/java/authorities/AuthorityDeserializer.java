package com.microsoft.identity.common.java.authorities;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.CommonURIBuilder;
import com.microsoft.identity.common.java.util.StringUtil;
import java.lang.reflect.Type;
import java.net.URI;
import net.jcip.annotations.Immutable;

/* JADX INFO: loaded from: classes14.dex */
@Immutable
public class AuthorityDeserializer implements JsonDeserializer<Authority> {
    private static final String TAG = "AuthorityDeserializer";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Authority deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String str;
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonElement2 = asJsonObject.get("type");
        if (jsonElement2 == null) {
            return null;
        }
        String asString = jsonElement2.getAsString();
        asString.hashCode();
        switch (asString) {
            case "AAD":
                Logger.verbose(TAG + ":deserialize", "Type: AAD");
                AzureActiveDirectoryAuthority azureActiveDirectoryAuthority = (AzureActiveDirectoryAuthority) jsonDeserializationContext.deserialize(asJsonObject, AzureActiveDirectoryAuthority.class);
                if (azureActiveDirectoryAuthority != null && azureActiveDirectoryAuthority.mAuthorityUrlString != null) {
                    try {
                        CommonURIBuilder commonURIBuilder = new CommonURIBuilder(URI.create(azureActiveDirectoryAuthority.mAuthorityUrlString));
                        if (commonURIBuilder.getPort() != -1) {
                            str = commonURIBuilder.getScheme() + "://" + commonURIBuilder.getHost() + ":" + commonURIBuilder.getPort();
                        } else {
                            str = commonURIBuilder.getScheme() + "://" + commonURIBuilder.getHost();
                        }
                        String lastPathSegment = commonURIBuilder.getLastPathSegment();
                        if (!StringUtil.isNullOrEmpty(lastPathSegment)) {
                            azureActiveDirectoryAuthority.mAudience = AzureActiveDirectoryAudience.getAzureActiveDirectoryAudience(str, lastPathSegment);
                            return azureActiveDirectoryAuthority;
                        }
                    } catch (IllegalArgumentException e) {
                        Logger.error(TAG + ":deserialize", e.getMessage(), e);
                    }
                }
                return azureActiveDirectoryAuthority;
            case "B2C":
                Logger.verbose(TAG + ":deserialize", "Type: B2C");
                return (Authority) jsonDeserializationContext.deserialize(asJsonObject, AzureActiveDirectoryB2CAuthority.class);
            case "ADFS":
                Logger.verbose(TAG + ":deserialize", "Type: ADFS");
                return (Authority) jsonDeserializationContext.deserialize(asJsonObject, ActiveDirectoryFederationServicesAuthority.class);
            case "CIAM":
                Logger.verbose(TAG + ":deserialize", "Type: CIAM");
                return (Authority) jsonDeserializationContext.deserialize(asJsonObject, CIAMAuthority.class);
            default:
                Logger.verbose(TAG + ":deserialize", "Type: Unknown");
                return (Authority) jsonDeserializationContext.deserialize(asJsonObject, UnknownAuthority.class);
        }
    }
}
