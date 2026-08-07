package expo.modules.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ExpoUIModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class ComposableSingletons$ExpoUIModuleKt$lambda$77819936$1 implements Function4<FunctionalComposableScope, AlertDialogProps, Composer, Integer, Unit> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(ComposableSingletons$ExpoUIModuleKt$lambda$77819936$1.class, "onDismissPressed", "<v#0>", 0)), Reflection.property0(new PropertyReference0Impl(ComposableSingletons$ExpoUIModuleKt$lambda$77819936$1.class, "onConfirmPressed", "<v#1>", 0))};
    public static final ComposableSingletons$ExpoUIModuleKt$lambda$77819936$1 INSTANCE = new ComposableSingletons$ExpoUIModuleKt$lambda$77819936$1();

    ComposableSingletons$ExpoUIModuleKt$lambda$77819936$1() {
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, AlertDialogProps alertDialogProps, Composer composer, Integer num) {
        invoke(functionalComposableScope, alertDialogProps, composer, num.intValue());
        return Unit.INSTANCE;
    }

    private static final ViewEventCallback<AlertDialogButtonPressedEvent> invoke$lambda$1(ViewEventDelegate<AlertDialogButtonPressedEvent> viewEventDelegate) {
        return viewEventDelegate.getValue($$delegatedProperties[0]);
    }

    private static final ViewEventCallback<AlertDialogButtonPressedEvent> invoke$lambda$3(ViewEventDelegate<AlertDialogButtonPressedEvent> viewEventDelegate) {
        return viewEventDelegate.getValue($$delegatedProperties[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4(ViewEventDelegate viewEventDelegate, AlertDialogButtonPressedEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        invoke$lambda$1(viewEventDelegate).invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6(ViewEventDelegate viewEventDelegate, AlertDialogButtonPressedEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        invoke$lambda$3(viewEventDelegate).invoke(it);
        return Unit.INSTANCE;
    }

    public final void invoke(FunctionalComposableScope ExpoUIView, AlertDialogProps props, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
        Intrinsics.checkNotNullParameter(props, "props");
        ComposerKt.sourceInformation(composer, "C220@6770L61,221@6862L61,224@6973L24,225@7007L24,222@6930L109:ExpoUIModule.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(77819936, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$77819936.<anonymous> (ExpoUIModule.kt:220)");
        }
        composer.startReplaceGroup(1849434622);
        ComposerKt.sourceInformation(composer, "CC(remember):ExpoUIModule.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object viewEventDelegate = new ViewEventDelegate(ExpoUIView.getView(), null);
            composer.updateRememberedValue(viewEventDelegate);
            objRememberedValue = viewEventDelegate;
        }
        final ViewEventDelegate viewEventDelegate2 = (ViewEventDelegate) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1849434622);
        ComposerKt.sourceInformation(composer, "CC(remember):ExpoUIModule.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            Object viewEventDelegate3 = new ViewEventDelegate(ExpoUIView.getView(), null);
            composer.updateRememberedValue(viewEventDelegate3);
            objRememberedValue2 = viewEventDelegate3;
        }
        final ViewEventDelegate viewEventDelegate4 = (ViewEventDelegate) objRememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):ExpoUIModule.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(viewEventDelegate2);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$77819936$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ComposableSingletons$ExpoUIModuleKt$lambda$77819936$1.invoke$lambda$5$lambda$4(viewEventDelegate2, (AlertDialogButtonPressedEvent) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        Function1 function1 = (Function1) objRememberedValue3;
        composer.endReplaceGroup();
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):ExpoUIModule.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(viewEventDelegate4);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function1() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$77819936$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ComposableSingletons$ExpoUIModuleKt$lambda$77819936$1.invoke$lambda$7$lambda$6(viewEventDelegate4, (AlertDialogButtonPressedEvent) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        composer.endReplaceGroup();
        AlertDialogViewKt.AlertDialogContent(ExpoUIView, props, function1, (Function1) objRememberedValue4, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
