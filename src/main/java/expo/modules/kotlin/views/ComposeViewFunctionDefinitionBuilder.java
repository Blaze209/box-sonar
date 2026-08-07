package expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.Composer;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.modules.DefinitionMarker;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.views.ComposeProps;
import java.util.Collection;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: ModuleDefinitionBuilderComposeExtension.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003BP\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00121\u0010\b\u001a-\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u001b\u001a\u00020\u001cJ\u001f\u0010\u001d\u001a\u00020\r2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001f\"\u00020\u0005¢\u0006\u0002\u0010 J\u001d\u0010\u001d\u001a\u00020\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fH\u0007¢\u0006\u0004\b!\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R>\u0010\b\u001a-\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\u0004\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lexpo/modules/kotlin/views/ComposeViewFunctionDefinitionBuilder;", "Props", "Lexpo/modules/kotlin/views/ComposeProps;", "", "name", "", "propsClass", "Lkotlin/reflect/KClass;", "viewFunction", "Lkotlin/Function2;", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "Lkotlin/ParameterName;", "props", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Ljava/lang/String;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function4;)V", "getName", "()Ljava/lang/String;", "getPropsClass", "()Lkotlin/reflect/KClass;", "getViewFunction", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "callbacksDefinition", "Lexpo/modules/kotlin/views/CallbacksDefinition;", "build", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "Events", "callbacks", "", "([Ljava/lang/String;)V", "EventsWithArray", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@DefinitionMarker
public final class ComposeViewFunctionDefinitionBuilder<Props extends ComposeProps> {
    public static final int $stable = 8;
    private CallbacksDefinition callbacksDefinition;
    private final String name;
    private final KClass<Props> propsClass;
    private final Function4<FunctionalComposableScope, Props, Composer, Integer, Unit> viewFunction;

    /* JADX WARN: Multi-variable type inference failed */
    public ComposeViewFunctionDefinitionBuilder(String name, KClass<Props> propsClass, Function4<? super FunctionalComposableScope, ? super Props, ? super Composer, ? super Integer, Unit> viewFunction) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(propsClass, "propsClass");
        Intrinsics.checkNotNullParameter(viewFunction, "viewFunction");
        this.name = name;
        this.propsClass = propsClass;
        this.viewFunction = viewFunction;
        this.callbacksDefinition = new CallbacksDefinition(new String[]{ModuleDefinitionBuilderComposeExtensionKt.GLOBAL_EVENT_NAME});
    }

    public final String getName() {
        return this.name;
    }

    public final KClass<Props> getPropsClass() {
        return this.propsClass;
    }

    public final Function4<FunctionalComposableScope, Props, Composer, Integer, Unit> getViewFunction() {
        return this.viewFunction;
    }

    public final ViewManagerDefinition build() {
        String str = this.name;
        CallbacksDefinition callbacksDefinition = this.callbacksDefinition;
        Class<ComposeFunctionHolder> cls = ComposeFunctionHolder.class;
        Collection<KProperty1> memberProperties = KClasses.getMemberProperties(this.propsClass);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(memberProperties, 10)), 16));
        for (KProperty1 kProperty1 : memberProperties) {
            Pair pair = TuplesKt.to(kProperty1.getName(), new ComposeViewProp(kProperty1.getName(), new AnyType(kProperty1.getReturnType(), null, 2, null), kProperty1));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return new ViewManagerDefinition(new Function2() { // from class: expo.modules.kotlin.views.ComposeViewFunctionDefinitionBuilder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ComposeViewFunctionDefinitionBuilder.build$lambda$1(this.f$0, (Context) obj, (AppContext) obj2);
            }
        }, cls, linkedHashMap, str, null, callbacksDefinition, null, null, null, 464, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View build$lambda$1(ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder, Context context, AppContext appContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        try {
            return new ComposeFunctionHolder(context, appContext, composeViewFunctionDefinitionBuilder.name, composeViewFunctionDefinitionBuilder.viewFunction, (ComposeProps) KClasses.createInstance(composeViewFunctionDefinitionBuilder.propsClass));
        } catch (Exception e) {
            throw new IllegalStateException("Could not instantiate props instance of " + composeViewFunctionDefinitionBuilder.name + " compose component.", e);
        }
    }

    public final void Events(String... callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(ModuleDefinitionBuilderComposeExtensionKt.GLOBAL_EVENT_NAME);
        spreadBuilder.addSpread(callbacks);
        this.callbacksDefinition = new CallbacksDefinition((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
    }

    public final void EventsWithArray(String[] callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(ModuleDefinitionBuilderComposeExtensionKt.GLOBAL_EVENT_NAME);
        spreadBuilder.addSpread(callbacks);
        this.callbacksDefinition = new CallbacksDefinition((String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
    }
}
