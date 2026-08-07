package com.box.android.capture.audiorecording;

import androidx.lifecycle.LiveData;
import com.box.android.domain.models.AudioRecordingError;
import com.box.android.domain.utils.result.Result;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: RecorderService.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H¦@¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H¦@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014H&J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0018H&J\b\u0010\u0019\u001a\u00020\u000bH&J\b\u0010\u001a\u001a\u00020\u000bH&¨\u0006\u001bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/capture/audiorecording/IRecordManager;", "", "startRecording", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/AudioRecordingError;", "file", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pauseRecording", "isAutoPaused", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resumeRecording", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopRecording", "getRecordingStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/box/android/capture/audiorecording/RecordingFileState;", "getRecordedSamples", "Landroidx/lifecycle/LiveData;", "", "", "getRecordedSamplesAsFlow", "Lkotlinx/coroutines/flow/Flow;", "isRecording", "hasPendingRecording", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IRecordManager {
    LiveData<List<Double>> getRecordedSamples();

    Flow<List<Double>> getRecordedSamplesAsFlow();

    StateFlow<RecordingFileState> getRecordingStateFlow();

    boolean hasPendingRecording();

    boolean isRecording();

    Object pauseRecording(boolean z, Continuation<? super Result<Unit, ? extends AudioRecordingError>> continuation);

    Object resumeRecording(Continuation<? super Result<Unit, ? extends AudioRecordingError>> continuation);

    Object startRecording(File file, Continuation<? super Result<Unit, ? extends AudioRecordingError>> continuation);

    Object stopRecording(Continuation<? super Result<Unit, ? extends AudioRecordingError>> continuation);

    /* JADX INFO: compiled from: RecorderService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object pauseRecording$default(IRecordManager iRecordManager, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pauseRecording");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        return iRecordManager.pauseRecording(z, continuation);
    }
}
