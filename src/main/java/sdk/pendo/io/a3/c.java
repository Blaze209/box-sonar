package sdk.pendo.io.a3;

import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H&J\u0012\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005J\u0012\u0010\t\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005J\u0012\u0010\n\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005J\u000e\u0010\b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/a3/c;", "", "Lsdk/pendo/io/a3/b;", FirebaseAnalytics.Param.LEVEL, "", "Lexternal/sdk/pendo/io/org/koin/core/logger/MESSAGE;", NotificationCompat.CATEGORY_MESSAGE, "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "c", "b", "lvl", "", "Lkotlin/Function0;", "Lsdk/pendo/io/a3/b;", "getLevel", "()Lsdk/pendo/io/a3/b;", "setLevel", "(Lsdk/pendo/io/a3/b;)V", "<init>", "koin-core"}, k = 1, mv = {1, 9, 0})
public abstract class c {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private b level;

    public c(b level) {
        Intrinsics.checkNotNullParameter(level, "level");
        this.level = level;
    }

    public final void a(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        b(b.DEBUG, msg);
    }

    public abstract void a(b level, String msg);

    public final void b(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        b(b.ERROR, msg);
    }

    public final void c(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        b(b.WARNING, msg);
    }

    public final boolean a(b lvl) {
        Intrinsics.checkNotNullParameter(lvl, "lvl");
        return this.level.compareTo(lvl) <= 0;
    }

    public final void b(b lvl, String msg) {
        Intrinsics.checkNotNullParameter(lvl, "lvl");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (a(lvl)) {
            a(lvl, msg);
        }
    }

    public final void a(b lvl, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(lvl, "lvl");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (a(lvl)) {
            a(lvl, msg.invoke());
        }
    }
}
