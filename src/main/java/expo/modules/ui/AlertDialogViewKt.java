package expo.modules.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlertDialogView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"AlertDialogContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/AlertDialogProps;", "onDismissPressed", "Lkotlin/Function1;", "Lexpo/modules/ui/AlertDialogButtonPressedEvent;", "onConfirmPressed", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/AlertDialogProps;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AlertDialogViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogContent$lambda$0(FunctionalComposableScope functionalComposableScope, AlertDialogProps alertDialogProps, Function1 function1, Function1 function2, int i, Composer composer, int i2) {
        AlertDialogContent(functionalComposableScope, alertDialogProps, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogContent$lambda$3(FunctionalComposableScope functionalComposableScope, AlertDialogProps alertDialogProps, Function1 function1, Function1 function2, int i, Composer composer, int i2) {
        AlertDialogContent(functionalComposableScope, alertDialogProps, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AlertDialogContent(final FunctionalComposableScope functionalComposableScope, final AlertDialogProps props, final Function1<? super AlertDialogButtonPressedEvent, Unit> onDismissPressed, final Function1<? super AlertDialogButtonPressedEvent, Unit> onConfirmPressed, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onDismissPressed, "onDismissPressed");
        Intrinsics.checkNotNullParameter(onConfirmPressed, "onConfirmPressed");
        Composer composerStartRestartGroup = composer.startRestartGroup(1237429795);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialogContent)P(2,1)47@1373L53,33@992L167,40@1181L167,48@1440L33,49@1486L32,32@959L563:AlertDialogView.kt#v15e7d");
        if ((i & 48) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(props) ? 32 : 16) | i;
        } else {
            i2 = i;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismissPressed) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onConfirmPressed) ? 2048 : 1024;
        }
        if ((i2 & 1169) != 1168 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1237429795, i2, -1, "expo.modules.ui.AlertDialogContent (AlertDialogView.kt:27)");
            }
            if (!props.getVisible()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.AlertDialogViewKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AlertDialogViewKt.AlertDialogContent$lambda$0(functionalComposableScope, props, onDismissPressed, onConfirmPressed, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AlertDialogView.kt#9igjgp");
            boolean z = (i2 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.AlertDialogViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AlertDialogViewKt.AlertDialogContent$lambda$2$lambda$1(onDismissPressed);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            composer2 = composerStartRestartGroup;
            AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0((Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-1030880149, true, new AnonymousClass3(props, onConfirmPressed), composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1858895469, true, new AnonymousClass4(props, onDismissPressed), composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(453703791, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.AlertDialogViewKt.AlertDialogContent.5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    ComposerKt.sourceInformation(composer3, "C*48@1461L8:AlertDialogView.kt#v15e7d");
                    if ((i3 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(453703791, i3, -1, "expo.modules.ui.AlertDialogContent.<anonymous> (AlertDialogView.kt:48)");
                    }
                    String title = props.getTitle();
                    if (title != null) {
                        TextKt.m4494TextNvy7gAk(title, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 262142);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-248892048, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.AlertDialogViewKt.AlertDialogContent.6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    ComposerKt.sourceInformation(composer3, "C*49@1506L8:AlertDialogView.kt#v15e7d");
                    if ((i3 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-248892048, i3, -1, "expo.modules.ui.AlertDialogContent.<anonymous> (AlertDialogView.kt:49)");
                    }
                    String text = props.getText();
                    if (text != null) {
                        TextKt.m4494TextNvy7gAk(text, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 262142);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: expo.modules.ui.AlertDialogViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogViewKt.AlertDialogContent$lambda$3(functionalComposableScope, props, onDismissPressed, onConfirmPressed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: expo.modules.ui.AlertDialogViewKt$AlertDialogContent$3, reason: invalid class name */
    /* JADX INFO: compiled from: AlertDialogView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class AnonymousClass3 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function1<AlertDialogButtonPressedEvent, Unit> $onConfirmPressed;
        final /* synthetic */ AlertDialogProps $props;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(AlertDialogProps alertDialogProps, Function1<? super AlertDialogButtonPressedEvent, Unit> function1) {
            this.$props = alertDialogProps;
            this.$onConfirmPressed = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C*35@1060L53,35@1115L30,35@1039L106:AlertDialogView.kt#v15e7d");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1030880149, i, -1, "expo.modules.ui.AlertDialogContent.<anonymous> (AlertDialogView.kt:34)");
            }
            final String confirmButtonText = this.$props.getConfirmButtonText();
            if (confirmButtonText != null) {
                final Function1<AlertDialogButtonPressedEvent, Unit> function1 = this.$onConfirmPressed;
                composer.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composer, "CC(remember):AlertDialogView.kt#9igjgp");
                boolean zChanged = composer.changed(function1);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: expo.modules.ui.AlertDialogViewKt$AlertDialogContent$3$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AlertDialogViewKt.AnonymousClass3.invoke$lambda$2$lambda$1$lambda$0(function1);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                composer.endReplaceGroup();
                ButtonKt.TextButton((Function0<Unit>) objRememberedValue, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(954985616, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: expo.modules.ui.AlertDialogViewKt$AlertDialogContent$3$1$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope TextButton, Composer composer2, int i2) {
                        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                        ComposerKt.sourceInformation(composer2, "C36@1127L8:AlertDialogView.kt#v15e7d");
                        if ((i2 & 17) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(954985616, i2, -1, "expo.modules.ui.AlertDialogContent.<anonymous>.<anonymous>.<anonymous> (AlertDialogView.kt:36)");
                        }
                        TextKt.m4494TextNvy7gAk(confirmButtonText, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 262142);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), composer, 805306368, 510);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$2$lambda$1$lambda$0(Function1 function1) {
            function1.invoke(new AlertDialogButtonPressedEvent());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: expo.modules.ui.AlertDialogViewKt$AlertDialogContent$4, reason: invalid class name */
    /* JADX INFO: compiled from: AlertDialogView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class AnonymousClass4 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function1<AlertDialogButtonPressedEvent, Unit> $onDismissPressed;
        final /* synthetic */ AlertDialogProps $props;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(AlertDialogProps alertDialogProps, Function1<? super AlertDialogButtonPressedEvent, Unit> function1) {
            this.$props = alertDialogProps;
            this.$onDismissPressed = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C*42@1249L53,42@1304L30,42@1228L106:AlertDialogView.kt#v15e7d");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1858895469, i, -1, "expo.modules.ui.AlertDialogContent.<anonymous> (AlertDialogView.kt:41)");
            }
            final String dismissButtonText = this.$props.getDismissButtonText();
            if (dismissButtonText != null) {
                final Function1<AlertDialogButtonPressedEvent, Unit> function1 = this.$onDismissPressed;
                composer.startReplaceGroup(5004770);
                ComposerKt.sourceInformation(composer, "CC(remember):AlertDialogView.kt#9igjgp");
                boolean zChanged = composer.changed(function1);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: expo.modules.ui.AlertDialogViewKt$AlertDialogContent$4$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AlertDialogViewKt.AnonymousClass4.invoke$lambda$2$lambda$1$lambda$0(function1);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                composer.endReplaceGroup();
                ButtonKt.TextButton((Function0<Unit>) objRememberedValue, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-450206062, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: expo.modules.ui.AlertDialogViewKt$AlertDialogContent$4$1$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope TextButton, Composer composer2, int i2) {
                        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                        ComposerKt.sourceInformation(composer2, "C43@1316L8:AlertDialogView.kt#v15e7d");
                        if ((i2 & 17) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-450206062, i2, -1, "expo.modules.ui.AlertDialogContent.<anonymous>.<anonymous>.<anonymous> (AlertDialogView.kt:43)");
                        }
                        TextKt.m4494TextNvy7gAk(dismissButtonText, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 262142);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer, 54), composer, 805306368, 510);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$2$lambda$1$lambda$0(Function1 function1) {
            function1.invoke(new AlertDialogButtonPressedEvent());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialogContent$lambda$2$lambda$1(Function1 function1) {
        function1.invoke(new AlertDialogButtonPressedEvent());
        return Unit.INSTANCE;
    }
}
