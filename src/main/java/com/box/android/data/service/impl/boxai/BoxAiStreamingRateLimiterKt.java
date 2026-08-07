package com.box.android.data.service.impl.boxai;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.boxai.AiAnswerStreamingModel;
import com.box.android.domain.utils.result.Result;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: BoxAiStreamingRateLimiter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\tH\u0002¨\u0006\n"}, d2 = {"withByWordRateLimiting", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel;", "Lcom/box/android/domain/models/DomainError;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "splitByWord", "", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel$AnswerPart;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiStreamingRateLimiterKt {

    /* JADX INFO: renamed from: com.box.android.data.service.impl.boxai.BoxAiStreamingRateLimiterKt$withByWordRateLimiting$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiStreamingRateLimiter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001c\u0012\u0018\u0012\u0016\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/boxai/AiAnswerStreamingModel;", "kotlin.jvm.PlatformType", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.boxai.BoxAiStreamingRateLimiterKt$withByWordRateLimiting$1", f = "BoxAiStreamingRateLimiter.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {53, 55}, m = "invokeSuspend", n = {"$this$channelFlow", "wordsBuffer", "isStreaming", "isError", "rateCalculator", "$this$channelFlow", "wordsBuffer", "isStreaming", "isError", "rateCalculator"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super Result<? extends AiAnswerStreamingModel, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Flow<Result<AiAnswerStreamingModel, DomainError>> $this_withByWordRateLimiting;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Flow<? extends Result<? extends AiAnswerStreamingModel, ? extends DomainError>> flow, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_withByWordRateLimiting = flow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_withByWordRateLimiting, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super Result<? extends AiAnswerStreamingModel, ? extends DomainError>> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0077 A[PHI: r2 r3 r4 r5
          0x0077: PHI (r2v4 com.box.android.data.service.impl.boxai.WordRateCalculator) = 
          (r2v2 com.box.android.data.service.impl.boxai.WordRateCalculator)
          (r2v3 com.box.android.data.service.impl.boxai.WordRateCalculator)
          (r2v8 com.box.android.data.service.impl.boxai.WordRateCalculator)
         binds: [B:10:0x0045, B:23:0x00cd, B:6:0x0015] A[DONT_GENERATE, DONT_INLINE]
          0x0077: PHI (r3v3 kotlin.jvm.internal.Ref$BooleanRef) = 
          (r3v1 kotlin.jvm.internal.Ref$BooleanRef)
          (r3v2 kotlin.jvm.internal.Ref$BooleanRef)
          (r3v7 kotlin.jvm.internal.Ref$BooleanRef)
         binds: [B:10:0x0045, B:23:0x00cd, B:6:0x0015] A[DONT_GENERATE, DONT_INLINE]
          0x0077: PHI (r4v2 kotlin.jvm.internal.Ref$BooleanRef) = 
          (r4v0 kotlin.jvm.internal.Ref$BooleanRef)
          (r4v1 kotlin.jvm.internal.Ref$BooleanRef)
          (r4v6 kotlin.jvm.internal.Ref$BooleanRef)
         binds: [B:10:0x0045, B:23:0x00cd, B:6:0x0015] A[DONT_GENERATE, DONT_INLINE]
          0x0077: PHI (r5v2 java.util.ArrayDeque) = (r5v0 java.util.ArrayDeque), (r5v1 java.util.ArrayDeque), (r5v6 java.util.ArrayDeque) binds: [B:10:0x0045, B:23:0x00cd, B:6:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:13:0x007b  */
        /* JADX WARN: Code duplicated, block: B:22:0x00af A[PHI: r2 r3 r4 r5
          0x00af: PHI (r2v3 com.box.android.data.service.impl.boxai.WordRateCalculator) = 
          (r2v4 com.box.android.data.service.impl.boxai.WordRateCalculator)
          (r2v4 com.box.android.data.service.impl.boxai.WordRateCalculator)
          (r2v6 com.box.android.data.service.impl.boxai.WordRateCalculator)
         binds: [B:18:0x008f, B:20:0x00ac, B:9:0x0031] A[DONT_GENERATE, DONT_INLINE]
          0x00af: PHI (r3v2 kotlin.jvm.internal.Ref$BooleanRef) = 
          (r3v3 kotlin.jvm.internal.Ref$BooleanRef)
          (r3v3 kotlin.jvm.internal.Ref$BooleanRef)
          (r3v5 kotlin.jvm.internal.Ref$BooleanRef)
         binds: [B:18:0x008f, B:20:0x00ac, B:9:0x0031] A[DONT_GENERATE, DONT_INLINE]
          0x00af: PHI (r4v1 kotlin.jvm.internal.Ref$BooleanRef) = 
          (r4v2 kotlin.jvm.internal.Ref$BooleanRef)
          (r4v2 kotlin.jvm.internal.Ref$BooleanRef)
          (r4v4 kotlin.jvm.internal.Ref$BooleanRef)
         binds: [B:18:0x008f, B:20:0x00ac, B:9:0x0031] A[DONT_GENERATE, DONT_INLINE]
          0x00af: PHI (r5v1 java.util.ArrayDeque) = (r5v2 java.util.ArrayDeque), (r5v2 java.util.ArrayDeque), (r5v4 java.util.ArrayDeque) binds: [B:18:0x008f, B:20:0x00ac, B:9:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00cd -> B:11:0x0077). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArrayDeque arrayDeque;
            Ref.BooleanRef booleanRef;
            Ref.BooleanRef booleanRef2;
            WordRateCalculator wordRateCalculator;
            ProducerScope producerScope = (ProducerScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                arrayDeque = new ArrayDeque();
                booleanRef = new Ref.BooleanRef();
                booleanRef.element = true;
                Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
                WordRateCalculator wordRateCalculator2 = new WordRateCalculator();
                BuildersKt__Builders_commonKt.launch$default(producerScope, null, null, new C01711(this.$this_withByWordRateLimiting, booleanRef, arrayDeque, producerScope, booleanRef3, null), 3, null);
                booleanRef2 = booleanRef3;
                wordRateCalculator = wordRateCalculator2;
            } else {
                if (i == 1) {
                    wordRateCalculator = (WordRateCalculator) this.L$4;
                    booleanRef2 = (Ref.BooleanRef) this.L$3;
                    booleanRef = (Ref.BooleanRef) this.L$2;
                    arrayDeque = (ArrayDeque) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = producerScope;
                    this.L$1 = arrayDeque;
                    this.L$2 = booleanRef;
                    this.L$3 = booleanRef2;
                    this.L$4 = wordRateCalculator;
                    this.label = 2;
                    if (DelayKt.m16309delayVtjQ1oo(wordRateCalculator.m12570getWordDelay5sfh64U(arrayDeque.size()), this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                wordRateCalculator = (WordRateCalculator) this.L$4;
                booleanRef2 = (Ref.BooleanRef) this.L$3;
                booleanRef = (Ref.BooleanRef) this.L$2;
                arrayDeque = (ArrayDeque) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            if (booleanRef2.element && (booleanRef.element || !arrayDeque.isEmpty())) {
                if (!arrayDeque.isEmpty()) {
                    this.L$0 = producerScope;
                    this.L$1 = arrayDeque;
                    this.L$2 = booleanRef;
                    this.L$3 = booleanRef2;
                    this.L$4 = wordRateCalculator;
                    this.label = 1;
                    if (producerScope.send(com.box.android.domain.utils.result.ResultKt.toResultSuccess(arrayDeque.remove()), this) != coroutine_suspended) {
                        this.L$0 = producerScope;
                        this.L$1 = arrayDeque;
                        this.L$2 = booleanRef;
                        this.L$3 = booleanRef2;
                        this.L$4 = wordRateCalculator;
                        this.label = 2;
                        if (DelayKt.m16309delayVtjQ1oo(wordRateCalculator.m12570getWordDelay5sfh64U(arrayDeque.size()), this) != coroutine_suspended) {
                            if (booleanRef2.element) {
                            }
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    this.L$0 = producerScope;
                    this.L$1 = arrayDeque;
                    this.L$2 = booleanRef;
                    this.L$3 = booleanRef2;
                    this.L$4 = wordRateCalculator;
                    this.label = 2;
                    if (DelayKt.m16309delayVtjQ1oo(wordRateCalculator.m12570getWordDelay5sfh64U(arrayDeque.size()), this) != coroutine_suspended) {
                        if (booleanRef2.element) {
                        }
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.box.android.data.service.impl.boxai.BoxAiStreamingRateLimiterKt$withByWordRateLimiting$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BoxAiStreamingRateLimiter.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.service.impl.boxai.BoxAiStreamingRateLimiterKt$withByWordRateLimiting$1$1", f = "BoxAiStreamingRateLimiter.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProducerScope<Result<? extends AiAnswerStreamingModel, ? extends DomainError>> $$this$channelFlow;
            final /* synthetic */ Ref.BooleanRef $isError;
            final /* synthetic */ Ref.BooleanRef $isStreaming;
            final /* synthetic */ Flow<Result<AiAnswerStreamingModel, DomainError>> $this_withByWordRateLimiting;
            final /* synthetic */ ArrayDeque<AiAnswerStreamingModel.AnswerPart> $wordsBuffer;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01711(Flow<? extends Result<? extends AiAnswerStreamingModel, ? extends DomainError>> flow, Ref.BooleanRef booleanRef, ArrayDeque<AiAnswerStreamingModel.AnswerPart> arrayDeque, ProducerScope<? super Result<? extends AiAnswerStreamingModel, ? extends DomainError>> producerScope, Ref.BooleanRef booleanRef2, Continuation<? super C01711> continuation) {
                super(2, continuation);
                this.$this_withByWordRateLimiting = flow;
                this.$isStreaming = booleanRef;
                this.$wordsBuffer = arrayDeque;
                this.$$this$channelFlow = producerScope;
                this.$isError = booleanRef2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01711(this.$this_withByWordRateLimiting, this.$isStreaming, this.$wordsBuffer, this.$$this$channelFlow, this.$isError, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: com.box.android.data.service.impl.boxai.BoxAiStreamingRateLimiterKt$withByWordRateLimiting$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: BoxAiStreamingRateLimiter.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            static final class C01721<T> implements FlowCollector {
                final /* synthetic */ ProducerScope<Result<? extends AiAnswerStreamingModel, ? extends DomainError>> $$this$channelFlow;
                final /* synthetic */ Ref.BooleanRef $isError;
                final /* synthetic */ ArrayDeque<AiAnswerStreamingModel.AnswerPart> $wordsBuffer;

                /* JADX WARN: Multi-variable type inference failed */
                C01721(ArrayDeque<AiAnswerStreamingModel.AnswerPart> arrayDeque, ProducerScope<? super Result<? extends AiAnswerStreamingModel, ? extends DomainError>> producerScope, Ref.BooleanRef booleanRef) {
                    this.$wordsBuffer = arrayDeque;
                    this.$$this$channelFlow = producerScope;
                    this.$isError = booleanRef;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                /* JADX WARN: Code restructure failed: missing block: B:25:0x009c, code lost:
                
                    if (r2.send(r10, r0) == r1) goto L43;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:30:0x00b7, code lost:
                
                    if (r2.send(r10, r0) == r1) goto L43;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:42:0x00f4, code lost:
                
                    if (r9.send(r2, r0) == r1) goto L43;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(com.box.android.domain.utils.result.Result<? extends com.box.android.domain.models.boxai.AiAnswerStreamingModel, ? extends com.box.android.domain.models.DomainError> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
                    /*
                        Method dump skipped, instruction units count: 262
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.boxai.BoxAiStreamingRateLimiterKt.AnonymousClass1.C01711.C01721.emit(com.box.android.domain.utils.result.Result, kotlin.coroutines.Continuation):java.lang.Object");
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit((Result<? extends AiAnswerStreamingModel, ? extends DomainError>) obj, (Continuation<? super Unit>) continuation);
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.$this_withByWordRateLimiting.collect(new C01721(this.$wordsBuffer, this.$$this$channelFlow, this.$isError), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$isStreaming.element = false;
                return Unit.INSTANCE;
            }
        }
    }

    public static final Flow<Result<AiAnswerStreamingModel, DomainError>> withByWordRateLimiting(Flow<? extends Result<? extends AiAnswerStreamingModel, ? extends DomainError>> flow, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        return FlowKt.flowOn(FlowKt.channelFlow(new AnonymousClass1(flow, null)), CoroutineDispatcher.limitedParallelism$default(dispatcher, 1, null, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AiAnswerStreamingModel.AnswerPart> splitByWord(AiAnswerStreamingModel.AnswerPart answerPart) {
        if (answerPart.getAnswer().length() == 0) {
            return CollectionsKt.emptyList();
        }
        if (StringsKt.isBlank(answerPart.getAnswer())) {
            return CollectionsKt.listOf(answerPart);
        }
        Sequence sequenceFindAll$default = Regex.findAll$default(new Regex("\\S+|\\s+"), answerPart.getAnswer(), 0, 2, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = sequenceFindAll$default.iterator();
        while (it.hasNext()) {
            String value = ((MatchResult) it.next()).getValue();
            if (!StringsKt.isBlank(value)) {
                arrayList.add(value);
            } else {
                ArrayList arrayList2 = arrayList;
                if (!arrayList2.isEmpty()) {
                    arrayList2.add(((String) arrayList.remove(CollectionsKt.getLastIndex(arrayList))) + value);
                } else {
                    arrayList2.add(value);
                }
            }
        }
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(new AiAnswerStreamingModel.AnswerPart((String) it2.next()));
        }
        return arrayList4;
    }
}
