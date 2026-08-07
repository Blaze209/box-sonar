package com.box.android.data.datasource;

import com.box.android.data.datasource.errors.RemoteError;
import kotlin.Metadata;

/* JADX INFO: compiled from: ErrorUtil.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002¨\u0006\u0004"}, d2 = {"putMessageForSupportedErrors", "Lcom/box/android/data/datasource/errors/RemoteError;", "message", "", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ErrorUtilKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoteError putMessageForSupportedErrors(RemoteError remoteError, String str) {
        if (!(remoteError instanceof RemoteError.BadRequest)) {
            return remoteError;
        }
        if (str == null) {
            str = "";
        }
        return new RemoteError.BadRequest(str);
    }
}
