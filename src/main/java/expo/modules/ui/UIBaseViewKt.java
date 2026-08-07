package expo.modules.ui;

import androidx.compose.runtime.Composer;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.ComposeViewFunctionDefinitionBuilder;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.kotlin.views.ModuleDefinitionBuilderWithCompose;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: UIBaseView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u007f\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001f\b\u0002\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\n23\b\b\u0010\u000b\u001a-\u0012\u0004\u0012\u00020\r\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000e\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0010¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"ExpoUIView", "", "Props", "Lexpo/modules/kotlin/views/ComposeProps;", "Lexpo/modules/kotlin/views/ModuleDefinitionBuilderWithCompose;", "name", "", BoxConvertedPushNotificationDevice.EVENTS, "Lkotlin/Function1;", "Lexpo/modules/kotlin/views/ComposeViewFunctionDefinitionBuilder;", "Lkotlin/ExtensionFunctionType;", "viewFunction", "Lkotlin/Function2;", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "Lkotlin/ParameterName;", "props", "Landroidx/compose/runtime/Composable;", "(Lexpo/modules/kotlin/views/ModuleDefinitionBuilderWithCompose;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UIBaseViewKt {
    public static /* synthetic */ void ExpoUIView$default(ModuleDefinitionBuilderWithCompose moduleDefinitionBuilderWithCompose, String name, Function1 events, Function4 viewFunction, int i, Object obj) {
        if ((i & 2) != 0) {
            Intrinsics.needClassReification();
            events = AnonymousClass1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(moduleDefinitionBuilderWithCompose, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(viewFunction, "viewFunction");
        Intrinsics.reifiedOperationMarker(4, "Props");
        ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder = new ComposeViewFunctionDefinitionBuilder(name, Reflection.getOrCreateKotlinClass(ComposeProps.class), viewFunction);
        events.invoke(composeViewFunctionDefinitionBuilder);
        moduleDefinitionBuilderWithCompose.registerViewDefinition(composeViewFunctionDefinitionBuilder.build());
    }

    public static final /* synthetic */ <Props extends ComposeProps> void ExpoUIView(ModuleDefinitionBuilderWithCompose moduleDefinitionBuilderWithCompose, String name, Function1<? super ComposeViewFunctionDefinitionBuilder<Props>, Unit> events, Function4<? super FunctionalComposableScope, ? super Props, ? super Composer, ? super Integer, Unit> viewFunction) {
        Intrinsics.checkNotNullParameter(moduleDefinitionBuilderWithCompose, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(viewFunction, "viewFunction");
        Intrinsics.reifiedOperationMarker(4, "Props");
        ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder = new ComposeViewFunctionDefinitionBuilder(name, Reflection.getOrCreateKotlinClass(ComposeProps.class), viewFunction);
        events.invoke(composeViewFunctionDefinitionBuilder);
        moduleDefinitionBuilderWithCompose.registerViewDefinition(composeViewFunctionDefinitionBuilder.build());
    }
}
