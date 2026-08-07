package expo.modules.ui;

import androidx.compose.ui.text.style.TextOverflow;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0010"}, d2 = {"Lexpo/modules/ui/TextOverflowType;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CLIP", "ELLIPSIS", "VISIBLE", "toComposeTextOverflow", "Landroidx/compose/ui/text/style/TextOverflow;", "toComposeTextOverflow-gIe3tQ8", "()I", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum TextOverflowType implements Enumerable {
    CLIP("clip"),
    ELLIPSIS("ellipsis"),
    VISIBLE(ViewProps.VISIBLE);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: TextView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextOverflowType.values().length];
            try {
                iArr[TextOverflowType.CLIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextOverflowType.ELLIPSIS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextOverflowType.VISIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<TextOverflowType> getEntries() {
        return $ENTRIES;
    }

    TextOverflowType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: toComposeTextOverflow-gIe3tQ8, reason: not valid java name */
    public final int m14678toComposeTextOverflowgIe3tQ8() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return TextOverflow.INSTANCE.m9583getClipgIe3tQ8();
        }
        if (i == 2) {
            return TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8();
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return TextOverflow.INSTANCE.m9587getVisiblegIe3tQ8();
    }
}
