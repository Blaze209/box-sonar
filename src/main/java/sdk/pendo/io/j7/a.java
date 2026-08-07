package sdk.pendo.io.j7;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\b\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005¨\u0006\f"}, d2 = {"Lsdk/pendo/io/j7/a;", "Lsdk/pendo/io/j7/d;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "()Ljava/lang/String;", "name", "b", "value", "Lsdk/pendo/io/j7/a$a;", "<init>", "(Lsdk/pendo/io/j7/a$a;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String value;

    /* JADX INFO: renamed from: sdk.pendo.io.j7.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lsdk/pendo/io/j7/a$a;", "", "", "css", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "FLEX_START", "CENTER", "FLEX_END", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public enum EnumC0403a {
        FLEX_START("flex-start"),
        CENTER(TtmlNode.CENTER),
        FLEX_END("flex-end");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(a());
        private final String css;

        EnumC0403a(String str) {
            this.css = str;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getCss() {
            return this.css;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(EnumC0403a value) {
        super(null);
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = "align-items";
        this.value = value.getCss();
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
