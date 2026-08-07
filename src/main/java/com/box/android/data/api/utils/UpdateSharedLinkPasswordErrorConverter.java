package com.box.android.data.api.utils;

import com.box.android.data.api.models.BadRequestContextErrorDTO;
import com.box.android.data.api.models.ItemBadRequestError;
import com.box.android.data.datasource.errors.ItemsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import com.box.android.domain.utils.result.ResultKt;
import com.squareup.moshi.Moshi;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateSharedLinkPasswordErrorConverter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/data/api/utils/UpdateSharedLinkPasswordErrorConverter;", "", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "convert", "Lcom/box/android/data/datasource/errors/RemoteError;", "body", "", "parseBadRequestContextError", "badRequestErrorDTO", "Lcom/box/android/data/api/models/BadRequestContextErrorDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UpdateSharedLinkPasswordErrorConverter {
    private final Moshi moshi;

    @Inject
    public UpdateSharedLinkPasswordErrorConverter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.moshi = moshi;
    }

    public final RemoteError convert(String body) {
        Result.Error error;
        ItemBadRequestError.ContextInfo contextInfo;
        List<BadRequestContextErrorDTO> errors;
        if (body != null) {
            try {
                error = new Result.Success((ItemBadRequestError) this.moshi.adapter(ItemBadRequestError.class).fromJson(body));
            } catch (Exception e) {
                error = new Result.Error(e);
            }
            if (error instanceof Result.Success) {
                ItemBadRequestError itemBadRequestError = (ItemBadRequestError) ((Result.Success) error).getValue();
                RemoteError remoteError = null;
                if (itemBadRequestError != null && (contextInfo = itemBadRequestError.getContextInfo()) != null && (errors = contextInfo.getErrors()) != null) {
                    Iterator<T> it = errors.iterator();
                    while (it.hasNext()) {
                        RemoteError badRequestContextError = parseBadRequestContextError((BadRequestContextErrorDTO) it.next());
                        if (badRequestContextError != null) {
                            remoteError = badRequestContextError;
                            break;
                        }
                    }
                }
                error = new Result.Success(remoteError);
            } else if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            RemoteError.Unknown unknown = (RemoteError) ResultKt.getOrNull(error);
            if (unknown == null) {
                unknown = new RemoteError.Unknown(-1, body);
            }
            if (unknown != null) {
                return unknown;
            }
        }
        return new RemoteError.Unknown(-1, "");
    }

    private final RemoteError parseBadRequestContextError(BadRequestContextErrorDTO badRequestErrorDTO) {
        if (!Intrinsics.areEqual(badRequestErrorDTO.getName(), "password")) {
            return null;
        }
        String message = badRequestErrorDTO.getMessage();
        if (message == null) {
            message = "";
        }
        List<String> validationErrors = badRequestErrorDTO.getValidationErrors();
        if (validationErrors == null) {
            validationErrors = CollectionsKt.emptyList();
        }
        return new ItemsRemoteError.SharedLinkPasswordValidationError(message, validationErrors);
    }
}
