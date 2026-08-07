package com.box.android.data.service.impl.preview.helpers.download;

import com.box.android.data.datasource.PreviewDownloadRemoteDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.service.impl.DomainErrorMapper;
import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewData;
import com.box.android.domain.models.preview.PreviewerType;
import com.box.android.domain.utils.result.Result;
import java.net.URI;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewDownloadOriginalWrapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J4\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/service/impl/preview/helpers/download/PreviewDownloadOriginalWrapper;", "", "observability", "Lcom/box/android/domain/metrics/preview/PreviewObservability;", "previewDownloadDataSource", "Lcom/box/android/data/datasource/PreviewDownloadRemoteDataSource;", "<init>", "(Lcom/box/android/domain/metrics/preview/PreviewObservability;Lcom/box/android/data/datasource/PreviewDownloadRemoteDataSource;)V", "downloadFilePreview", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/preview/PreviewData;", "Lcom/box/android/domain/models/DomainError;", "observabilityId", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewerType", "Lcom/box/android/domain/models/preview/PreviewerType;", "(Ljava/lang/String;Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/preview/PreviewerType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performDownload", "Ljava/net/URI;", "(Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewDownloadOriginalWrapper {
    private final PreviewObservability observability;
    private final PreviewDownloadRemoteDataSource previewDownloadDataSource;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.helpers.download.PreviewDownloadOriginalWrapper$downloadFilePreview$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewDownloadOriginalWrapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.helpers.download.PreviewDownloadOriginalWrapper", f = "PreviewDownloadOriginalWrapper.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {31, 33, 36}, m = "downloadFilePreview", n = {"observabilityId", "fileModel", "previewerType", "observabilityId", "fileModel", "previewerType", "$this$map$iv", "it", "$i$f$map", "$i$a$-map-PreviewDownloadOriginalWrapper$downloadFilePreview$2", "observabilityId", "fileModel", "previewerType", "$this$onError$iv", "error", "$i$f$onError", "$i$a$-onError-PreviewDownloadOriginalWrapper$downloadFilePreview$3"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewDownloadOriginalWrapper.this.downloadFilePreview(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.helpers.download.PreviewDownloadOriginalWrapper$performDownload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewDownloadOriginalWrapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.helpers.download.PreviewDownloadOriginalWrapper", f = "PreviewDownloadOriginalWrapper.kt", i = {0}, l = {40}, m = "performDownload", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C15591 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C15591(Continuation<? super C15591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewDownloadOriginalWrapper.this.performDownload(null, this);
        }
    }

    @Inject
    public PreviewDownloadOriginalWrapper(PreviewObservability observability, PreviewDownloadRemoteDataSource previewDownloadDataSource) {
        Intrinsics.checkNotNullParameter(observability, "observability");
        Intrinsics.checkNotNullParameter(previewDownloadDataSource, "previewDownloadDataSource");
        this.observability = observability;
        this.previewDownloadDataSource = previewDownloadDataSource;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:40:0x0122  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object downloadFilePreview(String str, FileModel fileModel, PreviewerType previewerType, Continuation<? super Result<PreviewData, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Success success;
        String str2;
        URI uri;
        FileModel fileModel2;
        PreviewerType previewerType2;
        DomainError domainError;
        PreviewObservability previewObservability;
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
        Object objPerformDownload = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objPerformDownload);
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(fileModel);
            anonymousClass1.L$2 = previewerType;
            anonymousClass1.label = 1;
            objPerformDownload = performDownload(fileModel, anonymousClass1);
            if (objPerformDownload != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            previewerType = (PreviewerType) anonymousClass1.L$2;
            fileModel = (FileModel) anonymousClass1.L$1;
            str = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objPerformDownload);
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                Result result = (Result) anonymousClass1.L$3;
                ResultKt.throwOnFailure(objPerformDownload);
                return result;
            }
            int i4 = anonymousClass1.I$1;
            int i5 = anonymousClass1.I$0;
            uri = (URI) anonymousClass1.L$4;
            previewerType2 = (PreviewerType) anonymousClass1.L$2;
            fileModel2 = (FileModel) anonymousClass1.L$1;
            str2 = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objPerformDownload);
        }
        success = new Result.Success(new PreviewData(uri, previewerType2, false));
        FileModel fileModel3 = fileModel2;
        previewerType = previewerType2;
        fileModel = fileModel3;
        str = str2;
        if (!(success instanceof Result.Success)) {
            if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            domainError = (DomainError) ((Result.Error) success).getValue();
            previewObservability = this.observability;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(fileModel);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(previewerType);
            anonymousClass1.L$3 = success;
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(domainError);
            anonymousClass1.I$0 = 0;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 3;
            if (previewObservability.previewFileDownloadError(str, PreviewObservability.ORIGINAL_CONTENT_TYPE, domainError, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return success;
        success = (Result) objPerformDownload;
        if (success instanceof Result.Success) {
            URI uri2 = (URI) ((Result.Success) success).getValue();
            PreviewObservability previewObservability2 = this.observability;
            PreviewObservability.LoadingSource loadingSource = PreviewObservability.LoadingSource.REMOTE;
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(fileModel);
            anonymousClass1.L$2 = previewerType;
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(success);
            anonymousClass1.L$4 = uri2;
            anonymousClass1.I$0 = 0;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 2;
            if (previewObservability2.previewFileDownloadSuccess(str, PreviewObservability.ORIGINAL_CONTENT_TYPE, loadingSource, anonymousClass1) != coroutine_suspended) {
                str2 = str;
                uri = uri2;
                PreviewerType previewerType3 = previewerType;
                fileModel2 = fileModel;
                previewerType2 = previewerType3;
                success = new Result.Success(new PreviewData(uri, previewerType2, false));
                FileModel fileModel4 = fileModel2;
                previewerType = previewerType2;
                fileModel = fileModel4;
                str = str2;
                if (!(success instanceof Result.Success)) {
                    if (!(success instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    domainError = (DomainError) ((Result.Error) success).getValue();
                    previewObservability = this.observability;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(fileModel);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(previewerType);
                    anonymousClass1.L$3 = success;
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(domainError);
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.label = 3;
                    if (previewObservability.previewFileDownloadError(str, PreviewObservability.ORIGINAL_CONTENT_TYPE, domainError, anonymousClass1) == coroutine_suspended) {
                    }
                }
                return success;
            }
        } else {
            if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(success instanceof Result.Success)) {
                if (!(success instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                domainError = (DomainError) ((Result.Error) success).getValue();
                previewObservability = this.observability;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(fileModel);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(previewerType);
                anonymousClass1.L$3 = success;
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(domainError);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 3;
                if (previewObservability.previewFileDownloadError(str, PreviewObservability.ORIGINAL_CONTENT_TYPE, domainError, anonymousClass1) == coroutine_suspended) {
                }
            }
            return success;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object performDownload(FileModel fileModel, Continuation<? super Result<URI, ? extends DomainError>> continuation) {
        C15591 c15591;
        if (continuation instanceof C15591) {
            c15591 = (C15591) continuation;
            if ((c15591.label & Integer.MIN_VALUE) != 0) {
                c15591.label -= Integer.MIN_VALUE;
            } else {
                c15591 = new C15591(continuation);
            }
        } else {
            c15591 = new C15591(continuation);
        }
        Object objDownloadOriginalPreview = c15591.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15591.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDownloadOriginalPreview);
            PreviewDownloadRemoteDataSource previewDownloadRemoteDataSource = this.previewDownloadDataSource;
            c15591.L$0 = fileModel;
            c15591.label = 1;
            objDownloadOriginalPreview = previewDownloadRemoteDataSource.downloadOriginalPreview(fileModel, c15591);
            if (objDownloadOriginalPreview == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c15591.L$0;
            ResultKt.throwOnFailure(objDownloadOriginalPreview);
        }
        Result.Success success = (Result) objDownloadOriginalPreview;
        if (success instanceof Result.Success) {
            URI uri = (URI) ((Result.Success) success).getValue();
            ItemId itemId = fileModel.getItemId();
            if (uri == null) {
                return new Result.Error(new DomainError.CacheReadError("Error when fetching cached preview for file with id " + itemId));
            }
            success = new Result.Success(uri);
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) success).getValue(), null, 2, null));
    }
}
