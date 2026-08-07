package com.box.android.data.datasource;

import androidx.media3.extractor.ts.TsExtractor;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.api.models.CreateFolderDTO;
import com.box.android.data.api.models.items.FolderDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.api.models.items.ItemDTOFields;
import com.box.android.data.api.models.items.ItemsDTO;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.data.api.requests.CreateFolderRequest;
import com.box.android.data.api.requests.FolderItemsRequest;
import com.box.android.data.api.requests.ItemInfoRequest;
import com.box.android.data.api.requests.UpdateItemRequest;
import com.box.android.data.datasource.errors.FileUploadRemoteError;
import com.box.android.data.datasource.errors.ItemsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.errors.UploadErrorUtil;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.box.android.domain.metrics.Gen204FolderItemsEventLogger;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.Moshi;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
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
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: ItemRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 <2\u00020\u0001:\u0002<=BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J*\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ&\u0010\u001d\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0004\u0012\u00020\u00170\u00150\u001e2\u0006\u0010!\u001a\u00020\u0019JB\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010!\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020'H\u0082@¢\u0006\u0002\u0010*J2\u0010+\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010!\u001a\u00020\u00192\u0006\u0010,\u001a\u00020'2\u0006\u0010(\u001a\u00020%H\u0082@¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020/2\u0006\u0010&\u001a\u00020'H\u0002J6\u00100\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00170\u00152\u0006\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u00192\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0019H\u0086@¢\u0006\u0002\u00104J6\u00105\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00170\u00152\u0006\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u00192\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0019H\u0086@¢\u0006\u0002\u00104J\"\u00106\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00170\u00152\u0006\u00107\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u00108J,\u00109\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00170\u00152\u0006\u00107\u001a\u00020\u001b2\b\b\u0002\u0010:\u001a\u00020/H\u0086@¢\u0006\u0002\u0010;R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/box/android/data/datasource/ItemRemoteDataSource;", "", "createFolderRequest", "Lcom/box/android/data/api/requests/CreateFolderRequest;", "folderItemsRequest", "Lcom/box/android/data/api/requests/FolderItemsRequest;", "updateItemRequest", "Lcom/box/android/data/api/requests/UpdateItemRequest;", "getItemRequest", "Lcom/box/android/data/api/requests/ItemInfoRequest;", "localSortPreferences", "Lcom/box/android/domain/localrepo/LocalSortPreferences;", "moshi", "Lcom/squareup/moshi/Moshi;", "gen204FolderItemsEventLogger", "Lcom/box/android/domain/metrics/Gen204FolderItemsEventLogger;", "<init>", "(Lcom/box/android/data/api/requests/CreateFolderRequest;Lcom/box/android/data/api/requests/FolderItemsRequest;Lcom/box/android/data/api/requests/UpdateItemRequest;Lcom/box/android/data/api/requests/ItemInfoRequest;Lcom/box/android/domain/localrepo/LocalSortPreferences;Lcom/squareup/moshi/Moshi;Lcom/box/android/domain/metrics/Gen204FolderItemsEventLogger;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "createFolder", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/items/FolderDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", BoxCommonConstants.EXTRA_FOLDER_NAME, "", "parentFolderId", "Lcom/box/android/domain/models/ItemId$Remote;", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFolderItemsFromRemote", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "folderId", "asyncFetchFolderItemsPagesFromRemote", "Lcom/box/android/data/datasource/ItemRemoteDataSource$PageResult;", "numberOfPagesToLoad", "", "offset", "", BoxIterator.FIELD_LIMIT, "maxLimit", "(Ljava/lang/String;IJIJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchFolderItemsPageFromRemote", "pageOffset", "(Ljava/lang/String;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFirstPages", "", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "remoteId", IdentificationData.FIELD_PARENT_ID, "newItemName", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_MOVE_JOB, "getItem", "itemId", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFolderMini", "withParent", "(Lcom/box/android/domain/models/ItemId$Remote;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "PageResult", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemRemoteDataSource {
    private static final int ASYNC_PAGE_LOADING_NUMBER = 4;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int FIRST_AND_SECOND_PAGE_LIMIT_FOR_ITEMS = 25;
    private static final String GET_FOLDER_ITEMS_DEFAULT_FIELDS;
    private static final String LOGTAG = "ItemRemoteDataSource";
    private static final int SUBSEQUENT_PAGE_LIMIT_FOR_ITEMS = 90;
    private static final int SYNC_PAGE_LOADING = 1;
    private static final List<String> getFolderItemDefaultFields;
    private final CreateFolderRequest createFolderRequest;
    private final FolderItemsRequest folderItemsRequest;
    private final Gen204FolderItemsEventLogger gen204FolderItemsEventLogger;
    private final ItemInfoRequest getItemRequest;
    private final LocalSortPreferences localSortPreferences;
    private final Moshi moshi;
    private final UpdateItemRequest updateItemRequest;

    /* JADX INFO: compiled from: ItemRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemType.values().length];
            try {
                iArr[ItemType.FOLDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemType.FILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemType.WEBLINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.ItemRemoteDataSource$asyncFetchFolderItemsPagesFromRemote$1, reason: invalid class name */
    /* JADX INFO: compiled from: ItemRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.ItemRemoteDataSource", f = "ItemRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {Token.CONST}, m = "asyncFetchFolderItemsPagesFromRemote", n = {"folderId", "pageResults", "numberOfPagesToLoad", "offset", BoxIterator.FIELD_LIMIT, "maxLimit"}, s = {"L$0", "L$1", "I$0", "J$0", "I$1", "J$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemRemoteDataSource.this.asyncFetchFolderItemsPagesFromRemote(null, 0, 0L, 0, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.ItemRemoteDataSource$copy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.ItemRemoteDataSource", f = "ItemRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {249, 255, 261}, m = BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, n = {"remoteId", IdentificationData.FIELD_PARENT_ID, "newItemName", "itemId", "updateItemDTO", "$i$f$resultOf", "$i$a$-resultOf-ItemRemoteDataSource$copy$2", "remoteId", IdentificationData.FIELD_PARENT_ID, "newItemName", "itemId", "updateItemDTO", "$i$f$resultOf", "$i$a$-resultOf-ItemRemoteDataSource$copy$2", "remoteId", IdentificationData.FIELD_PARENT_ID, "newItemName", "itemId", "updateItemDTO", "$i$f$resultOf", "$i$a$-resultOf-ItemRemoteDataSource$copy$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class C10881 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C10881(Continuation<? super C10881> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemRemoteDataSource.this.copy(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.ItemRemoteDataSource$createFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.ItemRemoteDataSource", f = "ItemRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {99}, m = "createFolder", n = {BoxCommonConstants.EXTRA_FOLDER_NAME, "parentFolderId", "$i$f$resultOf", "$i$a$-resultOf-ItemRemoteDataSource$createFolder$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C10891 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10891(Continuation<? super C10891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemRemoteDataSource.this.createFolder(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.ItemRemoteDataSource$fetchFolderItemsPageFromRemote$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.ItemRemoteDataSource", f = "ItemRemoteDataSource.kt", i = {0, 0, 0, 0, 0}, l = {TsExtractor.TS_PACKET_SIZE}, m = "fetchFolderItemsPageFromRemote", n = {"folderId", "pageOffset", BoxIterator.FIELD_LIMIT, "$i$f$resultOf", "$i$a$-resultOf-ItemRemoteDataSource$fetchFolderItemsPageFromRemote$2"}, s = {"L$0", "J$0", "I$0", "I$1", "I$2"}, v = 1)
    static final class C10901 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10901(Continuation<? super C10901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemRemoteDataSource.this.fetchFolderItemsPageFromRemote(null, 0L, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.ItemRemoteDataSource$getFolderMini$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.ItemRemoteDataSource", f = "ItemRemoteDataSource.kt", i = {0, 0, 0, 0, 0}, l = {357}, m = "getFolderMini", n = {"itemId", "fields", "withParent", "$i$f$resultOf", "$i$a$-resultOf-ItemRemoteDataSource$getFolderMini$2"}, s = {"L$0", "L$1", "Z$0", "I$0", "I$1"}, v = 1)
    static final class C10921 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C10921(Continuation<? super C10921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemRemoteDataSource.this.getFolderMini(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.ItemRemoteDataSource$getItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.ItemRemoteDataSource", f = "ItemRemoteDataSource.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {331, 336, 341}, m = "getItem", n = {"itemId", "$i$f$resultOf", "$i$a$-resultOf-ItemRemoteDataSource$getItem$2", "itemId", "$i$f$resultOf", "$i$a$-resultOf-ItemRemoteDataSource$getItem$2", "itemId", "$i$f$resultOf", "$i$a$-resultOf-ItemRemoteDataSource$getItem$2"}, s = {"L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1"}, v = 1)
    static final class C10931 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10931(Continuation<? super C10931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemRemoteDataSource.this.getItem(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.ItemRemoteDataSource$move$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.ItemRemoteDataSource", f = "ItemRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {BoxCommonConstants.REQUEST_RETRY_SHARED_LINK, 304, 310}, m = BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_MOVE_JOB, n = {"remoteId", IdentificationData.FIELD_PARENT_ID, "newItemName", "itemId", "updateItemDTO", "$i$f$resultOf", "$i$a$-resultOf-ItemRemoteDataSource$move$2", "remoteId", IdentificationData.FIELD_PARENT_ID, "newItemName", "itemId", "updateItemDTO", "$i$f$resultOf", "$i$a$-resultOf-ItemRemoteDataSource$move$2", "remoteId", IdentificationData.FIELD_PARENT_ID, "newItemName", "itemId", "updateItemDTO", "$i$f$resultOf", "$i$a$-resultOf-ItemRemoteDataSource$move$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class C10941 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C10941(Continuation<? super C10941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemRemoteDataSource.this.move(null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFirstPages(long offset) {
        return offset < 50;
    }

    @Inject
    public ItemRemoteDataSource(CreateFolderRequest createFolderRequest, FolderItemsRequest folderItemsRequest, UpdateItemRequest updateItemRequest, ItemInfoRequest getItemRequest, LocalSortPreferences localSortPreferences, Moshi moshi, Gen204FolderItemsEventLogger gen204FolderItemsEventLogger) {
        Intrinsics.checkNotNullParameter(createFolderRequest, "createFolderRequest");
        Intrinsics.checkNotNullParameter(folderItemsRequest, "folderItemsRequest");
        Intrinsics.checkNotNullParameter(updateItemRequest, "updateItemRequest");
        Intrinsics.checkNotNullParameter(getItemRequest, "getItemRequest");
        Intrinsics.checkNotNullParameter(localSortPreferences, "localSortPreferences");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(gen204FolderItemsEventLogger, "gen204FolderItemsEventLogger");
        this.createFolderRequest = createFolderRequest;
        this.folderItemsRequest = folderItemsRequest;
        this.updateItemRequest = updateItemRequest;
        this.getItemRequest = getItemRequest;
        this.localSortPreferences = localSortPreferences;
        this.moshi = moshi;
        this.gen204FolderItemsEventLogger = gen204FolderItemsEventLogger;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    /* JADX INFO: compiled from: ItemRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0012J\n\u0010\u0013\u001a\u00020\u0011*\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/datasource/ItemRemoteDataSource$Companion;", "", "<init>", "()V", "LOGTAG", "", "FIRST_AND_SECOND_PAGE_LIMIT_FOR_ITEMS", "", "SUBSEQUENT_PAGE_LIMIT_FOR_ITEMS", "SYNC_PAGE_LOADING", "ASYNC_PAGE_LOADING_NUMBER", "getFolderItemDefaultFields", "", "GET_FOLDER_ITEMS_DEFAULT_FIELDS", "getGET_FOLDER_ITEMS_DEFAULT_FIELDS", "()Ljava/lang/String;", "isKnownCopyMoveError", "", "Lcom/box/android/data/datasource/errors/RemoteError;", "isKnownGetFolderItemsError", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getGET_FOLDER_ITEMS_DEFAULT_FIELDS() {
            return ItemRemoteDataSource.GET_FOLDER_ITEMS_DEFAULT_FIELDS;
        }

        public final boolean isKnownCopyMoveError(RemoteError remoteError) {
            Intrinsics.checkNotNullParameter(remoteError, "<this>");
            return (remoteError instanceof ItemsRemoteError) || (remoteError instanceof FileUploadRemoteError.SourceOrDestNotFound) || (remoteError instanceof FileUploadRemoteError.AccountSpaceError) || (remoteError instanceof RemoteError.NotFound) || (remoteError instanceof RemoteError.BadRequest) || (remoteError instanceof FileUploadRemoteError.AccessDeniedError);
        }

        public final boolean isKnownGetFolderItemsError(RemoteError remoteError) {
            Intrinsics.checkNotNullParameter(remoteError, "<this>");
            return (remoteError instanceof ItemsRemoteError) || (remoteError instanceof RemoteError.NotFound) || (remoteError instanceof RemoteError.Unauthorized);
        }
    }

    static {
        List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{"parent", BoxItem.FIELD_PATH_COLLECTION, "name", "size", "modified_at", "url", "shared_link", "sha1", BoxFile.FIELD_WATERMARK, BoxItem.FIELD_OWNED_BY, "comment_count", "annotation_count", "content_created_at", "content_modified_at", "modified_by", "permissions", BoxItem.FIELD_COLLECTIONS, BoxCollaborationItem.FIELD_HAS_COLLABORATIONS, BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED, "file_version", BoxFile.FIELD_LOCK, BoxFolder.FIELD_ITEM_COLLECTION});
        getFolderItemDefaultFields = listListOf;
        GET_FOLDER_ITEMS_DEFAULT_FIELDS = CollectionsKt.joinToString$default(listListOf, ",", null, null, 0, null, null, 62, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createFolder(String str, ItemId.Remote remote, Continuation<? super Result<FolderDTO, ? extends RemoteError>> continuation) {
        C10891 c10891;
        Result.Error error;
        if (continuation instanceof C10891) {
            c10891 = (C10891) continuation;
            if ((c10891.label & Integer.MIN_VALUE) != 0) {
                c10891.label -= Integer.MIN_VALUE;
            } else {
                c10891 = new C10891(continuation);
            }
        } else {
            c10891 = new C10891(continuation);
        }
        Object objCreateFolder = c10891.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10891.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreateFolder);
                CreateFolderRequest createFolderRequest = this.createFolderRequest;
                CreateFolderDTO createFolderDTO = new CreateFolderDTO(str, new FolderMiniDTO(remote.getBoxId(), "folder", null, null, 12, null));
                String default_item_fields = ItemDTOFields.INSTANCE.getDEFAULT_ITEM_FIELDS();
                c10891.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c10891.L$1 = SpillingKt.nullOutSpilledVariable(remote);
                c10891.I$0 = 0;
                c10891.I$1 = 0;
                c10891.label = 1;
                objCreateFolder = createFolderRequest.createFolder(createFolderDTO, default_item_fields, c10891);
                if (objCreateFolder == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c10891.I$1;
                int i3 = c10891.I$0;
                ResultKt.throwOnFailure(objCreateFolder);
            }
            error = new Result.Success((FolderDTO) objCreateFolder);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception attempting to create a folder", exc);
            return new Result.Error(UploadErrorUtil.INSTANCE.getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.ItemRemoteDataSource$getFolderItemsFromRemote$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.ItemRemoteDataSource$getFolderItemsFromRemote$1", f = "ItemRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {128, 138, Token.SETELEM_OP}, m = "invokeSuspend", n = {"$this$flow", "offset", "maxLimit", BoxIterator.FIELD_LIMIT, "numberOfPagesToLoad", "$this$flow", "offset", "maxLimit", "$this$onSuccess$iv", "it", BoxIterator.FIELD_LIMIT, "numberOfPagesToLoad", "$i$f$onSuccess", "$i$a$-onSuccess-ItemRemoteDataSource$getFolderItemsFromRemote$1$1", "$this$flow", "offset", "maxLimit", "$this$onError$iv", "it", BoxIterator.FIELD_LIMIT, "numberOfPagesToLoad", "$i$f$onError", "$i$a$-onError-ItemRemoteDataSource$getFolderItemsFromRemote$1$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C10911 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $folderId;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10911(String str, Continuation<? super C10911> continuation) {
            super(2, continuation);
            this.$folderId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10911 c10911 = ItemRemoteDataSource.this.new C10911(this.$folderId, continuation);
            c10911.L$0 = obj;
            return c10911;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C10911) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x007e  */
        /* JADX WARN: Code duplicated, block: B:16:0x0081  */
        /* JADX WARN: Code duplicated, block: B:19:0x008e  */
        /* JADX WARN: Code duplicated, block: B:20:0x0090  */
        /* JADX WARN: Code duplicated, block: B:24:0x00b9  */
        /* JADX WARN: Code duplicated, block: B:27:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:31:0x010b  */
        /* JADX WARN: Code duplicated, block: B:36:0x0115  */
        /* JADX WARN: Code duplicated, block: B:38:0x0119  */
        /* JADX WARN: Code duplicated, block: B:43:0x015a  */
        /* JADX WARN: Code duplicated, block: B:45:0x0160  */
        /* JADX WARN: Code duplicated, block: B:47:0x0169  */
        /* JADX WARN: Code duplicated, block: B:53:0x017b  */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0154, code lost:
        
            if (r1.emit(r6, r19) == r2) goto L40;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0101 -> B:30:0x0104). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x010e -> B:30:0x0104). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                Method dump skipped, instruction units count: 385
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.ItemRemoteDataSource.C10911.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Flow<Result<List<IItemDTO>, RemoteError>> getFolderItemsFromRemote(String folderId) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        return FlowKt.flow(new C10911(folderId, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object asyncFetchFolderItemsPagesFromRemote(String str, int i, long j, int i2, long j2, Continuation<? super Result<PageResult, ? extends RemoteError>> continuation) {
        AnonymousClass1 anonymousClass1;
        List<Result> list;
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
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(i, j, i2, j2, arrayList, this, str, null);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$1 = arrayList;
            anonymousClass1.I$0 = i;
            anonymousClass1.J$0 = j;
            anonymousClass1.I$1 = i2;
            anonymousClass1.J$1 = j2;
            anonymousClass1.label = 1;
            if (CoroutineScopeKt.coroutineScope(anonymousClass2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = arrayList;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j3 = anonymousClass1.J$1;
            int i4 = anonymousClass1.I$1;
            long j4 = anonymousClass1.J$0;
            int i5 = anonymousClass1.I$0;
            list = (List) anonymousClass1.L$1;
            ResultKt.throwOnFailure(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        long totalItemsCount = 0;
        for (Result result : list) {
            boolean z = result instanceof Result.Success;
            if (z) {
                PageResult pageResult = (PageResult) ((Result.Success) result).getValue();
                arrayList2.addAll(pageResult.getPageItems());
                totalItemsCount = pageResult.getTotalItemsCount();
            } else if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!z) {
                if (result instanceof Result.Error) {
                    return new Result.Error((RemoteError) ((Result.Error) result).getValue());
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return new Result.Success(new PageResult(arrayList2, totalItemsCount));
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.ItemRemoteDataSource$asyncFetchFolderItemsPagesFromRemote$2, reason: invalid class name */
    /* JADX INFO: compiled from: ItemRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.ItemRemoteDataSource$asyncFetchFolderItemsPagesFromRemote$2", f = "ItemRemoteDataSource.kt", i = {0}, l = {169}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
        final /* synthetic */ String $folderId;
        final /* synthetic */ int $limit;
        final /* synthetic */ long $maxLimit;
        final /* synthetic */ int $numberOfPagesToLoad;
        final /* synthetic */ long $offset;
        final /* synthetic */ List<Result<PageResult, RemoteError>> $pageResults;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ItemRemoteDataSource this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, long j, int i2, long j2, List<Result<PageResult, RemoteError>> list, ItemRemoteDataSource itemRemoteDataSource, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$numberOfPagesToLoad = i;
            this.$offset = j;
            this.$limit = i2;
            this.$maxLimit = j2;
            this.$pageResults = list;
            this.this$0 = itemRemoteDataSource;
            this.$folderId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$numberOfPagesToLoad, this.$offset, this.$limit, this.$maxLimit, this.$pageResults, this.this$0, this.$folderId, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<Unit>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Unit>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
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
            IntRange intRangeUntil = RangesKt.until(0, this.$numberOfPagesToLoad);
            long j = this.$offset;
            int i2 = this.$limit;
            long j2 = this.$maxLimit;
            List<Result<PageResult, RemoteError>> list = this.$pageResults;
            ItemRemoteDataSource itemRemoteDataSource = this.this$0;
            String str = this.$folderId;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                List<Result<PageResult, RemoteError>> list2 = list;
                ItemRemoteDataSource itemRemoteDataSource2 = itemRemoteDataSource;
                String str2 = str;
                ArrayList arrayList2 = arrayList;
                arrayList2.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ItemRemoteDataSource$asyncFetchFolderItemsPagesFromRemote$2$1$1(j, ((IntIterator) it).nextInt(), i2, j2, list2, itemRemoteDataSource2, str2, null), 3, null));
                arrayList = arrayList2;
                list = list2;
                itemRemoteDataSource = itemRemoteDataSource2;
                str = str2;
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.label = 1;
            Object objAwaitAll = AwaitKt.awaitAll(arrayList, this);
            return objAwaitAll == coroutine_suspended ? coroutine_suspended : objAwaitAll;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x0097  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:40:0x00da  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:49:0x0122  */
    /* JADX WARN: Code duplicated, block: B:51:0x0128  */
    /* JADX WARN: Code duplicated, block: B:53:0x012e  */
    /* JADX WARN: Code duplicated, block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchFolderItemsPageFromRemote(String str, long j, int i, Continuation<? super Result<PageResult, ? extends RemoteError>> continuation) {
        C10901 c10901;
        Exception exc;
        Result.Error error;
        boolean z;
        if (continuation instanceof C10901) {
            c10901 = (C10901) continuation;
            if ((c10901.label & Integer.MIN_VALUE) != 0) {
                c10901.label -= Integer.MIN_VALUE;
            } else {
                c10901 = new C10901(continuation);
            }
        } else {
            c10901 = new C10901(continuation);
        }
        C10901 c10902 = c10901;
        Object folderItems = c10902.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10902.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(folderItems);
            try {
                FolderItemsRequest folderItemsRequest = this.folderItemsRequest;
                String str2 = GET_FOLDER_ITEMS_DEFAULT_FIELDS;
                Long lBoxLong = Boxing.boxLong(j);
                Integer numBoxInt = Boxing.boxInt(i);
                String apiSort = this.localSortPreferences.getSortBy().toApiSort();
                String string = this.localSortPreferences.getSortOrder().toString();
                c10902.L$0 = str;
                c10902.J$0 = j;
                c10902.I$0 = i;
                c10902.I$1 = 0;
                c10902.I$2 = 0;
                c10902.label = 1;
                try {
                    folderItems = folderItemsRequest.getFolderItems(str, str2, lBoxLong, numBoxInt, apiSort, string, c10902);
                    if (folderItems == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = str;
                } catch (Exception e) {
                    exc = e;
                    str = str;
                    error = new Result.Error(exc);
                }
            } catch (Exception e2) {
                e = e2;
                exc = e;
                error = new Result.Error(exc);
                z = error instanceof Result.Success;
                if (z) {
                    this.gen204FolderItemsEventLogger.success(new ItemId.Remote(str, ItemType.FOLDER), ((ItemsDTO) ((Result.Success) error).getValue()).getEntries().size());
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (z) {
                    ItemsDTO itemsDTO = (ItemsDTO) ((Result.Success) error).getValue();
                    error = new Result.Success(new PageResult(itemsDTO.getEntries(), itemsDTO.getTotalCount()));
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (error instanceof Result.Success) {
                    return error;
                }
                if (error instanceof Result.Error) {
                    Exception exc2 = (Exception) ((Result.Error) error).getValue();
                    BoxLogUtils.e(LOGTAG, "Exception attempting to get folder items", exc2);
                    RemoteError remoteErrorFromApiException = ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc2, this.moshi);
                    this.gen204FolderItemsEventLogger.failure(new ItemId.Remote(str, ItemType.FOLDER), remoteErrorFromApiException.getMessage(), remoteErrorFromApiException.getCode());
                    return new Result.Error(remoteErrorFromApiException);
                }
                throw new NoWhenBranchMatchedException();
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c10902.I$2;
            int i4 = c10902.I$1;
            int i5 = c10902.I$0;
            long j2 = c10902.J$0;
            str = (String) c10902.L$0;
            try {
                ResultKt.throwOnFailure(folderItems);
            } catch (Exception e3) {
                e = e3;
                exc = e;
                error = new Result.Error(exc);
            }
        }
        error = new Result.Success((ItemsDTO) folderItems);
        z = error instanceof Result.Success;
        if (z) {
            this.gen204FolderItemsEventLogger.success(new ItemId.Remote(str, ItemType.FOLDER), ((ItemsDTO) ((Result.Success) error).getValue()).getEntries().size());
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            ItemsDTO itemsDTO2 = (ItemsDTO) ((Result.Success) error).getValue();
            error = new Result.Success(new PageResult(itemsDTO2.getEntries(), itemsDTO2.getTotalCount()));
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc3 = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception attempting to get folder items", exc3);
            RemoteError remoteErrorFromApiException2 = ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc3, this.moshi);
            this.gen204FolderItemsEventLogger.failure(new ItemId.Remote(str, ItemType.FOLDER), remoteErrorFromApiException2.getMessage(), remoteErrorFromApiException2.getCode());
            return new Result.Error(remoteErrorFromApiException2);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Object copy$default(ItemRemoteDataSource itemRemoteDataSource, ItemId.Remote remote, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return itemRemoteDataSource.copy(remote, str, str2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x017e, code lost:
    
        if (r0 == r4) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object copy(com.box.android.domain.models.ItemId.Remote r18, java.lang.String r19, java.lang.String r20, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends com.box.android.data.api.models.items.IItemDTO, ? extends com.box.android.data.datasource.errors.RemoteError>> r21) {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.ItemRemoteDataSource.copy(com.box.android.domain.models.ItemId$Remote, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object move$default(ItemRemoteDataSource itemRemoteDataSource, ItemId.Remote remote, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return itemRemoteDataSource.move(remote, str, str2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x017e, code lost:
    
        if (r0 == r4) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object move(com.box.android.domain.models.ItemId.Remote r18, java.lang.String r19, java.lang.String r20, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends com.box.android.data.api.models.items.IItemDTO, ? extends com.box.android.data.datasource.errors.RemoteError>> r21) {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.ItemRemoteDataSource.move(com.box.android.domain.models.ItemId$Remote, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d5, code lost:
    
        if (r8 == r1) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getItem(com.box.android.domain.models.ItemId.Remote r7, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<? extends com.box.android.data.api.models.items.IItemDTO, ? extends com.box.android.data.datasource.errors.RemoteError>> r8) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.ItemRemoteDataSource.getItem(com.box.android.domain.models.ItemId$Remote, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getFolderMini$default(ItemRemoteDataSource itemRemoteDataSource, ItemId.Remote remote, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return itemRemoteDataSource.getFolderMini(remote, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFolderMini(ItemId.Remote remote, boolean z, Continuation<? super Result<? extends IItemDTO, ? extends RemoteError>> continuation) {
        C10921 c10921;
        Result.Error error;
        String folder_mini_fields;
        if (continuation instanceof C10921) {
            c10921 = (C10921) continuation;
            if ((c10921.label & Integer.MIN_VALUE) != 0) {
                c10921.label -= Integer.MIN_VALUE;
            } else {
                c10921 = new C10921(continuation);
            }
        } else {
            c10921 = new C10921(continuation);
        }
        Object folderInfo = c10921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10921.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(folderInfo);
                if (z) {
                    folder_mini_fields = ItemDTOFields.INSTANCE.getFOLDER_MINI_FIELDS_WITH_PARENT();
                } else {
                    folder_mini_fields = ItemDTOFields.INSTANCE.getFOLDER_MINI_FIELDS();
                }
                ItemInfoRequest itemInfoRequest = this.getItemRequest;
                String boxId = remote.getBoxId();
                c10921.L$0 = SpillingKt.nullOutSpilledVariable(remote);
                c10921.L$1 = SpillingKt.nullOutSpilledVariable(folder_mini_fields);
                c10921.Z$0 = z;
                c10921.I$0 = 0;
                c10921.I$1 = 0;
                c10921.label = 1;
                folderInfo = itemInfoRequest.getFolderInfo(boxId, folder_mini_fields, c10921);
                if (folderInfo == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c10921.I$1;
                int i3 = c10921.I$0;
                boolean z2 = c10921.Z$0;
                ResultKt.throwOnFailure(folderInfo);
            }
            error = new Result.Success((FolderDTO) folderInfo);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(UploadErrorUtil.INSTANCE.getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }

    /* JADX INFO: compiled from: ItemRemoteDataSource.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/datasource/ItemRemoteDataSource$PageResult;", "", "pageItems", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "totalItemsCount", "", "<init>", "(Ljava/util/List;J)V", "getPageItems", "()Ljava/util/List;", "getTotalItemsCount", "()J", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PageResult {
        private final List<IItemDTO> pageItems;
        private final long totalItemsCount;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PageResult copy$default(PageResult pageResult, List list, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                list = pageResult.pageItems;
            }
            if ((i & 2) != 0) {
                j = pageResult.totalItemsCount;
            }
            return pageResult.copy(list, j);
        }

        public final List<IItemDTO> component1() {
            return this.pageItems;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTotalItemsCount() {
            return this.totalItemsCount;
        }

        public final PageResult copy(List<? extends IItemDTO> pageItems, long totalItemsCount) {
            Intrinsics.checkNotNullParameter(pageItems, "pageItems");
            return new PageResult(pageItems, totalItemsCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageResult)) {
                return false;
            }
            PageResult pageResult = (PageResult) other;
            return Intrinsics.areEqual(this.pageItems, pageResult.pageItems) && this.totalItemsCount == pageResult.totalItemsCount;
        }

        public int hashCode() {
            return (this.pageItems.hashCode() * 31) + Long.hashCode(this.totalItemsCount);
        }

        public String toString() {
            return "PageResult(pageItems=" + this.pageItems + ", totalItemsCount=" + this.totalItemsCount + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public PageResult(List<? extends IItemDTO> pageItems, long j) {
            Intrinsics.checkNotNullParameter(pageItems, "pageItems");
            this.pageItems = pageItems;
            this.totalItemsCount = j;
        }

        public final List<IItemDTO> getPageItems() {
            return this.pageItems;
        }

        public final long getTotalItemsCount() {
            return this.totalItemsCount;
        }
    }
}
