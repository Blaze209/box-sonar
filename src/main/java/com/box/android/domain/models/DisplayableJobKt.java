package com.box.android.domain.models;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: compiled from: DisplayableJob.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"getContentUrl", "", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "(Lcom/box/android/domain/models/IJobDisplayInfoProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DisplayableJobKt {
    public static final Object getContentUrl(IJobDisplayInfoProvider iJobDisplayInfoProvider, Continuation<? super String> continuation) {
        if (!(iJobDisplayInfoProvider instanceof UploadFileJobDisplayInfoProvider)) {
            return null;
        }
        Object contentUrl = ((UploadFileJobDisplayInfoProvider) iJobDisplayInfoProvider).getContentUrl(continuation);
        return contentUrl == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? contentUrl : (String) contentUrl;
    }
}
