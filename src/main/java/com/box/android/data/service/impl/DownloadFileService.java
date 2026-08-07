package com.box.android.data.service.impl;

import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.files.DownloadFileRemoteDataSource;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.services.IDownloadFileService;
import com.box.android.domain.utils.Progress;
import com.box.android.domain.utils.result.Result;
import com.box.android.domain.utils.result.ResultProgressWrapper;
import java.io.File;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: DownloadFileService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JB\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096@¢\u0006\u0002\u0010\u0013JJ\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/service/impl/DownloadFileService;", "Lcom/box/android/domain/services/IDownloadFileService;", "downloadFileRemoteDataSource", "Lcom/box/android/data/datasource/files/DownloadFileRemoteDataSource;", "<init>", "(Lcom/box/android/data/datasource/files/DownloadFileRemoteDataSource;)V", "downloadFile", "Lcom/box/android/domain/utils/result/ResultProgressWrapper;", "", "Lcom/box/android/domain/models/DomainError;", "Lcom/box/android/domain/utils/Progress;", "fileId", "Lcom/box/android/domain/models/ItemId$Remote;", "fileSize", "", "targetFile", "Ljava/io/File;", "sharedLinkHeader", "", "(Lcom/box/android/domain/models/ItemId$Remote;JLjava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFileChunk", "startByte", "endByte", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/io/File;JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DownloadFileService implements IDownloadFileService {
    private final DownloadFileRemoteDataSource downloadFileRemoteDataSource;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.DownloadFileService$downloadFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadFileService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.DownloadFileService", f = "DownloadFileService.kt", i = {0, 0, 0, 0}, l = {22}, m = "downloadFile", n = {"fileId", "targetFile", "sharedLinkHeader", "fileSize"}, s = {"L$0", "L$1", "L$2", "J$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFileService.this.downloadFile(null, 0L, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.DownloadFileService$downloadFileChunk$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadFileService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.DownloadFileService", f = "DownloadFileService.kt", i = {0, 0, 0, 0, 0}, l = {43}, m = "downloadFileChunk", n = {"fileId", "targetFile", "sharedLinkHeader", "startByte", "endByte"}, s = {"L$0", "L$1", "L$2", "J$0", "J$1"}, v = 1)
    static final class C14231 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C14231(Continuation<? super C14231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFileService.this.downloadFileChunk(null, null, 0L, 0L, null, this);
        }
    }

    @Inject
    public DownloadFileService(DownloadFileRemoteDataSource downloadFileRemoteDataSource) {
        Intrinsics.checkNotNullParameter(downloadFileRemoteDataSource, "downloadFileRemoteDataSource");
        this.downloadFileRemoteDataSource = downloadFileRemoteDataSource;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IDownloadFileService
    public Object downloadFile(ItemId.Remote remote, long j, File file, String str, Continuation<? super ResultProgressWrapper<Unit, DomainError, Progress>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objDownloadFile = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDownloadFile);
            DownloadFileRemoteDataSource downloadFileRemoteDataSource = this.downloadFileRemoteDataSource;
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(remote);
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(file);
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass2.J$0 = j;
            anonymousClass2.label = 1;
            objDownloadFile = downloadFileRemoteDataSource.downloadFile(remote, j, str, file, anonymousClass2);
            if (objDownloadFile == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j2 = anonymousClass2.J$0;
            ResultKt.throwOnFailure(objDownloadFile);
        }
        ResultProgressWrapper resultProgressWrapper = (ResultProgressWrapper) objDownloadFile;
        Flow progress = resultProgressWrapper.getProgress();
        final Flow result = resultProgressWrapper.getResult();
        return new ResultProgressWrapper(progress, new Flow<Result<? extends Unit, ? extends DomainError>>() { // from class: com.box.android.data.service.impl.DownloadFileService$downloadFile$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.data.service.impl.DownloadFileService$downloadFile$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.data.service.impl.DownloadFileService$downloadFile$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.service.impl.DownloadFileService$downloadFile$$inlined$map$1$2", f = "DownloadFileService.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Result.Error error = (Result) obj;
                        Result result = null;
                        if (error != null) {
                            if (!(error instanceof Result.Success)) {
                                if (!(error instanceof Result.Error)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) error).getValue(), null, 2, null));
                            }
                            result = error;
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(result, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Result<? extends Unit, ? extends DomainError>> flowCollector, Continuation continuation2) {
                Object objCollect = result.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IDownloadFileService
    public Object downloadFileChunk(ItemId.Remote remote, File file, long j, long j2, String str, Continuation<? super ResultProgressWrapper<Unit, DomainError, Progress>> continuation) {
        C14231 c14231;
        if (continuation instanceof C14231) {
            c14231 = (C14231) continuation;
            if ((c14231.label & Integer.MIN_VALUE) != 0) {
                c14231.label -= Integer.MIN_VALUE;
            } else {
                c14231 = new C14231(continuation);
            }
        } else {
            c14231 = new C14231(continuation);
        }
        C14231 c14232 = c14231;
        Object objDownloadFileChunk = c14232.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14232.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDownloadFileChunk);
            DownloadFileRemoteDataSource downloadFileRemoteDataSource = this.downloadFileRemoteDataSource;
            c14232.L$0 = SpillingKt.nullOutSpilledVariable(remote);
            c14232.L$1 = SpillingKt.nullOutSpilledVariable(file);
            c14232.L$2 = SpillingKt.nullOutSpilledVariable(str);
            c14232.J$0 = j;
            c14232.J$1 = j2;
            c14232.label = 1;
            objDownloadFileChunk = downloadFileRemoteDataSource.downloadFileChunk(remote, file, j, j2, str, c14232);
            if (objDownloadFileChunk == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j3 = c14232.J$1;
            long j4 = c14232.J$0;
            ResultKt.throwOnFailure(objDownloadFileChunk);
        }
        ResultProgressWrapper resultProgressWrapper = (ResultProgressWrapper) objDownloadFileChunk;
        Flow progress = resultProgressWrapper.getProgress();
        final Flow result = resultProgressWrapper.getResult();
        return new ResultProgressWrapper(progress, new Flow<Result<? extends Unit, ? extends DomainError>>() { // from class: com.box.android.data.service.impl.DownloadFileService$downloadFileChunk$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.data.service.impl.DownloadFileService$downloadFileChunk$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.data.service.impl.DownloadFileService$downloadFileChunk$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.service.impl.DownloadFileService$downloadFileChunk$$inlined$map$1$2", f = "DownloadFileService.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Result.Error error = (Result) obj;
                        Result result = null;
                        if (error != null) {
                            if (!(error instanceof Result.Success)) {
                                if (!(error instanceof Result.Error)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) error).getValue(), null, 2, null));
                            }
                            result = error;
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(result, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Result<? extends Unit, ? extends DomainError>> flowCollector, Continuation continuation2) {
                Object objCollect = result.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        });
    }
}
