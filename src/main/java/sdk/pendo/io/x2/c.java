package sdk.pendo.io.x2;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lsdk/pendo/io/x2/c;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", NotificationCompat.CATEGORY_MESSAGE, "parent", "<init>", "(Ljava/lang/String;Ljava/lang/Exception;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
public final class c extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String msg, Exception parent) {
        super(msg, parent);
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(parent, "parent");
    }
}
