package androidx.compose.material;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
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
import org.apache.hc.core5.http.HttpStatus;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\"\u0010\r\u001a\u00020\u0007*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0005H\u0002¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0017X\u008a\u008e\u0002"}, d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "expandable", "Lkotlin/Function0;", "menuLabel", "", "updateHeight", "windowBounds", "Landroidx/compose/ui/unit/IntRect;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "material", "width", "menuHeight"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenu_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$15(boolean z, Function1 function1, Modifier modifier, Function3 function3, int i, int i2, Composer composer, int i3) {
        ExposedDropdownMenuBox(z, function1, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:108:0x030b  */
    /* JADX WARN: Code duplicated, block: B:111:0x0324  */
    /* JADX WARN: Code duplicated, block: B:113:0x032a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0333  */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:32:0x005c  */
    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0074 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:59:0x0131  */
    /* JADX WARN: Code duplicated, block: B:62:0x0150  */
    /* JADX WARN: Code duplicated, block: B:69:0x0185  */
    /* JADX WARN: Code duplicated, block: B:72:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:73:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:76:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:77:0x01be  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:85:0x0233  */
    /* JADX WARN: Code duplicated, block: B:88:0x023f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0243  */
    /* JADX WARN: Code duplicated, block: B:94:0x0276  */
    /* JADX WARN: Code duplicated, block: B:97:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:98:0x02c9  */
    public static final void ExposedDropdownMenuBox(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Density density;
        final WindowBoundsCalculator windowBoundsCalculatorPlatformWindowBoundsCalculator;
        Object objRememberedValue;
        final MutableIntState mutableIntState;
        Object objRememberedValue2;
        final MutableIntState mutableIntState2;
        final int iMo748roundToPx0680j_4;
        Object objRememberedValue3;
        final Ref ref;
        boolean zChanged;
        Object objRememberedValue4;
        Object objRememberedValue5;
        final FocusRequester focusRequester;
        boolean zChangedInstance;
        Object obj;
        final WindowBoundsCalculator windowBoundsCalculator;
        final int i4;
        MutableIntState mutableIntState3;
        boolean z3;
        int i5;
        boolean z4;
        boolean z5;
        Object objRememberedValue6;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        final MutableIntState mutableIntState4;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z6;
        Object objRememberedValue7;
        boolean zChangedInstance2;
        Object objRememberedValue8;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1337700255);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExposedDropdownMenuBox)N(expanded,onExpandedChange,modifier,content)95@4064L7,96@4105L32,97@4155L33,98@4211L33,100@4345L37,103@4408L536,116@4970L29,120@5061L414,132@5536L31,133@5597L38,118@5005L727,140@5749L47,140@5738L58,142@5831L273,142@5802L302:ExposedDropdownMenu.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
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
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1337700255, i3, -1, "androidx.compose.material.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:94)");
                }
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume;
                windowBoundsCalculatorPlatformWindowBoundsCalculator = ExposedDropdownMenu_android.platformWindowBoundsCalculator(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334713342, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableIntState = (MutableIntState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334711550, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableIntState2 = (MutableIntState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                iMo748roundToPx0680j_4 = density.mo748roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334707258, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Ref();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ref = (Ref) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int iExposedDropdownMenuBox$lambda$4 = ExposedDropdownMenuBox$lambda$4(mutableIntState2);
                int iExposedDropdownMenuBox$lambda$1 = ExposedDropdownMenuBox$lambda$1(mutableIntState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334704743, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(iExposedDropdownMenuBox$lambda$4) | composerStartRestartGroup.changed(iExposedDropdownMenuBox$lambda$1);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
                        @Override // androidx.compose.material.ExposedDropdownMenuBoxScope
                        public Modifier exposedDropdownSize(Modifier modifier3, boolean z7) {
                            Density density2 = density;
                            MutableIntState mutableIntState5 = mutableIntState2;
                            MutableIntState mutableIntState6 = mutableIntState;
                            Modifier modifierM1254heightInVpY3zN4$default = SizeKt.m1254heightInVpY3zN4$default(modifier3, 0.0f, density2.mo751toDpu2uoSUM(ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$4(mutableIntState5)), 1, null);
                            return z7 ? SizeKt.m1271width3ABfNKs(modifierM1254heightInVpY3zN4$default, density2.mo751toDpu2uoSUM(ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$1(mutableIntState6))) : modifierM1254heightInVpY3zN4$default;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 = (ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334687266, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                focusRequester = (FocusRequester) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334683969, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(ref) | composerStartRestartGroup.changedInstance(windowBoundsCalculatorPlatformWindowBoundsCalculator) | composerStartRestartGroup.changed(iMo748roundToPx0680j_4);
                Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    obj = new Function1() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$10$0(ref, windowBoundsCalculatorPlatformWindowBoundsCalculator, iMo748roundToPx0680j_4, mutableIntState, mutableIntState2, (LayoutCoordinates) obj2);
                        }
                    };
                    windowBoundsCalculator = windowBoundsCalculatorPlatformWindowBoundsCalculator;
                    i4 = iMo748roundToPx0680j_4;
                    mutableIntState3 = mutableIntState2;
                    composerStartRestartGroup.updateRememberedValue(obj);
                } else {
                    windowBoundsCalculator = windowBoundsCalculatorPlatformWindowBoundsCalculator;
                    mutableIntState3 = mutableIntState2;
                    obj = objRememberedValue9;
                    i4 = iMo748roundToPx0680j_4;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, (Function1) obj);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334669152, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                if ((i3 & 112) == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                i5 = i3 & 14;
                int i8 = i3;
                if (i5 == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                z5 = z4 | z3;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!z5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$11$0(function1, z);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(expandable(modifierOnGloballyPositioned, (Function0) objRememberedValue6, Strings_androidKt.m2581getString4foXLRw(Strings.INSTANCE.m2576getExposedDropdownMenuUdPEhr4(), composerStartRestartGroup, 6)), focusRequester);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                Modifier modifier3 = modifier2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                mutableIntState4 = mutableIntState3;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 527294489, "C137@5717L9:ExposedDropdownMenu.kt#jmzs0o");
                function3.invoke(exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1, composerStartRestartGroup, Integer.valueOf((i8 >> 6) & 112));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334662320, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                if (i5 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!z6 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function0() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$13$0(z, focusRequester);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue7, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334659470, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(windowBoundsCalculator) | composerStartRestartGroup.changedInstance(ref) | composerStartRestartGroup.changed(i4);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new Function0() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$14$0(windowBoundsCalculator, ref, i4, mutableIntState4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ExposedDropdownMenu_android.OnPlatformWindowBoundsChange((Function0) objRememberedValue8, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$15(z, function1, modifier4, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
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
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i7 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1337700255, i3, -1, "androidx.compose.material.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:94)");
            }
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume2;
            windowBoundsCalculatorPlatformWindowBoundsCalculator = ExposedDropdownMenu_android.platformWindowBoundsCalculator(composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334713342, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableIntState = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334711550, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableIntState2 = (MutableIntState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            iMo748roundToPx0680j_4 = density.mo748roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334707258, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Ref();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ref = (Ref) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int iExposedDropdownMenuBox$lambda$5 = ExposedDropdownMenuBox$lambda$4(mutableIntState2);
            int iExposedDropdownMenuBox$lambda$2 = ExposedDropdownMenuBox$lambda$1(mutableIntState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334704743, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(iExposedDropdownMenuBox$lambda$5) | composerStartRestartGroup.changed(iExposedDropdownMenuBox$lambda$2);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue4 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
                    @Override // androidx.compose.material.ExposedDropdownMenuBoxScope
                    public Modifier exposedDropdownSize(Modifier modifier5, boolean z7) {
                        Density density2 = density;
                        MutableIntState mutableIntState5 = mutableIntState2;
                        MutableIntState mutableIntState6 = mutableIntState;
                        Modifier modifierM1254heightInVpY3zN4$default = SizeKt.m1254heightInVpY3zN4$default(modifier5, 0.0f, density2.mo751toDpu2uoSUM(ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$4(mutableIntState5)), 1, null);
                        return z7 ? SizeKt.m1271width3ABfNKs(modifierM1254heightInVpY3zN4$default, density2.mo751toDpu2uoSUM(ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$1(mutableIntState6))) : modifierM1254heightInVpY3zN4$default;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
                    @Override // androidx.compose.material.ExposedDropdownMenuBoxScope
                    public Modifier exposedDropdownSize(Modifier modifier5, boolean z7) {
                        Density density2 = density;
                        MutableIntState mutableIntState5 = mutableIntState2;
                        MutableIntState mutableIntState6 = mutableIntState;
                        Modifier modifierM1254heightInVpY3zN4$default = SizeKt.m1254heightInVpY3zN4$default(modifier5, 0.0f, density2.mo751toDpu2uoSUM(ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$4(mutableIntState5)), 1, null);
                        return z7 ? SizeKt.m1271width3ABfNKs(modifierM1254heightInVpY3zN4$default, density2.mo751toDpu2uoSUM(ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$1(mutableIntState6))) : modifierM1254heightInVpY3zN4$default;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$2 = (ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334687266, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            focusRequester = (FocusRequester) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334683969, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(ref) | composerStartRestartGroup.changedInstance(windowBoundsCalculatorPlatformWindowBoundsCalculator) | composerStartRestartGroup.changed(iMo748roundToPx0680j_4);
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                obj = new Function1() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$10$0(ref, windowBoundsCalculatorPlatformWindowBoundsCalculator, iMo748roundToPx0680j_4, mutableIntState, mutableIntState2, (LayoutCoordinates) obj2);
                    }
                };
                windowBoundsCalculator = windowBoundsCalculatorPlatformWindowBoundsCalculator;
                i4 = iMo748roundToPx0680j_4;
                mutableIntState3 = mutableIntState2;
                composerStartRestartGroup.updateRememberedValue(obj);
            } else {
                obj = new Function1() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$10$0(ref, windowBoundsCalculatorPlatformWindowBoundsCalculator, iMo748roundToPx0680j_4, mutableIntState, mutableIntState2, (LayoutCoordinates) obj2);
                    }
                };
                windowBoundsCalculator = windowBoundsCalculatorPlatformWindowBoundsCalculator;
                i4 = iMo748roundToPx0680j_4;
                mutableIntState3 = mutableIntState2;
                composerStartRestartGroup.updateRememberedValue(obj);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, (Function1) obj);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334669152, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            if ((i3 & 112) == 32) {
                z3 = true;
            } else {
                z3 = false;
            }
            i5 = i3 & 14;
            int i9 = i3;
            if (i5 == 4) {
                z4 = true;
            } else {
                z4 = false;
            }
            z5 = z4 | z3;
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue6 = new Function0() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$11$0(function1, z);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function0() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$11$0(function1, z);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFocusRequester2 = FocusRequesterModifierKt.focusRequester(expandable(modifierOnGloballyPositioned2, (Function0) objRememberedValue6, Strings_androidKt.m2581getString4foXLRw(Strings.INSTANCE.m2576getExposedDropdownMenuUdPEhr4(), composerStartRestartGroup, 6)), focusRequester);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            Modifier modifier5 = modifier2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            mutableIntState4 = mutableIntState3;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 527294489, "C137@5717L9:ExposedDropdownMenu.kt#jmzs0o");
            function3.invoke(exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$2, composerStartRestartGroup, Integer.valueOf((i9 >> 6) & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334662320, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            if (i5 == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue7 = new Function0() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$13$0(z, focusRequester);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new Function0() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$13$0(z, focusRequester);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue7, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1334659470, "CC(remember):ExposedDropdownMenu.kt#9igjgp");
            zChangedInstance2 = composerStartRestartGroup.changedInstance(windowBoundsCalculator) | composerStartRestartGroup.changedInstance(ref) | composerStartRestartGroup.changed(i4);
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue8 = new Function0() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$14$0(windowBoundsCalculator, ref, i4, mutableIntState4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new Function0() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$14$0(windowBoundsCalculator, ref, i4, mutableIntState4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ExposedDropdownMenu_android.OnPlatformWindowBoundsChange((Function0) objRememberedValue8, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$15(z, function1, modifier6, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$1(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$4(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$10$0(Ref ref, WindowBoundsCalculator windowBoundsCalculator, int i, MutableIntState mutableIntState, final MutableIntState mutableIntState2, LayoutCoordinates layoutCoordinates) {
        mutableIntState.setIntValue((int) (layoutCoordinates.mo8273getSizeYbymL2g() >> 32));
        ref.setValue(layoutCoordinates);
        updateHeight(windowBoundsCalculator.getVisibleWindowBounds(), (LayoutCoordinates) ref.getValue(), i, new Function1() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$10$0$0(mutableIntState2, ((Integer) obj).intValue());
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$10$0$0(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$11$0(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$13$0(boolean z, FocusRequester focusRequester) {
        if (z) {
            FocusRequester.m6474requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$14$0(WindowBoundsCalculator windowBoundsCalculator, Ref ref, int i, final MutableIntState mutableIntState) {
        updateHeight(windowBoundsCalculator.getVisibleWindowBounds(), (LayoutCoordinates) ref.getValue(), i, new Function1() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$14$0$0(mutableIntState, ((Integer) obj).intValue());
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuBox$lambda$14$0$0(MutableIntState mutableIntState, int i) {
        mutableIntState.setIntValue(i);
        return Unit.INSTANCE;
    }

    private static final Modifier expandable(Modifier modifier, final Function0<Unit> function0, final String str) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput(modifier, function0, new PointerInputEventHandler() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt.expandable.1

            /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenu_androidKt$expandable$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material.ExposedDropdownMenu_androidKt$expandable$1$1", f = "ExposedDropdownMenu.kt", i = {0}, l = {450, HttpStatus.SC_UNAVAILABLE_FOR_LEGAL_REASONS}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"}, v = 1)
            static final class C00491 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function0<Unit> $onExpandedChange;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00491(Function0<Unit> function0, Continuation<? super C00491> continuation) {
                    super(2, continuation);
                    this.$onExpandedChange = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00491 c00491 = new C00491(this.$onExpandedChange, continuation);
                    c00491.L$0 = obj;
                    return c00491;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C00491) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
                
                    if (r11 == r0) goto L16;
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
                        if (r1 == 0) goto L22
                        if (r1 == r3) goto L1a
                        if (r1 != r2) goto L12
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L4f
                    L12:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L1a:
                        java.lang.Object r1 = r10.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L3e
                    L22:
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
                        if (r11 != r0) goto L3d
                        goto L4e
                    L3d:
                        r1 = r4
                    L3e:
                        androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r3 = r10
                        kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                        r4 = 0
                        r10.L$0 = r4
                        r10.label = r2
                        java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(r1, r11, r3)
                        if (r11 != r0) goto L4f
                    L4e:
                        return r0
                    L4f:
                        androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                        if (r11 == 0) goto L58
                        kotlin.jvm.functions.Function0<kotlin.Unit> r10 = r10.$onExpandedChange
                        r10.invoke()
                    L58:
                        kotlin.Unit r10 = kotlin.Unit.INSTANCE
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenu_androidKt.AnonymousClass1.C00491.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C00491(function0, null), continuation);
                return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
            }
        }), false, new Function1() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExposedDropdownMenu_androidKt.expandable$lambda$0(str, function0, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit expandable$lambda$0(String str, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ExposedDropdownMenu_androidKt.expandable$lambda$0$0(function0));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean expandable$lambda$0$0(Function0 function0) {
        function0.invoke();
        return true;
    }

    private static final void updateHeight(IntRect intRect, LayoutCoordinates layoutCoordinates, int i, Function1<? super Integer, Unit> function1) {
        if (layoutCoordinates == null) {
            return;
        }
        function1.invoke(Integer.valueOf(((int) Math.max(LayoutCoordinatesKt.boundsInWindow(layoutCoordinates, true).getTop() - intRect.getTop(), (intRect.getBottom() - intRect.getTop()) - LayoutCoordinatesKt.boundsInWindow(layoutCoordinates, true).getBottom())) - i));
    }
}
