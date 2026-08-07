package expo.modules.ui;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.TextStyle;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001aR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u001b"}, d2 = {"Lexpo/modules/ui/TypographyStyle;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DISPLAY_LARGE", "DISPLAY_MEDIUM", "DISPLAY_SMALL", "HEADLINE_LARGE", "HEADLINE_MEDIUM", "HEADLINE_SMALL", "TITLE_LARGE", "TITLE_MEDIUM", "TITLE_SMALL", "BODY_LARGE", "BODY_MEDIUM", "BODY_SMALL", "LABEL_LARGE", "LABEL_MEDIUM", "LABEL_SMALL", "toTextStyle", "Landroidx/compose/ui/text/TextStyle;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum TypographyStyle implements Enumerable {
    DISPLAY_LARGE("displayLarge"),
    DISPLAY_MEDIUM("displayMedium"),
    DISPLAY_SMALL("displaySmall"),
    HEADLINE_LARGE("headlineLarge"),
    HEADLINE_MEDIUM("headlineMedium"),
    HEADLINE_SMALL("headlineSmall"),
    TITLE_LARGE("titleLarge"),
    TITLE_MEDIUM("titleMedium"),
    TITLE_SMALL("titleSmall"),
    BODY_LARGE("bodyLarge"),
    BODY_MEDIUM("bodyMedium"),
    BODY_SMALL("bodySmall"),
    LABEL_LARGE("labelLarge"),
    LABEL_MEDIUM("labelMedium"),
    LABEL_SMALL("labelSmall");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: TextView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TypographyStyle.values().length];
            try {
                iArr[TypographyStyle.DISPLAY_LARGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TypographyStyle.DISPLAY_MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TypographyStyle.DISPLAY_SMALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TypographyStyle.HEADLINE_LARGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TypographyStyle.HEADLINE_MEDIUM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TypographyStyle.HEADLINE_SMALL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TypographyStyle.TITLE_LARGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TypographyStyle.TITLE_MEDIUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TypographyStyle.TITLE_SMALL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[TypographyStyle.BODY_LARGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[TypographyStyle.BODY_MEDIUM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[TypographyStyle.BODY_SMALL.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[TypographyStyle.LABEL_LARGE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[TypographyStyle.LABEL_MEDIUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[TypographyStyle.LABEL_SMALL.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<TypographyStyle> getEntries() {
        return $ENTRIES;
    }

    TypographyStyle(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final TextStyle toTextStyle(Composer composer, int i) {
        TextStyle displayLarge;
        composer.startReplaceGroup(1469993686);
        ComposerKt.sourceInformation(composer, "C(toTextStyle)126@3266L10:TextView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1469993686, i, -1, "expo.modules.ui.TypographyStyle.toTextStyle (TextView.kt:125)");
        }
        Typography typography = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable);
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                displayLarge = typography.getDisplayLarge();
                break;
            case 2:
                displayLarge = typography.getDisplayMedium();
                break;
            case 3:
                displayLarge = typography.getDisplaySmall();
                break;
            case 4:
                displayLarge = typography.getHeadlineLarge();
                break;
            case 5:
                displayLarge = typography.getHeadlineMedium();
                break;
            case 6:
                displayLarge = typography.getHeadlineSmall();
                break;
            case 7:
                displayLarge = typography.getTitleLarge();
                break;
            case 8:
                displayLarge = typography.getTitleMedium();
                break;
            case 9:
                displayLarge = typography.getTitleSmall();
                break;
            case 10:
                displayLarge = typography.getBodyLarge();
                break;
            case 11:
                displayLarge = typography.getBodyMedium();
                break;
            case 12:
                displayLarge = typography.getBodySmall();
                break;
            case 13:
                displayLarge = typography.getLabelLarge();
                break;
            case 14:
                displayLarge = typography.getLabelMedium();
                break;
            case 15:
                displayLarge = typography.getLabelSmall();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return displayLarge;
    }
}
