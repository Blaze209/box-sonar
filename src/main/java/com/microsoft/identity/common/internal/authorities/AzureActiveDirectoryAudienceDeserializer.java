package com.microsoft.identity.common.internal.authorities;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.microsoft.identity.common.java.authorities.AccountsInOneOrganization;
import com.microsoft.identity.common.java.authorities.AllAccounts;
import com.microsoft.identity.common.java.authorities.AnyOrganizationalAccount;
import com.microsoft.identity.common.java.authorities.AnyPersonalAccount;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.logging.Logger;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes14.dex */
public class AzureActiveDirectoryAudienceDeserializer implements JsonDeserializer<AzureActiveDirectoryAudience> {
    private static final String TAG = "AzureActiveDirectoryAudienceDeserializer";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public AzureActiveDirectoryAudience deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String str = TAG + ":deserialize";
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonElement2 = asJsonObject.get("type");
        if (jsonElement2 == null) {
            return null;
        }
        String asString = jsonElement2.getAsString();
        asString.hashCode();
        switch (asString) {
            case "PersonalMicrosoftAccount":
                Logger.verbose(str, "Type: PersonalMicrosoftAccount");
                return (AzureActiveDirectoryAudience) jsonDeserializationContext.deserialize(asJsonObject, AnyPersonalAccount.class);
            case "AzureADMultipleOrgs":
                Logger.verbose(str, "Type: AzureADMultipleOrgs");
                return (AzureActiveDirectoryAudience) jsonDeserializationContext.deserialize(asJsonObject, AnyOrganizationalAccount.class);
            case "AzureADMyOrg":
                Logger.verbose(str, "Type: AzureADMyOrg");
                return (AzureActiveDirectoryAudience) jsonDeserializationContext.deserialize(asJsonObject, AccountsInOneOrganization.class);
            case "AzureADandPersonalMicrosoftAccount":
                Logger.verbose(str, "Type: AzureADandPersonalMicrosoftAccount");
                return (AzureActiveDirectoryAudience) jsonDeserializationContext.deserialize(asJsonObject, AllAccounts.class);
            default:
                Logger.verbose(str, "Type: Unknown");
                return (AzureActiveDirectoryAudience) jsonDeserializationContext.deserialize(asJsonObject, UnknownAudience.class);
        }
    }
}
