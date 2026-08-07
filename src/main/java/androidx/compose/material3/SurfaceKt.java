package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.internal.ChildParentSemanticsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Surface.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aj\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u009c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00152\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u001f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001b\u0010 \u001a5\u0010!\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020#H\u0003¢\u0006\u0004\b$\u0010%\u001aF\u0010\u0000\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0004\b'\u0010(\u001a\u001f\u0010)\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\nH\u0003¢\u0006\u0004\b+\u0010,\"\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Surface", "", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Surface-T9BRK9s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", ViewProps.ON_CLICK, "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Surface-o_FOJdg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "selected", "Surface-d85dljk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surface", "backgroundColor", "", "surface-XO-JAsU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/graphics/ColorProducer;", "Surface-vz2T9sI", "(Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/ui/Modifier;FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "surfaceColorAtElevation", "elevation", "surfaceColorAtElevation-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "LocalAbsoluteTonalElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalAbsoluteTonalElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SurfaceKt {
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SurfaceKt.LocalAbsoluteTonalElevation$lambda$0();
        }
    }, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_vz2T9sI$lambda$1(ColorProducer colorProducer, Modifier modifier, float f, float f2, Function2 function2, int i, int i2, Composer composer, int i3) {
        m4327Surfacevz2T9sI(colorProducer, modifier, f, f2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: Surface-T9BRK9s, reason: not valid java name */
    public static final void m4323SurfaceT9BRK9s(Modifier modifier, Shape shape, long j, long j2, float f, float f2, BorderStroke borderStroke, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1093433818, "C(Surface)N(modifier,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)100@5265L11,101@5312L22,107@5530L7,111@5704L884,108@5559L1029:Surface.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        if ((i2 & 4) != 0) {
            j = MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface();
        }
        if ((i2 & 8) != 0) {
            j2 = ColorSchemeKt.m3051contentColorForek8zF_U(j, composer, (i >> 6) & 14);
        }
        if ((i2 & 16) != 0) {
            f = Dp.m9687constructorimpl(0);
        }
        if ((i2 & 32) != 0) {
            f2 = Dp.m9687constructorimpl(0);
        }
        if ((i2 & 64) != 0) {
            borderStroke = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1093433818, i, -1, "androidx.compose.material3.Surface (Surface.kt:106)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final float fM9687constructorimpl = Dp.m9687constructorimpl(((Dp) objConsume).m9701unboximpl() + f);
        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(j2)), providableCompositionLocal.provides(Dp.m9685boximpl(fM9687constructorimpl))};
        final long j3 = j;
        final Shape shape2 = shape;
        final BorderStroke borderStroke2 = borderStroke;
        final float f3 = f2;
        final Modifier modifier2 = modifier;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.rememberComposableLambda(421772006, true, new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SurfaceKt.Surface_T9BRK9s$lambda$0(modifier2, shape2, j3, fM9687constructorimpl, borderStroke2, f3, function2, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_T9BRK9s$lambda$0(Modifier modifier, Shape shape, long j, float f, BorderStroke borderStroke, float f2, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C118@5906L69,120@6078L7,122@6194L256,128@6491L2,112@5714L868:Surface.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(421772006, i, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:112)");
            }
            long jM4329surfaceColorAtElevationCLU3JFs = m4329surfaceColorAtElevationCLU3JFs(j, f, composer, 0);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM4328surfaceXOJAsU = m4328surfaceXOJAsU(modifier, shape, jM4329surfaceColorAtElevationCLU3JFs, borderStroke, ((Density) objConsume).mo754toPx0680j_4(f2));
            ComposerKt.sourceInformationMarkerStart(composer, 1595987878, "CC(remember):Surface.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SurfaceKt.Surface_T9BRK9s$lambda$0$1$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierM4328surfaceXOJAsU, false, (Function1) objRememberedValue);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1595997128, "CC(remember):Surface.kt#9igjgp");
            SurfaceKt$Surface$1$3$1 surfaceKt$Surface$1$3$1RememberedValue = composer.rememberedValue();
            if (surfaceKt$Surface$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                surfaceKt$Surface$1$3$1RememberedValue = new PointerInputEventHandler() { // from class: androidx.compose.material3.SurfaceKt$Surface$1$3$1
                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        return Unit.INSTANCE;
                    }
                };
                composer.updateRememberedValue(surfaceKt$Surface$1$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierSemantics, unit, (PointerInputEventHandler) surfaceKt$Surface$1$3$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPointerInput);
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
            ComposerKt.sourceInformationMarkerStart(composer, 258689390, "C131@6563L9:Surface.kt#uh7d8r");
            function2.invoke(composer, 0);
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
    public static final Unit Surface_T9BRK9s$lambda$0$1$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: Surface-o_FOJdg, reason: not valid java name */
    public static final void m4326Surfaceo_FOJdg(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, float f, float f2, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2, int i3) {
        char c;
        ComposerKt.sourceInformationMarkerStart(composer, -1472753265, "C(Surface)N(onClick,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,interactionSource,content)202@10991L11,203@11038L22,212@11434L7,216@11608L870,213@11463L1015:Surface.kt#uh7d8r");
        final Modifier modifier2 = (i3 & 2) != 0 ? Modifier.INSTANCE : modifier;
        final boolean z2 = (i3 & 4) != 0 ? true : z;
        final Shape rectangleShape = (i3 & 8) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        final long surface = (i3 & 16) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface() : j;
        long jM3051contentColorForek8zF_U = (i3 & 32) != 0 ? ColorSchemeKt.m3051contentColorForek8zF_U(surface, composer, (i >> 12) & 14) : j2;
        float fM9687constructorimpl = (i3 & 64) != 0 ? Dp.m9687constructorimpl(0) : f;
        final float fM9687constructorimpl2 = (i3 & 128) != 0 ? Dp.m9687constructorimpl(0) : f2;
        BorderStroke borderStroke2 = (i3 & 256) != 0 ? null : borderStroke;
        MutableInteractionSource mutableInteractionSource2 = (i3 & 512) == 0 ? mutableInteractionSource : null;
        if (ComposerKt.isTraceInProgress()) {
            c = 1;
            ComposerKt.traceEventStart(-1472753265, i, i2, "androidx.compose.material3.Surface (Surface.kt:209)");
        } else {
            c = 1;
        }
        if (mutableInteractionSource2 == null) {
            composer.startReplaceGroup(-1701074900);
            ComposerKt.sourceInformation(composer, "211@11338L39");
            ComposerKt.sourceInformationMarkerStart(composer, 2023336598, "CC(remember):Surface.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            composer.startReplaceGroup(2023335947);
        }
        composer.endReplaceGroup();
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final float fM9687constructorimpl3 = Dp.m9687constructorimpl(((Dp) objConsume).m9701unboximpl() + fM9687constructorimpl);
        ProvidedValue[] providedValueArr = new ProvidedValue[2];
        providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U));
        providedValueArr[c] = providableCompositionLocal.provides(Dp.m9685boximpl(fM9687constructorimpl3));
        final BorderStroke borderStroke3 = borderStroke2;
        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.rememberComposableLambda(849208527, c, new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SurfaceKt.Surface_o_FOJdg$lambda$1(modifier2, rectangleShape, surface, fM9687constructorimpl3, borderStroke3, mutableInteractionSource3, z2, function0, fM9687constructorimpl2, function2, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_o_FOJdg$lambda$1(Modifier modifier, Shape shape, long j, float f, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, boolean z, Function0 function0, float f2, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C224@11865L69,226@12037L7,217@11618L854:Surface.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(849208527, i, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:217)");
            }
            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier);
            long jM4329surfaceColorAtElevationCLU3JFs = m4329surfaceColorAtElevationCLU3JFs(j, f, composer, 0);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierChildSemantics$default = ChildParentSemanticsKt.childSemantics$default(ClickableKt.m628clickableO2vRcR0$default(m4328surfaceXOJAsU(modifierMinimumInteractiveComponentSize, shape, jM4329surfaceColorAtElevationCLU3JFs, borderStroke, ((Density) objConsume).mo754toPx0680j_4(f2)), mutableInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z, null, null, function0, 24, null), null, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierChildSemantics$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, -361808591, "C237@12453L9:Surface.kt#uh7d8r");
            function2.invoke(composer, 0);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m4324Surfaced85dljk(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, Shape shape, long j, long j2, float f, float f2, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2, int i3) {
        char c;
        ComposerKt.sourceInformationMarkerStart(composer, 1416521139, "C(Surface)N(selected,onClick,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,interactionSource,content)308@16817L11,309@16864L22,318@17260L7,322@17434L916,319@17289L1061:Surface.kt#uh7d8r");
        final Modifier modifier2 = (i3 & 4) != 0 ? Modifier.INSTANCE : modifier;
        final boolean z3 = (i3 & 8) != 0 ? true : z2;
        final Shape rectangleShape = (i3 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        final long surface = (i3 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface() : j;
        long jM3051contentColorForek8zF_U = (i3 & 64) != 0 ? ColorSchemeKt.m3051contentColorForek8zF_U(surface, composer, (i >> 15) & 14) : j2;
        float fM9687constructorimpl = (i3 & 128) != 0 ? Dp.m9687constructorimpl(0) : f;
        final float fM9687constructorimpl2 = (i3 & 256) != 0 ? Dp.m9687constructorimpl(0) : f2;
        BorderStroke borderStroke2 = (i3 & 512) != 0 ? null : borderStroke;
        MutableInteractionSource mutableInteractionSource2 = (i3 & 1024) == 0 ? mutableInteractionSource : null;
        if (ComposerKt.isTraceInProgress()) {
            c = 1;
            ComposerKt.traceEventStart(1416521139, i, i2, "androidx.compose.material3.Surface (Surface.kt:315)");
        } else {
            c = 1;
        }
        if (mutableInteractionSource2 == null) {
            composer.startReplaceGroup(1528105640);
            ComposerKt.sourceInformation(composer, "317@17164L39");
            ComposerKt.sourceInformationMarkerStart(composer, -227800934, "CC(remember):Surface.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            composer.startReplaceGroup(-227801585);
        }
        composer.endReplaceGroup();
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final float fM9687constructorimpl3 = Dp.m9687constructorimpl(((Dp) objConsume).m9701unboximpl() + fM9687constructorimpl);
        ProvidedValue[] providedValueArr = new ProvidedValue[2];
        providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U));
        providedValueArr[c] = providableCompositionLocal.provides(Dp.m9685boximpl(fM9687constructorimpl3));
        final BorderStroke borderStroke3 = borderStroke2;
        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.rememberComposableLambda(1508735219, c, new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SurfaceKt.Surface_d85dljk$lambda$1(modifier2, rectangleShape, surface, fM9687constructorimpl3, borderStroke3, z, mutableInteractionSource3, z3, function0, fM9687constructorimpl2, function2, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_d85dljk$lambda$1(Modifier modifier, Shape shape, long j, float f, BorderStroke borderStroke, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function0 function0, float f2, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C330@17691L69,332@17863L7,323@17444L900:Surface.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1508735219, i, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:323)");
            }
            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier);
            long jM4329surfaceColorAtElevationCLU3JFs = m4329surfaceColorAtElevationCLU3JFs(j, f, composer, 0);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierChildSemantics$default = ChildParentSemanticsKt.childSemantics$default(SelectableKt.m1534selectableO2vRcR0$default(m4328surfaceXOJAsU(modifierMinimumInteractiveComponentSize, shape, jM4329surfaceColorAtElevationCLU3JFs, borderStroke, ((Density) objConsume).mo754toPx0680j_4(f2)), z, mutableInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z2, null, function0, 16, null), null, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierChildSemantics$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 2010194061, "C344@18325L9:Surface.kt#uh7d8r");
            function2.invoke(composer, 0);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m4325Surfaced85dljk(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, Shape shape, long j, long j2, float f, float f2, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2, int i3) {
        char c;
        ComposerKt.sourceInformationMarkerStart(composer, -1931279214, "C(Surface)N(checked,onCheckedChange,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,interactionSource,content)415@22756L11,416@22803L22,425@23199L7,429@23373L926,426@23228L1071:Surface.kt#uh7d8r");
        final Modifier modifier2 = (i3 & 4) != 0 ? Modifier.INSTANCE : modifier;
        final boolean z3 = (i3 & 8) != 0 ? true : z2;
        final Shape rectangleShape = (i3 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        final long surface = (i3 & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface() : j;
        long jM3051contentColorForek8zF_U = (i3 & 64) != 0 ? ColorSchemeKt.m3051contentColorForek8zF_U(surface, composer, (i >> 15) & 14) : j2;
        float fM9687constructorimpl = (i3 & 128) != 0 ? Dp.m9687constructorimpl(0) : f;
        final float fM9687constructorimpl2 = (i3 & 256) != 0 ? Dp.m9687constructorimpl(0) : f2;
        BorderStroke borderStroke2 = (i3 & 512) != 0 ? null : borderStroke;
        MutableInteractionSource mutableInteractionSource2 = (i3 & 1024) == 0 ? mutableInteractionSource : null;
        if (ComposerKt.isTraceInProgress()) {
            c = 1;
            ComposerKt.traceEventStart(-1931279214, i, i2, "androidx.compose.material3.Surface (Surface.kt:422)");
        } else {
            c = 1;
        }
        if (mutableInteractionSource2 == null) {
            composer.startReplaceGroup(643383721);
            ComposerKt.sourceInformation(composer, "424@23103L39");
            ComposerKt.sourceInformationMarkerStart(composer, -533435015, "CC(remember):Surface.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(objRememberedValue);
            }
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            composer.startReplaceGroup(-533435666);
        }
        composer.endReplaceGroup();
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final float fM9687constructorimpl3 = Dp.m9687constructorimpl(((Dp) objConsume).m9701unboximpl() + fM9687constructorimpl);
        ProvidedValue[] providedValueArr = new ProvidedValue[2];
        providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM3051contentColorForek8zF_U));
        providedValueArr[c] = providableCompositionLocal.provides(Dp.m9685boximpl(fM9687constructorimpl3));
        final BorderStroke borderStroke3 = borderStroke2;
        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.rememberComposableLambda(-1839065134, c, new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SurfaceKt.Surface_d85dljk$lambda$3(modifier2, rectangleShape, surface, fM9687constructorimpl3, borderStroke3, z, mutableInteractionSource3, z3, function1, fM9687constructorimpl2, function2, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_d85dljk$lambda$3(Modifier modifier, Shape shape, long j, float f, BorderStroke borderStroke, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function1 function1, float f2, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C437@23630L69,439@23802L7,430@23383L910:Surface.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1839065134, i, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:430)");
            }
            Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier);
            long jM4329surfaceColorAtElevationCLU3JFs = m4329surfaceColorAtElevationCLU3JFs(j, f, composer, 0);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierChildSemantics$default = ChildParentSemanticsKt.childSemantics$default(ToggleableKt.m1541toggleableO2vRcR0$default(m4328surfaceXOJAsU(modifierMinimumInteractiveComponentSize, shape, jM4329surfaceColorAtElevationCLU3JFs, borderStroke, ((Density) objConsume).mo754toPx0680j_4(f2)), z, mutableInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, 0.0f, 0L, 7, null), z2, null, function1, 16, null), null, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierChildSemantics$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1125458254, "C451@24274L9:Surface.kt#uh7d8r");
            function2.invoke(composer, 0);
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

    /* JADX INFO: renamed from: surface-XO-JAsU, reason: not valid java name */
    private static final Modifier m4328surfaceXOJAsU(Modifier modifier, Shape shape, long j, BorderStroke borderStroke, float f) {
        Shape shape2;
        Modifier.Companion companionM6978graphicsLayerAp8cVGQ;
        if (f > 0.0f) {
            shape2 = shape;
            companionM6978graphicsLayerAp8cVGQ = GraphicsLayerModifierKt.m6978graphicsLayerAp8cVGQ(Modifier.INSTANCE, (131064 & 1) != 0 ? 1.0f : 0.0f, (131064 & 2) != 0 ? 1.0f : 0.0f, (131064 & 4) == 0 ? 0.0f : 1.0f, (131064 & 8) != 0 ? 0.0f : 0.0f, (131064 & 16) != 0 ? 0.0f : 0.0f, (131064 & 32) != 0 ? 0.0f : f, (131064 & 64) != 0 ? 0.0f : 0.0f, (131064 & 128) != 0 ? 0.0f : 0.0f, (131064 & 256) == 0 ? 0.0f : 0.0f, (131064 & 512) != 0 ? 8.0f : 0.0f, (131064 & 1024) != 0 ? TransformOrigin.INSTANCE.m7229getCenterSzJe1aQ() : 0L, (131064 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : shape2, (131064 & 4096) != 0 ? false : false, (131064 & 8192) != 0 ? null : null, (131064 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (32768 & 131064) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (131064 & 65536) != 0 ? CompositingStrategy.INSTANCE.m6905getAutoNrFUSI() : 0);
        } else {
            shape2 = shape;
            companionM6978graphicsLayerAp8cVGQ = Modifier.INSTANCE;
        }
        return ClipKt.clip(BackgroundKt.m588backgroundbw27NRU(modifier.then(companionM6978graphicsLayerAp8cVGQ).then(borderStroke != null ? BorderKt.border(Modifier.INSTANCE, borderStroke, shape2) : Modifier.INSTANCE), j, shape2), shape2);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:33:0x005b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:56:0x009d  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x0112  */
    /* JADX WARN: Code duplicated, block: B:65:0x0118  */
    /* JADX WARN: Code duplicated, block: B:68:0x0123  */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Surface-vz2T9sI, reason: not valid java name */
    public static final void m4327Surfacevz2T9sI(final ColorProducer colorProducer, final Modifier modifier, float f, float f2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        float f3;
        int i4;
        float f4;
        int i5;
        boolean z;
        final float f5;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final float fM9687constructorimpl;
        final float fM9687constructorimpl2;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1185311536);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Surface)N(backgroundColor,modifier,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)486@25169L7,487@25253L7,488@25297L11,489@25394L1141,489@25313L1222:Surface.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(colorProducer) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 384) == 0) {
                f3 = f;
                i3 |= composerStartRestartGroup.changed(f3) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    f4 = f2;
                    if (composerStartRestartGroup.changed(f4)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i3 |= i6;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    f5 = f3;
                    f6 = f4;
                } else {
                    if (i7 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f3;
                    }
                    if (i4 != 0) {
                        fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl2 = f4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1185311536, i3, -1, "androidx.compose.material3.Surface (Surface.kt:485)");
                    }
                    ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fM9687constructorimpl3 = Dp.m9687constructorimpl(((Dp) objConsume).m9701unboximpl() + fM9687constructorimpl);
                    ProvidableCompositionLocal<Boolean> localTonalElevationEnabled = ColorSchemeKt.getLocalTonalElevationEnabled();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localTonalElevationEnabled);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final boolean zBooleanValue = ((Boolean) objConsume2).booleanValue();
                    final ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                    CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(Dp.m9685boximpl(fM9687constructorimpl3)), ComposableLambdaKt.rememberComposableLambda(85870608, true, new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_vz2T9sI$lambda$0(modifier, fM9687constructorimpl2, colorProducer, colorScheme, zBooleanValue, fM9687constructorimpl, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f6 = fM9687constructorimpl2;
                    f5 = fM9687constructorimpl;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SurfaceKt.Surface_vz2T9sI$lambda$1(colorProducer, modifier, f5, f6, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            f4 = f2;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                f5 = f3;
                f6 = f4;
            } else {
                if (i7 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f3;
                }
                if (i4 != 0) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl2 = f4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1185311536, i3, -1, "androidx.compose.material3.Surface (Surface.kt:485)");
                }
                ProvidableCompositionLocal<Dp> providableCompositionLocal2 = LocalAbsoluteTonalElevation;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(providableCompositionLocal2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fM9687constructorimpl4 = Dp.m9687constructorimpl(((Dp) objConsume3).m9701unboximpl() + fM9687constructorimpl);
                ProvidableCompositionLocal<Boolean> localTonalElevationEnabled2 = ColorSchemeKt.getLocalTonalElevationEnabled();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localTonalElevationEnabled2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final boolean zBooleanValue2 = ((Boolean) objConsume4).booleanValue();
                final ColorScheme colorScheme2 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal2.provides(Dp.m9685boximpl(fM9687constructorimpl4)), ComposableLambdaKt.rememberComposableLambda(85870608, true, new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_vz2T9sI$lambda$0(modifier, fM9687constructorimpl2, colorProducer, colorScheme2, zBooleanValue2, fM9687constructorimpl, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f6 = fM9687constructorimpl2;
                f5 = fM9687constructorimpl;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_vz2T9sI$lambda$1(colorProducer, modifier, f5, f6, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        f3 = f;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                f4 = f2;
                if (composerStartRestartGroup.changed(f4)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                f5 = f3;
                f6 = f4;
            } else {
                if (i7 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f3;
                }
                if (i4 != 0) {
                    fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl2 = f4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1185311536, i3, -1, "androidx.compose.material3.Surface (Surface.kt:485)");
                }
                ProvidableCompositionLocal<Dp> providableCompositionLocal3 = LocalAbsoluteTonalElevation;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(providableCompositionLocal3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fM9687constructorimpl5 = Dp.m9687constructorimpl(((Dp) objConsume5).m9701unboximpl() + fM9687constructorimpl);
                ProvidableCompositionLocal<Boolean> localTonalElevationEnabled3 = ColorSchemeKt.getLocalTonalElevationEnabled();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localTonalElevationEnabled3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final boolean zBooleanValue3 = ((Boolean) objConsume6).booleanValue();
                final ColorScheme colorScheme3 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
                CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal3.provides(Dp.m9685boximpl(fM9687constructorimpl5)), ComposableLambdaKt.rememberComposableLambda(85870608, true, new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_vz2T9sI$lambda$0(modifier, fM9687constructorimpl2, colorProducer, colorScheme3, zBooleanValue3, fM9687constructorimpl, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f6 = fM9687constructorimpl2;
                f5 = fM9687constructorimpl;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SurfaceKt.Surface_vz2T9sI$lambda$1(colorProducer, modifier, f5, f6, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        f4 = f2;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i3 |= i6;
        }
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            f5 = f3;
            f6 = f4;
        } else {
            if (i7 != 0) {
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            } else {
                fM9687constructorimpl = f3;
            }
            if (i4 != 0) {
                fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
            } else {
                fM9687constructorimpl2 = f4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1185311536, i3, -1, "androidx.compose.material3.Surface (Surface.kt:485)");
            }
            ProvidableCompositionLocal<Dp> providableCompositionLocal4 = LocalAbsoluteTonalElevation;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume7 = composerStartRestartGroup.consume(providableCompositionLocal4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fM9687constructorimpl6 = Dp.m9687constructorimpl(((Dp) objConsume7).m9701unboximpl() + fM9687constructorimpl);
            ProvidableCompositionLocal<Boolean> localTonalElevationEnabled4 = ColorSchemeKt.getLocalTonalElevationEnabled();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume8 = composerStartRestartGroup.consume(localTonalElevationEnabled4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final boolean zBooleanValue4 = ((Boolean) objConsume8).booleanValue();
            final ColorScheme colorScheme4 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6);
            CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal4.provides(Dp.m9685boximpl(fM9687constructorimpl6)), ComposableLambdaKt.rememberComposableLambda(85870608, true, new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SurfaceKt.Surface_vz2T9sI$lambda$0(modifier, fM9687constructorimpl2, colorProducer, colorScheme4, zBooleanValue4, fM9687constructorimpl, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f6 = fM9687constructorimpl2;
            f5 = fM9687constructorimpl;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SurfaceKt.Surface_vz2T9sI$lambda$1(colorProducer, modifier, f5, f6, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_vz2T9sI$lambda$0$0$0(float f, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setShadowElevation(graphicsLayerScope.mo754toPx0680j_4(f));
        graphicsLayerScope.setClip(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_vz2T9sI$lambda$0$1$0(ColorProducer colorProducer, ColorScheme colorScheme, boolean z, float f, DrawScope drawScope) {
        long jMo2379invoke0d7_KjU = colorProducer.mo2379invoke0d7_KjU();
        if (Color.m6815equalsimpl0(jMo2379invoke0d7_KjU, colorScheme.getSurface()) && z) {
            jMo2379invoke0d7_KjU = ColorSchemeKt.m3064surfaceColorAtElevation3ABfNKs(colorScheme, f);
        }
        DrawScope.m7389drawRectnJ9OG0$default(drawScope, jMo2379invoke0d7_KjU, 0L, 0L, 0.0f, null, null, 0, 126, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-CLU3JFs, reason: not valid java name */
    private static final long m4329surfaceColorAtElevationCLU3JFs(long j, float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2079918090, "C(surfaceColorAtElevation)N(color:c#ui.graphics.Color,elevation:c#ui.unit.Dp)524@26643L11,524@26655L37:Surface.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079918090, i, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:524)");
        }
        long jM3049applyTonalElevationRFCenO8 = ColorSchemeKt.m3049applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j, f, composer, (i << 3) & 1008);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM3049applyTonalElevationRFCenO8;
    }

    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteTonalElevation() {
        return LocalAbsoluteTonalElevation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Surface_vz2T9sI$lambda$0(Modifier modifier, final float f, final ColorProducer colorProducer, final ColorScheme colorScheme, final boolean z, final float f2, Function2 function2, Composer composer, int i) {
        Modifier.Companion companionGraphicsLayer;
        ComposerKt.sourceInformation(composer, "C503@25894L591,490@25404L1125:Surface.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(85870608, i, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:490)");
            }
            if (Dp.m9686compareTo0680j_4(f, Dp.m9687constructorimpl(0)) > 0) {
                composer.startReplaceGroup(-1629077399);
                ComposerKt.sourceInformation(composer, "495@25589L154");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 917282058, "CC(remember):Surface.kt#9igjgp");
                boolean zChanged = composer.changed(f);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SurfaceKt.Surface_vz2T9sI$lambda$0$0$0(f, (GraphicsLayerScope) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                companionGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1628845550);
                composer.endReplaceGroup();
                companionGraphicsLayer = Modifier.INSTANCE;
            }
            Modifier modifierThen = modifier.then(companionGraphicsLayer);
            ComposerKt.sourceInformationMarkerStart(composer, 917292255, "CC(remember):Surface.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(colorProducer) | composer.changed(colorScheme) | composer.changed(z) | composer.changed(f2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SurfaceKt.Surface_vz2T9sI$lambda$0$1$0(colorProducer, colorScheme, z, f2, (DrawScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierDrawBehind = DrawModifierKt.drawBehind(modifierThen, (Function1) objRememberedValue2);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierDrawBehind);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1732559696, "C517@26510L9:Surface.kt#uh7d8r");
            function2.invoke(composer, 0);
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
    public static final Dp LocalAbsoluteTonalElevation$lambda$0() {
        return Dp.m9685boximpl(Dp.m9687constructorimpl(0));
    }
}
