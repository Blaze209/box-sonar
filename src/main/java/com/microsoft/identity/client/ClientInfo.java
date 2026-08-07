package com.microsoft.identity.client;

import android.util.Base64;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.java.AuthenticationConstants;
import java.nio.charset.Charset;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: loaded from: classes14.dex */
final class ClientInfo {
    private final String mUniqueIdentifier;
    private final String mUniqueTenantIdentifier;

    ClientInfo(String str) throws MsalClientException {
        if (MsalUtils.isEmpty(str)) {
            this.mUniqueIdentifier = "";
            this.mUniqueTenantIdentifier = "";
        } else {
            try {
                Map<String, String> mapExtractJsonObjectIntoMap = MsalUtils.extractJsonObjectIntoMap(new String(Base64.decode(str, 8), Charset.forName("UTF-8")));
                this.mUniqueIdentifier = mapExtractJsonObjectIntoMap.get("uid");
                this.mUniqueTenantIdentifier = mapExtractJsonObjectIntoMap.get(AuthenticationConstants.OAuth2.UTID);
            } catch (JSONException unused) {
                throw new MsalClientException("json_parse_failure", "Failed to parse the returned raw client info.");
            }
        }
    }

    String getUniqueIdentifier() {
        return MsalUtils.isEmpty(this.mUniqueIdentifier) ? "" : this.mUniqueIdentifier;
    }

    String getUniqueTenantIdentifier() {
        return MsalUtils.isEmpty(this.mUniqueTenantIdentifier) ? "" : this.mUniqueTenantIdentifier;
    }

    static final class ClientInfoClaim {
        static final String UNIQUE_IDENTIFIER = "uid";
        static final String UNIQUE_TENANT_IDENTIFIER = "utid";

        ClientInfoClaim() {
        }
    }
}
