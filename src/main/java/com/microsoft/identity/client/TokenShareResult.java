package com.microsoft.identity.client;

import com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareResultInternal;
import com.microsoft.identity.common.adal.internal.tokensharing.TokenShareResultInternal;

/* JADX INFO: loaded from: classes14.dex */
public class TokenShareResult extends TokenShareResultInternal {

    public static class TokenShareExportFormat {
        public static final String RAW = "RAW";
        public static final String SSO_STATE_SERIALIZER_BLOB = "SSO_STATE_SERIALIZER_BLOB";
    }

    TokenShareResult(ITokenShareResultInternal iTokenShareResultInternal) {
        super(iTokenShareResultInternal.getCacheRecord(), iTokenShareResultInternal.getRefreshToken(), iTokenShareResultInternal.getFormat());
    }

    @Override // com.microsoft.identity.common.adal.internal.tokensharing.TokenShareResultInternal, com.microsoft.identity.common.adal.internal.tokensharing.ITokenShareResultInternal
    public String getFormat() {
        return super.getFormat();
    }
}
