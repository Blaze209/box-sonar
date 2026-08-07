package com.box.android.domain.utils;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.services.IBaseModelControllerService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Extensions.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aF\u0010\u0005\u001a\u0004\u0018\u00010\u0006\"\b\b\u0000\u0010\u0007*\u00020\b\"\u001e\b\u0001\u0010\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\t0\n*\b\u0012\u0004\u0012\u0002H\u00070\u000b*\u00020\f2\u0006\u0010\r\u001a\u0002H\tH\u0086@¢\u0006\u0002\u0010\u000e\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000f"}, d2 = {"TAG", "", "", "getTAG", "(Ljava/lang/Object;)Ljava/lang/String;", "perform", "Lcom/box/androidsdk/content/models/BoxItem;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/box/androidsdk/content/models/BoxObject;", "R", "Lcom/box/androidsdk/content/requests/BoxRequest;", "Lcom/box/androidsdk/content/requests/BoxCacheableRequest;", "Lcom/box/android/domain/services/IBaseModelControllerService;", "request", "(Lcom/box/android/domain/services/IBaseModelControllerService;Lcom/box/androidsdk/content/requests/BoxRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ExtensionsKt {
    public static final String getTAG(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        String simpleName = obj.getClass().getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        return StringsKt.take(simpleName, 40);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Lcom/box/androidsdk/content/models/BoxObject;R:Lcom/box/androidsdk/content/requests/BoxRequest<TT;TR;>;:Lcom/box/androidsdk/content/requests/BoxCacheableRequest<TT;>;>(Lcom/box/android/domain/services/IBaseModelControllerService;TR;Lkotlin/coroutines/Continuation<-Lcom/box/androidsdk/content/models/BoxItem;>;)Ljava/lang/Object; */
    public static final Object perform(IBaseModelControllerService iBaseModelControllerService, BoxRequest boxRequest, Continuation continuation) {
        Result<BoxObject, DomainError> resultPerformRemoteForResult = iBaseModelControllerService.performRemoteForResult(boxRequest);
        if (resultPerformRemoteForResult instanceof Result.Success) {
            Object value = ((Result.Success) resultPerformRemoteForResult).getValue();
            if (value instanceof BoxItem) {
                return (BoxItem) value;
            }
            return null;
        }
        if (resultPerformRemoteForResult instanceof Result.Error) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
