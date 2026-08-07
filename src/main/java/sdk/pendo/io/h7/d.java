package sdk.pendo.io.h7;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/h7/d;", "", "", "cssName", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "NORMAL", "ITALIC", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public enum d {
    NORMAL(SemanticAttributes.MessagingRocketmqMessageTypeValues.NORMAL),
    ITALIC("italic");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(a());
    private final String cssName;

    d(String str) {
        this.cssName = str;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getCssName() {
        return this.cssName;
    }
}
