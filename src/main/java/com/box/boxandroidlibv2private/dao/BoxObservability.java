package com.box.boxandroidlibv2private.dao;

import com.box.androidsdk.content.models.BoxJsonObject;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: BoxObservability.kt */
/* JADX INFO: loaded from: classes13.dex */
@Deprecated(message = "Use ClientSettingsDTO or ClientSettingsModel depending on your use case")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\r\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/box/boxandroidlibv2private/dao/BoxObservability;", "Lcom/box/androidsdk/content/models/BoxJsonObject;", "<init>", "()V", "getRumProxyUrl", "", "getRumSamplingRatio", "", "()Ljava/lang/Double;", "Companion", "BoxAndroidLibraryV2Private_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxObservability extends BoxJsonObject {
    public static final String RUM_PROXY_URL = "rum_proxy_url";
    public static final String RUM_SAMPLING_RATIO = "rum_sampling_ratio";

    public final String getRumProxyUrl() {
        return getPropertyAsString(RUM_PROXY_URL);
    }

    public final Double getRumSamplingRatio() {
        return getPropertyAsDouble(RUM_SAMPLING_RATIO);
    }
}
