package expo.modules.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.menu.ContextMenuButtonPressedEvent;
import expo.modules.ui.menu.ContextMenuKt;
import expo.modules.ui.menu.ContextMenuProps;
import expo.modules.ui.menu.ContextMenuSwitchValueChangeEvent;
import expo.modules.ui.menu.ExpandedChangedEvent;
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
final class ComposableSingletons$ExpoUIModuleKt$lambda$1585574314$1 implements Function4<FunctionalComposableScope, ContextMenuProps, Composer, Integer, Unit> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(ComposableSingletons$ExpoUIModuleKt$lambda$1585574314$1.class, "onContextMenuButtonPressed", "<v#0>", 0)), Reflection.property0(new PropertyReference0Impl(ComposableSingletons$ExpoUIModuleKt$lambda$1585574314$1.class, "onContextMenuSwitchValueChanged", "<v#1>", 0)), Reflection.property0(new PropertyReference0Impl(ComposableSingletons$ExpoUIModuleKt$lambda$1585574314$1.class, "onExpandedChanged", "<v#2>", 0))};
    public static final ComposableSingletons$ExpoUIModuleKt$lambda$1585574314$1 INSTANCE = new ComposableSingletons$ExpoUIModuleKt$lambda$1585574314$1();

    ComposableSingletons$ExpoUIModuleKt$lambda$1585574314$1() {
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ContextMenuProps contextMenuProps, Composer composer, Integer num) {
        invoke(functionalComposableScope, contextMenuProps, composer, num.intValue());
        return Unit.INSTANCE;
    }

    private static final ViewEventCallback<ContextMenuButtonPressedEvent> invoke$lambda$1(ViewEventDelegate<ContextMenuButtonPressedEvent> viewEventDelegate) {
        return viewEventDelegate.getValue($$delegatedProperties[0]);
    }

    private static final ViewEventCallback<ContextMenuSwitchValueChangeEvent> invoke$lambda$3(ViewEventDelegate<ContextMenuSwitchValueChangeEvent> viewEventDelegate) {
        return viewEventDelegate.getValue($$delegatedProperties[1]);
    }

    private static final ViewEventCallback<ExpandedChangedEvent> invoke$lambda$5(ViewEventDelegate<ExpandedChangedEvent> viewEventDelegate) {
        return viewEventDelegate.getValue($$delegatedProperties[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6(ViewEventDelegate viewEventDelegate, ContextMenuButtonPressedEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        invoke$lambda$1(viewEventDelegate).invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$9$lambda$8(ViewEventDelegate viewEventDelegate, ContextMenuSwitchValueChangeEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        invoke$lambda$3(viewEventDelegate).invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$11$lambda$10(ViewEventDelegate viewEventDelegate, ExpandedChangedEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        invoke$lambda$5(viewEventDelegate).invoke(it);
        return Unit.INSTANCE;
    }

    public final void invoke(FunctionalComposableScope ExpoUIView, ContextMenuProps props, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
        Intrinsics.checkNotNullParameter(props, "props");
        ComposerKt.sourceInformation(composer, "C150@4641L61,151@4748L65,152@4845L52,155@4947L34,156@4991L39,157@5040L25,153@4904L169:ExpoUIModule.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1585574314, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$1585574314.<anonymous> (ExpoUIModule.kt:150)");
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
        composer.startReplaceGroup(1849434622);
        ComposerKt.sourceInformation(composer, "CC(remember):ExpoUIModule.kt#9igjgp");
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            Object viewEventDelegate5 = new ViewEventDelegate(ExpoUIView.getView(), null);
            composer.updateRememberedValue(viewEventDelegate5);
            objRememberedValue3 = viewEventDelegate5;
        }
        final ViewEventDelegate viewEventDelegate6 = (ViewEventDelegate) objRememberedValue3;
        composer.endReplaceGroup();
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):ExpoUIModule.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(viewEventDelegate2);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function1() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$1585574314$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ComposableSingletons$ExpoUIModuleKt$lambda$1585574314$1.invoke$lambda$7$lambda$6(viewEventDelegate2, (ContextMenuButtonPressedEvent) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        Function1 function1 = (Function1) objRememberedValue4;
        composer.endReplaceGroup();
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):ExpoUIModule.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(viewEventDelegate4);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = new Function1() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$1585574314$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ComposableSingletons$ExpoUIModuleKt$lambda$1585574314$1.invoke$lambda$9$lambda$8(viewEventDelegate4, (ContextMenuSwitchValueChangeEvent) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        Function1 function2 = (Function1) objRememberedValue5;
        composer.endReplaceGroup();
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):ExpoUIModule.kt#9igjgp");
        boolean zChangedInstance3 = composer.changedInstance(viewEventDelegate6);
        Object objRememberedValue6 = composer.rememberedValue();
        if (zChangedInstance3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue6 = new Function1() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$1585574314$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ComposableSingletons$ExpoUIModuleKt$lambda$1585574314$1.invoke$lambda$11$lambda$10(viewEventDelegate6, (ExpandedChangedEvent) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue6);
        }
        composer.endReplaceGroup();
        ContextMenuKt.ContextMenuContent(ExpoUIView, props, function1, function2, (Function1) objRememberedValue6, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
