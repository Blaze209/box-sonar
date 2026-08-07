package expo.modules.ui.convertibles;

import androidx.compose.foundation.layout.Arrangement;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: Arrangement.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0011"}, d2 = {"Lexpo/modules/ui/convertibles/VerticalArrangementDefault;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TOP", "BOTTOM", "CENTER", "SPACE_BETWEEN", "SPACE_AROUND", "SPACE_EVENLY", "toComposeArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum VerticalArrangementDefault implements Enumerable {
    TOP(ViewProps.TOP),
    BOTTOM(ViewProps.BOTTOM),
    CENTER(TtmlNode.CENTER),
    SPACE_BETWEEN("spaceBetween"),
    SPACE_AROUND("spaceAround"),
    SPACE_EVENLY("spaceEvenly");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: Arrangement.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VerticalArrangementDefault.values().length];
            try {
                iArr[VerticalArrangementDefault.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VerticalArrangementDefault.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VerticalArrangementDefault.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VerticalArrangementDefault.SPACE_BETWEEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VerticalArrangementDefault.SPACE_AROUND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[VerticalArrangementDefault.SPACE_EVENLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<VerticalArrangementDefault> getEntries() {
        return $ENTRIES;
    }

    VerticalArrangementDefault(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final Arrangement.Vertical toComposeArrangement() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return Arrangement.INSTANCE.getTop();
            case 2:
                return Arrangement.INSTANCE.getBottom();
            case 3:
                return Arrangement.INSTANCE.getCenter();
            case 4:
                return Arrangement.INSTANCE.getSpaceBetween();
            case 5:
                return Arrangement.INSTANCE.getSpaceAround();
            case 6:
                return Arrangement.INSTANCE.getSpaceEvenly();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
