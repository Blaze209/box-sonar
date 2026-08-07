package com.box.android.preview.integration.media3;

import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.datasource.DefaultHttpDataSource;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.data.api.interceptors.auth.SharedLinkAuthInterceptor;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: Media3DataSourceFactory.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\f"}, d2 = {"Lcom/box/android/preview/integration/media3/Media3DataSourceFactory;", "", "<init>", "()V", "createFactory", "Landroidx/media3/datasource/DefaultDataSource$Factory;", "session", "Lcom/box/android/coreservices/models/CustomBoxSession;", "updateHttpDataSourceFactory", "", "dataSourceFactory", "Landroidx/media3/datasource/DefaultHttpDataSource$Factory;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Media3DataSourceFactory {
    public static final int $stable = 0;

    @Inject
    public Media3DataSourceFactory() {
    }

    public final DefaultDataSource.Factory createFactory(CustomBoxSession session) {
        Intrinsics.checkNotNullParameter(session, "session");
        DefaultHttpDataSource.Factory userAgent = new DefaultHttpDataSource.Factory().setUserAgent(session.getUserAgent());
        Intrinsics.checkNotNullExpressionValue(userAgent, "setUserAgent(...)");
        updateHttpDataSourceFactory(userAgent, session);
        return new DefaultDataSource.Factory(session.getApplicationContext(), userAgent);
    }

    private final void updateHttpDataSourceFactory(DefaultHttpDataSource.Factory dataSourceFactory, CustomBoxSession session) {
        String str;
        String sharedLink = session.getSharedLink();
        if (sharedLink == null || sharedLink.length() == 0) {
            str = null;
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format(Locale.ENGLISH, "shared_link=%s", Arrays.copyOf(new Object[]{session.getSharedLink()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            String password = session.getPassword();
            if (password != null && password.length() != 0) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str2 = String.format(Locale.ENGLISH, "&shared_link_password=%s", Arrays.copyOf(new Object[]{session.getPassword()}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                str = ((Object) str) + str2;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Authorization", "Bearer " + session.getAuthInfo().accessToken());
        if (str != null) {
            linkedHashMap.put(SharedLinkAuthInterceptor.HEADER_AUTH_SHARED_LINK, str);
        }
        dataSourceFactory.setDefaultRequestProperties((Map<String, String>) linkedHashMap);
    }
}
