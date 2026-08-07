package sdk.pendo.io.h7;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/h7/x;", "", "", "value", "I", "b", "()I", "<init>", "(Ljava/lang/String;II)V", "FULL_SNAPSHOT", "INCREMENTAL_SNAPSHOT", "META_DATA", "TOUCH_START", "TOUCH_END", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public enum x {
    FULL_SNAPSHOT(2),
    INCREMENTAL_SNAPSHOT(3),
    META_DATA(4),
    TOUCH_START(7),
    TOUCH_END(9);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(a());
    private final int value;

    x(int i) {
        this.value = i;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getValue() {
        return this.value;
    }
}
