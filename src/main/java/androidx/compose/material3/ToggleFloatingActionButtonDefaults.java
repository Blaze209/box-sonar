package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: FloatingActionButtonMenu.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0005J\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0005J\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0005J+\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0011J\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0005J\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0005J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0005J/\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0019\u0010\u000bJ+\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u0011J\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0005J\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0005J\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0005JK\u0010\u001e\u001a\u00020\u001f*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060!2\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0005H\u0007¢\u0006\u0002\u0010$¨\u0006%"}, d2 = {"Landroidx/compose/material3/ToggleFloatingActionButtonDefaults;", "", "<init>", "()V", "containerColor", "Lkotlin/Function1;", "", "Landroidx/compose/ui/graphics/Color;", "initialColor", "finalColor", "containerColor-dgg9oW8", "(JJLandroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function1;", "containerSize", "Landroidx/compose/ui/unit/Dp;", "initialSize", "finalSize", "containerSize-YgX7TsA", "(FF)Lkotlin/jvm/functions/Function1;", "containerSizeMedium", "containerSizeLarge", "containerCornerRadius", "containerCornerRadius-YgX7TsA", "containerCornerRadiusMedium", "containerCornerRadiusLarge", "iconColor", "iconColor-dgg9oW8", "iconSize", "iconSize-YgX7TsA", "iconSizeMedium", "iconSizeLarge", "animateIcon", "Landroidx/compose/ui/Modifier;", "checkedProgress", "Lkotlin/Function0;", "color", "size", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ToggleFloatingActionButtonDefaults {
    public static final int $stable = 0;
    public static final ToggleFloatingActionButtonDefaults INSTANCE = new ToggleFloatingActionButtonDefaults();

    private ToggleFloatingActionButtonDefaults() {
    }

    /* JADX INFO: renamed from: containerColor-dgg9oW8, reason: not valid java name */
    public final Function1<Float, Color> m4622containerColordgg9oW8(final long j, final long j2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1880162323, "C(containerColor)N(initialColor:c#ui.graphics.Color,finalColor:c#ui.graphics.Color)583@25747L11,584@25819L11,585@25866L56:FloatingActionButtonMenu.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getPrimaryContainer();
        }
        if ((i2 & 2) != 0) {
            j2 = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getPrimary();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1880162323, i, -1, "androidx.compose.material3.ToggleFloatingActionButtonDefaults.containerColor (FloatingActionButtonMenu.kt:585)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1345233301, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(j)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(j2)) || (i & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function1) new Function1<Float, Color>() { // from class: androidx.compose.material3.ToggleFloatingActionButtonDefaults$containerColor$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Color invoke(Float f) {
                    return Color.m6804boximpl(m4627invokevNxB06k(f.floatValue()));
                }

                /* JADX INFO: renamed from: invoke-vNxB06k, reason: not valid java name */
                public final long m4627invokevNxB06k(float f) {
                    return ColorKt.m6865lerpjxsXWHM(j, j2, f);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function1<Float, Color> function1 = (Function1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function1;
    }

    /* JADX INFO: renamed from: containerSize-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ Function1 m4620containerSizeYgX7TsA$default(ToggleFloatingActionButtonDefaults toggleFloatingActionButtonDefaults, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = FloatingActionButtonMenuKt.FabFinalSize;
        }
        return toggleFloatingActionButtonDefaults.m4624containerSizeYgX7TsA(f, f2);
    }

    /* JADX INFO: renamed from: containerSize-YgX7TsA, reason: not valid java name */
    public final Function1<Float, Dp> m4624containerSizeYgX7TsA(final float initialSize, final float finalSize) {
        return new Function1() { // from class: androidx.compose.material3.ToggleFloatingActionButtonDefaults$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ToggleFloatingActionButtonDefaults.containerSize_YgX7TsA$lambda$0(initialSize, finalSize, ((Float) obj).floatValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp containerSize_YgX7TsA$lambda$0(float f, float f2, float f3) {
        return Dp.m9685boximpl(DpKt.m9730lerpMdfbLM(f, f2, f3));
    }

    public final Function1<Float, Dp> containerSize() {
        return m4620containerSizeYgX7TsA$default(this, FloatingActionButtonMenuKt.FabInitialSize, 0.0f, 2, null);
    }

    public final Function1<Float, Dp> containerSizeMedium() {
        return m4620containerSizeYgX7TsA$default(this, FloatingActionButtonMenuKt.FabMediumInitialSize, 0.0f, 2, null);
    }

    public final Function1<Float, Dp> containerSizeLarge() {
        return m4620containerSizeYgX7TsA$default(this, FloatingActionButtonMenuKt.FabLargeInitialSize, 0.0f, 2, null);
    }

    /* JADX INFO: renamed from: containerCornerRadius-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ Function1 m4619containerCornerRadiusYgX7TsA$default(ToggleFloatingActionButtonDefaults toggleFloatingActionButtonDefaults, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = FloatingActionButtonMenuKt.FabFinalCornerRadius;
        }
        return toggleFloatingActionButtonDefaults.m4623containerCornerRadiusYgX7TsA(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp containerCornerRadius_YgX7TsA$lambda$0(float f, float f2, float f3) {
        return Dp.m9685boximpl(DpKt.m9730lerpMdfbLM(f, f2, f3));
    }

    /* JADX INFO: renamed from: containerCornerRadius-YgX7TsA, reason: not valid java name */
    public final Function1<Float, Dp> m4623containerCornerRadiusYgX7TsA(final float initialSize, final float finalSize) {
        return new Function1() { // from class: androidx.compose.material3.ToggleFloatingActionButtonDefaults$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ToggleFloatingActionButtonDefaults.containerCornerRadius_YgX7TsA$lambda$0(initialSize, finalSize, ((Float) obj).floatValue());
            }
        };
    }

    public final Function1<Float, Dp> containerCornerRadius() {
        return m4619containerCornerRadiusYgX7TsA$default(this, FloatingActionButtonMenuKt.FabInitialCornerRadius, 0.0f, 2, null);
    }

    public final Function1<Float, Dp> containerCornerRadiusMedium() {
        return m4619containerCornerRadiusYgX7TsA$default(this, FloatingActionButtonMenuKt.FabMediumInitialCornerRadius, 0.0f, 2, null);
    }

    public final Function1<Float, Dp> containerCornerRadiusLarge() {
        return m4619containerCornerRadiusYgX7TsA$default(this, FloatingActionButtonMenuKt.FabLargeInitialCornerRadius, 0.0f, 2, null);
    }

    /* JADX INFO: renamed from: iconColor-dgg9oW8, reason: not valid java name */
    public final Function1<Float, Color> m4625iconColordgg9oW8(final long j, final long j2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1334162535, "C(iconColor)N(initialColor:c#ui.graphics.Color,finalColor:c#ui.graphics.Color)610@26796L11,611@26870L11,612@26919L56:FloatingActionButtonMenu.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getOnPrimaryContainer();
        }
        if ((i2 & 2) != 0) {
            j2 = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getOnPrimary();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1334162535, i, -1, "androidx.compose.material3.ToggleFloatingActionButtonDefaults.iconColor (FloatingActionButtonMenu.kt:612)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -2065019489, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(j)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(j2)) || (i & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function1) new Function1<Float, Color>() { // from class: androidx.compose.material3.ToggleFloatingActionButtonDefaults$iconColor$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Color invoke(Float f) {
                    return Color.m6804boximpl(m4628invokevNxB06k(f.floatValue()));
                }

                /* JADX INFO: renamed from: invoke-vNxB06k, reason: not valid java name */
                public final long m4628invokevNxB06k(float f) {
                    return ColorKt.m6865lerpjxsXWHM(j, j2, f);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function1<Float, Color> function1 = (Function1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function1;
    }

    /* JADX INFO: renamed from: iconSize-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ Function1 m4621iconSizeYgX7TsA$default(ToggleFloatingActionButtonDefaults toggleFloatingActionButtonDefaults, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = FloatingActionButtonMenuKt.FabFinalIconSize;
        }
        return toggleFloatingActionButtonDefaults.m4626iconSizeYgX7TsA(f, f2);
    }

    /* JADX INFO: renamed from: iconSize-YgX7TsA, reason: not valid java name */
    public final Function1<Float, Dp> m4626iconSizeYgX7TsA(final float initialSize, final float finalSize) {
        return new Function1() { // from class: androidx.compose.material3.ToggleFloatingActionButtonDefaults$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ToggleFloatingActionButtonDefaults.iconSize_YgX7TsA$lambda$0(initialSize, finalSize, ((Float) obj).floatValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp iconSize_YgX7TsA$lambda$0(float f, float f2, float f3) {
        return Dp.m9685boximpl(DpKt.m9730lerpMdfbLM(f, f2, f3));
    }

    public final Function1<Float, Dp> iconSize() {
        return m4621iconSizeYgX7TsA$default(this, FloatingActionButtonMenuKt.FabInitialIconSize, 0.0f, 2, null);
    }

    public final Function1<Float, Dp> iconSizeMedium() {
        return m4621iconSizeYgX7TsA$default(this, FloatingActionButtonMenuKt.FabMediumInitialIconSize, 0.0f, 2, null);
    }

    public final Function1<Float, Dp> iconSizeLarge() {
        return m4621iconSizeYgX7TsA$default(this, FloatingActionButtonMenuKt.FabLargeInitialIconSize, 0.0f, 2, null);
    }

    public final Modifier animateIcon(Modifier modifier, final Function0<Float> function0, final Function1<? super Float, Color> function1, Function1<? super Float, Dp> function2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 961635008, "C(animateIcon)N(checkedProgress,color,size)635@27845L11,638@27928L248,643@28204L312:FloatingActionButtonMenu.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            function1 = m4625iconColordgg9oW8(0L, 0L, composer, (i >> 6) & 896, 3);
        }
        final Function1<? super Float, Dp> function1IconSize = (i2 & 4) != 0 ? iconSize() : function2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(961635008, i, -1, "androidx.compose.material3.ToggleFloatingActionButtonDefaults.animateIcon (FloatingActionButtonMenu.kt:638)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 713280088, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
        int i3 = (i & 112) ^ 48;
        boolean z = ((((i & 7168) ^ 3072) > 2048 && composer.changed(function1IconSize)) || (i & 3072) == 2048) | ((i3 > 32 && composer.changed(function0)) || (i & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function3() { // from class: androidx.compose.material3.ToggleFloatingActionButtonDefaults$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ToggleFloatingActionButtonDefaults.animateIcon$lambda$0$0(function1IconSize, function0, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierLayout = LayoutModifierKt.layout(modifier, (Function3) objRememberedValue);
        ComposerKt.sourceInformationMarkerStart(composer, 713288984, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
        boolean z2 = ((((i & 896) ^ 384) > 256 && composer.changed(function1)) || (i & 384) == 256) | ((i3 > 32 && composer.changed(function0)) || (i & 48) == 32);
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ToggleFloatingActionButtonDefaults$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ToggleFloatingActionButtonDefaults.animateIcon$lambda$1$0(function1, function0, (CacheDrawScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierDrawWithCache = DrawModifierKt.drawWithCache(modifierLayout, (Function1) objRememberedValue2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifierDrawWithCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult animateIcon$lambda$0$0(Function1 function1, Function0 function0, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        int i = measureScope.mo748roundToPx0680j_4(((Dp) function1.invoke(function0.invoke())).m9701unboximpl());
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(i, i));
        return MeasureScope.layout$default(measureScope, i, i, null, new Function1() { // from class: androidx.compose.material3.ToggleFloatingActionButtonDefaults$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ToggleFloatingActionButtonDefaults.animateIcon$lambda$0$0$0(placeableMo8265measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateIcon$lambda$0$0$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult animateIcon$lambda$1$0(Function1 function1, Function0 function0, CacheDrawScope cacheDrawScope) {
        final GraphicsLayer graphicsLayerObtainGraphicsLayer = cacheDrawScope.obtainGraphicsLayer();
        CacheDrawScope.m6348recordTdoYBX4$default(cacheDrawScope, graphicsLayerObtainGraphicsLayer, null, null, 0L, new Function1() { // from class: androidx.compose.material3.ToggleFloatingActionButtonDefaults$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ToggleFloatingActionButtonDefaults.animateIcon$lambda$1$0$0$0((ContentDrawScope) obj);
            }
        }, 7, null);
        graphicsLayerObtainGraphicsLayer.setColorFilter(ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, ((Color) function1.invoke(function0.invoke())).m6824unboximpl(), 0, 2, null));
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.material3.ToggleFloatingActionButtonDefaults$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ToggleFloatingActionButtonDefaults.animateIcon$lambda$1$0$1(graphicsLayerObtainGraphicsLayer, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateIcon$lambda$1$0$0$0(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateIcon$lambda$1$0$1(GraphicsLayer graphicsLayer, ContentDrawScope contentDrawScope) {
        GraphicsLayerKt.drawLayer(contentDrawScope, graphicsLayer);
        return Unit.INSTANCE;
    }
}
