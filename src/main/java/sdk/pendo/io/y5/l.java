package sdk.pendo.io.y5;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lsdk/pendo/io/y5/l;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class l extends IllegalStateException {
    public l() {
        super("SemanticsNode must be only be read on the main thread");
    }
}
