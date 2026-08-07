package com.box.android.data.service.impl;

import android.content.SharedPreferences;
import com.box.android.data.datasource.jobs.JobsDataSource;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.androidsdk.content.utils.BoxLogUtils;
import dagger.Lazy;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: UploadFileCleanupService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0082@¢\u0006\u0002\u0010\u0019J\u001a\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/service/impl/UploadFileCleanupService;", "", "jobsDataSource", "Lcom/box/android/data/datasource/jobs/JobsDataSource;", "localItemService", "Ldagger/Lazy;", "Lcom/box/android/data/service/impl/LocalItemService;", "boxStorage", "Lcom/box/android/domain/localrepo/IBoxStorage;", "localSharedPreferences", "Lcom/box/android/domain/localrepo/ILocalSharedPreferences;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/data/datasource/jobs/JobsDataSource;Ldagger/Lazy;Lcom/box/android/domain/localrepo/IBoxStorage;Lcom/box/android/domain/localrepo/ILocalSharedPreferences;Lkotlinx/coroutines/CoroutineDispatcher;)V", "cleanupOrphanedFiles", "", "force", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPreferences", "Landroid/content/SharedPreferences;", "getUploadJobContentUris", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleCleanup", "delayMillis", "", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadFileCleanupService {
    private static final long CLEANUP_THROTTLE_INTERVAL_MS = 86400000;
    private static final String LAST_CLEANUP_TIMESTAMP_KEY = "last_cleanup_timestamp";
    private static final String TAG = "UploadFileCleanupService";
    private final IBoxStorage boxStorage;
    private final CoroutineDispatcher ioDispatcher;
    private final JobsDataSource jobsDataSource;
    private final Lazy<LocalItemService> localItemService;
    private final ILocalSharedPreferences localSharedPreferences;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.UploadFileCleanupService$cleanupOrphanedFiles$1, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFileCleanupService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.UploadFileCleanupService", f = "UploadFileCleanupService.kt", i = {0, 0, 0, 0, 0, 0}, l = {72}, m = "cleanupOrphanedFiles", n = {"prefs", "directory", "files", "force", "lastCleanupTime", "currentTime"}, s = {"L$0", "L$1", "L$2", "Z$0", "J$0", "J$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
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
            return UploadFileCleanupService.this.cleanupOrphanedFiles(false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.UploadFileCleanupService$getUploadJobContentUris$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileCleanupService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.UploadFileCleanupService", f = "UploadFileCleanupService.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {124, 139}, m = "getUploadJobContentUris", n = {"contentUris", "contentUris", "allJobsResult", "uploadJobs", "$this$forEach$iv", "element$iv", "jobEntity", "inputData", "itemId", "id", "$i$f$forEach", "$i$a$-forEach-UploadFileCleanupService$getUploadJobContentUris$2", "$i$a$-let-UploadFileCleanupService$getUploadJobContentUris$2$1"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2"}, v = 1)
    static final class C15291 extends ContinuationImpl {
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
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C15291(Continuation<? super C15291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileCleanupService.this.getUploadJobContentUris(this);
        }
    }

    @Inject
    public UploadFileCleanupService(JobsDataSource jobsDataSource, Lazy<LocalItemService> localItemService, IBoxStorage boxStorage, ILocalSharedPreferences localSharedPreferences, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(jobsDataSource, "jobsDataSource");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(boxStorage, "boxStorage");
        Intrinsics.checkNotNullParameter(localSharedPreferences, "localSharedPreferences");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.jobsDataSource = jobsDataSource;
        this.localItemService = localItemService;
        this.boxStorage = boxStorage;
        this.localSharedPreferences = localSharedPreferences;
        this.ioDispatcher = ioDispatcher;
    }

    public static /* synthetic */ Object cleanupOrphanedFiles$default(UploadFileCleanupService uploadFileCleanupService, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return uploadFileCleanupService.cleanupOrphanedFiles(z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object cleanupOrphanedFiles(boolean z, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        long jCurrentTimeMillis;
        SharedPreferences sharedPreferences;
        File[] fileArr;
        String absolutePath;
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
            SharedPreferences preferences = getPreferences();
            long j = preferences.getLong(LAST_CLEANUP_TIMESTAMP_KEY, 0L);
            jCurrentTimeMillis = System.currentTimeMillis();
            if (!z) {
                long j2 = jCurrentTimeMillis - j;
                if (j2 < 86400000) {
                    BoxLogUtils.i(TAG, "Skipping cleanup - last cleanup was " + ((j2 / ((long) 1000)) / ((long) 60)) + " minutes ago");
                    return Unit.INSTANCE;
                }
            }
            File pendingUploadDirectory = this.boxStorage.getPendingUploadDirectory();
            if (!pendingUploadDirectory.exists() || !pendingUploadDirectory.isDirectory()) {
                BoxLogUtils.w(TAG, "Pending upload directory does not exist or is not a directory");
                return Unit.INSTANCE;
            }
            File[] fileArrListFiles = pendingUploadDirectory.listFiles();
            if (fileArrListFiles == null) {
                fileArrListFiles = new File[0];
            }
            if (fileArrListFiles.length == 0) {
                BoxLogUtils.i(TAG, "No files to cleanup in pending upload directory");
                return Unit.INSTANCE;
            }
            anonymousClass1.L$0 = preferences;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(pendingUploadDirectory);
            anonymousClass1.L$2 = fileArrListFiles;
            anonymousClass1.Z$0 = z;
            anonymousClass1.J$0 = j;
            anonymousClass1.J$1 = jCurrentTimeMillis;
            anonymousClass1.label = 1;
            Object uploadJobContentUris = getUploadJobContentUris(anonymousClass1);
            if (uploadJobContentUris == coroutine_suspended) {
                return coroutine_suspended;
            }
            sharedPreferences = preferences;
            fileArr = fileArrListFiles;
            obj = uploadJobContentUris;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j3 = anonymousClass1.J$1;
            long j4 = anonymousClass1.J$0;
            boolean z2 = anonymousClass1.Z$0;
            fileArr = (File[]) anonymousClass1.L$2;
            sharedPreferences = (SharedPreferences) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            jCurrentTimeMillis = j3;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : (List) obj) {
            try {
                absolutePath = new File(str).getAbsolutePath();
            } catch (Exception e) {
                BoxLogUtils.e(TAG, "Error processing URI: " + str, e);
                absolutePath = null;
            }
            if (absolutePath != null) {
                arrayList.add(absolutePath);
            }
        }
        Set set = CollectionsKt.toSet(arrayList);
        int i2 = 0;
        int i3 = 0;
        for (File file : fileArr) {
            if (set.contains(file.getAbsolutePath())) {
                BoxLogUtils.v(TAG, "Skipping file associated with job: " + file.getAbsolutePath());
            } else {
                try {
                    if (file.delete()) {
                        i2++;
                        BoxLogUtils.i(TAG, "Deleted orphaned file: " + file.getName());
                    } else {
                        i3++;
                        BoxLogUtils.w(TAG, "Failed to delete orphaned file: " + file.getName());
                    }
                } catch (Exception e2) {
                    i3++;
                    BoxLogUtils.e(TAG, "Error deleting orphaned file: " + file.getName(), e2);
                }
            }
        }
        sharedPreferences.edit().putLong(LAST_CLEANUP_TIMESTAMP_KEY, jCurrentTimeMillis).apply();
        BoxLogUtils.e(TAG, "Cleanup completed: deleted=" + i2 + ", failed=" + i3 + ", jobFiles=" + set.size());
        return Unit.INSTANCE;
    }

    private final SharedPreferences getPreferences() {
        return this.localSharedPreferences.getSharedPreferences(ILocalSharedPreferences.PreferenceName.GLOBAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:61:0x0171  */
    /* JADX WARN: Code duplicated, block: B:65:0x0106 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0154 -> B:69:0x0157). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0171 -> B:63:0x018c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0174 -> B:63:0x018c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object getUploadJobContentUris(kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> r18) {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.UploadFileCleanupService.getUploadJobContentUris(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.UploadFileCleanupService$scheduleCleanup$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileCleanupService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.UploadFileCleanupService$scheduleCleanup$1", f = "UploadFileCleanupService.kt", i = {}, l = {Token.COMMENT, Token.GENEXPR}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMillis;
        final /* synthetic */ boolean $force;
        int label;
        final /* synthetic */ UploadFileCleanupService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15301(long j, UploadFileCleanupService uploadFileCleanupService, boolean z, Continuation<? super C15301> continuation) {
            super(2, continuation);
            this.$delayMillis = j;
            this.this$0 = uploadFileCleanupService;
            this.$force = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C15301(this.$delayMillis, this.this$0, this.$force, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
        
            if (r6.this$0.cleanupOrphanedFiles(r6.$force, r6) == r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L3f
                goto L49
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1a:
                kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L3f
                goto L2f
            L1e:
                kotlin.ResultKt.throwOnFailure(r7)
                long r4 = r6.$delayMillis     // Catch: java.lang.Exception -> L3f
                r7 = r6
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.lang.Exception -> L3f
                r6.label = r3     // Catch: java.lang.Exception -> L3f
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)     // Catch: java.lang.Exception -> L3f
                if (r7 != r0) goto L2f
                goto L3e
            L2f:
                com.box.android.data.service.impl.UploadFileCleanupService r7 = r6.this$0     // Catch: java.lang.Exception -> L3f
                boolean r1 = r6.$force     // Catch: java.lang.Exception -> L3f
                r3 = r6
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch: java.lang.Exception -> L3f
                r6.label = r2     // Catch: java.lang.Exception -> L3f
                java.lang.Object r6 = r7.cleanupOrphanedFiles(r1, r3)     // Catch: java.lang.Exception -> L3f
                if (r6 != r0) goto L49
            L3e:
                return r0
            L3f:
                r6 = move-exception
                java.lang.String r7 = "Error during scheduled cleanup"
                java.lang.Throwable r6 = (java.lang.Throwable) r6
                java.lang.String r0 = "UploadFileCleanupService"
                com.box.androidsdk.content.utils.BoxLogUtils.e(r0, r7, r6)
            L49:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.UploadFileCleanupService.C15301.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static /* synthetic */ void scheduleCleanup$default(UploadFileCleanupService uploadFileCleanupService, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 5000;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        uploadFileCleanupService.scheduleCleanup(j, z);
    }

    public final void scheduleCleanup(long delayMillis, boolean force) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new C15301(delayMillis, this, force, null), 3, null);
    }
}
