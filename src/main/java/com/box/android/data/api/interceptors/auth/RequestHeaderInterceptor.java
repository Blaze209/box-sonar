package com.box.android.data.api.interceptors.auth;

import com.box.android.domain.services.ISessionManager;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: RequestHeaderInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/api/interceptors/auth/RequestHeaderInterceptor;", "Lokhttp3/Interceptor;", "sessionManager", "Lcom/box/android/domain/services/ISessionManager;", "<init>", "(Lcom/box/android/domain/services/ISessionManager;)V", "getSessionManager", "()Lcom/box/android/domain/services/ISessionManager;", "headersMap", "", "", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RequestHeaderInterceptor implements Interceptor {
    public static final String ACCEPT_KEY = "Accept";
    public static final String CONTENT_TYPE_KEY = "Content-Type";
    public static final String USER_AGENT_KEY = "User-Agent";
    private final Map<String, String> headersMap;
    private final ISessionManager sessionManager;

    @Inject
    public RequestHeaderInterceptor(ISessionManager sessionManager) {
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        this.sessionManager = sessionManager;
        this.headersMap = MapsKt.mapOf(TuplesKt.to("Accept", "application/vnd.box.internal+json;version=3"), TuplesKt.to("Content-Type", "application/vnd.box+json;version=v2"), TuplesKt.to("User-Agent", sessionManager.getUserAgent()));
    }

    public final ISessionManager getSessionManager() {
        return this.sessionManager;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        for (Map.Entry<String, String> entry : this.headersMap.entrySet()) {
            builderNewBuilder.addHeader(entry.getKey(), entry.getValue());
        }
        if (StringsKt.contains$default((CharSequence) request.url().getUrl(), (CharSequence) "notification-center/notifications", false, 2, (Object) null)) {
            builderNewBuilder.header("Accept", "application/json;version=2");
        }
        return chain.proceed(builderNewBuilder.build());
    }
}
