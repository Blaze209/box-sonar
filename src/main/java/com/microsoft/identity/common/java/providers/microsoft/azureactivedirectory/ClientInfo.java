package com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.java.base64.Base64Flags;
import com.microsoft.identity.common.java.base64.Base64Util;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.util.JsonUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: loaded from: classes14.dex */
public class ClientInfo implements Serializable {
    private static final String UNIQUE_IDENTIFIER = "uid";
    private static final String UNIQUE_TENANT_IDENTIFIER = "utid";
    private static final long serialVersionUID = 3326461566190095403L;
    private String mRawClientInfo;
    private String mUid;
    private String mUtid;

    public ClientInfo(String str) throws ServiceException {
        if (str == null) {
            throw new NullPointerException("rawClientInfo is marked non-null but is null");
        }
        if (StringUtil.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("ClientInfo cannot be null or blank.");
        }
        try {
            Map<String, String> mapExtractJsonObjectIntoMap = JsonUtil.extractJsonObjectIntoMap(StringUtil.fromByteArray(Base64Util.decode(str, Base64Flags.URL_SAFE)));
            this.mUid = mapExtractJsonObjectIntoMap.get(UNIQUE_IDENTIFIER);
            this.mUtid = mapExtractJsonObjectIntoMap.get("utid");
            this.mRawClientInfo = str;
        } catch (JSONException e) {
            throw new ServiceException("", "invalid_jwt", e);
        }
    }

    public String getUid() {
        return this.mUid;
    }

    public String getUtid() {
        return this.mUtid;
    }

    public String getRawClientInfo() {
        return this.mRawClientInfo;
    }
}
