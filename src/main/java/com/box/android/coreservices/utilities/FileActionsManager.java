package com.box.android.coreservices.utilities;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.AdminSettingsDomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.UserModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.services.IAudioPlaylistItemsService;
import com.box.android.domain.services.IGalleryItemsService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.android.domain.utils.result.Result;
import com.microsoft.intune.mam.policy.SaveLocation;
import external.sdk.pendo.io.mozilla.javascript.Token;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActionsManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018J\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018J\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018J\u0016\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u0010%\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u0010&\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018J\u0016\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u0010)\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u000e\u0010*\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-J\u0016\u00100\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u00101\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014J\u0010\u00102\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u00103\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u00104\u001a\u00020\u00112\b\u00105\u001a\u0004\u0018\u000106R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/box/android/coreservices/utilities/FileActionsManager;", "", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "boxAccountManagerHelper", "Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "galleryItemsService", "Lcom/box/android/domain/services/IGalleryItemsService;", "audioPlaylistItemsService", "Lcom/box/android/domain/services/IAudioPlaylistItemsService;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/coreservices/utilities/BoxAccountManagerHelper;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/domain/services/IGalleryItemsService;Lcom/box/android/domain/services/IAudioPlaylistItemsService;Lcom/box/android/domain/configuration/FeatureFlips;)V", "isSeeShareInfoEnabled", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "(Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isShareEnabled", "isDeleteEnabled", "checkOpenInActionAdminSettings", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/AdminSettingsDomainError;", "isCreatingAnnotationsEnabled", "isCreatingAnnotationsHidden", "isViewingAnnotationsEnabled", "isCommentingEnabled", "isCommentingHidden", "isAddTaskEnabled", "isAddingToCollectionEnabled", "checkOfflineActionAdminSettings", "checkPrintActionAdminSettings", "isOfflineActionEnabled", "canSaveFileForOfflineUse", "isDownloadActionEnabled", "checkDownloadActionAdminSettings", "isRenamingEnabled", "isEndCollaborationEnabled", "isViewContainingFolderEnabled", "isGalleryEnabled", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "(Lcom/box/android/domain/models/preview/PreviewSource;Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPlaylistEnabled", "moveOrCopyEnabled", "isLocal", "isBoxNote", "isBoxCanvas", "isPreviewOnly", "permissions", "Lcom/box/android/domain/models/item/PermissionsModel;", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActionsManager {
    private final IAudioPlaylistItemsService audioPlaylistItemsService;
    private final BoxAccountManagerHelper boxAccountManagerHelper;
    private final FeatureFlips featureFlips;
    private final IGalleryItemsService galleryItemsService;
    private final IdMappingService idMappingService;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$canSaveFileForOfflineUse$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0}, l = {96}, m = "canSaveFileForOfflineUse", n = {"fileModel"}, s = {"L$0"}, v = 1)
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
            return FileActionsManager.this.canSaveFileForOfflineUse(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$isAddTaskEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0}, l = {59}, m = "isAddTaskEnabled", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C10391 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10391(Continuation<? super C10391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsManager.this.isAddTaskEnabled(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$isAddingToCollectionEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0}, l = {64}, m = "isAddingToCollectionEnabled", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C10401 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10401(Continuation<? super C10401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsManager.this.isAddingToCollectionEnabled(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$isCommentingEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0}, l = {55}, m = "isCommentingEnabled", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C10411 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10411(Continuation<? super C10411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsManager.this.isCommentingEnabled(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$isCreatingAnnotationsEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0}, l = {42}, m = "isCreatingAnnotationsEnabled", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C10421 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10421(Continuation<? super C10421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsManager.this.isCreatingAnnotationsEnabled(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$isDeleteEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0}, l = {31}, m = "isDeleteEnabled", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C10431 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10431(Continuation<? super C10431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsManager.this.isDeleteEnabled(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$isDownloadActionEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0}, l = {98}, m = "isDownloadActionEnabled", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C10441 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10441(Continuation<? super C10441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsManager.this.isDownloadActionEnabled(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$isEndCollaborationEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0}, l = {123}, m = "isEndCollaborationEnabled", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C10451 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10451(Continuation<? super C10451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsManager.this.isEndCollaborationEnabled(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$isGalleryEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0, 0}, l = {Token.LABEL}, m = "isGalleryEnabled", n = {"previewSource", "fileModel"}, s = {"L$0", "L$1"}, v = 1)
    static final class C10461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10461(Continuation<? super C10461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsManager.this.isGalleryEnabled(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$isLocal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0}, l = {139}, m = "isLocal", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C10471 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10471(Continuation<? super C10471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsManager.this.isLocal(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$isOfflineActionEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0}, l = {89}, m = "isOfflineActionEnabled", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C10481 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10481(Continuation<? super C10481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsManager.this.isOfflineActionEnabled(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$isRenamingEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0}, l = {120}, m = "isRenamingEnabled", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C10491 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10491(Continuation<? super C10491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsManager.this.isRenamingEnabled(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$isSeeShareInfoEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0}, l = {27}, m = "isSeeShareInfoEnabled", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C10501 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10501(Continuation<? super C10501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsManager.this.isSeeShareInfoEnabled(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$isShareEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0}, l = {29}, m = "isShareEnabled", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C10511 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10511(Continuation<? super C10511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsManager.this.isShareEnabled(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.FileActionsManager$moveOrCopyEnabled$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActionsManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.FileActionsManager", f = "FileActionsManager.kt", i = {0}, l = {136}, m = "moveOrCopyEnabled", n = {"fileModel"}, s = {"L$0"}, v = 1)
    static final class C10521 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10521(Continuation<? super C10521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActionsManager.this.moveOrCopyEnabled(null, this);
        }
    }

    @Inject
    public FileActionsManager(IdMappingService idMappingService, BoxAccountManagerHelper boxAccountManagerHelper, IUserContextManager userContextManager, IGalleryItemsService galleryItemsService, IAudioPlaylistItemsService audioPlaylistItemsService, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(boxAccountManagerHelper, "boxAccountManagerHelper");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(galleryItemsService, "galleryItemsService");
        Intrinsics.checkNotNullParameter(audioPlaylistItemsService, "audioPlaylistItemsService");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.idMappingService = idMappingService;
        this.boxAccountManagerHelper = boxAccountManagerHelper;
        this.userContextManager = userContextManager;
        this.galleryItemsService = galleryItemsService;
        this.audioPlaylistItemsService = audioPlaylistItemsService;
        this.featureFlips = featureFlips;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isSeeShareInfoEnabled(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C10501 c10501;
        if (continuation instanceof C10501) {
            c10501 = (C10501) continuation;
            if ((c10501.label & Integer.MIN_VALUE) != 0) {
                c10501.label -= Integer.MIN_VALUE;
            } else {
                c10501 = new C10501(continuation);
            }
        } else {
            c10501 = new C10501(continuation);
        }
        Object objIsLocal = c10501.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10501.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsLocal);
            c10501.L$0 = fileModel;
            c10501.label = 1;
            objIsLocal = isLocal(fileModel, c10501);
            if (objIsLocal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c10501.L$0;
            ResultKt.throwOnFailure(objIsLocal);
        }
        return Boxing.boxBoolean(!((Boolean) objIsLocal).booleanValue() && CoreServiceUtils.canSeeShareInfo(fileModel));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isShareEnabled(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C10511 c10511;
        PermissionsModel permissions;
        if (continuation instanceof C10511) {
            c10511 = (C10511) continuation;
            if ((c10511.label & Integer.MIN_VALUE) != 0) {
                c10511.label -= Integer.MIN_VALUE;
            } else {
                c10511 = new C10511(continuation);
            }
        } else {
            c10511 = new C10511(continuation);
        }
        Object objIsLocal = c10511.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10511.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsLocal);
            c10511.L$0 = fileModel;
            c10511.label = 1;
            objIsLocal = isLocal(fileModel, c10511);
            if (objIsLocal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c10511.L$0;
            ResultKt.throwOnFailure(objIsLocal);
        }
        return Boxing.boxBoolean((((Boolean) objIsLocal).booleanValue() || (permissions = fileModel.getPermissions()) == null || !permissions.getCanShare()) ? false : true);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isDeleteEnabled(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C10431 c10431;
        PermissionsModel permissions;
        if (continuation instanceof C10431) {
            c10431 = (C10431) continuation;
            if ((c10431.label & Integer.MIN_VALUE) != 0) {
                c10431.label -= Integer.MIN_VALUE;
            } else {
                c10431 = new C10431(continuation);
            }
        } else {
            c10431 = new C10431(continuation);
        }
        Object objIsLocal = c10431.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10431.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsLocal);
            c10431.L$0 = fileModel;
            c10431.label = 1;
            objIsLocal = isLocal(fileModel, c10431);
            if (objIsLocal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c10431.L$0;
            ResultKt.throwOnFailure(objIsLocal);
        }
        return Boxing.boxBoolean((((Boolean) objIsLocal).booleanValue() || (permissions = fileModel.getPermissions()) == null || !permissions.getCanDelete()) ? false : true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Result<Unit, AdminSettingsDomainError> checkOpenInActionAdminSettings() {
        if (!this.boxAccountManagerHelper.isMobileSaveOnDeviceEnabled() || !this.boxAccountManagerHelper.isMobileOpenInEnabled()) {
            return new Result.Error(new AdminSettingsDomainError.FeatureDisabled(null, 1, 0 == true ? 1 : 0));
        }
        return new Result.Success(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isCreatingAnnotationsEnabled(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C10421 c10421;
        PermissionsModel permissions;
        if (continuation instanceof C10421) {
            c10421 = (C10421) continuation;
            if ((c10421.label & Integer.MIN_VALUE) != 0) {
                c10421.label -= Integer.MIN_VALUE;
            } else {
                c10421 = new C10421(continuation);
            }
        } else {
            c10421 = new C10421(continuation);
        }
        Object objIsLocal = c10421.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10421.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsLocal);
            c10421.L$0 = fileModel;
            c10421.label = 1;
            objIsLocal = isLocal(fileModel, c10421);
            if (objIsLocal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c10421.L$0;
            ResultKt.throwOnFailure(objIsLocal);
        }
        return Boxing.boxBoolean(!((Boolean) objIsLocal).booleanValue() && (permissions = fileModel.getPermissions()) != null && permissions.getCanCreateAnnotations() && this.featureFlips.getCreateAnnotations().getEnabled() && fileModel.isRooted());
    }

    public final boolean isCreatingAnnotationsHidden(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        return (fileModel.isRooted() && this.featureFlips.getCreateAnnotations().getEnabled()) ? false : true;
    }

    public final boolean isViewingAnnotationsEnabled(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        PermissionsModel permissions = fileModel.getPermissions();
        return permissions != null && permissions.getCanViewAnnotations() && this.featureFlips.getViewAnnotations().getEnabled() && fileModel.isRooted();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isCommentingEnabled(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C10411 c10411;
        PermissionsModel permissions;
        if (continuation instanceof C10411) {
            c10411 = (C10411) continuation;
            if ((c10411.label & Integer.MIN_VALUE) != 0) {
                c10411.label -= Integer.MIN_VALUE;
            } else {
                c10411 = new C10411(continuation);
            }
        } else {
            c10411 = new C10411(continuation);
        }
        Object objIsLocal = c10411.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10411.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsLocal);
            c10411.L$0 = fileModel;
            c10411.label = 1;
            objIsLocal = isLocal(fileModel, c10411);
            if (objIsLocal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c10411.L$0;
            ResultKt.throwOnFailure(objIsLocal);
        }
        if (((Boolean) objIsLocal).booleanValue() || (permissions = fileModel.getPermissions()) == null || !permissions.getCanComment() || (!fileModel.isRooted() && !isBoxNote(fileModel))) {
            z = false;
        }
        return Boxing.boxBoolean(z);
    }

    public final boolean isCommentingHidden(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        return !fileModel.isRooted();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isAddTaskEnabled(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C10391 c10391;
        PermissionsModel permissions;
        if (continuation instanceof C10391) {
            c10391 = (C10391) continuation;
            if ((c10391.label & Integer.MIN_VALUE) != 0) {
                c10391.label -= Integer.MIN_VALUE;
            } else {
                c10391 = new C10391(continuation);
            }
        } else {
            c10391 = new C10391(continuation);
        }
        Object objIsLocal = c10391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10391.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsLocal);
            c10391.L$0 = fileModel;
            c10391.label = 1;
            objIsLocal = isLocal(fileModel, c10391);
            if (objIsLocal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c10391.L$0;
            ResultKt.throwOnFailure(objIsLocal);
        }
        return Boxing.boxBoolean((((Boolean) objIsLocal).booleanValue() || (permissions = fileModel.getPermissions()) == null || !permissions.getCanComment() || isBoxNote(fileModel) || isBoxCanvas(fileModel)) ? false : true);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isAddingToCollectionEnabled(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C10401 c10401;
        if (continuation instanceof C10401) {
            c10401 = (C10401) continuation;
            if ((c10401.label & Integer.MIN_VALUE) != 0) {
                c10401.label -= Integer.MIN_VALUE;
            } else {
                c10401 = new C10401(continuation);
            }
        } else {
            c10401 = new C10401(continuation);
        }
        Object objIsLocal = c10401.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10401.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsLocal);
            c10401.L$0 = fileModel;
            c10401.label = 1;
            objIsLocal = isLocal(fileModel, c10401);
            if (objIsLocal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c10401.L$0;
            ResultKt.throwOnFailure(objIsLocal);
        }
        return Boxing.boxBoolean(!((Boolean) objIsLocal).booleanValue() && fileModel.isRooted());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Result<Unit, AdminSettingsDomainError> checkOfflineActionAdminSettings() {
        int i = 1;
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (this.boxAccountManagerHelper.doesSaveOnDeviceRequireEncryptedDevice()) {
            return new Result.Error(new AdminSettingsDomainError.EncryptedDeviceRequired(str, i, objArr3 == true ? 1 : 0));
        }
        if (!this.boxAccountManagerHelper.isMobileSaveOnDeviceEnabled()) {
            return new Result.Error(new AdminSettingsDomainError.FeatureDisabled(objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0));
        }
        return new Result.Success(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Result<Unit, AdminSettingsDomainError> checkPrintActionAdminSettings() {
        if (!this.boxAccountManagerHelper.isMobilePrintEnabled() || !this.boxAccountManagerHelper.isMobileSaveOnDeviceEnabled() || !this.boxAccountManagerHelper.isMobileOpenInEnabled()) {
            return new Result.Error(new AdminSettingsDomainError.FeatureDisabled(null, 1, 0 == true ? 1 : 0));
        }
        return new Result.Success(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isOfflineActionEnabled(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C10481 c10481;
        PermissionsModel permissions;
        if (continuation instanceof C10481) {
            c10481 = (C10481) continuation;
            if ((c10481.label & Integer.MIN_VALUE) != 0) {
                c10481.label -= Integer.MIN_VALUE;
            } else {
                c10481 = new C10481(continuation);
            }
        } else {
            c10481 = new C10481(continuation);
        }
        Object objIsLocal = c10481.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10481.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsLocal);
            c10481.L$0 = fileModel;
            c10481.label = 1;
            objIsLocal = isLocal(fileModel, c10481);
            if (objIsLocal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c10481.L$0;
            ResultKt.throwOnFailure(objIsLocal);
        }
        boolean z2 = (((Boolean) objIsLocal).booleanValue() || isBoxNote(fileModel)) ? false : true;
        boolean z3 = isPreviewOnly(fileModel.getPermissions()) && this.boxAccountManagerHelper.isMobilePreviewOnlyOffliningEnabled();
        if (!z2 || (((permissions = fileModel.getPermissions()) == null || !permissions.getCanDownload()) && !z3)) {
            z = false;
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object canSaveFileForOfflineUse(FileModel fileModel, Continuation<? super Boolean> continuation) {
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
        Object objIsOfflineActionEnabled = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsOfflineActionEnabled);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
            anonymousClass1.label = 1;
            objIsOfflineActionEnabled = isOfflineActionEnabled(fileModel, anonymousClass1);
            if (objIsOfflineActionEnabled == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objIsOfflineActionEnabled);
        }
        return Boxing.boxBoolean(((Boolean) objIsOfflineActionEnabled).booleanValue() && Intrinsics.areEqual(checkOfflineActionAdminSettings(), new Result.Success(Unit.INSTANCE)));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isDownloadActionEnabled(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C10441 c10441;
        PermissionsModel permissions;
        if (continuation instanceof C10441) {
            c10441 = (C10441) continuation;
            if ((c10441.label & Integer.MIN_VALUE) != 0) {
                c10441.label -= Integer.MIN_VALUE;
            } else {
                c10441 = new C10441(continuation);
            }
        } else {
            c10441 = new C10441(continuation);
        }
        Object objIsLocal = c10441.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10441.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsLocal);
            c10441.L$0 = fileModel;
            c10441.label = 1;
            objIsLocal = isLocal(fileModel, c10441);
            if (objIsLocal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c10441.L$0;
            ResultKt.throwOnFailure(objIsLocal);
        }
        return Boxing.boxBoolean((((Boolean) objIsLocal).booleanValue() || isBoxNote(fileModel) || (permissions = fileModel.getPermissions()) == null || !permissions.getCanDownload()) ? false : true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Result<Unit, AdminSettingsDomainError> checkDownloadActionAdminSettings() {
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        int i = 1;
        if (!this.boxAccountManagerHelper.isSaveToLocationAllowed(SaveLocation.LOCAL, null)) {
            return new Result.Error(new AdminSettingsDomainError.SaveToLocationDisabled(str, i, objArr5 == true ? 1 : 0));
        }
        if (this.boxAccountManagerHelper.doesSaveOnDeviceRequireEncryptedDevice()) {
            return new Result.Error(new AdminSettingsDomainError.EncryptedDeviceRequired(objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0));
        }
        if (!this.boxAccountManagerHelper.isMobileSaveOnDeviceEnabled() || !this.boxAccountManagerHelper.isMobileOpenInEnabled()) {
            return new Result.Error(new AdminSettingsDomainError.FeatureDisabled(objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0));
        }
        return new Result.Success(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isRenamingEnabled(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C10491 c10491;
        PermissionsModel permissions;
        if (continuation instanceof C10491) {
            c10491 = (C10491) continuation;
            if ((c10491.label & Integer.MIN_VALUE) != 0) {
                c10491.label -= Integer.MIN_VALUE;
            } else {
                c10491 = new C10491(continuation);
            }
        } else {
            c10491 = new C10491(continuation);
        }
        Object objIsLocal = c10491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10491.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsLocal);
            c10491.L$0 = fileModel;
            c10491.label = 1;
            objIsLocal = isLocal(fileModel, c10491);
            if (objIsLocal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c10491.L$0;
            ResultKt.throwOnFailure(objIsLocal);
        }
        return Boxing.boxBoolean((((Boolean) objIsLocal).booleanValue() || (permissions = fileModel.getPermissions()) == null || !permissions.getCanRename()) ? false : true);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0078  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isEndCollaborationEnabled(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C10451 c10451;
        boolean z;
        PermissionsModel permissions;
        if (continuation instanceof C10451) {
            c10451 = (C10451) continuation;
            if ((c10451.label & Integer.MIN_VALUE) != 0) {
                c10451.label -= Integer.MIN_VALUE;
            } else {
                c10451 = new C10451(continuation);
            }
        } else {
            c10451 = new C10451(continuation);
        }
        Object objIsLocal = c10451.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10451.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsLocal);
            c10451.L$0 = fileModel;
            c10451.label = 1;
            objIsLocal = isLocal(fileModel, c10451);
            if (objIsLocal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c10451.L$0;
            ResultKt.throwOnFailure(objIsLocal);
        }
        if (!((Boolean) objIsLocal).booleanValue() && ((permissions = fileModel.getPermissions()) == null || !permissions.getCanDelete())) {
            UserModel owner = fileModel.getOwner();
            z = !Intrinsics.areEqual(owner != null ? owner.getId() : null, this.userContextManager.getCurrentContextId()) && fileModel.isRooted();
        }
        return Boxing.boxBoolean(z);
    }

    public final boolean isViewContainingFolderEnabled(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        return fileModel.getParentFolder() != null || fileModel.isRooted();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isGalleryEnabled(PreviewSource previewSource, FileModel fileModel, Continuation<? super Boolean> continuation) {
        C10461 c10461;
        if (continuation instanceof C10461) {
            c10461 = (C10461) continuation;
            if ((c10461.label & Integer.MIN_VALUE) != 0) {
                c10461.label -= Integer.MIN_VALUE;
            } else {
                c10461 = new C10461(continuation);
            }
        } else {
            c10461 = new C10461(continuation);
        }
        Object objIsLocal = c10461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10461.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsLocal);
            c10461.L$0 = previewSource;
            c10461.L$1 = fileModel;
            c10461.label = 1;
            objIsLocal = isLocal(fileModel, c10461);
            if (objIsLocal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c10461.L$1;
            previewSource = (PreviewSource) c10461.L$0;
            ResultKt.throwOnFailure(objIsLocal);
        }
        return Boxing.boxBoolean(!((Boolean) objIsLocal).booleanValue() && this.galleryItemsService.isGalleryAvailable(previewSource, fileModel));
    }

    public final boolean isPlaylistEnabled(FileModel fileModel, PreviewSource previewSource) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        return this.audioPlaylistItemsService.isAudioPlaylistAvailable(fileModel, previewSource);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object moveOrCopyEnabled(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C10521 c10521;
        PermissionsModel permissions;
        if (continuation instanceof C10521) {
            c10521 = (C10521) continuation;
            if ((c10521.label & Integer.MIN_VALUE) != 0) {
                c10521.label -= Integer.MIN_VALUE;
            } else {
                c10521 = new C10521(continuation);
            }
        } else {
            c10521 = new C10521(continuation);
        }
        Object objIsLocal = c10521.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10521.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsLocal);
            c10521.L$0 = fileModel;
            c10521.label = 1;
            objIsLocal = isLocal(fileModel, c10521);
            if (objIsLocal == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) c10521.L$0;
            ResultKt.throwOnFailure(objIsLocal);
        }
        return Boxing.boxBoolean((((Boolean) objIsLocal).booleanValue() || (permissions = fileModel.getPermissions()) == null || !permissions.getCanDownload()) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isLocal(FileModel fileModel, Continuation<? super Boolean> continuation) {
        C10471 c10471;
        if (continuation instanceof C10471) {
            c10471 = (C10471) continuation;
            if ((c10471.label & Integer.MIN_VALUE) != 0) {
                c10471.label -= Integer.MIN_VALUE;
            } else {
                c10471 = new C10471(continuation);
            }
        } else {
            c10471 = new C10471(continuation);
        }
        Object remoteId = c10471.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10471.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remoteId);
            IdMappingService idMappingService = this.idMappingService;
            ItemId itemId = fileModel.getItemId();
            c10471.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
            c10471.label = 1;
            remoteId = idMappingService.getRemoteId(itemId, c10471);
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

    private final boolean isBoxNote(FileModel fileModel) {
        return SupportedFileExtensions.INSTANCE.isBoxNoteExtension(CommonBoxUtil.getFileExtension(fileModel.getName(), ""));
    }

    private final boolean isBoxCanvas(FileModel fileModel) {
        return SupportedFileExtensions.INSTANCE.isBoxCanvasExtension(CommonBoxUtil.getFileExtension(fileModel.getName(), ""));
    }

    public final boolean isPreviewOnly(PermissionsModel permissions) {
        return (permissions == null || !permissions.getCanPreview() || permissions.getCanDownload()) ? false : true;
    }
}
