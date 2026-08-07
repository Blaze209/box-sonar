package sdk.pendo.io.y5;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/y5/f;", "Ljava/io/IOException;", "", "message", "<init>", "(Ljava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class f extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
