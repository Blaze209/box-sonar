package com.box.android.data.service.impl;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import com.apollographql.apollo3.ApolloCall;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.Error;
import com.apollographql.apollo3.cache.normalized.ApolloStore;
import com.apollographql.apollo3.exception.ApolloException;
import com.apollographql.apollo3.exception.CacheMissException;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.data.CreateCollectionItemMutation;
import com.box.android.data.CreateCollectionMutation;
import com.box.android.data.DeleteCollectionItemMutation;
import com.box.android.data.GetAllCollectionsQuery;
import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.GetCollectionsWithItemQuery;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.collection.GQLCollectionItemsDataSourceFactory;
import com.box.android.data.datasource.collection.GQLCollectionsDataSourceFactory;
import com.box.android.data.datasource.gql.BoxGraphQL;
import com.box.android.data.datasource.gql.GQLCache;
import com.box.android.data.mappers.GQLCreateCollectionToCollectionModelMapper;
import com.box.android.data.mappers.GQLGetCollectionItemsQueryOnFileToFileModelMapper;
import com.box.android.data.mappers.GQLGetCollectionItemsQueryOnFolderToFolderModelMapper;
import com.box.android.data.mappers.GQLGetCollectionItemsQueryOnWeblinkToWeblinkModelMapper;
import com.box.android.data.mappers.GraphQLMapper;
import com.box.android.data.mappers.TypenameMapperKt;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.item.WebLinkModel;
import com.box.android.domain.services.ICollectionsService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import com.facebook.imageutils.JfifUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CollectionsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 j2\u00020\u0001:\u0001jB9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ>\u0010\u0010\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012\u0012\u0004\u0012\u00020\u00150\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001aH\u0016J0\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001b\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010#\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010$J*\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010(J\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010*\u001a\u00020'H\u0096@¢\u0006\u0002\u0010+J*\u0010,\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010*\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010.J*\u0010/\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010*\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010.J\u0018\u00100\u001a\u00020\"2\b\u0010*\u001a\u0004\u0018\u00010'H\u0096@¢\u0006\u0002\u0010+J\u001e\u00101\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001022\u0006\u0010*\u001a\u00020'H\u0086@¢\u0006\u0002\u0010+J(\u00104\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u0002050\u0012\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010*\u001a\u00020'H\u0016J\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002050\u00172\f\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0017H\u0007J\u0012\u00109\u001a\u0004\u0018\u0001082\u0006\u0010:\u001a\u000205H\u0007J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\u001c\u0010?\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00150\u0011H\u0081@¢\u0006\u0004\b@\u0010AJ\u0018\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u000102H\u0081@¢\u0006\u0004\bD\u0010AJ>\u0010E\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012\u0012\u0004\u0012\u00020\u00150\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001aH\u0002J\"\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010&\u001a\u00020'H\u0082@¢\u0006\u0002\u0010+J\u001e\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u0001022\u0006\u0010&\u001a\u00020'H\u0087@¢\u0006\u0002\u0010+J\"\u0010I\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020J0\u00112\u0006\u0010K\u001a\u00020>H\u0087@¢\u0006\u0002\u0010LJ\u0018\u0010M\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010<\u0018\u00010NH\u0087@¢\u0006\u0002\u0010AJ&\u0010O\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u001b2\u000e\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0\u0017H\u0087@¢\u0006\u0002\u0010QJ*\u0010R\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020J0\u00112\u0006\u0010*\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0087@¢\u0006\u0002\u0010.J2\u0010S\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020J0\u00112\u0006\u0010T\u001a\u00020'2\u0006\u0010U\u001a\u00020V2\u0006\u0010*\u001a\u00020'H\u0087@¢\u0006\u0002\u0010WJ\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0N2\u0006\u0010*\u001a\u00020'H\u0087@¢\u0006\u0002\u0010+J\u001a\u0010Z\u001a\u0004\u0018\u0001052\u0006\u0010T\u001a\u00020'2\u0006\u0010U\u001a\u00020VH\u0007J,\u0010[\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u001b2\u0006\u0010*\u001a\u00020'2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020Y0\u0017H\u0087@¢\u0006\u0002\u0010\\J\"\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010*\u001a\u00020'H\u0082@¢\u0006\u0002\u0010+J\u001e\u0010^\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001022\u0006\u0010*\u001a\u00020'H\u0087@¢\u0006\u0002\u0010+J*\u0010_\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010*\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010.J&\u0010`\u001a\n\u0012\u0004\u0012\u00020a\u0018\u0001022\u0006\u0010*\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0087@¢\u0006\u0002\u0010.J*\u0010b\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010*\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010.J&\u0010c\u001a\n\u0012\u0004\u0012\u00020d\u0018\u0001022\u0006\u0010*\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0087@¢\u0006\u0002\u0010.J*\u0010E\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001b\u0012\u0004\u0012\u00020\u00150\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0081@¢\u0006\u0004\be\u0010fJ&\u0010g\u001a\n\u0012\u0004\u0012\u00020h\u0018\u0001022\u0006\u0010T\u001a\u00020'2\u0006\u0010U\u001a\u00020'H\u0087@¢\u0006\u0002\u0010iR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/box/android/data/service/impl/CollectionsService;", "Lcom/box/android/domain/services/ICollectionsService;", "graphQL", "Lcom/box/android/data/datasource/gql/BoxGraphQL;", "gqlCache", "Lcom/box/android/data/datasource/gql/GQLCache;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "boxExtendedApiFile", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;", "boxExtendedApiFolder", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "boxExtendedApiWeblink", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiWeblink;", "<init>", "(Lcom/box/android/data/datasource/gql/BoxGraphQL;Lcom/box/android/data/datasource/gql/GQLCache;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiWeblink;)V", "getCollections", "Lcom/box/android/domain/utils/result/Result;", "Landroidx/paging/DataSource$Factory;", "", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/domain/models/DomainError;", "types", "", "Lcom/box/android/domain/models/CollectionType;", "comparator", "Ljava/util/Comparator;", "", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "fetchedAfter", "Ljava/util/Date;", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchCollectionsFromRemote", "", "type", "(Lcom/box/android/domain/models/CollectionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCollection", "name", "", "(Ljava/lang/String;Lcom/box/android/domain/models/CollectionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchCollectionItemsFromRemote", BoxItemJob.COLLECTION_ID, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addCollectionItem", "", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeCollectionItem", "areCollectionItemsFetched", "gqlResponseGetCollectionItemsFromCache", "Lcom/apollographql/apollo3/api/ApolloResponse;", "Lcom/box/android/data/GetCollectionItemsQuery$Data;", "gqlGetCollectionItems", "Lcom/box/android/domain/models/item/ItemModel;", "mapNodeToItemModel", "nodes", "Lcom/box/android/data/GetCollectionItemsQuery$Node;", "mapItemModelToNode", "itemModel", "toQuery", "Lcom/box/android/data/GetAllCollectionsQuery$Edge;", SemanticAttributes.GraphqlOperationTypeValues.MUTATION, "Lcom/box/android/data/CreateCollectionMutation$CreateCollection;", "gqlFetchAllCollections", "gqlFetchAllCollections$data_generalProdRelease", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlResponseForGetAllCollectionsFromNetwork", "Lcom/box/android/data/GetAllCollectionsQuery$Data;", "gqlResponseForGetAllCollectionsFromNetwork$data_generalProdRelease", "gqlGetCollections", "gqlCreateCollection", "gqlResponseCreateCollection", "Lcom/box/android/data/CreateCollectionMutation$Data;", "gqlUpdateCollectionToCache", "Lcom/box/android/data/datasource/CacheError;", "createdCollection", "(Lcom/box/android/data/CreateCollectionMutation$CreateCollection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlGetCachedCollections", "", "gqlAddCollectionsToCache", BoxItem.FIELD_COLLECTIONS, "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlRemoveItemFromCache", "gqlAddItemToCache", "itemId", "itemType", "Lcom/box/android/domain/models/item/ItemType;", "(Ljava/lang/String;Lcom/box/android/domain/models/item/ItemType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlGetCachedCollectionItems", "Lcom/box/android/data/GetCollectionItemsQuery$Edge;", "mapItemTypeToItemModel", "gqlAddCollectionByIdToCache", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlFetchCollectionItemsFromRemote", "gqlResponseGetCollectionItemsFromRemote", "gqlRemoveCollectionItem", "gqlResponseRemoveItemFromCollection", "Lcom/box/android/data/DeleteCollectionItemMutation$Data;", "gqlCreateCollectionItem", "gqlResponseCreateCollectionItem", "Lcom/box/android/data/CreateCollectionItemMutation$Data;", "gqlGetCollections$data_generalProdRelease", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gqlGetCollectionsWithItem", "Lcom/box/android/data/GetCollectionsWithItemQuery$Data;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionsService implements ICollectionsService {
    public static final String LOGTAG = "CollectionsService";
    private final BoxExtendedApiFile boxExtendedApiFile;
    private final BoxExtendedApiFolder boxExtendedApiFolder;
    private final BoxExtendedApiWeblink boxExtendedApiWeblink;
    private final GQLCache gqlCache;
    private final BoxGraphQL graphQL;
    private final IUserContextManager userContextManager;

    /* JADX INFO: compiled from: CollectionsService.kt */
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

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsService$areCollectionItemsFetched$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsService", f = "CollectionsService.kt", i = {0, 0, 0, 0}, l = {78}, m = "areCollectionItemsFetched", n = {BoxItemJob.COLLECTION_ID, "areFetched", "it", "$i$a$-let-CollectionsService$areCollectionItemsFetched$2"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionsService.this.areCollectionItemsFetched(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsService$gqlAddItemToCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsService", f = "CollectionsService.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {337, 363}, m = "gqlAddItemToCache", n = {"itemId", "itemType", BoxItemJob.COLLECTION_ID, "itemId", "itemType", BoxItemJob.COLLECTION_ID, "edges", "item", "it", "node", "$i$a$-let-CollectionsService$gqlAddItemToCache$2", "$i$a$-let-CollectionsService$gqlAddItemToCache$2$1"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class C14001 extends ContinuationImpl {
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

        C14001(Continuation<? super C14001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionsService.this.gqlAddItemToCache(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsService$gqlCreateCollectionItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsService", f = "CollectionsService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {479, 491}, m = "gqlCreateCollectionItem", n = {BoxItemJob.COLLECTION_ID, "remoteId", "$i$f$resultOf", "$i$a$-resultOf-CollectionsService$gqlCreateCollectionItem$2", BoxItemJob.COLLECTION_ID, "remoteId", "$this$flatMap$iv", "response", "resp", "$i$f$flatMap", "$i$a$-flatMap-CollectionsService$gqlCreateCollectionItem$4", "$i$a$-let-CollectionsService$gqlCreateCollectionItem$4$1"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2"}, v = 1)
    static final class C14021 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C14021(Continuation<? super C14021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionsService.this.gqlCreateCollectionItem(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsService$gqlFetchCollectionItemsFromRemote$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsService", f = "CollectionsService.kt", i = {0, 0, 0}, l = {422}, m = "gqlFetchCollectionItemsFromRemote", n = {BoxItemJob.COLLECTION_ID, "$i$f$resultOf", "$i$a$-resultOf-CollectionsService$gqlFetchCollectionItemsFromRemote$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C14031 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14031(Continuation<? super C14031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionsService.this.gqlFetchCollectionItemsFromRemote(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsService$gqlGetCachedCollectionItems$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsService", f = "CollectionsService.kt", i = {0}, l = {382}, m = "gqlGetCachedCollectionItems", n = {BoxItemJob.COLLECTION_ID}, s = {"L$0"}, v = 1)
    static final class C14041 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14041(Continuation<? super C14041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionsService.this.gqlGetCachedCollectionItems(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsService$gqlGetCachedCollections$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsService", f = "CollectionsService.kt", i = {}, l = {263}, m = "gqlGetCachedCollections", n = {}, s = {}, v = 1)
    static final class C14051 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C14051(Continuation<? super C14051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionsService.this.gqlGetCachedCollections(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsService$gqlGetCollections$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsService", f = "CollectionsService.kt", i = {0, 0, 0}, l = {519}, m = "gqlGetCollections$data_generalProdRelease", n = {"remoteId", "$i$f$resultOf", "$i$a$-resultOf-CollectionsService$gqlGetCollections$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C14061 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14061(Continuation<? super C14061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionsService.this.gqlGetCollections$data_generalProdRelease(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsService$gqlRemoveCollectionItem$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsService", f = "CollectionsService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {445, 459}, m = "gqlRemoveCollectionItem", n = {BoxItemJob.COLLECTION_ID, "remoteId", "$i$f$resultOf", "$i$a$-resultOf-CollectionsService$gqlRemoveCollectionItem$2", BoxItemJob.COLLECTION_ID, "remoteId", "$this$flatMap$iv", "response", "resp", "it", "$i$f$flatMap", "$i$a$-flatMap-CollectionsService$gqlRemoveCollectionItem$4", "$i$a$-let-CollectionsService$gqlRemoveCollectionItem$4$1", "$i$a$-let-CollectionsService$gqlRemoveCollectionItem$4$1$1"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C14071 extends ContinuationImpl {
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
        int label;
        /* synthetic */ Object result;

        C14071(Continuation<? super C14071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionsService.this.gqlRemoveCollectionItem(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsService$gqlRemoveItemFromCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsService", f = "CollectionsService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {287, 314}, m = "gqlRemoveItemFromCache", n = {BoxItemJob.COLLECTION_ID, "remoteId", BoxItemJob.COLLECTION_ID, "remoteId", "cachedCollectionEdges", "itemType", "foundEdge", "it", "$i$a$-let-CollectionsService$gqlRemoveItemFromCache$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 1)
    static final class C14081 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C14081(Continuation<? super C14081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionsService.this.gqlRemoveItemFromCache(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsService$gqlUpdateCollectionToCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsService", f = "CollectionsService.kt", i = {0, 1, 1, 1}, l = {245, 247}, m = "gqlUpdateCollectionToCache", n = {"createdCollection", "createdCollection", "cachedCollections", "$i$a$-let-CollectionsService$gqlUpdateCollectionToCache$2"}, s = {"L$0", "L$0", "L$1", "I$0"}, v = 1)
    static final class C14091 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C14091(Continuation<? super C14091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectionsService.this.gqlUpdateCollectionToCache(null, this);
        }
    }

    @Inject
    public CollectionsService(BoxGraphQL graphQL, GQLCache gqlCache, IUserContextManager userContextManager, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiWeblink boxExtendedApiWeblink) {
        Intrinsics.checkNotNullParameter(graphQL, "graphQL");
        Intrinsics.checkNotNullParameter(gqlCache, "gqlCache");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(boxExtendedApiFile, "boxExtendedApiFile");
        Intrinsics.checkNotNullParameter(boxExtendedApiFolder, "boxExtendedApiFolder");
        Intrinsics.checkNotNullParameter(boxExtendedApiWeblink, "boxExtendedApiWeblink");
        this.graphQL = graphQL;
        this.gqlCache = gqlCache;
        this.userContextManager = userContextManager;
        this.boxExtendedApiFile = boxExtendedApiFile;
        this.boxExtendedApiFolder = boxExtendedApiFolder;
        this.boxExtendedApiWeblink = boxExtendedApiWeblink;
    }

    @Override // com.box.android.domain.services.ICollectionsService
    public Result<DataSource.Factory<Integer, CollectionModel>, DomainError> getCollections(List<? extends CollectionType> types, Comparator<CollectionModel> comparator) {
        Intrinsics.checkNotNullParameter(types, "types");
        return gqlGetCollections(types, comparator);
    }

    @Override // com.box.android.domain.services.ICollectionsService
    public Object getCollections(ItemId.Remote remote, Date date, Continuation<? super Result<? extends Set<CollectionModel>, ? extends DomainError>> continuation) {
        return gqlGetCollections$data_generalProdRelease(remote, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsService$fetchCollectionsFromRemote$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionsService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsService$fetchCollectionsFromRemote$2", f = "CollectionsService.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C13992 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean, ? extends DomainError>>, Object> {
        int label;

        C13992(Continuation<? super C13992> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CollectionsService.this.new C13992(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Boolean, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Boolean, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Boolean, ? extends DomainError>> continuation) {
            return ((C13992) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = CollectionsService.this.gqlFetchAllCollections$data_generalProdRelease(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result result = (Result) obj;
            if (result instanceof Result.Success) {
                return new Result.Success(Boxing.boxBoolean(true));
            }
            if (result instanceof Result.Error) {
                return result;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.box.android.domain.services.ICollectionsService
    public Object fetchCollectionsFromRemote(CollectionType collectionType, Continuation<? super Result<Boolean, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C13992(null), continuation);
    }

    @Override // com.box.android.domain.services.ICollectionsService
    public Object createCollection(String str, CollectionType collectionType, Continuation<? super Result<CollectionModel, ? extends DomainError>> continuation) {
        return gqlCreateCollection(str, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsService$fetchCollectionItemsFromRemote$2, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionsService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsService$fetchCollectionItemsFromRemote$2", f = "CollectionsService.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Boolean, ? extends DomainError>>, Object> {
        final /* synthetic */ String $collectionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CollectionsService.this.new AnonymousClass2(this.$collectionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Boolean, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Boolean, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Boolean, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Object objGqlFetchCollectionItemsFromRemote = CollectionsService.this.gqlFetchCollectionItemsFromRemote(this.$collectionId, this);
            return objGqlFetchCollectionItemsFromRemote == coroutine_suspended ? coroutine_suspended : objGqlFetchCollectionItemsFromRemote;
        }
    }

    @Override // com.box.android.domain.services.ICollectionsService
    public Object fetchCollectionItemsFromRemote(String str, Continuation<? super Result<Boolean, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, null), continuation);
    }

    @Override // com.box.android.domain.services.ICollectionsService
    public Object addCollectionItem(String str, ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return gqlCreateCollectionItem(str, remote, continuation);
    }

    @Override // com.box.android.domain.services.ICollectionsService
    public Object removeCollectionItem(String str, ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return gqlRemoveCollectionItem(str, remote, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ICollectionsService
    public Object areCollectionItemsFetched(String str, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        Ref.BooleanRef booleanRef;
        Exception e;
        Ref.BooleanRef booleanRef2;
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
        ApolloResponse apolloResponse = null;
        boolean z = false;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            booleanRef = new Ref.BooleanRef();
            if (str != null) {
                try {
                    anonymousClass1.L$0 = str;
                    anonymousClass1.L$1 = booleanRef;
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.label = 1;
                    Object objGqlResponseGetCollectionItemsFromCache = gqlResponseGetCollectionItemsFromCache(str, anonymousClass1);
                    if (objGqlResponseGetCollectionItemsFromCache == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = objGqlResponseGetCollectionItemsFromCache;
                    booleanRef2 = booleanRef;
                } catch (CacheMissException unused) {
                    booleanRef2 = booleanRef;
                    BoxLogUtils.d(LOGTAG, "Collection items not yet cached for collectionId: " + str);
                } catch (Exception e2) {
                    e = e2;
                    booleanRef2 = booleanRef;
                    BoxLogUtils.e(LOGTAG, "Unexpected error checking cache for collectionId: " + str, e);
                }
            }
            return Boxing.boxBoolean(booleanRef.element);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = anonymousClass1.I$0;
        booleanRef2 = (Ref.BooleanRef) anonymousClass1.L$1;
        str = (String) anonymousClass1.L$0;
        try {
            ResultKt.throwOnFailure(obj);
        } catch (CacheMissException unused2) {
            BoxLogUtils.d(LOGTAG, "Collection items not yet cached for collectionId: " + str);
        } catch (Exception e3) {
            e = e3;
            BoxLogUtils.e(LOGTAG, "Unexpected error checking cache for collectionId: " + str, e);
        }
        apolloResponse = (ApolloResponse) obj;
        booleanRef = booleanRef2;
        if (apolloResponse != null && !apolloResponse.hasErrors()) {
            z = true;
        }
        booleanRef.element = z;
        return Boxing.boxBoolean(booleanRef.element);
    }

    public final Object gqlResponseGetCollectionItemsFromCache(String str, Continuation<? super ApolloResponse<GetCollectionItemsQuery.Data>> continuation) {
        ApolloCall<GetCollectionItemsQuery.Data> collectionItemsFromCache = this.graphQL.getCollectionItemsFromCache(str);
        if (collectionItemsFromCache == null) {
            return null;
        }
        Object objExecute = collectionItemsFromCache.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    @Override // com.box.android.domain.services.ICollectionsService
    public Result<DataSource.Factory<String, ItemModel>, DomainError> gqlGetCollectionItems(String collectionId) {
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        return new Result.Success(((GQLCollectionItemsDataSourceFactory) new Result.Success(new GQLCollectionItemsDataSourceFactory(this.graphQL, collectionId)).getValue()).mapByPage(new Function() { // from class: com.box.android.data.service.impl.CollectionsService$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return CollectionsService.gqlGetCollectionItems$lambda$0$0(this.f$0, (List) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List gqlGetCollectionItems$lambda$0$0(CollectionsService collectionsService, List list) {
        Intrinsics.checkNotNull(list);
        return CollectionsKt.sortedWith(collectionsService.mapNodeToItemModel(list), new Comparator() { // from class: com.box.android.data.service.impl.CollectionsService$gqlGetCollectionItems$lambda$0$0$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((ItemModel) t2).getModifiedDate(), ((ItemModel) t).getModifiedDate());
            }
        });
    }

    public final List<ItemModel> mapNodeToItemModel(List<GetCollectionItemsQuery.Node> nodes) {
        Object objFromGraphQL$default;
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        List<GetCollectionItemsQuery.Node> list = nodes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (GetCollectionItemsQuery.Node node : list) {
            if (node.getOnFile() != null) {
                objFromGraphQL$default = GraphQLMapper.fromGraphQL$default(GQLGetCollectionItemsQueryOnFileToFileModelMapper.INSTANCE, node.getOnFile(), null, 2, null);
            } else if (node.getOnFolder() != null) {
                objFromGraphQL$default = GraphQLMapper.fromGraphQL$default(GQLGetCollectionItemsQueryOnFolderToFolderModelMapper.INSTANCE, node.getOnFolder(), null, 2, null);
            } else if (node.getOnWeblink() != null) {
                objFromGraphQL$default = GraphQLMapper.fromGraphQL$default(GQLGetCollectionItemsQueryOnWeblinkToWeblinkModelMapper.INSTANCE, node.getOnWeblink(), null, 2, null);
            } else {
                BoxLogUtils.w(ExtensionsKt.getTAG(this), "Invalid item [" + node + "]");
                throw new IllegalStateException("Collection Service invalid item " + node);
            }
            arrayList.add((ItemModel) objFromGraphQL$default);
        }
        return arrayList;
    }

    public final GetCollectionItemsQuery.Node mapItemModelToNode(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        if (itemModel instanceof FileModel) {
            return new GetCollectionItemsQuery.Node(TypenameMapperKt.toGQLTypename(ItemType.FILE), (GetCollectionItemsQuery.OnFile) GraphQLMapper.toGraphQL$default(GQLGetCollectionItemsQueryOnFileToFileModelMapper.INSTANCE, itemModel, null, 2, null), null, null);
        }
        if (itemModel instanceof FolderModel) {
            return new GetCollectionItemsQuery.Node(TypenameMapperKt.toGQLTypename(ItemType.FOLDER), null, (GetCollectionItemsQuery.OnFolder) GraphQLMapper.toGraphQL$default(GQLGetCollectionItemsQueryOnFolderToFolderModelMapper.INSTANCE, itemModel, null, 2, null), null);
        }
        if (itemModel instanceof WebLinkModel) {
            return new GetCollectionItemsQuery.Node(TypenameMapperKt.toGQLTypename(ItemType.WEBLINK), null, null, (GetCollectionItemsQuery.OnWeblink) GraphQLMapper.toGraphQL$default(GQLGetCollectionItemsQueryOnWeblinkToWeblinkModelMapper.INSTANCE, itemModel, null, 2, null));
        }
        return null;
    }

    private final GetAllCollectionsQuery.Edge toQuery(CreateCollectionMutation.CreateCollection mutation) {
        return new GetAllCollectionsQuery.Edge(mutation.getId(), new GetAllCollectionsQuery.Node(mutation.getId(), mutation.getCollectionType(), mutation.getName()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlFetchAllCollections$data_generalProdRelease(Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        CollectionsService$gqlFetchAllCollections$1 collectionsService$gqlFetchAllCollections$1;
        if (continuation instanceof CollectionsService$gqlFetchAllCollections$1) {
            collectionsService$gqlFetchAllCollections$1 = (CollectionsService$gqlFetchAllCollections$1) continuation;
            if ((collectionsService$gqlFetchAllCollections$1.label & Integer.MIN_VALUE) != 0) {
                collectionsService$gqlFetchAllCollections$1.label -= Integer.MIN_VALUE;
            } else {
                collectionsService$gqlFetchAllCollections$1 = new CollectionsService$gqlFetchAllCollections$1(this, continuation);
            }
        } else {
            collectionsService$gqlFetchAllCollections$1 = new CollectionsService$gqlFetchAllCollections$1(this, continuation);
        }
        Object objGqlResponseForGetAllCollectionsFromNetwork$data_generalProdRelease = collectionsService$gqlFetchAllCollections$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = collectionsService$gqlFetchAllCollections$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objGqlResponseForGetAllCollectionsFromNetwork$data_generalProdRelease);
                collectionsService$gqlFetchAllCollections$1.label = 1;
                objGqlResponseForGetAllCollectionsFromNetwork$data_generalProdRelease = gqlResponseForGetAllCollectionsFromNetwork$data_generalProdRelease(collectionsService$gqlFetchAllCollections$1);
                if (objGqlResponseForGetAllCollectionsFromNetwork$data_generalProdRelease == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objGqlResponseForGetAllCollectionsFromNetwork$data_generalProdRelease);
            }
            ApolloResponse apolloResponse = (ApolloResponse) objGqlResponseForGetAllCollectionsFromNetwork$data_generalProdRelease;
            if (apolloResponse != null && !apolloResponse.hasErrors()) {
                return new Result.Success(Unit.INSTANCE);
            }
            DomainErrorMapper domainErrorMapper = DomainErrorMapper.INSTANCE;
            List<Error> list = apolloResponse != null ? apolloResponse.errors : null;
            Intrinsics.checkNotNull(list);
            return new Result.Error(domainErrorMapper.toDomainError(list.get(0)));
        } catch (ApolloException e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Could not refresh the collections list from remote: " + e.getCause());
            return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError(e, "Could not refresh the collections list from remote: " + e.getCause()));
        }
    }

    public final Object gqlResponseForGetAllCollectionsFromNetwork$data_generalProdRelease(Continuation<? super ApolloResponse<GetAllCollectionsQuery.Data>> continuation) {
        ApolloCall<GetAllCollectionsQuery.Data> allCollectionsQueryFromNetwork = this.graphQL.getAllCollectionsQueryFromNetwork();
        if (allCollectionsQueryFromNetwork == null) {
            return null;
        }
        Object objExecute = allCollectionsQueryFromNetwork.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    private final Result<DataSource.Factory<Integer, CollectionModel>, DomainError> gqlGetCollections(List<? extends CollectionType> types, Comparator<CollectionModel> comparator) {
        return new Result.Success(new GQLCollectionsDataSourceFactory(this.graphQL, this.userContextManager, types, comparator));
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CollectionsService$gqlCreateCollection$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectionsService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/CollectionModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CollectionsService$gqlCreateCollection$2", f = "CollectionsService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {JfifUtil.MARKER_RST7, 226}, m = "invokeSuspend", n = {"$i$f$resultOf", "$i$a$-resultOf-CollectionsService$gqlCreateCollection$2$1", "$this$flatMap$iv", "response", "createCollection", "$i$f$flatMap", "$i$a$-flatMap-CollectionsService$gqlCreateCollection$2$3", "$i$a$-let-CollectionsService$gqlCreateCollection$2$3$1"}, s = {"I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "I$2"}, v = 1)
    static final class C14012 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends CollectionModel, ? extends DomainError>>, Object> {
        final /* synthetic */ String $name;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14012(String str, Continuation<? super C14012> continuation) {
            super(2, continuation);
            this.$name = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CollectionsService.this.new C14012(this.$name, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends CollectionModel, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<CollectionModel, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<CollectionModel, ? extends DomainError>> continuation) {
            return ((C14012) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:43:0x00d7  */
        /* JADX WARN: Code duplicated, block: B:44:0x00f1  */
        /* JADX WARN: Code duplicated, block: B:49:0x00fa  */
        /* JADX WARN: Code duplicated, block: B:51:0x00fe  */
        /* JADX WARN: Code duplicated, block: B:53:0x0117  */
        /* JADX WARN: Code duplicated, block: B:54:0x0119  */
        /* JADX WARN: Code duplicated, block: B:56:0x011f  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Result.Error error;
            CreateCollectionMutation.Data data;
            CreateCollectionMutation.CreateCollection createCollection;
            CreateCollectionMutation.CreateCollection createCollection2;
            Result.Error error2;
            Result.Error error3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        createCollection2 = (CreateCollectionMutation.CreateCollection) this.L$2;
                        ResultKt.throwOnFailure(obj);
                    }
                    error3 = (Result) obj;
                    if (error3 instanceof Result.Success) {
                        error3 = new Result.Success((CollectionModel) GraphQLMapper.fromGraphQL$default(GQLCreateCollectionToCollectionModelMapper.INSTANCE, createCollection2, null, 2, null));
                    } else if (!(error3 instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (!(error3 instanceof Result.Success)) {
                        if (error3 instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        error3 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) error3).getValue(), null, 2, null));
                    }
                    if (error3 != null) {
                        return error3;
                    }
                    error2 = new Result.Error(new DomainError.UnknownError(""));
                    return error2;
                }
                ResultKt.throwOnFailure(obj);
                CollectionsService collectionsService = CollectionsService.this;
                String str = this.$name;
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 1;
                obj = collectionsService.gqlResponseCreateCollection(str, this);
                if (obj == coroutine_suspended) {
                }
                return coroutine_suspended;
                error = new Result.Success((ApolloResponse) obj);
            } catch (Exception e) {
                error = new Result.Error(e);
            }
            if (!(error instanceof Result.Success)) {
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((Exception) ((Result.Error) error).getValue(), "Failed to create collection in GraphQL"));
            }
            CollectionsService collectionsService2 = CollectionsService.this;
            if (error instanceof Result.Success) {
                ApolloResponse apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
                if (apolloResponse != null && apolloResponse.hasErrors()) {
                    DomainErrorMapper domainErrorMapper = DomainErrorMapper.INSTANCE;
                    List<Error> list = apolloResponse.errors;
                    Intrinsics.checkNotNull(list);
                    error2 = new Result.Error(domainErrorMapper.toDomainError(list.get(0)));
                } else {
                    if (apolloResponse != null && (data = (CreateCollectionMutation.Data) apolloResponse.data) != null && (createCollection = data.getCreateCollection()) != null) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(error);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(apolloResponse);
                        this.L$2 = createCollection;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.I$2 = 0;
                        this.label = 2;
                        obj = collectionsService2.gqlUpdateCollectionToCache(createCollection, this);
                        if (obj != coroutine_suspended) {
                            createCollection2 = createCollection;
                            error3 = (Result) obj;
                            if (error3 instanceof Result.Success) {
                                error3 = new Result.Success((CollectionModel) GraphQLMapper.fromGraphQL$default(GQLCreateCollectionToCollectionModelMapper.INSTANCE, createCollection2, null, 2, null));
                            } else if (!(error3 instanceof Result.Error)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            if (!(error3 instanceof Result.Success)) {
                                if (error3 instanceof Result.Error) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                error3 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) error3).getValue(), null, 2, null));
                            }
                            if (error3 != null) {
                                return error3;
                            }
                        }
                        return coroutine_suspended;
                    }
                    error2 = new Result.Error(new DomainError.UnknownError(""));
                }
                return error2;
            }
            if (error instanceof Result.Error) {
                return error;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object gqlCreateCollection(String str, Continuation<? super Result<CollectionModel, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C14012(str, null), continuation);
    }

    public final Object gqlResponseCreateCollection(String str, Continuation<? super ApolloResponse<CreateCollectionMutation.Data>> continuation) {
        ApolloCall<CreateCollectionMutation.Data> apolloCallCreateCollection = this.graphQL.createCollection(str);
        if (apolloCallCreateCollection == null) {
            return null;
        }
        Object objExecute = apolloCallCreateCollection.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0078, code lost:
    
        if (r7 == r1) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object gqlUpdateCollectionToCache(com.box.android.data.CreateCollectionMutation.CreateCollection r6, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.data.datasource.CacheError>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.box.android.data.service.impl.CollectionsService.C14091
            if (r0 == 0) goto L14
            r0 = r7
            com.box.android.data.service.impl.CollectionsService$gqlUpdateCollectionToCache$1 r0 = (com.box.android.data.service.impl.CollectionsService.C14091) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.box.android.data.service.impl.CollectionsService$gqlUpdateCollectionToCache$1 r0 = new com.box.android.data.service.impl.CollectionsService$gqlUpdateCollectionToCache$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            int r5 = r0.I$0
            java.lang.Object r5 = r0.L$1
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r5 = r0.L$0
            com.box.android.data.CreateCollectionMutation$CreateCollection r5 = (com.box.android.data.CreateCollectionMutation.CreateCollection) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L7b
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            java.lang.Object r6 = r0.L$0
            com.box.android.data.CreateCollectionMutation$CreateCollection r6 = (com.box.android.data.CreateCollectionMutation.CreateCollection) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L55
        L47:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.gqlGetCachedCollections(r0)
            if (r7 != r1) goto L55
            goto L7a
        L55:
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto La5
            com.box.android.data.GetAllCollectionsQuery$Edge r2 = r5.toQuery(r6)
            boolean r2 = r7.add(r2)
            if (r2 == 0) goto La5
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r6
            r6 = 0
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r7 = r5.gqlAddCollectionsToCache(r7, r0)
            if (r7 != r1) goto L7b
        L7a:
            return r1
        L7b:
            java.util.Set r7 = (java.util.Set) r7
            if (r7 == 0) goto L9b
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r5 = r7.isEmpty()
            if (r5 != 0) goto L91
            com.box.android.domain.utils.result.Result$Success r5 = new com.box.android.domain.utils.result.Result$Success
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r5.<init>(r6)
            com.box.android.domain.utils.result.Result r5 = (com.box.android.domain.utils.result.Result) r5
            return r5
        L91:
            com.box.android.domain.utils.result.Result$Error r5 = new com.box.android.domain.utils.result.Result$Error
            com.box.android.data.datasource.CacheError$SaveError r6 = com.box.android.data.datasource.CacheError.SaveError.INSTANCE
            r5.<init>(r6)
            com.box.android.domain.utils.result.Result r5 = (com.box.android.domain.utils.result.Result) r5
            return r5
        L9b:
            com.box.android.domain.utils.result.Result$Error r5 = new com.box.android.domain.utils.result.Result$Error
            com.box.android.data.datasource.CacheError$SaveError r6 = com.box.android.data.datasource.CacheError.SaveError.INSTANCE
            r5.<init>(r6)
            com.box.android.domain.utils.result.Result r5 = (com.box.android.domain.utils.result.Result) r5
            return r5
        La5:
            com.box.android.domain.utils.result.Result$Error r5 = new com.box.android.domain.utils.result.Result$Error
            com.box.android.data.datasource.CacheError$SaveError r6 = com.box.android.data.datasource.CacheError.SaveError.INSTANCE
            r5.<init>(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.CollectionsService.gqlUpdateCollectionToCache(com.box.android.data.CreateCollectionMutation$CreateCollection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlGetCachedCollections(Continuation<? super List<GetAllCollectionsQuery.Edge>> continuation) {
        C14051 c14051;
        GetAllCollectionsQuery.Collections collections;
        List<GetAllCollectionsQuery.Edge> edges;
        if (continuation instanceof C14051) {
            c14051 = (C14051) continuation;
            if ((c14051.label & Integer.MIN_VALUE) != 0) {
                c14051.label -= Integer.MIN_VALUE;
            } else {
                c14051 = new C14051(continuation);
            }
        } else {
            c14051 = new C14051(continuation);
        }
        C14051 c14052 = c14051;
        Object operation$default = c14052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14052.label;
        if (i == 0) {
            ResultKt.throwOnFailure(operation$default);
            ApolloStore apolloStore = this.gqlCache.getApolloStore();
            if (apolloStore == null) {
                return null;
            }
            GetAllCollectionsQuery getAllCollectionsQuery = new GetAllCollectionsQuery();
            c14052.label = 1;
            operation$default = ApolloStore.DefaultImpls.readOperation$default(apolloStore, getAllCollectionsQuery, null, null, c14052, 6, null);
            if (operation$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(operation$default);
        }
        GetAllCollectionsQuery.Data data = (GetAllCollectionsQuery.Data) operation$default;
        if (data == null || (collections = data.getCollections()) == null || (edges = collections.getEdges()) == null) {
            return null;
        }
        List<GetAllCollectionsQuery.Edge> list = edges;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((GetAllCollectionsQuery.Edge) it.next());
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }

    public final Object gqlAddCollectionsToCache(List<GetAllCollectionsQuery.Edge> list, Continuation<? super Set<String>> continuation) {
        ApolloStore apolloStore = this.gqlCache.getApolloStore();
        if (apolloStore == null) {
            return null;
        }
        Object objWriteOperation$default = ApolloStore.DefaultImpls.writeOperation$default(apolloStore, new GetAllCollectionsQuery(), new GetAllCollectionsQuery.Data(new GetAllCollectionsQuery.Collections(list)), null, null, true, continuation, 12, null);
        return objWriteOperation$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteOperation$default : (Set) objWriteOperation$default;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:50:0x010d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0112  */
    /* JADX WARN: Code duplicated, block: B:54:0x011d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0127  */
    /* JADX WARN: Code duplicated, block: B:57:0x012c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0137  */
    /* JADX WARN: Code duplicated, block: B:62:0x0141  */
    /* JADX WARN: Code duplicated, block: B:63:0x0146  */
    /* JADX WARN: Code duplicated, block: B:69:0x0156  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:82:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:93:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x00e8 A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0186, code lost:
    
        if (r0 == r4) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object gqlRemoveItemFromCache(java.lang.String r19, com.box.android.domain.models.ItemId.Remote r20, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.data.datasource.CacheError>> r21) {
        /*
            Method dump skipped, instruction units count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.CollectionsService.gqlRemoveItemFromCache(java.lang.String, com.box.android.domain.models.ItemId$Remote, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e3, code lost:
    
        if (r12 == r1) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object gqlAddItemToCache(java.lang.String r9, com.box.android.domain.models.item.ItemType r10, java.lang.String r11, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.data.datasource.CacheError>> r12) {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.CollectionsService.gqlAddItemToCache(java.lang.String, com.box.android.domain.models.item.ItemType, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlGetCachedCollectionItems(String str, Continuation<? super List<GetCollectionItemsQuery.Edge>> continuation) {
        C14041 c14041;
        GetCollectionItemsQuery.Collection collection;
        GetCollectionItemsQuery.CollectionItemConnection collectionItemConnection;
        List<GetCollectionItemsQuery.Edge> edges;
        List mutableList;
        if (continuation instanceof C14041) {
            c14041 = (C14041) continuation;
            if ((c14041.label & Integer.MIN_VALUE) != 0) {
                c14041.label -= Integer.MIN_VALUE;
            } else {
                c14041 = new C14041(continuation);
            }
        } else {
            c14041 = new C14041(continuation);
        }
        C14041 c14042 = c14041;
        Object operation$default = c14042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14042.label;
        if (i == 0) {
            ResultKt.throwOnFailure(operation$default);
            ApolloStore apolloStore = this.gqlCache.getApolloStore();
            if (apolloStore != null) {
                GetCollectionItemsQuery getCollectionItemsQuery = new GetCollectionItemsQuery(str);
                c14042.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c14042.label = 1;
                operation$default = ApolloStore.DefaultImpls.readOperation$default(apolloStore, getCollectionItemsQuery, null, null, c14042, 6, null);
                if (operation$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return new ArrayList();
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(operation$default);
        GetCollectionItemsQuery.Data data = (GetCollectionItemsQuery.Data) operation$default;
        if (data != null && (collection = data.getCollection()) != null && (collectionItemConnection = collection.getCollectionItemConnection()) != null && (edges = collectionItemConnection.getEdges()) != null && (mutableList = CollectionsKt.toMutableList((Collection) edges)) != null) {
            return mutableList;
        }
        return new ArrayList();
    }

    public final ItemModel mapItemTypeToItemModel(String itemId, ItemType itemType) throws BoxException {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        int i = WhenMappings.$EnumSwitchMapping$0[itemType.ordinal()];
        if (i == 1) {
            ItemModelMapper itemModelMapper = ItemModelMapper.INSTANCE;
            BoxFile boxFileSendForCachedResult = this.boxExtendedApiFile.getInfoRequest(itemId).sendForCachedResult();
            Intrinsics.checkNotNullExpressionValue(boxFileSendForCachedResult, "sendForCachedResult(...)");
            return itemModelMapper.toItemModel(boxFileSendForCachedResult);
        }
        if (i == 2) {
            ItemModelMapper itemModelMapper2 = ItemModelMapper.INSTANCE;
            BoxFolder boxFolderSendForCachedResult = this.boxExtendedApiFolder.getInfoRequest(itemId).sendForCachedResult();
            Intrinsics.checkNotNullExpressionValue(boxFolderSendForCachedResult, "sendForCachedResult(...)");
            return itemModelMapper2.toItemModel(boxFolderSendForCachedResult);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        ItemModelMapper itemModelMapper3 = ItemModelMapper.INSTANCE;
        BoxBookmark boxBookmarkSendForCachedResult = this.boxExtendedApiWeblink.getInfoRequest(itemId).sendForCachedResult();
        Intrinsics.checkNotNullExpressionValue(boxBookmarkSendForCachedResult, "sendForCachedResult(...)");
        return itemModelMapper3.toItemModel(boxBookmarkSendForCachedResult);
    }

    public final Object gqlAddCollectionByIdToCache(String str, List<GetCollectionItemsQuery.Edge> list, Continuation<? super Set<String>> continuation) {
        ApolloStore apolloStore = this.gqlCache.getApolloStore();
        if (apolloStore == null) {
            return null;
        }
        Object objWriteOperation$default = ApolloStore.DefaultImpls.writeOperation$default(apolloStore, new GetCollectionItemsQuery(str), new GetCollectionItemsQuery.Data(new GetCollectionItemsQuery.Collection(str, new GetCollectionItemsQuery.CollectionItemConnection(list))), null, null, true, continuation, 12, null);
        return objWriteOperation$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteOperation$default : (Set) objWriteOperation$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlFetchCollectionItemsFromRemote(String str, Continuation<? super Result<Boolean, ? extends DomainError>> continuation) {
        C14031 c14031;
        Result.Error error;
        Result.Success success;
        if (continuation instanceof C14031) {
            c14031 = (C14031) continuation;
            if ((c14031.label & Integer.MIN_VALUE) != 0) {
                c14031.label -= Integer.MIN_VALUE;
            } else {
                c14031 = new C14031(continuation);
            }
        } else {
            c14031 = new C14031(continuation);
        }
        Object objGqlResponseGetCollectionItemsFromRemote = c14031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14031.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objGqlResponseGetCollectionItemsFromRemote);
                c14031.L$0 = str;
                c14031.I$0 = 0;
                c14031.I$1 = 0;
                c14031.label = 1;
                objGqlResponseGetCollectionItemsFromRemote = gqlResponseGetCollectionItemsFromRemote(str, c14031);
                if (objGqlResponseGetCollectionItemsFromRemote == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c14031.I$1;
                int i3 = c14031.I$0;
                str = (String) c14031.L$0;
                ResultKt.throwOnFailure(objGqlResponseGetCollectionItemsFromRemote);
            }
            error = new Result.Success((ApolloResponse) objGqlResponseGetCollectionItemsFromRemote);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((Exception) ((Result.Error) error).getValue(), "Failed to get collection items for ID in GraphQL"));
        }
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                return error;
            }
            throw new NoWhenBranchMatchedException();
        }
        ApolloResponse apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
        if (apolloResponse != null) {
            if (apolloResponse.hasErrors()) {
                DomainErrorMapper domainErrorMapper = DomainErrorMapper.INSTANCE;
                List<Error> list = apolloResponse.errors;
                Intrinsics.checkNotNull(list);
                success = new Result.Error(domainErrorMapper.toDomainError(list.get(0)));
            } else {
                success = new Result.Success(Boxing.boxBoolean(false));
            }
            return success;
        }
        return new Result.Error(new DomainError.UnknownError("Could not perform the add to collection id " + str + ". Is a user logged in?"));
    }

    public final Object gqlResponseGetCollectionItemsFromRemote(String str, Continuation<? super ApolloResponse<GetCollectionItemsQuery.Data>> continuation) {
        ApolloCall<GetCollectionItemsQuery.Data> collectionItemsFromNetwork = this.graphQL.getCollectionItemsFromNetwork(str);
        if (collectionItemsFromNetwork == null) {
            return null;
        }
        Object objExecute = collectionItemsFromNetwork.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0117, code lost:
    
        if (gqlRemoveItemFromCache(r8, r9, r0) == r1) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object gqlRemoveCollectionItem(java.lang.String r8, com.box.android.domain.models.ItemId.Remote r9, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r10) {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.CollectionsService.gqlRemoveCollectionItem(java.lang.String, com.box.android.domain.models.ItemId$Remote, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object gqlResponseRemoveItemFromCollection(String str, ItemId.Remote remote, Continuation<? super ApolloResponse<DeleteCollectionItemMutation.Data>> continuation) {
        ApolloCall<DeleteCollectionItemMutation.Data> apolloCallRemoveItemFromCollection = this.graphQL.removeItemFromCollection(str, remote.getBoxId(), remote.getType().toString());
        if (apolloCallRemoveItemFromCollection == null) {
            return null;
        }
        Object objExecute = apolloCallRemoveItemFromCollection.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:45:0x012a  */
    /* JADX WARN: Code duplicated, block: B:46:0x012c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0130  */
    /* JADX WARN: Code duplicated, block: B:53:0x014f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0155 A[PHI: r9
      0x0155: PHI (r9v3 java.lang.String) = (r9v2 java.lang.String), (r9v7 java.lang.String) binds: [B:35:0x00d1, B:50:0x014a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlCreateCollectionItem(String str, ItemId.Remote remote, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C14021 c14021;
        Result.Error error;
        String str2;
        Result.Error error2;
        Result result;
        Result.Error error3;
        if (continuation instanceof C14021) {
            c14021 = (C14021) continuation;
            if ((c14021.label & Integer.MIN_VALUE) != 0) {
                c14021.label -= Integer.MIN_VALUE;
            } else {
                c14021 = new C14021(continuation);
            }
        } else {
            c14021 = new C14021(continuation);
        }
        Object objGqlAddItemToCache = c14021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14021.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    int i2 = c14021.I$1;
                    int i3 = c14021.I$0;
                    remote = (ItemId.Remote) c14021.L$1;
                    str = (String) c14021.L$0;
                    ResultKt.throwOnFailure(objGqlAddItemToCache);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i4 = c14021.I$2;
                    int i5 = c14021.I$1;
                    int i6 = c14021.I$0;
                    str2 = (String) c14021.L$0;
                    ResultKt.throwOnFailure(objGqlAddItemToCache);
                }
                result = (Result) objGqlAddItemToCache;
                if (result instanceof Result.Success) {
                    error3 = result;
                } else {
                    if (result instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    error3 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
                }
                str = str2;
                error2 = error3;
                if (error2 == null) {
                    error2 = new Result.Error(new DomainError.UnknownError("Could not perform the add to collection id " + str + ". Is a user logged in?"));
                }
                return error2;
            }
            ResultKt.throwOnFailure(objGqlAddItemToCache);
            c14021.L$0 = str;
            c14021.L$1 = remote;
            c14021.I$0 = 0;
            c14021.I$1 = 0;
            c14021.label = 1;
            objGqlAddItemToCache = gqlResponseCreateCollectionItem(str, remote, c14021);
            if (objGqlAddItemToCache == coroutine_suspended) {
            }
            return coroutine_suspended;
            error = new Result.Success((ApolloResponse) objGqlAddItemToCache);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                error = new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((Exception) ((Result.Error) error).getValue(), "Could not add item with id " + remote.getBoxId() + " to the collection id " + str));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                return error;
            }
            throw new NoWhenBranchMatchedException();
        }
        ApolloResponse apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
        if (apolloResponse != null) {
            if (apolloResponse.hasErrors()) {
                DomainErrorMapper domainErrorMapper = DomainErrorMapper.INSTANCE;
                List<Error> list = apolloResponse.errors;
                Intrinsics.checkNotNull(list);
                error2 = new Result.Error(domainErrorMapper.toDomainError(list.get(0)));
            } else {
                String boxId = remote.getBoxId();
                ItemType type = remote.getType();
                c14021.L$0 = str;
                c14021.L$1 = SpillingKt.nullOutSpilledVariable(remote);
                c14021.L$2 = SpillingKt.nullOutSpilledVariable(error);
                c14021.L$3 = SpillingKt.nullOutSpilledVariable(apolloResponse);
                c14021.L$4 = SpillingKt.nullOutSpilledVariable(apolloResponse);
                c14021.I$0 = 0;
                c14021.I$1 = 0;
                c14021.I$2 = 0;
                c14021.label = 2;
                objGqlAddItemToCache = gqlAddItemToCache(boxId, type, str, c14021);
                if (objGqlAddItemToCache != coroutine_suspended) {
                    str2 = str;
                    result = (Result) objGqlAddItemToCache;
                    if (result instanceof Result.Success) {
                        error3 = result;
                    } else {
                        if (result instanceof Result.Error) {
                            throw new NoWhenBranchMatchedException();
                        }
                        error3 = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
                    }
                    str = str2;
                    error2 = error3;
                }
                return coroutine_suspended;
            }
            if (error2 == null) {
                error2 = new Result.Error(new DomainError.UnknownError("Could not perform the add to collection id " + str + ". Is a user logged in?"));
            }
        } else {
            error2 = new Result.Error(new DomainError.UnknownError("Could not perform the add to collection id " + str + ". Is a user logged in?"));
        }
        return error2;
    }

    public final Object gqlResponseCreateCollectionItem(String str, ItemId.Remote remote, Continuation<? super ApolloResponse<CreateCollectionItemMutation.Data>> continuation) {
        ApolloCall<CreateCollectionItemMutation.Data> apolloCallCreateCollectionItem = this.graphQL.createCollectionItem(str, remote.getBoxId(), remote.getType().toString());
        if (apolloCallCreateCollectionItem == null) {
            return null;
        }
        Object objExecute = apolloCallCreateCollectionItem.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object gqlGetCollections$data_generalProdRelease(ItemId.Remote remote, Continuation<? super Result<? extends Set<CollectionModel>, ? extends DomainError>> continuation) {
        C14061 c14061;
        Result.Error error;
        GetCollectionsWithItemQuery.Data data;
        GetCollectionsWithItemQuery.Item item;
        GetCollectionsWithItemQuery.OnCoreItem onCoreItem;
        GetCollectionsWithItemQuery.ItemCollectionConnection itemCollectionConnection;
        List<GetCollectionsWithItemQuery.Edge> edges;
        CollectionModel collectionModel;
        if (continuation instanceof C14061) {
            c14061 = (C14061) continuation;
            if ((c14061.label & Integer.MIN_VALUE) != 0) {
                c14061.label -= Integer.MIN_VALUE;
            } else {
                c14061 = new C14061(continuation);
            }
        } else {
            c14061 = new C14061(continuation);
        }
        Object objGqlGetCollectionsWithItem = c14061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14061.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objGqlGetCollectionsWithItem);
                String boxId = remote.getBoxId();
                String string = remote.getType().toString();
                c14061.L$0 = remote;
                c14061.I$0 = 0;
                c14061.I$1 = 0;
                c14061.label = 1;
                objGqlGetCollectionsWithItem = gqlGetCollectionsWithItem(boxId, string, c14061);
                if (objGqlGetCollectionsWithItem == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c14061.I$1;
                int i3 = c14061.I$0;
                remote = (ItemId.Remote) c14061.L$0;
                ResultKt.throwOnFailure(objGqlGetCollectionsWithItem);
            }
            error = new Result.Success((ApolloResponse) objGqlGetCollectionsWithItem);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((Exception) ((Result.Error) error).getValue(), "Could not get collections with item id " + remote.getBoxId()));
        }
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                return error;
            }
            throw new NoWhenBranchMatchedException();
        }
        ApolloResponse apolloResponse = (ApolloResponse) ((Result.Success) error).getValue();
        if (apolloResponse == null || (data = (GetCollectionsWithItemQuery.Data) apolloResponse.data) == null || (item = data.getItem()) == null || (onCoreItem = item.getOnCoreItem()) == null || (itemCollectionConnection = onCoreItem.getItemCollectionConnection()) == null || (edges = itemCollectionConnection.getEdges()) == null) {
            return new Result.Error(new DomainError.NetworkError(null, 1, null));
        }
        ArrayList arrayList = new ArrayList();
        for (GetCollectionsWithItemQuery.Edge edge : edges) {
            String collectionType = edge.getNode().getCollectionType();
            if (collectionType != null) {
                String id = edge.getNode().getId();
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String upperCase = collectionType.toUpperCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                CollectionType collectionTypeValueOf = CollectionType.valueOf(upperCase);
                String name = edge.getNode().getName();
                if (name == null) {
                    name = "";
                }
                collectionModel = new CollectionModel(id, collectionTypeValueOf, name, null, null);
            } else {
                collectionModel = null;
            }
            if (collectionModel != null) {
                arrayList.add(collectionModel);
            }
        }
        return new Result.Success(CollectionsKt.toSet(arrayList));
    }

    public final Object gqlGetCollectionsWithItem(String str, String str2, Continuation<? super ApolloResponse<GetCollectionsWithItemQuery.Data>> continuation) {
        ApolloCall<GetCollectionsWithItemQuery.Data> collectionsWithItem = this.graphQL.getCollectionsWithItem(str, str2);
        if (collectionsWithItem == null) {
            return null;
        }
        Object objExecute = collectionsWithItem.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }
}
