package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.DropdownMenuPositionProvider;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidMenu.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\u001a\u009f\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001aa\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007¢\u0006\u0004\b\u001f\u0010 \u001aO\u0010!\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0001¢\u0006\u0002\u0010'\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007¢\u0006\u0004\b(\u0010)\u001aa\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007¢\u0006\u0004\b*\u0010 \u001a\u0090\u0001\u0010+\u001a\u00020\u00012\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001a2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u001a2\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u0002042\n\b\u0002\u00105\u001a\u0004\u0018\u000106H\u0007¢\u0006\u0002\u00107\"\u0014\u00108\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006;²\u0006\n\u0010<\u001a\u00020=X\u008a\u0084\u0002²\u0006\n\u0010>\u001a\u00020=X\u008a\u0084\u0002"}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-IlH_yew", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "DropdownMenuPopup", "DropdownMenuPopup-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuPopupContent", "expandedState", "Landroidx/compose/animation/core/MutableTransitionState;", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenu-ILWXrKs", "DropdownMenuItem", "text", ViewProps.ON_CLICK, "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "DefaultMenuProperties", "getDefaultMenuProperties", "()Landroidx/compose/ui/window/PopupProperties;", "material3", "scale", "", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidMenu_androidKt {
    private static final PopupProperties DefaultMenuProperties = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItem$lambda$0(Function2 function2, Function0 function0, Modifier modifier, Function2 function3, Function2 function4, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        DropdownMenuItem(function2, function0, modifier, function3, function4, z, menuItemColors, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec DropdownMenuPopupContent$lambda$0(FiniteAnimationSpec finiteAnimationSpec, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(-1891222038);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1891222038, i, -1, "androidx.compose.material3.DropdownMenuPopupContent.<anonymous> (AndroidMenu.android.kt:151)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec DropdownMenuPopupContent$lambda$3(FiniteAnimationSpec finiteAnimationSpec, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(1122412374);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1122412374, i, -1, "androidx.compose.material3.DropdownMenuPopupContent.<anonymous> (AndroidMenu.android.kt:156)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuPopupContent$lambda$7(Modifier modifier, MutableTransitionState mutableTransitionState, MutableState mutableState, Function3 function3, int i, Composer composer, int i2) {
        DropdownMenuPopupContent(modifier, mutableTransitionState, mutableState, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuPopup_ILWXrKs$lambda$4(boolean z, Function0 function0, Modifier modifier, long j, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2744DropdownMenuPopupILWXrKs(z, function0, modifier, j, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenu_4kj__NE$lambda$0(boolean z, Function0 function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2741DropdownMenu4kj_NE(z, function0, modifier, j, scrollState, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenu_ILWXrKs$lambda$0(boolean z, Function0 function0, Modifier modifier, long j, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2742DropdownMenuILWXrKs(z, function0, modifier, j, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenu_IlH_yew$lambda$4(boolean z, Function0 function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, Shape shape, long j2, float f, float f2, BorderStroke borderStroke, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m2743DropdownMenuIlH_yew(z, function0, modifier, j, scrollState, popupProperties, shape, j2, f, f2, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0126  */
    /* JADX WARN: Code duplicated, block: B:101:0x0129  */
    /* JADX WARN: Code duplicated, block: B:106:0x0136  */
    /* JADX WARN: Code duplicated, block: B:107:0x013f  */
    /* JADX WARN: Code duplicated, block: B:109:0x0143  */
    /* JADX WARN: Code duplicated, block: B:111:0x014d  */
    /* JADX WARN: Code duplicated, block: B:112:0x0150  */
    /* JADX WARN: Code duplicated, block: B:114:0x0155  */
    /* JADX WARN: Code duplicated, block: B:117:0x0161  */
    /* JADX WARN: Code duplicated, block: B:119:0x0167  */
    /* JADX WARN: Code duplicated, block: B:120:0x016a  */
    /* JADX WARN: Code duplicated, block: B:124:0x017c  */
    /* JADX WARN: Code duplicated, block: B:128:0x0185  */
    /* JADX WARN: Code duplicated, block: B:131:0x018e  */
    /* JADX WARN: Code duplicated, block: B:133:0x019d  */
    /* JADX WARN: Code duplicated, block: B:146:0x01cf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:151:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:154:0x0201  */
    /* JADX WARN: Code duplicated, block: B:156:0x020a  */
    /* JADX WARN: Code duplicated, block: B:159:0x0211  */
    /* JADX WARN: Code duplicated, block: B:160:0x021c  */
    /* JADX WARN: Code duplicated, block: B:163:0x0221  */
    /* JADX WARN: Code duplicated, block: B:164:0x022d  */
    /* JADX WARN: Code duplicated, block: B:166:0x0231  */
    /* JADX WARN: Code duplicated, block: B:167:0x0238  */
    /* JADX WARN: Code duplicated, block: B:169:0x023c  */
    /* JADX WARN: Code duplicated, block: B:170:0x0243  */
    /* JADX WARN: Code duplicated, block: B:172:0x0247  */
    /* JADX WARN: Code duplicated, block: B:173:0x0256  */
    /* JADX WARN: Code duplicated, block: B:176:0x026d  */
    /* JADX WARN: Code duplicated, block: B:179:0x0289  */
    /* JADX WARN: Code duplicated, block: B:180:0x0298  */
    /* JADX WARN: Code duplicated, block: B:183:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:187:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:189:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:192:0x0323  */
    /* JADX WARN: Code duplicated, block: B:195:0x0331  */
    /* JADX WARN: Code duplicated, block: B:197:0x0339  */
    /* JADX WARN: Code duplicated, block: B:201:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:203:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:206:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:208:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:37:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x007c  */
    /* JADX WARN: Code duplicated, block: B:44:0x0080  */
    /* JADX WARN: Code duplicated, block: B:46:0x0088  */
    /* JADX WARN: Code duplicated, block: B:47:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x009a  */
    /* JADX WARN: Code duplicated, block: B:54:0x009f  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:65:0x00be  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:81:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:89:0x0103  */
    /* JADX WARN: Code duplicated, block: B:90:0x0106  */
    /* JADX WARN: Code duplicated, block: B:95:0x0115  */
    /* JADX WARN: Code duplicated, block: B:96:0x0118  */
    /* JADX WARN: Code duplicated, block: B:98:0x011c  */
    /* JADX INFO: renamed from: DropdownMenu-IlH_yew, reason: not valid java name */
    public static final void m2743DropdownMenuIlH_yew(final boolean z, final Function0<Unit> function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, Shape shape, long j2, float f, float f2, BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0<Unit> function1;
        Modifier modifier2;
        int i5;
        int i6;
        int i7;
        ScrollState scrollStateRememberScrollState;
        int i8;
        PopupProperties popupProperties2;
        int i9;
        Shape shape2;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z2;
        Composer composer2;
        final long jM9743constructorimpl;
        final float f3;
        final ScrollState scrollState2;
        final PopupProperties popupProperties3;
        final Modifier modifier3;
        final Shape shape3;
        final long j3;
        final float f4;
        final BorderStroke borderStroke2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Shape shape4;
        long containerColor;
        float fM3754getTonalElevationD9Ej5fM;
        float fM3753getShadowElevationD9Ej5fM;
        final BorderStroke borderStroke3;
        final Modifier modifier4;
        final ScrollState scrollState3;
        final Shape shape5;
        final long j4;
        final float f5;
        final float f6;
        Object objRememberedValue;
        boolean z3;
        final MutableTransitionState mutableTransitionState;
        Object objRememberedValue2;
        final MutableState mutableState;
        Density density;
        boolean zChanged;
        Object objRememberedValue3;
        int i18;
        int i19;
        Composer composerStartRestartGroup = composer.startRestartGroup(1725609375);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenu)N(expanded,onDismissRequest,modifier,offset:c#ui.unit.DpOffset,scrollState,properties,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)66@2629L42:AndroidMenu.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            function1 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        int i20 = i3 & 4;
        if (i20 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    int i21 = i4;
                    if (composerStartRestartGroup.changed(j)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i7 = i21 | i6;
                }
                if ((i & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        scrollStateRememberScrollState = scrollState;
                        int i22 = composerStartRestartGroup.changed(scrollStateRememberScrollState) ? 16384 : 8192;
                        i7 |= i22;
                    } else {
                        scrollStateRememberScrollState = scrollState;
                    }
                    i7 |= i22;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i8 = i3 & 32;
                if (i8 != 0) {
                    i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    popupProperties2 = popupProperties;
                } else {
                    popupProperties2 = popupProperties;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(popupProperties2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i7 |= i9;
                    }
                }
                if ((i & 1572864) == 0) {
                    shape2 = shape;
                    if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(shape2)) {
                        i19 = 524288;
                    } else {
                        i19 = 1048576;
                    }
                    i7 |= i19;
                } else {
                    shape2 = shape;
                }
                if ((i & 12582912) != 0) {
                    i7 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(j2)) ? 4194304 : 8388608;
                }
                i10 = i3 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i7 |= i11;
                    }
                    i12 = i3 & 512;
                    if (i12 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(f2)) {
                                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i13 = 268435456;
                            }
                            i7 |= i13;
                        }
                        i14 = i3 & 1024;
                        if (i14 != 0) {
                            i15 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            if (composerStartRestartGroup.changed(borderStroke)) {
                                i16 = 4;
                            } else {
                                i16 = 2;
                            }
                            i15 = i2 | i16;
                        } else {
                            i15 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i18 = 32;
                            } else {
                                i18 = 16;
                            }
                            i15 |= i18;
                        }
                        i17 = i15;
                        if ((i7 & 306783379) == 306783378 || (i17 & 19) != 18) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i20 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier2;
                                }
                                if (i5 != 0) {
                                    float f7 = 0;
                                    jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f7))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f7))) << 32));
                                } else {
                                    jM9743constructorimpl = j;
                                }
                                if ((i3 & 16) != 0) {
                                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                    i7 &= -57345;
                                }
                                if (i8 != 0) {
                                    popupProperties2 = DefaultMenuProperties;
                                }
                                if ((i3 & 64) != 0) {
                                    shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                    i7 &= -3670017;
                                } else {
                                    shape4 = shape2;
                                }
                                if ((i3 & 128) != 0) {
                                    containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i7 = (-29360129) & i7;
                                } else {
                                    containerColor = j2;
                                }
                                if (i10 != 0) {
                                    fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                                } else {
                                    fM3754getTonalElevationD9Ej5fM = f;
                                }
                                if (i12 != 0) {
                                    fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                                } else {
                                    fM3753getShadowElevationD9Ej5fM = f2;
                                }
                                if (i14 != 0) {
                                    modifier4 = companion;
                                    scrollState3 = scrollStateRememberScrollState;
                                    shape5 = shape4;
                                    j4 = containerColor;
                                    f5 = fM3754getTonalElevationD9Ej5fM;
                                    f6 = fM3753getShadowElevationD9Ej5fM;
                                    borderStroke3 = null;
                                } else {
                                    borderStroke3 = borderStroke;
                                    modifier4 = companion;
                                    scrollState3 = scrollStateRememberScrollState;
                                    shape5 = shape4;
                                    j4 = containerColor;
                                    f5 = fM3754getTonalElevationD9Ej5fM;
                                    f6 = fM3753getShadowElevationD9Ej5fM;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 16) != 0) {
                                    i7 &= -57345;
                                }
                                if ((i3 & 64) != 0) {
                                    i7 &= -3670017;
                                }
                                if ((i3 & 128) != 0) {
                                    i7 &= -29360129;
                                }
                                jM9743constructorimpl = j;
                                j4 = j2;
                                f5 = f;
                                f6 = f2;
                                borderStroke3 = borderStroke;
                                scrollState3 = scrollStateRememberScrollState;
                                modifier4 = modifier2;
                                shape5 = shape2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                z3 = false;
                                objRememberedValue = new MutableTransitionState(false);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            } else {
                                z3 = false;
                            }
                            mutableTransitionState = (MutableTransitionState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                            if (!((Boolean) mutableTransitionState.getCurrentState()).booleanValue() || ((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
                                composerStartRestartGroup.startReplaceGroup(1165888662);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                mutableState = (MutableState) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                density = (Density) objConsume;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                                if ((i7 & 7168) == 2048) {
                                    z3 = true;
                                }
                                zChanged = z3 | composerStartRestartGroup.changed(density);
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                        }
                                    }, 4, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                                composer2 = composerStartRestartGroup;
                                composer2.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1163094787);
                                composerStartRestartGroup.endReplaceGroup();
                                composer2 = composerStartRestartGroup;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            popupProperties3 = popupProperties2;
                            modifier3 = modifier4;
                            scrollState2 = scrollState3;
                            shape3 = shape5;
                            j3 = j4;
                            f4 = f5;
                            f3 = f6;
                            borderStroke2 = borderStroke3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            jM9743constructorimpl = j;
                            f3 = f2;
                            scrollState2 = scrollStateRememberScrollState;
                            popupProperties3 = popupProperties2;
                            modifier3 = modifier2;
                            shape3 = shape2;
                            j3 = j2;
                            f4 = f;
                            borderStroke2 = borderStroke;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i7 |= 805306368;
                    i14 = i3 & 1024;
                    if (i14 != 0) {
                        i15 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke)) {
                            i16 = 4;
                        } else {
                            i16 = 2;
                        }
                        i15 = i2 | i16;
                    } else {
                        i15 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i18 = 32;
                        } else {
                            i18 = 16;
                        }
                        i15 |= i18;
                    }
                    i17 = i15;
                    if ((i7 & 306783379) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                        if ((i & 1) != 0) {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                float f8 = 0;
                                jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f8))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f8))) << 32));
                            } else {
                                jM9743constructorimpl = j;
                            }
                            if ((i3 & 16) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i7 &= -57345;
                            }
                            if (i8 != 0) {
                                popupProperties2 = DefaultMenuProperties;
                            }
                            if ((i3 & 64) != 0) {
                                shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i7 &= -3670017;
                            } else {
                                shape4 = shape2;
                            }
                            if ((i3 & 128) != 0) {
                                containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i7 = (-29360129) & i7;
                            } else {
                                containerColor = j2;
                            }
                            if (i10 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            } else {
                                fM3754getTonalElevationD9Ej5fM = f;
                            }
                            if (i12 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            } else {
                                fM3753getShadowElevationD9Ej5fM = f2;
                            }
                            if (i14 != 0) {
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                            }
                        } else {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                float f9 = 0;
                                jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f9))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f9))) << 32));
                            } else {
                                jM9743constructorimpl = j;
                            }
                            if ((i3 & 16) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i7 &= -57345;
                            }
                            if (i8 != 0) {
                                popupProperties2 = DefaultMenuProperties;
                            }
                            if ((i3 & 64) != 0) {
                                shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i7 &= -3670017;
                            } else {
                                shape4 = shape2;
                            }
                            if ((i3 & 128) != 0) {
                                containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i7 = (-29360129) & i7;
                            } else {
                                containerColor = j2;
                            }
                            if (i10 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            } else {
                                fM3754getTonalElevationD9Ej5fM = f;
                            }
                            if (i12 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            } else {
                                fM3753getShadowElevationD9Ej5fM = f2;
                            }
                            if (i14 != 0) {
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            z3 = false;
                            objRememberedValue = new MutableTransitionState(false);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            z3 = false;
                        }
                        mutableTransitionState = (MutableTransitionState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                        if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                            composerStartRestartGroup.startReplaceGroup(1165888662);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume2;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            if ((i7 & 7168) == 2048) {
                                z3 = true;
                            }
                            zChanged = z3 | composerStartRestartGroup.changed(density);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1165888662);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume3;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            if ((i7 & 7168) == 2048) {
                                z3 = true;
                            }
                            zChanged = z3 | composerStartRestartGroup.changed(density);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        popupProperties3 = popupProperties2;
                        modifier3 = modifier4;
                        scrollState2 = scrollState3;
                        shape3 = shape5;
                        j3 = j4;
                        f4 = f5;
                        f3 = f6;
                        borderStroke2 = borderStroke3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        jM9743constructorimpl = j;
                        f3 = f2;
                        scrollState2 = scrollStateRememberScrollState;
                        popupProperties3 = popupProperties2;
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j3 = j2;
                        f4 = f;
                        borderStroke2 = borderStroke;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i7 |= 100663296;
                i12 = i3 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i7 |= i13;
                    }
                    i14 = i3 & 1024;
                    if (i14 != 0) {
                        i15 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke)) {
                            i16 = 4;
                        } else {
                            i16 = 2;
                        }
                        i15 = i2 | i16;
                    } else {
                        i15 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i18 = 32;
                        } else {
                            i18 = 16;
                        }
                        i15 |= i18;
                    }
                    i17 = i15;
                    if ((i7 & 306783379) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                        if ((i & 1) != 0) {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                float f10 = 0;
                                jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f10))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f10))) << 32));
                            } else {
                                jM9743constructorimpl = j;
                            }
                            if ((i3 & 16) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i7 &= -57345;
                            }
                            if (i8 != 0) {
                                popupProperties2 = DefaultMenuProperties;
                            }
                            if ((i3 & 64) != 0) {
                                shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i7 &= -3670017;
                            } else {
                                shape4 = shape2;
                            }
                            if ((i3 & 128) != 0) {
                                containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i7 = (-29360129) & i7;
                            } else {
                                containerColor = j2;
                            }
                            if (i10 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            } else {
                                fM3754getTonalElevationD9Ej5fM = f;
                            }
                            if (i12 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            } else {
                                fM3753getShadowElevationD9Ej5fM = f2;
                            }
                            if (i14 != 0) {
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                            }
                        } else {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                float f11 = 0;
                                jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f11))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f11))) << 32));
                            } else {
                                jM9743constructorimpl = j;
                            }
                            if ((i3 & 16) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i7 &= -57345;
                            }
                            if (i8 != 0) {
                                popupProperties2 = DefaultMenuProperties;
                            }
                            if ((i3 & 64) != 0) {
                                shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i7 &= -3670017;
                            } else {
                                shape4 = shape2;
                            }
                            if ((i3 & 128) != 0) {
                                containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i7 = (-29360129) & i7;
                            } else {
                                containerColor = j2;
                            }
                            if (i10 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            } else {
                                fM3754getTonalElevationD9Ej5fM = f;
                            }
                            if (i12 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            } else {
                                fM3753getShadowElevationD9Ej5fM = f2;
                            }
                            if (i14 != 0) {
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            z3 = false;
                            objRememberedValue = new MutableTransitionState(false);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            z3 = false;
                        }
                        mutableTransitionState = (MutableTransitionState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                        if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                            composerStartRestartGroup.startReplaceGroup(1165888662);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume4;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            if ((i7 & 7168) == 2048) {
                                z3 = true;
                            }
                            zChanged = z3 | composerStartRestartGroup.changed(density);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1165888662);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume5;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            if ((i7 & 7168) == 2048) {
                                z3 = true;
                            }
                            zChanged = z3 | composerStartRestartGroup.changed(density);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        popupProperties3 = popupProperties2;
                        modifier3 = modifier4;
                        scrollState2 = scrollState3;
                        shape3 = shape5;
                        j3 = j4;
                        f4 = f5;
                        f3 = f6;
                        borderStroke2 = borderStroke3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        jM9743constructorimpl = j;
                        f3 = f2;
                        scrollState2 = scrollStateRememberScrollState;
                        popupProperties3 = popupProperties2;
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j3 = j2;
                        f4 = f;
                        borderStroke2 = borderStroke;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i7 |= 805306368;
                i14 = i3 & 1024;
                if (i14 != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i15 |= i18;
                }
                i17 = i15;
                if ((i7 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            float f12 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f12))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f12))) << 32));
                        } else {
                            jM9743constructorimpl = j;
                        }
                        if ((i3 & 16) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i7 &= -57345;
                        }
                        if (i8 != 0) {
                            popupProperties2 = DefaultMenuProperties;
                        }
                        if ((i3 & 64) != 0) {
                            shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i3 & 128) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i7 = (-29360129) & i7;
                        } else {
                            containerColor = j2;
                        }
                        if (i10 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i12 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i14 != 0) {
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            float f13 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f13))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f13))) << 32));
                        } else {
                            jM9743constructorimpl = j;
                        }
                        if ((i3 & 16) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i7 &= -57345;
                        }
                        if (i8 != 0) {
                            popupProperties2 = DefaultMenuProperties;
                        }
                        if ((i3 & 64) != 0) {
                            shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i3 & 128) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i7 = (-29360129) & i7;
                        } else {
                            containerColor = j2;
                        }
                        if (i10 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i12 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i14 != 0) {
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        z3 = false;
                        objRememberedValue = new MutableTransitionState(false);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        z3 = false;
                    }
                    mutableTransitionState = (MutableTransitionState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                    if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(1165888662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume6;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        if ((i7 & 7168) == 2048) {
                            z3 = true;
                        }
                        zChanged = z3 | composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1165888662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume7;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        if ((i7 & 7168) == 2048) {
                            z3 = true;
                        }
                        zChanged = z3 | composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    popupProperties3 = popupProperties2;
                    modifier3 = modifier4;
                    scrollState2 = scrollState3;
                    shape3 = shape5;
                    j3 = j4;
                    f4 = f5;
                    f3 = f6;
                    borderStroke2 = borderStroke3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    jM9743constructorimpl = j;
                    f3 = f2;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = j2;
                    f4 = f;
                    borderStroke2 = borderStroke;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            i7 = i4;
            if ((i & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    scrollStateRememberScrollState = scrollState;
                    if (composerStartRestartGroup.changed(scrollStateRememberScrollState)) {
                    }
                    i7 |= i22;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i7 |= i22;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            i8 = i3 & 32;
            if (i8 != 0) {
                i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                popupProperties2 = popupProperties;
            } else {
                popupProperties2 = popupProperties;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i7 |= i9;
                }
            }
            if ((i & 1572864) == 0) {
                shape2 = shape;
                if ((i3 & 64) == 0) {
                    i19 = 524288;
                } else {
                    i19 = 524288;
                }
                i7 |= i19;
            } else {
                shape2 = shape;
            }
            if ((i & 12582912) != 0) {
                i7 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(j2)) ? 4194304 : 8388608;
            }
            i10 = i3 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i7 |= i11;
                }
                i12 = i3 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i7 |= i13;
                    }
                    i14 = i3 & 1024;
                    if (i14 != 0) {
                        i15 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke)) {
                            i16 = 4;
                        } else {
                            i16 = 2;
                        }
                        i15 = i2 | i16;
                    } else {
                        i15 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i18 = 32;
                        } else {
                            i18 = 16;
                        }
                        i15 |= i18;
                    }
                    i17 = i15;
                    if ((i7 & 306783379) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                        if ((i & 1) != 0) {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                float f14 = 0;
                                jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f14))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f14))) << 32));
                            } else {
                                jM9743constructorimpl = j;
                            }
                            if ((i3 & 16) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i7 &= -57345;
                            }
                            if (i8 != 0) {
                                popupProperties2 = DefaultMenuProperties;
                            }
                            if ((i3 & 64) != 0) {
                                shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i7 &= -3670017;
                            } else {
                                shape4 = shape2;
                            }
                            if ((i3 & 128) != 0) {
                                containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i7 = (-29360129) & i7;
                            } else {
                                containerColor = j2;
                            }
                            if (i10 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            } else {
                                fM3754getTonalElevationD9Ej5fM = f;
                            }
                            if (i12 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            } else {
                                fM3753getShadowElevationD9Ej5fM = f2;
                            }
                            if (i14 != 0) {
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                            }
                        } else {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                float f15 = 0;
                                jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f15))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f15))) << 32));
                            } else {
                                jM9743constructorimpl = j;
                            }
                            if ((i3 & 16) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i7 &= -57345;
                            }
                            if (i8 != 0) {
                                popupProperties2 = DefaultMenuProperties;
                            }
                            if ((i3 & 64) != 0) {
                                shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i7 &= -3670017;
                            } else {
                                shape4 = shape2;
                            }
                            if ((i3 & 128) != 0) {
                                containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i7 = (-29360129) & i7;
                            } else {
                                containerColor = j2;
                            }
                            if (i10 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            } else {
                                fM3754getTonalElevationD9Ej5fM = f;
                            }
                            if (i12 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            } else {
                                fM3753getShadowElevationD9Ej5fM = f2;
                            }
                            if (i14 != 0) {
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            z3 = false;
                            objRememberedValue = new MutableTransitionState(false);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            z3 = false;
                        }
                        mutableTransitionState = (MutableTransitionState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                        if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                            composerStartRestartGroup.startReplaceGroup(1165888662);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume8 = composerStartRestartGroup.consume(localDensity8);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume8;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            if ((i7 & 7168) == 2048) {
                                z3 = true;
                            }
                            zChanged = z3 | composerStartRestartGroup.changed(density);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1165888662);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume9 = composerStartRestartGroup.consume(localDensity9);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume9;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            if ((i7 & 7168) == 2048) {
                                z3 = true;
                            }
                            zChanged = z3 | composerStartRestartGroup.changed(density);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        popupProperties3 = popupProperties2;
                        modifier3 = modifier4;
                        scrollState2 = scrollState3;
                        shape3 = shape5;
                        j3 = j4;
                        f4 = f5;
                        f3 = f6;
                        borderStroke2 = borderStroke3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        jM9743constructorimpl = j;
                        f3 = f2;
                        scrollState2 = scrollStateRememberScrollState;
                        popupProperties3 = popupProperties2;
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j3 = j2;
                        f4 = f;
                        borderStroke2 = borderStroke;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i7 |= 805306368;
                i14 = i3 & 1024;
                if (i14 != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i15 |= i18;
                }
                i17 = i15;
                if ((i7 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            float f16 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f16))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f16))) << 32));
                        } else {
                            jM9743constructorimpl = j;
                        }
                        if ((i3 & 16) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i7 &= -57345;
                        }
                        if (i8 != 0) {
                            popupProperties2 = DefaultMenuProperties;
                        }
                        if ((i3 & 64) != 0) {
                            shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i3 & 128) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i7 = (-29360129) & i7;
                        } else {
                            containerColor = j2;
                        }
                        if (i10 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i12 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i14 != 0) {
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            float f17 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f17))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f17))) << 32));
                        } else {
                            jM9743constructorimpl = j;
                        }
                        if ((i3 & 16) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i7 &= -57345;
                        }
                        if (i8 != 0) {
                            popupProperties2 = DefaultMenuProperties;
                        }
                        if ((i3 & 64) != 0) {
                            shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i3 & 128) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i7 = (-29360129) & i7;
                        } else {
                            containerColor = j2;
                        }
                        if (i10 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i12 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i14 != 0) {
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        z3 = false;
                        objRememberedValue = new MutableTransitionState(false);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        z3 = false;
                    }
                    mutableTransitionState = (MutableTransitionState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                    if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(1165888662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity10 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume10 = composerStartRestartGroup.consume(localDensity10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume10;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        if ((i7 & 7168) == 2048) {
                            z3 = true;
                        }
                        zChanged = z3 | composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1165888662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity11 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume11 = composerStartRestartGroup.consume(localDensity11);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume11;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        if ((i7 & 7168) == 2048) {
                            z3 = true;
                        }
                        zChanged = z3 | composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    popupProperties3 = popupProperties2;
                    modifier3 = modifier4;
                    scrollState2 = scrollState3;
                    shape3 = shape5;
                    j3 = j4;
                    f4 = f5;
                    f3 = f6;
                    borderStroke2 = borderStroke3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    jM9743constructorimpl = j;
                    f3 = f2;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = j2;
                    f4 = f;
                    borderStroke2 = borderStroke;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i7 |= 100663296;
            i12 = i3 & 512;
            if (i12 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i7 |= i13;
                }
                i14 = i3 & 1024;
                if (i14 != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i15 |= i18;
                }
                i17 = i15;
                if ((i7 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            float f18 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f18))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f18))) << 32));
                        } else {
                            jM9743constructorimpl = j;
                        }
                        if ((i3 & 16) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i7 &= -57345;
                        }
                        if (i8 != 0) {
                            popupProperties2 = DefaultMenuProperties;
                        }
                        if ((i3 & 64) != 0) {
                            shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i3 & 128) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i7 = (-29360129) & i7;
                        } else {
                            containerColor = j2;
                        }
                        if (i10 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i12 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i14 != 0) {
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            float f19 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f19))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f19))) << 32));
                        } else {
                            jM9743constructorimpl = j;
                        }
                        if ((i3 & 16) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i7 &= -57345;
                        }
                        if (i8 != 0) {
                            popupProperties2 = DefaultMenuProperties;
                        }
                        if ((i3 & 64) != 0) {
                            shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i3 & 128) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i7 = (-29360129) & i7;
                        } else {
                            containerColor = j2;
                        }
                        if (i10 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i12 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i14 != 0) {
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        z3 = false;
                        objRememberedValue = new MutableTransitionState(false);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        z3 = false;
                    }
                    mutableTransitionState = (MutableTransitionState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                    if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(1165888662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity12 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume12 = composerStartRestartGroup.consume(localDensity12);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume12;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        if ((i7 & 7168) == 2048) {
                            z3 = true;
                        }
                        zChanged = z3 | composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1165888662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity13 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume13 = composerStartRestartGroup.consume(localDensity13);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume13;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        if ((i7 & 7168) == 2048) {
                            z3 = true;
                        }
                        zChanged = z3 | composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    popupProperties3 = popupProperties2;
                    modifier3 = modifier4;
                    scrollState2 = scrollState3;
                    shape3 = shape5;
                    j3 = j4;
                    f4 = f5;
                    f3 = f6;
                    borderStroke2 = borderStroke3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    jM9743constructorimpl = j;
                    f3 = f2;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = j2;
                    f4 = f;
                    borderStroke2 = borderStroke;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i7 |= 805306368;
            i14 = i3 & 1024;
            if (i14 != 0) {
                i15 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i18 = 32;
                } else {
                    i18 = 16;
                }
                i15 |= i18;
            }
            i17 = i15;
            if ((i7 & 306783379) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                if ((i & 1) != 0) {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        float f110 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f110))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f110))) << 32));
                    } else {
                        jM9743constructorimpl = j;
                    }
                    if ((i3 & 16) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i7 &= -57345;
                    }
                    if (i8 != 0) {
                        popupProperties2 = DefaultMenuProperties;
                    }
                    if ((i3 & 64) != 0) {
                        shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i7 &= -3670017;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 128) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i7 = (-29360129) & i7;
                    } else {
                        containerColor = j2;
                    }
                    if (i10 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i12 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i14 != 0) {
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                    }
                } else {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        float f111 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f111))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f111))) << 32));
                    } else {
                        jM9743constructorimpl = j;
                    }
                    if ((i3 & 16) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i7 &= -57345;
                    }
                    if (i8 != 0) {
                        popupProperties2 = DefaultMenuProperties;
                    }
                    if ((i3 & 64) != 0) {
                        shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i7 &= -3670017;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 128) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i7 = (-29360129) & i7;
                    } else {
                        containerColor = j2;
                    }
                    if (i10 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i12 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i14 != 0) {
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    z3 = false;
                    objRememberedValue = new MutableTransitionState(false);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    z3 = false;
                }
                mutableTransitionState = (MutableTransitionState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(1165888662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity14 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume14 = composerStartRestartGroup.consume(localDensity14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume14;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    if ((i7 & 7168) == 2048) {
                        z3 = true;
                    }
                    zChanged = z3 | composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1165888662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity15 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume15 = composerStartRestartGroup.consume(localDensity15);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume15;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    if ((i7 & 7168) == 2048) {
                        z3 = true;
                    }
                    zChanged = z3 | composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                popupProperties3 = popupProperties2;
                modifier3 = modifier4;
                scrollState2 = scrollState3;
                shape3 = shape5;
                j3 = j4;
                f4 = f5;
                f3 = f6;
                borderStroke2 = borderStroke3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                jM9743constructorimpl = j;
                f3 = f2;
                scrollState2 = scrollStateRememberScrollState;
                popupProperties3 = popupProperties2;
                modifier3 = modifier2;
                shape3 = shape2;
                j3 = j2;
                f4 = f;
                borderStroke2 = borderStroke;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                int i23 = i4;
                if (composerStartRestartGroup.changed(j)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i7 = i23 | i6;
            }
            if ((i & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    scrollStateRememberScrollState = scrollState;
                    if (composerStartRestartGroup.changed(scrollStateRememberScrollState)) {
                    }
                    i7 |= i22;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i7 |= i22;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            i8 = i3 & 32;
            if (i8 != 0) {
                i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                popupProperties2 = popupProperties;
            } else {
                popupProperties2 = popupProperties;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i7 |= i9;
                }
            }
            if ((i & 1572864) == 0) {
                shape2 = shape;
                if ((i3 & 64) == 0) {
                    i19 = 524288;
                } else {
                    i19 = 524288;
                }
                i7 |= i19;
            } else {
                shape2 = shape;
            }
            if ((i & 12582912) != 0) {
                i7 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(j2)) ? 4194304 : 8388608;
            }
            i10 = i3 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i7 |= i11;
                }
                i12 = i3 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(f2)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i7 |= i13;
                    }
                    i14 = i3 & 1024;
                    if (i14 != 0) {
                        i15 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke)) {
                            i16 = 4;
                        } else {
                            i16 = 2;
                        }
                        i15 = i2 | i16;
                    } else {
                        i15 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i18 = 32;
                        } else {
                            i18 = 16;
                        }
                        i15 |= i18;
                    }
                    i17 = i15;
                    if ((i7 & 306783379) == 306783378) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                        if ((i & 1) != 0) {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                float f112 = 0;
                                jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f112))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f112))) << 32));
                            } else {
                                jM9743constructorimpl = j;
                            }
                            if ((i3 & 16) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i7 &= -57345;
                            }
                            if (i8 != 0) {
                                popupProperties2 = DefaultMenuProperties;
                            }
                            if ((i3 & 64) != 0) {
                                shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i7 &= -3670017;
                            } else {
                                shape4 = shape2;
                            }
                            if ((i3 & 128) != 0) {
                                containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i7 = (-29360129) & i7;
                            } else {
                                containerColor = j2;
                            }
                            if (i10 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            } else {
                                fM3754getTonalElevationD9Ej5fM = f;
                            }
                            if (i12 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            } else {
                                fM3753getShadowElevationD9Ej5fM = f2;
                            }
                            if (i14 != 0) {
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                            }
                        } else {
                            if (i20 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                float f113 = 0;
                                jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f113))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f113))) << 32));
                            } else {
                                jM9743constructorimpl = j;
                            }
                            if ((i3 & 16) != 0) {
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                                i7 &= -57345;
                            }
                            if (i8 != 0) {
                                popupProperties2 = DefaultMenuProperties;
                            }
                            if ((i3 & 64) != 0) {
                                shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                i7 &= -3670017;
                            } else {
                                shape4 = shape2;
                            }
                            if ((i3 & 128) != 0) {
                                containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i7 = (-29360129) & i7;
                            } else {
                                containerColor = j2;
                            }
                            if (i10 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            } else {
                                fM3754getTonalElevationD9Ej5fM = f;
                            }
                            if (i12 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            } else {
                                fM3753getShadowElevationD9Ej5fM = f2;
                            }
                            if (i14 != 0) {
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                                modifier4 = companion;
                                scrollState3 = scrollStateRememberScrollState;
                                shape5 = shape4;
                                j4 = containerColor;
                                f5 = fM3754getTonalElevationD9Ej5fM;
                                f6 = fM3753getShadowElevationD9Ej5fM;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            z3 = false;
                            objRememberedValue = new MutableTransitionState(false);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            z3 = false;
                        }
                        mutableTransitionState = (MutableTransitionState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                        if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                            composerStartRestartGroup.startReplaceGroup(1165888662);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ProvidableCompositionLocal<Density> localDensity16 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume16 = composerStartRestartGroup.consume(localDensity16);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume16;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            if ((i7 & 7168) == 2048) {
                                z3 = true;
                            }
                            zChanged = z3 | composerStartRestartGroup.changed(density);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1165888662);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ProvidableCompositionLocal<Density> localDensity17 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume17 = composerStartRestartGroup.consume(localDensity17);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume17;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                            if ((i7 & 7168) == 2048) {
                                z3 = true;
                            }
                            zChanged = z3 | composerStartRestartGroup.changed(density);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                    }
                                }, 4, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        popupProperties3 = popupProperties2;
                        modifier3 = modifier4;
                        scrollState2 = scrollState3;
                        shape3 = shape5;
                        j3 = j4;
                        f4 = f5;
                        f3 = f6;
                        borderStroke2 = borderStroke3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        jM9743constructorimpl = j;
                        f3 = f2;
                        scrollState2 = scrollStateRememberScrollState;
                        popupProperties3 = popupProperties2;
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j3 = j2;
                        f4 = f;
                        borderStroke2 = borderStroke;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i7 |= 805306368;
                i14 = i3 & 1024;
                if (i14 != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i15 |= i18;
                }
                i17 = i15;
                if ((i7 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            float f114 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f114))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f114))) << 32));
                        } else {
                            jM9743constructorimpl = j;
                        }
                        if ((i3 & 16) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i7 &= -57345;
                        }
                        if (i8 != 0) {
                            popupProperties2 = DefaultMenuProperties;
                        }
                        if ((i3 & 64) != 0) {
                            shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i3 & 128) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i7 = (-29360129) & i7;
                        } else {
                            containerColor = j2;
                        }
                        if (i10 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i12 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i14 != 0) {
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            float f115 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f115))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f115))) << 32));
                        } else {
                            jM9743constructorimpl = j;
                        }
                        if ((i3 & 16) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i7 &= -57345;
                        }
                        if (i8 != 0) {
                            popupProperties2 = DefaultMenuProperties;
                        }
                        if ((i3 & 64) != 0) {
                            shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i3 & 128) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i7 = (-29360129) & i7;
                        } else {
                            containerColor = j2;
                        }
                        if (i10 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i12 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i14 != 0) {
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        z3 = false;
                        objRememberedValue = new MutableTransitionState(false);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        z3 = false;
                    }
                    mutableTransitionState = (MutableTransitionState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                    if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(1165888662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity18 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume18 = composerStartRestartGroup.consume(localDensity18);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume18;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        if ((i7 & 7168) == 2048) {
                            z3 = true;
                        }
                        zChanged = z3 | composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1165888662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity19 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume19 = composerStartRestartGroup.consume(localDensity19);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume19;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        if ((i7 & 7168) == 2048) {
                            z3 = true;
                        }
                        zChanged = z3 | composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    popupProperties3 = popupProperties2;
                    modifier3 = modifier4;
                    scrollState2 = scrollState3;
                    shape3 = shape5;
                    j3 = j4;
                    f4 = f5;
                    f3 = f6;
                    borderStroke2 = borderStroke3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    jM9743constructorimpl = j;
                    f3 = f2;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = j2;
                    f4 = f;
                    borderStroke2 = borderStroke;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i7 |= 100663296;
            i12 = i3 & 512;
            if (i12 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i7 |= i13;
                }
                i14 = i3 & 1024;
                if (i14 != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i15 |= i18;
                }
                i17 = i15;
                if ((i7 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            float f116 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f116))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f116))) << 32));
                        } else {
                            jM9743constructorimpl = j;
                        }
                        if ((i3 & 16) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i7 &= -57345;
                        }
                        if (i8 != 0) {
                            popupProperties2 = DefaultMenuProperties;
                        }
                        if ((i3 & 64) != 0) {
                            shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i3 & 128) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i7 = (-29360129) & i7;
                        } else {
                            containerColor = j2;
                        }
                        if (i10 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i12 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i14 != 0) {
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            float f117 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f117))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f117))) << 32));
                        } else {
                            jM9743constructorimpl = j;
                        }
                        if ((i3 & 16) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i7 &= -57345;
                        }
                        if (i8 != 0) {
                            popupProperties2 = DefaultMenuProperties;
                        }
                        if ((i3 & 64) != 0) {
                            shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i3 & 128) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i7 = (-29360129) & i7;
                        } else {
                            containerColor = j2;
                        }
                        if (i10 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i12 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i14 != 0) {
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        z3 = false;
                        objRememberedValue = new MutableTransitionState(false);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        z3 = false;
                    }
                    mutableTransitionState = (MutableTransitionState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                    if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(1165888662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity110 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume110 = composerStartRestartGroup.consume(localDensity110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume110;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        if ((i7 & 7168) == 2048) {
                            z3 = true;
                        }
                        zChanged = z3 | composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1165888662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity111 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume111 = composerStartRestartGroup.consume(localDensity111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume111;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        if ((i7 & 7168) == 2048) {
                            z3 = true;
                        }
                        zChanged = z3 | composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    popupProperties3 = popupProperties2;
                    modifier3 = modifier4;
                    scrollState2 = scrollState3;
                    shape3 = shape5;
                    j3 = j4;
                    f4 = f5;
                    f3 = f6;
                    borderStroke2 = borderStroke3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    jM9743constructorimpl = j;
                    f3 = f2;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = j2;
                    f4 = f;
                    borderStroke2 = borderStroke;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i7 |= 805306368;
            i14 = i3 & 1024;
            if (i14 != 0) {
                i15 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i18 = 32;
                } else {
                    i18 = 16;
                }
                i15 |= i18;
            }
            i17 = i15;
            if ((i7 & 306783379) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                if ((i & 1) != 0) {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        float f118 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f118))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f118))) << 32));
                    } else {
                        jM9743constructorimpl = j;
                    }
                    if ((i3 & 16) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i7 &= -57345;
                    }
                    if (i8 != 0) {
                        popupProperties2 = DefaultMenuProperties;
                    }
                    if ((i3 & 64) != 0) {
                        shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i7 &= -3670017;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 128) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i7 = (-29360129) & i7;
                    } else {
                        containerColor = j2;
                    }
                    if (i10 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i12 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i14 != 0) {
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                    }
                } else {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        float f119 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f119))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f119))) << 32));
                    } else {
                        jM9743constructorimpl = j;
                    }
                    if ((i3 & 16) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i7 &= -57345;
                    }
                    if (i8 != 0) {
                        popupProperties2 = DefaultMenuProperties;
                    }
                    if ((i3 & 64) != 0) {
                        shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i7 &= -3670017;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 128) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i7 = (-29360129) & i7;
                    } else {
                        containerColor = j2;
                    }
                    if (i10 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i12 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i14 != 0) {
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    z3 = false;
                    objRememberedValue = new MutableTransitionState(false);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    z3 = false;
                }
                mutableTransitionState = (MutableTransitionState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(1165888662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity112 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume112 = composerStartRestartGroup.consume(localDensity112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume112;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    if ((i7 & 7168) == 2048) {
                        z3 = true;
                    }
                    zChanged = z3 | composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1165888662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity113 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume113 = composerStartRestartGroup.consume(localDensity113);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume113;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    if ((i7 & 7168) == 2048) {
                        z3 = true;
                    }
                    zChanged = z3 | composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                popupProperties3 = popupProperties2;
                modifier3 = modifier4;
                scrollState2 = scrollState3;
                shape3 = shape5;
                j3 = j4;
                f4 = f5;
                f3 = f6;
                borderStroke2 = borderStroke3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                jM9743constructorimpl = j;
                f3 = f2;
                scrollState2 = scrollStateRememberScrollState;
                popupProperties3 = popupProperties2;
                modifier3 = modifier2;
                shape3 = shape2;
                j3 = j2;
                f4 = f;
                borderStroke2 = borderStroke;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        i7 = i4;
        if ((i & 24576) == 0) {
            if ((i3 & 16) == 0) {
                scrollStateRememberScrollState = scrollState;
                if (composerStartRestartGroup.changed(scrollStateRememberScrollState)) {
                }
                i7 |= i22;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            i7 |= i22;
        } else {
            scrollStateRememberScrollState = scrollState;
        }
        i8 = i3 & 32;
        if (i8 != 0) {
            i7 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            popupProperties2 = popupProperties;
        } else {
            popupProperties2 = popupProperties;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(popupProperties2)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i7 |= i9;
            }
        }
        if ((i & 1572864) == 0) {
            shape2 = shape;
            if ((i3 & 64) == 0) {
                i19 = 524288;
            } else {
                i19 = 524288;
            }
            i7 |= i19;
        } else {
            shape2 = shape;
        }
        if ((i & 12582912) != 0) {
            i7 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(j2)) ? 4194304 : 8388608;
        }
        i10 = i3 & 256;
        if (i10 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i7 |= i11;
            }
            i12 = i3 & 512;
            if (i12 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i7 |= i13;
                }
                i14 = i3 & 1024;
                if (i14 != 0) {
                    i15 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i18 = 32;
                    } else {
                        i18 = 16;
                    }
                    i15 |= i18;
                }
                i17 = i15;
                if ((i7 & 306783379) == 306783378) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                    if ((i & 1) != 0) {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            float f1110 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1110))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1110))) << 32));
                        } else {
                            jM9743constructorimpl = j;
                        }
                        if ((i3 & 16) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i7 &= -57345;
                        }
                        if (i8 != 0) {
                            popupProperties2 = DefaultMenuProperties;
                        }
                        if ((i3 & 64) != 0) {
                            shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i3 & 128) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i7 = (-29360129) & i7;
                        } else {
                            containerColor = j2;
                        }
                        if (i10 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i12 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i14 != 0) {
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                        }
                    } else {
                        if (i20 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            float f1111 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1111))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1111))) << 32));
                        } else {
                            jM9743constructorimpl = j;
                        }
                        if ((i3 & 16) != 0) {
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            i7 &= -57345;
                        }
                        if (i8 != 0) {
                            popupProperties2 = DefaultMenuProperties;
                        }
                        if ((i3 & 64) != 0) {
                            shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            i7 &= -3670017;
                        } else {
                            shape4 = shape2;
                        }
                        if ((i3 & 128) != 0) {
                            containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i7 = (-29360129) & i7;
                        } else {
                            containerColor = j2;
                        }
                        if (i10 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        } else {
                            fM3754getTonalElevationD9Ej5fM = f;
                        }
                        if (i12 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        } else {
                            fM3753getShadowElevationD9Ej5fM = f2;
                        }
                        if (i14 != 0) {
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                            modifier4 = companion;
                            scrollState3 = scrollStateRememberScrollState;
                            shape5 = shape4;
                            j4 = containerColor;
                            f5 = fM3754getTonalElevationD9Ej5fM;
                            f6 = fM3753getShadowElevationD9Ej5fM;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        z3 = false;
                        objRememberedValue = new MutableTransitionState(false);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        z3 = false;
                    }
                    mutableTransitionState = (MutableTransitionState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                    if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                        composerStartRestartGroup.startReplaceGroup(1165888662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity114 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume114 = composerStartRestartGroup.consume(localDensity114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume114;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        if ((i7 & 7168) == 2048) {
                            z3 = true;
                        }
                        zChanged = z3 | composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1165888662);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity115 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume115 = composerStartRestartGroup.consume(localDensity115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume115;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                        if ((i7 & 7168) == 2048) {
                            z3 = true;
                        }
                        zChanged = z3 | composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                                }
                            }, 4, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    popupProperties3 = popupProperties2;
                    modifier3 = modifier4;
                    scrollState2 = scrollState3;
                    shape3 = shape5;
                    j3 = j4;
                    f4 = f5;
                    f3 = f6;
                    borderStroke2 = borderStroke3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    jM9743constructorimpl = j;
                    f3 = f2;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = j2;
                    f4 = f;
                    borderStroke2 = borderStroke;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i7 |= 805306368;
            i14 = i3 & 1024;
            if (i14 != 0) {
                i15 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i18 = 32;
                } else {
                    i18 = 16;
                }
                i15 |= i18;
            }
            i17 = i15;
            if ((i7 & 306783379) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                if ((i & 1) != 0) {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        float f1112 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1112))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1112))) << 32));
                    } else {
                        jM9743constructorimpl = j;
                    }
                    if ((i3 & 16) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i7 &= -57345;
                    }
                    if (i8 != 0) {
                        popupProperties2 = DefaultMenuProperties;
                    }
                    if ((i3 & 64) != 0) {
                        shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i7 &= -3670017;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 128) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i7 = (-29360129) & i7;
                    } else {
                        containerColor = j2;
                    }
                    if (i10 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i12 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i14 != 0) {
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                    }
                } else {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        float f1113 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1113))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1113))) << 32));
                    } else {
                        jM9743constructorimpl = j;
                    }
                    if ((i3 & 16) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i7 &= -57345;
                    }
                    if (i8 != 0) {
                        popupProperties2 = DefaultMenuProperties;
                    }
                    if ((i3 & 64) != 0) {
                        shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i7 &= -3670017;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 128) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i7 = (-29360129) & i7;
                    } else {
                        containerColor = j2;
                    }
                    if (i10 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i12 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i14 != 0) {
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    z3 = false;
                    objRememberedValue = new MutableTransitionState(false);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    z3 = false;
                }
                mutableTransitionState = (MutableTransitionState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(1165888662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity116 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume116 = composerStartRestartGroup.consume(localDensity116);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume116;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    if ((i7 & 7168) == 2048) {
                        z3 = true;
                    }
                    zChanged = z3 | composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1165888662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity117 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume117 = composerStartRestartGroup.consume(localDensity117);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume117;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    if ((i7 & 7168) == 2048) {
                        z3 = true;
                    }
                    zChanged = z3 | composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                popupProperties3 = popupProperties2;
                modifier3 = modifier4;
                scrollState2 = scrollState3;
                shape3 = shape5;
                j3 = j4;
                f4 = f5;
                f3 = f6;
                borderStroke2 = borderStroke3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                jM9743constructorimpl = j;
                f3 = f2;
                scrollState2 = scrollStateRememberScrollState;
                popupProperties3 = popupProperties2;
                modifier3 = modifier2;
                shape3 = shape2;
                j3 = j2;
                f4 = f;
                borderStroke2 = borderStroke;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i7 |= 100663296;
        i12 = i3 & 512;
        if (i12 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i13 = 268435456;
                }
                i7 |= i13;
            }
            i14 = i3 & 1024;
            if (i14 != 0) {
                i15 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i18 = 32;
                } else {
                    i18 = 16;
                }
                i15 |= i18;
            }
            i17 = i15;
            if ((i7 & 306783379) == 306783378) {
                z2 = true;
            } else {
                z2 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
                if ((i & 1) != 0) {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        float f1114 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1114))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1114))) << 32));
                    } else {
                        jM9743constructorimpl = j;
                    }
                    if ((i3 & 16) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i7 &= -57345;
                    }
                    if (i8 != 0) {
                        popupProperties2 = DefaultMenuProperties;
                    }
                    if ((i3 & 64) != 0) {
                        shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i7 &= -3670017;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 128) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i7 = (-29360129) & i7;
                    } else {
                        containerColor = j2;
                    }
                    if (i10 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i12 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i14 != 0) {
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                    }
                } else {
                    if (i20 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        float f1115 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1115))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1115))) << 32));
                    } else {
                        jM9743constructorimpl = j;
                    }
                    if ((i3 & 16) != 0) {
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        i7 &= -57345;
                    }
                    if (i8 != 0) {
                        popupProperties2 = DefaultMenuProperties;
                    }
                    if ((i3 & 64) != 0) {
                        shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i7 &= -3670017;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i3 & 128) != 0) {
                        containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i7 = (-29360129) & i7;
                    } else {
                        containerColor = j2;
                    }
                    if (i10 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    } else {
                        fM3754getTonalElevationD9Ej5fM = f;
                    }
                    if (i12 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    } else {
                        fM3753getShadowElevationD9Ej5fM = f2;
                    }
                    if (i14 != 0) {
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                        modifier4 = companion;
                        scrollState3 = scrollStateRememberScrollState;
                        shape5 = shape4;
                        j4 = containerColor;
                        f5 = fM3754getTonalElevationD9Ej5fM;
                        f6 = fM3753getShadowElevationD9Ej5fM;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    z3 = false;
                    objRememberedValue = new MutableTransitionState(false);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    z3 = false;
                }
                mutableTransitionState = (MutableTransitionState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
                if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                    composerStartRestartGroup.startReplaceGroup(1165888662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity118 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume118 = composerStartRestartGroup.consume(localDensity118);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume118;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    if ((i7 & 7168) == 2048) {
                        z3 = true;
                    }
                    zChanged = z3 | composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1165888662);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity119 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume119 = composerStartRestartGroup.consume(localDensity119);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume119;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                    if ((i7 & 7168) == 2048) {
                        z3 = true;
                    }
                    zChanged = z3 | composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                            }
                        }, 4, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                popupProperties3 = popupProperties2;
                modifier3 = modifier4;
                scrollState2 = scrollState3;
                shape3 = shape5;
                j3 = j4;
                f4 = f5;
                f3 = f6;
                borderStroke2 = borderStroke3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                jM9743constructorimpl = j;
                f3 = f2;
                scrollState2 = scrollStateRememberScrollState;
                popupProperties3 = popupProperties2;
                modifier3 = modifier2;
                shape3 = shape2;
                j3 = j2;
                f4 = f;
                borderStroke2 = borderStroke;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i7 |= 805306368;
        i14 = i3 & 1024;
        if (i14 != 0) {
            i15 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changed(borderStroke)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i15 = i2 | i16;
        } else {
            i15 = i2;
        }
        if ((i2 & 48) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i18 = 32;
            } else {
                i18 = 16;
            }
            i15 |= i18;
        }
        i17 = i15;
        if ((i7 & 306783379) == 306783378) {
            z2 = true;
        } else {
            z2 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i7 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "199@7833L21,202@7945L5,204@7993L14");
            if ((i & 1) != 0) {
                if (i20 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    float f1116 = 0;
                    jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1116))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1116))) << 32));
                } else {
                    jM9743constructorimpl = j;
                }
                if ((i3 & 16) != 0) {
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    i7 &= -57345;
                }
                if (i8 != 0) {
                    popupProperties2 = DefaultMenuProperties;
                }
                if ((i3 & 64) != 0) {
                    shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i7 &= -3670017;
                } else {
                    shape4 = shape2;
                }
                if ((i3 & 128) != 0) {
                    containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i7 = (-29360129) & i7;
                } else {
                    containerColor = j2;
                }
                if (i10 != 0) {
                    fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                } else {
                    fM3754getTonalElevationD9Ej5fM = f;
                }
                if (i12 != 0) {
                    fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                } else {
                    fM3753getShadowElevationD9Ej5fM = f2;
                }
                if (i14 != 0) {
                    modifier4 = companion;
                    scrollState3 = scrollStateRememberScrollState;
                    shape5 = shape4;
                    j4 = containerColor;
                    f5 = fM3754getTonalElevationD9Ej5fM;
                    f6 = fM3753getShadowElevationD9Ej5fM;
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                    modifier4 = companion;
                    scrollState3 = scrollStateRememberScrollState;
                    shape5 = shape4;
                    j4 = containerColor;
                    f5 = fM3754getTonalElevationD9Ej5fM;
                    f6 = fM3753getShadowElevationD9Ej5fM;
                }
            } else {
                if (i20 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    float f1117 = 0;
                    jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1117))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f1117))) << 32));
                } else {
                    jM9743constructorimpl = j;
                }
                if ((i3 & 16) != 0) {
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    i7 &= -57345;
                }
                if (i8 != 0) {
                    popupProperties2 = DefaultMenuProperties;
                }
                if ((i3 & 64) != 0) {
                    shape4 = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i7 &= -3670017;
                } else {
                    shape4 = shape2;
                }
                if ((i3 & 128) != 0) {
                    containerColor = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i7 = (-29360129) & i7;
                } else {
                    containerColor = j2;
                }
                if (i10 != 0) {
                    fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                } else {
                    fM3754getTonalElevationD9Ej5fM = f;
                }
                if (i12 != 0) {
                    fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                } else {
                    fM3753getShadowElevationD9Ej5fM = f2;
                }
                if (i14 != 0) {
                    modifier4 = companion;
                    scrollState3 = scrollStateRememberScrollState;
                    shape5 = shape4;
                    j4 = containerColor;
                    f5 = fM3754getTonalElevationD9Ej5fM;
                    f6 = fM3753getShadowElevationD9Ej5fM;
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                    modifier4 = companion;
                    scrollState3 = scrollStateRememberScrollState;
                    shape5 = shape4;
                    j4 = containerColor;
                    f5 = fM3754getTonalElevationD9Ej5fM;
                    f6 = fM3753getShadowElevationD9Ej5fM;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1725609375, i7, i17, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:65)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453245385, "CC(remember):AndroidMenu.android.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                z3 = false;
                objRememberedValue = new MutableTransitionState(false);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                z3 = false;
            }
            mutableTransitionState = (MutableTransitionState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            mutableTransitionState.setTargetState$animation_core(Boolean.valueOf(z));
            if (((Boolean) mutableTransitionState.getCurrentState()).booleanValue()) {
                composerStartRestartGroup.startReplaceGroup(1165888662);
                ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity1110 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume1110 = composerStartRestartGroup.consume(localDensity1110);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume1110;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                if ((i7 & 7168) == 2048) {
                    z3 = true;
                }
                zChanged = z3 | composerStartRestartGroup.changed(density);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                        }
                    }, 4, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                        }
                    }, 4, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1165888662);
                ComposerKt.sourceInformation(composerStartRestartGroup, "70@2816L51,71@2903L7,73@2959L313,85@3444L494,81@3282L656");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453251378, "CC(remember):AndroidMenu.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m7216boximpl(TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity1111 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume1111 = composerStartRestartGroup.consume(localDensity1111);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume1111;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 453256216, "CC(remember):AndroidMenu.android.kt#9igjgp");
                if ((i7 & 7168) == 2048) {
                    z3 = true;
                }
                zChanged = z3 | composerStartRestartGroup.changed(density);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                        }
                    }, 4, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new DropdownMenuPositionProvider(jM9743constructorimpl, density, 0, 0, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$2$0(mutableState, (IntRect) obj, (IntRect) obj2);
                        }
                    }, 4, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties2, ComposableLambdaKt.rememberComposableLambda(-917492520, true, new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$3(modifier4, mutableTransitionState, mutableState, scrollState3, shape5, j4, f5, f6, borderStroke3, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 3072 | ((i7 >> 9) & 896), 0);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            popupProperties3 = popupProperties2;
            modifier3 = modifier4;
            scrollState2 = scrollState3;
            shape3 = shape5;
            j3 = j4;
            f4 = f5;
            f3 = f6;
            borderStroke2 = borderStroke3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            jM9743constructorimpl = j;
            f3 = f2;
            scrollState2 = scrollStateRememberScrollState;
            popupProperties3 = popupProperties2;
            modifier3 = modifier2;
            shape3 = shape2;
            j3 = j2;
            f4 = f;
            borderStroke2 = borderStroke;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidMenu_androidKt.DropdownMenu_IlH_yew$lambda$4(z, function0, modifier3, jM9743constructorimpl, scrollState2, popupProperties3, shape3, j3, f4, f3, borderStroke2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenu_IlH_yew$lambda$2$0(MutableState mutableState, IntRect intRect, IntRect intRect2) {
        mutableState.setValue(TransformOrigin.m7216boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenu_IlH_yew$lambda$3(Modifier modifier, MutableTransitionState mutableTransitionState, MutableState mutableState, ScrollState scrollState, Shape shape, long j, float f, float f2, BorderStroke borderStroke, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C86@3458L470:AndroidMenu.android.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-917492520, i, -1, "androidx.compose.material3.DropdownMenu.<anonymous> (AndroidMenu.android.kt:86)");
            }
            MenuKt.m3796DropdownMenuContentQj0Zi0g(modifier, mutableTransitionState, mutableState, scrollState, shape, j, f, f2, borderStroke, function3, composer, (MutableTransitionState.$stable << 3) | 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to calculate best type for var: r13v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v0 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r13v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v0 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r33v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r33v0 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r9v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v8 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r33v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r33v0 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v7 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    /* JADX INFO: renamed from: DropdownMenuPopup-ILWXrKs, reason: not valid java name */
    public static final void m2744DropdownMenuPopupILWXrKs(boolean r26, kotlin.jvm.functions.Function0<kotlin.Unit> r27, androidx.compose.ui.Modifier r28, long r29, androidx.compose.ui.window.PopupProperties r31, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AndroidMenu_androidKt.m2744DropdownMenuPopupILWXrKs(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuPopup_ILWXrKs$lambda$1$0(MutableState mutableState, IntRect intRect, IntRect intRect2) {
        mutableState.setValue(TransformOrigin.m7216boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuPopup_ILWXrKs$lambda$3(Modifier modifier, MutableTransitionState mutableTransitionState, MutableState mutableState, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C128@4972L219:AndroidMenu.android.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-333680730, i, -1, "androidx.compose.material3.DropdownMenuPopup.<anonymous> (AndroidMenu.android.kt:128)");
            }
            DropdownMenuPopupContent(modifier, mutableTransitionState, mutableState, function3, composer, (MutableTransitionState.$stable << 3) | 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void DropdownMenuPopupContent(final Modifier modifier, final MutableTransitionState<Boolean> mutableTransitionState, final MutableState<TransformOrigin> mutableState, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Object obj;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1603362751);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuPopupContent)N(modifier,expandedState,transformOriginState,content)146@5528L47,148@5711L14,149@5789L14,151@5840L146,156@6024L146,160@6215L7,164@6315L587,162@6228L708:AndroidMenu.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(mutableTransitionState) : composerStartRestartGroup.changedInstance(mutableTransitionState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableState) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1603362751, i2, -1, "androidx.compose.material3.DropdownMenuPopupContent (AndroidMenu.android.kt:144)");
            }
            Transition transitionUpdateTransition = TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, "DropDownMenu", composerStartRestartGroup, MutableTransitionState.$stable | 48 | ((i2 >> 3) & 14), 0);
            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            Function3 function4 = new Function3() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AndroidMenu_androidKt.DropdownMenuPopupContent$lambda$0(finiteAnimationSpecValue, (Transition.Segment) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            boolean zBooleanValue = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(1568151973);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(expanded):AndroidMenu.android.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1568151973, 0, -1, "androidx.compose.material3.DropdownMenuPopupContent.<anonymous> (AndroidMenu.android.kt:152)");
            }
            float f = zBooleanValue ? 1.0f : 0.8f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf = Float.valueOf(f);
            boolean zBooleanValue2 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(1568151973);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(expanded):AndroidMenu.android.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1568151973, 0, -1, "androidx.compose.material3.DropdownMenuPopupContent.<anonymous> (AndroidMenu.android.kt:152)");
            }
            float f2 = zBooleanValue2 ? 1.0f : 0.8f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            final State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f2), (FiniteAnimationSpec) function4.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function3 function5 = new Function3() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return AndroidMenu_androidKt.DropdownMenuPopupContent$lambda$3(finiteAnimationSpecValue2, (Transition.Segment) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            boolean zBooleanValue3 = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(286819089);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(expanded):AndroidMenu.android.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(286819089, 0, -1, "androidx.compose.material3.DropdownMenuPopupContent.<anonymous> (AndroidMenu.android.kt:157)");
            }
            float f3 = zBooleanValue3 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf2 = Float.valueOf(f3);
            boolean zBooleanValue4 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(286819089);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(expanded):AndroidMenu.android.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(286819089, 0, -1, "androidx.compose.material3.DropdownMenuPopupContent.<anonymous> (AndroidMenu.android.kt:157)");
            }
            float f4 = zBooleanValue4 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            final State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f4), (FiniteAnimationSpec) function5.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "FloatAnimation", composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Boolean> localInspectionMode = InspectionModeKt.getLocalInspectionMode();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localInspectionMode);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final boolean zBooleanValue5 = ((Boolean) objConsume).booleanValue();
            Modifier modifierWidth = IntrinsicKt.width(modifier, IntrinsicSize.Max);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1061690796, "CC(remember):AndroidMenu.android.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(zBooleanValue5) | composerStartRestartGroup.changed(stateCreateTransitionAnimation) | ((i2 & 112) == 32 || ((i2 & 64) != 0 && composerStartRestartGroup.changedInstance(mutableTransitionState))) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2) | ((i2 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function1() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenuPopupContent$lambda$6$0(zBooleanValue5, mutableTransitionState, mutableState, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, (GraphicsLayerScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierWidth, (Function1) obj);
            int i3 = i2 & 7168;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, r18);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            function3.invoke(ColumnScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i3 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return AndroidMenu_androidKt.DropdownMenuPopupContent$lambda$7(modifier, mutableTransitionState, mutableState, function3, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuPopupContent$lambda$6$0(boolean z, MutableTransitionState mutableTransitionState, MutableState mutableState, State state, State state2, GraphicsLayerScope graphicsLayerScope) {
        float fDropdownMenuPopupContent$lambda$2;
        float fDropdownMenuPopupContent$lambda$3 = 0.8f;
        float fDropdownMenuPopupContent$lambda$5 = 1.0f;
        if (!z) {
            fDropdownMenuPopupContent$lambda$2 = DropdownMenuPopupContent$lambda$2(state);
        } else {
            fDropdownMenuPopupContent$lambda$2 = ((Boolean) mutableTransitionState.getTargetState()).booleanValue() ? 1.0f : 0.8f;
        }
        graphicsLayerScope.setScaleX(fDropdownMenuPopupContent$lambda$2);
        if (!z) {
            fDropdownMenuPopupContent$lambda$3 = DropdownMenuPopupContent$lambda$2(state);
        } else if (((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
            fDropdownMenuPopupContent$lambda$3 = 1.0f;
        }
        graphicsLayerScope.setScaleY(fDropdownMenuPopupContent$lambda$3);
        if (!z) {
            fDropdownMenuPopupContent$lambda$5 = DropdownMenuPopupContent$lambda$5(state2);
        } else if (!((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
            fDropdownMenuPopupContent$lambda$5 = 0.0f;
        }
        graphicsLayerScope.setAlpha(fDropdownMenuPopupContent$lambda$5);
        graphicsLayerScope.mo7017setTransformOrigin__ExYCQ(((TransformOrigin) mutableState.getValue()).getPackedValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0173  */
    /* JADX WARN: Code duplicated, block: B:103:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:108:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:33:0x005b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:41:0x0070  */
    /* JADX WARN: Code duplicated, block: B:43:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:52:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0092  */
    /* JADX WARN: Code duplicated, block: B:57:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x009d  */
    /* JADX WARN: Code duplicated, block: B:63:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:86:0x0103 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0105  */
    /* JADX WARN: Code duplicated, block: B:89:0x010c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0132  */
    /* JADX WARN: Code duplicated, block: B:93:0x0139  */
    /* JADX WARN: Code duplicated, block: B:94:0x0142  */
    /* JADX WARN: Code duplicated, block: B:96:0x0146  */
    /* JADX WARN: Code duplicated, block: B:97:0x0161  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with parameters for shape, color, elevation, and border.", replaceWith = @ReplaceWith(expression = "DropdownMenu(\n    expanded = expanded,\n    onDismissRequest = onDismissRequest,\n    modifier = modifier,\n    offset = offset,\n    scrollState = scrollState,\n    properties = properties,\n    shape = MenuDefaults.shape,\n    containerColor = MenuDefaults.containerColor,\n    tonalElevation = MenuDefaults.TonalElevation,\n    shadowElevation = MenuDefaults.ShadowElevation,\n    border = null,\n    content = content,\n)", imports = {}))
    /* JADX INFO: renamed from: DropdownMenu-4kj-_NE, reason: not valid java name */
    public static final /* synthetic */ void m2741DropdownMenu4kj_NE(final boolean z, final Function0 function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, final Function3 function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        long jM9743constructorimpl;
        int i5;
        ScrollState scrollStateRememberScrollState;
        int i6;
        PopupProperties popupProperties2;
        int i7;
        int i8;
        boolean z2;
        Composer composer2;
        final Modifier modifier3;
        final long j2;
        final ScrollState scrollState2;
        final PopupProperties popupProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        int i10;
        Modifier modifier4;
        long j3;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(1518067413);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenu)N(expanded,onDismissRequest,modifier,offset:c#ui.unit.DpOffset,scrollState,properties,content)222@8606L5,223@8651L14,215@8367L465:AndroidMenu.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i12 = i2 & 4;
        if (i12 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    jM9743constructorimpl = j;
                    if (composerStartRestartGroup.changed(jM9743constructorimpl)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        scrollStateRememberScrollState = scrollState;
                        int i13 = composerStartRestartGroup.changed(scrollStateRememberScrollState) ? 16384 : 8192;
                        i3 |= i13;
                    } else {
                        scrollStateRememberScrollState = scrollState;
                    }
                    i3 |= i13;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        popupProperties2 = popupProperties;
                        if (composerStartRestartGroup.changed(popupProperties2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((1572864 & i) != 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    i8 = i3;
                    if ((i3 & 599187) != 599186) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "211@8218L21");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                float f = 0;
                                jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f))) << 32));
                            }
                            if ((i2 & 16) != 0) {
                                i9 = i8 & (-57345);
                                scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                            } else {
                                i9 = i8;
                            }
                            if (i6 != 0) {
                                j3 = jM9743constructorimpl;
                                scrollStateRememberScrollState = scrollStateRememberScrollState;
                                popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                                i10 = 1518067413;
                                modifier4 = modifier2;
                            } else {
                                scrollStateRememberScrollState = scrollStateRememberScrollState;
                                popupProperties2 = popupProperties2;
                                i10 = 1518067413;
                                modifier4 = modifier2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:215)");
                            }
                            composer2 = composerStartRestartGroup;
                            m2743DropdownMenuIlH_yew(z, function0, modifier4, j3, scrollStateRememberScrollState, popupProperties2, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM(), null, function3, composer2, (i9 & 14) | 905969664 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9), ((i9 >> 15) & 112) | 6, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            j2 = j3;
                            scrollState2 = scrollStateRememberScrollState;
                            popupProperties3 = popupProperties2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i9 = (i2 & 16) != 0 ? i8 & (-57345) : i8;
                            i10 = 1518067413;
                            modifier4 = modifier2;
                        }
                        j3 = jM9743constructorimpl;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:215)");
                        }
                        composer2 = composerStartRestartGroup;
                        m2743DropdownMenuIlH_yew(z, function0, modifier4, j3, scrollStateRememberScrollState, popupProperties2, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM(), null, function3, composer2, (i9 & 14) | 905969664 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9), ((i9 >> 15) & 112) | 6, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        j2 = j3;
                        scrollState2 = scrollStateRememberScrollState;
                        popupProperties3 = popupProperties2;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        j2 = jM9743constructorimpl;
                        scrollState2 = scrollStateRememberScrollState;
                        popupProperties3 = popupProperties2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$0(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                popupProperties2 = popupProperties;
                if ((1572864 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                i8 = i3;
                if ((i3 & 599187) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "211@8218L21");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            float f2 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f2))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f2))) << 32));
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            j3 = jM9743constructorimpl;
                            scrollStateRememberScrollState = scrollStateRememberScrollState;
                            popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                            i10 = 1518067413;
                            modifier4 = modifier2;
                        } else {
                            scrollStateRememberScrollState = scrollStateRememberScrollState;
                            popupProperties2 = popupProperties2;
                            i10 = 1518067413;
                            modifier4 = modifier2;
                            j3 = jM9743constructorimpl;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            float f3 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f3))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f3))) << 32));
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            j3 = jM9743constructorimpl;
                            scrollStateRememberScrollState = scrollStateRememberScrollState;
                            popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                            i10 = 1518067413;
                            modifier4 = modifier2;
                        } else {
                            scrollStateRememberScrollState = scrollStateRememberScrollState;
                            popupProperties2 = popupProperties2;
                            i10 = 1518067413;
                            modifier4 = modifier2;
                            j3 = jM9743constructorimpl;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:215)");
                    }
                    composer2 = composerStartRestartGroup;
                    m2743DropdownMenuIlH_yew(z, function0, modifier4, j3, scrollStateRememberScrollState, popupProperties2, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM(), null, function3, composer2, (i9 & 14) | 905969664 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9), ((i9 >> 15) & 112) | 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    j2 = j3;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j2 = jM9743constructorimpl;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$0(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            jM9743constructorimpl = j;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    scrollStateRememberScrollState = scrollState;
                    if (composerStartRestartGroup.changed(scrollStateRememberScrollState)) {
                    }
                    i3 |= i13;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i3 |= i13;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                i8 = i3;
                if ((i3 & 599187) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "211@8218L21");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            float f4 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f4))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f4))) << 32));
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            j3 = jM9743constructorimpl;
                            scrollStateRememberScrollState = scrollStateRememberScrollState;
                            popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                            i10 = 1518067413;
                            modifier4 = modifier2;
                        } else {
                            scrollStateRememberScrollState = scrollStateRememberScrollState;
                            popupProperties2 = popupProperties2;
                            i10 = 1518067413;
                            modifier4 = modifier2;
                            j3 = jM9743constructorimpl;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            float f5 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f5))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f5))) << 32));
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            j3 = jM9743constructorimpl;
                            scrollStateRememberScrollState = scrollStateRememberScrollState;
                            popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                            i10 = 1518067413;
                            modifier4 = modifier2;
                        } else {
                            scrollStateRememberScrollState = scrollStateRememberScrollState;
                            popupProperties2 = popupProperties2;
                            i10 = 1518067413;
                            modifier4 = modifier2;
                            j3 = jM9743constructorimpl;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:215)");
                    }
                    composer2 = composerStartRestartGroup;
                    m2743DropdownMenuIlH_yew(z, function0, modifier4, j3, scrollStateRememberScrollState, popupProperties2, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM(), null, function3, composer2, (i9 & 14) | 905969664 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9), ((i9 >> 15) & 112) | 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    j2 = j3;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j2 = jM9743constructorimpl;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$0(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            popupProperties2 = popupProperties;
            if ((1572864 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            i8 = i3;
            if ((i3 & 599187) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "211@8218L21");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        float f6 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f6))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f6))) << 32));
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        j3 = jM9743constructorimpl;
                        scrollStateRememberScrollState = scrollStateRememberScrollState;
                        popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                        i10 = 1518067413;
                        modifier4 = modifier2;
                    } else {
                        scrollStateRememberScrollState = scrollStateRememberScrollState;
                        popupProperties2 = popupProperties2;
                        i10 = 1518067413;
                        modifier4 = modifier2;
                        j3 = jM9743constructorimpl;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        float f7 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f7))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f7))) << 32));
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        j3 = jM9743constructorimpl;
                        scrollStateRememberScrollState = scrollStateRememberScrollState;
                        popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                        i10 = 1518067413;
                        modifier4 = modifier2;
                    } else {
                        scrollStateRememberScrollState = scrollStateRememberScrollState;
                        popupProperties2 = popupProperties2;
                        i10 = 1518067413;
                        modifier4 = modifier2;
                        j3 = jM9743constructorimpl;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:215)");
                }
                composer2 = composerStartRestartGroup;
                m2743DropdownMenuIlH_yew(z, function0, modifier4, j3, scrollStateRememberScrollState, popupProperties2, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM(), null, function3, composer2, (i9 & 14) | 905969664 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9), ((i9 >> 15) & 112) | 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j2 = j3;
                scrollState2 = scrollStateRememberScrollState;
                popupProperties3 = popupProperties2;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = jM9743constructorimpl;
                scrollState2 = scrollStateRememberScrollState;
                popupProperties3 = popupProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$0(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                jM9743constructorimpl = j;
                if (composerStartRestartGroup.changed(jM9743constructorimpl)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    scrollStateRememberScrollState = scrollState;
                    if (composerStartRestartGroup.changed(scrollStateRememberScrollState)) {
                    }
                    i3 |= i13;
                } else {
                    scrollStateRememberScrollState = scrollState;
                }
                i3 |= i13;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    popupProperties2 = popupProperties;
                    if (composerStartRestartGroup.changed(popupProperties2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                i8 = i3;
                if ((i3 & 599187) != 599186) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "211@8218L21");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            float f8 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f8))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f8))) << 32));
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            j3 = jM9743constructorimpl;
                            scrollStateRememberScrollState = scrollStateRememberScrollState;
                            popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                            i10 = 1518067413;
                            modifier4 = modifier2;
                        } else {
                            scrollStateRememberScrollState = scrollStateRememberScrollState;
                            popupProperties2 = popupProperties2;
                            i10 = 1518067413;
                            modifier4 = modifier2;
                            j3 = jM9743constructorimpl;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            float f9 = 0;
                            jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f9))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f9))) << 32));
                        }
                        if ((i2 & 16) != 0) {
                            i9 = i8 & (-57345);
                            scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            j3 = jM9743constructorimpl;
                            scrollStateRememberScrollState = scrollStateRememberScrollState;
                            popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                            i10 = 1518067413;
                            modifier4 = modifier2;
                        } else {
                            scrollStateRememberScrollState = scrollStateRememberScrollState;
                            popupProperties2 = popupProperties2;
                            i10 = 1518067413;
                            modifier4 = modifier2;
                            j3 = jM9743constructorimpl;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:215)");
                    }
                    composer2 = composerStartRestartGroup;
                    m2743DropdownMenuIlH_yew(z, function0, modifier4, j3, scrollStateRememberScrollState, popupProperties2, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM(), null, function3, composer2, (i9 & 14) | 905969664 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9), ((i9 >> 15) & 112) | 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    j2 = j3;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j2 = jM9743constructorimpl;
                    scrollState2 = scrollStateRememberScrollState;
                    popupProperties3 = popupProperties2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$0(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            popupProperties2 = popupProperties;
            if ((1572864 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            i8 = i3;
            if ((i3 & 599187) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "211@8218L21");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        float f10 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f10))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f10))) << 32));
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        j3 = jM9743constructorimpl;
                        scrollStateRememberScrollState = scrollStateRememberScrollState;
                        popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                        i10 = 1518067413;
                        modifier4 = modifier2;
                    } else {
                        scrollStateRememberScrollState = scrollStateRememberScrollState;
                        popupProperties2 = popupProperties2;
                        i10 = 1518067413;
                        modifier4 = modifier2;
                        j3 = jM9743constructorimpl;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        float f11 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f11))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f11))) << 32));
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        j3 = jM9743constructorimpl;
                        scrollStateRememberScrollState = scrollStateRememberScrollState;
                        popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                        i10 = 1518067413;
                        modifier4 = modifier2;
                    } else {
                        scrollStateRememberScrollState = scrollStateRememberScrollState;
                        popupProperties2 = popupProperties2;
                        i10 = 1518067413;
                        modifier4 = modifier2;
                        j3 = jM9743constructorimpl;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:215)");
                }
                composer2 = composerStartRestartGroup;
                m2743DropdownMenuIlH_yew(z, function0, modifier4, j3, scrollStateRememberScrollState, popupProperties2, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM(), null, function3, composer2, (i9 & 14) | 905969664 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9), ((i9 >> 15) & 112) | 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j2 = j3;
                scrollState2 = scrollStateRememberScrollState;
                popupProperties3 = popupProperties2;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = jM9743constructorimpl;
                scrollState2 = scrollStateRememberScrollState;
                popupProperties3 = popupProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$0(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        jM9743constructorimpl = j;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                scrollStateRememberScrollState = scrollState;
                if (composerStartRestartGroup.changed(scrollStateRememberScrollState)) {
                }
                i3 |= i13;
            } else {
                scrollStateRememberScrollState = scrollState;
            }
            i3 |= i13;
        } else {
            scrollStateRememberScrollState = scrollState;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                popupProperties2 = popupProperties;
                if (composerStartRestartGroup.changed(popupProperties2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((1572864 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            i8 = i3;
            if ((i3 & 599187) != 599186) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "211@8218L21");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        float f12 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f12))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f12))) << 32));
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        j3 = jM9743constructorimpl;
                        scrollStateRememberScrollState = scrollStateRememberScrollState;
                        popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                        i10 = 1518067413;
                        modifier4 = modifier2;
                    } else {
                        scrollStateRememberScrollState = scrollStateRememberScrollState;
                        popupProperties2 = popupProperties2;
                        i10 = 1518067413;
                        modifier4 = modifier2;
                        j3 = jM9743constructorimpl;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        float f13 = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f13))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f13))) << 32));
                    }
                    if ((i2 & 16) != 0) {
                        i9 = i8 & (-57345);
                        scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        j3 = jM9743constructorimpl;
                        scrollStateRememberScrollState = scrollStateRememberScrollState;
                        popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                        i10 = 1518067413;
                        modifier4 = modifier2;
                    } else {
                        scrollStateRememberScrollState = scrollStateRememberScrollState;
                        popupProperties2 = popupProperties2;
                        i10 = 1518067413;
                        modifier4 = modifier2;
                        j3 = jM9743constructorimpl;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:215)");
                }
                composer2 = composerStartRestartGroup;
                m2743DropdownMenuIlH_yew(z, function0, modifier4, j3, scrollStateRememberScrollState, popupProperties2, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM(), null, function3, composer2, (i9 & 14) | 905969664 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9), ((i9 >> 15) & 112) | 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j2 = j3;
                scrollState2 = scrollStateRememberScrollState;
                popupProperties3 = popupProperties2;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j2 = jM9743constructorimpl;
                scrollState2 = scrollStateRememberScrollState;
                popupProperties3 = popupProperties2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$0(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        popupProperties2 = popupProperties;
        if ((1572864 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        }
        i8 = i3;
        if ((i3 & 599187) != 599186) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i8 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "211@8218L21");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    float f14 = 0;
                    jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f14))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f14))) << 32));
                }
                if ((i2 & 16) != 0) {
                    i9 = i8 & (-57345);
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                } else {
                    i9 = i8;
                }
                if (i6 != 0) {
                    j3 = jM9743constructorimpl;
                    scrollStateRememberScrollState = scrollStateRememberScrollState;
                    popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                    i10 = 1518067413;
                    modifier4 = modifier2;
                } else {
                    scrollStateRememberScrollState = scrollStateRememberScrollState;
                    popupProperties2 = popupProperties2;
                    i10 = 1518067413;
                    modifier4 = modifier2;
                    j3 = jM9743constructorimpl;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    float f15 = 0;
                    jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f15))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f15))) << 32));
                }
                if ((i2 & 16) != 0) {
                    i9 = i8 & (-57345);
                    scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                } else {
                    i9 = i8;
                }
                if (i6 != 0) {
                    j3 = jM9743constructorimpl;
                    scrollStateRememberScrollState = scrollStateRememberScrollState;
                    popupProperties2 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                    i10 = 1518067413;
                    modifier4 = modifier2;
                } else {
                    scrollStateRememberScrollState = scrollStateRememberScrollState;
                    popupProperties2 = popupProperties2;
                    i10 = 1518067413;
                    modifier4 = modifier2;
                    j3 = jM9743constructorimpl;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:215)");
            }
            composer2 = composerStartRestartGroup;
            m2743DropdownMenuIlH_yew(z, function0, modifier4, j3, scrollStateRememberScrollState, popupProperties2, MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6), MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM(), MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM(), null, function3, composer2, (i9 & 14) | 905969664 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9), ((i9 >> 15) & 112) | 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j2 = j3;
            scrollState2 = scrollStateRememberScrollState;
            popupProperties3 = popupProperties2;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j2 = jM9743constructorimpl;
            scrollState2 = scrollStateRememberScrollState;
            popupProperties3 = popupProperties2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidMenu_androidKt.DropdownMenu_4kj__NE$lambda$0(z, function0, modifier3, j2, scrollState2, popupProperties3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:40:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:71:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:74:0x0106  */
    /* JADX WARN: Code duplicated, block: B:77:0x013e  */
    /* JADX WARN: Code duplicated, block: B:79:0x0145  */
    /* JADX WARN: Code duplicated, block: B:82:0x0155  */
    /* JADX WARN: Code duplicated, block: B:84:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith = @ReplaceWith(expression = "DropdownMenu(expanded,onDismissRequest, modifier, offset, rememberScrollState(), properties, content)", imports = {"androidx.compose.foundation.rememberScrollState"}))
    /* JADX INFO: renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    public static final /* synthetic */ void m2742DropdownMenuILWXrKs(final boolean z, final Function0 function0, Modifier modifier, long j, PopupProperties popupProperties, final Function3 function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        int i6;
        int i7;
        Function3 function4;
        boolean z2;
        Composer composer2;
        final PopupProperties popupProperties2;
        final Modifier modifier3;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        long jM9743constructorimpl;
        PopupProperties popupProperties3;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(1744198621);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenu)N(expanded,onDismissRequest,modifier,offset:c#ui.unit.DpOffset,properties,content)256@9743L21,251@9579L252:AndroidMenu.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(j)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(popupProperties)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    function4 = function3;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i8 = 131072;
                    } else {
                        i8 = 65536;
                    }
                    i3 |= i8;
                } else {
                    function4 = function3;
                }
                if ((74899 & i3) != 74898) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    popupProperties2 = popupProperties;
                    modifier3 = modifier2;
                    j2 = j;
                } else {
                    if (i9 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        float f = 0;
                        jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f))) << 32));
                    } else {
                        jM9743constructorimpl = j;
                    }
                    if (i6 != 0) {
                        popupProperties3 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                    } else {
                        popupProperties3 = popupProperties;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1744198621, i3, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:251)");
                    }
                    composer2 = composerStartRestartGroup;
                    m2743DropdownMenuIlH_yew(z, function0, modifier4, jM9743constructorimpl, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, null, 0L, 0.0f, 0.0f, null, function4, composer2, (i3 & 8190) | ((i3 << 3) & 458752), (i3 >> 12) & 112, 1984);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    j2 = jM9743constructorimpl;
                    popupProperties2 = popupProperties3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenu_ILWXrKs$lambda$0(z, function0, modifier3, j2, popupProperties2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            if ((196608 & i) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            } else {
                function4 = function3;
            }
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                popupProperties2 = popupProperties;
                modifier3 = modifier2;
                j2 = j;
            } else {
                if (i9 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    float f2 = 0;
                    jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f2))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f2))) << 32));
                } else {
                    jM9743constructorimpl = j;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                } else {
                    popupProperties3 = popupProperties;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1744198621, i3, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:251)");
                }
                composer2 = composerStartRestartGroup;
                m2743DropdownMenuIlH_yew(z, function0, modifier4, jM9743constructorimpl, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, null, 0L, 0.0f, 0.0f, null, function4, composer2, (i3 & 8190) | ((i3 << 3) & 458752), (i3 >> 12) & 112, 1984);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j2 = jM9743constructorimpl;
                popupProperties2 = popupProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_ILWXrKs$lambda$0(z, function0, modifier3, j2, popupProperties2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changed(j)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i3 |= i5;
        }
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(popupProperties)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((196608 & i) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i8 = 131072;
                } else {
                    i8 = 65536;
                }
                i3 |= i8;
            } else {
                function4 = function3;
            }
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                popupProperties2 = popupProperties;
                modifier3 = modifier2;
                j2 = j;
            } else {
                if (i9 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    float f3 = 0;
                    jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f3))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f3))) << 32));
                } else {
                    jM9743constructorimpl = j;
                }
                if (i6 != 0) {
                    popupProperties3 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
                } else {
                    popupProperties3 = popupProperties;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1744198621, i3, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:251)");
                }
                composer2 = composerStartRestartGroup;
                m2743DropdownMenuIlH_yew(z, function0, modifier4, jM9743constructorimpl, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, null, 0L, 0.0f, 0.0f, null, function4, composer2, (i3 & 8190) | ((i3 << 3) & 458752), (i3 >> 12) & 112, 1984);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j2 = jM9743constructorimpl;
                popupProperties2 = popupProperties3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenu_ILWXrKs$lambda$0(z, function0, modifier3, j2, popupProperties2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        if ((196608 & i) == 0) {
            function4 = function3;
            if (composerStartRestartGroup.changedInstance(function4)) {
                i8 = 131072;
            } else {
                i8 = 65536;
            }
            i3 |= i8;
        } else {
            function4 = function3;
        }
        if ((74899 & i3) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            popupProperties2 = popupProperties;
            modifier3 = modifier2;
            j2 = j;
        } else {
            if (i9 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                float f4 = 0;
                jM9743constructorimpl = DpOffset.m9743constructorimpl((((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f4))) & 4294967295L) | (((long) Float.floatToRawIntBits(Dp.m9687constructorimpl(f4))) << 32));
            } else {
                jM9743constructorimpl = j;
            }
            if (i6 != 0) {
                popupProperties3 = new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null);
            } else {
                popupProperties3 = popupProperties;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1744198621, i3, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:251)");
            }
            composer2 = composerStartRestartGroup;
            m2743DropdownMenuIlH_yew(z, function0, modifier4, jM9743constructorimpl, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), popupProperties3, null, 0L, 0.0f, 0.0f, null, function4, composer2, (i3 & 8190) | ((i3 << 3) & 458752), (i3 >> 12) & 112, 1984);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j2 = jM9743constructorimpl;
            popupProperties2 = popupProperties3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidMenu_androidKt.DropdownMenu_ILWXrKs$lambda$0(z, function0, modifier3, j2, popupProperties2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0123  */
    /* JADX WARN: Code duplicated, block: B:102:0x0132  */
    /* JADX WARN: Code duplicated, block: B:110:0x0159 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x015b  */
    /* JADX WARN: Code duplicated, block: B:114:0x0163  */
    /* JADX WARN: Code duplicated, block: B:116:0x0166  */
    /* JADX WARN: Code duplicated, block: B:118:0x0169  */
    /* JADX WARN: Code duplicated, block: B:121:0x016f  */
    /* JADX WARN: Code duplicated, block: B:122:0x017a  */
    /* JADX WARN: Code duplicated, block: B:124:0x017e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0185  */
    /* JADX WARN: Code duplicated, block: B:127:0x0189  */
    /* JADX WARN: Code duplicated, block: B:128:0x018c  */
    /* JADX WARN: Code duplicated, block: B:132:0x019a  */
    /* JADX WARN: Code duplicated, block: B:135:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:137:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:140:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:55:0x0095  */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:65:0x00af  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00da  */
    /* JADX WARN: Code duplicated, block: B:80:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:91:0x0100  */
    /* JADX WARN: Code duplicated, block: B:96:0x0117  */
    /* JADX WARN: Code duplicated, block: B:97:0x011a  */
    public static final void DropdownMenuItem(final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function5;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int i7;
        int i8;
        boolean z2;
        int i9;
        MenuItemColors menuItemColorsItemColors;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z3;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function7;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        final boolean z4;
        final MenuItemColors menuItemColors2;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i15;
        PaddingValues dropdownMenuItemContentPadding;
        MutableInteractionSource mutableInteractionSource3;
        PaddingValues paddingValues3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-532959117);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItem)N(text,onClick,modifier,leadingIcon,trailingIcon,enabled,colors,contentPadding,interactionSource)273@10189L319:AndroidMenu.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i16 = i2 & 4;
        if (i16 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        function6 = function4;
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            z2 = z;
                            if (composerStartRestartGroup.changed(z2)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                menuItemColorsItemColors = menuItemColors;
                                int i17 = composerStartRestartGroup.changed(menuItemColorsItemColors) ? 1048576 : 524288;
                                i3 |= i17;
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                            }
                            i3 |= i17;
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                        }
                        i10 = i2 & 128;
                        if (i10 != 0) {
                            if ((i & 12582912) == 0) {
                                if (composerStartRestartGroup.changed(paddingValues)) {
                                    i11 = 8388608;
                                } else {
                                    i11 = 4194304;
                                }
                                i3 |= i11;
                            }
                            i12 = i2 & 256;
                            if (i12 != 0) {
                                if ((i & 100663296) == 0) {
                                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                        i13 = 67108864;
                                    } else {
                                        i13 = 33554432;
                                    }
                                    i3 |= i13;
                                }
                                i14 = i3;
                                if ((i3 & 38347923) != 38347922) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i16 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i4 != 0) {
                                            function5 = null;
                                        }
                                        if (i6 != 0) {
                                            function6 = null;
                                        }
                                        if (i8 != 0) {
                                            z2 = true;
                                        }
                                        if ((i2 & 64) != 0) {
                                            i15 = i14 & (-3670017);
                                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                        } else {
                                            i15 = i14;
                                        }
                                        if (i10 != 0) {
                                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                        } else {
                                            dropdownMenuItemContentPadding = paddingValues;
                                        }
                                        if (i12 != 0) {
                                            mutableInteractionSource3 = null;
                                        } else {
                                            mutableInteractionSource3 = mutableInteractionSource;
                                        }
                                        paddingValues3 = dropdownMenuItemContentPadding;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i2 & 64) != 0) {
                                            i15 = i14 & (-3670017);
                                            paddingValues3 = paddingValues;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                        } else {
                                            paddingValues3 = paddingValues;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                            i15 = i14;
                                        }
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function9 = function6;
                                    boolean z5 = z2;
                                    MenuItemColors menuItemColors3 = menuItemColorsItemColors;
                                    Modifier modifier4 = modifier2;
                                    Function2<? super Composer, ? super Integer, Unit> function10 = function5;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                                    }
                                    composer2 = composerStartRestartGroup;
                                    MenuKt.DropdownMenuItemContent(function2, function0, modifier4, function10, function9, z5, menuItemColors3, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    function7 = function10;
                                    function8 = function9;
                                    z4 = z5;
                                    menuItemColors2 = menuItemColors3;
                                    paddingValues2 = paddingValues3;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    modifier3 = modifier2;
                                    function7 = function5;
                                    function8 = function6;
                                    z4 = z2;
                                    menuItemColors2 = menuItemColorsItemColors;
                                    paddingValues2 = paddingValues;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                }
                            }
                            i3 |= 100663296;
                            i14 = i3;
                            if ((i3 & 38347923) != 38347922) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                                if ((i & 1) != 0) {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i15 = i14 & (-3670017);
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    } else {
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                } else {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i15 = i14 & (-3670017);
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    } else {
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function11 = function6;
                                boolean z6 = z2;
                                MenuItemColors menuItemColors4 = menuItemColorsItemColors;
                                Modifier modifier5 = modifier2;
                                Function2<? super Composer, ? super Integer, Unit> function12 = function5;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                                }
                                composer2 = composerStartRestartGroup;
                                MenuKt.DropdownMenuItemContent(function2, function0, modifier5, function12, function11, z6, menuItemColors4, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier5;
                                function7 = function12;
                                function8 = function11;
                                z4 = z6;
                                menuItemColors2 = menuItemColors4;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier3 = modifier2;
                                function7 = function5;
                                function8 = function6;
                                z4 = z2;
                                menuItemColors2 = menuItemColorsItemColors;
                                paddingValues2 = paddingValues;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 12582912;
                        i12 = i2 & 256;
                        if (i12 != 0) {
                            if ((i & 100663296) == 0) {
                                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                    i13 = 67108864;
                                } else {
                                    i13 = 33554432;
                                }
                                i3 |= i13;
                            }
                            i14 = i3;
                            if ((i3 & 38347923) != 38347922) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                                if ((i & 1) != 0) {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i15 = i14 & (-3670017);
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    } else {
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                } else {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i15 = i14 & (-3670017);
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    } else {
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function13 = function6;
                                boolean z7 = z2;
                                MenuItemColors menuItemColors5 = menuItemColorsItemColors;
                                Modifier modifier6 = modifier2;
                                Function2<? super Composer, ? super Integer, Unit> function14 = function5;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                                }
                                composer2 = composerStartRestartGroup;
                                MenuKt.DropdownMenuItemContent(function2, function0, modifier6, function14, function13, z7, menuItemColors5, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier6;
                                function7 = function14;
                                function8 = function13;
                                z4 = z7;
                                menuItemColors2 = menuItemColors5;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier3 = modifier2;
                                function7 = function5;
                                function8 = function6;
                                z4 = z2;
                                menuItemColors2 = menuItemColorsItemColors;
                                paddingValues2 = paddingValues;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 100663296;
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function15 = function6;
                            boolean z8 = z2;
                            MenuItemColors menuItemColors6 = menuItemColorsItemColors;
                            Modifier modifier7 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function16 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier7, function16, function15, z8, menuItemColors6, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier7;
                            function7 = function16;
                            function8 = function15;
                            z4 = z8;
                            menuItemColors2 = menuItemColors6;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    z2 = z;
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            menuItemColorsItemColors = menuItemColors;
                            if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                            }
                            i3 |= i17;
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                        }
                        i3 |= i17;
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        i12 = i2 & 256;
                        if (i12 != 0) {
                            if ((i & 100663296) == 0) {
                                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                    i13 = 67108864;
                                } else {
                                    i13 = 33554432;
                                }
                                i3 |= i13;
                            }
                            i14 = i3;
                            if ((i3 & 38347923) != 38347922) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                                if ((i & 1) != 0) {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i15 = i14 & (-3670017);
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    } else {
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                } else {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i15 = i14 & (-3670017);
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    } else {
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function17 = function6;
                                boolean z9 = z2;
                                MenuItemColors menuItemColors7 = menuItemColorsItemColors;
                                Modifier modifier8 = modifier2;
                                Function2<? super Composer, ? super Integer, Unit> function18 = function5;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                                }
                                composer2 = composerStartRestartGroup;
                                MenuKt.DropdownMenuItemContent(function2, function0, modifier8, function18, function17, z9, menuItemColors7, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier8;
                                function7 = function18;
                                function8 = function17;
                                z4 = z9;
                                menuItemColors2 = menuItemColors7;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier3 = modifier2;
                                function7 = function5;
                                function8 = function6;
                                z4 = z2;
                                menuItemColors2 = menuItemColorsItemColors;
                                paddingValues2 = paddingValues;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 100663296;
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function19 = function6;
                            boolean z10 = z2;
                            MenuItemColors menuItemColors8 = menuItemColorsItemColors;
                            Modifier modifier9 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function110 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier9, function110, function19, z10, menuItemColors8, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier9;
                            function7 = function110;
                            function8 = function19;
                            z4 = z10;
                            menuItemColors2 = menuItemColors8;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function111 = function6;
                            boolean z11 = z2;
                            MenuItemColors menuItemColors9 = menuItemColorsItemColors;
                            Modifier modifier10 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function112 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier10, function112, function111, z11, menuItemColors9, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier10;
                            function7 = function112;
                            function8 = function111;
                            z4 = z11;
                            menuItemColors2 = menuItemColors9;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function113 = function6;
                        boolean z12 = z2;
                        MenuItemColors menuItemColors10 = menuItemColorsItemColors;
                        Modifier modifier11 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function114 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier11, function114, function113, z12, menuItemColors10, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier11;
                        function7 = function114;
                        function8 = function113;
                        z4 = z12;
                        menuItemColors2 = menuItemColors10;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function6 = function4;
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            menuItemColorsItemColors = menuItemColors;
                            if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                            }
                            i3 |= i17;
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                        }
                        i3 |= i17;
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        i12 = i2 & 256;
                        if (i12 != 0) {
                            if ((i & 100663296) == 0) {
                                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                    i13 = 67108864;
                                } else {
                                    i13 = 33554432;
                                }
                                i3 |= i13;
                            }
                            i14 = i3;
                            if ((i3 & 38347923) != 38347922) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                                if ((i & 1) != 0) {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i15 = i14 & (-3670017);
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    } else {
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                } else {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i15 = i14 & (-3670017);
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    } else {
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function115 = function6;
                                boolean z13 = z2;
                                MenuItemColors menuItemColors11 = menuItemColorsItemColors;
                                Modifier modifier12 = modifier2;
                                Function2<? super Composer, ? super Integer, Unit> function116 = function5;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                                }
                                composer2 = composerStartRestartGroup;
                                MenuKt.DropdownMenuItemContent(function2, function0, modifier12, function116, function115, z13, menuItemColors11, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier12;
                                function7 = function116;
                                function8 = function115;
                                z4 = z13;
                                menuItemColors2 = menuItemColors11;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier3 = modifier2;
                                function7 = function5;
                                function8 = function6;
                                z4 = z2;
                                menuItemColors2 = menuItemColorsItemColors;
                                paddingValues2 = paddingValues;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 100663296;
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function117 = function6;
                            boolean z14 = z2;
                            MenuItemColors menuItemColors12 = menuItemColorsItemColors;
                            Modifier modifier13 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function118 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier13, function118, function117, z14, menuItemColors12, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier13;
                            function7 = function118;
                            function8 = function117;
                            z4 = z14;
                            menuItemColors2 = menuItemColors12;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function119 = function6;
                            boolean z15 = z2;
                            MenuItemColors menuItemColors13 = menuItemColorsItemColors;
                            Modifier modifier14 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function1110 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier14, function1110, function119, z15, menuItemColors13, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier14;
                            function7 = function1110;
                            function8 = function119;
                            z4 = z15;
                            menuItemColors2 = menuItemColors13;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1111 = function6;
                        boolean z16 = z2;
                        MenuItemColors menuItemColors14 = menuItemColorsItemColors;
                        Modifier modifier15 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function1112 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier15, function1112, function1111, z16, menuItemColors14, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier15;
                        function7 = function1112;
                        function8 = function1111;
                        z4 = z16;
                        menuItemColors2 = menuItemColors14;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        menuItemColorsItemColors = menuItemColors;
                        if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                        }
                        i3 |= i17;
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                    }
                    i3 |= i17;
                } else {
                    menuItemColorsItemColors = menuItemColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function1113 = function6;
                            boolean z17 = z2;
                            MenuItemColors menuItemColors15 = menuItemColorsItemColors;
                            Modifier modifier16 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function1114 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier16, function1114, function1113, z17, menuItemColors15, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier16;
                            function7 = function1114;
                            function8 = function1113;
                            z4 = z17;
                            menuItemColors2 = menuItemColors15;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1115 = function6;
                        boolean z18 = z2;
                        MenuItemColors menuItemColors16 = menuItemColorsItemColors;
                        Modifier modifier17 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function1116 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier17, function1116, function1115, z18, menuItemColors16, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier17;
                        function7 = function1116;
                        function8 = function1115;
                        z4 = z18;
                        menuItemColors2 = menuItemColors16;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1117 = function6;
                        boolean z19 = z2;
                        MenuItemColors menuItemColors17 = menuItemColorsItemColors;
                        Modifier modifier18 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function1118 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier18, function1118, function1117, z19, menuItemColors17, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier18;
                        function7 = function1118;
                        function8 = function1117;
                        z4 = z19;
                        menuItemColors2 = menuItemColors17;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1119 = function6;
                    boolean z110 = z2;
                    MenuItemColors menuItemColors18 = menuItemColorsItemColors;
                    Modifier modifier19 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function11110 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier19, function11110, function1119, z110, menuItemColors18, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier19;
                    function7 = function11110;
                    function8 = function1119;
                    z4 = z110;
                    menuItemColors2 = menuItemColors18;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            function5 = function3;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function6 = function4;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            menuItemColorsItemColors = menuItemColors;
                            if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                            }
                            i3 |= i17;
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                        }
                        i3 |= i17;
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        i12 = i2 & 256;
                        if (i12 != 0) {
                            if ((i & 100663296) == 0) {
                                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                    i13 = 67108864;
                                } else {
                                    i13 = 33554432;
                                }
                                i3 |= i13;
                            }
                            i14 = i3;
                            if ((i3 & 38347923) != 38347922) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                                if ((i & 1) != 0) {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i15 = i14 & (-3670017);
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    } else {
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                } else {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i15 = i14 & (-3670017);
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    } else {
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function11111 = function6;
                                boolean z111 = z2;
                                MenuItemColors menuItemColors19 = menuItemColorsItemColors;
                                Modifier modifier110 = modifier2;
                                Function2<? super Composer, ? super Integer, Unit> function11112 = function5;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                                }
                                composer2 = composerStartRestartGroup;
                                MenuKt.DropdownMenuItemContent(function2, function0, modifier110, function11112, function11111, z111, menuItemColors19, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier110;
                                function7 = function11112;
                                function8 = function11111;
                                z4 = z111;
                                menuItemColors2 = menuItemColors19;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier3 = modifier2;
                                function7 = function5;
                                function8 = function6;
                                z4 = z2;
                                menuItemColors2 = menuItemColorsItemColors;
                                paddingValues2 = paddingValues;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 100663296;
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function11113 = function6;
                            boolean z112 = z2;
                            MenuItemColors menuItemColors110 = menuItemColorsItemColors;
                            Modifier modifier111 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function11114 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier111, function11114, function11113, z112, menuItemColors110, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier111;
                            function7 = function11114;
                            function8 = function11113;
                            z4 = z112;
                            menuItemColors2 = menuItemColors110;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function11115 = function6;
                            boolean z113 = z2;
                            MenuItemColors menuItemColors111 = menuItemColorsItemColors;
                            Modifier modifier112 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function11116 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier112, function11116, function11115, z113, menuItemColors111, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier112;
                            function7 = function11116;
                            function8 = function11115;
                            z4 = z113;
                            menuItemColors2 = menuItemColors111;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function11117 = function6;
                        boolean z114 = z2;
                        MenuItemColors menuItemColors112 = menuItemColorsItemColors;
                        Modifier modifier113 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function11118 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier113, function11118, function11117, z114, menuItemColors112, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier113;
                        function7 = function11118;
                        function8 = function11117;
                        z4 = z114;
                        menuItemColors2 = menuItemColors112;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        menuItemColorsItemColors = menuItemColors;
                        if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                        }
                        i3 |= i17;
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                    }
                    i3 |= i17;
                } else {
                    menuItemColorsItemColors = menuItemColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function11119 = function6;
                            boolean z115 = z2;
                            MenuItemColors menuItemColors113 = menuItemColorsItemColors;
                            Modifier modifier114 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function111110 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier114, function111110, function11119, z115, menuItemColors113, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier114;
                            function7 = function111110;
                            function8 = function11119;
                            z4 = z115;
                            menuItemColors2 = menuItemColors113;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function111111 = function6;
                        boolean z116 = z2;
                        MenuItemColors menuItemColors114 = menuItemColorsItemColors;
                        Modifier modifier115 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function111112 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier115, function111112, function111111, z116, menuItemColors114, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier115;
                        function7 = function111112;
                        function8 = function111111;
                        z4 = z116;
                        menuItemColors2 = menuItemColors114;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function111113 = function6;
                        boolean z117 = z2;
                        MenuItemColors menuItemColors115 = menuItemColorsItemColors;
                        Modifier modifier116 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function111114 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier116, function111114, function111113, z117, menuItemColors115, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier116;
                        function7 = function111114;
                        function8 = function111113;
                        z4 = z117;
                        menuItemColors2 = menuItemColors115;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function111115 = function6;
                    boolean z118 = z2;
                    MenuItemColors menuItemColors116 = menuItemColorsItemColors;
                    Modifier modifier117 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function111116 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier117, function111116, function111115, z118, menuItemColors116, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier117;
                    function7 = function111116;
                    function8 = function111115;
                    z4 = z118;
                    menuItemColors2 = menuItemColors116;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function6 = function4;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        menuItemColorsItemColors = menuItemColors;
                        if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                        }
                        i3 |= i17;
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                    }
                    i3 |= i17;
                } else {
                    menuItemColorsItemColors = menuItemColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function111117 = function6;
                            boolean z119 = z2;
                            MenuItemColors menuItemColors117 = menuItemColorsItemColors;
                            Modifier modifier118 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function111118 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier118, function111118, function111117, z119, menuItemColors117, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier118;
                            function7 = function111118;
                            function8 = function111117;
                            z4 = z119;
                            menuItemColors2 = menuItemColors117;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function111119 = function6;
                        boolean z1110 = z2;
                        MenuItemColors menuItemColors118 = menuItemColorsItemColors;
                        Modifier modifier119 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function1111110 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier119, function1111110, function111119, z1110, menuItemColors118, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier119;
                        function7 = function1111110;
                        function8 = function111119;
                        z4 = z1110;
                        menuItemColors2 = menuItemColors118;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1111111 = function6;
                        boolean z1111 = z2;
                        MenuItemColors menuItemColors119 = menuItemColorsItemColors;
                        Modifier modifier1110 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function1111112 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier1110, function1111112, function1111111, z1111, menuItemColors119, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier1110;
                        function7 = function1111112;
                        function8 = function1111111;
                        z4 = z1111;
                        menuItemColors2 = menuItemColors119;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111113 = function6;
                    boolean z1112 = z2;
                    MenuItemColors menuItemColors1110 = menuItemColorsItemColors;
                    Modifier modifier1111 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function1111114 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier1111, function1111114, function1111113, z1112, menuItemColors1110, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1111;
                    function7 = function1111114;
                    function8 = function1111113;
                    z4 = z1112;
                    menuItemColors2 = menuItemColors1110;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    menuItemColorsItemColors = menuItemColors;
                    if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                    }
                    i3 |= i17;
                } else {
                    menuItemColorsItemColors = menuItemColors;
                }
                i3 |= i17;
            } else {
                menuItemColorsItemColors = menuItemColors;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1111115 = function6;
                        boolean z1113 = z2;
                        MenuItemColors menuItemColors1111 = menuItemColorsItemColors;
                        Modifier modifier1112 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function1111116 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier1112, function1111116, function1111115, z1113, menuItemColors1111, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier1112;
                        function7 = function1111116;
                        function8 = function1111115;
                        z4 = z1113;
                        menuItemColors2 = menuItemColors1111;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111117 = function6;
                    boolean z1114 = z2;
                    MenuItemColors menuItemColors1112 = menuItemColorsItemColors;
                    Modifier modifier1113 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function1111118 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier1113, function1111118, function1111117, z1114, menuItemColors1112, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1113;
                    function7 = function1111118;
                    function8 = function1111117;
                    z4 = z1114;
                    menuItemColors2 = menuItemColors1112;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            i12 = i2 & 256;
            if (i12 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111119 = function6;
                    boolean z1115 = z2;
                    MenuItemColors menuItemColors1113 = menuItemColorsItemColors;
                    Modifier modifier1114 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function11111110 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier1114, function11111110, function1111119, z1115, menuItemColors1113, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1114;
                    function7 = function11111110;
                    function8 = function1111119;
                    z4 = z1115;
                    menuItemColors2 = menuItemColors1113;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            i14 = i3;
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i15 = i14 & (-3670017);
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                    } else {
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i15 = i14 & (-3670017);
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                    } else {
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                Function2<? super Composer, ? super Integer, Unit> function11111111 = function6;
                boolean z1116 = z2;
                MenuItemColors menuItemColors1114 = menuItemColorsItemColors;
                Modifier modifier1115 = modifier2;
                Function2<? super Composer, ? super Integer, Unit> function11111112 = function5;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                }
                composer2 = composerStartRestartGroup;
                MenuKt.DropdownMenuItemContent(function2, function0, modifier1115, function11111112, function11111111, z1116, menuItemColors1114, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1115;
                function7 = function11111112;
                function8 = function11111111;
                z4 = z1116;
                menuItemColors2 = menuItemColors1114;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                menuItemColors2 = menuItemColorsItemColors;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function6 = function4;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            menuItemColorsItemColors = menuItemColors;
                            if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                            }
                            i3 |= i17;
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                        }
                        i3 |= i17;
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        i12 = i2 & 256;
                        if (i12 != 0) {
                            if ((i & 100663296) == 0) {
                                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                    i13 = 67108864;
                                } else {
                                    i13 = 33554432;
                                }
                                i3 |= i13;
                            }
                            i14 = i3;
                            if ((i3 & 38347923) != 38347922) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                                if ((i & 1) != 0) {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i15 = i14 & (-3670017);
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    } else {
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                } else {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i15 = i14 & (-3670017);
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    } else {
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function11111113 = function6;
                                boolean z1117 = z2;
                                MenuItemColors menuItemColors1115 = menuItemColorsItemColors;
                                Modifier modifier1116 = modifier2;
                                Function2<? super Composer, ? super Integer, Unit> function11111114 = function5;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                                }
                                composer2 = composerStartRestartGroup;
                                MenuKt.DropdownMenuItemContent(function2, function0, modifier1116, function11111114, function11111113, z1117, menuItemColors1115, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier1116;
                                function7 = function11111114;
                                function8 = function11111113;
                                z4 = z1117;
                                menuItemColors2 = menuItemColors1115;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier3 = modifier2;
                                function7 = function5;
                                function8 = function6;
                                z4 = z2;
                                menuItemColors2 = menuItemColorsItemColors;
                                paddingValues2 = paddingValues;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 100663296;
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function11111115 = function6;
                            boolean z1118 = z2;
                            MenuItemColors menuItemColors1116 = menuItemColorsItemColors;
                            Modifier modifier1117 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function11111116 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier1117, function11111116, function11111115, z1118, menuItemColors1116, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier1117;
                            function7 = function11111116;
                            function8 = function11111115;
                            z4 = z1118;
                            menuItemColors2 = menuItemColors1116;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function11111117 = function6;
                            boolean z1119 = z2;
                            MenuItemColors menuItemColors1117 = menuItemColorsItemColors;
                            Modifier modifier1118 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function11111118 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier1118, function11111118, function11111117, z1119, menuItemColors1117, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier1118;
                            function7 = function11111118;
                            function8 = function11111117;
                            z4 = z1119;
                            menuItemColors2 = menuItemColors1117;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function11111119 = function6;
                        boolean z11110 = z2;
                        MenuItemColors menuItemColors1118 = menuItemColorsItemColors;
                        Modifier modifier1119 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function111111110 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier1119, function111111110, function11111119, z11110, menuItemColors1118, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier1119;
                        function7 = function111111110;
                        function8 = function11111119;
                        z4 = z11110;
                        menuItemColors2 = menuItemColors1118;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        menuItemColorsItemColors = menuItemColors;
                        if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                        }
                        i3 |= i17;
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                    }
                    i3 |= i17;
                } else {
                    menuItemColorsItemColors = menuItemColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function111111111 = function6;
                            boolean z11111 = z2;
                            MenuItemColors menuItemColors1119 = menuItemColorsItemColors;
                            Modifier modifier11110 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function111111112 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier11110, function111111112, function111111111, z11111, menuItemColors1119, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier11110;
                            function7 = function111111112;
                            function8 = function111111111;
                            z4 = z11111;
                            menuItemColors2 = menuItemColors1119;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function111111113 = function6;
                        boolean z11112 = z2;
                        MenuItemColors menuItemColors11110 = menuItemColorsItemColors;
                        Modifier modifier11111 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function111111114 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier11111, function111111114, function111111113, z11112, menuItemColors11110, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier11111;
                        function7 = function111111114;
                        function8 = function111111113;
                        z4 = z11112;
                        menuItemColors2 = menuItemColors11110;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function111111115 = function6;
                        boolean z11113 = z2;
                        MenuItemColors menuItemColors11111 = menuItemColorsItemColors;
                        Modifier modifier11112 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function111111116 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier11112, function111111116, function111111115, z11113, menuItemColors11111, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier11112;
                        function7 = function111111116;
                        function8 = function111111115;
                        z4 = z11113;
                        menuItemColors2 = menuItemColors11111;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function111111117 = function6;
                    boolean z11114 = z2;
                    MenuItemColors menuItemColors11112 = menuItemColorsItemColors;
                    Modifier modifier11113 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function111111118 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier11113, function111111118, function111111117, z11114, menuItemColors11112, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11113;
                    function7 = function111111118;
                    function8 = function111111117;
                    z4 = z11114;
                    menuItemColors2 = menuItemColors11112;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function6 = function4;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        menuItemColorsItemColors = menuItemColors;
                        if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                        }
                        i3 |= i17;
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                    }
                    i3 |= i17;
                } else {
                    menuItemColorsItemColors = menuItemColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function111111119 = function6;
                            boolean z11115 = z2;
                            MenuItemColors menuItemColors11113 = menuItemColorsItemColors;
                            Modifier modifier11114 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function1111111110 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier11114, function1111111110, function111111119, z11115, menuItemColors11113, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier11114;
                            function7 = function1111111110;
                            function8 = function111111119;
                            z4 = z11115;
                            menuItemColors2 = menuItemColors11113;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1111111111 = function6;
                        boolean z11116 = z2;
                        MenuItemColors menuItemColors11114 = menuItemColorsItemColors;
                        Modifier modifier11115 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function1111111112 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier11115, function1111111112, function1111111111, z11116, menuItemColors11114, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier11115;
                        function7 = function1111111112;
                        function8 = function1111111111;
                        z4 = z11116;
                        menuItemColors2 = menuItemColors11114;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1111111113 = function6;
                        boolean z11117 = z2;
                        MenuItemColors menuItemColors11115 = menuItemColorsItemColors;
                        Modifier modifier11116 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function1111111114 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier11116, function1111111114, function1111111113, z11117, menuItemColors11115, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier11116;
                        function7 = function1111111114;
                        function8 = function1111111113;
                        z4 = z11117;
                        menuItemColors2 = menuItemColors11115;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111111115 = function6;
                    boolean z11118 = z2;
                    MenuItemColors menuItemColors11116 = menuItemColorsItemColors;
                    Modifier modifier11117 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function1111111116 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier11117, function1111111116, function1111111115, z11118, menuItemColors11116, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11117;
                    function7 = function1111111116;
                    function8 = function1111111115;
                    z4 = z11118;
                    menuItemColors2 = menuItemColors11116;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    menuItemColorsItemColors = menuItemColors;
                    if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                    }
                    i3 |= i17;
                } else {
                    menuItemColorsItemColors = menuItemColors;
                }
                i3 |= i17;
            } else {
                menuItemColorsItemColors = menuItemColors;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1111111117 = function6;
                        boolean z11119 = z2;
                        MenuItemColors menuItemColors11117 = menuItemColorsItemColors;
                        Modifier modifier11118 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function1111111118 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier11118, function1111111118, function1111111117, z11119, menuItemColors11117, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier11118;
                        function7 = function1111111118;
                        function8 = function1111111117;
                        z4 = z11119;
                        menuItemColors2 = menuItemColors11117;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111111119 = function6;
                    boolean z111110 = z2;
                    MenuItemColors menuItemColors11118 = menuItemColorsItemColors;
                    Modifier modifier11119 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function11111111110 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier11119, function11111111110, function1111111119, z111110, menuItemColors11118, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11119;
                    function7 = function11111111110;
                    function8 = function1111111119;
                    z4 = z111110;
                    menuItemColors2 = menuItemColors11118;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            i12 = i2 & 256;
            if (i12 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function11111111111 = function6;
                    boolean z111111 = z2;
                    MenuItemColors menuItemColors11119 = menuItemColorsItemColors;
                    Modifier modifier111110 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function11111111112 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier111110, function11111111112, function11111111111, z111111, menuItemColors11119, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier111110;
                    function7 = function11111111112;
                    function8 = function11111111111;
                    z4 = z111111;
                    menuItemColors2 = menuItemColors11119;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            i14 = i3;
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i15 = i14 & (-3670017);
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                    } else {
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i15 = i14 & (-3670017);
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                    } else {
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                Function2<? super Composer, ? super Integer, Unit> function11111111113 = function6;
                boolean z111112 = z2;
                MenuItemColors menuItemColors111110 = menuItemColorsItemColors;
                Modifier modifier111111 = modifier2;
                Function2<? super Composer, ? super Integer, Unit> function11111111114 = function5;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                }
                composer2 = composerStartRestartGroup;
                MenuKt.DropdownMenuItemContent(function2, function0, modifier111111, function11111111114, function11111111113, z111112, menuItemColors111110, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier111111;
                function7 = function11111111114;
                function8 = function11111111113;
                z4 = z111112;
                menuItemColors2 = menuItemColors111110;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                menuItemColors2 = menuItemColorsItemColors;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function5 = function3;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                function6 = function4;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        menuItemColorsItemColors = menuItemColors;
                        if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                        }
                        i3 |= i17;
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                    }
                    i3 |= i17;
                } else {
                    menuItemColorsItemColors = menuItemColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i15 = i14 & (-3670017);
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                } else {
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function11111111115 = function6;
                            boolean z111113 = z2;
                            MenuItemColors menuItemColors111111 = menuItemColorsItemColors;
                            Modifier modifier111112 = modifier2;
                            Function2<? super Composer, ? super Integer, Unit> function11111111116 = function5;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                            }
                            composer2 = composerStartRestartGroup;
                            MenuKt.DropdownMenuItemContent(function2, function0, modifier111112, function11111111116, function11111111115, z111113, menuItemColors111111, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier111112;
                            function7 = function11111111116;
                            function8 = function11111111115;
                            z4 = z111113;
                            menuItemColors2 = menuItemColors111111;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function11111111117 = function6;
                        boolean z111114 = z2;
                        MenuItemColors menuItemColors111112 = menuItemColorsItemColors;
                        Modifier modifier111113 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function11111111118 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier111113, function11111111118, function11111111117, z111114, menuItemColors111112, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier111113;
                        function7 = function11111111118;
                        function8 = function11111111117;
                        z4 = z111114;
                        menuItemColors2 = menuItemColors111112;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function11111111119 = function6;
                        boolean z111115 = z2;
                        MenuItemColors menuItemColors111113 = menuItemColorsItemColors;
                        Modifier modifier111114 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function111111111110 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier111114, function111111111110, function11111111119, z111115, menuItemColors111113, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier111114;
                        function7 = function111111111110;
                        function8 = function11111111119;
                        z4 = z111115;
                        menuItemColors2 = menuItemColors111113;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function111111111111 = function6;
                    boolean z111116 = z2;
                    MenuItemColors menuItemColors111114 = menuItemColorsItemColors;
                    Modifier modifier111115 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function111111111112 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier111115, function111111111112, function111111111111, z111116, menuItemColors111114, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier111115;
                    function7 = function111111111112;
                    function8 = function111111111111;
                    z4 = z111116;
                    menuItemColors2 = menuItemColors111114;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    menuItemColorsItemColors = menuItemColors;
                    if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                    }
                    i3 |= i17;
                } else {
                    menuItemColorsItemColors = menuItemColors;
                }
                i3 |= i17;
            } else {
                menuItemColorsItemColors = menuItemColors;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function111111111113 = function6;
                        boolean z111117 = z2;
                        MenuItemColors menuItemColors111115 = menuItemColorsItemColors;
                        Modifier modifier111116 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function111111111114 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier111116, function111111111114, function111111111113, z111117, menuItemColors111115, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier111116;
                        function7 = function111111111114;
                        function8 = function111111111113;
                        z4 = z111117;
                        menuItemColors2 = menuItemColors111115;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function111111111115 = function6;
                    boolean z111118 = z2;
                    MenuItemColors menuItemColors111116 = menuItemColorsItemColors;
                    Modifier modifier111117 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function111111111116 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier111117, function111111111116, function111111111115, z111118, menuItemColors111116, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier111117;
                    function7 = function111111111116;
                    function8 = function111111111115;
                    z4 = z111118;
                    menuItemColors2 = menuItemColors111116;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            i12 = i2 & 256;
            if (i12 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function111111111117 = function6;
                    boolean z111119 = z2;
                    MenuItemColors menuItemColors111117 = menuItemColorsItemColors;
                    Modifier modifier111118 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function111111111118 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier111118, function111111111118, function111111111117, z111119, menuItemColors111117, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier111118;
                    function7 = function111111111118;
                    function8 = function111111111117;
                    z4 = z111119;
                    menuItemColors2 = menuItemColors111117;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            i14 = i3;
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i15 = i14 & (-3670017);
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                    } else {
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i15 = i14 & (-3670017);
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                    } else {
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                Function2<? super Composer, ? super Integer, Unit> function111111111119 = function6;
                boolean z1111110 = z2;
                MenuItemColors menuItemColors111118 = menuItemColorsItemColors;
                Modifier modifier111119 = modifier2;
                Function2<? super Composer, ? super Integer, Unit> function1111111111110 = function5;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                }
                composer2 = composerStartRestartGroup;
                MenuKt.DropdownMenuItemContent(function2, function0, modifier111119, function1111111111110, function111111111119, z1111110, menuItemColors111118, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier111119;
                function7 = function1111111111110;
                function8 = function111111111119;
                z4 = z1111110;
                menuItemColors2 = menuItemColors111118;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                menuItemColors2 = menuItemColorsItemColors;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function6 = function4;
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    menuItemColorsItemColors = menuItemColors;
                    if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                    }
                    i3 |= i17;
                } else {
                    menuItemColorsItemColors = menuItemColors;
                }
                i3 |= i17;
            } else {
                menuItemColorsItemColors = menuItemColors;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i15 = i14 & (-3670017);
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            } else {
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1111111111111 = function6;
                        boolean z1111111 = z2;
                        MenuItemColors menuItemColors111119 = menuItemColorsItemColors;
                        Modifier modifier1111110 = modifier2;
                        Function2<? super Composer, ? super Integer, Unit> function1111111111112 = function5;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                        }
                        composer2 = composerStartRestartGroup;
                        MenuKt.DropdownMenuItemContent(function2, function0, modifier1111110, function1111111111112, function1111111111111, z1111111, menuItemColors111119, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier1111110;
                        function7 = function1111111111112;
                        function8 = function1111111111111;
                        z4 = z1111111;
                        menuItemColors2 = menuItemColors111119;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111111111113 = function6;
                    boolean z1111112 = z2;
                    MenuItemColors menuItemColors1111110 = menuItemColorsItemColors;
                    Modifier modifier1111111 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function1111111111114 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier1111111, function1111111111114, function1111111111113, z1111112, menuItemColors1111110, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1111111;
                    function7 = function1111111111114;
                    function8 = function1111111111113;
                    z4 = z1111112;
                    menuItemColors2 = menuItemColors1111110;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            i12 = i2 & 256;
            if (i12 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111111111115 = function6;
                    boolean z1111113 = z2;
                    MenuItemColors menuItemColors1111111 = menuItemColorsItemColors;
                    Modifier modifier1111112 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function1111111111116 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier1111112, function1111111111116, function1111111111115, z1111113, menuItemColors1111111, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1111112;
                    function7 = function1111111111116;
                    function8 = function1111111111115;
                    z4 = z1111113;
                    menuItemColors2 = menuItemColors1111111;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            i14 = i3;
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i15 = i14 & (-3670017);
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                    } else {
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i15 = i14 & (-3670017);
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                    } else {
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                Function2<? super Composer, ? super Integer, Unit> function1111111111117 = function6;
                boolean z1111114 = z2;
                MenuItemColors menuItemColors1111112 = menuItemColorsItemColors;
                Modifier modifier1111113 = modifier2;
                Function2<? super Composer, ? super Integer, Unit> function1111111111118 = function5;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                }
                composer2 = composerStartRestartGroup;
                MenuKt.DropdownMenuItemContent(function2, function0, modifier1111113, function1111111111118, function1111111111117, z1111114, menuItemColors1111112, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1111113;
                function7 = function1111111111118;
                function8 = function1111111111117;
                z4 = z1111114;
                menuItemColors2 = menuItemColors1111112;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                menuItemColors2 = menuItemColorsItemColors;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z2 = z;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                menuItemColorsItemColors = menuItemColors;
                if (composerStartRestartGroup.changed(menuItemColorsItemColors)) {
                }
                i3 |= i17;
            } else {
                menuItemColorsItemColors = menuItemColors;
            }
            i3 |= i17;
        } else {
            menuItemColorsItemColors = menuItemColors;
        }
        i10 = i2 & 128;
        if (i10 != 0) {
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            i12 = i2 & 256;
            if (i12 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                i14 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i15 = i14 & (-3670017);
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        } else {
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111111111119 = function6;
                    boolean z1111115 = z2;
                    MenuItemColors menuItemColors1111113 = menuItemColorsItemColors;
                    Modifier modifier1111114 = modifier2;
                    Function2<? super Composer, ? super Integer, Unit> function11111111111110 = function5;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                    }
                    composer2 = composerStartRestartGroup;
                    MenuKt.DropdownMenuItemContent(function2, function0, modifier1111114, function11111111111110, function1111111111119, z1111115, menuItemColors1111113, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier1111114;
                    function7 = function11111111111110;
                    function8 = function1111111111119;
                    z4 = z1111115;
                    menuItemColors2 = menuItemColors1111113;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            i14 = i3;
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i15 = i14 & (-3670017);
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                    } else {
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i15 = i14 & (-3670017);
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                    } else {
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                Function2<? super Composer, ? super Integer, Unit> function11111111111111 = function6;
                boolean z1111116 = z2;
                MenuItemColors menuItemColors1111114 = menuItemColorsItemColors;
                Modifier modifier1111115 = modifier2;
                Function2<? super Composer, ? super Integer, Unit> function11111111111112 = function5;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                }
                composer2 = composerStartRestartGroup;
                MenuKt.DropdownMenuItemContent(function2, function0, modifier1111115, function11111111111112, function11111111111111, z1111116, menuItemColors1111114, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1111115;
                function7 = function11111111111112;
                function8 = function11111111111111;
                z4 = z1111116;
                menuItemColors2 = menuItemColors1111114;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                menuItemColors2 = menuItemColorsItemColors;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 12582912;
        i12 = i2 & 256;
        if (i12 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            i14 = i3;
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i15 = i14 & (-3670017);
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                    } else {
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i15 = i14 & (-3670017);
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                    } else {
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                Function2<? super Composer, ? super Integer, Unit> function11111111111113 = function6;
                boolean z1111117 = z2;
                MenuItemColors menuItemColors1111115 = menuItemColorsItemColors;
                Modifier modifier1111116 = modifier2;
                Function2<? super Composer, ? super Integer, Unit> function11111111111114 = function5;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
                }
                composer2 = composerStartRestartGroup;
                MenuKt.DropdownMenuItemContent(function2, function0, modifier1111116, function11111111111114, function11111111111113, z1111117, menuItemColors1111115, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier1111116;
                function7 = function11111111111114;
                function8 = function11111111111113;
                z4 = z1111117;
                menuItemColors2 = menuItemColors1111115;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                menuItemColors2 = menuItemColorsItemColors;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 100663296;
        i14 = i3;
        if ((i3 & 38347923) != 38347922) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "287@14452L12");
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    function6 = null;
                }
                if (i8 != 0) {
                    z2 = true;
                }
                if ((i2 & 64) != 0) {
                    i15 = i14 & (-3670017);
                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                } else {
                    i15 = i14;
                }
                if (i10 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                if (i12 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                paddingValues3 = dropdownMenuItemContentPadding;
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    function6 = null;
                }
                if (i8 != 0) {
                    z2 = true;
                }
                if ((i2 & 64) != 0) {
                    i15 = i14 & (-3670017);
                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                } else {
                    i15 = i14;
                }
                if (i10 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                if (i12 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                paddingValues3 = dropdownMenuItemContentPadding;
            }
            Function2<? super Composer, ? super Integer, Unit> function11111111111115 = function6;
            boolean z1111118 = z2;
            MenuItemColors menuItemColors1111116 = menuItemColorsItemColors;
            Modifier modifier1111117 = modifier2;
            Function2<? super Composer, ? super Integer, Unit> function11111111111116 = function5;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-532959117, i15, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:272)");
            }
            composer2 = composerStartRestartGroup;
            MenuKt.DropdownMenuItemContent(function2, function0, modifier1111117, function11111111111116, function11111111111115, z1111118, menuItemColors1111116, paddingValues3, mutableInteractionSource3, composer2, i15 & 268435454);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier1111117;
            function7 = function11111111111116;
            function8 = function11111111111115;
            z4 = z1111118;
            menuItemColors2 = menuItemColors1111116;
            paddingValues2 = paddingValues3;
            mutableInteractionSource2 = mutableInteractionSource3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            function7 = function5;
            function8 = function6;
            z4 = z2;
            menuItemColors2 = menuItemColorsItemColors;
            paddingValues2 = paddingValues;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidMenu_androidKt.DropdownMenuItem$lambda$0(function2, function0, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final PopupProperties getDefaultMenuProperties() {
        return DefaultMenuProperties;
    }

    private static final float DropdownMenuPopupContent$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float DropdownMenuPopupContent$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }
}
