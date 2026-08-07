package expo.modules.kotlin.views;

import androidx.compose.runtime.Composer;
import androidx.exifinterface.media.ExifInterface;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;
import expo.modules.kotlin.modules.InternalModuleDefinitionBuilder;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.views.decorators.CSSPropsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: ModuleDefinitionBuilderComposeExtension.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J^\u0010\u0006\u001a\u00020\u0007\"\u0010\b\u0000\u0010\b\u0018\u0001*\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0001\u0010\n\u0018\u0001*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\r2\u001f\b\u0002\u0010\u000e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0010\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u0011H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0012J}\u0010\u0006\u001a\u00020\u0007\"\n\b\u0000\u0010\u0013\u0018\u0001*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u001f\b\u0002\u0010\u0017\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u0018\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\u0002\b\u001123\b\b\u0010\u0019\u001a-\u0012\u0004\u0012\u00020\u001b\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u001f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"Lexpo/modules/kotlin/views/ModuleDefinitionBuilderWithCompose;", "Lexpo/modules/kotlin/modules/InternalModuleDefinitionBuilder;", "module", "Lexpo/modules/kotlin/modules/Module;", "<init>", "(Lexpo/modules/kotlin/modules/Module;)V", "View", "", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/views/ExpoComposeView;", "P", "", "viewClass", "Lkotlin/reflect/KClass;", "body", "Lkotlin/Function1;", "Lexpo/modules/kotlin/views/ViewDefinitionBuilder;", "Lkotlin/ExtensionFunctionType;", "ComposeView", "Props", "Lexpo/modules/kotlin/views/ComposeProps;", "name", "", BoxConvertedPushNotificationDevice.EVENTS, "Lexpo/modules/kotlin/views/ComposeViewFunctionDefinitionBuilder;", "viewFunction", "Lkotlin/Function2;", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "Lkotlin/ParameterName;", "props", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ModuleDefinitionBuilderWithCompose extends InternalModuleDefinitionBuilder {
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public ModuleDefinitionBuilderWithCompose() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ModuleDefinitionBuilderWithCompose(Module module, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : module);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ModuleDefinitionBuilderWithCompose(Module module) {
        super(module, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void ComposeView$default(ModuleDefinitionBuilderWithCompose moduleDefinitionBuilderWithCompose, KClass viewClass, Function1 body, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                Intrinsics.needClassReification();
                body = ModuleDefinitionBuilderWithCompose$View$1.INSTANCE;
            }
            Intrinsics.checkNotNullParameter(viewClass, "viewClass");
            Intrinsics.checkNotNullParameter(body, "body");
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ExpoComposeView.class);
            Intrinsics.needClassReification();
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(viewClass, new LazyKType(orCreateKotlinClass, false, ModuleDefinitionBuilderWithCompose$View$viewDefinitionBuilder$1.INSTANCE, 2, null), null, 4, null);
            Intrinsics.reifiedOperationMarker(4, "P");
            for (KProperty1 kProperty1 : KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(Object.class))) {
                KType type = ((KTypeProjection) CollectionsKt.first((List) kProperty1.getReturnType().getArguments())).getType();
                if (type != null && viewDefinitionBuilder.getProps().get(kProperty1.getName()) == null) {
                    viewDefinitionBuilder.getProps().put(kProperty1.getName(), new ComposeViewProp(kProperty1.getName(), new AnyType(type, null, 2, null), kProperty1));
                }
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
            body.invoke(viewDefinitionBuilder);
            moduleDefinitionBuilderWithCompose.registerViewDefinition(viewDefinitionBuilder.build());
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: View");
    }

    public final /* synthetic */ <T extends ExpoComposeView<P>, P> void ComposeView(KClass<T> viewClass, Function1<? super ViewDefinitionBuilder<T>, Unit> body) {
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ExpoComposeView.class);
        Intrinsics.needClassReification();
        ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(viewClass, new LazyKType(orCreateKotlinClass, false, ModuleDefinitionBuilderWithCompose$View$viewDefinitionBuilder$1.INSTANCE, 2, null), null, 4, null);
        Intrinsics.reifiedOperationMarker(4, "P");
        for (KProperty1 kProperty1 : KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(Object.class))) {
            KType type = ((KTypeProjection) CollectionsKt.first((List) kProperty1.getReturnType().getArguments())).getType();
            if (type != null && viewDefinitionBuilder.getProps().get(kProperty1.getName()) == null) {
                viewDefinitionBuilder.getProps().put(kProperty1.getName(), new ComposeViewProp(kProperty1.getName(), new AnyType(type, null, 2, null), kProperty1));
            }
        }
        CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
        body.invoke(viewDefinitionBuilder);
        registerViewDefinition(viewDefinitionBuilder.build());
    }

    public static /* synthetic */ void ComposeView$default(ModuleDefinitionBuilderWithCompose moduleDefinitionBuilderWithCompose, String name, Function1 events, Function4 viewFunction, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                Intrinsics.needClassReification();
                events = ModuleDefinitionBuilderWithCompose$View$3.INSTANCE;
            }
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(events, "events");
            Intrinsics.checkNotNullParameter(viewFunction, "viewFunction");
            Intrinsics.reifiedOperationMarker(4, "Props");
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder = new ComposeViewFunctionDefinitionBuilder(name, Reflection.getOrCreateKotlinClass(ComposeProps.class), viewFunction);
            events.invoke(composeViewFunctionDefinitionBuilder);
            moduleDefinitionBuilderWithCompose.registerViewDefinition(composeViewFunctionDefinitionBuilder.build());
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: View");
    }

    public final /* synthetic */ <Props extends ComposeProps> void ComposeView(String name, Function1<? super ComposeViewFunctionDefinitionBuilder<Props>, Unit> events, Function4<? super FunctionalComposableScope, ? super Props, ? super Composer, ? super Integer, Unit> viewFunction) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(viewFunction, "viewFunction");
        Intrinsics.reifiedOperationMarker(4, "Props");
        ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder = new ComposeViewFunctionDefinitionBuilder(name, Reflection.getOrCreateKotlinClass(ComposeProps.class), viewFunction);
        events.invoke(composeViewFunctionDefinitionBuilder);
        registerViewDefinition(composeViewFunctionDefinitionBuilder.build());
    }
}
