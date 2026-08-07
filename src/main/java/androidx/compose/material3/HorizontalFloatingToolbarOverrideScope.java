package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FloatingToolbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001B©\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013\u0012\u001e\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013¢\u0006\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R+\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R+\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'R\u0013\u0010\u0015\u001a\u00020\u0016¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0013\u0010\u0017\u001a\u00020\u0016¢\u0006\n\n\u0002\u0010,\u001a\u0004\b-\u0010+R)\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013¢\u0006\n\n\u0002\u0010(\u001a\u0004\b.\u0010'¨\u0006/"}, d2 = {"Landroidx/compose/material3/HorizontalFloatingToolbarOverrideScope;", "", "isExpanded", "", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "Landroidx/compose/material3/FloatingToolbarColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "scrollBehavior", "Landroidx/compose/material3/FloatingToolbarScrollBehavior;", "shape", "Landroidx/compose/ui/graphics/Shape;", "leadingContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "trailingContent", "expandedShadowElevation", "Landroidx/compose/ui/unit/Dp;", "collapsedShadowElevation", "content", "<init>", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/material3/FloatingToolbarColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/FloatingToolbarScrollBehavior;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;FFLkotlin/jvm/functions/Function3;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "getModifier", "()Landroidx/compose/ui/Modifier;", "getColors", "()Landroidx/compose/material3/FloatingToolbarColors;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "getScrollBehavior", "()Landroidx/compose/material3/FloatingToolbarScrollBehavior;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getLeadingContent", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getTrailingContent", "getExpandedShadowElevation-D9Ej5fM", "()F", "F", "getCollapsedShadowElevation-D9Ej5fM", "getContent", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HorizontalFloatingToolbarOverrideScope {
    public static final int $stable = 0;
    private final float collapsedShadowElevation;
    private final FloatingToolbarColors colors;
    private final Function3<RowScope, Composer, Integer, Unit> content;
    private final PaddingValues contentPadding;
    private final float expandedShadowElevation;
    private final boolean isExpanded;
    private final Function3<RowScope, Composer, Integer, Unit> leadingContent;
    private final Modifier modifier;
    private final FloatingToolbarScrollBehavior scrollBehavior;
    private final Shape shape;
    private final Function3<RowScope, Composer, Integer, Unit> trailingContent;

    public /* synthetic */ HorizontalFloatingToolbarOverrideScope(boolean z, Modifier modifier, FloatingToolbarColors floatingToolbarColors, PaddingValues paddingValues, FloatingToolbarScrollBehavior floatingToolbarScrollBehavior, Shape shape, Function3 function3, Function3 function4, float f, float f2, Function3 function5, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, modifier, floatingToolbarColors, paddingValues, floatingToolbarScrollBehavior, shape, function3, function4, f, f2, function5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private HorizontalFloatingToolbarOverrideScope(boolean z, Modifier modifier, FloatingToolbarColors floatingToolbarColors, PaddingValues paddingValues, FloatingToolbarScrollBehavior floatingToolbarScrollBehavior, Shape shape, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4, float f, float f2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function5) {
        this.isExpanded = z;
        this.modifier = modifier;
        this.colors = floatingToolbarColors;
        this.contentPadding = paddingValues;
        this.scrollBehavior = floatingToolbarScrollBehavior;
        this.shape = shape;
        this.leadingContent = function3;
        this.trailingContent = function4;
        this.expandedShadowElevation = f;
        this.collapsedShadowElevation = f2;
        this.content = function5;
    }

    /* JADX INFO: renamed from: isExpanded, reason: from getter */
    public final boolean getIsExpanded() {
        return this.isExpanded;
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

    public final Function3<RowScope, Composer, Integer, Unit> getLeadingContent() {
        return this.leadingContent;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getTrailingContent() {
        return this.trailingContent;
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
