package com.box.android.browse.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxColorPalette;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import com.box.android.boxai.multidoc.BoxAiMultidocStatus;
import com.box.android.boxai.ui.BoxAITheme;
import com.box.android.browse.R;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiTopBarButton.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"BoxAiTopBarButton", "", "state", "Lcom/box/android/boxai/multidoc/BoxAiMultidocStatus;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/boxai/multidoc/BoxAiMultidocStatus;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "BoxAiTopBarButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiTopBarButtonKt {

    /* JADX INFO: compiled from: BoxAiTopBarButton.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BoxAiMultidocStatus.values().length];
            try {
                iArr[BoxAiMultidocStatus.AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BoxAiMultidocStatus.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BoxAiMultidocStatus.ACTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BoxAiMultidocStatus.UNAVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BoxAiMultidocStatus.DISABLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTopBarButton$lambda$0(BoxAiMultidocStatus boxAiMultidocStatus, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BoxAiTopBarButton(boxAiMultidocStatus, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTopBarButton$lambda$3(BoxAiMultidocStatus boxAiMultidocStatus, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BoxAiTopBarButton(boxAiMultidocStatus, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTopBarButtonPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiTopBarButtonPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x035d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0368  */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x006e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0070  */
    /* JADX WARN: Code duplicated, block: B:34:0x0079 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x007b  */
    /* JADX WARN: Code duplicated, block: B:36:0x0080  */
    /* JADX WARN: Code duplicated, block: B:39:0x0087  */
    /* JADX WARN: Code duplicated, block: B:59:0x016b  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:64:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:74:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:75:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:78:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:80:0x0203  */
    /* JADX WARN: Code duplicated, block: B:83:0x025a  */
    /* JADX WARN: Code duplicated, block: B:86:0x0266  */
    /* JADX WARN: Code duplicated, block: B:87:0x026a  */
    /* JADX WARN: Code duplicated, block: B:90:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:91:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:93:0x0326  */
    /* JADX WARN: Code duplicated, block: B:94:0x032d  */
    /* JADX WARN: Code duplicated, block: B:98:0x0357  */
    public static final void BoxAiTopBarButton(final BoxAiMultidocStatus boxAiMultidocStatus, final Function0<Unit> onClick, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        final Modifier.Companion companion;
        int i5;
        SolidColor solidColorM6763linearGradientmHitzGk$default;
        Brush brush;
        float f;
        boolean z2;
        boolean z3;
        Object objRememberedValue;
        Function0<ComposeUiNode> constructor;
        long jM6850getUnspecified0d7_KjU;
        final BoxAiMultidocStatus state = boxAiMultidocStatus;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2138431940);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiTopBarButton)N(state,onClick,modifier)63@2653L61,53@2235L1293:BoxAiTopBarButton.kt#9mvyw3");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(state.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i3;
            if ((i4 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2138431940, i4, -1, "com.box.android.browse.compose.BoxAiTopBarButton (BoxAiTopBarButton.kt:36)");
                }
                i5 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i5 == 1 && i5 != 2) {
                    if (i5 == 3) {
                        composerStartRestartGroup.startReplaceGroup(1224292269);
                        composerStartRestartGroup.endReplaceGroup();
                        solidColorM6763linearGradientmHitzGk$default = Brush.Companion.m6763linearGradientmHitzGk$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m6804boximpl(ColorKt.Color(4294837212L)), Color.m6804boximpl(ColorKt.Color(4280780026L))}), Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) << 32) | (((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) & 4294967295L)), 0, 8, (Object) null);
                    } else if (i5 == 4) {
                        state = state;
                        companion = companion;
                        composerStartRestartGroup.startReplaceGroup(-2038707464);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "49@2138L6");
                        SolidColor solidColor = new SolidColor(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, BoxAITheme.$stable).m12048getAccentButtonDisabledBackground0d7_KjU(), null);
                        composerStartRestartGroup.endReplaceGroup();
                        brush = solidColor;
                        i4 = i4;
                        Modifier modifierClip = ClipKt.clip(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(44)), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)));
                        if (state != BoxAiMultidocStatus.UNAVAILABLE) {
                            f = 1.0f;
                        } else {
                            f = 0.3f;
                        }
                        Modifier modifierBackground$default = BackgroundKt.background$default(AlphaKt.alpha(modifierClip, f), brush, null, 0.0f, 6, null);
                        if (state != BoxAiMultidocStatus.AVAILABLE || state == BoxAiMultidocStatus.ACTIVE) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        Modifier modifier4 = companion;
                        Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(modifierBackground$default, z2, null, null, null, onClick, 14, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2038690279, "CC(remember):BoxAiTopBarButton.kt#9igjgp");
                        if ((i4 & 14) == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.browse.compose.BoxAiTopBarButtonKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiTopBarButtonKt.BoxAiTopBarButton$lambda$1$0(boxAiMultidocStatus, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierTestTag = TestTagKt.testTag(SemanticsModifierKt.semantics$default(modifierM632clickableoSLSa3U$default, false, (Function1) objRememberedValue, 1, null), "BoxAIButton");
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1712546823, "C:BoxAiTopBarButton.kt#9mvyw3");
                        if (boxAiMultidocStatus == BoxAiMultidocStatus.LOADING) {
                            composerStartRestartGroup.startReplaceGroup(1712576737);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "70@2868L307");
                            BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(TestTagKt.testTag(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), "BoxAIButton:ProgressIndicator"), null, BoxColorPalette.INSTANCE.m11395getPURPLE_RAIN_1100d7_KjU(), 0L, Dp.m9687constructorimpl(3), StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), null, composerStartRestartGroup, 24582, 74);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1712924185);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "81@3286L42,82@3367L31,79@3205L307");
                            Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24));
                            Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.ic_box_ai, composerStartRestartGroup, 0);
                            String strStringResource = StringResources_androidKt.stringResource(R.string.box_ai, composerStartRestartGroup, 0);
                            if (boxAiMultidocStatus == BoxAiMultidocStatus.ACTIVE) {
                                jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                            } else {
                                jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                            }
                            IconKt.m3575Iconww6aTOc(painterPainterResource, strStringResource, modifierM1266size3ABfNKs, jM6850getUnspecified0d7_KjU, composerStartRestartGroup, Painter.$stable | 384, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                    } else {
                        if (i5 != 5) {
                            composerStartRestartGroup.startReplaceGroup(-2038722259);
                            composerStartRestartGroup.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composerStartRestartGroup.startReplaceGroup(1224677568);
                        composerStartRestartGroup.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        } else {
                            function2 = new Function2() { // from class: com.box.android.browse.compose.BoxAiTopBarButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxAiTopBarButtonKt.BoxAiTopBarButton$lambda$0(state, onClick, companion, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                        }
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(function2);
                }
                composerStartRestartGroup.startReplaceGroup(-2038719824);
                ComposerKt.sourceInformation(composerStartRestartGroup, "39@1752L6");
                SolidColor solidColor2 = new SolidColor(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, BoxAITheme.$stable).m12047getAccentButtonBackground0d7_KjU(), null);
                composerStartRestartGroup.endReplaceGroup();
                solidColorM6763linearGradientmHitzGk$default = solidColor2;
                brush = solidColorM6763linearGradientmHitzGk$default;
                Modifier modifierClip2 = ClipKt.clip(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(44)), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)));
                if (state != BoxAiMultidocStatus.UNAVAILABLE) {
                    f = 1.0f;
                } else {
                    f = 0.3f;
                }
                Modifier modifierBackground$default2 = BackgroundKt.background$default(AlphaKt.alpha(modifierClip2, f), brush, null, 0.0f, 6, null);
                if (state != BoxAiMultidocStatus.AVAILABLE) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                Modifier modifier5 = companion;
                Modifier modifierM632clickableoSLSa3U$default2 = ClickableKt.m632clickableoSLSa3U$default(modifierBackground$default2, z2, null, null, null, onClick, 14, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2038690279, "CC(remember):BoxAiTopBarButton.kt#9igjgp");
                if ((i4 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.compose.BoxAiTopBarButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiTopBarButtonKt.BoxAiTopBarButton$lambda$1$0(boxAiMultidocStatus, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.compose.BoxAiTopBarButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiTopBarButtonKt.BoxAiTopBarButton$lambda$1$0(boxAiMultidocStatus, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierTestTag2 = TestTagKt.testTag(SemanticsModifierKt.semantics$default(modifierM632clickableoSLSa3U$default2, false, (Function1) objRememberedValue, 1, null), "BoxAIButton");
                Alignment center2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1712546823, "C:BoxAiTopBarButton.kt#9mvyw3");
                if (boxAiMultidocStatus == BoxAiMultidocStatus.LOADING) {
                    composerStartRestartGroup.startReplaceGroup(1712576737);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "70@2868L307");
                    BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(TestTagKt.testTag(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), "BoxAIButton:ProgressIndicator"), null, BoxColorPalette.INSTANCE.m11395getPURPLE_RAIN_1100d7_KjU(), 0L, Dp.m9687constructorimpl(3), StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), null, composerStartRestartGroup, 24582, 74);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1712924185);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "81@3286L42,82@3367L31,79@3205L307");
                    Modifier modifierM1266size3ABfNKs2 = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24));
                    Painter painterPainterResource2 = PainterResources_androidKt.painterResource(R.drawable.ic_box_ai, composerStartRestartGroup, 0);
                    String strStringResource2 = StringResources_androidKt.stringResource(R.string.box_ai, composerStartRestartGroup, 0);
                    if (boxAiMultidocStatus == BoxAiMultidocStatus.ACTIVE) {
                        jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                    } else {
                        jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                    }
                    IconKt.m3575Iconww6aTOc(painterPainterResource2, strStringResource2, modifierM1266size3ABfNKs2, jM6850getUnspecified0d7_KjU, composerStartRestartGroup, Painter.$stable | 384, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                function2 = new Function2() { // from class: com.box.android.browse.compose.BoxAiTopBarButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiTopBarButtonKt.BoxAiTopBarButton$lambda$3(boxAiMultidocStatus, onClick, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i6 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2138431940, i4, -1, "com.box.android.browse.compose.BoxAiTopBarButton (BoxAiTopBarButton.kt:36)");
            }
            i5 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i5 == 1) {
                composerStartRestartGroup.startReplaceGroup(-2038719824);
                ComposerKt.sourceInformation(composerStartRestartGroup, "39@1752L6");
                SolidColor solidColor3 = new SolidColor(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, BoxAITheme.$stable).m12047getAccentButtonBackground0d7_KjU(), null);
                composerStartRestartGroup.endReplaceGroup();
                solidColorM6763linearGradientmHitzGk$default = solidColor3;
                brush = solidColorM6763linearGradientmHitzGk$default;
                Modifier modifierClip3 = ClipKt.clip(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(44)), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)));
                if (state != BoxAiMultidocStatus.UNAVAILABLE) {
                    f = 1.0f;
                } else {
                    f = 0.3f;
                }
                Modifier modifierBackground$default3 = BackgroundKt.background$default(AlphaKt.alpha(modifierClip3, f), brush, null, 0.0f, 6, null);
                if (state != BoxAiMultidocStatus.AVAILABLE) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                Modifier modifier6 = companion;
                Modifier modifierM632clickableoSLSa3U$default3 = ClickableKt.m632clickableoSLSa3U$default(modifierBackground$default3, z2, null, null, null, onClick, 14, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2038690279, "CC(remember):BoxAiTopBarButton.kt#9igjgp");
                if ((i4 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.compose.BoxAiTopBarButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiTopBarButtonKt.BoxAiTopBarButton$lambda$1$0(boxAiMultidocStatus, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.compose.BoxAiTopBarButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiTopBarButtonKt.BoxAiTopBarButton$lambda$1$0(boxAiMultidocStatus, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierTestTag3 = TestTagKt.testTag(SemanticsModifierKt.semantics$default(modifierM632clickableoSLSa3U$default3, false, (Function1) objRememberedValue, 1, null), "BoxAIButton");
                Alignment center3 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1712546823, "C:BoxAiTopBarButton.kt#9mvyw3");
                if (boxAiMultidocStatus == BoxAiMultidocStatus.LOADING) {
                    composerStartRestartGroup.startReplaceGroup(1712576737);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "70@2868L307");
                    BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(TestTagKt.testTag(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), "BoxAIButton:ProgressIndicator"), null, BoxColorPalette.INSTANCE.m11395getPURPLE_RAIN_1100d7_KjU(), 0L, Dp.m9687constructorimpl(3), StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), null, composerStartRestartGroup, 24582, 74);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1712924185);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "81@3286L42,82@3367L31,79@3205L307");
                    Modifier modifierM1266size3ABfNKs3 = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24));
                    Painter painterPainterResource3 = PainterResources_androidKt.painterResource(R.drawable.ic_box_ai, composerStartRestartGroup, 0);
                    String strStringResource3 = StringResources_androidKt.stringResource(R.string.box_ai, composerStartRestartGroup, 0);
                    if (boxAiMultidocStatus == BoxAiMultidocStatus.ACTIVE) {
                        jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                    } else {
                        jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                    }
                    IconKt.m3575Iconww6aTOc(painterPainterResource3, strStringResource3, modifierM1266size3ABfNKs3, jM6850getUnspecified0d7_KjU, composerStartRestartGroup, Painter.$stable | 384, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier6;
            } else {
                composerStartRestartGroup.startReplaceGroup(-2038719824);
                ComposerKt.sourceInformation(composerStartRestartGroup, "39@1752L6");
                SolidColor solidColor4 = new SolidColor(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, BoxAITheme.$stable).m12047getAccentButtonBackground0d7_KjU(), null);
                composerStartRestartGroup.endReplaceGroup();
                solidColorM6763linearGradientmHitzGk$default = solidColor4;
                brush = solidColorM6763linearGradientmHitzGk$default;
                Modifier modifierClip4 = ClipKt.clip(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(44)), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16)));
                if (state != BoxAiMultidocStatus.UNAVAILABLE) {
                    f = 1.0f;
                } else {
                    f = 0.3f;
                }
                Modifier modifierBackground$default4 = BackgroundKt.background$default(AlphaKt.alpha(modifierClip4, f), brush, null, 0.0f, 6, null);
                if (state != BoxAiMultidocStatus.AVAILABLE) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                Modifier modifier7 = companion;
                Modifier modifierM632clickableoSLSa3U$default4 = ClickableKt.m632clickableoSLSa3U$default(modifierBackground$default4, z2, null, null, null, onClick, 14, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2038690279, "CC(remember):BoxAiTopBarButton.kt#9igjgp");
                if ((i4 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.compose.BoxAiTopBarButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiTopBarButtonKt.BoxAiTopBarButton$lambda$1$0(boxAiMultidocStatus, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.box.android.browse.compose.BoxAiTopBarButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiTopBarButtonKt.BoxAiTopBarButton$lambda$1$0(boxAiMultidocStatus, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierTestTag4 = TestTagKt.testTag(SemanticsModifierKt.semantics$default(modifierM632clickableoSLSa3U$default4, false, (Function1) objRememberedValue, 1, null), "BoxAIButton");
                Alignment center4 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1712546823, "C:BoxAiTopBarButton.kt#9mvyw3");
                if (boxAiMultidocStatus == BoxAiMultidocStatus.LOADING) {
                    composerStartRestartGroup.startReplaceGroup(1712576737);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "70@2868L307");
                    BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(TestTagKt.testTag(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), "BoxAIButton:ProgressIndicator"), null, BoxColorPalette.INSTANCE.m11395getPURPLE_RAIN_1100d7_KjU(), 0L, Dp.m9687constructorimpl(3), StrokeCap.INSTANCE.m7192getSquareKaPHkGw(), null, composerStartRestartGroup, 24582, 74);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1712924185);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "81@3286L42,82@3367L31,79@3205L307");
                    Modifier modifierM1266size3ABfNKs4 = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24));
                    Painter painterPainterResource4 = PainterResources_androidKt.painterResource(R.drawable.ic_box_ai, composerStartRestartGroup, 0);
                    String strStringResource4 = StringResources_androidKt.stringResource(R.string.box_ai, composerStartRestartGroup, 0);
                    if (boxAiMultidocStatus == BoxAiMultidocStatus.ACTIVE) {
                        jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                    } else {
                        jM6850getUnspecified0d7_KjU = Color.INSTANCE.m6850getUnspecified0d7_KjU();
                    }
                    IconKt.m3575Iconww6aTOc(painterPainterResource4, strStringResource4, modifierM1266size3ABfNKs4, jM6850getUnspecified0d7_KjU, composerStartRestartGroup, Painter.$stable | 384, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier7;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.browse.compose.BoxAiTopBarButtonKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiTopBarButtonKt.BoxAiTopBarButton$lambda$3(boxAiMultidocStatus, onClick, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiTopBarButton$lambda$1$0(BoxAiMultidocStatus boxAiMultidocStatus, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setStateDescription(semantics, boxAiMultidocStatus.name());
        return Unit.INSTANCE;
    }

    private static final void BoxAiTopBarButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1449809973);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiTopBarButtonPreview)94@3660L388:BoxAiTopBarButton.kt#9mvyw3");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1449809973, i, -1, "com.box.android.browse.compose.BoxAiTopBarButtonPreview (BoxAiTopBarButton.kt:93)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiTopBarButtonKt.INSTANCE.m12171getLambda$1784099306$browse_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.BoxAiTopBarButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiTopBarButtonKt.BoxAiTopBarButtonPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
