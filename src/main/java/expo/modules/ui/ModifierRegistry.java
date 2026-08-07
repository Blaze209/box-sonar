package expo.modules.ui;

import android.graphics.Color;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.shape.CutCornerShape;
import androidx.compose.foundation.shape.CutCornerShapeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material3.MaterialShapesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.unit.Dp;
import androidx.graphics.shapes.RoundedPolygon;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.records.RecordTypeConverter;
import expo.modules.kotlin.records.RecordTypeConverterKt;
import expo.modules.kotlin.types.TypeConverter;
import expo.modules.kotlin.types.TypeConverterProviderImpl;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.ui.convertibles.AlignmentType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: ModifierRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J|\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00062g\u0010\u0014\u001ac\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bj\u0002`\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012(\u0012&\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u0007j\u0002`\u0011¢\u0006\u0002\b\u0010¢\u0006\u0002\u0010\u0015Jk\u0010\u0016\u001a\u00020\u000f2 \u0010\u0017\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bj\u0002`\t\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\n2*\u0010\u001b\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000eH\u0007¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0006J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018J\b\u0010 \u001a\u00020\rH\u0002R{\u0010\u0004\u001ao\u0012\u0004\u0012\u00020\u0006\u0012e\u0012c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bj\u0002`\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012(\u0012&\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u0007j\u0002`\u0011¢\u0006\u0002\b\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lexpo/modules/ui/ModifierRegistry;", "", "<init>", "()V", "modifierFactories", "", "", "Lkotlin/Function4;", "", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/kotlin/views/ComposableScope;", "Lexpo/modules/kotlin/AppContext;", "Lkotlin/Function2;", "", "Lexpo/modules/ui/ModifierEventDispatcher;", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "Lexpo/modules/ui/ModifierFactory;", "register", "type", "factory", "(Ljava/lang/String;Lkotlin/jvm/functions/Function6;)V", "applyModifiers", "modifiers", "", "appContext", "scope", "eventDispatcher", "(Ljava/util/List;Lexpo/modules/kotlin/AppContext;Lexpo/modules/kotlin/views/ComposableScope;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "hasModifier", "", "registeredTypes", "registerBuiltInModifiers", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModifierRegistry {
    public static final int $stable;
    public static final ModifierRegistry INSTANCE;
    private static final Map<String, Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit>, Composer, Integer, Modifier>> modifierFactories;

    private ModifierRegistry() {
    }

    static {
        ModifierRegistry modifierRegistry = new ModifierRegistry();
        INSTANCE = modifierRegistry;
        modifierFactories = new LinkedHashMap();
        modifierRegistry.registerBuiltInModifiers();
        $stable = 8;
    }

    public final void register(String type, Function6<? super Map<String, ? extends Object>, ? super ComposableScope, ? super AppContext, ? super Function2<? super String, ? super Map<String, ? extends Object>, Unit>, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(factory, "factory");
        modifierFactories.put(type, factory);
    }

    public final Modifier applyModifiers(List<? extends Map<String, ? extends Object>> list, AppContext appContext, ComposableScope scope, Function2<? super String, ? super Map<String, ? extends Object>, Unit> eventDispatcher, Composer composer, int i) {
        AppContext appContext2;
        ComposableScope composableScope;
        Function2<? super String, ? super Map<String, ? extends Object>, Unit> function2;
        Composer composer2;
        Modifier modifierInvoke;
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        composer.startReplaceGroup(-1182308343);
        ComposerKt.sourceInformation(composer, "C(applyModifiers)P(2!1,3):ModifierRegistry.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1182308343, i, -1, "expo.modules.ui.ModifierRegistry.applyModifiers (ModifierRegistry.kt:217)");
        }
        List<? extends Map<String, ? extends Object>> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            Modifier.Companion companion = Modifier.INSTANCE;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return companion;
        }
        Modifier.Companion companion2 = Modifier.INSTANCE;
        Intrinsics.checkNotNull(companion2, "null cannot be cast to non-null type androidx.compose.ui.Modifier");
        Modifier.Companion companionThen = companion2;
        for (Map<String, ? extends Object> map : list) {
            Object obj = map.get("$type");
            String str = obj instanceof String ? (String) obj : null;
            if (str == null) {
                appContext2 = appContext;
                composableScope = scope;
                function2 = eventDispatcher;
                composer2 = composer;
            } else {
                Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit>, Composer, Integer, Modifier> function6 = modifierFactories.get(str);
                composer.startReplaceGroup(1968029083);
                ComposerKt.sourceInformation(composer, "221@6390L50");
                if (function6 == null) {
                    appContext2 = appContext;
                    function2 = eventDispatcher;
                    composer2 = composer;
                    modifierInvoke = null;
                    composableScope = scope;
                } else {
                    appContext2 = appContext;
                    composableScope = scope;
                    function2 = eventDispatcher;
                    composer2 = composer;
                    modifierInvoke = function6.invoke(map, composableScope, appContext2, function2, composer2, Integer.valueOf((ComposableScope.$stable << 3) | ((i >> 3) & 112) | (AppContext.$stable << 6) | ((i << 3) & 896) | (i & 7168)));
                }
                composer2.endReplaceGroup();
                if (modifierInvoke == null) {
                    modifierInvoke = Modifier.INSTANCE;
                }
                companionThen = companionThen.then(modifierInvoke);
            }
            scope = composableScope;
            appContext = appContext2;
            eventDispatcher = function2;
            composer = composer2;
        }
        Composer composer3 = composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer3.endReplaceGroup();
        return companionThen;
    }

    public final boolean hasModifier(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return modifierFactories.get(type) != null;
    }

    public final List<String> registeredTypes() {
        return CollectionsKt.toList(modifierFactories.keySet());
    }

    private final void registerBuiltInModifiers() {
        register("paddingAll", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.1
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(-137508514);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-137508514, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:243)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(PaddingAllParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(((PaddingAllParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getAll()));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM1218padding3ABfNKs;
            }
        });
        register(ViewProps.PADDING, new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.2
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(-460946745);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-460946745, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:248)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(PaddingParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                PaddingParams paddingParams = (PaddingParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter);
                Modifier modifierM1221paddingqDBjuR0 = PaddingKt.m1221paddingqDBjuR0(Modifier.INSTANCE, Dp.m9687constructorimpl(paddingParams.getStart()), Dp.m9687constructorimpl(paddingParams.getTop()), Dp.m9687constructorimpl(paddingParams.getEnd()), Dp.m9687constructorimpl(paddingParams.getBottom()));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM1221paddingqDBjuR0;
            }
        });
        register("size", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.3
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(233700262);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(233700262, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:259)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(SizeParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                SizeParams sizeParams = (SizeParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter);
                Modifier modifierM1268sizeVpY3zN4 = SizeKt.m1268sizeVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(sizeParams.getWidth()), Dp.m9687constructorimpl(sizeParams.getHeight()));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM1268sizeVpY3zN4;
            }
        });
        register("fillMaxSize", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.4
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(928347269);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(928347269, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:264)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(FillMaxSizeParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                Modifier modifierFillMaxSize = SizeKt.fillMaxSize(Modifier.INSTANCE, ((FillMaxSizeParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getFraction());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierFillMaxSize;
            }
        });
        register("fillMaxWidth", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.5
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(1622994276);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1622994276, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:269)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(FillMaxWidthParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.INSTANCE, ((FillMaxWidthParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getFraction());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierFillMaxWidth;
            }
        });
        register("fillMaxHeight", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.6
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(-1977326013);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1977326013, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:274)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(FillMaxHeightParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                Modifier modifierFillMaxHeight = SizeKt.fillMaxHeight(Modifier.INSTANCE, ((FillMaxHeightParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getFraction());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierFillMaxHeight;
            }
        });
        register("width", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.7
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(-1282679006);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1282679006, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:279)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(WidthParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                Modifier modifierM1271width3ABfNKs = SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(((WidthParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getWidth()));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM1271width3ABfNKs;
            }
        });
        register("height", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.8
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(-588031999);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-588031999, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:284)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(HeightParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(((HeightParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getHeight()));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM1252height3ABfNKs;
            }
        });
        register("wrapContentWidth", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.9
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Modifier modifierWrapContentWidth$default;
                Alignment.Horizontal horizontalAlignment;
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(106615008);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(106615008, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:289)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(WrapContentWidthParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                AlignmentType alignment = ((WrapContentWidthParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getAlignment();
                if (alignment == null || (horizontalAlignment = alignment.toHorizontalAlignment()) == null || (modifierWrapContentWidth$default = SizeKt.wrapContentWidth$default(Modifier.INSTANCE, horizontalAlignment, false, 2, null)) == null) {
                    modifierWrapContentWidth$default = SizeKt.wrapContentWidth$default(Modifier.INSTANCE, null, false, 3, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierWrapContentWidth$default;
            }
        });
        register("wrapContentHeight", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.10
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Modifier modifierWrapContentHeight$default;
                Alignment.Vertical verticalAlignment;
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(801262015);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(801262015, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:296)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(WrapContentHeightParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                AlignmentType alignment = ((WrapContentHeightParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getAlignment();
                if (alignment == null || (verticalAlignment = alignment.toVerticalAlignment()) == null || (modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(Modifier.INSTANCE, verticalAlignment, false, 2, null)) == null) {
                    modifierWrapContentHeight$default = SizeKt.wrapContentHeight$default(Modifier.INSTANCE, null, false, 3, null);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierWrapContentHeight$default;
            }
        });
        register("offset", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.11
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(523002921);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(523002921, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:304)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(OffsetParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                OffsetParams offsetParams = (OffsetParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter);
                Modifier modifierM1174offsetVpY3zN4 = OffsetKt.m1174offsetVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(offsetParams.getX()), Dp.m9687constructorimpl(offsetParams.getY()));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM1174offsetVpY3zN4;
            }
        });
        register(AppStateModule.APP_STATE_BACKGROUND, new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.12
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Modifier.Companion companionM589backgroundbw27NRU$default;
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(1217649928);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1217649928, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:310)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(BackgroundParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                Color color = ((BackgroundParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getColor();
                if (color == null || (companionM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, UtilsKt.getCompose(color), null, 2, null)) == null) {
                    companionM589backgroundbw27NRU$default = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return companionM589backgroundbw27NRU$default;
            }
        });
        register(OutlinedTextFieldKt.BorderId, new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.13
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Modifier.Companion companionBorder$default;
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(1912296935);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1912296935, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:317)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(BorderParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                BorderParams borderParams = (BorderParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter);
                Color borderColor = borderParams.getBorderColor();
                if (borderColor == null || (companionBorder$default = BorderKt.border$default(Modifier.INSTANCE, BorderStrokeKt.m622BorderStrokecXLIe8U(Dp.m9687constructorimpl(borderParams.getBorderWidth()), UtilsKt.getCompose(borderColor)), null, 2, null)) == null) {
                    companionBorder$default = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return companionBorder$default;
            }
        });
        register("shadow", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.14
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(-1688023354);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1688023354, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:324)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(ShadowParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                Modifier modifierM6412shadows4CzXII$default = ShadowKt.m6412shadows4CzXII$default(Modifier.INSTANCE, Dp.m9687constructorimpl(((ShadowParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getElevation()), null, false, 0L, 0L, 30, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM6412shadows4CzXII$default;
            }
        });
        register("alpha", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.15
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(-993376347);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-993376347, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:329)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(AlphaParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                Modifier modifierAlpha = AlphaKt.alpha(Modifier.INSTANCE, ((AlphaParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getAlpha());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierAlpha;
            }
        });
        register("blur", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.16
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(-298729340);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-298729340, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:334)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(BlurParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                Modifier modifierM6337blurF8QBwvs$default = BlurKt.m6337blurF8QBwvs$default(Modifier.INSTANCE, Dp.m9687constructorimpl(((BlurParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getRadius()), null, 2, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierM6337blurF8QBwvs$default;
            }
        });
        register("rotate", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.17
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(395917667);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(395917667, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:340)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(RotateParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                Modifier modifierRotate = RotateKt.rotate(Modifier.INSTANCE, ((RotateParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getDegrees());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierRotate;
            }
        });
        register(ViewProps.Z_INDEX, new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.18
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(1090564674);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1090564674, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:345)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(ZIndexParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                Modifier modifierZIndex = ZIndexModifierKt.zIndex(Modifier.INSTANCE, ((ZIndexParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getIndex());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierZIndex;
            }
        });
        register("animateContentSize", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.19
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(1785211681);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1785211681, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:351)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(AnimateContentSizeParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                AnimateContentSizeParams animateContentSizeParams = (AnimateContentSizeParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter);
                Modifier modifierAnimateContentSize$default = AnimationModifierKt.animateContentSize$default(Modifier.INSTANCE, AnimationSpecKt.spring$default(animateContentSizeParams.getDampingRatio(), animateContentSizeParams.getStiffness(), null, 4, null), null, 2, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierAnimateContentSize$default;
            }
        });
        register("weight", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.20
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Modifier.Companion companionWeight$default;
                ColumnScope columnScope;
                RowScope rowScope;
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(-1815108608);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1815108608, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:359)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(WeightParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                WeightParams weightParams = (WeightParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter);
                if (composableScope == null || (rowScope = composableScope.getRowScope()) == null || (companionWeight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, weightParams.getWeight(), false, 2, null)) == null) {
                    if (composableScope != null && (columnScope = composableScope.getColumnScope()) != null) {
                        companionWeight$default = ColumnScope.weight$default(columnScope, Modifier.INSTANCE, weightParams.getWeight(), false, 2, null);
                    } else {
                        companionWeight$default = Modifier.INSTANCE;
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return companionWeight$default;
            }
        });
        register("align", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.21
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            /* JADX WARN: Code duplicated, block: B:16:0x0056  */
            /* JADX WARN: Code duplicated, block: B:24:0x0073  */
            /* JADX WARN: Code duplicated, block: B:26:0x0076  */
            /* JADX WARN: Code duplicated, block: B:35:0x0095  */
            /* JADX WARN: Code duplicated, block: B:36:0x009b  */
            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Modifier.Companion companionAlign;
                ColumnScope columnScope;
                AlignmentType alignment;
                Alignment.Horizontal horizontalAlignment;
                RowScope rowScope;
                AlignmentType alignment2;
                Alignment.Vertical verticalAlignment;
                BoxScope boxScope;
                Alignment alignment3;
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(582223658);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(582223658, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:368)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(AlignParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                AlignParams alignParams = (AlignParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter);
                Modifier modifierAlign = null;
                if (composableScope == null || (boxScope = composableScope.getBoxScope()) == null) {
                    if (composableScope != null || (rowScope = composableScope.getRowScope()) == null || (alignment2 = alignParams.getAlignment()) == null || (verticalAlignment = alignment2.toVerticalAlignment()) == null) {
                        companionAlign = null;
                    } else {
                        companionAlign = rowScope.align(Modifier.INSTANCE, verticalAlignment);
                    }
                    if (companionAlign == null) {
                        if (composableScope != null && (columnScope = composableScope.getColumnScope()) != null && (alignment = alignParams.getAlignment()) != null && (horizontalAlignment = alignment.toHorizontalAlignment()) != null) {
                            modifierAlign = columnScope.align(Modifier.INSTANCE, horizontalAlignment);
                        }
                        if (modifierAlign == null) {
                            companionAlign = Modifier.INSTANCE;
                        } else {
                            companionAlign = modifierAlign;
                        }
                    }
                } else {
                    AlignmentType alignment4 = alignParams.getAlignment();
                    companionAlign = (alignment4 == null || (alignment3 = alignment4.toAlignment()) == null) ? null : boxScope.align(Modifier.INSTANCE, alignment3);
                    if (companionAlign == null) {
                        if (composableScope != null) {
                            companionAlign = null;
                        } else {
                            companionAlign = null;
                        }
                        if (companionAlign == null) {
                            if (composableScope != null) {
                                modifierAlign = columnScope.align(Modifier.INSTANCE, horizontalAlignment);
                            }
                            if (modifierAlign == null) {
                                companionAlign = Modifier.INSTANCE;
                            } else {
                                companionAlign = modifierAlign;
                            }
                        }
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return companionAlign;
            }
        });
        register("matchParentSize", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.22
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> unused$var$, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$2, Composer composer, int i) {
                Modifier.Companion companionMatchParentSize;
                BoxScope boxScope;
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                Intrinsics.checkNotNullParameter(unused$var$2, "$unused$var$");
                composer.startReplaceGroup(1276870665);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1276870665, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:379)");
                }
                if (composableScope == null || (boxScope = composableScope.getBoxScope()) == null || (companionMatchParentSize = boxScope.matchParentSize(Modifier.INSTANCE)) == null) {
                    companionMatchParentSize = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return companionMatchParentSize;
            }
        });
        register(ViewProps.TEST_ID, new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.23
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                Modifier.Companion companionApplyTestTag;
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(1971517672);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1971517672, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:386)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(TestIDParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                String testID = ((TestIDParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getTestID();
                if (testID == null || (companionApplyTestTag = ModifiersKt.applyTestTag(Modifier.INSTANCE, testID)) == null) {
                    companionApplyTestTag = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return companionApplyTestTag;
            }
        });
        register("clip", new Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier>() { // from class: expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.24
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
                return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
            }

            public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, Unit> unused$var$, Composer composer, int i) throws MissingTypeConverter {
                CutCornerShape shape;
                CutCornerShape cutCornerShapeM1567CutCornerShapea9UjIt4;
                RoundedCornerShape roundedCornerShapeM1574RoundedCornerShapea9UjIt4;
                Intrinsics.checkNotNullParameter(map, "map");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                composer.startReplaceGroup(-1628802617);
                ComposerKt.sourceInformation(composer, "C:ModifierRegistry.kt#v15e7d");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1628802617, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:393)");
                }
                TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(ClipParams.class));
                Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
                BuiltinShapeRecord shape2 = ((ClipParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter)).getShape();
                Modifier.Companion companionClip = null;
                if (shape2 != null) {
                    BuiltinShapeType type = shape2.getType();
                    composer.startReplaceGroup(-1911213631);
                    ComposerKt.sourceInformation(composer, "425@13074L9");
                    if (type == BuiltinShapeType.RECTANGLE) {
                        shape = RectangleShapeKt.getRectangleShape();
                    } else if (type == BuiltinShapeType.CIRCLE) {
                        shape = RoundedCornerShapeKt.getCircleShape();
                    } else {
                        if (type == BuiltinShapeType.ROUNDED_CORNER) {
                            if (shape2.getTopStart() != null || shape2.getTopEnd() != null || shape2.getBottomStart() != null || shape2.getBottomEnd() != null) {
                                Float topStart = shape2.getTopStart();
                                float fM9687constructorimpl = Dp.m9687constructorimpl(topStart != null ? topStart.floatValue() : 0.0f);
                                Float topEnd = shape2.getTopEnd();
                                float fM9687constructorimpl2 = Dp.m9687constructorimpl(topEnd != null ? topEnd.floatValue() : 0.0f);
                                Float bottomStart = shape2.getBottomStart();
                                float fM9687constructorimpl3 = Dp.m9687constructorimpl(bottomStart != null ? bottomStart.floatValue() : 0.0f);
                                Float bottomEnd = shape2.getBottomEnd();
                                roundedCornerShapeM1574RoundedCornerShapea9UjIt4 = RoundedCornerShapeKt.m1574RoundedCornerShapea9UjIt4(fM9687constructorimpl, fM9687constructorimpl2, Dp.m9687constructorimpl(bottomEnd != null ? bottomEnd.floatValue() : 0.0f), fM9687constructorimpl3);
                            } else {
                                Float radius = shape2.getRadius();
                                roundedCornerShapeM1574RoundedCornerShapea9UjIt4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(radius != null ? radius.floatValue() : 0.0f));
                            }
                            shape = roundedCornerShapeM1574RoundedCornerShapea9UjIt4;
                        } else if (type == BuiltinShapeType.CUT_CORNER) {
                            if (shape2.getTopStart() != null || shape2.getTopEnd() != null || shape2.getBottomStart() != null || shape2.getBottomEnd() != null) {
                                Float topStart2 = shape2.getTopStart();
                                float fM9687constructorimpl4 = Dp.m9687constructorimpl(topStart2 != null ? topStart2.floatValue() : 0.0f);
                                Float topEnd2 = shape2.getTopEnd();
                                float fM9687constructorimpl5 = Dp.m9687constructorimpl(topEnd2 != null ? topEnd2.floatValue() : 0.0f);
                                Float bottomStart2 = shape2.getBottomStart();
                                float fM9687constructorimpl6 = Dp.m9687constructorimpl(bottomStart2 != null ? bottomStart2.floatValue() : 0.0f);
                                Float bottomEnd2 = shape2.getBottomEnd();
                                cutCornerShapeM1567CutCornerShapea9UjIt4 = CutCornerShapeKt.m1567CutCornerShapea9UjIt4(fM9687constructorimpl4, fM9687constructorimpl5, Dp.m9687constructorimpl(bottomEnd2 != null ? bottomEnd2.floatValue() : 0.0f), fM9687constructorimpl6);
                            } else {
                                Float radius2 = shape2.getRadius();
                                cutCornerShapeM1567CutCornerShapea9UjIt4 = CutCornerShapeKt.m1566CutCornerShape0680j_4(Dp.m9687constructorimpl(radius2 != null ? radius2.floatValue() : 0.0f));
                            }
                            shape = cutCornerShapeM1567CutCornerShapea9UjIt4;
                        } else {
                            if (type != BuiltinShapeType.MATERIAL) {
                                throw new NoWhenBranchMatchedException();
                            }
                            MaterialShapeType name = shape2.getName();
                            RoundedPolygon roundedPolygon = name != null ? name.toRoundedPolygon() : null;
                            shape = roundedPolygon == null ? null : MaterialShapesKt.toShape(roundedPolygon, 0, composer, 0, 1);
                        }
                    }
                    composer.endReplaceGroup();
                    if (shape != null) {
                        companionClip = ClipKt.clip(Modifier.INSTANCE, shape);
                    }
                }
                if (companionClip == null) {
                    companionClip = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return companionClip;
            }
        });
        register("clickable", AnonymousClass25.INSTANCE);
        register(ComposeIdentificationData.FIELD_IS_SELECTABLE, AnonymousClass26.INSTANCE);
    }

    /* JADX INFO: renamed from: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$25, reason: invalid class name */
    /* JADX INFO: compiled from: ModifierRegistry.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class AnonymousClass25 implements Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier> {
        public static final AnonymousClass25 INSTANCE = new AnonymousClass25();

        AnonymousClass25() {
        }

        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
            return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
        }

        public final Modifier invoke(Map<String, ? extends Object> unused$var$, ComposableScope composableScope, AppContext appContext, final Function2<? super String, ? super Map<String, ? extends Object>, Unit> eventDispatcher, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
            Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
            composer.startReplaceGroup(-934155610);
            ComposerKt.sourceInformation(composer, "C435@13280L58:ModifierRegistry.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-934155610, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:435)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            composer.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composer, "CC(remember):ModifierRegistry.kt#9igjgp");
            boolean z = (((i & 7168) ^ 3072) > 2048 && composer.changed(eventDispatcher)) || (i & 3072) == 2048;
            Object objRememberedValue = composer.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$25$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModifierRegistry.AnonymousClass25.invoke$lambda$1$lambda$0(eventDispatcher);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceGroup();
            Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue, 15, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return modifierM632clickableoSLSa3U$default;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(Function2 function2) {
            function2.invoke("clickable", MapsKt.emptyMap());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$26, reason: invalid class name */
    /* JADX INFO: compiled from: ModifierRegistry.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class AnonymousClass26 implements Function6<Map<String, ? extends Object>, ComposableScope, AppContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit>, Composer, Integer, Modifier> {
        public static final AnonymousClass26 INSTANCE = new AnonymousClass26();

        AnonymousClass26() {
        }

        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Unit> function2, Composer composer, Integer num) {
            return invoke(map, composableScope, appContext, (Function2<? super String, ? super Map<String, ? extends Object>, Unit>) function2, composer, num.intValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(Function2 function2) {
            function2.invoke(ComposeIdentificationData.FIELD_IS_SELECTABLE, MapsKt.emptyMap());
            return Unit.INSTANCE;
        }

        public final Modifier invoke(Map<String, ? extends Object> map, ComposableScope composableScope, AppContext appContext, final Function2<? super String, ? super Map<String, ? extends Object>, Unit> eventDispatcher, Composer composer, int i) throws MissingTypeConverter {
            Intrinsics.checkNotNullParameter(map, "map");
            Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
            composer.startReplaceGroup(-239508603);
            ComposerKt.sourceInformation(composer, "CP(1)444@13542L45:ModifierRegistry.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-239508603, i, -1, "expo.modules.ui.ModifierRegistry.registerBuiltInModifiers.<anonymous> (ModifierRegistry.kt:441)");
            }
            TypeConverter<?> typeConverterObtainTypeConverter = TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(Reflection.typeOf(SelectableParams.class));
            Intrinsics.checkNotNull(typeConverterObtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.records.RecordTypeConverter<T of expo.modules.kotlin.records.RecordTypeConverterKt.recordFromMap>");
            SelectableParams selectableParams = (SelectableParams) RecordTypeConverterKt.recordFromMap(map, (RecordTypeConverter) typeConverterObtainTypeConverter);
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean selected = selectableParams.getSelected();
            composer.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composer, "CC(remember):ModifierRegistry.kt#9igjgp");
            boolean z = (((i & 7168) ^ 3072) > 2048 && composer.changed(eventDispatcher)) || (i & 3072) == 2048;
            Object objRememberedValue = composer.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.ModifierRegistry$registerBuiltInModifiers$26$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ModifierRegistry.AnonymousClass26.invoke$lambda$1$lambda$0(eventDispatcher);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceGroup();
            Modifier modifierM1538selectableoSLSa3U$default = SelectableKt.m1538selectableoSLSa3U$default(companion, selected, false, null, null, (Function0) objRememberedValue, 14, null);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return modifierM1538selectableoSLSa3U$default;
        }
    }
}
