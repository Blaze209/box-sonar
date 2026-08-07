package com.box.android.capture.audiorecording.viewmodel;

import android.media.MediaRecorder;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.box.android.capture.audiorecording.AudioProcessor;
import com.box.android.capture.audiorecording.IRecordingFileManager;
import com.box.android.capture.audiorecording.RecorderService;
import com.box.android.capture.audiorecording.RecordingFileState;
import com.microsoft.intune.mam.client.media.MAMMediaRecorder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: RecorderServiceViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\u000e\u0010\u001c\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\u00192\b\b\u0002\u0010 \u001a\u00020!H\u0086@¢\u0006\u0002\u0010\"J\u000e\u0010#\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001dJ\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010%\u001a\u00020\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006)"}, d2 = {"Lcom/box/android/capture/audiorecording/viewmodel/RecorderServiceViewModel;", "Landroidx/lifecycle/ViewModel;", "recordingFileManager", "Lcom/box/android/capture/audiorecording/IRecordingFileManager;", "<init>", "(Lcom/box/android/capture/audiorecording/IRecordingFileManager;)V", "mediaRecorder", "Landroid/media/MediaRecorder;", "recordedFileAmps", "Landroidx/lifecycle/MutableLiveData;", "", "", "recordingStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/box/android/capture/audiorecording/RecordingFileState;", "recordedFileSamples", "Landroidx/lifecycle/LiveData;", "getRecordedFileSamples", "()Landroidx/lifecycle/LiveData;", "recordingState", "getRecordingState", "recordedTime", "", "getRecordedTime", "samplingLoop", "", "getSamplingLoop", "getLatestSample", "startRecording", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resumeRecording", "pauseRecording", "isAutoPaused", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopRecording", "getRecordingStateFlow", "getElapsedTime", "parseElapsedTime", "elapsedTime", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecorderServiceViewModel extends ViewModel {
    public static final int $stable = 8;
    private MediaRecorder mediaRecorder;
    private final MutableLiveData<List<Double>> recordedFileAmps;
    private final LiveData<List<Double>> recordedFileSamples;
    private final LiveData<String> recordedTime;
    private final IRecordingFileManager recordingFileManager;
    private final LiveData<RecordingFileState> recordingState;
    private final MutableStateFlow<RecordingFileState> recordingStateFlow;
    private final LiveData<Unit> samplingLoop;

    @Inject
    public RecorderServiceViewModel(IRecordingFileManager recordingFileManager) {
        Intrinsics.checkNotNullParameter(recordingFileManager, "recordingFileManager");
        this.recordingFileManager = recordingFileManager;
        MutableLiveData<List<Double>> mutableLiveData = new MutableLiveData<>(new ArrayList());
        this.recordedFileAmps = mutableLiveData;
        this.recordingStateFlow = StateFlowKt.MutableStateFlow(RecordingFileState.NOT_RECORDING);
        this.recordedFileSamples = mutableLiveData;
        File metadataFile = recordingFileManager.getMetadataFile();
        if (metadataFile.length() > 0) {
            List listSplit$default = StringsKt.split$default((CharSequence) FilesKt.readText$default(metadataFile, null, 1, null), new char[]{' '}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listSplit$default) {
                if (((String) obj).length() > 0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(Double.valueOf(Double.parseDouble((String) it.next())));
            }
            mutableLiveData.setValue(CollectionsKt.toMutableList((Collection) arrayList3));
        }
        LiveData<RecordingFileState> liveDataAsLiveData$default = FlowLiveDataConversions.asLiveData$default(this.recordingStateFlow, (CoroutineContext) null, 0L, 3, (Object) null);
        this.recordingState = liveDataAsLiveData$default;
        this.recordedTime = Transformations.switchMap(liveDataAsLiveData$default, new Function1() { // from class: com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return RecorderServiceViewModel.recordedTime$lambda$0(this.f$0, (RecordingFileState) obj2);
            }
        });
        this.samplingLoop = Transformations.switchMap(liveDataAsLiveData$default, new Function1() { // from class: com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return RecorderServiceViewModel.samplingLoop$lambda$0(this.f$0, (RecordingFileState) obj2);
            }
        });
    }

    public final LiveData<List<Double>> getRecordedFileSamples() {
        return this.recordedFileSamples;
    }

    public final LiveData<RecordingFileState> getRecordingState() {
        return this.recordingState;
    }

    public final LiveData<String> getRecordedTime() {
        return this.recordedTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData recordedTime$lambda$0(RecorderServiceViewModel recorderServiceViewModel, RecordingFileState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return FlowLiveDataConversions.asLiveData$default(FlowKt.flow(new RecorderServiceViewModel$recordedTime$1$1(recorderServiceViewModel, null)), (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public final LiveData<Unit> getSamplingLoop() {
        return this.samplingLoop;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData samplingLoop$lambda$0(RecorderServiceViewModel recorderServiceViewModel, RecordingFileState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return FlowLiveDataConversions.asLiveData$default(FlowKt.flow(new RecorderServiceViewModel$samplingLoop$1$1(recorderServiceViewModel, null)), (CoroutineContext) null, 0L, 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double getLatestSample() {
        AudioProcessor audioProcessor = AudioProcessor.INSTANCE;
        MediaRecorder mediaRecorder = this.mediaRecorder;
        if (mediaRecorder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecorder");
            mediaRecorder = null;
        }
        return audioProcessor.normalizeAmplitude(mediaRecorder.getMaxAmplitude());
    }

    public final Object startRecording(Continuation<? super Unit> continuation) throws IOException {
        List<Double> value = this.recordedFileAmps.getValue();
        if (value != null) {
            value.clear();
        }
        MAMMediaRecorder mAMMediaRecorder = new MAMMediaRecorder();
        mAMMediaRecorder.setAudioSource(1);
        mAMMediaRecorder.setOutputFormat(2);
        mAMMediaRecorder.setAudioEncoder(4);
        mAMMediaRecorder.setAudioChannels(1);
        mAMMediaRecorder.setAudioEncodingBitRate(RecorderService.AUDIO_BIT_RATE);
        mAMMediaRecorder.setAudioSamplingRate(RecorderService.AUDIO_SAMPLING_RATE);
        mAMMediaRecorder.setOutputFile(this.recordingFileManager.getRecordingFile());
        this.mediaRecorder = mAMMediaRecorder;
        mAMMediaRecorder.prepare();
        MediaRecorder mediaRecorder = this.mediaRecorder;
        if (mediaRecorder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecorder");
            mediaRecorder = null;
        }
        mediaRecorder.start();
        Object objEmit = this.recordingStateFlow.emit(RecordingFileState.RECORDING, continuation);
        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
    }

    public final Object resumeRecording(Continuation<? super Unit> continuation) {
        MediaRecorder mediaRecorder = this.mediaRecorder;
        if (mediaRecorder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecorder");
            mediaRecorder = null;
        }
        mediaRecorder.resume();
        Object objEmit = this.recordingStateFlow.emit(RecordingFileState.RECORDING, continuation);
        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
    }

    public static /* synthetic */ Object pauseRecording$default(RecorderServiceViewModel recorderServiceViewModel, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return recorderServiceViewModel.pauseRecording(z, continuation);
    }

    public final Object pauseRecording(boolean z, Continuation<? super Unit> continuation) {
        MediaRecorder mediaRecorder = this.mediaRecorder;
        if (mediaRecorder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRecorder");
            mediaRecorder = null;
        }
        mediaRecorder.pause();
        Object objEmit = this.recordingStateFlow.emit(z ? RecordingFileState.AUTO_PAUSED : RecordingFileState.PAUSED, continuation);
        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
    }

    public final Object stopRecording(Continuation<? super Unit> continuation) {
        try {
            MediaRecorder mediaRecorder = this.mediaRecorder;
            if (mediaRecorder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRecorder");
                mediaRecorder = null;
            }
            mediaRecorder.stop();
            mediaRecorder.release();
        } catch (IllegalStateException unused) {
        }
        Object objEmit = this.recordingStateFlow.emit(RecordingFileState.NOT_RECORDING, continuation);
        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
    }

    public final MutableStateFlow<RecordingFileState> getRecordingStateFlow() {
        return this.recordingStateFlow;
    }

    /* JADX INFO: renamed from: getRecordingState, reason: collision with other method in class */
    public final RecordingFileState m12329getRecordingState() {
        return this.recordingStateFlow.getValue();
    }

    public final String getElapsedTime() {
        return parseElapsedTime(RecorderService.INSTANCE.getFileDuration(this.recordingFileManager.getRecordingFile()));
    }

    private final String parseElapsedTime(long elapsedTime) {
        String strValueOf = String.valueOf(TimeUnit.MILLISECONDS.toMinutes(elapsedTime));
        return StringsKt.padStart(strValueOf, Math.max(2, strValueOf.length()), '0') + ":" + StringsKt.padStart(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(elapsedTime) % TimeUnit.MINUTES.toSeconds(1L)), 2, '0');
    }
}
