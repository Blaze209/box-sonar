package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TransitionScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019BU\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rR\u0014\u0010\f\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u000b\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001a"}, d2 = {"Landroidx/constraintlayout/compose/SwipeMode;", "", "name", "", "springMass", "", "springStiffness", "springDamping", "springThreshold", "springBoundary", "Landroidx/constraintlayout/compose/SpringBoundary;", "maxVelocity", "maxAcceleration", "(Ljava/lang/String;FFFFLandroidx/constraintlayout/compose/SpringBoundary;FF)V", "getMaxAcceleration$constraintlayout_compose_release", "()F", "getMaxVelocity$constraintlayout_compose_release", "getName", "()Ljava/lang/String;", "getSpringBoundary$constraintlayout_compose_release", "()Landroidx/constraintlayout/compose/SpringBoundary;", "getSpringDamping$constraintlayout_compose_release", "getSpringMass$constraintlayout_compose_release", "getSpringStiffness$constraintlayout_compose_release", "getSpringThreshold$constraintlayout_compose_release", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeMode {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final SwipeMode Spring;
    private static final SwipeMode Velocity;
    private final float maxAcceleration;
    private final float maxVelocity;
    private final String name;
    private final SpringBoundary springBoundary;
    private final float springDamping;
    private final float springMass;
    private final float springStiffness;
    private final float springThreshold;

    public SwipeMode(String str, float f, float f2, float f3, float f4, SpringBoundary springBoundary, float f5, float f6) {
        this.name = str;
        this.springMass = f;
        this.springStiffness = f2;
        this.springDamping = f3;
        this.springThreshold = f4;
        this.springBoundary = springBoundary;
        this.maxVelocity = f5;
        this.maxAcceleration = f6;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: getSpringMass$constraintlayout_compose_release, reason: from getter */
    public final float getSpringMass() {
        return this.springMass;
    }

    /* JADX INFO: renamed from: getSpringStiffness$constraintlayout_compose_release, reason: from getter */
    public final float getSpringStiffness() {
        return this.springStiffness;
    }

    /* JADX INFO: renamed from: getSpringDamping$constraintlayout_compose_release, reason: from getter */
    public final float getSpringDamping() {
        return this.springDamping;
    }

    /* JADX INFO: renamed from: getSpringThreshold$constraintlayout_compose_release, reason: from getter */
    public final float getSpringThreshold() {
        return this.springThreshold;
    }

    public /* synthetic */ SwipeMode(String str, float f, float f2, float f3, float f4, SpringBoundary springBoundary, float f5, float f6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 1.0f : f, (i & 4) != 0 ? 400.0f : f2, (i & 8) != 0 ? 10.0f : f3, (i & 16) != 0 ? 0.01f : f4, (i & 32) != 0 ? SpringBoundary.INSTANCE.getOvershoot() : springBoundary, (i & 64) != 0 ? 4.0f : f5, (i & 128) != 0 ? 1.2f : f6);
    }

    /* JADX INFO: renamed from: getSpringBoundary$constraintlayout_compose_release, reason: from getter */
    public final SpringBoundary getSpringBoundary() {
        return this.springBoundary;
    }

    /* JADX INFO: renamed from: getMaxVelocity$constraintlayout_compose_release, reason: from getter */
    public final float getMaxVelocity() {
        return this.maxVelocity;
    }

    /* JADX INFO: renamed from: getMaxAcceleration$constraintlayout_compose_release, reason: from getter */
    public final float getMaxAcceleration() {
        return this.maxAcceleration;
    }

    /* JADX INFO: compiled from: TransitionScope.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0014"}, d2 = {"Landroidx/constraintlayout/compose/SwipeMode$Companion;", "", "()V", "Spring", "Landroidx/constraintlayout/compose/SwipeMode;", "getSpring", "()Landroidx/constraintlayout/compose/SwipeMode;", "Velocity", "getVelocity", "spring", "mass", "", "stiffness", "damping", "threshold", "boundary", "Landroidx/constraintlayout/compose/SpringBoundary;", "velocity", "maxVelocity", "maxAcceleration", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SwipeMode getVelocity() {
            return SwipeMode.Velocity;
        }

        public final SwipeMode getSpring() {
            return SwipeMode.Spring;
        }

        public static /* synthetic */ SwipeMode velocity$default(Companion companion, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = 4.0f;
            }
            if ((i & 2) != 0) {
                f2 = 1.2f;
            }
            return companion.velocity(f, f2);
        }

        public final SwipeMode velocity(float maxVelocity, float maxAcceleration) {
            return new SwipeMode("velocity", 0.0f, 0.0f, 0.0f, 0.0f, null, maxVelocity, maxAcceleration, 62, null);
        }

        public static /* synthetic */ SwipeMode spring$default(Companion companion, float f, float f2, float f3, float f4, SpringBoundary springBoundary, int i, Object obj) {
            if ((i & 1) != 0) {
                f = 1.0f;
            }
            if ((i & 2) != 0) {
                f2 = 400.0f;
            }
            if ((i & 4) != 0) {
                f3 = 10.0f;
            }
            if ((i & 8) != 0) {
                f4 = 0.01f;
            }
            if ((i & 16) != 0) {
                springBoundary = SpringBoundary.INSTANCE.getOvershoot();
            }
            SpringBoundary springBoundary2 = springBoundary;
            float f5 = f3;
            return companion.spring(f, f2, f5, f4, springBoundary2);
        }

        public final SwipeMode spring(float mass, float stiffness, float damping, float threshold, SpringBoundary boundary) {
            return new SwipeMode("spring", mass, stiffness, damping, threshold, boundary, 0.0f, 0.0f, 192, null);
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        Velocity = Companion.velocity$default(companion, 0.0f, 0.0f, 3, null);
        Spring = Companion.spring$default(companion, 0.0f, 0.0f, 0.0f, 0.0f, null, 31, null);
    }
}
