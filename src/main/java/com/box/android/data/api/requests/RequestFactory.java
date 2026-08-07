package com.box.android.data.api.requests;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.data.observability.InstrumentedCallFactory;
import com.box.android.data.observability.RumInstrumentation;
import com.box.android.domain.configuration.FeatureFlips;
import com.squareup.moshi.Moshi;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/* JADX INFO: compiled from: RequestFactory.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB4\b\u0007\u0012\u0011\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00192\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/api/requests/RequestFactory;", "", "interceptors", "", "Lokhttp3/Interceptor;", "Lkotlin/jvm/JvmSuppressWildcards;", "moshi", "Lcom/squareup/moshi/Moshi;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "rumInstrumentation", "Lcom/box/android/data/observability/RumInstrumentation;", "<init>", "(Ljava/util/List;Lcom/squareup/moshi/Moshi;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/data/observability/RumInstrumentation;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "okHttpClient", "Lokhttp3/OkHttpClient;", "okHttpClientBuilder", "Lokhttp3/OkHttpClient$Builder;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "createRequest", ExifInterface.GPS_DIRECTION_TRUE, "requestClass", "Ljava/lang/Class;", "baseUrl", "", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RequestFactory {
    private final Moshi moshi;
    private final OkHttpClient okHttpClient;
    private final OkHttpClient.Builder okHttpClientBuilder;
    private final Retrofit.Builder retrofitBuilder;

    @Inject
    public RequestFactory(List<Interceptor> interceptors, Moshi moshi, FeatureFlips featureFlips, RumInstrumentation rumInstrumentation) {
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(rumInstrumentation, "rumInstrumentation");
        this.moshi = moshi;
        this.okHttpClientBuilder = new OkHttpClient.Builder();
        Iterator<T> it = interceptors.iterator();
        while (it.hasNext()) {
            this.okHttpClientBuilder.addInterceptor((Interceptor) it.next());
        }
        OkHttpClient okHttpClientBuild = this.okHttpClientBuilder.connectTimeout(1L, TimeUnit.MINUTES).readTimeout(1L, TimeUnit.MINUTES).build();
        this.okHttpClient = okHttpClientBuild;
        Retrofit.Builder builderClient = new Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(this.moshi)).client(okHttpClientBuild);
        Intrinsics.checkNotNullExpressionValue(builderClient, "client(...)");
        this.retrofitBuilder = builderClient;
        if (featureFlips.getSplunkRUM().getEnabled()) {
            builderClient.callFactory(new InstrumentedCallFactory(okHttpClientBuild, rumInstrumentation));
        }
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final <T> T createRequest(Class<T> requestClass, String baseUrl) {
        Intrinsics.checkNotNullParameter(requestClass, "requestClass");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        return (T) this.retrofitBuilder.baseUrl(baseUrl).build().create(requestClass);
    }
}
