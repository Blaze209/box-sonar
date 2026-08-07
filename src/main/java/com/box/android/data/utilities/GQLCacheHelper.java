package com.box.android.data.utilities;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.apollographql.apollo3.cache.normalized.ApolloStore;
import com.apollographql.apollo3.cache.normalized.api.CacheKey;
import com.apollographql.apollo3.exception.ApolloException;
import com.apollographql.apollo3.exception.CacheMissException;
import com.box.android.data.GetFolderItemsEdgesOnlyQuery;
import com.box.android.data.GetFolderItemsQuery;
import com.box.android.data.GetItemQuery;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.gql.GQLCache;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.datasource.gql.cache.GQLCacheKeyUtils;
import com.box.android.data.datasource.gql.cache.GQLEdgeHelper;
import com.box.android.data.fragment.FileFields;
import com.box.android.data.fragment.FileFieldsImpl;
import com.box.android.data.fragment.FolderFields;
import com.box.android.data.fragment.FolderFieldsImpl;
import com.box.android.data.fragment.ItemConnectionEdgesOnlyFragment;
import com.box.android.data.fragment.ItemConnectionFragment;
import com.box.android.data.fragment.ItemConnectionFragmentImpl;
import com.box.android.data.fragment.WeblinkFields;
import com.box.android.data.fragment.WeblinkFieldsImpl;
import com.box.android.data.mappers.GQLGetFileByIDFileToFileModelMapper;
import com.box.android.data.mappers.GQLGetFolderItemsQueryEdgeToItemModelMapper;
import com.box.android.data.mappers.GraphQLMapper;
import com.box.android.data.mappers.ItemConnectionEdgesToItemConnectionEdgesOnlyMapper;
import com.box.android.data.mappers.TypenameMapperKt;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.utils.BoxLogUtils;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Predicate;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.sync.Mutex;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: GQLCacheHelper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0019J\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001dJ6\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0082@¢\u0006\u0002\u0010 J,\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0017H\u0086@¢\u0006\u0002\u0010!JT\u0010\"\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0#2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010%Jh\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\t2<\u0010'\u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020*0)¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\n0(2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0017H\u0087@¢\u0006\u0002\u0010/Jp\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000b0\t2<\u0010'\u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020*0)¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\n0(2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0017H\u0087@¢\u0006\u0002\u00100J\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020*022\f\u00103\u001a\b\u0012\u0004\u0012\u00020*02J \u00104\u001a\u0004\u0018\u00010*2\u0006\u00105\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0019J\u0016\u00106\u001a\u00020*2\u0006\u00107\u001a\u000208H\u0082@¢\u0006\u0002\u00109J\u0016\u0010:\u001a\u00020*2\u0006\u00107\u001a\u000208H\u0082@¢\u0006\u0002\u00109J\u0016\u0010;\u001a\u00020*2\u0006\u00107\u001a\u000208H\u0082@¢\u0006\u0002\u00109J$\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u00172\f\u0010>\u001a\b\u0012\u0004\u0012\u00020*02H\u0086@¢\u0006\u0002\u0010?J\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020*022\u0006\u0010=\u001a\u00020\u0017H\u0087@¢\u0006\u0002\u0010AJ\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020C022\u0006\u0010=\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010AJ$\u0010D\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u00172\f\u0010-\u001a\b\u0012\u0004\u0012\u00020C02H\u0087@¢\u0006\u0002\u0010?J$\u0010E\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u00172\f\u0010-\u001a\b\u0012\u0004\u0012\u00020*02H\u0087@¢\u0006\u0002\u0010?J\u001e\u0010F\u001a\u00020G2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0087@¢\u0006\u0002\u0010\u0019J\u0016\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0017H\u0087@¢\u0006\u0002\u0010AJ\u0016\u0010F\u001a\u00020G2\u0006\u00107\u001a\u000208H\u0082@¢\u0006\u0002\u00109J2\u0010I\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u00172\f\u0010J\u001a\b\u0012\u0004\u0012\u00020C022\f\u0010K\u001a\b\u0012\u0004\u0012\u00020*02H\u0086@¢\u0006\u0002\u0010LJ*\u0010M\u001a\b\u0012\u0004\u0012\u00020C022\f\u0010N\u001a\b\u0012\u0004\u0012\u00020C022\f\u0010O\u001a\b\u0012\u0004\u0012\u00020C02H\u0007J*\u0010P\u001a\b\u0012\u0004\u0012\u00020C022\f\u0010J\u001a\b\u0012\u0004\u0012\u00020C022\f\u0010K\u001a\b\u0012\u0004\u0012\u00020*02H\u0007J\u000e\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006S"}, d2 = {"Lcom/box/android/data/utilities/GQLCacheHelper;", "", "gqlCache", "Lcom/box/android/data/datasource/gql/GQLCache;", "<init>", "(Lcom/box/android/data/datasource/gql/GQLCache;)V", "getGqlCache", "()Lcom/box/android/data/datasource/gql/GQLCache;", "gqlWriteFileToCache", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/datasource/CacheError;", "store", "Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "(Lcom/apollographql/apollo3/cache/normalized/ApolloStore;Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlWriteFolderToCache", "folderModel", "Lcom/box/android/domain/models/item/FolderModel;", "(Lcom/apollographql/apollo3/cache/normalized/ApolloStore;Lcom/box/android/domain/models/item/FolderModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlDeleteItemFromCache", "itemId", "", "type", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlInsertItemToParentInCache", "Lcom/box/android/domain/models/item/ItemModel;", "itemModel", "(Lcom/box/android/domain/models/item/ItemModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlRemoveItemFromParentInCache", IdentificationData.FIELD_PARENT_ID, "(Lcom/box/android/domain/models/item/ItemModel;Ljava/lang/String;Lcom/apollographql/apollo3/cache/normalized/ApolloStore;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/box/android/domain/models/item/ItemModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlRemoveFromParentAndDeleteItem", "Lkotlin/Pair;", "itemType", "(Lcom/box/android/domain/models/item/ItemModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlUpdateEdgesWithItemInCache", "updateEdges", "Lkotlin/Function2;", "", "Lcom/box/android/data/fragment/ItemConnectionFragment$Edge;", "Lkotlin/ParameterName;", "name", "edges", SemanticAttributes.NetHostConnectionSubtypeValues.EDGE, "(Lkotlin/jvm/functions/Function2;Lcom/box/android/domain/models/item/ItemModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Lcom/apollographql/apollo3/cache/normalized/ApolloStore;Lcom/box/android/domain/models/item/ItemModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlDistinctEdgesById", "", BoxNoteConstants.BOX_NOTE_STYLE_TYPE_LIST, "gqlReadEdgeForGetFolderItemsFromCache", "id", "gqlReadFileEdgeFromCache", "cacheKey", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "(Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlReadFolderEdgeFromCache", "gqlReadWeblinkEdgeFromCache", "gqlUpdateEdgesInCache", "folderId", "newEdges", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlFetchEdgesFromCache", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlFetchEdgesOnlyFromCache", "Lcom/box/android/data/fragment/ItemConnectionEdgesOnlyFragment$Edge;", "gqlWriteEdgesOnlyToCache", "gqlWriteItemConnectionFragmentToCache", "gqlDeleteItemRowFromCache", "", "cacheKeyString", "removeStaleChildren", "originalCachedEdges", "fetchedEdges", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStaleChildren", "removedEdges", "currentCachedEdges", "getRemovedChildren", "logCacheError", NotificationCompat.CATEGORY_MESSAGE, "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCacheHelper {
    private final GQLCache gqlCache;

    /* JADX INFO: compiled from: GQLCacheHelper.kt */
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
            try {
                iArr[ItemType.WEBLINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlDeleteItemFromCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {79, 88, 95, 102, 109}, m = "gqlDeleteItemFromCache", n = {"itemId", "type", "success", "edges", "itemId", "type", "success", "edges", "$this$forEach$iv", "element$iv", SemanticAttributes.NetHostConnectionSubtypeValues.EDGE, "folder", "$i$f$forEach", "$i$a$-forEach-GQLCacheHelper$gqlDeleteItemFromCache$2", "$i$a$-let-GQLCacheHelper$gqlDeleteItemFromCache$2$1", "itemId", "type", "success", "edges", "$this$forEach$iv", "element$iv", SemanticAttributes.NetHostConnectionSubtypeValues.EDGE, "file", "$i$f$forEach", "$i$a$-forEach-GQLCacheHelper$gqlDeleteItemFromCache$2", "$i$a$-let-GQLCacheHelper$gqlDeleteItemFromCache$2$2", "itemId", "type", "success", "edges", "$this$forEach$iv", "element$iv", SemanticAttributes.NetHostConnectionSubtypeValues.EDGE, "weblink", "$i$f$forEach", "$i$a$-forEach-GQLCacheHelper$gqlDeleteItemFromCache$2", "$i$a$-let-GQLCacheHelper$gqlDeleteItemFromCache$2$3", "itemId", "type", "success", "edges"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
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
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlDeleteItemFromCache(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlDeleteItemRowFromCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0, 0, 0, 0}, l = {514}, m = "gqlDeleteItemRowFromCache", n = {"itemId", "type", "cacheKey", "$i$a$-let-GQLCacheHelper$gqlDeleteItemRowFromCache$2"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class C15611 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C15611(Continuation<? super C15611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlDeleteItemRowFromCache(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlDeleteItemRowFromCache$4, reason: invalid class name */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0}, l = {527}, m = "gqlDeleteItemRowFromCache", n = {"cacheKey"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass4 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlDeleteItemRowFromCache((CacheKey) null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlFetchEdgesFromCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0, 0, 0}, l = {415}, m = "gqlFetchEdgesFromCache", n = {"folderId", "store", "$i$a$-let-GQLCacheHelper$gqlFetchEdgesFromCache$2"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C15621 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C15621(Continuation<? super C15621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlFetchEdgesFromCache(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlFetchEdgesOnlyFromCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0, 0, 0}, l = {441}, m = "gqlFetchEdgesOnlyFromCache", n = {"folderId", "store", "$i$a$-let-GQLCacheHelper$gqlFetchEdgesOnlyFromCache$2"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class C15631 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C15631(Continuation<? super C15631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlFetchEdgesOnlyFromCache(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlReadFileEdgeFromCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0}, l = {284}, m = "gqlReadFileEdgeFromCache", n = {"cacheKey"}, s = {"L$0"}, v = 1)
    static final class C15641 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C15641(Continuation<? super C15641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlReadFileEdgeFromCache(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlReadFolderEdgeFromCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0}, l = {300}, m = "gqlReadFolderEdgeFromCache", n = {"cacheKey"}, s = {"L$0"}, v = 1)
    static final class C15651 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C15651(Continuation<? super C15651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlReadFolderEdgeFromCache(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlReadWeblinkEdgeFromCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0}, l = {TypedValues.AttributesType.TYPE_PATH_ROTATE}, m = "gqlReadWeblinkEdgeFromCache", n = {"cacheKey"}, s = {"L$0"}, v = 1)
    static final class C15661 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C15661(Continuation<? super C15661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlReadWeblinkEdgeFromCache(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlRemoveFromParentAndDeleteItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {643, Token.GENEXPR, Token.METHOD}, m = "gqlRemoveFromParentAndDeleteItem", n = {"itemModel", IdentificationData.FIELD_PARENT_ID, "itemId", "itemType", "this_$iv", "$this$withLock_u24default$iv$iv", "$i$f$apolloStoreWithLock", "$i$f$withLock", "itemModel", IdentificationData.FIELD_PARENT_ID, "itemId", "itemType", "this_$iv", "$this$withLock_u24default$iv$iv", "store", "$i$f$apolloStoreWithLock", "$i$f$withLock", "$i$a$-withLock$default-GQLCache$apolloStoreWithLock$2$iv", "$i$a$-apolloStoreWithLock-GQLCacheHelper$gqlRemoveFromParentAndDeleteItem$2", "itemModel", IdentificationData.FIELD_PARENT_ID, "itemId", "itemType", "this_$iv", "$this$withLock_u24default$iv$iv", "store", "removeResult", "$i$f$apolloStoreWithLock", "$i$f$withLock", "$i$a$-withLock$default-GQLCache$apolloStoreWithLock$2$iv", "$i$a$-apolloStoreWithLock-GQLCacheHelper$gqlRemoveFromParentAndDeleteItem$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C15671 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C15671(Continuation<? super C15671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlRemoveFromParentAndDeleteItem(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlRemoveItemFromParentInCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0, 0, 0, 0, 0}, l = {140}, m = "gqlRemoveItemFromParentInCache", n = {"itemModel", IdentificationData.FIELD_PARENT_ID, "store", "it", "$i$a$-let-GQLCacheHelper$gqlRemoveItemFromParentInCache$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
    static final class C15681 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C15681(Continuation<? super C15681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlRemoveItemFromParentInCache(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlRemoveItemFromParentInCache$4, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {643, Token.LET}, m = "gqlRemoveItemFromParentInCache", n = {"itemModel", IdentificationData.FIELD_PARENT_ID, "this_$iv", "$this$withLock_u24default$iv$iv", "$i$f$apolloStoreWithLock", "$i$f$withLock", "itemModel", IdentificationData.FIELD_PARENT_ID, "this_$iv", "$this$withLock_u24default$iv$iv", "store", "$i$f$apolloStoreWithLock", "$i$f$withLock", "$i$a$-withLock$default-GQLCache$apolloStoreWithLock$2$iv", "$i$a$-apolloStoreWithLock-GQLCacheHelper$gqlRemoveItemFromParentInCache$5"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C15694 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C15694(Continuation<? super C15694> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlRemoveItemFromParentInCache(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlUpdateEdgesInCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {643, 359, 365, 380, 386}, m = "gqlUpdateEdgesInCache", n = {"folderId", "newEdges", "this_$iv", "$this$withLock_u24default$iv$iv", "$i$f$apolloStoreWithLock", "$i$f$withLock", "folderId", "newEdges", "this_$iv", "$this$withLock_u24default$iv$iv", "it", "it", "fakeFolderId", "$i$f$apolloStoreWithLock", "$i$f$withLock", "$i$a$-withLock$default-GQLCache$apolloStoreWithLock$2$iv", "$i$a$-apolloStoreWithLock-GQLCacheHelper$gqlUpdateEdgesInCache$2", "$i$a$-let-GQLCacheHelper$gqlUpdateEdgesInCache$2$1", "folderId", "newEdges", "this_$iv", "$this$withLock_u24default$iv$iv", "it", "it", "fakeFolderId", "$i$f$apolloStoreWithLock", "$i$f$withLock", "$i$a$-withLock$default-GQLCache$apolloStoreWithLock$2$iv", "$i$a$-apolloStoreWithLock-GQLCacheHelper$gqlUpdateEdgesInCache$2", "$i$a$-let-GQLCacheHelper$gqlUpdateEdgesInCache$2$1", "folderId", "newEdges", "this_$iv", "$this$withLock_u24default$iv$iv", "it", "it", "fakeFolderId", "newEdgesOnly", "joinedEdgesOnly", "cachedEdgesOnly", "$i$f$apolloStoreWithLock", "$i$f$withLock", "$i$a$-withLock$default-GQLCache$apolloStoreWithLock$2$iv", "$i$a$-apolloStoreWithLock-GQLCacheHelper$gqlUpdateEdgesInCache$2", "$i$a$-let-GQLCacheHelper$gqlUpdateEdgesInCache$2$1", "folderId", "newEdges", "this_$iv", "$this$withLock_u24default$iv$iv", "it", "it", "fakeFolderId", "newEdgesOnly", "joinedEdgesOnly", "cachedEdgesOnly", "$i$f$apolloStoreWithLock", "$i$f$withLock", "$i$a$-withLock$default-GQLCache$apolloStoreWithLock$2$iv", "$i$a$-apolloStoreWithLock-GQLCacheHelper$gqlUpdateEdgesInCache$2", "$i$a$-let-GQLCacheHelper$gqlUpdateEdgesInCache$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "I$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
    static final class C15701 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
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

        C15701(Continuation<? super C15701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlUpdateEdgesInCache(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlUpdateEdgesWithItemInCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {643, 185}, m = "gqlUpdateEdgesWithItemInCache", n = {"updateEdges", "itemModel", IdentificationData.FIELD_PARENT_ID, "this_$iv", "$this$withLock_u24default$iv$iv", "$i$f$apolloStoreWithLock", "$i$f$withLock", "updateEdges", "itemModel", IdentificationData.FIELD_PARENT_ID, "this_$iv", "$this$withLock_u24default$iv$iv", "it", "store", "$i$f$apolloStoreWithLock", "$i$f$withLock", "$i$a$-withLock$default-GQLCache$apolloStoreWithLock$2$iv", "$i$a$-apolloStoreWithLock-GQLCacheHelper$gqlUpdateEdgesWithItemInCache$2", "$i$a$-let-GQLCacheHelper$gqlUpdateEdgesWithItemInCache$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
    static final class C15711 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C15711(Continuation<? super C15711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlUpdateEdgesWithItemInCache(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlUpdateEdgesWithItemInCache$3, reason: invalid class name */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {209, 234}, m = "gqlUpdateEdgesWithItemInCache", n = {"updateEdges", "store", "itemModel", IdentificationData.FIELD_PARENT_ID, "query", "updateEdges", "store", "itemModel", IdentificationData.FIELD_PARENT_ID, "query", "data", "edges", SemanticAttributes.NetHostConnectionSubtypeValues.EDGE, "distinctEdges", "modifiedData", "$i$a$-let-GQLCacheHelper$gqlUpdateEdgesWithItemInCache$4"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0"}, v = 1)
    static final class AnonymousClass3 extends ContinuationImpl {
        int I$0;
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

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlUpdateEdgesWithItemInCache(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlWriteFileToCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0, 0}, l = {37}, m = "gqlWriteFileToCache", n = {"store", "fileModel"}, s = {"L$0", "L$1"}, v = 1)
    static final class C15721 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C15721(Continuation<? super C15721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlWriteFileToCache(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$gqlWriteFolderToCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0, 0}, l = {57}, m = "gqlWriteFolderToCache", n = {"store", "folderModel"}, s = {"L$0", "L$1"}, v = 1)
    static final class C15731 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C15731(Continuation<? super C15731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.gqlWriteFolderToCache(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.utilities.GQLCacheHelper$removeStaleChildren$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCacheHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.utilities.GQLCacheHelper", f = "GQLCacheHelper.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {551, 565, 573}, m = "removeStaleChildren", n = {"folderId", "originalCachedEdges", "fetchedEdges", "removedEdges", "folderId", "originalCachedEdges", "fetchedEdges", "removedEdges", "currentCachedEdges", "staleChildren", "$this$forEach$iv", "element$iv", "staleEdge", "remoteId", "$i$f$forEach", "$i$a$-forEach-GQLCacheHelper$removeStaleChildren$2", "$i$a$-let-GQLCacheHelper$removeStaleChildren$2$2", "folderId", "originalCachedEdges", "fetchedEdges", "removedEdges", "currentCachedEdges", "staleChildren"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class C15741 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$10;
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

        C15741(Continuation<? super C15741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCacheHelper.this.removeStaleChildren(null, null, null, this);
        }
    }

    @Inject
    public GQLCacheHelper(GQLCache gqlCache) {
        Intrinsics.checkNotNullParameter(gqlCache, "gqlCache");
        this.gqlCache = gqlCache;
    }

    public final GQLCache getGqlCache() {
        return this.gqlCache;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlWriteFileToCache(ApolloStore apolloStore, FileModel fileModel, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C15721 c15721;
        if (continuation instanceof C15721) {
            c15721 = (C15721) continuation;
            if ((c15721.label & Integer.MIN_VALUE) != 0) {
                c15721.label -= Integer.MIN_VALUE;
            } else {
                c15721 = new C15721(continuation);
            }
        } else {
            c15721 = new C15721(continuation);
        }
        C15721 c15722 = c15721;
        Object objWriteOperation$default = c15722.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15722.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWriteOperation$default);
            GetItemQuery getItemQuery = new GetItemQuery(ItemModelKt.toItemIdRemoteId(fileModel).getBoxId(), com.box.android.data.type.ItemType.file);
            GetItemQuery.Data data = new GetItemQuery.Data(new GetItemQuery.Item(TypenameMapperKt.toGQLTypename(ItemType.FILE), (GetItemQuery.OnFile) GraphQLMapper.toGraphQL$default(GQLGetFileByIDFileToFileModelMapper.INSTANCE, fileModel, null, 2, null), null, null));
            c15722.L$0 = SpillingKt.nullOutSpilledVariable(apolloStore);
            c15722.L$1 = SpillingKt.nullOutSpilledVariable(fileModel);
            c15722.label = 1;
            objWriteOperation$default = ApolloStore.DefaultImpls.writeOperation$default(apolloStore, getItemQuery, data, null, null, true, c15722, 12, null);
            if (objWriteOperation$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWriteOperation$default);
        }
        if (!((Set) objWriteOperation$default).isEmpty()) {
            return new Result.Success(Unit.INSTANCE);
        }
        return new Result.Error(CacheError.SaveError.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlWriteFolderToCache(ApolloStore apolloStore, FolderModel folderModel, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C15731 c15731;
        if (continuation instanceof C15731) {
            c15731 = (C15731) continuation;
            if ((c15731.label & Integer.MIN_VALUE) != 0) {
                c15731.label -= Integer.MIN_VALUE;
            } else {
                c15731 = new C15731(continuation);
            }
        } else {
            c15731 = new C15731(continuation);
        }
        C15731 c15732 = c15731;
        Object objWriteOperation$default = c15732.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15732.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWriteOperation$default);
            FolderModel folderModel2 = folderModel;
            GetFolderItemsQuery getFolderItemsQuery = new GetFolderItemsQuery(ItemModelKt.toItemIdRemoteId(folderModel2).getBoxId());
            GetFolderItemsQuery.Data data = new GetFolderItemsQuery.Data(new GetFolderItemsQuery.Folder(ItemModelKt.toItemIdRemoteId(folderModel2).getBoxId(), null));
            c15732.L$0 = SpillingKt.nullOutSpilledVariable(apolloStore);
            c15732.L$1 = SpillingKt.nullOutSpilledVariable(folderModel);
            c15732.label = 1;
            objWriteOperation$default = ApolloStore.DefaultImpls.writeOperation$default(apolloStore, getFolderItemsQuery, data, null, null, true, c15732, 12, null);
            if (objWriteOperation$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWriteOperation$default);
        }
        if (!((Set) objWriteOperation$default).isEmpty()) {
            return new Result.Success(Unit.INSTANCE);
        }
        return new Result.Error(CacheError.SaveError.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:55:0x018d  */
    /* JADX WARN: Code duplicated, block: B:57:0x019e  */
    /* JADX WARN: Code duplicated, block: B:60:0x01de  */
    /* JADX WARN: Code duplicated, block: B:63:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:66:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:71:0x0205  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:82:0x025c  */
    /* JADX WARN: Code duplicated, block: B:85:0x0268  */
    /* JADX WARN: Code duplicated, block: B:88:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:91:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:94:0x02bc  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:10:0x0031, B:25:0x0105], limit reached: 118 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x02ad -> B:89:0x02b0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x02c7 -> B:96:0x02c3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object gqlDeleteItemFromCache(java.lang.String r21, java.lang.String r22, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.data.datasource.CacheError>> r23) {
        /*
            Method dump skipped, instruction units count: 808
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.utilities.GQLCacheHelper.gqlDeleteItemFromCache(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object gqlInsertItemToParentInCache(ItemModel itemModel, Continuation<? super Result<? extends ItemModel, ? extends CacheError>> continuation) {
        ItemId.Remote itemIdRemoteId;
        String boxId;
        FolderModel parentFolder = itemModel.getParentFolder();
        if (parentFolder == null || (itemIdRemoteId = ItemModelKt.toItemIdRemoteId(parentFolder)) == null || (boxId = itemIdRemoteId.getBoxId()) == null) {
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
        return gqlUpdateEdgesWithItemInCache(new Function2() { // from class: com.box.android.data.utilities.GQLCacheHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GQLCacheHelper.gqlInsertItemToParentInCache$lambda$0((List) obj, (ItemConnectionFragment.Edge) obj2);
            }
        }, itemModel, boxId, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gqlInsertItemToParentInCache$lambda$0(List edges, ItemConnectionFragment.Edge edge) {
        Intrinsics.checkNotNullParameter(edges, "edges");
        Intrinsics.checkNotNullParameter(edge, "edge");
        edges.add(edge);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlRemoveItemFromParentInCache(ItemModel itemModel, String str, ApolloStore apolloStore, Continuation<? super Result<? extends ItemModel, ? extends CacheError>> continuation) throws Exception {
        C15681 c15681;
        GQLCacheHelper gQLCacheHelper;
        if (continuation instanceof C15681) {
            c15681 = (C15681) continuation;
            if ((c15681.label & Integer.MIN_VALUE) != 0) {
                c15681.label -= Integer.MIN_VALUE;
            } else {
                c15681 = new C15681(continuation);
            }
        } else {
            c15681 = new C15681(continuation);
        }
        C15681 c15682 = c15681;
        Object objGqlUpdateEdgesWithItemInCache = c15682.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15682.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objGqlUpdateEdgesWithItemInCache);
            if (str == null) {
                return new Result.Error(CacheError.SaveError.INSTANCE);
            }
            if (apolloStore != null) {
                Function2<? super List<ItemConnectionFragment.Edge>, ? super ItemConnectionFragment.Edge, Unit> function2 = new Function2() { // from class: com.box.android.data.utilities.GQLCacheHelper$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GQLCacheHelper.gqlRemoveItemFromParentInCache$lambda$0$0((List) obj, (ItemConnectionFragment.Edge) obj2);
                    }
                };
                c15682.L$0 = itemModel;
                c15682.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c15682.L$2 = SpillingKt.nullOutSpilledVariable(apolloStore);
                c15682.L$3 = SpillingKt.nullOutSpilledVariable(apolloStore);
                c15682.I$0 = 0;
                c15682.label = 1;
                gQLCacheHelper = this;
                objGqlUpdateEdgesWithItemInCache = gQLCacheHelper.gqlUpdateEdgesWithItemInCache(function2, apolloStore, itemModel, str, c15682);
                if (objGqlUpdateEdgesWithItemInCache == coroutine_suspended) {
                    return coroutine_suspended;
                }
                itemModel = itemModel;
            } else {
                gQLCacheHelper = this;
            }
            gQLCacheHelper.logCacheError("Error getting ApolloStore instance during delete (" + itemModel + ")");
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c15682.I$0;
        itemModel = (ItemModel) c15682.L$0;
        ResultKt.throwOnFailure(objGqlUpdateEdgesWithItemInCache);
        gQLCacheHelper = this;
        Result result = (Result) objGqlUpdateEdgesWithItemInCache;
        if (result != null) {
            return result;
        }
        gQLCacheHelper.logCacheError("Error getting ApolloStore instance during delete (" + itemModel + ")");
        return new Result.Error(CacheError.SaveError.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gqlRemoveItemFromParentInCache$lambda$0$0(List edges, final ItemConnectionFragment.Edge edge) {
        Intrinsics.checkNotNullParameter(edges, "edges");
        Intrinsics.checkNotNullParameter(edge, "edge");
        final Function1 function1 = new Function1() { // from class: com.box.android.data.utilities.GQLCacheHelper$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(GQLCacheHelper.gqlRemoveItemFromParentInCache$lambda$0$0$0(edge, (ItemConnectionFragment.Edge) obj));
            }
        };
        edges.removeIf(new Predicate() { // from class: com.box.android.data.utilities.GQLCacheHelper$$ExternalSyntheticLambda6
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return GQLCacheHelper.gqlRemoveItemFromParentInCache$lambda$0$0$1(function1, obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean gqlRemoveItemFromParentInCache$lambda$0$0$0(ItemConnectionFragment.Edge edge, ItemConnectionFragment.Edge i) {
        Intrinsics.checkNotNullParameter(i, "i");
        return Intrinsics.areEqual(i.getId(), edge.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean gqlRemoveItemFromParentInCache$lambda$0$0$1(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlRemoveItemFromParentInCache(ItemModel itemModel, String str, Continuation<? super Result<? extends ItemModel, ? extends CacheError>> continuation) throws Throwable {
        C15694 c15694;
        Mutex mutex;
        String str2;
        GQLCache gQLCache;
        int i;
        int i2;
        Mutex mutex2;
        if (continuation instanceof C15694) {
            c15694 = (C15694) continuation;
            if ((c15694.label & Integer.MIN_VALUE) != 0) {
                c15694.label -= Integer.MIN_VALUE;
            } else {
                c15694 = new C15694(continuation);
            }
        } else {
            c15694 = new C15694(continuation);
        }
        Object objGqlRemoveItemFromParentInCache = c15694.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c15694.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(objGqlRemoveItemFromParentInCache);
                GQLCache gQLCache2 = this.gqlCache;
                mutex = gQLCache2.getMutex();
                c15694.L$0 = itemModel;
                c15694.L$1 = str;
                c15694.L$2 = gQLCache2;
                c15694.L$3 = mutex;
                c15694.I$0 = 0;
                c15694.I$1 = 0;
                c15694.label = 1;
                if (mutex.lock(null, c15694) != coroutine_suspended) {
                    str2 = str;
                    gQLCache = gQLCache2;
                    i = 0;
                    i2 = 0;
                }
                return coroutine_suspended;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i4 = c15694.I$3;
                int i5 = c15694.I$2;
                int i6 = c15694.I$1;
                int i7 = c15694.I$0;
                mutex2 = (Mutex) c15694.L$3;
                try {
                    ResultKt.throwOnFailure(objGqlRemoveItemFromParentInCache);
                    Result result = (Result) objGqlRemoveItemFromParentInCache;
                    mutex2.unlock(null);
                    return result;
                } catch (Throwable th) {
                    th = th;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            int i8 = c15694.I$1;
            int i9 = c15694.I$0;
            mutex = (Mutex) c15694.L$3;
            gQLCache = (GQLCache) c15694.L$2;
            str2 = (String) c15694.L$1;
            ItemModel itemModel2 = (ItemModel) c15694.L$0;
            ResultKt.throwOnFailure(objGqlRemoveItemFromParentInCache);
            i2 = i9;
            i = i8;
            itemModel = itemModel2;
            ApolloStore apolloStore = gQLCache.getApolloStore();
            c15694.L$0 = SpillingKt.nullOutSpilledVariable(itemModel);
            c15694.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            c15694.L$2 = SpillingKt.nullOutSpilledVariable(gQLCache);
            c15694.L$3 = mutex;
            c15694.L$4 = SpillingKt.nullOutSpilledVariable(apolloStore);
            c15694.I$0 = i2;
            c15694.I$1 = i;
            c15694.I$2 = 0;
            c15694.I$3 = 0;
            c15694.label = 2;
            objGqlRemoveItemFromParentInCache = gqlRemoveItemFromParentInCache(itemModel, str2, apolloStore, c15694);
            if (objGqlRemoveItemFromParentInCache != coroutine_suspended) {
                mutex2 = mutex;
                Result result2 = (Result) objGqlRemoveItemFromParentInCache;
                mutex2.unlock(null);
                return result2;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x016d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object gqlRemoveFromParentAndDeleteItem(ItemModel itemModel, String str, String str2, String str3, Continuation<? super Pair<? extends Result<? extends ItemModel, ? extends CacheError>, ? extends Result<Unit, ? extends CacheError>>> continuation) throws Throwable {
        C15671 c15671;
        Mutex mutex;
        String str4;
        String str5;
        String str6;
        ItemModel itemModel2;
        int i;
        GQLCache gQLCache;
        int i2;
        Mutex mutex2;
        int i3;
        String str7;
        ApolloStore apolloStore;
        String str8;
        GQLCache gQLCache2;
        ItemModel itemModel3;
        String str9;
        Mutex mutex3;
        int i4;
        Result result;
        Object objGqlDeleteItemFromCache;
        Result result2;
        if (continuation instanceof C15671) {
            c15671 = (C15671) continuation;
            if ((c15671.label & Integer.MIN_VALUE) != 0) {
                c15671.label -= Integer.MIN_VALUE;
            } else {
                c15671 = new C15671(continuation);
            }
        } else {
            c15671 = new C15671(continuation);
        }
        Object obj = c15671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c15671.label;
        int i6 = 0;
        try {
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                GQLCache gQLCache3 = this.gqlCache;
                mutex = gQLCache3.getMutex();
                c15671.L$0 = itemModel;
                str4 = str;
                c15671.L$1 = str4;
                str5 = str2;
                c15671.L$2 = str5;
                str6 = str3;
                c15671.L$3 = str6;
                c15671.L$4 = gQLCache3;
                c15671.L$5 = mutex;
                c15671.I$0 = 0;
                c15671.I$1 = 0;
                c15671.label = 1;
                if (mutex.lock(null, c15671) != coroutine_suspended) {
                    itemModel2 = itemModel;
                    i = 0;
                    gQLCache = gQLCache3;
                    i2 = 0;
                }
                return coroutine_suspended;
            }
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i7 = c15671.I$3;
                    int i8 = c15671.I$2;
                    int i9 = c15671.I$1;
                    int i10 = c15671.I$0;
                    result2 = (Result) c15671.L$7;
                    mutex2 = (Mutex) c15671.L$5;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Pair pair = new Pair(result2, (Result) obj);
                        mutex2.unlock(null);
                        return pair;
                    } catch (Throwable th) {
                        th = th;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                int i11 = c15671.I$3;
                int i12 = c15671.I$2;
                i3 = c15671.I$1;
                i = c15671.I$0;
                apolloStore = (ApolloStore) c15671.L$6;
                mutex3 = (Mutex) c15671.L$5;
                gQLCache2 = (GQLCache) c15671.L$4;
                str8 = (String) c15671.L$3;
                str9 = (String) c15671.L$2;
                str7 = (String) c15671.L$1;
                itemModel3 = (ItemModel) c15671.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    i6 = i12;
                    i4 = i11;
                    result = (Result) obj;
                    c15671.L$0 = SpillingKt.nullOutSpilledVariable(itemModel3);
                    c15671.L$1 = SpillingKt.nullOutSpilledVariable(str7);
                    c15671.L$2 = SpillingKt.nullOutSpilledVariable(str9);
                    c15671.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                    c15671.L$4 = SpillingKt.nullOutSpilledVariable(gQLCache2);
                    c15671.L$5 = mutex3;
                    c15671.L$6 = SpillingKt.nullOutSpilledVariable(apolloStore);
                    c15671.L$7 = result;
                    c15671.I$0 = i;
                    c15671.I$1 = i3;
                    c15671.I$2 = i6;
                    c15671.I$3 = i4;
                    c15671.label = 3;
                    objGqlDeleteItemFromCache = gqlDeleteItemFromCache(str9, str8, c15671);
                    if (objGqlDeleteItemFromCache != coroutine_suspended) {
                        obj = objGqlDeleteItemFromCache;
                        result2 = result;
                        mutex2 = mutex3;
                        Pair pair2 = new Pair(result2, (Result) obj);
                        mutex2.unlock(null);
                        return pair2;
                    }
                    return coroutine_suspended;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2 = mutex3;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            int i13 = c15671.I$1;
            int i14 = c15671.I$0;
            Mutex mutex4 = (Mutex) c15671.L$5;
            GQLCache gQLCache4 = (GQLCache) c15671.L$4;
            String str10 = (String) c15671.L$3;
            String str11 = (String) c15671.L$2;
            String str12 = (String) c15671.L$1;
            itemModel2 = (ItemModel) c15671.L$0;
            ResultKt.throwOnFailure(obj);
            str6 = str10;
            str5 = str11;
            i2 = i13;
            mutex = mutex4;
            i = i14;
            gQLCache = gQLCache4;
            str4 = str12;
            ApolloStore apolloStore2 = gQLCache.getApolloStore();
            c15671.L$0 = SpillingKt.nullOutSpilledVariable(itemModel2);
            c15671.L$1 = SpillingKt.nullOutSpilledVariable(str4);
            c15671.L$2 = str5;
            c15671.L$3 = str6;
            c15671.L$4 = SpillingKt.nullOutSpilledVariable(gQLCache);
            c15671.L$5 = mutex;
            c15671.L$6 = SpillingKt.nullOutSpilledVariable(apolloStore2);
            c15671.I$0 = i;
            c15671.I$1 = i2;
            c15671.I$2 = 0;
            c15671.I$3 = 0;
            c15671.label = 2;
            Object objGqlRemoveItemFromParentInCache = gqlRemoveItemFromParentInCache(itemModel2, str4, apolloStore2, c15671);
            if (objGqlRemoveItemFromParentInCache != coroutine_suspended) {
                i3 = i2;
                obj = objGqlRemoveItemFromParentInCache;
                str7 = str4;
                apolloStore = apolloStore2;
                str8 = str6;
                gQLCache2 = gQLCache;
                itemModel3 = itemModel2;
                str9 = str5;
                mutex3 = mutex;
                i4 = 0;
                result = (Result) obj;
                c15671.L$0 = SpillingKt.nullOutSpilledVariable(itemModel3);
                c15671.L$1 = SpillingKt.nullOutSpilledVariable(str7);
                c15671.L$2 = SpillingKt.nullOutSpilledVariable(str9);
                c15671.L$3 = SpillingKt.nullOutSpilledVariable(str8);
                c15671.L$4 = SpillingKt.nullOutSpilledVariable(gQLCache2);
                c15671.L$5 = mutex3;
                c15671.L$6 = SpillingKt.nullOutSpilledVariable(apolloStore);
                c15671.L$7 = result;
                c15671.I$0 = i;
                c15671.I$1 = i3;
                c15671.I$2 = i6;
                c15671.I$3 = i4;
                c15671.label = 3;
                objGqlDeleteItemFromCache = gqlDeleteItemFromCache(str9, str8, c15671);
                if (objGqlDeleteItemFromCache != coroutine_suspended) {
                    obj = objGqlDeleteItemFromCache;
                    result2 = result;
                    mutex2 = mutex3;
                    Pair pair3 = new Pair(result2, (Result) obj);
                    mutex2.unlock(null);
                    return pair3;
                }
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            th = th3;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object gqlUpdateEdgesWithItemInCache(Function2<? super List<ItemConnectionFragment.Edge>, ? super ItemConnectionFragment.Edge, Unit> function2, ItemModel itemModel, String str, Continuation<? super Result<? extends ItemModel, ? extends CacheError>> continuation) throws Throwable {
        C15711 c15711;
        GQLCache gQLCache;
        String str2;
        Mutex mutex;
        int i;
        int i2;
        ItemModel itemModel2;
        int i3;
        Throwable th;
        Mutex mutex2;
        GQLCacheHelper gQLCacheHelper;
        ItemModel itemModel3;
        Result.Error error;
        if (continuation instanceof C15711) {
            c15711 = (C15711) continuation;
            if ((c15711.label & Integer.MIN_VALUE) != 0) {
                c15711.label -= Integer.MIN_VALUE;
            } else {
                c15711 = new C15711(continuation);
            }
        } else {
            c15711 = new C15711(continuation);
        }
        C15711 c15712 = c15711;
        Object objGqlUpdateEdgesWithItemInCache = c15712.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c15712.label;
        try {
            if (i4 == 0) {
                ResultKt.throwOnFailure(objGqlUpdateEdgesWithItemInCache);
                gQLCache = this.gqlCache;
                Mutex mutex3 = gQLCache.getMutex();
                c15712.L$0 = function2;
                c15712.L$1 = itemModel;
                c15712.L$2 = str;
                c15712.L$3 = gQLCache;
                c15712.L$4 = mutex3;
                c15712.I$0 = 0;
                c15712.I$1 = 0;
                c15712.label = 1;
                if (mutex3.lock(null, c15712) != coroutine_suspended) {
                    str2 = str;
                    mutex = mutex3;
                    i = 0;
                    i2 = 0;
                    itemModel2 = itemModel;
                    i3 = 0;
                }
                return coroutine_suspended;
            }
            if (i4 != 1) {
                if (i4 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i5 = c15712.I$4;
                int i6 = c15712.I$3;
                int i7 = c15712.I$2;
                int i8 = c15712.I$1;
                int i9 = c15712.I$0;
                mutex2 = (Mutex) c15712.L$4;
                itemModel3 = (ItemModel) c15712.L$1;
                try {
                    ResultKt.throwOnFailure(objGqlUpdateEdgesWithItemInCache);
                    gQLCacheHelper = this;
                    error = (Result) objGqlUpdateEdgesWithItemInCache;
                    if (error == null) {
                        itemModel2 = itemModel3;
                        gQLCacheHelper.logCacheError("Error getting ApolloStore instance during move (" + itemModel2 + ")");
                        error = new Result.Error(CacheError.SaveError.INSTANCE);
                    }
                    mutex2.unlock(null);
                    return error;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            int i10 = c15712.I$1;
            int i11 = c15712.I$0;
            mutex = (Mutex) c15712.L$4;
            gQLCache = (GQLCache) c15712.L$3;
            String str3 = (String) c15712.L$2;
            ItemModel itemModel4 = (ItemModel) c15712.L$1;
            Function2<? super List<ItemConnectionFragment.Edge>, ? super ItemConnectionFragment.Edge, Unit> function3 = (Function2) c15712.L$0;
            ResultKt.throwOnFailure(objGqlUpdateEdgesWithItemInCache);
            str2 = str3;
            i2 = 0;
            itemModel2 = itemModel4;
            i = i11;
            i3 = i10;
            function2 = function3;
            ApolloStore apolloStore = gQLCache.getApolloStore();
            if (apolloStore != null) {
                c15712.L$0 = SpillingKt.nullOutSpilledVariable(function2);
                c15712.L$1 = itemModel2;
                c15712.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                c15712.L$3 = SpillingKt.nullOutSpilledVariable(gQLCache);
                c15712.L$4 = mutex;
                c15712.L$5 = SpillingKt.nullOutSpilledVariable(apolloStore);
                c15712.L$6 = SpillingKt.nullOutSpilledVariable(apolloStore);
                c15712.I$0 = i;
                c15712.I$1 = i3;
                c15712.I$2 = i2;
                c15712.I$3 = i2;
                c15712.I$4 = i2;
                c15712.label = 2;
                gQLCacheHelper = this;
                objGqlUpdateEdgesWithItemInCache = gQLCacheHelper.gqlUpdateEdgesWithItemInCache(function2, apolloStore, itemModel2, str2, c15712);
                if (objGqlUpdateEdgesWithItemInCache != coroutine_suspended) {
                    mutex2 = mutex;
                    itemModel3 = itemModel2;
                    error = (Result) objGqlUpdateEdgesWithItemInCache;
                    if (error == null) {
                        itemModel2 = itemModel3;
                    }
                    mutex2.unlock(null);
                    return error;
                }
                return coroutine_suspended;
            }
            gQLCacheHelper = this;
            mutex2 = mutex;
            gQLCacheHelper.logCacheError("Error getting ApolloStore instance during move (" + itemModel2 + ")");
            error = new Result.Error(CacheError.SaveError.INSTANCE);
            mutex2.unlock(null);
            return error;
        } catch (Throwable th3) {
            th = th3;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00da  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:60:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object gqlUpdateEdgesWithItemInCache(Function2<? super List<ItemConnectionFragment.Edge>, ? super ItemConnectionFragment.Edge, Unit> function2, ApolloStore apolloStore, ItemModel itemModel, String str, Continuation<? super Result<? extends ItemModel, ? extends CacheError>> continuation) throws Exception {
        AnonymousClass3 anonymousClass3;
        GetFolderItemsQuery getFolderItemsQuery;
        Function2<? super List<ItemConnectionFragment.Edge>, ? super ItemConnectionFragment.Edge, Unit> function3;
        ItemModel itemModel2;
        AnonymousClass3 anonymousClass4;
        Object operation$default;
        ApolloStore apolloStore2;
        GetFolderItemsQuery.Data data;
        GetFolderItemsQuery.Folder folder;
        ArrayList arrayList;
        ItemConnectionFragment.Edge edge;
        GetFolderItemsQuery.Folder folder2;
        String id;
        ItemModel itemModel3;
        GetFolderItemsQuery.ItemConnection itemConnection;
        ItemConnectionFragment itemConnectionFragment;
        List<ItemConnectionFragment.Edge> edges;
        String str2 = str;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            if ((anonymousClass3.label & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        } else {
            anonymousClass3 = new AnonymousClass3(continuation);
        }
        AnonymousClass3 anonymousClass5 = anonymousClass3;
        Object objWriteOperation$default = anonymousClass5.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass5.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objWriteOperation$default);
                getFolderItemsQuery = new GetFolderItemsQuery(str2);
                try {
                    function3 = function2;
                    anonymousClass5.L$0 = function3;
                    anonymousClass5.L$1 = apolloStore;
                    itemModel2 = itemModel;
                    anonymousClass5.L$2 = itemModel2;
                    anonymousClass5.L$3 = str2;
                    anonymousClass5.L$4 = getFolderItemsQuery;
                    anonymousClass5.label = 1;
                    anonymousClass4 = anonymousClass5;
                    operation$default = ApolloStore.DefaultImpls.readOperation$default(apolloStore, getFolderItemsQuery, null, null, anonymousClass4, 6, null);
                    if (operation$default != coroutine_suspended) {
                        apolloStore2 = apolloStore;
                        data = (GetFolderItemsQuery.Data) operation$default;
                        folder = data.getFolder();
                        if (folder != null) {
                            arrayList = new ArrayList();
                        } else {
                            arrayList = new ArrayList();
                        }
                        edge = (ItemConnectionFragment.Edge) GraphQLMapper.toGraphQL$default(GQLGetFolderItemsQueryEdgeToItemModelMapper.INSTANCE, itemModel2, null, 2, null);
                        if (edge != null) {
                            function3.invoke(arrayList, edge);
                            List<ItemConnectionFragment.Edge> listGqlDistinctEdgesById = gqlDistinctEdgesById(arrayList);
                            folder2 = data.getFolder();
                            if (folder2 == null) {
                            }
                            throw new Exception("Unexpected: missing folder data");
                        }
                        BoxLogUtils.d("GQLGetFolderItemsQueryEdgeToItemModelMapper failed to map to GraphQL: " + itemModel2);
                        return new Result.Error(CacheError.SaveError.INSTANCE);
                    }
                    return coroutine_suspended;
                } catch (ApolloException unused) {
                    BoxLogUtils.w(ExtensionsKt.getTAG(this), "Unexpected: parent data should already exist in cache: " + str2);
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
            }
            if (i == 1) {
                GetFolderItemsQuery getFolderItemsQuery2 = (GetFolderItemsQuery) anonymousClass5.L$4;
                String str3 = (String) anonymousClass5.L$3;
                ItemModel itemModel4 = (ItemModel) anonymousClass5.L$2;
                ApolloStore apolloStore3 = (ApolloStore) anonymousClass5.L$1;
                Function2<? super List<ItemConnectionFragment.Edge>, ? super ItemConnectionFragment.Edge, Unit> function4 = (Function2) anonymousClass5.L$0;
                try {
                    ResultKt.throwOnFailure(objWriteOperation$default);
                    itemModel2 = itemModel4;
                    function3 = function4;
                    anonymousClass4 = anonymousClass5;
                    operation$default = objWriteOperation$default;
                    getFolderItemsQuery = getFolderItemsQuery2;
                    str2 = str3;
                    apolloStore2 = apolloStore3;
                    try {
                        data = (GetFolderItemsQuery.Data) operation$default;
                        folder = data.getFolder();
                        if (folder != null || (itemConnection = folder.getItemConnection()) == null || (itemConnectionFragment = itemConnection.getItemConnectionFragment()) == null || (edges = itemConnectionFragment.getEdges()) == null || (arrayList = CollectionsKt.toMutableList((Collection) edges)) == null) {
                            arrayList = new ArrayList();
                        }
                        edge = (ItemConnectionFragment.Edge) GraphQLMapper.toGraphQL$default(GQLGetFolderItemsQueryEdgeToItemModelMapper.INSTANCE, itemModel2, null, 2, null);
                        if (edge != null) {
                            function3.invoke(arrayList, edge);
                            List<ItemConnectionFragment.Edge> listGqlDistinctEdgesById2 = gqlDistinctEdgesById(arrayList);
                            folder2 = data.getFolder();
                            if (folder2 == null && (id = folder2.getId()) != null) {
                                String str4 = str2;
                                GetFolderItemsQuery.Data data2 = new GetFolderItemsQuery.Data(new GetFolderItemsQuery.Folder(id, new GetFolderItemsQuery.ItemConnection(GQLCacheConstants.TYPENAME_ITEM_CONNECTION, new ItemConnectionFragment(listGqlDistinctEdgesById2.size(), listGqlDistinctEdgesById2))));
                                anonymousClass4.L$0 = SpillingKt.nullOutSpilledVariable(function3);
                                anonymousClass4.L$1 = SpillingKt.nullOutSpilledVariable(apolloStore2);
                                anonymousClass4.L$2 = itemModel2;
                                anonymousClass4.L$3 = SpillingKt.nullOutSpilledVariable(str4);
                                anonymousClass4.L$4 = SpillingKt.nullOutSpilledVariable(getFolderItemsQuery);
                                anonymousClass4.L$5 = SpillingKt.nullOutSpilledVariable(data);
                                anonymousClass4.L$6 = SpillingKt.nullOutSpilledVariable(arrayList);
                                anonymousClass4.L$7 = SpillingKt.nullOutSpilledVariable(edge);
                                anonymousClass4.L$8 = SpillingKt.nullOutSpilledVariable(listGqlDistinctEdgesById2);
                                anonymousClass4.L$9 = SpillingKt.nullOutSpilledVariable(data2);
                                anonymousClass4.I$0 = 0;
                                anonymousClass4.label = 2;
                                objWriteOperation$default = ApolloStore.DefaultImpls.writeOperation$default(apolloStore2, getFolderItemsQuery, data2, null, null, false, anonymousClass4, 28, null);
                                if (objWriteOperation$default != coroutine_suspended) {
                                    itemModel3 = itemModel2;
                                }
                                return coroutine_suspended;
                            }
                            throw new Exception("Unexpected: missing folder data");
                        }
                        BoxLogUtils.d("GQLGetFolderItemsQueryEdgeToItemModelMapper failed to map to GraphQL: " + itemModel2);
                        return new Result.Error(CacheError.SaveError.INSTANCE);
                    } catch (ApolloException unused2) {
                        BoxLogUtils.w(ExtensionsKt.getTAG(this), "Unexpected: parent data should already exist in cache: " + str2);
                        return new Result.Error(CacheError.ReadError.INSTANCE);
                    }
                } catch (ApolloException unused3) {
                    str2 = str3;
                    BoxLogUtils.w(ExtensionsKt.getTAG(this), "Unexpected: parent data should already exist in cache: " + str2);
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass5.I$0;
            itemModel3 = (ItemModel) anonymousClass5.L$2;
            ResultKt.throwOnFailure(objWriteOperation$default);
            if (!((Set) objWriteOperation$default).isEmpty()) {
                return new Result.Success(itemModel3);
            }
            return new Result.Error(CacheError.SaveError.INSTANCE);
        } catch (ApolloException unused4) {
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
    }

    public final List<ItemConnectionFragment.Edge> gqlDistinctEdgesById(List<ItemConnectionFragment.Edge> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List listAsReversed = CollectionsKt.asReversed(list);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listAsReversed) {
            if (hashSet.add(((ItemConnectionFragment.Edge) obj).getId())) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.asReversed(arrayList);
    }

    public final Object gqlReadEdgeForGetFolderItemsFromCache(String str, String str2, Continuation<? super ItemConnectionFragment.Edge> continuation) {
        CacheKey cacheKeyCreateCacheKey$default = GQLCacheKeyUtils.createCacheKey$default(GQLCacheKeyUtils.INSTANCE, str, str2, null, 4, null);
        if (cacheKeyCreateCacheKey$default == null) {
            return null;
        }
        String upperCase = str2.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        int i = WhenMappings.$EnumSwitchMapping$0[ItemType.valueOf(upperCase).ordinal()];
        if (i == 1) {
            Object objGqlReadFileEdgeFromCache = gqlReadFileEdgeFromCache(cacheKeyCreateCacheKey$default, continuation);
            return objGqlReadFileEdgeFromCache == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objGqlReadFileEdgeFromCache : (ItemConnectionFragment.Edge) objGqlReadFileEdgeFromCache;
        }
        if (i == 2) {
            Object objGqlReadFolderEdgeFromCache = gqlReadFolderEdgeFromCache(cacheKeyCreateCacheKey$default, continuation);
            return objGqlReadFolderEdgeFromCache == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objGqlReadFolderEdgeFromCache : (ItemConnectionFragment.Edge) objGqlReadFolderEdgeFromCache;
        }
        if (i == 3) {
            Object objGqlReadWeblinkEdgeFromCache = gqlReadWeblinkEdgeFromCache(cacheKeyCreateCacheKey$default, continuation);
            return objGqlReadWeblinkEdgeFromCache == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objGqlReadWeblinkEdgeFromCache : (ItemConnectionFragment.Edge) objGqlReadWeblinkEdgeFromCache;
        }
        throw new IllegalArgumentException("Unexpected ItemType: " + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    /* JADX WARN: Code duplicated, block: B:24:0x006f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0072  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlReadFileEdgeFromCache(CacheKey cacheKey, Continuation<? super ItemConnectionFragment.Edge> continuation) {
        C15641 c15641;
        FileFields fileFields;
        String id;
        if (continuation instanceof C15641) {
            c15641 = (C15641) continuation;
            if ((c15641.label & Integer.MIN_VALUE) != 0) {
                c15641.label -= Integer.MIN_VALUE;
            } else {
                c15641 = new C15641(continuation);
            }
        } else {
            c15641 = new C15641(continuation);
        }
        C15641 c15642 = c15641;
        Object fragment$default = c15642.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15642.label;
        if (i == 0) {
            ResultKt.throwOnFailure(fragment$default);
            ApolloStore apolloStore = this.gqlCache.getApolloStore();
            if (apolloStore != null) {
                FileFieldsImpl fileFieldsImpl = new FileFieldsImpl();
                c15642.L$0 = SpillingKt.nullOutSpilledVariable(cacheKey);
                c15642.label = 1;
                fragment$default = ApolloStore.DefaultImpls.readFragment$default(apolloStore, fileFieldsImpl, cacheKey, null, null, c15642, 12, null);
                if (fragment$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                fileFields = null;
            }
            GQLEdgeHelper gQLEdgeHelper = GQLEdgeHelper.INSTANCE;
            if (fileFields != null) {
                id = fileFields.getId();
            } else {
                id = null;
            }
            if (id == null) {
                id = "";
            }
            return new ItemConnectionFragment.Edge(gQLEdgeHelper.constructEdgeId(id, TypenameMapperKt.toGQLTypename(ItemType.FILE)), new ItemConnectionFragment.Node(TypenameMapperKt.toGQLTypename(ItemType.FILE), fileFields, null, null));
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(fragment$default);
        fileFields = (FileFields) fragment$default;
        GQLEdgeHelper gQLEdgeHelper2 = GQLEdgeHelper.INSTANCE;
        if (fileFields != null) {
            id = fileFields.getId();
        } else {
            id = null;
        }
        if (id == null) {
            id = "";
        }
        return new ItemConnectionFragment.Edge(gQLEdgeHelper2.constructEdgeId(id, TypenameMapperKt.toGQLTypename(ItemType.FILE)), new ItemConnectionFragment.Node(TypenameMapperKt.toGQLTypename(ItemType.FILE), fileFields, null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    /* JADX WARN: Code duplicated, block: B:24:0x006f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0072  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlReadFolderEdgeFromCache(CacheKey cacheKey, Continuation<? super ItemConnectionFragment.Edge> continuation) {
        C15651 c15651;
        FolderFields folderFields;
        String id;
        if (continuation instanceof C15651) {
            c15651 = (C15651) continuation;
            if ((c15651.label & Integer.MIN_VALUE) != 0) {
                c15651.label -= Integer.MIN_VALUE;
            } else {
                c15651 = new C15651(continuation);
            }
        } else {
            c15651 = new C15651(continuation);
        }
        C15651 c15652 = c15651;
        Object fragment$default = c15652.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15652.label;
        if (i == 0) {
            ResultKt.throwOnFailure(fragment$default);
            ApolloStore apolloStore = this.gqlCache.getApolloStore();
            if (apolloStore != null) {
                FolderFieldsImpl folderFieldsImpl = new FolderFieldsImpl();
                c15652.L$0 = SpillingKt.nullOutSpilledVariable(cacheKey);
                c15652.label = 1;
                fragment$default = ApolloStore.DefaultImpls.readFragment$default(apolloStore, folderFieldsImpl, cacheKey, null, null, c15652, 12, null);
                if (fragment$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                folderFields = null;
            }
            GQLEdgeHelper gQLEdgeHelper = GQLEdgeHelper.INSTANCE;
            if (folderFields != null) {
                id = folderFields.getId();
            } else {
                id = null;
            }
            if (id == null) {
                id = "";
            }
            return new ItemConnectionFragment.Edge(gQLEdgeHelper.constructEdgeId(id, TypenameMapperKt.toGQLTypename(ItemType.FOLDER)), new ItemConnectionFragment.Node(TypenameMapperKt.toGQLTypename(ItemType.FOLDER), null, folderFields, null));
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(fragment$default);
        folderFields = (FolderFields) fragment$default;
        GQLEdgeHelper gQLEdgeHelper2 = GQLEdgeHelper.INSTANCE;
        if (folderFields != null) {
            id = folderFields.getId();
        } else {
            id = null;
        }
        if (id == null) {
            id = "";
        }
        return new ItemConnectionFragment.Edge(gQLEdgeHelper2.constructEdgeId(id, TypenameMapperKt.toGQLTypename(ItemType.FOLDER)), new ItemConnectionFragment.Node(TypenameMapperKt.toGQLTypename(ItemType.FOLDER), null, folderFields, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    /* JADX WARN: Code duplicated, block: B:24:0x006f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0072  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlReadWeblinkEdgeFromCache(CacheKey cacheKey, Continuation<? super ItemConnectionFragment.Edge> continuation) {
        C15661 c15661;
        WeblinkFields weblinkFields;
        String id;
        if (continuation instanceof C15661) {
            c15661 = (C15661) continuation;
            if ((c15661.label & Integer.MIN_VALUE) != 0) {
                c15661.label -= Integer.MIN_VALUE;
            } else {
                c15661 = new C15661(continuation);
            }
        } else {
            c15661 = new C15661(continuation);
        }
        C15661 c15662 = c15661;
        Object fragment$default = c15662.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15662.label;
        if (i == 0) {
            ResultKt.throwOnFailure(fragment$default);
            ApolloStore apolloStore = this.gqlCache.getApolloStore();
            if (apolloStore != null) {
                WeblinkFieldsImpl weblinkFieldsImpl = new WeblinkFieldsImpl();
                c15662.L$0 = SpillingKt.nullOutSpilledVariable(cacheKey);
                c15662.label = 1;
                fragment$default = ApolloStore.DefaultImpls.readFragment$default(apolloStore, weblinkFieldsImpl, cacheKey, null, null, c15662, 12, null);
                if (fragment$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                weblinkFields = null;
            }
            GQLEdgeHelper gQLEdgeHelper = GQLEdgeHelper.INSTANCE;
            if (weblinkFields != null) {
                id = weblinkFields.getId();
            } else {
                id = null;
            }
            if (id == null) {
                id = "";
            }
            return new ItemConnectionFragment.Edge(gQLEdgeHelper.constructEdgeId(id, TypenameMapperKt.toGQLTypename(ItemType.WEBLINK)), new ItemConnectionFragment.Node(TypenameMapperKt.toGQLTypename(ItemType.WEBLINK), null, null, weblinkFields));
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(fragment$default);
        weblinkFields = (WeblinkFields) fragment$default;
        GQLEdgeHelper gQLEdgeHelper2 = GQLEdgeHelper.INSTANCE;
        if (weblinkFields != null) {
            id = weblinkFields.getId();
        } else {
            id = null;
        }
        if (id == null) {
            id = "";
        }
        return new ItemConnectionFragment.Edge(gQLEdgeHelper2.constructEdgeId(id, TypenameMapperKt.toGQLTypename(ItemType.WEBLINK)), new ItemConnectionFragment.Node(TypenameMapperKt.toGQLTypename(ItemType.WEBLINK), null, null, weblinkFields));
    }

    /* JADX WARN: Code duplicated, block: B:105:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:134:0x0251 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x0288 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x0212  */
    /* JADX WARN: Code duplicated, block: B:69:0x023e A[Catch: all -> 0x010e, ApolloException -> 0x0111, CacheMissException -> 0x0116, TryCatch #12 {CacheMissException -> 0x0116, ApolloException -> 0x0111, all -> 0x010e, blocks: (B:92:0x0348, B:33:0x0100, B:66:0x0227, B:67:0x0238, B:69:0x023e, B:71:0x024e, B:73:0x0254, B:74:0x026f, B:76:0x0275, B:78:0x0285, B:80:0x028b, B:81:0x02a4, B:83:0x02aa, B:84:0x02c5, B:85:0x02cb, B:87:0x02d1, B:88:0x02e8), top: B:128:0x0100 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x024e A[Catch: all -> 0x010e, ApolloException -> 0x0111, CacheMissException -> 0x0116, TryCatch #12 {CacheMissException -> 0x0116, ApolloException -> 0x0111, all -> 0x010e, blocks: (B:92:0x0348, B:33:0x0100, B:66:0x0227, B:67:0x0238, B:69:0x023e, B:71:0x024e, B:73:0x0254, B:74:0x026f, B:76:0x0275, B:78:0x0285, B:80:0x028b, B:81:0x02a4, B:83:0x02aa, B:84:0x02c5, B:85:0x02cb, B:87:0x02d1, B:88:0x02e8), top: B:128:0x0100 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0275 A[Catch: all -> 0x010e, ApolloException -> 0x0111, CacheMissException -> 0x0116, TryCatch #12 {CacheMissException -> 0x0116, ApolloException -> 0x0111, all -> 0x010e, blocks: (B:92:0x0348, B:33:0x0100, B:66:0x0227, B:67:0x0238, B:69:0x023e, B:71:0x024e, B:73:0x0254, B:74:0x026f, B:76:0x0275, B:78:0x0285, B:80:0x028b, B:81:0x02a4, B:83:0x02aa, B:84:0x02c5, B:85:0x02cb, B:87:0x02d1, B:88:0x02e8), top: B:128:0x0100 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0285 A[Catch: all -> 0x010e, ApolloException -> 0x0111, CacheMissException -> 0x0116, TryCatch #12 {CacheMissException -> 0x0116, ApolloException -> 0x0111, all -> 0x010e, blocks: (B:92:0x0348, B:33:0x0100, B:66:0x0227, B:67:0x0238, B:69:0x023e, B:71:0x024e, B:73:0x0254, B:74:0x026f, B:76:0x0275, B:78:0x0285, B:80:0x028b, B:81:0x02a4, B:83:0x02aa, B:84:0x02c5, B:85:0x02cb, B:87:0x02d1, B:88:0x02e8), top: B:128:0x0100 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:83:0x02aa A[Catch: all -> 0x010e, ApolloException -> 0x0111, CacheMissException -> 0x0116, LOOP:2: B:81:0x02a4->B:83:0x02aa, LOOP_END, TryCatch #12 {CacheMissException -> 0x0116, ApolloException -> 0x0111, all -> 0x010e, blocks: (B:92:0x0348, B:33:0x0100, B:66:0x0227, B:67:0x0238, B:69:0x023e, B:71:0x024e, B:73:0x0254, B:74:0x026f, B:76:0x0275, B:78:0x0285, B:80:0x028b, B:81:0x02a4, B:83:0x02aa, B:84:0x02c5, B:85:0x02cb, B:87:0x02d1, B:88:0x02e8), top: B:128:0x0100 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x02d1 A[Catch: all -> 0x010e, ApolloException -> 0x0111, CacheMissException -> 0x0116, LOOP:3: B:85:0x02cb->B:87:0x02d1, LOOP_END, TryCatch #12 {CacheMissException -> 0x0116, ApolloException -> 0x0111, all -> 0x010e, blocks: (B:92:0x0348, B:33:0x0100, B:66:0x0227, B:67:0x0238, B:69:0x023e, B:71:0x024e, B:73:0x0254, B:74:0x026f, B:76:0x0275, B:78:0x0285, B:80:0x028b, B:81:0x02a4, B:83:0x02aa, B:84:0x02c5, B:85:0x02cb, B:87:0x02d1, B:88:0x02e8), top: B:128:0x0100 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x033c  */
    /* JADX WARN: Code duplicated, block: B:91:0x033d  */
    /* JADX WARN: Code duplicated, block: B:95:0x03ac  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v16, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public final Object gqlUpdateEdgesInCache(String str, List<ItemConnectionFragment.Edge> list, Continuation<? super Unit> continuation) throws Throwable {
        C15701 c15701;
        Mutex mutex;
        String str2;
        List<ItemConnectionFragment.Edge> list2;
        GQLCache gQLCache;
        int i;
        int i2;
        ApolloStore apolloStore;
        Mutex mutex2;
        String str3;
        Mutex mutex3;
        List<ItemConnectionFragment.Edge> list3;
        int i3;
        int i4;
        int i5;
        String str4;
        ApolloStore apolloStore2;
        Object objGqlFetchEdgesOnlyFromCache;
        int i6;
        Object obj;
        int i7;
        int i8;
        int i9;
        int i10;
        String str5;
        ApolloStore apolloStore3;
        ApolloStore apolloStore4;
        Mutex mutex4;
        GQLCache gQLCache2;
        List<ItemConnectionFragment.Edge> list4;
        ArrayList arrayList;
        ApolloStore apolloStore5;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Iterator it;
        List list5;
        LinkedHashMap linkedHashMap;
        Iterator it2;
        ApolloStore apolloStore6;
        Iterator it3;
        Set set;
        List list6;
        Set set2;
        List<ItemConnectionFragment.Edge> list7;
        ApolloStore apolloStore7;
        String str6;
        ApolloStore apolloStore8;
        List list8;
        Object next;
        if (continuation instanceof C15701) {
            c15701 = (C15701) continuation;
            if ((c15701.label & Integer.MIN_VALUE) != 0) {
                c15701.label -= Integer.MIN_VALUE;
            } else {
                c15701 = new C15701(continuation);
            }
        } else {
            c15701 = new C15701(continuation);
        }
        Object objGqlDeleteItemRowFromCache = c15701.result;
        ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = c15701.label;
        int i12 = 0;
        try {
            try {
                if (i11 == 0) {
                    ResultKt.throwOnFailure(objGqlDeleteItemRowFromCache);
                    GQLCache gQLCache3 = this.gqlCache;
                    mutex = gQLCache3.getMutex();
                    str2 = str;
                    c15701.L$0 = str2;
                    list2 = list;
                    c15701.L$1 = list2;
                    c15701.L$2 = gQLCache3;
                    c15701.L$3 = mutex;
                    c15701.I$0 = 0;
                    c15701.I$1 = 0;
                    c15701.label = 1;
                    if (mutex.lock(null, c15701) != coroutine_suspended) {
                        gQLCache = gQLCache3;
                        i = 0;
                        i2 = 0;
                    }
                    return coroutine_suspended;
                }
                if (i11 == 1) {
                    i = c15701.I$1;
                    int i13 = c15701.I$0;
                    Mutex mutex5 = (Mutex) c15701.L$3;
                    GQLCache gQLCache4 = (GQLCache) c15701.L$2;
                    List<ItemConnectionFragment.Edge> list9 = (List) c15701.L$1;
                    String str7 = (String) c15701.L$0;
                    ResultKt.throwOnFailure(objGqlDeleteItemRowFromCache);
                    gQLCache = gQLCache4;
                    list2 = list9;
                    i2 = i13;
                    mutex = mutex5;
                    str2 = str7;
                } else if (i11 == 2) {
                    int i14 = c15701.I$4;
                    int i15 = c15701.I$3;
                    int i16 = c15701.I$2;
                    int i17 = c15701.I$1;
                    i3 = c15701.I$0;
                    str4 = (String) c15701.L$6;
                    apolloStore = (ApolloStore) c15701.L$5;
                    apolloStore2 = (ApolloStore) c15701.L$4;
                    mutex3 = (Mutex) c15701.L$3;
                    gQLCache = (GQLCache) c15701.L$2;
                    list3 = (List) c15701.L$1;
                    String str8 = (String) c15701.L$0;
                    try {
                        try {
                            ResultKt.throwOnFailure(objGqlDeleteItemRowFromCache);
                            i4 = i15;
                            i = i17;
                            str2 = str8;
                            i5 = i14;
                            i12 = i16;
                            try {
                                c15701.L$0 = str2;
                                c15701.L$1 = list3;
                                c15701.L$2 = SpillingKt.nullOutSpilledVariable(gQLCache);
                                c15701.L$3 = mutex3;
                                c15701.L$4 = SpillingKt.nullOutSpilledVariable(apolloStore2);
                                c15701.L$5 = SpillingKt.nullOutSpilledVariable(apolloStore);
                                c15701.L$6 = str4;
                                c15701.I$0 = i3;
                                c15701.I$1 = i;
                                c15701.I$2 = i12;
                                c15701.I$3 = i4;
                                c15701.I$4 = i5;
                                c15701.label = 3;
                                objGqlFetchEdgesOnlyFromCache = gqlFetchEdgesOnlyFromCache(str2, c15701);
                                if (objGqlFetchEdgesOnlyFromCache != coroutine_suspended) {
                                    int i18 = i3;
                                    i6 = i;
                                    obj = objGqlFetchEdgesOnlyFromCache;
                                    i7 = i12;
                                    i8 = i18;
                                    int i19 = i5;
                                    i9 = i4;
                                    i10 = i19;
                                    List<ItemConnectionFragment.Edge> list10 = list3;
                                    str5 = str2;
                                    apolloStore3 = apolloStore;
                                    apolloStore4 = apolloStore2;
                                    mutex4 = mutex3;
                                    gQLCache2 = gQLCache;
                                    list4 = list10;
                                    Iterable iterable = (Iterable) obj;
                                    arrayList = new ArrayList();
                                    for (Object obj2 : iterable) {
                                        ApolloStore apolloStore9 = apolloStore3;
                                        if (((ItemConnectionEdgesOnlyFragment.Edge) obj2).getId() != null) {
                                            arrayList.add(obj2);
                                        }
                                        apolloStore3 = apolloStore9;
                                    }
                                    apolloStore5 = apolloStore3;
                                    arrayList2 = arrayList;
                                    List<ItemConnectionEdgesOnlyFragment.Edge> listConvert = ItemConnectionEdgesToItemConnectionEdgesOnlyMapper.INSTANCE.convert(list4);
                                    arrayList3 = new ArrayList();
                                    it = listConvert.iterator();
                                    while (it.hasNext()) {
                                        Iterator it4 = it;
                                        next = it4.next();
                                        if (((ItemConnectionEdgesOnlyFragment.Edge) next).getId() != null) {
                                            arrayList3.add(next);
                                        }
                                        it = it4;
                                    }
                                    ArrayList arrayList4 = arrayList3;
                                    ArrayList arrayList5 = arrayList2;
                                    ArrayList arrayList6 = arrayList4;
                                    list5 = arrayList4;
                                    linkedHashMap = new LinkedHashMap();
                                    it2 = arrayList5.iterator();
                                    while (it2.hasNext()) {
                                        Iterator it5 = it2;
                                        Object next2 = it5.next();
                                        ApolloStore apolloStore10 = apolloStore4;
                                        String id = ((ItemConnectionEdgesOnlyFragment.Edge) next2).getId();
                                        Intrinsics.checkNotNull(id);
                                        linkedHashMap.put(id, next2);
                                        it2 = it5;
                                        apolloStore4 = apolloStore10;
                                    }
                                    apolloStore6 = apolloStore4;
                                    it3 = arrayList6.iterator();
                                    while (it3.hasNext()) {
                                        Object next3 = it3.next();
                                        Iterator it6 = it3;
                                        String id2 = ((ItemConnectionEdgesOnlyFragment.Edge) next3).getId();
                                        Intrinsics.checkNotNull(id2);
                                        linkedHashMap.put(id2, next3);
                                        it3 = it6;
                                    }
                                    set = CollectionsKt.toSet(linkedHashMap.values());
                                    list6 = CollectionsKt.toList(set);
                                    c15701.L$0 = str5;
                                    c15701.L$1 = SpillingKt.nullOutSpilledVariable(list4);
                                    c15701.L$2 = SpillingKt.nullOutSpilledVariable(gQLCache2);
                                    c15701.L$3 = mutex4;
                                    c15701.L$4 = SpillingKt.nullOutSpilledVariable(apolloStore6);
                                    c15701.L$5 = SpillingKt.nullOutSpilledVariable(apolloStore5);
                                    c15701.L$6 = str4;
                                    c15701.L$7 = SpillingKt.nullOutSpilledVariable(list5);
                                    c15701.L$8 = SpillingKt.nullOutSpilledVariable(set);
                                    c15701.L$9 = SpillingKt.nullOutSpilledVariable(arrayList2);
                                    c15701.I$0 = i8;
                                    c15701.I$1 = i6;
                                    c15701.I$2 = i7;
                                    c15701.I$3 = i9;
                                    c15701.I$4 = i10;
                                    c15701.label = 4;
                                    if (gqlWriteEdgesOnlyToCache(str5, list6, c15701) != coroutine_suspended) {
                                        List<ItemConnectionFragment.Edge> list11 = list4;
                                        set2 = set;
                                        list7 = list11;
                                        apolloStore7 = apolloStore5;
                                        str6 = str4;
                                        apolloStore8 = apolloStore6;
                                        list8 = arrayList2;
                                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                        List<ItemConnectionFragment.Edge> list12 = list7;
                                        String str9 = String.format(GQLCacheConstants.FORMAT_FOLDER_ITEM_CONNECTION_CACHE_KEY, Arrays.copyOf(new Object[]{str6}, 1));
                                        Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                                        c15701.L$0 = str5;
                                        c15701.L$1 = SpillingKt.nullOutSpilledVariable(list12);
                                        c15701.L$2 = SpillingKt.nullOutSpilledVariable(gQLCache2);
                                        c15701.L$3 = mutex4;
                                        c15701.L$4 = SpillingKt.nullOutSpilledVariable(apolloStore8);
                                        c15701.L$5 = SpillingKt.nullOutSpilledVariable(apolloStore7);
                                        c15701.L$6 = SpillingKt.nullOutSpilledVariable(str6);
                                        c15701.L$7 = SpillingKt.nullOutSpilledVariable(list5);
                                        c15701.L$8 = SpillingKt.nullOutSpilledVariable(set2);
                                        c15701.L$9 = SpillingKt.nullOutSpilledVariable(list8);
                                        c15701.I$0 = i8;
                                        c15701.I$1 = i6;
                                        c15701.I$2 = i7;
                                        c15701.I$3 = i9;
                                        c15701.I$4 = i10;
                                        c15701.label = 5;
                                        objGqlDeleteItemRowFromCache = gqlDeleteItemRowFromCache(str9, c15701);
                                        if (objGqlDeleteItemRowFromCache != coroutine_suspended) {
                                            coroutine_suspended = mutex4;
                                            if (objGqlDeleteItemRowFromCache == null) {
                                                coroutine_suspended = coroutine_suspended;
                                                GQLCacheHelper gQLCacheHelper = this;
                                                logCacheError("Error getting ApolloStore instance during updating edges in cache");
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            coroutine_suspended.unlock(null);
                                            return Unit.INSTANCE;
                                        }
                                    }
                                }
                                return coroutine_suspended;
                            } catch (CacheMissException unused) {
                                str3 = str2;
                                mutex2 = mutex3;
                                BoxLogUtils.w(ExtensionsKt.getTAG(this), "Cache miss during edge update for folder " + str3);
                                objGqlDeleteItemRowFromCache = Unit.INSTANCE;
                                coroutine_suspended = mutex2;
                            } catch (ApolloException e) {
                                e = e;
                                str3 = str2;
                                mutex2 = mutex3;
                                logCacheError("Unexpected cache error during edge update for folder " + str3 + ": " + e);
                                objGqlDeleteItemRowFromCache = Unit.INSTANCE;
                                coroutine_suspended = mutex2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            coroutine_suspended = mutex3;
                            coroutine_suspended.unlock(null);
                            throw th;
                        }
                    } catch (CacheMissException unused2) {
                        str3 = str8;
                        mutex2 = mutex3;
                        BoxLogUtils.w(ExtensionsKt.getTAG(this), "Cache miss during edge update for folder " + str3);
                        objGqlDeleteItemRowFromCache = Unit.INSTANCE;
                        coroutine_suspended = mutex2;
                        if (objGqlDeleteItemRowFromCache == null) {
                            coroutine_suspended = coroutine_suspended;
                            GQLCacheHelper gQLCacheHelper2 = this;
                            logCacheError("Error getting ApolloStore instance during updating edges in cache");
                            Unit unit2 = Unit.INSTANCE;
                        }
                        coroutine_suspended.unlock(null);
                        return Unit.INSTANCE;
                    } catch (ApolloException e2) {
                        e = e2;
                        str3 = str8;
                        mutex2 = mutex3;
                        logCacheError("Unexpected cache error during edge update for folder " + str3 + ": " + e);
                        objGqlDeleteItemRowFromCache = Unit.INSTANCE;
                        coroutine_suspended = mutex2;
                        if (objGqlDeleteItemRowFromCache == null) {
                            coroutine_suspended = coroutine_suspended;
                            GQLCacheHelper gQLCacheHelper3 = this;
                            logCacheError("Error getting ApolloStore instance during updating edges in cache");
                            Unit unit3 = Unit.INSTANCE;
                        }
                        coroutine_suspended.unlock(null);
                        return Unit.INSTANCE;
                    }
                } else if (i11 == 3) {
                    int i20 = c15701.I$4;
                    int i21 = c15701.I$3;
                    int i22 = c15701.I$2;
                    int i23 = c15701.I$1;
                    int i24 = c15701.I$0;
                    str4 = (String) c15701.L$6;
                    ApolloStore apolloStore11 = (ApolloStore) c15701.L$5;
                    apolloStore4 = (ApolloStore) c15701.L$4;
                    mutex4 = (Mutex) c15701.L$3;
                    gQLCache2 = (GQLCache) c15701.L$2;
                    list4 = (List) c15701.L$1;
                    str5 = (String) c15701.L$0;
                    try {
                        ResultKt.throwOnFailure(objGqlDeleteItemRowFromCache);
                        i7 = i22;
                        apolloStore3 = apolloStore11;
                        i8 = i24;
                        i6 = i23;
                        i9 = i21;
                        i10 = i20;
                        obj = objGqlDeleteItemRowFromCache;
                        Iterable iterable2 = (Iterable) obj;
                        arrayList = new ArrayList();
                        while (r16.hasNext()) {
                            ApolloStore apolloStore12 = apolloStore3;
                            if (((ItemConnectionEdgesOnlyFragment.Edge) obj2).getId() != null) {
                                arrayList.add(obj2);
                            }
                            apolloStore3 = apolloStore12;
                        }
                        apolloStore5 = apolloStore3;
                        arrayList2 = arrayList;
                        List<ItemConnectionEdgesOnlyFragment.Edge> listConvert2 = ItemConnectionEdgesToItemConnectionEdgesOnlyMapper.INSTANCE.convert(list4);
                        arrayList3 = new ArrayList();
                        it = listConvert2.iterator();
                        while (it.hasNext()) {
                            Iterator it7 = it;
                            next = it7.next();
                            if (((ItemConnectionEdgesOnlyFragment.Edge) next).getId() != null) {
                                arrayList3.add(next);
                            }
                            it = it7;
                        }
                        ArrayList arrayList7 = arrayList3;
                        ArrayList arrayList8 = arrayList2;
                        ArrayList arrayList9 = arrayList7;
                        list5 = arrayList7;
                        linkedHashMap = new LinkedHashMap();
                        it2 = arrayList8.iterator();
                        while (it2.hasNext()) {
                            Iterator it8 = it2;
                            Object next4 = it8.next();
                            ApolloStore apolloStore13 = apolloStore4;
                            String id3 = ((ItemConnectionEdgesOnlyFragment.Edge) next4).getId();
                            Intrinsics.checkNotNull(id3);
                            linkedHashMap.put(id3, next4);
                            it2 = it8;
                            apolloStore4 = apolloStore13;
                        }
                        apolloStore6 = apolloStore4;
                        it3 = arrayList9.iterator();
                        while (it3.hasNext()) {
                            Object next5 = it3.next();
                            Iterator it9 = it3;
                            String id4 = ((ItemConnectionEdgesOnlyFragment.Edge) next5).getId();
                            Intrinsics.checkNotNull(id4);
                            linkedHashMap.put(id4, next5);
                            it3 = it9;
                        }
                        set = CollectionsKt.toSet(linkedHashMap.values());
                        list6 = CollectionsKt.toList(set);
                        c15701.L$0 = str5;
                        c15701.L$1 = SpillingKt.nullOutSpilledVariable(list4);
                        c15701.L$2 = SpillingKt.nullOutSpilledVariable(gQLCache2);
                        c15701.L$3 = mutex4;
                        c15701.L$4 = SpillingKt.nullOutSpilledVariable(apolloStore6);
                        c15701.L$5 = SpillingKt.nullOutSpilledVariable(apolloStore5);
                        c15701.L$6 = str4;
                        c15701.L$7 = SpillingKt.nullOutSpilledVariable(list5);
                        c15701.L$8 = SpillingKt.nullOutSpilledVariable(set);
                        c15701.L$9 = SpillingKt.nullOutSpilledVariable(arrayList2);
                        c15701.I$0 = i8;
                        c15701.I$1 = i6;
                        c15701.I$2 = i7;
                        c15701.I$3 = i9;
                        c15701.I$4 = i10;
                        c15701.label = 4;
                        if (gqlWriteEdgesOnlyToCache(str5, list6, c15701) != coroutine_suspended) {
                            List<ItemConnectionFragment.Edge> list13 = list4;
                            set2 = set;
                            list7 = list13;
                            apolloStore7 = apolloStore5;
                            str6 = str4;
                            apolloStore8 = apolloStore6;
                            list8 = arrayList2;
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                            List<ItemConnectionFragment.Edge> list14 = list7;
                            String str10 = String.format(GQLCacheConstants.FORMAT_FOLDER_ITEM_CONNECTION_CACHE_KEY, Arrays.copyOf(new Object[]{str6}, 1));
                            Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                            c15701.L$0 = str5;
                            c15701.L$1 = SpillingKt.nullOutSpilledVariable(list14);
                            c15701.L$2 = SpillingKt.nullOutSpilledVariable(gQLCache2);
                            c15701.L$3 = mutex4;
                            c15701.L$4 = SpillingKt.nullOutSpilledVariable(apolloStore8);
                            c15701.L$5 = SpillingKt.nullOutSpilledVariable(apolloStore7);
                            c15701.L$6 = SpillingKt.nullOutSpilledVariable(str6);
                            c15701.L$7 = SpillingKt.nullOutSpilledVariable(list5);
                            c15701.L$8 = SpillingKt.nullOutSpilledVariable(set2);
                            c15701.L$9 = SpillingKt.nullOutSpilledVariable(list8);
                            c15701.I$0 = i8;
                            c15701.I$1 = i6;
                            c15701.I$2 = i7;
                            c15701.I$3 = i9;
                            c15701.I$4 = i10;
                            c15701.label = 5;
                            objGqlDeleteItemRowFromCache = gqlDeleteItemRowFromCache(str10, c15701);
                            if (objGqlDeleteItemRowFromCache != coroutine_suspended) {
                                coroutine_suspended = mutex4;
                                if (objGqlDeleteItemRowFromCache == null) {
                                    coroutine_suspended = coroutine_suspended;
                                    GQLCacheHelper gQLCacheHelper4 = this;
                                    logCacheError("Error getting ApolloStore instance during updating edges in cache");
                                    Unit unit4 = Unit.INSTANCE;
                                }
                                coroutine_suspended.unlock(null);
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutine_suspended;
                    } catch (CacheMissException unused3) {
                        mutex2 = mutex4;
                        str3 = str5;
                        BoxLogUtils.w(ExtensionsKt.getTAG(this), "Cache miss during edge update for folder " + str3);
                        objGqlDeleteItemRowFromCache = Unit.INSTANCE;
                        coroutine_suspended = mutex2;
                    } catch (ApolloException e3) {
                        e = e3;
                        mutex2 = mutex4;
                        str3 = str5;
                        logCacheError("Unexpected cache error during edge update for folder " + str3 + ": " + e);
                        objGqlDeleteItemRowFromCache = Unit.INSTANCE;
                        coroutine_suspended = mutex2;
                    } catch (Throwable th2) {
                        th = th2;
                        coroutine_suspended = mutex4;
                        coroutine_suspended.unlock(null);
                        throw th;
                    }
                } else {
                    if (i11 == 4) {
                        i10 = c15701.I$4;
                        i9 = c15701.I$3;
                        i7 = c15701.I$2;
                        i6 = c15701.I$1;
                        i8 = c15701.I$0;
                        List list15 = (List) c15701.L$9;
                        Set set3 = (Set) c15701.L$8;
                        List list16 = (List) c15701.L$7;
                        String str11 = (String) c15701.L$6;
                        apolloStore7 = (ApolloStore) c15701.L$5;
                        apolloStore8 = (ApolloStore) c15701.L$4;
                        Mutex mutex6 = (Mutex) c15701.L$3;
                        GQLCache gQLCache5 = (GQLCache) c15701.L$2;
                        List<ItemConnectionFragment.Edge> list17 = (List) c15701.L$1;
                        String str12 = (String) c15701.L$0;
                        try {
                            ResultKt.throwOnFailure(objGqlDeleteItemRowFromCache);
                            mutex4 = mutex6;
                            list8 = list15;
                            list7 = list17;
                            list5 = list16;
                            str6 = str11;
                            str5 = str12;
                            set2 = set3;
                            gQLCache2 = gQLCache5;
                            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                            List<ItemConnectionFragment.Edge> list18 = list7;
                            String str13 = String.format(GQLCacheConstants.FORMAT_FOLDER_ITEM_CONNECTION_CACHE_KEY, Arrays.copyOf(new Object[]{str6}, 1));
                            Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                            c15701.L$0 = str5;
                            c15701.L$1 = SpillingKt.nullOutSpilledVariable(list18);
                            c15701.L$2 = SpillingKt.nullOutSpilledVariable(gQLCache2);
                            c15701.L$3 = mutex4;
                            c15701.L$4 = SpillingKt.nullOutSpilledVariable(apolloStore8);
                            c15701.L$5 = SpillingKt.nullOutSpilledVariable(apolloStore7);
                            c15701.L$6 = SpillingKt.nullOutSpilledVariable(str6);
                            c15701.L$7 = SpillingKt.nullOutSpilledVariable(list5);
                            c15701.L$8 = SpillingKt.nullOutSpilledVariable(set2);
                            c15701.L$9 = SpillingKt.nullOutSpilledVariable(list8);
                            c15701.I$0 = i8;
                            c15701.I$1 = i6;
                            c15701.I$2 = i7;
                            c15701.I$3 = i9;
                            c15701.I$4 = i10;
                            c15701.label = 5;
                            objGqlDeleteItemRowFromCache = gqlDeleteItemRowFromCache(str13, c15701);
                            if (objGqlDeleteItemRowFromCache != coroutine_suspended) {
                                coroutine_suspended = mutex4;
                            }
                            return coroutine_suspended;
                        } catch (CacheMissException unused4) {
                            mutex2 = mutex6;
                            str3 = str12;
                            BoxLogUtils.w(ExtensionsKt.getTAG(this), "Cache miss during edge update for folder " + str3);
                            objGqlDeleteItemRowFromCache = Unit.INSTANCE;
                            coroutine_suspended = mutex2;
                        } catch (ApolloException e4) {
                            e = e4;
                            mutex2 = mutex6;
                            str3 = str12;
                            logCacheError("Unexpected cache error during edge update for folder " + str3 + ": " + e);
                            objGqlDeleteItemRowFromCache = Unit.INSTANCE;
                            coroutine_suspended = mutex2;
                        } catch (Throwable th3) {
                            th = th3;
                            coroutine_suspended = mutex6;
                            coroutine_suspended.unlock(null);
                            throw th;
                        }
                    } else {
                        if (i11 != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i25 = c15701.I$4;
                        int i26 = c15701.I$3;
                        int i27 = c15701.I$2;
                        int i28 = c15701.I$1;
                        int i29 = c15701.I$0;
                        mutex2 = (Mutex) c15701.L$3;
                        str3 = (String) c15701.L$0;
                        try {
                            ResultKt.throwOnFailure(objGqlDeleteItemRowFromCache);
                            coroutine_suspended = mutex2;
                        } catch (CacheMissException unused5) {
                            BoxLogUtils.w(ExtensionsKt.getTAG(this), "Cache miss during edge update for folder " + str3);
                            objGqlDeleteItemRowFromCache = Unit.INSTANCE;
                            coroutine_suspended = mutex2;
                        } catch (ApolloException e5) {
                            e = e5;
                            logCacheError("Unexpected cache error during edge update for folder " + str3 + ": " + e);
                            objGqlDeleteItemRowFromCache = Unit.INSTANCE;
                            coroutine_suspended = mutex2;
                        }
                    }
                    if (objGqlDeleteItemRowFromCache == null) {
                        coroutine_suspended = coroutine_suspended;
                        GQLCacheHelper gQLCacheHelper5 = this;
                        logCacheError("Error getting ApolloStore instance during updating edges in cache");
                        Unit unit5 = Unit.INSTANCE;
                    }
                    coroutine_suspended.unlock(null);
                    return Unit.INSTANCE;
                }
                apolloStore = gQLCache.getApolloStore();
                if (apolloStore != null) {
                    try {
                        c15701.L$0 = str2;
                        c15701.L$1 = list2;
                        c15701.L$2 = SpillingKt.nullOutSpilledVariable(gQLCache);
                        c15701.L$3 = mutex;
                        c15701.L$4 = SpillingKt.nullOutSpilledVariable(apolloStore);
                        c15701.L$5 = SpillingKt.nullOutSpilledVariable(apolloStore);
                        c15701.L$6 = GQLCacheConstants.ID_TEMP_KEY;
                        c15701.I$0 = i2;
                        c15701.I$1 = i;
                        c15701.I$2 = 0;
                        c15701.I$3 = 0;
                        c15701.I$4 = 0;
                        c15701.label = 2;
                        if (gqlWriteItemConnectionFragmentToCache(GQLCacheConstants.ID_TEMP_KEY, list2, c15701) != coroutine_suspended) {
                            mutex3 = mutex;
                            list3 = list2;
                            i3 = i2;
                            i4 = 0;
                            i5 = 0;
                            str4 = GQLCacheConstants.ID_TEMP_KEY;
                            apolloStore2 = apolloStore;
                            c15701.L$0 = str2;
                            c15701.L$1 = list3;
                            c15701.L$2 = SpillingKt.nullOutSpilledVariable(gQLCache);
                            c15701.L$3 = mutex3;
                            c15701.L$4 = SpillingKt.nullOutSpilledVariable(apolloStore2);
                            c15701.L$5 = SpillingKt.nullOutSpilledVariable(apolloStore);
                            c15701.L$6 = str4;
                            c15701.I$0 = i3;
                            c15701.I$1 = i;
                            c15701.I$2 = i12;
                            c15701.I$3 = i4;
                            c15701.I$4 = i5;
                            c15701.label = 3;
                            objGqlFetchEdgesOnlyFromCache = gqlFetchEdgesOnlyFromCache(str2, c15701);
                            if (objGqlFetchEdgesOnlyFromCache != coroutine_suspended) {
                                int i110 = i3;
                                i6 = i;
                                obj = objGqlFetchEdgesOnlyFromCache;
                                i7 = i12;
                                i8 = i110;
                                int i111 = i5;
                                i9 = i4;
                                i10 = i111;
                                List<ItemConnectionFragment.Edge> list19 = list3;
                                str5 = str2;
                                apolloStore3 = apolloStore;
                                apolloStore4 = apolloStore2;
                                mutex4 = mutex3;
                                gQLCache2 = gQLCache;
                                list4 = list19;
                                Iterable iterable3 = (Iterable) obj;
                                arrayList = new ArrayList();
                                while (r16.hasNext()) {
                                    ApolloStore apolloStore14 = apolloStore3;
                                    if (((ItemConnectionEdgesOnlyFragment.Edge) obj2).getId() != null) {
                                        arrayList.add(obj2);
                                    }
                                    apolloStore3 = apolloStore14;
                                }
                                apolloStore5 = apolloStore3;
                                arrayList2 = arrayList;
                                List<ItemConnectionEdgesOnlyFragment.Edge> listConvert3 = ItemConnectionEdgesToItemConnectionEdgesOnlyMapper.INSTANCE.convert(list4);
                                arrayList3 = new ArrayList();
                                it = listConvert3.iterator();
                                while (it.hasNext()) {
                                    Iterator it10 = it;
                                    next = it10.next();
                                    if (((ItemConnectionEdgesOnlyFragment.Edge) next).getId() != null) {
                                        arrayList3.add(next);
                                    }
                                    it = it10;
                                }
                                ArrayList arrayList10 = arrayList3;
                                ArrayList arrayList11 = arrayList2;
                                ArrayList arrayList12 = arrayList10;
                                list5 = arrayList10;
                                linkedHashMap = new LinkedHashMap();
                                it2 = arrayList11.iterator();
                                while (it2.hasNext()) {
                                    Iterator it11 = it2;
                                    Object next6 = it11.next();
                                    ApolloStore apolloStore15 = apolloStore4;
                                    String id5 = ((ItemConnectionEdgesOnlyFragment.Edge) next6).getId();
                                    Intrinsics.checkNotNull(id5);
                                    linkedHashMap.put(id5, next6);
                                    it2 = it11;
                                    apolloStore4 = apolloStore15;
                                }
                                apolloStore6 = apolloStore4;
                                it3 = arrayList12.iterator();
                                while (it3.hasNext()) {
                                    Object next7 = it3.next();
                                    Iterator it12 = it3;
                                    String id6 = ((ItemConnectionEdgesOnlyFragment.Edge) next7).getId();
                                    Intrinsics.checkNotNull(id6);
                                    linkedHashMap.put(id6, next7);
                                    it3 = it12;
                                }
                                set = CollectionsKt.toSet(linkedHashMap.values());
                                list6 = CollectionsKt.toList(set);
                                c15701.L$0 = str5;
                                c15701.L$1 = SpillingKt.nullOutSpilledVariable(list4);
                                c15701.L$2 = SpillingKt.nullOutSpilledVariable(gQLCache2);
                                c15701.L$3 = mutex4;
                                c15701.L$4 = SpillingKt.nullOutSpilledVariable(apolloStore6);
                                c15701.L$5 = SpillingKt.nullOutSpilledVariable(apolloStore5);
                                c15701.L$6 = str4;
                                c15701.L$7 = SpillingKt.nullOutSpilledVariable(list5);
                                c15701.L$8 = SpillingKt.nullOutSpilledVariable(set);
                                c15701.L$9 = SpillingKt.nullOutSpilledVariable(arrayList2);
                                c15701.I$0 = i8;
                                c15701.I$1 = i6;
                                c15701.I$2 = i7;
                                c15701.I$3 = i9;
                                c15701.I$4 = i10;
                                c15701.label = 4;
                                if (gqlWriteEdgesOnlyToCache(str5, list6, c15701) != coroutine_suspended) {
                                    List<ItemConnectionFragment.Edge> list110 = list4;
                                    set2 = set;
                                    list7 = list110;
                                    apolloStore7 = apolloStore5;
                                    str6 = str4;
                                    apolloStore8 = apolloStore6;
                                    list8 = arrayList2;
                                    StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                                    List<ItemConnectionFragment.Edge> list111 = list7;
                                    String str14 = String.format(GQLCacheConstants.FORMAT_FOLDER_ITEM_CONNECTION_CACHE_KEY, Arrays.copyOf(new Object[]{str6}, 1));
                                    Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
                                    c15701.L$0 = str5;
                                    c15701.L$1 = SpillingKt.nullOutSpilledVariable(list111);
                                    c15701.L$2 = SpillingKt.nullOutSpilledVariable(gQLCache2);
                                    c15701.L$3 = mutex4;
                                    c15701.L$4 = SpillingKt.nullOutSpilledVariable(apolloStore8);
                                    c15701.L$5 = SpillingKt.nullOutSpilledVariable(apolloStore7);
                                    c15701.L$6 = SpillingKt.nullOutSpilledVariable(str6);
                                    c15701.L$7 = SpillingKt.nullOutSpilledVariable(list5);
                                    c15701.L$8 = SpillingKt.nullOutSpilledVariable(set2);
                                    c15701.L$9 = SpillingKt.nullOutSpilledVariable(list8);
                                    c15701.I$0 = i8;
                                    c15701.I$1 = i6;
                                    c15701.I$2 = i7;
                                    c15701.I$3 = i9;
                                    c15701.I$4 = i10;
                                    c15701.label = 5;
                                    objGqlDeleteItemRowFromCache = gqlDeleteItemRowFromCache(str14, c15701);
                                    if (objGqlDeleteItemRowFromCache != coroutine_suspended) {
                                        coroutine_suspended = mutex4;
                                        if (objGqlDeleteItemRowFromCache == null) {
                                            coroutine_suspended = coroutine_suspended;
                                        }
                                        coroutine_suspended.unlock(null);
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    } catch (CacheMissException unused6) {
                        mutex2 = mutex;
                        str3 = str2;
                        BoxLogUtils.w(ExtensionsKt.getTAG(this), "Cache miss during edge update for folder " + str3);
                        objGqlDeleteItemRowFromCache = Unit.INSTANCE;
                        coroutine_suspended = mutex2;
                    } catch (ApolloException e6) {
                        e = e6;
                        mutex2 = mutex;
                        str3 = str2;
                        logCacheError("Unexpected cache error during edge update for folder " + str3 + ": " + e);
                        objGqlDeleteItemRowFromCache = Unit.INSTANCE;
                        coroutine_suspended = mutex2;
                    }
                } else {
                    coroutine_suspended = mutex;
                }
                GQLCacheHelper gQLCacheHelper6 = this;
                logCacheError("Error getting ApolloStore instance during updating edges in cache");
                Unit unit6 = Unit.INSTANCE;
                coroutine_suspended.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th4) {
                th = th4;
                coroutine_suspended = mutex;
                coroutine_suspended.unlock(null);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlFetchEdgesFromCache(String str, Continuation<? super List<ItemConnectionFragment.Edge>> continuation) {
        C15621 c15621;
        List<ItemConnectionFragment.Edge> listEmptyList;
        GetFolderItemsQuery.ItemConnection itemConnection;
        ItemConnectionFragment itemConnectionFragment;
        if (continuation instanceof C15621) {
            c15621 = (C15621) continuation;
            if ((c15621.label & Integer.MIN_VALUE) != 0) {
                c15621.label -= Integer.MIN_VALUE;
            } else {
                c15621 = new C15621(continuation);
            }
        } else {
            c15621 = new C15621(continuation);
        }
        C15621 c15622 = c15621;
        Object operation$default = c15622.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15622.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(operation$default);
                ApolloStore apolloStore = this.gqlCache.getApolloStore();
                if (apolloStore != null) {
                    GetFolderItemsQuery getFolderItemsQuery = new GetFolderItemsQuery(str);
                    c15622.L$0 = str;
                    c15622.L$1 = SpillingKt.nullOutSpilledVariable(apolloStore);
                    c15622.I$0 = 0;
                    c15622.label = 1;
                    operation$default = ApolloStore.DefaultImpls.readOperation$default(apolloStore, getFolderItemsQuery, null, null, c15622, 6, null);
                    if (operation$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                logCacheError("Error getting ApolloStore instance during fetching edges from cache");
                return CollectionsKt.emptyList();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c15622.I$0;
            str = (String) c15622.L$0;
            ResultKt.throwOnFailure(operation$default);
            GetFolderItemsQuery.Folder folder = ((GetFolderItemsQuery.Data) operation$default).getFolder();
            if (folder == null || (itemConnection = folder.getItemConnection()) == null || (itemConnectionFragment = itemConnection.getItemConnectionFragment()) == null || (listEmptyList = itemConnectionFragment.getEdges()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
        } catch (CacheMissException unused) {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Cache miss reading edges for folder " + str);
            listEmptyList = CollectionsKt.emptyList();
        } catch (ApolloException e) {
            logCacheError("Unexpected cache error fetching edges for folder " + str + ": " + e);
            listEmptyList = CollectionsKt.emptyList();
        }
        if (listEmptyList != null) {
            return listEmptyList;
        }
        logCacheError("Error getting ApolloStore instance during fetching edges from cache");
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlFetchEdgesOnlyFromCache(String str, Continuation<? super List<ItemConnectionEdgesOnlyFragment.Edge>> continuation) {
        C15631 c15631;
        List<ItemConnectionEdgesOnlyFragment.Edge> listEmptyList;
        GetFolderItemsEdgesOnlyQuery.ItemConnection itemConnection;
        ItemConnectionEdgesOnlyFragment itemConnectionEdgesOnlyFragment;
        if (continuation instanceof C15631) {
            c15631 = (C15631) continuation;
            if ((c15631.label & Integer.MIN_VALUE) != 0) {
                c15631.label -= Integer.MIN_VALUE;
            } else {
                c15631 = new C15631(continuation);
            }
        } else {
            c15631 = new C15631(continuation);
        }
        C15631 c15632 = c15631;
        Object operation$default = c15632.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15632.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(operation$default);
                ApolloStore apolloStore = this.gqlCache.getApolloStore();
                if (apolloStore != null) {
                    GetFolderItemsEdgesOnlyQuery getFolderItemsEdgesOnlyQuery = new GetFolderItemsEdgesOnlyQuery(str);
                    c15632.L$0 = str;
                    c15632.L$1 = SpillingKt.nullOutSpilledVariable(apolloStore);
                    c15632.I$0 = 0;
                    c15632.label = 1;
                    operation$default = ApolloStore.DefaultImpls.readOperation$default(apolloStore, getFolderItemsEdgesOnlyQuery, null, null, c15632, 6, null);
                    if (operation$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                logCacheError("Error getting ApolloStore instance during fetching edges only from cache");
                return CollectionsKt.emptyList();
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c15632.I$0;
            str = (String) c15632.L$0;
            ResultKt.throwOnFailure(operation$default);
            GetFolderItemsEdgesOnlyQuery.Folder folder = ((GetFolderItemsEdgesOnlyQuery.Data) operation$default).getFolder();
            if (folder == null || (itemConnection = folder.getItemConnection()) == null || (itemConnectionEdgesOnlyFragment = itemConnection.getItemConnectionEdgesOnlyFragment()) == null || (listEmptyList = itemConnectionEdgesOnlyFragment.getEdges()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
        } catch (CacheMissException unused) {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Cache miss reading edges-only for folder " + str);
            listEmptyList = CollectionsKt.emptyList();
        } catch (ApolloException e) {
            logCacheError("Unexpected cache error fetching edges-only for folder " + str + ": " + e);
            listEmptyList = CollectionsKt.emptyList();
        }
        if (listEmptyList != null) {
            return listEmptyList;
        }
        logCacheError("Error getting ApolloStore instance during fetching edges only from cache");
        return CollectionsKt.emptyList();
    }

    public final Object gqlWriteEdgesOnlyToCache(String str, List<ItemConnectionEdgesOnlyFragment.Edge> list, Continuation<? super Unit> continuation) {
        ApolloStore apolloStore = this.gqlCache.getApolloStore();
        if (apolloStore != null) {
            Object objWriteOperation$default = ApolloStore.DefaultImpls.writeOperation$default(apolloStore, new GetFolderItemsEdgesOnlyQuery(str), new GetFolderItemsEdgesOnlyQuery.Data(new GetFolderItemsEdgesOnlyQuery.Folder(str, new GetFolderItemsEdgesOnlyQuery.ItemConnection(GQLCacheConstants.TYPENAME_ITEM_CONNECTION, new ItemConnectionEdgesOnlyFragment(list.size(), list)))), null, null, true, continuation, 12, null);
            return objWriteOperation$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteOperation$default : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final Object gqlWriteItemConnectionFragmentToCache(String str, List<ItemConnectionFragment.Edge> list, Continuation<? super Unit> continuation) {
        ApolloStore apolloStore = this.gqlCache.getApolloStore();
        if (apolloStore != null) {
            ItemConnectionFragmentImpl itemConnectionFragmentImpl = new ItemConnectionFragmentImpl();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format(GQLCacheConstants.FORMAT_FOLDER_ITEM_CONNECTION_CACHE_KEY, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            Object objWriteFragment$default = ApolloStore.DefaultImpls.writeFragment$default(apolloStore, itemConnectionFragmentImpl, new CacheKey(str2), new ItemConnectionFragment(list.size(), list), null, null, true, continuation, 24, null);
            return objWriteFragment$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteFragment$default : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlDeleteItemRowFromCache(String str, String str2, Continuation<? super Boolean> continuation) {
        C15611 c15611;
        boolean zBooleanValue;
        if (continuation instanceof C15611) {
            c15611 = (C15611) continuation;
            if ((c15611.label & Integer.MIN_VALUE) != 0) {
                c15611.label -= Integer.MIN_VALUE;
            } else {
                c15611 = new C15611(continuation);
            }
        } else {
            c15611 = new C15611(continuation);
        }
        Object objGqlDeleteItemRowFromCache = c15611.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15611.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objGqlDeleteItemRowFromCache);
            CacheKey cacheKeyCreateCacheKey$default = GQLCacheKeyUtils.createCacheKey$default(GQLCacheKeyUtils.INSTANCE, str, str2, null, 4, null);
            zBooleanValue = false;
            if (cacheKeyCreateCacheKey$default != null) {
                c15611.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c15611.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c15611.L$2 = SpillingKt.nullOutSpilledVariable(cacheKeyCreateCacheKey$default);
                c15611.I$0 = 0;
                c15611.label = 1;
                objGqlDeleteItemRowFromCache = gqlDeleteItemRowFromCache(cacheKeyCreateCacheKey$default, c15611);
                if (objGqlDeleteItemRowFromCache == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c15611.I$0;
        ResultKt.throwOnFailure(objGqlDeleteItemRowFromCache);
        zBooleanValue = ((Boolean) objGqlDeleteItemRowFromCache).booleanValue();
        return Boxing.boxBoolean(zBooleanValue);
    }

    public final Object gqlDeleteItemRowFromCache(String str, Continuation<? super Boolean> continuation) {
        return gqlDeleteItemRowFromCache(new CacheKey(str), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlDeleteItemRowFromCache(CacheKey cacheKey, Continuation<? super Boolean> continuation) {
        AnonymousClass4 anonymousClass4;
        boolean zBooleanValue;
        if (continuation instanceof AnonymousClass4) {
            anonymousClass4 = (AnonymousClass4) continuation;
            if ((anonymousClass4.label & Integer.MIN_VALUE) != 0) {
                anonymousClass4.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass4 = new AnonymousClass4(continuation);
            }
        } else {
            anonymousClass4 = new AnonymousClass4(continuation);
        }
        Object objRemove = anonymousClass4.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass4.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objRemove);
            ApolloStore apolloStore = this.gqlCache.getApolloStore();
            zBooleanValue = false;
            if (apolloStore != null) {
                anonymousClass4.L$0 = SpillingKt.nullOutSpilledVariable(cacheKey);
                anonymousClass4.label = 1;
                objRemove = apolloStore.remove(cacheKey, false, (Continuation<? super Boolean>) anonymousClass4);
                if (objRemove == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objRemove);
        zBooleanValue = ((Boolean) objRemove).booleanValue();
        return Boxing.boxBoolean(zBooleanValue);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0107  */
    /* JADX WARN: Code duplicated, block: B:30:0x0123  */
    /* JADX WARN: Code duplicated, block: B:33:0x017a  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0177 -> B:34:0x017c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x017a -> B:34:0x017c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object removeStaleChildren(java.lang.String r19, java.util.List<com.box.android.data.fragment.ItemConnectionEdgesOnlyFragment.Edge> r20, java.util.List<com.box.android.data.fragment.ItemConnectionFragment.Edge> r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instruction units count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.utilities.GQLCacheHelper.removeStaleChildren(java.lang.String, java.util.List, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeStaleChildren$lambda$0$1(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeStaleChildren$lambda$0$0(ItemConnectionEdgesOnlyFragment.Edge edge, ItemConnectionEdgesOnlyFragment.Edge edge2) {
        return Intrinsics.areEqual(edge2.getId(), edge.getId());
    }

    public final List<ItemConnectionEdgesOnlyFragment.Edge> getStaleChildren(List<ItemConnectionEdgesOnlyFragment.Edge> removedEdges, List<ItemConnectionEdgesOnlyFragment.Edge> currentCachedEdges) {
        Object next;
        Intrinsics.checkNotNullParameter(removedEdges, "removedEdges");
        Intrinsics.checkNotNullParameter(currentCachedEdges, "currentCachedEdges");
        ArrayList arrayList = new ArrayList();
        for (ItemConnectionEdgesOnlyFragment.Edge edge : removedEdges) {
            Iterator<T> it = currentCachedEdges.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(edge.getId(), ((ItemConnectionEdgesOnlyFragment.Edge) next).getId()));
            ItemConnectionEdgesOnlyFragment.Edge edge2 = (ItemConnectionEdgesOnlyFragment.Edge) next;
            if (edge2 != null) {
                arrayList.add(edge2);
            }
        }
        return arrayList;
    }

    public final List<ItemConnectionEdgesOnlyFragment.Edge> getRemovedChildren(List<ItemConnectionEdgesOnlyFragment.Edge> originalCachedEdges, List<ItemConnectionFragment.Edge> fetchedEdges) {
        Intrinsics.checkNotNullParameter(originalCachedEdges, "originalCachedEdges");
        Intrinsics.checkNotNullParameter(fetchedEdges, "fetchedEdges");
        ArrayList arrayList = new ArrayList(originalCachedEdges);
        for (final ItemConnectionFragment.Edge edge : fetchedEdges) {
            final Function1 function1 = new Function1() { // from class: com.box.android.data.utilities.GQLCacheHelper$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(GQLCacheHelper.getRemovedChildren$lambda$0$0(edge, (ItemConnectionEdgesOnlyFragment.Edge) obj));
                }
            };
            arrayList.removeIf(new Predicate() { // from class: com.box.android.data.utilities.GQLCacheHelper$$ExternalSyntheticLambda4
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return GQLCacheHelper.getRemovedChildren$lambda$0$1(function1, obj);
                }
            });
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getRemovedChildren$lambda$0$1(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getRemovedChildren$lambda$0$0(ItemConnectionFragment.Edge edge, ItemConnectionEdgesOnlyFragment.Edge edge2) {
        return Intrinsics.areEqual(edge2.getId(), edge.getId());
    }

    public final void logCacheError(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        BoxLogUtils.e(ExtensionsKt.getTAG(this), msg);
    }
}
