package com.box.android.base.compose.analytics;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.OnVisibilityChangedModifierKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.compose.LifecycleEffectKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalyticsUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\u0004X\u008a\u008e\u0002²\u0006\n\u0010\n\u001a\u00020\u0004X\u008a\u008e\u0002²\u0006\n\u0010\u000b\u001a\u00020\u0004X\u008a\u008e\u0002"}, d2 = {"trackOnVisible", "Landroidx/compose/ui/Modifier;", "shouldTrack", "Lkotlin/Function0;", "", "onTrack", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "base_generalProdRelease", "isVisible", "hasEventTracked", "wasPaused"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AnalyticsUtilsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean trackOnVisible$lambda$0$0() {
        return true;
    }

    public static final Modifier trackOnVisible(Modifier modifier, Function0<Boolean> function0, final Function0<Unit> onTrack, Composer composer, int i, int i2) {
        final Function0<Boolean> function1;
        Object obj;
        MutableState mutableState;
        MutableState mutableState2;
        Boolean bool;
        final MutableState mutableState3;
        final MutableState mutableState4;
        final Function0<Boolean> function2;
        final Function0 function3;
        Object obj2;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onTrack, "onTrack");
        ComposerKt.sourceInformationMarkerStart(composer, 1342713137, "C(trackOnVisible)N(shouldTrack,onTrack)29@1384L8,30@1448L34,31@1510L34,32@1566L34,42@1890L134,42@1843L181,50@2256L100,50@2208L148,60@2602L85,60@2563L124,67@2763L169:AnalyticsUtils.kt#4ltjuk");
        if ((i2 & 1) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 1857137689, "CC(remember):AnalyticsUtils.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.analytics.AnalyticsUtilsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(AnalyticsUtilsKt.trackOnVisible$lambda$0$0());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            function1 = (Function0) objRememberedValue;
        } else {
            function1 = function0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1342713137, i, -1, "com.box.android.base.compose.analytics.trackOnVisible (AnalyticsUtils.kt:29)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1857139763, "CC(remember):AnalyticsUtils.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        final MutableState mutableState5 = (MutableState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1857141747, "CC(remember):AnalyticsUtils.kt#9igjgp");
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composer.updateRememberedValue(objRememberedValue3);
        }
        final MutableState mutableState6 = (MutableState) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1857143539, "CC(remember):AnalyticsUtils.kt#9igjgp");
        Object objRememberedValue4 = composer.rememberedValue();
        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composer.updateRememberedValue(objRememberedValue4);
        }
        final MutableState mutableState7 = (MutableState) objRememberedValue4;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Lifecycle.Event event = Lifecycle.Event.ON_PAUSE;
        ComposerKt.sourceInformationMarkerStart(composer, 1857154007, "CC(remember):AnalyticsUtils.kt#9igjgp");
        Object objRememberedValue5 = composer.rememberedValue();
        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = new Function0() { // from class: com.box.android.base.compose.analytics.AnalyticsUtilsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AnalyticsUtilsKt.trackOnVisible$lambda$10$0(mutableState7, mutableState6);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        LifecycleEffectKt.LifecycleEventEffect(event, null, (Function0) objRememberedValue5, composer, 390, 2);
        Lifecycle.Event event2 = Lifecycle.Event.ON_RESUME;
        ComposerKt.sourceInformationMarkerStart(composer, 1857165685, "CC(remember):AnalyticsUtils.kt#9igjgp");
        int i3 = (i & 112) ^ 48;
        int i4 = (i & 896) ^ 384;
        boolean z = ((i3 > 32 && composer.changed(function1)) || (i & 48) == 32) | ((i4 > 256 && composer.changed(onTrack)) || (i & 384) == 256);
        Object objRememberedValue6 = composer.rememberedValue();
        if (z || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
            obj = new Function0() { // from class: com.box.android.base.compose.analytics.AnalyticsUtilsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AnalyticsUtilsKt.trackOnVisible$lambda$11$0(mutableState7, function1, onTrack, mutableState5, mutableState6);
                }
            };
            mutableState = mutableState5;
            mutableState2 = mutableState6;
            composer.updateRememberedValue(obj);
        } else {
            mutableState = mutableState5;
            mutableState2 = mutableState6;
            obj = objRememberedValue6;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Function0<Boolean> function4 = function1;
        LifecycleEffectKt.LifecycleEventEffect(event2, null, (Function0) obj, composer, 6, 2);
        boolean zBooleanValue = function4.invoke().booleanValue();
        Boolean boolValueOf = Boolean.valueOf(trackOnVisible$lambda$2(mutableState));
        Boolean boolValueOf2 = Boolean.valueOf(zBooleanValue);
        ComposerKt.sourceInformationMarkerStart(composer, 1857176742, "CC(remember):AnalyticsUtils.kt#9igjgp");
        boolean zChanged = composer.changed(zBooleanValue) | ((i3 > 32 && composer.changed(function4)) || (i & 48) == 32) | ((i4 > 256 && composer.changed(onTrack)) || (i & 384) == 256);
        Object objRememberedValue7 = composer.rememberedValue();
        if (zChanged || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
            bool = boolValueOf;
            MutableState mutableState8 = mutableState;
            mutableState3 = mutableState2;
            Object analyticsUtilsKt$trackOnVisible$4$1 = new AnalyticsUtilsKt$trackOnVisible$4$1(zBooleanValue, mutableState8, function4, r3, mutableState3, null);
            mutableState4 = mutableState8;
            function2 = function4;
            function3 = r3;
            obj2 = (Function2) analyticsUtilsKt$trackOnVisible$4$1;
            composer.updateRememberedValue(obj2);
        } else {
            function2 = function4;
            function3 = r3;
            mutableState3 = mutableState2;
            bool = boolValueOf;
            obj2 = objRememberedValue7;
            mutableState4 = mutableState;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(bool, boolValueOf2, (Function2) obj2, composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 1857181978, "CC(remember):AnalyticsUtils.kt#9igjgp");
        boolean z2 = ((i3 > 32 && composer.changed(function2)) || (i & 48) == 32) | ((i4 > 256 && composer.changed(function3)) || (i & 384) == 256);
        Object objRememberedValue8 = composer.rememberedValue();
        if (z2 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue8 = new Function1() { // from class: com.box.android.base.compose.analytics.AnalyticsUtilsKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return AnalyticsUtilsKt.trackOnVisible$lambda$13$0(mutableState4, function2, function3, mutableState3, ((Boolean) obj3).booleanValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue8);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierOnVisibilityChanged$default = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier, 0L, 0.0f, null, (Function1) objRememberedValue8, 7, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifierOnVisibilityChanged$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean trackOnVisible$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void trackOnVisible$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean trackOnVisible$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void trackOnVisible$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean trackOnVisible$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void trackOnVisible$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void trackOnVisible$tryTrackEvent(Function0<Boolean> function0, Function0<Unit> function1, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2) {
        if (trackOnVisible$lambda$2(mutableState) && function0.invoke().booleanValue() && !trackOnVisible$lambda$5(mutableState2)) {
            function1.invoke();
            trackOnVisible$lambda$6(mutableState2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit trackOnVisible$lambda$10$0(MutableState mutableState, MutableState mutableState2) {
        trackOnVisible$lambda$9(mutableState, true);
        trackOnVisible$lambda$6(mutableState2, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit trackOnVisible$lambda$11$0(MutableState mutableState, Function0 function0, Function0 function1, MutableState mutableState2, MutableState mutableState3) {
        if (trackOnVisible$lambda$8(mutableState)) {
            trackOnVisible$tryTrackEvent(function0, function1, mutableState2, mutableState3);
            trackOnVisible$lambda$9(mutableState, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit trackOnVisible$lambda$13$0(MutableState mutableState, Function0 function0, Function0 function1, MutableState mutableState2, boolean z) {
        trackOnVisible$lambda$3(mutableState, z);
        if (z) {
            trackOnVisible$tryTrackEvent(function0, function1, mutableState, mutableState2);
        } else {
            trackOnVisible$lambda$6(mutableState2, false);
        }
        return Unit.INSTANCE;
    }
}
