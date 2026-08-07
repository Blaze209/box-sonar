package sdk.pendo.io.j7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0003B\u001b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\b\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\b\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/j7/g;", "Lsdk/pendo/io/j7/d;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "()Ljava/lang/String;", "name", "b", "value", "", "height", "Lsdk/pendo/io/j7/g$a;", "<init>", "(Ljava/lang/Integer;Lsdk/pendo/io/j7/g$a;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class g extends d {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String value;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lsdk/pendo/io/j7/g$a;", "", "", "css", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "LENGTH", "AUTO", "PERCENT", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public enum a {
        LENGTH("px"),
        AUTO("auto"),
        PERCENT("%");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(a());
        private final String css;

        a(String str) {
            this.css = str;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getCss() {
            return this.css;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Integer num, a value) {
        String css;
        super(null);
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = "height";
        if (num == null || value == a.AUTO) {
            css = value.getCss();
        } else {
            css = num + value.getCss();
        }
        this.value = css;
    }

    @Override // sdk.pendo.io.j7.d
    /* JADX INFO: renamed from: a, reason: from getter */
    public String getName() {
        return this.name;
    }

    @Override // sdk.pendo.io.j7.d
    /* JADX INFO: renamed from: b, reason: from getter */
    public String getValue() {
        return this.value;
    }
}
