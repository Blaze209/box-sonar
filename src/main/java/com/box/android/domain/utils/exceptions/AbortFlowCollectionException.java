package com.box.android.domain.utils.exceptions;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AbortFlowCollectionException.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/domain/utils/exceptions/AbortFlowCollectionException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", NotificationCompat.CATEGORY_MESSAGE, "", "exception", "<init>", "(Ljava/lang/String;Ljava/lang/Exception;)V", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AbortFlowCollectionException extends Exception {
    public AbortFlowCollectionException(String str, Exception exc) {
        super(str, exc);
    }

    public /* synthetic */ AbortFlowCollectionException(String str, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : exc);
    }
}
