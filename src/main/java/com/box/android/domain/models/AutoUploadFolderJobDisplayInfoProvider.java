package com.box.android.domain.models;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.jobs.JobType;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.ILocalItemService;
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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\rJ\u000e\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0096@¢\u0006\u0002\u0010\rJ\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/box/android/domain/models/AutoUploadFolderJobDisplayInfoProvider;", "Lcom/box/android/domain/models/IJobDisplayInfoProvider;", "itemId", "Lcom/box/android/domain/models/ItemId;", "sourceFolderPath", "", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "<init>", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lcom/box/android/domain/services/ILocalItemService;)V", "getLocalItemService", "()Lcom/box/android/domain/services/ILocalItemService;", "getName", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iconResId", "", "getIconResId", "()I", "jobType", "getJobType", "()Ljava/lang/String;", "getItemModel", "Lcom/box/android/domain/models/item/ItemModel;", "getServerId", "errorStringRes", "error", "Lcom/box/android/domain/models/DomainError;", "(Lcom/box/android/domain/models/DomainError;)Ljava/lang/Integer;", "getItemDescription", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AutoUploadFolderJobDisplayInfoProvider implements IJobDisplayInfoProvider {
    private final ItemId itemId;
    private final String jobType;
    private final ILocalItemService localItemService;
    private final String sourceFolderPath;

    /* JADX INFO: renamed from: com.box.android.domain.models.AutoUploadFolderJobDisplayInfoProvider$getItemDescription$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobInfoProviders.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.models.AutoUploadFolderJobDisplayInfoProvider", f = "JobInfoProviders.kt", i = {}, l = {276}, m = "getItemDescription", n = {}, s = {}, v = 1)
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
            return AutoUploadFolderJobDisplayInfoProvider.this.getItemDescription(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.models.AutoUploadFolderJobDisplayInfoProvider$getItemModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobInfoProviders.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.models.AutoUploadFolderJobDisplayInfoProvider", f = "JobInfoProviders.kt", i = {}, l = {270}, m = "getItemModel", n = {}, s = {}, v = 1)
    static final class C16041 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C16041(Continuation<? super C16041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoUploadFolderJobDisplayInfoProvider.this.getItemModel(this);
        }
    }

    public AutoUploadFolderJobDisplayInfoProvider(ItemId itemId, String sourceFolderPath, ILocalItemService localItemService) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(sourceFolderPath, "sourceFolderPath");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        this.itemId = itemId;
        this.sourceFolderPath = sourceFolderPath;
        this.localItemService = localItemService;
        this.jobType = JobType.AUTO_UPLOAD;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public /* bridge */ boolean getShowNotification() {
        return super.getShowNotification();
    }

    public final ILocalItemService getLocalItemService() {
        return this.localItemService;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getName(Continuation<? super String> continuation) {
        return this.sourceFolderPath;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public int getIconResId() {
        return CommonBoxUtil.getDrawableResIdByName("ic_file_upload_grey_24dp");
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public String getJobType() {
        return this.jobType;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getItemModel(Continuation<? super ItemModel> continuation) {
        C16041 c16041;
        if (continuation instanceof C16041) {
            c16041 = (C16041) continuation;
            if ((c16041.label & Integer.MIN_VALUE) != 0) {
                c16041.label -= Integer.MIN_VALUE;
            } else {
                c16041 = new C16041(continuation);
            }
        } else {
            c16041 = new C16041(continuation);
        }
        Object itemByLocalId = c16041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16041.label;
        if (i == 0) {
            ResultKt.throwOnFailure(itemByLocalId);
            ILocalItemService iLocalItemService = this.localItemService;
            ItemId itemId = this.itemId;
            c16041.label = 1;
            itemByLocalId = iLocalItemService.getItemByLocalId(itemId, c16041);
            if (itemByLocalId == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(itemByLocalId);
        }
        Object orNull = com.box.android.domain.utils.result.ResultKt.getOrNull((Result) itemByLocalId);
        Intrinsics.checkNotNull(orNull);
        return orNull;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getServerId(Continuation<? super String> continuation) {
        ItemId itemId = this.itemId;
        ItemId.Remote remote = itemId instanceof ItemId.Remote ? (ItemId.Remote) itemId : null;
        if (remote != null) {
            return remote.getBoxId();
        }
        return null;
    }

    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Integer errorStringRes(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return JobInfoProvidersKt.getFileUploadErrorStringRes(error);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.models.IJobDisplayInfoProvider
    public Object getItemDescription(Continuation<? super String> continuation) {
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
        Object itemModel = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(itemModel);
            anonymousClass1.label = 1;
            itemModel = getItemModel(anonymousClass1);
            if (itemModel == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(itemModel);
        }
        return ((ItemModel) itemModel).getName();
    }
}
