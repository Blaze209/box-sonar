package androidx.compose.ui.tooling.animation;

import android.util.Log;
import androidx.compose.animation.core.DecayAnimation;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.compose.ui.tooling.animation.clock.AnimateXAsStateClock;
import androidx.compose.ui.tooling.animation.clock.AnimatedVisibilityClock;
import androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock;
import androidx.compose.ui.tooling.animation.clock.InfiniteTransitionClock;
import androidx.compose.ui.tooling.animation.clock.TransitionClock;
import androidx.compose.ui.tooling.animation.clock.Utils_androidKt;
import androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState;
import com.box.androidsdk.content.models.BoxFile;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewAnimationClock.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010-\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010(2\u0006\u0010.\u001a\u00020/H\u0002J\u0012\u00100\u001a\u00020\u00042\n\u0010.\u001a\u0006\u0012\u0002\b\u000301J\"\u00102\u001a\u00020\u00042\n\u0010.\u001a\u0006\u0012\u0002\b\u0003012\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0016\u00104\u001a\u00020\u00042\u000e\u0010.\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000305J\u000e\u00106\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0001J\u0016\u00107\u001a\u00020\u00042\u000e\u0010.\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000308J\u0016\u00109\u001a\u00020\u00042\u000e\u0010.\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030:J\u0012\u0010;\u001a\u00020\u00042\n\u0010.\u001a\u0006\u0012\u0002\b\u000301J\u000e\u0010<\u001a\u00020\u00042\u0006\u0010.\u001a\u00020=J\u0018\u0010E\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0006\u0010F\u001a\u00020\bH\u0002J\u0012\u0010G\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010\bH\u0002J$\u0010J\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u00012\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040LH\u0002J\u0010\u0010M\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/H\u0015J\u0010\u0010N\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/H\u0015J\u001e\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010R\u001a\u00020\u0001J\u0016\u0010S\u001a\u00020\u00042\u0006\u0010P\u001a\u00020/2\u0006\u0010T\u001a\u00020\u0001J\u0015\u0010U\u001a\u00020V2\u0006\u0010P\u001a\u00020/¢\u0006\u0004\bW\u0010XJ\u0006\u0010Y\u001a\u00020ZJ\u0006\u0010[\u001a\u00020ZJ\u0014\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0'2\u0006\u0010.\u001a\u00020/J\u001c\u0010^\u001a\b\u0012\u0004\u0012\u00020_0'2\u0006\u0010.\u001a\u00020/2\u0006\u0010`\u001a\u00020ZJ\u000e\u0010a\u001a\u00020\u00042\u0006\u0010b\u001a\u00020ZJ\u001a\u0010c\u001a\u00020\u00042\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020Z0dJ\u0006\u0010e\u001a\u00020\u0004R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R0\u0010\u000b\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R8\u0010\u0018\u001a\u001e\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0019\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001a0\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012R(\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012R0\u0010\"\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030#\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\u0012R\"\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030(0'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\"\u0010+\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030(0'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R,\u0010>\u001a\u0012\u0012\u0004\u0012\u00020@0?j\b\u0012\u0004\u0012\u00020@`A8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010\u0010\u001a\u0004\bC\u0010DR\u001e\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u00010?j\b\u0012\u0004\u0012\u00020\u0001`AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "", "setAnimationsTimeCallback", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "TAG", "", "DEBUG", "", "transitionClocks", "", "Landroidx/compose/ui/tooling/animation/TransitionComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/TransitionClock;", "getTransitionClocks$ui_tooling$annotations", "()V", "getTransitionClocks$ui_tooling", "()Ljava/util/Map;", "animatedVisibilityClocks", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/AnimatedVisibilityClock;", "getAnimatedVisibilityClocks$ui_tooling$annotations", "getAnimatedVisibilityClocks$ui_tooling", "animateXAsStateClocks", "Landroidx/compose/ui/tooling/animation/AnimateXAsStateComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/AnimateXAsStateClock;", "getAnimateXAsStateClocks$ui_tooling$annotations", "getAnimateXAsStateClocks$ui_tooling", "infiniteTransitionClocks", "Landroidx/compose/ui/tooling/animation/InfiniteTransitionComposeAnimation;", "Landroidx/compose/ui/tooling/animation/clock/InfiniteTransitionClock;", "getInfiniteTransitionClocks$ui_tooling$annotations", "getInfiniteTransitionClocks$ui_tooling", "animatedContentClocks", "Landroidx/compose/ui/tooling/animation/AnimatedContentComposeAnimation;", "getAnimatedContentClocks$ui_tooling$annotations", "getAnimatedContentClocks$ui_tooling", "allClocksExceptInfinite", "", "Landroidx/compose/ui/tooling/animation/clock/ComposeAnimationClock;", "getAllClocksExceptInfinite", "()Ljava/util/List;", "allClocks", "getAllClocks", "findClock", "animation", "Landroidx/compose/animation/tooling/ComposeAnimation;", "trackTransition", "Landroidx/compose/animation/core/Transition;", "trackAnimatedVisibility", "onSeek", "trackAnimateXAsState", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearchInfo;", "trackAnimateContentSize", "trackTargetBasedAnimations", "Landroidx/compose/animation/core/TargetBasedAnimation;", "trackDecayAnimations", "Landroidx/compose/animation/core/DecayAnimation;", "trackAnimatedContent", "trackInfiniteTransition", "Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearchInfo;", "trackedUnsupportedAnimations", "Ljava/util/LinkedHashSet;", "Landroidx/compose/ui/tooling/animation/UnsupportedComposeAnimation;", "Lkotlin/collections/LinkedHashSet;", "getTrackedUnsupportedAnimations$annotations", "getTrackedUnsupportedAnimations", "()Ljava/util/LinkedHashSet;", "trackUnsupported", "label", "createUnsupported", "trackedAnimations", BoxFile.FIELD_LOCK, "trackAnimation", "createClockAndSubscribe", "Lkotlin/Function1;", "notifySubscribe", "notifyUnsubscribe", "updateFromAndToStates", "composeAnimation", "fromState", "toState", "updateAnimatedVisibilityState", "state", "getAnimatedVisibilityState", "Landroidx/compose/ui/tooling/animation/states/AnimatedVisibilityState;", "getAnimatedVisibilityState-cc2g1to", "(Landroidx/compose/animation/tooling/ComposeAnimation;)Ljava/lang/String;", "getMaxDuration", "", "getMaxDurationPerIteration", "getAnimatedProperties", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "getTransitions", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "setClockTime", "animationTimeMillis", "setClockTimes", "", "dispose", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class PreviewAnimationClock {
    public static final int $stable = 8;
    private final boolean DEBUG;
    private final String TAG;
    private final Map<AnimateXAsStateComposeAnimation<?, ?>, AnimateXAsStateClock<?, ?>> animateXAsStateClocks;
    private final Map<AnimatedContentComposeAnimation<?>, TransitionClock<?>> animatedContentClocks;
    private final Map<AnimatedVisibilityComposeAnimation, AnimatedVisibilityClock> animatedVisibilityClocks;
    private final Map<InfiniteTransitionComposeAnimation, InfiniteTransitionClock> infiniteTransitionClocks;
    private final Object lock;
    private final Function0<Unit> setAnimationsTimeCallback;
    private final LinkedHashSet<Object> trackedAnimations;
    private final LinkedHashSet<UnsupportedComposeAnimation> trackedUnsupportedAnimations;
    private final Map<TransitionComposeAnimation<?>, TransitionClock<?>> transitionClocks;

    /* JADX WARN: Multi-variable type inference failed */
    public PreviewAnimationClock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void getAnimateXAsStateClocks$ui_tooling$annotations() {
    }

    public static /* synthetic */ void getAnimatedContentClocks$ui_tooling$annotations() {
    }

    public static /* synthetic */ void getAnimatedVisibilityClocks$ui_tooling$annotations() {
    }

    public static /* synthetic */ void getInfiniteTransitionClocks$ui_tooling$annotations() {
    }

    public static /* synthetic */ void getTrackedUnsupportedAnimations$annotations() {
    }

    public static /* synthetic */ void getTransitionClocks$ui_tooling$annotations() {
    }

    protected void notifySubscribe(ComposeAnimation animation) {
    }

    protected void notifyUnsubscribe(ComposeAnimation animation) {
    }

    public PreviewAnimationClock(Function0<Unit> function0) {
        this.setAnimationsTimeCallback = function0;
        this.TAG = "PreviewAnimationClock";
        this.transitionClocks = new LinkedHashMap();
        this.animatedVisibilityClocks = new LinkedHashMap();
        this.animateXAsStateClocks = new LinkedHashMap();
        this.infiniteTransitionClocks = new LinkedHashMap();
        this.animatedContentClocks = new LinkedHashMap();
        this.trackedUnsupportedAnimations = new LinkedHashSet<>();
        this.trackedAnimations = new LinkedHashSet<>();
        this.lock = new Object();
    }

    public /* synthetic */ PreviewAnimationClock(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        } : function0);
    }

    public final Map<TransitionComposeAnimation<?>, TransitionClock<?>> getTransitionClocks$ui_tooling() {
        return this.transitionClocks;
    }

    public final Map<AnimatedVisibilityComposeAnimation, AnimatedVisibilityClock> getAnimatedVisibilityClocks$ui_tooling() {
        return this.animatedVisibilityClocks;
    }

    public final Map<AnimateXAsStateComposeAnimation<?, ?>, AnimateXAsStateClock<?, ?>> getAnimateXAsStateClocks$ui_tooling() {
        return this.animateXAsStateClocks;
    }

    public final Map<InfiniteTransitionComposeAnimation, InfiniteTransitionClock> getInfiniteTransitionClocks$ui_tooling() {
        return this.infiniteTransitionClocks;
    }

    public final Map<AnimatedContentComposeAnimation<?>, TransitionClock<?>> getAnimatedContentClocks$ui_tooling() {
        return this.animatedContentClocks;
    }

    private final List<ComposeAnimationClock<?, ?>> getAllClocksExceptInfinite() {
        return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) this.transitionClocks.values(), (Iterable) this.animatedVisibilityClocks.values()), (Iterable) this.animateXAsStateClocks.values()), (Iterable) this.animatedContentClocks.values());
    }

    private final List<ComposeAnimationClock<?, ?>> getAllClocks() {
        return CollectionsKt.plus((Collection) getAllClocksExceptInfinite(), (Iterable) this.infiniteTransitionClocks.values());
    }

    private final ComposeAnimationClock<?, ?> findClock(ComposeAnimation animation) {
        TransitionClock<?> transitionClock = this.transitionClocks.get(animation);
        if (transitionClock != null) {
            return transitionClock;
        }
        AnimatedVisibilityClock animatedVisibilityClock = this.animatedVisibilityClocks.get(animation);
        if (animatedVisibilityClock != null) {
            return animatedVisibilityClock;
        }
        AnimateXAsStateClock<?, ?> animateXAsStateClock = this.animateXAsStateClocks.get(animation);
        if (animateXAsStateClock != null) {
            return animateXAsStateClock;
        }
        InfiniteTransitionClock infiniteTransitionClock = this.infiniteTransitionClocks.get(animation);
        return infiniteTransitionClock != null ? infiniteTransitionClock : this.animatedContentClocks.get(animation);
    }

    public final void trackTransition(final Transition<?> animation) {
        trackAnimation(animation, new Function1() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewAnimationClock.trackTransition$lambda$0(animation, this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit trackTransition$lambda$0(Transition transition, PreviewAnimationClock previewAnimationClock, Object obj) {
        TransitionComposeAnimation<?> transitionComposeAnimation = TransitionComposeAnimation_androidKt.parse(transition);
        if (transitionComposeAnimation != null) {
            previewAnimationClock.transitionClocks.put(transitionComposeAnimation, new TransitionClock<>(transitionComposeAnimation));
            previewAnimationClock.notifySubscribe(transitionComposeAnimation);
            return Unit.INSTANCE;
        }
        previewAnimationClock.createUnsupported(transition.getLabel());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackAnimatedVisibility$default(PreviewAnimationClock previewAnimationClock, Transition transition, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackAnimatedVisibility");
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        previewAnimationClock.trackAnimatedVisibility(transition, function0);
    }

    public final void trackAnimatedVisibility(final Transition<?> animation, final Function0<Unit> onSeek) {
        if (animation.getCurrentState() instanceof Boolean) {
            trackAnimation(animation, new Function1() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PreviewAnimationClock.trackAnimatedVisibility$lambda$1(animation, onSeek, this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit trackAnimatedVisibility$lambda$1(Transition transition, Function0 function0, PreviewAnimationClock previewAnimationClock, Object obj) {
        Intrinsics.checkNotNull(transition, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Boolean>");
        AnimatedVisibilityComposeAnimation animatedVisibility = AnimatedVisibilityComposeAnimation_androidKt.parseAnimatedVisibility(transition);
        function0.invoke();
        Map<AnimatedVisibilityComposeAnimation, AnimatedVisibilityClock> map = previewAnimationClock.animatedVisibilityClocks;
        AnimatedVisibilityClock animatedVisibilityClock = new AnimatedVisibilityClock(animatedVisibility);
        animatedVisibilityClock.setClockTime(0L);
        map.put(animatedVisibility, animatedVisibilityClock);
        previewAnimationClock.notifySubscribe(animatedVisibility);
        return Unit.INSTANCE;
    }

    public final void trackAnimateXAsState(final AnimationSearch.AnimateXAsStateSearchInfo<?, ?> animation) {
        trackAnimation(animation.getAnimatable(), new Function1() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewAnimationClock.trackAnimateXAsState$lambda$0(animation, this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit trackAnimateXAsState$lambda$0(AnimationSearch.AnimateXAsStateSearchInfo animateXAsStateSearchInfo, PreviewAnimationClock previewAnimationClock, Object obj) {
        AnimateXAsStateComposeAnimation<?, ?> animateXAsStateComposeAnimation = AnimateXAsStateComposeAnimation.INSTANCE.parse$ui_tooling(animateXAsStateSearchInfo);
        if (animateXAsStateComposeAnimation != null) {
            previewAnimationClock.animateXAsStateClocks.put(animateXAsStateComposeAnimation, new AnimateXAsStateClock<>(animateXAsStateComposeAnimation));
            previewAnimationClock.notifySubscribe(animateXAsStateComposeAnimation);
            return Unit.INSTANCE;
        }
        previewAnimationClock.createUnsupported(animateXAsStateSearchInfo.getAnimatable().getLabel());
        return Unit.INSTANCE;
    }

    public final void trackAnimateContentSize(Object animation) {
        trackUnsupported(animation, "animateContentSize");
    }

    public final void trackTargetBasedAnimations(TargetBasedAnimation<?, ?> animation) {
        trackUnsupported(animation, "TargetBasedAnimation");
    }

    public final void trackDecayAnimations(DecayAnimation<?, ?> animation) {
        trackUnsupported(animation, "DecayAnimation");
    }

    public final void trackAnimatedContent(final Transition<?> animation) {
        trackAnimation(animation, new Function1() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewAnimationClock.trackAnimatedContent$lambda$0(animation, this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit trackAnimatedContent$lambda$0(Transition transition, PreviewAnimationClock previewAnimationClock, Object obj) {
        AnimatedContentComposeAnimation<?> animatedContent = AnimatedContentComposeAnimation.INSTANCE.parseAnimatedContent(transition);
        if (animatedContent != null) {
            previewAnimationClock.animatedContentClocks.put(animatedContent, new TransitionClock<>(animatedContent));
            previewAnimationClock.notifySubscribe(animatedContent);
            return Unit.INSTANCE;
        }
        previewAnimationClock.createUnsupported(transition.getLabel());
        return Unit.INSTANCE;
    }

    public final void trackInfiniteTransition(final AnimationSearch.InfiniteTransitionSearchInfo animation) {
        trackAnimation(animation.getInfiniteTransition(), new Function1() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewAnimationClock.trackInfiniteTransition$lambda$0(animation, this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit trackInfiniteTransition$lambda$0(AnimationSearch.InfiniteTransitionSearchInfo infiniteTransitionSearchInfo, final PreviewAnimationClock previewAnimationClock, Object obj) {
        InfiniteTransitionComposeAnimation infiniteTransitionComposeAnimation = InfiniteTransitionComposeAnimation.INSTANCE.parse$ui_tooling(infiniteTransitionSearchInfo);
        if (infiniteTransitionComposeAnimation != null) {
            previewAnimationClock.infiniteTransitionClocks.put(infiniteTransitionComposeAnimation, new InfiniteTransitionClock(infiniteTransitionComposeAnimation, new Function0() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Long.valueOf(PreviewAnimationClock.trackInfiniteTransition$lambda$0$0$0(this.f$0));
                }
            }));
            previewAnimationClock.notifySubscribe(infiniteTransitionComposeAnimation);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long trackInfiniteTransition$lambda$0$0$0(PreviewAnimationClock previewAnimationClock) {
        Long lValueOf;
        Iterator<T> it = previewAnimationClock.getAllClocksExceptInfinite().iterator();
        Long lValueOf2 = null;
        if (it.hasNext()) {
            lValueOf = Long.valueOf(((ComposeAnimationClock) it.next()).getMaxDuration());
            while (it.hasNext()) {
                Long lValueOf3 = Long.valueOf(((ComposeAnimationClock) it.next()).getMaxDuration());
                if (lValueOf.compareTo(lValueOf3) < 0) {
                    lValueOf = lValueOf3;
                }
            }
        } else {
            lValueOf = null;
        }
        Long l = lValueOf;
        long jLongValue = l != null ? l.longValue() : 0L;
        Iterator<T> it2 = previewAnimationClock.infiniteTransitionClocks.values().iterator();
        if (it2.hasNext()) {
            lValueOf2 = Long.valueOf(((InfiniteTransitionClock) it2.next()).getMaxDurationPerIteration());
            while (it2.hasNext()) {
                Long lValueOf4 = Long.valueOf(((InfiniteTransitionClock) it2.next()).getMaxDurationPerIteration());
                if (lValueOf2.compareTo(lValueOf4) < 0) {
                    lValueOf2 = lValueOf4;
                }
            }
        }
        Long l2 = lValueOf2;
        return Math.max(jLongValue, l2 != null ? l2.longValue() : 0L);
    }

    public final LinkedHashSet<UnsupportedComposeAnimation> getTrackedUnsupportedAnimations() {
        return this.trackedUnsupportedAnimations;
    }

    private final void trackUnsupported(Object animation, final String label) {
        trackAnimation(animation, new Function1() { // from class: androidx.compose.ui.tooling.animation.PreviewAnimationClock$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewAnimationClock.trackUnsupported$lambda$0(this.f$0, label, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit trackUnsupported$lambda$0(PreviewAnimationClock previewAnimationClock, String str, Object obj) {
        previewAnimationClock.createUnsupported(str);
        return Unit.INSTANCE;
    }

    private final void createUnsupported(String label) {
        UnsupportedComposeAnimation unsupportedComposeAnimationCreate = UnsupportedComposeAnimation.INSTANCE.create(label);
        if (unsupportedComposeAnimationCreate != null) {
            this.trackedUnsupportedAnimations.add(unsupportedComposeAnimationCreate);
            notifySubscribe(unsupportedComposeAnimationCreate);
        }
    }

    private final boolean trackAnimation(Object animation, Function1<Object, Unit> createClockAndSubscribe) {
        synchronized (this.lock) {
            if (this.trackedAnimations.contains(animation)) {
                if (this.DEBUG) {
                    Log.d(this.TAG, "Animation " + animation + " is already being tracked");
                }
                return false;
            }
            this.trackedAnimations.add(animation);
            createClockAndSubscribe.invoke(animation);
            if (!this.DEBUG) {
                return true;
            }
            Log.d(this.TAG, "Animation " + animation + " is now tracked");
            return true;
        }
    }

    public final void updateFromAndToStates(ComposeAnimation composeAnimation, Object fromState, Object toState) {
        ComposeAnimationClock<?, ?> composeAnimationClockFindClock = findClock(composeAnimation);
        if (composeAnimationClockFindClock != null) {
            composeAnimationClockFindClock.setStateParameters(fromState, toState);
        }
    }

    public final void updateAnimatedVisibilityState(ComposeAnimation composeAnimation, Object state) {
        AnimatedVisibilityClock animatedVisibilityClock = this.animatedVisibilityClocks.get(composeAnimation);
        if (animatedVisibilityClock != null) {
            ComposeAnimationClock.setStateParameters$default(animatedVisibilityClock, state, null, 2, null);
        }
    }

    /* JADX INFO: renamed from: getAnimatedVisibilityState-cc2g1to, reason: not valid java name */
    public final String m9610getAnimatedVisibilityStatecc2g1to(ComposeAnimation composeAnimation) {
        AnimatedVisibilityClock animatedVisibilityClock = this.animatedVisibilityClocks.get(composeAnimation);
        return animatedVisibilityClock != null ? animatedVisibilityClock.getState() : AnimatedVisibilityState.INSTANCE.m9624getEnterjXw82LU();
    }

    public final long getMaxDuration() {
        Long l;
        Iterator<T> it = getAllClocks().iterator();
        if (it.hasNext()) {
            Long lValueOf = Long.valueOf(((ComposeAnimationClock) it.next()).getMaxDuration());
            while (it.hasNext()) {
                Long lValueOf2 = Long.valueOf(((ComposeAnimationClock) it.next()).getMaxDuration());
                if (lValueOf.compareTo(lValueOf2) < 0) {
                    lValueOf = lValueOf2;
                }
            }
            l = lValueOf;
        } else {
            l = null;
        }
        Long l2 = l;
        if (l2 != null) {
            return l2.longValue();
        }
        return 0L;
    }

    public final long getMaxDurationPerIteration() {
        Long l;
        Iterator<T> it = getAllClocks().iterator();
        if (it.hasNext()) {
            Long lValueOf = Long.valueOf(((ComposeAnimationClock) it.next()).getMaxDurationPerIteration());
            while (it.hasNext()) {
                Long lValueOf2 = Long.valueOf(((ComposeAnimationClock) it.next()).getMaxDurationPerIteration());
                if (lValueOf.compareTo(lValueOf2) < 0) {
                    lValueOf = lValueOf2;
                }
            }
            l = lValueOf;
        } else {
            l = null;
        }
        Long l2 = l;
        if (l2 != null) {
            return l2.longValue();
        }
        return 0L;
    }

    public final List<ComposeAnimatedProperty> getAnimatedProperties(ComposeAnimation animation) {
        List<ComposeAnimatedProperty> animatedProperties;
        ComposeAnimationClock<?, ?> composeAnimationClockFindClock = findClock(animation);
        return (composeAnimationClockFindClock == null || (animatedProperties = composeAnimationClockFindClock.getAnimatedProperties()) == null) ? CollectionsKt.emptyList() : animatedProperties;
    }

    public final List<TransitionInfo> getTransitions(ComposeAnimation animation, long stepMillis) {
        List<TransitionInfo> transitions;
        ComposeAnimationClock<?, ?> composeAnimationClockFindClock = findClock(animation);
        return (composeAnimationClockFindClock == null || (transitions = composeAnimationClockFindClock.getTransitions(stepMillis)) == null) ? CollectionsKt.emptyList() : transitions;
    }

    public final void setClockTime(long animationTimeMillis) {
        long jMillisToNanos = Utils_androidKt.millisToNanos(animationTimeMillis);
        Iterator<T> it = getAllClocks().iterator();
        while (it.hasNext()) {
            ((ComposeAnimationClock) it.next()).setClockTime(jMillisToNanos);
        }
        this.setAnimationsTimeCallback.invoke();
    }

    public final void dispose() {
        Iterator<T> it = getAllClocks().iterator();
        while (it.hasNext()) {
            notifyUnsubscribe(((ComposeAnimationClock) it.next()).getAnimation());
        }
        Iterator<T> it2 = this.trackedUnsupportedAnimations.iterator();
        while (it2.hasNext()) {
            notifyUnsubscribe((UnsupportedComposeAnimation) it2.next());
        }
        this.trackedUnsupportedAnimations.clear();
        this.transitionClocks.clear();
        this.animatedVisibilityClocks.clear();
        this.trackedAnimations.clear();
    }

    public final void setClockTimes(Map<ComposeAnimation, Long> animationTimeMillis) {
        for (Map.Entry<ComposeAnimation, Long> entry : animationTimeMillis.entrySet()) {
            ComposeAnimation key = entry.getKey();
            long jLongValue = entry.getValue().longValue();
            ComposeAnimationClock<?, ?> composeAnimationClockFindClock = findClock(key);
            if (composeAnimationClockFindClock != null) {
                composeAnimationClockFindClock.setClockTime(Utils_androidKt.millisToNanos(jLongValue));
            }
        }
        this.setAnimationsTimeCallback.invoke();
    }
}
