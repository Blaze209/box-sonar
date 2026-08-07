package expo.modules.ui;

import androidx.compose.ui.text.font.FontStyle;
import expo.modules.kotlin.types.Enumerable;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000f"}, d2 = {"Lexpo/modules/ui/TextFontStyle;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NORMAL", "ITALIC", "toComposeFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "toComposeFontStyle-_-LCdwA", "()I", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum TextFontStyle implements Enumerable {
    NORMAL(SemanticAttributes.MessagingRocketmqMessageTypeValues.NORMAL),
    ITALIC("italic");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: TextView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextFontStyle.values().length];
            try {
                iArr[TextFontStyle.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextFontStyle.ITALIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<TextFontStyle> getEntries() {
        return $ENTRIES;
    }

    TextFontStyle(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: toComposeFontStyle-_-LCdwA, reason: not valid java name */
    public final int m14677toComposeFontStyle_LCdwA() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return FontStyle.INSTANCE.m9212getNormal_LCdwA();
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return FontStyle.INSTANCE.m9211getItalic_LCdwA();
    }
}
