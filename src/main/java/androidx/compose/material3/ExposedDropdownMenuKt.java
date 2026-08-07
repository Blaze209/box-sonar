package androidx.compose.material3;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u0003*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001aa\u0010\u001b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b&\u0010'\u001a\"\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020/H\u0002\u001a\u000e\u00105\u001a\u000203*\u0004\u0018\u000106H\u0002\"\u0018\u0010(\u001a\u00020\u0003*\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0018\u0010,\u001a\u00020\u0003*\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010+\"\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109*8\b\u0007\u0010\u0012\"\u00020\u000e2\u00020\u000eB*\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u001c\b\u0016\u0012\u0018\b\u000bB\u0014\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0006\b\u001a\u0012\u0002\b\f¨\u0006:²\u0006\f\u0010;\u001a\u0004\u0018\u000106X\u008a\u008e\u0002²\u0006\n\u0010<\u001a\u00020/X\u008a\u008e\u0002²\u0006\n\u0010=\u001a\u00020/X\u008a\u008e\u0002"}, d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "hasGreaterOrEqualPriorityThan", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "that", "hasGreaterOrEqualPriorityThan-vVDBVkM", "(Ljava/lang/String;Ljava/lang/String;)Z", "MenuAnchorType", "Lkotlin/Deprecated;", "message", "Renamed to ExposedDropdownMenuAnchorType", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "ExposedDropdownMenuAnchorType", "imports", "expandable", "Lkotlin/Function0;", "anchorType", "alwaysFocusable", "Landroidx/compose/runtime/MutableState;", "expandedDescription", "", "collapsedDescription", "toggleDescription", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "expandable-3-2CpT8", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/MutableState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Landroidx/compose/ui/Modifier;", "isClick", "Landroidx/compose/ui/input/key/KeyEvent;", "isClick-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isEnterMinusSpacebar", "isEnterMinusSpacebar-ZmokQxo", "calculateMaxHeight", "", "windowBounds", "Landroidx/compose/ui/unit/IntRect;", "anchorBounds", "Landroidx/compose/ui/geometry/Rect;", "verticalMargin", "getAnchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "material3", "anchorCoordinates", "anchorWidth", "menuMaxHeight"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuKt {
    private static final float ExposedDropdownMenuItemHorizontalPadding = Dp.m9687constructorimpl(16);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$19(boolean z, Function1 function1, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        ExposedDropdownMenuBox(z, function1, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Renamed to ExposedDropdownMenuAnchorType", replaceWith = @ReplaceWith(expression = "ExposedDropdownMenuAnchorType", imports = {}))
    public static /* synthetic */ void MenuAnchorType$annotations() {
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0304  */
    /* JADX WARN: Code duplicated, block: B:103:0x0350  */
    /* JADX WARN: Code duplicated, block: B:107:0x0378  */
    /* JADX WARN: Code duplicated, block: B:109:0x038a  */
    /* JADX WARN: Code duplicated, block: B:112:0x039e  */
    /* JADX WARN: Code duplicated, block: B:113:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:118:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:122:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:127:0x03de  */
    /* JADX WARN: Code duplicated, block: B:130:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:132:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:135:0x0406  */
    /* JADX WARN: Code duplicated, block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0057  */
    /* JADX WARN: Code duplicated, block: B:32:0x005d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:43:0x007f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:55:0x0106  */
    /* JADX WARN: Code duplicated, block: B:58:0x0124  */
    /* JADX WARN: Code duplicated, block: B:61:0x017e  */
    /* JADX WARN: Code duplicated, block: B:62:0x0195  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:66:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:69:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:73:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:74:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:81:0x0215  */
    /* JADX WARN: Code duplicated, block: B:88:0x0261  */
    /* JADX WARN: Code duplicated, block: B:91:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:94:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:95:0x02d1  */
    public static final void ExposedDropdownMenuBox(boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z2;
        final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function4;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        WindowBoundsCalculator windowBoundsCalculatorPlatformWindowBoundsCalculator;
        final int iMo748roundToPx0680j_4;
        Object objRememberedValue;
        final MutableState mutableState;
        Object objRememberedValue2;
        MutableIntState mutableIntState;
        Object objRememberedValue3;
        final MutableIntState mutableIntState2;
        Object objRememberedValue4;
        FocusRequester focusRequester;
        SoftwareKeyboardController softwareKeyboardController;
        String strM5086getString2EP1pXo;
        String strM5086getString2EP1pXo2;
        String strM5086getString2EP1pXo3;
        Object objRememberedValue5;
        MutableState mutableState2;
        Object objRememberedValue6;
        boolean z3;
        MutableState mutableState3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        boolean zChanged;
        Object objRememberedValue7;
        MutableIntState mutableIntState3;
        final WindowBoundsCalculator windowBoundsCalculator;
        final FocusRequester focusRequester2;
        boolean zChangedInstance;
        Object objRememberedValue8;
        final MutableIntState mutableIntState4;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z6;
        Object objRememberedValue9;
        boolean z7;
        Object objRememberedValue10;
        boolean zChangedInstance2;
        Object objRememberedValue11;
        int i6;
        final boolean z8 = z;
        Composer composerStartRestartGroup = composer.startRestartGroup(1597265892);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExposedDropdownMenuBox)N(expanded,onExpandedChange,modifier,content)142@6635L32,143@6699L7,147@6812L53,148@6889L33,149@6948L33,151@7008L29,152@7099L7,153@7137L31,154@7200L32,155@7261L37,156@7325L89,159@7441L34,162@7501L2786,217@10336L377,216@10293L458,242@11135L47,242@11124L58,246@11347L27,246@11315L59:ExposedDropdownMenu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z8) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 1171) != 1170) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                function4 = function3;
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1597265892, i3, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:141)");
                }
                windowBoundsCalculatorPlatformWindowBoundsCalculator = ExposedDropdownMenu_androidKt.platformWindowBoundsCalculator(composerStartRestartGroup, 0);
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density = (Density) objConsume;
                iMo748roundToPx0680j_4 = density.mo748roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669210585, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669213029, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableIntState = (MutableIntState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669214917, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableIntState2 = (MutableIntState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669216833, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                focusRequester = (FocusRequester) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localSoftwareKeyboardController);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                softwareKeyboardController = (SoftwareKeyboardController) objConsume2;
                Strings.Companion companion2 = Strings.INSTANCE;
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_dropdown_menu_expanded), composerStartRestartGroup, 0);
                Strings.Companion companion3 = Strings.INSTANCE;
                strM5086getString2EP1pXo2 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_dropdown_menu_collapsed), composerStartRestartGroup, 0);
                Strings.Companion companion4 = Strings.INSTANCE;
                strM5086getString2EP1pXo3 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_dropdown_menu_toggle), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669227037, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ExposedDropdownMenuAnchorType.m3315boximpl(ExposedDropdownMenuAnchorType.INSTANCE.m3323getPrimaryNotEditableoYjWRB4()), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                    objRememberedValue5 = mutableStateMutableStateOf$default;
                }
                mutableState2 = (MutableState) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669230694, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    z3 = false;
                    objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    z3 = false;
                }
                mutableState3 = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669235366, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                i4 = i3 & 14;
                if (i4 == 4) {
                    z4 = true;
                } else {
                    z4 = z3;
                }
                i5 = i3 & 112;
                if (i5 == 32) {
                    z5 = true;
                } else {
                    z5 = z3;
                }
                zChanged = z4 | z5 | composerStartRestartGroup.changed(windowBoundsCalculatorPlatformWindowBoundsCalculator) | composerStartRestartGroup.changed(density);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    mutableIntState3 = mutableIntState;
                    windowBoundsCalculator = windowBoundsCalculatorPlatformWindowBoundsCalculator;
                    ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 = new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(focusRequester, z, mutableState3, strM5086getString2EP1pXo, strM5086getString2EP1pXo2, strM5086getString2EP1pXo3, softwareKeyboardController, mutableState2, function1, mutableIntState3, mutableIntState2);
                    focusRequester2 = focusRequester;
                    z8 = z;
                    composerStartRestartGroup.updateRememberedValue(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1);
                    objRememberedValue7 = exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1;
                } else {
                    z8 = z;
                    focusRequester2 = focusRequester;
                    mutableIntState3 = mutableIntState;
                    windowBoundsCalculator = windowBoundsCalculatorPlatformWindowBoundsCalculator;
                }
                ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$2 = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669323677, r5);
                zChangedInstance = composerStartRestartGroup.changedInstance(windowBoundsCalculator) | composerStartRestartGroup.changed(iMo748roundToPx0680j_4);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    final MutableIntState mutableIntState5 = mutableIntState3;
                    final WindowBoundsCalculator windowBoundsCalculator2 = windowBoundsCalculator;
                    objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$14$0(windowBoundsCalculator2, iMo748roundToPx0680j_4, mutableState, mutableIntState5, mutableIntState2, (LayoutCoordinates) obj);
                        }
                    };
                    mutableIntState4 = mutableIntState2;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    mutableIntState4 = mutableIntState2;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) objRememberedValue8);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnGloballyPositioned);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2140542826, "C228@10736L9:ExposedDropdownMenu.kt#uh7d8r");
                function4 = function3;
                function4.invoke(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$2, composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 112));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z8) {
                    composerStartRestartGroup.startReplaceGroup(209857027);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "232@10810L302,232@10781L331");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669338770, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(windowBoundsCalculator) | composerStartRestartGroup.changed(iMo748roundToPx0680j_4);
                    objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue11 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$16$0(windowBoundsCalculator, iMo748roundToPx0680j_4, mutableState, mutableIntState4);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) objRememberedValue11, composerStartRestartGroup, 0);
                } else {
                    composerStartRestartGroup.startReplaceGroup(199160446);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669348915, r5);
                if (i4 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (!z6 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue9 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$17$0(z8, focusRequester2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue9, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669355679, r5);
                z7 = i5 == 32;
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (!z7 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue10 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$18$0(function1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BackHandler_androidKt.BackHandler(z8, (Function0) objRememberedValue10, composerStartRestartGroup, i4, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$19(z8, function1, modifier3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i3 & 1171) != 1170) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            function4 = function3;
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i7 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1597265892, i3, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:141)");
            }
            windowBoundsCalculatorPlatformWindowBoundsCalculator = ExposedDropdownMenu_androidKt.platformWindowBoundsCalculator(composerStartRestartGroup, 0);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density2 = (Density) objConsume3;
            iMo748roundToPx0680j_4 = density2.mo748roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669210585, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669213029, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableIntState = (MutableIntState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669214917, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableIntState2 = (MutableIntState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669216833, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            focusRequester = (FocusRequester) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController2 = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localSoftwareKeyboardController2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            softwareKeyboardController = (SoftwareKeyboardController) objConsume4;
            Strings.Companion companion5 = Strings.INSTANCE;
            strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_dropdown_menu_expanded), composerStartRestartGroup, 0);
            Strings.Companion companion6 = Strings.INSTANCE;
            strM5086getString2EP1pXo2 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_dropdown_menu_collapsed), composerStartRestartGroup, 0);
            Strings.Companion companion7 = Strings.INSTANCE;
            strM5086getString2EP1pXo3 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_dropdown_menu_toggle), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669227037, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                MutableState mutableStateMutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ExposedDropdownMenuAnchorType.m3315boximpl(ExposedDropdownMenuAnchorType.INSTANCE.m3323getPrimaryNotEditableoYjWRB4()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default2);
                objRememberedValue5 = mutableStateMutableStateOf$default2;
            }
            mutableState2 = (MutableState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669230694, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                z3 = false;
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                z3 = false;
            }
            mutableState3 = (MutableState) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669235366, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            i4 = i3 & 14;
            if (i4 == 4) {
                z4 = true;
            } else {
                z4 = z3;
            }
            i5 = i3 & 112;
            if (i5 == 32) {
                z5 = true;
            } else {
                z5 = z3;
            }
            zChanged = z4 | z5 | composerStartRestartGroup.changed(windowBoundsCalculatorPlatformWindowBoundsCalculator) | composerStartRestartGroup.changed(density2);
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                mutableIntState3 = mutableIntState;
                windowBoundsCalculator = windowBoundsCalculatorPlatformWindowBoundsCalculator;
                ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$3 = new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(focusRequester, z, mutableState3, strM5086getString2EP1pXo, strM5086getString2EP1pXo2, strM5086getString2EP1pXo3, softwareKeyboardController, mutableState2, function1, mutableIntState3, mutableIntState2);
                focusRequester2 = focusRequester;
                z8 = z;
                composerStartRestartGroup.updateRememberedValue(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$3);
                objRememberedValue7 = exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$3;
            } else {
                mutableIntState3 = mutableIntState;
                windowBoundsCalculator = windowBoundsCalculatorPlatformWindowBoundsCalculator;
                ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$4 = new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(focusRequester, z, mutableState3, strM5086getString2EP1pXo, strM5086getString2EP1pXo2, strM5086getString2EP1pXo3, softwareKeyboardController, mutableState2, function1, mutableIntState3, mutableIntState2);
                focusRequester2 = focusRequester;
                z8 = z;
                composerStartRestartGroup.updateRememberedValue(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$4);
                objRememberedValue7 = exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$4;
            }
            ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$5 = (ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669323677, r5);
            zChangedInstance = composerStartRestartGroup.changedInstance(windowBoundsCalculator) | composerStartRestartGroup.changed(iMo748roundToPx0680j_4);
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                final MutableIntState mutableIntState6 = mutableIntState3;
                final WindowBoundsCalculator windowBoundsCalculator3 = windowBoundsCalculator;
                objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$14$0(windowBoundsCalculator3, iMo748roundToPx0680j_4, mutableState, mutableIntState6, mutableIntState2, (LayoutCoordinates) obj);
                    }
                };
                mutableIntState4 = mutableIntState2;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            } else {
                final MutableIntState mutableIntState7 = mutableIntState3;
                final WindowBoundsCalculator windowBoundsCalculator4 = windowBoundsCalculator;
                objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$14$0(windowBoundsCalculator4, iMo748roundToPx0680j_4, mutableState, mutableIntState7, mutableIntState2, (LayoutCoordinates) obj);
                    }
                };
                mutableIntState4 = mutableIntState2;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) objRememberedValue8);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnGloballyPositioned2);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2140542826, "C228@10736L9:ExposedDropdownMenu.kt#uh7d8r");
            function4 = function3;
            function4.invoke(exposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$5, composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (z8) {
                composerStartRestartGroup.startReplaceGroup(209857027);
                ComposerKt.sourceInformation(composerStartRestartGroup, "232@10810L302,232@10781L331");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669338770, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(windowBoundsCalculator) | composerStartRestartGroup.changed(iMo748roundToPx0680j_4);
                objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue11 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$16$0(windowBoundsCalculator, iMo748roundToPx0680j_4, mutableState, mutableIntState4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$16$0(windowBoundsCalculator, iMo748roundToPx0680j_4, mutableState, mutableIntState4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange((Function0) objRememberedValue11, composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(199160446);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669348915, r5);
            if (i4 == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue9 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$17$0(z8, focusRequester2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$17$0(z8, focusRequester2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue9, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1669355679, r5);
            if (i5 == 32) {
            }
            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (!z7) {
                objRememberedValue10 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$18$0(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            } else {
                objRememberedValue10 = new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$18$0(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackHandler_androidKt.BackHandler(z8, (Function0) objRememberedValue10, composerStartRestartGroup, i4, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExposedDropdownMenuKt.ExposedDropdownMenuBox$lambda$19(z8, function1, modifier3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final LayoutCoordinates ExposedDropdownMenuBox$lambda$2(MutableState<LayoutCoordinates> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$5(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$8(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$14$0(WindowBoundsCalculator windowBoundsCalculator, int i, MutableState mutableState, MutableIntState mutableIntState, MutableIntState mutableIntState2, LayoutCoordinates layoutCoordinates) {
        mutableState.setValue(layoutCoordinates);
        mutableIntState.setIntValue((int) (layoutCoordinates.mo8273getSizeYbymL2g() >> 32));
        mutableIntState2.setIntValue(calculateMaxHeight(windowBoundsCalculator.getVisibleWindowBounds(), getAnchorBounds(ExposedDropdownMenuBox$lambda$2(mutableState)), i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$16$0(WindowBoundsCalculator windowBoundsCalculator, int i, MutableState mutableState, MutableIntState mutableIntState) {
        mutableIntState.setIntValue(calculateMaxHeight(windowBoundsCalculator.getVisibleWindowBounds(), getAnchorBounds(ExposedDropdownMenuBox$lambda$2(mutableState)), i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$17$0(boolean z, FocusRequester focusRequester) {
        if (z) {
            FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$18$0(Function1 function1) {
        function1.invoke(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hasGreaterOrEqualPriorityThan-vVDBVkM, reason: not valid java name */
    public static final boolean m3345hasGreaterOrEqualPriorityThanvVDBVkM(String str, String str2) {
        if (ExposedDropdownMenuAnchorType.m3318equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m3323getPrimaryNotEditableoYjWRB4()) || ExposedDropdownMenuAnchorType.m3318equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m3322getPrimaryEditableoYjWRB4())) {
            return true;
        }
        if (ExposedDropdownMenuAnchorType.m3318equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m3324getSecondaryEditableoYjWRB4())) {
            return ExposedDropdownMenuAnchorType.m3318equalsimpl0(str2, ExposedDropdownMenuAnchorType.INSTANCE.m3324getSecondaryEditableoYjWRB4());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: expandable-3-2CpT8, reason: not valid java name */
    public static final Modifier m3344expandable32CpT8(Modifier modifier, final boolean z, final Function0<Unit> function0, final String str, final MutableState<Boolean> mutableState, final String str2, final String str3, final String str4, final SoftwareKeyboardController softwareKeyboardController) {
        return SemanticsModifierKt.semantics$default(KeyInputModifierKt.onPreviewKeyEvent(SuspendingPointerInputFilterKt.pointerInput(modifier, function0, new PointerInputEventHandler() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$expandable$1

            /* JADX INFO: renamed from: androidx.compose.material3.ExposedDropdownMenuKt$expandable$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.ExposedDropdownMenuKt$expandable$1$1", f = "ExposedDropdownMenu.kt", i = {0}, l = {1421, 1425}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"}, v = 1)
            static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: $$v$c$androidx-compose-material3-ExposedDropdownMenuAnchorType$-anchorType$0, reason: not valid java name */
                final /* synthetic */ String f112xce14d612;
                final /* synthetic */ Function0<Unit> $onExpandedChange;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(String str, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.f112xce14d612 = str;
                    this.$onExpandedChange = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f112xce14d612, this.$onExpandedChange, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
                
                    if (r11 == r0) goto L19;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                    /*
                        r10 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r10.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L23
                        if (r1 == r3) goto L1b
                        if (r1 != r2) goto L12
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L63
                    L12:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L1b:
                        java.lang.Object r1 = r10.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L3f
                    L23:
                        kotlin.ResultKt.throwOnFailure(r11)
                        java.lang.Object r11 = r10.L$0
                        r4 = r11
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                        androidx.compose.ui.input.pointer.PointerEventPass r6 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r7 = r10
                        kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                        r10.L$0 = r4
                        r10.label = r3
                        r5 = 0
                        r8 = 1
                        r9 = 0
                        java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r4, r5, r6, r7, r8, r9)
                        if (r11 != r0) goto L3e
                        goto L62
                    L3e:
                        r1 = r4
                    L3f:
                        androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                        java.lang.String r3 = r10.f112xce14d612
                        androidx.compose.material3.ExposedDropdownMenuAnchorType$Companion r4 = androidx.compose.material3.ExposedDropdownMenuAnchorType.INSTANCE
                        java.lang.String r4 = r4.m3324getSecondaryEditableoYjWRB4()
                        boolean r3 = androidx.compose.material3.ExposedDropdownMenuAnchorType.m3318equalsimpl0(r3, r4)
                        if (r3 == 0) goto L52
                        r11.consume()
                    L52:
                        androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r3 = r10
                        kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                        r4 = 0
                        r10.L$0 = r4
                        r10.label = r2
                        java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(r1, r11, r3)
                        if (r11 != r0) goto L63
                    L62:
                        return r0
                    L63:
                        androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                        if (r11 == 0) goto L6c
                        kotlin.jvm.functions.Function0<kotlin.Unit> r10 = r10.$onExpandedChange
                        r10.invoke()
                    L6c:
                        kotlin.Unit r10 = kotlin.Unit.INSTANCE
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuKt$expandable$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass1(str, function0, null), continuation);
                return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
            }
        }), new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$expandable$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m3348invokeZmokQxo(keyEvent.m7966unboximpl());
            }

            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m3348invokeZmokQxo(android.view.KeyEvent keyEvent) {
                if (ExposedDropdownMenuKt.m3346isClickZmokQxo(keyEvent)) {
                    if (ExposedDropdownMenuAnchorType.m3318equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m3322getPrimaryEditableoYjWRB4())) {
                        if (ExposedDropdownMenuKt.m3347isEnterMinusSpacebarZmokQxo(keyEvent)) {
                            function0.invoke();
                            return true;
                        }
                    } else {
                        function0.invoke();
                    }
                }
                if (ExposedDropdownMenuAnchorType.m3318equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m3322getPrimaryEditableoYjWRB4()) && z && (Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7905getTabEK5gGoQ()) || Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7742getDirectionDownEK5gGoQ()) || Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7747getDirectionUpEK5gGoQ()))) {
                    mutableState.setValue(true);
                    return true;
                }
                mutableState.setValue(false);
                return false;
            }
        }), false, new Function1() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExposedDropdownMenuKt.expandable_3_2CpT8$lambda$0(str, z, str2, str3, str4, function0, softwareKeyboardController, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit expandable_3_2CpT8$lambda$0(final String str, boolean z, String str2, String str3, String str4, final Function0 function0, final SoftwareKeyboardController softwareKeyboardController, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (ExposedDropdownMenuAnchorType.m3318equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m3324getSecondaryEditableoYjWRB4())) {
            SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8832getButtono7Vup1c());
            if (!z) {
                str2 = str3;
            }
            SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str2);
            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str4);
        } else {
            SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8835getDropdownListo7Vup1c());
        }
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.ExposedDropdownMenuKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ExposedDropdownMenuKt.expandable_3_2CpT8$lambda$0$0(function0, str, softwareKeyboardController));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean expandable_3_2CpT8$lambda$0$0(Function0 function0, String str, SoftwareKeyboardController softwareKeyboardController) {
        function0.invoke();
        if (!ExposedDropdownMenuAnchorType.m3318equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m3322getPrimaryEditableoYjWRB4()) || softwareKeyboardController == null) {
            return true;
        }
        softwareKeyboardController.show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isClick-ZmokQxo, reason: not valid java name */
    public static final boolean m3346isClickZmokQxo(android.view.KeyEvent keyEvent) {
        if (KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY())) {
            return m3347isEnterMinusSpacebarZmokQxo(keyEvent) || Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7893getSpacebarEK5gGoQ());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isEnterMinusSpacebar-ZmokQxo, reason: not valid java name */
    public static final boolean m3347isEnterMinusSpacebarZmokQxo(android.view.KeyEvent keyEvent) {
        long jM7977getKeyZmokQxo = KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent);
        return Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7741getDirectionCenterEK5gGoQ()) || Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7755getEnterEK5gGoQ()) || Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7847getNumPadEnterEK5gGoQ());
    }

    private static final int calculateMaxHeight(IntRect intRect, Rect rect, int i) {
        if (rect == null) {
            return 0;
        }
        int top = intRect.getTop() + i;
        int bottom = intRect.getBottom() - i;
        return Math.max((rect.getTop() > ((float) intRect.getBottom()) || rect.getBottom() < ((float) intRect.getTop())) ? bottom - top : MathKt.roundToInt(Math.max(rect.getTop() - top, bottom - rect.getBottom())), 0);
    }

    private static final Rect getAnchorBounds(LayoutCoordinates layoutCoordinates) {
        return (layoutCoordinates == null || !layoutCoordinates.isAttached()) ? Rect.INSTANCE.getZero() : RectKt.m6609Recttz77jQw(LayoutCoordinatesKt.positionInWindow(layoutCoordinates), IntSizeKt.m9870toSizeozmzZPI(layoutCoordinates.mo8273getSizeYbymL2g()));
    }
}
