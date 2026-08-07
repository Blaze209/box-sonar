package com.box.android.data.datasource;

import com.box.android.data.api.models.watermark.ApplyWatermarkRequestDTO;
import com.box.android.data.api.models.watermark.WatermarkImprintDTO;
import com.box.android.data.api.requests.WatermarkRequest;
import com.box.android.data.service.impl.DomainErrorMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WatermarkRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u000f\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u000f\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/datasource/WatermarkRemoteDataSource;", "", "watermarkRequest", "Lcom/box/android/data/api/requests/WatermarkRequest;", "<init>", "(Lcom/box/android/data/api/requests/WatermarkRequest;)V", "applyWatermarkToFile", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "fileId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeWatermarkFromFile", "applyWatermarkToFolder", "folderId", "removeWatermarkFromFolder", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class WatermarkRemoteDataSource {
    private final WatermarkRequest watermarkRequest;

    /* JADX INFO: renamed from: com.box.android.data.datasource.WatermarkRemoteDataSource$applyWatermarkToFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: WatermarkRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.WatermarkRemoteDataSource", f = "WatermarkRemoteDataSource.kt", i = {0, 0, 0}, l = {22}, m = "applyWatermarkToFile$suspendImpl", n = {"$this", "fileId", "request"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return WatermarkRemoteDataSource.applyWatermarkToFile$suspendImpl(WatermarkRemoteDataSource.this, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.WatermarkRemoteDataSource$applyWatermarkToFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WatermarkRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.WatermarkRemoteDataSource", f = "WatermarkRemoteDataSource.kt", i = {0, 0, 0}, l = {47}, m = "applyWatermarkToFolder$suspendImpl", n = {"$this", "folderId", "request"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C11011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11011(Continuation<? super C11011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WatermarkRemoteDataSource.applyWatermarkToFolder$suspendImpl(WatermarkRemoteDataSource.this, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.WatermarkRemoteDataSource$removeWatermarkFromFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WatermarkRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.WatermarkRemoteDataSource", f = "WatermarkRemoteDataSource.kt", i = {0, 0}, l = {34}, m = "removeWatermarkFromFile$suspendImpl", n = {"$this", "fileId"}, s = {"L$0", "L$1"}, v = 1)
    static final class C11021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11021(Continuation<? super C11021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WatermarkRemoteDataSource.removeWatermarkFromFile$suspendImpl(WatermarkRemoteDataSource.this, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.WatermarkRemoteDataSource$removeWatermarkFromFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WatermarkRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.WatermarkRemoteDataSource", f = "WatermarkRemoteDataSource.kt", i = {0, 0}, l = {59}, m = "removeWatermarkFromFolder$suspendImpl", n = {"$this", "folderId"}, s = {"L$0", "L$1"}, v = 1)
    static final class C11031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11031(Continuation<? super C11031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WatermarkRemoteDataSource.removeWatermarkFromFolder$suspendImpl(WatermarkRemoteDataSource.this, null, this);
        }
    }

    public Object applyWatermarkToFile(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return applyWatermarkToFile$suspendImpl(this, str, continuation);
    }

    public Object applyWatermarkToFolder(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return applyWatermarkToFolder$suspendImpl(this, str, continuation);
    }

    public Object removeWatermarkFromFile(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return removeWatermarkFromFile$suspendImpl(this, str, continuation);
    }

    public Object removeWatermarkFromFolder(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return removeWatermarkFromFolder$suspendImpl(this, str, continuation);
    }

    @Inject
    public WatermarkRemoteDataSource(WatermarkRequest watermarkRequest) {
        Intrinsics.checkNotNullParameter(watermarkRequest, "watermarkRequest");
        this.watermarkRequest = watermarkRequest;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object applyWatermarkToFile$suspendImpl(WatermarkRemoteDataSource watermarkRemoteDataSource, String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = watermarkRemoteDataSource.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = watermarkRemoteDataSource.new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ApplyWatermarkRequestDTO applyWatermarkRequestDTO = new ApplyWatermarkRequestDTO(new WatermarkImprintDTO(null, 1, null));
                WatermarkRequest watermarkRequest = watermarkRemoteDataSource.watermarkRequest;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(watermarkRemoteDataSource);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(applyWatermarkRequestDTO);
                anonymousClass1.label = 1;
                if (watermarkRequest.applyWatermarkToFile(str, applyWatermarkRequestDTO, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Result.Success(Unit.INSTANCE);
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError(e2, "Failed to apply watermark to file"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object removeWatermarkFromFile$suspendImpl(WatermarkRemoteDataSource watermarkRemoteDataSource, String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C11021 c11021;
        if (continuation instanceof C11021) {
            c11021 = (C11021) continuation;
            if ((c11021.label & Integer.MIN_VALUE) != 0) {
                c11021.label -= Integer.MIN_VALUE;
            } else {
                c11021 = watermarkRemoteDataSource.new C11021(continuation);
            }
        } else {
            c11021 = watermarkRemoteDataSource.new C11021(continuation);
        }
        Object obj = c11021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11021.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                WatermarkRequest watermarkRequest = watermarkRemoteDataSource.watermarkRequest;
                c11021.L$0 = SpillingKt.nullOutSpilledVariable(watermarkRemoteDataSource);
                c11021.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c11021.label = 1;
                if (watermarkRequest.removeWatermarkFromFile(str, c11021) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Result.Success(Unit.INSTANCE);
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError(e2, "Failed to remove watermark from file"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object applyWatermarkToFolder$suspendImpl(WatermarkRemoteDataSource watermarkRemoteDataSource, String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C11011 c11011;
        if (continuation instanceof C11011) {
            c11011 = (C11011) continuation;
            if ((c11011.label & Integer.MIN_VALUE) != 0) {
                c11011.label -= Integer.MIN_VALUE;
            } else {
                c11011 = watermarkRemoteDataSource.new C11011(continuation);
            }
        } else {
            c11011 = watermarkRemoteDataSource.new C11011(continuation);
        }
        Object obj = c11011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11011.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ApplyWatermarkRequestDTO applyWatermarkRequestDTO = new ApplyWatermarkRequestDTO(new WatermarkImprintDTO(null, 1, null));
                WatermarkRequest watermarkRequest = watermarkRemoteDataSource.watermarkRequest;
                c11011.L$0 = SpillingKt.nullOutSpilledVariable(watermarkRemoteDataSource);
                c11011.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c11011.L$2 = SpillingKt.nullOutSpilledVariable(applyWatermarkRequestDTO);
                c11011.label = 1;
                if (watermarkRequest.applyWatermarkToFolder(str, applyWatermarkRequestDTO, c11011) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Result.Success(Unit.INSTANCE);
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError(e2, "Failed to apply watermark to folder"));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object removeWatermarkFromFolder$suspendImpl(WatermarkRemoteDataSource watermarkRemoteDataSource, String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C11031 c11031;
        if (continuation instanceof C11031) {
            c11031 = (C11031) continuation;
            if ((c11031.label & Integer.MIN_VALUE) != 0) {
                c11031.label -= Integer.MIN_VALUE;
            } else {
                c11031 = watermarkRemoteDataSource.new C11031(continuation);
            }
        } else {
            c11031 = watermarkRemoteDataSource.new C11031(continuation);
        }
        Object obj = c11031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11031.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                WatermarkRequest watermarkRequest = watermarkRemoteDataSource.watermarkRequest;
                c11031.L$0 = SpillingKt.nullOutSpilledVariable(watermarkRemoteDataSource);
                c11031.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c11031.label = 1;
                if (watermarkRequest.removeWatermarkFromFolder(str, c11031) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Result.Success(Unit.INSTANCE);
        } catch (CancellationException e) {
            throw e;
        } catch (Exception e2) {
            return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError(e2, "Failed to remove watermark from folder"));
        }
    }
}
