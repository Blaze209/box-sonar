package com.box.android.base.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.ConstraintSetForInlineDsl;
import androidx.constraintlayout.compose.Measurer;
import androidx.constraintlayout.compose.ToolingUtilsKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.R;
import com.box.android.base.compose.button.BoxOutlinedButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: ItemStateScreens.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\n\u001aO\u0010\u000b\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\f\u001a\u00020\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0003\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0011\u001aG\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"LoadingItemsScreen", "", "text", "", "isRedesignedVersion", "", "(Ljava/lang/String;ZLandroidx/compose/runtime/Composer;II)V", "NetworkConnectionError", "retryAction", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "GenericErrorScreen", "mainTextRes", "", "subTextRes", "drawableId", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "(Lkotlin/jvm/functions/Function0;ZILjava/lang/Integer;ILjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "ItemsStateScreen", "itemsStateConfig", "Lcom/box/android/base/compose/ItemsStateConfig;", "modifier", "Landroidx/compose/ui/Modifier;", "shouldCenter", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "ItemsStateScreen-V-9fs2A", "(Lcom/box/android/base/compose/ItemsStateConfig;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZZJLandroidx/compose/runtime/Composer;II)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ItemStateScreensKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GenericErrorScreen$lambda$1(Function0 function0, boolean z, int i, Integer num, int i2, String str, int i3, int i4, Composer composer, int i5) {
        GenericErrorScreen(function0, z, i, num, i2, str, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemsStateScreen_V_9fs2A$lambda$3(ItemsStateConfig itemsStateConfig, String str, Modifier modifier, boolean z, boolean z2, long j, int i, int i2, Composer composer, int i3) {
        m11654ItemsStateScreenV9fs2A(itemsStateConfig, str, modifier, z, z2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingItemsScreen$lambda$1(String str, boolean z, int i, int i2, Composer composer, int i3) {
        LoadingItemsScreen(str, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NetworkConnectionError$lambda$0(Function0 function0, boolean z, int i, int i2, Composer composer, int i3) {
        NetworkConnectionError(function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0054  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0064  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x0084  */
    /* JADX WARN: Code duplicated, block: B:43:0x009a  */
    /* JADX WARN: Code duplicated, block: B:46:0x010e  */
    /* JADX WARN: Code duplicated, block: B:49:0x011a  */
    /* JADX WARN: Code duplicated, block: B:50:0x011e  */
    /* JADX WARN: Code duplicated, block: B:53:0x017b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0186  */
    /* JADX WARN: Code duplicated, block: B:57:0x0201  */
    /* JADX WARN: Code duplicated, block: B:59:0x0207  */
    /* JADX WARN: Code duplicated, block: B:62:0x0211  */
    /* JADX WARN: Code duplicated, block: B:64:? A[RETURN, SYNTHETIC] */
    public static final void LoadingItemsScreen(String str, boolean z, Composer composer, final int i, final int i2) {
        String str2;
        int i3;
        final boolean z2;
        boolean z3;
        final String str3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String str4;
        boolean z4;
        long jM11499getAppBackgroundAlt0d7_KjU;
        Function0<ComposeUiNode> constructor;
        Composer composerStartRestartGroup = composer.startRestartGroup(926870126);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadingItemsScreen)N(text,isRedesignedVersion)39@1740L655:ItemStateScreens.kt#vejmn0");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            str2 = str;
        } else if ((i & 6) == 0) {
            str2 = str;
            i3 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            str2 = str;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            if ((i3 & 19) != 18) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str3 = str2;
            } else {
                if (i4 != 0) {
                    str4 = null;
                } else {
                    str4 = str2;
                }
                if (i5 != 0) {
                    z4 = false;
                } else {
                    z4 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(926870126, i3, -1, "com.box.android.base.compose.LoadingItemsScreen (ItemStateScreens.kt:38)");
                }
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                if (z4) {
                    composerStartRestartGroup.startReplaceGroup(1663967771);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "42@1861L6");
                    jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1663968894);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "42@1896L6");
                    jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierTestTag = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(modifierFillMaxSize$default, jM11499getAppBackgroundAlt0d7_KjU, null, 2, null), "Loading");
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -37755371, "C47@2079L24:ItemStateScreens.kt#vejmn0");
                BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(null, null, 0L, 0L, 0.0f, 0, null, composerStartRestartGroup, 0, 127);
                if (str4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-37717894);
                    composerStartRestartGroup.endReplaceGroup();
                    str3 = str4;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-37717893);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*49@2136L30,54@2348L6,50@2179L200");
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), composerStartRestartGroup, 6);
                    TextStyle boxMedium16 = BoxTheme.INSTANCE.getTypography().getBoxMedium16();
                    int iM9526getCentere0LSkKk = TextAlign.INSTANCE.m9526getCentere0LSkKk();
                    long jM11500getAppPrimary0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                    TextAlign textAlignM9519boximpl = TextAlign.m9519boximpl(iM9526getCentere0LSkKk);
                    str3 = str4;
                    TextKt.m4494TextNvy7gAk(str3, null, jM11500getAppPrimary0d7_KjU, null, 0L, null, null, null, 0L, null, textAlignM9519boximpl, 0L, 0, false, 0, 0, null, boxMedium16, composerStartRestartGroup, 0, 12582912, 130042);
                    composerStartRestartGroup = composerStartRestartGroup;
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
                z2 = z4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemStateScreensKt.LoadingItemsScreen$lambda$1(str3, z2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z2 = z;
        if ((i3 & 19) != 18) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            str3 = str2;
        } else {
            if (i4 != 0) {
                str4 = null;
            } else {
                str4 = str2;
            }
            if (i5 != 0) {
                z4 = false;
            } else {
                z4 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(926870126, i3, -1, "com.box.android.base.compose.LoadingItemsScreen (ItemStateScreens.kt:38)");
            }
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            if (z4) {
                composerStartRestartGroup.startReplaceGroup(1663967771);
                ComposerKt.sourceInformation(composerStartRestartGroup, "42@1861L6");
                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
            } else {
                composerStartRestartGroup.startReplaceGroup(1663968894);
                ComposerKt.sourceInformation(composerStartRestartGroup, "42@1896L6");
                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierTestTag2 = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(modifierFillMaxSize$default2, jM11499getAppBackgroundAlt0d7_KjU, null, 2, null), "Loading");
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center2, centerHorizontally2, composerStartRestartGroup, 54);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -37755371, "C47@2079L24:ItemStateScreens.kt#vejmn0");
            BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(null, null, 0L, 0L, 0.0f, 0, null, composerStartRestartGroup, 0, 127);
            if (str4 == null) {
                composerStartRestartGroup.startReplaceGroup(-37717894);
                composerStartRestartGroup.endReplaceGroup();
                str3 = str4;
            } else {
                composerStartRestartGroup.startReplaceGroup(-37717893);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*49@2136L30,54@2348L6,50@2179L200");
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), composerStartRestartGroup, 6);
                TextStyle boxMedium17 = BoxTheme.INSTANCE.getTypography().getBoxMedium16();
                int iM9526getCentere0LSkKk2 = TextAlign.INSTANCE.m9526getCentere0LSkKk();
                long jM11500getAppPrimary0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                TextAlign textAlignM9519boximpl2 = TextAlign.m9519boximpl(iM9526getCentere0LSkKk2);
                str3 = str4;
                TextKt.m4494TextNvy7gAk(str3, null, jM11500getAppPrimary0d7_KjU2, null, 0L, null, null, null, 0L, null, textAlignM9519boximpl2, 0L, 0, false, 0, 0, null, boxMedium17, composerStartRestartGroup, 0, 12582912, 130042);
                composerStartRestartGroup = composerStartRestartGroup;
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
            z2 = z4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemStateScreensKt.LoadingItemsScreen$lambda$1(str3, z2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void NetworkConnectionError(final Function0<Unit> retryAction, final boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(retryAction, "retryAction");
        Composer composerStartRestartGroup = composer.startRestartGroup(1237860367);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NetworkConnectionError)N(retryAction,isRedesignedVersion)66@2689L47,67@2760L56,62@2507L601:ItemStateScreens.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(retryAction) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                z = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1237860367, i3, -1, "com.box.android.base.compose.NetworkConnectionError (ItemStateScreens.kt:61)");
            }
            boolean z2 = z;
            m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(R.drawable.ic_unplugged140, StringResources_androidKt.stringResource(R.string.no_internet_connection, composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.check_internet_connection_retry, composerStartRestartGroup, 0), new ButtonItem.TextButtonItem(true, retryAction, R.string.retry)), "NetworkConnectionError", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, z2, 0L, composerStartRestartGroup, ((i3 << 9) & 57344) | 432, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z = z2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemStateScreensKt.NetworkConnectionError$lambda$0(retryAction, z, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x011e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0137  */
    /* JADX WARN: Code duplicated, block: B:104:0x013e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0181  */
    /* JADX WARN: Code duplicated, block: B:109:0x0189  */
    /* JADX WARN: Code duplicated, block: B:112:0x0197  */
    /* JADX WARN: Code duplicated, block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:35:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:68:0x00be  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ef A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:94:0x0103  */
    /* JADX WARN: Code duplicated, block: B:96:0x010a  */
    /* JADX WARN: Code duplicated, block: B:97:0x0110  */
    public static final void GenericErrorScreen(final Function0<Unit> retryAction, boolean z, int i, Integer num, int i2, String str, Composer composer, final int i3, final int i4) {
        int i5;
        boolean z2;
        int i6;
        int i7;
        Integer num2;
        int i8;
        int i9;
        int i10;
        String str2;
        int i11;
        boolean z3;
        final boolean z4;
        final int i12;
        final Integer num3;
        final int i13;
        final String str3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String strStringResource;
        int i14;
        boolean z5;
        Integer num4;
        int i15;
        String str4;
        Intrinsics.checkNotNullParameter(retryAction, "retryAction");
        Composer composerStartRestartGroup = composer.startRestartGroup(505181736);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GenericErrorScreen)N(retryAction,isRedesignedVersion,mainTextRes,subTextRes,drawableId,testTag)92@3614L27,88@3448L530:ItemStateScreens.kt#vejmn0");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changedInstance(retryAction) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i16 = i4 & 2;
        if (i16 == 0) {
            if ((i3 & 48) == 0) {
                z2 = z;
                i5 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            if ((i3 & 384) == 0) {
                if ((i4 & 4) == 0) {
                    i6 = i;
                    int i17 = composerStartRestartGroup.changed(i6) ? 256 : 128;
                    i5 |= i17;
                } else {
                    i6 = i;
                }
                i5 |= i17;
            } else {
                i6 = i;
            }
            i7 = i4 & 8;
            if (i7 != 0) {
                if ((i3 & 3072) == 0) {
                    num2 = num;
                    if (composerStartRestartGroup.changed(num2)) {
                        i8 = 2048;
                    } else {
                        i8 = 1024;
                    }
                    i5 |= i8;
                }
                if ((i3 & 24576) == 0) {
                    if ((i4 & 16) == 0) {
                        i9 = i2;
                        int i18 = composerStartRestartGroup.changed(i9) ? 16384 : 8192;
                        i5 |= i18;
                    } else {
                        i9 = i2;
                    }
                    i5 |= i18;
                } else {
                    i9 = i2;
                }
                i10 = i4 & 32;
                if (i10 != 0) {
                    if ((196608 & i3) == 0) {
                        str2 = str;
                        if (composerStartRestartGroup.changed(str2)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i5 |= i11;
                    }
                    if ((74899 & i5) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        strStringResource = null;
                        if ((i3 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i16 != 0) {
                                z2 = false;
                            }
                            if ((i4 & 4) != 0) {
                                i12 = R.string.box_sharesdk_generic_error;
                                i5 &= -897;
                            } else {
                                i12 = i6;
                            }
                            if (i7 != 0) {
                                num2 = null;
                            }
                            if ((i4 & 16) != 0) {
                                i5 &= -57345;
                                i9 = R.drawable.ic_errorstate404140;
                            }
                            if (i10 != 0) {
                                z5 = z2;
                                i15 = i9;
                                str4 = "GenericErrorScreen";
                            } else {
                                i14 = i5;
                                z5 = z2;
                                num4 = num2;
                                i15 = i9;
                                str4 = str2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(505181736, i14, -1, "com.box.android.base.compose.GenericErrorScreen (ItemStateScreens.kt:87)");
                            }
                            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            String strStringResource2 = StringResources_androidKt.stringResource(i12, composerStartRestartGroup, (i14 >> 6) & 14);
                            if (num4 == null) {
                                composerStartRestartGroup.startReplaceGroup(304241375);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(304241376);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*93@3683L18");
                                strStringResource = StringResources_androidKt.stringResource(num4.intValue(), composerStartRestartGroup, 0);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i15, strStringResource2, strStringResource, new ButtonItem.TextButtonItem(true, retryAction, R.string.retry)), str4, modifierFillMaxSize$default, false, z5, 0L, composerStartRestartGroup, ((i14 >> 12) & 112) | 384 | ((i14 << 9) & 57344), 40);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i13 = i15;
                            str3 = str4;
                            num3 = num4;
                            z4 = z5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i4 & 4) != 0) {
                                i5 &= -897;
                            }
                            if ((i4 & 16) != 0) {
                                i5 &= -57345;
                            }
                            z5 = z2;
                            i12 = i6;
                            i15 = i9;
                            str4 = str2;
                        }
                        i14 = i5;
                        num4 = num2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(505181736, i14, -1, "com.box.android.base.compose.GenericErrorScreen (ItemStateScreens.kt:87)");
                        }
                        Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        String strStringResource3 = StringResources_androidKt.stringResource(i12, composerStartRestartGroup, (i14 >> 6) & 14);
                        if (num4 == null) {
                            composerStartRestartGroup.startReplaceGroup(304241375);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(304241376);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*93@3683L18");
                            strStringResource = StringResources_androidKt.stringResource(num4.intValue(), composerStartRestartGroup, 0);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i15, strStringResource3, strStringResource, new ButtonItem.TextButtonItem(true, retryAction, R.string.retry)), str4, modifierFillMaxSize$default2, false, z5, 0L, composerStartRestartGroup, ((i14 >> 12) & 112) | 384 | ((i14 << 9) & 57344), 40);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i13 = i15;
                        str3 = str4;
                        num3 = num4;
                        z4 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z4 = z2;
                        i12 = i6;
                        num3 = num2;
                        i13 = i9;
                        str3 = str2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ItemStateScreensKt.GenericErrorScreen$lambda$1(retryAction, z4, i12, num3, i13, str3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                str2 = str;
                if ((74899 & i5) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    strStringResource = null;
                    if ((i3 & 1) != 0) {
                        if (i16 != 0) {
                            z2 = false;
                        }
                        if ((i4 & 4) != 0) {
                            i12 = R.string.box_sharesdk_generic_error;
                            i5 &= -897;
                        } else {
                            i12 = i6;
                        }
                        if (i7 != 0) {
                            num2 = null;
                        }
                        if ((i4 & 16) != 0) {
                            i5 &= -57345;
                            i9 = R.drawable.ic_errorstate404140;
                        }
                        if (i10 != 0) {
                            z5 = z2;
                            i15 = i9;
                            str4 = "GenericErrorScreen";
                            i14 = i5;
                            num4 = num2;
                        } else {
                            i14 = i5;
                            z5 = z2;
                            num4 = num2;
                            i15 = i9;
                            str4 = str2;
                        }
                    } else {
                        if (i16 != 0) {
                            z2 = false;
                        }
                        if ((i4 & 4) != 0) {
                            i12 = R.string.box_sharesdk_generic_error;
                            i5 &= -897;
                        } else {
                            i12 = i6;
                        }
                        if (i7 != 0) {
                            num2 = null;
                        }
                        if ((i4 & 16) != 0) {
                            i5 &= -57345;
                            i9 = R.drawable.ic_errorstate404140;
                        }
                        if (i10 != 0) {
                            z5 = z2;
                            i15 = i9;
                            str4 = "GenericErrorScreen";
                            i14 = i5;
                            num4 = num2;
                        } else {
                            i14 = i5;
                            z5 = z2;
                            num4 = num2;
                            i15 = i9;
                            str4 = str2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(505181736, i14, -1, "com.box.android.base.compose.GenericErrorScreen (ItemStateScreens.kt:87)");
                    }
                    Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    String strStringResource4 = StringResources_androidKt.stringResource(i12, composerStartRestartGroup, (i14 >> 6) & 14);
                    if (num4 == null) {
                        composerStartRestartGroup.startReplaceGroup(304241375);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(304241376);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*93@3683L18");
                        strStringResource = StringResources_androidKt.stringResource(num4.intValue(), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i15, strStringResource4, strStringResource, new ButtonItem.TextButtonItem(true, retryAction, R.string.retry)), str4, modifierFillMaxSize$default3, false, z5, 0L, composerStartRestartGroup, ((i14 >> 12) & 112) | 384 | ((i14 << 9) & 57344), 40);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i13 = i15;
                    str3 = str4;
                    num3 = num4;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z2;
                    i12 = i6;
                    num3 = num2;
                    i13 = i9;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ItemStateScreensKt.GenericErrorScreen$lambda$1(retryAction, z4, i12, num3, i13, str3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 3072;
            num2 = num;
            if ((i3 & 24576) == 0) {
                if ((i4 & 16) == 0) {
                    i9 = i2;
                    if (composerStartRestartGroup.changed(i9)) {
                    }
                    i5 |= i18;
                } else {
                    i9 = i2;
                }
                i5 |= i18;
            } else {
                i9 = i2;
            }
            i10 = i4 & 32;
            if (i10 != 0) {
                if ((196608 & i3) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i5 |= i11;
                }
                if ((74899 & i5) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    strStringResource = null;
                    if ((i3 & 1) != 0) {
                        if (i16 != 0) {
                            z2 = false;
                        }
                        if ((i4 & 4) != 0) {
                            i12 = R.string.box_sharesdk_generic_error;
                            i5 &= -897;
                        } else {
                            i12 = i6;
                        }
                        if (i7 != 0) {
                            num2 = null;
                        }
                        if ((i4 & 16) != 0) {
                            i5 &= -57345;
                            i9 = R.drawable.ic_errorstate404140;
                        }
                        if (i10 != 0) {
                            z5 = z2;
                            i15 = i9;
                            str4 = "GenericErrorScreen";
                            i14 = i5;
                            num4 = num2;
                        } else {
                            i14 = i5;
                            z5 = z2;
                            num4 = num2;
                            i15 = i9;
                            str4 = str2;
                        }
                    } else {
                        if (i16 != 0) {
                            z2 = false;
                        }
                        if ((i4 & 4) != 0) {
                            i12 = R.string.box_sharesdk_generic_error;
                            i5 &= -897;
                        } else {
                            i12 = i6;
                        }
                        if (i7 != 0) {
                            num2 = null;
                        }
                        if ((i4 & 16) != 0) {
                            i5 &= -57345;
                            i9 = R.drawable.ic_errorstate404140;
                        }
                        if (i10 != 0) {
                            z5 = z2;
                            i15 = i9;
                            str4 = "GenericErrorScreen";
                            i14 = i5;
                            num4 = num2;
                        } else {
                            i14 = i5;
                            z5 = z2;
                            num4 = num2;
                            i15 = i9;
                            str4 = str2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(505181736, i14, -1, "com.box.android.base.compose.GenericErrorScreen (ItemStateScreens.kt:87)");
                    }
                    Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    String strStringResource5 = StringResources_androidKt.stringResource(i12, composerStartRestartGroup, (i14 >> 6) & 14);
                    if (num4 == null) {
                        composerStartRestartGroup.startReplaceGroup(304241375);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(304241376);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*93@3683L18");
                        strStringResource = StringResources_androidKt.stringResource(num4.intValue(), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i15, strStringResource5, strStringResource, new ButtonItem.TextButtonItem(true, retryAction, R.string.retry)), str4, modifierFillMaxSize$default4, false, z5, 0L, composerStartRestartGroup, ((i14 >> 12) & 112) | 384 | ((i14 << 9) & 57344), 40);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i13 = i15;
                    str3 = str4;
                    num3 = num4;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z2;
                    i12 = i6;
                    num3 = num2;
                    i13 = i9;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ItemStateScreensKt.GenericErrorScreen$lambda$1(retryAction, z4, i12, num3, i13, str3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            str2 = str;
            if ((74899 & i5) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                composerStartRestartGroup.startDefaults();
                strStringResource = null;
                if ((i3 & 1) != 0) {
                    if (i16 != 0) {
                        z2 = false;
                    }
                    if ((i4 & 4) != 0) {
                        i12 = R.string.box_sharesdk_generic_error;
                        i5 &= -897;
                    } else {
                        i12 = i6;
                    }
                    if (i7 != 0) {
                        num2 = null;
                    }
                    if ((i4 & 16) != 0) {
                        i5 &= -57345;
                        i9 = R.drawable.ic_errorstate404140;
                    }
                    if (i10 != 0) {
                        z5 = z2;
                        i15 = i9;
                        str4 = "GenericErrorScreen";
                        i14 = i5;
                        num4 = num2;
                    } else {
                        i14 = i5;
                        z5 = z2;
                        num4 = num2;
                        i15 = i9;
                        str4 = str2;
                    }
                } else {
                    if (i16 != 0) {
                        z2 = false;
                    }
                    if ((i4 & 4) != 0) {
                        i12 = R.string.box_sharesdk_generic_error;
                        i5 &= -897;
                    } else {
                        i12 = i6;
                    }
                    if (i7 != 0) {
                        num2 = null;
                    }
                    if ((i4 & 16) != 0) {
                        i5 &= -57345;
                        i9 = R.drawable.ic_errorstate404140;
                    }
                    if (i10 != 0) {
                        z5 = z2;
                        i15 = i9;
                        str4 = "GenericErrorScreen";
                        i14 = i5;
                        num4 = num2;
                    } else {
                        i14 = i5;
                        z5 = z2;
                        num4 = num2;
                        i15 = i9;
                        str4 = str2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(505181736, i14, -1, "com.box.android.base.compose.GenericErrorScreen (ItemStateScreens.kt:87)");
                }
                Modifier modifierFillMaxSize$default5 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                String strStringResource6 = StringResources_androidKt.stringResource(i12, composerStartRestartGroup, (i14 >> 6) & 14);
                if (num4 == null) {
                    composerStartRestartGroup.startReplaceGroup(304241375);
                } else {
                    composerStartRestartGroup.startReplaceGroup(304241376);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*93@3683L18");
                    strStringResource = StringResources_androidKt.stringResource(num4.intValue(), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i15, strStringResource6, strStringResource, new ButtonItem.TextButtonItem(true, retryAction, R.string.retry)), str4, modifierFillMaxSize$default5, false, z5, 0L, composerStartRestartGroup, ((i14 >> 12) & 112) | 384 | ((i14 << 9) & 57344), 40);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i13 = i15;
                str3 = str4;
                num3 = num4;
                z4 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
                i12 = i6;
                num3 = num2;
                i13 = i9;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemStateScreensKt.GenericErrorScreen$lambda$1(retryAction, z4, i12, num3, i13, str3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 48;
        z2 = z;
        if ((i3 & 384) == 0) {
            if ((i4 & 4) == 0) {
                i6 = i;
                if (composerStartRestartGroup.changed(i6)) {
                }
                i5 |= i17;
            } else {
                i6 = i;
            }
            i5 |= i17;
        } else {
            i6 = i;
        }
        i7 = i4 & 8;
        if (i7 != 0) {
            if ((i3 & 3072) == 0) {
                num2 = num;
                if (composerStartRestartGroup.changed(num2)) {
                    i8 = 2048;
                } else {
                    i8 = 1024;
                }
                i5 |= i8;
            }
            if ((i3 & 24576) == 0) {
                if ((i4 & 16) == 0) {
                    i9 = i2;
                    if (composerStartRestartGroup.changed(i9)) {
                    }
                    i5 |= i18;
                } else {
                    i9 = i2;
                }
                i5 |= i18;
            } else {
                i9 = i2;
            }
            i10 = i4 & 32;
            if (i10 != 0) {
                if ((196608 & i3) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i5 |= i11;
                }
                if ((74899 & i5) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    strStringResource = null;
                    if ((i3 & 1) != 0) {
                        if (i16 != 0) {
                            z2 = false;
                        }
                        if ((i4 & 4) != 0) {
                            i12 = R.string.box_sharesdk_generic_error;
                            i5 &= -897;
                        } else {
                            i12 = i6;
                        }
                        if (i7 != 0) {
                            num2 = null;
                        }
                        if ((i4 & 16) != 0) {
                            i5 &= -57345;
                            i9 = R.drawable.ic_errorstate404140;
                        }
                        if (i10 != 0) {
                            z5 = z2;
                            i15 = i9;
                            str4 = "GenericErrorScreen";
                            i14 = i5;
                            num4 = num2;
                        } else {
                            i14 = i5;
                            z5 = z2;
                            num4 = num2;
                            i15 = i9;
                            str4 = str2;
                        }
                    } else {
                        if (i16 != 0) {
                            z2 = false;
                        }
                        if ((i4 & 4) != 0) {
                            i12 = R.string.box_sharesdk_generic_error;
                            i5 &= -897;
                        } else {
                            i12 = i6;
                        }
                        if (i7 != 0) {
                            num2 = null;
                        }
                        if ((i4 & 16) != 0) {
                            i5 &= -57345;
                            i9 = R.drawable.ic_errorstate404140;
                        }
                        if (i10 != 0) {
                            z5 = z2;
                            i15 = i9;
                            str4 = "GenericErrorScreen";
                            i14 = i5;
                            num4 = num2;
                        } else {
                            i14 = i5;
                            z5 = z2;
                            num4 = num2;
                            i15 = i9;
                            str4 = str2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(505181736, i14, -1, "com.box.android.base.compose.GenericErrorScreen (ItemStateScreens.kt:87)");
                    }
                    Modifier modifierFillMaxSize$default6 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    String strStringResource7 = StringResources_androidKt.stringResource(i12, composerStartRestartGroup, (i14 >> 6) & 14);
                    if (num4 == null) {
                        composerStartRestartGroup.startReplaceGroup(304241375);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(304241376);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*93@3683L18");
                        strStringResource = StringResources_androidKt.stringResource(num4.intValue(), composerStartRestartGroup, 0);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i15, strStringResource7, strStringResource, new ButtonItem.TextButtonItem(true, retryAction, R.string.retry)), str4, modifierFillMaxSize$default6, false, z5, 0L, composerStartRestartGroup, ((i14 >> 12) & 112) | 384 | ((i14 << 9) & 57344), 40);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i13 = i15;
                    str3 = str4;
                    num3 = num4;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z2;
                    i12 = i6;
                    num3 = num2;
                    i13 = i9;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ItemStateScreensKt.GenericErrorScreen$lambda$1(retryAction, z4, i12, num3, i13, str3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            str2 = str;
            if ((74899 & i5) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                composerStartRestartGroup.startDefaults();
                strStringResource = null;
                if ((i3 & 1) != 0) {
                    if (i16 != 0) {
                        z2 = false;
                    }
                    if ((i4 & 4) != 0) {
                        i12 = R.string.box_sharesdk_generic_error;
                        i5 &= -897;
                    } else {
                        i12 = i6;
                    }
                    if (i7 != 0) {
                        num2 = null;
                    }
                    if ((i4 & 16) != 0) {
                        i5 &= -57345;
                        i9 = R.drawable.ic_errorstate404140;
                    }
                    if (i10 != 0) {
                        z5 = z2;
                        i15 = i9;
                        str4 = "GenericErrorScreen";
                        i14 = i5;
                        num4 = num2;
                    } else {
                        i14 = i5;
                        z5 = z2;
                        num4 = num2;
                        i15 = i9;
                        str4 = str2;
                    }
                } else {
                    if (i16 != 0) {
                        z2 = false;
                    }
                    if ((i4 & 4) != 0) {
                        i12 = R.string.box_sharesdk_generic_error;
                        i5 &= -897;
                    } else {
                        i12 = i6;
                    }
                    if (i7 != 0) {
                        num2 = null;
                    }
                    if ((i4 & 16) != 0) {
                        i5 &= -57345;
                        i9 = R.drawable.ic_errorstate404140;
                    }
                    if (i10 != 0) {
                        z5 = z2;
                        i15 = i9;
                        str4 = "GenericErrorScreen";
                        i14 = i5;
                        num4 = num2;
                    } else {
                        i14 = i5;
                        z5 = z2;
                        num4 = num2;
                        i15 = i9;
                        str4 = str2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(505181736, i14, -1, "com.box.android.base.compose.GenericErrorScreen (ItemStateScreens.kt:87)");
                }
                Modifier modifierFillMaxSize$default7 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                String strStringResource8 = StringResources_androidKt.stringResource(i12, composerStartRestartGroup, (i14 >> 6) & 14);
                if (num4 == null) {
                    composerStartRestartGroup.startReplaceGroup(304241375);
                } else {
                    composerStartRestartGroup.startReplaceGroup(304241376);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*93@3683L18");
                    strStringResource = StringResources_androidKt.stringResource(num4.intValue(), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i15, strStringResource8, strStringResource, new ButtonItem.TextButtonItem(true, retryAction, R.string.retry)), str4, modifierFillMaxSize$default7, false, z5, 0L, composerStartRestartGroup, ((i14 >> 12) & 112) | 384 | ((i14 << 9) & 57344), 40);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i13 = i15;
                str3 = str4;
                num3 = num4;
                z4 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
                i12 = i6;
                num3 = num2;
                i13 = i9;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemStateScreensKt.GenericErrorScreen$lambda$1(retryAction, z4, i12, num3, i13, str3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 3072;
        num2 = num;
        if ((i3 & 24576) == 0) {
            if ((i4 & 16) == 0) {
                i9 = i2;
                if (composerStartRestartGroup.changed(i9)) {
                }
                i5 |= i18;
            } else {
                i9 = i2;
            }
            i5 |= i18;
        } else {
            i9 = i2;
        }
        i10 = i4 & 32;
        if (i10 != 0) {
            if ((196608 & i3) == 0) {
                str2 = str;
                if (composerStartRestartGroup.changed(str2)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i5 |= i11;
            }
            if ((74899 & i5) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                composerStartRestartGroup.startDefaults();
                strStringResource = null;
                if ((i3 & 1) != 0) {
                    if (i16 != 0) {
                        z2 = false;
                    }
                    if ((i4 & 4) != 0) {
                        i12 = R.string.box_sharesdk_generic_error;
                        i5 &= -897;
                    } else {
                        i12 = i6;
                    }
                    if (i7 != 0) {
                        num2 = null;
                    }
                    if ((i4 & 16) != 0) {
                        i5 &= -57345;
                        i9 = R.drawable.ic_errorstate404140;
                    }
                    if (i10 != 0) {
                        z5 = z2;
                        i15 = i9;
                        str4 = "GenericErrorScreen";
                        i14 = i5;
                        num4 = num2;
                    } else {
                        i14 = i5;
                        z5 = z2;
                        num4 = num2;
                        i15 = i9;
                        str4 = str2;
                    }
                } else {
                    if (i16 != 0) {
                        z2 = false;
                    }
                    if ((i4 & 4) != 0) {
                        i12 = R.string.box_sharesdk_generic_error;
                        i5 &= -897;
                    } else {
                        i12 = i6;
                    }
                    if (i7 != 0) {
                        num2 = null;
                    }
                    if ((i4 & 16) != 0) {
                        i5 &= -57345;
                        i9 = R.drawable.ic_errorstate404140;
                    }
                    if (i10 != 0) {
                        z5 = z2;
                        i15 = i9;
                        str4 = "GenericErrorScreen";
                        i14 = i5;
                        num4 = num2;
                    } else {
                        i14 = i5;
                        z5 = z2;
                        num4 = num2;
                        i15 = i9;
                        str4 = str2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(505181736, i14, -1, "com.box.android.base.compose.GenericErrorScreen (ItemStateScreens.kt:87)");
                }
                Modifier modifierFillMaxSize$default8 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                String strStringResource9 = StringResources_androidKt.stringResource(i12, composerStartRestartGroup, (i14 >> 6) & 14);
                if (num4 == null) {
                    composerStartRestartGroup.startReplaceGroup(304241375);
                } else {
                    composerStartRestartGroup.startReplaceGroup(304241376);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*93@3683L18");
                    strStringResource = StringResources_androidKt.stringResource(num4.intValue(), composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i15, strStringResource9, strStringResource, new ButtonItem.TextButtonItem(true, retryAction, R.string.retry)), str4, modifierFillMaxSize$default8, false, z5, 0L, composerStartRestartGroup, ((i14 >> 12) & 112) | 384 | ((i14 << 9) & 57344), 40);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i13 = i15;
                str3 = str4;
                num3 = num4;
                z4 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
                i12 = i6;
                num3 = num2;
                i13 = i9;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemStateScreensKt.GenericErrorScreen$lambda$1(retryAction, z4, i12, num3, i13, str3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        str2 = str;
        if ((74899 & i5) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
            composerStartRestartGroup.startDefaults();
            strStringResource = null;
            if ((i3 & 1) != 0) {
                if (i16 != 0) {
                    z2 = false;
                }
                if ((i4 & 4) != 0) {
                    i12 = R.string.box_sharesdk_generic_error;
                    i5 &= -897;
                } else {
                    i12 = i6;
                }
                if (i7 != 0) {
                    num2 = null;
                }
                if ((i4 & 16) != 0) {
                    i5 &= -57345;
                    i9 = R.drawable.ic_errorstate404140;
                }
                if (i10 != 0) {
                    z5 = z2;
                    i15 = i9;
                    str4 = "GenericErrorScreen";
                    i14 = i5;
                    num4 = num2;
                } else {
                    i14 = i5;
                    z5 = z2;
                    num4 = num2;
                    i15 = i9;
                    str4 = str2;
                }
            } else {
                if (i16 != 0) {
                    z2 = false;
                }
                if ((i4 & 4) != 0) {
                    i12 = R.string.box_sharesdk_generic_error;
                    i5 &= -897;
                } else {
                    i12 = i6;
                }
                if (i7 != 0) {
                    num2 = null;
                }
                if ((i4 & 16) != 0) {
                    i5 &= -57345;
                    i9 = R.drawable.ic_errorstate404140;
                }
                if (i10 != 0) {
                    z5 = z2;
                    i15 = i9;
                    str4 = "GenericErrorScreen";
                    i14 = i5;
                    num4 = num2;
                } else {
                    i14 = i5;
                    z5 = z2;
                    num4 = num2;
                    i15 = i9;
                    str4 = str2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(505181736, i14, -1, "com.box.android.base.compose.GenericErrorScreen (ItemStateScreens.kt:87)");
            }
            Modifier modifierFillMaxSize$default9 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            String strStringResource10 = StringResources_androidKt.stringResource(i12, composerStartRestartGroup, (i14 >> 6) & 14);
            if (num4 == null) {
                composerStartRestartGroup.startReplaceGroup(304241375);
            } else {
                composerStartRestartGroup.startReplaceGroup(304241376);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*93@3683L18");
                strStringResource = StringResources_androidKt.stringResource(num4.intValue(), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i15, strStringResource10, strStringResource, new ButtonItem.TextButtonItem(true, retryAction, R.string.retry)), str4, modifierFillMaxSize$default9, false, z5, 0L, composerStartRestartGroup, ((i14 >> 12) & 112) | 384 | ((i14 << 9) & 57344), 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            i13 = i15;
            str3 = str4;
            num3 = num4;
            z4 = z5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z4 = z2;
            i12 = i6;
            num3 = num2;
            i13 = i9;
            str3 = str2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemStateScreensKt.GenericErrorScreen$lambda$1(retryAction, z4, i12, num3, i13, str3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0193  */
    /* JADX WARN: Code duplicated, block: B:103:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:106:0x0214  */
    /* JADX WARN: Code duplicated, block: B:109:0x0233  */
    /* JADX WARN: Code duplicated, block: B:112:0x0252  */
    /* JADX WARN: Code duplicated, block: B:115:0x0279  */
    /* JADX WARN: Code duplicated, block: B:118:0x029a  */
    /* JADX WARN: Code duplicated, block: B:121:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:125:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:128:0x0302  */
    /* JADX WARN: Code duplicated, block: B:131:0x0322  */
    /* JADX WARN: Code duplicated, block: B:133:0x032a  */
    /* JADX WARN: Code duplicated, block: B:136:0x037c  */
    /* JADX WARN: Code duplicated, block: B:138:0x0383  */
    /* JADX WARN: Code duplicated, block: B:141:0x0391  */
    /* JADX WARN: Code duplicated, block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x006e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0082  */
    /* JADX WARN: Code duplicated, block: B:46:0x008a  */
    /* JADX WARN: Code duplicated, block: B:47:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0098  */
    /* JADX WARN: Code duplicated, block: B:54:0x009c  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e2 A[PHI: r4 r7 r10 r12
      0x00e2: PHI (r4v21 int) = (r4v11 int), (r4v11 int), (r4v22 int) binds: [B:83:0x00f4, B:73:0x00df, B:74:0x00e1] A[DONT_GENERATE, DONT_INLINE]
      0x00e2: PHI (r7v6 androidx.compose.ui.Modifier) = (r7v3 androidx.compose.ui.Modifier), (r7v2 androidx.compose.ui.Modifier), (r7v2 androidx.compose.ui.Modifier) binds: [B:83:0x00f4, B:73:0x00df, B:74:0x00e1] A[DONT_GENERATE, DONT_INLINE]
      0x00e2: PHI (r10v8 boolean) = (r10v5 boolean), (r10v2 boolean), (r10v2 boolean) binds: [B:83:0x00f4, B:73:0x00df, B:74:0x00e1] A[DONT_GENERATE, DONT_INLINE]
      0x00e2: PHI (r12v7 boolean) = (r12v4 boolean), (r12v2 boolean), (r12v2 boolean) binds: [B:83:0x00f4, B:73:0x00df, B:74:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:76:0x00e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:87:0x010f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0133  */
    /* JADX WARN: Code duplicated, block: B:94:0x0143 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:96:0x0147  */
    /* JADX WARN: Code duplicated, block: B:99:0x017b  */
    /* JADX INFO: renamed from: ItemsStateScreen-V-9fs2A, reason: not valid java name */
    public static final void m11654ItemsStateScreenV9fs2A(final ItemsStateConfig itemsStateConfig, final String testTag, Modifier modifier, boolean z, boolean z2, long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        boolean z4;
        int i7;
        long j2;
        boolean z5;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final boolean z6;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM11499getAppBackgroundAlt0d7_KjU;
        long j4;
        boolean isLandscapePhone;
        boolean z8;
        Object objRememberedValue;
        Modifier.Companion companionM1222paddingqDBjuR0$default;
        Density density;
        Object objRememberedValue2;
        final Measurer measurer;
        Object objRememberedValue3;
        final ConstraintLayoutScope constraintLayoutScope;
        Object objRememberedValue4;
        final MutableState mutableState;
        Object objRememberedValue5;
        final ConstraintSetForInlineDsl constraintSetForInlineDsl;
        Object objRememberedValue6;
        final MutableState mutableState2;
        boolean zChangedInstance;
        MeasurePolicy measurePolicy;
        Object objRememberedValue7;
        boolean zChangedInstance2;
        Object objRememberedValue8;
        Intrinsics.checkNotNullParameter(itemsStateConfig, "itemsStateConfig");
        Intrinsics.checkNotNullParameter(testTag, "testTag");
        Composer composerStartRestartGroup = composer.startRestartGroup(1595628288);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemsStateScreen)N(itemsStateConfig,testTag,modifier,shouldCenter,isRedesignedVersion,backgroundColor:c#ui.graphics.Color)114@4341L21,121@4597L2,117@4432L3141:ItemStateScreens.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(itemsStateConfig) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(testTag) ? 32 : 16;
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
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((196608 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            j2 = j;
                            int i9 = composerStartRestartGroup.changed(j2) ? 131072 : 65536;
                            i3 |= i9;
                        } else {
                            j2 = j;
                        }
                        i3 |= i9;
                    } else {
                        j2 = j;
                    }
                    if ((74899 & i3) != 74898) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                z4 = false;
                            }
                            if ((i2 & 32) != 0) {
                                if (z4) {
                                    composerStartRestartGroup.startReplaceGroup(95468557);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                                    jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(95469680);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                                    jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                i3 &= -458753;
                                j4 = jM11499getAppBackgroundAlt0d7_KjU;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1595628288, i3, -1, "com.box.android.base.compose.ItemsStateScreen (ItemStateScreens.kt:113)");
                            }
                            isLandscapePhone = ComposeUtilsKt.getIsLandscapePhone(composerStartRestartGroup, 0);
                            if (z3 || isLandscapePhone) {
                                z8 = false;
                            } else {
                                z8 = true;
                            }
                            composerStartRestartGroup.startReplaceGroup(95480950);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*124@4716L21");
                            Modifier modifierTestTag = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, j4, null, 2, null), testTag);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 95479394, "CC(remember):ItemStateScreens.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierThen = SemanticsModifierKt.semantics(modifierTestTag, true, (Function1) objRememberedValue).then(modifier2);
                            if (isLandscapePhone) {
                                companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(24), 7, null);
                            } else {
                                companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                            }
                            Modifier modifierThen2 = modifierThen.then(companionM1222paddingqDBjuR0$default);
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(-1003410150);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
                            composerStartRestartGroup.startReplaceGroup(212064437);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
                            composerStartRestartGroup.endReplaceGroup();
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Measurer(density);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            measurer = (Measurer) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new ConstraintLayoutScope();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            constraintLayoutScope = (ConstraintLayoutScope) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            mutableState = (MutableState) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            mutableState2 = (MutableState) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
                            zChangedInstance = composerStartRestartGroup.changedInstance(measurer) | composerStartRestartGroup.changed(257);
                            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                final int i10 = 257;
                                measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                    /* JADX INFO: renamed from: measure-3p2s80s */
                                    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List<? extends Measurable> list, long j5) {
                                        mutableState2.getValue();
                                        long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i10);
                                        mutableState.getValue();
                                        int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                                        int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                                        final Measurer measurer2 = measurer;
                                        return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                invoke2(placementScope);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                                measurer2.performLayout(placementScope, list);
                                            }
                                        }, 4, null);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(measurePolicy);
                            } else {
                                measurePolicy = objRememberedValue9;
                            }
                            MeasurePolicy measurePolicy2 = (MeasurePolicy) measurePolicy;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        MutableState mutableState3 = mutableState;
                                        mutableState3.setValue(Boolean.valueOf(!((Boolean) mutableState3.getValue()).booleanValue()));
                                        constraintSetForInlineDsl.setKnownDirty(true);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            final Function0 function0 = (Function0) objRememberedValue7;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
                            zChangedInstance2 = composerStartRestartGroup.changedInstance(measurer);
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final boolean z9 = z8;
                            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierThen2, false, (Function1) objRememberedValue8, 1, null), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new Function2<Composer, Integer, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11) {
                                    int i12;
                                    float f;
                                    int i13;
                                    ComposerKt.sourceInformation(composer3, "C457@20608L9,462@20943L28:ConstraintLayout.kt#fysre8");
                                    if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1200550679, i11, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                                        }
                                        mutableState2.setValue(Unit.INSTANCE);
                                        int helpersHashCode = constraintLayoutScope.getHelpersHashCode();
                                        constraintLayoutScope.reset();
                                        ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                                        composer3.startReplaceGroup(1475404531);
                                        ComposerKt.sourceInformation(composer3, "C130@4895L44,133@5053L286,129@4866L548,146@5554L265,143@5423L2144:ItemStateScreens.kt#vejmn0");
                                        ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope2.createRefs();
                                        ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
                                        ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
                                        Painter painterPainterResource = PainterResources_androidKt.painterResource(itemsStateConfig.getDrawableId(), composer3, 0);
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 1710167047, "CC(remember):ItemStateScreens.kt#9igjgp");
                                        boolean zChanged = composer3.changed(z9) | composer3.changed(constrainedLayoutReferenceComponent1);
                                        ItemStateScreensKt$ItemsStateScreen$3$1$1 itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = composer3.rememberedValue();
                                        if (zChanged || itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                            itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$1$1(z9, constrainedLayoutReferenceComponent1);
                                            composer3.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ImageKt.Image(painterPainterResource, (String) null, TestTagKt.testTag(constraintLayoutScope2.constrainAs(companion, constrainedLayoutReferenceComponent2, (Function1) itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue), String.valueOf(itemsStateConfig.getDrawableId())), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer3, Painter.$stable | 48, 120);
                                        Composer composer4 = composer3;
                                        float f2 = 24;
                                        Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), 0.0f, 2, null);
                                        ComposerKt.sourceInformationMarkerStart(composer4, 1710183058, "CC(remember):ItemStateScreens.kt#9igjgp");
                                        boolean zChanged2 = composer4.changed(z9) | composer4.changed(constrainedLayoutReferenceComponent2);
                                        ItemStateScreensKt$ItemsStateScreen$3$2$1 itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = composer4.rememberedValue();
                                        if (zChanged2 || itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                            itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$2$1(z9, constrainedLayoutReferenceComponent2);
                                            composer4.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        Modifier modifierConstrainAs = constraintLayoutScope2.constrainAs(modifierM1220paddingVpY3zN4$default, constrainedLayoutReferenceComponent1, (Function1) itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                        ComposerKt.sourceInformationMarkerStart(composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer4, 48);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierConstrainAs);
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer4);
                                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer4, -1633959809, "C:ItemStateScreens.kt#vejmn0");
                                        if (itemsStateConfig.getMainText() == null) {
                                            composer4.startReplaceGroup(-1633973172);
                                            composer4.endReplaceGroup();
                                            f = f2;
                                            i12 = helpersHashCode;
                                        } else {
                                            composer4.startReplaceGroup(-1633973171);
                                            ComposerKt.sourceInformation(composer4, "*162@6240L6,157@5957L318");
                                            i12 = helpersHashCode;
                                            f = f2;
                                            TextKt.m4494TextNvy7gAk(itemsStateConfig.getMainText(), TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer3, 48, 12582912, 130040);
                                            composer4 = composer3;
                                            composer4.endReplaceGroup();
                                        }
                                        String subText = itemsStateConfig.getSubText();
                                        if (subText == null) {
                                            composer4.startReplaceGroup(-1633581363);
                                        } else {
                                            composer4.startReplaceGroup(-1633581362);
                                            ComposerKt.sourceInformation(composer4, "*167@6351L30,173@6661L6,168@6398L302");
                                            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer4, 6);
                                            TextKt.m4494TextNvy7gAk(subText, TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenSubMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11543getPopupSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer3, 48, 12582912, 130040);
                                            composer4 = composer3;
                                        }
                                        composer4.endReplaceGroup();
                                        ButtonItem.TextButtonItem actionItem = itemsStateConfig.getActionItem();
                                        if (actionItem == null) {
                                            composer4.startReplaceGroup(-1633143922);
                                            composer4.endReplaceGroup();
                                            i13 = 6;
                                        } else {
                                            composer4.startReplaceGroup(-1633143921);
                                            ComposerKt.sourceInformation(composer4, "*178@6779L30,185@7141L6,186@7213L6,184@7069L183,179@6826L717");
                                            i13 = 6;
                                            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer4, 6);
                                            composer4 = composer3;
                                            BoxOutlinedButtonKt.BoxOutlinedButton(new ButtonItem.TextButtonItem(false, actionItem.getOnClick(), actionItem.getTextRes(), 1, null), null, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6)), ButtonDefaults.INSTANCE.m2876outlinedButtonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composer4, 6).m11516getDialogContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), 0L, 0L, composer3, ButtonDefaults.$stable << 12, 12), BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU()), BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer4, 221184, 2);
                                            composer4.endReplaceGroup();
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endReplaceGroup();
                                        if (constraintLayoutScope.getHelpersHashCode() != i12) {
                                            EffectsKt.SideEffect(function0, composer4, i13);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, composerStartRestartGroup, 54), measurePolicy2, composerStartRestartGroup, 48, 0);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            j3 = j4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                        }
                        j4 = j2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1595628288, i3, -1, "com.box.android.base.compose.ItemsStateScreen (ItemStateScreens.kt:113)");
                        }
                        isLandscapePhone = ComposeUtilsKt.getIsLandscapePhone(composerStartRestartGroup, 0);
                        if (z3) {
                            z8 = false;
                        } else {
                            z8 = false;
                        }
                        composerStartRestartGroup.startReplaceGroup(95480950);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*124@4716L21");
                        Modifier modifierTestTag2 = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, j4, null, 2, null), testTag);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 95479394, "CC(remember):ItemStateScreens.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierThen3 = SemanticsModifierKt.semantics(modifierTestTag2, true, (Function1) objRememberedValue).then(modifier2);
                        if (isLandscapePhone) {
                            companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(24), 7, null);
                        } else {
                            companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                        }
                        Modifier modifierThen4 = modifierThen3.then(companionM1222paddingqDBjuR0$default);
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-1003410150);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
                        composerStartRestartGroup.startReplaceGroup(212064437);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
                        composerStartRestartGroup.endReplaceGroup();
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume2;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Measurer(density);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        measurer = (Measurer) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new ConstraintLayoutScope();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        constraintLayoutScope = (ConstraintLayoutScope) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        mutableState = (MutableState) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        mutableState2 = (MutableState) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
                        zChangedInstance = composerStartRestartGroup.changedInstance(measurer) | composerStartRestartGroup.changed(257);
                        Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            final int i11 = 257;
                            measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                                @Override // androidx.compose.ui.layout.MeasurePolicy
                                /* JADX INFO: renamed from: measure-3p2s80s */
                                public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                                    mutableState2.getValue();
                                    long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i11);
                                    mutableState.getValue();
                                    int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                                    int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                                    final Measurer measurer2 = measurer;
                                    return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                            invoke2(placementScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(Placeable.PlacementScope placementScope) {
                                            measurer2.performLayout(placementScope, list);
                                        }
                                    }, 4, null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicy);
                        } else {
                            final int i12 = 257;
                            measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                                @Override // androidx.compose.ui.layout.MeasurePolicy
                                /* JADX INFO: renamed from: measure-3p2s80s */
                                public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                                    mutableState2.getValue();
                                    long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i12);
                                    mutableState.getValue();
                                    int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                                    int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                                    final Measurer measurer2 = measurer;
                                    return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                            invoke2(placementScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(Placeable.PlacementScope placementScope) {
                                            measurer2.performLayout(placementScope, list);
                                        }
                                    }, 4, null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicy);
                        }
                        MeasurePolicy measurePolicy3 = (MeasurePolicy) measurePolicy;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    MutableState mutableState3 = mutableState;
                                    mutableState3.setValue(Boolean.valueOf(!((Boolean) mutableState3.getValue()).booleanValue()));
                                    constraintSetForInlineDsl.setKnownDirty(true);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        final Function0 function1 = (Function0) objRememberedValue7;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(measurer);
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance2) {
                            objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final boolean z10 = z8;
                        LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierThen4, false, (Function1) objRememberedValue8, 1, null), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new Function2<Composer, Integer, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                int i14;
                                float f;
                                int i15;
                                ComposerKt.sourceInformation(composer3, "C457@20608L9,462@20943L28:ConstraintLayout.kt#fysre8");
                                if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1200550679, i13, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                                    }
                                    mutableState2.setValue(Unit.INSTANCE);
                                    int helpersHashCode = constraintLayoutScope.getHelpersHashCode();
                                    constraintLayoutScope.reset();
                                    ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                                    composer3.startReplaceGroup(1475404531);
                                    ComposerKt.sourceInformation(composer3, "C130@4895L44,133@5053L286,129@4866L548,146@5554L265,143@5423L2144:ItemStateScreens.kt#vejmn0");
                                    ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope2.createRefs();
                                    ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
                                    ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
                                    Painter painterPainterResource = PainterResources_androidKt.painterResource(itemsStateConfig.getDrawableId(), composer3, 0);
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 1710167047, "CC(remember):ItemStateScreens.kt#9igjgp");
                                    boolean zChanged = composer3.changed(z10) | composer3.changed(constrainedLayoutReferenceComponent1);
                                    ItemStateScreensKt$ItemsStateScreen$3$1$1 itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = composer3.rememberedValue();
                                    if (zChanged || itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$1$1(z10, constrainedLayoutReferenceComponent1);
                                        composer3.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ImageKt.Image(painterPainterResource, (String) null, TestTagKt.testTag(constraintLayoutScope2.constrainAs(companion, constrainedLayoutReferenceComponent2, (Function1) itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue), String.valueOf(itemsStateConfig.getDrawableId())), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer3, Painter.$stable | 48, 120);
                                    Composer composer4 = composer3;
                                    float f2 = 24;
                                    Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), 0.0f, 2, null);
                                    ComposerKt.sourceInformationMarkerStart(composer4, 1710183058, "CC(remember):ItemStateScreens.kt#9igjgp");
                                    boolean zChanged2 = composer4.changed(z10) | composer4.changed(constrainedLayoutReferenceComponent2);
                                    ItemStateScreensKt$ItemsStateScreen$3$2$1 itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = composer4.rememberedValue();
                                    if (zChanged2 || itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$2$1(z10, constrainedLayoutReferenceComponent2);
                                        composer4.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    Modifier modifierConstrainAs = constraintLayoutScope2.constrainAs(modifierM1220paddingVpY3zN4$default, constrainedLayoutReferenceComponent1, (Function1) itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                    ComposerKt.sourceInformationMarkerStart(composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer4, 48);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierConstrainAs);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer4);
                                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                    Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1633959809, "C:ItemStateScreens.kt#vejmn0");
                                    if (itemsStateConfig.getMainText() == null) {
                                        composer4.startReplaceGroup(-1633973172);
                                        composer4.endReplaceGroup();
                                        f = f2;
                                        i14 = helpersHashCode;
                                    } else {
                                        composer4.startReplaceGroup(-1633973171);
                                        ComposerKt.sourceInformation(composer4, "*162@6240L6,157@5957L318");
                                        i14 = helpersHashCode;
                                        f = f2;
                                        TextKt.m4494TextNvy7gAk(itemsStateConfig.getMainText(), TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer3, 48, 12582912, 130040);
                                        composer4 = composer3;
                                        composer4.endReplaceGroup();
                                    }
                                    String subText = itemsStateConfig.getSubText();
                                    if (subText == null) {
                                        composer4.startReplaceGroup(-1633581363);
                                    } else {
                                        composer4.startReplaceGroup(-1633581362);
                                        ComposerKt.sourceInformation(composer4, "*167@6351L30,173@6661L6,168@6398L302");
                                        SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer4, 6);
                                        TextKt.m4494TextNvy7gAk(subText, TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenSubMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11543getPopupSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer3, 48, 12582912, 130040);
                                        composer4 = composer3;
                                    }
                                    composer4.endReplaceGroup();
                                    ButtonItem.TextButtonItem actionItem = itemsStateConfig.getActionItem();
                                    if (actionItem == null) {
                                        composer4.startReplaceGroup(-1633143922);
                                        composer4.endReplaceGroup();
                                        i15 = 6;
                                    } else {
                                        composer4.startReplaceGroup(-1633143921);
                                        ComposerKt.sourceInformation(composer4, "*178@6779L30,185@7141L6,186@7213L6,184@7069L183,179@6826L717");
                                        i15 = 6;
                                        SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer4, 6);
                                        composer4 = composer3;
                                        BoxOutlinedButtonKt.BoxOutlinedButton(new ButtonItem.TextButtonItem(false, actionItem.getOnClick(), actionItem.getTextRes(), 1, null), null, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6)), ButtonDefaults.INSTANCE.m2876outlinedButtonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composer4, 6).m11516getDialogContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), 0L, 0L, composer3, ButtonDefaults.$stable << 12, 12), BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU()), BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer4, 221184, 2);
                                        composer4.endReplaceGroup();
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceGroup();
                                    if (constraintLayoutScope.getHelpersHashCode() != i14) {
                                        EffectsKt.SideEffect(function1, composer4, i15);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), measurePolicy3, composerStartRestartGroup, 48, 0);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        j3 = j4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        j3 = j2;
                    }
                    z6 = z3;
                    z7 = z4;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$3(itemsStateConfig, testTag, modifier3, z6, z7, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                z4 = z2;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j2 = j;
                        if (composerStartRestartGroup.changed(j2)) {
                        }
                        i3 |= i9;
                    } else {
                        j2 = j;
                    }
                    i3 |= i9;
                } else {
                    j2 = j;
                }
                if ((74899 & i3) != 74898) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = false;
                        }
                        if ((i2 & 32) != 0) {
                            if (z4) {
                                composerStartRestartGroup.startReplaceGroup(95468557);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(95469680);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            i3 &= -458753;
                            j4 = jM11499getAppBackgroundAlt0d7_KjU;
                        } else {
                            j4 = j2;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = false;
                        }
                        if ((i2 & 32) != 0) {
                            if (z4) {
                                composerStartRestartGroup.startReplaceGroup(95468557);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(95469680);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            i3 &= -458753;
                            j4 = jM11499getAppBackgroundAlt0d7_KjU;
                        } else {
                            j4 = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1595628288, i3, -1, "com.box.android.base.compose.ItemsStateScreen (ItemStateScreens.kt:113)");
                    }
                    isLandscapePhone = ComposeUtilsKt.getIsLandscapePhone(composerStartRestartGroup, 0);
                    if (z3) {
                        z8 = false;
                    } else {
                        z8 = false;
                    }
                    composerStartRestartGroup.startReplaceGroup(95480950);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*124@4716L21");
                    Modifier modifierTestTag3 = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, j4, null, 2, null), testTag);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 95479394, "CC(remember):ItemStateScreens.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierThen5 = SemanticsModifierKt.semantics(modifierTestTag3, true, (Function1) objRememberedValue).then(modifier2);
                    if (isLandscapePhone) {
                        companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(24), 7, null);
                    } else {
                        companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                    }
                    Modifier modifierThen6 = modifierThen5.then(companionM1222paddingqDBjuR0$default);
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-1003410150);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
                    composerStartRestartGroup.startReplaceGroup(212064437);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
                    composerStartRestartGroup.endReplaceGroup();
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Measurer(density);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    measurer = (Measurer) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new ConstraintLayoutScope();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintLayoutScope = (ConstraintLayoutScope) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    mutableState2 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(measurer) | composerStartRestartGroup.changed(257);
                    Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        final int i13 = 257;
                        measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                                mutableState2.getValue();
                                long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i13);
                                mutableState.getValue();
                                int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                                int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                                final Measurer measurer2 = measurer;
                                return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                        measurer2.performLayout(placementScope, list);
                                    }
                                }, 4, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicy);
                    } else {
                        final int i14 = 257;
                        measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                                mutableState2.getValue();
                                long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i14);
                                mutableState.getValue();
                                int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                                int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                                final Measurer measurer2 = measurer;
                                return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                        measurer2.performLayout(placementScope, list);
                                    }
                                }, 4, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicy);
                    }
                    MeasurePolicy measurePolicy4 = (MeasurePolicy) measurePolicy;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                MutableState mutableState3 = mutableState;
                                mutableState3.setValue(Boolean.valueOf(!((Boolean) mutableState3.getValue()).booleanValue()));
                                constraintSetForInlineDsl.setKnownDirty(true);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    final Function0 function2 = (Function0) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(measurer);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2) {
                        objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final boolean z11 = z8;
                    LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierThen6, false, (Function1) objRememberedValue8, 1, null), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new Function2<Composer, Integer, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i15) {
                            int i16;
                            float f;
                            int i17;
                            ComposerKt.sourceInformation(composer3, "C457@20608L9,462@20943L28:ConstraintLayout.kt#fysre8");
                            if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1200550679, i15, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                                }
                                mutableState2.setValue(Unit.INSTANCE);
                                int helpersHashCode = constraintLayoutScope.getHelpersHashCode();
                                constraintLayoutScope.reset();
                                ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                                composer3.startReplaceGroup(1475404531);
                                ComposerKt.sourceInformation(composer3, "C130@4895L44,133@5053L286,129@4866L548,146@5554L265,143@5423L2144:ItemStateScreens.kt#vejmn0");
                                ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope2.createRefs();
                                ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
                                ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
                                Painter painterPainterResource = PainterResources_androidKt.painterResource(itemsStateConfig.getDrawableId(), composer3, 0);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 1710167047, "CC(remember):ItemStateScreens.kt#9igjgp");
                                boolean zChanged = composer3.changed(z11) | composer3.changed(constrainedLayoutReferenceComponent1);
                                ItemStateScreensKt$ItemsStateScreen$3$1$1 itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = composer3.rememberedValue();
                                if (zChanged || itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$1$1(z11, constrainedLayoutReferenceComponent1);
                                    composer3.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ImageKt.Image(painterPainterResource, (String) null, TestTagKt.testTag(constraintLayoutScope2.constrainAs(companion, constrainedLayoutReferenceComponent2, (Function1) itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue), String.valueOf(itemsStateConfig.getDrawableId())), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer3, Painter.$stable | 48, 120);
                                Composer composer4 = composer3;
                                float f2 = 24;
                                Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), 0.0f, 2, null);
                                ComposerKt.sourceInformationMarkerStart(composer4, 1710183058, "CC(remember):ItemStateScreens.kt#9igjgp");
                                boolean zChanged2 = composer4.changed(z11) | composer4.changed(constrainedLayoutReferenceComponent2);
                                ItemStateScreensKt$ItemsStateScreen$3$2$1 itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = composer4.rememberedValue();
                                if (zChanged2 || itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$2$1(z11, constrainedLayoutReferenceComponent2);
                                    composer4.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                Modifier modifierConstrainAs = constraintLayoutScope2.constrainAs(modifierM1220paddingVpY3zN4$default, constrainedLayoutReferenceComponent1, (Function1) itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                ComposerKt.sourceInformationMarkerStart(composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer4, 48);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierConstrainAs);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer4);
                                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, -1633959809, "C:ItemStateScreens.kt#vejmn0");
                                if (itemsStateConfig.getMainText() == null) {
                                    composer4.startReplaceGroup(-1633973172);
                                    composer4.endReplaceGroup();
                                    f = f2;
                                    i16 = helpersHashCode;
                                } else {
                                    composer4.startReplaceGroup(-1633973171);
                                    ComposerKt.sourceInformation(composer4, "*162@6240L6,157@5957L318");
                                    i16 = helpersHashCode;
                                    f = f2;
                                    TextKt.m4494TextNvy7gAk(itemsStateConfig.getMainText(), TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer3, 48, 12582912, 130040);
                                    composer4 = composer3;
                                    composer4.endReplaceGroup();
                                }
                                String subText = itemsStateConfig.getSubText();
                                if (subText == null) {
                                    composer4.startReplaceGroup(-1633581363);
                                } else {
                                    composer4.startReplaceGroup(-1633581362);
                                    ComposerKt.sourceInformation(composer4, "*167@6351L30,173@6661L6,168@6398L302");
                                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer4, 6);
                                    TextKt.m4494TextNvy7gAk(subText, TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenSubMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11543getPopupSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer3, 48, 12582912, 130040);
                                    composer4 = composer3;
                                }
                                composer4.endReplaceGroup();
                                ButtonItem.TextButtonItem actionItem = itemsStateConfig.getActionItem();
                                if (actionItem == null) {
                                    composer4.startReplaceGroup(-1633143922);
                                    composer4.endReplaceGroup();
                                    i17 = 6;
                                } else {
                                    composer4.startReplaceGroup(-1633143921);
                                    ComposerKt.sourceInformation(composer4, "*178@6779L30,185@7141L6,186@7213L6,184@7069L183,179@6826L717");
                                    i17 = 6;
                                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer4, 6);
                                    composer4 = composer3;
                                    BoxOutlinedButtonKt.BoxOutlinedButton(new ButtonItem.TextButtonItem(false, actionItem.getOnClick(), actionItem.getTextRes(), 1, null), null, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6)), ButtonDefaults.INSTANCE.m2876outlinedButtonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composer4, 6).m11516getDialogContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), 0L, 0L, composer3, ButtonDefaults.$stable << 12, 12), BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU()), BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer4, 221184, 2);
                                    composer4.endReplaceGroup();
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceGroup();
                                if (constraintLayoutScope.getHelpersHashCode() != i16) {
                                    EffectsKt.SideEffect(function2, composer4, i17);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), measurePolicy4, composerStartRestartGroup, 48, 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    j3 = j4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = j2;
                }
                z6 = z3;
                z7 = z4;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$3(itemsStateConfig, testTag, modifier3, z6, z7, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z3 = z;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j2 = j;
                        if (composerStartRestartGroup.changed(j2)) {
                        }
                        i3 |= i9;
                    } else {
                        j2 = j;
                    }
                    i3 |= i9;
                } else {
                    j2 = j;
                }
                if ((74899 & i3) != 74898) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = false;
                        }
                        if ((i2 & 32) != 0) {
                            if (z4) {
                                composerStartRestartGroup.startReplaceGroup(95468557);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(95469680);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            i3 &= -458753;
                            j4 = jM11499getAppBackgroundAlt0d7_KjU;
                        } else {
                            j4 = j2;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = false;
                        }
                        if ((i2 & 32) != 0) {
                            if (z4) {
                                composerStartRestartGroup.startReplaceGroup(95468557);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(95469680);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            i3 &= -458753;
                            j4 = jM11499getAppBackgroundAlt0d7_KjU;
                        } else {
                            j4 = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1595628288, i3, -1, "com.box.android.base.compose.ItemsStateScreen (ItemStateScreens.kt:113)");
                    }
                    isLandscapePhone = ComposeUtilsKt.getIsLandscapePhone(composerStartRestartGroup, 0);
                    if (z3) {
                        z8 = false;
                    } else {
                        z8 = false;
                    }
                    composerStartRestartGroup.startReplaceGroup(95480950);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*124@4716L21");
                    Modifier modifierTestTag4 = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, j4, null, 2, null), testTag);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 95479394, "CC(remember):ItemStateScreens.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierThen7 = SemanticsModifierKt.semantics(modifierTestTag4, true, (Function1) objRememberedValue).then(modifier2);
                    if (isLandscapePhone) {
                        companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(24), 7, null);
                    } else {
                        companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                    }
                    Modifier modifierThen8 = modifierThen7.then(companionM1222paddingqDBjuR0$default);
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-1003410150);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
                    composerStartRestartGroup.startReplaceGroup(212064437);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
                    composerStartRestartGroup.endReplaceGroup();
                    ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume4;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Measurer(density);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    measurer = (Measurer) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new ConstraintLayoutScope();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintLayoutScope = (ConstraintLayoutScope) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    mutableState2 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(measurer) | composerStartRestartGroup.changed(257);
                    Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        final int i15 = 257;
                        measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                                mutableState2.getValue();
                                long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i15);
                                mutableState.getValue();
                                int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                                int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                                final Measurer measurer2 = measurer;
                                return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                        measurer2.performLayout(placementScope, list);
                                    }
                                }, 4, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicy);
                    } else {
                        final int i16 = 257;
                        measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                                mutableState2.getValue();
                                long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i16);
                                mutableState.getValue();
                                int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                                int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                                final Measurer measurer2 = measurer;
                                return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                        measurer2.performLayout(placementScope, list);
                                    }
                                }, 4, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicy);
                    }
                    MeasurePolicy measurePolicy5 = (MeasurePolicy) measurePolicy;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                MutableState mutableState3 = mutableState;
                                mutableState3.setValue(Boolean.valueOf(!((Boolean) mutableState3.getValue()).booleanValue()));
                                constraintSetForInlineDsl.setKnownDirty(true);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    final Function0 function3 = (Function0) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(measurer);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2) {
                        objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final boolean z12 = z8;
                    LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierThen8, false, (Function1) objRememberedValue8, 1, null), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new Function2<Composer, Integer, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i17) {
                            int i18;
                            float f;
                            int i19;
                            ComposerKt.sourceInformation(composer3, "C457@20608L9,462@20943L28:ConstraintLayout.kt#fysre8");
                            if ((i17 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1200550679, i17, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                                }
                                mutableState2.setValue(Unit.INSTANCE);
                                int helpersHashCode = constraintLayoutScope.getHelpersHashCode();
                                constraintLayoutScope.reset();
                                ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                                composer3.startReplaceGroup(1475404531);
                                ComposerKt.sourceInformation(composer3, "C130@4895L44,133@5053L286,129@4866L548,146@5554L265,143@5423L2144:ItemStateScreens.kt#vejmn0");
                                ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope2.createRefs();
                                ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
                                ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
                                Painter painterPainterResource = PainterResources_androidKt.painterResource(itemsStateConfig.getDrawableId(), composer3, 0);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 1710167047, "CC(remember):ItemStateScreens.kt#9igjgp");
                                boolean zChanged = composer3.changed(z12) | composer3.changed(constrainedLayoutReferenceComponent1);
                                ItemStateScreensKt$ItemsStateScreen$3$1$1 itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = composer3.rememberedValue();
                                if (zChanged || itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$1$1(z12, constrainedLayoutReferenceComponent1);
                                    composer3.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ImageKt.Image(painterPainterResource, (String) null, TestTagKt.testTag(constraintLayoutScope2.constrainAs(companion, constrainedLayoutReferenceComponent2, (Function1) itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue), String.valueOf(itemsStateConfig.getDrawableId())), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer3, Painter.$stable | 48, 120);
                                Composer composer4 = composer3;
                                float f2 = 24;
                                Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), 0.0f, 2, null);
                                ComposerKt.sourceInformationMarkerStart(composer4, 1710183058, "CC(remember):ItemStateScreens.kt#9igjgp");
                                boolean zChanged2 = composer4.changed(z12) | composer4.changed(constrainedLayoutReferenceComponent2);
                                ItemStateScreensKt$ItemsStateScreen$3$2$1 itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = composer4.rememberedValue();
                                if (zChanged2 || itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$2$1(z12, constrainedLayoutReferenceComponent2);
                                    composer4.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                Modifier modifierConstrainAs = constraintLayoutScope2.constrainAs(modifierM1220paddingVpY3zN4$default, constrainedLayoutReferenceComponent1, (Function1) itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                ComposerKt.sourceInformationMarkerStart(composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer4, 48);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierConstrainAs);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer4);
                                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, -1633959809, "C:ItemStateScreens.kt#vejmn0");
                                if (itemsStateConfig.getMainText() == null) {
                                    composer4.startReplaceGroup(-1633973172);
                                    composer4.endReplaceGroup();
                                    f = f2;
                                    i18 = helpersHashCode;
                                } else {
                                    composer4.startReplaceGroup(-1633973171);
                                    ComposerKt.sourceInformation(composer4, "*162@6240L6,157@5957L318");
                                    i18 = helpersHashCode;
                                    f = f2;
                                    TextKt.m4494TextNvy7gAk(itemsStateConfig.getMainText(), TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer3, 48, 12582912, 130040);
                                    composer4 = composer3;
                                    composer4.endReplaceGroup();
                                }
                                String subText = itemsStateConfig.getSubText();
                                if (subText == null) {
                                    composer4.startReplaceGroup(-1633581363);
                                } else {
                                    composer4.startReplaceGroup(-1633581362);
                                    ComposerKt.sourceInformation(composer4, "*167@6351L30,173@6661L6,168@6398L302");
                                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer4, 6);
                                    TextKt.m4494TextNvy7gAk(subText, TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenSubMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11543getPopupSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer3, 48, 12582912, 130040);
                                    composer4 = composer3;
                                }
                                composer4.endReplaceGroup();
                                ButtonItem.TextButtonItem actionItem = itemsStateConfig.getActionItem();
                                if (actionItem == null) {
                                    composer4.startReplaceGroup(-1633143922);
                                    composer4.endReplaceGroup();
                                    i19 = 6;
                                } else {
                                    composer4.startReplaceGroup(-1633143921);
                                    ComposerKt.sourceInformation(composer4, "*178@6779L30,185@7141L6,186@7213L6,184@7069L183,179@6826L717");
                                    i19 = 6;
                                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer4, 6);
                                    composer4 = composer3;
                                    BoxOutlinedButtonKt.BoxOutlinedButton(new ButtonItem.TextButtonItem(false, actionItem.getOnClick(), actionItem.getTextRes(), 1, null), null, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6)), ButtonDefaults.INSTANCE.m2876outlinedButtonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composer4, 6).m11516getDialogContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), 0L, 0L, composer3, ButtonDefaults.$stable << 12, 12), BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU()), BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer4, 221184, 2);
                                    composer4.endReplaceGroup();
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceGroup();
                                if (constraintLayoutScope.getHelpersHashCode() != i18) {
                                    EffectsKt.SideEffect(function3, composer4, i19);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), measurePolicy5, composerStartRestartGroup, 48, 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    j3 = j4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = j2;
                }
                z6 = z3;
                z7 = z4;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$3(itemsStateConfig, testTag, modifier3, z6, z7, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z4 = z2;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j2 = j;
                    if (composerStartRestartGroup.changed(j2)) {
                    }
                    i3 |= i9;
                } else {
                    j2 = j;
                }
                i3 |= i9;
            } else {
                j2 = j;
            }
            if ((74899 & i3) != 74898) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = false;
                    }
                    if ((i2 & 32) != 0) {
                        if (z4) {
                            composerStartRestartGroup.startReplaceGroup(95468557);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                            jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(95469680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                            jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        i3 &= -458753;
                        j4 = jM11499getAppBackgroundAlt0d7_KjU;
                    } else {
                        j4 = j2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = false;
                    }
                    if ((i2 & 32) != 0) {
                        if (z4) {
                            composerStartRestartGroup.startReplaceGroup(95468557);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                            jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(95469680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                            jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        i3 &= -458753;
                        j4 = jM11499getAppBackgroundAlt0d7_KjU;
                    } else {
                        j4 = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1595628288, i3, -1, "com.box.android.base.compose.ItemsStateScreen (ItemStateScreens.kt:113)");
                }
                isLandscapePhone = ComposeUtilsKt.getIsLandscapePhone(composerStartRestartGroup, 0);
                if (z3) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                composerStartRestartGroup.startReplaceGroup(95480950);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*124@4716L21");
                Modifier modifierTestTag5 = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, j4, null, 2, null), testTag);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 95479394, "CC(remember):ItemStateScreens.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierThen9 = SemanticsModifierKt.semantics(modifierTestTag5, true, (Function1) objRememberedValue).then(modifier2);
                if (isLandscapePhone) {
                    companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(24), 7, null);
                } else {
                    companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                }
                Modifier modifierThen10 = modifierThen9.then(companionM1222paddingqDBjuR0$default);
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1003410150);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
                composerStartRestartGroup.startReplaceGroup(212064437);
                ComposerKt.sourceInformation(composerStartRestartGroup, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
                composerStartRestartGroup.endReplaceGroup();
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume5;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Measurer(density);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                measurer = (Measurer) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new ConstraintLayoutScope();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintLayoutScope = (ConstraintLayoutScope) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                mutableState2 = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(measurer) | composerStartRestartGroup.changed(257);
                Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    final int i17 = 257;
                    measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                            mutableState2.getValue();
                            long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i17);
                            mutableState.getValue();
                            int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                            int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                            final Measurer measurer2 = measurer;
                            return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                    measurer2.performLayout(placementScope, list);
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicy);
                } else {
                    final int i18 = 257;
                    measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                            mutableState2.getValue();
                            long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i18);
                            mutableState.getValue();
                            int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                            int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                            final Measurer measurer2 = measurer;
                            return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                    measurer2.performLayout(placementScope, list);
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicy);
                }
                MeasurePolicy measurePolicy6 = (MeasurePolicy) measurePolicy;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MutableState mutableState3 = mutableState;
                            mutableState3.setValue(Boolean.valueOf(!((Boolean) mutableState3.getValue()).booleanValue()));
                            constraintSetForInlineDsl.setKnownDirty(true);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                final Function0 function4 = (Function0) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(measurer);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final boolean z13 = z8;
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierThen10, false, (Function1) objRememberedValue8, 1, null), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new Function2<Composer, Integer, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i19) {
                        int i110;
                        float f;
                        int i111;
                        ComposerKt.sourceInformation(composer3, "C457@20608L9,462@20943L28:ConstraintLayout.kt#fysre8");
                        if ((i19 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1200550679, i19, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                            }
                            mutableState2.setValue(Unit.INSTANCE);
                            int helpersHashCode = constraintLayoutScope.getHelpersHashCode();
                            constraintLayoutScope.reset();
                            ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                            composer3.startReplaceGroup(1475404531);
                            ComposerKt.sourceInformation(composer3, "C130@4895L44,133@5053L286,129@4866L548,146@5554L265,143@5423L2144:ItemStateScreens.kt#vejmn0");
                            ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope2.createRefs();
                            ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
                            ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
                            Painter painterPainterResource = PainterResources_androidKt.painterResource(itemsStateConfig.getDrawableId(), composer3, 0);
                            Modifier.Companion companion = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 1710167047, "CC(remember):ItemStateScreens.kt#9igjgp");
                            boolean zChanged = composer3.changed(z13) | composer3.changed(constrainedLayoutReferenceComponent1);
                            ItemStateScreensKt$ItemsStateScreen$3$1$1 itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = composer3.rememberedValue();
                            if (zChanged || itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$1$1(z13, constrainedLayoutReferenceComponent1);
                                composer3.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ImageKt.Image(painterPainterResource, (String) null, TestTagKt.testTag(constraintLayoutScope2.constrainAs(companion, constrainedLayoutReferenceComponent2, (Function1) itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue), String.valueOf(itemsStateConfig.getDrawableId())), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer3, Painter.$stable | 48, 120);
                            Composer composer4 = composer3;
                            float f2 = 24;
                            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), 0.0f, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composer4, 1710183058, "CC(remember):ItemStateScreens.kt#9igjgp");
                            boolean zChanged2 = composer4.changed(z13) | composer4.changed(constrainedLayoutReferenceComponent2);
                            ItemStateScreensKt$ItemsStateScreen$3$2$1 itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = composer4.rememberedValue();
                            if (zChanged2 || itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$2$1(z13, constrainedLayoutReferenceComponent2);
                                composer4.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            Modifier modifierConstrainAs = constraintLayoutScope2.constrainAs(modifierM1220paddingVpY3zN4$default, constrainedLayoutReferenceComponent1, (Function1) itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            ComposerKt.sourceInformationMarkerStart(composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer4, 48);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierConstrainAs);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor);
                            } else {
                                composer4.useNode();
                            }
                            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer4);
                            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, -1633959809, "C:ItemStateScreens.kt#vejmn0");
                            if (itemsStateConfig.getMainText() == null) {
                                composer4.startReplaceGroup(-1633973172);
                                composer4.endReplaceGroup();
                                f = f2;
                                i110 = helpersHashCode;
                            } else {
                                composer4.startReplaceGroup(-1633973171);
                                ComposerKt.sourceInformation(composer4, "*162@6240L6,157@5957L318");
                                i110 = helpersHashCode;
                                f = f2;
                                TextKt.m4494TextNvy7gAk(itemsStateConfig.getMainText(), TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer3, 48, 12582912, 130040);
                                composer4 = composer3;
                                composer4.endReplaceGroup();
                            }
                            String subText = itemsStateConfig.getSubText();
                            if (subText == null) {
                                composer4.startReplaceGroup(-1633581363);
                            } else {
                                composer4.startReplaceGroup(-1633581362);
                                ComposerKt.sourceInformation(composer4, "*167@6351L30,173@6661L6,168@6398L302");
                                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer4, 6);
                                TextKt.m4494TextNvy7gAk(subText, TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenSubMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11543getPopupSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer3, 48, 12582912, 130040);
                                composer4 = composer3;
                            }
                            composer4.endReplaceGroup();
                            ButtonItem.TextButtonItem actionItem = itemsStateConfig.getActionItem();
                            if (actionItem == null) {
                                composer4.startReplaceGroup(-1633143922);
                                composer4.endReplaceGroup();
                                i111 = 6;
                            } else {
                                composer4.startReplaceGroup(-1633143921);
                                ComposerKt.sourceInformation(composer4, "*178@6779L30,185@7141L6,186@7213L6,184@7069L183,179@6826L717");
                                i111 = 6;
                                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer4, 6);
                                composer4 = composer3;
                                BoxOutlinedButtonKt.BoxOutlinedButton(new ButtonItem.TextButtonItem(false, actionItem.getOnClick(), actionItem.getTextRes(), 1, null), null, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6)), ButtonDefaults.INSTANCE.m2876outlinedButtonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composer4, 6).m11516getDialogContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), 0L, 0L, composer3, ButtonDefaults.$stable << 12, 12), BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU()), BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer4, 221184, 2);
                                composer4.endReplaceGroup();
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceGroup();
                            if (constraintLayoutScope.getHelpersHashCode() != i110) {
                                EffectsKt.SideEffect(function4, composer4, i111);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), measurePolicy6, composerStartRestartGroup, 48, 0);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                j3 = j4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = j2;
            }
            z6 = z3;
            z7 = z4;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$3(itemsStateConfig, testTag, modifier3, z6, z7, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j2 = j;
                        if (composerStartRestartGroup.changed(j2)) {
                        }
                        i3 |= i9;
                    } else {
                        j2 = j;
                    }
                    i3 |= i9;
                } else {
                    j2 = j;
                }
                if ((74899 & i3) != 74898) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = false;
                        }
                        if ((i2 & 32) != 0) {
                            if (z4) {
                                composerStartRestartGroup.startReplaceGroup(95468557);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(95469680);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            i3 &= -458753;
                            j4 = jM11499getAppBackgroundAlt0d7_KjU;
                        } else {
                            j4 = j2;
                        }
                    } else {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = false;
                        }
                        if ((i2 & 32) != 0) {
                            if (z4) {
                                composerStartRestartGroup.startReplaceGroup(95468557);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(95469680);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            i3 &= -458753;
                            j4 = jM11499getAppBackgroundAlt0d7_KjU;
                        } else {
                            j4 = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1595628288, i3, -1, "com.box.android.base.compose.ItemsStateScreen (ItemStateScreens.kt:113)");
                    }
                    isLandscapePhone = ComposeUtilsKt.getIsLandscapePhone(composerStartRestartGroup, 0);
                    if (z3) {
                        z8 = false;
                    } else {
                        z8 = false;
                    }
                    composerStartRestartGroup.startReplaceGroup(95480950);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*124@4716L21");
                    Modifier modifierTestTag6 = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, j4, null, 2, null), testTag);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 95479394, "CC(remember):ItemStateScreens.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierThen11 = SemanticsModifierKt.semantics(modifierTestTag6, true, (Function1) objRememberedValue).then(modifier2);
                    if (isLandscapePhone) {
                        companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(24), 7, null);
                    } else {
                        companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                    }
                    Modifier modifierThen12 = modifierThen11.then(companionM1222paddingqDBjuR0$default);
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-1003410150);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
                    composerStartRestartGroup.startReplaceGroup(212064437);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
                    composerStartRestartGroup.endReplaceGroup();
                    ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume6;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Measurer(density);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    measurer = (Measurer) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new ConstraintLayoutScope();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    constraintLayoutScope = (ConstraintLayoutScope) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    mutableState2 = (MutableState) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(measurer) | composerStartRestartGroup.changed(257);
                    Object objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        final int i19 = 257;
                        measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                                mutableState2.getValue();
                                long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i19);
                                mutableState.getValue();
                                int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                                int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                                final Measurer measurer2 = measurer;
                                return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                        measurer2.performLayout(placementScope, list);
                                    }
                                }, 4, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicy);
                    } else {
                        final int i110 = 257;
                        measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                                mutableState2.getValue();
                                long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i110);
                                mutableState.getValue();
                                int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                                int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                                final Measurer measurer2 = measurer;
                                return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                        measurer2.performLayout(placementScope, list);
                                    }
                                }, 4, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicy);
                    }
                    MeasurePolicy measurePolicy7 = (MeasurePolicy) measurePolicy;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                MutableState mutableState3 = mutableState;
                                mutableState3.setValue(Boolean.valueOf(!((Boolean) mutableState3.getValue()).booleanValue()));
                                constraintSetForInlineDsl.setKnownDirty(true);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    final Function0 function5 = (Function0) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(measurer);
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2) {
                        objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final boolean z14 = z8;
                    LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierThen12, false, (Function1) objRememberedValue8, 1, null), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new Function2<Composer, Integer, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i111) {
                            int i112;
                            float f;
                            int i113;
                            ComposerKt.sourceInformation(composer3, "C457@20608L9,462@20943L28:ConstraintLayout.kt#fysre8");
                            if ((i111 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1200550679, i111, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                                }
                                mutableState2.setValue(Unit.INSTANCE);
                                int helpersHashCode = constraintLayoutScope.getHelpersHashCode();
                                constraintLayoutScope.reset();
                                ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                                composer3.startReplaceGroup(1475404531);
                                ComposerKt.sourceInformation(composer3, "C130@4895L44,133@5053L286,129@4866L548,146@5554L265,143@5423L2144:ItemStateScreens.kt#vejmn0");
                                ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope2.createRefs();
                                ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
                                ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
                                Painter painterPainterResource = PainterResources_androidKt.painterResource(itemsStateConfig.getDrawableId(), composer3, 0);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 1710167047, "CC(remember):ItemStateScreens.kt#9igjgp");
                                boolean zChanged = composer3.changed(z14) | composer3.changed(constrainedLayoutReferenceComponent1);
                                ItemStateScreensKt$ItemsStateScreen$3$1$1 itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = composer3.rememberedValue();
                                if (zChanged || itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$1$1(z14, constrainedLayoutReferenceComponent1);
                                    composer3.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ImageKt.Image(painterPainterResource, (String) null, TestTagKt.testTag(constraintLayoutScope2.constrainAs(companion, constrainedLayoutReferenceComponent2, (Function1) itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue), String.valueOf(itemsStateConfig.getDrawableId())), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer3, Painter.$stable | 48, 120);
                                Composer composer4 = composer3;
                                float f2 = 24;
                                Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), 0.0f, 2, null);
                                ComposerKt.sourceInformationMarkerStart(composer4, 1710183058, "CC(remember):ItemStateScreens.kt#9igjgp");
                                boolean zChanged2 = composer4.changed(z14) | composer4.changed(constrainedLayoutReferenceComponent2);
                                ItemStateScreensKt$ItemsStateScreen$3$2$1 itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = composer4.rememberedValue();
                                if (zChanged2 || itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$2$1(z14, constrainedLayoutReferenceComponent2);
                                    composer4.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                Modifier modifierConstrainAs = constraintLayoutScope2.constrainAs(modifierM1220paddingVpY3zN4$default, constrainedLayoutReferenceComponent1, (Function1) itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                                ComposerKt.sourceInformationMarkerStart(composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer4, 48);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierConstrainAs);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer4);
                                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, -1633959809, "C:ItemStateScreens.kt#vejmn0");
                                if (itemsStateConfig.getMainText() == null) {
                                    composer4.startReplaceGroup(-1633973172);
                                    composer4.endReplaceGroup();
                                    f = f2;
                                    i112 = helpersHashCode;
                                } else {
                                    composer4.startReplaceGroup(-1633973171);
                                    ComposerKt.sourceInformation(composer4, "*162@6240L6,157@5957L318");
                                    i112 = helpersHashCode;
                                    f = f2;
                                    TextKt.m4494TextNvy7gAk(itemsStateConfig.getMainText(), TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer3, 48, 12582912, 130040);
                                    composer4 = composer3;
                                    composer4.endReplaceGroup();
                                }
                                String subText = itemsStateConfig.getSubText();
                                if (subText == null) {
                                    composer4.startReplaceGroup(-1633581363);
                                } else {
                                    composer4.startReplaceGroup(-1633581362);
                                    ComposerKt.sourceInformation(composer4, "*167@6351L30,173@6661L6,168@6398L302");
                                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer4, 6);
                                    TextKt.m4494TextNvy7gAk(subText, TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenSubMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11543getPopupSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer3, 48, 12582912, 130040);
                                    composer4 = composer3;
                                }
                                composer4.endReplaceGroup();
                                ButtonItem.TextButtonItem actionItem = itemsStateConfig.getActionItem();
                                if (actionItem == null) {
                                    composer4.startReplaceGroup(-1633143922);
                                    composer4.endReplaceGroup();
                                    i113 = 6;
                                } else {
                                    composer4.startReplaceGroup(-1633143921);
                                    ComposerKt.sourceInformation(composer4, "*178@6779L30,185@7141L6,186@7213L6,184@7069L183,179@6826L717");
                                    i113 = 6;
                                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer4, 6);
                                    composer4 = composer3;
                                    BoxOutlinedButtonKt.BoxOutlinedButton(new ButtonItem.TextButtonItem(false, actionItem.getOnClick(), actionItem.getTextRes(), 1, null), null, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6)), ButtonDefaults.INSTANCE.m2876outlinedButtonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composer4, 6).m11516getDialogContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), 0L, 0L, composer3, ButtonDefaults.$stable << 12, 12), BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU()), BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer4, 221184, 2);
                                    composer4.endReplaceGroup();
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceGroup();
                                if (constraintLayoutScope.getHelpersHashCode() != i112) {
                                    EffectsKt.SideEffect(function5, composer4, i113);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), measurePolicy7, composerStartRestartGroup, 48, 0);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    j3 = j4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = j2;
                }
                z6 = z3;
                z7 = z4;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$3(itemsStateConfig, testTag, modifier3, z6, z7, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z4 = z2;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j2 = j;
                    if (composerStartRestartGroup.changed(j2)) {
                    }
                    i3 |= i9;
                } else {
                    j2 = j;
                }
                i3 |= i9;
            } else {
                j2 = j;
            }
            if ((74899 & i3) != 74898) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = false;
                    }
                    if ((i2 & 32) != 0) {
                        if (z4) {
                            composerStartRestartGroup.startReplaceGroup(95468557);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                            jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(95469680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                            jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        i3 &= -458753;
                        j4 = jM11499getAppBackgroundAlt0d7_KjU;
                    } else {
                        j4 = j2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = false;
                    }
                    if ((i2 & 32) != 0) {
                        if (z4) {
                            composerStartRestartGroup.startReplaceGroup(95468557);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                            jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(95469680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                            jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        i3 &= -458753;
                        j4 = jM11499getAppBackgroundAlt0d7_KjU;
                    } else {
                        j4 = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1595628288, i3, -1, "com.box.android.base.compose.ItemsStateScreen (ItemStateScreens.kt:113)");
                }
                isLandscapePhone = ComposeUtilsKt.getIsLandscapePhone(composerStartRestartGroup, 0);
                if (z3) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                composerStartRestartGroup.startReplaceGroup(95480950);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*124@4716L21");
                Modifier modifierTestTag7 = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, j4, null, 2, null), testTag);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 95479394, "CC(remember):ItemStateScreens.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierThen13 = SemanticsModifierKt.semantics(modifierTestTag7, true, (Function1) objRememberedValue).then(modifier2);
                if (isLandscapePhone) {
                    companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(24), 7, null);
                } else {
                    companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                }
                Modifier modifierThen14 = modifierThen13.then(companionM1222paddingqDBjuR0$default);
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1003410150);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
                composerStartRestartGroup.startReplaceGroup(212064437);
                ComposerKt.sourceInformation(composerStartRestartGroup, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
                composerStartRestartGroup.endReplaceGroup();
                ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume7;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Measurer(density);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                measurer = (Measurer) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new ConstraintLayoutScope();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintLayoutScope = (ConstraintLayoutScope) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                mutableState2 = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(measurer) | composerStartRestartGroup.changed(257);
                Object objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    final int i111 = 257;
                    measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                            mutableState2.getValue();
                            long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i111);
                            mutableState.getValue();
                            int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                            int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                            final Measurer measurer2 = measurer;
                            return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                    measurer2.performLayout(placementScope, list);
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicy);
                } else {
                    final int i112 = 257;
                    measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                            mutableState2.getValue();
                            long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i112);
                            mutableState.getValue();
                            int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                            int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                            final Measurer measurer2 = measurer;
                            return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                    measurer2.performLayout(placementScope, list);
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicy);
                }
                MeasurePolicy measurePolicy8 = (MeasurePolicy) measurePolicy;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MutableState mutableState3 = mutableState;
                            mutableState3.setValue(Boolean.valueOf(!((Boolean) mutableState3.getValue()).booleanValue()));
                            constraintSetForInlineDsl.setKnownDirty(true);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                final Function0 function6 = (Function0) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(measurer);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final boolean z15 = z8;
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierThen14, false, (Function1) objRememberedValue8, 1, null), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new Function2<Composer, Integer, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i113) {
                        int i114;
                        float f;
                        int i115;
                        ComposerKt.sourceInformation(composer3, "C457@20608L9,462@20943L28:ConstraintLayout.kt#fysre8");
                        if ((i113 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1200550679, i113, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                            }
                            mutableState2.setValue(Unit.INSTANCE);
                            int helpersHashCode = constraintLayoutScope.getHelpersHashCode();
                            constraintLayoutScope.reset();
                            ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                            composer3.startReplaceGroup(1475404531);
                            ComposerKt.sourceInformation(composer3, "C130@4895L44,133@5053L286,129@4866L548,146@5554L265,143@5423L2144:ItemStateScreens.kt#vejmn0");
                            ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope2.createRefs();
                            ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
                            ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
                            Painter painterPainterResource = PainterResources_androidKt.painterResource(itemsStateConfig.getDrawableId(), composer3, 0);
                            Modifier.Companion companion = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 1710167047, "CC(remember):ItemStateScreens.kt#9igjgp");
                            boolean zChanged = composer3.changed(z15) | composer3.changed(constrainedLayoutReferenceComponent1);
                            ItemStateScreensKt$ItemsStateScreen$3$1$1 itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = composer3.rememberedValue();
                            if (zChanged || itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$1$1(z15, constrainedLayoutReferenceComponent1);
                                composer3.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ImageKt.Image(painterPainterResource, (String) null, TestTagKt.testTag(constraintLayoutScope2.constrainAs(companion, constrainedLayoutReferenceComponent2, (Function1) itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue), String.valueOf(itemsStateConfig.getDrawableId())), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer3, Painter.$stable | 48, 120);
                            Composer composer4 = composer3;
                            float f2 = 24;
                            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), 0.0f, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composer4, 1710183058, "CC(remember):ItemStateScreens.kt#9igjgp");
                            boolean zChanged2 = composer4.changed(z15) | composer4.changed(constrainedLayoutReferenceComponent2);
                            ItemStateScreensKt$ItemsStateScreen$3$2$1 itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = composer4.rememberedValue();
                            if (zChanged2 || itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$2$1(z15, constrainedLayoutReferenceComponent2);
                                composer4.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            Modifier modifierConstrainAs = constraintLayoutScope2.constrainAs(modifierM1220paddingVpY3zN4$default, constrainedLayoutReferenceComponent1, (Function1) itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            ComposerKt.sourceInformationMarkerStart(composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer4, 48);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierConstrainAs);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor);
                            } else {
                                composer4.useNode();
                            }
                            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer4);
                            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, -1633959809, "C:ItemStateScreens.kt#vejmn0");
                            if (itemsStateConfig.getMainText() == null) {
                                composer4.startReplaceGroup(-1633973172);
                                composer4.endReplaceGroup();
                                f = f2;
                                i114 = helpersHashCode;
                            } else {
                                composer4.startReplaceGroup(-1633973171);
                                ComposerKt.sourceInformation(composer4, "*162@6240L6,157@5957L318");
                                i114 = helpersHashCode;
                                f = f2;
                                TextKt.m4494TextNvy7gAk(itemsStateConfig.getMainText(), TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer3, 48, 12582912, 130040);
                                composer4 = composer3;
                                composer4.endReplaceGroup();
                            }
                            String subText = itemsStateConfig.getSubText();
                            if (subText == null) {
                                composer4.startReplaceGroup(-1633581363);
                            } else {
                                composer4.startReplaceGroup(-1633581362);
                                ComposerKt.sourceInformation(composer4, "*167@6351L30,173@6661L6,168@6398L302");
                                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer4, 6);
                                TextKt.m4494TextNvy7gAk(subText, TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenSubMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11543getPopupSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer3, 48, 12582912, 130040);
                                composer4 = composer3;
                            }
                            composer4.endReplaceGroup();
                            ButtonItem.TextButtonItem actionItem = itemsStateConfig.getActionItem();
                            if (actionItem == null) {
                                composer4.startReplaceGroup(-1633143922);
                                composer4.endReplaceGroup();
                                i115 = 6;
                            } else {
                                composer4.startReplaceGroup(-1633143921);
                                ComposerKt.sourceInformation(composer4, "*178@6779L30,185@7141L6,186@7213L6,184@7069L183,179@6826L717");
                                i115 = 6;
                                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer4, 6);
                                composer4 = composer3;
                                BoxOutlinedButtonKt.BoxOutlinedButton(new ButtonItem.TextButtonItem(false, actionItem.getOnClick(), actionItem.getTextRes(), 1, null), null, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6)), ButtonDefaults.INSTANCE.m2876outlinedButtonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composer4, 6).m11516getDialogContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), 0L, 0L, composer3, ButtonDefaults.$stable << 12, 12), BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU()), BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer4, 221184, 2);
                                composer4.endReplaceGroup();
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceGroup();
                            if (constraintLayoutScope.getHelpersHashCode() != i114) {
                                EffectsKt.SideEffect(function6, composer4, i115);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), measurePolicy8, composerStartRestartGroup, 48, 0);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                j3 = j4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = j2;
            }
            z6 = z3;
            z7 = z4;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$3(itemsStateConfig, testTag, modifier3, z6, z7, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z3 = z;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    j2 = j;
                    if (composerStartRestartGroup.changed(j2)) {
                    }
                    i3 |= i9;
                } else {
                    j2 = j;
                }
                i3 |= i9;
            } else {
                j2 = j;
            }
            if ((74899 & i3) != 74898) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = false;
                    }
                    if ((i2 & 32) != 0) {
                        if (z4) {
                            composerStartRestartGroup.startReplaceGroup(95468557);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                            jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(95469680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                            jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        i3 &= -458753;
                        j4 = jM11499getAppBackgroundAlt0d7_KjU;
                    } else {
                        j4 = j2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = false;
                    }
                    if ((i2 & 32) != 0) {
                        if (z4) {
                            composerStartRestartGroup.startReplaceGroup(95468557);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                            jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(95469680);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                            jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        i3 &= -458753;
                        j4 = jM11499getAppBackgroundAlt0d7_KjU;
                    } else {
                        j4 = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1595628288, i3, -1, "com.box.android.base.compose.ItemsStateScreen (ItemStateScreens.kt:113)");
                }
                isLandscapePhone = ComposeUtilsKt.getIsLandscapePhone(composerStartRestartGroup, 0);
                if (z3) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                composerStartRestartGroup.startReplaceGroup(95480950);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*124@4716L21");
                Modifier modifierTestTag8 = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, j4, null, 2, null), testTag);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 95479394, "CC(remember):ItemStateScreens.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierThen15 = SemanticsModifierKt.semantics(modifierTestTag8, true, (Function1) objRememberedValue).then(modifier2);
                if (isLandscapePhone) {
                    companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(24), 7, null);
                } else {
                    companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
                }
                Modifier modifierThen16 = modifierThen15.then(companionM1222paddingqDBjuR0$default);
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1003410150);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
                composerStartRestartGroup.startReplaceGroup(212064437);
                ComposerKt.sourceInformation(composerStartRestartGroup, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
                composerStartRestartGroup.endReplaceGroup();
                ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localDensity8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume8;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Measurer(density);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                measurer = (Measurer) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new ConstraintLayoutScope();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                constraintLayoutScope = (ConstraintLayoutScope) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                mutableState2 = (MutableState) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(measurer) | composerStartRestartGroup.changed(257);
                Object objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    final int i113 = 257;
                    measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                            mutableState2.getValue();
                            long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i113);
                            mutableState.getValue();
                            int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                            int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                            final Measurer measurer2 = measurer;
                            return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                    measurer2.performLayout(placementScope, list);
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicy);
                } else {
                    final int i114 = 257;
                    measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                            mutableState2.getValue();
                            long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i114);
                            mutableState.getValue();
                            int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                            int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                            final Measurer measurer2 = measurer;
                            return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                    measurer2.performLayout(placementScope, list);
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicy);
                }
                MeasurePolicy measurePolicy9 = (MeasurePolicy) measurePolicy;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            MutableState mutableState3 = mutableState;
                            mutableState3.setValue(Boolean.valueOf(!((Boolean) mutableState3.getValue()).booleanValue()));
                            constraintSetForInlineDsl.setKnownDirty(true);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                final Function0 function7 = (Function0) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(measurer);
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2) {
                    objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final boolean z16 = z8;
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierThen16, false, (Function1) objRememberedValue8, 1, null), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new Function2<Composer, Integer, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i115) {
                        int i116;
                        float f;
                        int i117;
                        ComposerKt.sourceInformation(composer3, "C457@20608L9,462@20943L28:ConstraintLayout.kt#fysre8");
                        if ((i115 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1200550679, i115, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                            }
                            mutableState2.setValue(Unit.INSTANCE);
                            int helpersHashCode = constraintLayoutScope.getHelpersHashCode();
                            constraintLayoutScope.reset();
                            ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                            composer3.startReplaceGroup(1475404531);
                            ComposerKt.sourceInformation(composer3, "C130@4895L44,133@5053L286,129@4866L548,146@5554L265,143@5423L2144:ItemStateScreens.kt#vejmn0");
                            ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope2.createRefs();
                            ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
                            ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
                            Painter painterPainterResource = PainterResources_androidKt.painterResource(itemsStateConfig.getDrawableId(), composer3, 0);
                            Modifier.Companion companion = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 1710167047, "CC(remember):ItemStateScreens.kt#9igjgp");
                            boolean zChanged = composer3.changed(z16) | composer3.changed(constrainedLayoutReferenceComponent1);
                            ItemStateScreensKt$ItemsStateScreen$3$1$1 itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = composer3.rememberedValue();
                            if (zChanged || itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$1$1(z16, constrainedLayoutReferenceComponent1);
                                composer3.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ImageKt.Image(painterPainterResource, (String) null, TestTagKt.testTag(constraintLayoutScope2.constrainAs(companion, constrainedLayoutReferenceComponent2, (Function1) itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue), String.valueOf(itemsStateConfig.getDrawableId())), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer3, Painter.$stable | 48, 120);
                            Composer composer4 = composer3;
                            float f2 = 24;
                            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), 0.0f, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composer4, 1710183058, "CC(remember):ItemStateScreens.kt#9igjgp");
                            boolean zChanged2 = composer4.changed(z16) | composer4.changed(constrainedLayoutReferenceComponent2);
                            ItemStateScreensKt$ItemsStateScreen$3$2$1 itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = composer4.rememberedValue();
                            if (zChanged2 || itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$2$1(z16, constrainedLayoutReferenceComponent2);
                                composer4.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            Modifier modifierConstrainAs = constraintLayoutScope2.constrainAs(modifierM1220paddingVpY3zN4$default, constrainedLayoutReferenceComponent1, (Function1) itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                            ComposerKt.sourceInformationMarkerStart(composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer4, 48);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierConstrainAs);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor);
                            } else {
                                composer4.useNode();
                            }
                            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer4);
                            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, -1633959809, "C:ItemStateScreens.kt#vejmn0");
                            if (itemsStateConfig.getMainText() == null) {
                                composer4.startReplaceGroup(-1633973172);
                                composer4.endReplaceGroup();
                                f = f2;
                                i116 = helpersHashCode;
                            } else {
                                composer4.startReplaceGroup(-1633973171);
                                ComposerKt.sourceInformation(composer4, "*162@6240L6,157@5957L318");
                                i116 = helpersHashCode;
                                f = f2;
                                TextKt.m4494TextNvy7gAk(itemsStateConfig.getMainText(), TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer3, 48, 12582912, 130040);
                                composer4 = composer3;
                                composer4.endReplaceGroup();
                            }
                            String subText = itemsStateConfig.getSubText();
                            if (subText == null) {
                                composer4.startReplaceGroup(-1633581363);
                            } else {
                                composer4.startReplaceGroup(-1633581362);
                                ComposerKt.sourceInformation(composer4, "*167@6351L30,173@6661L6,168@6398L302");
                                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer4, 6);
                                TextKt.m4494TextNvy7gAk(subText, TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenSubMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11543getPopupSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer3, 48, 12582912, 130040);
                                composer4 = composer3;
                            }
                            composer4.endReplaceGroup();
                            ButtonItem.TextButtonItem actionItem = itemsStateConfig.getActionItem();
                            if (actionItem == null) {
                                composer4.startReplaceGroup(-1633143922);
                                composer4.endReplaceGroup();
                                i117 = 6;
                            } else {
                                composer4.startReplaceGroup(-1633143921);
                                ComposerKt.sourceInformation(composer4, "*178@6779L30,185@7141L6,186@7213L6,184@7069L183,179@6826L717");
                                i117 = 6;
                                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer4, 6);
                                composer4 = composer3;
                                BoxOutlinedButtonKt.BoxOutlinedButton(new ButtonItem.TextButtonItem(false, actionItem.getOnClick(), actionItem.getTextRes(), 1, null), null, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6)), ButtonDefaults.INSTANCE.m2876outlinedButtonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composer4, 6).m11516getDialogContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), 0L, 0L, composer3, ButtonDefaults.$stable << 12, 12), BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU()), BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer4, 221184, 2);
                                composer4.endReplaceGroup();
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceGroup();
                            if (constraintLayoutScope.getHelpersHashCode() != i116) {
                                EffectsKt.SideEffect(function7, composer4, i117);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), measurePolicy9, composerStartRestartGroup, 48, 0);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                j3 = j4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = j2;
            }
            z6 = z3;
            z7 = z4;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$3(itemsStateConfig, testTag, modifier3, z6, z7, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z4 = z2;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                j2 = j;
                if (composerStartRestartGroup.changed(j2)) {
                }
                i3 |= i9;
            } else {
                j2 = j;
            }
            i3 |= i9;
        } else {
            j2 = j;
        }
        if ((74899 & i3) != 74898) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "");
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    z4 = false;
                }
                if ((i2 & 32) != 0) {
                    if (z4) {
                        composerStartRestartGroup.startReplaceGroup(95468557);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                        jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(95469680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                        jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    i3 &= -458753;
                    j4 = jM11499getAppBackgroundAlt0d7_KjU;
                } else {
                    j4 = j2;
                }
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    z4 = false;
                }
                if ((i2 & 32) != 0) {
                    if (z4) {
                        composerStartRestartGroup.startReplaceGroup(95468557);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "112@4251L6");
                        jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(95469680);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "112@4286L6");
                        jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11499getAppBackgroundAlt0d7_KjU();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    i3 &= -458753;
                    j4 = jM11499getAppBackgroundAlt0d7_KjU;
                } else {
                    j4 = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1595628288, i3, -1, "com.box.android.base.compose.ItemsStateScreen (ItemStateScreens.kt:113)");
            }
            isLandscapePhone = ComposeUtilsKt.getIsLandscapePhone(composerStartRestartGroup, 0);
            if (z3) {
                z8 = false;
            } else {
                z8 = false;
            }
            composerStartRestartGroup.startReplaceGroup(95480950);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*124@4716L21");
            Modifier modifierTestTag9 = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, j4, null, 2, null), testTag);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 95479394, "CC(remember):ItemStateScreens.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierThen17 = SemanticsModifierKt.semantics(modifierTestTag9, true, (Function1) objRememberedValue).then(modifier2);
            if (isLandscapePhone) {
                companionM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(24), 7, null);
            } else {
                companionM1222paddingqDBjuR0$default = Modifier.INSTANCE;
            }
            Modifier modifierThen18 = modifierThen17.then(companionM1222paddingqDBjuR0$default);
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1003410150);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
            composerStartRestartGroup.startReplaceGroup(212064437);
            ComposerKt.sourceInformation(composerStartRestartGroup, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
            composerStartRestartGroup.endReplaceGroup();
            ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume9 = composerStartRestartGroup.consume(localDensity9);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume9;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Measurer(density);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            measurer = (Measurer) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new ConstraintLayoutScope();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            constraintLayoutScope = (ConstraintLayoutScope) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            mutableState = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            mutableState2 = (MutableState) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(measurer) | composerStartRestartGroup.changed(257);
            Object objRememberedValue17 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                final int i115 = 257;
                measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                        mutableState2.getValue();
                        long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i115);
                        mutableState.getValue();
                        int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                        int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                        final Measurer measurer2 = measurer;
                        return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                measurer2.performLayout(placementScope, list);
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicy);
            } else {
                final int i116 = 257;
                measurePolicy = new MeasurePolicy() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, final List list, long j5) {
                        mutableState2.getValue();
                        long jM10087performMeasure2eBlSMk = measurer.m10087performMeasure2eBlSMk(j5, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i116);
                        mutableState.getValue();
                        int iM9858getWidthimpl = IntSize.m9858getWidthimpl(jM10087performMeasure2eBlSMk);
                        int iM9857getHeightimpl = IntSize.m9857getHeightimpl(jM10087performMeasure2eBlSMk);
                        final Measurer measurer2 = measurer;
                        return MeasureScope.layout$default(measureScope, iM9858getWidthimpl, iM9857getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                measurer2.performLayout(placementScope, list);
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicy);
            }
            MeasurePolicy measurePolicy10 = (MeasurePolicy) measurePolicy;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = (Function0) new Function0<Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        MutableState mutableState3 = mutableState;
                        mutableState3.setValue(Boolean.valueOf(!((Boolean) mutableState3.getValue()).booleanValue()));
                        constraintSetForInlineDsl.setKnownDirty(true);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            final Function0 function8 = (Function0) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
            zChangedInstance2 = composerStartRestartGroup.changedInstance(measurer);
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2) {
                objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final boolean z17 = z8;
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierThen18, false, (Function1) objRememberedValue8, 1, null), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new Function2<Composer, Integer, Unit>() { // from class: com.box.android.base.compose.ItemStateScreensKt$ItemsStateScreen-V-9fs2A$$inlined$ConstraintLayout$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i117) {
                    int i118;
                    float f;
                    int i119;
                    ComposerKt.sourceInformation(composer3, "C457@20608L9,462@20943L28:ConstraintLayout.kt#fysre8");
                    if ((i117 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1200550679, i117, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                        }
                        mutableState2.setValue(Unit.INSTANCE);
                        int helpersHashCode = constraintLayoutScope.getHelpersHashCode();
                        constraintLayoutScope.reset();
                        ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                        composer3.startReplaceGroup(1475404531);
                        ComposerKt.sourceInformation(composer3, "C130@4895L44,133@5053L286,129@4866L548,146@5554L265,143@5423L2144:ItemStateScreens.kt#vejmn0");
                        ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope2.createRefs();
                        ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
                        ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
                        Painter painterPainterResource = PainterResources_androidKt.painterResource(itemsStateConfig.getDrawableId(), composer3, 0);
                        Modifier.Companion companion = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 1710167047, "CC(remember):ItemStateScreens.kt#9igjgp");
                        boolean zChanged = composer3.changed(z17) | composer3.changed(constrainedLayoutReferenceComponent1);
                        ItemStateScreensKt$ItemsStateScreen$3$1$1 itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = composer3.rememberedValue();
                        if (zChanged || itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$1$1(z17, constrainedLayoutReferenceComponent1);
                            composer3.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ImageKt.Image(painterPainterResource, (String) null, TestTagKt.testTag(constraintLayoutScope2.constrainAs(companion, constrainedLayoutReferenceComponent2, (Function1) itemStateScreensKt$ItemsStateScreen$3$1$1RememberedValue), String.valueOf(itemsStateConfig.getDrawableId())), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer3, Painter.$stable | 48, 120);
                        Composer composer4 = composer3;
                        float f2 = 24;
                        Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), 0.0f, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composer4, 1710183058, "CC(remember):ItemStateScreens.kt#9igjgp");
                        boolean zChanged2 = composer4.changed(z17) | composer4.changed(constrainedLayoutReferenceComponent2);
                        ItemStateScreensKt$ItemsStateScreen$3$2$1 itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = composer4.rememberedValue();
                        if (zChanged2 || itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue = new ItemStateScreensKt$ItemsStateScreen$3$2$1(z17, constrainedLayoutReferenceComponent2);
                            composer4.updateRememberedValue(itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        Modifier modifierConstrainAs = constraintLayoutScope2.constrainAs(modifierM1220paddingVpY3zN4$default, constrainedLayoutReferenceComponent1, (Function1) itemStateScreensKt$ItemsStateScreen$3$2$1RememberedValue);
                        Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                        ComposerKt.sourceInformationMarkerStart(composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer4, 48);
                        ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierConstrainAs);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!(composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer4.startReusableNode();
                        if (composer4.getInserting()) {
                            composer4.createNode(constructor);
                        } else {
                            composer4.useNode();
                        }
                        Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer4);
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer4, -1633959809, "C:ItemStateScreens.kt#vejmn0");
                        if (itemsStateConfig.getMainText() == null) {
                            composer4.startReplaceGroup(-1633973172);
                            composer4.endReplaceGroup();
                            f = f2;
                            i118 = helpersHashCode;
                        } else {
                            composer4.startReplaceGroup(-1633973171);
                            ComposerKt.sourceInformation(composer4, "*162@6240L6,157@5957L318");
                            i118 = helpersHashCode;
                            f = f2;
                            TextKt.m4494TextNvy7gAk(itemsStateConfig.getMainText(), TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer3, 48, 12582912, 130040);
                            composer4 = composer3;
                            composer4.endReplaceGroup();
                        }
                        String subText = itemsStateConfig.getSubText();
                        if (subText == null) {
                            composer4.startReplaceGroup(-1633581363);
                        } else {
                            composer4.startReplaceGroup(-1633581362);
                            ComposerKt.sourceInformation(composer4, "*167@6351L30,173@6661L6,168@6398L302");
                            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), composer4, 6);
                            TextKt.m4494TextNvy7gAk(subText, TestTagKt.testTag(Modifier.INSTANCE, "ItemStateScreenSubMessage"), BoxTheme.INSTANCE.getColors(composer4, 6).m11543getPopupSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer3, 48, 12582912, 130040);
                            composer4 = composer3;
                        }
                        composer4.endReplaceGroup();
                        ButtonItem.TextButtonItem actionItem = itemsStateConfig.getActionItem();
                        if (actionItem == null) {
                            composer4.startReplaceGroup(-1633143922);
                            composer4.endReplaceGroup();
                            i119 = 6;
                        } else {
                            composer4.startReplaceGroup(-1633143921);
                            ComposerKt.sourceInformation(composer4, "*178@6779L30,185@7141L6,186@7213L6,184@7069L183,179@6826L717");
                            i119 = 6;
                            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer4, 6);
                            composer4 = composer3;
                            BoxOutlinedButtonKt.BoxOutlinedButton(new ButtonItem.TextButtonItem(false, actionItem.getOnClick(), actionItem.getTextRes(), 1, null), null, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(6)), ButtonDefaults.INSTANCE.m2876outlinedButtonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composer4, 6).m11516getDialogContainer0d7_KjU(), BoxTheme.INSTANCE.getColors(composer4, 6).m11500getAppPrimary0d7_KjU(), 0L, 0L, composer3, ButtonDefaults.$stable << 12, 12), BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(1), BoxColorPalette.INSTANCE.m11366getBOX_GRAY_300d7_KjU()), BoxTheme.INSTANCE.getTypography().getBoxMedium16(), composer4, 221184, 2);
                            composer4.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        composer4.endReplaceGroup();
                        if (constraintLayoutScope.getHelpersHashCode() != i118) {
                            EffectsKt.SideEffect(function8, composer4, i119);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), measurePolicy10, composerStartRestartGroup, 48, 0);
            composer2 = composerStartRestartGroup;
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            j3 = j4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = j2;
        }
        z6 = z3;
        z7 = z4;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ItemStateScreensKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemStateScreensKt.ItemsStateScreen_V_9fs2A$lambda$3(itemsStateConfig, testTag, modifier3, z6, z7, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemsStateScreen_V_9fs2A$lambda$0$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        return Unit.INSTANCE;
    }
}
