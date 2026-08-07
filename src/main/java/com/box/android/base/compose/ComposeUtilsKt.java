package com.box.android.base.compose;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.LocalActivityKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.exifinterface.media.ExifInterface;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.box.android.base.R;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.facebook.react.uimanager.ViewProps;
import dagger.hilt.android.lifecycle.HiltViewModelExtensions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComposeUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0013\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0006*\u00020\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0006H\u0007¢\u0006\u0002\u0010\t\u001a'\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000bH\u0007¢\u0006\u0002\u0010\u000e\u001a&\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u0086\bø\u0001\u0000\u001a\u0012\u0010\u0014\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0012\u001a\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a#\u0010\u0019\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010\u001f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0001¢\u0006\u0004\b \u0010\u001e\u001a\u0012\u0010!\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\"\u001a\u00020#\u001a1\u0010$\u001a\u00020\u0010*\u00020\u00102\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(H\u0007¢\u0006\u0002\u0010+\u001a&\u0010,\u001a\u0002H-\"\n\b\u0000\u0010-\u0018\u0001*\u00020.2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010#H\u0087\b¢\u0006\u0002\u0010/\u001a\"\u00100\u001a\u0002H-\"\n\b\u0000\u0010-\u0018\u0001*\u00020.2\u0006\u00101\u001a\u000202H\u0087\b¢\u0006\u0002\u00103\u001a\u001d\u00104\u001a\b\u0012\u0004\u0012\u0002050\u00172\u0006\u00106\u001a\u000207H\u0007¢\u0006\u0004\b8\u00109\u001a#\u0010:\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020&2\b\u0010;\u001a\u0004\u0018\u0001H\fH\u0007¢\u0006\u0002\u0010<\u001a\r\u0010=\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010>\"\u000e\u0010?\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006@²\u0006\u0016\u0010A\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020&X\u008a\u008e\u0002"}, d2 = {"toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-o2QH7mI", "(JLandroidx/compose/runtime/Composer;I)F", "toPx", "", "toPx-8Feqmps", "(FLandroidx/compose/runtime/Composer;I)I", "(ILandroidx/compose/runtime/Composer;I)F", "remembered", "Lkotlin/Function0;", ExifInterface.GPS_DIRECTION_TRUE, "calculation", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "addIfCondition", "Landroidx/compose/ui/Modifier;", "condition", "", "modifierToAdd", "visibleIf", ViewProps.VISIBLE, "keyboardIsOpenedAsState", "Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "bottomBorder", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "bottomBorder-Hht5A8o", "(Landroidx/compose/ui/Modifier;JF)Landroidx/compose/ui/Modifier;", "topBorder", "topBorder-Hht5A8o", "dialogSemantics", "contentDescription", "", "longClickableWithOffset", "key", "", "onLongClick", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/DpOffset;", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "hiltActivityViewModel", "VM", "Landroidx/lifecycle/ViewModel;", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/lifecycle/ViewModel;", "hiltViewModelWithArgs", "args", "Landroid/os/Bundle;", "(Landroid/os/Bundle;Landroidx/compose/runtime/Composer;I)Landroidx/lifecycle/ViewModel;", "rememberCurrentTimeMillis", "", "updatePeriod", "Lkotlin/time/Duration;", "rememberCurrentTimeMillis-KLykuaI", "(JLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "rememberLastNotNull", "value", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "getIsLandscapePhone", "(Landroidx/compose/runtime/Composer;I)Z", "LANDSCAPE_PHONE_SMALLEST_WIDTH_DP", "base_generalProdRelease", "lastValue"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ComposeUtilsKt {
    private static final int LANDSCAPE_PHONE_SMALLEST_WIDTH_DP = 600;

    /* JADX INFO: renamed from: toDp-o2QH7mI, reason: not valid java name */
    public static final float m11637toDpo2QH7mI(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -553857755, "C(toDp)52@2270L7:ComposeUtils.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-553857755, i, -1, "com.box.android.base.compose.toDp (ComposeUtils.kt:52)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float f = ((Density) objConsume).mo749toDpGaN1DYA(j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return f;
    }

    /* JADX INFO: renamed from: toPx-8Feqmps, reason: not valid java name */
    public static final int m11638toPx8Feqmps(float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2139502151, "C(toPx)58@2376L7:ComposeUtils.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2139502151, i, -1, "com.box.android.base.compose.toPx (ComposeUtils.kt:58)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        int iMo754toPx0680j_4 = (int) ((Density) objConsume).mo754toPx0680j_4(f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iMo754toPx0680j_4;
    }

    public static final float toDp(int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -916773021, "C(toDp)64@2490L7:ComposeUtils.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-916773021, i2, -1, "com.box.android.base.compose.toDp (ComposeUtils.kt:64)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fMo751toDpu2uoSUM = ((Density) objConsume).mo751toDpu2uoSUM(i);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fMo751toDpu2uoSUM;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    public static final <T> Function0<T> remembered(Function0<? extends T> calculation, Composer composer, int i) {
        ?? r3;
        Intrinsics.checkNotNullParameter(calculation, "calculation");
        ComposerKt.sourceInformationMarkerStart(composer, -639278213, "C(remembered)N(calculation)69@2589L24:ComposeUtils.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-639278213, i, -1, "com.box.android.base.compose.remembered (ComposeUtils.kt:69)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -166037677, "CC(remember):ComposeUtils.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            composer.updateRememberedValue(calculation);
            r3 = calculation;
        } else {
            r3 = (Function0<? extends T>) objRememberedValue;
        }
        Function0<T> function0 = (Function0) r3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function0;
    }

    public static final Modifier addIfCondition(Modifier modifier, boolean z, Function0<? extends Modifier> modifierToAdd) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(modifierToAdd, "modifierToAdd");
        return modifier.then((Modifier) (z ? modifierToAdd.invoke() : Modifier.INSTANCE));
    }

    public static final Modifier visibleIf(Modifier modifier, final boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: com.box.android.base.compose.ComposeUtilsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeUtilsKt.visibleIf$lambda$0(z, (GraphicsLayerScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit visibleIf$lambda$0(boolean z, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setAlpha(z ? 1.0f : 0.0f);
        return Unit.INSTANCE;
    }

    public static final State<Boolean> keyboardIsOpenedAsState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1085461029, "C(keyboardIsOpenedAsState)90@3417L3,90@3444L7,91@3468L34:ComposeUtils.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1085461029, i, -1, "com.box.android.base.compose.keyboardIsOpenedAsState (ComposeUtils.kt:89)");
        }
        WindowInsets ime = WindowInsets_androidKt.getIme(WindowInsets.INSTANCE, composer, 6);
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        State<Boolean> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(ime.getBottom((Density) objConsume) > 0), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateRememberUpdatedState;
    }

    /* JADX INFO: renamed from: bottomBorder-Hht5A8o, reason: not valid java name */
    public static final Modifier m11634bottomBorderHht5A8o(Modifier bottomBorder, final long j, final float f) {
        Intrinsics.checkNotNullParameter(bottomBorder, "$this$bottomBorder");
        return DrawModifierKt.drawBehind(bottomBorder, new Function1() { // from class: com.box.android.base.compose.ComposeUtilsKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeUtilsKt.bottomBorder_Hht5A8o$lambda$0(j, f, (DrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bottomBorder_Hht5A8o$lambda$0(long j, float f, DrawScope drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        float f2 = 2;
        long jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawBehind.mo7395getSizeNHjbRc() & 4294967295L)) - (drawBehind.mo754toPx0680j_4(f) / f2))) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawBehind.mo7395getSizeNHjbRc() >> 32));
        DrawScope.m7381drawLineNGM6Ib0$default(drawBehind, j, jM6561constructorimpl, Offset.m6561constructorimpl((4294967295L & ((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawBehind.mo7395getSizeNHjbRc() & 4294967295L)) - (drawBehind.mo754toPx0680j_4(f) / f2)))) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), drawBehind.mo754toPx0680j_4(f), 0, null, 0.0f, null, 0, 496, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: topBorder-Hht5A8o, reason: not valid java name */
    public static final Modifier m11639topBorderHht5A8o(Modifier topBorder, final long j, final float f) {
        Intrinsics.checkNotNullParameter(topBorder, "$this$topBorder");
        return DrawModifierKt.drawBehind(topBorder, new Function1() { // from class: com.box.android.base.compose.ComposeUtilsKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeUtilsKt.topBorder_Hht5A8o$lambda$0(j, f, (DrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit topBorder_Hht5A8o$lambda$0(long j, float f, DrawScope drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        float f2 = 2;
        DrawScope.m7381drawLineNGM6Ib0$default(drawBehind, j, Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(drawBehind.mo754toPx0680j_4(f) / f2)) & 4294967295L)), Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawBehind.mo7395getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(drawBehind.mo754toPx0680j_4(f) / f2)) & 4294967295L)), drawBehind.mo754toPx0680j_4(f), 0, null, 0.0f, null, 0, 496, null);
        return Unit.INSTANCE;
    }

    public static final Modifier dialogSemantics(Modifier modifier, final String contentDescription) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        return ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: com.box.android.base.compose.ComposeUtilsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ComposeUtilsKt.dialogSemantics$lambda$0(contentDescription, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier dialogSemantics$lambda$0(String str, Modifier composed, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.startReplaceGroup(1885465869);
        ComposerKt.sourceInformation(composer, "C119@4363L41,121@4469L114:ComposeUtils.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1885465869, i, -1, "com.box.android.base.compose.dialogSemantics.<anonymous> (ComposeUtils.kt:119)");
        }
        final String str2 = StringResources_androidKt.stringResource(R.string.dialog_semantics, composer, 0) + " " + str;
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -543494241, "CC(remember):ComposeUtils.kt#9igjgp");
        boolean zChanged = composer.changed(str2);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.box.android.base.compose.ComposeUtilsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ComposeUtilsKt.dialogSemantics$lambda$0$0$0(str2, (SemanticsPropertyReceiver) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierThen = composed.then(SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierThen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dialogSemantics$lambda$0$0$0(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        SemanticsPropertiesKt.m8850setLiveRegionhR3wRGc(semantics, LiveRegionMode.INSTANCE.m8824getPolite0phEisY());
        return Unit.INSTANCE;
    }

    public static final Modifier longClickableWithOffset(Modifier modifier, Object obj, Function1<? super DpOffset, Unit> onLongClick, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onLongClick, "onLongClick");
        ComposerKt.sourceInformationMarkerStart(composer, 2140436635, "C(longClickableWithOffset)N(key,onLongClick)130@4733L39,131@4818L7,134@4898L7,135@4934L549:ComposeUtils.kt#vejmn0");
        boolean z = true;
        if ((i2 & 1) != 0) {
            obj = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2140436635, i, -1, "com.box.android.base.compose.longClickableWithOffset (ComposeUtils.kt:129)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -329724414, "CC(remember):ComposeUtils.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ProvidableCompositionLocal<HapticFeedback> localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localHapticFeedback);
        ComposerKt.sourceInformationMarkerEnd(composer);
        HapticFeedback hapticFeedback = (HapticFeedback) objConsume;
        ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localIndication);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierIndication = IndicationKt.indication(modifier, mutableInteractionSource, (Indication) objConsume2);
        ComposerKt.sourceInformationMarkerStart(composer, -329717472, "CC(remember):ComposeUtils.kt#9igjgp");
        if ((((i & 896) ^ 384) <= 256 || !composer.changed(onLongClick)) && (i & 384) != 256) {
            z = false;
        }
        boolean zChangedInstance = composer.changedInstance(hapticFeedback) | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (PointerInputEventHandler) new ComposeUtilsKt$longClickableWithOffset$1$1(onLongClick, hapticFeedback, mutableInteractionSource);
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierIndication, obj, (PointerInputEventHandler) objRememberedValue2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifierPointerInput;
    }

    public static final /* synthetic */ <VM extends ViewModel> VM hiltActivityViewModel(String str, Composer composer, int i, int i2) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        ComposerKt.sourceInformationMarkerStart(composer, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
        if ((i2 & 1) != 0) {
            str = null;
        }
        String str2 = str;
        ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localActivity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        ComponentActivity componentActivity = (ComponentActivity) objConsume;
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composer, 0);
        int i3 = (i << 3) & 112;
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (componentActivity instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        Intrinsics.reifiedOperationMarker(4, "VM");
        VM vm = (VM) ViewModelKt.viewModel(ViewModel.class, componentActivity, str2, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, ((i3 << 3) & 896) | 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        return vm;
    }

    public static final /* synthetic */ <VM extends ViewModel> VM hiltViewModelWithArgs(final Bundle args, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(args, "args");
        ComposerKt.sourceInformationMarkerStart(composer, -1556966040, "CC(hiltViewModelWithArgs)N(args)176@6582L35,176@6534L83:ComposeUtils.kt#vejmn0");
        ComposerKt.sourceInformationMarkerStart(composer, -1595741461, "CC(remember):ComposeUtils.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(args);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Intrinsics.needClassReification();
            objRememberedValue = (Function1) new Function1<ViewModelAssistedFactory<VM>, VM>() { // from class: com.box.android.base.compose.ComposeUtilsKt$hiltViewModelWithArgs$1$1
                /* JADX WARN: Incorrect return type in method signature: (Lcom/box/android/common/utilities/ViewModelAssistedFactory<TVM;>;)TVM; */
                @Override // kotlin.jvm.functions.Function1
                public final ViewModel invoke(ViewModelAssistedFactory factory) {
                    Intrinsics.checkNotNullParameter(factory, "factory");
                    return factory.create(args);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function1 function1 = (Function1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.startReplaceableGroup(-83599083);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(2,1)*68@2969L7,74@3156L47,75@3215L430:HiltViewModel.kt#9mcars");
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
        CreationExtras creationExtrasWithCreationCallback = current instanceof HasDefaultViewModelProviderFactory ? HiltViewModelExtensions.withCreationCallback(((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras(), function1) : HiltViewModelExtensions.withCreationCallback(CreationExtras.Empty.INSTANCE, function1);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        Intrinsics.reifiedOperationMarker(4, "VM");
        VM vm = (VM) ViewModelKt.viewModel(ViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, creationExtrasWithCreationCallback, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        return vm;
    }

    /* JADX INFO: renamed from: rememberCurrentTimeMillis-KLykuaI, reason: not valid java name */
    public static final State<Long> m11636rememberCurrentTimeMillisKLykuaI(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1705717109, "C(rememberCurrentTimeMillis)N(updatePeriod:kotlin.time.Duration)179@6743L99,179@6687L155:ComposeUtils.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1705717109, i, -1, "com.box.android.base.compose.rememberCurrentTimeMillis (ComposeUtils.kt:179)");
        }
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        ComposerKt.sourceInformationMarkerStart(composer, -1483361640, "CC(remember):ComposeUtils.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(j)) || (i & 6) == 4;
        ComposeUtilsKt$rememberCurrentTimeMillis$1$1 composeUtilsKt$rememberCurrentTimeMillis$1$1RememberedValue = composer.rememberedValue();
        if (z || composeUtilsKt$rememberCurrentTimeMillis$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            composeUtilsKt$rememberCurrentTimeMillis$1$1RememberedValue = new ComposeUtilsKt$rememberCurrentTimeMillis$1$1(j, null);
            composer.updateRememberedValue(composeUtilsKt$rememberCurrentTimeMillis$1$1RememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State<Long> stateProduceState = SnapshotStateKt.produceState(lValueOf, (Function2) composeUtilsKt$rememberCurrentTimeMillis$1$1RememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateProduceState;
    }

    public static final <T> T rememberLastNotNull(T t, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1624068962, "C(rememberLastNotNull)N(value)197@7276L34:ComposeUtils.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1624068962, i, -1, "com.box.android.base.compose.rememberLastNotNull (ComposeUtils.kt:196)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1657146372, "CC(remember):ComposeUtils.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (t != null) {
            mutableState.setValue(t);
        }
        T t2 = (T) rememberLastNotNull$lambda$1(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return t2;
    }

    private static final <T> T rememberLastNotNull$lambda$1(MutableState<T> mutableState) {
        return mutableState.getValue();
    }

    public static final boolean getIsLandscapePhone(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1068586588, "C(getIsLandscapePhone)210@7688L7:ComposeUtils.kt#vejmn0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1068586588, i, -1, "com.box.android.base.compose.getIsLandscapePhone (ComposeUtils.kt:209)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Configuration configuration = (Configuration) objConsume;
        boolean z = configuration.orientation == 2 && configuration.smallestScreenWidthDp < 600;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return z;
    }

    /* JADX INFO: renamed from: bottomBorder-Hht5A8o$default, reason: not valid java name */
    public static /* synthetic */ Modifier m11635bottomBorderHht5A8o$default(Modifier modifier, long j, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.m9687constructorimpl(1);
        }
        return m11634bottomBorderHht5A8o(modifier, j, f);
    }

    /* JADX INFO: renamed from: topBorder-Hht5A8o$default, reason: not valid java name */
    public static /* synthetic */ Modifier m11640topBorderHht5A8o$default(Modifier modifier, long j, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.m9687constructorimpl(1);
        }
        return m11639topBorderHht5A8o(modifier, j, f);
    }
}
