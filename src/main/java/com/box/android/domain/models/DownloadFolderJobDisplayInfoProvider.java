package com.box.android.domain.models;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobInfoProviders.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0096@¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0002\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/box/android/domain/models/DownloadFolderJobDisplayInfoProvider;", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "folderId", "", BoxCommonConstants.EXTRA_FOLDER_NAME, "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/services/IRemoteItemService;)V", "getFolderId", "()Ljava/lang/String;", "getFolderName", "getItemService", "()Lcom/box/android/domain/services/IRemoteItemService;", "getName", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iconResId", "", "getIconResId", "()I", "jobType", "getJobType", "getItemModel", "Lcom/box/android/domain/models/item/ItemModel;", "getServerId", "errorStringRes", "error", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/models/DomainError;)Ljava/lang/Integer;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DownloadFolderJobDisplayInfoProvider implements IJobDisplayInfoProvider {
    private final String folderId;
    private final String folderName;
    private final IRemoteItemService itemService;
    private final String jobType;

    /* JADX INFO: renamed from: com.box.android.domain.models.DownloadFolderJobDisplayInfoProvider$getItemModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobInfoProviders.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.models.DownloadFolderJobDisplayInfoProvider", f = "JobInfoProviders.kt", i = {}, l = {224}, m = "getItemModel", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadFolderJobDisplayInfoProvider.this.getItemModel(this);
        }
    }

    public DownloadFolderJobDisplayInfoProvider(String folderId, String folderName, IRemoteItemService itemService) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        this.folderId = folderId;
        this.folderName = folderName;
        this.itemService = itemService;
        this.jobType = JobType.DOWNLOAD_FILE;
    }

    public final String getFolderId() {
        return this.folderId;
    }

    public final String getFolderName() {
        return this.folderName;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public /* bridge */ Object getItemDescription(Continuation<? super String> continuation) {
        return super.getItemDescription(continuation);
    }

    public final IRemoteItemService getItemService() {
        return this.itemService;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public /* bridge */ boolean getShowNotification() {
        return super.getShowNotification();
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getName(Continuation<? super String> continuation) {
        return this.folderName;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public int getIconResId() {
        return CommonBoxUtil.getDrawableResIdByName("ic_file_download_grey_24dp");
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public String getJobType() {
        return this.jobType;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getItemModel(Continuation<? super ItemModel> continuation) {
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
        Object objItem = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objItem);
            IRemoteItemService iRemoteItemService = this.itemService;
            ItemId.Remote remote = new ItemId.Remote(this.folderId, ItemType.FOLDER);
            DataPolicy dataPolicy = DataPolicy.CACHE_OR_REMOTE;
            anonymousClass1.label = 1;
            objItem = iRemoteItemService.item(remote, dataPolicy, (Continuation<? super Result<? extends ItemModel, ? extends DomainError>>) anonymousClass1);
            if (objItem == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objItem);
        }
        return com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getServerId(Continuation<? super String> continuation) {
        return this.folderId;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Integer errorStringRes(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return JobInfoProvidersKt.getFileDownloadErrorStringRes(error);
    }
}
