package sdk.pendo.io.y5;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lsdk/pendo/io/y5/d;", "Ljava/lang/Exception;", "originalException", "<init>", "(Ljava/lang/Exception;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class d extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Exception originalException) {
        super(originalException);
        Intrinsics.checkNotNullParameter(originalException, "originalException");
    }
}
