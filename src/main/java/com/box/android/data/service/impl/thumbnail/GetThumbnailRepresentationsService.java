package com.box.android.data.service.impl.thumbnail;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.services.IRepresentationsService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxRepresentation;
import java.net.URL;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: GetThumbnailRepresentationsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/service/impl/thumbnail/GetThumbnailRepresentationsService;", "", "representationService", "Lcom/box/android/domain/services/IRepresentationsService;", "<init>", "(Lcom/box/android/domain/services/IRepresentationsService;)V", "downloadThumbnail", "Lcom/box/android/domain/utils/result/Result;", "Ljava/net/URL;", "Lcom/box/android/domain/models/DomainError;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "isLargeThumbnailNeeded", "", "destinationUrl", "(Lcom/box/android/domain/models/item/FileModel;ZLjava/net/URL;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "thumbnailDimension", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetThumbnailRepresentationsService {
    private final IRepresentationsService representationService;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.thumbnail.GetThumbnailRepresentationsService$downloadThumbnail$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetThumbnailRepresentationsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.thumbnail.GetThumbnailRepresentationsService", f = "GetThumbnailRepresentationsService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {18, 21, 26}, m = "downloadThumbnail", n = {"fileModel", "destinationUrl", BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_DIMENSIONS, "isLargeThumbnailNeeded", "fileModel", "destinationUrl", BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_DIMENSIONS, "isLargeThumbnailNeeded", "fileModel", "destinationUrl", BoxRepresentation.BoxRepPropertiesMap.FIELD_PROPERTIES_DIMENSIONS, "representationModels", "thumbnailRep", "it", "isLargeThumbnailNeeded", "$i$a$-let-GetThumbnailRepresentationsService$downloadThumbnail$2"}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetThumbnailRepresentationsService.this.downloadThumbnail(null, false, null, this);
        }
    }

    @Inject
    public GetThumbnailRepresentationsService(IRepresentationsService representationService) {
        Intrinsics.checkNotNullParameter(representationService, "representationService");
        this.representationService = representationService;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:38:0x012f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0134  */
    /* JADX WARN: Code duplicated, block: B:42:0x0136 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x00fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:? A[LOOP:0: B:28:0x00df->B:47:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object downloadThumbnail(FileModel fileModel, boolean z, URL url, Continuation<? super Result<URL, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Object objFetchFileRepresentations;
        boolean z2;
        String str;
        URL url2;
        Object objFirstOrNull;
        List list;
        FileModel fileModel2;
        Result result;
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
        Object objDownloadThumbnailRepresentation = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        RepresentationModel representationModel = null;
        Object obj = null;
        if (i == 0) {
            ResultKt.throwOnFailure(objDownloadThumbnailRepresentation);
            String strThumbnailDimension = thumbnailDimension(z);
            anonymousClass1.L$0 = fileModel;
            anonymousClass1.L$1 = url;
            anonymousClass1.L$2 = strThumbnailDimension;
            anonymousClass1.Z$0 = z;
            anonymousClass1.label = 1;
            objFetchFileRepresentations = this.representationService.fetchFileRepresentations(fileModel, "[jpg?dimensions=" + strThumbnailDimension + "]", anonymousClass1);
            if (objFetchFileRepresentations != coroutine_suspended) {
                z2 = z;
                str = strThumbnailDimension;
                url2 = url;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            boolean z3 = anonymousClass1.Z$0;
            String str2 = (String) anonymousClass1.L$2;
            URL url3 = (URL) anonymousClass1.L$1;
            FileModel fileModel3 = (FileModel) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objDownloadThumbnailRepresentation);
            str = str2;
            fileModel = fileModel3;
            objFetchFileRepresentations = objDownloadThumbnailRepresentation;
            url2 = url3;
            z2 = z3;
        } else {
            if (i == 2) {
                boolean z4 = anonymousClass1.Z$0;
                str = (String) anonymousClass1.L$2;
                URL url4 = (URL) anonymousClass1.L$1;
                FileModel fileModel4 = (FileModel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objDownloadThumbnailRepresentation);
                z2 = z4;
                fileModel = fileModel4;
                objFirstOrNull = objDownloadThumbnailRepresentation;
                url2 = url4;
                list = (List) objFirstOrNull;
                if (list != null) {
                    for (Object obj2 : list) {
                        if (Intrinsics.areEqual(((RepresentationModel) obj2).getProperties().getDimensions(), str)) {
                            obj = obj2;
                            break;
                        }
                    }
                    representationModel = (RepresentationModel) obj;
                }
                if (representationModel != null) {
                    IRepresentationsService iRepresentationsService = this.representationService;
                    anonymousClass1.L$0 = fileModel;
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(list);
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(representationModel);
                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(representationModel);
                    anonymousClass1.Z$0 = z2;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.label = 3;
                    objDownloadThumbnailRepresentation = iRepresentationsService.downloadThumbnailRepresentation(fileModel, representationModel, url2, anonymousClass1);
                    if (objDownloadThumbnailRepresentation != coroutine_suspended) {
                        fileModel2 = fileModel;
                    }
                    return coroutine_suspended;
                }
                return new Result.Error(new DomainError.NoResultFoundError("Representation not found for extension:" + CommonBoxUtil.getFileExtension(fileModel.getName(), "")));
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$0;
            boolean z5 = anonymousClass1.Z$0;
            fileModel2 = (FileModel) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objDownloadThumbnailRepresentation);
        }
        result = (Result) objDownloadThumbnailRepresentation;
        if (result == null) {
            return result;
        }
        fileModel = fileModel2;
        return new Result.Error(new DomainError.NoResultFoundError("Representation not found for extension:" + CommonBoxUtil.getFileExtension(fileModel.getName(), "")));
        GetThumbnailRepresentationsService$downloadThumbnail$representationModels$1 getThumbnailRepresentationsService$downloadThumbnail$representationModels$1 = new GetThumbnailRepresentationsService$downloadThumbnail$representationModels$1(str, null);
        anonymousClass1.L$0 = fileModel;
        anonymousClass1.L$1 = url2;
        anonymousClass1.L$2 = str;
        anonymousClass1.Z$0 = z2;
        anonymousClass1.label = 2;
        objFirstOrNull = FlowKt.firstOrNull((Flow) objFetchFileRepresentations, getThumbnailRepresentationsService$downloadThumbnail$representationModels$1, anonymousClass1);
        if (objFirstOrNull != coroutine_suspended) {
            list = (List) objFirstOrNull;
            if (list != null) {
                while (r4.hasNext()) {
                    if (Intrinsics.areEqual(((RepresentationModel) obj2).getProperties().getDimensions(), str)) {
                        obj = obj2;
                        break;
                    }
                }
                representationModel = (RepresentationModel) obj;
            }
            if (representationModel != null) {
                IRepresentationsService iRepresentationsService2 = this.representationService;
                anonymousClass1.L$0 = fileModel;
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(list);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(representationModel);
                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(representationModel);
                anonymousClass1.Z$0 = z2;
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 3;
                objDownloadThumbnailRepresentation = iRepresentationsService2.downloadThumbnailRepresentation(fileModel, representationModel, url2, anonymousClass1);
                if (objDownloadThumbnailRepresentation != coroutine_suspended) {
                    fileModel2 = fileModel;
                    result = (Result) objDownloadThumbnailRepresentation;
                    if (result == null) {
                        return result;
                    }
                    fileModel = fileModel2;
                }
            }
            return new Result.Error(new DomainError.NoResultFoundError("Representation not found for extension:" + CommonBoxUtil.getFileExtension(fileModel.getName(), "")));
        }
        return coroutine_suspended;
    }

    private final String thumbnailDimension(boolean isLargeThumbnailNeeded) {
        return isLargeThumbnailNeeded ? "320x320" : "160x160";
    }
}
