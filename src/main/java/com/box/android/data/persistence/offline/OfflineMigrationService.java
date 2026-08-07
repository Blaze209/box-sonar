package com.box.android.data.persistence.offline;

import android.content.SharedPreferences;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import sdk.pendo.io.models.SessionDataKt;

/* JADX INFO: compiled from: OfflineMigrationService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0007J\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010\u0011J \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u0017\u0012\u0002\b\u00030\u0016H\u0002J \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u0017\u0012\u0002\b\u00030\u0016H\u0002J\u0006\u0010\u0019\u001a\u00020\rJ\u000e\u0010\u001a\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0011J\u001a\u0010\u001b\u001a\u00020\u001c2\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u0017\u0012\u0002\b\u00030\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/persistence/offline/OfflineMigrationService;", "", "dataSource", "Lcom/box/android/data/persistence/offline/OfflineServiceLocalDataSource;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/data/persistence/offline/OfflineServiceLocalDataSource;Lcom/box/android/domain/identity/IUserContextManager;Lkotlinx/coroutines/CoroutineDispatcher;)V", "isMigrating", "", "resetMigrationState", "", "isMigrationCompleted", "migrateToRoom", "migrateToRoomInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractFileStates", "", "Lcom/box/android/data/persistence/offline/OfflineStateEntity;", "prefs", "", "", "extractFolderStates", "clearSharedPreferencesAfterMigration", "validateMigration", "countSavedItems", "", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfflineMigrationService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String IS_OFFLINE_USER_REMOVED = "isOfflineUserRemoved";
    private static final String IS_OFFLINE_USER_SAVED = "isOfflineUserSaved";
    private static final String OFFLINE_COMPLETED_DATE = "offlineCompletedDate";
    private static final String OFFLINE_SHA1 = "offlineSha1";
    private static final String OFFLINE_STARTED_DATE = "offlineStartedDate";
    private final OfflineServiceLocalDataSource dataSource;
    private final CoroutineDispatcher ioDispatcher;
    private volatile boolean isMigrating;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineMigrationService$migrateToRoomInternal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OfflineMigrationService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineMigrationService", f = "OfflineMigrationService.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {126, 130}, m = "migrateToRoomInternal", n = {"filePrefs", "folderPrefs", "fileEntries", "folderEntries", "allEntries", "startTime", "filePrefs", "folderPrefs", "fileEntries", "folderEntries", "allEntries", "startTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0"}, v = 1)
    static final class C13761 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C13761(Continuation<? super C13761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfflineMigrationService.this.migrateToRoomInternal(this);
        }
    }

    @Inject
    public OfflineMigrationService(OfflineServiceLocalDataSource dataSource, IUserContextManager userContextManager, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.dataSource = dataSource;
        this.userContextManager = userContextManager;
        this.ioDispatcher = ioDispatcher;
    }

    /* JADX INFO: compiled from: OfflineMigrationService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b*\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/data/persistence/offline/OfflineMigrationService$Companion;", "", "<init>", "()V", "IS_OFFLINE_USER_SAVED", "", "IS_OFFLINE_USER_REMOVED", "OFFLINE_STARTED_DATE", "OFFLINE_COMPLETED_DATE", "OFFLINE_SHA1", "toLongOrNull", "", "(Ljava/lang/Object;)Ljava/lang/Long;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Long toLongOrNull(Object obj) {
            if (obj instanceof Long) {
                return (Long) obj;
            }
            if (obj instanceof Integer) {
                return Long.valueOf(((Number) obj).intValue());
            }
            if (obj instanceof String) {
                return toLongOrNull(obj);
            }
            return null;
        }
    }

    public final void resetMigrationState() {
        this.isMigrating = false;
    }

    public final boolean isMigrationCompleted() {
        return this.userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFileSharedPreferences).getAll().isEmpty() && this.userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFolderSharedPreferences).getAll().isEmpty();
    }

    public final void migrateToRoom() {
        if (this.isMigrating) {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Migration already in progress, skipping");
        } else {
            this.isMigrating = true;
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.ioDispatcher), null, null, new AnonymousClass1(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineMigrationService$migrateToRoom$1, reason: invalid class name */
    /* JADX INFO: compiled from: OfflineMigrationService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineMigrationService$migrateToRoom$1", f = "OfflineMigrationService.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OfflineMigrationService.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, kotlin.Unit] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (OfflineMigrationService.this.migrateToRoomInternal(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                OfflineMigrationService.this.isMigrating = false;
                this = Unit.INSTANCE;
                return this;
            } catch (Throwable th) {
                OfflineMigrationService.this.isMigrating = false;
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:38:0x0110 A[Catch: Exception -> 0x015b, TryCatch #0 {Exception -> 0x015b, blocks: (B:13:0x0043, B:36:0x0108, B:38:0x0110, B:40:0x011c, B:18:0x0066, B:32:0x00e5, B:21:0x006d, B:23:0x0073, B:25:0x007f, B:27:0x00bc), top: B:46:0x0027 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x011c A[Catch: Exception -> 0x015b, TRY_LEAVE, TryCatch #0 {Exception -> 0x015b, blocks: (B:13:0x0043, B:36:0x0108, B:38:0x0110, B:40:0x011c, B:18:0x0066, B:32:0x00e5, B:21:0x006d, B:23:0x0073, B:25:0x007f, B:27:0x00bc), top: B:46:0x0027 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object migrateToRoomInternal(Continuation<? super Unit> continuation) {
        C13761 c13761;
        SharedPreferences userSharedPrefs;
        SharedPreferences userSharedPrefs2;
        List<OfflineStateEntity> listExtractFolderStates;
        List<OfflineStateEntity> listPlus;
        long j;
        List<OfflineStateEntity> list;
        List<OfflineStateEntity> list2;
        long j2;
        List<OfflineStateEntity> list3;
        if (continuation instanceof C13761) {
            c13761 = (C13761) continuation;
            if ((c13761.label & Integer.MIN_VALUE) != 0) {
                c13761.label -= Integer.MIN_VALUE;
            } else {
                c13761 = new C13761(continuation);
            }
        } else {
            c13761 = new C13761(continuation);
        }
        Object objValidateMigration = c13761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c13761.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    j = c13761.J$0;
                    listPlus = (List) c13761.L$4;
                    listExtractFolderStates = (List) c13761.L$3;
                    list = (List) c13761.L$2;
                    userSharedPrefs2 = (SharedPreferences) c13761.L$1;
                    userSharedPrefs = (SharedPreferences) c13761.L$0;
                    ResultKt.throwOnFailure(objValidateMigration);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j2 = c13761.J$0;
                    list2 = (List) c13761.L$3;
                    list3 = (List) c13761.L$2;
                    ResultKt.throwOnFailure(objValidateMigration);
                }
                if (!((Boolean) objValidateMigration).booleanValue()) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Migration validation failed - Data count mismatch between SharedPreferences and Room database");
                    return Unit.INSTANCE;
                }
                clearSharedPreferencesAfterMigration();
                long jCurrentTimeMillis = System.currentTimeMillis() - j2;
                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Migration completed successfully in " + jCurrentTimeMillis + "ms - migrated " + list3.size() + " files and " + list2.size() + " folders");
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(objValidateMigration);
            if (isMigrationCompleted()) {
                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Migration already completed, skipping");
                return Unit.INSTANCE;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            userSharedPrefs = this.userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFileSharedPreferences);
            userSharedPrefs2 = this.userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFolderSharedPreferences);
            Map<String, ?> all = userSharedPrefs.getAll();
            Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
            List<OfflineStateEntity> listExtractFileStates = extractFileStates(all);
            Map<String, ?> all2 = userSharedPrefs2.getAll();
            Intrinsics.checkNotNullExpressionValue(all2, "getAll(...)");
            listExtractFolderStates = extractFolderStates(all2);
            listPlus = CollectionsKt.plus((Collection) listExtractFileStates, (Iterable) listExtractFolderStates);
            if (!listPlus.isEmpty()) {
                OfflineServiceLocalDataSource offlineServiceLocalDataSource = this.dataSource;
                c13761.L$0 = SpillingKt.nullOutSpilledVariable(userSharedPrefs);
                c13761.L$1 = SpillingKt.nullOutSpilledVariable(userSharedPrefs2);
                c13761.L$2 = listExtractFileStates;
                c13761.L$3 = listExtractFolderStates;
                c13761.L$4 = SpillingKt.nullOutSpilledVariable(listPlus);
                c13761.J$0 = jCurrentTimeMillis2;
                c13761.label = 1;
                if (offlineServiceLocalDataSource.bulkInsert(listPlus, c13761) == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            j = jCurrentTimeMillis2;
            list = listExtractFileStates;
            List<OfflineStateEntity> list4 = listPlus;
            list2 = listExtractFolderStates;
            c13761.L$0 = SpillingKt.nullOutSpilledVariable(userSharedPrefs);
            c13761.L$1 = SpillingKt.nullOutSpilledVariable(userSharedPrefs2);
            c13761.L$2 = list;
            c13761.L$3 = list2;
            c13761.L$4 = SpillingKt.nullOutSpilledVariable(list4);
            c13761.J$0 = j;
            c13761.label = 2;
            objValidateMigration = validateMigration(c13761);
            if (objValidateMigration != coroutine_suspended) {
                j2 = j;
                list3 = list;
                if (!((Boolean) objValidateMigration).booleanValue()) {
                    BoxLogUtils.e(ExtensionsKt.getTAG(this), "Migration validation failed - Data count mismatch between SharedPreferences and Room database");
                    return Unit.INSTANCE;
                }
                clearSharedPreferencesAfterMigration();
                long jCurrentTimeMillis3 = System.currentTimeMillis() - j2;
                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Migration completed successfully in " + jCurrentTimeMillis3 + "ms - migrated " + list3.size() + " files and " + list2.size() + " folders");
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Migration failed - SharedPreferences data preserved", e);
        }
    }

    private final List<OfflineStateEntity> extractFileStates(Map<String, ?> prefs) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : prefs.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) key, SessionDataKt.UNDERSCORE, 0, false, 6, (Object) null);
            if (iLastIndexOf$default > 0 && iLastIndexOf$default < key.length() - 1) {
                String strSubstring = key.substring(0, iLastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String strSubstring2 = key.substring(iLastIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                Object obj = linkedHashMap.get(strSubstring);
                if (obj == null) {
                    obj = (Map) new LinkedHashMap();
                    linkedHashMap.put(strSubstring, obj);
                }
                ((Map) obj).put(strSubstring2, value);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            String str = (String) entry2.getKey();
            Map map = (Map) entry2.getValue();
            Object obj2 = map.get(IS_OFFLINE_USER_SAVED);
            OfflineStateEntity offlineStateEntity = null;
            Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            Object obj3 = map.get(IS_OFFLINE_USER_REMOVED);
            Boolean bool2 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : false;
            if (zBooleanValue || zBooleanValue2 || map.get(OFFLINE_COMPLETED_DATE) != null || map.get(OFFLINE_SHA1) != null) {
                ItemType itemType = ItemType.FILE;
                Long longOrNull = INSTANCE.toLongOrNull(map.get(OFFLINE_COMPLETED_DATE));
                Object obj4 = map.get(OFFLINE_SHA1);
                offlineStateEntity = new OfflineStateEntity(str, itemType, zBooleanValue, zBooleanValue2, null, longOrNull, obj4 instanceof String ? (String) obj4 : null, 16, null);
            }
            if (offlineStateEntity != null) {
                arrayList.add(offlineStateEntity);
            }
        }
        return arrayList;
    }

    private final List<OfflineStateEntity> extractFolderStates(Map<String, ?> prefs) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : prefs.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) key, SessionDataKt.UNDERSCORE, 0, false, 6, (Object) null);
            if (iLastIndexOf$default > 0 && iLastIndexOf$default < key.length() - 1) {
                String strSubstring = key.substring(0, iLastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String strSubstring2 = key.substring(iLastIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                Object obj = linkedHashMap.get(strSubstring);
                if (obj == null) {
                    obj = (Map) new LinkedHashMap();
                    linkedHashMap.put(strSubstring, obj);
                }
                ((Map) obj).put(strSubstring2, value);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            String str = (String) entry2.getKey();
            Map map = (Map) entry2.getValue();
            Object obj2 = map.get(IS_OFFLINE_USER_SAVED);
            OfflineStateEntity offlineStateEntity = null;
            Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            Object obj3 = map.get(IS_OFFLINE_USER_REMOVED);
            Boolean bool2 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : false;
            if (zBooleanValue || zBooleanValue2 || map.get(OFFLINE_STARTED_DATE) != null || map.get(OFFLINE_COMPLETED_DATE) != null) {
                ItemType itemType = ItemType.FOLDER;
                Companion companion = INSTANCE;
                offlineStateEntity = new OfflineStateEntity(str, itemType, zBooleanValue, zBooleanValue2, companion.toLongOrNull(map.get(OFFLINE_STARTED_DATE)), companion.toLongOrNull(map.get(OFFLINE_COMPLETED_DATE)), null, 64, null);
            }
            if (offlineStateEntity != null) {
                arrayList.add(offlineStateEntity);
            }
        }
        return arrayList;
    }

    public final void clearSharedPreferencesAfterMigration() throws Exception {
        try {
            SharedPreferences userSharedPrefs = this.userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFileSharedPreferences);
            SharedPreferences userSharedPrefs2 = this.userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFolderSharedPreferences);
            Intrinsics.checkNotNull(userSharedPrefs);
            SharedPreferences.Editor editorEdit = userSharedPrefs.edit();
            editorEdit.clear();
            editorEdit.apply();
            Intrinsics.checkNotNull(userSharedPrefs2);
            SharedPreferences.Editor editorEdit2 = userSharedPrefs2.edit();
            editorEdit2.clear();
            editorEdit2.apply();
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Failed to clear SharedPreferences after migration", e);
            throw e;
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.persistence.offline.OfflineMigrationService$validateMigration$2, reason: invalid class name */
    /* JADX INFO: compiled from: OfflineMigrationService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.persistence.offline.OfflineMigrationService$validateMigration$2", f = "OfflineMigrationService.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {268, 269}, m = "invokeSuspend", n = {"$this$withContext", "filePrefs", "folderPrefs", "spFileCount", "spFolderCount", "$this$withContext", "filePrefs", "folderPrefs", "spFileCount", "spFolderCount", "roomFileCount"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = OfflineMigrationService.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SharedPreferences userSharedPrefs;
            SharedPreferences userSharedPrefs2;
            int iCountSavedItems;
            int i;
            int i2;
            int i3;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            boolean z = false;
            try {
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    userSharedPrefs = OfflineMigrationService.this.userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFileSharedPreferences);
                    userSharedPrefs2 = OfflineMigrationService.this.userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFolderSharedPreferences);
                    OfflineMigrationService offlineMigrationService = OfflineMigrationService.this;
                    Map<String, ?> all = userSharedPrefs.getAll();
                    Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
                    int iCountSavedItems2 = offlineMigrationService.countSavedItems(all);
                    OfflineMigrationService offlineMigrationService2 = OfflineMigrationService.this;
                    Map<String, ?> all2 = userSharedPrefs2.getAll();
                    Intrinsics.checkNotNullExpressionValue(all2, "getAll(...)");
                    iCountSavedItems = offlineMigrationService2.countSavedItems(all2);
                    this.L$0 = coroutineScope;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(userSharedPrefs);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(userSharedPrefs2);
                    this.I$0 = iCountSavedItems2;
                    this.I$1 = iCountSavedItems;
                    this.label = 1;
                    Object objCountOfflinedFiles = OfflineMigrationService.this.dataSource.countOfflinedFiles(this);
                    if (objCountOfflinedFiles != coroutine_suspended) {
                        i = iCountSavedItems2;
                        obj = objCountOfflinedFiles;
                    }
                    return coroutine_suspended;
                }
                if (i4 == 1) {
                    iCountSavedItems = this.I$1;
                    i = this.I$0;
                    userSharedPrefs2 = (SharedPreferences) this.L$2;
                    userSharedPrefs = (SharedPreferences) this.L$1;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i4 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i3 = this.I$2;
                    i2 = this.I$1;
                    i = this.I$0;
                    ResultKt.throwOnFailure(obj);
                }
                int iIntValue = ((Number) obj).intValue();
                if (i == i3 && i2 == iIntValue) {
                    z = true;
                }
                return Boxing.boxBoolean(z);
                int iIntValue2 = ((Number) obj).intValue();
                this.L$0 = coroutineScope;
                this.L$1 = SpillingKt.nullOutSpilledVariable(userSharedPrefs);
                this.L$2 = SpillingKt.nullOutSpilledVariable(userSharedPrefs2);
                this.I$0 = i;
                this.I$1 = iCountSavedItems;
                this.I$2 = iIntValue2;
                this.label = 2;
                Object objCountOfflinedFolders = OfflineMigrationService.this.dataSource.countOfflinedFolders(this);
                if (objCountOfflinedFolders != coroutine_suspended) {
                    i2 = iCountSavedItems;
                    i3 = iIntValue2;
                    obj = objCountOfflinedFolders;
                    int iIntValue3 = ((Number) obj).intValue();
                    if (i == i3) {
                        z = true;
                    }
                    return Boxing.boxBoolean(z);
                }
                return coroutine_suspended;
            } catch (Exception e) {
                BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Migration validation error", e);
            }
        }
    }

    public final Object validateMigration(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new AnonymousClass2(null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int countSavedItems(Map<String, ?> prefs) {
        if (prefs.isEmpty()) {
            return 0;
        }
        int i = 0;
        for (Map.Entry<String, ?> entry : prefs.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (StringsKt.endsWith$default(key, "_isOfflineUserSaved", false, 2, (Object) null) && Intrinsics.areEqual(value, (Object) true)) {
                i++;
            }
        }
        return i;
    }
}
