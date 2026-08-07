package expo.modules.ui.convertibles;

import androidx.compose.ui.Alignment;
import androidx.media3.extractor.text.ttml.TtmlNode;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: Alignment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0014"}, d2 = {"Lexpo/modules/ui/convertibles/ContentAlignment;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TOP_START", "TOP_CENTER", "TOP_END", "CENTER_START", "CENTER", "CENTER_END", "BOTTOM_START", "BOTTOM_CENTER", "BOTTOM_END", "toComposeAlignment", "Landroidx/compose/ui/Alignment;", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum ContentAlignment implements Enumerable {
    TOP_START("topStart"),
    TOP_CENTER("topCenter"),
    TOP_END("topEnd"),
    CENTER_START("centerStart"),
    CENTER(TtmlNode.CENTER),
    CENTER_END("centerEnd"),
    BOTTOM_START("bottomStart"),
    BOTTOM_CENTER("bottomCenter"),
    BOTTOM_END("bottomEnd");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: Alignment.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ContentAlignment.values().length];
            try {
                iArr[ContentAlignment.TOP_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContentAlignment.TOP_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ContentAlignment.TOP_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ContentAlignment.CENTER_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ContentAlignment.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ContentAlignment.CENTER_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ContentAlignment.BOTTOM_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ContentAlignment.BOTTOM_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ContentAlignment.BOTTOM_END.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<ContentAlignment> getEntries() {
        return $ENTRIES;
    }

    ContentAlignment(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final Alignment toComposeAlignment() {
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
                throw new NoWhenBranchMatchedException();
        }
    }
}
