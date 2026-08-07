package com.box.android.data.api.interceptors;

import com.box.android.data.api.models.error.GQLHttpError;
import com.box.android.data.api.models.error.GQLHttpErrorEnvelope;
import com.box.android.data.api.models.error.GQLHttpErrorExtensions;
import com.box.android.domain.services.IForceUpdateCoordinator;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: GQLForceUpdateInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\b\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/api/interceptors/GQLForceUpdateInterceptor;", "Lokhttp3/Interceptor;", "forceUpdateCoordinator", "Lcom/box/android/domain/services/IForceUpdateCoordinator;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/domain/services/IForceUpdateCoordinator;Lcom/squareup/moshi/Moshi;)V", "envelopeAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/error/GQLHttpErrorEnvelope;", "kotlin.jvm.PlatformType", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "isGQLValidationFailed", "", "response", "hasValidationFailedInBody", "body", "", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLForceUpdateInterceptor implements Interceptor {
    private static final Companion Companion = new Companion(null);
    private static final String GRAPHQL_VALIDATION_FAILED = "GRAPHQL_VALIDATION_FAILED";
    private static final long PEEK_LIMIT_BYTES = 65536;
    private final JsonAdapter<GQLHttpErrorEnvelope> envelopeAdapter;
    private final IForceUpdateCoordinator forceUpdateCoordinator;
    private final Moshi moshi;

    @Inject
    public GQLForceUpdateInterceptor(IForceUpdateCoordinator forceUpdateCoordinator, Moshi moshi) {
        Intrinsics.checkNotNullParameter(forceUpdateCoordinator, "forceUpdateCoordinator");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.forceUpdateCoordinator = forceUpdateCoordinator;
        this.moshi = moshi;
        this.envelopeAdapter = moshi.adapter(GQLHttpErrorEnvelope.class);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response responseProceed = chain.proceed(chain.request());
        if (this.forceUpdateCoordinator.shouldValidateGQL() && isGQLValidationFailed(responseProceed)) {
            this.forceUpdateCoordinator.onGQLValidationError();
        }
        return responseProceed;
    }

    private final boolean isGQLValidationFailed(Response response) {
        String strSubtype;
        if (response.code() != 400) {
            return false;
        }
        ResponseBody responseBodyBody = response.body();
        MediaType mediaType = responseBodyBody != null ? responseBodyBody.get$contentType() : null;
        if (mediaType == null || (strSubtype = mediaType.subtype()) == null || !StringsKt.contains((CharSequence) strSubtype, (CharSequence) "json", true)) {
            return false;
        }
        return hasValidationFailedInBody(response.peekBody(65536L).string());
    }

    private final boolean hasValidationFailedInBody(String body) {
        List<GQLHttpError> errors;
        try {
            GQLHttpErrorEnvelope gQLHttpErrorEnvelopeFromJson = this.envelopeAdapter.fromJson(body);
            if (gQLHttpErrorEnvelopeFromJson != null && (errors = gQLHttpErrorEnvelopeFromJson.getErrors()) != null) {
                List<GQLHttpError> list = errors;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    for (GQLHttpError gQLHttpError : list) {
                        GQLHttpErrorExtensions extensions = gQLHttpError.getExtensions();
                        String code = extensions != null ? extensions.getCode() : null;
                        String code2 = gQLHttpError.getCode();
                        if (Intrinsics.areEqual(GRAPHQL_VALIDATION_FAILED, code) || Intrinsics.areEqual(GRAPHQL_VALIDATION_FAILED, code2)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX INFO: compiled from: GQLForceUpdateInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/box/android/data/api/interceptors/GQLForceUpdateInterceptor$Companion;", "", "<init>", "()V", "PEEK_LIMIT_BYTES", "", GQLForceUpdateInterceptor.GRAPHQL_VALIDATION_FAILED, "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
