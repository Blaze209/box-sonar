package com.box.android.data.service.impl.preview.helpers.download;

import com.box.android.data.service.impl.DomainErrorMapper;
import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewData;
import com.box.android.domain.preview.PreviewContentType;
import com.box.android.domain.preview.PreviewerMapping;
import com.box.android.domain.services.IRepresentationsService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxRepresentation;
import java.io.File;
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

/* JADX INFO: compiled from: PreviewDownloadRepresentationWrapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJF\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0086@¢\u0006\u0002\u0010\u0018J*\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/box/android/data/service/impl/preview/helpers/download/PreviewDownloadRepresentationWrapper;", "", "representationsService", "Lcom/box/android/domain/services/IRepresentationsService;", "observability", "Lcom/box/android/domain/metrics/preview/PreviewObservability;", "legacyPreviewController", "Lcom/box/android/domain/controller/IPreviewController;", "<init>", "(Lcom/box/android/domain/services/IRepresentationsService;Lcom/box/android/domain/metrics/preview/PreviewObservability;Lcom/box/android/domain/controller/IPreviewController;)V", "downloadRepresentation", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/preview/PreviewData;", "Lcom/box/android/domain/models/DomainError;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewerMapping", "Lcom/box/android/domain/preview/PreviewerMapping;", "cachedFileURIToReturnIfFailed", "Ljava/net/URI;", BoxRepresentation.FIELD_REPRESENTATION, "Lcom/box/android/domain/models/RepresentationModel;", "observabilityId", "", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/preview/PreviewerMapping;Ljava/net/URI;Lcom/box/android/domain/models/RepresentationModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performDownload", "representationType", "Lcom/box/android/domain/preview/PreviewContentType$Representation;", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/preview/PreviewContentType$Representation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getURIOfCachedPreview", "previewContentType", "Lcom/box/android/domain/preview/PreviewContentType;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewDownloadRepresentationWrapper {
    private final IPreviewController legacyPreviewController;
    private final PreviewObservability observability;
    private final IRepresentationsService representationsService;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.helpers.download.PreviewDownloadRepresentationWrapper$downloadRepresentation$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewDownloadRepresentationWrapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.helpers.download.PreviewDownloadRepresentationWrapper", f = "PreviewDownloadRepresentationWrapper.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {37, 41, 45, 48}, m = "downloadRepresentation", n = {"fileModel", "previewerMapping", "cachedFileURIToReturnIfFailed", BoxRepresentation.FIELD_REPRESENTATION, "observabilityId", "fileModel", "previewerMapping", "cachedFileURIToReturnIfFailed", BoxRepresentation.FIELD_REPRESENTATION, "observabilityId", "$this$map$iv", "downloadedFileUri", "$i$f$map", "$i$a$-map-PreviewDownloadRepresentationWrapper$downloadRepresentation$2", "fileModel", "previewerMapping", "cachedFileURIToReturnIfFailed", BoxRepresentation.FIELD_REPRESENTATION, "observabilityId", "$this$flatMapError$iv", "error", "cachedFileUri", "$i$f$flatMapError", "$i$a$-flatMapError-PreviewDownloadRepresentationWrapper$downloadRepresentation$3", "$i$a$-let-PreviewDownloadRepresentationWrapper$downloadRepresentation$3$1", "fileModel", "previewerMapping", "cachedFileURIToReturnIfFailed", BoxRepresentation.FIELD_REPRESENTATION, "observabilityId", "$this$flatMapError$iv", "error", "$this$downloadRepresentation_u24lambda_u241_u241", "$i$f$flatMapError", "$i$a$-flatMapError-PreviewDownloadRepresentationWrapper$downloadRepresentation$3", "$i$a$-run-PreviewDownloadRepresentationWrapper$downloadRepresentation$3$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewDownloadRepresentationWrapper.this.downloadRepresentation(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.helpers.download.PreviewDownloadRepresentationWrapper$performDownload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewDownloadRepresentationWrapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.helpers.download.PreviewDownloadRepresentationWrapper", f = "PreviewDownloadRepresentationWrapper.kt", i = {0, 0}, l = {57}, m = "performDownload", n = {"fileModel", "representationType"}, s = {"L$0", "L$1"}, v = 1)
    static final class C15601 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C15601(Continuation<? super C15601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewDownloadRepresentationWrapper.this.performDownload(null, null, this);
        }
    }

    @Inject
    public PreviewDownloadRepresentationWrapper(IRepresentationsService representationsService, PreviewObservability observability, IPreviewController legacyPreviewController) {
        Intrinsics.checkNotNullParameter(representationsService, "representationsService");
        Intrinsics.checkNotNullParameter(observability, "observability");
        Intrinsics.checkNotNullParameter(legacyPreviewController, "legacyPreviewController");
        this.representationsService = representationsService;
        this.observability = observability;
        this.legacyPreviewController = legacyPreviewController;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0169 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x016a  */
    /* JADX WARN: Code duplicated, block: B:38:0x016e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0179  */
    /* JADX WARN: Code duplicated, block: B:43:0x01af  */
    /* JADX WARN: Code duplicated, block: B:46:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:49:0x020a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0213  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object downloadRepresentation(FileModel fileModel, PreviewerMapping previewerMapping, URI uri, RepresentationModel representationModel, String str, Continuation<? super Result<PreviewData, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        URI uri2;
        RepresentationModel representationModel2;
        FileModel fileModel2;
        PreviewerMapping previewerMapping2;
        String str2;
        Result.Success success;
        URI uri3;
        RepresentationModel representationModel3;
        String str3;
        URI uri4;
        DomainError domainError;
        PreviewObservability previewObservability;
        String previewContentType;
        DomainError domainError2;
        PreviewObservability previewObservability2;
        String previewContentType2;
        PreviewObservability.LoadingSource loadingSource;
        URI uri5;
        PreviewerMapping previewerMapping3;
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
            PreviewContentType content = previewerMapping.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type com.box.android.domain.preview.PreviewContentType.Representation");
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
            anonymousClass1.L$1 = previewerMapping;
            uri2 = uri;
            anonymousClass1.L$2 = uri2;
            representationModel2 = representationModel;
            anonymousClass1.L$3 = representationModel2;
            anonymousClass1.L$4 = str;
            anonymousClass1.label = 1;
            fileModel2 = fileModel;
            objPerformDownload = performDownload(fileModel2, (PreviewContentType.Representation) content, anonymousClass1);
            if (objPerformDownload != coroutine_suspended) {
                previewerMapping2 = previewerMapping;
                str2 = str;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    int i2 = anonymousClass1.I$2;
                    int i3 = anonymousClass1.I$1;
                    int i4 = anonymousClass1.I$0;
                    uri5 = (URI) anonymousClass1.L$7;
                    previewerMapping3 = (PreviewerMapping) anonymousClass1.L$1;
                    ResultKt.throwOnFailure(objPerformDownload);
                    return new Result.Success(new PreviewData(uri5, previewerMapping3.getType(), true));
                }
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i5 = anonymousClass1.I$2;
                int i6 = anonymousClass1.I$1;
                int i7 = anonymousClass1.I$0;
                domainError2 = (DomainError) anonymousClass1.L$6;
                ResultKt.throwOnFailure(objPerformDownload);
                return new Result.Error(domainError2);
            }
            int i8 = anonymousClass1.I$1;
            int i9 = anonymousClass1.I$0;
            uri4 = (URI) anonymousClass1.L$6;
            str3 = (String) anonymousClass1.L$4;
            representationModel3 = (RepresentationModel) anonymousClass1.L$3;
            uri3 = (URI) anonymousClass1.L$2;
            previewerMapping2 = (PreviewerMapping) anonymousClass1.L$1;
            fileModel2 = (FileModel) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objPerformDownload);
            success = new Result.Success(new PreviewData(uri4, previewerMapping2.getType(), false));
            URI uri6 = uri3;
            representationModel2 = representationModel3;
            uri2 = uri6;
            str2 = str3;
            if (success instanceof Result.Success) {
                return success;
            }
            if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            domainError = (DomainError) ((Result.Error) success).getValue();
            if (uri2 != null) {
                previewObservability2 = this.observability;
                previewContentType2 = PreviewObservability.INSTANCE.toPreviewContentType(representationModel2);
                loadingSource = PreviewObservability.LoadingSource.CACHE;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileModel2);
                anonymousClass1.L$1 = previewerMapping2;
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(uri2);
                anonymousClass1.L$3 = representationModel2;
                anonymousClass1.L$4 = str2;
                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(success);
                anonymousClass1.L$6 = domainError;
                anonymousClass1.L$7 = uri2;
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.I$2 = 0;
                anonymousClass1.label = 3;
                if (previewObservability2.previewFileDownloadSuccess(str2, previewContentType2, loadingSource, anonymousClass1) != coroutine_suspended) {
                    uri5 = uri2;
                    previewerMapping3 = previewerMapping2;
                    return new Result.Success(new PreviewData(uri5, previewerMapping3.getType(), true));
                }
            } else {
                previewObservability = this.observability;
                previewContentType = PreviewObservability.INSTANCE.toPreviewContentType(representationModel2);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileModel2);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(previewerMapping2);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(uri2);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(representationModel2);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(success);
                anonymousClass1.L$6 = domainError;
                anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(this);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.I$2 = 0;
                anonymousClass1.label = 4;
                if (previewObservability.previewFileDownloadError(str2, previewContentType, domainError, anonymousClass1) != coroutine_suspended) {
                    domainError2 = domainError;
                    return new Result.Error(domainError2);
                }
            }
            return coroutine_suspended;
        }
        str2 = (String) anonymousClass1.L$4;
        RepresentationModel representationModel4 = (RepresentationModel) anonymousClass1.L$3;
        URI uri7 = (URI) anonymousClass1.L$2;
        previewerMapping2 = (PreviewerMapping) anonymousClass1.L$1;
        fileModel2 = (FileModel) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objPerformDownload);
        representationModel2 = representationModel4;
        uri2 = uri7;
        success = (Result) objPerformDownload;
        if (success instanceof Result.Success) {
            URI uri8 = (URI) ((Result.Success) success).getValue();
            PreviewObservability previewObservability3 = this.observability;
            String previewContentType3 = PreviewObservability.INSTANCE.toPreviewContentType(representationModel2);
            PreviewObservability.LoadingSource loadingSource2 = PreviewObservability.LoadingSource.REMOTE;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileModel2);
            anonymousClass1.L$1 = previewerMapping2;
            anonymousClass1.L$2 = uri2;
            anonymousClass1.L$3 = representationModel2;
            anonymousClass1.L$4 = str2;
            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(success);
            anonymousClass1.L$6 = uri8;
            anonymousClass1.I$0 = 0;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 2;
            if (previewObservability3.previewFileDownloadSuccess(str2, previewContentType3, loadingSource2, anonymousClass1) != coroutine_suspended) {
                RepresentationModel representationModel5 = representationModel2;
                uri3 = uri2;
                representationModel3 = representationModel5;
                str3 = str2;
                uri4 = uri8;
                success = new Result.Success(new PreviewData(uri4, previewerMapping2.getType(), false));
                URI uri9 = uri3;
                representationModel2 = representationModel3;
                uri2 = uri9;
                str2 = str3;
                if (success instanceof Result.Success) {
                    return success;
                }
                if (!(success instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                domainError = (DomainError) ((Result.Error) success).getValue();
                if (uri2 != null) {
                    previewObservability2 = this.observability;
                    previewContentType2 = PreviewObservability.INSTANCE.toPreviewContentType(representationModel2);
                    loadingSource = PreviewObservability.LoadingSource.CACHE;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileModel2);
                    anonymousClass1.L$1 = previewerMapping2;
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(uri2);
                    anonymousClass1.L$3 = representationModel2;
                    anonymousClass1.L$4 = str2;
                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(success);
                    anonymousClass1.L$6 = domainError;
                    anonymousClass1.L$7 = uri2;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.label = 3;
                    if (previewObservability2.previewFileDownloadSuccess(str2, previewContentType2, loadingSource, anonymousClass1) != coroutine_suspended) {
                        uri5 = uri2;
                        previewerMapping3 = previewerMapping2;
                        return new Result.Success(new PreviewData(uri5, previewerMapping3.getType(), true));
                    }
                } else {
                    previewObservability = this.observability;
                    previewContentType = PreviewObservability.INSTANCE.toPreviewContentType(representationModel2);
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileModel2);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(previewerMapping2);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(uri2);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(representationModel2);
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(str2);
                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(success);
                    anonymousClass1.L$6 = domainError;
                    anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(this);
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.label = 4;
                    if (previewObservability.previewFileDownloadError(str2, previewContentType, domainError, anonymousClass1) != coroutine_suspended) {
                        domainError2 = domainError;
                        return new Result.Error(domainError2);
                    }
                }
            }
        } else {
            if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (success instanceof Result.Success) {
                return success;
            }
            if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            domainError = (DomainError) ((Result.Error) success).getValue();
            if (uri2 != null) {
                previewObservability2 = this.observability;
                previewContentType2 = PreviewObservability.INSTANCE.toPreviewContentType(representationModel2);
                loadingSource = PreviewObservability.LoadingSource.CACHE;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileModel2);
                anonymousClass1.L$1 = previewerMapping2;
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(uri2);
                anonymousClass1.L$3 = representationModel2;
                anonymousClass1.L$4 = str2;
                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(success);
                anonymousClass1.L$6 = domainError;
                anonymousClass1.L$7 = uri2;
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.I$2 = 0;
                anonymousClass1.label = 3;
                if (previewObservability2.previewFileDownloadSuccess(str2, previewContentType2, loadingSource, anonymousClass1) != coroutine_suspended) {
                    uri5 = uri2;
                    previewerMapping3 = previewerMapping2;
                    return new Result.Success(new PreviewData(uri5, previewerMapping3.getType(), true));
                }
            } else {
                previewObservability = this.observability;
                previewContentType = PreviewObservability.INSTANCE.toPreviewContentType(representationModel2);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileModel2);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(previewerMapping2);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(uri2);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(representationModel2);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(success);
                anonymousClass1.L$6 = domainError;
                anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(this);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.I$2 = 0;
                anonymousClass1.label = 4;
                if (previewObservability.previewFileDownloadError(str2, previewContentType, domainError, anonymousClass1) != coroutine_suspended) {
                    domainError2 = domainError;
                    return new Result.Error(domainError2);
                }
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object performDownload(FileModel fileModel, PreviewContentType.Representation representation, Continuation<? super Result<URI, ? extends DomainError>> continuation) {
        C15601 c15601;
        if (continuation instanceof C15601) {
            c15601 = (C15601) continuation;
            if ((c15601.label & Integer.MIN_VALUE) != 0) {
                c15601.label -= Integer.MIN_VALUE;
            } else {
                c15601 = new C15601(continuation);
            }
        } else {
            c15601 = new C15601(continuation);
        }
        Object objDownloadRepresentationToLegacyCache = c15601.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15601.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDownloadRepresentationToLegacyCache);
            IRepresentationsService iRepresentationsService = this.representationsService;
            c15601.L$0 = fileModel;
            c15601.L$1 = representation;
            c15601.label = 1;
            objDownloadRepresentationToLegacyCache = iRepresentationsService.downloadRepresentationToLegacyCache(fileModel, representation, c15601);
            if (objDownloadRepresentationToLegacyCache == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            representation = (PreviewContentType.Representation) c15601.L$1;
            fileModel = (FileModel) c15601.L$0;
            ResultKt.throwOnFailure(objDownloadRepresentationToLegacyCache);
        }
        Result.Success success = (Result) objDownloadRepresentationToLegacyCache;
        if (success instanceof Result.Success) {
            URI uRIOfCachedPreview = getURIOfCachedPreview(fileModel, representation);
            if (uRIOfCachedPreview == null) {
                return new Result.Error(new DomainError.CacheReadError("Error when fetching preview for file with id " + fileModel.getItemId()));
            }
            success = new Result.Success(uRIOfCachedPreview);
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (DomainError) ((Result.Error) success).getValue(), null, 2, null));
    }

    private final URI getURIOfCachedPreview(FileModel fileModel, PreviewContentType previewContentType) {
        File cachedPreviewOnlyFile = this.legacyPreviewController.getStorage().getCachedPreviewOnlyFile(fileModel, (String) null, previewContentType);
        if (cachedPreviewOnlyFile == null || !cachedPreviewOnlyFile.exists()) {
            return null;
        }
        return cachedPreviewOnlyFile.toURI();
    }
}
