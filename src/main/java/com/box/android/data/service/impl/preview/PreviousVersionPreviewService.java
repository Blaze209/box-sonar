package com.box.android.data.service.impl.preview;

import com.amplitude.api.Constants;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.FilePreviewDomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.RepresentationType;
import com.box.android.domain.models.preview.FileVersionRepresentationsModel;
import com.box.android.domain.models.preview.PreviewData;
import com.box.android.domain.models.preview.PreviewerType;
import com.box.android.domain.preview.PreviewerMapping;
import com.box.android.domain.preview.PreviewerTypeResolver;
import com.box.android.domain.services.IPreviousVersionPreviewService;
import com.box.android.domain.services.IRepresentationsService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxRepresentation;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PreviousVersionPreviewService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J:\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0016J:\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/service/impl/preview/PreviousVersionPreviewService;", "Lcom/box/android/domain/services/IPreviousVersionPreviewService;", "representationsService", "Lcom/box/android/domain/services/IRepresentationsService;", "previewerTypeResolver", "Lcom/box/android/domain/preview/PreviewerTypeResolver;", "<init>", "(Lcom/box/android/domain/services/IRepresentationsService;Lcom/box/android/domain/preview/PreviewerTypeResolver;)V", "getPreviousVersionPreviewData", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/preview/PreviewData;", "Lcom/box/android/domain/models/DomainError;", "fileId", "Lcom/box/android/domain/models/ItemId;", Constants.AMP_PLAN_VERSION_ID, "", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadRepresentation", BoxRepresentation.FIELD_REPRESENTATION, "Lcom/box/android/domain/models/RepresentationModel;", "previewerType", "Lcom/box/android/domain/models/preview/PreviewerType;", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lcom/box/android/domain/models/RepresentationModel;Lcom/box/android/domain/models/preview/PreviewerType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadOriginal", "previewerMapping", "Lcom/box/android/domain/preview/PreviewerMapping;", "fileVersionRepresentationsModel", "Lcom/box/android/domain/models/preview/FileVersionRepresentationsModel;", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lcom/box/android/domain/preview/PreviewerMapping;Lcom/box/android/domain/models/preview/FileVersionRepresentationsModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviousVersionPreviewService implements IPreviousVersionPreviewService {
    private final PreviewerTypeResolver previewerTypeResolver;
    private final IRepresentationsService representationsService;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.PreviousVersionPreviewService$downloadOriginal$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviousVersionPreviewService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.PreviousVersionPreviewService", f = "PreviousVersionPreviewService.kt", i = {0, 0, 0, 0, 0, 0}, l = {115}, m = "downloadOriginal", n = {"fileId", Constants.AMP_PLAN_VERSION_ID, "previewerMapping", "fileVersionRepresentationsModel", BoxRepresentation.FIELD_REPRESENTATION, "$i$a$-let-PreviousVersionPreviewService$downloadOriginal$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return PreviousVersionPreviewService.this.downloadOriginal(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.PreviousVersionPreviewService$downloadRepresentation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviousVersionPreviewService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.PreviousVersionPreviewService", f = "PreviousVersionPreviewService.kt", i = {0, 0, 0, 0}, l = {90}, m = "downloadRepresentation", n = {"fileId", Constants.AMP_PLAN_VERSION_ID, BoxRepresentation.FIELD_REPRESENTATION, "previewerType"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C15571 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C15571(Continuation<? super C15571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviousVersionPreviewService.this.downloadRepresentation(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.PreviousVersionPreviewService$getPreviousVersionPreviewData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviousVersionPreviewService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.PreviousVersionPreviewService", f = "PreviousVersionPreviewService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {31, 42, 47, 55}, m = "getPreviousVersionPreviewData", n = {"fileId", Constants.AMP_PLAN_VERSION_ID, "fileId", Constants.AMP_PLAN_VERSION_ID, "$this$flatMap$iv", "fileVersionRepresentationsModel", "lastError", "previewers", "previewerMapping", "previewerContent", "$i$f$flatMap", "$i$a$-flatMap-PreviousVersionPreviewService$getPreviousVersionPreviewData$2", "fileId", Constants.AMP_PLAN_VERSION_ID, "$this$flatMap$iv", "fileVersionRepresentationsModel", "lastError", "previewers", "previewerMapping", "previewerContent", BoxRepresentation.FIELD_REPRESENTATION, "$i$f$flatMap", "$i$a$-flatMap-PreviousVersionPreviewService$getPreviousVersionPreviewData$2", "fileId", Constants.AMP_PLAN_VERSION_ID, "$this$flatMap$iv", "fileVersionRepresentationsModel", "lastError", "previewers", "previewerMapping", "previewerContent", BoxRepresentation.FIELD_REPRESENTATION, "$i$f$flatMap", "$i$a$-flatMap-PreviousVersionPreviewService$getPreviousVersionPreviewData$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "I$0", "I$1"}, v = 1)
    static final class C15581 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C15581(Continuation<? super C15581> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviousVersionPreviewService.this.getPreviousVersionPreviewData(null, null, this);
        }
    }

    @Inject
    public PreviousVersionPreviewService(IRepresentationsService representationsService, PreviewerTypeResolver previewerTypeResolver) {
        Intrinsics.checkNotNullParameter(representationsService, "representationsService");
        Intrinsics.checkNotNullParameter(previewerTypeResolver, "previewerTypeResolver");
        this.representationsService = representationsService;
        this.previewerTypeResolver = previewerTypeResolver;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0139  */
    /* JADX WARN: Code duplicated, block: B:35:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:37:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:40:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:43:0x0201  */
    /* JADX WARN: Code duplicated, block: B:44:0x0212  */
    /* JADX WARN: Code duplicated, block: B:47:0x021a  */
    /* JADX WARN: Code duplicated, block: B:49:0x021e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0240  */
    /* JADX WARN: Code duplicated, block: B:55:0x0286  */
    /* JADX WARN: Code duplicated, block: B:65:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [T, com.box.android.domain.models.FilePreviewDomainError$RepresentationStatusError] */
    /* JADX WARN: Type inference failed for: r0v18, types: [T, com.box.android.domain.models.RepresentationModel] */
    /* JADX WARN: Type inference failed for: r14v4, types: [T, com.box.android.domain.models.RepresentationModel] */
    /* JADX WARN: Type inference failed for: r3v20, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x021e -> B:26:0x0133). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0286 -> B:56:0x0291). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.box.android.domain.services.IPreviousVersionPreviewService
    public java.lang.Object getPreviousVersionPreviewData(com.box.android.domain.models.ItemId r20, java.lang.String r21, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.preview.PreviewData, ? extends com.box.android.domain.models.DomainError>> r22) {
        /*
            Method dump skipped, instruction units count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.preview.PreviousVersionPreviewService.getPreviousVersionPreviewData(com.box.android.domain.models.ItemId, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object downloadRepresentation(ItemId itemId, String str, RepresentationModel representationModel, PreviewerType previewerType, Continuation<? super Result<PreviewData, ? extends DomainError>> continuation) throws URISyntaxException {
        C15571 c15571;
        PreviewerType previewerType2;
        if (continuation instanceof C15571) {
            c15571 = (C15571) continuation;
            if ((c15571.label & Integer.MIN_VALUE) != 0) {
                c15571.label -= Integer.MIN_VALUE;
            } else {
                c15571 = new C15571(continuation);
            }
        } else {
            c15571 = new C15571(continuation);
        }
        Object objDownloadPreviewRepresentation = c15571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15571.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDownloadPreviewRepresentation);
            if (representationModel.getRepresentationType() == RepresentationType.DASH) {
                URI uriCreate = URI.create(StringsKt.replace$default(representationModel.getContentUrlTemplate(), "{+asset_path}", "manifest.mpd", false, 4, (Object) null));
                Intrinsics.checkNotNull(uriCreate);
                return new Result.Success(new PreviewData(uriCreate, previewerType, false));
            }
            IRepresentationsService iRepresentationsService = this.representationsService;
            c15571.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            c15571.L$1 = SpillingKt.nullOutSpilledVariable(str);
            c15571.L$2 = SpillingKt.nullOutSpilledVariable(representationModel);
            c15571.L$3 = previewerType;
            c15571.label = 1;
            objDownloadPreviewRepresentation = iRepresentationsService.downloadPreviewRepresentation(itemId, str, representationModel, c15571);
            if (objDownloadPreviewRepresentation == coroutine_suspended) {
                return coroutine_suspended;
            }
            previewerType2 = previewerType;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            previewerType2 = (PreviewerType) c15571.L$3;
            ResultKt.throwOnFailure(objDownloadPreviewRepresentation);
        }
        Result result = (Result) objDownloadPreviewRepresentation;
        if (result instanceof Result.Success) {
            URI uri = ((URL) ((Result.Success) result).getValue()).toURI();
            Intrinsics.checkNotNullExpressionValue(uri, "toURI(...)");
            return new Result.Success(new PreviewData(uri, previewerType2, false));
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object downloadOriginal(ItemId itemId, String str, PreviewerMapping previewerMapping, FileVersionRepresentationsModel fileVersionRepresentationsModel, Continuation<? super Result<PreviewData, ? extends DomainError>> continuation) throws URISyntaxException {
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
        Object objDownloadPreviewRepresentation = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDownloadPreviewRepresentation);
            RepresentationModel originalPdfRepresentationModel = FileVersionRepresentationsModel.INSTANCE.getOriginalPdfRepresentationModel(fileVersionRepresentationsModel.getFileDownloadUrl(), fileVersionRepresentationsModel.getFileName());
            if (originalPdfRepresentationModel != null) {
                IRepresentationsService iRepresentationsService = this.representationsService;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$2 = previewerMapping;
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(fileVersionRepresentationsModel);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(originalPdfRepresentationModel);
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 1;
                objDownloadPreviewRepresentation = iRepresentationsService.downloadPreviewRepresentation(itemId, str, originalPdfRepresentationModel, anonymousClass1);
                if (objDownloadPreviewRepresentation == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return new Result.Error(new FilePreviewDomainError.NotSupportedTypeError(null, 1, null));
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = anonymousClass1.I$0;
        previewerMapping = (PreviewerMapping) anonymousClass1.L$2;
        ResultKt.throwOnFailure(objDownloadPreviewRepresentation);
        Result.Success success = (Result) objDownloadPreviewRepresentation;
        if (success instanceof Result.Success) {
            URI uri = ((URL) ((Result.Success) success).getValue()).toURI();
            Intrinsics.checkNotNullExpressionValue(uri, "toURI(...)");
            success = new Result.Success(new PreviewData(uri, previewerMapping.getType(), false));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success != null) {
            return success;
        }
        return new Result.Error(new FilePreviewDomainError.NotSupportedTypeError(null, 1, null));
    }
}
