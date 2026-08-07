package expo.modules.ui;

import androidx.compose.ui.text.style.TextDecoration;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Lexpo/modules/ui/TextDecorationType;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NONE", "UNDERLINE", "LINE_THROUGH", "toComposeTextDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum TextDecorationType implements Enumerable {
    NONE("none"),
    UNDERLINE("underline"),
    LINE_THROUGH("lineThrough");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: TextView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextDecorationType.values().length];
            try {
                iArr[TextDecorationType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextDecorationType.UNDERLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextDecorationType.LINE_THROUGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<TextDecorationType> getEntries() {
        return $ENTRIES;
    }

    TextDecorationType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final TextDecoration toComposeTextDecoration() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return TextDecoration.INSTANCE.getNone();
        }
        if (i == 2) {
            return TextDecoration.INSTANCE.getUnderline();
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return TextDecoration.INSTANCE.getLineThrough();
    }
}
