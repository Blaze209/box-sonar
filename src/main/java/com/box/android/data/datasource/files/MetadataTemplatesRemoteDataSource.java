package com.box.android.data.datasource.files;

import com.box.android.data.api.models.MetadataTemplateDTO;
import com.box.android.data.api.models.MetadataTemplatesListDTO;
import com.box.android.data.api.requests.MetadataTemplatesRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.Moshi;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetadataTemplatesRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f0\tH\u0086@¢\u0006\u0002\u0010\rJ \u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f0\tH\u0086@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/datasource/files/MetadataTemplatesRemoteDataSource;", "", "metadataTemplatesRequest", "Lcom/box/android/data/api/requests/MetadataTemplatesRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/MetadataTemplatesRequest;Lcom/squareup/moshi/Moshi;)V", "listGlobalMetadataTemplates", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/MetadataTemplateDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listEnterpriseMetadataTemplates", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MetadataTemplatesRemoteDataSource {
    private final MetadataTemplatesRequest metadataTemplatesRequest;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.MetadataTemplatesRemoteDataSource$listEnterpriseMetadataTemplates$1, reason: invalid class name */
    /* JADX INFO: compiled from: MetadataTemplatesRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.MetadataTemplatesRemoteDataSource", f = "MetadataTemplatesRemoteDataSource.kt", i = {0, 0}, l = {31}, m = "listEnterpriseMetadataTemplates", n = {"$i$f$resultOf", "$i$a$-resultOf-MetadataTemplatesRemoteDataSource$listEnterpriseMetadataTemplates$2"}, s = {"I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataTemplatesRemoteDataSource.this.listEnterpriseMetadataTemplates(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.MetadataTemplatesRemoteDataSource$listGlobalMetadataTemplates$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MetadataTemplatesRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.MetadataTemplatesRemoteDataSource", f = "MetadataTemplatesRemoteDataSource.kt", i = {0, 0}, l = {22}, m = "listGlobalMetadataTemplates", n = {"$i$f$resultOf", "$i$a$-resultOf-MetadataTemplatesRemoteDataSource$listGlobalMetadataTemplates$2"}, s = {"I$0", "I$1"}, v = 1)
    static final class C11501 extends ContinuationImpl {
        int I$0;
        int I$1;
        int label;
        /* synthetic */ Object result;

        C11501(Continuation<? super C11501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetadataTemplatesRemoteDataSource.this.listGlobalMetadataTemplates(this);
        }
    }

    @Inject
    public MetadataTemplatesRemoteDataSource(MetadataTemplatesRequest metadataTemplatesRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(metadataTemplatesRequest, "metadataTemplatesRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.metadataTemplatesRequest = metadataTemplatesRequest;
        this.moshi = moshi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object listGlobalMetadataTemplates(Continuation<? super Result<? extends List<MetadataTemplateDTO>, ? extends RemoteError>> continuation) {
        C11501 c11501;
        Result.Error error;
        if (continuation instanceof C11501) {
            c11501 = (C11501) continuation;
            if ((c11501.label & Integer.MIN_VALUE) != 0) {
                c11501.label -= Integer.MIN_VALUE;
            } else {
                c11501 = new C11501(continuation);
            }
        } else {
            c11501 = new C11501(continuation);
        }
        Object objListGlobalMetadataTemplates$default = c11501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11501.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objListGlobalMetadataTemplates$default);
                MetadataTemplatesRequest metadataTemplatesRequest = this.metadataTemplatesRequest;
                c11501.I$0 = 0;
                c11501.I$1 = 0;
                c11501.label = 1;
                objListGlobalMetadataTemplates$default = MetadataTemplatesRequest.listGlobalMetadataTemplates$default(metadataTemplatesRequest, 0, c11501, 1, null);
                if (objListGlobalMetadataTemplates$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11501.I$1;
                int i3 = c11501.I$0;
                ResultKt.throwOnFailure(objListGlobalMetadataTemplates$default);
            }
            error = new Result.Success((MetadataTemplatesListDTO) objListGlobalMetadataTemplates$default);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            error = new Result.Success(((MetadataTemplatesListDTO) ((Result.Success) error).getValue()).getEntries());
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "listGlobalMetadataTemplates failed: " + exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object listEnterpriseMetadataTemplates(Continuation<? super Result<? extends List<MetadataTemplateDTO>, ? extends RemoteError>> continuation) {
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
        Object objListEnterpriseMetadataTemplates$default = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objListEnterpriseMetadataTemplates$default);
                MetadataTemplatesRequest metadataTemplatesRequest = this.metadataTemplatesRequest;
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                objListEnterpriseMetadataTemplates$default = MetadataTemplatesRequest.listEnterpriseMetadataTemplates$default(metadataTemplatesRequest, 0, anonymousClass1, 1, null);
                if (objListEnterpriseMetadataTemplates$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(objListEnterpriseMetadataTemplates$default);
            }
            error = new Result.Success((MetadataTemplatesListDTO) objListEnterpriseMetadataTemplates$default);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            error = new Result.Success(((MetadataTemplatesListDTO) ((Result.Success) error).getValue()).getEntries());
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "listEnterpriseMetadataTemplates failed: " + exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }
}
