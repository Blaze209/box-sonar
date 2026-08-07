package sdk.pendo.io.d7;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.apache.commons.codec.language.bm.Rule;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/d7/b;", "", "", "b", "spacingType", "I", "<init>", "(Ljava/lang/String;II)V", Rule.ALL, "LEFT", "TOP", "RIGHT", "BOTTOM", "START", "END", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public enum b {
    ALL(8),
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3),
    START(4),
    END(5);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(a());
    private final int spacingType;

    b(int i) {
        this.spacingType = i;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getSpacingType() {
        return this.spacingType;
    }
}
