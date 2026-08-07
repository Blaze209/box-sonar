package androidx.compose.material3.internal;

import android.view.View;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.profileinstaller.ProfileVerifier;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicEdgeToEdgeDialog.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\\\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\t*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0000¨\u0006\u0013²\u0006\u001b\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000eX\u008a\u0084\u0002²\u0006\u0010\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"BasicEdgeToEdgeDialog", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "lightStatusBars", "", "lightNavigationBars", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/internal/PredictiveBackState;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "shouldApplySecureFlag", "Landroidx/compose/ui/window/SecureFlagPolicy;", "isSecureFlagSetOnParent", "material3", "currentContent", "currentOnDismissRequest", "currentDismissOnBackPress"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicEdgeToEdgeDialog_androidKt {

    /* JADX INFO: compiled from: BasicEdgeToEdgeDialog.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SecureFlagPolicy.values().length];
            try {
                iArr[SecureFlagPolicy.SecureOff.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SecureFlagPolicy.SecureOn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SecureFlagPolicy.Inherit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicEdgeToEdgeDialog$lambda$7(Function0 function0, Modifier modifier, DialogProperties dialogProperties, boolean z, boolean z2, Function3 function3, int i, int i2, Composer composer, int i3) {
        BasicEdgeToEdgeDialog(function0, modifier, dialogProperties, z, z2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0168  */
    /* JADX WARN: Code duplicated, block: B:106:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:109:0x020d  */
    /* JADX WARN: Code duplicated, block: B:113:0x021c  */
    /* JADX WARN: Code duplicated, block: B:116:0x0255  */
    /* JADX WARN: Code duplicated, block: B:118:0x025d  */
    /* JADX WARN: Code duplicated, block: B:121:0x027d  */
    /* JADX WARN: Code duplicated, block: B:122:0x027f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0289  */
    /* JADX WARN: Code duplicated, block: B:126:0x028b  */
    /* JADX WARN: Code duplicated, block: B:129:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:131:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:137:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:139:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:145:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:147:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:150:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:152:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:155:0x0306  */
    /* JADX WARN: Code duplicated, block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:45:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:84:0x0105  */
    /* JADX WARN: Code duplicated, block: B:87:0x010d  */
    /* JADX WARN: Code duplicated, block: B:89:0x012b  */
    /* JADX WARN: Code duplicated, block: B:90:0x012d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0135  */
    /* JADX WARN: Code duplicated, block: B:96:0x0153  */
    /* JADX WARN: Code duplicated, block: B:97:0x0155  */
    /* JADX WARN: Code duplicated, block: B:99:0x015b  */
    public static final void BasicEdgeToEdgeDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties dialogProperties, boolean z, boolean z2, final Function3<? super PredictiveBackState, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        DialogProperties dialogProperties2;
        int i5;
        boolean z3;
        boolean z4;
        boolean z5;
        final Modifier modifier3;
        final DialogProperties dialogProperties3;
        final boolean z6;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Modifier.Companion companion;
        DialogProperties dialogProperties4;
        int i6;
        DialogProperties dialogProperties5;
        Object objConsume;
        boolean z8;
        Object objConsume2;
        boolean z9;
        View view;
        Density density;
        final LayoutDirection layoutDirection;
        CompositionContext compositionContextRememberCompositionContext;
        Object objRememberedValue;
        DialogProperties dialogProperties6;
        UUID uuid;
        final State stateRememberUpdatedState;
        int i7;
        final State stateRememberUpdatedState2;
        final State stateRememberUpdatedState3;
        boolean zChanged;
        DialogProperties dialogProperties7;
        boolean z10;
        Object obj;
        final DialogWrapper dialogWrapper;
        boolean zChangedInstance;
        Object objRememberedValue2;
        boolean z11;
        int i8;
        boolean z12;
        boolean zChanged2;
        Object objRememberedValue3;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(814581409);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BasicEdgeToEdgeDialog)N(onDismissRequest,modifier,properties,lightStatusBars,lightNavigationBars,content)91@3820L7,92@3859L7,93@3914L7,94@3944L28,95@4009L21,95@3992L38,97@4058L29,98@4123L38,99@4199L51,102@4277L1031,128@5339L129,128@5314L154,137@5485L285,137@5474L296:BasicEdgeToEdgeDialog.android.kt#mqatfk");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    dialogProperties2 = dialogProperties;
                    if (composerStartRestartGroup.changed(dialogProperties2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        z3 = z;
                        int i11 = composerStartRestartGroup.changed(z3) ? 2048 : 1024;
                        i3 |= i11;
                    } else {
                        z3 = z;
                    }
                    i3 |= i11;
                } else {
                    z3 = z;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        z4 = z2;
                        int i12 = composerStartRestartGroup.changed(z4) ? 16384 : 8192;
                        i3 |= i12;
                    } else {
                        z4 = z2;
                    }
                    i3 |= i12;
                } else {
                    z4 = z2;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((i3 & 74899) != 74898) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "37@1426L7,39@1507L7");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            dialogProperties4 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties4 = dialogProperties2;
                        }
                        if ((i2 & 8) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            objConsume2 = composerStartRestartGroup.consume(localContentColor);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ColorKt.m6866luminance8_81llA(((Color) objConsume2).m6824unboximpl()) < 0.5f) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i3 &= -7169;
                            z3 = z9;
                        }
                        if ((i2 & 16) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            objConsume = composerStartRestartGroup.consume(localContentColor2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ColorKt.m6866luminance8_81llA(((Color) objConsume).m6824unboximpl()) < 0.5f) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            i3 &= -57345;
                            z4 = z8;
                        }
                        i6 = i3;
                        dialogProperties5 = dialogProperties4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        i6 = i3;
                        companion = modifier2;
                        dialogProperties5 = dialogProperties2;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(814581409, i6, -1, "androidx.compose.material3.internal.BasicEdgeToEdgeDialog (BasicEdgeToEdgeDialog.android.kt:90)");
                    }
                    ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localView);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    view = (View) objConsume3;
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume4;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    layoutDirection = (LayoutDirection) objConsume5;
                    compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                    Object[] objArr = new Object[0];
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128700822, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    dialogProperties6 = dialogProperties5;
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return UUID.randomUUID();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 48);
                    stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composerStartRestartGroup, (i6 >> 15) & 14);
                    i7 = i6 & 14;
                    stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function0, composerStartRestartGroup, i7);
                    stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(dialogProperties6.getDismissOnBackPress()), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128710408, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        dialogProperties7 = dialogProperties6;
                        DialogWrapper dialogWrapper2 = new DialogWrapper(function0, dialogProperties7, view, layoutDirection, density, uuid, z3, z4);
                        z10 = true;
                        dialogWrapper2.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-635938462, true, new Function2() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$4$0$0(companion, stateRememberUpdatedState3, stateRememberUpdatedState2, stateRememberUpdatedState, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }));
                        composerStartRestartGroup.updateRememberedValue(dialogWrapper2);
                        obj = dialogWrapper2;
                    } else {
                        dialogProperties7 = dialogProperties6;
                        z10 = true;
                        obj = objRememberedValue4;
                    }
                    dialogWrapper = (DialogWrapper) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128743490, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(dialogWrapper);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$5$0(dialogWrapper, (DisposableEffectScope) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.DisposableEffect(dialogWrapper, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128748318, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(dialogWrapper);
                    if (i7 == 4) {
                        z11 = z10;
                    } else {
                        z11 = false;
                    }
                    boolean z13 = zChangedInstance2 | z11;
                    i8 = i6;
                    if ((i8 & 896) == 256) {
                        z12 = z10;
                    } else {
                        z12 = false;
                    }
                    zChanged2 = z13 | z12 | composerStartRestartGroup.changed(layoutDirection.ordinal()) | (((((i8 & 7168) ^ 3072) > 2048 || !composerStartRestartGroup.changed(z3)) && (i8 & 3072) != 2048) ? false : z10) | (((((57344 & i8) ^ 24576) > 16384 || !composerStartRestartGroup.changed(z4)) && (i8 & 24576) != 16384) ? false : z10);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        final DialogProperties dialogProperties8 = dialogProperties7;
                        final boolean z14 = z3;
                        final boolean z15 = z4;
                        Function0 function1 = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$6$0(dialogWrapper, function0, dialogProperties8, layoutDirection, z14, z15);
                            }
                        };
                        dialogProperties7 = dialogProperties8;
                        composerStartRestartGroup.updateRememberedValue(function1);
                        objRememberedValue3 = function1;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    dialogProperties3 = dialogProperties7;
                    modifier3 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    dialogProperties3 = dialogProperties2;
                }
                z6 = z3;
                z7 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$7(function0, modifier3, dialogProperties3, z6, z7, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            dialogProperties2 = dialogProperties;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                    }
                    i3 |= i11;
                } else {
                    z3 = z;
                }
                i3 |= i11;
            } else {
                z3 = z;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                    }
                    i3 |= i12;
                } else {
                    z4 = z2;
                }
                i3 |= i12;
            } else {
                z4 = z2;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((i3 & 74899) != 74898) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "37@1426L7,39@1507L7");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        dialogProperties4 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties4 = dialogProperties2;
                    }
                    if ((i2 & 8) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        objConsume2 = composerStartRestartGroup.consume(localContentColor3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ColorKt.m6866luminance8_81llA(((Color) objConsume2).m6824unboximpl()) < 0.5f) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i3 &= -7169;
                        z3 = z9;
                    }
                    if ((i2 & 16) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor4 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        objConsume = composerStartRestartGroup.consume(localContentColor4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ColorKt.m6866luminance8_81llA(((Color) objConsume).m6824unboximpl()) < 0.5f) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        i3 &= -57345;
                        z4 = z8;
                    }
                    i6 = i3;
                    dialogProperties5 = dialogProperties4;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        dialogProperties4 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties4 = dialogProperties2;
                    }
                    if ((i2 & 8) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor5 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        objConsume2 = composerStartRestartGroup.consume(localContentColor5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ColorKt.m6866luminance8_81llA(((Color) objConsume2).m6824unboximpl()) < 0.5f) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i3 &= -7169;
                        z3 = z9;
                    }
                    if ((i2 & 16) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor6 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        objConsume = composerStartRestartGroup.consume(localContentColor6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ColorKt.m6866luminance8_81llA(((Color) objConsume).m6824unboximpl()) < 0.5f) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        i3 &= -57345;
                        z4 = z8;
                    }
                    i6 = i3;
                    dialogProperties5 = dialogProperties4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(814581409, i6, -1, "androidx.compose.material3.internal.BasicEdgeToEdgeDialog (BasicEdgeToEdgeDialog.android.kt:90)");
                }
                ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localView2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume6;
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume7;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume8;
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                Object[] objArr2 = new Object[0];
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128700822, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                dialogProperties6 = dialogProperties5;
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return UUID.randomUUID();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue, composerStartRestartGroup, 48);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composerStartRestartGroup, (i6 >> 15) & 14);
                i7 = i6 & 14;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function0, composerStartRestartGroup, i7);
                stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(dialogProperties6.getDismissOnBackPress()), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128710408, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    dialogProperties7 = dialogProperties6;
                    DialogWrapper dialogWrapper3 = new DialogWrapper(function0, dialogProperties7, view, layoutDirection, density, uuid, z3, z4);
                    z10 = true;
                    dialogWrapper3.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-635938462, true, new Function2() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$4$0$0(companion, stateRememberUpdatedState3, stateRememberUpdatedState2, stateRememberUpdatedState, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    composerStartRestartGroup.updateRememberedValue(dialogWrapper3);
                    obj = dialogWrapper3;
                } else {
                    dialogProperties7 = dialogProperties6;
                    DialogWrapper dialogWrapper4 = new DialogWrapper(function0, dialogProperties7, view, layoutDirection, density, uuid, z3, z4);
                    z10 = true;
                    dialogWrapper4.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-635938462, true, new Function2() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$4$0$0(companion, stateRememberUpdatedState3, stateRememberUpdatedState2, stateRememberUpdatedState, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    composerStartRestartGroup.updateRememberedValue(dialogWrapper4);
                    obj = dialogWrapper4;
                }
                dialogWrapper = (DialogWrapper) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128743490, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(dialogWrapper);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$5$0(dialogWrapper, (DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$5$0(dialogWrapper, (DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(dialogWrapper, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128748318, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(dialogWrapper);
                if (i7 == 4) {
                    z11 = z10;
                } else {
                    z11 = false;
                }
                boolean z16 = zChangedInstance3 | z11;
                i8 = i6;
                if ((i8 & 896) == 256) {
                    z12 = z10;
                } else {
                    z12 = false;
                }
                zChanged2 = z16 | z12 | composerStartRestartGroup.changed(layoutDirection.ordinal()) | (((((i8 & 7168) ^ 3072) > 2048 || !composerStartRestartGroup.changed(z3)) && (i8 & 3072) != 2048) ? false : z10) | (((((57344 & i8) ^ 24576) > 16384 || !composerStartRestartGroup.changed(z4)) && (i8 & 24576) != 16384) ? false : z10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    final DialogProperties dialogProperties9 = dialogProperties7;
                    final boolean z17 = z3;
                    final boolean z18 = z4;
                    Function0 function2 = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$6$0(dialogWrapper, function0, dialogProperties9, layoutDirection, z17, z18);
                        }
                    };
                    dialogProperties7 = dialogProperties9;
                    composerStartRestartGroup.updateRememberedValue(function2);
                    objRememberedValue3 = function2;
                } else {
                    final DialogProperties dialogProperties10 = dialogProperties7;
                    final boolean z19 = z3;
                    final boolean z110 = z4;
                    Function0 function4 = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$6$0(dialogWrapper, function0, dialogProperties10, layoutDirection, z19, z110);
                        }
                    };
                    dialogProperties7 = dialogProperties10;
                    composerStartRestartGroup.updateRememberedValue(function4);
                    objRememberedValue3 = function4;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dialogProperties3 = dialogProperties7;
                modifier3 = companion;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                dialogProperties3 = dialogProperties2;
            }
            z6 = z3;
            z7 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$7(function0, modifier3, dialogProperties3, z6, z7, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                dialogProperties2 = dialogProperties;
                if (composerStartRestartGroup.changed(dialogProperties2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                    }
                    i3 |= i11;
                } else {
                    z3 = z;
                }
                i3 |= i11;
            } else {
                z3 = z;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                    }
                    i3 |= i12;
                } else {
                    z4 = z2;
                }
                i3 |= i12;
            } else {
                z4 = z2;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((i3 & 74899) != 74898) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "37@1426L7,39@1507L7");
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        dialogProperties4 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties4 = dialogProperties2;
                    }
                    if ((i2 & 8) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor7 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        objConsume2 = composerStartRestartGroup.consume(localContentColor7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ColorKt.m6866luminance8_81llA(((Color) objConsume2).m6824unboximpl()) < 0.5f) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i3 &= -7169;
                        z3 = z9;
                    }
                    if ((i2 & 16) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor8 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        objConsume = composerStartRestartGroup.consume(localContentColor8);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ColorKt.m6866luminance8_81llA(((Color) objConsume).m6824unboximpl()) < 0.5f) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        i3 &= -57345;
                        z4 = z8;
                    }
                    i6 = i3;
                    dialogProperties5 = dialogProperties4;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        dialogProperties4 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties4 = dialogProperties2;
                    }
                    if ((i2 & 8) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor9 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        objConsume2 = composerStartRestartGroup.consume(localContentColor9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ColorKt.m6866luminance8_81llA(((Color) objConsume2).m6824unboximpl()) < 0.5f) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i3 &= -7169;
                        z3 = z9;
                    }
                    if ((i2 & 16) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor10 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        objConsume = composerStartRestartGroup.consume(localContentColor10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ColorKt.m6866luminance8_81llA(((Color) objConsume).m6824unboximpl()) < 0.5f) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        i3 &= -57345;
                        z4 = z8;
                    }
                    i6 = i3;
                    dialogProperties5 = dialogProperties4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(814581409, i6, -1, "androidx.compose.material3.internal.BasicEdgeToEdgeDialog (BasicEdgeToEdgeDialog.android.kt:90)");
                }
                ProvidableCompositionLocal<View> localView3 = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume9 = composerStartRestartGroup.consume(localView3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume9;
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume10 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume10;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume11 = composerStartRestartGroup.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume11;
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                Object[] objArr3 = new Object[0];
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128700822, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                dialogProperties6 = dialogProperties5;
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return UUID.randomUUID();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr3, (Function0) objRememberedValue, composerStartRestartGroup, 48);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composerStartRestartGroup, (i6 >> 15) & 14);
                i7 = i6 & 14;
                stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function0, composerStartRestartGroup, i7);
                stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(dialogProperties6.getDismissOnBackPress()), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128710408, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    dialogProperties7 = dialogProperties6;
                    DialogWrapper dialogWrapper5 = new DialogWrapper(function0, dialogProperties7, view, layoutDirection, density, uuid, z3, z4);
                    z10 = true;
                    dialogWrapper5.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-635938462, true, new Function2() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$4$0$0(companion, stateRememberUpdatedState3, stateRememberUpdatedState2, stateRememberUpdatedState, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    composerStartRestartGroup.updateRememberedValue(dialogWrapper5);
                    obj = dialogWrapper5;
                } else {
                    dialogProperties7 = dialogProperties6;
                    DialogWrapper dialogWrapper6 = new DialogWrapper(function0, dialogProperties7, view, layoutDirection, density, uuid, z3, z4);
                    z10 = true;
                    dialogWrapper6.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-635938462, true, new Function2() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$4$0$0(companion, stateRememberUpdatedState3, stateRememberUpdatedState2, stateRememberUpdatedState, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }));
                    composerStartRestartGroup.updateRememberedValue(dialogWrapper6);
                    obj = dialogWrapper6;
                }
                dialogWrapper = (DialogWrapper) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128743490, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(dialogWrapper);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$5$0(dialogWrapper, (DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$5$0(dialogWrapper, (DisposableEffectScope) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(dialogWrapper, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128748318, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
                boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(dialogWrapper);
                if (i7 == 4) {
                    z11 = z10;
                } else {
                    z11 = false;
                }
                boolean z111 = zChangedInstance4 | z11;
                i8 = i6;
                if ((i8 & 896) == 256) {
                    z12 = z10;
                } else {
                    z12 = false;
                }
                zChanged2 = z111 | z12 | composerStartRestartGroup.changed(layoutDirection.ordinal()) | (((((i8 & 7168) ^ 3072) > 2048 || !composerStartRestartGroup.changed(z3)) && (i8 & 3072) != 2048) ? false : z10) | (((((57344 & i8) ^ 24576) > 16384 || !composerStartRestartGroup.changed(z4)) && (i8 & 24576) != 16384) ? false : z10);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    final DialogProperties dialogProperties11 = dialogProperties7;
                    final boolean z112 = z3;
                    final boolean z113 = z4;
                    Function0 function5 = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$6$0(dialogWrapper, function0, dialogProperties11, layoutDirection, z112, z113);
                        }
                    };
                    dialogProperties7 = dialogProperties11;
                    composerStartRestartGroup.updateRememberedValue(function5);
                    objRememberedValue3 = function5;
                } else {
                    final DialogProperties dialogProperties12 = dialogProperties7;
                    final boolean z114 = z3;
                    final boolean z115 = z4;
                    Function0 function6 = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$6$0(dialogWrapper, function0, dialogProperties12, layoutDirection, z114, z115);
                        }
                    };
                    dialogProperties7 = dialogProperties12;
                    composerStartRestartGroup.updateRememberedValue(function6);
                    objRememberedValue3 = function6;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                dialogProperties3 = dialogProperties7;
                modifier3 = companion;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                dialogProperties3 = dialogProperties2;
            }
            z6 = z3;
            z7 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$7(function0, modifier3, dialogProperties3, z6, z7, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        dialogProperties2 = dialogProperties;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                }
                i3 |= i11;
            } else {
                z3 = z;
            }
            i3 |= i11;
        } else {
            z3 = z;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                }
                i3 |= i12;
            } else {
                z4 = z2;
            }
            i3 |= i12;
        } else {
            z4 = z2;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i9 = 131072;
            } else {
                i9 = 65536;
            }
            i3 |= i9;
        }
        if ((i3 & 74899) != 74898) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "37@1426L7,39@1507L7");
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    dialogProperties4 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties4 = dialogProperties2;
                }
                if ((i2 & 8) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor11 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume2 = composerStartRestartGroup.consume(localContentColor11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ColorKt.m6866luminance8_81llA(((Color) objConsume2).m6824unboximpl()) < 0.5f) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    i3 &= -7169;
                    z3 = z9;
                }
                if ((i2 & 16) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor12 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localContentColor12);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ColorKt.m6866luminance8_81llA(((Color) objConsume).m6824unboximpl()) < 0.5f) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    i3 &= -57345;
                    z4 = z8;
                }
                i6 = i3;
                dialogProperties5 = dialogProperties4;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    dialogProperties4 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties4 = dialogProperties2;
                }
                if ((i2 & 8) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor13 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume2 = composerStartRestartGroup.consume(localContentColor13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ColorKt.m6866luminance8_81llA(((Color) objConsume2).m6824unboximpl()) < 0.5f) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    i3 &= -7169;
                    z3 = z9;
                }
                if ((i2 & 16) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor14 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localContentColor14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ColorKt.m6866luminance8_81llA(((Color) objConsume).m6824unboximpl()) < 0.5f) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    i3 &= -57345;
                    z4 = z8;
                }
                i6 = i3;
                dialogProperties5 = dialogProperties4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(814581409, i6, -1, "androidx.compose.material3.internal.BasicEdgeToEdgeDialog (BasicEdgeToEdgeDialog.android.kt:90)");
            }
            ProvidableCompositionLocal<View> localView4 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume12 = composerStartRestartGroup.consume(localView4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            view = (View) objConsume12;
            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume13 = composerStartRestartGroup.consume(localDensity4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume13;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume14 = composerStartRestartGroup.consume(localLayoutDirection4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            layoutDirection = (LayoutDirection) objConsume14;
            compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            Object[] objArr4 = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128700822, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            dialogProperties6 = dialogProperties5;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return UUID.randomUUID();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr4, (Function0) objRememberedValue, composerStartRestartGroup, 48);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function3, composerStartRestartGroup, (i6 >> 15) & 14);
            i7 = i6 & 14;
            stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function0, composerStartRestartGroup, i7);
            stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(dialogProperties6.getDismissOnBackPress()), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128710408, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                dialogProperties7 = dialogProperties6;
                DialogWrapper dialogWrapper7 = new DialogWrapper(function0, dialogProperties7, view, layoutDirection, density, uuid, z3, z4);
                z10 = true;
                dialogWrapper7.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-635938462, true, new Function2() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$4$0$0(companion, stateRememberUpdatedState3, stateRememberUpdatedState2, stateRememberUpdatedState, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }));
                composerStartRestartGroup.updateRememberedValue(dialogWrapper7);
                obj = dialogWrapper7;
            } else {
                dialogProperties7 = dialogProperties6;
                DialogWrapper dialogWrapper8 = new DialogWrapper(function0, dialogProperties7, view, layoutDirection, density, uuid, z3, z4);
                z10 = true;
                dialogWrapper8.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-635938462, true, new Function2() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$4$0$0(companion, stateRememberUpdatedState3, stateRememberUpdatedState2, stateRememberUpdatedState, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }));
                composerStartRestartGroup.updateRememberedValue(dialogWrapper8);
                obj = dialogWrapper8;
            }
            dialogWrapper = (DialogWrapper) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128743490, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(dialogWrapper);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$5$0(dialogWrapper, (DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$5$0(dialogWrapper, (DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(dialogWrapper, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1128748318, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
            boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(dialogWrapper);
            if (i7 == 4) {
                z11 = z10;
            } else {
                z11 = false;
            }
            boolean z116 = zChangedInstance5 | z11;
            i8 = i6;
            if ((i8 & 896) == 256) {
                z12 = z10;
            } else {
                z12 = false;
            }
            zChanged2 = z116 | z12 | composerStartRestartGroup.changed(layoutDirection.ordinal()) | (((((i8 & 7168) ^ 3072) > 2048 || !composerStartRestartGroup.changed(z3)) && (i8 & 3072) != 2048) ? false : z10) | (((((57344 & i8) ^ 24576) > 16384 || !composerStartRestartGroup.changed(z4)) && (i8 & 24576) != 16384) ? false : z10);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                final DialogProperties dialogProperties13 = dialogProperties7;
                final boolean z117 = z3;
                final boolean z118 = z4;
                Function0 function7 = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$6$0(dialogWrapper, function0, dialogProperties13, layoutDirection, z117, z118);
                    }
                };
                dialogProperties7 = dialogProperties13;
                composerStartRestartGroup.updateRememberedValue(function7);
                objRememberedValue3 = function7;
            } else {
                final DialogProperties dialogProperties14 = dialogProperties7;
                final boolean z119 = z3;
                final boolean z1110 = z4;
                Function0 function8 = new Function0() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$6$0(dialogWrapper, function0, dialogProperties14, layoutDirection, z119, z1110);
                    }
                };
                dialogProperties7 = dialogProperties14;
                composerStartRestartGroup.updateRememberedValue(function8);
                objRememberedValue3 = function8;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            dialogProperties3 = dialogProperties7;
            modifier3 = companion;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            dialogProperties3 = dialogProperties2;
        }
        z6 = z3;
        z7 = z4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$7(function0, modifier3, dialogProperties3, z6, z7, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicEdgeToEdgeDialog$lambda$4$0$0(Modifier modifier, State state, State state2, State state3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C115@4864L29,117@4919L237,123@5205L12,123@5182L76:BasicEdgeToEdgeDialog.android.kt#mqatfk");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-635938462, i, -1, "androidx.compose.material3.internal.BasicEdgeToEdgeDialog.<anonymous>.<anonymous>.<anonymous> (BasicEdgeToEdgeDialog.android.kt:115)");
            }
            PredictiveBackState predictiveBackStateRememberPredictiveBackState = BasicEdgeToEdgeDialogKt.rememberPredictiveBackState(composer, 0);
            BasicEdgeToEdgeDialogKt.PredictiveBackStateHandler(predictiveBackStateRememberPredictiveBackState, BasicEdgeToEdgeDialog$lambda$3(state), BasicEdgeToEdgeDialog$lambda$2(state2), composer, 0, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1251493362, "CC(remember):BasicEdgeToEdgeDialog.android.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog$lambda$4$0$0$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierSemantics$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 213544984, "C123@5221L35:BasicEdgeToEdgeDialog.android.kt#mqatfk");
            BasicEdgeToEdgeDialog$lambda$1(state3).invoke(predictiveBackStateRememberPredictiveBackState, composer, 0);
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
    public static final Unit BasicEdgeToEdgeDialog$lambda$4$0$0$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.dialog(semanticsPropertyReceiver);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BasicEdgeToEdgeDialog$lambda$5$0(final DialogWrapper dialogWrapper, DisposableEffectScope disposableEffectScope) {
        dialogWrapper.show();
        return new DisposableEffectResult() { // from class: androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt$BasicEdgeToEdgeDialog$lambda$5$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                dialogWrapper.dismiss();
                dialogWrapper.disposeComposition();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicEdgeToEdgeDialog$lambda$6$0(DialogWrapper dialogWrapper, Function0 function0, DialogProperties dialogProperties, LayoutDirection layoutDirection, boolean z, boolean z2) {
        dialogWrapper.updateParameters(function0, dialogProperties, layoutDirection, z, z2);
        return Unit.INSTANCE;
    }

    public static final boolean shouldApplySecureFlag(SecureFlagPolicy secureFlagPolicy, boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$0[secureFlagPolicy.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (i == 3) {
            return z;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Function3<PredictiveBackState, Composer, Integer, Unit> BasicEdgeToEdgeDialog$lambda$1(State<? extends Function3<? super PredictiveBackState, ? super Composer, ? super Integer, Unit>> state) {
        return (Function3) state.getValue();
    }

    private static final Function0<Unit> BasicEdgeToEdgeDialog$lambda$2(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }

    private static final boolean BasicEdgeToEdgeDialog$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
