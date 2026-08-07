package com.box.android.data.datasource.errors;

import com.box.android.data.api.models.MultiItemConflictErrorDTO;
import com.box.android.data.api.models.SingleItemConflictErrorDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.domain.utils.result.Result;
import com.box.android.domain.utils.result.ResultKt;
import com.squareup.moshi.Moshi;
import java.io.FileNotFoundException;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: compiled from: UploadErrorUtil.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/datasource/errors/UploadErrorUtil;", "Lcom/box/android/data/datasource/ErrorUtil;", "<init>", "()V", "getRemoteErrorFromApiException", "Lcom/box/android/data/datasource/errors/RemoteError;", "apiException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "moshi", "Lcom/squareup/moshi/Moshi;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadErrorUtil extends ErrorUtil {
    public static final UploadErrorUtil INSTANCE = new UploadErrorUtil();

    private UploadErrorUtil() {
    }

    @Override // com.box.android.data.datasource.ErrorUtil
    public RemoteError getRemoteErrorFromApiException(Exception apiException, Moshi moshi) {
        Result.Error error;
        Result.Error error2;
        SingleItemConflictErrorDTO.ContextInfo contextInfo;
        IItemDTO conflicts;
        MultiItemConflictErrorDTO.ContextInfo contextInfo2;
        List<IItemDTO> conflicts2;
        ResponseBody responseBodyErrorBody;
        Intrinsics.checkNotNullParameter(apiException, "apiException");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        if (ErrorUtil.INSTANCE.itemNotFoundError(apiException)) {
            return new FileUploadRemoteError.SourceOrDestNotFound("ItemNotFoundError");
        }
        if (apiException instanceof FileNotFoundException) {
            return new FileUploadRemoteError.SourceOrDestNotFound("FileNotFoundException");
        }
        ItemsRemoteError.NameConflict nameConflict = null;
        if (apiException instanceof CommitNotReadyException) {
            return new FileUploadRemoteError.CommitNotReady(null, 1, null);
        }
        if (ErrorUtil.INSTANCE.isConflictError(apiException)) {
            Response<?> response = ((HttpException) apiException).response();
            String strString = (response == null || (responseBodyErrorBody = response.errorBody()) == null) ? null : responseBodyErrorBody.string();
            if (strString != null) {
                try {
                    error = new Result.Success((MultiItemConflictErrorDTO) moshi.adapter(MultiItemConflictErrorDTO.class).fromJson(strString));
                } catch (Exception e) {
                    error = new Result.Error(e);
                }
                if (error instanceof Result.Success) {
                    MultiItemConflictErrorDTO multiItemConflictErrorDTO = (MultiItemConflictErrorDTO) ((Result.Success) error).getValue();
                    error = new Result.Success((multiItemConflictErrorDTO == null || (contextInfo2 = multiItemConflictErrorDTO.getContextInfo()) == null || (conflicts2 = contextInfo2.getConflicts()) == null) ? null : new ItemsRemoteError.NameConflict(conflicts2));
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                ItemsRemoteError.NameConflict nameConflict2 = (ItemsRemoteError.NameConflict) ResultKt.getOrNull(error);
                if (nameConflict2 == null) {
                    try {
                        error2 = new Result.Success((SingleItemConflictErrorDTO) moshi.adapter(SingleItemConflictErrorDTO.class).fromJson(strString));
                    } catch (Exception e2) {
                        error2 = new Result.Error(e2);
                    }
                    if (error2 instanceof Result.Success) {
                        SingleItemConflictErrorDTO singleItemConflictErrorDTO = (SingleItemConflictErrorDTO) ((Result.Success) error2).getValue();
                        if (singleItemConflictErrorDTO != null && (contextInfo = singleItemConflictErrorDTO.getContextInfo()) != null && (conflicts = contextInfo.getConflicts()) != null) {
                            nameConflict = new ItemsRemoteError.NameConflict(CollectionsKt.listOf(conflicts));
                        }
                        error2 = new Result.Success(nameConflict);
                    } else if (!(error2 instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    nameConflict2 = (ItemsRemoteError.NameConflict) ResultKt.getOrNull(error2);
                }
                if (nameConflict2 != null) {
                    return nameConflict2;
                }
            }
            return super.getRemoteErrorFromApiException(apiException, moshi);
        }
        return super.getRemoteErrorFromApiException(apiException, moshi);
    }
}
