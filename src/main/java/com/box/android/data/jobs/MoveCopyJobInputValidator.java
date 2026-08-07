package com.box.android.data.jobs;

import androidx.work.Data;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MoveCopyJobInputValidator.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/jobs/MoveCopyJobInputValidator;", "Lcom/box/android/data/jobs/IMoveCopyJobInputValidator;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/domain/services/IdMappingService;)V", "validateInputData", "Lcom/box/android/data/jobs/MoveCopyJobInputValidator$ValidationResult;", "inputData", "Landroidx/work/Data;", "(Landroidx/work/Data;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ValidationResult", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MoveCopyJobInputValidator implements IMoveCopyJobInputValidator {
    public static final String DESTINATION_FOLDER_ID = "destinationFolderIdParam";
    public static final String ITEM_ID_PARAM = "itemIdParam";
    private final IdMappingService idMappingService;
    private final ILocalItemService localItemService;

    /* JADX INFO: renamed from: com.box.android.data.jobs.MoveCopyJobInputValidator$validateInputData$1, reason: invalid class name */
    /* JADX INFO: compiled from: MoveCopyJobInputValidator.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.MoveCopyJobInputValidator", f = "MoveCopyJobInputValidator.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {36, 43, 49}, m = "validateInputData", n = {"inputData", "localItemId", "inputData", "localItemId", "itemName", "inputData", "localItemId", "itemName", "remoteItemId"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MoveCopyJobInputValidator.this.validateInputData(null, this);
        }
    }

    @Inject
    public MoveCopyJobInputValidator(ILocalItemService localItemService, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.localItemService = localItemService;
        this.idMappingService = idMappingService;
    }

    /* JADX INFO: compiled from: MoveCopyJobInputValidator.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/jobs/MoveCopyJobInputValidator$ValidationResult;", "", "localItemId", "Lcom/box/android/domain/models/ItemId;", "itemName", "", "remoteItemId", "Lcom/box/android/domain/models/ItemId$Remote;", "remoteDestinationFolderId", "<init>", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/models/ItemId$Remote;)V", "getLocalItemId", "()Lcom/box/android/domain/models/ItemId;", "getItemName", "()Ljava/lang/String;", "getRemoteItemId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getRemoteDestinationFolderId", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ValidationResult {
        private final String itemName;
        private final ItemId localItemId;
        private final ItemId.Remote remoteDestinationFolderId;
        private final ItemId.Remote remoteItemId;

        public static /* synthetic */ ValidationResult copy$default(ValidationResult validationResult, ItemId itemId, String str, ItemId.Remote remote, ItemId.Remote remote2, int i, Object obj) {
            if ((i & 1) != 0) {
                itemId = validationResult.localItemId;
            }
            if ((i & 2) != 0) {
                str = validationResult.itemName;
            }
            if ((i & 4) != 0) {
                remote = validationResult.remoteItemId;
            }
            if ((i & 8) != 0) {
                remote2 = validationResult.remoteDestinationFolderId;
            }
            return validationResult.copy(itemId, str, remote, remote2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemId getLocalItemId() {
            return this.localItemId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getItemName() {
            return this.itemName;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ItemId.Remote getRemoteItemId() {
            return this.remoteItemId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ItemId.Remote getRemoteDestinationFolderId() {
            return this.remoteDestinationFolderId;
        }

        public final ValidationResult copy(ItemId localItemId, String itemName, ItemId.Remote remoteItemId, ItemId.Remote remoteDestinationFolderId) {
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            Intrinsics.checkNotNullParameter(itemName, "itemName");
            Intrinsics.checkNotNullParameter(remoteItemId, "remoteItemId");
            Intrinsics.checkNotNullParameter(remoteDestinationFolderId, "remoteDestinationFolderId");
            return new ValidationResult(localItemId, itemName, remoteItemId, remoteDestinationFolderId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ValidationResult)) {
                return false;
            }
            ValidationResult validationResult = (ValidationResult) other;
            return Intrinsics.areEqual(this.localItemId, validationResult.localItemId) && Intrinsics.areEqual(this.itemName, validationResult.itemName) && Intrinsics.areEqual(this.remoteItemId, validationResult.remoteItemId) && Intrinsics.areEqual(this.remoteDestinationFolderId, validationResult.remoteDestinationFolderId);
        }

        public int hashCode() {
            return (((((this.localItemId.hashCode() * 31) + this.itemName.hashCode()) * 31) + this.remoteItemId.hashCode()) * 31) + this.remoteDestinationFolderId.hashCode();
        }

        public String toString() {
            return "ValidationResult(localItemId=" + this.localItemId + ", itemName=" + this.itemName + ", remoteItemId=" + this.remoteItemId + ", remoteDestinationFolderId=" + this.remoteDestinationFolderId + ")";
        }

        public ValidationResult(ItemId localItemId, String itemName, ItemId.Remote remoteItemId, ItemId.Remote remoteDestinationFolderId) {
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            Intrinsics.checkNotNullParameter(itemName, "itemName");
            Intrinsics.checkNotNullParameter(remoteItemId, "remoteItemId");
            Intrinsics.checkNotNullParameter(remoteDestinationFolderId, "remoteDestinationFolderId");
            this.localItemId = localItemId;
            this.itemName = itemName;
            this.remoteItemId = remoteItemId;
            this.remoteDestinationFolderId = remoteDestinationFolderId;
        }

        public final ItemId getLocalItemId() {
            return this.localItemId;
        }

        public final String getItemName() {
            return this.itemName;
        }

        public final ItemId.Remote getRemoteItemId() {
            return this.remoteItemId;
        }

        public final ItemId.Remote getRemoteDestinationFolderId() {
            return this.remoteDestinationFolderId;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:42:0x0102  */
    /* JADX WARN: Code duplicated, block: B:44:0x011b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.data.jobs.IMoveCopyJobInputValidator
    public Object validateInputData(Data data, Continuation<? super ValidationResult> continuation) {
        AnonymousClass1 anonymousClass1;
        Data data2;
        ItemId itemId;
        ItemId itemId2;
        String str;
        ItemId.Remote remote;
        Object remoteIdOrError;
        ItemId.Remote remote2;
        Data data3;
        ItemId itemId3;
        ItemId.Remote remote3;
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
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (data.getString("itemIdParam") == null || data.getString("destinationFolderIdParam") == null) {
                throw new IllegalStateException("Item ID or Destination Folder ID is null in input data");
            }
            ItemId.Companion companion = ItemId.INSTANCE;
            String string = data.getString("itemIdParam");
            Intrinsics.checkNotNull(string);
            ItemId itemIdCreate = companion.create(string);
            ILocalItemService iLocalItemService = this.localItemService;
            anonymousClass1.L$0 = data;
            anonymousClass1.L$1 = itemIdCreate;
            anonymousClass1.label = 1;
            Object itemByLocalId = iLocalItemService.getItemByLocalId(itemIdCreate, anonymousClass1);
            if (itemByLocalId != coroutine_suspended) {
                data2 = data;
                itemId = itemIdCreate;
                obj = itemByLocalId;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            itemId = (ItemId) anonymousClass1.L$1;
            data2 = (Data) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i == 2) {
                str = (String) anonymousClass1.L$2;
                ItemId itemId4 = (ItemId) anonymousClass1.L$1;
                Data data4 = (Data) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                itemId2 = itemId4;
                data2 = data4;
                remote = (ItemId.Remote) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
                if (remote != null) {
                    throw new IllegalStateException("Remote ID not found for item: " + data2.getString("itemIdParam"));
                }
                IdMappingService idMappingService = this.idMappingService;
                ItemId.Companion companion2 = ItemId.INSTANCE;
                String string2 = data2.getString("destinationFolderIdParam");
                Intrinsics.checkNotNull(string2);
                ItemId itemIdCreate2 = companion2.create(string2);
                anonymousClass1.L$0 = data2;
                anonymousClass1.L$1 = itemId2;
                anonymousClass1.L$2 = str;
                anonymousClass1.L$3 = remote;
                anonymousClass1.label = 3;
                remoteIdOrError = idMappingService.getRemoteIdOrError(itemIdCreate2, anonymousClass1);
                if (remoteIdOrError != coroutine_suspended) {
                    obj = remoteIdOrError;
                    remote2 = remote;
                    data3 = data2;
                    itemId3 = itemId2;
                }
                return coroutine_suspended;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            remote2 = (ItemId.Remote) anonymousClass1.L$3;
            str = (String) anonymousClass1.L$2;
            itemId3 = (ItemId) anonymousClass1.L$1;
            data3 = (Data) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        remote3 = (ItemId.Remote) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
        if (remote3 != null) {
            throw new IllegalStateException("Remote ID not found for destination folder: " + data3.getString("destinationFolderIdParam"));
        }
        return new ValidationResult(itemId3, str, remote2, remote3);
        Result result = (Result) obj;
        if (!(result instanceof Result.Success)) {
            if (result instanceof Result.Error) {
                throw new IllegalStateException("Item not found in LIS");
            }
            throw new NoWhenBranchMatchedException();
        }
        String name = ((ItemModel) ((Result.Success) result).getValue()).getName();
        IdMappingService idMappingService2 = this.idMappingService;
        anonymousClass1.L$0 = data2;
        anonymousClass1.L$1 = itemId;
        anonymousClass1.L$2 = name;
        anonymousClass1.label = 2;
        Object remoteIdOrError2 = idMappingService2.getRemoteIdOrError(itemId, anonymousClass1);
        if (remoteIdOrError2 != coroutine_suspended) {
            itemId2 = itemId;
            str = name;
            obj = remoteIdOrError2;
            remote = (ItemId.Remote) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
            if (remote != null) {
                throw new IllegalStateException("Remote ID not found for item: " + data2.getString("itemIdParam"));
            }
            IdMappingService idMappingService3 = this.idMappingService;
            ItemId.Companion companion3 = ItemId.INSTANCE;
            String string3 = data2.getString("destinationFolderIdParam");
            Intrinsics.checkNotNull(string3);
            ItemId itemIdCreate3 = companion3.create(string3);
            anonymousClass1.L$0 = data2;
            anonymousClass1.L$1 = itemId2;
            anonymousClass1.L$2 = str;
            anonymousClass1.L$3 = remote;
            anonymousClass1.label = 3;
            remoteIdOrError = idMappingService3.getRemoteIdOrError(itemIdCreate3, anonymousClass1);
            if (remoteIdOrError != coroutine_suspended) {
                obj = remoteIdOrError;
                remote2 = remote;
                data3 = data2;
                itemId3 = itemId2;
                remote3 = (ItemId.Remote) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
                if (remote3 != null) {
                    throw new IllegalStateException("Remote ID not found for destination folder: " + data3.getString("destinationFolderIdParam"));
                }
                return new ValidationResult(itemId3, str, remote2, remote3);
            }
        }
        return coroutine_suspended;
    }
}
