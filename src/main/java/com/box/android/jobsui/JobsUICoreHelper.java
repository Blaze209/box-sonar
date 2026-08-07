package com.box.android.jobsui;

import android.graphics.Bitmap;
import android.net.Uri;
import com.box.android.base.compose.ItemThumbnail;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.adapters.BoxItemBrowseViewHolder;
import com.box.android.base.presentation.utilities.SupportedFileExtensionIcons;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.RealPathUtils;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.mappers.RecentFileModelMapper;
import com.box.android.domain.models.DisplayableJobKt;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IJobDisplayInfoProvider;
import com.box.android.domain.models.ItemDescriptor;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.LegacyJobModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.androidsdk.content.SizeUtils;
import com.box.androidsdk.content.utils.BoxLogUtils;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Arrays;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: JobsUICoreHelper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J0\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u0011J \u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019J6\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0007H\u0002J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020'¨\u0006("}, d2 = {"Lcom/box/android/jobsui/JobsUICoreHelper;", "", "<init>", "()V", "getScaledBitmap", "Lcom/box/android/base/compose/ItemThumbnail$PreviewThumbnail;", "contentUrl", "", "getJobState", "Lcom/box/android/jobsui/JobItemReducer$State;", "jobInfo", "Lcom/box/android/domain/models/JobInfo;", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "oldThumbnailFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/box/android/base/compose/ItemThumbnail;", "(Lcom/box/android/domain/models/JobInfo;Lcom/box/android/base/presentation/ThumbnailManager;Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThumbnailFromFileModel", "item", "Lcom/box/android/domain/models/item/FileModel;", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/base/presentation/ThumbnailManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThumbnailFromUri", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJobStateFromLegacyJob", "legacyJobModel", "Lcom/box/android/domain/models/LegacyJobModel;", "groupId", "(Lcom/box/android/domain/models/LegacyJobModel;Ljava/lang/String;Lcom/box/android/base/presentation/ThumbnailManager;Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJobTypeIconRes", "", "jobType", "getDefaultIcon", "Lcom/box/android/base/compose/ItemThumbnail$Icon;", "itemDescriptor", "Lcom/box/android/domain/models/ItemDescriptor;", "logRunningJobDeleted", "", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobsUICoreHelper {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: com.box.android.jobsui.JobsUICoreHelper$getJobState$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobsUICoreHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.jobsui.JobsUICoreHelper", f = "JobsUICoreHelper.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6}, l = {46, 49, 50, 53, 54, 59, 84}, m = "getJobState", n = {"jobInfo", "thumbnailManager", "oldThumbnailFlow", "infoProvider", "jobInfo", "thumbnailManager", "oldThumbnailFlow", "infoProvider", "itemModel", "jobInfo", "thumbnailManager", "oldThumbnailFlow", "infoProvider", "itemModel", "contentUrl", "jobInfo", "thumbnailManager", "oldThumbnailFlow", "infoProvider", "itemModel", "contentUrl", "serverID", "jobInfo", "thumbnailManager", "oldThumbnailFlow", "infoProvider", "itemModel", "contentUrl", "serverID", "jobInfo", "thumbnailManager", "oldThumbnailFlow", "infoProvider", "itemModel", "contentUrl", "serverID", "jobInfo", "thumbnailManager", "oldThumbnailFlow", "infoProvider", "itemModel", "contentUrl", "serverID"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
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

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsUICoreHelper.this.getJobState(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.jobsui.JobsUICoreHelper$getJobStateFromLegacyJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsUICoreHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.jobsui.JobsUICoreHelper", f = "JobsUICoreHelper.kt", i = {0, 0, 0, 0, 0, 0}, l = {Token.COMMENT}, m = "getJobStateFromLegacyJob", n = {"legacyJobModel", "groupId", "thumbnailManager", "oldThumbnailFlow", "$this$getJobStateFromLegacyJob_u24lambda_u240", "$i$a$-with-JobsUICoreHelper$getJobStateFromLegacyJob$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
    static final class C16561 extends ContinuationImpl {
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

        C16561(Continuation<? super C16561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsUICoreHelper.this.getJobStateFromLegacyJob(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.jobsui.JobsUICoreHelper$getThumbnailFromFileModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsUICoreHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.jobsui.JobsUICoreHelper", f = "JobsUICoreHelper.kt", i = {0, 0}, l = {116}, m = "getThumbnailFromFileModel", n = {"item", "thumbnailManager"}, s = {"L$0", "L$1"}, v = 1)
    static final class C16571 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C16571(Continuation<? super C16571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobsUICoreHelper.this.getThumbnailFromFileModel(null, null, this);
        }
    }

    @Inject
    public JobsUICoreHelper() {
    }

    public final ItemThumbnail.PreviewThumbnail getScaledBitmap(String contentUrl) {
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        Bitmap scaledBitmap$default = CommonBoxUtil.getScaledBitmap$default(CommonBoxUtil.INSTANCE, contentUrl, 0, 2, null);
        if (scaledBitmap$default != null) {
            return new ItemThumbnail.PreviewThumbnail(scaledBitmap$default);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0382  */
    /* JADX WARN: Code duplicated, block: B:102:0x0388  */
    /* JADX WARN: Code duplicated, block: B:110:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:63:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:67:0x0203  */
    /* JADX WARN: Code duplicated, block: B:70:0x023c  */
    /* JADX WARN: Code duplicated, block: B:71:0x023e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0261  */
    /* JADX WARN: Code duplicated, block: B:75:0x0263  */
    /* JADX WARN: Code duplicated, block: B:78:0x0272 A[Catch: Exception -> 0x0148, TryCatch #5 {Exception -> 0x0148, blocks: (B:82:0x02ad, B:76:0x026d, B:78:0x0272, B:84:0x02d3, B:72:0x0244, B:33:0x013e, B:68:0x020c), top: B:113:0x013e }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x029f  */
    /* JADX WARN: Code duplicated, block: B:81:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:83:0x02d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x02d3 A[Catch: Exception -> 0x0148, TRY_LEAVE, TryCatch #5 {Exception -> 0x0148, blocks: (B:82:0x02ad, B:76:0x026d, B:78:0x0272, B:84:0x02d3, B:72:0x0244, B:33:0x013e, B:68:0x020c), top: B:113:0x013e }] */
    /* JADX WARN: Code duplicated, block: B:87:0x030c  */
    /* JADX WARN: Code duplicated, block: B:92:0x035d  */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x016d: MOVE (r11 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:42:0x016b */
    public final Object getJobState(JobInfo jobInfo, ThumbnailManager thumbnailManager, StateFlow<? extends ItemThumbnail> stateFlow, Continuation<? super JobItemReducer.State> continuation) {
        AnonymousClass1 anonymousClass1;
        Object obj;
        JobInfo jobInfo2;
        JobInfo jobInfo3;
        JobInfo jobInfo4;
        ThumbnailManager thumbnailManager2;
        StateFlow<? extends ItemThumbnail> stateFlow2;
        IJobDisplayInfoProvider iJobDisplayInfoProvider;
        FileModel fileModel;
        Object contentUrl;
        ItemModel itemModel;
        ThumbnailManager thumbnailManager3;
        String str;
        Object serverId;
        String str2;
        StateFlow<? extends ItemThumbnail> stateFlow3;
        ThumbnailManager thumbnailManager4;
        IJobDisplayInfoProvider iJobDisplayInfoProvider2;
        ItemModel itemModel2;
        String str3;
        JobItemId jobItemId;
        ThumbnailManager thumbnailManager5;
        StateFlow<? extends ItemThumbnail> stateFlow4;
        JobItemId jobItemId2;
        ThumbnailManager thumbnailManager6;
        String str4;
        Object itemDescription;
        String str5;
        StateFlow<? extends ItemThumbnail> stateFlow5;
        JobItemId jobItemId3;
        String str6;
        ThumbnailManager thumbnailManager7;
        final IJobDisplayInfoProvider iJobDisplayInfoProvider3;
        String str7;
        ItemModel itemModel3;
        StateFlow<? extends ItemThumbnail> stateFlowStateIn;
        String str8;
        ThumbnailManager thumbnailManager8;
        String str9;
        String str10;
        SupportedFileExtensionIcons supportedFileExtensionIcons;
        Object name;
        SupportedFileExtensionIcons supportedFileExtensionIcons2;
        String str11;
        JobItemId jobItemId4;
        ItemModel itemModel4;
        String str12;
        int iconResId;
        String str13;
        JobItemId jobItemId5;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object name2 = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (anonymousClass2.label) {
                case 0:
                    ResultKt.throwOnFailure(name2);
                    IJobDisplayInfoProvider infoProvider = jobInfo.getInfoProvider();
                    Intrinsics.checkNotNull(infoProvider);
                    jobInfo4 = jobInfo;
                    try {
                        anonymousClass2.L$0 = jobInfo4;
                        thumbnailManager2 = thumbnailManager;
                        anonymousClass2.L$1 = thumbnailManager2;
                        stateFlow2 = stateFlow;
                        anonymousClass2.L$2 = stateFlow2;
                        anonymousClass2.L$3 = infoProvider;
                        anonymousClass2.label = 1;
                        Object itemModel5 = infoProvider.getItemModel(anonymousClass2);
                        if (itemModel5 != coroutine_suspended) {
                            iJobDisplayInfoProvider = infoProvider;
                            name2 = itemModel5;
                            fileModel = (ItemModel) name2;
                            if (fileModel instanceof RecentFileModel) {
                                try {
                                    fileModel = RecentFileModelMapper.INSTANCE.toFileModel((RecentFileModel) fileModel);
                                } catch (Exception e) {
                                    e = e;
                                    jobInfo3 = jobInfo4;
                                    obj = null;
                                    if (JobKt.isActive(anonymousClass2.getContext())) {
                                        BoxLogUtils.e("Returning null for JobState due to Exception:" + e + " JobId:" + jobInfo3.getId() + " JobType:" + jobInfo3.getJobType() + " ");
                                    } else {
                                        BoxLogUtils.e("Returning null for JobState earlier due to coroutineContext no longer being active while constructing JobState");
                                    }
                                    return obj;
                                }
                            }
                            anonymousClass2.L$0 = jobInfo4;
                            anonymousClass2.L$1 = thumbnailManager2;
                            anonymousClass2.L$2 = stateFlow2;
                            anonymousClass2.L$3 = iJobDisplayInfoProvider;
                            anonymousClass2.L$4 = fileModel;
                            anonymousClass2.label = 2;
                            contentUrl = DisplayableJobKt.getContentUrl(iJobDisplayInfoProvider, anonymousClass2);
                            if (contentUrl == coroutine_suspended) {
                                ThumbnailManager thumbnailManager9 = thumbnailManager2;
                                itemModel = fileModel;
                                name2 = contentUrl;
                                thumbnailManager3 = thumbnailManager9;
                                str = (String) name2;
                                anonymousClass2.L$0 = jobInfo4;
                                anonymousClass2.L$1 = thumbnailManager3;
                                anonymousClass2.L$2 = stateFlow2;
                                anonymousClass2.L$3 = iJobDisplayInfoProvider;
                                anonymousClass2.L$4 = itemModel;
                                anonymousClass2.L$5 = str;
                                anonymousClass2.label = 3;
                                serverId = iJobDisplayInfoProvider.getServerId(anonymousClass2);
                                if (serverId != coroutine_suspended) {
                                    StateFlow<? extends ItemThumbnail> stateFlow6 = stateFlow2;
                                    str2 = str;
                                    name2 = serverId;
                                    jobInfo3 = jobInfo4;
                                    stateFlow3 = stateFlow6;
                                    thumbnailManager4 = thumbnailManager3;
                                    iJobDisplayInfoProvider2 = iJobDisplayInfoProvider;
                                    itemModel2 = itemModel;
                                    str3 = (String) name2;
                                    jobItemId = new JobItemId(jobInfo3.getId().getIdentifier(), false, null, 4, null);
                                    anonymousClass2.L$0 = jobInfo3;
                                    anonymousClass2.L$1 = thumbnailManager4;
                                    anonymousClass2.L$2 = stateFlow3;
                                    anonymousClass2.L$3 = iJobDisplayInfoProvider2;
                                    anonymousClass2.L$4 = itemModel2;
                                    anonymousClass2.L$5 = str2;
                                    anonymousClass2.L$6 = str3;
                                    anonymousClass2.L$7 = jobItemId;
                                    anonymousClass2.label = 4;
                                    name2 = iJobDisplayInfoProvider2.getName(anonymousClass2);
                                    if (name2 == coroutine_suspended) {
                                        thumbnailManager5 = thumbnailManager4;
                                        stateFlow4 = stateFlow3;
                                        jobItemId2 = jobItemId;
                                        thumbnailManager6 = thumbnailManager5;
                                        str4 = (String) name2;
                                        anonymousClass2.L$0 = jobInfo3;
                                        anonymousClass2.L$1 = thumbnailManager6;
                                        anonymousClass2.L$2 = stateFlow4;
                                        anonymousClass2.L$3 = iJobDisplayInfoProvider2;
                                        anonymousClass2.L$4 = itemModel2;
                                        anonymousClass2.L$5 = str2;
                                        anonymousClass2.L$6 = str3;
                                        anonymousClass2.L$7 = jobItemId2;
                                        anonymousClass2.L$8 = str4;
                                        anonymousClass2.label = 5;
                                        itemDescription = iJobDisplayInfoProvider2.getItemDescription(anonymousClass2);
                                        if (itemDescription != coroutine_suspended) {
                                            IJobDisplayInfoProvider iJobDisplayInfoProvider4 = iJobDisplayInfoProvider2;
                                            str5 = str4;
                                            name2 = itemDescription;
                                            stateFlow5 = stateFlow4;
                                            jobItemId3 = jobItemId2;
                                            str6 = str2;
                                            thumbnailManager7 = thumbnailManager6;
                                            iJobDisplayInfoProvider3 = iJobDisplayInfoProvider4;
                                            str7 = (String) name2;
                                            if (itemModel2 != null) {
                                                supportedFileExtensionIcons = SupportedFileExtensionIcons.INSTANCE;
                                                anonymousClass2.L$0 = jobInfo3;
                                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager7);
                                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                                anonymousClass2.L$3 = iJobDisplayInfoProvider3;
                                                anonymousClass2.L$4 = itemModel2;
                                                anonymousClass2.L$5 = str6;
                                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                                anonymousClass2.L$7 = jobItemId3;
                                                anonymousClass2.L$8 = str5;
                                                anonymousClass2.L$9 = str7;
                                                anonymousClass2.L$10 = supportedFileExtensionIcons;
                                                anonymousClass2.label = 6;
                                                name = iJobDisplayInfoProvider3.getName(anonymousClass2);
                                                if (name == coroutine_suspended) {
                                                    String str14 = str6;
                                                    supportedFileExtensionIcons2 = supportedFileExtensionIcons;
                                                    name2 = name;
                                                    str11 = str7;
                                                    thumbnailManager8 = thumbnailManager7;
                                                    jobItemId4 = jobItemId3;
                                                    itemModel4 = itemModel2;
                                                    str3 = str3;
                                                    str12 = str5;
                                                    str10 = str14;
                                                    obj = null;
                                                    itemModel3 = itemModel4;
                                                    jobItemId3 = jobItemId4;
                                                    str9 = str12;
                                                    str8 = str11;
                                                    stateFlowStateIn = StateFlowKt.MutableStateFlow(new ItemThumbnail.Icon(supportedFileExtensionIcons2.findFileIcon(CommonBoxUtil.getFileExtension((String) name2, "")).getDrawable(), null, 2, null));
                                                    iconResId = iJobDisplayInfoProvider3.getIconResId();
                                                    Flow<JobInfo.Status> status = jobInfo3.getStatus();
                                                    Function1 function1 = new Function1() { // from class: com.box.android.jobsui.JobsUICoreHelper$$ExternalSyntheticLambda0
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj2) {
                                                            return JobsUICoreHelper.getJobState$lambda$1(iJobDisplayInfoProvider3, (DomainError) obj2);
                                                        }
                                                    };
                                                    anonymousClass2.L$0 = jobInfo3;
                                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager8);
                                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(iJobDisplayInfoProvider3);
                                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel3);
                                                    anonymousClass2.L$5 = str10;
                                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                                    anonymousClass2.L$7 = jobItemId3;
                                                    anonymousClass2.L$8 = str9;
                                                    anonymousClass2.L$9 = str8;
                                                    anonymousClass2.L$10 = stateFlowStateIn;
                                                    anonymousClass2.L$11 = itemModel3;
                                                    anonymousClass2.I$0 = iconResId;
                                                    anonymousClass2.label = 7;
                                                    name2 = JobsUICoreHelperKt.mapJobInfoStatusForUI(status, function1, anonymousClass2);
                                                    if (name2 != coroutine_suspended) {
                                                        str13 = str10;
                                                        jobItemId5 = jobItemId3;
                                                        return new JobItemReducer.State(jobItemId5, str9, str8, stateFlowStateIn, itemModel3, iconResId, (StateFlow) name2, false, str13, 128, null);
                                                    }
                                                }
                                            } else {
                                                if (stateFlow5 == null) {
                                                    itemModel3 = itemModel2;
                                                    obj = null;
                                                    try {
                                                        stateFlowStateIn = FlowKt.stateIn(FlowKt.flow(new AnonymousClass2(str6, itemModel3, this, str3, thumbnailManager7, null)), CoroutineScopeKt.CoroutineScope(anonymousClass2.getContext()), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), getDefaultIcon(new ItemDescriptor.ExistingBoxItem(itemModel3)));
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        if (JobKt.isActive(anonymousClass2.getContext())) {
                                                            BoxLogUtils.e("Returning null for JobState earlier due to coroutineContext no longer being active while constructing JobState");
                                                        } else {
                                                            BoxLogUtils.e("Returning null for JobState due to Exception:" + e + " JobId:" + jobInfo3.getId() + " JobType:" + jobInfo3.getJobType() + " ");
                                                        }
                                                        return obj;
                                                    }
                                                } else {
                                                    itemModel3 = itemModel2;
                                                    obj = null;
                                                    stateFlowStateIn = stateFlow5;
                                                }
                                                str8 = str7;
                                                thumbnailManager8 = thumbnailManager7;
                                                str9 = str5;
                                                str10 = str6;
                                                iconResId = iJobDisplayInfoProvider3.getIconResId();
                                                Flow<JobInfo.Status> status2 = jobInfo3.getStatus();
                                                Function1 function2 = new Function1() { // from class: com.box.android.jobsui.JobsUICoreHelper$$ExternalSyntheticLambda0
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj2) {
                                                        return JobsUICoreHelper.getJobState$lambda$1(iJobDisplayInfoProvider3, (DomainError) obj2);
                                                    }
                                                };
                                                anonymousClass2.L$0 = jobInfo3;
                                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager8);
                                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(iJobDisplayInfoProvider3);
                                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel3);
                                                anonymousClass2.L$5 = str10;
                                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                                anonymousClass2.L$7 = jobItemId3;
                                                anonymousClass2.L$8 = str9;
                                                anonymousClass2.L$9 = str8;
                                                anonymousClass2.L$10 = stateFlowStateIn;
                                                anonymousClass2.L$11 = itemModel3;
                                                anonymousClass2.I$0 = iconResId;
                                                anonymousClass2.label = 7;
                                                name2 = JobsUICoreHelperKt.mapJobInfoStatusForUI(status2, function2, anonymousClass2);
                                                if (name2 != coroutine_suspended) {
                                                    str13 = str10;
                                                    jobItemId5 = jobItemId3;
                                                    return new JobItemReducer.State(jobItemId5, str9, str8, stateFlowStateIn, itemModel3, iconResId, (StateFlow) name2, false, str13, 128, null);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        }
                        return coroutine_suspended;
                    } catch (Exception e3) {
                        e = e3;
                        obj = null;
                        jobInfo3 = jobInfo4;
                        if (JobKt.isActive(anonymousClass2.getContext())) {
                            BoxLogUtils.e("Returning null for JobState earlier due to coroutineContext no longer being active while constructing JobState");
                        } else {
                            BoxLogUtils.e("Returning null for JobState due to Exception:" + e + " JobId:" + jobInfo3.getId() + " JobType:" + jobInfo3.getJobType() + " ");
                        }
                        return obj;
                    }
                case 1:
                    IJobDisplayInfoProvider iJobDisplayInfoProvider5 = (IJobDisplayInfoProvider) anonymousClass2.L$3;
                    StateFlow<? extends ItemThumbnail> stateFlow7 = (StateFlow) anonymousClass2.L$2;
                    ThumbnailManager thumbnailManager10 = (ThumbnailManager) anonymousClass2.L$1;
                    JobInfo jobInfo5 = (JobInfo) anonymousClass2.L$0;
                    try {
                        ResultKt.throwOnFailure(name2);
                        iJobDisplayInfoProvider = iJobDisplayInfoProvider5;
                        jobInfo4 = jobInfo5;
                        stateFlow2 = stateFlow7;
                        thumbnailManager2 = thumbnailManager10;
                        fileModel = (ItemModel) name2;
                        if (fileModel instanceof RecentFileModel) {
                            fileModel = RecentFileModelMapper.INSTANCE.toFileModel((RecentFileModel) fileModel);
                            break;
                        }
                        anonymousClass2.L$0 = jobInfo4;
                        anonymousClass2.L$1 = thumbnailManager2;
                        anonymousClass2.L$2 = stateFlow2;
                        anonymousClass2.L$3 = iJobDisplayInfoProvider;
                        anonymousClass2.L$4 = fileModel;
                        anonymousClass2.label = 2;
                        contentUrl = DisplayableJobKt.getContentUrl(iJobDisplayInfoProvider, anonymousClass2);
                        if (contentUrl == coroutine_suspended) {
                            ThumbnailManager thumbnailManager11 = thumbnailManager2;
                            itemModel = fileModel;
                            name2 = contentUrl;
                            thumbnailManager3 = thumbnailManager11;
                            str = (String) name2;
                            anonymousClass2.L$0 = jobInfo4;
                            anonymousClass2.L$1 = thumbnailManager3;
                            anonymousClass2.L$2 = stateFlow2;
                            anonymousClass2.L$3 = iJobDisplayInfoProvider;
                            anonymousClass2.L$4 = itemModel;
                            anonymousClass2.L$5 = str;
                            anonymousClass2.label = 3;
                            serverId = iJobDisplayInfoProvider.getServerId(anonymousClass2);
                            if (serverId != coroutine_suspended) {
                                StateFlow<? extends ItemThumbnail> stateFlow8 = stateFlow2;
                                str2 = str;
                                name2 = serverId;
                                jobInfo3 = jobInfo4;
                                stateFlow3 = stateFlow8;
                                thumbnailManager4 = thumbnailManager3;
                                iJobDisplayInfoProvider2 = iJobDisplayInfoProvider;
                                itemModel2 = itemModel;
                                str3 = (String) name2;
                                jobItemId = new JobItemId(jobInfo3.getId().getIdentifier(), false, null, 4, null);
                                anonymousClass2.L$0 = jobInfo3;
                                anonymousClass2.L$1 = thumbnailManager4;
                                anonymousClass2.L$2 = stateFlow3;
                                anonymousClass2.L$3 = iJobDisplayInfoProvider2;
                                anonymousClass2.L$4 = itemModel2;
                                anonymousClass2.L$5 = str2;
                                anonymousClass2.L$6 = str3;
                                anonymousClass2.L$7 = jobItemId;
                                anonymousClass2.label = 4;
                                name2 = iJobDisplayInfoProvider2.getName(anonymousClass2);
                                if (name2 == coroutine_suspended) {
                                    thumbnailManager5 = thumbnailManager4;
                                    stateFlow4 = stateFlow3;
                                    jobItemId2 = jobItemId;
                                    thumbnailManager6 = thumbnailManager5;
                                    str4 = (String) name2;
                                    anonymousClass2.L$0 = jobInfo3;
                                    anonymousClass2.L$1 = thumbnailManager6;
                                    anonymousClass2.L$2 = stateFlow4;
                                    anonymousClass2.L$3 = iJobDisplayInfoProvider2;
                                    anonymousClass2.L$4 = itemModel2;
                                    anonymousClass2.L$5 = str2;
                                    anonymousClass2.L$6 = str3;
                                    anonymousClass2.L$7 = jobItemId2;
                                    anonymousClass2.L$8 = str4;
                                    anonymousClass2.label = 5;
                                    itemDescription = iJobDisplayInfoProvider2.getItemDescription(anonymousClass2);
                                    if (itemDescription != coroutine_suspended) {
                                        IJobDisplayInfoProvider iJobDisplayInfoProvider6 = iJobDisplayInfoProvider2;
                                        str5 = str4;
                                        name2 = itemDescription;
                                        stateFlow5 = stateFlow4;
                                        jobItemId3 = jobItemId2;
                                        str6 = str2;
                                        thumbnailManager7 = thumbnailManager6;
                                        iJobDisplayInfoProvider3 = iJobDisplayInfoProvider6;
                                        str7 = (String) name2;
                                        if (itemModel2 != null) {
                                            supportedFileExtensionIcons = SupportedFileExtensionIcons.INSTANCE;
                                            anonymousClass2.L$0 = jobInfo3;
                                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager7);
                                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                            anonymousClass2.L$3 = iJobDisplayInfoProvider3;
                                            anonymousClass2.L$4 = itemModel2;
                                            anonymousClass2.L$5 = str6;
                                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                            anonymousClass2.L$7 = jobItemId3;
                                            anonymousClass2.L$8 = str5;
                                            anonymousClass2.L$9 = str7;
                                            anonymousClass2.L$10 = supportedFileExtensionIcons;
                                            anonymousClass2.label = 6;
                                            name = iJobDisplayInfoProvider3.getName(anonymousClass2);
                                            if (name == coroutine_suspended) {
                                                String str15 = str6;
                                                supportedFileExtensionIcons2 = supportedFileExtensionIcons;
                                                name2 = name;
                                                str11 = str7;
                                                thumbnailManager8 = thumbnailManager7;
                                                jobItemId4 = jobItemId3;
                                                itemModel4 = itemModel2;
                                                str3 = str3;
                                                str12 = str5;
                                                str10 = str15;
                                                obj = null;
                                                itemModel3 = itemModel4;
                                                jobItemId3 = jobItemId4;
                                                str9 = str12;
                                                str8 = str11;
                                                stateFlowStateIn = StateFlowKt.MutableStateFlow(new ItemThumbnail.Icon(supportedFileExtensionIcons2.findFileIcon(CommonBoxUtil.getFileExtension((String) name2, "")).getDrawable(), null, 2, null));
                                                iconResId = iJobDisplayInfoProvider3.getIconResId();
                                                Flow<JobInfo.Status> status3 = jobInfo3.getStatus();
                                                Function1 function3 = new Function1() { // from class: com.box.android.jobsui.JobsUICoreHelper$$ExternalSyntheticLambda0
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj2) {
                                                        return JobsUICoreHelper.getJobState$lambda$1(iJobDisplayInfoProvider3, (DomainError) obj2);
                                                    }
                                                };
                                                anonymousClass2.L$0 = jobInfo3;
                                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager8);
                                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(iJobDisplayInfoProvider3);
                                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel3);
                                                anonymousClass2.L$5 = str10;
                                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                                anonymousClass2.L$7 = jobItemId3;
                                                anonymousClass2.L$8 = str9;
                                                anonymousClass2.L$9 = str8;
                                                anonymousClass2.L$10 = stateFlowStateIn;
                                                anonymousClass2.L$11 = itemModel3;
                                                anonymousClass2.I$0 = iconResId;
                                                anonymousClass2.label = 7;
                                                name2 = JobsUICoreHelperKt.mapJobInfoStatusForUI(status3, function3, anonymousClass2);
                                                if (name2 != coroutine_suspended) {
                                                    str13 = str10;
                                                    jobItemId5 = jobItemId3;
                                                    return new JobItemReducer.State(jobItemId5, str9, str8, stateFlowStateIn, itemModel3, iconResId, (StateFlow) name2, false, str13, 128, null);
                                                }
                                            }
                                        } else {
                                            if (stateFlow5 == null) {
                                                itemModel3 = itemModel2;
                                                obj = null;
                                                stateFlowStateIn = FlowKt.stateIn(FlowKt.flow(new AnonymousClass2(str6, itemModel3, this, str3, thumbnailManager7, null)), CoroutineScopeKt.CoroutineScope(anonymousClass2.getContext()), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), getDefaultIcon(new ItemDescriptor.ExistingBoxItem(itemModel3)));
                                            } else {
                                                itemModel3 = itemModel2;
                                                obj = null;
                                                stateFlowStateIn = stateFlow5;
                                            }
                                            str8 = str7;
                                            thumbnailManager8 = thumbnailManager7;
                                            str9 = str5;
                                            str10 = str6;
                                            iconResId = iJobDisplayInfoProvider3.getIconResId();
                                            Flow<JobInfo.Status> status4 = jobInfo3.getStatus();
                                            Function1 function4 = new Function1() { // from class: com.box.android.jobsui.JobsUICoreHelper$$ExternalSyntheticLambda0
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj2) {
                                                    return JobsUICoreHelper.getJobState$lambda$1(iJobDisplayInfoProvider3, (DomainError) obj2);
                                                }
                                            };
                                            anonymousClass2.L$0 = jobInfo3;
                                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager8);
                                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(iJobDisplayInfoProvider3);
                                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel3);
                                            anonymousClass2.L$5 = str10;
                                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                            anonymousClass2.L$7 = jobItemId3;
                                            anonymousClass2.L$8 = str9;
                                            anonymousClass2.L$9 = str8;
                                            anonymousClass2.L$10 = stateFlowStateIn;
                                            anonymousClass2.L$11 = itemModel3;
                                            anonymousClass2.I$0 = iconResId;
                                            anonymousClass2.label = 7;
                                            name2 = JobsUICoreHelperKt.mapJobInfoStatusForUI(status4, function4, anonymousClass2);
                                            if (name2 != coroutine_suspended) {
                                                str13 = str10;
                                                jobItemId5 = jobItemId3;
                                                return new JobItemReducer.State(jobItemId5, str9, str8, stateFlowStateIn, itemModel3, iconResId, (StateFlow) name2, false, str13, 128, null);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    } catch (Exception e4) {
                        e = e4;
                        jobInfo3 = jobInfo5;
                        obj = null;
                        if (JobKt.isActive(anonymousClass2.getContext())) {
                            BoxLogUtils.e("Returning null for JobState earlier due to coroutineContext no longer being active while constructing JobState");
                        } else {
                            BoxLogUtils.e("Returning null for JobState due to Exception:" + e + " JobId:" + jobInfo3.getId() + " JobType:" + jobInfo3.getJobType() + " ");
                        }
                        return obj;
                    }
                case 2:
                    ItemModel itemModel6 = (ItemModel) anonymousClass2.L$4;
                    IJobDisplayInfoProvider iJobDisplayInfoProvider7 = (IJobDisplayInfoProvider) anonymousClass2.L$3;
                    stateFlow2 = (StateFlow) anonymousClass2.L$2;
                    ThumbnailManager thumbnailManager12 = (ThumbnailManager) anonymousClass2.L$1;
                    JobInfo jobInfo6 = (JobInfo) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(name2);
                    itemModel = itemModel6;
                    jobInfo4 = jobInfo6;
                    thumbnailManager3 = thumbnailManager12;
                    iJobDisplayInfoProvider = iJobDisplayInfoProvider7;
                    str = (String) name2;
                    anonymousClass2.L$0 = jobInfo4;
                    anonymousClass2.L$1 = thumbnailManager3;
                    anonymousClass2.L$2 = stateFlow2;
                    anonymousClass2.L$3 = iJobDisplayInfoProvider;
                    anonymousClass2.L$4 = itemModel;
                    anonymousClass2.L$5 = str;
                    anonymousClass2.label = 3;
                    serverId = iJobDisplayInfoProvider.getServerId(anonymousClass2);
                    if (serverId != coroutine_suspended) {
                        StateFlow<? extends ItemThumbnail> stateFlow9 = stateFlow2;
                        str2 = str;
                        name2 = serverId;
                        jobInfo3 = jobInfo4;
                        stateFlow3 = stateFlow9;
                        thumbnailManager4 = thumbnailManager3;
                        iJobDisplayInfoProvider2 = iJobDisplayInfoProvider;
                        itemModel2 = itemModel;
                        str3 = (String) name2;
                        jobItemId = new JobItemId(jobInfo3.getId().getIdentifier(), false, null, 4, null);
                        anonymousClass2.L$0 = jobInfo3;
                        anonymousClass2.L$1 = thumbnailManager4;
                        anonymousClass2.L$2 = stateFlow3;
                        anonymousClass2.L$3 = iJobDisplayInfoProvider2;
                        anonymousClass2.L$4 = itemModel2;
                        anonymousClass2.L$5 = str2;
                        anonymousClass2.L$6 = str3;
                        anonymousClass2.L$7 = jobItemId;
                        anonymousClass2.label = 4;
                        name2 = iJobDisplayInfoProvider2.getName(anonymousClass2);
                        if (name2 == coroutine_suspended) {
                            thumbnailManager5 = thumbnailManager4;
                            stateFlow4 = stateFlow3;
                            jobItemId2 = jobItemId;
                            thumbnailManager6 = thumbnailManager5;
                            str4 = (String) name2;
                            anonymousClass2.L$0 = jobInfo3;
                            anonymousClass2.L$1 = thumbnailManager6;
                            anonymousClass2.L$2 = stateFlow4;
                            anonymousClass2.L$3 = iJobDisplayInfoProvider2;
                            anonymousClass2.L$4 = itemModel2;
                            anonymousClass2.L$5 = str2;
                            anonymousClass2.L$6 = str3;
                            anonymousClass2.L$7 = jobItemId2;
                            anonymousClass2.L$8 = str4;
                            anonymousClass2.label = 5;
                            itemDescription = iJobDisplayInfoProvider2.getItemDescription(anonymousClass2);
                            if (itemDescription != coroutine_suspended) {
                                IJobDisplayInfoProvider iJobDisplayInfoProvider8 = iJobDisplayInfoProvider2;
                                str5 = str4;
                                name2 = itemDescription;
                                stateFlow5 = stateFlow4;
                                jobItemId3 = jobItemId2;
                                str6 = str2;
                                thumbnailManager7 = thumbnailManager6;
                                iJobDisplayInfoProvider3 = iJobDisplayInfoProvider8;
                                str7 = (String) name2;
                                if (itemModel2 != null) {
                                    supportedFileExtensionIcons = SupportedFileExtensionIcons.INSTANCE;
                                    anonymousClass2.L$0 = jobInfo3;
                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager7);
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                    anonymousClass2.L$3 = iJobDisplayInfoProvider3;
                                    anonymousClass2.L$4 = itemModel2;
                                    anonymousClass2.L$5 = str6;
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                    anonymousClass2.L$7 = jobItemId3;
                                    anonymousClass2.L$8 = str5;
                                    anonymousClass2.L$9 = str7;
                                    anonymousClass2.L$10 = supportedFileExtensionIcons;
                                    anonymousClass2.label = 6;
                                    name = iJobDisplayInfoProvider3.getName(anonymousClass2);
                                    if (name == coroutine_suspended) {
                                        String str16 = str6;
                                        supportedFileExtensionIcons2 = supportedFileExtensionIcons;
                                        name2 = name;
                                        str11 = str7;
                                        thumbnailManager8 = thumbnailManager7;
                                        jobItemId4 = jobItemId3;
                                        itemModel4 = itemModel2;
                                        str3 = str3;
                                        str12 = str5;
                                        str10 = str16;
                                        obj = null;
                                        itemModel3 = itemModel4;
                                        jobItemId3 = jobItemId4;
                                        str9 = str12;
                                        str8 = str11;
                                        stateFlowStateIn = StateFlowKt.MutableStateFlow(new ItemThumbnail.Icon(supportedFileExtensionIcons2.findFileIcon(CommonBoxUtil.getFileExtension((String) name2, "")).getDrawable(), null, 2, null));
                                        iconResId = iJobDisplayInfoProvider3.getIconResId();
                                        Flow<JobInfo.Status> status5 = jobInfo3.getStatus();
                                        Function1 function5 = new Function1() { // from class: com.box.android.jobsui.JobsUICoreHelper$$ExternalSyntheticLambda0
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj2) {
                                                return JobsUICoreHelper.getJobState$lambda$1(iJobDisplayInfoProvider3, (DomainError) obj2);
                                            }
                                        };
                                        anonymousClass2.L$0 = jobInfo3;
                                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager8);
                                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(iJobDisplayInfoProvider3);
                                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel3);
                                        anonymousClass2.L$5 = str10;
                                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                        anonymousClass2.L$7 = jobItemId3;
                                        anonymousClass2.L$8 = str9;
                                        anonymousClass2.L$9 = str8;
                                        anonymousClass2.L$10 = stateFlowStateIn;
                                        anonymousClass2.L$11 = itemModel3;
                                        anonymousClass2.I$0 = iconResId;
                                        anonymousClass2.label = 7;
                                        name2 = JobsUICoreHelperKt.mapJobInfoStatusForUI(status5, function5, anonymousClass2);
                                        if (name2 != coroutine_suspended) {
                                            str13 = str10;
                                            jobItemId5 = jobItemId3;
                                            return new JobItemReducer.State(jobItemId5, str9, str8, stateFlowStateIn, itemModel3, iconResId, (StateFlow) name2, false, str13, 128, null);
                                        }
                                    }
                                } else {
                                    if (stateFlow5 == null) {
                                        itemModel3 = itemModel2;
                                        obj = null;
                                        stateFlowStateIn = FlowKt.stateIn(FlowKt.flow(new AnonymousClass2(str6, itemModel3, this, str3, thumbnailManager7, null)), CoroutineScopeKt.CoroutineScope(anonymousClass2.getContext()), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), getDefaultIcon(new ItemDescriptor.ExistingBoxItem(itemModel3)));
                                    } else {
                                        itemModel3 = itemModel2;
                                        obj = null;
                                        stateFlowStateIn = stateFlow5;
                                    }
                                    str8 = str7;
                                    thumbnailManager8 = thumbnailManager7;
                                    str9 = str5;
                                    str10 = str6;
                                    iconResId = iJobDisplayInfoProvider3.getIconResId();
                                    Flow<JobInfo.Status> status6 = jobInfo3.getStatus();
                                    Function1 function6 = new Function1() { // from class: com.box.android.jobsui.JobsUICoreHelper$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return JobsUICoreHelper.getJobState$lambda$1(iJobDisplayInfoProvider3, (DomainError) obj2);
                                        }
                                    };
                                    anonymousClass2.L$0 = jobInfo3;
                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager8);
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(iJobDisplayInfoProvider3);
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel3);
                                    anonymousClass2.L$5 = str10;
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                    anonymousClass2.L$7 = jobItemId3;
                                    anonymousClass2.L$8 = str9;
                                    anonymousClass2.L$9 = str8;
                                    anonymousClass2.L$10 = stateFlowStateIn;
                                    anonymousClass2.L$11 = itemModel3;
                                    anonymousClass2.I$0 = iconResId;
                                    anonymousClass2.label = 7;
                                    name2 = JobsUICoreHelperKt.mapJobInfoStatusForUI(status6, function6, anonymousClass2);
                                    if (name2 != coroutine_suspended) {
                                        str13 = str10;
                                        jobItemId5 = jobItemId3;
                                        return new JobItemReducer.State(jobItemId5, str9, str8, stateFlowStateIn, itemModel3, iconResId, (StateFlow) name2, false, str13, 128, null);
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                case 3:
                    String str17 = (String) anonymousClass2.L$5;
                    itemModel = (ItemModel) anonymousClass2.L$4;
                    IJobDisplayInfoProvider iJobDisplayInfoProvider9 = (IJobDisplayInfoProvider) anonymousClass2.L$3;
                    StateFlow<? extends ItemThumbnail> stateFlow10 = (StateFlow) anonymousClass2.L$2;
                    ThumbnailManager thumbnailManager13 = (ThumbnailManager) anonymousClass2.L$1;
                    jobInfo3 = (JobInfo) anonymousClass2.L$0;
                    try {
                        ResultKt.throwOnFailure(name2);
                        thumbnailManager4 = thumbnailManager13;
                        iJobDisplayInfoProvider2 = iJobDisplayInfoProvider9;
                        str2 = str17;
                        stateFlow3 = stateFlow10;
                        itemModel2 = itemModel;
                        str3 = (String) name2;
                        jobItemId = new JobItemId(jobInfo3.getId().getIdentifier(), false, null, 4, null);
                        anonymousClass2.L$0 = jobInfo3;
                        anonymousClass2.L$1 = thumbnailManager4;
                        anonymousClass2.L$2 = stateFlow3;
                        anonymousClass2.L$3 = iJobDisplayInfoProvider2;
                        anonymousClass2.L$4 = itemModel2;
                        anonymousClass2.L$5 = str2;
                        anonymousClass2.L$6 = str3;
                        anonymousClass2.L$7 = jobItemId;
                        anonymousClass2.label = 4;
                        name2 = iJobDisplayInfoProvider2.getName(anonymousClass2);
                        if (name2 == coroutine_suspended) {
                            thumbnailManager5 = thumbnailManager4;
                            stateFlow4 = stateFlow3;
                            jobItemId2 = jobItemId;
                            thumbnailManager6 = thumbnailManager5;
                            str4 = (String) name2;
                            anonymousClass2.L$0 = jobInfo3;
                            anonymousClass2.L$1 = thumbnailManager6;
                            anonymousClass2.L$2 = stateFlow4;
                            anonymousClass2.L$3 = iJobDisplayInfoProvider2;
                            anonymousClass2.L$4 = itemModel2;
                            anonymousClass2.L$5 = str2;
                            anonymousClass2.L$6 = str3;
                            anonymousClass2.L$7 = jobItemId2;
                            anonymousClass2.L$8 = str4;
                            anonymousClass2.label = 5;
                            itemDescription = iJobDisplayInfoProvider2.getItemDescription(anonymousClass2);
                            if (itemDescription != coroutine_suspended) {
                                IJobDisplayInfoProvider iJobDisplayInfoProvider10 = iJobDisplayInfoProvider2;
                                str5 = str4;
                                name2 = itemDescription;
                                stateFlow5 = stateFlow4;
                                jobItemId3 = jobItemId2;
                                str6 = str2;
                                thumbnailManager7 = thumbnailManager6;
                                iJobDisplayInfoProvider3 = iJobDisplayInfoProvider10;
                                str7 = (String) name2;
                                if (itemModel2 != null) {
                                    supportedFileExtensionIcons = SupportedFileExtensionIcons.INSTANCE;
                                    anonymousClass2.L$0 = jobInfo3;
                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager7);
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                    anonymousClass2.L$3 = iJobDisplayInfoProvider3;
                                    anonymousClass2.L$4 = itemModel2;
                                    anonymousClass2.L$5 = str6;
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                    anonymousClass2.L$7 = jobItemId3;
                                    anonymousClass2.L$8 = str5;
                                    anonymousClass2.L$9 = str7;
                                    anonymousClass2.L$10 = supportedFileExtensionIcons;
                                    anonymousClass2.label = 6;
                                    name = iJobDisplayInfoProvider3.getName(anonymousClass2);
                                    if (name == coroutine_suspended) {
                                        String str18 = str6;
                                        supportedFileExtensionIcons2 = supportedFileExtensionIcons;
                                        name2 = name;
                                        str11 = str7;
                                        thumbnailManager8 = thumbnailManager7;
                                        jobItemId4 = jobItemId3;
                                        itemModel4 = itemModel2;
                                        str3 = str3;
                                        str12 = str5;
                                        str10 = str18;
                                        obj = null;
                                        itemModel3 = itemModel4;
                                        jobItemId3 = jobItemId4;
                                        str9 = str12;
                                        str8 = str11;
                                        stateFlowStateIn = StateFlowKt.MutableStateFlow(new ItemThumbnail.Icon(supportedFileExtensionIcons2.findFileIcon(CommonBoxUtil.getFileExtension((String) name2, "")).getDrawable(), null, 2, null));
                                        iconResId = iJobDisplayInfoProvider3.getIconResId();
                                        Flow<JobInfo.Status> status7 = jobInfo3.getStatus();
                                        Function1 function7 = new Function1() { // from class: com.box.android.jobsui.JobsUICoreHelper$$ExternalSyntheticLambda0
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj2) {
                                                return JobsUICoreHelper.getJobState$lambda$1(iJobDisplayInfoProvider3, (DomainError) obj2);
                                            }
                                        };
                                        anonymousClass2.L$0 = jobInfo3;
                                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager8);
                                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(iJobDisplayInfoProvider3);
                                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel3);
                                        anonymousClass2.L$5 = str10;
                                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                        anonymousClass2.L$7 = jobItemId3;
                                        anonymousClass2.L$8 = str9;
                                        anonymousClass2.L$9 = str8;
                                        anonymousClass2.L$10 = stateFlowStateIn;
                                        anonymousClass2.L$11 = itemModel3;
                                        anonymousClass2.I$0 = iconResId;
                                        anonymousClass2.label = 7;
                                        name2 = JobsUICoreHelperKt.mapJobInfoStatusForUI(status7, function7, anonymousClass2);
                                        if (name2 != coroutine_suspended) {
                                            str13 = str10;
                                            jobItemId5 = jobItemId3;
                                            return new JobItemReducer.State(jobItemId5, str9, str8, stateFlowStateIn, itemModel3, iconResId, (StateFlow) name2, false, str13, 128, null);
                                        }
                                    }
                                } else {
                                    if (stateFlow5 == null) {
                                        itemModel3 = itemModel2;
                                        obj = null;
                                        stateFlowStateIn = FlowKt.stateIn(FlowKt.flow(new AnonymousClass2(str6, itemModel3, this, str3, thumbnailManager7, null)), CoroutineScopeKt.CoroutineScope(anonymousClass2.getContext()), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), getDefaultIcon(new ItemDescriptor.ExistingBoxItem(itemModel3)));
                                    } else {
                                        itemModel3 = itemModel2;
                                        obj = null;
                                        stateFlowStateIn = stateFlow5;
                                    }
                                    str8 = str7;
                                    thumbnailManager8 = thumbnailManager7;
                                    str9 = str5;
                                    str10 = str6;
                                    iconResId = iJobDisplayInfoProvider3.getIconResId();
                                    Flow<JobInfo.Status> status8 = jobInfo3.getStatus();
                                    Function1 function8 = new Function1() { // from class: com.box.android.jobsui.JobsUICoreHelper$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return JobsUICoreHelper.getJobState$lambda$1(iJobDisplayInfoProvider3, (DomainError) obj2);
                                        }
                                    };
                                    anonymousClass2.L$0 = jobInfo3;
                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager8);
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(iJobDisplayInfoProvider3);
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel3);
                                    anonymousClass2.L$5 = str10;
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                    anonymousClass2.L$7 = jobItemId3;
                                    anonymousClass2.L$8 = str9;
                                    anonymousClass2.L$9 = str8;
                                    anonymousClass2.L$10 = stateFlowStateIn;
                                    anonymousClass2.L$11 = itemModel3;
                                    anonymousClass2.I$0 = iconResId;
                                    anonymousClass2.label = 7;
                                    name2 = JobsUICoreHelperKt.mapJobInfoStatusForUI(status8, function8, anonymousClass2);
                                    if (name2 != coroutine_suspended) {
                                        str13 = str10;
                                        jobItemId5 = jobItemId3;
                                        return new JobItemReducer.State(jobItemId5, str9, str8, stateFlowStateIn, itemModel3, iconResId, (StateFlow) name2, false, str13, 128, null);
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    } catch (Exception e5) {
                        e = e5;
                        obj = null;
                        if (JobKt.isActive(anonymousClass2.getContext())) {
                            BoxLogUtils.e("Returning null for JobState earlier due to coroutineContext no longer being active while constructing JobState");
                        } else {
                            BoxLogUtils.e("Returning null for JobState due to Exception:" + e + " JobId:" + jobInfo3.getId() + " JobType:" + jobInfo3.getJobType() + " ");
                        }
                        return obj;
                    }
                case 4:
                    jobItemId2 = (JobItemId) anonymousClass2.L$7;
                    str3 = (String) anonymousClass2.L$6;
                    str2 = (String) anonymousClass2.L$5;
                    itemModel2 = (ItemModel) anonymousClass2.L$4;
                    iJobDisplayInfoProvider2 = (IJobDisplayInfoProvider) anonymousClass2.L$3;
                    StateFlow<? extends ItemThumbnail> stateFlow11 = (StateFlow) anonymousClass2.L$2;
                    ThumbnailManager thumbnailManager14 = (ThumbnailManager) anonymousClass2.L$1;
                    JobInfo jobInfo7 = (JobInfo) anonymousClass2.L$0;
                    try {
                        ResultKt.throwOnFailure(name2);
                        thumbnailManager5 = thumbnailManager14;
                        stateFlow4 = stateFlow11;
                        jobInfo3 = jobInfo7;
                        thumbnailManager6 = thumbnailManager5;
                        str4 = (String) name2;
                        anonymousClass2.L$0 = jobInfo3;
                        anonymousClass2.L$1 = thumbnailManager6;
                        anonymousClass2.L$2 = stateFlow4;
                        anonymousClass2.L$3 = iJobDisplayInfoProvider2;
                        anonymousClass2.L$4 = itemModel2;
                        anonymousClass2.L$5 = str2;
                        anonymousClass2.L$6 = str3;
                        anonymousClass2.L$7 = jobItemId2;
                        anonymousClass2.L$8 = str4;
                        anonymousClass2.label = 5;
                        itemDescription = iJobDisplayInfoProvider2.getItemDescription(anonymousClass2);
                        if (itemDescription != coroutine_suspended) {
                            IJobDisplayInfoProvider iJobDisplayInfoProvider11 = iJobDisplayInfoProvider2;
                            str5 = str4;
                            name2 = itemDescription;
                            stateFlow5 = stateFlow4;
                            jobItemId3 = jobItemId2;
                            str6 = str2;
                            thumbnailManager7 = thumbnailManager6;
                            iJobDisplayInfoProvider3 = iJobDisplayInfoProvider11;
                            str7 = (String) name2;
                            if (itemModel2 != null) {
                                supportedFileExtensionIcons = SupportedFileExtensionIcons.INSTANCE;
                                anonymousClass2.L$0 = jobInfo3;
                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager7);
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                anonymousClass2.L$3 = iJobDisplayInfoProvider3;
                                anonymousClass2.L$4 = itemModel2;
                                anonymousClass2.L$5 = str6;
                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                anonymousClass2.L$7 = jobItemId3;
                                anonymousClass2.L$8 = str5;
                                anonymousClass2.L$9 = str7;
                                anonymousClass2.L$10 = supportedFileExtensionIcons;
                                anonymousClass2.label = 6;
                                name = iJobDisplayInfoProvider3.getName(anonymousClass2);
                                if (name == coroutine_suspended) {
                                    String str19 = str6;
                                    supportedFileExtensionIcons2 = supportedFileExtensionIcons;
                                    name2 = name;
                                    str11 = str7;
                                    thumbnailManager8 = thumbnailManager7;
                                    jobItemId4 = jobItemId3;
                                    itemModel4 = itemModel2;
                                    str3 = str3;
                                    str12 = str5;
                                    str10 = str19;
                                    obj = null;
                                    itemModel3 = itemModel4;
                                    jobItemId3 = jobItemId4;
                                    str9 = str12;
                                    str8 = str11;
                                    stateFlowStateIn = StateFlowKt.MutableStateFlow(new ItemThumbnail.Icon(supportedFileExtensionIcons2.findFileIcon(CommonBoxUtil.getFileExtension((String) name2, "")).getDrawable(), null, 2, null));
                                    iconResId = iJobDisplayInfoProvider3.getIconResId();
                                    Flow<JobInfo.Status> status9 = jobInfo3.getStatus();
                                    Function1 function9 = new Function1() { // from class: com.box.android.jobsui.JobsUICoreHelper$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return JobsUICoreHelper.getJobState$lambda$1(iJobDisplayInfoProvider3, (DomainError) obj2);
                                        }
                                    };
                                    anonymousClass2.L$0 = jobInfo3;
                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager8);
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(iJobDisplayInfoProvider3);
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel3);
                                    anonymousClass2.L$5 = str10;
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                    anonymousClass2.L$7 = jobItemId3;
                                    anonymousClass2.L$8 = str9;
                                    anonymousClass2.L$9 = str8;
                                    anonymousClass2.L$10 = stateFlowStateIn;
                                    anonymousClass2.L$11 = itemModel3;
                                    anonymousClass2.I$0 = iconResId;
                                    anonymousClass2.label = 7;
                                    name2 = JobsUICoreHelperKt.mapJobInfoStatusForUI(status9, function9, anonymousClass2);
                                    if (name2 != coroutine_suspended) {
                                        str13 = str10;
                                        jobItemId5 = jobItemId3;
                                        return new JobItemReducer.State(jobItemId5, str9, str8, stateFlowStateIn, itemModel3, iconResId, (StateFlow) name2, false, str13, 128, null);
                                    }
                                }
                            } else {
                                if (stateFlow5 == null) {
                                    itemModel3 = itemModel2;
                                    obj = null;
                                    stateFlowStateIn = FlowKt.stateIn(FlowKt.flow(new AnonymousClass2(str6, itemModel3, this, str3, thumbnailManager7, null)), CoroutineScopeKt.CoroutineScope(anonymousClass2.getContext()), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), getDefaultIcon(new ItemDescriptor.ExistingBoxItem(itemModel3)));
                                } else {
                                    itemModel3 = itemModel2;
                                    obj = null;
                                    stateFlowStateIn = stateFlow5;
                                }
                                str8 = str7;
                                thumbnailManager8 = thumbnailManager7;
                                str9 = str5;
                                str10 = str6;
                                iconResId = iJobDisplayInfoProvider3.getIconResId();
                                Flow<JobInfo.Status> status10 = jobInfo3.getStatus();
                                Function1 function10 = new Function1() { // from class: com.box.android.jobsui.JobsUICoreHelper$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return JobsUICoreHelper.getJobState$lambda$1(iJobDisplayInfoProvider3, (DomainError) obj2);
                                    }
                                };
                                anonymousClass2.L$0 = jobInfo3;
                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager8);
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(iJobDisplayInfoProvider3);
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel3);
                                anonymousClass2.L$5 = str10;
                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                                anonymousClass2.L$7 = jobItemId3;
                                anonymousClass2.L$8 = str9;
                                anonymousClass2.L$9 = str8;
                                anonymousClass2.L$10 = stateFlowStateIn;
                                anonymousClass2.L$11 = itemModel3;
                                anonymousClass2.I$0 = iconResId;
                                anonymousClass2.label = 7;
                                name2 = JobsUICoreHelperKt.mapJobInfoStatusForUI(status10, function10, anonymousClass2);
                                if (name2 != coroutine_suspended) {
                                    str13 = str10;
                                    jobItemId5 = jobItemId3;
                                    return new JobItemReducer.State(jobItemId5, str9, str8, stateFlowStateIn, itemModel3, iconResId, (StateFlow) name2, false, str13, 128, null);
                                }
                            }
                        }
                        return coroutine_suspended;
                    } catch (Exception e6) {
                        e = e6;
                        obj = null;
                        jobInfo3 = jobInfo7;
                        if (JobKt.isActive(anonymousClass2.getContext())) {
                            BoxLogUtils.e("Returning null for JobState earlier due to coroutineContext no longer being active while constructing JobState");
                        } else {
                            BoxLogUtils.e("Returning null for JobState due to Exception:" + e + " JobId:" + jobInfo3.getId() + " JobType:" + jobInfo3.getJobType() + " ");
                        }
                        return obj;
                    }
                case 5:
                    String str20 = (String) anonymousClass2.L$8;
                    JobItemId jobItemId6 = (JobItemId) anonymousClass2.L$7;
                    String str21 = (String) anonymousClass2.L$6;
                    String str22 = (String) anonymousClass2.L$5;
                    ItemModel itemModel7 = (ItemModel) anonymousClass2.L$4;
                    IJobDisplayInfoProvider iJobDisplayInfoProvider12 = (IJobDisplayInfoProvider) anonymousClass2.L$3;
                    StateFlow<? extends ItemThumbnail> stateFlow12 = (StateFlow) anonymousClass2.L$2;
                    ThumbnailManager thumbnailManager15 = (ThumbnailManager) anonymousClass2.L$1;
                    JobInfo jobInfo8 = (JobInfo) anonymousClass2.L$0;
                    try {
                        ResultKt.throwOnFailure(name2);
                        str5 = str20;
                        str6 = str22;
                        itemModel2 = itemModel7;
                        jobItemId3 = jobItemId6;
                        str3 = str21;
                        thumbnailManager7 = thumbnailManager15;
                        iJobDisplayInfoProvider3 = iJobDisplayInfoProvider12;
                        jobInfo3 = jobInfo8;
                        stateFlow5 = stateFlow12;
                        str7 = (String) name2;
                        if (itemModel2 != null) {
                            if (stateFlow5 == null) {
                                itemModel3 = itemModel2;
                                obj = null;
                                stateFlowStateIn = FlowKt.stateIn(FlowKt.flow(new AnonymousClass2(str6, itemModel3, this, str3, thumbnailManager7, null)), CoroutineScopeKt.CoroutineScope(anonymousClass2.getContext()), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), getDefaultIcon(new ItemDescriptor.ExistingBoxItem(itemModel3)));
                            } else {
                                itemModel3 = itemModel2;
                                obj = null;
                                stateFlowStateIn = stateFlow5;
                            }
                            str8 = str7;
                            thumbnailManager8 = thumbnailManager7;
                            str9 = str5;
                            str10 = str6;
                            iconResId = iJobDisplayInfoProvider3.getIconResId();
                            Flow<JobInfo.Status> status11 = jobInfo3.getStatus();
                            Function1 function11 = new Function1() { // from class: com.box.android.jobsui.JobsUICoreHelper$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return JobsUICoreHelper.getJobState$lambda$1(iJobDisplayInfoProvider3, (DomainError) obj2);
                                }
                            };
                            anonymousClass2.L$0 = jobInfo3;
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager8);
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(iJobDisplayInfoProvider3);
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel3);
                            anonymousClass2.L$5 = str10;
                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                            anonymousClass2.L$7 = jobItemId3;
                            anonymousClass2.L$8 = str9;
                            anonymousClass2.L$9 = str8;
                            anonymousClass2.L$10 = stateFlowStateIn;
                            anonymousClass2.L$11 = itemModel3;
                            anonymousClass2.I$0 = iconResId;
                            anonymousClass2.label = 7;
                            name2 = JobsUICoreHelperKt.mapJobInfoStatusForUI(status11, function11, anonymousClass2);
                            if (name2 != coroutine_suspended) {
                                str13 = str10;
                                jobItemId5 = jobItemId3;
                                return new JobItemReducer.State(jobItemId5, str9, str8, stateFlowStateIn, itemModel3, iconResId, (StateFlow) name2, false, str13, 128, null);
                            }
                            return coroutine_suspended;
                        }
                        supportedFileExtensionIcons = SupportedFileExtensionIcons.INSTANCE;
                        anonymousClass2.L$0 = jobInfo3;
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager7);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                        anonymousClass2.L$3 = iJobDisplayInfoProvider3;
                        anonymousClass2.L$4 = itemModel2;
                        anonymousClass2.L$5 = str6;
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                        anonymousClass2.L$7 = jobItemId3;
                        anonymousClass2.L$8 = str5;
                        anonymousClass2.L$9 = str7;
                        anonymousClass2.L$10 = supportedFileExtensionIcons;
                        anonymousClass2.label = 6;
                        name = iJobDisplayInfoProvider3.getName(anonymousClass2);
                        if (name == coroutine_suspended) {
                            String str110 = str6;
                            supportedFileExtensionIcons2 = supportedFileExtensionIcons;
                            name2 = name;
                            str11 = str7;
                            thumbnailManager8 = thumbnailManager7;
                            jobItemId4 = jobItemId3;
                            itemModel4 = itemModel2;
                            str3 = str3;
                            str12 = str5;
                            str10 = str110;
                            obj = null;
                            itemModel3 = itemModel4;
                            jobItemId3 = jobItemId4;
                            str9 = str12;
                            str8 = str11;
                            stateFlowStateIn = StateFlowKt.MutableStateFlow(new ItemThumbnail.Icon(supportedFileExtensionIcons2.findFileIcon(CommonBoxUtil.getFileExtension((String) name2, "")).getDrawable(), null, 2, null));
                            iconResId = iJobDisplayInfoProvider3.getIconResId();
                            Flow<JobInfo.Status> status12 = jobInfo3.getStatus();
                            Function1 function12 = new Function1() { // from class: com.box.android.jobsui.JobsUICoreHelper$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return JobsUICoreHelper.getJobState$lambda$1(iJobDisplayInfoProvider3, (DomainError) obj2);
                                }
                            };
                            anonymousClass2.L$0 = jobInfo3;
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager8);
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(iJobDisplayInfoProvider3);
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel3);
                            anonymousClass2.L$5 = str10;
                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                            anonymousClass2.L$7 = jobItemId3;
                            anonymousClass2.L$8 = str9;
                            anonymousClass2.L$9 = str8;
                            anonymousClass2.L$10 = stateFlowStateIn;
                            anonymousClass2.L$11 = itemModel3;
                            anonymousClass2.I$0 = iconResId;
                            anonymousClass2.label = 7;
                            name2 = JobsUICoreHelperKt.mapJobInfoStatusForUI(status12, function12, anonymousClass2);
                            if (name2 != coroutine_suspended) {
                                str13 = str10;
                                jobItemId5 = jobItemId3;
                                return new JobItemReducer.State(jobItemId5, str9, str8, stateFlowStateIn, itemModel3, iconResId, (StateFlow) name2, false, str13, 128, null);
                            }
                        }
                        return coroutine_suspended;
                    } catch (Exception e7) {
                        e = e7;
                        obj = null;
                        jobInfo3 = jobInfo8;
                        if (JobKt.isActive(anonymousClass2.getContext())) {
                            BoxLogUtils.e("Returning null for JobState earlier due to coroutineContext no longer being active while constructing JobState");
                        } else {
                            BoxLogUtils.e("Returning null for JobState due to Exception:" + e + " JobId:" + jobInfo3.getId() + " JobType:" + jobInfo3.getJobType() + " ");
                        }
                        return obj;
                    }
                case 6:
                    supportedFileExtensionIcons2 = (SupportedFileExtensionIcons) anonymousClass2.L$10;
                    str11 = (String) anonymousClass2.L$9;
                    str12 = (String) anonymousClass2.L$8;
                    jobItemId4 = (JobItemId) anonymousClass2.L$7;
                    str3 = (String) anonymousClass2.L$6;
                    str10 = (String) anonymousClass2.L$5;
                    ItemModel itemModel8 = (ItemModel) anonymousClass2.L$4;
                    IJobDisplayInfoProvider iJobDisplayInfoProvider13 = (IJobDisplayInfoProvider) anonymousClass2.L$3;
                    StateFlow<? extends ItemThumbnail> stateFlow13 = (StateFlow) anonymousClass2.L$2;
                    ThumbnailManager thumbnailManager16 = (ThumbnailManager) anonymousClass2.L$1;
                    JobInfo jobInfo9 = (JobInfo) anonymousClass2.L$0;
                    try {
                        ResultKt.throwOnFailure(name2);
                        itemModel4 = itemModel8;
                        jobInfo3 = jobInfo9;
                        thumbnailManager8 = thumbnailManager16;
                        stateFlow5 = stateFlow13;
                        iJobDisplayInfoProvider3 = iJobDisplayInfoProvider13;
                        obj = null;
                        itemModel3 = itemModel4;
                        jobItemId3 = jobItemId4;
                        str9 = str12;
                        str8 = str11;
                        stateFlowStateIn = StateFlowKt.MutableStateFlow(new ItemThumbnail.Icon(supportedFileExtensionIcons2.findFileIcon(CommonBoxUtil.getFileExtension((String) name2, "")).getDrawable(), null, 2, null));
                        iconResId = iJobDisplayInfoProvider3.getIconResId();
                        Flow<JobInfo.Status> status13 = jobInfo3.getStatus();
                        Function1 function13 = new Function1() { // from class: com.box.android.jobsui.JobsUICoreHelper$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return JobsUICoreHelper.getJobState$lambda$1(iJobDisplayInfoProvider3, (DomainError) obj2);
                            }
                        };
                        anonymousClass2.L$0 = jobInfo3;
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager8);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(stateFlow5);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(iJobDisplayInfoProvider3);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(itemModel3);
                        anonymousClass2.L$5 = str10;
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                        anonymousClass2.L$7 = jobItemId3;
                        anonymousClass2.L$8 = str9;
                        anonymousClass2.L$9 = str8;
                        anonymousClass2.L$10 = stateFlowStateIn;
                        anonymousClass2.L$11 = itemModel3;
                        anonymousClass2.I$0 = iconResId;
                        anonymousClass2.label = 7;
                        name2 = JobsUICoreHelperKt.mapJobInfoStatusForUI(status13, function13, anonymousClass2);
                        if (name2 != coroutine_suspended) {
                            str13 = str10;
                            jobItemId5 = jobItemId3;
                            return new JobItemReducer.State(jobItemId5, str9, str8, stateFlowStateIn, itemModel3, iconResId, (StateFlow) name2, false, str13, 128, null);
                        }
                        return coroutine_suspended;
                    } catch (Exception e8) {
                        e = e8;
                        obj = null;
                        jobInfo3 = jobInfo9;
                        if (JobKt.isActive(anonymousClass2.getContext())) {
                            BoxLogUtils.e("Returning null for JobState earlier due to coroutineContext no longer being active while constructing JobState");
                        } else {
                            BoxLogUtils.e("Returning null for JobState due to Exception:" + e + " JobId:" + jobInfo3.getId() + " JobType:" + jobInfo3.getJobType() + " ");
                        }
                        return obj;
                    }
                case 7:
                    iconResId = anonymousClass2.I$0;
                    itemModel3 = (ItemModel) anonymousClass2.L$11;
                    stateFlowStateIn = (StateFlow) anonymousClass2.L$10;
                    str8 = (String) anonymousClass2.L$9;
                    str9 = (String) anonymousClass2.L$8;
                    JobItemId jobItemId7 = (JobItemId) anonymousClass2.L$7;
                    String str23 = (String) anonymousClass2.L$5;
                    JobInfo jobInfo10 = (JobInfo) anonymousClass2.L$0;
                    ResultKt.throwOnFailure(name2);
                    jobItemId5 = jobItemId7;
                    str13 = str23;
                    obj = null;
                    jobInfo3 = jobInfo10;
                    return new JobItemReducer.State(jobItemId5, str9, str8, stateFlowStateIn, itemModel3, iconResId, (StateFlow) name2, false, str13, 128, null);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e9) {
            e = e9;
            obj = null;
            jobInfo3 = jobInfo2;
        }
    }

    /* JADX INFO: renamed from: com.box.android.jobsui.JobsUICoreHelper$getJobState$2, reason: invalid class name */
    /* JADX INFO: compiled from: JobsUICoreHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\r\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u00040\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/base/compose/ItemThumbnail;", "Lkotlin/internal/Exact;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.jobsui.JobsUICoreHelper$getJobState$2", f = "JobsUICoreHelper.kt", i = {0, 0, 0, 0, 0, 1}, l = {69, 65}, m = "invokeSuspend", n = {"$this$flow", "fileModel", "it", "$i$a$-let-JobsUICoreHelper$getJobState$2$2", "$i$a$-let-JobsUICoreHelper$getJobState$2$2$1", "$this$flow"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super ItemThumbnail>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $contentUrl;
        final /* synthetic */ ItemModel $itemModel;
        final /* synthetic */ String $serverID;
        final /* synthetic */ ThumbnailManager $thumbnailManager;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ JobsUICoreHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, ItemModel itemModel, JobsUICoreHelper jobsUICoreHelper, String str2, ThumbnailManager thumbnailManager, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$contentUrl = str;
            this.$itemModel = itemModel;
            this.this$0 = jobsUICoreHelper;
            this.$serverID = str2;
            this.$thumbnailManager = thumbnailManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$contentUrl, this.$itemModel, this.this$0, this.$serverID, this.$thumbnailManager, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ItemThumbnail> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x00fd  */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0125, code lost:
        
            if (r4.emit(r3, r40) == r2) goto L32;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r41) {
            /*
                Method dump skipped, instruction units count: 299
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.jobsui.JobsUICoreHelper.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getJobState$lambda$1(IJobDisplayInfoProvider iJobDisplayInfoProvider, DomainError it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof DomainError.NetworkError) {
            return CommonBoxUtil.LS(R.string.box_sharesdk_network_error);
        }
        Integer numErrorStringRes = iJobDisplayInfoProvider.errorStringRes(it);
        if (numErrorStringRes != null) {
            return CommonBoxUtil.LS(numErrorStringRes.intValue());
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getThumbnailFromFileModel(FileModel fileModel, ThumbnailManager thumbnailManager, Continuation<? super ItemThumbnail> continuation) {
        C16571 c16571;
        if (continuation instanceof C16571) {
            c16571 = (C16571) continuation;
            if ((c16571.label & Integer.MIN_VALUE) != 0) {
                c16571.label -= Integer.MIN_VALUE;
            } else {
                c16571 = new C16571(continuation);
            }
        } else {
            c16571 = new C16571(continuation);
        }
        C16571 c16572 = c16571;
        Object objLoadThumbnailFileModel$default = c16572.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16572.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objLoadThumbnailFileModel$default);
            c16572.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
            c16572.L$1 = SpillingKt.nullOutSpilledVariable(thumbnailManager);
            c16572.label = 1;
            objLoadThumbnailFileModel$default = ThumbnailManager.loadThumbnailFileModel$default(thumbnailManager, fileModel, false, false, c16572, 6, null);
            if (objLoadThumbnailFileModel$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objLoadThumbnailFileModel$default);
        }
        Bitmap bitmap = (Bitmap) objLoadThumbnailFileModel$default;
        if (bitmap != null) {
            return new ItemThumbnail.PreviewThumbnail(bitmap);
        }
        return null;
    }

    /* JADX INFO: renamed from: com.box.android.jobsui.JobsUICoreHelper$getThumbnailFromUri$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: JobsUICoreHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/box/android/base/compose/ItemThumbnail$PreviewThumbnail;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.jobsui.JobsUICoreHelper$getThumbnailFromUri$2", f = "JobsUICoreHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16582 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ItemThumbnail.PreviewThumbnail>, Object> {
        final /* synthetic */ Uri $uri;
        int label;
        final /* synthetic */ JobsUICoreHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16582(Uri uri, JobsUICoreHelper jobsUICoreHelper, Continuation<? super C16582> continuation) {
            super(2, continuation);
            this.$uri = uri;
            this.this$0 = jobsUICoreHelper;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C16582(this.$uri, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ItemThumbnail.PreviewThumbnail> continuation) {
            return ((C16582) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String path = RealPathUtils.INSTANCE.getPath(this.$uri);
            if (path != null) {
                return this.this$0.getScaledBitmap(path);
            }
            return null;
        }
    }

    public final Object getThumbnailFromUri(Uri uri, Continuation<? super ItemThumbnail> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C16582(uri, this, null), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object getJobStateFromLegacyJob(LegacyJobModel legacyJobModel, String str, ThumbnailManager thumbnailManager, StateFlow<? extends ItemThumbnail> stateFlow, Continuation<? super JobItemReducer.State> continuation) {
        C16561 c16561;
        String itemName;
        String name;
        ThumbnailManager thumbnailManager2;
        StateFlow<? extends ItemThumbnail> stateFlowStateIn;
        int jobTypeIconRes;
        String str2;
        ItemModel itemModel;
        JobItemId jobItemId;
        StateFlow<? extends ItemThumbnail> stateFlow2;
        String formattedSize;
        LegacyJobModel legacyJobModel2 = legacyJobModel;
        if (continuation instanceof C16561) {
            c16561 = (C16561) continuation;
            if ((c16561.label & Integer.MIN_VALUE) != 0) {
                c16561.label -= Integer.MIN_VALUE;
            } else {
                c16561 = new C16561(continuation);
            }
        } else {
            c16561 = new C16561(continuation);
        }
        Object obj = c16561.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16561.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            JobItemId jobItemId2 = new JobItemId(legacyJobModel2.getJobInfo().getId().getIdentifier(), true, str);
            itemName = legacyJobModel2.getItemDescriptor().getItemName();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.ENGLISH;
            FolderModel parent = legacyJobModel2.getItemDescriptor().getParent();
            String str3 = "";
            if (parent == null || (name = parent.getName()) == null) {
                name = "";
            }
            Long itemSize = legacyJobModel2.getItemDescriptor().getItemSize();
            if (itemSize != null && (formattedSize = SizeUtils.INSTANCE.toFormattedSize(itemSize.longValue())) != null) {
                str3 = formattedSize;
            }
            String str4 = String.format(locale, BoxItemBrowseViewHolder.DESCRIPTION_TEMPLATE, Arrays.copyOf(new Object[]{name, str3}, 2));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            if (stateFlow == null) {
                thumbnailManager2 = thumbnailManager;
                stateFlowStateIn = FlowKt.stateIn(FlowKt.flow(new JobsUICoreHelper$getJobStateFromLegacyJob$2$1(legacyJobModel2, this, thumbnailManager2, null)), CoroutineScopeKt.CoroutineScope(c16561.getContext()), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), getDefaultIcon(legacyJobModel2.getItemDescriptor()));
            } else {
                thumbnailManager2 = thumbnailManager;
                stateFlowStateIn = stateFlow;
            }
            FileModel itemModelOrNull = legacyJobModel2.getItemDescriptor().getItemModelOrNull();
            if (itemModelOrNull == null) {
                itemModelOrNull = null;
            } else if (itemModelOrNull instanceof RecentFileModel) {
                itemModelOrNull = RecentFileModelMapper.INSTANCE.toFileModel((RecentFileModel) itemModelOrNull);
            }
            jobTypeIconRes = getJobTypeIconRes(legacyJobModel2.getJobInfo().getJobType());
            Flow<JobInfo.Status> status = legacyJobModel2.getJobInfo().getStatus();
            c16561.L$0 = SpillingKt.nullOutSpilledVariable(legacyJobModel2);
            c16561.L$1 = SpillingKt.nullOutSpilledVariable(str);
            c16561.L$2 = SpillingKt.nullOutSpilledVariable(thumbnailManager2);
            c16561.L$3 = SpillingKt.nullOutSpilledVariable(stateFlow);
            c16561.L$4 = legacyJobModel2;
            c16561.L$5 = stateFlowStateIn;
            c16561.L$6 = str4;
            c16561.L$7 = itemName;
            c16561.L$8 = jobItemId2;
            c16561.L$9 = itemModelOrNull;
            c16561.I$0 = 0;
            c16561.I$1 = jobTypeIconRes;
            c16561.label = 1;
            Object objMapJobInfoStatusForUI = JobsUICoreHelperKt.mapJobInfoStatusForUI(status, null, c16561);
            if (objMapJobInfoStatusForUI == coroutine_suspended) {
                return coroutine_suspended;
            }
            str2 = str4;
            itemModel = itemModelOrNull;
            jobItemId = jobItemId2;
            obj = objMapJobInfoStatusForUI;
            stateFlow2 = stateFlowStateIn;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jobTypeIconRes = c16561.I$1;
            int i2 = c16561.I$0;
            ItemModel itemModel2 = (ItemModel) c16561.L$9;
            JobItemId jobItemId3 = (JobItemId) c16561.L$8;
            itemName = (String) c16561.L$7;
            String str5 = (String) c16561.L$6;
            StateFlow<? extends ItemThumbnail> stateFlow3 = (StateFlow) c16561.L$5;
            LegacyJobModel legacyJobModel3 = (LegacyJobModel) c16561.L$4;
            ResultKt.throwOnFailure(obj);
            itemModel = itemModel2;
            str2 = str5;
            stateFlow2 = stateFlow3;
            legacyJobModel2 = legacyJobModel3;
            jobItemId = jobItemId3;
        }
        int i3 = jobTypeIconRes;
        String str6 = itemName;
        StateFlow stateFlow4 = (StateFlow) obj;
        Uri uriOrNull = legacyJobModel2.getItemDescriptor().getUriOrNull();
        return new JobItemReducer.State(jobItemId, str6, str2, stateFlow2, itemModel, i3, stateFlow4, false, uriOrNull != null ? RealPathUtils.INSTANCE.getPath(uriOrNull) : null, 128, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        if (r2.equals(com.box.android.domain.jobs.JobType.CHUNK_UPLOAD) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (r2.equals(com.box.android.domain.jobs.JobType.MARK_FOR_OFFLINE) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        if (r2.equals(com.box.android.domain.jobs.JobType.MOVE_FILE) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        if (r2.equals(com.box.android.domain.jobs.JobType.COPY_FILE) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        if (r2.equals("MoveItem") == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
    
        if (r2.equals(com.box.android.domain.jobs.JobType.DELETE_FILE) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
    
        return com.box.android.jobsui.R.drawable.ic_trash24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006f, code lost:
    
        if (r2.equals(com.box.android.domain.jobs.JobType.MARK_FOR_OFFLINE_FOLDER) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0078, code lost:
    
        if (r2.equals("CopyItem") == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007d, code lost:
    
        return com.box.android.jobsui.R.drawable.ic_copy24_android;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0084, code lost:
    
        if (r2.equals(com.box.android.domain.jobs.JobType.OFFLINE_FILE) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0089, code lost:
    
        return com.box.android.jobsui.R.drawable.ic_checkmark_badge_underline;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0090, code lost:
    
        if (r2.equals(com.box.android.domain.jobs.JobType.DOWNLOAD_FILE_LEGACY) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0099, code lost:
    
        if (r2.equals(com.box.android.domain.jobs.JobType.DOWNLOAD_FILE) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
    
        return com.box.android.jobsui.R.drawable.ic_file_download_grey_24dp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a5, code lost:
    
        if (r2.equals(com.box.android.domain.jobs.JobType.UPLOAD_FILE_V2) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00aa, code lost:
    
        return com.box.android.jobsui.R.drawable.ic_file_upload_grey_24dp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
    
        if (r2.equals(com.box.android.domain.jobs.JobType.REMOVE_OFFLINE_JOB) == false) goto L64;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int getJobTypeIconRes(java.lang.String r2) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.jobsui.JobsUICoreHelper.getJobTypeIconRes(java.lang.String):int");
    }

    public final ItemThumbnail.Icon getDefaultIcon(ItemDescriptor itemDescriptor) {
        int drawable;
        Intrinsics.checkNotNullParameter(itemDescriptor, "itemDescriptor");
        ItemModel itemModelOrNull = itemDescriptor.getItemModelOrNull();
        if (itemModelOrNull != null) {
            return new ItemThumbnail.Icon(ThumbnailManager.INSTANCE.getDefaultIconResource(itemModelOrNull), null, 2, null);
        }
        if ((itemDescriptor instanceof ItemDescriptor.ExternalItem) && itemDescriptor.isFolder()) {
            FolderModel parent = itemDescriptor.getParent();
            if (parent != null) {
                drawable = ThumbnailManager.INSTANCE.getDefaultIconResource(parent);
            } else {
                drawable = R.drawable.ic_folder_personal;
            }
        } else {
            drawable = SupportedFileExtensionIcons.INSTANCE.findFileIcon(CommonBoxUtil.getFileExtension(itemDescriptor.getItemName(), "")).getDrawable();
        }
        return new ItemThumbnail.Icon(drawable, null, 2, null);
    }

    public final void logRunningJobDeleted() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent("running job deleted");
    }
}
