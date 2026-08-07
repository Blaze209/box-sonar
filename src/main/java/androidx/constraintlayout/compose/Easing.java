package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TransitionScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/constraintlayout/compose/Easing;", "Landroidx/constraintlayout/compose/NamedPropertyOrValue;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Easing implements NamedPropertyOrValue {
    public static final int $stable = 0;
    private final String name;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Easing Standard = new Easing("standard");
    private static final Easing Accelerate = new Easing("accelerate");
    private static final Easing Decelerate = new Easing("decelerate");
    private static final Easing Linear = new Easing("linear");
    private static final Easing Anticipate = new Easing("anticipate");
    private static final Easing Overshoot = new Easing("overshoot");

    public Easing(String str) {
        this.name = str;
    }

    /* JADX INFO: compiled from: TransitionScope.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0017"}, d2 = {"Landroidx/constraintlayout/compose/Easing$Companion;", "", "()V", "Accelerate", "Landroidx/constraintlayout/compose/Easing;", "getAccelerate", "()Landroidx/constraintlayout/compose/Easing;", "Anticipate", "getAnticipate", "Decelerate", "getDecelerate", "Linear", "getLinear", "Overshoot", "getOvershoot", "Standard", "getStandard", "cubic", "x1", "", "y1", "x2", "y2", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Easing getStandard() {
            return Easing.Standard;
        }

        public final Easing getAccelerate() {
            return Easing.Accelerate;
        }

        public final Easing getDecelerate() {
            return Easing.Decelerate;
        }

        public final Easing getLinear() {
            return Easing.Linear;
        }

        public final Easing getAnticipate() {
            return Easing.Anticipate;
        }

        public final Easing getOvershoot() {
            return Easing.Overshoot;
        }

        public final Easing cubic(float x1, float y1, float x2, float y2) {
            return new Easing("cubic(" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + ')');
        }
    }

    @Override // androidx.constraintlayout.compose.NamedPropertyOrValue
    public String getName() {
        return this.name;
    }
}
