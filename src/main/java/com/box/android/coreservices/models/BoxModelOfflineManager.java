package com.box.android.coreservices.models;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.OfflineBoxJobCollection;
import com.box.android.coreservices.localrepo.IDownloadFiles;
import com.box.android.coreservices.localrepo.ILocalFiles;
import com.box.android.coreservices.localrepo.IPreviewFiles;
import com.box.android.coreservices.modelcontroller.messages.BoxSaveAllOfflineMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.coreservices.utilities.imagemanager.LegacyCacheManager;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.offline.IOfflineStateStorage;
import com.box.android.domain.offline.OfflineStateModel;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.utils.result.Result;
import com.box.android.observability.DiagnosisParams;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.apache.hc.core5.http.HttpStatus;

/* JADX INFO: compiled from: BoxModelOfflineManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002|}B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0007J\b\u0010\u0010\u001a\u00020\u000eH\u0007J1\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u001c\u0010\u0013\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014H\u0002¢\u0006\u0002\u0010\u0016J\u0080\u0001\u0010\u0017\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c23\u0010\u001d\u001a/\b\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e¢\u0006\u0002\b\u001f2\u001d\u0010 \u001a\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00120!¢\u0006\u0002\b\u001fH\u0082@¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J$\u0010(\u001a\b\u0012\u0004\u0012\u00020%0)2\u0006\u0010\u0018\u001a\u00020*2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,J*\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020/2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0087@¢\u0006\u0002\u00103J\u0018\u00104\u001a\u0002012\u0006\u00102\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J \u00105\u001a\u0002012\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u00108J\u001a\u00109\u001a\u0002012\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001e\u0010:\u001a\u0002012\u0006\u00106\u001a\u0002072\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u00108J\u0018\u0010;\u001a\u0002012\u0006\u00106\u001a\u0002072\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001e\u0010<\u001a\u00020=2\u0006\u00102\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0087@¢\u0006\u0002\u00103J\u0018\u0010>\u001a\u00020=2\u0006\u00102\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001a\u0010?\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J \u0010@\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u00103J&\u0010A\u001a\u00020\u000e2\u0006\u00106\u001a\u0002072\u0006\u0010B\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010CJ \u0010D\u001a\u00020\u000e2\u0006\u00106\u001a\u0002072\u0006\u0010B\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J&\u0010E\u001a\u00020\u000e2\u0006\u00106\u001a\u0002072\u0006\u0010F\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010CJ \u0010G\u001a\u00020\u000e2\u0006\u00106\u001a\u0002072\u0006\u0010F\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001e\u0010H\u001a\u0002012\u0006\u0010I\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0087@¢\u0006\u0002\u00103J\u0018\u0010J\u001a\u0002012\u0006\u0010I\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J \u00105\u001a\u0002012\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010MJ\u001a\u00109\u001a\u0002012\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001e\u0010:\u001a\u0002012\u0006\u0010K\u001a\u00020L2\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010MJ\u0018\u0010;\u001a\u0002012\u0006\u0010K\u001a\u00020L2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001e\u0010N\u001a\u0002012\u0006\u0010I\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u00103J\u0018\u0010O\u001a\u0002012\u0006\u0010I\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0018\u0010P\u001a\u0002012\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0016\u0010P\u001a\u0002012\u0006\u0010S\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010T\u001a\u00020=2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0018\u0010U\u001a\u00020=2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001e\u0010V\u001a\u00020=2\u0006\u0010I\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u00103J.\u0010W\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020L2\u0006\u0010X\u001a\u0002012\u0006\u0010Y\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010ZJ(\u0010[\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020L2\u0006\u0010X\u001a\u0002012\u0006\u0010Y\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J&\u0010\\\u001a\u0002012\u0006\u0010K\u001a\u00020L2\u0006\u0010F\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010]J \u0010^\u001a\u0002012\u0006\u0010K\u001a\u00020L2\u0006\u0010F\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010_\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001c\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00050a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010bJ\u0016\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00050a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001c\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00050a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010bJ\u0016\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00050a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0016\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00050a2\u0006\u0010g\u001a\u00020\"H\u0007J\u0010\u0010h\u001a\u00020i2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010j\u001a\u00020k2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010l\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010m\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010n\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J.\u0010o\u001a\b\u0012\u0004\u0012\u0002010p2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020vH\u0007J\u0010\u0010w\u001a\u0002012\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010x\u001a\u00020\u000e2\u0006\u0010y\u001a\u00020zH\u0007J\u0010\u0010{\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006~"}, d2 = {"Lcom/box/android/coreservices/models/BoxModelOfflineManager;", "", "<init>", "()V", "IS_OFFLINE_USER_SAVED", "", "IS_OFFLINE_USER_REMOVED", "OFFLINE_STARTED_DATE", "OFFLINE_COMPLETED_DATE", "OFFLINE_SHA1", "SAVED_FOR_OFFLINE_POSTFIX", "offlineStorage", "Lcom/box/android/domain/offline/IOfflineStateStorage;", "setOfflineStorage", "", "storage", "resetOfflineStorage", "blockingSuspend", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withStorageRead", "itemId", "itemType", "Lcom/box/android/domain/models/item/ItemType;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "storageOp", "Lkotlin/Function4;", "Lkotlin/ExtensionFunctionType;", "sharedPrefsOp", "Lkotlin/Function2;", "Landroid/content/SharedPreferences;", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;Lcom/box/android/domain/identity/IUserContextManager;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getState", "Lcom/box/android/coreservices/models/BoxModelOfflineManager$State;", "item", "Lcom/box/android/domain/models/item/ItemModel;", "getStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/models/ItemId;", "remoteItemService", "Lcom/box/android/domain/services/IRemoteItemService;", "mapOfflineStateModelToState", "offlineState", "Lcom/box/android/domain/offline/OfflineStateModel;", "isFileSpecificallyUserSaved", "", "fileId", "(Ljava/lang/String;Lcom/box/android/domain/identity/IUserContextManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFileSpecificallyUserSavedBlocking", BoxModelOfflineManager.IS_OFFLINE_USER_SAVED, "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "(Lcom/box/androidsdk/content/models/BoxFile;Lcom/box/android/domain/identity/IUserContextManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isOfflineUserSavedBlocking", BoxModelOfflineManager.IS_OFFLINE_USER_REMOVED, "isOfflineUserRemovedBlocking", "getFileSavedCompletedDate", "", "getFileSavedCompletedDateBlocking", "getFileSavedSha1Blocking", "getFileSavedSha1", "setFileOfflineUserSaved", "userSaved", "(Lcom/box/androidsdk/content/models/BoxFile;ZLcom/box/android/domain/identity/IUserContextManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFileOfflineUserSavedBlocking", "setFileOfflineSavedCompleted", "savedOffline", "setFileOfflineSavedCompletedBlocking", "isFolderSpecificallyUserSaved", "folderId", "isFolderSpecificallyUserSavedBlocking", "boxFolder", "Lcom/box/androidsdk/content/models/BoxFolder;", "(Lcom/box/androidsdk/content/models/BoxFolder;Lcom/box/android/domain/identity/IUserContextManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isOfflineUserRemovedFolder", "isOfflineUserRemovedFolderBlocking", "isSpecificallyUserSaved", "boxItem", "Lcom/box/androidsdk/content/models/BoxItem;", "itemModel", "getFolderSavedStartedDate", "getFolderSavedCompletedDateBlocking", "getFolderSavedCompletedDate", "setFolderOfflineSavedStarted", "savedForOffline", "startedDate", "(Lcom/box/androidsdk/content/models/BoxFolder;ZJLcom/box/android/domain/identity/IUserContextManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFolderOfflineSavedStartedBlocking", "setFolderOfflineSavedCompleted", "(Lcom/box/androidsdk/content/models/BoxFolder;ZLcom/box/android/domain/identity/IUserContextManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFolderOfflineSavedCompletedBlocking", "clearOfflineInformation", "fetchUserOfflinedFileIds", "", "(Lcom/box/android/domain/identity/IUserContextManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchUserOfflinedFileIdsBlocking", "fetchUserOfflinedFolderIds", "fetchUserOfflinedFolderIdsBlocking", "fetchOfflinedIds", "pref", "getDownloadFiles", "Lcom/box/android/coreservices/localrepo/IDownloadFiles;", "getPreviewFiles", "Lcom/box/android/coreservices/localrepo/IPreviewFiles;", "getLegacyCacheSize", "getLegacyDownloadSize", "getTotalCacheSize", "removeAllOfflineFileFolders", "Ljava/util/concurrent/FutureTask;", "kv", "Lcom/box/android/domain/localrepo/IKeyValueStore;", "jobManager", "Lcom/box/android/coreservices/jobmanager/JobManager;", "jobService", "Lcom/box/android/domain/services/IJobService;", "userHasOfflineFiles", "broadcastIntent", "intent", "Landroid/content/Intent;", "getIsOfflineUserSavedString", "State", "Manager", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxModelOfflineManager {
    public static final BoxModelOfflineManager INSTANCE = new BoxModelOfflineManager();
    private static final String IS_OFFLINE_USER_REMOVED = "isOfflineUserRemoved";
    private static final String IS_OFFLINE_USER_SAVED = "isOfflineUserSaved";
    private static final String OFFLINE_COMPLETED_DATE = "offlineCompletedDate";
    private static final String OFFLINE_SHA1 = "offlineSha1";
    private static final String OFFLINE_STARTED_DATE = "offlineStartedDate";
    private static final String SAVED_FOR_OFFLINE_POSTFIX = "_isOfflineUserSaved";
    private static IOfflineStateStorage offlineStorage;

    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/box/android/coreservices/models/BoxModelOfflineManager$State;", "", "<init>", "(Ljava/lang/String;I)V", "OFFLINE", "OFFLINE_PENDING", "CACHED", "OUT_OF_DATE", "NONE", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum State {
        OFFLINE,
        OFFLINE_PENDING,
        CACHED,
        OUT_OF_DATE,
        NONE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemType.values().length];
            try {
                iArr[ItemType.FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemType.FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$fetchUserOfflinedFileIds$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager", f = "BoxModelOfflineManager.kt", i = {0}, l = {651}, m = "fetchUserOfflinedFileIds", n = {"userContextManager"}, s = {"L$0"}, v = 1)
    static final class C10091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10091(Continuation<? super C10091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxModelOfflineManager.this.fetchUserOfflinedFileIds(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$fetchUserOfflinedFolderIds$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager", f = "BoxModelOfflineManager.kt", i = {0}, l = {660}, m = "fetchUserOfflinedFolderIds", n = {"userContextManager"}, s = {"L$0"}, v = 1)
    static final class C10111 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10111(Continuation<? super C10111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxModelOfflineManager.this.fetchUserOfflinedFolderIds(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$getFileSavedSha1$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager", f = "BoxModelOfflineManager.kt", i = {0, 0}, l = {334}, m = "getFileSavedSha1", n = {"fileId", "userContextManager"}, s = {"L$0", "L$1"}, v = 1)
    static final class C10141 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10141(Continuation<? super C10141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxModelOfflineManager.this.getFileSavedSha1(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserSaved$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager", f = "BoxModelOfflineManager.kt", i = {0, 0, 1, 1, 2, 2}, l = {283, 286, 287}, m = BoxModelOfflineManager.IS_OFFLINE_USER_SAVED, n = {"boxFile", "userContextManager", "boxFile", "userContextManager", "boxFile", "userContextManager"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class C10281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10281(Continuation<? super C10281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxModelOfflineManager.this.isOfflineUserSaved((BoxFile) null, (IUserContextManager) null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserSaved$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager", f = "BoxModelOfflineManager.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {434, 438, 450, 453}, m = BoxModelOfflineManager.IS_OFFLINE_USER_SAVED, n = {"boxFolder", "userContextManager", "boxFolder", "userContextManager", "boxFolder", "userContextManager", "lineageCollection", "$this$forEach$iv", "element$iv", "pair", "$i$f$forEach", "$i$a$-forEach-BoxModelOfflineManager$isOfflineUserSaved$3", "boxFolder", "userContextManager", "lineageCollection", "$this$forEach$iv", "element$iv", "pair", "$i$f$forEach", "$i$a$-forEach-BoxModelOfflineManager$isOfflineUserSaved$3"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class C10292 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C10292(Continuation<? super C10292> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxModelOfflineManager.this.isOfflineUserSaved((BoxFolder) null, (IUserContextManager) null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$setFileOfflineUserSaved$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager", f = "BoxModelOfflineManager.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {346, 348, 349, 351, 366}, m = "setFileOfflineUserSaved", n = {"boxFile", "userContextManager", "fileId", "storage", "userSaved", "$i$a$-let-BoxModelOfflineManager$setFileOfflineUserSaved$2", "boxFile", "userContextManager", "fileId", "storage", "userSaved", "$i$a$-let-BoxModelOfflineManager$setFileOfflineUserSaved$2", "boxFile", "userContextManager", "fileId", "storage", "userSaved", "$i$a$-let-BoxModelOfflineManager$setFileOfflineUserSaved$2", "boxFile", "userContextManager", "fileId", "storage", "userSaved", "$i$a$-let-BoxModelOfflineManager$setFileOfflineUserSaved$2", "boxFile", "userContextManager", "fileId", "$this$edit_u24default$iv", "editor$iv", "$this$setFileOfflineUserSaved_u24lambda_u241", "userSaved", "commit$iv", "$i$f$edit", "$i$a$-edit$default-BoxModelOfflineManager$setFileOfflineUserSaved$3"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "I$0", "I$1", "I$2"}, v = 1)
    static final class C10331 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C10331(Continuation<? super C10331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxModelOfflineManager.this.setFileOfflineUserSaved(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$setFolderOfflineSavedStarted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager", f = "BoxModelOfflineManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {545, 547, 548, 550, 567}, m = "setFolderOfflineSavedStarted", n = {"boxFolder", "userContextManager", "folderId", "storage", "savedForOffline", "startedDate", "$i$a$-let-BoxModelOfflineManager$setFolderOfflineSavedStarted$2", "boxFolder", "userContextManager", "folderId", "storage", "savedForOffline", "startedDate", "$i$a$-let-BoxModelOfflineManager$setFolderOfflineSavedStarted$2", "boxFolder", "userContextManager", "folderId", "storage", "savedForOffline", "startedDate", "$i$a$-let-BoxModelOfflineManager$setFolderOfflineSavedStarted$2", "boxFolder", "userContextManager", "folderId", "storage", "savedForOffline", "startedDate", "$i$a$-let-BoxModelOfflineManager$setFolderOfflineSavedStarted$2", "boxFolder", "userContextManager", "folderId", "$this$edit_u24default$iv", "editor$iv", "$this$setFolderOfflineSavedStarted_u24lambda_u241", "savedForOffline", "startedDate", "commit$iv", "$i$f$edit", "$i$a$-edit$default-BoxModelOfflineManager$setFolderOfflineSavedStarted$3"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "J$0", "I$0", "I$1", "I$2"}, v = 1)
    static final class C10361 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C10361(Continuation<? super C10361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxModelOfflineManager.this.setFolderOfflineSavedStarted(null, false, 0L, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$withStorageRead$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager", f = "BoxModelOfflineManager.kt", i = {0, 0, 0, 0, 0, 0}, l = {129}, m = "withStorageRead", n = {"itemId", "itemType", "userContextManager", "storageOp", "sharedPrefsOp", "prefsName"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class C10381<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C10381(Continuation<? super C10381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxModelOfflineManager.this.withStorageRead(null, null, null, null, null, this);
        }
    }

    private BoxModelOfflineManager() {
    }

    @JvmStatic
    public static final void setOfflineStorage(IOfflineStateStorage storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        offlineStorage = storage;
    }

    @JvmStatic
    public static final void resetOfflineStorage() {
        offlineStorage = null;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$blockingSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$blockingSuspend$1", f = "BoxModelOfflineManager.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super T>, Object> function1 = this.$block;
            this.label = 1;
            Object objInvoke = function1.invoke(this);
            return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
        }
    }

    private final <T> T blockingSuspend(Function1<? super Continuation<? super T>, ? extends Object> block) {
        return (T) BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(block, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <T> Object withStorageRead(String str, ItemType itemType, IUserContextManager iUserContextManager, Function4<? super IOfflineStateStorage, ? super String, ? super ItemType, ? super Continuation<? super T>, ? extends Object> function4, Function2<? super SharedPreferences, ? super String, ? extends T> function2, Continuation<? super T> continuation) {
        C10381 c10381;
        ILocalSharedPreferences.PreferenceName preferenceName;
        ILocalSharedPreferences.PreferenceName preferenceName2;
        if (continuation instanceof C10381) {
            c10381 = (C10381) continuation;
            if ((c10381.label & Integer.MIN_VALUE) != 0) {
                c10381.label -= Integer.MIN_VALUE;
            } else {
                c10381 = new C10381(continuation);
            }
        } else {
            c10381 = new C10381(continuation);
        }
        Object obj = c10381.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10381.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int i2 = WhenMappings.$EnumSwitchMapping$0[itemType.ordinal()];
            if (i2 == 1) {
                preferenceName = ILocalSharedPreferences.PreferenceName.offlinedFileSharedPreferences;
            } else if (i2 == 2) {
                preferenceName = ILocalSharedPreferences.PreferenceName.offlinedFolderSharedPreferences;
            } else {
                throw new IllegalStateException((itemType + " not recognized for offlining").toString());
            }
            IOfflineStateStorage iOfflineStateStorage = offlineStorage;
            if (iOfflineStateStorage != null) {
                c10381.L$0 = str;
                c10381.L$1 = SpillingKt.nullOutSpilledVariable(itemType);
                c10381.L$2 = iUserContextManager;
                c10381.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c10381.L$4 = function2;
                c10381.L$5 = preferenceName;
                c10381.label = 1;
                Object objInvoke = function4.invoke(iOfflineStateStorage, str, itemType, c10381);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                preferenceName2 = preferenceName;
                obj = objInvoke;
            }
            SharedPreferences userSharedPrefs = iUserContextManager.getUserSharedPrefs(preferenceName);
            Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
            return function2.invoke(userSharedPrefs, str);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ILocalSharedPreferences.PreferenceName preferenceName3 = (ILocalSharedPreferences.PreferenceName) c10381.L$5;
        Function2<? super SharedPreferences, ? super String, ? extends T> function3 = (Function2) c10381.L$4;
        iUserContextManager = (IUserContextManager) c10381.L$2;
        String str2 = (String) c10381.L$0;
        ResultKt.throwOnFailure(obj);
        function2 = function3;
        preferenceName2 = preferenceName3;
        str = str2;
        if (obj != null) {
            return obj;
        }
        preferenceName = preferenceName2;
        SharedPreferences userSharedPrefs2 = iUserContextManager.getUserSharedPrefs(preferenceName);
        Intrinsics.checkNotNullExpressionValue(userSharedPrefs2, "getUserSharedPrefs(...)");
        return function2.invoke(userSharedPrefs2, str);
    }

    @Deprecated(message = "Use BoxModelOfflineManagerWrapper#getState instead")
    @JvmStatic
    public static final State getState(ItemModel item, IUserContextManager userContextManager) {
        IBoxStorage previewStorage;
        long fileSavedCompletedDateBlocking;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        if (item.getItemId() instanceof ItemId.Local) {
            return State.NONE;
        }
        BoxModelOfflineManager boxModelOfflineManager = INSTANCE;
        if (boxModelOfflineManager.isSpecificallyUserSaved(item, userContextManager)) {
            boolean z = item instanceof FolderModel;
            if (z) {
                fileSavedCompletedDateBlocking = getFolderSavedCompletedDateBlocking(item.boxIdOrThrow(), userContextManager);
            } else {
                fileSavedCompletedDateBlocking = boxModelOfflineManager.getFileSavedCompletedDateBlocking(item.boxIdOrThrow(), userContextManager);
            }
            if (fileSavedCompletedDateBlocking == -1) {
                return State.OFFLINE_PENDING;
            }
            if (z) {
                Date modifiedDate = ((FolderModel) item).getModifiedDate();
                if ((modifiedDate != null ? modifiedDate.getTime() : Long.MAX_VALUE) > fileSavedCompletedDateBlocking) {
                    return State.OUT_OF_DATE;
                }
            }
            FileModel fileModel = ItemModelKt.fileModel(item);
            if (fileModel != null && !TextUtils.equals(fileModel.getSha1(), getFileSavedSha1Blocking(item.boxIdOrThrow(), userContextManager))) {
                return State.OUT_OF_DATE;
            }
            return State.OFFLINE;
        }
        FileModel fileModel2 = ItemModelKt.fileModel(item);
        if (fileModel2 != null && (previewStorage = userContextManager.getPreviewStorage()) != null && previewStorage.isFileCached(FileModelMapper.INSTANCE.toBoxFile(fileModel2, true), null)) {
            return State.CACHED;
        }
        return State.NONE;
    }

    public final Flow<State> getStateFlow(ItemId itemId, IUserContextManager userContextManager, IRemoteItemService remoteItemService) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(remoteItemService, "remoteItemService");
        if (itemId instanceof ItemId.Local) {
            return FlowKt.flowOf(State.NONE);
        }
        IOfflineStateStorage iOfflineStateStorage = offlineStorage;
        if (iOfflineStateStorage == null) {
            return FlowKt.emptyFlow();
        }
        ItemId.Remote remote = (ItemId.Remote) itemId;
        String boxId = remote.getBoxId();
        ItemType type = remote.getType();
        if (type != ItemType.FILE && type != ItemType.FOLDER) {
            return FlowKt.flowOf(State.NONE);
        }
        Flow<OfflineStateModel> flowObserveState = iOfflineStateStorage.observeState(boxId, type);
        final Flow<Result<ItemModel, DomainError>> flowObserveItem = remoteItemService.observeItem(itemId, DataPolicy.CACHE);
        return FlowKt.flowCombine(flowObserveState, new Flow<ItemModel>() { // from class: com.box.android.coreservices.models.BoxModelOfflineManager$getStateFlow$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super ItemModel> flowCollector, Continuation continuation) {
                Object objCollect = flowObserveItem.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$getStateFlow$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$getStateFlow$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$getStateFlow$$inlined$map$1$2", f = "BoxModelOfflineManager.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Object orNull = com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(orNull, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        }, new C10181(type, userContextManager, null));
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$getStateFlow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "Lcom/box/android/coreservices/models/BoxModelOfflineManager$State;", "offlineState", "Lcom/box/android/domain/offline/OfflineStateModel;", "fetchedItem", "Lcom/box/android/domain/models/item/ItemModel;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$getStateFlow$1", f = "BoxModelOfflineManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10181 extends SuspendLambda implements Function3<OfflineStateModel, ItemModel, Continuation<? super State>, Object> {
        final /* synthetic */ ItemType $itemType;
        final /* synthetic */ IUserContextManager $userContextManager;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10181(ItemType itemType, IUserContextManager iUserContextManager, Continuation<? super C10181> continuation) {
            super(3, continuation);
            this.$itemType = itemType;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(OfflineStateModel offlineStateModel, ItemModel itemModel, Continuation<? super State> continuation) {
            C10181 c10181 = new C10181(this.$itemType, this.$userContextManager, continuation);
            c10181.L$0 = offlineStateModel;
            c10181.L$1 = itemModel;
            return c10181.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            OfflineStateModel offlineStateModel = (OfflineStateModel) this.L$0;
            ItemModel itemModel = (ItemModel) this.L$1;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return BoxModelOfflineManager.INSTANCE.mapOfflineStateModelToState(offlineStateModel, itemModel, this.$itemType, this.$userContextManager);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State mapOfflineStateModelToState(OfflineStateModel offlineState, ItemModel item, ItemType itemType, IUserContextManager userContextManager) {
        FileModel fileModel;
        IBoxStorage previewStorage;
        Date modifiedDate;
        if (!offlineState.isUserSaved() || offlineState.isUserRemoved()) {
            if (item != null && (fileModel = ItemModelKt.fileModel(item)) != null && (previewStorage = userContextManager.getPreviewStorage()) != null && previewStorage.isFileCached(FileModelMapper.INSTANCE.toBoxFile(fileModel, true), null)) {
                return State.CACHED;
            }
            return State.NONE;
        }
        Long completedDate = offlineState.getCompletedDate();
        long jLongValue = completedDate != null ? completedDate.longValue() : -1L;
        if (jLongValue == -1) {
            return State.OFFLINE_PENDING;
        }
        if (item != null && itemType == ItemType.FOLDER) {
            FolderModel folderModel = item instanceof FolderModel ? (FolderModel) item : null;
            if (((folderModel == null || (modifiedDate = folderModel.getModifiedDate()) == null) ? Long.MAX_VALUE : modifiedDate.getTime()) > jLongValue) {
                return State.OUT_OF_DATE;
            }
        }
        if (item != null && itemType == ItemType.FILE && ItemModelKt.fileModel(item) != null) {
            FileModel fileModel2 = ItemModelKt.fileModel(item);
            if (!TextUtils.equals(fileModel2 != null ? fileModel2.getSha1() : null, offlineState.getSha1())) {
                return State.OUT_OF_DATE;
            }
        }
        return State.OFFLINE;
    }

    public final Object isFileSpecificallyUserSaved(String str, IUserContextManager iUserContextManager, Continuation<? super Boolean> continuation) {
        return withStorageRead(str, ItemType.FILE, iUserContextManager, new C10192(null), new Function2() { // from class: com.box.android.coreservices.models.BoxModelOfflineManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(BoxModelOfflineManager.isFileSpecificallyUserSaved$lambda$0((SharedPreferences) obj, (String) obj2));
            }
        }, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$isFileSpecificallyUserSaved$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lcom/box/android/domain/offline/IOfflineStateStorage;", "id", "", "type", "Lcom/box/android/domain/models/item/ItemType;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$isFileSpecificallyUserSaved$2", f = "BoxModelOfflineManager.kt", i = {0, 0, 0}, l = {268}, m = "invokeSuspend", n = {"$this$withStorageRead", "id", "type"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C10192 extends SuspendLambda implements Function4<IOfflineStateStorage, String, ItemType, Continuation<? super Boolean>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        C10192(Continuation<? super C10192> continuation) {
            super(4, continuation);
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(IOfflineStateStorage iOfflineStateStorage, String str, ItemType itemType, Continuation<? super Boolean> continuation) {
            C10192 c10192 = new C10192(continuation);
            c10192.L$0 = iOfflineStateStorage;
            c10192.L$1 = str;
            c10192.L$2 = itemType;
            return c10192.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IOfflineStateStorage iOfflineStateStorage = (IOfflineStateStorage) this.L$0;
            String str = (String) this.L$1;
            ItemType itemType = (ItemType) this.L$2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(iOfflineStateStorage);
            this.L$1 = SpillingKt.nullOutSpilledVariable(str);
            this.L$2 = SpillingKt.nullOutSpilledVariable(itemType);
            this.label = 1;
            Object objIsUserSaved = iOfflineStateStorage.isUserSaved(str, itemType, this);
            return objIsUserSaved == coroutine_suspended ? coroutine_suspended : objIsUserSaved;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isFileSpecificallyUserSaved$lambda$0(SharedPreferences withStorageRead, String id) {
        Intrinsics.checkNotNullParameter(withStorageRead, "$this$withStorageRead");
        Intrinsics.checkNotNullParameter(id, "id");
        return withStorageRead.getBoolean(INSTANCE.getIsOfflineUserSavedString(id), false);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$isFileSpecificallyUserSavedBlocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$isFileSpecificallyUserSavedBlocking$1", f = "BoxModelOfflineManager.kt", i = {}, l = {277}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10201 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $fileId;
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10201(String str, IUserContextManager iUserContextManager, Continuation<? super C10201> continuation) {
            super(1, continuation);
            this.$fileId = str;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10201(this.$fileId, this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Boolean> continuation) {
            return ((C10201) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objIsFileSpecificallyUserSaved = BoxModelOfflineManager.INSTANCE.isFileSpecificallyUserSaved(this.$fileId, this.$userContextManager, this);
            return objIsFileSpecificallyUserSaved == coroutine_suspended ? coroutine_suspended : objIsFileSpecificallyUserSaved;
        }
    }

    public final boolean isFileSpecificallyUserSavedBlocking(String fileId, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return ((Boolean) blockingSuspend(new C10201(fileId, userContextManager, null))).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0095  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ae A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00af  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isOfflineUserSaved(BoxFile boxFile, IUserContextManager iUserContextManager, Continuation<? super Boolean> continuation) {
        C10281 c10281;
        BoxFile boxFile2;
        IUserContextManager iUserContextManager2;
        Object objIsOfflineUserSaved;
        if (continuation instanceof C10281) {
            c10281 = (C10281) continuation;
            if ((c10281.label & Integer.MIN_VALUE) != 0) {
                c10281.label -= Integer.MIN_VALUE;
            } else {
                c10281 = new C10281(continuation);
            }
        } else {
            c10281 = new C10281(continuation);
        }
        Object objIsOfflineUserRemoved = c10281.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10281.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsOfflineUserRemoved);
            if (boxFile != null) {
                c10281.L$0 = boxFile;
                c10281.L$1 = iUserContextManager;
                c10281.label = 1;
                objIsOfflineUserRemoved = isOfflineUserRemoved(boxFile, iUserContextManager, c10281);
                if (objIsOfflineUserRemoved != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            return Boxing.boxBoolean(false);
        }
        if (i == 1) {
            iUserContextManager = (IUserContextManager) c10281.L$1;
            boxFile = (BoxFile) c10281.L$0;
            ResultKt.throwOnFailure(objIsOfflineUserRemoved);
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objIsOfflineUserRemoved);
                return objIsOfflineUserRemoved;
            }
            iUserContextManager2 = (IUserContextManager) c10281.L$1;
            boxFile2 = (BoxFile) c10281.L$0;
            ResultKt.throwOnFailure(objIsOfflineUserRemoved);
        }
        if (!((Boolean) objIsOfflineUserRemoved).booleanValue()) {
            BoxFolder parent = boxFile2.getParent();
            c10281.L$0 = SpillingKt.nullOutSpilledVariable(boxFile2);
            c10281.L$1 = SpillingKt.nullOutSpilledVariable(iUserContextManager2);
            c10281.label = 3;
            objIsOfflineUserSaved = isOfflineUserSaved(parent, iUserContextManager2, c10281);
            if (objIsOfflineUserSaved != coroutine_suspended) {
                return coroutine_suspended;
            }
            return objIsOfflineUserSaved;
        }
        return Boxing.boxBoolean(true);
        if (!((Boolean) objIsOfflineUserRemoved).booleanValue()) {
            String id = boxFile.getUserId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            c10281.L$0 = boxFile;
            c10281.L$1 = iUserContextManager;
            c10281.label = 2;
            objIsOfflineUserRemoved = isFileSpecificallyUserSaved(id, iUserContextManager, c10281);
            if (objIsOfflineUserRemoved != coroutine_suspended) {
                IUserContextManager iUserContextManager3 = iUserContextManager;
                boxFile2 = boxFile;
                iUserContextManager2 = iUserContextManager3;
                if (!((Boolean) objIsOfflineUserRemoved).booleanValue()) {
                    BoxFolder parent2 = boxFile2.getParent();
                    c10281.L$0 = SpillingKt.nullOutSpilledVariable(boxFile2);
                    c10281.L$1 = SpillingKt.nullOutSpilledVariable(iUserContextManager2);
                    c10281.label = 3;
                    objIsOfflineUserSaved = isOfflineUserSaved(parent2, iUserContextManager2, c10281);
                    if (objIsOfflineUserSaved != coroutine_suspended) {
                        return objIsOfflineUserSaved;
                    }
                } else {
                    return Boxing.boxBoolean(true);
                }
            }
            return coroutine_suspended;
        }
        return Boxing.boxBoolean(false);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserSavedBlocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserSavedBlocking$1", f = "BoxModelOfflineManager.kt", i = {}, l = {BoxCommonConstants.REQUEST_CHOOSE_LOCAL_UPLOAD_DIR}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10301 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ BoxFile $boxFile;
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10301(BoxFile boxFile, IUserContextManager iUserContextManager, Continuation<? super C10301> continuation) {
            super(1, continuation);
            this.$boxFile = boxFile;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10301(this.$boxFile, this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Boolean> continuation) {
            return ((C10301) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objIsOfflineUserSaved = BoxModelOfflineManager.INSTANCE.isOfflineUserSaved(this.$boxFile, this.$userContextManager, this);
            return objIsOfflineUserSaved == coroutine_suspended ? coroutine_suspended : objIsOfflineUserSaved;
        }
    }

    @JvmStatic
    public static final boolean isOfflineUserSavedBlocking(BoxFile boxFile, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return ((Boolean) INSTANCE.blockingSuspend(new C10301(boxFile, userContextManager, null))).booleanValue();
    }

    public final Object isOfflineUserRemoved(BoxFile boxFile, IUserContextManager iUserContextManager, Continuation<? super Boolean> continuation) {
        String id = boxFile.getUserId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        return withStorageRead(id, ItemType.FILE, iUserContextManager, new C10232(null), new Function2() { // from class: com.box.android.coreservices.models.BoxModelOfflineManager$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(BoxModelOfflineManager.isOfflineUserRemoved$lambda$0((SharedPreferences) obj, (String) obj2));
            }
        }, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserRemoved$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lcom/box/android/domain/offline/IOfflineStateStorage;", "id", "", "type", "Lcom/box/android/domain/models/item/ItemType;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserRemoved$2", f = "BoxModelOfflineManager.kt", i = {0, 0, 0}, l = {304}, m = "invokeSuspend", n = {"$this$withStorageRead", "id", "type"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C10232 extends SuspendLambda implements Function4<IOfflineStateStorage, String, ItemType, Continuation<? super Boolean>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        C10232(Continuation<? super C10232> continuation) {
            super(4, continuation);
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(IOfflineStateStorage iOfflineStateStorage, String str, ItemType itemType, Continuation<? super Boolean> continuation) {
            C10232 c10232 = new C10232(continuation);
            c10232.L$0 = iOfflineStateStorage;
            c10232.L$1 = str;
            c10232.L$2 = itemType;
            return c10232.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IOfflineStateStorage iOfflineStateStorage = (IOfflineStateStorage) this.L$0;
            String str = (String) this.L$1;
            ItemType itemType = (ItemType) this.L$2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(iOfflineStateStorage);
            this.L$1 = SpillingKt.nullOutSpilledVariable(str);
            this.L$2 = SpillingKt.nullOutSpilledVariable(itemType);
            this.label = 1;
            Object objIsUserRemoved = iOfflineStateStorage.isUserRemoved(str, itemType, this);
            return objIsUserRemoved == coroutine_suspended ? coroutine_suspended : objIsUserRemoved;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isOfflineUserRemoved$lambda$0(SharedPreferences withStorageRead, String id) {
        Intrinsics.checkNotNullParameter(withStorageRead, "$this$withStorageRead");
        Intrinsics.checkNotNullParameter(id, "id");
        return withStorageRead.getBoolean(id + "_isOfflineUserRemoved", false);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserRemovedBlocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserRemovedBlocking$1", f = "BoxModelOfflineManager.kt", i = {}, l = {313}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10241 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ BoxFile $boxFile;
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10241(BoxFile boxFile, IUserContextManager iUserContextManager, Continuation<? super C10241> continuation) {
            super(1, continuation);
            this.$boxFile = boxFile;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10241(this.$boxFile, this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Boolean> continuation) {
            return ((C10241) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objIsOfflineUserRemoved = BoxModelOfflineManager.INSTANCE.isOfflineUserRemoved(this.$boxFile, this.$userContextManager, this);
            return objIsOfflineUserRemoved == coroutine_suspended ? coroutine_suspended : objIsOfflineUserRemoved;
        }
    }

    @JvmStatic
    public static final boolean isOfflineUserRemovedBlocking(BoxFile boxFile, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(boxFile, "boxFile");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return ((Boolean) INSTANCE.blockingSuspend(new C10241(boxFile, userContextManager, null))).booleanValue();
    }

    public final Object getFileSavedCompletedDate(String str, IUserContextManager iUserContextManager, Continuation<? super Long> continuation) {
        return withStorageRead(str, ItemType.FILE, iUserContextManager, new AnonymousClass2(null), new Function2() { // from class: com.box.android.coreservices.models.BoxModelOfflineManager$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Long.valueOf(BoxModelOfflineManager.getFileSavedCompletedDate$lambda$0((SharedPreferences) obj, (String) obj2));
            }
        }, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$getFileSavedCompletedDate$2, reason: invalid class name */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lcom/box/android/domain/offline/IOfflineStateStorage;", "id", "", "type", "Lcom/box/android/domain/models/item/ItemType;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$getFileSavedCompletedDate$2", f = "BoxModelOfflineManager.kt", i = {0, 0, 0}, l = {BoxRequestsFile.DownloadThumbnail.SIZE_320}, m = "invokeSuspend", n = {"$this$withStorageRead", "id", "type"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function4<IOfflineStateStorage, String, ItemType, Continuation<? super Long>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(4, continuation);
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(IOfflineStateStorage iOfflineStateStorage, String str, ItemType itemType, Continuation<? super Long> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = iOfflineStateStorage;
            anonymousClass2.L$1 = str;
            anonymousClass2.L$2 = itemType;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IOfflineStateStorage iOfflineStateStorage = (IOfflineStateStorage) this.L$0;
            String str = (String) this.L$1;
            ItemType itemType = (ItemType) this.L$2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(iOfflineStateStorage);
            this.L$1 = SpillingKt.nullOutSpilledVariable(str);
            this.L$2 = SpillingKt.nullOutSpilledVariable(itemType);
            this.label = 1;
            Object completedDate = iOfflineStateStorage.getCompletedDate(str, itemType, this);
            return completedDate == coroutine_suspended ? coroutine_suspended : completedDate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getFileSavedCompletedDate$lambda$0(SharedPreferences withStorageRead, String id) {
        Intrinsics.checkNotNullParameter(withStorageRead, "$this$withStorageRead");
        Intrinsics.checkNotNullParameter(id, "id");
        return withStorageRead.getLong(id + "_offlineCompletedDate", -1L);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$getFileSavedCompletedDateBlocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$getFileSavedCompletedDateBlocking$1", f = "BoxModelOfflineManager.kt", i = {}, l = {326}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10131 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {
        final /* synthetic */ String $fileId;
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10131(String str, IUserContextManager iUserContextManager, Continuation<? super C10131> continuation) {
            super(1, continuation);
            this.$fileId = str;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10131(this.$fileId, this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Long> continuation) {
            return ((C10131) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object fileSavedCompletedDate = BoxModelOfflineManager.INSTANCE.getFileSavedCompletedDate(this.$fileId, this.$userContextManager, this);
            return fileSavedCompletedDate == coroutine_suspended ? coroutine_suspended : fileSavedCompletedDate;
        }
    }

    public final long getFileSavedCompletedDateBlocking(String fileId, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return ((Number) blockingSuspend(new C10131(fileId, userContextManager, null))).longValue();
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$getFileSavedSha1Blocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$getFileSavedSha1Blocking$1", f = "BoxModelOfflineManager.kt", i = {}, l = {331}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10151 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
        final /* synthetic */ String $fileId;
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10151(String str, IUserContextManager iUserContextManager, Continuation<? super C10151> continuation) {
            super(1, continuation);
            this.$fileId = str;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10151(this.$fileId, this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super String> continuation) {
            return ((C10151) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object fileSavedSha1 = BoxModelOfflineManager.INSTANCE.getFileSavedSha1(this.$fileId, this.$userContextManager, this);
            return fileSavedSha1 == coroutine_suspended ? coroutine_suspended : fileSavedSha1;
        }
    }

    @JvmStatic
    public static final String getFileSavedSha1Blocking(String fileId, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return (String) INSTANCE.blockingSuspend(new C10151(fileId, userContextManager, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFileSavedSha1(String str, IUserContextManager iUserContextManager, Continuation<? super String> continuation) {
        C10141 c10141;
        if (continuation instanceof C10141) {
            c10141 = (C10141) continuation;
            if ((c10141.label & Integer.MIN_VALUE) != 0) {
                c10141.label -= Integer.MIN_VALUE;
            } else {
                c10141 = new C10141(continuation);
            }
        } else {
            c10141 = new C10141(continuation);
        }
        Object fileSha1 = c10141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10141.label;
        if (i == 0) {
            ResultKt.throwOnFailure(fileSha1);
            IOfflineStateStorage iOfflineStateStorage = offlineStorage;
            if (iOfflineStateStorage != null) {
                c10141.L$0 = str;
                c10141.L$1 = iUserContextManager;
                c10141.label = 1;
                fileSha1 = iOfflineStateStorage.getFileSha1(str, c10141);
                if (fileSha1 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return iUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFileSharedPreferences).getString(str + "_offlineSha1", null);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        iUserContextManager = (IUserContextManager) c10141.L$1;
        str = (String) c10141.L$0;
        ResultKt.throwOnFailure(fileSha1);
        String str2 = (String) fileSha1;
        if (str2 != null) {
            return str2;
        }
        return iUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFileSharedPreferences).getString(str + "_offlineSha1", null);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0102  */
    /* JADX WARN: Code duplicated, block: B:35:0x012b  */
    /* JADX WARN: Code duplicated, block: B:49:0x020b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0222  */
    /* JADX WARN: Code duplicated, block: B:53:0x0226  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00cd, code lost:
    
        if (r1.setFileOfflineUserSaved(r11, true, r0) == r15) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0127, code lost:
    
        if (r1.setFileOfflineUserSaved(r5, false, r0) == r15) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0152, code lost:
    
        if (r1.removeOfflinedItem(r5, r11, r0) == r15) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object setFileOfflineUserSaved(com.box.androidsdk.content.models.BoxFile r12, boolean r13, com.box.android.domain.identity.IUserContextManager r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instruction units count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.coreservices.models.BoxModelOfflineManager.setFileOfflineUserSaved(com.box.androidsdk.content.models.BoxFile, boolean, com.box.android.domain.identity.IUserContextManager, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$setFileOfflineUserSavedBlocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$setFileOfflineUserSavedBlocking$1", f = "BoxModelOfflineManager.kt", i = {}, l = {378}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10341 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ BoxFile $boxFile;
        final /* synthetic */ IUserContextManager $userContextManager;
        final /* synthetic */ boolean $userSaved;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10341(BoxFile boxFile, boolean z, IUserContextManager iUserContextManager, Continuation<? super C10341> continuation) {
            super(1, continuation);
            this.$boxFile = boxFile;
            this.$userSaved = z;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10341(this.$boxFile, this.$userSaved, this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C10341) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BoxModelOfflineManager.INSTANCE.setFileOfflineUserSaved(this.$boxFile, this.$userSaved, this.$userContextManager, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final void setFileOfflineUserSavedBlocking(BoxFile boxFile, boolean userSaved, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(boxFile, "boxFile");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        INSTANCE.blockingSuspend(new C10341(boxFile, userSaved, userContextManager, null));
    }

    public final Object setFileOfflineSavedCompleted(BoxFile boxFile, boolean z, IUserContextManager iUserContextManager, Continuation<? super Unit> continuation) {
        String sha1;
        String id = boxFile.getUserId();
        IOfflineStateStorage iOfflineStateStorage = offlineStorage;
        if (iOfflineStateStorage != null) {
            String sha2 = (!z || (sha1 = boxFile.getSha1()) == null || sha1.length() == 0) ? null : boxFile.getSha1();
            Intrinsics.checkNotNull(id);
            Object fileOfflineSavedCompleted = iOfflineStateStorage.setFileOfflineSavedCompleted(id, sha2, continuation);
            return fileOfflineSavedCompleted == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? fileOfflineSavedCompleted : Unit.INSTANCE;
        }
        SharedPreferences userSharedPrefs = iUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFileSharedPreferences);
        Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
        SharedPreferences.Editor editorEdit = userSharedPrefs.edit();
        if (!z) {
            editorEdit.remove(id + "_offlineCompletedDate");
        } else {
            String sha3 = boxFile.getSha1();
            if (sha3 != null && sha3.length() != 0) {
                editorEdit.putString(id + "_offlineSha1", boxFile.getSha1());
            }
            editorEdit.putLong(id + "_offlineCompletedDate", System.currentTimeMillis());
        }
        editorEdit.commit();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$setFileOfflineSavedCompletedBlocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$setFileOfflineSavedCompletedBlocking$1", f = "BoxModelOfflineManager.kt", i = {}, l = {409}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10321 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ BoxFile $boxFile;
        final /* synthetic */ boolean $savedOffline;
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10321(BoxFile boxFile, boolean z, IUserContextManager iUserContextManager, Continuation<? super C10321> continuation) {
            super(1, continuation);
            this.$boxFile = boxFile;
            this.$savedOffline = z;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10321(this.$boxFile, this.$savedOffline, this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C10321) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BoxModelOfflineManager.INSTANCE.setFileOfflineSavedCompleted(this.$boxFile, this.$savedOffline, this.$userContextManager, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final void setFileOfflineSavedCompletedBlocking(BoxFile boxFile, boolean savedOffline, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(boxFile, "boxFile");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        INSTANCE.blockingSuspend(new C10321(boxFile, savedOffline, userContextManager, null));
    }

    public final Object isFolderSpecificallyUserSaved(String str, IUserContextManager iUserContextManager, Continuation<? super Boolean> continuation) {
        return withStorageRead(str, ItemType.FOLDER, iUserContextManager, new C10212(null), new Function2() { // from class: com.box.android.coreservices.models.BoxModelOfflineManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(BoxModelOfflineManager.isFolderSpecificallyUserSaved$lambda$0((SharedPreferences) obj, (String) obj2));
            }
        }, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$isFolderSpecificallyUserSaved$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lcom/box/android/domain/offline/IOfflineStateStorage;", "id", "", "type", "Lcom/box/android/domain/models/item/ItemType;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$isFolderSpecificallyUserSaved$2", f = "BoxModelOfflineManager.kt", i = {0, 0, 0}, l = {419}, m = "invokeSuspend", n = {"$this$withStorageRead", "id", "type"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C10212 extends SuspendLambda implements Function4<IOfflineStateStorage, String, ItemType, Continuation<? super Boolean>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        C10212(Continuation<? super C10212> continuation) {
            super(4, continuation);
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(IOfflineStateStorage iOfflineStateStorage, String str, ItemType itemType, Continuation<? super Boolean> continuation) {
            C10212 c10212 = new C10212(continuation);
            c10212.L$0 = iOfflineStateStorage;
            c10212.L$1 = str;
            c10212.L$2 = itemType;
            return c10212.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IOfflineStateStorage iOfflineStateStorage = (IOfflineStateStorage) this.L$0;
            String str = (String) this.L$1;
            ItemType itemType = (ItemType) this.L$2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(iOfflineStateStorage);
            this.L$1 = SpillingKt.nullOutSpilledVariable(str);
            this.L$2 = SpillingKt.nullOutSpilledVariable(itemType);
            this.label = 1;
            Object objIsUserSaved = iOfflineStateStorage.isUserSaved(str, itemType, this);
            return objIsUserSaved == coroutine_suspended ? coroutine_suspended : objIsUserSaved;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isFolderSpecificallyUserSaved$lambda$0(SharedPreferences withStorageRead, String id) {
        Intrinsics.checkNotNullParameter(withStorageRead, "$this$withStorageRead");
        Intrinsics.checkNotNullParameter(id, "id");
        return withStorageRead.getBoolean(INSTANCE.getIsOfflineUserSavedString(id), false);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$isFolderSpecificallyUserSavedBlocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$isFolderSpecificallyUserSavedBlocking$1", f = "BoxModelOfflineManager.kt", i = {}, l = {HttpStatus.SC_PRECONDITION_REQUIRED}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10221 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $folderId;
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10221(String str, IUserContextManager iUserContextManager, Continuation<? super C10221> continuation) {
            super(1, continuation);
            this.$folderId = str;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10221(this.$folderId, this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Boolean> continuation) {
            return ((C10221) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objIsFolderSpecificallyUserSaved = BoxModelOfflineManager.INSTANCE.isFolderSpecificallyUserSaved(this.$folderId, this.$userContextManager, this);
            return objIsFolderSpecificallyUserSaved == coroutine_suspended ? coroutine_suspended : objIsFolderSpecificallyUserSaved;
        }
    }

    public final boolean isFolderSpecificallyUserSavedBlocking(String folderId, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return ((Boolean) blockingSuspend(new C10221(folderId, userContextManager, null))).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0116  */
    /* JADX WARN: Code duplicated, block: B:43:0x0129  */
    /* JADX WARN: Code duplicated, block: B:46:0x015f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0170  */
    /* JADX WARN: Code duplicated, block: B:53:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:56:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:58:0x01be  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01a9 -> B:54:0x01b1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object isOfflineUserSaved(com.box.androidsdk.content.models.BoxFolder r19, com.box.android.domain.identity.IUserContextManager r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            Method dump skipped, instruction units count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.coreservices.models.BoxModelOfflineManager.isOfflineUserSaved(com.box.androidsdk.content.models.BoxFolder, com.box.android.domain.identity.IUserContextManager, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserSavedBlocking$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserSavedBlocking$2", f = "BoxModelOfflineManager.kt", i = {}, l = {466}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10312 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ BoxFolder $boxFolder;
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10312(BoxFolder boxFolder, IUserContextManager iUserContextManager, Continuation<? super C10312> continuation) {
            super(1, continuation);
            this.$boxFolder = boxFolder;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10312(this.$boxFolder, this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Boolean> continuation) {
            return ((C10312) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objIsOfflineUserSaved = BoxModelOfflineManager.INSTANCE.isOfflineUserSaved(this.$boxFolder, this.$userContextManager, this);
            return objIsOfflineUserSaved == coroutine_suspended ? coroutine_suspended : objIsOfflineUserSaved;
        }
    }

    public final boolean isOfflineUserSavedBlocking(BoxFolder boxFolder, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return ((Boolean) blockingSuspend(new C10312(boxFolder, userContextManager, null))).booleanValue();
    }

    public final Object isOfflineUserRemoved(BoxFolder boxFolder, IUserContextManager iUserContextManager, Continuation<? super Boolean> continuation) {
        String id = boxFolder.getUserId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        return withStorageRead(id, ItemType.FOLDER, iUserContextManager, new AnonymousClass5(null), new Function2() { // from class: com.box.android.coreservices.models.BoxModelOfflineManager$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(BoxModelOfflineManager.isOfflineUserRemoved$lambda$1((SharedPreferences) obj, (String) obj2));
            }
        }, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserRemoved$5, reason: invalid class name */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lcom/box/android/domain/offline/IOfflineStateStorage;", "id", "", "type", "Lcom/box/android/domain/models/item/ItemType;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserRemoved$5", f = "BoxModelOfflineManager.kt", i = {0, 0, 0}, l = {475}, m = "invokeSuspend", n = {"$this$withStorageRead", "id", "type"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function4<IOfflineStateStorage, String, ItemType, Continuation<? super Boolean>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(4, continuation);
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(IOfflineStateStorage iOfflineStateStorage, String str, ItemType itemType, Continuation<? super Boolean> continuation) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(continuation);
            anonymousClass5.L$0 = iOfflineStateStorage;
            anonymousClass5.L$1 = str;
            anonymousClass5.L$2 = itemType;
            return anonymousClass5.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IOfflineStateStorage iOfflineStateStorage = (IOfflineStateStorage) this.L$0;
            String str = (String) this.L$1;
            ItemType itemType = (ItemType) this.L$2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(iOfflineStateStorage);
            this.L$1 = SpillingKt.nullOutSpilledVariable(str);
            this.L$2 = SpillingKt.nullOutSpilledVariable(itemType);
            this.label = 1;
            Object objIsUserRemoved = iOfflineStateStorage.isUserRemoved(str, itemType, this);
            return objIsUserRemoved == coroutine_suspended ? coroutine_suspended : objIsUserRemoved;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isOfflineUserRemoved$lambda$1(SharedPreferences withStorageRead, String id) {
        Intrinsics.checkNotNullParameter(withStorageRead, "$this$withStorageRead");
        Intrinsics.checkNotNullParameter(id, "id");
        return withStorageRead.getBoolean(id + "_isOfflineUserRemoved", false);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserRemovedBlocking$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserRemovedBlocking$2", f = "BoxModelOfflineManager.kt", i = {}, l = {484}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10252 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ BoxFolder $boxFolder;
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10252(BoxFolder boxFolder, IUserContextManager iUserContextManager, Continuation<? super C10252> continuation) {
            super(1, continuation);
            this.$boxFolder = boxFolder;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10252(this.$boxFolder, this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Boolean> continuation) {
            return ((C10252) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objIsOfflineUserRemoved = BoxModelOfflineManager.INSTANCE.isOfflineUserRemoved(this.$boxFolder, this.$userContextManager, this);
            return objIsOfflineUserRemoved == coroutine_suspended ? coroutine_suspended : objIsOfflineUserRemoved;
        }
    }

    public final boolean isOfflineUserRemovedBlocking(BoxFolder boxFolder, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(boxFolder, "boxFolder");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return ((Boolean) blockingSuspend(new C10252(boxFolder, userContextManager, null))).booleanValue();
    }

    public final Object isOfflineUserRemovedFolder(String str, IUserContextManager iUserContextManager, Continuation<? super Boolean> continuation) {
        return withStorageRead(str, ItemType.FOLDER, iUserContextManager, new C10262(null), new Function2() { // from class: com.box.android.coreservices.models.BoxModelOfflineManager$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(BoxModelOfflineManager.isOfflineUserRemovedFolder$lambda$0((SharedPreferences) obj, (String) obj2));
            }
        }, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserRemovedFolder$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lcom/box/android/domain/offline/IOfflineStateStorage;", "id", "", "type", "Lcom/box/android/domain/models/item/ItemType;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserRemovedFolder$2", f = "BoxModelOfflineManager.kt", i = {0, 0, 0}, l = {493}, m = "invokeSuspend", n = {"$this$withStorageRead", "id", "type"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C10262 extends SuspendLambda implements Function4<IOfflineStateStorage, String, ItemType, Continuation<? super Boolean>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        C10262(Continuation<? super C10262> continuation) {
            super(4, continuation);
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(IOfflineStateStorage iOfflineStateStorage, String str, ItemType itemType, Continuation<? super Boolean> continuation) {
            C10262 c10262 = new C10262(continuation);
            c10262.L$0 = iOfflineStateStorage;
            c10262.L$1 = str;
            c10262.L$2 = itemType;
            return c10262.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IOfflineStateStorage iOfflineStateStorage = (IOfflineStateStorage) this.L$0;
            String str = (String) this.L$1;
            ItemType itemType = (ItemType) this.L$2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(iOfflineStateStorage);
            this.L$1 = SpillingKt.nullOutSpilledVariable(str);
            this.L$2 = SpillingKt.nullOutSpilledVariable(itemType);
            this.label = 1;
            Object objIsUserRemoved = iOfflineStateStorage.isUserRemoved(str, itemType, this);
            return objIsUserRemoved == coroutine_suspended ? coroutine_suspended : objIsUserRemoved;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isOfflineUserRemovedFolder$lambda$0(SharedPreferences withStorageRead, String id) {
        Intrinsics.checkNotNullParameter(withStorageRead, "$this$withStorageRead");
        Intrinsics.checkNotNullParameter(id, "id");
        return withStorageRead.getBoolean(id + "_isOfflineUserRemoved", false);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserRemovedFolderBlocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$isOfflineUserRemovedFolderBlocking$1", f = "BoxModelOfflineManager.kt", i = {}, l = {502}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10271 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $folderId;
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10271(String str, IUserContextManager iUserContextManager, Continuation<? super C10271> continuation) {
            super(1, continuation);
            this.$folderId = str;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10271(this.$folderId, this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Boolean> continuation) {
            return ((C10271) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objIsOfflineUserRemovedFolder = BoxModelOfflineManager.INSTANCE.isOfflineUserRemovedFolder(this.$folderId, this.$userContextManager, this);
            return objIsOfflineUserRemovedFolder == coroutine_suspended ? coroutine_suspended : objIsOfflineUserRemovedFolder;
        }
    }

    public final boolean isOfflineUserRemovedFolderBlocking(String folderId, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return ((Boolean) blockingSuspend(new C10271(folderId, userContextManager, null))).booleanValue();
    }

    @JvmStatic
    public static final boolean isSpecificallyUserSaved(BoxItem boxItem, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(boxItem, "boxItem");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        if (boxItem instanceof BoxFolder) {
            BoxModelOfflineManager boxModelOfflineManager = INSTANCE;
            String id = ((BoxFolder) boxItem).getUserId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            return boxModelOfflineManager.isFolderSpecificallyUserSavedBlocking(id, userContextManager);
        }
        if (!(boxItem instanceof BoxFile)) {
            return false;
        }
        BoxModelOfflineManager boxModelOfflineManager2 = INSTANCE;
        String id2 = ((BoxFile) boxItem).getUserId();
        Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
        return boxModelOfflineManager2.isFileSpecificallyUserSavedBlocking(id2, userContextManager);
    }

    public final boolean isSpecificallyUserSaved(ItemModel itemModel, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        if (itemModel instanceof FolderModel) {
            return isFolderSpecificallyUserSavedBlocking(itemModel.boxIdOrThrow(), userContextManager);
        }
        if (ItemModelKt.fileModel(itemModel) != null) {
            return isFileSpecificallyUserSavedBlocking(itemModel.boxIdOrThrow(), userContextManager);
        }
        return false;
    }

    public final long getFolderSavedStartedDate(String folderId, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFolderSharedPreferences).getLong(folderId + "_offlineStartedDate", -1L);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$getFolderSavedCompletedDateBlocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$getFolderSavedCompletedDateBlocking$1", f = "BoxModelOfflineManager.kt", i = {}, l = {524}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10171 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {
        final /* synthetic */ String $folderId;
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10171(String str, IUserContextManager iUserContextManager, Continuation<? super C10171> continuation) {
            super(1, continuation);
            this.$folderId = str;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10171(this.$folderId, this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Long> continuation) {
            return ((C10171) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object folderSavedCompletedDate = BoxModelOfflineManager.INSTANCE.getFolderSavedCompletedDate(this.$folderId, this.$userContextManager, this);
            return folderSavedCompletedDate == coroutine_suspended ? coroutine_suspended : folderSavedCompletedDate;
        }
    }

    @JvmStatic
    public static final long getFolderSavedCompletedDateBlocking(String folderId, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return ((Number) INSTANCE.blockingSuspend(new C10171(folderId, userContextManager, null))).longValue();
    }

    public final Object getFolderSavedCompletedDate(String str, IUserContextManager iUserContextManager, Continuation<? super Long> continuation) {
        return withStorageRead(str, ItemType.FOLDER, iUserContextManager, new C10162(null), new Function2() { // from class: com.box.android.coreservices.models.BoxModelOfflineManager$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Long.valueOf(BoxModelOfflineManager.getFolderSavedCompletedDate$lambda$0((SharedPreferences) obj, (String) obj2));
            }
        }, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$getFolderSavedCompletedDate$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lcom/box/android/domain/offline/IOfflineStateStorage;", "id", "", "type", "Lcom/box/android/domain/models/item/ItemType;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$getFolderSavedCompletedDate$2", f = "BoxModelOfflineManager.kt", i = {0, 0, 0}, l = {531}, m = "invokeSuspend", n = {"$this$withStorageRead", "id", "type"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C10162 extends SuspendLambda implements Function4<IOfflineStateStorage, String, ItemType, Continuation<? super Long>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        C10162(Continuation<? super C10162> continuation) {
            super(4, continuation);
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(IOfflineStateStorage iOfflineStateStorage, String str, ItemType itemType, Continuation<? super Long> continuation) {
            C10162 c10162 = new C10162(continuation);
            c10162.L$0 = iOfflineStateStorage;
            c10162.L$1 = str;
            c10162.L$2 = itemType;
            return c10162.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IOfflineStateStorage iOfflineStateStorage = (IOfflineStateStorage) this.L$0;
            String str = (String) this.L$1;
            ItemType itemType = (ItemType) this.L$2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(iOfflineStateStorage);
            this.L$1 = SpillingKt.nullOutSpilledVariable(str);
            this.L$2 = SpillingKt.nullOutSpilledVariable(itemType);
            this.label = 1;
            Object completedDate = iOfflineStateStorage.getCompletedDate(str, itemType, this);
            return completedDate == coroutine_suspended ? coroutine_suspended : completedDate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getFolderSavedCompletedDate$lambda$0(SharedPreferences withStorageRead, String id) {
        Intrinsics.checkNotNullParameter(withStorageRead, "$this$withStorageRead");
        Intrinsics.checkNotNullParameter(id, "id");
        return withStorageRead.getLong(id + "_offlineCompletedDate", -1L);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0113  */
    /* JADX WARN: Code duplicated, block: B:35:0x0149  */
    /* JADX WARN: Code duplicated, block: B:49:0x025a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0272  */
    /* JADX WARN: Code duplicated, block: B:53:0x0276  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00dc, code lost:
    
        if (r7.setFolderOfflineSavedStarted(r1, true, r3, r5) == r6) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0145, code lost:
    
        if (r7.setFolderOfflineSavedStarted(r8, false, r3, r5) == r6) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0173, code lost:
    
        if (r7.removeOfflinedItem(r1, r2, r5) == r6) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object setFolderOfflineSavedStarted(com.box.androidsdk.content.models.BoxFolder r17, boolean r18, long r19, com.box.android.domain.identity.IUserContextManager r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instruction units count: 636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.coreservices.models.BoxModelOfflineManager.setFolderOfflineSavedStarted(com.box.androidsdk.content.models.BoxFolder, boolean, long, com.box.android.domain.identity.IUserContextManager, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$setFolderOfflineSavedStartedBlocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$setFolderOfflineSavedStartedBlocking$1", f = "BoxModelOfflineManager.kt", i = {}, l = {583}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10371 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ BoxFolder $boxFolder;
        final /* synthetic */ boolean $savedForOffline;
        final /* synthetic */ long $startedDate;
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10371(BoxFolder boxFolder, boolean z, long j, IUserContextManager iUserContextManager, Continuation<? super C10371> continuation) {
            super(1, continuation);
            this.$boxFolder = boxFolder;
            this.$savedForOffline = z;
            this.$startedDate = j;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10371(this.$boxFolder, this.$savedForOffline, this.$startedDate, this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C10371) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BoxModelOfflineManager.INSTANCE.setFolderOfflineSavedStarted(this.$boxFolder, this.$savedForOffline, this.$startedDate, this.$userContextManager, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final void setFolderOfflineSavedStartedBlocking(BoxFolder boxFolder, boolean savedForOffline, long startedDate, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(boxFolder, "boxFolder");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        INSTANCE.blockingSuspend(new C10371(boxFolder, savedForOffline, startedDate, userContextManager, null));
    }

    public final Object setFolderOfflineSavedCompleted(BoxFolder boxFolder, boolean z, IUserContextManager iUserContextManager, Continuation<? super Boolean> continuation) {
        String id = boxFolder.getUserId();
        IOfflineStateStorage iOfflineStateStorage = offlineStorage;
        if (iOfflineStateStorage != null) {
            Intrinsics.checkNotNull(id);
            return iOfflineStateStorage.setFolderOfflineSavedCompleted(id, z, continuation);
        }
        Intrinsics.checkNotNull(id);
        long folderSavedStartedDate = getFolderSavedStartedDate(id, iUserContextManager);
        boolean z2 = true;
        if (!z) {
            SharedPreferences userSharedPrefs = iUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFolderSharedPreferences);
            Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
            SharedPreferences.Editor editorEdit = userSharedPrefs.edit();
            editorEdit.remove(id + "_offlineCompletedDate");
            editorEdit.commit();
        } else if (folderSavedStartedDate < 0) {
            z2 = false;
        } else {
            SharedPreferences userSharedPrefs2 = iUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFolderSharedPreferences);
            Intrinsics.checkNotNullExpressionValue(userSharedPrefs2, "getUserSharedPrefs(...)");
            SharedPreferences.Editor editorEdit2 = userSharedPrefs2.edit();
            editorEdit2.putLong(id + "_offlineCompletedDate", folderSavedStartedDate);
            editorEdit2.commit();
        }
        return Boxing.boxBoolean(z2);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$setFolderOfflineSavedCompletedBlocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$setFolderOfflineSavedCompletedBlocking$1", f = "BoxModelOfflineManager.kt", i = {}, l = {629}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10351 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ BoxFolder $boxFolder;
        final /* synthetic */ boolean $savedOffline;
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10351(BoxFolder boxFolder, boolean z, IUserContextManager iUserContextManager, Continuation<? super C10351> continuation) {
            super(1, continuation);
            this.$boxFolder = boxFolder;
            this.$savedOffline = z;
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10351(this.$boxFolder, this.$savedOffline, this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Boolean> continuation) {
            return ((C10351) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object folderOfflineSavedCompleted = BoxModelOfflineManager.INSTANCE.setFolderOfflineSavedCompleted(this.$boxFolder, this.$savedOffline, this.$userContextManager, this);
            return folderOfflineSavedCompleted == coroutine_suspended ? coroutine_suspended : folderOfflineSavedCompleted;
        }
    }

    @JvmStatic
    public static final boolean setFolderOfflineSavedCompletedBlocking(BoxFolder boxFolder, boolean savedOffline, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(boxFolder, "boxFolder");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return ((Boolean) INSTANCE.blockingSuspend(new C10351(boxFolder, savedOffline, userContextManager, null))).booleanValue();
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$clearOfflineInformation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$clearOfflineInformation$1", f = "BoxModelOfflineManager.kt", i = {0, 0}, l = {638}, m = "invokeSuspend", n = {"storage", "$i$a$-let-BoxModelOfflineManager$clearOfflineInformation$1$1"}, s = {"L$0", "I$0"}, v = 1)
    static final class C10081 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ IUserContextManager $userContextManager;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10081(IUserContextManager iUserContextManager, Continuation<? super C10081> continuation) {
            super(1, continuation);
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10081(this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C10081) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IOfflineStateStorage iOfflineStateStorage = BoxModelOfflineManager.offlineStorage;
                if (iOfflineStateStorage != null) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(iOfflineStateStorage);
                    this.I$0 = 0;
                    this.label = 1;
                    if (iOfflineStateStorage.clearOfflineInformation(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    SharedPreferences userSharedPrefs = this.$userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFileSharedPreferences);
                    Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
                    SharedPreferences.Editor editorEdit = userSharedPrefs.edit();
                    editorEdit.clear();
                    editorEdit.commit();
                    SharedPreferences userSharedPrefs2 = this.$userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFolderSharedPreferences);
                    Intrinsics.checkNotNullExpressionValue(userSharedPrefs2, "getUserSharedPrefs(...)");
                    SharedPreferences.Editor editorEdit2 = userSharedPrefs2.edit();
                    editorEdit2.clear();
                    editorEdit2.commit();
                    return Unit.INSTANCE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void clearOfflineInformation(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        blockingSuspend(new C10081(userContextManager, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchUserOfflinedFileIds(IUserContextManager iUserContextManager, Continuation<? super List<String>> continuation) {
        C10091 c10091;
        if (continuation instanceof C10091) {
            c10091 = (C10091) continuation;
            if ((c10091.label & Integer.MIN_VALUE) != 0) {
                c10091.label -= Integer.MIN_VALUE;
            } else {
                c10091 = new C10091(continuation);
            }
        } else {
            c10091 = new C10091(continuation);
        }
        Object objFetchUserOfflinedFileIds = c10091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10091.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchUserOfflinedFileIds);
            IOfflineStateStorage iOfflineStateStorage = offlineStorage;
            if (iOfflineStateStorage != null) {
                c10091.L$0 = iUserContextManager;
                c10091.label = 1;
                objFetchUserOfflinedFileIds = iOfflineStateStorage.fetchUserOfflinedFileIds(c10091);
                if (objFetchUserOfflinedFileIds == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            SharedPreferences userSharedPrefs = iUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFileSharedPreferences);
            Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
            return fetchOfflinedIds(userSharedPrefs);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        iUserContextManager = (IUserContextManager) c10091.L$0;
        ResultKt.throwOnFailure(objFetchUserOfflinedFileIds);
        List list = (List) objFetchUserOfflinedFileIds;
        if (list != null) {
            return list;
        }
        SharedPreferences userSharedPrefs2 = iUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFileSharedPreferences);
        Intrinsics.checkNotNullExpressionValue(userSharedPrefs2, "getUserSharedPrefs(...)");
        return fetchOfflinedIds(userSharedPrefs2);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$fetchUserOfflinedFileIdsBlocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$fetchUserOfflinedFileIdsBlocking$1", f = "BoxModelOfflineManager.kt", i = {}, l = {656}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10101 extends SuspendLambda implements Function1<Continuation<? super List<? extends String>>, Object> {
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10101(IUserContextManager iUserContextManager, Continuation<? super C10101> continuation) {
            super(1, continuation);
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10101(this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends String>> continuation) {
            return invoke2((Continuation<? super List<String>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super List<String>> continuation) {
            return ((C10101) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objFetchUserOfflinedFileIds = BoxModelOfflineManager.INSTANCE.fetchUserOfflinedFileIds(this.$userContextManager, this);
            return objFetchUserOfflinedFileIds == coroutine_suspended ? coroutine_suspended : objFetchUserOfflinedFileIds;
        }
    }

    @JvmStatic
    public static final List<String> fetchUserOfflinedFileIdsBlocking(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return (List) INSTANCE.blockingSuspend(new C10101(userContextManager, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchUserOfflinedFolderIds(IUserContextManager iUserContextManager, Continuation<? super List<String>> continuation) {
        C10111 c10111;
        if (continuation instanceof C10111) {
            c10111 = (C10111) continuation;
            if ((c10111.label & Integer.MIN_VALUE) != 0) {
                c10111.label -= Integer.MIN_VALUE;
            } else {
                c10111 = new C10111(continuation);
            }
        } else {
            c10111 = new C10111(continuation);
        }
        Object objFetchUserOfflinedFolderIds = c10111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10111.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchUserOfflinedFolderIds);
            IOfflineStateStorage iOfflineStateStorage = offlineStorage;
            if (iOfflineStateStorage != null) {
                c10111.L$0 = iUserContextManager;
                c10111.label = 1;
                objFetchUserOfflinedFolderIds = iOfflineStateStorage.fetchUserOfflinedFolderIds(c10111);
                if (objFetchUserOfflinedFolderIds == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            SharedPreferences userSharedPrefs = iUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFolderSharedPreferences);
            Intrinsics.checkNotNullExpressionValue(userSharedPrefs, "getUserSharedPrefs(...)");
            return fetchOfflinedIds(userSharedPrefs);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        iUserContextManager = (IUserContextManager) c10111.L$0;
        ResultKt.throwOnFailure(objFetchUserOfflinedFolderIds);
        List list = (List) objFetchUserOfflinedFolderIds;
        if (list != null) {
            return list;
        }
        SharedPreferences userSharedPrefs2 = iUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.offlinedFolderSharedPreferences);
        Intrinsics.checkNotNullExpressionValue(userSharedPrefs2, "getUserSharedPrefs(...)");
        return fetchOfflinedIds(userSharedPrefs2);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.models.BoxModelOfflineManager$fetchUserOfflinedFolderIdsBlocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.models.BoxModelOfflineManager$fetchUserOfflinedFolderIdsBlocking$1", f = "BoxModelOfflineManager.kt", i = {}, l = {667}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10121 extends SuspendLambda implements Function1<Continuation<? super List<? extends String>>, Object> {
        final /* synthetic */ IUserContextManager $userContextManager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10121(IUserContextManager iUserContextManager, Continuation<? super C10121> continuation) {
            super(1, continuation);
            this.$userContextManager = iUserContextManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C10121(this.$userContextManager, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends String>> continuation) {
            return invoke2((Continuation<? super List<String>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super List<String>> continuation) {
            return ((C10121) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objFetchUserOfflinedFolderIds = BoxModelOfflineManager.INSTANCE.fetchUserOfflinedFolderIds(this.$userContextManager, this);
            return objFetchUserOfflinedFolderIds == coroutine_suspended ? coroutine_suspended : objFetchUserOfflinedFolderIds;
        }
    }

    @JvmStatic
    public static final List<String> fetchUserOfflinedFolderIdsBlocking(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        return (List) INSTANCE.blockingSuspend(new C10121(userContextManager, null));
    }

    public final List<String> fetchOfflinedIds(SharedPreferences pref) {
        Intrinsics.checkNotNullParameter(pref, "pref");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = pref.getAll().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
            if (StringsKt.endsWith$default((String) key, SAVED_FOR_OFFLINE_POSTFIX, false, 2, (Object) null)) {
                Object value = entry.getValue();
                if ((value instanceof Boolean) && ((Boolean) value).booleanValue()) {
                    Object key2 = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue(key2, "<get-key>(...)");
                    String strSubstring = ((String) key2).substring(0, ((String) entry.getKey()).length() - 19);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    arrayList.add(strSubstring);
                }
            }
        }
        return arrayList;
    }

    public final IDownloadFiles getDownloadFiles(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        IUserContextComponent userContextComponent = userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_FILES);
        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.coreservices.localrepo.ILocalFiles");
        IDownloadFiles downloads = ((ILocalFiles) userContextComponent).getDownloads();
        Intrinsics.checkNotNullExpressionValue(downloads, "getDownloads(...)");
        return downloads;
    }

    public final IPreviewFiles getPreviewFiles(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        IUserContextComponent userContextComponent = userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_FILES);
        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.coreservices.localrepo.ILocalFiles");
        IPreviewFiles previews = ((ILocalFiles) userContextComponent).getPreviews();
        Intrinsics.checkNotNullExpressionValue(previews, "getPreviews(...)");
        return previews;
    }

    public final long getLegacyCacheSize(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        long dirSize = CommonBoxUtil.getDirSize(CommonBoxUtil.getInternalPreviewDirectory());
        File legacyThumbnailDir = LegacyCacheManager.getLegacyThumbnailDir();
        Intrinsics.checkNotNullExpressionValue(legacyThumbnailDir, "getLegacyThumbnailDir(...)");
        long dirSize2 = dirSize + CommonBoxUtil.getDirSize(legacyThumbnailDir);
        IDownloadFiles downloadFiles = getDownloadFiles(userContextManager);
        File encryptedCacheDir = downloadFiles.getEncryptedCacheDir();
        Intrinsics.checkNotNullExpressionValue(encryptedCacheDir, "getEncryptedCacheDir(...)");
        long dirSize3 = CommonBoxUtil.getDirSize(encryptedCacheDir);
        File decryptedWorkingDir = downloadFiles.getDecryptedWorkingDir();
        Intrinsics.checkNotNullExpressionValue(decryptedWorkingDir, "getDecryptedWorkingDir(...)");
        return dirSize2 + dirSize3 + CommonBoxUtil.getDirSize(decryptedWorkingDir);
    }

    public final long getLegacyDownloadSize(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        File encryptedOfflineDir = getDownloadFiles(userContextManager).getEncryptedOfflineDir();
        Intrinsics.checkNotNullExpressionValue(encryptedOfflineDir, "getEncryptedOfflineDir(...)");
        long dirSize = CommonBoxUtil.getDirSize(encryptedOfflineDir);
        File externalPreviewDirectory = getPreviewFiles(userContextManager).getExternalPreviewDirectory();
        Intrinsics.checkNotNullExpressionValue(externalPreviewDirectory, "getExternalPreviewDirectory(...)");
        return dirSize + CommonBoxUtil.getDirSize(externalPreviewDirectory);
    }

    @JvmStatic
    public static final long getTotalCacheSize(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        BoxModelOfflineManager boxModelOfflineManager = INSTANCE;
        long legacyCacheSize = boxModelOfflineManager.getLegacyCacheSize(userContextManager) + boxModelOfflineManager.getLegacyDownloadSize(userContextManager);
        IBoxStorage previewStorage = userContextManager.getPreviewStorage();
        return legacyCacheSize + (previewStorage != null ? previewStorage.getStorageSize() : 0L);
    }

    @JvmStatic
    public static final FutureTask<Boolean> removeAllOfflineFileFolders(final IUserContextManager userContextManager, final IKeyValueStore kv, final JobManager jobManager, final IJobService jobService) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(kv, "kv");
        Intrinsics.checkNotNullParameter(jobManager, "jobManager");
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        FutureTask<Boolean> futureTask = new FutureTask<>(new Callable() { // from class: com.box.android.coreservices.models.BoxModelOfflineManager$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BoxModelOfflineManager.removeAllOfflineFileFolders$lambda$0(jobManager, userContextManager, kv, jobService);
            }
        });
        futureTask.run();
        return futureTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean removeAllOfflineFileFolders$lambda$0(JobManager jobManager, IUserContextManager iUserContextManager, IKeyValueStore iKeyValueStore, IJobService iJobService) throws InterruptedException {
        List<BoxJobCollection> allJobCollections = jobManager.getAllJobCollections();
        Intrinsics.checkNotNullExpressionValue(allJobCollections, "getAllJobCollections(...)");
        for (BoxJobCollection boxJobCollection : allJobCollections) {
            if (boxJobCollection instanceof OfflineBoxJobCollection) {
                ((OfflineBoxJobCollection) boxJobCollection).cancel();
            }
        }
        BuildersKt__BuildersKt.runBlocking$default(null, new BoxModelOfflineManager$removeAllOfflineFileFolders$task$1$2(iJobService, null), 1, null);
        IUserContextComponent userContextComponent = iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_FILES);
        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.coreservices.localrepo.ILocalFiles");
        IDownloadFiles downloads = ((ILocalFiles) userContextComponent).getDownloads();
        downloads.deleteAllEncryptedOfflineFiles();
        downloads.clearEncryptionSalts(iUserContextManager);
        BoxModelOfflineManager boxModelOfflineManager = INSTANCE;
        boxModelOfflineManager.clearOfflineInformation(iUserContextManager);
        LegacyCacheManager.deleteAllPreviewInfo(iUserContextManager);
        boxModelOfflineManager.getDownloadFiles(iUserContextManager).deleteAllDecryptedWorkingFiles();
        boxModelOfflineManager.getDownloadFiles(iUserContextManager).deleteAllEncryptedCachedFiles();
        LegacyCacheManager.deleteLegacyThumbnailDir();
        iUserContextManager.getPreviewStorage().clearPreviewCache();
        BoxSaveAllOfflineMessage boxSaveAllOfflineMessage = new BoxSaveAllOfflineMessage(iKeyValueStore);
        boxSaveAllOfflineMessage.setSuccess(true);
        boxModelOfflineManager.broadcastIntent(boxSaveAllOfflineMessage);
        return true;
    }

    @JvmStatic
    public static final boolean userHasOfflineFiles(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        IUserContextComponent userContextComponent = userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_FILES);
        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.coreservices.localrepo.ILocalFiles");
        return ((ILocalFiles) userContextComponent).getDownloads().userHasOfflineFiles();
    }

    public final void broadcastIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            CommonBoxUtil.dumpIntent(intent, Controller.class.getName());
        }
        LocalBroadcastManager.getInstance(ApplicationProvider.getApplication()).sendBroadcast(intent);
    }

    public final String getIsOfflineUserSavedString(String itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        return itemId + SAVED_FOR_OFFLINE_POSTFIX;
    }

    /* JADX INFO: compiled from: BoxModelOfflineManager.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/box/android/coreservices/models/BoxModelOfflineManager$Manager;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "offlinedIds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "notOfflinedIds", "addItem", "", "boxItem", "Lcom/box/androidsdk/content/models/BoxItem;", "removeItem", DiagnosisParams.CLEAR_ON_LOGOUT, "numberOfflined", "", "getNumberOfflined", "()I", "numberNotOfflined", "getNumberNotOfflined", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Manager {
        private final HashSet<String> notOfflinedIds;
        private final HashSet<String> offlinedIds;
        private final IUserContextManager userContextManager;

        @Inject
        public Manager(IUserContextManager userContextManager) {
            Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
            this.userContextManager = userContextManager;
            this.offlinedIds = new HashSet<>();
            this.notOfflinedIds = new HashSet<>();
        }

        public final void addItem(BoxItem boxItem) {
            Intrinsics.checkNotNullParameter(boxItem, "boxItem");
            if (BoxModelOfflineManager.isSpecificallyUserSaved(boxItem, this.userContextManager)) {
                this.offlinedIds.add(boxItem.getUserId());
            } else if ((boxItem instanceof BoxFile) || (boxItem instanceof BoxFolder)) {
                this.notOfflinedIds.add(((BoxCollaborationItem) boxItem).getUserId());
            }
        }

        public final void removeItem(BoxItem boxItem) {
            Intrinsics.checkNotNullParameter(boxItem, "boxItem");
            this.offlinedIds.remove(boxItem.getUserId());
            this.notOfflinedIds.remove(boxItem.getUserId());
        }

        public final void clear() {
            this.notOfflinedIds.clear();
            this.offlinedIds.clear();
        }

        public final int getNumberOfflined() {
            return this.offlinedIds.size();
        }

        public final int getNumberNotOfflined() {
            return this.notOfflinedIds.size();
        }
    }
}
