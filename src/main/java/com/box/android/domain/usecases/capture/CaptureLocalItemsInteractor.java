package com.box.android.domain.usecases.capture;

import android.net.Uri;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.services.ICaptureHistoryFilesService;
import com.box.android.domain.services.ICaptureThumbnailService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.File;
import java.util.Date;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: CaptureLocalItemsInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ2\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014J2\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J*\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u001aJ\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u001c\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u001dJ*\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/box/android/domain/usecases/capture/CaptureLocalItemsInteractor;", "Lcom/box/android/domain/usecases/capture/CaptureLocalItemsUseCase;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "captureHistoryFilesService", "Lcom/box/android/domain/services/ICaptureHistoryFilesService;", "captureThumbnailService", "Lcom/box/android/domain/services/ICaptureThumbnailService;", "<init>", "(Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/domain/services/ICaptureHistoryFilesService;Lcom/box/android/domain/services/ICaptureThumbnailService;)V", "createFile", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/domain/models/DomainError;", "name", "", IdentificationData.FIELD_PARENT_ID, "Lcom/box/android/domain/models/ItemId;", "contentFile", "Ljava/io/File;", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contentUrl", "Landroid/net/Uri;", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFolder", "Lcom/box/android/domain/models/item/FolderModel;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFolderById", "folderId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFolderByName", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureLocalItemsInteractor implements CaptureLocalItemsUseCase {
    private final ICaptureHistoryFilesService captureHistoryFilesService;
    private final ICaptureThumbnailService captureThumbnailService;
    private final ILocalItemService localItemService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.capture.CaptureLocalItemsInteractor$createFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureLocalItemsInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.capture.CaptureLocalItemsInteractor", f = "CaptureLocalItemsInteractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {34, 37, 47}, m = "createFile", n = {"name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "uploadSource", "tags", "name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "uploadSource", "tags", "$this$onSuccess$iv", "fileModel", "localItemId", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureLocalItemsInteractor$createFile$3", "$i$a$-let-CaptureLocalItemsInteractor$createFile$3$1", "name", IdentificationData.FIELD_PARENT_ID, "contentUrl", "uploadSource", "tags", "$this$onSuccess$iv", "fileModel", "$i$f$onSuccess", "$i$a$-onSuccess-CaptureLocalItemsInteractor$createFile$3"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass2 extends ContinuationImpl {
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

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CaptureLocalItemsInteractor.this.createFile((String) null, (ItemId) null, (Uri) null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.capture.CaptureLocalItemsInteractor$getFolderById$1, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureLocalItemsInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.capture.CaptureLocalItemsInteractor", f = "CaptureLocalItemsInteractor.kt", i = {0}, l = {56}, m = "getFolderById", n = {"folderId"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return CaptureLocalItemsInteractor.this.getFolderById(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.capture.CaptureLocalItemsInteractor$getFolderByName$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureLocalItemsInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.capture.CaptureLocalItemsInteractor", f = "CaptureLocalItemsInteractor.kt", i = {0, 0}, l = {65}, m = "getFolderByName", n = {"name", IdentificationData.FIELD_PARENT_ID}, s = {"L$0", "L$1"}, v = 1)
    static final class C16281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C16281(Continuation<? super C16281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CaptureLocalItemsInteractor.this.getFolderByName(null, null, this);
        }
    }

    @Inject
    public CaptureLocalItemsInteractor(ILocalItemService localItemService, ICaptureHistoryFilesService captureHistoryFilesService, ICaptureThumbnailService captureThumbnailService) {
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(captureHistoryFilesService, "captureHistoryFilesService");
        Intrinsics.checkNotNullParameter(captureThumbnailService, "captureThumbnailService");
        this.localItemService = localItemService;
        this.captureHistoryFilesService = captureHistoryFilesService;
        this.captureThumbnailService = captureThumbnailService;
    }

    @Override // com.box.android.domain.usecases.capture.CaptureLocalItemsUseCase
    public Object createFile(String str, ItemId itemId, File file, Continuation<? super Result<FileModel, ? extends DomainError>> continuation) {
        Uri uri = Uri.parse(file.getPath());
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        return createFile(str, itemId, uri, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x015b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0198  */
    /* JADX WARN: Code duplicated, block: B:45:0x019f  */
    /* JADX WARN: Code duplicated, block: B:48:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:51:0x01af  */
    /* JADX WARN: Code duplicated, block: B:53:0x01f5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // com.box.android.domain.usecases.capture.CaptureLocalItemsUseCase
    public Object createFile(String str, ItemId itemId, Uri uri, Continuation<? super Result<FileModel, ? extends DomainError>> continuation) {
        AnonymousClass2 anonymousClass2;
        ItemId itemId2;
        Uri uri2;
        JobTags.JobSource jobSource;
        Set set;
        String str2;
        Result result;
        FileModel fileModel;
        int i;
        int i2;
        String str3;
        Set set2;
        int i3;
        ItemId itemId3;
        Result result2;
        Uri uri3;
        FileModel fileModel2;
        int i4;
        SupportedFileExtensions supportedFileExtensions;
        String extension;
        ICaptureThumbnailService iCaptureThumbnailService;
        String string;
        String sha1;
        SupportedFileExtensions supportedFileExtensions2;
        String extension2;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            if ((anonymousClass2.label & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuation);
        }
        AnonymousClass2 anonymousClass3 = anonymousClass2;
        Object obj = anonymousClass3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = anonymousClass3.label;
        if (i5 != 0) {
            if (i5 == 1) {
                set = (Set) anonymousClass3.L$4;
                JobTags.JobSource jobSource2 = (JobTags.JobSource) anonymousClass3.L$3;
                uri2 = (Uri) anonymousClass3.L$2;
                itemId2 = (ItemId) anonymousClass3.L$1;
                str2 = (String) anonymousClass3.L$0;
                ResultKt.throwOnFailure(obj);
                jobSource = jobSource2;
            } else {
                if (i5 != 2) {
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i6 = anonymousClass3.I$1;
                    int i7 = anonymousClass3.I$0;
                    Result result3 = (Result) anonymousClass3.L$5;
                    ResultKt.throwOnFailure(obj);
                    return result3;
                }
                int i8 = anonymousClass3.I$2;
                i3 = anonymousClass3.I$1;
                i4 = anonymousClass3.I$0;
                fileModel2 = (FileModel) anonymousClass3.L$6;
                result2 = (Result) anonymousClass3.L$5;
                set2 = (Set) anonymousClass3.L$4;
                jobSource = (JobTags.JobSource) anonymousClass3.L$3;
                uri3 = (Uri) anonymousClass3.L$2;
                itemId3 = (ItemId) anonymousClass3.L$1;
                str3 = (String) anonymousClass3.L$0;
                ResultKt.throwOnFailure(obj);
            }
            if (((Result) obj) == null) {
                result = result2;
                itemId2 = itemId3;
                i = i4;
                fileModel = fileModel2;
                uri2 = uri3;
                i2 = i3;
                set = set2;
                str2 = str3;
                BoxLogUtils.e("Trying to add historical capture for file with " + fileModel.getItemId() + " which is not a local id. This is logic error.");
                Unit unit = Unit.INSTANCE;
                str3 = str2;
                set2 = set;
                i3 = i2;
                uri3 = uri2;
                fileModel2 = fileModel;
                i4 = i;
                itemId3 = itemId2;
                result2 = result;
            }
            supportedFileExtensions = SupportedFileExtensions.INSTANCE;
            extension = fileModel2.getExtension();
            if (extension == null) {
                extension = "";
            }
            if (supportedFileExtensions.isImageExtension(extension)) {
                iCaptureThumbnailService = this.captureThumbnailService;
                string = uri3.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                sha1 = fileModel2.getSha1();
                anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable(itemId3);
                anonymousClass3.L$2 = SpillingKt.nullOutSpilledVariable(uri3);
                anonymousClass3.L$3 = SpillingKt.nullOutSpilledVariable(jobSource);
                anonymousClass3.L$4 = SpillingKt.nullOutSpilledVariable(set2);
                anonymousClass3.L$5 = result2;
                anonymousClass3.L$6 = SpillingKt.nullOutSpilledVariable(fileModel2);
                anonymousClass3.L$7 = null;
                anonymousClass3.I$0 = i4;
                anonymousClass3.I$1 = i3;
                anonymousClass3.label = 3;
                if (iCaptureThumbnailService.saveThumbnail(string, sha1, anonymousClass3) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                supportedFileExtensions2 = SupportedFileExtensions.INSTANCE;
                extension2 = fileModel2.getExtension();
                if (supportedFileExtensions2.isVideoExtension(extension2 != null ? extension2 : "")) {
                    iCaptureThumbnailService = this.captureThumbnailService;
                    string = uri3.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    sha1 = fileModel2.getSha1();
                    anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                    anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable(itemId3);
                    anonymousClass3.L$2 = SpillingKt.nullOutSpilledVariable(uri3);
                    anonymousClass3.L$3 = SpillingKt.nullOutSpilledVariable(jobSource);
                    anonymousClass3.L$4 = SpillingKt.nullOutSpilledVariable(set2);
                    anonymousClass3.L$5 = result2;
                    anonymousClass3.L$6 = SpillingKt.nullOutSpilledVariable(fileModel2);
                    anonymousClass3.L$7 = null;
                    anonymousClass3.I$0 = i4;
                    anonymousClass3.I$1 = i3;
                    anonymousClass3.label = 3;
                    if (iCaptureThumbnailService.saveThumbnail(string, sha1, anonymousClass3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return result2;
        }
        ResultKt.throwOnFailure(obj);
        JobTags.JobSource jobSource3 = JobTags.JobSource.CAPTURE_UPLOAD;
        Set of = SetsKt.setOf("job_source:" + jobSource3);
        ILocalItemService iLocalItemService = this.localItemService;
        anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(str);
        anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable(itemId);
        anonymousClass3.L$2 = uri;
        anonymousClass3.L$3 = SpillingKt.nullOutSpilledVariable(jobSource3);
        anonymousClass3.L$4 = SpillingKt.nullOutSpilledVariable(of);
        anonymousClass3.label = 1;
        Object objUploadFile$default = ILocalItemService.uploadFile$default(iLocalItemService, str, itemId, uri, of, false, null, anonymousClass3, 48, null);
        if (objUploadFile$default != coroutine_suspended) {
            itemId2 = itemId;
            uri2 = uri;
            jobSource = jobSource3;
            obj = objUploadFile$default;
            set = of;
            str2 = str;
        }
        return coroutine_suspended;
        result = (Result) obj;
        if (result instanceof Result.Success) {
            fileModel = (FileModel) ((Result.Success) result).getValue();
            ItemId itemId4 = fileModel.getItemId();
            ItemId.Local local = itemId4 instanceof ItemId.Local ? (ItemId.Local) itemId4 : null;
            i = 0;
            if (local != null) {
                ICaptureHistoryFilesService iCaptureHistoryFilesService = this.captureHistoryFilesService;
                Date contentCreatedDate = fileModel.getContentCreatedDate();
                Intrinsics.checkNotNull(contentCreatedDate);
                anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable(itemId2);
                anonymousClass3.L$2 = uri2;
                anonymousClass3.L$3 = SpillingKt.nullOutSpilledVariable(jobSource);
                anonymousClass3.L$4 = SpillingKt.nullOutSpilledVariable(set);
                anonymousClass3.L$5 = result;
                anonymousClass3.L$6 = fileModel;
                anonymousClass3.L$7 = SpillingKt.nullOutSpilledVariable(local);
                anonymousClass3.I$0 = 0;
                anonymousClass3.I$1 = 0;
                anonymousClass3.I$2 = 0;
                anonymousClass3.label = 2;
                Object objAddHistoricalCapture = iCaptureHistoryFilesService.addHistoricalCapture(local, contentCreatedDate, anonymousClass3);
                if (objAddHistoricalCapture != coroutine_suspended) {
                    str3 = str2;
                    set2 = set;
                    i3 = 0;
                    itemId3 = itemId2;
                    result2 = result;
                    obj = objAddHistoricalCapture;
                    uri3 = uri2;
                    fileModel2 = fileModel;
                    i4 = 0;
                    if (((Result) obj) == null) {
                        result = result2;
                        itemId2 = itemId3;
                        i = i4;
                        fileModel = fileModel2;
                        uri2 = uri3;
                        i2 = i3;
                        set = set2;
                        str2 = str3;
                        BoxLogUtils.e("Trying to add historical capture for file with " + fileModel.getItemId() + " which is not a local id. This is logic error.");
                        Unit unit2 = Unit.INSTANCE;
                        str3 = str2;
                        set2 = set;
                        i3 = i2;
                        uri3 = uri2;
                        fileModel2 = fileModel;
                        i4 = i;
                        itemId3 = itemId2;
                        result2 = result;
                    }
                    supportedFileExtensions = SupportedFileExtensions.INSTANCE;
                    extension = fileModel2.getExtension();
                    if (extension == null) {
                        extension = "";
                    }
                    if (supportedFileExtensions.isImageExtension(extension)) {
                        supportedFileExtensions2 = SupportedFileExtensions.INSTANCE;
                        extension2 = fileModel2.getExtension();
                        if (supportedFileExtensions2.isVideoExtension(extension2 != null ? extension2 : "")) {
                            iCaptureThumbnailService = this.captureThumbnailService;
                            string = uri3.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                            sha1 = fileModel2.getSha1();
                            anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                            anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable(itemId3);
                            anonymousClass3.L$2 = SpillingKt.nullOutSpilledVariable(uri3);
                            anonymousClass3.L$3 = SpillingKt.nullOutSpilledVariable(jobSource);
                            anonymousClass3.L$4 = SpillingKt.nullOutSpilledVariable(set2);
                            anonymousClass3.L$5 = result2;
                            anonymousClass3.L$6 = SpillingKt.nullOutSpilledVariable(fileModel2);
                            anonymousClass3.L$7 = null;
                            anonymousClass3.I$0 = i4;
                            anonymousClass3.I$1 = i3;
                            anonymousClass3.label = 3;
                            if (iCaptureThumbnailService.saveThumbnail(string, sha1, anonymousClass3) == coroutine_suspended) {
                            }
                        }
                    } else {
                        iCaptureThumbnailService = this.captureThumbnailService;
                        string = uri3.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        sha1 = fileModel2.getSha1();
                        anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                        anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable(itemId3);
                        anonymousClass3.L$2 = SpillingKt.nullOutSpilledVariable(uri3);
                        anonymousClass3.L$3 = SpillingKt.nullOutSpilledVariable(jobSource);
                        anonymousClass3.L$4 = SpillingKt.nullOutSpilledVariable(set2);
                        anonymousClass3.L$5 = result2;
                        anonymousClass3.L$6 = SpillingKt.nullOutSpilledVariable(fileModel2);
                        anonymousClass3.L$7 = null;
                        anonymousClass3.I$0 = i4;
                        anonymousClass3.I$1 = i3;
                        anonymousClass3.label = 3;
                        if (iCaptureThumbnailService.saveThumbnail(string, sha1, anonymousClass3) == coroutine_suspended) {
                        }
                    }
                    return result2;
                }
            } else {
                i2 = 0;
                BoxLogUtils.e("Trying to add historical capture for file with " + fileModel.getItemId() + " which is not a local id. This is logic error.");
                Unit unit3 = Unit.INSTANCE;
                str3 = str2;
                set2 = set;
                i3 = i2;
                uri3 = uri2;
                fileModel2 = fileModel;
                i4 = i;
                itemId3 = itemId2;
                result2 = result;
                supportedFileExtensions = SupportedFileExtensions.INSTANCE;
                extension = fileModel2.getExtension();
                if (extension == null) {
                    extension = "";
                }
                if (supportedFileExtensions.isImageExtension(extension)) {
                    supportedFileExtensions2 = SupportedFileExtensions.INSTANCE;
                    extension2 = fileModel2.getExtension();
                    if (supportedFileExtensions2.isVideoExtension(extension2 != null ? extension2 : "")) {
                        iCaptureThumbnailService = this.captureThumbnailService;
                        string = uri3.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        sha1 = fileModel2.getSha1();
                        anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                        anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable(itemId3);
                        anonymousClass3.L$2 = SpillingKt.nullOutSpilledVariable(uri3);
                        anonymousClass3.L$3 = SpillingKt.nullOutSpilledVariable(jobSource);
                        anonymousClass3.L$4 = SpillingKt.nullOutSpilledVariable(set2);
                        anonymousClass3.L$5 = result2;
                        anonymousClass3.L$6 = SpillingKt.nullOutSpilledVariable(fileModel2);
                        anonymousClass3.L$7 = null;
                        anonymousClass3.I$0 = i4;
                        anonymousClass3.I$1 = i3;
                        anonymousClass3.label = 3;
                        if (iCaptureThumbnailService.saveThumbnail(string, sha1, anonymousClass3) == coroutine_suspended) {
                        }
                    }
                } else {
                    iCaptureThumbnailService = this.captureThumbnailService;
                    string = uri3.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    sha1 = fileModel2.getSha1();
                    anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                    anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable(itemId3);
                    anonymousClass3.L$2 = SpillingKt.nullOutSpilledVariable(uri3);
                    anonymousClass3.L$3 = SpillingKt.nullOutSpilledVariable(jobSource);
                    anonymousClass3.L$4 = SpillingKt.nullOutSpilledVariable(set2);
                    anonymousClass3.L$5 = result2;
                    anonymousClass3.L$6 = SpillingKt.nullOutSpilledVariable(fileModel2);
                    anonymousClass3.L$7 = null;
                    anonymousClass3.I$0 = i4;
                    anonymousClass3.I$1 = i3;
                    anonymousClass3.label = 3;
                    if (iCaptureThumbnailService.saveThumbnail(string, sha1, anonymousClass3) == coroutine_suspended) {
                    }
                }
                return result2;
            }
            return coroutine_suspended;
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.box.android.domain.usecases.capture.CaptureLocalItemsUseCase
    public Object createFolder(String str, String str2, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) {
        return this.localItemService.createFolder(str, new ItemId.Remote(str2, ItemType.FOLDER), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.usecases.capture.CaptureLocalItemsUseCase
    public Object getFolderById(String str, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) {
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
        Object itemByLocalId = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(itemByLocalId);
            ILocalItemService iLocalItemService = this.localItemService;
            ItemId itemIdCreate = ItemId.INSTANCE.create(str);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.label = 1;
            itemByLocalId = iLocalItemService.getItemByLocalId(itemIdCreate, anonymousClass1);
            if (itemByLocalId == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(itemByLocalId);
        }
        Result result = (Result) itemByLocalId;
        if (result instanceof Result.Success) {
            ItemModel itemModel = (ItemModel) ((Result.Success) result).getValue();
            return itemModel instanceof FolderModel ? new Result.Success(itemModel) : new Result.Error(new DomainError.NoResultFoundError(null, 1, null));
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.usecases.capture.CaptureLocalItemsUseCase
    public Object getFolderByName(String str, String str2, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation) {
        C16281 c16281;
        if (continuation instanceof C16281) {
            c16281 = (C16281) continuation;
            if ((c16281.label & Integer.MIN_VALUE) != 0) {
                c16281.label -= Integer.MIN_VALUE;
            } else {
                c16281 = new C16281(continuation);
            }
        } else {
            c16281 = new C16281(continuation);
        }
        Object item = c16281.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16281.label;
        if (i == 0) {
            ResultKt.throwOnFailure(item);
            ILocalItemService iLocalItemService = this.localItemService;
            ItemId.Remote remote = new ItemId.Remote(str2, ItemType.FOLDER);
            c16281.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c16281.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            c16281.label = 1;
            item = iLocalItemService.getItem(str, remote, c16281);
            if (item == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(item);
        }
        Result result = (Result) item;
        if (result instanceof Result.Success) {
            ItemModel itemModel = (ItemModel) ((Result.Success) result).getValue();
            return itemModel instanceof FolderModel ? new Result.Success(itemModel) : new Result.Error(new DomainError.NoResultFoundError(null, 1, null));
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }
}
