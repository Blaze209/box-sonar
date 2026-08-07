package com.box.android.domain.services;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxRequest;
import kotlin.Metadata;

/* JADX INFO: compiled from: IBaseModelControllerService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\"\u0014\b\u0000\u0010\u0006*\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00060\u0007\"\b\b\u0001\u0010\b*\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00060\u0007H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IBaseModelControllerService;", "", "performRemoteForResult", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/androidsdk/content/models/BoxObject;", "Lcom/box/android/domain/models/DomainError;", "R", "Lcom/box/androidsdk/content/requests/BoxRequest;", ExifInterface.GPS_DIRECTION_TRUE, "request", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IBaseModelControllerService {
    <R extends BoxRequest<T, R>, T extends BoxObject> Result<BoxObject, DomainError> performRemoteForResult(BoxRequest<T, R> request);
}
