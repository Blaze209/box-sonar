package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.DecayAnimation;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.tooling.PreviewUtils_androidKt;
import androidx.compose.ui.tooling.data.CallGroup;
import androidx.compose.ui.tooling.data.Group;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;

/* JADX INFO: compiled from: AnimationSearch.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001:\f\u001f !\"#$%&'()*B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0016\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00160\u0013H\u0002J\u0016\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00160\u0010H\u0002J\u0014\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0010J\u0014\u0010\u001e\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0010R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch;", "", "clock", "Lkotlin/Function0;", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "onSeek", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "transitionSearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$TransitionSearch;", "animatedContentSearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedContentSearch;", "animatedVisibilitySearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedVisibilitySearch;", "animateXAsStateSearch", "", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearch;", "infiniteTransitionSearch", "", "Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearch;", "supportedSearch", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "unsupportedSearch", "setToTrack", "setToSearch", "searchAny", "", "slotTrees", "Landroidx/compose/ui/tooling/data/Group;", "attachAllAnimations", "Search", "RememberSearch", "TargetBasedSearch", "DecaySearch", "InfiniteTransitionSearchInfo", "InfiniteTransitionSearch", "AnimateXAsStateSearchInfo", "AnimateXAsStateSearch", "AnimateContentSizeSearch", "TransitionSearch", "AnimatedVisibilitySearch", "AnimatedContentSearch", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimationSearch {
    public static final int $stable = 8;
    private final AnimatedContentSearch animatedContentSearch;
    private final AnimatedVisibilitySearch animatedVisibilitySearch;
    private final Function0<PreviewAnimationClock> clock;
    private final Function0<Unit> onSeek;
    private final Set<Search<? extends Object>> setToSearch;
    private final Set<Search<? extends Object>> setToTrack;
    private final Set<Search<? extends Object>> supportedSearch;
    private final TransitionSearch transitionSearch = new TransitionSearch(new Function1() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return AnimationSearch.transitionSearch$lambda$0(this.f$0, (Transition) obj);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean attachAllAnimations$lambda$0$0(Group group) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean searchAny$lambda$0$0(Group group) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnimationSearch(Function0<? extends PreviewAnimationClock> function0, Function0<Unit> function1) {
        this.clock = function0;
        this.onSeek = function1;
        AnimatedContentSearch animatedContentSearch = new AnimatedContentSearch(new Function1() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnimationSearch.animatedContentSearch$lambda$0(this.f$0, (Transition) obj);
            }
        });
        this.animatedContentSearch = animatedContentSearch;
        this.animatedVisibilitySearch = new AnimatedVisibilitySearch(new Function1() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnimationSearch.animatedVisibilitySearch$lambda$0(this.f$0, (Transition) obj);
            }
        });
        Set<Search<? extends Object>> setSupportedSearch = supportedSearch();
        this.supportedSearch = setSupportedSearch;
        Set<Search<? extends Object>> setPlus = SetsKt.plus((Set) setSupportedSearch, (Iterable) unsupportedSearch());
        this.setToTrack = setPlus;
        this.setToSearch = SetsKt.plus((Set) setPlus, (Iterable) SetsKt.setOf(animatedContentSearch));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transitionSearch$lambda$0(AnimationSearch animationSearch, Transition transition) {
        animationSearch.clock.invoke().trackTransition(transition);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animatedContentSearch$lambda$0(AnimationSearch animationSearch, Transition transition) {
        animationSearch.clock.invoke().trackAnimatedContent(transition);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animatedVisibilitySearch$lambda$0(AnimationSearch animationSearch, Transition transition) {
        animationSearch.clock.invoke().trackAnimatedVisibility(transition, animationSearch.onSeek);
        return Unit.INSTANCE;
    }

    private final Collection<AnimateXAsStateSearch> animateXAsStateSearch() {
        if (AnimateXAsStateComposeAnimation.INSTANCE.getApiAvailable()) {
            return SetsKt.setOf(new AnimateXAsStateSearch(new Function1() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AnimationSearch.animateXAsStateSearch$lambda$0(this.f$0, (AnimationSearch.AnimateXAsStateSearchInfo) obj);
                }
            }));
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateXAsStateSearch$lambda$0(AnimationSearch animationSearch, AnimateXAsStateSearchInfo animateXAsStateSearchInfo) {
        animationSearch.clock.invoke().trackAnimateXAsState(animateXAsStateSearchInfo);
        return Unit.INSTANCE;
    }

    private final Set<InfiniteTransitionSearch> infiniteTransitionSearch() {
        if (InfiniteTransitionComposeAnimation.INSTANCE.getApiAvailable()) {
            return SetsKt.setOf(new InfiniteTransitionSearch(new Function1() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AnimationSearch.infiniteTransitionSearch$lambda$0(this.f$0, (AnimationSearch.InfiniteTransitionSearchInfo) obj);
                }
            }));
        }
        return SetsKt.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit infiniteTransitionSearch$lambda$0(AnimationSearch animationSearch, InfiniteTransitionSearchInfo infiniteTransitionSearchInfo) {
        animationSearch.clock.invoke().trackInfiniteTransition(infiniteTransitionSearchInfo);
        return Unit.INSTANCE;
    }

    private final Set<Search<? extends Object>> supportedSearch() {
        return SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.setOf((Object[]) new Search[]{this.transitionSearch, this.animatedVisibilitySearch}), (Iterable) animateXAsStateSearch()), (Iterable) infiniteTransitionSearch()), (Iterable) (AnimatedContentComposeAnimation.INSTANCE.getApiAvailable() ? SetsKt.setOf(this.animatedContentSearch) : SetsKt.emptySet()));
    }

    private final Collection<Search<? extends Object>> unsupportedSearch() {
        return UnsupportedComposeAnimation.INSTANCE.getApiAvailable() ? SetsKt.setOf((Object[]) new Search[]{new AnimateContentSizeSearch(new Function1() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnimationSearch.unsupportedSearch$lambda$0(this.f$0, obj);
            }
        }), new TargetBasedSearch(new Function1() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnimationSearch.unsupportedSearch$lambda$1(this.f$0, (TargetBasedAnimation) obj);
            }
        }), new DecaySearch(new Function1() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnimationSearch.unsupportedSearch$lambda$2(this.f$0, (DecayAnimation) obj);
            }
        })}) : CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit unsupportedSearch$lambda$0(AnimationSearch animationSearch, Object obj) {
        animationSearch.clock.invoke().trackAnimateContentSize(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit unsupportedSearch$lambda$1(AnimationSearch animationSearch, TargetBasedAnimation targetBasedAnimation) {
        animationSearch.clock.invoke().trackTargetBasedAnimations(targetBasedAnimation);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit unsupportedSearch$lambda$2(AnimationSearch animationSearch, DecayAnimation decayAnimation) {
        animationSearch.clock.invoke().trackDecayAnimations(decayAnimation);
        return Unit.INSTANCE;
    }

    public final boolean searchAny(Collection<? extends Group> slotTrees) {
        Collection<? extends Group> collection = slotTrees;
        if ((collection instanceof Collection) && collection.isEmpty()) {
            return false;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            List<Group> listFindAll = PreviewUtils_androidKt.findAll((Group) it.next(), new Function1() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(AnimationSearch.searchAny$lambda$0$0((Group) obj));
                }
            });
            Set<Search<? extends Object>> set = this.supportedSearch;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator<T> it2 = set.iterator();
                while (it2.hasNext()) {
                    if (((Search) it2.next()).hasAnimations(listFindAll)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void attachAllAnimations(Collection<? extends Group> slotTrees) {
        Iterator<T> it = slotTrees.iterator();
        while (it.hasNext()) {
            List<Group> listFindAll = PreviewUtils_androidKt.findAll((Group) it.next(), new Function1() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(AnimationSearch.attachAllAnimations$lambda$0$0((Group) obj));
                }
            });
            Iterator<T> it2 = this.setToSearch.iterator();
            while (it2.hasNext()) {
                ((Search) it2.next()).addAnimations(listFindAll);
            }
            this.transitionSearch.getAnimations().removeAll(this.animatedVisibilitySearch.getAnimations());
            this.transitionSearch.getAnimations().removeAll(this.animatedContentSearch.getAnimations());
        }
        Iterator<T> it3 = this.setToTrack.iterator();
        while (it3.hasNext()) {
            ((Search) it3.next()).track();
        }
    }

    /* JADX INFO: compiled from: AnimationSearch.android.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0005\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\fH&J\u0016\u0010\u0013\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0006\u0010\u0014\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", ExifInterface.GPS_DIRECTION_TRUE, "", "trackAnimation", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "hasAnimations", "", "groups", "", "Landroidx/compose/ui/tooling/data/Group;", "hasAnimation", "group", "animations", "", "getAnimations", "()Ljava/util/Set;", "addAnimations", "track", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class Search<T> {
        public static final int $stable = 8;
        private final Set<T> animations = new LinkedHashSet();
        private final Function1<T, Unit> trackAnimation;

        public void addAnimations(Collection<? extends Group> groups) {
        }

        public abstract boolean hasAnimation(Group group);

        /* JADX WARN: Multi-variable type inference failed */
        public Search(Function1<? super T, Unit> function1) {
            this.trackAnimation = function1;
        }

        public final boolean hasAnimations(Collection<? extends Group> groups) {
            Collection<? extends Group> collection = groups;
            if ((collection instanceof Collection) && collection.isEmpty()) {
                return false;
            }
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (hasAnimation((Group) it.next())) {
                    return true;
                }
            }
            return false;
        }

        public final Set<T> getAnimations() {
            return this.animations;
        }

        public final void track() {
            List listReversed = CollectionsKt.reversed(this.animations);
            Function1<T, Unit> function1 = this.trackAnimation;
            Iterator<T> it = listReversed.iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
        }
    }

    /* JADX INFO: compiled from: AnimationSearch.android.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J0\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0013\"\b\b\u0001\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0002J+\u0010\u0012\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0001\u0010\u0001*\u00020\u0002*\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0002¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$RememberSearch;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "clazz", "Lkotlin/reflect/KClass;", "trackAnimation", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "addAnimations", "groups", "", "Landroidx/compose/ui/tooling/data/Group;", "hasAnimation", "", "group", "findRememberCallWithType", "", "(Landroidx/compose/ui/tooling/data/Group;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class RememberSearch<T> extends Search<T> {
        public static final int $stable = 8;
        private final KClass<T> clazz;

        public RememberSearch(KClass<T> kClass, Function1<? super T, Unit> function1) {
            super(function1);
            this.clazz = kClass;
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void addAnimations(Collection<? extends Group> groups) {
            ArrayList arrayList = new ArrayList();
            for (T t : groups) {
                if (((Group) t).getLocation() != null) {
                    arrayList.add(t);
                }
            }
            getAnimations().addAll(CollectionsKt.toSet(findRememberCallWithType(arrayList, this.clazz)));
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public boolean hasAnimation(Group group) {
            return (group.getLocation() == null || findRememberCallWithType(group, this.clazz) == null) ? false : true;
        }

        private final <T> List<T> findRememberCallWithType(Collection<? extends Group> collection, KClass<T> kClass) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                T tFindRememberCallWithType = findRememberCallWithType((Group) it.next(), kClass);
                if (tFindRememberCallWithType != null) {
                    arrayList.add(tFindRememberCallWithType);
                }
            }
            return arrayList;
        }

        private final <T> T findRememberCallWithType(Group group, KClass<T> kClass) {
            Object kotlinClass;
            T next;
            Class<?> cls;
            Iterator<T> it = group.getData().iterator();
            do {
                kotlinClass = null;
                if (it.hasNext()) {
                    next = it.next();
                    if (next != null && (cls = next.getClass()) != null) {
                        kotlinClass = JvmClassMappingKt.getKotlinClass(cls);
                    }
                }
                return (T) KClasses.safeCast(kClass, kotlinClass);
            } while (!Intrinsics.areEqual(kotlinClass, kClass));
            kotlinClass = next;
            return (T) KClasses.safeCast(kClass, kotlinClass);
        }
    }

    /* JADX INFO: compiled from: AnimationSearch.android.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B#\u0012\u001a\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$TargetBasedSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$RememberSearch;", "Landroidx/compose/animation/core/TargetBasedAnimation;", "trackAnimation", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TargetBasedSearch extends RememberSearch<TargetBasedAnimation<?, ?>> {
        public static final int $stable = 8;

        public TargetBasedSearch(Function1<? super TargetBasedAnimation<?, ?>, Unit> function1) {
            super(Reflection.getOrCreateKotlinClass(TargetBasedAnimation.class), function1);
        }
    }

    /* JADX INFO: compiled from: AnimationSearch.android.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B#\u0012\u001a\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$DecaySearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$RememberSearch;", "Landroidx/compose/animation/core/DecayAnimation;", "trackAnimation", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DecaySearch extends RememberSearch<DecayAnimation<?, ?>> {
        public static final int $stable = 8;

        public DecaySearch(Function1<? super DecayAnimation<?, ?>, Unit> function1) {
            super(Reflection.getOrCreateKotlinClass(DecayAnimation.class), function1);
        }
    }

    /* JADX INFO: compiled from: AnimationSearch.android.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearchInfo;", "", "infiniteTransition", "Landroidx/compose/animation/core/InfiniteTransition;", "toolingState", "Landroidx/compose/ui/tooling/animation/ToolingState;", "", "<init>", "(Landroidx/compose/animation/core/InfiniteTransition;Landroidx/compose/ui/tooling/animation/ToolingState;)V", "getInfiniteTransition", "()Landroidx/compose/animation/core/InfiniteTransition;", "getToolingState", "()Landroidx/compose/ui/tooling/animation/ToolingState;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class InfiniteTransitionSearchInfo {
        public static final int $stable = InfiniteTransition.$stable;
        private final InfiniteTransition infiniteTransition;
        private final ToolingState<Long> toolingState;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InfiniteTransitionSearchInfo copy$default(InfiniteTransitionSearchInfo infiniteTransitionSearchInfo, InfiniteTransition infiniteTransition, ToolingState toolingState, int i, Object obj) {
            if ((i & 1) != 0) {
                infiniteTransition = infiniteTransitionSearchInfo.infiniteTransition;
            }
            if ((i & 2) != 0) {
                toolingState = infiniteTransitionSearchInfo.toolingState;
            }
            return infiniteTransitionSearchInfo.copy(infiniteTransition, toolingState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final InfiniteTransition getInfiniteTransition() {
            return this.infiniteTransition;
        }

        public final ToolingState<Long> component2() {
            return this.toolingState;
        }

        public final InfiniteTransitionSearchInfo copy(InfiniteTransition infiniteTransition, ToolingState<Long> toolingState) {
            return new InfiniteTransitionSearchInfo(infiniteTransition, toolingState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InfiniteTransitionSearchInfo)) {
                return false;
            }
            InfiniteTransitionSearchInfo infiniteTransitionSearchInfo = (InfiniteTransitionSearchInfo) other;
            return Intrinsics.areEqual(this.infiniteTransition, infiniteTransitionSearchInfo.infiniteTransition) && Intrinsics.areEqual(this.toolingState, infiniteTransitionSearchInfo.toolingState);
        }

        public int hashCode() {
            return (this.infiniteTransition.hashCode() * 31) + this.toolingState.hashCode();
        }

        public String toString() {
            return "InfiniteTransitionSearchInfo(infiniteTransition=" + this.infiniteTransition + ", toolingState=" + this.toolingState + ')';
        }

        public InfiniteTransitionSearchInfo(InfiniteTransition infiniteTransition, ToolingState<Long> toolingState) {
            this.infiniteTransition = infiniteTransition;
            this.toolingState = toolingState;
        }

        public final InfiniteTransition getInfiniteTransition() {
            return this.infiniteTransition;
        }

        public final ToolingState<Long> getToolingState() {
            return this.toolingState;
        }
    }

    /* JADX INFO: compiled from: AnimationSearch.android.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002J \u0010\u0013\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearchInfo;", "trackAnimation", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "hasAnimation", "", "group", "Landroidx/compose/ui/tooling/data/Group;", "addAnimations", "groups", "", "toAnimationGroup", "Landroidx/compose/ui/tooling/data/CallGroup;", "findAnimations", "", "findToolingOverride", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/runtime/State;", "", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class InfiniteTransitionSearch extends Search<InfiniteTransitionSearchInfo> {
        public static final int $stable = 8;

        public InfiniteTransitionSearch(Function1<? super InfiniteTransitionSearchInfo, Unit> function1) {
            super(function1);
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public boolean hasAnimation(Group group) {
            Object next;
            if (toAnimationGroup(group) != null) {
                Collection<Object> data = group.getData();
                Collection<Group> children = group.getChildren();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = children.iterator();
                while (it.hasNext()) {
                    CollectionsKt.addAll(arrayList, ((Group) it.next()).getData());
                }
                Iterator it2 = CollectionsKt.plus((Collection) data, (Iterable) arrayList).iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!(next instanceof InfiniteTransition));
                if (((InfiniteTransition) (next instanceof InfiniteTransition ? next : null)) != null && findToolingOverride(group) != null) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void addAnimations(Collection<? extends Group> groups) {
            getAnimations().addAll(findAnimations(groups));
        }

        private final CallGroup toAnimationGroup(Group group) {
            if (group.getLocation() == null || !Intrinsics.areEqual(group.getName(), "rememberInfiniteTransition")) {
                group = null;
            }
            if (group == null || !(group instanceof CallGroup)) {
                return null;
            }
            return (CallGroup) group;
        }

        private final List<InfiniteTransitionSearchInfo> findAnimations(Collection<? extends Group> groups) {
            InfiniteTransitionSearchInfo infiniteTransitionSearchInfo;
            Object next;
            ArrayList<CallGroup> arrayList = new ArrayList();
            Iterator<T> it = groups.iterator();
            while (it.hasNext()) {
                CallGroup animationGroup = toAnimationGroup((Group) it.next());
                if (animationGroup != null) {
                    arrayList.add(animationGroup);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (CallGroup callGroup : arrayList) {
                Collection<Object> data = callGroup.getData();
                Collection<Group> children = callGroup.getChildren();
                ArrayList arrayList3 = new ArrayList();
                Iterator<T> it2 = children.iterator();
                while (it2.hasNext()) {
                    CollectionsKt.addAll(arrayList3, ((Group) it2.next()).getData());
                }
                Iterator it3 = CollectionsKt.plus((Collection) data, (Iterable) arrayList3).iterator();
                do {
                    infiniteTransitionSearchInfo = null;
                    infiniteTransitionSearchInfo = null;
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it3.next();
                } while (!(next instanceof InfiniteTransition));
                if (!(next instanceof InfiniteTransition)) {
                    next = null;
                }
                InfiniteTransition infiniteTransition = (InfiniteTransition) next;
                MutableState<State<Long>> mutableStateFindToolingOverride = findToolingOverride(callGroup);
                if (infiniteTransition != null && mutableStateFindToolingOverride != null) {
                    if (mutableStateFindToolingOverride.getValue() == null) {
                        mutableStateFindToolingOverride.setValue(new ToolingState(0L));
                    }
                    State<Long> value = mutableStateFindToolingOverride.getValue();
                    ToolingState toolingState = value instanceof ToolingState ? (ToolingState) value : null;
                    if (toolingState == null) {
                        toolingState = new ToolingState(0L);
                    }
                    infiniteTransitionSearchInfo = new InfiniteTransitionSearchInfo(infiniteTransition, toolingState);
                }
                if (infiniteTransitionSearchInfo != null) {
                    arrayList2.add(infiniteTransitionSearchInfo);
                }
            }
            return arrayList2;
        }

        private final MutableState<State<Long>> findToolingOverride(Group group) {
            Object next;
            Collection<Object> data = group.getData();
            Collection<Group> children = group.getChildren();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = children.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList, ((Group) it.next()).getChildren());
            }
            List listPlus = CollectionsKt.plus((Collection) children, (Iterable) arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = listPlus.iterator();
            while (it2.hasNext()) {
                CollectionsKt.addAll(arrayList2, ((Group) it2.next()).getData());
            }
            Iterator it3 = CollectionsKt.plus((Collection) data, (Iterable) arrayList2).iterator();
            do {
                if (!it3.hasNext()) {
                    next = null;
                    break;
                }
                next = it3.next();
            } while (!(next instanceof MutableState));
            return (MutableState) (next instanceof MutableState ? next : null);
        }
    }

    /* JADX INFO: compiled from: AnimationSearch.android.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B7\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\bHÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\nHÆ\u0003JK\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearchInfo;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "", "animatable", "Landroidx/compose/animation/core/Animatable;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "toolingState", "Landroidx/compose/ui/tooling/animation/ToolingState;", "<init>", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/tooling/animation/ToolingState;)V", "getAnimatable", "()Landroidx/compose/animation/core/Animatable;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getToolingState", "()Landroidx/compose/ui/tooling/animation/ToolingState;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class AnimateXAsStateSearchInfo<T, V extends AnimationVector> {
        public static final int $stable = 8;
        private final Animatable<T, V> animatable;
        private final AnimationSpec<T> animationSpec;
        private final ToolingState<T> toolingState;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnimateXAsStateSearchInfo copy$default(AnimateXAsStateSearchInfo animateXAsStateSearchInfo, Animatable animatable, AnimationSpec animationSpec, ToolingState toolingState, int i, Object obj) {
            if ((i & 1) != 0) {
                animatable = animateXAsStateSearchInfo.animatable;
            }
            if ((i & 2) != 0) {
                animationSpec = animateXAsStateSearchInfo.animationSpec;
            }
            if ((i & 4) != 0) {
                toolingState = animateXAsStateSearchInfo.toolingState;
            }
            return animateXAsStateSearchInfo.copy(animatable, animationSpec, toolingState);
        }

        public final Animatable<T, V> component1() {
            return this.animatable;
        }

        public final AnimationSpec<T> component2() {
            return this.animationSpec;
        }

        public final ToolingState<T> component3() {
            return this.toolingState;
        }

        public final AnimateXAsStateSearchInfo<T, V> copy(Animatable<T, V> animatable, AnimationSpec<T> animationSpec, ToolingState<T> toolingState) {
            return new AnimateXAsStateSearchInfo<>(animatable, animationSpec, toolingState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimateXAsStateSearchInfo)) {
                return false;
            }
            AnimateXAsStateSearchInfo animateXAsStateSearchInfo = (AnimateXAsStateSearchInfo) other;
            return Intrinsics.areEqual(this.animatable, animateXAsStateSearchInfo.animatable) && Intrinsics.areEqual(this.animationSpec, animateXAsStateSearchInfo.animationSpec) && Intrinsics.areEqual(this.toolingState, animateXAsStateSearchInfo.toolingState);
        }

        public int hashCode() {
            return (((this.animatable.hashCode() * 31) + this.animationSpec.hashCode()) * 31) + this.toolingState.hashCode();
        }

        public String toString() {
            return "AnimateXAsStateSearchInfo(animatable=" + this.animatable + ", animationSpec=" + this.animationSpec + ", toolingState=" + this.toolingState + ')';
        }

        public AnimateXAsStateSearchInfo(Animatable<T, V> animatable, AnimationSpec<T> animationSpec, ToolingState<T> toolingState) {
            this.animatable = animatable;
            this.animationSpec = animationSpec;
            this.toolingState = toolingState;
        }

        public final Animatable<T, V> getAnimatable() {
            return this.animatable;
        }

        public final AnimationSpec<T> getAnimationSpec() {
            return this.animationSpec;
        }

        public final ToolingState<T> getToolingState() {
            return this.toolingState;
        }
    }

    /* JADX INFO: compiled from: AnimationSearch.android.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B#\u0012\u001a\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J.\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00140\u00020\u0012\"\u0004\b\u0000\u0010\u00132\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002J&\u0010\u0015\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u0017\u0018\u00010\u0016\"\u0004\b\u0000\u0010\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0013\u0018\u00010\u0019\"\u0004\b\u0000\u0010\u00132\u0006\u0010\n\u001a\u00020\u0010H\u0002J$\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001b\"\u0004\b\u0000\u0010\u00132\u0006\u0010\n\u001a\u00020\u0010H\u0002¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateXAsStateSearchInfo;", "trackAnimation", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "hasAnimation", "", "group", "Landroidx/compose/ui/tooling/data/Group;", "addAnimations", "groups", "", "toAnimationGroup", "Landroidx/compose/ui/tooling/data/CallGroup;", "findAnimations", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/AnimationVector;", "findToolingOverride", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/runtime/State;", "findAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "findAnimatable", "Landroidx/compose/animation/core/Animatable;", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnimateXAsStateSearch extends Search<AnimateXAsStateSearchInfo<?, ?>> {
        public static final int $stable = 8;

        public AnimateXAsStateSearch(Function1<? super AnimateXAsStateSearchInfo<?, ?>, Unit> function1) {
            super(function1);
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public boolean hasAnimation(Group group) {
            CallGroup animationGroup = toAnimationGroup(group);
            return (animationGroup == null || findAnimatable(animationGroup) == null || findAnimationSpec(animationGroup) == null || findToolingOverride(animationGroup) == null) ? false : true;
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void addAnimations(Collection<? extends Group> groups) {
            getAnimations().addAll(findAnimations(groups));
        }

        private final CallGroup toAnimationGroup(Group group) {
            if (group.getLocation() == null || !Intrinsics.areEqual(group.getName(), "animateValueAsState")) {
                group = null;
            }
            if (group == null || !(group instanceof CallGroup)) {
                return null;
            }
            return (CallGroup) group;
        }

        private final <T> List<AnimateXAsStateSearchInfo<T, AnimationVector>> findAnimations(Collection<? extends Group> groups) {
            ArrayList<CallGroup> arrayList = new ArrayList();
            Iterator<T> it = groups.iterator();
            while (it.hasNext()) {
                CallGroup animationGroup = toAnimationGroup((Group) it.next());
                if (animationGroup != null) {
                    arrayList.add(animationGroup);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (CallGroup callGroup : arrayList) {
                Animatable<T, AnimationVector> animatableFindAnimatable = findAnimatable(callGroup);
                AnimationSpec<T> animationSpecFindAnimationSpec = findAnimationSpec(callGroup);
                MutableState<State<T>> mutableStateFindToolingOverride = findToolingOverride(callGroup);
                AnimateXAsStateSearchInfo animateXAsStateSearchInfo = null;
                animateXAsStateSearchInfo = null;
                animateXAsStateSearchInfo = null;
                if (animatableFindAnimatable != null && animationSpecFindAnimationSpec != null && mutableStateFindToolingOverride != null) {
                    if (mutableStateFindToolingOverride.getValue() == null) {
                        mutableStateFindToolingOverride.setValue(new ToolingState(animatableFindAnimatable.getValue()));
                    }
                    State<T> value = mutableStateFindToolingOverride.getValue();
                    ToolingState toolingState = value instanceof ToolingState ? (ToolingState) value : null;
                    if (toolingState == null) {
                        toolingState = new ToolingState(animatableFindAnimatable.getValue());
                    }
                    animateXAsStateSearchInfo = new AnimateXAsStateSearchInfo(animatableFindAnimatable, animationSpecFindAnimationSpec, toolingState);
                }
                if (animateXAsStateSearchInfo != null) {
                    arrayList2.add(animateXAsStateSearchInfo);
                }
            }
            return arrayList2;
        }

        private final <T> AnimationSpec<T> findAnimationSpec(CallGroup group) {
            Collection<Group> children = group.getChildren();
            ArrayList arrayList = new ArrayList();
            for (T t : children) {
                if (Intrinsics.areEqual(((Group) t).getName(), "rememberUpdatedState")) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList();
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList4, ((Group) it.next()).getChildren());
            }
            List listPlus = CollectionsKt.plus((Collection) arrayList3, (Iterable) arrayList4);
            ArrayList arrayList5 = new ArrayList();
            Iterator<T> it2 = listPlus.iterator();
            while (it2.hasNext()) {
                CollectionsKt.addAll(arrayList5, ((Group) it2.next()).getData());
            }
            ArrayList arrayList6 = new ArrayList();
            for (T t2 : arrayList5) {
                if (t2 instanceof State) {
                    arrayList6.add(t2);
                }
            }
            ArrayList arrayList7 = arrayList6;
            ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
            Iterator<T> it3 = arrayList7.iterator();
            while (it3.hasNext()) {
                arrayList8.add(((State) it3.next()).getValue());
            }
            ArrayList arrayList9 = new ArrayList();
            for (T t3 : arrayList8) {
                if (t3 instanceof AnimationSpec) {
                    arrayList9.add(t3);
                }
            }
            return (AnimationSpec) CollectionsKt.firstOrNull((List) arrayList9);
        }

        private final <T> Animatable<T, AnimationVector> findAnimatable(CallGroup group) {
            T next;
            List listEmptyList;
            T next2;
            T next3;
            CallGroup callGroup = group;
            Iterator<T> it = callGroup.getData().iterator();
            do {
                if (!it.hasNext()) {
                    next = (T) null;
                    break;
                }
                next = it.next();
            } while (!(next instanceof Animatable));
            if (!(next instanceof Animatable)) {
                next = null;
            }
            Animatable animatable = next;
            if (animatable == null || (listEmptyList = CollectionsKt.listOf(animatable)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List list = listEmptyList;
            Collection<Group> children = callGroup.getChildren();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it2 = children.iterator();
            while (it2.hasNext()) {
                Iterator<T> it3 = ((Group) it2.next()).getData().iterator();
                do {
                    if (!it3.hasNext()) {
                        next3 = (T) null;
                        break;
                    }
                    next3 = it3.next();
                } while (!(next3 instanceof Animatable));
                if (!(next3 instanceof Animatable)) {
                    next3 = null;
                }
                Animatable animatable2 = next3;
                if (animatable2 != null) {
                    arrayList.add(animatable2);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it4 = children.iterator();
            while (it4.hasNext()) {
                Group groupFirstOrNull = PreviewUtils_androidKt.firstOrNull((Group) it4.next(), AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1.INSTANCE);
                if (groupFirstOrNull != null) {
                    arrayList3.add(groupFirstOrNull);
                }
            }
            ArrayList arrayList4 = arrayList2;
            ArrayList arrayList5 = new ArrayList();
            Iterator<T> it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                Iterator<T> it6 = ((Group) it5.next()).getData().iterator();
                do {
                    if (!it6.hasNext()) {
                        next2 = (T) null;
                        break;
                    }
                    next2 = it6.next();
                } while (!(next2 instanceof Animatable));
                if (!(next2 instanceof Animatable)) {
                    next2 = null;
                }
                Animatable animatable3 = next2;
                if (animatable3 != null) {
                    arrayList5.add(animatable3);
                }
            }
            return (Animatable) CollectionsKt.firstOrNull(CollectionsKt.plus((Collection) list, (Iterable) CollectionsKt.plus((Collection) arrayList4, (Iterable) arrayList5)));
        }

        private final <T> MutableState<State<T>> findToolingOverride(Group group) {
            T next;
            List listEmptyList;
            T next2;
            T next3;
            Iterator<T> it = group.getData().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(next instanceof MutableState));
            if (!(next instanceof MutableState)) {
                next = null;
            }
            MutableState mutableState = (MutableState) next;
            if (mutableState == null || (listEmptyList = CollectionsKt.listOf(mutableState)) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List list = listEmptyList;
            Collection<Group> children = group.getChildren();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it2 = children.iterator();
            while (it2.hasNext()) {
                Iterator<T> it3 = ((Group) it2.next()).getData().iterator();
                do {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                } while (!(next3 instanceof MutableState));
                if (!(next3 instanceof MutableState)) {
                    next3 = null;
                }
                MutableState mutableState2 = (MutableState) next3;
                if (mutableState2 != null) {
                    arrayList.add(mutableState2);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it4 = children.iterator();
            while (it4.hasNext()) {
                Group groupFirstOrNull = PreviewUtils_androidKt.firstOrNull((Group) it4.next(), AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1.INSTANCE);
                if (groupFirstOrNull != null) {
                    arrayList3.add(groupFirstOrNull);
                }
            }
            ArrayList arrayList4 = arrayList2;
            ArrayList arrayList5 = new ArrayList();
            Iterator<T> it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                Iterator<T> it6 = ((Group) it5.next()).getData().iterator();
                do {
                    if (!it6.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it6.next();
                } while (!(next2 instanceof MutableState));
                if (!(next2 instanceof MutableState)) {
                    next2 = null;
                }
                MutableState mutableState3 = (MutableState) next2;
                if (mutableState3 != null) {
                    arrayList5.add(mutableState3);
                }
            }
            return (MutableState) CollectionsKt.firstOrNull(CollectionsKt.plus((Collection) list, (Iterable) CollectionsKt.plus((Collection) arrayList4, (Iterable) arrayList5)));
        }
    }

    /* JADX INFO: compiled from: AnimationSearch.android.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0016¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimateContentSizeSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "", "trackAnimation", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "hasAnimation", "", "group", "Landroidx/compose/ui/tooling/data/Group;", "addAnimations", "groups", "", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnimateContentSizeSearch extends Search<Object> {
        public static final int $stable = 8;

        public AnimateContentSizeSearch(Function1<Object, Unit> function1) {
            super(function1);
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public boolean hasAnimation(Group group) {
            if (group.getModifierInfo().isEmpty()) {
                return false;
            }
            List<ModifierInfo> modifierInfo = group.getModifierInfo();
            if ((modifierInfo instanceof Collection) && modifierInfo.isEmpty()) {
                return false;
            }
            Iterator<T> it = modifierInfo.iterator();
            while (it.hasNext()) {
                if (((ModifierInfo) it.next()).getModifier().any(new Function1() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$AnimateContentSizeSearch$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(AnimationSearch.AnimateContentSizeSearch.hasAnimation$lambda$0$0((Modifier.Element) obj));
                    }
                })) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean hasAnimation$lambda$0$0(Modifier.Element element) {
            return Intrinsics.areEqual(element.getClass().getName(), "androidx.compose.animation.SizeAnimationModifierElement");
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void addAnimations(Collection<? extends Group> groups) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : groups) {
                if (!((Group) obj).getModifierInfo().isEmpty()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Iterator<T> it2 = ((Group) it.next()).getModifierInfo().iterator();
                while (it2.hasNext()) {
                    ((ModifierInfo) it2.next()).getModifier().any(new Function1() { // from class: androidx.compose.ui.tooling.animation.AnimationSearch$AnimateContentSizeSearch$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return Boolean.valueOf(AnimationSearch.AnimateContentSizeSearch.addAnimations$lambda$1$0$0(this.f$0, (Modifier.Element) obj2));
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean addAnimations$lambda$1$0$0(AnimateContentSizeSearch animateContentSizeSearch, Modifier.Element element) {
            if (!Intrinsics.areEqual(element.getClass().getName(), "androidx.compose.animation.SizeAnimationModifierElement")) {
                return false;
            }
            animateContentSizeSearch.getAnimations().add(element);
            return true;
        }
    }

    /* JADX INFO: compiled from: AnimationSearch.android.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001f\u0012\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$TransitionSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/animation/core/Transition;", "trackAnimation", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "hasAnimation", "", "group", "Landroidx/compose/ui/tooling/data/Group;", "addAnimations", "groups", "", "toAnimationGroup", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TransitionSearch extends Search<Transition<?>> {
        public static final int $stable = 8;

        public TransitionSearch(Function1<? super Transition<?>, Unit> function1) {
            super(function1);
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public boolean hasAnimation(Group group) {
            return toAnimationGroup(group) != null;
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void addAnimations(Collection<? extends Group> groups) {
            Object next;
            Object next2;
            Set<Transition<?>> animations = getAnimations();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = groups.iterator();
            while (it.hasNext()) {
                Group animationGroup = toAnimationGroup((Group) it.next());
                if (animationGroup != null) {
                    arrayList.add(animationGroup);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Iterator<T> it3 = ((Group) it2.next()).getData().iterator();
                do {
                    if (!it3.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it3.next();
                } while (!(next2 instanceof Transition));
                Transition transition = (Transition) (next2 instanceof Transition ? next2 : null);
                if (transition != null) {
                    arrayList3.add(transition);
                }
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList();
            Iterator it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                Group groupFirstOrNull = PreviewUtils_androidKt.firstOrNull((Group) it4.next(), AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1.INSTANCE);
                if (groupFirstOrNull != null) {
                    arrayList5.add(groupFirstOrNull);
                }
            }
            ArrayList arrayList6 = arrayList4;
            ArrayList arrayList7 = new ArrayList();
            Iterator it5 = arrayList5.iterator();
            while (it5.hasNext()) {
                Iterator<T> it6 = ((Group) it5.next()).getData().iterator();
                do {
                    if (!it6.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it6.next();
                } while (!(next instanceof Transition));
                if (!(next instanceof Transition)) {
                    next = null;
                }
                Transition transition2 = (Transition) next;
                if (transition2 != null) {
                    arrayList7.add(transition2);
                }
            }
            animations.addAll(CollectionsKt.plus((Collection) arrayList6, (Iterable) arrayList7));
        }

        private final Group toAnimationGroup(Group group) {
            if (group.getLocation() == null || !Intrinsics.areEqual(group.getName(), "updateTransition")) {
                return null;
            }
            return group;
        }
    }

    /* JADX INFO: compiled from: AnimationSearch.android.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001f\u0012\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedVisibilitySearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/animation/core/Transition;", "trackAnimation", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "hasAnimation", "", "group", "Landroidx/compose/ui/tooling/data/Group;", "addAnimations", "groups", "", "toAnimationGroup", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnimatedVisibilitySearch extends Search<Transition<?>> {
        public static final int $stable = 8;

        public AnimatedVisibilitySearch(Function1<? super Transition<?>, Unit> function1) {
            super(function1);
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public boolean hasAnimation(Group group) {
            return toAnimationGroup(group) != null;
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void addAnimations(Collection<? extends Group> groups) {
            Object next;
            Object next2;
            Set<Transition<?>> animations = getAnimations();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = groups.iterator();
            while (it.hasNext()) {
                Group animationGroup = toAnimationGroup((Group) it.next());
                if (animationGroup != null) {
                    arrayList.add(animationGroup);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Iterator<T> it3 = ((Group) it2.next()).getData().iterator();
                do {
                    if (!it3.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it3.next();
                } while (!(next2 instanceof Transition));
                Transition transition = (Transition) (next2 instanceof Transition ? next2 : null);
                if (transition != null) {
                    arrayList3.add(transition);
                }
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList();
            Iterator it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                Group groupFirstOrNull = PreviewUtils_androidKt.firstOrNull((Group) it4.next(), AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1.INSTANCE);
                if (groupFirstOrNull != null) {
                    arrayList5.add(groupFirstOrNull);
                }
            }
            ArrayList arrayList6 = arrayList4;
            ArrayList arrayList7 = new ArrayList();
            Iterator it5 = arrayList5.iterator();
            while (it5.hasNext()) {
                Iterator<T> it6 = ((Group) it5.next()).getData().iterator();
                do {
                    if (!it6.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it6.next();
                } while (!(next instanceof Transition));
                if (!(next instanceof Transition)) {
                    next = null;
                }
                Transition transition2 = (Transition) next;
                if (transition2 != null) {
                    arrayList7.add(transition2);
                }
            }
            animations.addAll(CollectionsKt.plus((Collection) arrayList6, (Iterable) arrayList7));
        }

        private final Group toAnimationGroup(Group group) {
            Object obj = null;
            if (group.getLocation() == null || !Intrinsics.areEqual(group.getName(), "AnimatedVisibility")) {
                group = null;
            }
            if (group == null) {
                return null;
            }
            for (Object obj2 : group.getChildren()) {
                if (Intrinsics.areEqual(((Group) obj2).getName(), "updateTransition")) {
                    obj = obj2;
                    break;
                }
            }
            return (Group) obj;
        }
    }

    /* JADX INFO: compiled from: AnimationSearch.android.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u001f\u0012\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimationSearch$AnimatedContentSearch;", "Landroidx/compose/ui/tooling/animation/AnimationSearch$Search;", "Landroidx/compose/animation/core/Transition;", "trackAnimation", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "hasAnimation", "", "group", "Landroidx/compose/ui/tooling/data/Group;", "addAnimations", "groups", "", "toAnimationGroup", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnimatedContentSearch extends Search<Transition<?>> {
        public static final int $stable = 8;

        public AnimatedContentSearch(Function1<? super Transition<?>, Unit> function1) {
            super(function1);
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public boolean hasAnimation(Group group) {
            return toAnimationGroup(group) != null;
        }

        @Override // androidx.compose.ui.tooling.animation.AnimationSearch.Search
        public void addAnimations(Collection<? extends Group> groups) {
            Object next;
            Object next2;
            Set<Transition<?>> animations = getAnimations();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = groups.iterator();
            while (it.hasNext()) {
                Group animationGroup = toAnimationGroup((Group) it.next());
                if (animationGroup != null) {
                    arrayList.add(animationGroup);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = arrayList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Iterator<T> it3 = ((Group) it2.next()).getData().iterator();
                do {
                    if (!it3.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it3.next();
                } while (!(next2 instanceof Transition));
                Transition transition = (Transition) (next2 instanceof Transition ? next2 : null);
                if (transition != null) {
                    arrayList3.add(transition);
                }
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList();
            Iterator it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                Group groupFirstOrNull = PreviewUtils_androidKt.firstOrNull((Group) it4.next(), AnimationSearch_androidKt$findRememberedData$rememberCalls$1$1.INSTANCE);
                if (groupFirstOrNull != null) {
                    arrayList5.add(groupFirstOrNull);
                }
            }
            ArrayList arrayList6 = arrayList4;
            ArrayList arrayList7 = new ArrayList();
            Iterator it5 = arrayList5.iterator();
            while (it5.hasNext()) {
                Iterator<T> it6 = ((Group) it5.next()).getData().iterator();
                do {
                    if (!it6.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it6.next();
                } while (!(next instanceof Transition));
                if (!(next instanceof Transition)) {
                    next = null;
                }
                Transition transition2 = (Transition) next;
                if (transition2 != null) {
                    arrayList7.add(transition2);
                }
            }
            animations.addAll(CollectionsKt.plus((Collection) arrayList6, (Iterable) arrayList7));
        }

        private final Group toAnimationGroup(Group group) {
            Object obj = null;
            if (group.getLocation() == null || !Intrinsics.areEqual(group.getName(), "AnimatedContent")) {
                group = null;
            }
            if (group == null) {
                return null;
            }
            for (Object obj2 : group.getChildren()) {
                if (Intrinsics.areEqual(((Group) obj2).getName(), "updateTransition")) {
                    obj = obj2;
                    break;
                }
            }
            return (Group) obj;
        }
    }
}
