package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.material3.tokens.FabBaselineTokens;
import androidx.compose.material3.tokens.FabLargeTokens;
import androidx.compose.material3.tokens.FabMediumTokens;
import androidx.compose.material3.tokens.FabMenuBaselineTokens;
import androidx.compose.material3.tokens.FabPrimaryContainerTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.HorizontalRuler;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FloatingActionButtonMenu.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aZ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001aQ\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u000eH\u0003¢\u0006\u0002\u0010\u0013\u001ae\u0010\u0014\u001a\u00020\u0001*\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u009d\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00032\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\f2\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00190\f2\b\b\u0002\u0010#\u001a\u00020$2\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020&0\f2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020&0\f2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010)\u001a«\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00032\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00190\f2\b\b\u0002\u0010#\u001a\u00020$2\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020&0\f2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020&0\f2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u000eH\u0003¢\u0006\u0002\u0010+\u001a\u001a\u0010,\u001a\u00020\b*\u00020\b2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0003\"\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010-\u001a\u00020\u0003*\u00020.8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010/\"\u0010\u00100\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u00102\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u00103\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u00104\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u00105\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u00106\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u00107\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u00108\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u00109\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u0010:\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u0010;\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u0010<\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u0010=\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u0010>\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u0010?\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u0010@\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u0010A\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u0010B\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u0010C\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u0010D\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u0010E\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101\"\u0010\u0010F\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u00101¨\u0006G²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010H\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010I\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\u0018\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020L\u0018\u00010KX\u008a\u008e\u0002²\u0006\u0018\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020L\u0018\u00010KX\u008a\u008e\u0002²\u0006\u0018\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020L\u0018\u00010KX\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"FloatingActionButtonMenu", "", "expanded", "", "button", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/FloatingActionButtonMenuScope;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FloatingActionButtonMenuItemColumn", "buttonHeight", "", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "FloatingActionButtonMenuItem", ViewProps.ON_CLICK, "text", HubsObservability.HUB_ASSET_ICON, "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "FloatingActionButtonMenuItem-WMdw5o4", "(Landroidx/compose/material3/FloatingActionButtonMenuScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "MenuItemRuler", "Landroidx/compose/ui/layout/HorizontalRuler;", "ToggleFloatingActionButton", "checked", "onCheckedChange", "", "contentAlignment", "Landroidx/compose/ui/Alignment;", "containerSize", "Landroidx/compose/ui/unit/Dp;", "containerCornerRadius", "Landroidx/compose/material3/ToggleFloatingActionButtonScope;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "checkedProgress", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "itemVisible", "isVisible", "Landroidx/compose/ui/layout/Placeable;", "(Landroidx/compose/ui/layout/Placeable;)Z", "FabInitialSize", "F", "FabInitialCornerRadius", "FabInitialIconSize", "FabMediumInitialSize", "FabMediumInitialCornerRadius", "FabMediumInitialIconSize", "FabLargeInitialSize", "FabLargeInitialCornerRadius", "FabLargeInitialIconSize", "FabFinalSize", "FabFinalCornerRadius", "FabFinalIconSize", "FabShadowElevation", "FabMenuPaddingHorizontal", "FabMenuPaddingBottom", "FabMenuButtonPaddingBottom", "FabMenuItemMinWidth", "FabMenuItemHeight", "FabMenuItemSpacingVertical", "FabMenuItemContentPaddingStart", "FabMenuItemContentPaddingEnd", "FabMenuItemContentSpacingHorizontal", "material3", "itemCount", "itemsNeedVerticalScroll", "staggerAnim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "widthAnim", "alphaAnim"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FloatingActionButtonMenuKt {
    private static final float FabFinalCornerRadius;
    private static final float FabFinalIconSize;
    private static final float FabFinalSize;
    private static final float FabInitialCornerRadius;
    private static final float FabMenuButtonPaddingBottom;
    private static final float FabMenuItemContentPaddingEnd;
    private static final float FabMenuItemContentPaddingStart;
    private static final float FabMenuItemContentSpacingHorizontal;
    private static final float FabMenuItemHeight;
    private static final float FabMenuItemMinWidth;
    private static final float FabMenuItemSpacingVertical;
    private static final float FabMenuPaddingBottom;
    private static final float FabMenuPaddingHorizontal;
    private static final float FabShadowElevation;
    private static final HorizontalRuler MenuItemRuler = new HorizontalRuler();
    private static final float FabInitialSize = FabBaselineTokens.INSTANCE.m5394getContainerHeightD9Ej5fM();
    private static final float FabInitialIconSize = FabBaselineTokens.INSTANCE.m5396getIconSizeD9Ej5fM();
    private static final float FabMediumInitialSize = FabMediumTokens.INSTANCE.m5400getContainerHeightD9Ej5fM();
    private static final float FabMediumInitialCornerRadius = Dp.m9687constructorimpl(20);
    private static final float FabMediumInitialIconSize = FabMediumTokens.INSTANCE.m5402getIconSizeD9Ej5fM();
    private static final float FabLargeInitialSize = FabLargeTokens.INSTANCE.m5397getContainerHeightD9Ej5fM();
    private static final float FabLargeInitialCornerRadius = Dp.m9687constructorimpl(28);
    private static final float FabLargeInitialIconSize = Dp.m9687constructorimpl(36);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButtonMenu$lambda$6(boolean z, Function2 function2, Modifier modifier, Alignment.Horizontal horizontal, Function3 function3, int i, int i2, Composer composer, int i3) {
        FloatingActionButtonMenu(z, function2, modifier, horizontal, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButtonMenuItemColumn$lambda$12(Modifier modifier, boolean z, Alignment.Horizontal horizontal, Function0 function0, Function3 function3, int i, Composer composer, int i2) {
        FloatingActionButtonMenuItemColumn(modifier, z, horizontal, function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButtonMenuItem_WMdw5o4$lambda$10(FloatingActionButtonMenuScope floatingActionButtonMenuScope, Function0 function0, Function2 function2, Function2 function3, Modifier modifier, long j, long j2, int i, int i2, Composer composer, int i3) {
        m3410FloatingActionButtonMenuItemWMdw5o4(floatingActionButtonMenuScope, function0, function2, function3, modifier, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleFloatingActionButton$lambda$1(boolean z, Function1 function1, Modifier modifier, Function1 function2, Alignment alignment, Function1 function3, Function1 function4, Function3 function5, int i, int i2, Composer composer, int i3) {
        ToggleFloatingActionButton(z, function1, modifier, function2, alignment, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleFloatingActionButton$lambda$4(boolean z, Function1 function1, Function0 function0, Modifier modifier, Function1 function2, Alignment alignment, Function1 function3, Function1 function4, Function3 function5, int i, int i2, Composer composer, int i3) {
        ToggleFloatingActionButton(z, function1, function0, modifier, function2, alignment, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0217  */
    /* JADX WARN: Code duplicated, block: B:103:0x0263  */
    /* JADX WARN: Code duplicated, block: B:106:0x026f  */
    /* JADX WARN: Code duplicated, block: B:107:0x0273  */
    /* JADX WARN: Code duplicated, block: B:110:0x0298  */
    /* JADX WARN: Code duplicated, block: B:112:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:115:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:117:0x0304  */
    /* JADX WARN: Code duplicated, block: B:120:0x030f  */
    /* JADX WARN: Code duplicated, block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005a  */
    /* JADX WARN: Code duplicated, block: B:33:0x005e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0066  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x007d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:49:0x008d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x009b  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:70:0x010a  */
    /* JADX WARN: Code duplicated, block: B:71:0x010d  */
    /* JADX WARN: Code duplicated, block: B:74:0x0114  */
    /* JADX WARN: Code duplicated, block: B:76:0x011c  */
    /* JADX WARN: Code duplicated, block: B:79:0x0157  */
    /* JADX WARN: Code duplicated, block: B:82:0x0163  */
    /* JADX WARN: Code duplicated, block: B:83:0x0167  */
    /* JADX WARN: Code duplicated, block: B:86:0x018c  */
    /* JADX WARN: Code duplicated, block: B:88:0x019a  */
    /* JADX WARN: Code duplicated, block: B:91:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:95:0x0207  */
    /* JADX WARN: Code duplicated, block: B:98:0x020f  */
    public static final void FloatingActionButtonMenu(final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Alignment.Horizontal horizontal, final Function3<? super FloatingActionButtonMenuScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Alignment.Horizontal horizontal2;
        int i5;
        int i6;
        boolean z2;
        final Modifier modifier3;
        final Alignment.Horizontal horizontal3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Alignment.Horizontal end;
        Object objRememberedValue;
        final MutableIntState mutableIntState;
        Object objRememberedValue2;
        final FocusRequester focusRequester;
        boolean z3;
        FloatingActionButtonMenuKt$FloatingActionButtonMenu$1$1 floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        Object objRememberedValue3;
        boolean z4;
        Object objRememberedValue4;
        int currentCompositeKeyHash2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM6062constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        int i7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1619207533);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FloatingActionButtonMenu)N(expanded,button,modifier,horizontalAlignment,content)121@5531L33,122@5590L29,154@6712L1462,124@5625L2549:FloatingActionButtonMenu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    horizontal2 = horizontal;
                    if (composerStartRestartGroup.changed(horizontal2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) != 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i6 = i3;
                if ((i6 & 9363) != 9362) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i6 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    horizontal3 = horizontal2;
                } else {
                    if (i8 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        end = Alignment.INSTANCE.getEnd();
                    } else {
                        end = horizontal2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1619207533, i6, -1, "androidx.compose.material3.FloatingActionButtonMenu (FloatingActionButtonMenu.kt:120)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1280269004, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1280267120, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    focusRequester = (FocusRequester) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(modifier4, FabMenuPaddingHorizontal, 0.0f, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1280229783, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    if ((i6 & 7168) == 2048) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3 || floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue = new FloatingActionButtonMenuKt$FloatingActionButtonMenu$1$1(mutableIntState, end);
                        composerStartRestartGroup.updateRememberedValue(floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 768392800, "C131@5913L16,127@5741L228,136@6024L615,135@5983L711:FloatingActionButtonMenu.kt#uh7d8r");
                    Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1499229222, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(FloatingActionButtonMenuKt.FloatingActionButtonMenu$lambda$1(mutableIntState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i9 = i6 >> 3;
                    FloatingActionButtonMenuItemColumn(modifierFocusRequester, z, end, (Function0) objRememberedValue3, function3, composerStartRestartGroup, (57344 & i6) | ((i6 << 3) & 112) | 3072 | (i9 & 896));
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1499225071, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    z4 = (i6 & 14) == 4;
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!z4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$FloatingActionButtonMenu$2$2$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                return m3411invokeZmokQxo(keyEvent.m7966unboximpl());
                            }

                            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                            public final Boolean m3411invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                if (z && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY()) && ((Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7905getTabEK5gGoQ()) && !KeyEvent_androidKt.m7983isShiftPressedZmokQxo(keyEvent)) || Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7742getDirectionDownEK5gGoQ()))) {
                                    FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                                    return true;
                                }
                                return false;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(companion, (Function1) objRememberedValue4);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnKeyEvent);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1412194219, "C151@6672L8:FloatingActionButtonMenu.kt#uh7d8r");
                    function2.invoke(composerStartRestartGroup, Integer.valueOf(i9 & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    horizontal3 = end;
                    modifier3 = modifier4;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonMenuKt.FloatingActionButtonMenu$lambda$6(z, function2, modifier3, horizontal3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            horizontal2 = horizontal;
            if ((i & 24576) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i6 = i3;
            if ((i6 & 9363) != 9362) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i6 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                horizontal3 = horizontal2;
            } else {
                if (i8 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    end = Alignment.INSTANCE.getEnd();
                } else {
                    end = horizontal2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1619207533, i6, -1, "androidx.compose.material3.FloatingActionButtonMenu (FloatingActionButtonMenu.kt:120)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1280269004, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableIntState = (MutableIntState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1280267120, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                focusRequester = (FocusRequester) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM1220paddingVpY3zN4$default2 = PaddingKt.m1220paddingVpY3zN4$default(modifier4, FabMenuPaddingHorizontal, 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1280229783, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                if ((i6 & 7168) == 2048) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue = new FloatingActionButtonMenuKt$FloatingActionButtonMenu$1$1(mutableIntState, end);
                    composerStartRestartGroup.updateRememberedValue(floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue);
                } else {
                    floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue = new FloatingActionButtonMenuKt$FloatingActionButtonMenu$1$1(mutableIntState, end);
                    composerStartRestartGroup.updateRememberedValue(floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue);
                }
                MeasurePolicy measurePolicy2 = (MeasurePolicy) floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 768392800, "C131@5913L16,127@5741L228,136@6024L615,135@5983L711:FloatingActionButtonMenu.kt#uh7d8r");
                Modifier modifierFocusRequester2 = FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1499229222, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(FloatingActionButtonMenuKt.FloatingActionButtonMenu$lambda$1(mutableIntState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i10 = i6 >> 3;
                FloatingActionButtonMenuItemColumn(modifierFocusRequester2, z, end, (Function0) objRememberedValue3, function3, composerStartRestartGroup, (57344 & i6) | ((i6 << 3) & 112) | 3072 | (i10 & 896));
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1499225071, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                if ((i6 & 14) == 4) {
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z4) {
                    objRememberedValue4 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$FloatingActionButtonMenu$2$2$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m3411invokeZmokQxo(keyEvent.m7966unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m3411invokeZmokQxo(android.view.KeyEvent keyEvent) {
                            if (z && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY()) && ((Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7905getTabEK5gGoQ()) && !KeyEvent_androidKt.m7983isShiftPressedZmokQxo(keyEvent)) || Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7742getDirectionDownEK5gGoQ()))) {
                                FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                                return true;
                            }
                            return false;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$FloatingActionButtonMenu$2$2$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m3411invokeZmokQxo(keyEvent.m7966unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m3411invokeZmokQxo(android.view.KeyEvent keyEvent) {
                            if (z && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY()) && ((Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7905getTabEK5gGoQ()) && !KeyEvent_androidKt.m7983isShiftPressedZmokQxo(keyEvent)) || Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7742getDirectionDownEK5gGoQ()))) {
                                FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                                return true;
                            }
                            return false;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnKeyEvent2 = KeyInputModifierKt.onKeyEvent(companion2, (Function1) objRememberedValue4);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnKeyEvent2);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting()) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1412194219, "C151@6672L8:FloatingActionButtonMenu.kt#uh7d8r");
                function2.invoke(composerStartRestartGroup, Integer.valueOf(i10 & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                horizontal3 = end;
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonMenuKt.FloatingActionButtonMenu$lambda$6(z, function2, modifier3, horizontal3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                horizontal2 = horizontal;
                if (composerStartRestartGroup.changed(horizontal2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i6 = i3;
            if ((i6 & 9363) != 9362) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i6 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                horizontal3 = horizontal2;
            } else {
                if (i8 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    end = Alignment.INSTANCE.getEnd();
                } else {
                    end = horizontal2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1619207533, i6, -1, "androidx.compose.material3.FloatingActionButtonMenu (FloatingActionButtonMenu.kt:120)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1280269004, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableIntState = (MutableIntState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1280267120, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                focusRequester = (FocusRequester) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM1220paddingVpY3zN4$default3 = PaddingKt.m1220paddingVpY3zN4$default(modifier4, FabMenuPaddingHorizontal, 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1280229783, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                if ((i6 & 7168) == 2048) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue = new FloatingActionButtonMenuKt$FloatingActionButtonMenu$1$1(mutableIntState, end);
                    composerStartRestartGroup.updateRememberedValue(floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue);
                } else {
                    floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue = new FloatingActionButtonMenuKt$FloatingActionButtonMenu$1$1(mutableIntState, end);
                    composerStartRestartGroup.updateRememberedValue(floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue);
                }
                MeasurePolicy measurePolicy3 = (MeasurePolicy) floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 768392800, "C131@5913L16,127@5741L228,136@6024L615,135@5983L711:FloatingActionButtonMenu.kt#uh7d8r");
                Modifier modifierFocusRequester3 = FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1499229222, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Integer.valueOf(FloatingActionButtonMenuKt.FloatingActionButtonMenu$lambda$1(mutableIntState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i11 = i6 >> 3;
                FloatingActionButtonMenuItemColumn(modifierFocusRequester3, z, end, (Function0) objRememberedValue3, function3, composerStartRestartGroup, (57344 & i6) | ((i6 << 3) & 112) | 3072 | (i11 & 896));
                Modifier.Companion companion3 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1499225071, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                if ((i6 & 14) == 4) {
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z4) {
                    objRememberedValue4 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$FloatingActionButtonMenu$2$2$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m3411invokeZmokQxo(keyEvent.m7966unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m3411invokeZmokQxo(android.view.KeyEvent keyEvent) {
                            if (z && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY()) && ((Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7905getTabEK5gGoQ()) && !KeyEvent_androidKt.m7983isShiftPressedZmokQxo(keyEvent)) || Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7742getDirectionDownEK5gGoQ()))) {
                                FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                                return true;
                            }
                            return false;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$FloatingActionButtonMenu$2$2$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m3411invokeZmokQxo(keyEvent.m7966unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m3411invokeZmokQxo(android.view.KeyEvent keyEvent) {
                            if (z && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY()) && ((Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7905getTabEK5gGoQ()) && !KeyEvent_androidKt.m7983isShiftPressedZmokQxo(keyEvent)) || Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7742getDirectionDownEK5gGoQ()))) {
                                FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                                return true;
                            }
                            return false;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnKeyEvent3 = KeyInputModifierKt.onKeyEvent(companion3, (Function1) objRememberedValue4);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnKeyEvent3);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting()) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1412194219, "C151@6672L8:FloatingActionButtonMenu.kt#uh7d8r");
                function2.invoke(composerStartRestartGroup, Integer.valueOf(i11 & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                horizontal3 = end;
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonMenuKt.FloatingActionButtonMenu$lambda$6(z, function2, modifier3, horizontal3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        horizontal2 = horizontal;
        if ((i & 24576) != 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i7 = 16384;
            } else {
                i7 = 8192;
            }
            i3 |= i7;
        }
        i6 = i3;
        if ((i6 & 9363) != 9362) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i6 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            horizontal3 = horizontal2;
        } else {
            if (i8 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                end = Alignment.INSTANCE.getEnd();
            } else {
                end = horizontal2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1619207533, i6, -1, "androidx.compose.material3.FloatingActionButtonMenu (FloatingActionButtonMenu.kt:120)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1280269004, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableIntState = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1280267120, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            focusRequester = (FocusRequester) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM1220paddingVpY3zN4$default4 = PaddingKt.m1220paddingVpY3zN4$default(modifier4, FabMenuPaddingHorizontal, 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1280229783, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            if ((i6 & 7168) == 2048) {
                z3 = true;
            } else {
                z3 = false;
            }
            floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue = new FloatingActionButtonMenuKt$FloatingActionButtonMenu$1$1(mutableIntState, end);
                composerStartRestartGroup.updateRememberedValue(floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue);
            } else {
                floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue = new FloatingActionButtonMenuKt$FloatingActionButtonMenu$1$1(mutableIntState, end);
                composerStartRestartGroup.updateRememberedValue(floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy4 = (MeasurePolicy) floatingActionButtonMenuKt$FloatingActionButtonMenu$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default4);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 768392800, "C131@5913L16,127@5741L228,136@6024L615,135@5983L711:FloatingActionButtonMenu.kt#uh7d8r");
            Modifier modifierFocusRequester4 = FocusRequesterModifierKt.focusRequester(Modifier.INSTANCE, focusRequester);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1499229222, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(FloatingActionButtonMenuKt.FloatingActionButtonMenu$lambda$1(mutableIntState));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i12 = i6 >> 3;
            FloatingActionButtonMenuItemColumn(modifierFocusRequester4, z, end, (Function0) objRememberedValue3, function3, composerStartRestartGroup, (57344 & i6) | ((i6 << 3) & 112) | 3072 | (i12 & 896));
            Modifier.Companion companion4 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1499225071, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            if ((i6 & 14) == 4) {
            }
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!z4) {
                objRememberedValue4 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$FloatingActionButtonMenu$2$2$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                        return m3411invokeZmokQxo(keyEvent.m7966unboximpl());
                    }

                    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                    public final Boolean m3411invokeZmokQxo(android.view.KeyEvent keyEvent) {
                        if (z && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY()) && ((Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7905getTabEK5gGoQ()) && !KeyEvent_androidKt.m7983isShiftPressedZmokQxo(keyEvent)) || Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7742getDirectionDownEK5gGoQ()))) {
                            FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                            return true;
                        }
                        return false;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$FloatingActionButtonMenu$2$2$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                        return m3411invokeZmokQxo(keyEvent.m7966unboximpl());
                    }

                    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                    public final Boolean m3411invokeZmokQxo(android.view.KeyEvent keyEvent) {
                        if (z && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7974getKeyDownCS__XNY()) && ((Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7905getTabEK5gGoQ()) && !KeyEvent_androidKt.m7983isShiftPressedZmokQxo(keyEvent)) || Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7742getDirectionDownEK5gGoQ()))) {
                            FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                            return true;
                        }
                        return false;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnKeyEvent4 = KeyInputModifierKt.onKeyEvent(companion4, (Function1) objRememberedValue4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnKeyEvent4);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl2.getInserting()) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1412194219, "C151@6672L8:FloatingActionButtonMenu.kt#uh7d8r");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i12 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            horizontal3 = end;
            modifier3 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonMenuKt.FloatingActionButtonMenu$lambda$6(z, function2, modifier3, horizontal3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int FloatingActionButtonMenu$lambda$1(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v22, types: [T, androidx.compose.animation.core.SpringSpec] */
    /* JADX WARN: Type inference failed for: r5v3, types: [T, androidx.compose.animation.core.FiniteAnimationSpec] */
    private static final void FloatingActionButtonMenuItemColumn(final Modifier modifier, final boolean z, final Alignment.Horizontal horizontal, final Function0<Integer> function0, final Function3<? super FloatingActionButtonMenuScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Function0<Integer> function1;
        int i3;
        int i4;
        Modifier.Companion companionVerticalScroll$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(-353421035);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FloatingActionButtonMenuItemColumn)N(modifier,expanded,horizontalAlignment,buttonHeight,content)200@8503L33,201@8572L34,203@8679L70,204@8775L24,206@8958L7,221@9509L106,217@9402L3707:FloatingActionButtonMenu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(horizontal) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function1 = function0;
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        } else {
            function1 = function0;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-353421035, i2, -1, "androidx.compose.material3.FloatingActionButtonMenuItemColumn (FloatingActionButtonMenu.kt:199)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -335190058, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -335187849, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -335184389, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = MotionSchemeKt.value(MotionSchemeKeyTokens.SlowEffects, composerStartRestartGroup, 6);
            if (objectRef2.element instanceof SpringSpec) {
                objectRef2.element = AnimationSpecKt.spring(((SpringSpec) objectRef2.element).getDampingRatio(), ((SpringSpec) objectRef2.element).getStiffness(), 1);
            }
            Modifier modifierClipToBounds = ClipKt.clipToBounds(modifier);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -335157793, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FloatingActionButtonMenuKt.FloatingActionButtonMenuItemColumn$lambda$9$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i5 = i2;
            Modifier modifierLayout = LayoutModifierKt.layout(SemanticsModifierKt.semantics$default(modifierClipToBounds, false, (Function1) objRememberedValue5, 1, null), new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FloatingActionButtonMenuKt.FloatingActionButtonMenuItemColumn$lambda$10(objectRef, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                }
            });
            if (FloatingActionButtonMenuItemColumn$lambda$4(mutableState)) {
                composerStartRestartGroup.startReplaceGroup(-335134346);
                ComposerKt.sourceInformation(composerStartRestartGroup, "235@10266L21");
                i3 = 1;
                i4 = 0;
                companionVerticalScroll$default = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), z, null, false, 12, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                i3 = 1;
                i4 = 0;
                composerStartRestartGroup.startReplaceGroup(-335131491);
                composerStartRestartGroup.endReplaceGroup();
                companionVerticalScroll$default = Modifier.INSTANCE;
            }
            Modifier modifierThen = modifierLayout.then(companionVerticalScroll$default);
            int i6 = i3;
            int i7 = i4;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(z, function1, objectRef, mutableIntState, mutableState2, coroutineScope, objectRef2, mutableState, horizontal);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, i7);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, anonymousClass3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1076277, "C240@10422L267,246@10702L14:FloatingActionButtonMenu.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -554153769, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            int i8 = (i5 & 896) == 256 ? i6 : i7;
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (i8 != 0 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new FloatingActionButtonMenuScope() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$FloatingActionButtonMenuItemColumn$4$scope$1$1
                    @Override // androidx.compose.material3.FloatingActionButtonMenuScope
                    /* JADX INFO: renamed from: getHorizontalAlignment, reason: from getter */
                    public Alignment.Horizontal get$horizontalAlignment() {
                        return horizontal;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function3.invoke((FloatingActionButtonMenuKt$FloatingActionButtonMenuItemColumn$4$scope$1$1) objRememberedValue6, composerStartRestartGroup, Integer.valueOf((i5 >> 9) & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonMenuKt.FloatingActionButtonMenuItemColumn$lambda$12(modifier, z, horizontal, function0, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int FloatingActionButtonMenuItemColumn$lambda$1(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    private static final boolean FloatingActionButtonMenuItemColumn$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FloatingActionButtonMenuItemColumn$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Animatable<Integer, AnimationVector1D> FloatingActionButtonMenuItemColumn$lambda$7(MutableState<Animatable<Integer, AnimationVector1D>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButtonMenuItemColumn$lambda$9$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, -0.9f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final MeasureResult FloatingActionButtonMenuItemColumn$lambda$10(Ref.ObjectRef objectRef, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        objectRef.element = constraints;
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(constraints.getValue());
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FloatingActionButtonMenuKt.FloatingActionButtonMenuItemColumn$lambda$10$0(placeableMo8265measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButtonMenuItemColumn$lambda$10$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.FloatingActionButtonMenuKt$FloatingActionButtonMenuItemColumn$3, reason: invalid class name */
    /* JADX INFO: compiled from: FloatingActionButtonMenu.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass3 implements MeasurePolicy {
        final /* synthetic */ Function0<Integer> $buttonHeight;
        final /* synthetic */ CoroutineScope $coroutineScope;
        final /* synthetic */ boolean $expanded;
        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
        final /* synthetic */ MutableIntState $itemCount$delegate;
        final /* synthetic */ MutableState<Boolean> $itemsNeedVerticalScroll$delegate;
        final /* synthetic */ Ref.ObjectRef<Constraints> $originalConstraints;
        final /* synthetic */ MutableState<Animatable<Integer, AnimationVector1D>> $staggerAnim$delegate;
        final /* synthetic */ Ref.ObjectRef<FiniteAnimationSpec<Integer>> $staggerAnimSpec;

        AnonymousClass3(boolean z, Function0<Integer> function0, Ref.ObjectRef<Constraints> objectRef, MutableIntState mutableIntState, MutableState<Animatable<Integer, AnimationVector1D>> mutableState, CoroutineScope coroutineScope, Ref.ObjectRef<FiniteAnimationSpec<Integer>> objectRef2, MutableState<Boolean> mutableState2, Alignment.Horizontal horizontal) {
            this.$expanded = z;
            this.$buttonHeight = function0;
            this.$originalConstraints = objectRef;
            this.$itemCount$delegate = mutableIntState;
            this.$staggerAnim$delegate = mutableState;
            this.$coroutineScope = coroutineScope;
            this.$staggerAnimSpec = objectRef2;
            this.$itemsNeedVerticalScroll$delegate = mutableState2;
            this.$horizontalAlignment = horizontal;
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* JADX INFO: renamed from: measure-3p2s80s */
        public final MeasureResult mo344measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
            int i;
            FloatingActionButtonMenuKt.FloatingActionButtonMenuItemColumn$lambda$2(this.$itemCount$delegate, list.size());
            int iFloatingActionButtonMenuItemColumn$lambda$1 = this.$expanded ? FloatingActionButtonMenuKt.FloatingActionButtonMenuItemColumn$lambda$1(this.$itemCount$delegate) : 0;
            MutableState<Animatable<Integer, AnimationVector1D>> mutableState = this.$staggerAnim$delegate;
            Animatable animatableFloatingActionButtonMenuItemColumn$lambda$7 = FloatingActionButtonMenuKt.FloatingActionButtonMenuItemColumn$lambda$7(mutableState);
            Object obj = null;
            if (animatableFloatingActionButtonMenuItemColumn$lambda$7 != null) {
                CoroutineScope coroutineScope = this.$coroutineScope;
                Ref.ObjectRef<FiniteAnimationSpec<Integer>> objectRef = this.$staggerAnimSpec;
                if (((Number) animatableFloatingActionButtonMenuItemColumn$lambda$7.getTargetValue()).intValue() != iFloatingActionButtonMenuItemColumn$lambda$1) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new FloatingActionButtonMenuKt$FloatingActionButtonMenuItemColumn$3$1$1(animatableFloatingActionButtonMenuItemColumn$lambda$7, iFloatingActionButtonMenuItemColumn$lambda$1, objectRef, null), 3, null);
                }
            } else {
                animatableFloatingActionButtonMenuItemColumn$lambda$7 = new Animatable(Integer.valueOf(iFloatingActionButtonMenuItemColumn$lambda$1), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), null, null, 12, null);
            }
            FloatingActionButtonMenuKt.FloatingActionButtonMenuItemColumn$lambda$8(mutableState, animatableFloatingActionButtonMenuItemColumn$lambda$7);
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(list.get(i2).mo8265measureBRTryo0(j));
            }
            final ArrayList arrayList2 = arrayList;
            if (!arrayList2.isEmpty()) {
                Object obj2 = arrayList2.get(0);
                int width = ((Placeable) obj2).getWidth();
                int lastIndex = CollectionsKt.getLastIndex(arrayList2);
                if (1 <= lastIndex) {
                    int i3 = 1;
                    while (true) {
                        Object obj3 = arrayList2.get(i3);
                        int width2 = ((Placeable) obj3).getWidth();
                        if (width < width2) {
                            obj2 = obj3;
                            width = width2;
                        }
                        if (i3 == lastIndex) {
                            break;
                        }
                        i3++;
                    }
                }
                obj = obj2;
            }
            Placeable placeable = (Placeable) obj;
            int width3 = placeable != null ? placeable.getWidth() : 0;
            final int i4 = measureScope.mo748roundToPx0680j_4(FloatingActionButtonMenuKt.FabMenuItemSpacingVertical);
            ArrayList arrayList3 = arrayList2;
            int size2 = !arrayList3.isEmpty() ? (arrayList2.size() - 1) * i4 : 0;
            int iIntValue = this.$buttonHeight.invoke().intValue();
            int i5 = iIntValue > 0 ? iIntValue + measureScope.mo748roundToPx0680j_4(FloatingActionButtonMenuKt.FabMenuButtonPaddingBottom) + measureScope.mo748roundToPx0680j_4(FloatingActionButtonMenuKt.FabMenuPaddingBottom) : 0;
            int size3 = arrayList3.size();
            int height = 0;
            for (int i6 = 0; i6 < size3; i6++) {
                height += ((Placeable) arrayList2.get(i6)).getHeight();
            }
            final int i7 = height + size2 + i5;
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            floatRef.element = i5;
            MutableIntState mutableIntState = this.$itemCount$delegate;
            MutableState<Animatable<Integer, AnimationVector1D>> mutableState2 = this.$staggerAnim$delegate;
            int size4 = arrayList3.size();
            for (int i8 = 0; i8 < size4; i8++) {
                Placeable placeable2 = (Placeable) arrayList2.get(i8);
                int iFloatingActionButtonMenuItemColumn$lambda$2 = FloatingActionButtonMenuKt.FloatingActionButtonMenuItemColumn$lambda$1(mutableIntState);
                Animatable animatableFloatingActionButtonMenuItemColumn$lambda$8 = FloatingActionButtonMenuKt.FloatingActionButtonMenuItemColumn$lambda$7(mutableState2);
                if (i8 >= iFloatingActionButtonMenuItemColumn$lambda$2 - (animatableFloatingActionButtonMenuItemColumn$lambda$8 != null ? ((Number) animatableFloatingActionButtonMenuItemColumn$lambda$8.getValue()).intValue() : 0)) {
                    floatRef.element += placeable2.getHeight();
                    if (i8 < arrayList2.size() - 1) {
                        floatRef.element += i4;
                    }
                }
            }
            int size5 = arrayList3.size();
            int i9 = 0;
            while (true) {
                if (i9 >= size5) {
                    i = 0;
                    break;
                }
                if (FloatingActionButtonMenuKt.isVisible((Placeable) arrayList2.get(i9))) {
                    i = i7;
                    break;
                }
                i9++;
            }
            MutableState<Boolean> mutableState3 = this.$itemsNeedVerticalScroll$delegate;
            Constraints constraints = this.$originalConstraints.element;
            Intrinsics.checkNotNull(constraints);
            FloatingActionButtonMenuKt.FloatingActionButtonMenuItemColumn$lambda$5(mutableState3, i > Constraints.m9639getMaxHeightimpl(constraints.getValue()));
            Function1 function1 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$FloatingActionButtonMenuItemColumn$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj4) {
                    return FloatingActionButtonMenuKt.AnonymousClass3.measure_3p2s80s$lambda$6(i7, floatRef, (RulerScope) obj4);
                }
            };
            final Alignment.Horizontal horizontal = this.$horizontalAlignment;
            final int i10 = width3;
            return MeasureScope.layout$default(measureScope, i10, i, null, function1, new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$FloatingActionButtonMenuItemColumn$3$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj4) {
                    return FloatingActionButtonMenuKt.AnonymousClass3.measure_3p2s80s$lambda$7(arrayList2, horizontal, i10, measureScope, i4, (Placeable.PlacementScope) obj4);
                }
            }, 4, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit measure_3p2s80s$lambda$6(int i, Ref.FloatRef floatRef, RulerScope rulerScope) {
            rulerScope.provides(FloatingActionButtonMenuKt.MenuItemRuler, i - floatRef.element);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit measure_3p2s80s$lambda$7(List list, Alignment.Horizontal horizontal, int i, MeasureScope measureScope, int i2, Placeable.PlacementScope placementScope) {
            int size = list.size();
            int i3 = 0;
            int height = 0;
            while (i3 < size) {
                Placeable placeable = (Placeable) list.get(i3);
                Placeable.PlacementScope placementScope2 = placementScope;
                Placeable.PlacementScope.place$default(placementScope2, placeable, horizontal.align(placeable.getWidth(), i, measureScope.getLayoutDirection()), height, 0.0f, 4, null);
                height += placeable.getHeight();
                if (i3 < list.size() - 1) {
                    height += i2;
                }
                i3++;
                placementScope = placementScope2;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x014a  */
    /* JADX WARN: Code duplicated, block: B:105:0x016a  */
    /* JADX WARN: Code duplicated, block: B:108:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:111:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:112:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:115:0x021f  */
    /* JADX WARN: Code duplicated, block: B:117:0x0224  */
    /* JADX WARN: Code duplicated, block: B:120:0x0231  */
    /* JADX WARN: Code duplicated, block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:88:0x0101  */
    /* JADX WARN: Code duplicated, block: B:91:0x0106  */
    /* JADX WARN: Code duplicated, block: B:92:0x0113  */
    /* JADX WARN: Code duplicated, block: B:95:0x0118  */
    /* JADX WARN: Code duplicated, block: B:96:0x0122 A[PHI: r3 r4 r6
      0x0122: PHI (r3v27 int) = (r3v12 int), (r3v29 int) binds: [B:94:0x0116, B:85:0x00f7] A[DONT_GENERATE, DONT_INLINE]
      0x0122: PHI (r4v16 androidx.compose.ui.Modifier) = (r4v10 androidx.compose.ui.Modifier), (r4v20 androidx.compose.ui.Modifier) binds: [B:94:0x0116, B:85:0x00f7] A[DONT_GENERATE, DONT_INLINE]
      0x0122: PHI (r6v12 long) = (r6v7 long), (r6v13 long) binds: [B:94:0x0116, B:85:0x00f7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:99:0x012c  */
    /* JADX INFO: renamed from: FloatingActionButtonMenuItem-WMdw5o4, reason: not valid java name */
    public static final void m3410FloatingActionButtonMenuItemWMdw5o4(final FloatingActionButtonMenuScope floatingActionButtonMenuScope, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        final Function0<Unit> function1;
        Modifier modifier2;
        long j3;
        long j4;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final long primaryContainer;
        final long jM3051contentColorForek8zF_U;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Object objRememberedValue;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1448697100);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FloatingActionButtonMenuItem)N(onClick,text,icon,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color)339@14546L72,340@14640L72,342@14869L7,343@14961L7,344@14994L24,346@15041L34,349@15319L2991,349@15242L3068:FloatingActionButtonMenu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(floatingActionButtonMenuScope) : composerStartRestartGroup.changedInstance(floatingActionButtonMenuScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            function1 = function0;
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 16) == 0) {
                    j3 = j;
                    int i5 = composerStartRestartGroup.changed(j3) ? 131072 : 65536;
                    i3 |= i5;
                } else {
                    j3 = j;
                }
                i3 |= i5;
            } else {
                j3 = j;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j4 = j2;
                    int i6 = composerStartRestartGroup.changed(j4) ? 1048576 : 524288;
                    i3 |= i6;
                } else {
                    j4 = j2;
                }
                i3 |= i6;
            } else {
                j4 = j2;
            }
            if ((599187 & i3) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "336@14432L11,337@14488L31");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 16) != 0) {
                        primaryContainer = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getPrimaryContainer();
                        i3 &= -458753;
                    } else {
                        primaryContainer = j3;
                    }
                    if ((i2 & 32) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(primaryContainer, composerStartRestartGroup, (i3 >> 15) & 14);
                        i3 &= -3670017;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1448697100, i3, -1, "androidx.compose.material3.FloatingActionButtonMenuItem (FloatingActionButtonMenu.kt:338)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 628520404, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final MutableState mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 628523412, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final MutableState mutableState2 = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
                    final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 628536206, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    final MutableState mutableState3 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Modifier modifier4 = companion;
                    composer2 = composerStartRestartGroup;
                    CompositionLocalKt.CompositionLocalProvider(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize().provides(Dp.m9685boximpl(Dp.m9687constructorimpl(0))), ComposableLambdaKt.rememberComposableLambda(-581009332, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonMenuKt.FloatingActionButtonMenuItem_WMdw5o4$lambda$9(modifier4, coroutineScope, finiteAnimationSpecValue, finiteAnimationSpecValue2, function1, primaryContainer, jM3051contentColorForek8zF_U, mutableState3, mutableState, mutableState2, floatingActionButtonMenuScope, function3, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 16) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -3670017;
                    }
                    companion = modifier2;
                    primaryContainer = j3;
                }
                jM3051contentColorForek8zF_U = j4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1448697100, i3, -1, "androidx.compose.material3.FloatingActionButtonMenuItem (FloatingActionButtonMenu.kt:338)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 628520404, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState4 = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 628523412, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MutableState mutableState5 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
                final FiniteAnimationSpec finiteAnimationSpecValue4 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 628536206, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final MutableState mutableState6 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Modifier modifier5 = companion;
                composer2 = composerStartRestartGroup;
                CompositionLocalKt.CompositionLocalProvider(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize().provides(Dp.m9685boximpl(Dp.m9687constructorimpl(0))), ComposableLambdaKt.rememberComposableLambda(-581009332, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonMenuKt.FloatingActionButtonMenuItem_WMdw5o4$lambda$9(modifier5, coroutineScope2, finiteAnimationSpecValue3, finiteAnimationSpecValue4, function1, primaryContainer, jM3051contentColorForek8zF_U, mutableState6, mutableState4, mutableState5, floatingActionButtonMenuScope, function3, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                primaryContainer = j3;
                jM3051contentColorForek8zF_U = j4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonMenuKt.FloatingActionButtonMenuItem_WMdw5o4$lambda$10(floatingActionButtonMenuScope, function0, function2, function3, modifier3, primaryContainer, jM3051contentColorForek8zF_U, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((196608 & i) == 0) {
            if ((i2 & 16) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i5;
            } else {
                j3 = j;
            }
            i3 |= i5;
        } else {
            j3 = j;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 32) == 0) {
                j4 = j2;
                if (composerStartRestartGroup.changed(j4)) {
                }
                i3 |= i6;
            } else {
                j4 = j2;
            }
            i3 |= i6;
        } else {
            j4 = j2;
        }
        if ((599187 & i3) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "336@14432L11,337@14488L31");
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 16) != 0) {
                    primaryContainer = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getPrimaryContainer();
                    i3 &= -458753;
                } else {
                    primaryContainer = j3;
                }
                if ((i2 & 32) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(primaryContainer, composerStartRestartGroup, (i3 >> 15) & 14);
                    i3 &= -3670017;
                } else {
                    jM3051contentColorForek8zF_U = j4;
                }
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 16) != 0) {
                    primaryContainer = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getPrimaryContainer();
                    i3 &= -458753;
                } else {
                    primaryContainer = j3;
                }
                if ((i2 & 32) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(primaryContainer, composerStartRestartGroup, (i3 >> 15) & 14);
                    i3 &= -3670017;
                } else {
                    jM3051contentColorForek8zF_U = j4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1448697100, i3, -1, "androidx.compose.material3.FloatingActionButtonMenuItem (FloatingActionButtonMenu.kt:338)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 628520404, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState7 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 628523412, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState8 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FiniteAnimationSpec finiteAnimationSpecValue5 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue6 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 628536206, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState9 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Modifier modifier6 = companion;
            composer2 = composerStartRestartGroup;
            CompositionLocalKt.CompositionLocalProvider(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize().provides(Dp.m9685boximpl(Dp.m9687constructorimpl(0))), ComposableLambdaKt.rememberComposableLambda(-581009332, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonMenuKt.FloatingActionButtonMenuItem_WMdw5o4$lambda$9(modifier6, coroutineScope3, finiteAnimationSpecValue5, finiteAnimationSpecValue6, function1, primaryContainer, jM3051contentColorForek8zF_U, mutableState9, mutableState7, mutableState8, floatingActionButtonMenuScope, function3, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            primaryContainer = j3;
            jM3051contentColorForek8zF_U = j4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonMenuKt.FloatingActionButtonMenuItem_WMdw5o4$lambda$10(floatingActionButtonMenuScope, function0, function2, function3, modifier3, primaryContainer, jM3051contentColorForek8zF_U, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Animatable<Float, AnimationVector1D> FloatingActionButtonMenuItem_WMdw5o4$lambda$1(MutableState<Animatable<Float, AnimationVector1D>> mutableState) {
        return mutableState.getValue();
    }

    private static final Animatable<Float, AnimationVector1D> FloatingActionButtonMenuItem_WMdw5o4$lambda$4(MutableState<Animatable<Float, AnimationVector1D>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FloatingActionButtonMenuItem_WMdw5o4$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void FloatingActionButtonMenuItem_WMdw5o4$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButtonMenuItem_WMdw5o4$lambda$9(Modifier modifier, final CoroutineScope coroutineScope, final FiniteAnimationSpec finiteAnimationSpec, final FiniteAnimationSpec finiteAnimationSpec2, Function0 function0, long j, long j2, MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final FloatingActionButtonMenuScope floatingActionButtonMenuScope, final Function2 function2, final Function2 function3, Composer composer, int i) {
        final MutableState mutableState4;
        ComposerKt.sourceInformation(composer, "C352@15398L13,352@15420L1315,378@16802L5,382@16927L1377,350@15329L2975:FloatingActionButtonMenu.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-581009332, i, -1, "androidx.compose.material3.FloatingActionButtonMenuItem.<anonymous> (FloatingActionButtonMenu.kt:350)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -4217031, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState4 = mutableState;
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(FloatingActionButtonMenuKt.FloatingActionButtonMenuItem_WMdw5o4$lambda$7(mutableState4));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            } else {
                mutableState4 = mutableState;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierItemVisible = itemVisible(modifier, (Function0) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, -4215025, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(coroutineScope) | composer.changedInstance(finiteAnimationSpec) | composer.changedInstance(finiteAnimationSpec2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function3 function4 = new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return FloatingActionButtonMenuKt.FloatingActionButtonMenuItem_WMdw5o4$lambda$9$1$0(mutableState2, coroutineScope, finiteAnimationSpec, mutableState3, finiteAnimationSpec2, mutableState4, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composer.updateRememberedValue(function4);
                objRememberedValue2 = function4;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SurfaceKt.m4326Surfaceo_FOJdg(function0, LayoutModifierKt.layout(modifierItemVisible, (Function3) objRememberedValue2), false, ShapesKt.getValue(FabMenuBaselineTokens.INSTANCE.getListItemContainerShape(), composer, 6), j, j2, 0.0f, 0.0f, null, null, ComposableLambdaKt.rememberComposableLambda(-267751263, true, new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonMenuKt.FloatingActionButtonMenuItem_WMdw5o4$lambda$9$2(floatingActionButtonMenuScope, mutableState2, function2, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 0, 6, 964);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult FloatingActionButtonMenuItem_WMdw5o4$lambda$9$1$0(final MutableState mutableState, final CoroutineScope coroutineScope, final FiniteAnimationSpec finiteAnimationSpec, final MutableState mutableState2, final FiniteAnimationSpec finiteAnimationSpec2, final MutableState mutableState3, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(constraints.getValue());
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FloatingActionButtonMenuKt.FloatingActionButtonMenuItem_WMdw5o4$lambda$9$1$0$0(placeableMo8265measureBRTryo0, mutableState, coroutineScope, finiteAnimationSpec, mutableState2, finiteAnimationSpec2, mutableState3, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButtonMenuItem_WMdw5o4$lambda$9$1$0$0(Placeable placeable, MutableState mutableState, CoroutineScope coroutineScope, FiniteAnimationSpec finiteAnimationSpec, MutableState mutableState2, FiniteAnimationSpec finiteAnimationSpec2, MutableState mutableState3, Placeable.PlacementScope placementScope) {
        float f = placementScope.current(MenuItemRuler, Float.POSITIVE_INFINITY) <= 0.0f ? 1.0f : 0.0f;
        Animatable<Float, AnimationVector1D> animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$1 = FloatingActionButtonMenuItem_WMdw5o4$lambda$1(mutableState);
        if (animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$1 == null) {
            animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$1 = new Animatable<>(Float.valueOf(f), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null);
        } else if (animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$1.getTargetValue().floatValue() != f) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new FloatingActionButtonMenuKt$FloatingActionButtonMenuItem$1$2$1$1$1$1(animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$1, f, finiteAnimationSpec, null), 3, null);
        }
        mutableState.setValue(animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$1);
        final Animatable<Float, AnimationVector1D> animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$4 = FloatingActionButtonMenuItem_WMdw5o4$lambda$4(mutableState2);
        if (animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$4 == null) {
            animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$4 = new Animatable<>(Float.valueOf(f), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null);
        } else if (animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$4.getTargetValue().floatValue() != f) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new FloatingActionButtonMenuKt$FloatingActionButtonMenuItem$1$2$1$1$tempAlphaAnim$1$1(animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$4, f, finiteAnimationSpec2, null), 3, null);
        }
        mutableState2.setValue(animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$4);
        FloatingActionButtonMenuItem_WMdw5o4$lambda$8(mutableState3, !(animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$4.getValue().floatValue() == 0.0f));
        if (FloatingActionButtonMenuItem_WMdw5o4$lambda$7(mutableState3)) {
            Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, 0, 0.0f, new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FloatingActionButtonMenuKt.FloatingActionButtonMenuItem_WMdw5o4$lambda$9$1$0$0$2(animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$4, (GraphicsLayerScope) obj);
                }
            }, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButtonMenuItem_WMdw5o4$lambda$9$1$0$0$2(Animatable animatable, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(((Number) animatable.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButtonMenuItem_WMdw5o4$lambda$9$2(final FloatingActionButtonMenuScope floatingActionButtonMenuScope, final MutableState mutableState, Function2 function2, Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C384@16978L533,383@16941L1353:FloatingActionButtonMenu.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-267751263, i, -1, "androidx.compose.material3.FloatingActionButtonMenuItem.<anonymous>.<anonymous> (FloatingActionButtonMenu.kt:383)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 389076182, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(floatingActionButtonMenuScope);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return FloatingActionButtonMenuKt.FloatingActionButtonMenuItem_WMdw5o4$lambda$9$2$0$0(mutableState, floatingActionButtonMenuScope, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1270sizeInqDBjuR0$default(LayoutModifierKt.layout(companion, (Function3) objRememberedValue), FabMenuItemMinWidth, FabMenuItemHeight, 0.0f, 0.0f, 12, null), FabMenuItemContentPaddingStart, 0.0f, FabMenuItemContentPaddingEnd, 0.0f, 10, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.Horizontal horizontalM1074spacedByD5KLDUw = Arrangement.INSTANCE.m1074spacedByD5KLDUw(FabMenuItemContentSpacingHorizontal, Alignment.INSTANCE.getCenterHorizontally());
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalM1074spacedByD5KLDUw, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1222paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 541710382, "C406@18096L6,408@18203L10,407@18119L161:FloatingActionButtonMenu.kt#uh7d8r");
            function2.invoke(composer, 0);
            CompositionLocalKt.CompositionLocalProvider(TextKt.getLocalTextStyle().provides(MaterialTheme.INSTANCE.getTypography(composer, 6).getTitleMedium()), (Function2<? super Composer, ? super Integer, Unit>) function3, composer, ProvidedValue.$stable);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult FloatingActionButtonMenuItem_WMdw5o4$lambda$9$2$0$0(MutableState mutableState, final FloatingActionButtonMenuScope floatingActionButtonMenuScope, final MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(constraints.getValue());
        float width = placeableMo8265measureBRTryo0.getWidth();
        Animatable<Float, AnimationVector1D> animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$1 = FloatingActionButtonMenuItem_WMdw5o4$lambda$1(mutableState);
        final int iRoundToInt = MathKt.roundToInt(width * Math.max(animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$1 != null ? animatableFloatingActionButtonMenuItem_WMdw5o4$lambda$1.getValue().floatValue() : 0.0f, 0.0f));
        return MeasureScope.layout$default(measureScope, iRoundToInt, placeableMo8265measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FloatingActionButtonMenuKt.FloatingActionButtonMenuItem_WMdw5o4$lambda$9$2$0$0$0(floatingActionButtonMenuScope, placeableMo8265measureBRTryo0, iRoundToInt, measureScope, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FloatingActionButtonMenuItem_WMdw5o4$lambda$9$2$0$0$0(FloatingActionButtonMenuScope floatingActionButtonMenuScope, Placeable placeable, int i, MeasureScope measureScope, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, floatingActionButtonMenuScope.get$horizontalAlignment().align(placeable.getWidth(), i, measureScope.getLayoutDirection()), 0, 0.0f, (Function1) null, 12, (Object) null);
        return Unit.INSTANCE;
    }

    static {
        float f = 16;
        FabInitialCornerRadius = Dp.m9687constructorimpl(f);
        float fM5405getCloseButtonContainerHeightD9Ej5fM = FabMenuBaselineTokens.INSTANCE.m5405getCloseButtonContainerHeightD9Ej5fM();
        FabFinalSize = fM5405getCloseButtonContainerHeightD9Ej5fM;
        FabFinalCornerRadius = Dp.m9687constructorimpl(fM5405getCloseButtonContainerHeightD9Ej5fM / 2);
        FabFinalIconSize = FabMenuBaselineTokens.INSTANCE.m5407getCloseButtonIconSizeD9Ej5fM();
        FabShadowElevation = FabPrimaryContainerTokens.INSTANCE.m5415getContainerElevationD9Ej5fM();
        FabMenuPaddingHorizontal = Dp.m9687constructorimpl(f);
        FabMenuPaddingBottom = FabMenuBaselineTokens.INSTANCE.m5403getCloseButtonBetweenSpaceD9Ej5fM();
        FabMenuButtonPaddingBottom = Dp.m9687constructorimpl(f);
        FabMenuItemMinWidth = FabMenuBaselineTokens.INSTANCE.m5410getListItemContainerHeightD9Ej5fM();
        FabMenuItemHeight = FabMenuBaselineTokens.INSTANCE.m5410getListItemContainerHeightD9Ej5fM();
        FabMenuItemSpacingVertical = FabMenuBaselineTokens.INSTANCE.m5408getListItemBetweenSpaceD9Ej5fM();
        FabMenuItemContentPaddingStart = FabMenuBaselineTokens.INSTANCE.m5413getListItemLeadingSpaceD9Ej5fM();
        FabMenuItemContentPaddingEnd = FabMenuBaselineTokens.INSTANCE.m5414getListItemTrailingSpaceD9Ej5fM();
        FabMenuItemContentSpacingHorizontal = FabMenuBaselineTokens.INSTANCE.m5411getListItemIconLabelSpaceD9Ej5fM();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0119  */
    /* JADX WARN: Code duplicated, block: B:101:0x0120  */
    /* JADX WARN: Code duplicated, block: B:104:0x0126  */
    /* JADX WARN: Code duplicated, block: B:105:0x013e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0141  */
    /* JADX WARN: Code duplicated, block: B:110:0x014c  */
    /* JADX WARN: Code duplicated, block: B:113:0x0159  */
    /* JADX WARN: Code duplicated, block: B:117:0x016d  */
    /* JADX WARN: Code duplicated, block: B:119:0x0178  */
    /* JADX WARN: Code duplicated, block: B:120:0x017b  */
    /* JADX WARN: Code duplicated, block: B:125:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:128:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:129:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:132:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:32:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:41:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0080  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:51:0x008b  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:80:0x00db  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:99:0x0117 A[DONT_INVERT] */
    public static final void ToggleFloatingActionButton(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, Function1<? super Float, Color> function2, Alignment alignment, Function1<? super Float, Dp> function3, Function1<? super Float, Dp> function4, final Function3<? super ToggleFloatingActionButtonScope, ? super Composer, ? super Integer, Unit> function5, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Function1<? super Float, Color> function1M4622containerColordgg9oW8;
        int i4;
        Alignment topEnd;
        int i5;
        Function1<? super Float, Dp> function1ContainerSize;
        Function1<? super Float, Dp> function1ContainerCornerRadius;
        boolean z2;
        final Modifier modifier3;
        final Function1<? super Float, Color> function6;
        final Alignment alignment2;
        final Function1<? super Float, Dp> function7;
        final Function1<? super Float, Dp> function8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        int i6;
        float f;
        final State<Float> stateAnimateFloatAsState;
        boolean zChanged;
        Object objRememberedValue;
        int i7;
        int i8;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(1041334678);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleFloatingActionButton)N(checked,onCheckedChange,modifier,containerColor,contentAlignment,containerSize,containerCornerRadius,content)459@20576L7,456@20362L232,464@20677L25,461@20599L249:FloatingActionButtonMenu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i10 = i2 & 4;
        if (i10 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    function1M4622containerColordgg9oW8 = function2;
                    int i11 = composerStartRestartGroup.changedInstance(function1M4622containerColordgg9oW8) ? 2048 : 1024;
                    i3 |= i11;
                } else {
                    function1M4622containerColordgg9oW8 = function2;
                }
                i3 |= i11;
            } else {
                function1M4622containerColordgg9oW8 = function2;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                i3 |= 24576;
                topEnd = alignment;
            } else {
                topEnd = alignment;
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(topEnd)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
            }
            if ((196608 & i) == 0) {
                function1ContainerSize = function3;
                if ((i2 & 32) == 0 || !composerStartRestartGroup.changedInstance(function1ContainerSize)) {
                    i9 = 65536;
                } else {
                    i9 = 131072;
                }
                i3 |= i9;
            } else {
                function1ContainerSize = function3;
            }
            if ((1572864 & i) == 0) {
                function1ContainerCornerRadius = function4;
                if ((i2 & 64) == 0 || !composerStartRestartGroup.changedInstance(function1ContainerCornerRadius)) {
                    i8 = 524288;
                } else {
                    i8 = 1048576;
                }
                i3 |= i8;
            } else {
                function1ContainerCornerRadius = function4;
            }
            if ((12582912 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((4793491 & i3) != 4793490) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "448@19987L16");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        function1M4622containerColordgg9oW8 = ToggleFloatingActionButtonDefaults.INSTANCE.m4622containerColordgg9oW8(0L, 0L, composerStartRestartGroup, 384, 3);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        topEnd = Alignment.INSTANCE.getTopEnd();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        function1ContainerSize = ToggleFloatingActionButtonDefaults.INSTANCE.containerSize();
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        function1ContainerCornerRadius = ToggleFloatingActionButtonDefaults.INSTANCE.containerCornerRadius();
                    }
                    i6 = i3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                    }
                    i6 = i3;
                    modifier4 = modifier2;
                }
                Function1<? super Float, Color> function9 = function1M4622containerColordgg9oW8;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1041334678, i6, -1, "androidx.compose.material3.ToggleFloatingActionButton (FloatingActionButtonMenu.kt:454)");
                }
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -4725809, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$0$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i12 = i6 << 3;
                int i13 = (i6 & 126) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (i12 & 234881024);
                function6 = function9;
                alignment2 = topEnd;
                function7 = function1ContainerSize;
                modifier3 = modifier4;
                ToggleFloatingActionButton(z, function1, function0, modifier3, function6, alignment2, function7, function1ContainerCornerRadius, function5, composerStartRestartGroup, i13, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function6 = function1M4622containerColordgg9oW8;
                alignment2 = topEnd;
                function7 = function1ContainerSize;
            }
            Composer composer2 = composerStartRestartGroup;
            function8 = function1ContainerCornerRadius;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$1(z, function1, modifier3, function6, alignment2, function7, function8, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                function1M4622containerColordgg9oW8 = function2;
                if (composerStartRestartGroup.changedInstance(function1M4622containerColordgg9oW8)) {
                }
                i3 |= i11;
            } else {
                function1M4622containerColordgg9oW8 = function2;
            }
            i3 |= i11;
        } else {
            function1M4622containerColordgg9oW8 = function2;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            i3 |= 24576;
            topEnd = alignment;
        } else {
            topEnd = alignment;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(topEnd)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
        }
        if ((196608 & i) == 0) {
            function1ContainerSize = function3;
            if ((i2 & 32) == 0) {
                i9 = 65536;
            } else {
                i9 = 65536;
            }
            i3 |= i9;
        } else {
            function1ContainerSize = function3;
        }
        if ((1572864 & i) == 0) {
            function1ContainerCornerRadius = function4;
            if ((i2 & 64) == 0) {
                i8 = 524288;
            } else {
                i8 = 524288;
            }
            i3 |= i8;
        } else {
            function1ContainerCornerRadius = function4;
        }
        if ((12582912 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function5)) {
                i7 = 8388608;
            } else {
                i7 = 4194304;
            }
            i3 |= i7;
        }
        if ((4793491 & i3) != 4793490) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "448@19987L16");
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    function1M4622containerColordgg9oW8 = ToggleFloatingActionButtonDefaults.INSTANCE.m4622containerColordgg9oW8(0L, 0L, composerStartRestartGroup, 384, 3);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    topEnd = Alignment.INSTANCE.getTopEnd();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    function1ContainerSize = ToggleFloatingActionButtonDefaults.INSTANCE.containerSize();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    function1ContainerCornerRadius = ToggleFloatingActionButtonDefaults.INSTANCE.containerCornerRadius();
                }
                i6 = i3;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    function1M4622containerColordgg9oW8 = ToggleFloatingActionButtonDefaults.INSTANCE.m4622containerColordgg9oW8(0L, 0L, composerStartRestartGroup, 384, 3);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    topEnd = Alignment.INSTANCE.getTopEnd();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    function1ContainerSize = ToggleFloatingActionButtonDefaults.INSTANCE.containerSize();
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    function1ContainerCornerRadius = ToggleFloatingActionButtonDefaults.INSTANCE.containerCornerRadius();
                }
                i6 = i3;
            }
            Function1<? super Float, Color> function10 = function1M4622containerColordgg9oW8;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1041334678, i6, -1, "androidx.compose.material3.ToggleFloatingActionButton (FloatingActionButtonMenu.kt:454)");
            }
            if (z) {
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -4725809, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$0$0(stateAnimateFloatAsState));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$0$0(stateAnimateFloatAsState));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function11 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i14 = i6 << 3;
            int i15 = (i6 & 126) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (29360128 & i14) | (i14 & 234881024);
            function6 = function10;
            alignment2 = topEnd;
            function7 = function1ContainerSize;
            modifier3 = modifier4;
            ToggleFloatingActionButton(z, function1, function11, modifier3, function6, alignment2, function7, function1ContainerCornerRadius, function5, composerStartRestartGroup, i15, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            function6 = function1M4622containerColordgg9oW8;
            alignment2 = topEnd;
            function7 = function1ContainerSize;
        }
        Composer composer3 = composerStartRestartGroup;
        function8 = function1ContainerCornerRadius;
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$1(z, function1, modifier3, function6, alignment2, function7, function8, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ToggleFloatingActionButton$lambda$0$0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0146 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x0148  */
    /* JADX WARN: Code duplicated, block: B:109:0x014d  */
    /* JADX WARN: Code duplicated, block: B:112:0x0152  */
    /* JADX WARN: Code duplicated, block: B:113:0x016e  */
    /* JADX WARN: Code duplicated, block: B:115:0x0176  */
    /* JADX WARN: Code duplicated, block: B:116:0x017d  */
    /* JADX WARN: Code duplicated, block: B:119:0x0183  */
    /* JADX WARN: Code duplicated, block: B:122:0x018f  */
    /* JADX WARN: Code duplicated, block: B:123:0x019d  */
    /* JADX WARN: Code duplicated, block: B:126:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:129:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:131:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:137:0x01db  */
    /* JADX WARN: Code duplicated, block: B:139:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:142:0x0246  */
    /* JADX WARN: Code duplicated, block: B:145:0x0252  */
    /* JADX WARN: Code duplicated, block: B:146:0x0256  */
    /* JADX WARN: Code duplicated, block: B:149:0x027b  */
    /* JADX WARN: Code duplicated, block: B:151:0x0289  */
    /* JADX WARN: Code duplicated, block: B:154:0x02db  */
    /* JADX WARN: Code duplicated, block: B:156:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:159:0x0314  */
    /* JADX WARN: Code duplicated, block: B:160:0x0317  */
    /* JADX WARN: Code duplicated, block: B:163:0x0322  */
    /* JADX WARN: Code duplicated, block: B:165:0x0328  */
    /* JADX WARN: Code duplicated, block: B:171:0x0337  */
    /* JADX WARN: Code duplicated, block: B:173:0x033f  */
    /* JADX WARN: Code duplicated, block: B:176:0x0361  */
    /* JADX WARN: Code duplicated, block: B:178:0x0369  */
    /* JADX WARN: Code duplicated, block: B:181:0x0388  */
    /* JADX WARN: Code duplicated, block: B:183:0x038e  */
    /* JADX WARN: Code duplicated, block: B:189:0x039b  */
    /* JADX WARN: Code duplicated, block: B:190:0x039e  */
    /* JADX WARN: Code duplicated, block: B:193:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:195:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:201:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:203:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:206:0x0406  */
    /* JADX WARN: Code duplicated, block: B:208:0x040c  */
    /* JADX WARN: Code duplicated, block: B:214:0x0419  */
    /* JADX WARN: Code duplicated, block: B:215:0x041c  */
    /* JADX WARN: Code duplicated, block: B:218:0x0424  */
    /* JADX WARN: Code duplicated, block: B:220:0x042c  */
    /* JADX WARN: Code duplicated, block: B:223:0x047a  */
    /* JADX WARN: Code duplicated, block: B:226:0x0486  */
    /* JADX WARN: Code duplicated, block: B:227:0x048a  */
    /* JADX WARN: Code duplicated, block: B:230:0x04af  */
    /* JADX WARN: Code duplicated, block: B:232:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:236:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:239:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:241:0x0503  */
    /* JADX WARN: Code duplicated, block: B:244:0x0547  */
    /* JADX WARN: Code duplicated, block: B:246:0x0551  */
    /* JADX WARN: Code duplicated, block: B:249:0x0564  */
    /* JADX WARN: Code duplicated, block: B:251:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x008c  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:54:0x0099  */
    /* JADX WARN: Code duplicated, block: B:55:0x009c  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:78:0x00db  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:89:0x0100  */
    /* JADX WARN: Code duplicated, block: B:92:0x0109  */
    /* JADX WARN: Code duplicated, block: B:94:0x011e  */
    private static final void ToggleFloatingActionButton(final boolean z, final Function1<? super Boolean, Unit> function1, final Function0<Float> function0, Modifier modifier, Function1<? super Float, Color> function2, Alignment alignment, Function1<? super Float, Dp> function3, Function1<? super Float, Dp> function4, final Function3<? super ToggleFloatingActionButtonScope, ? super Composer, ? super Integer, Unit> function5, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Alignment alignment2;
        int i5;
        Function1<? super Float, Dp> function1ContainerSize;
        Function1<? super Float, Dp> function6;
        boolean z2;
        Composer composer2;
        final Function1<? super Float, Color> function7;
        final Alignment alignment3;
        final Function1<? super Float, Dp> function8;
        final Function1<? super Float, Dp> function9;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Composer composer3;
        Function1<? super Float, Color> function1M4622containerColordgg9oW8;
        Alignment topEnd;
        int i6;
        Alignment alignment4;
        final Function1<? super Float, Dp> function10;
        final Function1<? super Float, Color> function11;
        final Function1<? super Float, Dp> function1ContainerCornerRadius;
        boolean z3;
        Object objRememberedValue;
        float fM9701unboximpl;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final Density density;
        boolean zChanged;
        Object objRememberedValue2;
        int i7;
        boolean z4;
        boolean z5;
        Object objRememberedValue3;
        final GenericShape genericShape;
        boolean zChanged2;
        Object objRememberedValue4;
        boolean z6;
        boolean z7;
        Object objRememberedValue5;
        boolean z8;
        boolean z9;
        Object objRememberedValue6;
        int currentCompositeKeyHash2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM6062constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean z10;
        Object objRememberedValue7;
        int i8;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(2138014434);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleFloatingActionButton)N(checked,onCheckedChange,checkedProgress,modifier,containerColor,contentAlignment,containerSize,containerCornerRadius,content)517@23123L45,518@23173L2333:FloatingActionButtonMenu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i10 = i2 & 8;
        if (i10 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            if ((i & 24576) != 0) {
                i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changedInstance(function2)) ? 8192 : 16384;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    alignment2 = alignment;
                    if (composerStartRestartGroup.changed(alignment2)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((i & 1572864) == 0) {
                    function1ContainerSize = function3;
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changedInstance(function1ContainerSize)) {
                        i9 = 524288;
                    } else {
                        i9 = 1048576;
                    }
                    i3 |= i9;
                } else {
                    function1ContainerSize = function3;
                }
                if ((i & 12582912) == 0) {
                    if ((i2 & 128) == 0) {
                        function6 = function4;
                        int i11 = composerStartRestartGroup.changedInstance(function6) ? 8388608 : 4194304;
                        i3 |= i11;
                    } else {
                        function6 = function4;
                    }
                    i3 |= i11;
                } else {
                    function6 = function4;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                    i3 |= i8;
                }
                if ((i3 & 38347923) != 38347922) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "510@22760L16");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 16) != 0) {
                            function1M4622containerColordgg9oW8 = ToggleFloatingActionButtonDefaults.INSTANCE.m4622containerColordgg9oW8(0L, 0L, composerStartRestartGroup, 384, 3);
                            composer3 = composerStartRestartGroup;
                            i3 &= -57345;
                        } else {
                            composer3 = composerStartRestartGroup;
                            function1M4622containerColordgg9oW8 = function2;
                        }
                        if (i4 != 0) {
                            topEnd = Alignment.INSTANCE.getTopEnd();
                        } else {
                            topEnd = alignment;
                        }
                        if ((i2 & 64) != 0) {
                            function1ContainerSize = ToggleFloatingActionButtonDefaults.INSTANCE.containerSize();
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            Alignment alignment5 = topEnd;
                            i6 = i3 & (-29360129);
                            alignment4 = alignment5;
                            function10 = function1ContainerSize;
                            function11 = function1M4622containerColordgg9oW8;
                            function1ContainerCornerRadius = ToggleFloatingActionButtonDefaults.INSTANCE.containerCornerRadius();
                        } else {
                            Alignment alignment6 = topEnd;
                            i6 = i3;
                            alignment4 = alignment6;
                            function10 = function1ContainerSize;
                            function11 = function1M4622containerColordgg9oW8;
                            function1ContainerCornerRadius = function4;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                        }
                        function10 = function1ContainerSize;
                        companion = modifier2;
                        function1ContainerCornerRadius = function6;
                        function11 = function2;
                        composer3 = composerStartRestartGroup;
                        i6 = i3;
                        alignment4 = alignment2;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2138014434, i6, -1, "androidx.compose.material3.ToggleFloatingActionButton (FloatingActionButtonMenu.kt:516)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer3, 1637522831, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    int i12 = (3670016 & i6) ^ 1572864;
                    z3 = (i12 <= 1048576 && composer3.changed(function10)) || (i6 & 1572864) == 1048576;
                    objRememberedValue = composer3.rememberedValue();
                    if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = Dp.m9685boximpl(function10.invoke(Float.valueOf(0.0f)).m9701unboximpl());
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    fM9701unboximpl = ((Dp) objRememberedValue).m9701unboximpl();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, fM9701unboximpl);
                    ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment4, false);
                    Alignment alignment7 = alignment4;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierM1266size3ABfNKs);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composer3);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 826450783, "C519@23279L7,521@23329L207,528@23569L313,536@23948L164,541@24141L303,554@24719L447,534@23891L1609:FloatingActionButtonMenu.kt#uh7d8r");
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composer3.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    density = (Density) objConsume;
                    ComposerKt.sourceInformationMarkerStart(composer3, 1550680779, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    zChanged = composer3.changed(fM9701unboximpl);
                    objRememberedValue2 = composer3.rememberedValue();
                    if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        double dMo754toPx0680j_4 = density.mo754toPx0680j_4(fM9701unboximpl) / 2;
                        objRememberedValue2 = Dp.m9685boximpl(density.mo750toDpu2uoSUM((float) Math.hypot(dMo754toPx0680j_4, dMo754toPx0680j_4)));
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    float fM9701unboximpl2 = ((Dp) objRememberedValue2).m9701unboximpl();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1550688565, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    boolean zChanged3 = composer3.changed(density);
                    i7 = i6 & 896;
                    if (i7 == 256) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean z11 = zChanged3 | z4;
                    int i13 = (29360128 & i6) ^ 12582912;
                    z5 = z11 | ((i13 <= 8388608 && composer3.changed(function1ContainerCornerRadius)) || (i6 & 12582912) == 8388608);
                    objRememberedValue3 = composer3.rememberedValue();
                    if (!z5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new GenericShape(new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda21
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$1$0(density, function1ContainerCornerRadius, function0, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
                            }
                        });
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    genericShape = (GenericShape) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1550700544, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    zChanged2 = composer3.changed(genericShape);
                    objRememberedValue4 = composer3.rememberedValue();
                    if (!zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda22
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$2$0(genericShape, (GraphicsLayerScope) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue4);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1550706859, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    boolean zChanged4 = ((i13 <= 8388608 && composer3.changed(function1ContainerCornerRadius)) || (i6 & 12582912) == 8388608) | composer3.changed(density);
                    if (i7 == 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChanged4 | z6 | ((((57344 & i6) ^ 24576) <= 16384 && composer3.changed(function11)) || (i6 & 24576) == 16384);
                    objRememberedValue5 = composer3.rememberedValue();
                    if (!z7 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$3$0(density, function11, function0, function1ContainerCornerRadius, (DrawScope) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    int i14 = i6;
                    Function1<? super Float, Dp> function12 = function1ContainerCornerRadius;
                    composer2 = composer3;
                    Modifier modifierM1541toggleableO2vRcR0$default = ToggleableKt.m1541toggleableO2vRcR0$default(DrawModifierKt.drawBehind(modifierGraphicsLayer, (Function1) objRememberedValue5), z, null, RippleKt.m4031rippleH2RKhps$default(false, fM9701unboximpl2, 0L, 5, null), false, null, function1, 24, null);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1550725499, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    boolean z12 = (i12 <= 1048576 && composer2.changed(function10)) || (i14 & 1572864) == 1048576;
                    if (i7 == 256) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | z12;
                    objRememberedValue6 = composer2.rememberedValue();
                    if (!z9 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$4$0(function10, function0, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierLayout = LayoutModifierKt.layout(modifierM1541toggleableO2vRcR0$default, (Function3) objRememberedValue6);
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierLayout);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -569655582, "C566@25219L244,572@25476L14:FloatingActionButtonMenu.kt#uh7d8r");
                    ComposerKt.sourceInformationMarkerStart(composer2, -434017142, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                    z10 = i7 == 256;
                    objRememberedValue7 = composer2.rememberedValue();
                    if (!z10 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new ToggleFloatingActionButtonScope() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$ToggleFloatingActionButton$3$4$scope$1$1
                            @Override // androidx.compose.material3.ToggleFloatingActionButtonScope
                            public float getCheckedProgress() {
                                return function0.invoke().floatValue();
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    function5.invoke((FloatingActionButtonMenuKt$ToggleFloatingActionButton$3$4$scope$1$1) objRememberedValue7, composer2, Integer.valueOf((i14 >> 21) & 112));
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function7 = function11;
                    function9 = function10;
                    function8 = function12;
                    alignment3 = alignment7;
                    modifier3 = companion;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function7 = function2;
                    alignment3 = alignment;
                    function8 = function4;
                    function9 = function1ContainerSize;
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$4(z, function1, function0, modifier3, function7, alignment3, function9, function8, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            alignment2 = alignment;
            if ((i & 1572864) == 0) {
                function1ContainerSize = function3;
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            } else {
                function1ContainerSize = function3;
            }
            if ((i & 12582912) == 0) {
                if ((i2 & 128) == 0) {
                    function6 = function4;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                    }
                    i3 |= i11;
                } else {
                    function6 = function4;
                }
                i3 |= i11;
            } else {
                function6 = function4;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i3 |= i8;
            }
            if ((i3 & 38347923) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "510@22760L16");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 16) != 0) {
                        function1M4622containerColordgg9oW8 = ToggleFloatingActionButtonDefaults.INSTANCE.m4622containerColordgg9oW8(0L, 0L, composerStartRestartGroup, 384, 3);
                        composer3 = composerStartRestartGroup;
                        i3 &= -57345;
                    } else {
                        composer3 = composerStartRestartGroup;
                        function1M4622containerColordgg9oW8 = function2;
                    }
                    if (i4 != 0) {
                        topEnd = Alignment.INSTANCE.getTopEnd();
                    } else {
                        topEnd = alignment;
                    }
                    if ((i2 & 64) != 0) {
                        function1ContainerSize = ToggleFloatingActionButtonDefaults.INSTANCE.containerSize();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        Alignment alignment8 = topEnd;
                        i6 = i3 & (-29360129);
                        alignment4 = alignment8;
                        function10 = function1ContainerSize;
                        function11 = function1M4622containerColordgg9oW8;
                        function1ContainerCornerRadius = ToggleFloatingActionButtonDefaults.INSTANCE.containerCornerRadius();
                    } else {
                        Alignment alignment9 = topEnd;
                        i6 = i3;
                        alignment4 = alignment9;
                        function10 = function1ContainerSize;
                        function11 = function1M4622containerColordgg9oW8;
                        function1ContainerCornerRadius = function4;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 16) != 0) {
                        function1M4622containerColordgg9oW8 = ToggleFloatingActionButtonDefaults.INSTANCE.m4622containerColordgg9oW8(0L, 0L, composerStartRestartGroup, 384, 3);
                        composer3 = composerStartRestartGroup;
                        i3 &= -57345;
                    } else {
                        composer3 = composerStartRestartGroup;
                        function1M4622containerColordgg9oW8 = function2;
                    }
                    if (i4 != 0) {
                        topEnd = Alignment.INSTANCE.getTopEnd();
                    } else {
                        topEnd = alignment;
                    }
                    if ((i2 & 64) != 0) {
                        function1ContainerSize = ToggleFloatingActionButtonDefaults.INSTANCE.containerSize();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        Alignment alignment10 = topEnd;
                        i6 = i3 & (-29360129);
                        alignment4 = alignment10;
                        function10 = function1ContainerSize;
                        function11 = function1M4622containerColordgg9oW8;
                        function1ContainerCornerRadius = ToggleFloatingActionButtonDefaults.INSTANCE.containerCornerRadius();
                    } else {
                        Alignment alignment11 = topEnd;
                        i6 = i3;
                        alignment4 = alignment11;
                        function10 = function1ContainerSize;
                        function11 = function1M4622containerColordgg9oW8;
                        function1ContainerCornerRadius = function4;
                    }
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2138014434, i6, -1, "androidx.compose.material3.ToggleFloatingActionButton (FloatingActionButtonMenu.kt:516)");
                }
                ComposerKt.sourceInformationMarkerStart(composer3, 1637522831, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                int i15 = (3670016 & i6) ^ 1572864;
                if (i15 <= 1048576) {
                }
                objRememberedValue = composer3.rememberedValue();
                if (!z3) {
                    objRememberedValue = Dp.m9685boximpl(function10.invoke(Float.valueOf(0.0f)).m9701unboximpl());
                    composer3.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = Dp.m9685boximpl(function10.invoke(Float.valueOf(0.0f)).m9701unboximpl());
                    composer3.updateRememberedValue(objRememberedValue);
                }
                fM9701unboximpl = ((Dp) objRememberedValue).m9701unboximpl();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierM1266size3ABfNKs2 = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, fM9701unboximpl);
                ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(alignment4, false);
                Alignment alignment12 = alignment4;
                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierM1266size3ABfNKs2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor);
                } else {
                    composer3.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composer3);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, 826450783, "C519@23279L7,521@23329L207,528@23569L313,536@23948L164,541@24141L303,554@24719L447,534@23891L1609:FloatingActionButtonMenu.kt#uh7d8r");
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composer3.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                density = (Density) objConsume2;
                ComposerKt.sourceInformationMarkerStart(composer3, 1550680779, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                zChanged = composer3.changed(fM9701unboximpl);
                objRememberedValue2 = composer3.rememberedValue();
                if (!zChanged) {
                    double dMo754toPx0680j_5 = density.mo754toPx0680j_4(fM9701unboximpl) / 2;
                    objRememberedValue2 = Dp.m9685boximpl(density.mo750toDpu2uoSUM((float) Math.hypot(dMo754toPx0680j_5, dMo754toPx0680j_5)));
                    composer3.updateRememberedValue(objRememberedValue2);
                } else {
                    double dMo754toPx0680j_6 = density.mo754toPx0680j_4(fM9701unboximpl) / 2;
                    objRememberedValue2 = Dp.m9685boximpl(density.mo750toDpu2uoSUM((float) Math.hypot(dMo754toPx0680j_6, dMo754toPx0680j_6)));
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                float fM9701unboximpl3 = ((Dp) objRememberedValue2).m9701unboximpl();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, 1550688565, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                boolean zChanged5 = composer3.changed(density);
                i7 = i6 & 896;
                if (i7 == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z13 = zChanged5 | z4;
                int i16 = (29360128 & i6) ^ 12582912;
                z5 = z13 | ((i16 <= 8388608 && composer3.changed(function1ContainerCornerRadius)) || (i6 & 12582912) == 8388608);
                objRememberedValue3 = composer3.rememberedValue();
                if (!z5) {
                    objRememberedValue3 = new GenericShape(new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$1$0(density, function1ContainerCornerRadius, function0, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
                        }
                    });
                    composer3.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new GenericShape(new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$1$0(density, function1ContainerCornerRadius, function0, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
                        }
                    });
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                genericShape = (GenericShape) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, 1550700544, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                zChanged2 = composer3.changed(genericShape);
                objRememberedValue4 = composer3.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$2$0(genericShape, (GraphicsLayerScope) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$2$0(genericShape, (GraphicsLayerScope) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierGraphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue4);
                ComposerKt.sourceInformationMarkerStart(composer3, 1550706859, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                boolean zChanged6 = ((i16 <= 8388608 && composer3.changed(function1ContainerCornerRadius)) || (i6 & 12582912) == 8388608) | composer3.changed(density);
                if (i7 == 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChanged6 | z6 | ((((57344 & i6) ^ 24576) <= 16384 && composer3.changed(function11)) || (i6 & 24576) == 16384);
                objRememberedValue5 = composer3.rememberedValue();
                if (!z7) {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$3$0(density, function11, function0, function1ContainerCornerRadius, (DrawScope) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$3$0(density, function11, function0, function1ContainerCornerRadius, (DrawScope) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                int i17 = i6;
                Function1<? super Float, Dp> function13 = function1ContainerCornerRadius;
                composer2 = composer3;
                Modifier modifierM1541toggleableO2vRcR0$default2 = ToggleableKt.m1541toggleableO2vRcR0$default(DrawModifierKt.drawBehind(modifierGraphicsLayer2, (Function1) objRememberedValue5), z, null, RippleKt.m4031rippleH2RKhps$default(false, fM9701unboximpl3, 0L, 5, null), false, null, function1, 24, null);
                ComposerKt.sourceInformationMarkerStart(composer2, 1550725499, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                if (i15 <= 1048576) {
                }
                if (i7 == 256) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z8 | z12;
                objRememberedValue6 = composer2.rememberedValue();
                if (!z9) {
                    objRememberedValue6 = new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$4$0(function10, function0, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$4$0(function10, function0, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierLayout2 = LayoutModifierKt.layout(modifierM1541toggleableO2vRcR0$default2, (Function3) objRememberedValue6);
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierLayout2);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting()) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -569655582, "C566@25219L244,572@25476L14:FloatingActionButtonMenu.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(composer2, -434017142, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                if (i7 == 256) {
                }
                objRememberedValue7 = composer2.rememberedValue();
                if (!z10) {
                    objRememberedValue7 = new ToggleFloatingActionButtonScope() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$ToggleFloatingActionButton$3$4$scope$1$1
                        @Override // androidx.compose.material3.ToggleFloatingActionButtonScope
                        public float getCheckedProgress() {
                            return function0.invoke().floatValue();
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new ToggleFloatingActionButtonScope() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$ToggleFloatingActionButton$3$4$scope$1$1
                        @Override // androidx.compose.material3.ToggleFloatingActionButtonScope
                        public float getCheckedProgress() {
                            return function0.invoke().floatValue();
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                function5.invoke((FloatingActionButtonMenuKt$ToggleFloatingActionButton$3$4$scope$1$1) objRememberedValue7, composer2, Integer.valueOf((i17 >> 21) & 112));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function7 = function11;
                function9 = function10;
                function8 = function13;
                alignment3 = alignment12;
                modifier3 = companion;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function7 = function2;
                alignment3 = alignment;
                function8 = function4;
                function9 = function1ContainerSize;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$4(z, function1, function0, modifier3, function7, alignment3, function9, function8, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        if ((i & 24576) != 0) {
            i3 |= ((i2 & 16) == 0 || !composerStartRestartGroup.changedInstance(function2)) ? 8192 : 16384;
        }
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                alignment2 = alignment;
                if (composerStartRestartGroup.changed(alignment2)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((i & 1572864) == 0) {
                function1ContainerSize = function3;
                if ((i2 & 64) == 0) {
                    i9 = 524288;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            } else {
                function1ContainerSize = function3;
            }
            if ((i & 12582912) == 0) {
                if ((i2 & 128) == 0) {
                    function6 = function4;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                    }
                    i3 |= i11;
                } else {
                    function6 = function4;
                }
                i3 |= i11;
            } else {
                function6 = function4;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i3 |= i8;
            }
            if ((i3 & 38347923) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "510@22760L16");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 16) != 0) {
                        function1M4622containerColordgg9oW8 = ToggleFloatingActionButtonDefaults.INSTANCE.m4622containerColordgg9oW8(0L, 0L, composerStartRestartGroup, 384, 3);
                        composer3 = composerStartRestartGroup;
                        i3 &= -57345;
                    } else {
                        composer3 = composerStartRestartGroup;
                        function1M4622containerColordgg9oW8 = function2;
                    }
                    if (i4 != 0) {
                        topEnd = Alignment.INSTANCE.getTopEnd();
                    } else {
                        topEnd = alignment;
                    }
                    if ((i2 & 64) != 0) {
                        function1ContainerSize = ToggleFloatingActionButtonDefaults.INSTANCE.containerSize();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        Alignment alignment13 = topEnd;
                        i6 = i3 & (-29360129);
                        alignment4 = alignment13;
                        function10 = function1ContainerSize;
                        function11 = function1M4622containerColordgg9oW8;
                        function1ContainerCornerRadius = ToggleFloatingActionButtonDefaults.INSTANCE.containerCornerRadius();
                    } else {
                        Alignment alignment14 = topEnd;
                        i6 = i3;
                        alignment4 = alignment14;
                        function10 = function1ContainerSize;
                        function11 = function1M4622containerColordgg9oW8;
                        function1ContainerCornerRadius = function4;
                    }
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 16) != 0) {
                        function1M4622containerColordgg9oW8 = ToggleFloatingActionButtonDefaults.INSTANCE.m4622containerColordgg9oW8(0L, 0L, composerStartRestartGroup, 384, 3);
                        composer3 = composerStartRestartGroup;
                        i3 &= -57345;
                    } else {
                        composer3 = composerStartRestartGroup;
                        function1M4622containerColordgg9oW8 = function2;
                    }
                    if (i4 != 0) {
                        topEnd = Alignment.INSTANCE.getTopEnd();
                    } else {
                        topEnd = alignment;
                    }
                    if ((i2 & 64) != 0) {
                        function1ContainerSize = ToggleFloatingActionButtonDefaults.INSTANCE.containerSize();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        Alignment alignment15 = topEnd;
                        i6 = i3 & (-29360129);
                        alignment4 = alignment15;
                        function10 = function1ContainerSize;
                        function11 = function1M4622containerColordgg9oW8;
                        function1ContainerCornerRadius = ToggleFloatingActionButtonDefaults.INSTANCE.containerCornerRadius();
                    } else {
                        Alignment alignment16 = topEnd;
                        i6 = i3;
                        alignment4 = alignment16;
                        function10 = function1ContainerSize;
                        function11 = function1M4622containerColordgg9oW8;
                        function1ContainerCornerRadius = function4;
                    }
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2138014434, i6, -1, "androidx.compose.material3.ToggleFloatingActionButton (FloatingActionButtonMenu.kt:516)");
                }
                ComposerKt.sourceInformationMarkerStart(composer3, 1637522831, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                int i18 = (3670016 & i6) ^ 1572864;
                if (i18 <= 1048576) {
                }
                objRememberedValue = composer3.rememberedValue();
                if (!z3) {
                    objRememberedValue = Dp.m9685boximpl(function10.invoke(Float.valueOf(0.0f)).m9701unboximpl());
                    composer3.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = Dp.m9685boximpl(function10.invoke(Float.valueOf(0.0f)).m9701unboximpl());
                    composer3.updateRememberedValue(objRememberedValue);
                }
                fM9701unboximpl = ((Dp) objRememberedValue).m9701unboximpl();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierM1266size3ABfNKs3 = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, fM9701unboximpl);
                ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(alignment4, false);
                Alignment alignment17 = alignment4;
                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composer3.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer3, modifierM1266size3ABfNKs3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                    composer3.createNode(constructor);
                } else {
                    composer3.useNode();
                }
                composerM6062constructorimpl = Updater.m6062constructorimpl(composer3);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer3, 826450783, "C519@23279L7,521@23329L207,528@23569L313,536@23948L164,541@24141L303,554@24719L447,534@23891L1609:FloatingActionButtonMenu.kt#uh7d8r");
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composer3.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                density = (Density) objConsume3;
                ComposerKt.sourceInformationMarkerStart(composer3, 1550680779, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                zChanged = composer3.changed(fM9701unboximpl);
                objRememberedValue2 = composer3.rememberedValue();
                if (!zChanged) {
                    double dMo754toPx0680j_7 = density.mo754toPx0680j_4(fM9701unboximpl) / 2;
                    objRememberedValue2 = Dp.m9685boximpl(density.mo750toDpu2uoSUM((float) Math.hypot(dMo754toPx0680j_7, dMo754toPx0680j_7)));
                    composer3.updateRememberedValue(objRememberedValue2);
                } else {
                    double dMo754toPx0680j_8 = density.mo754toPx0680j_4(fM9701unboximpl) / 2;
                    objRememberedValue2 = Dp.m9685boximpl(density.mo750toDpu2uoSUM((float) Math.hypot(dMo754toPx0680j_8, dMo754toPx0680j_8)));
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                float fM9701unboximpl4 = ((Dp) objRememberedValue2).m9701unboximpl();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, 1550688565, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                boolean zChanged7 = composer3.changed(density);
                i7 = i6 & 896;
                if (i7 == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z14 = zChanged7 | z4;
                int i19 = (29360128 & i6) ^ 12582912;
                z5 = z14 | ((i19 <= 8388608 && composer3.changed(function1ContainerCornerRadius)) || (i6 & 12582912) == 8388608);
                objRememberedValue3 = composer3.rememberedValue();
                if (!z5) {
                    objRememberedValue3 = new GenericShape(new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$1$0(density, function1ContainerCornerRadius, function0, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
                        }
                    });
                    composer3.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new GenericShape(new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$1$0(density, function1ContainerCornerRadius, function0, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
                        }
                    });
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                genericShape = (GenericShape) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, 1550700544, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                zChanged2 = composer3.changed(genericShape);
                objRememberedValue4 = composer3.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$2$0(genericShape, (GraphicsLayerScope) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$2$0(genericShape, (GraphicsLayerScope) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierGraphicsLayer3 = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue4);
                ComposerKt.sourceInformationMarkerStart(composer3, 1550706859, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                boolean zChanged8 = ((i19 <= 8388608 && composer3.changed(function1ContainerCornerRadius)) || (i6 & 12582912) == 8388608) | composer3.changed(density);
                if (i7 == 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = zChanged8 | z6 | ((((57344 & i6) ^ 24576) <= 16384 && composer3.changed(function11)) || (i6 & 24576) == 16384);
                objRememberedValue5 = composer3.rememberedValue();
                if (!z7) {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$3$0(density, function11, function0, function1ContainerCornerRadius, (DrawScope) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$3$0(density, function11, function0, function1ContainerCornerRadius, (DrawScope) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                int i110 = i6;
                Function1<? super Float, Dp> function14 = function1ContainerCornerRadius;
                composer2 = composer3;
                Modifier modifierM1541toggleableO2vRcR0$default3 = ToggleableKt.m1541toggleableO2vRcR0$default(DrawModifierKt.drawBehind(modifierGraphicsLayer3, (Function1) objRememberedValue5), z, null, RippleKt.m4031rippleH2RKhps$default(false, fM9701unboximpl4, 0L, 5, null), false, null, function1, 24, null);
                ComposerKt.sourceInformationMarkerStart(composer2, 1550725499, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                if (i18 <= 1048576) {
                }
                if (i7 == 256) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z8 | z12;
                objRememberedValue6 = composer2.rememberedValue();
                if (!z9) {
                    objRememberedValue6 = new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$4$0(function10, function0, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$4$0(function10, function0, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierLayout3 = LayoutModifierKt.layout(modifierM1541toggleableO2vRcR0$default3, (Function3) objRememberedValue6);
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer2, modifierLayout3);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting()) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -569655582, "C566@25219L244,572@25476L14:FloatingActionButtonMenu.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(composer2, -434017142, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
                if (i7 == 256) {
                }
                objRememberedValue7 = composer2.rememberedValue();
                if (!z10) {
                    objRememberedValue7 = new ToggleFloatingActionButtonScope() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$ToggleFloatingActionButton$3$4$scope$1$1
                        @Override // androidx.compose.material3.ToggleFloatingActionButtonScope
                        public float getCheckedProgress() {
                            return function0.invoke().floatValue();
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new ToggleFloatingActionButtonScope() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$ToggleFloatingActionButton$3$4$scope$1$1
                        @Override // androidx.compose.material3.ToggleFloatingActionButtonScope
                        public float getCheckedProgress() {
                            return function0.invoke().floatValue();
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                function5.invoke((FloatingActionButtonMenuKt$ToggleFloatingActionButton$3$4$scope$1$1) objRememberedValue7, composer2, Integer.valueOf((i110 >> 21) & 112));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function7 = function11;
                function9 = function10;
                function8 = function14;
                alignment3 = alignment17;
                modifier3 = companion;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function7 = function2;
                alignment3 = alignment;
                function8 = function4;
                function9 = function1ContainerSize;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$4(z, function1, function0, modifier3, function7, alignment3, function9, function8, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        alignment2 = alignment;
        if ((i & 1572864) == 0) {
            function1ContainerSize = function3;
            if ((i2 & 64) == 0) {
                i9 = 524288;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        } else {
            function1ContainerSize = function3;
        }
        if ((i & 12582912) == 0) {
            if ((i2 & 128) == 0) {
                function6 = function4;
                if (composerStartRestartGroup.changedInstance(function6)) {
                }
                i3 |= i11;
            } else {
                function6 = function4;
            }
            i3 |= i11;
        } else {
            function6 = function4;
        }
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function5)) {
                i8 = 67108864;
            } else {
                i8 = 33554432;
            }
            i3 |= i8;
        }
        if ((i3 & 38347923) != 38347922) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "510@22760L16");
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 16) != 0) {
                    function1M4622containerColordgg9oW8 = ToggleFloatingActionButtonDefaults.INSTANCE.m4622containerColordgg9oW8(0L, 0L, composerStartRestartGroup, 384, 3);
                    composer3 = composerStartRestartGroup;
                    i3 &= -57345;
                } else {
                    composer3 = composerStartRestartGroup;
                    function1M4622containerColordgg9oW8 = function2;
                }
                if (i4 != 0) {
                    topEnd = Alignment.INSTANCE.getTopEnd();
                } else {
                    topEnd = alignment;
                }
                if ((i2 & 64) != 0) {
                    function1ContainerSize = ToggleFloatingActionButtonDefaults.INSTANCE.containerSize();
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    Alignment alignment18 = topEnd;
                    i6 = i3 & (-29360129);
                    alignment4 = alignment18;
                    function10 = function1ContainerSize;
                    function11 = function1M4622containerColordgg9oW8;
                    function1ContainerCornerRadius = ToggleFloatingActionButtonDefaults.INSTANCE.containerCornerRadius();
                } else {
                    Alignment alignment19 = topEnd;
                    i6 = i3;
                    alignment4 = alignment19;
                    function10 = function1ContainerSize;
                    function11 = function1M4622containerColordgg9oW8;
                    function1ContainerCornerRadius = function4;
                }
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 16) != 0) {
                    function1M4622containerColordgg9oW8 = ToggleFloatingActionButtonDefaults.INSTANCE.m4622containerColordgg9oW8(0L, 0L, composerStartRestartGroup, 384, 3);
                    composer3 = composerStartRestartGroup;
                    i3 &= -57345;
                } else {
                    composer3 = composerStartRestartGroup;
                    function1M4622containerColordgg9oW8 = function2;
                }
                if (i4 != 0) {
                    topEnd = Alignment.INSTANCE.getTopEnd();
                } else {
                    topEnd = alignment;
                }
                if ((i2 & 64) != 0) {
                    function1ContainerSize = ToggleFloatingActionButtonDefaults.INSTANCE.containerSize();
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    Alignment alignment110 = topEnd;
                    i6 = i3 & (-29360129);
                    alignment4 = alignment110;
                    function10 = function1ContainerSize;
                    function11 = function1M4622containerColordgg9oW8;
                    function1ContainerCornerRadius = ToggleFloatingActionButtonDefaults.INSTANCE.containerCornerRadius();
                } else {
                    Alignment alignment111 = topEnd;
                    i6 = i3;
                    alignment4 = alignment111;
                    function10 = function1ContainerSize;
                    function11 = function1M4622containerColordgg9oW8;
                    function1ContainerCornerRadius = function4;
                }
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2138014434, i6, -1, "androidx.compose.material3.ToggleFloatingActionButton (FloatingActionButtonMenu.kt:516)");
            }
            ComposerKt.sourceInformationMarkerStart(composer3, 1637522831, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            int i111 = (3670016 & i6) ^ 1572864;
            if (i111 <= 1048576) {
            }
            objRememberedValue = composer3.rememberedValue();
            if (!z3) {
                objRememberedValue = Dp.m9685boximpl(function10.invoke(Float.valueOf(0.0f)).m9701unboximpl());
                composer3.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = Dp.m9685boximpl(function10.invoke(Float.valueOf(0.0f)).m9701unboximpl());
                composer3.updateRememberedValue(objRememberedValue);
            }
            fM9701unboximpl = ((Dp) objRememberedValue).m9701unboximpl();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            Modifier modifierM1266size3ABfNKs4 = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, fM9701unboximpl);
            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(alignment4, false);
            Alignment alignment112 = alignment4;
            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap7 = composer3.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer3, modifierM1266size3ABfNKs4);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            composerM6062constructorimpl = Updater.m6062constructorimpl(composer3);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer3, 826450783, "C519@23279L7,521@23329L207,528@23569L313,536@23948L164,541@24141L303,554@24719L447,534@23891L1609:FloatingActionButtonMenu.kt#uh7d8r");
            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composer3.consume(localDensity4);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            density = (Density) objConsume4;
            ComposerKt.sourceInformationMarkerStart(composer3, 1550680779, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            zChanged = composer3.changed(fM9701unboximpl);
            objRememberedValue2 = composer3.rememberedValue();
            if (!zChanged) {
                double dMo754toPx0680j_9 = density.mo754toPx0680j_4(fM9701unboximpl) / 2;
                objRememberedValue2 = Dp.m9685boximpl(density.mo750toDpu2uoSUM((float) Math.hypot(dMo754toPx0680j_9, dMo754toPx0680j_9)));
                composer3.updateRememberedValue(objRememberedValue2);
            } else {
                double dMo754toPx0680j_10 = density.mo754toPx0680j_4(fM9701unboximpl) / 2;
                objRememberedValue2 = Dp.m9685boximpl(density.mo750toDpu2uoSUM((float) Math.hypot(dMo754toPx0680j_10, dMo754toPx0680j_10)));
                composer3.updateRememberedValue(objRememberedValue2);
            }
            float fM9701unboximpl5 = ((Dp) objRememberedValue2).m9701unboximpl();
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, 1550688565, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            boolean zChanged9 = composer3.changed(density);
            i7 = i6 & 896;
            if (i7 == 256) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z15 = zChanged9 | z4;
            int i112 = (29360128 & i6) ^ 12582912;
            z5 = z15 | ((i112 <= 8388608 && composer3.changed(function1ContainerCornerRadius)) || (i6 & 12582912) == 8388608);
            objRememberedValue3 = composer3.rememberedValue();
            if (!z5) {
                objRememberedValue3 = new GenericShape(new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$1$0(density, function1ContainerCornerRadius, function0, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
                    }
                });
                composer3.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new GenericShape(new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$1$0(density, function1ContainerCornerRadius, function0, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
                    }
                });
                composer3.updateRememberedValue(objRememberedValue3);
            }
            genericShape = (GenericShape) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, 1550700544, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            zChanged2 = composer3.changed(genericShape);
            objRememberedValue4 = composer3.rememberedValue();
            if (!zChanged2) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$2$0(genericShape, (GraphicsLayerScope) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$2$0(genericShape, (GraphicsLayerScope) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            Modifier modifierGraphicsLayer4 = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue4);
            ComposerKt.sourceInformationMarkerStart(composer3, 1550706859, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            boolean zChanged10 = ((i112 <= 8388608 && composer3.changed(function1ContainerCornerRadius)) || (i6 & 12582912) == 8388608) | composer3.changed(density);
            if (i7 == 256) {
                z6 = true;
            } else {
                z6 = false;
            }
            z7 = zChanged10 | z6 | ((((57344 & i6) ^ 24576) <= 16384 && composer3.changed(function11)) || (i6 & 24576) == 16384);
            objRememberedValue5 = composer3.rememberedValue();
            if (!z7) {
                objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$3$0(density, function11, function0, function1ContainerCornerRadius, (DrawScope) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$3$0(density, function11, function0, function1ContainerCornerRadius, (DrawScope) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            int i113 = i6;
            Function1<? super Float, Dp> function15 = function1ContainerCornerRadius;
            composer2 = composer3;
            Modifier modifierM1541toggleableO2vRcR0$default4 = ToggleableKt.m1541toggleableO2vRcR0$default(DrawModifierKt.drawBehind(modifierGraphicsLayer4, (Function1) objRememberedValue5), z, null, RippleKt.m4031rippleH2RKhps$default(false, fM9701unboximpl5, 0L, 5, null), false, null, function1, 24, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 1550725499, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            if (i111 <= 1048576) {
            }
            if (i7 == 256) {
                z8 = true;
            } else {
                z8 = false;
            }
            z9 = z8 | z12;
            objRememberedValue6 = composer2.rememberedValue();
            if (!z9) {
                objRememberedValue6 = new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$4$0(function10, function0, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function3() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$4$0(function10, function0, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierLayout4 = LayoutModifierKt.layout(modifierM1541toggleableO2vRcR0$default4, (Function3) objRememberedValue6);
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap8 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer2, modifierLayout4);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl2.getInserting()) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -569655582, "C566@25219L244,572@25476L14:FloatingActionButtonMenu.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(composer2, -434017142, "CC(remember):FloatingActionButtonMenu.kt#9igjgp");
            if (i7 == 256) {
            }
            objRememberedValue7 = composer2.rememberedValue();
            if (!z10) {
                objRememberedValue7 = new ToggleFloatingActionButtonScope() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$ToggleFloatingActionButton$3$4$scope$1$1
                    @Override // androidx.compose.material3.ToggleFloatingActionButtonScope
                    public float getCheckedProgress() {
                        return function0.invoke().floatValue();
                    }
                };
                composer2.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new ToggleFloatingActionButtonScope() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$ToggleFloatingActionButton$3$4$scope$1$1
                    @Override // androidx.compose.material3.ToggleFloatingActionButtonScope
                    public float getCheckedProgress() {
                        return function0.invoke().floatValue();
                    }
                };
                composer2.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            function5.invoke((FloatingActionButtonMenuKt$ToggleFloatingActionButton$3$4$scope$1$1) objRememberedValue7, composer2, Integer.valueOf((i113 >> 21) & 112));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function7 = function11;
            function9 = function10;
            function8 = function15;
            alignment3 = alignment112;
            modifier3 = companion;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function7 = function2;
            alignment3 = alignment;
            function8 = function4;
            function9 = function1ContainerSize;
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$4(z, function1, function0, modifier3, function7, alignment3, function9, function8, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleFloatingActionButton$lambda$3$1$0(Density density, Function1 function1, Function0 function0, Path path, Size size, LayoutDirection layoutDirection) {
        float fMo754toPx0680j_4 = density.mo754toPx0680j_4(((Dp) function1.invoke(function0.invoke())).m9701unboximpl());
        Path.addRoundRect$default(path, RoundRectKt.m6624RoundRectsniSvfs(androidx.compose.ui.geometry.SizeKt.m6659toRectuvyYCjk(size.m6643unboximpl()), CornerRadius.m6523constructorimpl((((long) Float.floatToRawIntBits(fMo754toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo754toPx0680j_4)) & 4294967295L))), null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleFloatingActionButton$lambda$3$2$0(GenericShape genericShape, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setShadowElevation(graphicsLayerScope.mo754toPx0680j_4(FabShadowElevation));
        graphicsLayerScope.setShape(genericShape);
        graphicsLayerScope.setClip(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleFloatingActionButton$lambda$3$3$0(Density density, Function1 function1, Function0 function0, Function1 function2, DrawScope drawScope) {
        float fMo754toPx0680j_4 = density.mo754toPx0680j_4(((Dp) function2.invoke(function0.invoke())).m9701unboximpl());
        DrawScope.m7391drawRoundRectuAw5IA$default(drawScope, ((Color) function1.invoke(function0.invoke())).m6824unboximpl(), 0L, 0L, CornerRadius.m6523constructorimpl((((long) Float.floatToRawIntBits(fMo754toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo754toPx0680j_4)) & 4294967295L)), null, 0.0f, null, 0, 246, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult ToggleFloatingActionButton$lambda$3$4$0(Function1 function1, Function0 function0, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(constraints.getValue());
        final int i = measureScope.mo748roundToPx0680j_4(((Dp) function1.invoke(function0.invoke())).m9701unboximpl());
        return MeasureScope.layout$default(measureScope, i, i, null, new Function1() { // from class: androidx.compose.material3.FloatingActionButtonMenuKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FloatingActionButtonMenuKt.ToggleFloatingActionButton$lambda$3$4$0$0(placeableMo8265measureBRTryo0, i, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleFloatingActionButton$lambda$3$4$0$0(Placeable placeable, int i, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, (i - placeable.getWidth()) / 2, (i - placeable.getHeight()) / 2, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    private static final Modifier itemVisible(Modifier modifier, Function0<Boolean> function0) {
        return modifier.then(new MenuItemVisibleElement(function0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isVisible(Placeable placeable) {
        Function0<Boolean> visible;
        Object parentData = placeable.getParentData();
        MenuItemVisibilityModifier menuItemVisibilityModifier = parentData instanceof MenuItemVisibilityModifier ? (MenuItemVisibilityModifier) parentData : null;
        boolean z = false;
        if (menuItemVisibilityModifier != null && (visible = menuItemVisibilityModifier.getVisible()) != null && !visible.invoke().booleanValue()) {
            z = true;
        }
        return !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FloatingActionButtonMenuItemColumn$lambda$2(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FloatingActionButtonMenuItemColumn$lambda$8(MutableState<Animatable<Integer, AnimationVector1D>> mutableState, Animatable<Integer, AnimationVector1D> animatable) {
        mutableState.setValue(animatable);
    }
}
