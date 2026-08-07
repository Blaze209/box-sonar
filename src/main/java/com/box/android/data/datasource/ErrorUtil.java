package com.box.android.data.datasource;

import com.box.android.coreservices.utilities.APIErrorStringProvider;
import com.box.android.data.api.models.IContextInfo;
import com.box.android.data.api.models.SimpleErrorDTO;
import com.box.android.data.api.models.collections.ErrorCodes;
import com.box.android.data.datasource.errors.CollaborationRemoteError;
import com.box.android.data.datasource.errors.CollectionsRemoteError;
import com.box.android.data.datasource.errors.CreateFolderRemoteError;
import com.box.android.data.datasource.errors.FileUploadRemoteError;
import com.box.android.data.datasource.errors.ItemsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.errors.RequestCancelledError;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.requests.BoxRequestsShare;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: compiled from: ErrorUtil.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u00020\u00072\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\nj\u0002`\u000b0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J.\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/datasource/ErrorUtil;", "", "<init>", "()V", "boxAPIHttpErrorMap", "", "Lcom/box/android/data/datasource/ErrorUtil$ErrorModel;", "Lcom/box/android/data/datasource/errors/RemoteError;", "getRemoteErrorFromApiException", "apiException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "moshi", "Lcom/squareup/moshi/Moshi;", "parseHttpException", "Lcom/box/android/domain/utils/result/Result;", "httpException", "Lretrofit2/HttpException;", "getRemoteError", "httpErrorStatusCode", "", "apiErrorReasonCode", "", "apiErrorMessage", "apiErrorContextInfo", "Lcom/box/android/data/api/models/IContextInfo;", "Companion", "ErrorModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ErrorUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ErrorUtil instance = new ErrorUtil();
    private final Map<ErrorModel, RemoteError> boxAPIHttpErrorMap = MapsKt.mapOf(TuplesKt.to(new ErrorModel(400, "bad_request"), new RemoteError.BadRequest(null, 1, null)), TuplesKt.to(new ErrorModel(400, "collection_id_malformed"), new CollectionsRemoteError.CollectionIdMalformed(null, 1, null)), TuplesKt.to(new ErrorModel(400, "collection_name_malformed"), new CollectionsRemoteError.CollectionNameMalformed(null, 1, null)), TuplesKt.to(new ErrorModel(400, ""), new RemoteError.BadRequest(null, 1, null)), TuplesKt.to(new ErrorModel(403, ""), new RemoteError.Forbidden(null, 1, null)), TuplesKt.to(new ErrorModel(403, "user_not_allowed_collection"), new CollectionsRemoteError.UserNotAllowedCreation(null, 1, null)), TuplesKt.to(new ErrorModel(403, "creating_favorites_not_allowed"), new CollectionsRemoteError.CreatingFavoritesNotAllowed(null, 1, null)), TuplesKt.to(new ErrorModel(403, "deleting_favorites_not_allowed"), new CollectionsRemoteError.DeletingFavoritesNotAllowed(null, 1, null)), TuplesKt.to(new ErrorModel(403, BoxRequestsShare.AddCollaboration.ERROR_CODE_FORBIDDEN_BY_POLICY), new ItemsRemoteError.ForbiddenByShieldPolicy(null, 1, null)), TuplesKt.to(new ErrorModel(404, ""), new RemoteError.NotFound(null, 1, null)), TuplesKt.to(new ErrorModel(404, "collection_not_found"), new CollectionsRemoteError.CollectionNotFound(null, 1, null)), TuplesKt.to(new ErrorModel(409, ""), new RemoteError.Conflict()), TuplesKt.to(new ErrorModel(409, "exceeds_item_limit"), new CollectionsRemoteError.ExceedsItemLimit(null, 1, null)), TuplesKt.to(new ErrorModel(409, ErrorCodes.DUPLICATE_ERROR), new CollectionsRemoteError.CollectionNameConflict(null, 1, null)), TuplesKt.to(new ErrorModel(500, ""), RemoteError.InternalServerError.INSTANCE), TuplesKt.to(new ErrorModel(412, ""), RemoteError.PreconditionFailed.INSTANCE), TuplesKt.to(new ErrorModel(412, "precondition_failed"), RemoteError.PreconditionFailed.INSTANCE), TuplesKt.to(new ErrorModel(422, ""), RemoteError.UnprocessableEntity.INSTANCE), TuplesKt.to(new ErrorModel(422, "unprocessable_entity"), RemoteError.UnprocessableEntity.INSTANCE), TuplesKt.to(new ErrorModel(400, "item_name_too_long"), new CreateFolderRemoteError.ItemNameTooLong(null, 1, null)), TuplesKt.to(new ErrorModel(400, "item_name_invalid"), new CreateFolderRemoteError.InvalidName(null, 1, null)), TuplesKt.to(new ErrorModel(409, "operation_blocked_temporary"), new CreateFolderRemoteError.OperationBlockedTemporary(null, 1, null)), TuplesKt.to(new ErrorModel(400, "needs_two_factor_authentication"), new CollaborationRemoteError.TwoFactorAuthenticationUnmet(null, 1, null)), TuplesKt.to(new ErrorModel(403, APIErrorStringProvider.ERROR_INVITE_COLLAB_PERMISSION), new FileUploadRemoteError.AccessDeniedError(null, 1, null)), TuplesKt.to(new ErrorModel(403, "file_size_limit_exceeded"), FileUploadRemoteError.FileSizeLimitError.INSTANCE), TuplesKt.to(new ErrorModel(403, "insufficient_storage"), FileUploadRemoteError.InsufficientStorageError.INSTANCE), TuplesKt.to(new ErrorModel(403, "storage_limit_exceeded"), new FileUploadRemoteError.AccountSpaceError(null, 1, null)), TuplesKt.to(new ErrorModel(409, "item_name_in_use"), FileUploadRemoteError.NameExistsErr.INSTANCE), TuplesKt.to(new ErrorModel(401, "unauthorized"), new RemoteError.Unauthorized(null, 1, null)));

    /* JADX INFO: compiled from: ErrorUtil.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\fJ\u0012\u0010\r\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/datasource/ErrorUtil$Companion;", "", "<init>", "()V", "instance", "Lcom/box/android/data/datasource/ErrorUtil;", "getInstance", "()Lcom/box/android/data/datasource/ErrorUtil;", "isConflictError", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "itemNotFoundError", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ErrorUtil getInstance() {
            return ErrorUtil.instance;
        }

        public final boolean isConflictError(Exception exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return (exception instanceof HttpException) && ((HttpException) exception).code() == 409;
        }

        public final boolean itemNotFoundError(Exception exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return (exception instanceof HttpException) && ((HttpException) exception).code() == 404;
        }
    }

    /* JADX INFO: compiled from: ErrorUtil.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/datasource/ErrorUtil$ErrorModel;", "", "statusCode", "", "reasonCode", "", "<init>", "(ILjava/lang/String;)V", "getStatusCode", "()I", "getReasonCode", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ErrorModel {
        private final String reasonCode;
        private final int statusCode;

        public static /* synthetic */ ErrorModel copy$default(ErrorModel errorModel, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = errorModel.statusCode;
            }
            if ((i2 & 2) != 0) {
                str = errorModel.reasonCode;
            }
            return errorModel.copy(i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getStatusCode() {
            return this.statusCode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getReasonCode() {
            return this.reasonCode;
        }

        public final ErrorModel copy(int statusCode, String reasonCode) {
            Intrinsics.checkNotNullParameter(reasonCode, "reasonCode");
            return new ErrorModel(statusCode, reasonCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ErrorModel)) {
                return false;
            }
            ErrorModel errorModel = (ErrorModel) other;
            return this.statusCode == errorModel.statusCode && Intrinsics.areEqual(this.reasonCode, errorModel.reasonCode);
        }

        public int hashCode() {
            return (Integer.hashCode(this.statusCode) * 31) + this.reasonCode.hashCode();
        }

        public String toString() {
            return "ErrorModel(statusCode=" + this.statusCode + ", reasonCode=" + this.reasonCode + ")";
        }

        public ErrorModel(int i, String reasonCode) {
            Intrinsics.checkNotNullParameter(reasonCode, "reasonCode");
            this.statusCode = i;
            this.reasonCode = reasonCode;
        }

        public final String getReasonCode() {
            return this.reasonCode;
        }

        public final int getStatusCode() {
            return this.statusCode;
        }
    }

    public RemoteError getRemoteErrorFromApiException(Exception apiException, Moshi moshi) {
        Intrinsics.checkNotNullParameter(apiException, "apiException");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        if (apiException instanceof HttpException) {
            HttpException httpException = (HttpException) apiException;
            Result<RemoteError, Exception> httpException2 = parseHttpException(httpException, moshi);
            if (httpException2 instanceof Result.Success) {
                return (RemoteError) ((Result.Success) httpException2).getValue();
            }
            if (!(httpException2 instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return getRemoteError(httpException.code(), "", httpException.message(), null);
        }
        if (apiException instanceof UnknownHostException) {
            return new RemoteError.UnknownHostError();
        }
        if (apiException instanceof IOException) {
            return RemoteError.NetworkError.INSTANCE;
        }
        if (apiException instanceof CancellationException) {
            return RequestCancelledError.INSTANCE;
        }
        String message = apiException.getMessage();
        return new RemoteError.Unknown(-1, message != null ? message : "");
    }

    private final Result<RemoteError, Exception> parseHttpException(HttpException httpException, Moshi moshi) {
        Result.Error error;
        Integer status;
        ResponseBody responseBodyErrorBody;
        Response<?> response = httpException.response();
        Result<RemoteError, Exception> result = null;
        String strString = (response == null || (responseBodyErrorBody = response.errorBody()) == null) ? null : responseBodyErrorBody.string();
        if (strString != null) {
            try {
                error = new Result.Success((SimpleErrorDTO) moshi.adapter(SimpleErrorDTO.class).fromJson(strString));
            } catch (Exception e) {
                error = new Result.Error(e);
            }
            if (error instanceof Result.Success) {
                SimpleErrorDTO simpleErrorDTO = (SimpleErrorDTO) ((Result.Success) error).getValue();
                error = new Result.Success(ErrorUtilKt.putMessageForSupportedErrors(getRemoteError((simpleErrorDTO == null || (status = simpleErrorDTO.getStatus()) == null) ? httpException.code() : status.intValue(), simpleErrorDTO != null ? simpleErrorDTO.getCode() : null, simpleErrorDTO != null ? simpleErrorDTO.getMessage() : null, simpleErrorDTO != null ? simpleErrorDTO.getContextInfo() : null), simpleErrorDTO != null ? simpleErrorDTO.getMessage() : null));
            } else if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            result = error;
        }
        if (result != null) {
            return result;
        }
        RemoteError.Unknown unknown = this.boxAPIHttpErrorMap.get(new ErrorModel(httpException.code(), ""));
        if (unknown == null) {
            String message = httpException.getMessage();
            unknown = new RemoteError.Unknown(-1, message != null ? message : "");
        }
        return new Result.Success(unknown);
    }

    public RemoteError getRemoteError(int httpErrorStatusCode, String apiErrorReasonCode, String apiErrorMessage, IContextInfo apiErrorContextInfo) {
        Map<ErrorModel, RemoteError> map = this.boxAPIHttpErrorMap;
        if (apiErrorReasonCode == null) {
            apiErrorReasonCode = "";
        }
        RemoteError remoteError = map.get(new ErrorModel(httpErrorStatusCode, apiErrorReasonCode));
        if (remoteError != null) {
            return remoteError;
        }
        RemoteError remoteError2 = this.boxAPIHttpErrorMap.get(new ErrorModel(httpErrorStatusCode, ""));
        if (remoteError2 != null) {
            return remoteError2;
        }
        if (apiErrorMessage == null) {
            apiErrorMessage = "Unknown Error";
        }
        return new RemoteError.Unknown(httpErrorStatusCode, apiErrorMessage);
    }
}
