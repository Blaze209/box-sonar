package expo.modules.ui;

import androidx.media3.extractor.text.ttml.TtmlNode;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ShapeView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lexpo/modules/ui/ShapeType;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "STAR", "PILL_STAR", "PILL", "CIRCLE", "RECTANGLE", "POLYGON", "ROUNDED_CORNER", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum ShapeType implements Enumerable {
    STAR("star"),
    PILL_STAR("pillStar"),
    PILL("pill"),
    CIRCLE(TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE),
    RECTANGLE("rectangle"),
    POLYGON("polygon"),
    ROUNDED_CORNER("roundedCorner");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    public static EnumEntries<ShapeType> getEntries() {
        return $ENTRIES;
    }

    ShapeType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
