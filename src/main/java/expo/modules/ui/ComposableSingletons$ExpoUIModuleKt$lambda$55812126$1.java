package expo.modules.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.button.ButtonPressedEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$-55812126$1, reason: invalid class name */
/* JADX INFO: compiled from: ExpoUIModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class ComposableSingletons$ExpoUIModuleKt$lambda$55812126$1 implements Function4<FunctionalComposableScope, TextButtonProps, Composer, Integer, Unit> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(ComposableSingletons$ExpoUIModuleKt$lambda$55812126$1.class, "onButtonPressed", "<v#0>", 0))};
    public static final ComposableSingletons$ExpoUIModuleKt$lambda$55812126$1 INSTANCE = new ComposableSingletons$ExpoUIModuleKt$lambda$55812126$1();

    ComposableSingletons$ExpoUIModuleKt$lambda$55812126$1() {
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, TextButtonProps textButtonProps, Composer composer, Integer num) {
        invoke(functionalComposableScope, textButtonProps, composer, num.intValue());
        return Unit.INSTANCE;
    }

    private static final ViewEventCallback<ButtonPressedEvent> invoke$lambda$1(ViewEventDelegate<ButtonPressedEvent> viewEventDelegate) {
        return viewEventDelegate.getValue($$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(ViewEventDelegate viewEventDelegate, ButtonPressedEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        invoke$lambda$1(viewEventDelegate).invoke(it);
        return Unit.INSTANCE;
    }

    public final void invoke(FunctionalComposableScope ExpoUIView, TextButtonProps props, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
        Intrinsics.checkNotNullParameter(props, "props");
        ComposerKt.sourceInformation(composer, "C250@7758L73,251@7863L23,251@7838L48:ExpoUIModule.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-55812126, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$-55812126.<anonymous> (ExpoUIModule.kt:250)");
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
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):ExpoUIModule.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(viewEventDelegate2);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$-55812126$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ComposableSingletons$ExpoUIModuleKt$lambda$55812126$1.invoke$lambda$3$lambda$2(viewEventDelegate2, (ButtonPressedEvent) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceGroup();
        TextButtonViewKt.TextButtonContent(ExpoUIView, props, (Function1) objRememberedValue2, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
