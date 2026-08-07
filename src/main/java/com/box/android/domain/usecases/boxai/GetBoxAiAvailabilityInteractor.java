package com.box.android.domain.usecases.boxai;

import androidx.lifecycle.Lifecycle;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.boxai.AiFileType;
import com.box.android.domain.models.boxai.AiItemAvailabilityStatus;
import com.box.android.domain.models.boxai.AiPermissionModel;
import com.box.android.domain.models.boxai.AiUnavailabilityReason;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.services.IBoxAiService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxFile;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetBoxAiAvailabilityInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cJ\f\u0010\u001d\u001a\u00020\r*\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/box/android/domain/usecases/boxai/GetBoxAiAvailabilityInteractor;", "Lcom/box/android/domain/usecases/boxai/GetBoxAiAvailabilityUseCase;", "boxAiService", "Lcom/box/android/domain/services/IBoxAiService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "boxAccountSettings", "Lcom/box/android/domain/configuration/IBoxAccountSettings;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/domain/services/IBoxAiService;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/domain/configuration/IBoxAccountSettings;Lcom/box/android/domain/configuration/FeatureFlips;)V", "isBoxAiEnabled", "", "()Z", "availabilityCache", "", "Lcom/box/android/domain/usecases/boxai/GetBoxAiAvailabilityInteractor$CacheKey;", "Lcom/box/android/domain/models/boxai/AiItemAvailabilityStatus;", "getAiAvailabilityForItem", "item", "Lcom/box/android/domain/models/item/ItemModel;", "isMultidoc", "(Lcom/box/android/domain/models/item/ItemModel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "evaluateAvailability", "isFileLocal", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "(Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRetryable", "CacheKey", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetBoxAiAvailabilityInteractor implements GetBoxAiAvailabilityUseCase {
    private final Map<CacheKey, AiItemAvailabilityStatus> availabilityCache;
    private final IBoxAccountSettings boxAccountSettings;
    private final IBoxAiService boxAiService;
    private final FeatureFlips featureFlips;
    private final IdMappingService idMappingService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityInteractor$evaluateAvailability$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetBoxAiAvailabilityInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityInteractor", f = "GetBoxAiAvailabilityInteractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {55, 65}, m = "evaluateAvailability", n = {"item", "file", "fileType", "isMultidoc", "notesAiEnabledEnterprise", "item", "file", "fileType", "isMultidoc", "notesAiEnabledEnterprise"}, s = {"L$0", "L$1", "L$2", "Z$0", "I$0", "L$0", "L$1", "L$2", "Z$0", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
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
            return GetBoxAiAvailabilityInteractor.this.evaluateAvailability(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityInteractor$getAiAvailabilityForItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GetBoxAiAvailabilityInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityInteractor", f = "GetBoxAiAvailabilityInteractor.kt", i = {0, 0, 0, 0}, l = {38}, m = "getAiAvailabilityForItem", n = {"item", "cacheKey", "cachedStatus", "isMultidoc"}, s = {"L$0", "L$1", "L$2", "Z$0"}, v = 1)
    static final class C16221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C16221(Continuation<? super C16221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetBoxAiAvailabilityInteractor.this.getAiAvailabilityForItem(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityInteractor$isFileLocal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GetBoxAiAvailabilityInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityInteractor", f = "GetBoxAiAvailabilityInteractor.kt", i = {0}, l = {74}, m = "isFileLocal", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C16231 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C16231(Continuation<? super C16231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetBoxAiAvailabilityInteractor.this.isFileLocal(null, this);
        }
    }

    @Inject
    public GetBoxAiAvailabilityInteractor(IBoxAiService boxAiService, IdMappingService idMappingService, IBoxAccountSettings boxAccountSettings, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(boxAiService, "boxAiService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(boxAccountSettings, "boxAccountSettings");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.boxAiService = boxAiService;
        this.idMappingService = idMappingService;
        this.boxAccountSettings = boxAccountSettings;
        this.featureFlips = featureFlips;
        this.availabilityCache = new LinkedHashMap();
    }

    @Override // com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityUseCase
    public /* bridge */ void getAiAvailabilityForItemWithCallback(BoxFile boxFile, boolean z, Lifecycle lifecycle, Function1<? super AiItemAvailabilityStatus, Unit> function1) {
        super.getAiAvailabilityForItemWithCallback(boxFile, z, lifecycle, function1);
    }

    @Override // com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityUseCase
    public boolean isBoxAiEnabled() {
        return this.boxAccountSettings.isBoxAiEnabled();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityUseCase
    public Object getAiAvailabilityForItem(ItemModel itemModel, boolean z, Continuation<? super AiItemAvailabilityStatus> continuation) {
        C16221 c16221;
        CacheKey cacheKey;
        if (continuation instanceof C16221) {
            c16221 = (C16221) continuation;
            if ((c16221.label & Integer.MIN_VALUE) != 0) {
                c16221.label -= Integer.MIN_VALUE;
            } else {
                c16221 = new C16221(continuation);
            }
        } else {
            c16221 = new C16221(continuation);
        }
        Object obj = c16221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16221.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CacheKey cacheKey2 = new CacheKey(itemModel.getItemId(), z);
            AiItemAvailabilityStatus aiItemAvailabilityStatus = this.availabilityCache.get(cacheKey2);
            if (aiItemAvailabilityStatus != null && !isRetryable(aiItemAvailabilityStatus)) {
                return aiItemAvailabilityStatus;
            }
            c16221.L$0 = SpillingKt.nullOutSpilledVariable(itemModel);
            c16221.L$1 = cacheKey2;
            c16221.L$2 = SpillingKt.nullOutSpilledVariable(aiItemAvailabilityStatus);
            c16221.Z$0 = z;
            c16221.label = 1;
            Object objEvaluateAvailability = evaluateAvailability(itemModel, z, c16221);
            if (objEvaluateAvailability == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objEvaluateAvailability;
            cacheKey = cacheKey2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z2 = c16221.Z$0;
            cacheKey = (CacheKey) c16221.L$1;
            ResultKt.throwOnFailure(obj);
        }
        AiItemAvailabilityStatus aiItemAvailabilityStatus2 = (AiItemAvailabilityStatus) obj;
        this.availabilityCache.put(cacheKey, aiItemAvailabilityStatus2);
        return aiItemAvailabilityStatus2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:55:0x0123  */
    /* JADX WARN: Code duplicated, block: B:57:0x012b  */
    /* JADX WARN: Code duplicated, block: B:59:0x0139  */
    /* JADX WARN: Code duplicated, block: B:61:0x0141  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityInteractor] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final Object evaluateAvailability(ItemModel itemModel, boolean z, Continuation<? super AiItemAvailabilityStatus> continuation) {
        AnonymousClass1 anonymousClass1;
        FileModel fileModel;
        AiFileType aiFileTypeFromExtensionOrNull;
        ItemModel itemModel2;
        ?? r12;
        Object obj;
        AiFileType aiFileType;
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
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i != 0) {
            if (i == 1) {
                int i2 = anonymousClass1.I$0;
                z = anonymousClass1.Z$0;
                AiFileType aiFileType2 = (AiFileType) anonymousClass1.L$2;
                fileModel = (FileModel) anonymousClass1.L$1;
                itemModel2 = (ItemModel) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj2);
                obj = obj2;
                aiFileTypeFromExtensionOrNull = aiFileType2;
                r12 = i2;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = anonymousClass1.I$0;
                boolean z2 = anonymousClass1.Z$0;
                aiFileType = (AiFileType) anonymousClass1.L$2;
                ResultKt.throwOnFailure(obj2);
            }
            result = (Result) obj2;
            if (!(result instanceof Result.Success)) {
                return new AiItemAvailabilityStatus.Unavailable(AiUnavailabilityReason.NO_PERMISSION, true);
            }
            if (!((AiPermissionModel) ((Result.Success) result).getValue()).isValidUser()) {
                return new AiItemAvailabilityStatus.Unavailable(AiUnavailabilityReason.NO_PERMISSION, false, 2, null);
            }
            return new AiItemAvailabilityStatus.Available(aiFileType);
        }
        ResultKt.throwOnFailure(obj2);
        if (!isBoxAiEnabled()) {
            return new AiItemAvailabilityStatus.Unavailable(AiUnavailabilityReason.AI_DISABLED, false, 2, null);
        }
        fileModel = ItemModelKt.fileModel(itemModel);
        if (fileModel != null && (aiFileTypeFromExtensionOrNull = AiFileType.INSTANCE.fromExtensionOrNull(fileModel.getExtension())) != null) {
            ?? IsBoxAiNotesEnabled = this.featureFlips.getBoxAiStudioSettingsUpdates().getEnabled() ? 1 : this.boxAccountSettings.isBoxAiNotesEnabled();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemModel);
            anonymousClass1.L$1 = fileModel;
            anonymousClass1.L$2 = aiFileTypeFromExtensionOrNull;
            anonymousClass1.Z$0 = z;
            anonymousClass1.I$0 = IsBoxAiNotesEnabled;
            anonymousClass1.label = 1;
            Object objIsFileLocal = isFileLocal(fileModel, anonymousClass1);
            if (objIsFileLocal != coroutine_suspended) {
                itemModel2 = itemModel;
                r12 = IsBoxAiNotesEnabled;
                obj = objIsFileLocal;
            }
            return coroutine_suspended;
        }
        return new AiItemAvailabilityStatus.Unavailable(AiUnavailabilityReason.NOT_SUPPORTED, false, 2, null);
        if (((Boolean) obj).booleanValue()) {
            return new AiItemAvailabilityStatus.Unavailable(AiUnavailabilityReason.NOT_SUPPORTED, false, 2, null);
        }
        if (SupportedFileExtensions.INSTANCE.isBoxNoteExtension(fileModel.getExtension()) && r12 == 0) {
            return new AiItemAvailabilityStatus.Unavailable(AiUnavailabilityReason.NOT_SUPPORTED, false, 2, null);
        }
        if (this.featureFlips.getBoxAiApiChangesSafeguard().getEnabled()) {
            return new AiItemAvailabilityStatus.Available(aiFileTypeFromExtensionOrNull);
        }
        IBoxAiService iBoxAiService = this.boxAiService;
        ItemId itemId = fileModel.getItemId();
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemModel2);
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(fileModel);
        anonymousClass1.L$2 = aiFileTypeFromExtensionOrNull;
        anonymousClass1.Z$0 = z;
        anonymousClass1.I$0 = r12;
        anonymousClass1.label = 2;
        Object permission = iBoxAiService.getPermission(itemId, z, anonymousClass1);
        if (permission != coroutine_suspended) {
            AiFileType aiFileType3 = aiFileTypeFromExtensionOrNull;
            obj2 = permission;
            aiFileType = aiFileType3;
            result = (Result) obj2;
            if (!(result instanceof Result.Success)) {
                return new AiItemAvailabilityStatus.Unavailable(AiUnavailabilityReason.NO_PERMISSION, true);
            }
            if (!((AiPermissionModel) ((Result.Success) result).getValue()).isValidUser()) {
                return new AiItemAvailabilityStatus.Unavailable(AiUnavailabilityReason.NO_PERMISSION, false, 2, null);
            }
            return new AiItemAvailabilityStatus.Available(aiFileType);
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isFileLocal(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C16231 c16231;
        if (continuation instanceof C16231) {
            c16231 = (C16231) continuation;
            if ((c16231.label & Integer.MIN_VALUE) != 0) {
                c16231.label -= Integer.MIN_VALUE;
            } else {
                c16231 = new C16231(continuation);
            }
        } else {
            c16231 = new C16231(continuation);
        }
        Object remoteId = c16231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16231.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remoteId);
            IdMappingService idMappingService = this.idMappingService;
            ItemId itemId = fileModel.getItemId();
            c16231.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
            c16231.label = 1;
            remoteId = idMappingService.getRemoteId(itemId, c16231);
            if (remoteId == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(remoteId);
        }
        return Boxing.boxBoolean(remoteId == null);
    }

    private final boolean isRetryable(AiItemAvailabilityStatus aiItemAvailabilityStatus) {
        return (aiItemAvailabilityStatus instanceof AiItemAvailabilityStatus.Unavailable) && ((AiItemAvailabilityStatus.Unavailable) aiItemAvailabilityStatus).isRetryable();
    }

    /* JADX INFO: compiled from: GetBoxAiAvailabilityInteractor.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/box/android/domain/usecases/boxai/GetBoxAiAvailabilityInteractor$CacheKey;", "", "itemId", "Lcom/box/android/domain/models/ItemId;", "isMultidoc", "", "<init>", "(Lcom/box/android/domain/models/ItemId;Z)V", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class CacheKey {
        private final boolean isMultidoc;
        private final ItemId itemId;

        public static /* synthetic */ CacheKey copy$default(CacheKey cacheKey, ItemId itemId, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                itemId = cacheKey.itemId;
            }
            if ((i & 2) != 0) {
                z = cacheKey.isMultidoc;
            }
            return cacheKey.copy(itemId, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemId getItemId() {
            return this.itemId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsMultidoc() {
            return this.isMultidoc;
        }

        public final CacheKey copy(ItemId itemId, boolean isMultidoc) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            return new CacheKey(itemId, isMultidoc);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CacheKey)) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) other;
            return Intrinsics.areEqual(this.itemId, cacheKey.itemId) && this.isMultidoc == cacheKey.isMultidoc;
        }

        public int hashCode() {
            return (this.itemId.hashCode() * 31) + Boolean.hashCode(this.isMultidoc);
        }

        public String toString() {
            return "CacheKey(itemId=" + this.itemId + ", isMultidoc=" + this.isMultidoc + ")";
        }

        public CacheKey(ItemId itemId, boolean z) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            this.itemId = itemId;
            this.isMultidoc = z;
        }

        public final ItemId getItemId() {
            return this.itemId;
        }

        public final boolean isMultidoc() {
            return this.isMultidoc;
        }
    }
}
