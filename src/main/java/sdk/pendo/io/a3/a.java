package sdk.pendo.io.a3;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/a3/a;", "Lsdk/pendo/io/a3/c;", "Lsdk/pendo/io/a3/b;", FirebaseAnalytics.Param.LEVEL, "", "Lexternal/sdk/pendo/io/org/koin/core/logger/MESSAGE;", NotificationCompat.CATEGORY_MESSAGE, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "koin-core"}, k = 1, mv = {1, 9, 0})
public final class a extends c {
    public a() {
        super(b.NONE);
    }

    @Override // sdk.pendo.io.a3.c
    public void a(b level, String msg) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }
}
