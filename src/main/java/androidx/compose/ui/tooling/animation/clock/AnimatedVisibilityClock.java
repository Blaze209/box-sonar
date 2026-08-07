package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.compose.ui.tooling.animation.AnimatedVisibilityComposeAnimation;
import androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState;
import androidx.compose.ui.tooling.animation.states.ComposeAnimationState;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatedVisibilityClock.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001cH\u0016J\u001f\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\"*\u00020\u0003H\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@VX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/compose/ui/tooling/animation/clock/AnimatedVisibilityClock;", "Landroidx/compose/ui/tooling/animation/clock/ComposeAnimationClock;", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "Landroidx/compose/ui/tooling/animation/states/AnimatedVisibilityState;", "animation", "<init>", "(Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;)V", "getAnimation", "()Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "value", "state", "getState-jXw82LU", "()Ljava/lang/String;", "setState-7IW2chM", "(Ljava/lang/String;)V", "Ljava/lang/String;", "currentClockTimeNanos", "", "setStateParameters", "", "par1", "", "par2", "getMaxDurationPerIteration", "getMaxDuration", "setClockTime", "animationTimeNanos", "getTransitions", "", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "getAnimatedProperties", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "toCurrentTargetPair", "Lkotlin/Pair;", "", "toCurrentTargetPair-7IW2chM", "(Ljava/lang/String;)Lkotlin/Pair;", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimatedVisibilityClock implements ComposeAnimationClock<AnimatedVisibilityComposeAnimation, AnimatedVisibilityState> {
    public static final int $stable = 8;
    private final AnimatedVisibilityComposeAnimation animation;
    private long currentClockTimeNanos;
    private String state;

    public AnimatedVisibilityClock(AnimatedVisibilityComposeAnimation animatedVisibilityComposeAnimation) {
        String strM9624getEnterjXw82LU;
        this.animation = animatedVisibilityComposeAnimation;
        if (getAnimation().m9601getAnimationObject().getCurrentState().booleanValue()) {
            strM9624getEnterjXw82LU = AnimatedVisibilityState.INSTANCE.m9625getExitjXw82LU();
        } else {
            strM9624getEnterjXw82LU = AnimatedVisibilityState.INSTANCE.m9624getEnterjXw82LU();
        }
        this.state = strM9624getEnterjXw82LU;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public AnimatedVisibilityComposeAnimation getAnimation() {
        return this.animation;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public /* bridge */ /* synthetic */ ComposeAnimationState getState() {
        return AnimatedVisibilityState.m9617boximpl(getState());
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public /* bridge */ /* synthetic */ void setState(ComposeAnimationState composeAnimationState) {
        m9614setState7IW2chM(((AnimatedVisibilityState) composeAnimationState).m9623unboximpl());
    }

    /* JADX INFO: renamed from: getState-jXw82LU, reason: not valid java name and from getter */
    public String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: setState-7IW2chM, reason: not valid java name */
    public void m9614setState7IW2chM(String str) {
        this.state = str;
        setClockTime(this.currentClockTimeNanos);
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setStateParameters(Object par1, Object par2) {
        Intrinsics.checkNotNull(par1, "null cannot be cast to non-null type androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState");
        m9614setState7IW2chM(((AnimatedVisibilityState) par1).m9623unboximpl());
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long getMaxDurationPerIteration() {
        Transition<Object> childTransition = getAnimation().getChildTransition();
        if (childTransition != null) {
            return Utils_androidKt.nanosToMillis(childTransition.getTotalDurationNanos());
        }
        return 0L;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long getMaxDuration() {
        Transition<Object> childTransition = getAnimation().getChildTransition();
        if (childTransition != null) {
            return Utils_androidKt.nanosToMillis(childTransition.getTotalDurationNanos());
        }
        return 0L;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public void setClockTime(long animationTimeNanos) {
        this.currentClockTimeNanos = animationTimeNanos;
        Transition<Boolean> transitionM9601getAnimationObject = getAnimation().m9601getAnimationObject();
        Pair<Boolean, Boolean> pairM9612toCurrentTargetPair7IW2chM = m9612toCurrentTargetPair7IW2chM(getState());
        transitionM9601getAnimationObject.seek(Boolean.valueOf(pairM9612toCurrentTargetPair7IW2chM.component1().booleanValue()), Boolean.valueOf(pairM9612toCurrentTargetPair7IW2chM.component2().booleanValue()), animationTimeNanos);
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public List<TransitionInfo> getTransitions(long stepMillis) {
        Transition<Object> childTransition = getAnimation().getChildTransition();
        if (childTransition != null) {
            List<Transition<?>.TransitionAnimationState<?, ?>> listAllAnimations = Utils_androidKt.allAnimations(childTransition);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listAllAnimations, 10));
            Iterator<T> it = listAllAnimations.iterator();
            while (it.hasNext()) {
                arrayList.add(Utils_androidKt.createTransitionInfo((Transition.TransitionAnimationState) it.next(), stepMillis));
            }
            List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.compose.ui.tooling.animation.clock.AnimatedVisibilityClock$getTransitions$lambda$0$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((TransitionInfo) t).getLabel(), ((TransitionInfo) t2).getLabel());
                }
            });
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : listSortedWith) {
                if (!Utils_androidKt.getIGNORE_TRANSITIONS().contains(((TransitionInfo) obj).getLabel())) {
                    arrayList2.add(obj);
                }
            }
            return arrayList2;
        }
        return CollectionsKt.emptyList();
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public List<ComposeAnimatedProperty> getAnimatedProperties() {
        Transition<Object> childTransition = getAnimation().getChildTransition();
        if (childTransition != null) {
            List<Transition<?>.TransitionAnimationState<?, ?>> listAllAnimations = Utils_androidKt.allAnimations(childTransition);
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listAllAnimations.iterator();
            while (it.hasNext()) {
                Transition.TransitionAnimationState transitionAnimationState = (Transition.TransitionAnimationState) it.next();
                String label = transitionAnimationState.getLabel();
                Object value = transitionAnimationState.getValue();
                ComposeAnimatedProperty composeAnimatedProperty = value == null ? null : new ComposeAnimatedProperty(label, value);
                if (composeAnimatedProperty != null) {
                    arrayList.add(composeAnimatedProperty);
                }
            }
            List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.compose.ui.tooling.animation.clock.AnimatedVisibilityClock$getAnimatedProperties$lambda$0$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((ComposeAnimatedProperty) t).getLabel(), ((ComposeAnimatedProperty) t2).getLabel());
                }
            });
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : listSortedWith) {
                if (!Utils_androidKt.getIGNORE_TRANSITIONS().contains(((ComposeAnimatedProperty) obj).getLabel())) {
                    arrayList2.add(obj);
                }
            }
            return arrayList2;
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: toCurrentTargetPair-7IW2chM, reason: not valid java name */
    private final Pair<Boolean, Boolean> m9612toCurrentTargetPair7IW2chM(String str) {
        return AnimatedVisibilityState.m9620equalsimpl0(str, AnimatedVisibilityState.INSTANCE.m9624getEnterjXw82LU()) ? TuplesKt.to(false, true) : TuplesKt.to(true, false);
    }
}
