package expo.modules.ui.convertibles;

import androidx.compose.ui.Alignment;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: Alignment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u001e"}, d2 = {"Lexpo/modules/ui/convertibles/AlignmentType;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TOP_START", "TOP_CENTER", "TOP_END", "CENTER_START", "CENTER", "CENTER_END", "BOTTOM_START", "BOTTOM_CENTER", "BOTTOM_END", "TOP", "CENTER_VERTICALLY", "BOTTOM", "START", "CENTER_HORIZONTALLY", "END", "toAlignment", "Landroidx/compose/ui/Alignment;", "toVerticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "toHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum AlignmentType implements Enumerable {
    TOP_START("topStart"),
    TOP_CENTER("topCenter"),
    TOP_END("topEnd"),
    CENTER_START("centerStart"),
    CENTER(TtmlNode.CENTER),
    CENTER_END("centerEnd"),
    BOTTOM_START("bottomStart"),
    BOTTOM_CENTER("bottomCenter"),
    BOTTOM_END("bottomEnd"),
    TOP(ViewProps.TOP),
    CENTER_VERTICALLY("centerVertically"),
    BOTTOM(ViewProps.BOTTOM),
    START("start"),
    CENTER_HORIZONTALLY("centerHorizontally"),
    END("end");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: Alignment.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AlignmentType.values().length];
            try {
                iArr[AlignmentType.TOP_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AlignmentType.TOP_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AlignmentType.TOP_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AlignmentType.CENTER_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AlignmentType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AlignmentType.CENTER_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AlignmentType.BOTTOM_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AlignmentType.BOTTOM_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AlignmentType.BOTTOM_END.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AlignmentType.TOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AlignmentType.CENTER_VERTICALLY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[AlignmentType.BOTTOM.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[AlignmentType.START.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[AlignmentType.CENTER_HORIZONTALLY.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[AlignmentType.END.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<AlignmentType> getEntries() {
        return $ENTRIES;
    }

    AlignmentType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final Alignment toAlignment() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return Alignment.INSTANCE.getTopStart();
            case 2:
                return Alignment.INSTANCE.getTopCenter();
            case 3:
                return Alignment.INSTANCE.getTopEnd();
            case 4:
                return Alignment.INSTANCE.getCenterStart();
            case 5:
                return Alignment.INSTANCE.getCenter();
            case 6:
                return Alignment.INSTANCE.getCenterEnd();
            case 7:
                return Alignment.INSTANCE.getBottomStart();
            case 8:
                return Alignment.INSTANCE.getBottomCenter();
            case 9:
                return Alignment.INSTANCE.getBottomEnd();
            default:
                return null;
        }
    }

    public final Alignment.Vertical toVerticalAlignment() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 10:
                return Alignment.INSTANCE.getTop();
            case 11:
                return Alignment.INSTANCE.getCenterVertically();
            case 12:
                return Alignment.INSTANCE.getBottom();
            default:
                return null;
        }
    }

    public final Alignment.Horizontal toHorizontalAlignment() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 13:
                return Alignment.INSTANCE.getStart();
            case 14:
                return Alignment.INSTANCE.getCenterHorizontally();
            case 15:
                return Alignment.INSTANCE.getEnd();
            default:
                return null;
        }
    }
}
