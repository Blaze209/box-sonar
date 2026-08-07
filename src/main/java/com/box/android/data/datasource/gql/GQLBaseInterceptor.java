package com.box.android.data.datasource.gql;

import com.apollographql.apollo3.api.Error;
import com.apollographql.apollo3.api.Operation;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.utilities.RemoteErrorConverter;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.Moshi;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: GQLBaseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/datasource/gql/GQLBaseInterceptor;", "Lokhttp3/Interceptor;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "handleException", "Lcom/box/android/data/datasource/errors/RemoteError;", "cause", "", "getError", "Lcom/apollographql/apollo3/api/Error;", CustomAttributeKeys.REMOTE_ERROR, "getResponse", "Lokhttp3/Response;", "statusCode", "", "request", "Lokhttp3/Request;", "responseError", "data", "Lcom/apollographql/apollo3/api/Operation$Data;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class GQLBaseInterceptor implements Interceptor {
    private final Moshi moshi;

    public GQLBaseInterceptor(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.moshi = moshi;
    }

    public Moshi getMoshi() {
        return this.moshi;
    }

    public RemoteError handleException(Throwable cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        BoxLogUtils.e(ExtensionsKt.getTAG(this), cause);
        String message = cause.getMessage();
        if (message == null) {
            message = "Unknown Error";
        }
        return new RemoteError.Unknown(-1, message);
    }

    public Error getError(RemoteError remoteError) {
        Intrinsics.checkNotNullParameter(remoteError, "remoteError");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CustomAttributeKeys.REMOTE_ERROR, RemoteErrorConverter.INSTANCE.toString(remoteError));
        return new Error("Error - " + remoteError.getClass().getSimpleName() + " (" + remoteError.getCode() + ")", null, null, null, linkedHashMap);
    }

    public static /* synthetic */ Response getResponse$default(GQLBaseInterceptor gQLBaseInterceptor, int i, Request request, Error error, Operation.Data data, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getResponse");
        }
        if ((i2 & 4) != 0) {
            error = null;
        }
        return gQLBaseInterceptor.getResponse(i, request, error, data);
    }

    public Response getResponse(int statusCode, Request request, Error responseError, Operation.Data data) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(data, "data");
        if (responseError == null || (listEmptyList = CollectionsKt.listOf(responseError)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        String json = getMoshi().adapter(GQLOperationDTO.class).toJson(new GQLOperationDTO(data, listEmptyList));
        Response.Builder builder = new Response.Builder();
        ResponseBody.Companion companion = ResponseBody.INSTANCE;
        Intrinsics.checkNotNull(json);
        return builder.body(ResponseBody.Companion.create$default(companion, json, (MediaType) null, 1, (Object) null)).message("Intercepted").code(200).request(request).protocol(Protocol.HTTP_1_1).build();
    }
}
