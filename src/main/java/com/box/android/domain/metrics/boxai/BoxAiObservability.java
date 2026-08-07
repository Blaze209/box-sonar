package com.box.android.domain.metrics.boxai;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.observability.BoxAiEvent;
import com.box.android.domain.models.preview.BoxAiActionEvent;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: BoxAiObservability.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ*\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J&\u0010\u0014\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\tJ&\u0010\u0018\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\tJ&\u0010\u001a\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u0019\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/box/android/domain/metrics/boxai/BoxAiObservability;", "", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lkotlinx/coroutines/CoroutineDispatcher;)V", "promptSubmittedTime", "", "logBoxAiEnabledInMultiselect", "", "logBoxAiSessionCreated", "fileModels", "", "Lcom/box/android/domain/models/item/FileModel;", "isLargeFile", "", "domainError", "Lcom/box/android/domain/models/DomainError;", "logPromptSubmitted", "wordCount", "", "timeSubmitted", "logSuccessResponseReceived", "responseReceivedTime", "logErrorResponseReceived", "failReason", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiObservability {
    private final CoroutineDispatcher ioDispatcher;
    private final MetricsUseCase metricsUseCase;
    private long promptSubmittedTime;

    @Inject
    public BoxAiObservability(MetricsUseCase metricsUseCase, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.metricsUseCase = metricsUseCase;
        this.ioDispatcher = ioDispatcher;
        this.promptSubmittedTime = System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.boxai.BoxAiObservability$logBoxAiEnabledInMultiselect$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.boxai.BoxAiObservability$logBoxAiEnabledInMultiselect$1", f = "BoxAiObservability.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxAiObservability.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BoxAiObservability.this.metricsUseCase.log(new BoxAiEvent(BoxAiActionEvent.AiEnabledMultiselect.INSTANCE, SetsKt.emptySet(), null, null, null, 28, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void logBoxAiEnabledInMultiselect() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.boxai.BoxAiObservability$logBoxAiSessionCreated$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.boxai.BoxAiObservability$logBoxAiSessionCreated$1", f = "BoxAiObservability.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DomainError $domainError;
        final /* synthetic */ List<FileModel> $fileModels;
        final /* synthetic */ boolean $isLargeFile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15911(boolean z, DomainError domainError, List<FileModel> list, Continuation<? super C15911> continuation) {
            super(2, continuation);
            this.$isLargeFile = z;
            this.$domainError = domainError;
            this.$fileModels = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxAiObservability.this.new C15911(this.$isLargeFile, this.$domainError, this.$fileModels, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MetricsUseCase metricsUseCase = BoxAiObservability.this.metricsUseCase;
                BoxAiActionEvent.AiSessionCreated aiSessionCreated = new BoxAiActionEvent.AiSessionCreated(this.$isLargeFile ? BoxRequestsFile.DownloadAvatar.LARGE : BoxRequestsFile.DownloadAvatar.SMALL, this.$domainError);
                List<FileModel> list = this.$fileModels;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((FileModel) it.next()).getExtension());
                }
                this.label = 1;
                if (metricsUseCase.log(new BoxAiEvent(aiSessionCreated, CollectionsKt.toSet(arrayList), Boxing.boxInt(this.$fileModels.size()), null, null, 24, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void logBoxAiSessionCreated$default(BoxAiObservability boxAiObservability, List list, boolean z, DomainError domainError, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            domainError = null;
        }
        boxAiObservability.logBoxAiSessionCreated(list, z, domainError);
    }

    public final void logBoxAiSessionCreated(List<FileModel> fileModels, boolean isLargeFile, DomainError domainError) {
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new C15911(isLargeFile, domainError, fileModels, null), 3, null);
    }

    public static /* synthetic */ void logPromptSubmitted$default(BoxAiObservability boxAiObservability, List list, int i, long j, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j = System.currentTimeMillis();
        }
        boxAiObservability.logPromptSubmitted(list, i, j);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.boxai.BoxAiObservability$logPromptSubmitted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.boxai.BoxAiObservability$logPromptSubmitted$1", f = "BoxAiObservability.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<FileModel> $fileModels;
        final /* synthetic */ int $wordCount;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15931(int i, List<FileModel> list, Continuation<? super C15931> continuation) {
            super(2, continuation);
            this.$wordCount = i;
            this.$fileModels = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxAiObservability.this.new C15931(this.$wordCount, this.$fileModels, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MetricsUseCase metricsUseCase = BoxAiObservability.this.metricsUseCase;
                BoxAiActionEvent.PromptSubmitted promptSubmitted = new BoxAiActionEvent.PromptSubmitted(this.$wordCount);
                List<FileModel> list = this.$fileModels;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((FileModel) it.next()).getExtension());
                }
                this.label = 1;
                if (metricsUseCase.log(new BoxAiEvent(promptSubmitted, CollectionsKt.toSet(arrayList), Boxing.boxInt(this.$fileModels.size()), null, null, 24, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void logPromptSubmitted(List<FileModel> fileModels, int wordCount, long timeSubmitted) {
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        this.promptSubmittedTime = timeSubmitted;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new C15931(wordCount, fileModels, null), 3, null);
    }

    public static /* synthetic */ void logSuccessResponseReceived$default(BoxAiObservability boxAiObservability, List list, int i, long j, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j = System.currentTimeMillis();
        }
        boxAiObservability.logSuccessResponseReceived(list, i, j);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.boxai.BoxAiObservability$logSuccessResponseReceived$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.boxai.BoxAiObservability$logSuccessResponseReceived$1", f = "BoxAiObservability.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<FileModel> $fileModels;
        final /* synthetic */ long $timeToReceiveResponse;
        final /* synthetic */ int $wordCount;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15941(long j, int i, List<FileModel> list, Continuation<? super C15941> continuation) {
            super(2, continuation);
            this.$timeToReceiveResponse = j;
            this.$wordCount = i;
            this.$fileModels = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxAiObservability.this.new C15941(this.$timeToReceiveResponse, this.$wordCount, this.$fileModels, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MetricsUseCase metricsUseCase = BoxAiObservability.this.metricsUseCase;
                BoxAiActionEvent.AnswerReceived answerReceived = new BoxAiActionEvent.AnswerReceived(this.$timeToReceiveResponse, Boxing.boxInt(this.$wordCount), null, 4, null);
                List<FileModel> list = this.$fileModels;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((FileModel) it.next()).getExtension());
                }
                this.label = 1;
                if (metricsUseCase.log(new BoxAiEvent(answerReceived, CollectionsKt.toSet(arrayList), Boxing.boxInt(this.$fileModels.size()), null, null, 24, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void logSuccessResponseReceived(List<FileModel> fileModels, int wordCount, long responseReceivedTime) {
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new C15941(responseReceivedTime - this.promptSubmittedTime, wordCount, fileModels, null), 3, null);
    }

    public static /* synthetic */ void logErrorResponseReceived$default(BoxAiObservability boxAiObservability, List list, DomainError domainError, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = System.currentTimeMillis();
        }
        boxAiObservability.logErrorResponseReceived(list, domainError, j);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.boxai.BoxAiObservability$logErrorResponseReceived$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAiObservability.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.boxai.BoxAiObservability$logErrorResponseReceived$1", f = "BoxAiObservability.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DomainError $failReason;
        final /* synthetic */ List<FileModel> $fileModels;
        final /* synthetic */ long $timeToReceiveResponse;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15921(long j, DomainError domainError, List<FileModel> list, Continuation<? super C15921> continuation) {
            super(2, continuation);
            this.$timeToReceiveResponse = j;
            this.$failReason = domainError;
            this.$fileModels = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxAiObservability.this.new C15921(this.$timeToReceiveResponse, this.$failReason, this.$fileModels, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MetricsUseCase metricsUseCase = BoxAiObservability.this.metricsUseCase;
                BoxAiActionEvent.AnswerReceived answerReceived = new BoxAiActionEvent.AnswerReceived(this.$timeToReceiveResponse, null, this.$failReason, 2, null);
                List<FileModel> list = this.$fileModels;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((FileModel) it.next()).getExtension());
                }
                this.label = 1;
                if (metricsUseCase.log(new BoxAiEvent(answerReceived, CollectionsKt.toSet(arrayList), Boxing.boxInt(this.$fileModels.size()), null, null, 24, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void logErrorResponseReceived(List<FileModel> fileModels, DomainError failReason, long responseReceivedTime) {
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        Intrinsics.checkNotNullParameter(failReason, "failReason");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new C15921(responseReceivedTime - this.promptSubmittedTime, failReason, fileModels, null), 3, null);
    }
}
