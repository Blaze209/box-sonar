package com.microsoft.identity.common.java.nativeauth.providers.responses;

import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import kotlin.Metadata;

/* JADX INFO: compiled from: ApiResult.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/providers/responses/ApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "correlationId", "", "getCorrelationId", "()Ljava/lang/String;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ApiResult extends ILoggable {
    String getCorrelationId();

    /* JADX INFO: compiled from: ApiResult.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(ApiResult apiResult) {
            return ILoggable.DefaultImpls.containsPii(apiResult);
        }
    }
}
