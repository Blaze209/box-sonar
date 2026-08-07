package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MotionLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\\\u0012E\b\u0002\u0010\u0002\u001a?\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\u0002\b\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010\u000fRN\u0010\u0002\u001a?\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\u0002\b\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/constraintlayout/compose/InvalidationStrategy;", "", "onIncomingConstraints", "Lkotlin/Function3;", "Landroidx/constraintlayout/compose/InvalidationStrategySpecification;", "Landroidx/compose/ui/unit/Constraints;", "Lkotlin/ParameterName;", "name", "old", "new", "", "Lkotlin/ExtensionFunctionType;", "onObservedStateChange", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "getOnIncomingConstraints", "()Lkotlin/jvm/functions/Function3;", "getOnObservedStateChange", "()Lkotlin/jvm/functions/Function0;", "scope", "shouldInvalidate", "Landroidx/constraintlayout/compose/ShouldInvalidateCallback;", "getShouldInvalidate$constraintlayout_compose_release", "()Landroidx/constraintlayout/compose/ShouldInvalidateCallback;", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InvalidationStrategy {
    private final Function3<InvalidationStrategySpecification, Constraints, Constraints, Boolean> onIncomingConstraints;
    private final Function0<Unit> onObservedStateChange;
    private final InvalidationStrategySpecification scope;
    private final ShouldInvalidateCallback shouldInvalidate;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final InvalidationStrategy DefaultInvalidationStrategy = new InvalidationStrategy(null, null);

    /* JADX WARN: Multi-variable type inference failed */
    public InvalidationStrategy(Function3<? super InvalidationStrategySpecification, ? super Constraints, ? super Constraints, Boolean> function3, Function0<Unit> function0) {
        this.onIncomingConstraints = function3;
        this.onObservedStateChange = function0;
        this.scope = new InvalidationStrategySpecification();
        this.shouldInvalidate = function3 == 0 ? null : new ShouldInvalidateCallback() { // from class: androidx.constraintlayout.compose.InvalidationStrategy$shouldInvalidate$1$1
            @Override // androidx.constraintlayout.compose.ShouldInvalidateCallback
            /* JADX INFO: renamed from: invoke-N9IONVI, reason: not valid java name */
            public final boolean mo10068invokeN9IONVI(long j, long j2) {
                return this.this$0.getOnIncomingConstraints().invoke(this.this$0.scope, Constraints.m9627boximpl(j), Constraints.m9627boximpl(j2)).booleanValue();
            }
        };
    }

    public /* synthetic */ InvalidationStrategy(Function3 function3, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function3, function0);
    }

    public final Function3<InvalidationStrategySpecification, Constraints, Constraints, Boolean> getOnIncomingConstraints() {
        return this.onIncomingConstraints;
    }

    public final Function0<Unit> getOnObservedStateChange() {
        return this.onObservedStateChange;
    }

    /* JADX INFO: renamed from: getShouldInvalidate$constraintlayout_compose_release, reason: from getter */
    public final ShouldInvalidateCallback getShouldInvalidate() {
        return this.shouldInvalidate;
    }

    /* JADX INFO: compiled from: MotionLayout.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/constraintlayout/compose/InvalidationStrategy$Companion;", "", "()V", "DefaultInvalidationStrategy", "Landroidx/constraintlayout/compose/InvalidationStrategy;", "getDefaultInvalidationStrategy", "()Landroidx/constraintlayout/compose/InvalidationStrategy;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InvalidationStrategy getDefaultInvalidationStrategy() {
            return InvalidationStrategy.DefaultInvalidationStrategy;
        }
    }
}
