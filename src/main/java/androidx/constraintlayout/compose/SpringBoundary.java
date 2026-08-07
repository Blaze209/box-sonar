package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TransitionScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/constraintlayout/compose/SpringBoundary;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SpringBoundary {
    public static final int $stable = 0;
    private final String name;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SpringBoundary Overshoot = new SpringBoundary("overshoot");
    private static final SpringBoundary BounceStart = new SpringBoundary("bounceStart");
    private static final SpringBoundary BounceEnd = new SpringBoundary("bounceEnd");
    private static final SpringBoundary BounceBoth = new SpringBoundary("bounceBoth");

    public SpringBoundary(String str) {
        this.name = str;
    }

    /* JADX INFO: compiled from: TransitionScope.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Landroidx/constraintlayout/compose/SpringBoundary$Companion;", "", "()V", "BounceBoth", "Landroidx/constraintlayout/compose/SpringBoundary;", "getBounceBoth", "()Landroidx/constraintlayout/compose/SpringBoundary;", "BounceEnd", "getBounceEnd", "BounceStart", "getBounceStart", "Overshoot", "getOvershoot", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SpringBoundary getOvershoot() {
            return SpringBoundary.Overshoot;
        }

        public final SpringBoundary getBounceStart() {
            return SpringBoundary.BounceStart;
        }

        public final SpringBoundary getBounceEnd() {
            return SpringBoundary.BounceEnd;
        }

        public final SpringBoundary getBounceBoth() {
            return SpringBoundary.BounceBoth;
        }
    }

    public final String getName() {
        return this.name;
    }
}
