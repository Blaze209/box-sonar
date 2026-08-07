package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: SharedElement.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0018\u001a\u00020\u0019J\r\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\b J\u0017\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0000¢\u0006\u0004\b%\u0010&J\u0006\u0010+\u001a\u00020\u001fJ\b\u0010,\u001a\u0004\u0018\u00010-J\u0006\u0010.\u001a\u00020\u001fJ\u0016\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u0002062\u0006\u0010\r\u001a\u00020\u0013J\u000e\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\u0013J\u000e\u0010>\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010/\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b3\u00101R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u001308X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020\u001308X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001f0(X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010*¨\u0006?"}, d2 = {"Landroidx/compose/animation/SharedElement;", "", "key", "scope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "getKey", "()Ljava/lang/Object;", "getScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "stateMachine", "Landroidx/compose/animation/SharedTransitionStateMachine;", "state", "Landroidx/compose/animation/SharedTransitionStateMachine$State;", "getState$animation", "()Landroidx/compose/animation/SharedTransitionStateMachine$State;", "enabledEntries", "", "Landroidx/compose/animation/SharedElementEntry;", "getEnabledEntries", "()Ljava/util/List;", "allEntries", "getAllEntries", "isAnimating", "", "momentumAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/animation/core/AnimationVector2D;", "updateMatch", "", "updateMatch$animation", "animationSpecFinalized", "updateExitVelocity", "velocity", "Landroidx/compose/ui/unit/Velocity;", "updateExitVelocity-TH1AsA0$animation", "(J)V", "momentumAnimationOffset", "Lkotlin/Function0;", "getMomentumAnimationOffset", "()Lkotlin/jvm/functions/Function0;", "invalidateTargetBoundsProvider", "tryInitializingCurrentBounds", "Landroidx/compose/ui/geometry/Rect;", "onSharedTransitionFinished", "foundMatch", "getFoundMatch", "()Z", "boundsTransformIsActive", "getBoundsTransformIsActive", "onLookaheadPlaced", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "_allEntries", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "_enabledEntries", "observingVisibilityChange", "getObservingVisibilityChange$animation", "addEntry", "sharedElementState", "removeEntry", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SharedElement {
    public static final int $stable = 8;
    private boolean animationSpecFinalized;
    private final Object key;
    private final SharedTransitionScopeImpl scope;
    private final SharedTransitionStateMachine stateMachine = new SharedTransitionStateMachine(this);
    private final Animatable<Offset, AnimationVector2D> momentumAnimation = new Animatable<>(Offset.m6558boximpl(Offset.INSTANCE.m6585getZeroF1C5BW0()), VectorConvertersKt.getVectorConverter(Offset.INSTANCE), null, null, 12, null);
    private final Function0<Offset> momentumAnimationOffset = new Function0<Offset>() { // from class: androidx.compose.animation.SharedElement$momentumAnimationOffset$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Offset invoke() {
            return Offset.m6558boximpl(m424invokeF1C5BW0());
        }

        /* JADX INFO: renamed from: invoke-F1C5BW0, reason: not valid java name */
        public final long m424invokeF1C5BW0() {
            SharedElementEntry sharedElementEntry;
            if (!this.this$0.animationSpecFinalized && this.this$0.getScope().isTransitionActive() && this.this$0.momentumAnimation.isRunning()) {
                List<SharedElementEntry> enabledEntries = this.this$0.getEnabledEntries();
                int size = enabledEntries.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        sharedElementEntry = null;
                        break;
                    }
                    sharedElementEntry = enabledEntries.get(i);
                    if (sharedElementEntry.getTarget()) {
                        break;
                    }
                    i++;
                }
                SharedElementEntry sharedElementEntry2 = sharedElementEntry;
                if (sharedElementEntry2 != null) {
                    SharedElement sharedElement = this.this$0;
                    FiniteAnimationSpec<Rect> animationSpec = sharedElementEntry2.getBoundsAnimation().getAnimationSpec();
                    if (animationSpec instanceof SpringSpec) {
                        SpringSpec springSpec = (SpringSpec) animationSpec;
                        BuildersKt__Builders_commonKt.launch$default(sharedElement.getScope().getCoroutineScope(), null, null, new SharedElement$momentumAnimationOffset$1$2$1(sharedElement, AnimationSpecKt.spring(springSpec.getDampingRatio(), springSpec.getStiffness(), Offset.m6558boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.INSTANCE))), null), 3, null);
                    }
                    sharedElement.animationSpecFinalized = true;
                }
            }
            return ((Offset) this.this$0.momentumAnimation.getValue()).m6579unboximpl();
        }
    };
    private final SnapshotStateList<SharedElementEntry> _allEntries = SnapshotStateKt.mutableStateListOf();
    private final SnapshotStateList<SharedElementEntry> _enabledEntries = SnapshotStateKt.mutableStateListOf();
    private final Function0<Unit> observingVisibilityChange = new Function0<Unit>() { // from class: androidx.compose.animation.SharedElement$observingVisibilityChange$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            List<SharedElementEntry> allEntries = this.this$0.getAllEntries();
            int size = allEntries.size();
            for (int i = 0; i < size; i++) {
                SharedElementEntry sharedElementEntry = allEntries.get(i);
                if (sharedElementEntry.getTarget() && sharedElementEntry.isEnabled()) {
                    return;
                }
            }
        }
    };

    public SharedElement(Object obj, SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        this.key = obj;
        this.scope = sharedTransitionScopeImpl;
    }

    public final Object getKey() {
        return this.key;
    }

    public final SharedTransitionScopeImpl getScope() {
        return this.scope;
    }

    public final SharedTransitionStateMachine.State getState$animation() {
        return this.stateMachine.getState();
    }

    public final List<SharedElementEntry> getEnabledEntries() {
        return this._enabledEntries;
    }

    public final List<SharedElementEntry> getAllEntries() {
        return this._allEntries;
    }

    public final boolean isAnimating() {
        List<SharedElementEntry> enabledEntries = getEnabledEntries();
        int size = enabledEntries.size();
        for (int i = 0; i < size; i++) {
            if (enabledEntries.get(i).getBoundsAnimation().isRunning()) {
                return true;
            }
        }
        return false;
    }

    public final void updateMatch$animation() {
        Function0<Unit> testBlockToRun = this.scope.getTestBlockToRun();
        if (testBlockToRun != null) {
            testBlockToRun.invoke();
        }
        CollectionsKt.removeAll((List) this._enabledEntries, (Function1) new Function1<SharedElementEntry, Boolean>() { // from class: androidx.compose.animation.SharedElement$updateMatch$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SharedElementEntry sharedElementEntry) {
                return Boolean.valueOf((this.this$0.getAllEntries().contains(sharedElementEntry) && sharedElementEntry.isEnabled()) ? false : true);
            }
        });
        List<SharedElementEntry> allEntries = getAllEntries();
        int size = allEntries.size();
        for (int i = 0; i < size; i++) {
            SharedElementEntry sharedElementEntry = allEntries.get(i);
            if (sharedElementEntry.isEnabled() && !getEnabledEntries().contains(sharedElementEntry)) {
                this._enabledEntries.add(sharedElementEntry);
            }
        }
        this.stateMachine.checkForAndDeferStateUpdates(SharedElementKt.hasVisibleContent(this._enabledEntries));
    }

    /* JADX INFO: renamed from: updateExitVelocity-TH1AsA0$animation, reason: not valid java name */
    public final void m423updateExitVelocityTH1AsA0$animation(long velocity) {
        BuildersKt__Builders_commonKt.launch$default(this.scope.getCoroutineScope(), null, null, new SharedElement$updateExitVelocity$1(this, velocity, null), 3, null);
    }

    public final Function0<Offset> getMomentumAnimationOffset() {
        return this.momentumAnimationOffset;
    }

    public final void invalidateTargetBoundsProvider() {
        this.stateMachine.invalidateTargetBoundsProvider();
    }

    public final Rect tryInitializingCurrentBounds() {
        return this.stateMachine.tryInitializingCurrentBounds();
    }

    public final void onSharedTransitionFinished() {
        if (getEnabledEntries().size() <= 1 || !SharedElementKt.hasVisibleContent(getEnabledEntries())) {
            this.stateMachine.resetState();
        }
    }

    public final boolean getFoundMatch() {
        return getState$animation().getActiveMatchFound() || getState$animation().getMatchIsOrHasBeenConfigured() || this.stateMachine.getActiveMatchDeferred();
    }

    public final boolean getBoundsTransformIsActive() {
        return getState$animation().getMatchIsOrHasBeenConfigured();
    }

    public final void onLookaheadPlaced(Placeable.PlacementScope placementScope, SharedElementEntry state) {
        LayoutCoordinates coordinates;
        this.stateMachine.processPendingRequest();
        if (Intrinsics.areEqual(getState$animation(), NoMatchFound.INSTANCE) || !state.isEnabled()) {
            return;
        }
        SharedTransitionStateMachine.State state$animation = getState$animation();
        if (state.getBoundsAnimation().getTarget() && state$animation.getActiveMatchFound() && (coordinates = placementScope.getCoordinates()) != null) {
            long jM9870toSizeozmzZPI = IntSizeKt.m9870toSizeozmzZPI(coordinates.mo8273getSizeYbymL2g());
            long jM8295localLookaheadPositionOfauaQtc$default = LookaheadScope.m8295localLookaheadPositionOfauaQtc$default(state.getSharedElement().scope, state.getSharedElement().scope.getLookaheadRoot$animation(), coordinates, 0L, false, 6, null);
            SharedTransitionScopeImpl sharedTransitionScopeImpl = state.getSharedElement().scope;
            this.stateMachine.m432configureActiveMatchL7TYDSY(jM9870toSizeozmzZPI, jM8295localLookaheadPositionOfauaQtc$default, LayoutCoordinates.m8272localPositionOfS_NoaFU$default(state.getSharedElement().scope.getLookaheadRoot$animation(), coordinates, 0L, false, 2, null));
        }
    }

    public final Function0<Unit> getObservingVisibilityChange$animation() {
        return this.observingVisibilityChange;
    }

    public final void addEntry(SharedElementEntry sharedElementState) {
        this._allEntries.add(sharedElementState);
        updateMatch$animation();
    }

    public final void removeEntry(SharedElementEntry sharedElementState) {
        this._allEntries.remove(sharedElementState);
        this._enabledEntries.remove(sharedElementState);
        updateMatch$animation();
    }
}
