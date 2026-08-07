package com.box.android.data.datasource.files;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.api.interceptors.UploadProgressRequestBody;
import com.box.android.data.api.models.items.ItemsDTO;
import com.box.android.data.api.models.upload.ChunkedFileUploadDTO;
import com.box.android.data.api.models.upload.PartListDTO;
import com.box.android.data.api.models.upload.UploadFileChunkDTO;
import com.box.android.data.api.models.upload.UploadSessionArgsDTO;
import com.box.android.data.api.models.upload.UploadSessionDTO;
import com.box.android.data.api.requests.ChunkedFileUploadRequest;
import com.box.android.data.datasource.errors.CommitNotReadyException;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.errors.UploadErrorUtil;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.Progress;
import com.box.android.domain.utils.result.Result;
import com.box.android.domain.utils.result.ResultProgressWrapper;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.util.List;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: compiled from: ChunkedFileUploadRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J4\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J2\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0017\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u0018J\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u001b\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u0018J8\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0086@¢\u0006\u0002\u0010#J@\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010)\u001a\u00020*H\u0086@¢\u0006\u0002\u0010+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/box/android/data/datasource/files/ChunkedFileUploadRemoteDataSource;", "", "chunkedFileUploadRequest", "Lcom/box/android/data/api/requests/ChunkedFileUploadRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/ChunkedFileUploadRequest;Lcom/squareup/moshi/Moshi;)V", "createUploadSessionForExistingBoxFile", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/upload/UploadSessionDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", BoxCommonConstants.EXTRA_FILE_NAME, "", "fileSize", "", "boxFileId", "Lcom/box/android/domain/models/ItemId$Remote;", "(Ljava/lang/String;JLcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUploadSession", "parentFolderId", "getUploadedFileChunks", "Lcom/box/android/data/api/models/upload/ChunkedFileUploadDTO;", "sessionId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "abortUpload", "", "abortUploadEndpoint", "commitSession", "Lcom/box/android/data/api/models/items/ItemsDTO;", "commitSessionEndpoint", "digest", "parts", "", "Lcom/box/android/data/api/models/upload/UploadFileChunkDTO;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadChunk", "Lcom/box/android/domain/utils/result/ResultProgressWrapper;", "Lcom/box/android/domain/utils/Progress;", "uploadChunkEndpoint", "contentRange", "fileChunk", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChunkedFileUploadRemoteDataSource {
    private final ChunkedFileUploadRequest chunkedFileUploadRequest;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource$abortUpload$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChunkedFileUploadRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource", f = "ChunkedFileUploadRemoteDataSource.kt", i = {0, 0, 0}, l = {95}, m = "abortUpload", n = {"abortUploadEndpoint", "$i$f$resultOf", "$i$a$-resultOf-ChunkedFileUploadRemoteDataSource$abortUpload$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedFileUploadRemoteDataSource.this.abortUpload(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource$commitSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChunkedFileUploadRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource", f = "ChunkedFileUploadRemoteDataSource.kt", i = {0, 0, 0, 0, 0}, l = {110}, m = "commitSession", n = {"commitSessionEndpoint", "digest", "parts", "$i$f$resultOf", "$i$a$-resultOf-ChunkedFileUploadRemoteDataSource$commitSession$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C11431 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11431(Continuation<? super C11431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedFileUploadRemoteDataSource.this.commitSession(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource$createUploadSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChunkedFileUploadRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource", f = "ChunkedFileUploadRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {74}, m = "createUploadSession", n = {BoxCommonConstants.EXTRA_FILE_NAME, "parentFolderId", "uploadSessionArgs", "fileSize", "$i$f$resultOf", "$i$a$-resultOf-ChunkedFileUploadRemoteDataSource$createUploadSession$2"}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "I$1"}, v = 1)
    static final class C11441 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11441(Continuation<? super C11441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedFileUploadRemoteDataSource.this.createUploadSession(null, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource$createUploadSessionForExistingBoxFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChunkedFileUploadRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource", f = "ChunkedFileUploadRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {52}, m = "createUploadSessionForExistingBoxFile", n = {BoxCommonConstants.EXTRA_FILE_NAME, "boxFileId", "uploadSessionArgs", "fileSize", "$i$f$resultOf", "$i$a$-resultOf-ChunkedFileUploadRemoteDataSource$createUploadSessionForExistingBoxFile$2"}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "I$1"}, v = 1)
    static final class C11451 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11451(Continuation<? super C11451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedFileUploadRemoteDataSource.this.createUploadSessionForExistingBoxFile(null, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource$getUploadedFileChunks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChunkedFileUploadRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource", f = "ChunkedFileUploadRemoteDataSource.kt", i = {0, 0, 0}, l = {86}, m = "getUploadedFileChunks", n = {"sessionId", "$i$f$resultOf", "$i$a$-resultOf-ChunkedFileUploadRemoteDataSource$getUploadedFileChunks$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C11461 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11461(Continuation<? super C11461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedFileUploadRemoteDataSource.this.getUploadedFileChunks(null, this);
        }
    }

    @Inject
    public ChunkedFileUploadRemoteDataSource(ChunkedFileUploadRequest chunkedFileUploadRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(chunkedFileUploadRequest, "chunkedFileUploadRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.chunkedFileUploadRequest = chunkedFileUploadRequest;
        this.moshi = moshi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createUploadSessionForExistingBoxFile(String str, long j, ItemId.Remote remote, Continuation<? super Result<UploadSessionDTO, ? extends RemoteError>> continuation) {
        C11451 c11451;
        Result.Error error;
        if (continuation instanceof C11451) {
            c11451 = (C11451) continuation;
            if ((c11451.label & Integer.MIN_VALUE) != 0) {
                c11451.label -= Integer.MIN_VALUE;
            } else {
                c11451 = new C11451(continuation);
            }
        } else {
            c11451 = new C11451(continuation);
        }
        Object objCreateUploadSession = c11451.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11451.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreateUploadSession);
                UploadSessionArgsDTO uploadSessionArgsDTO = new UploadSessionArgsDTO(null, str, j);
                ChunkedFileUploadRequest chunkedFileUploadRequest = this.chunkedFileUploadRequest;
                String boxId = remote.getBoxId();
                c11451.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11451.L$1 = SpillingKt.nullOutSpilledVariable(remote);
                c11451.L$2 = SpillingKt.nullOutSpilledVariable(uploadSessionArgsDTO);
                c11451.J$0 = j;
                c11451.I$0 = 0;
                c11451.I$1 = 0;
                c11451.label = 1;
                objCreateUploadSession = chunkedFileUploadRequest.createUploadSession(boxId, uploadSessionArgsDTO, c11451);
                if (objCreateUploadSession == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11451.I$1;
                int i3 = c11451.I$0;
                long j2 = c11451.J$0;
                ResultKt.throwOnFailure(objCreateUploadSession);
            }
            error = new Result.Success((UploadSessionDTO) objCreateUploadSession);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(UploadErrorUtil.INSTANCE.getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createUploadSession(String str, long j, ItemId.Remote remote, Continuation<? super Result<UploadSessionDTO, ? extends RemoteError>> continuation) {
        C11441 c11441;
        Result.Error error;
        if (continuation instanceof C11441) {
            c11441 = (C11441) continuation;
            if ((c11441.label & Integer.MIN_VALUE) != 0) {
                c11441.label -= Integer.MIN_VALUE;
            } else {
                c11441 = new C11441(continuation);
            }
        } else {
            c11441 = new C11441(continuation);
        }
        Object objCreateUploadSession = c11441.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11441.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreateUploadSession);
                UploadSessionArgsDTO uploadSessionArgsDTO = new UploadSessionArgsDTO(remote.getBoxId(), str, j);
                ChunkedFileUploadRequest chunkedFileUploadRequest = this.chunkedFileUploadRequest;
                c11441.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11441.L$1 = SpillingKt.nullOutSpilledVariable(remote);
                c11441.L$2 = SpillingKt.nullOutSpilledVariable(uploadSessionArgsDTO);
                c11441.J$0 = j;
                c11441.I$0 = 0;
                c11441.I$1 = 0;
                c11441.label = 1;
                objCreateUploadSession = chunkedFileUploadRequest.createUploadSession(uploadSessionArgsDTO, c11441);
                if (objCreateUploadSession == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11441.I$1;
                int i3 = c11441.I$0;
                long j2 = c11441.J$0;
                ResultKt.throwOnFailure(objCreateUploadSession);
            }
            error = new Result.Success((UploadSessionDTO) objCreateUploadSession);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(UploadErrorUtil.INSTANCE.getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getUploadedFileChunks(String str, Continuation<? super Result<ChunkedFileUploadDTO, ? extends RemoteError>> continuation) {
        C11461 c11461;
        Result.Error error;
        if (continuation instanceof C11461) {
            c11461 = (C11461) continuation;
            if ((c11461.label & Integer.MIN_VALUE) != 0) {
                c11461.label -= Integer.MIN_VALUE;
            } else {
                c11461 = new C11461(continuation);
            }
        } else {
            c11461 = new C11461(continuation);
        }
        Object objUploadedChunks = c11461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11461.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objUploadedChunks);
                ChunkedFileUploadRequest chunkedFileUploadRequest = this.chunkedFileUploadRequest;
                c11461.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11461.I$0 = 0;
                c11461.I$1 = 0;
                c11461.label = 1;
                objUploadedChunks = chunkedFileUploadRequest.uploadedChunks(str, c11461);
                if (objUploadedChunks == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11461.I$1;
                int i3 = c11461.I$0;
                ResultKt.throwOnFailure(objUploadedChunks);
            }
            error = new Result.Success((ChunkedFileUploadDTO) objUploadedChunks);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(UploadErrorUtil.INSTANCE.getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object abortUpload(String str, Continuation<? super Result<Unit, ? extends RemoteError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ChunkedFileUploadRequest chunkedFileUploadRequest = this.chunkedFileUploadRequest;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                if (chunkedFileUploadRequest.abortUpload(str, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(obj);
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
        return new Result.Error(UploadErrorUtil.INSTANCE.getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object commitSession(String str, String str2, List<UploadFileChunkDTO> list, Continuation<? super Result<ItemsDTO, ? extends RemoteError>> continuation) {
        C11431 c11431;
        Result.Error error;
        if (continuation instanceof C11431) {
            c11431 = (C11431) continuation;
            if ((c11431.label & Integer.MIN_VALUE) != 0) {
                c11431.label -= Integer.MIN_VALUE;
            } else {
                c11431 = new C11431(continuation);
            }
        } else {
            c11431 = new C11431(continuation);
        }
        Object objCommitSession = c11431.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11431.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCommitSession);
                ChunkedFileUploadRequest chunkedFileUploadRequest = this.chunkedFileUploadRequest;
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String json = this.moshi.adapter(PartListDTO.class).toJson(new PartListDTO(list));
                Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
                RequestBody requestBodyCreate = companion.create(json, MediaType.INSTANCE.get("application/json"));
                c11431.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11431.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c11431.L$2 = SpillingKt.nullOutSpilledVariable(list);
                c11431.I$0 = 0;
                c11431.I$1 = 0;
                c11431.label = 1;
                objCommitSession = chunkedFileUploadRequest.commitSession(str, str2, requestBodyCreate, c11431);
                if (objCommitSession == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11431.I$1;
                int i3 = c11431.I$0;
                ResultKt.throwOnFailure(objCommitSession);
            }
            Response response = (Response) objCommitSession;
            int iCode = response.code();
            if (iCode != 201) {
                if (iCode == 202) {
                    throw CommitNotReadyException.INSTANCE;
                }
                throw new HttpException(response);
            }
            JsonAdapter jsonAdapterAdapter = this.moshi.adapter(ItemsDTO.class);
            Object objBody = response.body();
            Intrinsics.checkNotNull(objBody);
            Object objFromJson = jsonAdapterAdapter.fromJson(((ResponseBody) objBody).string());
            Intrinsics.checkNotNull(objFromJson);
            error = new Result.Success((ItemsDTO) objFromJson);
            if (error instanceof Result.Success) {
                return error;
            }
            if (error instanceof Result.Error) {
                Exception exc = (Exception) ((Result.Error) error).getValue();
                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Exception committing upload session: " + exc);
                return new Result.Error(UploadErrorUtil.INSTANCE.getRemoteErrorFromApiException(exc, this.moshi));
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            error = new Result.Error(e);
        }
    }

    public final Object uploadChunk(String str, String str2, String str3, byte[] bArr, Continuation<? super ResultProgressWrapper<UploadFileChunkDTO, RemoteError, Progress>> continuation) {
        MutableStateFlow<Progress> MutableStateFlow = StateFlowKt.MutableStateFlow(new Progress(0L, 1L));
        MutableStateFlow MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        RequestBody requestBodyAsProgressRequestBody = UploadProgressRequestBody.INSTANCE.asProgressRequestBody(bArr, MediaType.INSTANCE.get("application/octet-stream"), MutableStateFlow);
        ResultProgressWrapper resultProgressWrapper = new ResultProgressWrapper(MutableStateFlow, MutableStateFlow2);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ChunkedFileUploadRemoteDataSource$uploadChunk$2$1(MutableStateFlow2, this, str, str2, str3, requestBodyAsProgressRequestBody, null), 3, null);
        return resultProgressWrapper;
    }
}
