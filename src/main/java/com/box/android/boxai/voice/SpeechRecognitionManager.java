package com.box.android.boxai.voice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import com.box.android.domain.utils.result.Result;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: SpeechRecognitionManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00018B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020 0\u001aH\u0016J\u0014\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020 0\u001aH\u0016J\b\u0010\"\u001a\u00020\u001bH\u0002J\u0012\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u001bH\u0016J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020\u001b2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u001bH\u0016J\u0012\u0010.\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u00010%H\u0016J\u0012\u00100\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u00010%H\u0016J\u0010\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u000204H\u0016J\u001a\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u0002042\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u00107\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u00069"}, d2 = {"Lcom/box/android/boxai/voice/SpeechRecognitionManager;", "Lcom/box/android/boxai/voice/ISpeechRecognitionManager;", "Landroid/speech/RecognitionListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "speechRecognizer", "Landroid/speech/SpeechRecognizer;", "startTimeMillis", "", "Ljava/lang/Long;", "_recognitionEventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/box/android/boxai/voice/RecognitionEvent;", "recognitionEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getRecognitionEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "elapsedTime", "Lkotlin/time/Duration;", "getElapsedTime-FghU774", "()Lkotlin/time/Duration;", "isSpeechRecognitionSupported", "", "startListening", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/boxai/voice/RecognitionError;", "createRecognizerIntent", "Landroid/content/Intent;", "finishListening", "Lcom/box/android/boxai/voice/RecognitionError$GenericError;", "cancelListening", "cleanUp", "onReadyForSpeech", SerializedNames.PARAMS, "Landroid/os/Bundle;", "onBeginningOfSpeech", "onRmsChanged", "rmsdB", "", "onBufferReceived", "buffer", "", "onEndOfSpeech", "onPartialResults", "partialResults", "onResults", "results", "onError", "error", "", "onEvent", "eventType", "getCurrentTimeMillis", "Companion", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SpeechRecognitionManager implements ISpeechRecognitionManager, RecognitionListener {
    private static final long SILENCE_TIME_BEFORE_FINISHING;
    private final MutableSharedFlow<RecognitionEvent> _recognitionEventFlow;
    private final Context context;
    private final SharedFlow<RecognitionEvent> recognitionEventFlow;
    private SpeechRecognizer speechRecognizer;
    private Long startTimeMillis;
    public static final int $stable = 8;

    @Override // android.speech.RecognitionListener
    public void onBeginningOfSpeech() {
    }

    @Override // android.speech.RecognitionListener
    public void onBufferReceived(byte[] buffer) {
    }

    @Override // android.speech.RecognitionListener
    public void onEndOfSpeech() {
    }

    @Override // android.speech.RecognitionListener
    public void onEvent(int eventType, Bundle params) {
    }

    @Override // android.speech.RecognitionListener
    public void onPartialResults(Bundle partialResults) {
    }

    @Inject
    public SpeechRecognitionManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        MutableSharedFlow<RecognitionEvent> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 5, null, 5, null);
        this._recognitionEventFlow = mutableSharedFlowMutableSharedFlow$default;
        this.recognitionEventFlow = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    @Override // com.box.android.boxai.voice.ISpeechRecognitionManager
    public SharedFlow<RecognitionEvent> getRecognitionEventFlow() {
        return this.recognitionEventFlow;
    }

    @Override // com.box.android.boxai.voice.ISpeechRecognitionManager
    /* JADX INFO: renamed from: getElapsedTime-FghU774 */
    public Duration mo12127getElapsedTimeFghU774() {
        Long l = this.startTimeMillis;
        if (l == null) {
            return null;
        }
        long jLongValue = l.longValue();
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m16154boximpl(DurationKt.toDuration(getCurrentTimeMillis() - jLongValue, DurationUnit.MILLISECONDS));
    }

    @Override // com.box.android.boxai.voice.ISpeechRecognitionManager
    public boolean isSpeechRecognitionSupported() {
        return SpeechRecognizer.isRecognitionAvailable(this.context);
    }

    @Override // com.box.android.boxai.voice.ISpeechRecognitionManager
    public Result<Unit, RecognitionError> startListening() {
        Result.Error error;
        if (this.speechRecognizer != null) {
            return new Result.Error(RecognitionError.ListeningInProgress.INSTANCE);
        }
        if (!isSpeechRecognitionSupported()) {
            return new Result.Error(RecognitionError.RecognitionNotSupported.INSTANCE);
        }
        try {
            SpeechRecognizer speechRecognizerCreateSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this.context);
            speechRecognizerCreateSpeechRecognizer.setRecognitionListener(this);
            speechRecognizerCreateSpeechRecognizer.startListening(createRecognizerIntent());
            this.speechRecognizer = speechRecognizerCreateSpeechRecognizer;
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(RecognitionError.GenericError.INSTANCE);
    }

    private final Intent createRecognizerIntent() {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        long j = SILENCE_TIME_BEFORE_FINISHING;
        intent.putExtra("android.speech.extras.SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS", Duration.m16167getInWholeMillisecondsimpl(j));
        intent.putExtra("android.speech.extras.SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS", Duration.m16167getInWholeMillisecondsimpl(j));
        intent.putExtra("android.speech.extra.ENABLE_LANGUAGE_DETECTION", true);
        return intent;
    }

    @Override // com.box.android.boxai.voice.ISpeechRecognitionManager
    public Result<Unit, RecognitionError.GenericError> finishListening() {
        Result.Error error;
        try {
            SpeechRecognizer speechRecognizer = this.speechRecognizer;
            if (speechRecognizer != null) {
                speechRecognizer.stopListening();
            }
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(RecognitionError.GenericError.INSTANCE);
    }

    @Override // com.box.android.boxai.voice.ISpeechRecognitionManager
    public Result<Unit, RecognitionError.GenericError> cancelListening() {
        Result.Error error;
        try {
            SpeechRecognizer speechRecognizer = this.speechRecognizer;
            if (speechRecognizer != null) {
                speechRecognizer.cancel();
            }
            this._recognitionEventFlow.tryEmit(RecognitionEvent.ListeningCancelled.INSTANCE);
            cleanUp();
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(RecognitionError.GenericError.INSTANCE);
    }

    private final void cleanUp() {
        SpeechRecognizer speechRecognizer = this.speechRecognizer;
        if (speechRecognizer != null) {
            speechRecognizer.destroy();
        }
        this.speechRecognizer = null;
        this.startTimeMillis = null;
    }

    @Override // android.speech.RecognitionListener
    public void onReadyForSpeech(Bundle params) {
        this._recognitionEventFlow.tryEmit(RecognitionEvent.ListeningStarted.INSTANCE);
        this.startTimeMillis = Long.valueOf(getCurrentTimeMillis());
    }

    @Override // android.speech.RecognitionListener
    public void onRmsChanged(float rmsdB) {
        this._recognitionEventFlow.tryEmit(new RecognitionEvent.AudioLevelSample(rmsdB));
    }

    @Override // android.speech.RecognitionListener
    public void onResults(Bundle results) {
        ArrayList<String> stringArrayList = results != null ? results.getStringArrayList("results_recognition") : null;
        String strJoinToString$default = stringArrayList != null ? CollectionsKt.joinToString$default(stringArrayList, " ", null, null, 0, null, null, 62, null) : null;
        if (strJoinToString$default != null) {
            this._recognitionEventFlow.tryEmit(new RecognitionEvent.ListeningFinished(strJoinToString$default));
        } else {
            this._recognitionEventFlow.tryEmit(new RecognitionEvent.Error(RecognitionError.GenericError.INSTANCE));
        }
        cleanUp();
    }

    @Override // android.speech.RecognitionListener
    public void onError(int error) {
        this._recognitionEventFlow.tryEmit(new RecognitionEvent.Error(RecognitionError.GenericError.INSTANCE));
        cleanUp();
    }

    private final long getCurrentTimeMillis() {
        return SystemClock.elapsedRealtime();
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        SILENCE_TIME_BEFORE_FINISHING = DurationKt.toDuration(4, DurationUnit.SECONDS);
    }
}
