package com.box.android.jobsui;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.JobInfo;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobStatusIndicator.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f*\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u0010\u001a\u0014\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012*\u00020\u0003H\u0002\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"JobStatusIndicator", "", "status", "Lcom/box/android/jobsui/JobStatusUIState;", "modifier", "Landroidx/compose/ui/Modifier;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "isRedesignedVersion", "", "(Lcom/box/android/jobsui/JobStatusUIState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "getColorAndIconRes", "Lkotlin/Pair;", "Landroidx/compose/ui/graphics/Color;", "", "Lcom/box/android/domain/models/JobInfo$Status;", "(Lcom/box/android/domain/models/JobInfo$Status;ZLandroidx/compose/runtime/Composer;I)Lkotlin/Pair;", "getStatusString", "", "kotlin.jvm.PlatformType", "JobStatusIndicatorSucceededPreview", "(Landroidx/compose/runtime/Composer;I)V", "jobsui_generalProdRelease", "angle", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class JobStatusIndicatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobStatusIndicator$lambda$1(JobStatusUIState jobStatusUIState, Modifier modifier, Function0 function0, boolean z, int i, int i2, Composer composer, int i3) {
        JobStatusIndicator(jobStatusUIState, modifier, function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobStatusIndicatorSucceededPreview$lambda$1(int i, Composer composer, int i2) {
        JobStatusIndicatorSucceededPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Code duplicated, block: B:25:0x0059  */
    /* JADX WARN: Code duplicated, block: B:26:0x005b  */
    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    /* JADX WARN: Code duplicated, block: B:31:0x0065  */
    /* JADX WARN: Code duplicated, block: B:33:0x0069  */
    /* JADX WARN: Code duplicated, block: B:35:0x0071  */
    /* JADX WARN: Code duplicated, block: B:36:0x0074  */
    /* JADX WARN: Code duplicated, block: B:41:0x0081  */
    /* JADX WARN: Code duplicated, block: B:42:0x0083  */
    /* JADX WARN: Code duplicated, block: B:45:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x008e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0093  */
    /* JADX WARN: Code duplicated, block: B:49:0x0096  */
    /* JADX WARN: Code duplicated, block: B:50:0x0098  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:56:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:59:0x0108  */
    /* JADX WARN: Code duplicated, block: B:60:0x010c  */
    /* JADX WARN: Code duplicated, block: B:63:0x019d  */
    /* JADX WARN: Code duplicated, block: B:64:0x019f  */
    /* JADX WARN: Code duplicated, block: B:67:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:69:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:72:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:74:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:76:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:78:0x0220  */
    /* JADX WARN: Code duplicated, block: B:81:0x024b  */
    /* JADX WARN: Code duplicated, block: B:82:0x0299  */
    /* JADX WARN: Code duplicated, block: B:85:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:87:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:90:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    public static final void JobStatusIndicator(final JobStatusUIState status, Modifier modifier, final Function0<Unit> onClick, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        final Modifier modifier3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z5;
        Function0<ComposeUiNode> constructor;
        final Float progress;
        long jM6824unboximpl;
        int iIntValue;
        boolean z6;
        Object objRememberedValue;
        Modifier modifierM632clickableoSLSa3U$default;
        boolean z7;
        int i6;
        int i7;
        Modifier modifierThen;
        boolean zChanged;
        Object objRememberedValue2;
        int i8;
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(2009339894);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(JobStatusIndicator)N(status,modifier,onClick,isRedesignedVersion)39@1554L1742:JobStatusIndicator.kt#6w6mzd");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(status) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(onClick)) {
                    i8 = 256;
                } else {
                    i8 = 128;
                }
                i3 |= i8;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i3 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2009339894, i3, -1, "com.box.android.jobsui.JobStatusIndicator (JobStatusIndicator.kt:38)");
                    }
                    Modifier modifierTestTag = TestTagKt.testTag(companion, "JobStatusIndicator:" + getStatusString(status));
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1439943447, "C45@1793L61,50@1984L20,84@3117L27,83@3088L202:JobStatusIndicator.kt#6w6mzd");
                    progress = status.getProgress();
                    Pair<Color, Integer> colorAndIconRes = getColorAndIconRes(status.getJobStatus(), z5, composerStartRestartGroup, (i3 >> 6) & 112);
                    jM6824unboximpl = colorAndIconRes.component1().m6824unboximpl();
                    iIntValue = colorAndIconRes.component2().intValue();
                    Modifier modifierClip = ClipKt.clip(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(40)), RoundedCornerShapeKt.getCircleShape());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -507732208, "CC(remember):JobStatusIndicator.kt#9igjgp");
                    if ((i3 & 896) == 256) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return JobStatusIndicatorKt.JobStatusIndicator$lambda$0$0$0(onClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(modifierClip, false, null, null, null, (Function0) objRememberedValue, 15, null);
                    if (progress != null) {
                        composerStartRestartGroup.startReplaceGroup(1440296412);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "55@2156L12,54@2105L202");
                        float fM9687constructorimpl = Dp.m9687constructorimpl(2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -507726712, "CC(remember):JobStatusIndicator.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(progress);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(progress.floatValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        z7 = z5;
                        i6 = iIntValue;
                        BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(modifierM632clickableoSLSa3U$default, null, jM6824unboximpl, 0L, fM9687constructorimpl, 0, (Function0) objRememberedValue2, composerStartRestartGroup, 24576, 42);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        z7 = z5;
                        i6 = iIntValue;
                        composerStartRestartGroup.startReplaceGroup(1440581829);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@2394L161");
                        BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(modifierM632clickableoSLSa3U$default, null, jM6824unboximpl, 0L, Dp.m9687constructorimpl(2), 0, null, composerStartRestartGroup, 24576, 106);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (status.getShouldIconBeAnimated()) {
                        composerStartRestartGroup.startReplaceGroup(1440826543);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "70@2672L28,71@2745L235");
                        i7 = 0;
                        modifierThen = companion.then(RotateKt.rotate(companion, JobStatusIndicator$lambda$0$2(InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1), 0.0f, 360.0f, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(3000, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8))));
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        i7 = 0;
                        composerStartRestartGroup.startReplaceGroup(1441224614);
                        composerStartRestartGroup.endReplaceGroup();
                        modifierThen = companion;
                    }
                    ImageKt.Image(PainterResources_androidKt.painterResource(i6, composerStartRestartGroup, i7), (String) null, SizeKt.m1266size3ABfNKs(modifierThen, Dp.m9687constructorimpl(24)), Alignment.INSTANCE.getCenter(), (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable | 3120, 112);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    z4 = z7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return JobStatusIndicatorKt.JobStatusIndicator$lambda$1(status, modifier3, onClick, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2009339894, i3, -1, "com.box.android.jobsui.JobStatusIndicator (JobStatusIndicator.kt:38)");
                }
                Modifier modifierTestTag2 = TestTagKt.testTag(companion, "JobStatusIndicator:" + getStatusString(status));
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1439943447, "C45@1793L61,50@1984L20,84@3117L27,83@3088L202:JobStatusIndicator.kt#6w6mzd");
                progress = status.getProgress();
                Pair<Color, Integer> colorAndIconRes2 = getColorAndIconRes(status.getJobStatus(), z5, composerStartRestartGroup, (i3 >> 6) & 112);
                jM6824unboximpl = colorAndIconRes2.component1().m6824unboximpl();
                iIntValue = colorAndIconRes2.component2().intValue();
                Modifier modifierClip2 = ClipKt.clip(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(40)), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -507732208, "CC(remember):JobStatusIndicator.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobStatusIndicatorKt.JobStatusIndicator$lambda$0$0$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobStatusIndicatorKt.JobStatusIndicator$lambda$0$0$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(modifierClip2, false, null, null, null, (Function0) objRememberedValue, 15, null);
                if (progress != null) {
                    composerStartRestartGroup.startReplaceGroup(1440296412);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "55@2156L12,54@2105L202");
                    float fM9687constructorimpl2 = Dp.m9687constructorimpl(2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -507726712, "CC(remember):JobStatusIndicator.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(progress);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(progress.floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(progress.floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    z7 = z5;
                    i6 = iIntValue;
                    BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(modifierM632clickableoSLSa3U$default, null, jM6824unboximpl, 0L, fM9687constructorimpl2, 0, (Function0) objRememberedValue2, composerStartRestartGroup, 24576, 42);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    z7 = z5;
                    i6 = iIntValue;
                    composerStartRestartGroup.startReplaceGroup(1440581829);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@2394L161");
                    BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(modifierM632clickableoSLSa3U$default, null, jM6824unboximpl, 0L, Dp.m9687constructorimpl(2), 0, null, composerStartRestartGroup, 24576, 106);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (status.getShouldIconBeAnimated()) {
                    composerStartRestartGroup.startReplaceGroup(1440826543);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "70@2672L28,71@2745L235");
                    i7 = 0;
                    modifierThen = companion.then(RotateKt.rotate(companion, JobStatusIndicator$lambda$0$2(InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1), 0.0f, 360.0f, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(3000, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8))));
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    i7 = 0;
                    composerStartRestartGroup.startReplaceGroup(1441224614);
                    composerStartRestartGroup.endReplaceGroup();
                    modifierThen = companion;
                }
                ImageKt.Image(PainterResources_androidKt.painterResource(i6, composerStartRestartGroup, i7), (String) null, SizeKt.m1266size3ABfNKs(modifierThen, Dp.m9687constructorimpl(24)), Alignment.INSTANCE.getCenter(), (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable | 3120, 112);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                z4 = z7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return JobStatusIndicatorKt.JobStatusIndicator$lambda$1(status, modifier3, onClick, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(onClick)) {
                i8 = 256;
            } else {
                i8 = 128;
            }
            i3 |= i8;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2009339894, i3, -1, "com.box.android.jobsui.JobStatusIndicator (JobStatusIndicator.kt:38)");
                }
                Modifier modifierTestTag3 = TestTagKt.testTag(companion, "JobStatusIndicator:" + getStatusString(status));
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1439943447, "C45@1793L61,50@1984L20,84@3117L27,83@3088L202:JobStatusIndicator.kt#6w6mzd");
                progress = status.getProgress();
                Pair<Color, Integer> colorAndIconRes3 = getColorAndIconRes(status.getJobStatus(), z5, composerStartRestartGroup, (i3 >> 6) & 112);
                jM6824unboximpl = colorAndIconRes3.component1().m6824unboximpl();
                iIntValue = colorAndIconRes3.component2().intValue();
                Modifier modifierClip3 = ClipKt.clip(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(40)), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -507732208, "CC(remember):JobStatusIndicator.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobStatusIndicatorKt.JobStatusIndicator$lambda$0$0$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return JobStatusIndicatorKt.JobStatusIndicator$lambda$0$0$0(onClick);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(modifierClip3, false, null, null, null, (Function0) objRememberedValue, 15, null);
                if (progress != null) {
                    composerStartRestartGroup.startReplaceGroup(1440296412);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "55@2156L12,54@2105L202");
                    float fM9687constructorimpl3 = Dp.m9687constructorimpl(2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -507726712, "CC(remember):JobStatusIndicator.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(progress);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(progress.floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(progress.floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    z7 = z5;
                    i6 = iIntValue;
                    BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(modifierM632clickableoSLSa3U$default, null, jM6824unboximpl, 0L, fM9687constructorimpl3, 0, (Function0) objRememberedValue2, composerStartRestartGroup, 24576, 42);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    z7 = z5;
                    i6 = iIntValue;
                    composerStartRestartGroup.startReplaceGroup(1440581829);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@2394L161");
                    BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(modifierM632clickableoSLSa3U$default, null, jM6824unboximpl, 0L, Dp.m9687constructorimpl(2), 0, null, composerStartRestartGroup, 24576, 106);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (status.getShouldIconBeAnimated()) {
                    composerStartRestartGroup.startReplaceGroup(1440826543);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "70@2672L28,71@2745L235");
                    i7 = 0;
                    modifierThen = companion.then(RotateKt.rotate(companion, JobStatusIndicator$lambda$0$2(InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1), 0.0f, 360.0f, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(3000, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8))));
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    i7 = 0;
                    composerStartRestartGroup.startReplaceGroup(1441224614);
                    composerStartRestartGroup.endReplaceGroup();
                    modifierThen = companion;
                }
                ImageKt.Image(PainterResources_androidKt.painterResource(i6, composerStartRestartGroup, i7), (String) null, SizeKt.m1266size3ABfNKs(modifierThen, Dp.m9687constructorimpl(24)), Alignment.INSTANCE.getCenter(), (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable | 3120, 112);
                composerStartRestartGroup = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                z4 = z7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return JobStatusIndicatorKt.JobStatusIndicator$lambda$1(status, modifier3, onClick, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i3 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
        } else {
            if (i9 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2009339894, i3, -1, "com.box.android.jobsui.JobStatusIndicator (JobStatusIndicator.kt:38)");
            }
            Modifier modifierTestTag4 = TestTagKt.testTag(companion, "JobStatusIndicator:" + getStatusString(status));
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1439943447, "C45@1793L61,50@1984L20,84@3117L27,83@3088L202:JobStatusIndicator.kt#6w6mzd");
            progress = status.getProgress();
            Pair<Color, Integer> colorAndIconRes4 = getColorAndIconRes(status.getJobStatus(), z5, composerStartRestartGroup, (i3 >> 6) & 112);
            jM6824unboximpl = colorAndIconRes4.component1().m6824unboximpl();
            iIntValue = colorAndIconRes4.component2().intValue();
            Modifier modifierClip4 = ClipKt.clip(SizeKt.m1266size3ABfNKs(companion, Dp.m9687constructorimpl(40)), RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -507732208, "CC(remember):JobStatusIndicator.kt#9igjgp");
            if ((i3 & 896) == 256) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return JobStatusIndicatorKt.JobStatusIndicator$lambda$0$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return JobStatusIndicatorKt.JobStatusIndicator$lambda$0$0$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(modifierClip4, false, null, null, null, (Function0) objRememberedValue, 15, null);
            if (progress != null) {
                composerStartRestartGroup.startReplaceGroup(1440296412);
                ComposerKt.sourceInformation(composerStartRestartGroup, "55@2156L12,54@2105L202");
                float fM9687constructorimpl4 = Dp.m9687constructorimpl(2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -507726712, "CC(remember):JobStatusIndicator.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(progress);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(progress.floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(progress.floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                z7 = z5;
                i6 = iIntValue;
                BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(modifierM632clickableoSLSa3U$default, null, jM6824unboximpl, 0L, fM9687constructorimpl4, 0, (Function0) objRememberedValue2, composerStartRestartGroup, 24576, 42);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                z7 = z5;
                i6 = iIntValue;
                composerStartRestartGroup.startReplaceGroup(1440581829);
                ComposerKt.sourceInformation(composerStartRestartGroup, "62@2394L161");
                BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(modifierM632clickableoSLSa3U$default, null, jM6824unboximpl, 0L, Dp.m9687constructorimpl(2), 0, null, composerStartRestartGroup, 24576, 106);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (status.getShouldIconBeAnimated()) {
                composerStartRestartGroup.startReplaceGroup(1440826543);
                ComposerKt.sourceInformation(composerStartRestartGroup, "70@2672L28,71@2745L235");
                i7 = 0;
                modifierThen = companion.then(RotateKt.rotate(companion, JobStatusIndicator$lambda$0$2(InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition(null, composerStartRestartGroup, 0, 1), 0.0f, 360.0f, AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(3000, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8))));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                i7 = 0;
                composerStartRestartGroup.startReplaceGroup(1441224614);
                composerStartRestartGroup.endReplaceGroup();
                modifierThen = companion;
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(i6, composerStartRestartGroup, i7), (String) null, SizeKt.m1266size3ABfNKs(modifierThen, Dp.m9687constructorimpl(24)), Alignment.INSTANCE.getCenter(), (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, Painter.$stable | 3120, 112);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            z4 = z7;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobStatusIndicatorKt.JobStatusIndicator$lambda$1(status, modifier3, onClick, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JobStatusIndicator$lambda$0$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final Pair<Color, Integer> getColorAndIconRes(JobInfo.Status status, boolean z, Composer composer, int i) {
        long jM11499getAppBackgroundAlt0d7_KjU;
        Pair<Color, Integer> pair;
        ComposerKt.sourceInformationMarkerStart(composer, 1122645252, "C(getColorAndIconRes)N(isRedesignedVersion):JobStatusIndicator.kt#6w6mzd");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1122645252, i, -1, "com.box.android.jobsui.getColorAndIconRes (JobStatusIndicator.kt:93)");
        }
        if (z) {
            composer.startReplaceGroup(825300977);
            ComposerKt.sourceInformation(composer, "94@3472L6");
            jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
        } else {
            composer.startReplaceGroup(825302100);
            ComposerKt.sourceInformation(composer, "94@3507L6");
            jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11499getAppBackgroundAlt0d7_KjU();
        }
        composer.endReplaceGroup();
        if (status instanceof JobInfo.Status.Blocked) {
            composer.startReplaceGroup(825304658);
            composer.endReplaceGroup();
            pair = new Pair<>(Color.m6804boximpl(jM11499getAppBackgroundAlt0d7_KjU), Integer.valueOf(R.drawable.ic_job_progress));
        } else if (status instanceof JobInfo.Status.Cancelled) {
            composer.startReplaceGroup(825307461);
            ComposerKt.sourceInformation(composer, "98@3694L6");
            pair = new Pair<>(Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11513getContentSecondary0d7_KjU()), Integer.valueOf(R.drawable.ic_job_restart));
            composer.endReplaceGroup();
        } else if (status instanceof JobInfo.Status.Delayed) {
            composer.startReplaceGroup(825310770);
            composer.endReplaceGroup();
            pair = new Pair<>(Color.m6804boximpl(jM11499getAppBackgroundAlt0d7_KjU), Integer.valueOf(R.drawable.ic_job_progress));
        } else if (status instanceof JobInfo.Status.Failed) {
            composer.startReplaceGroup(825313482);
            ComposerKt.sourceInformation(composer, "102@3882L6");
            pair = new Pair<>(Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11540getNotificationContainer0d7_KjU()), Integer.valueOf(R.drawable.ic_job_restart));
            composer.endReplaceGroup();
        } else if (status instanceof JobInfo.Status.Paused) {
            composer.startReplaceGroup(825316933);
            ComposerKt.sourceInformation(composer, "104@3990L6");
            pair = new Pair<>(Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11513getContentSecondary0d7_KjU()), Integer.valueOf(R.drawable.ic_job_restart));
            composer.endReplaceGroup();
        } else if (status instanceof JobInfo.Status.Running) {
            composer.startReplaceGroup(825320262);
            ComposerKt.sourceInformation(composer, "106@4094L6");
            pair = new Pair<>(Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11559getStatusInProgress0d7_KjU()), Integer.valueOf(R.drawable.ic_job_progress));
            composer.endReplaceGroup();
        } else if (status instanceof JobInfo.Status.Succeeded) {
            composer.startReplaceGroup(825325025);
            ComposerKt.sourceInformation(composer, "109@4243L6");
            pair = new Pair<>(Color.m6804boximpl(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11558getStatusDone0d7_KjU()), Integer.valueOf(R.drawable.ic_job_completed));
            composer.endReplaceGroup();
        } else {
            if (!(status instanceof JobInfo.Status.Waiting)) {
                composer.startReplaceGroup(825303819);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(825328210);
            composer.endReplaceGroup();
            pair = new Pair<>(Color.m6804boximpl(jM11499getAppBackgroundAlt0d7_KjU), Integer.valueOf(R.drawable.ic_job_progress));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return pair;
    }

    private static final String getStatusString(JobStatusUIState jobStatusUIState) {
        return jobStatusUIState.getJobStatus().getClass().getSimpleName();
    }

    private static final void JobStatusIndicatorSucceededPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(372300838);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(JobStatusIndicatorSucceededPreview)120@4547L636:JobStatusIndicator.kt#6w6mzd");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(372300838, i, -1, "com.box.android.jobsui.JobStatusIndicatorSucceededPreview (JobStatusIndicator.kt:119)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1171233906, "C125@4704L2,121@4564L152,127@4725L29,132@4940L2,128@4763L189,134@4961L29,139@5165L2,135@4999L178:JobStatusIndicator.kt#6w6mzd");
            JobStatusUIState jobStatusUIState = new JobStatusUIState(null, JobInfo.Status.Succeeded.INSTANCE, null, 5, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -37777870, "CC(remember):JobStatusIndicator.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            JobStatusIndicator(jobStatusUIState, null, (Function0) objRememberedValue, false, composerStartRestartGroup, 384, 10);
            float f = 6;
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
            JobStatusUIState jobStatusUIState2 = new JobStatusUIState(null, new JobInfo.Status.Running(new JobInfo.Progress(0.1d, 1.0d)), null, 5, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -37770318, "CC(remember):JobStatusIndicator.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            JobStatusIndicator(jobStatusUIState2, null, (Function0) objRememberedValue2, false, composerStartRestartGroup, 384, 10);
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
            JobStatusUIState jobStatusUIState3 = new JobStatusUIState(null, new JobInfo.Status.Failed(new DomainError.CustomError("")), null, 5, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -37763118, "CC(remember):JobStatusIndicator.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            JobStatusIndicator(jobStatusUIState3, null, (Function0) objRememberedValue3, false, composerStartRestartGroup, 384, 10);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.jobsui.JobStatusIndicatorKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return JobStatusIndicatorKt.JobStatusIndicatorSucceededPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float JobStatusIndicator$lambda$0$2(State<Float> state) {
        return state.getValue().floatValue();
    }
}
