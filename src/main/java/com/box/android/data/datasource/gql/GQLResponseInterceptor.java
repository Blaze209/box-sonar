package com.box.android.data.datasource.gql;

import com.apollographql.apollo3.ApolloClient;
import com.apollographql.apollo3.cache.normalized.ApolloStore;
import com.apollographql.apollo3.cache.normalized.NormalizedCache;
import com.box.android.data.CreateCollectionItemMutation;
import com.box.android.data.CreateCollectionMutation;
import com.box.android.data.CreateFolderMutation;
import com.box.android.data.DeleteCollectionItemMutation;
import com.box.android.data.GetAllCollectionsQuery;
import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.GetCollectionsWithItemQuery;
import com.box.android.data.GetFolderItemsQuery;
import com.box.android.data.GetFolderMiniQuery;
import com.box.android.data.GetFolderMiniWithParentQuery;
import com.box.android.data.GetItemQuery;
import com.box.android.data.GetItemWithWatermarkDataQuery;
import com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLCollectionsResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLCollectionsWithItemResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLCreateCollectionItemResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLCreateCollectionResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLRemoveCollectionItemResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLCopyItemResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLCreateFolderResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetFolderMiniResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetFolderMiniWithParentResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetItemResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetItemWithWatermarkDataResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLMoveItemResponseInterceptor;
import com.box.android.domain.configuration.FeatureFlips;
import com.squareup.moshi.Moshi;
import dagger.Lazy;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: compiled from: GQLResponseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001Bí\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000b\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000b\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000b\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u000b\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u000b¢\u0006\u0004\b'\u0010(J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u0010/\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\u00012\u0006\u0010-\u001a\u00020.H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/box/android/data/datasource/gql/GQLResponseInterceptor;", "Lcom/box/android/data/datasource/gql/GQLBaseInterceptor;", "apolloClientConfigurator", "Lcom/box/android/data/datasource/gql/GQLApolloClientConfigurator;", "requestParser", "Lcom/box/android/data/datasource/gql/GQLRequestParser;", "moshi", "Lcom/squareup/moshi/Moshi;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "collectionsResponseInterceptor", "Ldagger/Lazy;", "Lcom/box/android/data/datasource/collection/interceptors/GQLCollectionsResponseInterceptor;", "collectionItemsResponseInterceptor", "Lcom/box/android/data/datasource/collection/interceptors/GQLCollectionItemsResponseInterceptor;", "collectionsWithItemResponseInterceptor", "Lcom/box/android/data/datasource/collection/interceptors/GQLCollectionsWithItemResponseInterceptor;", "createCollectionResponseInterceptor", "Lcom/box/android/data/datasource/collection/interceptors/GQLCreateCollectionResponseInterceptor;", "removeCollectionItemResponseInterceptor", "Lcom/box/android/data/datasource/collection/interceptors/GQLRemoveCollectionItemResponseInterceptor;", "createCollectionItemResponseInterceptor", "Lcom/box/android/data/datasource/collection/interceptors/GQLCreateCollectionItemResponseInterceptor;", "createFolderResponseInterceptor", "Lcom/box/android/data/datasource/items/interceptors/GQLCreateFolderResponseInterceptor;", "gqlGetFolderItemsResponseInterceptor", "Lcom/box/android/data/datasource/items/interceptors/GQLGetFolderItemsResponseInterceptor;", "copyItemResponseInterceptor", "Lcom/box/android/data/datasource/items/interceptors/GQLCopyItemResponseInterceptor;", "moveItemResponseInterceptor", "Lcom/box/android/data/datasource/items/interceptors/GQLMoveItemResponseInterceptor;", "gqlGetItemResponseInterceptor", "Lcom/box/android/data/datasource/items/interceptors/GQLGetItemResponseInterceptor;", "gqlGetItemWithWatermarkDataResponseInterceptor", "Lcom/box/android/data/datasource/items/interceptors/GQLGetItemWithWatermarkDataResponseInterceptor;", "gqlGetFolderMiniResponseInterceptor", "Lcom/box/android/data/datasource/items/interceptors/GQLGetFolderMiniResponseInterceptor;", "gqlGetFolderMiniWithParentResponseInterceptor", "Lcom/box/android/data/datasource/items/interceptors/GQLGetFolderMiniWithParentResponseInterceptor;", "<init>", "(Lcom/box/android/data/datasource/gql/GQLApolloClientConfigurator;Lcom/box/android/data/datasource/gql/GQLRequestParser;Lcom/squareup/moshi/Moshi;Lcom/box/android/domain/configuration/FeatureFlips;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "toResponse", "operationName", "", "interceptIfNecessary", "interceptor", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLResponseInterceptor extends GQLBaseInterceptor {
    private final GQLApolloClientConfigurator apolloClientConfigurator;
    private final Lazy<GQLCollectionItemsResponseInterceptor> collectionItemsResponseInterceptor;
    private final Lazy<GQLCollectionsResponseInterceptor> collectionsResponseInterceptor;
    private final Lazy<GQLCollectionsWithItemResponseInterceptor> collectionsWithItemResponseInterceptor;
    private final Lazy<GQLCopyItemResponseInterceptor> copyItemResponseInterceptor;
    private final Lazy<GQLCreateCollectionItemResponseInterceptor> createCollectionItemResponseInterceptor;
    private final Lazy<GQLCreateCollectionResponseInterceptor> createCollectionResponseInterceptor;
    private final Lazy<GQLCreateFolderResponseInterceptor> createFolderResponseInterceptor;
    private final FeatureFlips featureFlips;
    private final Lazy<GQLGetFolderItemsResponseInterceptor> gqlGetFolderItemsResponseInterceptor;
    private final Lazy<GQLGetFolderMiniResponseInterceptor> gqlGetFolderMiniResponseInterceptor;
    private final Lazy<GQLGetFolderMiniWithParentResponseInterceptor> gqlGetFolderMiniWithParentResponseInterceptor;
    private final Lazy<GQLGetItemResponseInterceptor> gqlGetItemResponseInterceptor;
    private final Lazy<GQLGetItemWithWatermarkDataResponseInterceptor> gqlGetItemWithWatermarkDataResponseInterceptor;
    private final Moshi moshi;
    private final Lazy<GQLMoveItemResponseInterceptor> moveItemResponseInterceptor;
    private final Lazy<GQLRemoveCollectionItemResponseInterceptor> removeCollectionItemResponseInterceptor;
    private final GQLRequestParser requestParser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GQLResponseInterceptor(GQLApolloClientConfigurator apolloClientConfigurator, GQLRequestParser requestParser, Moshi moshi, FeatureFlips featureFlips, Lazy<GQLCollectionsResponseInterceptor> collectionsResponseInterceptor, Lazy<GQLCollectionItemsResponseInterceptor> collectionItemsResponseInterceptor, Lazy<GQLCollectionsWithItemResponseInterceptor> collectionsWithItemResponseInterceptor, Lazy<GQLCreateCollectionResponseInterceptor> createCollectionResponseInterceptor, Lazy<GQLRemoveCollectionItemResponseInterceptor> removeCollectionItemResponseInterceptor, Lazy<GQLCreateCollectionItemResponseInterceptor> createCollectionItemResponseInterceptor, Lazy<GQLCreateFolderResponseInterceptor> createFolderResponseInterceptor, Lazy<GQLGetFolderItemsResponseInterceptor> gqlGetFolderItemsResponseInterceptor, Lazy<GQLCopyItemResponseInterceptor> copyItemResponseInterceptor, Lazy<GQLMoveItemResponseInterceptor> moveItemResponseInterceptor, Lazy<GQLGetItemResponseInterceptor> gqlGetItemResponseInterceptor, Lazy<GQLGetItemWithWatermarkDataResponseInterceptor> gqlGetItemWithWatermarkDataResponseInterceptor, Lazy<GQLGetFolderMiniResponseInterceptor> gqlGetFolderMiniResponseInterceptor, Lazy<GQLGetFolderMiniWithParentResponseInterceptor> gqlGetFolderMiniWithParentResponseInterceptor) {
        super(moshi);
        Intrinsics.checkNotNullParameter(apolloClientConfigurator, "apolloClientConfigurator");
        Intrinsics.checkNotNullParameter(requestParser, "requestParser");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(collectionsResponseInterceptor, "collectionsResponseInterceptor");
        Intrinsics.checkNotNullParameter(collectionItemsResponseInterceptor, "collectionItemsResponseInterceptor");
        Intrinsics.checkNotNullParameter(collectionsWithItemResponseInterceptor, "collectionsWithItemResponseInterceptor");
        Intrinsics.checkNotNullParameter(createCollectionResponseInterceptor, "createCollectionResponseInterceptor");
        Intrinsics.checkNotNullParameter(removeCollectionItemResponseInterceptor, "removeCollectionItemResponseInterceptor");
        Intrinsics.checkNotNullParameter(createCollectionItemResponseInterceptor, "createCollectionItemResponseInterceptor");
        Intrinsics.checkNotNullParameter(createFolderResponseInterceptor, "createFolderResponseInterceptor");
        Intrinsics.checkNotNullParameter(gqlGetFolderItemsResponseInterceptor, "gqlGetFolderItemsResponseInterceptor");
        Intrinsics.checkNotNullParameter(copyItemResponseInterceptor, "copyItemResponseInterceptor");
        Intrinsics.checkNotNullParameter(moveItemResponseInterceptor, "moveItemResponseInterceptor");
        Intrinsics.checkNotNullParameter(gqlGetItemResponseInterceptor, "gqlGetItemResponseInterceptor");
        Intrinsics.checkNotNullParameter(gqlGetItemWithWatermarkDataResponseInterceptor, "gqlGetItemWithWatermarkDataResponseInterceptor");
        Intrinsics.checkNotNullParameter(gqlGetFolderMiniResponseInterceptor, "gqlGetFolderMiniResponseInterceptor");
        Intrinsics.checkNotNullParameter(gqlGetFolderMiniWithParentResponseInterceptor, "gqlGetFolderMiniWithParentResponseInterceptor");
        this.apolloClientConfigurator = apolloClientConfigurator;
        this.requestParser = requestParser;
        this.moshi = moshi;
        this.featureFlips = featureFlips;
        this.collectionsResponseInterceptor = collectionsResponseInterceptor;
        this.collectionItemsResponseInterceptor = collectionItemsResponseInterceptor;
        this.collectionsWithItemResponseInterceptor = collectionsWithItemResponseInterceptor;
        this.createCollectionResponseInterceptor = createCollectionResponseInterceptor;
        this.removeCollectionItemResponseInterceptor = removeCollectionItemResponseInterceptor;
        this.createCollectionItemResponseInterceptor = createCollectionItemResponseInterceptor;
        this.createFolderResponseInterceptor = createFolderResponseInterceptor;
        this.gqlGetFolderItemsResponseInterceptor = gqlGetFolderItemsResponseInterceptor;
        this.copyItemResponseInterceptor = copyItemResponseInterceptor;
        this.moveItemResponseInterceptor = moveItemResponseInterceptor;
        this.gqlGetItemResponseInterceptor = gqlGetItemResponseInterceptor;
        this.gqlGetItemWithWatermarkDataResponseInterceptor = gqlGetItemWithWatermarkDataResponseInterceptor;
        this.gqlGetFolderMiniResponseInterceptor = gqlGetFolderMiniResponseInterceptor;
        this.gqlGetFolderMiniWithParentResponseInterceptor = gqlGetFolderMiniWithParentResponseInterceptor;
    }

    @Override // com.box.android.data.datasource.gql.GQLBaseInterceptor
    public Moshi getMoshi() {
        return this.moshi;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response response;
        Intrinsics.checkNotNullParameter(chain, "chain");
        String operationName = this.requestParser.parseOperationName(chain.request());
        if (operationName == null || (response = toResponse(operationName, chain)) == null) {
            throw new IOException("Could not parse operation name!");
        }
        return response;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Response toResponse(String operationName, Interceptor.Chain chain) throws IOException {
        ApolloStore apolloStore;
        ApolloStore apolloStore2;
        switch (operationName.hashCode()) {
            case -1876604500:
                if (operationName.equals(GetCollectionItemsQuery.OPERATION_NAME)) {
                    ApolloClient apolloClient = this.apolloClientConfigurator.getApolloClient();
                    if (apolloClient != null && (apolloStore = NormalizedCache.getApolloStore(apolloClient)) != null) {
                        this.collectionItemsResponseInterceptor.get().setApolloStore(apolloStore);
                        GQLCollectionItemsResponseInterceptor gQLCollectionItemsResponseInterceptor = this.collectionItemsResponseInterceptor.get();
                        Intrinsics.checkNotNullExpressionValue(gQLCollectionItemsResponseInterceptor, "get(...)");
                        Response responseInterceptIfNecessary = interceptIfNecessary(gQLCollectionItemsResponseInterceptor, chain);
                        if (responseInterceptIfNecessary != null) {
                            return responseInterceptIfNecessary;
                        }
                    }
                    throw new IOException("ApolloStore could not be found!");
                }
                break;
            case -1551793444:
                if (operationName.equals(GetFolderItemsQuery.OPERATION_NAME)) {
                    GQLGetFolderItemsResponseInterceptor gQLGetFolderItemsResponseInterceptor = this.gqlGetFolderItemsResponseInterceptor.get();
                    Intrinsics.checkNotNullExpressionValue(gQLGetFolderItemsResponseInterceptor, "get(...)");
                    return interceptIfNecessary(gQLGetFolderItemsResponseInterceptor, chain);
                }
                break;
            case -758553382:
                if (operationName.equals(CreateCollectionMutation.OPERATION_NAME)) {
                    String name = this.requestParser.parseName(chain.request());
                    if (name != null) {
                        this.createCollectionResponseInterceptor.get().setName(name);
                    }
                    GQLCreateCollectionResponseInterceptor gQLCreateCollectionResponseInterceptor = this.createCollectionResponseInterceptor.get();
                    Intrinsics.checkNotNullExpressionValue(gQLCreateCollectionResponseInterceptor, "get(...)");
                    return interceptIfNecessary(gQLCreateCollectionResponseInterceptor, chain);
                }
                break;
            case -744859891:
                if (operationName.equals(CreateCollectionItemMutation.OPERATION_NAME)) {
                    ApolloClient apolloClient2 = this.apolloClientConfigurator.getApolloClient();
                    if (apolloClient2 != null && (apolloStore2 = NormalizedCache.getApolloStore(apolloClient2)) != null) {
                        this.createCollectionItemResponseInterceptor.get().setApolloStore(apolloStore2);
                        GQLCreateCollectionItemResponseInterceptor gQLCreateCollectionItemResponseInterceptor = this.createCollectionItemResponseInterceptor.get();
                        Intrinsics.checkNotNullExpressionValue(gQLCreateCollectionItemResponseInterceptor, "get(...)");
                        Response responseInterceptIfNecessary2 = interceptIfNecessary(gQLCreateCollectionItemResponseInterceptor, chain);
                        if (responseInterceptIfNecessary2 != null) {
                            return responseInterceptIfNecessary2;
                        }
                    }
                    throw new IOException("ApolloStore could not be found!");
                }
                break;
            case -441630648:
                if (operationName.equals("CopyItem")) {
                    GQLCopyItemResponseInterceptor gQLCopyItemResponseInterceptor = this.copyItemResponseInterceptor.get();
                    Intrinsics.checkNotNullExpressionValue(gQLCopyItemResponseInterceptor, "get(...)");
                    return interceptIfNecessary(gQLCopyItemResponseInterceptor, chain);
                }
                break;
            case -331752068:
                if (operationName.equals(DeleteCollectionItemMutation.OPERATION_NAME)) {
                    GQLRemoveCollectionItemResponseInterceptor gQLRemoveCollectionItemResponseInterceptor = this.removeCollectionItemResponseInterceptor.get();
                    Intrinsics.checkNotNullExpressionValue(gQLRemoveCollectionItemResponseInterceptor, "get(...)");
                    return interceptIfNecessary(gQLRemoveCollectionItemResponseInterceptor, chain);
                }
                break;
            case -327043653:
                if (operationName.equals(GetFolderMiniQuery.OPERATION_NAME)) {
                    GQLGetFolderMiniResponseInterceptor gQLGetFolderMiniResponseInterceptor = this.gqlGetFolderMiniResponseInterceptor.get();
                    Intrinsics.checkNotNullExpressionValue(gQLGetFolderMiniResponseInterceptor, "get(...)");
                    return interceptIfNecessary(gQLGetFolderMiniResponseInterceptor, chain);
                }
                break;
            case -40091996:
                if (operationName.equals("MoveItem")) {
                    GQLMoveItemResponseInterceptor gQLMoveItemResponseInterceptor = this.moveItemResponseInterceptor.get();
                    Intrinsics.checkNotNullExpressionValue(gQLMoveItemResponseInterceptor, "get(...)");
                    return interceptIfNecessary(gQLMoveItemResponseInterceptor, chain);
                }
                break;
            case 512213514:
                if (operationName.equals(GetAllCollectionsQuery.OPERATION_NAME)) {
                    GQLCollectionsResponseInterceptor gQLCollectionsResponseInterceptor = this.collectionsResponseInterceptor.get();
                    Intrinsics.checkNotNullExpressionValue(gQLCollectionsResponseInterceptor, "get(...)");
                    return interceptIfNecessary(gQLCollectionsResponseInterceptor, chain);
                }
                break;
            case 1323126954:
                if (operationName.equals(CreateFolderMutation.OPERATION_NAME)) {
                    GQLCreateFolderResponseInterceptor gQLCreateFolderResponseInterceptor = this.createFolderResponseInterceptor.get();
                    Intrinsics.checkNotNullExpressionValue(gQLCreateFolderResponseInterceptor, "get(...)");
                    return interceptIfNecessary(gQLCreateFolderResponseInterceptor, chain);
                }
                break;
            case 1354508927:
                if (operationName.equals(GetItemWithWatermarkDataQuery.OPERATION_NAME)) {
                    GQLGetItemWithWatermarkDataResponseInterceptor gQLGetItemWithWatermarkDataResponseInterceptor = this.gqlGetItemWithWatermarkDataResponseInterceptor.get();
                    Intrinsics.checkNotNullExpressionValue(gQLGetItemWithWatermarkDataResponseInterceptor, "get(...)");
                    return interceptIfNecessary(gQLGetItemWithWatermarkDataResponseInterceptor, chain);
                }
                break;
            case 1589214057:
                if (operationName.equals(GetItemQuery.OPERATION_NAME)) {
                    GQLGetItemResponseInterceptor gQLGetItemResponseInterceptor = this.gqlGetItemResponseInterceptor.get();
                    Intrinsics.checkNotNullExpressionValue(gQLGetItemResponseInterceptor, "get(...)");
                    return interceptIfNecessary(gQLGetItemResponseInterceptor, chain);
                }
                break;
            case 1733909803:
                if (operationName.equals(GetFolderMiniWithParentQuery.OPERATION_NAME)) {
                    GQLGetFolderMiniWithParentResponseInterceptor gQLGetFolderMiniWithParentResponseInterceptor = this.gqlGetFolderMiniWithParentResponseInterceptor.get();
                    Intrinsics.checkNotNullExpressionValue(gQLGetFolderMiniWithParentResponseInterceptor, "get(...)");
                    return interceptIfNecessary(gQLGetFolderMiniWithParentResponseInterceptor, chain);
                }
                break;
            case 1906014872:
                if (operationName.equals(GetCollectionsWithItemQuery.OPERATION_NAME)) {
                    GQLCollectionsWithItemResponseInterceptor gQLCollectionsWithItemResponseInterceptor = this.collectionsWithItemResponseInterceptor.get();
                    Intrinsics.checkNotNullExpressionValue(gQLCollectionsWithItemResponseInterceptor, "get(...)");
                    return interceptIfNecessary(gQLCollectionsWithItemResponseInterceptor, chain);
                }
                break;
        }
        return chain.proceed(chain.request());
    }

    public final Response interceptIfNecessary(GQLBaseInterceptor interceptor, Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (this.featureFlips.getUseGraphQLEndpoints().getEnabled() && (interceptor instanceof BoxGQLEndpointSupport)) {
            return chain.proceed(chain.request());
        }
        return interceptor.intercept(chain);
    }
}
