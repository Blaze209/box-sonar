package androidx.compose.ui.window;

import android.view.View;
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
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AndroidDialog.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001a*\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0003¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\u0015\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007X\u008a\u0084\u0002"}, d2 = {"Dialog", "", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DialogLayout", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui", "currentContent"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidDialog_androidKt {
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0066  */
    /* JADX WARN: Code duplicated, block: B:36:0x0077  */
    /* JADX WARN: Code duplicated, block: B:39:0x007e  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:47:0x0113  */
    /* JADX WARN: Code duplicated, block: B:52:0x014c  */
    /* JADX WARN: Code duplicated, block: B:55:0x016f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0171  */
    /* JADX WARN: Code duplicated, block: B:60:0x017a  */
    /* JADX WARN: Code duplicated, block: B:65:0x0196  */
    /* JADX WARN: Code duplicated, block: B:68:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:69:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:72:0x01be  */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    public static final void Dialog(final Function0<Unit> function0, DialogProperties dialogProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        DialogProperties dialogProperties2;
        int i4;
        boolean z;
        final DialogProperties dialogProperties3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        View view;
        Density density;
        final LayoutDirection layoutDirection;
        CompositionContext compositionContextRememberCompositionContext;
        final State stateRememberUpdatedState;
        AndroidDialog_androidKt$Dialog$dialogId$1$1 androidDialog_androidKt$Dialog$dialogId$1$1RememberedValue;
        UUID uuid;
        boolean zChanged;
        Object objRememberedValue;
        final DialogWrapper dialogWrapper;
        boolean zChangedInstance;
        Object objRememberedValue2;
        boolean z2;
        boolean zChanged2;
        Object objRememberedValue3;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(826668973);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Dialog)P(1,2)202@8819L7,203@8858L7,204@8913L7,205@8943L28,206@8998L29,207@9064L21,207@9047L38,209@9111L330,218@9472L129,218@9447L154,227@9618L183,227@9607L194:AndroidDialog.android.kt#2oxthz");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 48) == 0) {
                dialogProperties2 = dialogProperties;
                i3 |= composerStartRestartGroup.changed(dialogProperties2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i4 = i3;
            if ((i4 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                dialogProperties3 = dialogProperties2;
            } else {
                if (i6 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(826668973, i4, -1, "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:201)");
                }
                ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localView);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                view = (View) objConsume;
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume2;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                layoutDirection = (LayoutDirection) objConsume3;
                compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
                stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i4 >> 6) & 14);
                Object[] objArr = new Object[0];
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -140054174, "CC(remember):AndroidDialog.android.kt#9igjgp");
                androidDialog_androidKt$Dialog$dialogId$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (androidDialog_androidKt$Dialog$dialogId$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    androidDialog_androidKt$Dialog$dialogId$1$1RememberedValue = new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public final UUID invoke() {
                            return UUID.randomUUID();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(androidDialog_androidKt$Dialog$dialogId$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr, (Function0) androidDialog_androidKt$Dialog$dialogId$1$1RememberedValue, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -140052361, "CC(remember):AndroidDialog.android.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    DialogWrapper dialogWrapper2 = new DialogWrapper(function0, dialogProperties3, view, layoutDirection, density, uuid);
                    dialogWrapper2.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(346960332, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i7) {
                            ComposerKt.sourceInformation(composer2, "C213@9362L12,213@9330L61:AndroidDialog.android.kt#2oxthz");
                            if (!composer2.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(346960332, i7, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:213)");
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1578568168, "CC(remember):AndroidDialog.android.kt#9igjgp");
                            AndroidDialog_androidKt$Dialog$dialog$1$1$1$1$1 androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue = composer2.rememberedValue();
                            if (androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1$1$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        SemanticsPropertiesKt.dialog(semanticsPropertyReceiver);
                                    }
                                };
                                composer2.updateRememberedValue(androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            AndroidDialog_androidKt.DialogLayout(SemanticsModifierKt.semantics$default(companion, false, (Function1) androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue, 1, null), AndroidDialog_androidKt.Dialog$lambda$0(stateRememberUpdatedState), composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                    composerStartRestartGroup.updateRememberedValue(dialogWrapper2);
                    objRememberedValue = dialogWrapper2;
                }
                dialogWrapper = (DialogWrapper) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -140041010, "CC(remember):AndroidDialog.android.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(dialogWrapper);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            dialogWrapper.show();
                            final DialogWrapper dialogWrapper3 = dialogWrapper;
                            return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    dialogWrapper3.dismiss();
                                    dialogWrapper3.disposeComposition();
                                }
                            };
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(dialogWrapper, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -140036284, "CC(remember):AndroidDialog.android.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(dialogWrapper);
                if ((i4 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged2 = zChangedInstance2 | z2 | ((i4 & 112) == 32) | composerStartRestartGroup.changed(layoutDirection.ordinal());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2$1
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
                            dialogWrapper.updateParameters(function0, dialogProperties3, layoutDirection);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt.Dialog.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i7) {
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        dialogProperties2 = dialogProperties;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i3 |= i5;
        }
        i4 = i3;
        if ((i4 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            dialogProperties3 = dialogProperties2;
        } else {
            if (i6 != 0) {
                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
            } else {
                dialogProperties3 = dialogProperties2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(826668973, i4, -1, "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:201)");
            }
            ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localView2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            view = (View) objConsume4;
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume5 = composerStartRestartGroup.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume5;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume6 = composerStartRestartGroup.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            layoutDirection = (LayoutDirection) objConsume6;
            compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i4 >> 6) & 14);
            Object[] objArr2 = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -140054174, "CC(remember):AndroidDialog.android.kt#9igjgp");
            androidDialog_androidKt$Dialog$dialogId$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (androidDialog_androidKt$Dialog$dialogId$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                androidDialog_androidKt$Dialog$dialogId$1$1RememberedValue = new Function0<UUID>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialogId$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public final UUID invoke() {
                        return UUID.randomUUID();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(androidDialog_androidKt$Dialog$dialogId$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr2, (Function0) androidDialog_androidKt$Dialog$dialogId$1$1RememberedValue, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -140052361, "CC(remember):AndroidDialog.android.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                DialogWrapper dialogWrapper3 = new DialogWrapper(function0, dialogProperties3, view, layoutDirection, density, uuid);
                dialogWrapper3.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(346960332, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i7) {
                        ComposerKt.sourceInformation(composer2, "C213@9362L12,213@9330L61:AndroidDialog.android.kt#2oxthz");
                        if (!composer2.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(346960332, i7, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:213)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1578568168, "CC(remember):AndroidDialog.android.kt#9igjgp");
                        AndroidDialog_androidKt$Dialog$dialog$1$1$1$1$1 androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue = composer2.rememberedValue();
                        if (androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1$1$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.dialog(semanticsPropertyReceiver);
                                }
                            };
                            composer2.updateRememberedValue(androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        AndroidDialog_androidKt.DialogLayout(SemanticsModifierKt.semantics$default(companion, false, (Function1) androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue, 1, null), AndroidDialog_androidKt.Dialog$lambda$0(stateRememberUpdatedState), composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                composerStartRestartGroup.updateRememberedValue(dialogWrapper3);
                objRememberedValue = dialogWrapper3;
            } else {
                DialogWrapper dialogWrapper4 = new DialogWrapper(function0, dialogProperties3, view, layoutDirection, density, uuid);
                dialogWrapper4.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(346960332, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i7) {
                        ComposerKt.sourceInformation(composer2, "C213@9362L12,213@9330L61:AndroidDialog.android.kt#2oxthz");
                        if (!composer2.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(346960332, i7, -1, "androidx.compose.ui.window.Dialog.<anonymous>.<anonymous>.<anonymous> (AndroidDialog.android.kt:213)");
                        }
                        Modifier.Companion companion = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1578568168, "CC(remember):AndroidDialog.android.kt#9igjgp");
                        AndroidDialog_androidKt$Dialog$dialog$1$1$1$1$1 androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue = composer2.rememberedValue();
                        if (androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$dialog$1$1$1$1$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.dialog(semanticsPropertyReceiver);
                                }
                            };
                            composer2.updateRememberedValue(androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        AndroidDialog_androidKt.DialogLayout(SemanticsModifierKt.semantics$default(companion, false, (Function1) androidDialog_androidKt$Dialog$dialog$1$1$1$1$1RememberedValue, 1, null), AndroidDialog_androidKt.Dialog$lambda$0(stateRememberUpdatedState), composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                composerStartRestartGroup.updateRememberedValue(dialogWrapper4);
                objRememberedValue = dialogWrapper4;
            }
            dialogWrapper = (DialogWrapper) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -140041010, "CC(remember):AndroidDialog.android.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(dialogWrapper);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        dialogWrapper.show();
                        final DialogWrapper dialogWrapper5 = dialogWrapper;
                        return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                dialogWrapper5.dismiss();
                                dialogWrapper5.disposeComposition();
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        dialogWrapper.show();
                        final DialogWrapper dialogWrapper5 = dialogWrapper;
                        return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                dialogWrapper5.dismiss();
                                dialogWrapper5.disposeComposition();
                            }
                        };
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(dialogWrapper, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -140036284, "CC(remember):AndroidDialog.android.kt#9igjgp");
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(dialogWrapper);
            if ((i4 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            zChanged2 = zChangedInstance3 | z2 | ((i4 & 112) == 32) | composerStartRestartGroup.changed(layoutDirection.ordinal());
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2$1
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
                        dialogWrapper.updateParameters(function0, dialogProperties3, layoutDirection);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2$1
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
                        dialogWrapper.updateParameters(function0, dialogProperties3, layoutDirection);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt.Dialog.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DialogLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1090521195);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DialogLayout)P(1)688@28193L559,688@28146L606:AndroidDialog.android.kt#2oxthz");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1090521195, i3, -1, "androidx.compose.ui.window.DialogLayout (AndroidDialog.android.kt:687)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 18853018, "CC(remember):AndroidDialog.android.kt#9igjgp");
            AndroidDialog_androidKt$DialogLayout$1$1 androidDialog_androidKt$DialogLayout$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (androidDialog_androidKt$DialogLayout$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                androidDialog_androidKt$DialogLayout$1$1RememberedValue = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        ArrayList arrayList = new ArrayList(list.size());
                        int size = list.size();
                        int iM9642getMinWidthimpl = 0;
                        int iM9641getMinHeightimpl = 0;
                        for (int i5 = 0; i5 < size; i5++) {
                            Placeable placeableMo8265measureBRTryo0 = list.get(i5).mo8265measureBRTryo0(j);
                            iM9642getMinWidthimpl = Math.max(iM9642getMinWidthimpl, placeableMo8265measureBRTryo0.getWidth());
                            iM9641getMinHeightimpl = Math.max(iM9641getMinHeightimpl, placeableMo8265measureBRTryo0.getHeight());
                            arrayList.add(placeableMo8265measureBRTryo0);
                        }
                        final ArrayList arrayList2 = arrayList;
                        if (list.isEmpty()) {
                            iM9642getMinWidthimpl = Constraints.m9642getMinWidthimpl(j);
                            iM9641getMinHeightimpl = Constraints.m9641getMinHeightimpl(j);
                        }
                        return MeasureScope.layout$default(measureScope, iM9642getMinWidthimpl, iM9641getMinHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                List<Placeable> list2 = arrayList2;
                                int size2 = list2.size();
                                for (int i6 = 0; i6 < size2; i6++) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, list2.get(i6), 0, 0, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(androidDialog_androidKt$DialogLayout$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) androidDialog_androidKt$DialogLayout$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i5 = ((i3 >> 3) & 14) | 384 | ((i3 << 3) & 112);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i6 = ((i5 << 6) & 896) | 6;
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 6) & 14));
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt.DialogLayout.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    AndroidDialog_androidKt.DialogLayout(modifier, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> Dialog$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
