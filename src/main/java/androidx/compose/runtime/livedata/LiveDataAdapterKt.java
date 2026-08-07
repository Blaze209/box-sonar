package androidx.compose.runtime.livedata;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LiveDataAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a5\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0002*\u0002H\u0005*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0006\u001a\u0002H\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"observeAsState", "Landroidx/compose/runtime/State;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "(Landroidx/lifecycle/LiveData;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "R", "initial", "(Landroidx/lifecycle/LiveData;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime-livedata"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LiveDataAdapterKt {
    public static final <T> State<T> observeAsState(LiveData<T> liveData, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2027206144, "C(observeAsState)39@1629L21:LiveDataAdapter.kt#drcai5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2027206144, i, -1, "androidx.compose.runtime.livedata.observeAsState (LiveDataAdapter.kt:39)");
        }
        State<T> stateObserveAsState = observeAsState(liveData, liveData.getValue(), composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateObserveAsState;
    }

    public static final <R, T extends R> State<R> observeAsState(final LiveData<T> liveData, R r, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 411178300, "C(observeAsState)N(initial)57@2516L7,58@2540L173,62@2757L152,62@2718L191:LiveDataAdapter.kt#drcai5");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(411178300, i, -1, "androidx.compose.runtime.livedata.observeAsState (LiveDataAdapter.kt:56)");
        }
        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localLifecycleOwner);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final LifecycleOwner lifecycleOwner = (LifecycleOwner) objConsume;
        ComposerKt.sourceInformationMarkerStart(composer, 5359561, "CC(remember):LiveDataAdapter.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            if (liveData.isInitialized()) {
                r = liveData.getValue();
            }
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 5366484, "CC(remember):LiveDataAdapter.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(liveData) | composer.changedInstance(lifecycleOwner);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: androidx.compose.runtime.livedata.LiveDataAdapterKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LiveDataAdapterKt.observeAsState$lambda$1$0(liveData, lifecycleOwner, mutableState, (DisposableEffectScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(liveData, lifecycleOwner, (Function1) objRememberedValue2, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult observeAsState$lambda$1$0(final LiveData liveData, LifecycleOwner lifecycleOwner, final MutableState mutableState, DisposableEffectScope disposableEffectScope) {
        final Observer observer = new Observer() { // from class: androidx.compose.runtime.livedata.LiveDataAdapterKt$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                mutableState.setValue(obj);
            }
        };
        liveData.observe(lifecycleOwner, observer);
        return new DisposableEffectResult() { // from class: androidx.compose.runtime.livedata.LiveDataAdapterKt$observeAsState$lambda$1$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                liveData.removeObserver(observer);
            }
        };
    }
}
