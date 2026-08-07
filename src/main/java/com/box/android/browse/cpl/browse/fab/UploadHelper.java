package com.box.android.browse.cpl.browse.fab;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.box.android.base.analytics.UploadAnalyticsUtils;
import com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity;
import com.box.android.browse.R;
import com.box.android.common.extensions.ContextExtensionsKt;
import com.box.android.common.extensions.DialogConfig;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: UploadHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e2\u0006\u0010\u001f\u001a\u00020\u0015H\u0002J&\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0082@¢\u0006\u0002\u0010&J.\u0010'\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020%H\u0082@¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0002J\u001e\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020)2\u0006\u0010*\u001a\u00020%H\u0082@¢\u0006\u0002\u00100J\u001e\u00101\u001a\u0002022\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020%H\u0082@¢\u0006\u0002\u00100R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u00064"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/UploadHelper;", "", "remoteItemService", "Lcom/box/android/domain/services/IRemoteItemService;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "mainDispatcher", "<init>", "(Lcom/box/android/domain/services/IRemoteItemService;Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/domain/identity/IUserContextManager;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getDefaultDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getMainDispatcher", "doUpload", "", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "data", "Landroid/content/Intent;", "jobSource", "Lcom/box/android/domain/usecases/jobs/JobTags$JobSource;", "activity", "Landroid/app/Activity;", "logAnalytics", "extractUris", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "Lkotlin/collections/ArrayList;", "intent", "uploadFolder", "context", "Landroid/content/Context;", "folderUri", "parentFolderItemId", "Lcom/box/android/domain/models/ItemId$Remote;", "(Landroid/content/Context;Landroid/net/Uri;Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showFolderNameConflictDialog", BoxCommonConstants.EXTRA_FOLDER_NAME, "", IdentificationData.FIELD_PARENT_ID, "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatDisplayName", "name", "generateUniqueFolderName", "originalName", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasConflictingItem", "", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadHelper {
    private static final int MAX_DISPLAY_NAME_LENGTH = 10;
    private final CoroutineDispatcher defaultDispatcher;
    private final ILocalItemService localItemService;
    private final CoroutineDispatcher mainDispatcher;
    private final IRemoteItemService remoteItemService;
    private final IUserContextManager userContextManager;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.box.android.browse.cpl.browse.fab.UploadHelper$generateUniqueFolderName$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.browse.fab.UploadHelper", f = "UploadHelper.kt", i = {0, 0}, l = {181}, m = "generateUniqueFolderName", n = {"originalName", IdentificationData.FIELD_PARENT_ID}, s = {"L$0", "L$1"}, v = 1)
    static final class C09461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09461(Continuation<? super C09461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadHelper.this.generateUniqueFolderName(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.browse.fab.UploadHelper$hasConflictingItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.browse.fab.UploadHelper", f = "UploadHelper.kt", i = {0, 0, 1, 1}, l = {203, BoxCommonConstants.REQUEST_OPTIONS}, m = "hasConflictingItem", n = {BoxCommonConstants.EXTRA_FOLDER_NAME, IdentificationData.FIELD_PARENT_ID, BoxCommonConstants.EXTRA_FOLDER_NAME, IdentificationData.FIELD_PARENT_ID}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C09471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09471(Continuation<? super C09471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadHelper.this.hasConflictingItem(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.browse.fab.UploadHelper$uploadFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.browse.fab.UploadHelper", f = "UploadHelper.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {123, 124, Token.LABEL}, m = "uploadFolder", n = {"context", "folderUri", "parentFolderItemId", BoxCommonConstants.EXTRA_FOLDER_NAME, "context", "folderUri", "parentFolderItemId", BoxCommonConstants.EXTRA_FOLDER_NAME, "context", "folderUri", "parentFolderItemId", BoxCommonConstants.EXTRA_FOLDER_NAME}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C09481 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C09481(Continuation<? super C09481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadHelper.this.uploadFolder(null, null, null, this);
        }
    }

    @Inject
    public UploadHelper(IRemoteItemService remoteItemService, ILocalItemService localItemService, IUserContextManager userContextManager, CoroutineDispatcher defaultDispatcher, CoroutineDispatcher mainDispatcher) {
        Intrinsics.checkNotNullParameter(remoteItemService, "remoteItemService");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(defaultDispatcher, "defaultDispatcher");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.remoteItemService = remoteItemService;
        this.localItemService = localItemService;
        this.userContextManager = userContextManager;
        this.defaultDispatcher = defaultDispatcher;
        this.mainDispatcher = mainDispatcher;
    }

    public final CoroutineDispatcher getDefaultDispatcher() {
        return this.defaultDispatcher;
    }

    public final CoroutineDispatcher getMainDispatcher() {
        return this.mainDispatcher;
    }

    public final void doUpload(FolderModel folder, Intent data, JobTags.JobSource jobSource, Activity activity) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(jobSource, "jobSource");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof BoxSpinnerDialogFragmentActivity) {
            logAnalytics(jobSource);
            ((BoxSpinnerDialogFragmentActivity) activity).showSpinner();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.defaultDispatcher), null, null, new AnonymousClass1(data, jobSource, activity, folder, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.browse.fab.UploadHelper$doUpload$1, reason: invalid class name */
    /* JADX INFO: compiled from: UploadHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.browse.fab.UploadHelper$doUpload$1", f = "UploadHelper.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {69, 82}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "uris", "folderUri", "$i$a$-runCatching-UploadHelper$doUpload$1$1", "$this$launch", "$this$invokeSuspend_u24lambda_u240", "uris", "intent", "$i$a$-runCatching-UploadHelper$doUpload$1$1"}, s = {"L$0", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Intent $data;
        final /* synthetic */ FolderModel $folder;
        final /* synthetic */ JobTags.JobSource $jobSource;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Intent intent, JobTags.JobSource jobSource, Activity activity, FolderModel folderModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$data = intent;
            this.$jobSource = jobSource;
            this.$activity = activity;
            this.$folder = folderModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = UploadHelper.this.new AnonymousClass1(this.$data, this.$jobSource, this.$activity, this.$folder, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x00f4, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r12, r6, r11) == r2) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 307
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.browse.cpl.browse.fab.UploadHelper.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void logAnalytics(JobTags.JobSource jobSource) {
        if (jobSource == JobTags.JobSource.FAB_FILE) {
            UploadAnalyticsUtils.newUploadFlowCtaEventBuilder().setPageExperience(BoxAnalyticsParams.PAGE_EXPERIENCE_MULTIPLE_FILES_UPLOAD).logEvent(BoxAnalyticsParams.EVENT_UPLOAD_TRIGGERED);
        } else if (jobSource == JobTags.JobSource.FAB_FOLDER) {
            UploadAnalyticsUtils.newUploadFlowCtaEventBuilder().setPageExperience("folder").logEvent(BoxAnalyticsParams.EVENT_FOLDER_UPLOAD_TRIGGERED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<Uri> extractUris(Intent intent) {
        ArrayList<Uri> arrayList = new ArrayList<>();
        Uri data = intent.getData();
        ClipData clipData = intent.getClipData();
        if (clipData == null && data != null) {
            arrayList.add(data);
            return arrayList;
        }
        if (clipData != null) {
            int itemCount = clipData.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                arrayList.add(clipData.getItemAt(i).getUri());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00cd, code lost:
    
        if (showFolderNameConflictDialog(r10, r11, r4, r5, r6) == r0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0102, code lost:
    
        if (com.box.android.domain.services.ILocalItemService.uploadFolder$default(r1, r2, r5, r3, null, r6, 8, null) == r0) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadFolder(android.content.Context r10, android.net.Uri r11, com.box.android.domain.models.ItemId.Remote r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.browse.cpl.browse.fab.UploadHelper.uploadFolder(android.content.Context, android.net.Uri, com.box.android.domain.models.ItemId$Remote, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.browse.fab.UploadHelper$showFolderNameConflictDialog$2, reason: invalid class name */
    /* JADX INFO: compiled from: UploadHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.browse.fab.UploadHelper$showFolderNameConflictDialog$2", f = "UploadHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $displayName;
        final /* synthetic */ String $folderName;
        final /* synthetic */ Uri $folderUri;
        final /* synthetic */ ItemId.Remote $parentId;
        int label;
        final /* synthetic */ UploadHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Context context, UploadHelper uploadHelper, String str2, ItemId.Remote remote, Uri uri, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$displayName = str;
            this.$context = context;
            this.this$0 = uploadHelper;
            this.$folderName = str2;
            this.$parentId = remote;
            this.$folderUri = uri;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$displayName, this.$context, this.this$0, this.$folderName, this.$parentId, this.$folderUri, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i = R.string.folder_conflict;
            String strLS = CommonBoxUtil.LS(R.string.conflicting_folder, this.$displayName);
            int i2 = R.string.merge_folders;
            final UploadHelper uploadHelper = this.this$0;
            final String str = this.$folderName;
            final ItemId.Remote remote = this.$parentId;
            final Uri uri = this.$folderUri;
            Function0 function0 = new Function0() { // from class: com.box.android.browse.cpl.browse.fab.UploadHelper$showFolderNameConflictDialog$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UploadHelper.AnonymousClass2.invokeSuspend$lambda$0(uploadHelper, str, remote, uri);
                }
            };
            int i3 = R.string.save_as_new;
            final UploadHelper uploadHelper2 = this.this$0;
            final String str2 = this.$folderName;
            final ItemId.Remote remote2 = this.$parentId;
            final Uri uri2 = this.$folderUri;
            ContextExtensionsKt.showAlertDialog(this.$context, new DialogConfig(i, strLS, i2, function0, i3, new Function0() { // from class: com.box.android.browse.cpl.browse.fab.UploadHelper$showFolderNameConflictDialog$2$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UploadHelper.AnonymousClass2.invokeSuspend$lambda$1(uploadHelper2, str2, remote2, uri2);
                }
            }, Boxing.boxInt(R.string.Skip), null, null, 384, null));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(UploadHelper uploadHelper, String str, ItemId.Remote remote, Uri uri) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(uploadHelper.getDefaultDispatcher()), null, null, new UploadHelper$showFolderNameConflictDialog$2$dialogConfig$1$1(uploadHelper, str, remote, uri, null), 3, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(UploadHelper uploadHelper, String str, ItemId.Remote remote, Uri uri) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(uploadHelper.getDefaultDispatcher()), null, null, new UploadHelper$showFolderNameConflictDialog$2$dialogConfig$2$1(uploadHelper, str, remote, uri, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showFolderNameConflictDialog(Context context, Uri uri, String str, ItemId.Remote remote, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.mainDispatcher, new AnonymousClass2(formatDisplayName(str), context, this, str, remote, uri, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    private final String formatDisplayName(String name) {
        if (name.length() > 10) {
            return "\"" + StringsKt.take(name, 10) + "...\"";
        }
        return "\"" + name + "\"";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object generateUniqueFolderName(String str, ItemId.Remote remote, Continuation<? super String> continuation) {
        C09461 c09461;
        if (continuation instanceof C09461) {
            c09461 = (C09461) continuation;
            if ((c09461.label & Integer.MIN_VALUE) != 0) {
                c09461.label -= Integer.MIN_VALUE;
            } else {
                c09461 = new C09461(continuation);
            }
        } else {
            c09461 = new C09461(continuation);
        }
        Object objFirst = c09461.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09461.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFirst);
            Flow<Result<List<ItemModel>, DomainError>> flowItems = this.remoteItemService.items(remote);
            c09461.L$0 = str;
            c09461.L$1 = SpillingKt.nullOutSpilledVariable(remote);
            c09461.label = 1;
            objFirst = FlowKt.first(flowItems, c09461);
            if (objFirst == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c09461.L$0;
            ResultKt.throwOnFailure(objFirst);
        }
        List listEmptyList = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objFirst);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List list = listEmptyList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ItemModel) it.next()).getName());
        }
        Set set = CollectionsKt.toSet(arrayList);
        String str2 = str;
        int i2 = 1;
        while (set.contains(str2)) {
            str2 = str + "_" + i2;
            i2++;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:38:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:? A[LOOP:0: B:39:0x00cf->B:47:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object hasConflictingItem(String str, ItemId.Remote remote, Continuation<? super Boolean> continuation) {
        C09471 c09471;
        String str2;
        List listEmptyList;
        List list;
        Iterator it;
        if (continuation instanceof C09471) {
            c09471 = (C09471) continuation;
            if ((c09471.label & Integer.MIN_VALUE) != 0) {
                c09471.label -= Integer.MIN_VALUE;
            } else {
                c09471 = new C09471(continuation);
            }
        } else {
            c09471 = new C09471(continuation);
        }
        Object objFetchFolderItemsFromRemote = c09471.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09471.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchFolderItemsFromRemote);
            IRemoteItemService iRemoteItemService = this.remoteItemService;
            c09471.L$0 = str;
            c09471.L$1 = remote;
            c09471.label = 1;
            objFetchFolderItemsFromRemote = iRemoteItemService.fetchFolderItemsFromRemote(remote, (Continuation<? super Result<Unit, ? extends DomainError>>) c09471);
            if (objFetchFolderItemsFromRemote != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            remote = (ItemId.Remote) c09471.L$1;
            str = (String) c09471.L$0;
            ResultKt.throwOnFailure(objFetchFolderItemsFromRemote);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) c09471.L$0;
            ResultKt.throwOnFailure(objFetchFolderItemsFromRemote);
        }
        listEmptyList = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objFetchFolderItemsFromRemote);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        list = listEmptyList;
        if ((list instanceof Collection) || !list.isEmpty()) {
            it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((ItemModel) it.next()).getName(), str2)) {
                }
            }
            z = false;
        } else {
            z = false;
        }
        return Boxing.boxBoolean(z);
        Result result = (Result) objFetchFolderItemsFromRemote;
        if (!(result instanceof Result.Success)) {
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            DomainError domainError = (DomainError) ((Result.Error) result).getValue();
            String name = UploadHelper.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            BoxLogUtils.e(name, "Error fetching items from remote: " + domainError);
        }
        Flow<Result<List<ItemModel>, DomainError>> flowItems = this.remoteItemService.items(remote);
        c09471.L$0 = str;
        c09471.L$1 = SpillingKt.nullOutSpilledVariable(remote);
        c09471.label = 2;
        objFetchFolderItemsFromRemote = FlowKt.first(flowItems, c09471);
        if (objFetchFolderItemsFromRemote != coroutine_suspended) {
            str2 = str;
            listEmptyList = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objFetchFolderItemsFromRemote);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            list = listEmptyList;
            if (list instanceof Collection) {
                it = list.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((ItemModel) it.next()).getName(), str2)) {
                    }
                }
                z = false;
            } else {
                it = list.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((ItemModel) it.next()).getName(), str2)) {
                    }
                }
                z = false;
            }
            return Boxing.boxBoolean(z);
        }
        return coroutine_suspended;
    }
}
