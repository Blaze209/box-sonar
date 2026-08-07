package com.box.android.boxai.voice;

import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.time.Duration;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ISpeechRecognitionManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u000b\u001a\u00020\fH&J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH&J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH&J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/box/android/boxai/voice/ISpeechRecognitionManager;", "", "recognitionEventFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/boxai/voice/RecognitionEvent;", "getRecognitionEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "elapsedTime", "Lkotlin/time/Duration;", "getElapsedTime-FghU774", "()Lkotlin/time/Duration;", "isSpeechRecognitionSupported", "", "startListening", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/boxai/voice/RecognitionError;", "finishListening", "cancelListening", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ISpeechRecognitionManager {
    Result<Unit, RecognitionError> cancelListening();

    Result<Unit, RecognitionError> finishListening();

    /* JADX INFO: renamed from: getElapsedTime-FghU774, reason: not valid java name */
    Duration mo12127getElapsedTimeFghU774();

    Flow<RecognitionEvent> getRecognitionEventFlow();

    boolean isSpeechRecognitionSupported();

    Result<Unit, RecognitionError> startListening();
}
