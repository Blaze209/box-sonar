package androidx.compose.material3;

import android.content.Context;
import android.hardware.input.InputManager;
import android.view.InputDevice;
import androidx.collection.IntSet;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: PrecisionPointer.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0003¢\u0006\u0002\u0010\t\u001a&\u0010\r\u001a\u0004\u0018\u00010\b*\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0002\u001a\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\fH\u0002\u001a\u000e\u0010\u0010\u001a\u00020\f*\u0004\u0018\u00010\u0016H\u0002\u001a\u000e\u0010\u0011\u001a\u00020\f*\u0004\u0018\u00010\u0016H\u0002\u001a\u0014\u0010\u0017\u001a\u00020\f*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000fH\u0002\"\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"EnsurePrecisionPointerListenersRegistered", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "rememberDevicesState", "Landroidx/compose/runtime/State;", "Landroidx/compose/material3/Devices;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "LocalIsPrecisionPointerListenerRegistered", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "withUpdateForDevice", "deviceId", "", "isKeyboard", "isMouse", "withUpdatedValuePresence", "Landroidx/collection/IntSet;", "value", "shouldBePresent", "Landroid/view/InputDevice;", "hasSource", "source", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PrecisionPointer_androidKt {
    private static final ProvidableCompositionLocal<Boolean> LocalIsPrecisionPointerListenerRegistered = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material3.PrecisionPointer_androidKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(PrecisionPointer_androidKt.LocalIsPrecisionPointerListenerRegistered$lambda$0());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EnsurePrecisionPointerListenersRegistered$lambda$0(Function2 function2, int i, Composer composer, int i2) {
        EnsurePrecisionPointerListenersRegistered(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LocalIsPrecisionPointerListenerRegistered$lambda$0() {
        return false;
    }

    public static final void EnsurePrecisionPointerListenersRegistered(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composerStartRestartGroup = composer.startRestartGroup(442516910);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EnsurePrecisionPointerListenersRegistered)N(content):PrecisionPointer.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        boolean z2 = false;
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(442516910, i2, -1, "androidx.compose.material3.EnsurePrecisionPointerListenersRegistered (PrecisionPointer.android.kt:37)");
            }
            if (ComposeMaterial3Flags.isPrecisionPointerComponentSizingEnabled) {
                composerStartRestartGroup.startReplaceGroup(56994752);
                ComposerKt.sourceInformation(composerStartRestartGroup, "40@1673L7");
                ProvidableCompositionLocal<Boolean> providableCompositionLocal = LocalIsPrecisionPointerListenerRegistered;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                z = !((Boolean) objConsume).booleanValue();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1766838549);
                composerStartRestartGroup.endReplaceGroup();
                z = false;
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1766933538);
                ComposerKt.sourceInformation(composerStartRestartGroup, "44@1899L22,47@2084L90");
                Devices value = rememberDevicesState(composerStartRestartGroup, 0).getValue();
                MutableState<Boolean> shouldUsePrecisionPointerComponentSizing = PrecisionPointerKt.getShouldUsePrecisionPointerComponentSizing();
                if (value != null && value.getKeyboards().isNotEmpty() && value.getMice().isNotEmpty()) {
                    z2 = true;
                }
                shouldUsePrecisionPointerComponentSizing.setValue(Boolean.valueOf(z2));
                CompositionLocalKt.CompositionLocalProvider(LocalIsPrecisionPointerListenerRegistered.provides(true), function2, composerStartRestartGroup, ((i2 << 3) & 112) | ProvidedValue.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1767392772);
                ComposerKt.sourceInformation(composerStartRestartGroup, "51@2347L9");
                function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.PrecisionPointer_androidKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PrecisionPointer_androidKt.EnsurePrecisionPointerListenersRegistered$lambda$0(function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final State<Devices> rememberDevicesState(Composer composer, int i) {
        composer.startReplaceGroup(57893307);
        ComposerKt.sourceInformation(composer, "C(rememberDevicesState)57@2463L7,64@2664L613,80@3309L1225,80@3283L1251:PrecisionPointer.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(57893307, i, -1, "androidx.compose.material3.rememberDevicesState (PrecisionPointer.android.kt:56)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        final InputManager inputManager = (InputManager) ContextCompat.getSystemService(context, InputManager.class);
        if (inputManager != null) {
            composer.startReplaceGroup(-199102972);
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composer, -199097312, "CC(remember):PrecisionPointer.android.kt#9igjgp");
            boolean zChanged = composer.changed(context);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                MutableIntSet mutableIntSet = new MutableIntSet(0, 1, null);
                MutableIntSet mutableIntSet2 = new MutableIntSet(0, 1, null);
                for (int i2 : inputManager.getInputDeviceIds()) {
                    InputDevice inputDevice = inputManager.getInputDevice(i2);
                    if (isKeyboard(inputDevice)) {
                        mutableIntSet.add(i2);
                    }
                    if (isMouse(inputDevice)) {
                        mutableIntSet2.add(i2);
                    }
                }
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Devices(mutableIntSet, mutableIntSet2), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -199076060, "CC(remember):PrecisionPointer.android.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(inputManager) | composer.changed(mutableState);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.PrecisionPointer_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PrecisionPointer_androidKt.rememberDevicesState$lambda$2$0(inputManager, mutableState, (DisposableEffectScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.DisposableEffect(context, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return mutableState;
        }
        composer.startReplaceGroup(-1877171018);
        ComposerKt.sourceInformation(composer, "61@2566L42");
        ComposerKt.sourceInformationMarkerStart(composer, -199101019, "CC(remember):PrecisionPointer.android.kt#9igjgp");
        boolean zChanged2 = composer.changed(context);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(objRememberedValue3);
        }
        MutableState mutableState2 = (MutableState) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return mutableState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.compose.material3.PrecisionPointer_androidKt$rememberDevicesState$1$1$listener$1] */
    public static final DisposableEffectResult rememberDevicesState$lambda$2$0(final InputManager inputManager, final MutableState mutableState, DisposableEffectScope disposableEffectScope) {
        final ?? r3 = new InputManager.InputDeviceListener() { // from class: androidx.compose.material3.PrecisionPointer_androidKt$rememberDevicesState$1$1$listener$1
            @Override // android.hardware.input.InputManager.InputDeviceListener
            public void onInputDeviceAdded(int deviceId) {
                maybeUpdateDevice(deviceId);
            }

            @Override // android.hardware.input.InputManager.InputDeviceListener
            public void onInputDeviceRemoved(int deviceId) {
                maybeUpdateDevice(deviceId);
            }

            @Override // android.hardware.input.InputManager.InputDeviceListener
            public void onInputDeviceChanged(int deviceId) {
                maybeUpdateDevice(deviceId);
            }

            private final void maybeUpdateDevice(int deviceId) {
                InputDevice inputDevice = inputManager.getInputDevice(deviceId);
                Devices devicesWithUpdateForDevice = PrecisionPointer_androidKt.withUpdateForDevice(mutableState.getValue(), deviceId, PrecisionPointer_androidKt.isKeyboard(inputDevice), PrecisionPointer_androidKt.isMouse(inputDevice));
                if (devicesWithUpdateForDevice != null) {
                    mutableState.setValue(devicesWithUpdateForDevice);
                }
            }
        };
        inputManager.registerInputDeviceListener((InputManager.InputDeviceListener) r3, null);
        return new DisposableEffectResult() { // from class: androidx.compose.material3.PrecisionPointer_androidKt$rememberDevicesState$lambda$2$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                inputManager.unregisterInputDeviceListener(r3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Devices withUpdateForDevice(Devices devices, int i, boolean z, boolean z2) {
        IntSet intSetWithUpdatedValuePresence = withUpdatedValuePresence(devices.getKeyboards(), i, z);
        IntSet intSetWithUpdatedValuePresence2 = withUpdatedValuePresence(devices.getMice(), i, z2);
        if (intSetWithUpdatedValuePresence == null && intSetWithUpdatedValuePresence2 == null) {
            return null;
        }
        if (intSetWithUpdatedValuePresence == null) {
            intSetWithUpdatedValuePresence = devices.getKeyboards();
        }
        if (intSetWithUpdatedValuePresence2 == null) {
            intSetWithUpdatedValuePresence2 = devices.getMice();
        }
        return devices.copy(intSetWithUpdatedValuePresence, intSetWithUpdatedValuePresence2);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0055 A[LOOP:0: B:8:0x001e->B:20:0x0055, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0058 A[EDGE_INSN: B:30:0x0058->B:21:0x0058 BREAK  A[LOOP:0: B:8:0x001e->B:20:0x0055], SYNTHETIC] */
    private static final IntSet withUpdatedValuePresence(IntSet intSet, int i, boolean z) {
        boolean zContains = intSet.contains(i);
        if (!zContains || z) {
            if (zContains || !z) {
                return null;
            }
            MutableIntSet mutableIntSet = new MutableIntSet(intSet.getSize() + 1);
            mutableIntSet.addAll(intSet);
            mutableIntSet.add(i);
            return mutableIntSet;
        }
        MutableIntSet mutableIntSet2 = new MutableIntSet(intSet.getSize() - 1);
        int[] iArr = intSet.elements;
        long[] jArr = intSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i2 != length) {
                        break;
                        break;
                    }
                    i2++;
                } else {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128 && iArr[(i2 << 3) + i4] != i) {
                            mutableIntSet2.add(i);
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                    if (i2 != length) {
                        break;
                    }
                    i2++;
                }
            }
        }
        return mutableIntSet2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isKeyboard(InputDevice inputDevice) {
        return inputDevice != null && !inputDevice.isVirtual() && hasSource(inputDevice, 257) && inputDevice.getKeyboardType() == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMouse(InputDevice inputDevice) {
        return (inputDevice == null || inputDevice.isVirtual() || !hasSource(inputDevice, 8194) || hasSource(inputDevice, InputDeviceCompat.SOURCE_STYLUS)) ? false : true;
    }

    private static final boolean hasSource(InputDevice inputDevice, int i) {
        return (inputDevice.getSources() & i) == i;
    }
}
