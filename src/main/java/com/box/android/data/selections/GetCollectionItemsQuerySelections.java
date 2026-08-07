package com.box.android.data.selections;

import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledFragment;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledVariable;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.type.Collection;
import com.box.android.data.type.CollectionItemConnection;
import com.box.android.data.type.CollectionItemEdge;
import com.box.android.data.type.DateTime;
import com.box.android.data.type.Folder;
import com.box.android.data.type.GraphQLBoolean;
import com.box.android.data.type.GraphQLID;
import com.box.android.data.type.GraphQLString;
import com.box.android.data.type.Item;
import com.box.android.data.type.ItemType;
import com.box.android.data.type.PermissionsV2API;
import com.box.android.data.type.SafeInt;
import com.box.android.data.type.SharedLink;
import com.box.android.data.type.URL;
import com.box.android.data.type.User;
import com.box.android.data.type.Watermark;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxCollection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: GetCollectionItemsQuerySelections.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/box/android/data/selections/GetCollectionItemsQuerySelections;", "", "<init>", "()V", "__ownedBy", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "__updatedBy", "__watermark", "__parent", "__permissionsV2Api", "__sharedLink", "__onFile", "__ownedBy1", "__updatedBy1", "__parent1", "__permissionsV2Api1", "__sharedLink1", "__onFolder", "__ownedBy2", "__updatedBy2", "__parent2", "__permissionsV2Api2", "__sharedLink2", "__onWeblink", "__node", "__edges", "__collectionItemConnection", "__collection", "__root", "get__root", "()Ljava/util/List;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetCollectionItemsQuerySelections {
    public static final GetCollectionItemsQuerySelections INSTANCE = new GetCollectionItemsQuerySelections();
    private static final List<CompiledSelection> __collection;
    private static final List<CompiledSelection> __collectionItemConnection;
    private static final List<CompiledSelection> __edges;
    private static final List<CompiledSelection> __node;
    private static final List<CompiledSelection> __onFile;
    private static final List<CompiledSelection> __onFolder;
    private static final List<CompiledSelection> __onWeblink;
    private static final List<CompiledSelection> __ownedBy;
    private static final List<CompiledSelection> __ownedBy1;
    private static final List<CompiledSelection> __ownedBy2;
    private static final List<CompiledSelection> __parent;
    private static final List<CompiledSelection> __parent1;
    private static final List<CompiledSelection> __parent2;
    private static final List<CompiledSelection> __permissionsV2Api;
    private static final List<CompiledSelection> __permissionsV2Api1;
    private static final List<CompiledSelection> __permissionsV2Api2;
    private static final List<CompiledSelection> __root;
    private static final List<CompiledSelection> __sharedLink;
    private static final List<CompiledSelection> __sharedLink1;
    private static final List<CompiledSelection> __sharedLink2;
    private static final List<CompiledSelection> __updatedBy;
    private static final List<CompiledSelection> __updatedBy1;
    private static final List<CompiledSelection> __updatedBy2;
    private static final List<CompiledSelection> __watermark;

    private GetCollectionItemsQuerySelections() {
    }

    static {
        List<CompiledSelection> listListOf = CollectionsKt.listOf(new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build());
        __ownedBy = listListOf;
        List<CompiledSelection> listListOf2 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __updatedBy = listListOf2;
        List<CompiledSelection> listListOf3 = CollectionsKt.listOf(new CompiledField.Builder("isWatermarked", GraphQLBoolean.INSTANCE.getType()).build());
        __watermark = listListOf3;
        List<CompiledSelection> listListOf4 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __parent = listListOf4;
        List<CompiledSelection> listListOf5 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("canInviteCollaborator", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canSetShareAccess", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canDownload", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canPreview", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canComment", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canUpload", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canRename", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canDelete", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canShare", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canViewAnnotations", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canCreateAnnotations", GraphQLBoolean.INSTANCE.getType()).build()});
        __permissionsV2Api = listListOf5;
        List<CompiledSelection> listListOf6 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("url", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("effectiveAccess", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("effectivePermission", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("isPasswordEnabled", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("unsharedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("canDownload", GraphQLBoolean.INSTANCE.getType()).build()});
        __sharedLink = listListOf6;
        List<CompiledSelection> listListOf7 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("type", CompiledGraphQL.m11195notNull(ItemType.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("size", SafeInt.INSTANCE.getType()).build(), new CompiledField.Builder("createdAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("updatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("contentCreatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("contentUpdatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("ownedBy", User.INSTANCE.getType()).selections(listListOf).build(), new CompiledField.Builder("updatedBy", User.INSTANCE.getType()).selections(listListOf2).build(), new CompiledField.Builder("hasCollaborations", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("isExternallyOwned", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("sha1", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("watermark", Watermark.INSTANCE.getType()).selections(listListOf3).build(), new CompiledField.Builder("parent", Folder.INSTANCE.getType()).selections(listListOf4).build(), new CompiledField.Builder("permissionsV2Api", PermissionsV2API.INSTANCE.getType()).selections(listListOf5).build(), new CompiledField.Builder(BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, SharedLink.INSTANCE.getType()).selections(listListOf6).build()});
        __onFile = listListOf7;
        List<CompiledSelection> listListOf8 = CollectionsKt.listOf(new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build());
        __ownedBy1 = listListOf8;
        List<CompiledSelection> listListOf9 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __updatedBy1 = listListOf9;
        List<CompiledSelection> listListOf10 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __parent1 = listListOf10;
        List<CompiledSelection> listListOf11 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("canInviteCollaborator", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canSetShareAccess", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canDownload", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canPreview", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canComment", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canUpload", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canRename", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canDelete", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canShare", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canViewAnnotations", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canCreateAnnotations", GraphQLBoolean.INSTANCE.getType()).build()});
        __permissionsV2Api1 = listListOf11;
        List<CompiledSelection> listListOf12 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("url", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("effectiveAccess", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("effectivePermission", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("isPasswordEnabled", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("unsharedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("canDownload", GraphQLBoolean.INSTANCE.getType()).build()});
        __sharedLink1 = listListOf12;
        List<CompiledSelection> listListOf13 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("type", CompiledGraphQL.m11195notNull(ItemType.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("size", SafeInt.INSTANCE.getType()).build(), new CompiledField.Builder("createdAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("updatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("contentCreatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("contentUpdatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("ownedBy", User.INSTANCE.getType()).selections(listListOf8).build(), new CompiledField.Builder("updatedBy", User.INSTANCE.getType()).selections(listListOf9).build(), new CompiledField.Builder("hasCollaborations", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("isExternallyOwned", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("parent", Folder.INSTANCE.getType()).selections(listListOf10).build(), new CompiledField.Builder("permissionsV2Api", PermissionsV2API.INSTANCE.getType()).selections(listListOf11).build(), new CompiledField.Builder(BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, SharedLink.INSTANCE.getType()).selections(listListOf12).build()});
        __onFolder = listListOf13;
        List<CompiledSelection> listListOf14 = CollectionsKt.listOf(new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build());
        __ownedBy2 = listListOf14;
        List<CompiledSelection> listListOf15 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __updatedBy2 = listListOf15;
        List<CompiledSelection> listListOf16 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __parent2 = listListOf16;
        List<CompiledSelection> listListOf17 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("canInviteCollaborator", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canSetShareAccess", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canDownload", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canPreview", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canComment", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canUpload", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canRename", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canDelete", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canShare", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canViewAnnotations", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canCreateAnnotations", GraphQLBoolean.INSTANCE.getType()).build()});
        __permissionsV2Api2 = listListOf17;
        List<CompiledSelection> listListOf18 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("url", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("effectiveAccess", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("effectivePermission", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("isPasswordEnabled", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("unsharedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("canDownload", GraphQLBoolean.INSTANCE.getType()).build()});
        __sharedLink2 = listListOf18;
        List<CompiledSelection> listListOf19 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("type", CompiledGraphQL.m11195notNull(ItemType.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("createdAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("updatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("contentCreatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("contentUpdatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("ownedBy", User.INSTANCE.getType()).selections(listListOf14).build(), new CompiledField.Builder("updatedBy", User.INSTANCE.getType()).selections(listListOf15).build(), new CompiledField.Builder("url", URL.INSTANCE.getType()).build(), new CompiledField.Builder("parent", Folder.INSTANCE.getType()).selections(listListOf16).build(), new CompiledField.Builder("permissionsV2Api", PermissionsV2API.INSTANCE.getType()).selections(listListOf17).build(), new CompiledField.Builder(BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, SharedLink.INSTANCE.getType()).selections(listListOf18).build()});
        __onWeblink = listListOf19;
        List<CompiledSelection> listListOf20 = CollectionsKt.listOf((Object[]) new CompiledSelection[]{new CompiledField.Builder(GQLCacheConstants.TYPENAME_KEY, CompiledGraphQL.m11195notNull(GraphQLString.INSTANCE.getType())).build(), new CompiledFragment.Builder("File", CollectionsKt.listOf("File")).selections(listListOf7).build(), new CompiledFragment.Builder("Folder", CollectionsKt.listOf("Folder")).selections(listListOf13).build(), new CompiledFragment.Builder("Weblink", CollectionsKt.listOf("Weblink")).selections(listListOf19).build()});
        __node = listListOf20;
        List<CompiledSelection> listListOf21 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("cursor", GraphQLString.INSTANCE.getType()).alias("id").build(), new CompiledField.Builder("node", CompiledGraphQL.m11195notNull(Item.INSTANCE.getType())).selections(listListOf20).build()});
        __edges = listListOf21;
        List<CompiledSelection> listListOf22 = CollectionsKt.listOf(new CompiledField.Builder("edges", CompiledGraphQL.m11195notNull(CompiledGraphQL.m11194list(CompiledGraphQL.m11195notNull(CollectionItemEdge.INSTANCE.getType())))).selections(listListOf21).build());
        __collectionItemConnection = listListOf22;
        List<CompiledSelection> listListOf23 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("collectionItemConnection", CollectionItemConnection.INSTANCE.getType()).selections(listListOf22).build()});
        __collection = listListOf23;
        __root = CollectionsKt.listOf(new CompiledField.Builder(BoxCollection.TYPE, Collection.INSTANCE.getType()).arguments(CollectionsKt.listOf(new CompiledArgument.Builder("id", new CompiledVariable("id")).build())).selections(listListOf23).build());
    }

    public final List<CompiledSelection> get__root() {
        return __root;
    }
}
