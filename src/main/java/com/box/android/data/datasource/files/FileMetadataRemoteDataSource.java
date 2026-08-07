package com.box.android.data.datasource.files;

import com.box.android.data.api.models.FileMetadataInstanceDTO;
import com.box.android.data.api.models.FileMetadataListDTO;
import com.box.android.data.api.requests.FileMetadataRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import com.squareup.moshi.Moshi;
import java.util.List;
import java.util.Map;
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

/* JADX INFO: compiled from: FileMetadataRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ6\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/datasource/files/FileMetadataRemoteDataSource;", "", "fileMetadataRequest", "Lcom/box/android/data/api/requests/FileMetadataRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/FileMetadataRequest;Lcom/squareup/moshi/Moshi;)V", "listFileMetadata", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/FileMetadataInstanceDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "fileId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeCaptureMetadataIfPresent", "", "addFileProperties", "properties", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileMetadataRemoteDataSource {
    public static final String SCOPE_GLOBAL = "global";
    public static final String TEMPLATE_CAPTURE_METADATA = "boxCaptureV1";
    private final FileMetadataRequest fileMetadataRequest;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.FileMetadataRemoteDataSource$addFileProperties$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileMetadataRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.FileMetadataRemoteDataSource", f = "FileMetadataRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {69}, m = "addFileProperties", n = {"fileId", "properties", "$i$f$resultOf", "$i$a$-resultOf-FileMetadataRemoteDataSource$addFileProperties$apiResult$1"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileMetadataRemoteDataSource.this.addFileProperties(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.FileMetadataRemoteDataSource$listFileMetadata$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileMetadataRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.FileMetadataRemoteDataSource", f = "FileMetadataRemoteDataSource.kt", i = {0, 0, 0}, l = {24}, m = "listFileMetadata", n = {"fileId", "$i$f$resultOf", "$i$a$-resultOf-FileMetadataRemoteDataSource$listFileMetadata$apiResult$1"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C11481 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11481(Continuation<? super C11481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileMetadataRemoteDataSource.this.listFileMetadata(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.FileMetadataRemoteDataSource$removeCaptureMetadataIfPresent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileMetadataRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.FileMetadataRemoteDataSource", f = "FileMetadataRemoteDataSource.kt", i = {0, 0, 0}, l = {41}, m = "removeCaptureMetadataIfPresent", n = {"fileId", "$i$f$resultOf", "$i$a$-resultOf-FileMetadataRemoteDataSource$removeCaptureMetadataIfPresent$apiResult$1"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C11491 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11491(Continuation<? super C11491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileMetadataRemoteDataSource.this.removeCaptureMetadataIfPresent(null, this);
        }
    }

    @Inject
    public FileMetadataRemoteDataSource(FileMetadataRequest fileMetadataRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(fileMetadataRequest, "fileMetadataRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.fileMetadataRequest = fileMetadataRequest;
        this.moshi = moshi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object listFileMetadata(String str, Continuation<? super Result<? extends List<FileMetadataInstanceDTO>, ? extends RemoteError>> continuation) {
        C11481 c11481;
        Result error;
        if (continuation instanceof C11481) {
            c11481 = (C11481) continuation;
            if ((c11481.label & Integer.MIN_VALUE) != 0) {
                c11481.label -= Integer.MIN_VALUE;
            } else {
                c11481 = new C11481(continuation);
            }
        } else {
            c11481 = new C11481(continuation);
        }
        Object objListFileMetadata = c11481.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11481.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objListFileMetadata);
                FileMetadataRequest fileMetadataRequest = this.fileMetadataRequest;
                c11481.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11481.I$0 = 0;
                c11481.I$1 = 0;
                c11481.label = 1;
                objListFileMetadata = fileMetadataRequest.listFileMetadata(str, c11481);
                if (objListFileMetadata == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11481.I$1;
                int i3 = c11481.I$0;
                ResultKt.throwOnFailure(objListFileMetadata);
            }
            error = new Result.Success((FileMetadataListDTO) objListFileMetadata);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return new Result.Success(((FileMetadataListDTO) ((Result.Success) error).getValue()).getEntries());
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object removeCaptureMetadataIfPresent(String str, Continuation<? super Result<Unit, ? extends RemoteError>> continuation) {
        C11491 c11491;
        Result error;
        if (continuation instanceof C11491) {
            c11491 = (C11491) continuation;
            if ((c11491.label & Integer.MIN_VALUE) != 0) {
                c11491.label -= Integer.MIN_VALUE;
            } else {
                c11491 = new C11491(continuation);
            }
        } else {
            c11491 = new C11491(continuation);
        }
        Object obj = c11491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11491.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FileMetadataRequest fileMetadataRequest = this.fileMetadataRequest;
                c11491.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11491.I$0 = 0;
                c11491.I$1 = 0;
                c11491.label = 1;
                if (fileMetadataRequest.removeFileMetadata(str, "global", TEMPLATE_CAPTURE_METADATA, c11491) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11491.I$1;
                int i3 = c11491.I$0;
                ResultKt.throwOnFailure(obj);
            }
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return new Result.Success(Unit.INSTANCE);
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        RemoteError remoteErrorFromApiException = ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi);
        if (remoteErrorFromApiException instanceof RemoteError.NotFound) {
            return new Result.Success(Unit.INSTANCE);
        }
        return new Result.Error(remoteErrorFromApiException);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object addFileProperties(String str, Map<String, String> map, Continuation<? super Result<Unit, ? extends RemoteError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result error;
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
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (map.isEmpty()) {
                    return new Result.Success(Unit.INSTANCE);
                }
                FileMetadataRequest fileMetadataRequest = this.fileMetadataRequest;
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(map);
                anonymousClass2.I$0 = 0;
                anonymousClass2.I$1 = 0;
                anonymousClass2.label = 1;
                if (fileMetadataRequest.addFileMetadata(str, "global", TEMPLATE_CAPTURE_METADATA, map, anonymousClass2) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass2.I$1;
                int i3 = anonymousClass2.I$0;
                ResultKt.throwOnFailure(obj);
            }
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return new Result.Success(Unit.INSTANCE);
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }
}
