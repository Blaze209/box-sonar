package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ConstraintLayoutBaseScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001b\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/constraintlayout/compose/ChainStyle;", "", "name", "", "bias", "", "(Ljava/lang/String;Ljava/lang/Float;)V", "getBias$constraintlayout_compose_release", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getName$constraintlayout_compose_release", "()Ljava/lang/String;", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChainStyle {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final ChainStyle Packed;
    private static final ChainStyle Spread;
    private static final ChainStyle SpreadInside;
    private final Float bias;
    private final String name;

    public ChainStyle(String str, Float f) {
        this.name = str;
        this.bias = f;
    }

    /* JADX INFO: compiled from: ConstraintLayoutBaseScope.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007¨\u0006\u0010"}, d2 = {"Landroidx/constraintlayout/compose/ChainStyle$Companion;", "", "()V", "Packed", "Landroidx/constraintlayout/compose/ChainStyle;", "getPacked$annotations", "getPacked", "()Landroidx/constraintlayout/compose/ChainStyle;", "Spread", "getSpread$annotations", "getSpread", "SpreadInside", "getSpreadInside$annotations", "getSpreadInside", "bias", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPacked$annotations() {
        }

        public static /* synthetic */ void getSpread$annotations() {
        }

        public static /* synthetic */ void getSpreadInside$annotations() {
        }

        private Companion() {
        }

        public final ChainStyle getSpread() {
            return ChainStyle.Spread;
        }

        public final ChainStyle getSpreadInside() {
            return ChainStyle.SpreadInside;
        }

        public final ChainStyle getPacked() {
            return ChainStyle.Packed;
        }

        public final ChainStyle Packed(float bias) {
            return new ChainStyle("packed", Float.valueOf(bias));
        }
    }

    public /* synthetic */ ChainStyle(String str, Float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : f);
    }

    /* JADX INFO: renamed from: getBias$constraintlayout_compose_release, reason: from getter */
    public final Float getBias() {
        return this.bias;
    }

    /* JADX INFO: renamed from: getName$constraintlayout_compose_release, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        int i = 2;
        Spread = new ChainStyle("spread", 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        SpreadInside = new ChainStyle("spread_inside", 0 == true ? 1 : 0, i, 0 == true ? 1 : 0);
        Packed = companion.Packed(0.5f);
    }
}
