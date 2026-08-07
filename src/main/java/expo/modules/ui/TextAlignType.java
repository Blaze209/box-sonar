package expo.modules.ui;

import androidx.compose.ui.text.style.TextAlign;
import androidx.media3.extractor.text.ttml.TtmlNode;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0013"}, d2 = {"Lexpo/modules/ui/TextAlignType;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LEFT", "RIGHT", "CENTER", "JUSTIFY", "START", "END", "toComposeTextAlign", "Landroidx/compose/ui/text/style/TextAlign;", "toComposeTextAlign-e0LSkKk", "()I", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum TextAlignType implements Enumerable {
    LEFT("left"),
    RIGHT("right"),
    CENTER(TtmlNode.CENTER),
    JUSTIFY("justify"),
    START("start"),
    END("end");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: TextView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextAlignType.values().length];
            try {
                iArr[TextAlignType.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextAlignType.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextAlignType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TextAlignType.JUSTIFY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TextAlignType.START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TextAlignType.END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<TextAlignType> getEntries() {
        return $ENTRIES;
    }

    TextAlignType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: toComposeTextAlign-e0LSkKk, reason: not valid java name */
    public final int m14675toComposeTextAligne0LSkKk() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return TextAlign.INSTANCE.m9529getLefte0LSkKk();
            case 2:
                return TextAlign.INSTANCE.m9530getRighte0LSkKk();
            case 3:
                return TextAlign.INSTANCE.m9526getCentere0LSkKk();
            case 4:
                return TextAlign.INSTANCE.m9528getJustifye0LSkKk();
            case 5:
                return TextAlign.INSTANCE.m9531getStarte0LSkKk();
            case 6:
                return TextAlign.INSTANCE.m9527getEnde0LSkKk();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
