package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FloatingToolbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001B\u0092\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u001c\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u001d¢\u0006\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010 R\u001e\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0012\u001a\u00020\u0013¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0017\u001a\u00020\u0018¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0013\u0010\u0019\u001a\u00020\u0018¢\u0006\n\n\u0002\u00105\u001a\u0004\b6\u00104R)\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u001b¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u001d¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Landroidx/compose/material3/HorizontalFloatingToolbarWithFabOverrideScope;", "", "isExpanded", "", "floatingActionButton", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "Landroidx/compose/material3/FloatingToolbarColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "scrollBehavior", "Landroidx/compose/material3/FloatingToolbarScrollBehavior;", "shape", "Landroidx/compose/ui/graphics/Shape;", "floatingActionButtonPosition", "Landroidx/compose/material3/FloatingToolbarHorizontalFabPosition;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "expandedShadowElevation", "Landroidx/compose/ui/unit/Dp;", "collapsedShadowElevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "<init>", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/FloatingToolbarColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/FloatingToolbarScrollBehavior;Landroidx/compose/ui/graphics/Shape;ILandroidx/compose/animation/core/FiniteAnimationSpec;FFLkotlin/jvm/functions/Function3;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "getFloatingActionButton", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getModifier", "()Landroidx/compose/ui/Modifier;", "getColors", "()Landroidx/compose/material3/FloatingToolbarColors;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "getScrollBehavior", "()Landroidx/compose/material3/FloatingToolbarScrollBehavior;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getFloatingActionButtonPosition-EdPuMIg", "()I", "I", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getExpandedShadowElevation-D9Ej5fM", "()F", "F", "getCollapsedShadowElevation-D9Ej5fM", "getContent", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HorizontalFloatingToolbarWithFabOverrideScope {
    public static final int $stable = 8;
    private final FiniteAnimationSpec<Float> animationSpec;
    private final float collapsedShadowElevation;
    private final FloatingToolbarColors colors;
    private final Function3<RowScope, Composer, Integer, Unit> content;
    private final PaddingValues contentPadding;
    private final float expandedShadowElevation;
    private final Function2<Composer, Integer, Unit> floatingActionButton;
    private final int floatingActionButtonPosition;
    private final boolean isExpanded;
    private final Modifier modifier;
    private final FloatingToolbarScrollBehavior scrollBehavior;
    private final Shape shape;

    public /* synthetic */ HorizontalFloatingToolbarWithFabOverrideScope(boolean z, Function2 function2, Modifier modifier, FloatingToolbarColors floatingToolbarColors, PaddingValues paddingValues, FloatingToolbarScrollBehavior floatingToolbarScrollBehavior, Shape shape, int i, FiniteAnimationSpec finiteAnimationSpec, float f, float f2, Function3 function3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, function2, modifier, floatingToolbarColors, paddingValues, floatingToolbarScrollBehavior, shape, i, finiteAnimationSpec, f, f2, function3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private HorizontalFloatingToolbarWithFabOverrideScope(boolean z, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, FloatingToolbarColors floatingToolbarColors, PaddingValues paddingValues, FloatingToolbarScrollBehavior floatingToolbarScrollBehavior, Shape shape, int i, FiniteAnimationSpec<Float> finiteAnimationSpec, float f, float f2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3) {
        this.isExpanded = z;
        this.floatingActionButton = function2;
        this.modifier = modifier;
        this.colors = floatingToolbarColors;
        this.contentPadding = paddingValues;
        this.scrollBehavior = floatingToolbarScrollBehavior;
        this.shape = shape;
        this.floatingActionButtonPosition = i;
        this.animationSpec = finiteAnimationSpec;
        this.expandedShadowElevation = f;
        this.collapsedShadowElevation = f2;
        this.content = function3;
    }

    /* JADX INFO: renamed from: isExpanded, reason: from getter */
    public final boolean getIsExpanded() {
        return this.isExpanded;
    }

    public final Function2<Composer, Integer, Unit> getFloatingActionButton() {
        return this.floatingActionButton;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    public final FloatingToolbarColors getColors() {
        return this.colors;
    }

    public final PaddingValues getContentPadding() {
        return this.contentPadding;
    }

    public final FloatingToolbarScrollBehavior getScrollBehavior() {
        return this.scrollBehavior;
    }

    public final Shape getShape() {
        return this.shape;
    }

    /* JADX INFO: renamed from: getFloatingActionButtonPosition-EdPuMIg, reason: not valid java name and from getter */
    public final int getFloatingActionButtonPosition() {
        return this.floatingActionButtonPosition;
    }

    public final FiniteAnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    /* JADX INFO: renamed from: getExpandedShadowElevation-D9Ej5fM, reason: not valid java name and from getter */
    public final float getExpandedShadowElevation() {
        return this.expandedShadowElevation;
    }

    /* JADX INFO: renamed from: getCollapsedShadowElevation-D9Ej5fM, reason: not valid java name and from getter */
    public final float getCollapsedShadowElevation() {
        return this.collapsedShadowElevation;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getContent() {
        return this.content;
    }
}
