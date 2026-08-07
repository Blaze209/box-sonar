package com.box.android.data.api.interceptors.auth;

import com.box.android.data.service.impl.SessionManager;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxSharedLinkSession;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: SharedLinkAuthInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/box/android/data/api/interceptors/auth/SharedLinkAuthInterceptor;", "Lokhttp3/Interceptor;", "sessionManager", "Lcom/box/android/data/service/impl/SessionManager;", "<init>", "(Lcom/box/android/data/service/impl/SessionManager;)V", "getSessionManager", "()Lcom/box/android/data/service/impl/SessionManager;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedLinkAuthInterceptor implements Interceptor {
    public static final String HEADER_AUTH_SHARED_LINK = "BoxApi";
    private static final String SEARCH_PATH = "/search";
    public static final String SHARED_LINK = "shared_link";
    public static final String SHARED_LINK_PASSWORD = "shared_link_password";
    private final SessionManager sessionManager;

    @Inject
    public SharedLinkAuthInterceptor(SessionManager sessionManager) {
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        this.sessionManager = sessionManager;
    }

    public final SessionManager getSessionManager() {
        return this.sessionManager;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        BoxSharedLinkSession boxSharedLinkSession;
        String sharedLink;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        if (StringsKt.endsWith$default(request.url().encodedPath(), SEARCH_PATH, false, 2, (Object) null)) {
            return chain.proceed(request);
        }
        if (request.header(HEADER_AUTH_SHARED_LINK) != null) {
            return chain.proceed(request);
        }
        Request.Builder builderNewBuilder = request.newBuilder();
        BoxSession boxSession = this.sessionManager.getBoxSession();
        if ((boxSession instanceof BoxSharedLinkSession) && (sharedLink = (boxSharedLinkSession = (BoxSharedLinkSession) boxSession).getSharedLink()) != null) {
            StringBuilder sb = new StringBuilder("shared_link=" + sharedLink);
            String password = boxSharedLinkSession.getPassword();
            if (password != null) {
                sb.append("&shared_link_password=" + password);
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            builderNewBuilder.addHeader(HEADER_AUTH_SHARED_LINK, string);
        }
        return chain.proceed(builderNewBuilder.build());
    }
}
