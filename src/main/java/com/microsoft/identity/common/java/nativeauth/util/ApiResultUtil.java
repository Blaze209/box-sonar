package com.microsoft.identity.common.java.nativeauth.util;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.providers.INativeAuthApiResponse;
import com.microsoft.identity.common.java.util.ObjectMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ApiResultUtil.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/util/ApiResultUtil;", "", "()V", "logExposedFieldsOfObject", "", "tag", "", "object", "logResponse", "response", "Lcom/microsoft/identity/common/java/nativeauth/providers/INativeAuthApiResponse;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ApiResultUtil {
    public static final ApiResultUtil INSTANCE = new ApiResultUtil();

    private ApiResultUtil() {
    }

    public final void logResponse(String tag, INativeAuthApiResponse response) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(response, "response");
        String str = tag + AbstractJsonLexerKt.COLON + response.getClass().getSimpleName();
        if (response.getStatusCode() == 200) {
            Logger.info(str, "Success Result");
        } else {
            Logger.warn(str, "Failure Result (Status Code: " + response.getStatusCode() + ')');
        }
        logExposedFieldsOfObject(str, response);
    }

    private final void logExposedFieldsOfObject(String tag, Object object) {
        Logger.warn(tag + AbstractJsonLexerKt.COLON + object.getClass().getSimpleName(), ObjectMapper.serializeExposedFieldsOfObjectToJsonString(object));
    }
}
