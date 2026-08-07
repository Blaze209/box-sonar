package expo.modules.ui;

import androidx.compose.ui.text.font.FontWeight;
import com.microsoft.identity.common.java.marker.PerfConstants;
import expo.modules.kotlin.types.Enumerable;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0016"}, d2 = {"Lexpo/modules/ui/TextFontWeight;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NORMAL", "BOLD", "W100", "W200", "W300", "W400", "W500", "W600", "W700", "W800", "W900", "toComposeFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum TextFontWeight implements Enumerable {
    NORMAL(SemanticAttributes.MessagingRocketmqMessageTypeValues.NORMAL),
    BOLD("bold"),
    W100(PerfConstants.ScenarioConstants.SCENARIO_NON_BROKERED_ACQUIRE_TOKEN_SILENTLY),
    W200(PerfConstants.ScenarioConstants.SCENARIO_BROKERED_ACQUIRE_TOKEN_SILENTLY),
    W300(PerfConstants.ScenarioConstants.SCENARIO_GENERATE_AT_POP_ASYMMETRIC_KEYPAIR),
    W400("400"),
    W500("500"),
    W600("600"),
    W700("700"),
    W800("800"),
    W900("900");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String value;

    /* JADX INFO: compiled from: TextView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextFontWeight.values().length];
            try {
                iArr[TextFontWeight.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextFontWeight.BOLD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextFontWeight.W100.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TextFontWeight.W200.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TextFontWeight.W300.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TextFontWeight.W400.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TextFontWeight.W500.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TextFontWeight.W600.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TextFontWeight.W700.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[TextFontWeight.W800.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[TextFontWeight.W900.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<TextFontWeight> getEntries() {
        return $ENTRIES;
    }

    TextFontWeight(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final FontWeight toComposeFontWeight() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return FontWeight.INSTANCE.getNormal();
            case 2:
                return FontWeight.INSTANCE.getBold();
            case 3:
                return FontWeight.INSTANCE.getW100();
            case 4:
                return FontWeight.INSTANCE.getW200();
            case 5:
                return FontWeight.INSTANCE.getW300();
            case 6:
                return FontWeight.INSTANCE.getW400();
            case 7:
                return FontWeight.INSTANCE.getW500();
            case 8:
                return FontWeight.INSTANCE.getW600();
            case 9:
                return FontWeight.INSTANCE.getW700();
            case 10:
                return FontWeight.INSTANCE.getW800();
            case 11:
                return FontWeight.INSTANCE.getW900();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
