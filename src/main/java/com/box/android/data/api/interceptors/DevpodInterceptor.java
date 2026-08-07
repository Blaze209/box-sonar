package com.box.android.data.api.interceptors;

import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.configuration.ConfigManager;
import java.io.IOException;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: DevpodInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/box/android/data/api/interceptors/DevpodInterceptor;", "Lokhttp3/Interceptor;", "configManager", "Lcom/box/android/domain/configuration/ConfigManager;", "<init>", "(Lcom/box/android/domain/configuration/ConfigManager;)V", "getConfigManager", "()Lcom/box/android/domain/configuration/ConfigManager;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DevpodInterceptor implements Interceptor {
    private static final Map<String, String> HOST_TO_PATH_PREFIX = MapsKt.mapOf(TuplesKt.to("api.box.com", "/api"), TuplesKt.to("account.box.com", ""));
    private final ConfigManager configManager;

    @Inject
    public DevpodInterceptor(ConfigManager configManager) {
        Intrinsics.checkNotNullParameter(configManager, "configManager");
        this.configManager = configManager;
    }

    public final ConfigManager getConfigManager() {
        return this.configManager;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        if (!BuildConfigProvider.INSTANCE.isDebugBuild() || !this.configManager.isDevpodEnvironment()) {
            return chain.proceed(request);
        }
        String str = HOST_TO_PATH_PREFIX.get(request.url().host());
        if (str == null) {
            return chain.proceed(request);
        }
        String string = this.configManager.getString(BoxConfigConstants.CONFIG_KEY_V2_API_URL_HOSTNAME);
        HttpUrl.Builder builderNewBuilder = request.url().newBuilder();
        Intrinsics.checkNotNull(string);
        return chain.proceed(request.newBuilder().url(builderNewBuilder.host(string).encodedPath(str + request.url().encodedPath()).build()).build());
    }
}
