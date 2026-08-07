package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 82\u00020\u0001:\u00018Bi\b\u0002\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\f\u0010\rB-\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\f\u0010\u0010BI\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\f\u0010\u0011J\u000e\u00101\u001a\u000202H\u0086@¢\u0006\u0002\u00103J\u000e\u00104\u001a\u000202H\u0086@¢\u0006\u0002\u00103J\u0016\u00105\u001a\u0002022\u0006\u00106\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u00107R \u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR/\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001c\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010$\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00048AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0011\u0010)\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b)\u0010\u0018R\u0011\u0010*\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001b\u0010-\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b.\u0010,¨\u00069"}, d2 = {"Landroidx/compose/material3/SearchBarState;", "", "animatable", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "contentAnimatable", "animationSpecForExpand", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpecForCollapse", "animationSpecForContentFadeIn", "animationSpecForContentFadeOut", "<init>", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/animation/core/Animatable;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "initialValue", "Landroidx/compose/material3/SearchBarValue;", "(Landroidx/compose/material3/SearchBarValue;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "(Landroidx/compose/material3/SearchBarValue;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "getAnimatable$material3", "()Landroidx/compose/animation/core/Animatable;", "<set-?>", "", "expandsToFullScreen", "getExpandsToFullScreen$material3", "()Z", "setExpandsToFullScreen$material3", "(Z)V", "expandsToFullScreen$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "collapsedCoords", "getCollapsedCoords", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setCollapsedCoords", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "collapsedCoords$delegate", "progress", "getProgress", "()F", "contentProgress", "getContentProgress$material3", "isAnimating", "targetValue", "getTargetValue", "()Landroidx/compose/material3/SearchBarValue;", "currentValue", "getCurrentValue", "currentValue$delegate", "Landroidx/compose/runtime/State;", "animateToExpanded", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToCollapsed", "snapTo", "fraction", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchBarState {
    public static final int $stable = 0;
    private static final float Collapsed = 0.0f;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float Expanded = 1.0f;
    private final Animatable<Float, AnimationVector1D> animatable;
    private final AnimationSpec<Float> animationSpecForCollapse;
    private final AnimationSpec<Float> animationSpecForContentFadeIn;
    private final AnimationSpec<Float> animationSpecForContentFadeOut;
    private final AnimationSpec<Float> animationSpecForExpand;

    /* JADX INFO: renamed from: collapsedCoords$delegate, reason: from kotlin metadata */
    private final MutableState collapsedCoords;
    private final Animatable<Float, AnimationVector1D> contentAnimatable;

    /* JADX INFO: renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final State currentValue;

    /* JADX INFO: renamed from: expandsToFullScreen$delegate, reason: from kotlin metadata */
    private final MutableState expandsToFullScreen;

    /* JADX INFO: renamed from: androidx.compose.material3.SearchBarState$animateToCollapsed$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBar.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SearchBarState", f = "SearchBar.kt", i = {}, l = {1176, 1180}, m = "animateToCollapsed", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchBarState.this.animateToCollapsed(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SearchBarState$animateToExpanded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchBar.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SearchBarState", f = "SearchBar.kt", i = {}, l = {1167, 1168}, m = "animateToExpanded", n = {}, s = {}, v = 1)
    static final class C07291 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07291(Continuation<? super C07291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchBarState.this.animateToExpanded(this);
        }
    }

    public /* synthetic */ SearchBarState(Animatable animatable, Animatable animatable2, AnimationSpec animationSpec, AnimationSpec animationSpec2, AnimationSpec animationSpec3, AnimationSpec animationSpec4, DefaultConstructorMarker defaultConstructorMarker) {
        this(animatable, animatable2, animationSpec, animationSpec2, animationSpec3, animationSpec4);
    }

    private SearchBarState(Animatable<Float, AnimationVector1D> animatable, Animatable<Float, AnimationVector1D> animatable2, AnimationSpec<Float> animationSpec, AnimationSpec<Float> animationSpec2, AnimationSpec<Float> animationSpec3, AnimationSpec<Float> animationSpec4) {
        this.animatable = animatable;
        this.contentAnimatable = animatable2;
        this.animationSpecForExpand = animationSpec;
        this.animationSpecForCollapse = animationSpec2;
        this.animationSpecForContentFadeIn = animationSpec3;
        this.animationSpecForContentFadeOut = animationSpec4;
        this.expandsToFullScreen = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.collapsedCoords = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.SearchBarState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SearchBarState.currentValue_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final Animatable<Float, AnimationVector1D> getAnimatable$material3() {
        return this.animatable;
    }

    public SearchBarState(SearchBarValue searchBarValue, AnimationSpec<Float> animationSpec, AnimationSpec<Float> animationSpec2) {
        this(AnimatableKt.Animatable$default(searchBarValue == SearchBarValue.Expanded ? 1.0f : 0.0f, 0.0f, 2, null), AnimatableKt.Animatable$default(searchBarValue != SearchBarValue.Expanded ? 0.0f : 1.0f, 0.0f, 2, null), animationSpec, animationSpec2, AnimationSpecKt.snap$default(0, 1, null), AnimationSpecKt.snap$default(0, 1, null));
    }

    public SearchBarState(SearchBarValue searchBarValue, AnimationSpec<Float> animationSpec, AnimationSpec<Float> animationSpec2, AnimationSpec<Float> animationSpec3, AnimationSpec<Float> animationSpec4) {
        this(AnimatableKt.Animatable$default(searchBarValue == SearchBarValue.Expanded ? 1.0f : 0.0f, 0.0f, 2, null), AnimatableKt.Animatable$default(searchBarValue != SearchBarValue.Expanded ? 0.0f : 1.0f, 0.0f, 2, null), animationSpec, animationSpec2, animationSpec3, animationSpec4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getExpandsToFullScreen$material3() {
        return ((Boolean) this.expandsToFullScreen.getValue()).booleanValue();
    }

    public final void setExpandsToFullScreen$material3(boolean z) {
        this.expandsToFullScreen.setValue(Boolean.valueOf(z));
    }

    public final LayoutCoordinates getCollapsedCoords() {
        return (LayoutCoordinates) this.collapsedCoords.getValue();
    }

    public final void setCollapsedCoords(LayoutCoordinates layoutCoordinates) {
        this.collapsedCoords.setValue(layoutCoordinates);
    }

    public final float getProgress() {
        return RangesKt.coerceIn(this.animatable.getValue().floatValue(), 0.0f, 1.0f);
    }

    public final float getContentProgress$material3() {
        return RangesKt.coerceIn(this.contentAnimatable.getValue().floatValue(), 0.0f, 1.0f);
    }

    public final boolean isAnimating() {
        return this.animatable.isRunning();
    }

    public final SearchBarValue getTargetValue() {
        if (this.animatable.getTargetValue().floatValue() == 1.0f) {
            return SearchBarValue.Expanded;
        }
        return SearchBarValue.Collapsed;
    }

    public final SearchBarValue getCurrentValue() {
        return (SearchBarValue) this.currentValue.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchBarValue currentValue_delegate$lambda$0(SearchBarState searchBarState) {
        if (searchBarState.animatable.getValue().floatValue() == 0.0f) {
            return SearchBarValue.Collapsed;
        }
        return SearchBarValue.Expanded;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, null, null, r6, 12, null) == r0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateToExpanded(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.compose.material3.SearchBarState.C07291
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material3.SearchBarState$animateToExpanded$1 r0 = (androidx.compose.material3.SearchBarState.C07291) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.material3.SearchBarState$animateToExpanded$1 r0 = new androidx.compose.material3.SearchBarState$animateToExpanded$1
            r0.<init>(r12)
        L19:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r9 = 1065353216(0x3f800000, float:1.0)
            r10 = 2
            r2 = 1
            if (r1 == 0) goto L3d
            if (r1 == r2) goto L39
            if (r1 != r10) goto L30
            kotlin.ResultKt.throwOnFailure(r12)
            goto L6d
        L30:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L57
        L3d:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r1 = r11.animatable
            r12 = r2
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r9)
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r3 = r11.animationSpecForExpand
            r6.label = r12
            r4 = 0
            r5 = 0
            r7 = 12
            r8 = 0
            java.lang.Object r12 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 != r0) goto L57
            goto L6c
        L57:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r1 = r11.contentAnimatable
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r9)
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r3 = r11.animationSpecForContentFadeIn
            r6.label = r10
            r4 = 0
            r5 = 0
            r7 = 12
            r8 = 0
            java.lang.Object r11 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto L6d
        L6c:
            return r0
        L6d:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarState.animateToExpanded(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, null, null, r6, 12, null) == r0) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateToCollapsed(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.compose.material3.SearchBarState.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material3.SearchBarState$animateToCollapsed$1 r0 = (androidx.compose.material3.SearchBarState.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            androidx.compose.material3.SearchBarState$animateToCollapsed$1 r0 = new androidx.compose.material3.SearchBarState$animateToCollapsed$1
            r0.<init>(r12)
        L19:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r9 = 0
            r10 = 2
            r2 = 1
            if (r1 == 0) goto L3c
            if (r1 == r2) goto L38
            if (r1 != r10) goto L2f
            kotlin.ResultKt.throwOnFailure(r12)
            goto L6c
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L38:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L56
        L3c:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r1 = r11.contentAnimatable
            r12 = r2
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r9)
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r3 = r11.animationSpecForContentFadeOut
            r6.label = r12
            r4 = 0
            r5 = 0
            r7 = 12
            r8 = 0
            java.lang.Object r12 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 != r0) goto L56
            goto L6b
        L56:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r1 = r11.animatable
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r9)
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r3 = r11.animationSpecForCollapse
            r6.label = r10
            r4 = 0
            r5 = 0
            r7 = 12
            r8 = 0
            java.lang.Object r11 = androidx.compose.animation.core.Animatable.animateTo$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto L6c
        L6b:
            return r0
        L6c:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarState.animateToCollapsed(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object snapTo(float f, Continuation<? super Unit> continuation) {
        Object objSnapTo = this.animatable.snapTo(Boxing.boxFloat(f), continuation);
        return objSnapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSnapTo : Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: SearchBar.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\t\u0012\u0002\b\u00030\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bJH\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\t\u0012\u0002\b\u00030\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/SearchBarState$Companion;", "", "<init>", "()V", "Collapsed", "", "Expanded", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SearchBarState;", "animationSpecForExpand", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpecForCollapse", "animationSpecForContentFadeIn", "animationSpecForContentFadeOut", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<SearchBarState, ?> Saver(final AnimationSpec<Float> animationSpecForExpand, final AnimationSpec<Float> animationSpecForCollapse) {
            return ListSaverKt.listSaver(new Function2() { // from class: androidx.compose.material3.SearchBarState$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarState.Companion.Saver$lambda$0((SaverScope) obj, (SearchBarState) obj2);
                }
            }, new Function1() { // from class: androidx.compose.material3.SearchBarState$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SearchBarState.Companion.Saver$lambda$1(animationSpecForExpand, animationSpecForCollapse, (List) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List Saver$lambda$0(SaverScope saverScope, SearchBarState searchBarState) {
            return CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(searchBarState.getProgress()), Float.valueOf(searchBarState.getContentProgress$material3())});
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SearchBarState Saver$lambda$1(AnimationSpec animationSpec, AnimationSpec animationSpec2, List list) {
            return new SearchBarState(new Animatable(list.get(0), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null), new Animatable(list.get(1), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null), animationSpec, animationSpec2, AnimationSpecKt.snap$default(0, 1, null), AnimationSpecKt.snap$default(0, 1, null), null);
        }

        public final Saver<SearchBarState, ?> Saver(final AnimationSpec<Float> animationSpecForExpand, final AnimationSpec<Float> animationSpecForCollapse, final AnimationSpec<Float> animationSpecForContentFadeIn, final AnimationSpec<Float> animationSpecForContentFadeOut) {
            return ListSaverKt.listSaver(new Function2() { // from class: androidx.compose.material3.SearchBarState$Companion$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarState.Companion.Saver$lambda$2((SaverScope) obj, (SearchBarState) obj2);
                }
            }, new Function1() { // from class: androidx.compose.material3.SearchBarState$Companion$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SearchBarState.Companion.Saver$lambda$3(animationSpecForExpand, animationSpecForCollapse, animationSpecForContentFadeIn, animationSpecForContentFadeOut, (List) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List Saver$lambda$2(SaverScope saverScope, SearchBarState searchBarState) {
            return CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(searchBarState.getProgress()), Float.valueOf(searchBarState.getContentProgress$material3())});
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SearchBarState Saver$lambda$3(AnimationSpec animationSpec, AnimationSpec animationSpec2, AnimationSpec animationSpec3, AnimationSpec animationSpec4, List list) {
            return new SearchBarState(new Animatable(list.get(0), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null), new Animatable(list.get(1), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null), animationSpec, animationSpec2, animationSpec3, animationSpec4, null);
        }
    }
}
