package sdk.pendo.io.q6;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.l4.h;
import sdk.pendo.io.q3.e;
import sdk.pendo.io.t6.d;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lsdk/pendo/io/q6/a;", "Lsdk/pendo/io/q3/e;", "", "t", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "<init>", "(Ljava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a implements e<Throwable> {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String description;

    public a(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.description = description;
    }

    @Override // sdk.pendo.io.q3.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable t) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(t, "t");
        if (d.a(t)) {
            if (t instanceof Exception) {
                str = this.description;
                str2 = "UnexpectedException";
            } else {
                boolean z = t instanceof h;
                str = this.description;
                str2 = z ? "HttpException" : "PossibleCrash_androidX";
            }
            sdk.pendo.io.s7.d.a(t, str, str2);
        }
    }
}
