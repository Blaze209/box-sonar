package com.box.android.data.selections;

import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledFragment;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledVariable;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.type.Classification;
import com.box.android.data.type.Collection;
import com.box.android.data.type.DateTime;
import com.box.android.data.type.FileLockv2;
import com.box.android.data.type.FileVersion;
import com.box.android.data.type.Folder;
import com.box.android.data.type.GraphQLBoolean;
import com.box.android.data.type.GraphQLID;
import com.box.android.data.type.GraphQLInt;
import com.box.android.data.type.GraphQLString;
import com.box.android.data.type.Item;
import com.box.android.data.type.ItemCollectionConnection;
import com.box.android.data.type.ItemCollectionEdge;
import com.box.android.data.type.ItemType;
import com.box.android.data.type.PermissionsV2API;
import com.box.android.data.type.SafeInt;
import com.box.android.data.type.SharedLink;
import com.box.android.data.type.URL;
import com.box.android.data.type.User;
import com.box.android.data.type.Watermark;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxClassification;
import com.box.androidsdk.content.models.BoxItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: GetItemWithWatermarkDataQuerySelections.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/box/android/data/selections/GetItemWithWatermarkDataQuerySelections;", "", "<init>", "()V", "__node", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "__edges", "__itemCollectionConnection", "__classification", "__ownedBy", "__updatedBy", "__parent", "__permissionsV2Api", "__fileVersion", "__createdBy", "__fileLock", "__sharedLink", "__watermark", "__onFile", "__node1", "__edges1", "__itemCollectionConnection1", "__ownedBy1", "__updatedBy1", "__parent1", "__permissionsV2Api1", "__sharedLink1", "__watermark1", "__onFolder", "__node2", "__edges2", "__itemCollectionConnection2", "__ownedBy2", "__updatedBy2", "__parent2", "__permissionsV2Api2", "__sharedLink2", "__onWeblink", "__item", "__root", "get__root", "()Ljava/util/List;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetItemWithWatermarkDataQuerySelections {
    public static final GetItemWithWatermarkDataQuerySelections INSTANCE = new GetItemWithWatermarkDataQuerySelections();
    private static final List<CompiledSelection> __classification;
    private static final List<CompiledSelection> __createdBy;
    private static final List<CompiledSelection> __edges;
    private static final List<CompiledSelection> __edges1;
    private static final List<CompiledSelection> __edges2;
    private static final List<CompiledSelection> __fileLock;
    private static final List<CompiledSelection> __fileVersion;
    private static final List<CompiledSelection> __item;
    private static final List<CompiledSelection> __itemCollectionConnection;
    private static final List<CompiledSelection> __itemCollectionConnection1;
    private static final List<CompiledSelection> __itemCollectionConnection2;
    private static final List<CompiledSelection> __node;
    private static final List<CompiledSelection> __node1;
    private static final List<CompiledSelection> __node2;
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
    private static final List<CompiledSelection> __watermark1;

    private GetItemWithWatermarkDataQuerySelections() {
    }

    static {
        List<CompiledSelection> listListOf = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("collectionType", GraphQLString.INSTANCE.getType()).build()});
        __node = listListOf;
        List<CompiledSelection> listListOf2 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("cursor", GraphQLString.INSTANCE.getType()).alias("id").build(), new CompiledField.Builder("node", CompiledGraphQL.m11195notNull(Collection.INSTANCE.getType())).selections(listListOf).build()});
        __edges = listListOf2;
        List<CompiledSelection> listListOf3 = CollectionsKt.listOf(new CompiledField.Builder("edges", CompiledGraphQL.m11195notNull(CompiledGraphQL.m11194list(CompiledGraphQL.m11195notNull(ItemCollectionEdge.INSTANCE.getType())))).selections(listListOf2).build());
        __itemCollectionConnection = listListOf3;
        List<CompiledSelection> listListOf4 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("color", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder(BoxClassification.FIELD_DEFINITION, GraphQLString.INSTANCE.getType()).build()});
        __classification = listListOf4;
        List<CompiledSelection> listListOf5 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __ownedBy = listListOf5;
        List<CompiledSelection> listListOf6 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __updatedBy = listListOf6;
        List<CompiledSelection> listListOf7 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __parent = listListOf7;
        List<CompiledSelection> listListOf8 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("canComment", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canDelete", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canDownload", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canInviteCollaborator", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canPreview", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canRename", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canSetShareAccess", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canShare", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canUpload", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canViewAnnotations", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canCreateAnnotations", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canApplyWatermark", GraphQLBoolean.INSTANCE.getType()).build()});
        __permissionsV2Api = listListOf8;
        List<CompiledSelection> listListOf9 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("sha1", CompiledGraphQL.m11195notNull(GraphQLString.INSTANCE.getType())).build()});
        __fileVersion = listListOf9;
        List<CompiledSelection> listListOf10 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("login", GraphQLString.INSTANCE.getType()).build()});
        __createdBy = listListOf10;
        List<CompiledSelection> listListOf11 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("appType", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("createdAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("createdBy", User.INSTANCE.getType()).selections(listListOf10).build(), new CompiledField.Builder("expiresAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("isDownloadPrevented", GraphQLBoolean.INSTANCE.getType()).build()});
        __fileLock = listListOf11;
        List<CompiledSelection> listListOf12 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("url", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("effectiveAccess", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("effectivePermission", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("isPasswordEnabled", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("unsharedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("canDownload", GraphQLBoolean.INSTANCE.getType()).build()});
        __sharedLink = listListOf12;
        List<CompiledSelection> listListOf13 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("isWatermarked", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("isWatermarkInherited", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("isWatermarkedByAccessPolicy", GraphQLBoolean.INSTANCE.getType()).build()});
        __watermark = listListOf13;
        List<CompiledSelection> listListOf14 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("type", CompiledGraphQL.m11195notNull(ItemType.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("createdAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("updatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("description", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("contentCreatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("contentUpdatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("isRooted", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("commentCount", GraphQLInt.INSTANCE.getType()).build(), new CompiledField.Builder("annotationCount", GraphQLInt.INSTANCE.getType()).build(), new CompiledField.Builder("itemCollectionConnection", ItemCollectionConnection.INSTANCE.getType()).selections(listListOf3).build(), new CompiledField.Builder(BoxItem.FIELD_CLASSIFICATION, Classification.INSTANCE.getType()).selections(listListOf4).build(), new CompiledField.Builder("size", SafeInt.INSTANCE.getType()).build(), new CompiledField.Builder("hasCollaborations", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("isExternallyOwned", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("sha1", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("ownedBy", User.INSTANCE.getType()).selections(listListOf5).build(), new CompiledField.Builder("updatedBy", User.INSTANCE.getType()).selections(listListOf6).build(), new CompiledField.Builder("parent", Folder.INSTANCE.getType()).selections(listListOf7).build(), new CompiledField.Builder("permissionsV2Api", PermissionsV2API.INSTANCE.getType()).selections(listListOf8).build(), new CompiledField.Builder("fileVersion", FileVersion.INSTANCE.getType()).selections(listListOf9).build(), new CompiledField.Builder("fileLock", FileLockv2.INSTANCE.getType()).selections(listListOf11).build(), new CompiledField.Builder(BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, SharedLink.INSTANCE.getType()).selections(listListOf12).build(), new CompiledField.Builder("watermark", Watermark.INSTANCE.getType()).selections(listListOf13).build()});
        __onFile = listListOf14;
        List<CompiledSelection> listListOf15 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("collectionType", GraphQLString.INSTANCE.getType()).build()});
        __node1 = listListOf15;
        List<CompiledSelection> listListOf16 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("cursor", GraphQLString.INSTANCE.getType()).alias("id").build(), new CompiledField.Builder("node", CompiledGraphQL.m11195notNull(Collection.INSTANCE.getType())).selections(listListOf15).build()});
        __edges1 = listListOf16;
        List<CompiledSelection> listListOf17 = CollectionsKt.listOf(new CompiledField.Builder("edges", CompiledGraphQL.m11195notNull(CompiledGraphQL.m11194list(CompiledGraphQL.m11195notNull(ItemCollectionEdge.INSTANCE.getType())))).selections(listListOf16).build());
        __itemCollectionConnection1 = listListOf17;
        List<CompiledSelection> listListOf18 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __ownedBy1 = listListOf18;
        List<CompiledSelection> listListOf19 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __updatedBy1 = listListOf19;
        List<CompiledSelection> listListOf20 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __parent1 = listListOf20;
        List<CompiledSelection> listListOf21 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("canDelete", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canDownload", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canInviteCollaborator", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canRename", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canSetShareAccess", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canShare", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canUpload", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canPreview", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canComment", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canViewAnnotations", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canCreateAnnotations", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canApplyWatermark", GraphQLBoolean.INSTANCE.getType()).build()});
        __permissionsV2Api1 = listListOf21;
        List<CompiledSelection> listListOf22 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("url", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("effectiveAccess", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("effectivePermission", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("isPasswordEnabled", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("unsharedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("canDownload", GraphQLBoolean.INSTANCE.getType()).build()});
        __sharedLink1 = listListOf22;
        List<CompiledSelection> listListOf23 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("isWatermarked", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("isWatermarkInherited", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("isWatermarkedByAccessPolicy", GraphQLBoolean.INSTANCE.getType()).build()});
        __watermark1 = listListOf23;
        List<CompiledSelection> listListOf24 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("type", CompiledGraphQL.m11195notNull(ItemType.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("createdAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("description", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("updatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("contentCreatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("contentUpdatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("isRooted", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("itemCollectionConnection", ItemCollectionConnection.INSTANCE.getType()).selections(listListOf17).build(), new CompiledField.Builder("size", SafeInt.INSTANCE.getType()).build(), new CompiledField.Builder("hasCollaborations", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("isExternallyOwned", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("ownedBy", User.INSTANCE.getType()).selections(listListOf18).build(), new CompiledField.Builder("updatedBy", User.INSTANCE.getType()).selections(listListOf19).build(), new CompiledField.Builder("parent", Folder.INSTANCE.getType()).selections(listListOf20).build(), new CompiledField.Builder("permissionsV2Api", PermissionsV2API.INSTANCE.getType()).selections(listListOf21).build(), new CompiledField.Builder(BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, SharedLink.INSTANCE.getType()).selections(listListOf22).build(), new CompiledField.Builder("watermark", Watermark.INSTANCE.getType()).selections(listListOf23).build()});
        __onFolder = listListOf24;
        List<CompiledSelection> listListOf25 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("collectionType", GraphQLString.INSTANCE.getType()).build()});
        __node2 = listListOf25;
        List<CompiledSelection> listListOf26 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("cursor", GraphQLString.INSTANCE.getType()).alias("id").build(), new CompiledField.Builder("node", CompiledGraphQL.m11195notNull(Collection.INSTANCE.getType())).selections(listListOf25).build()});
        __edges2 = listListOf26;
        List<CompiledSelection> listListOf27 = CollectionsKt.listOf(new CompiledField.Builder("edges", CompiledGraphQL.m11195notNull(CompiledGraphQL.m11194list(CompiledGraphQL.m11195notNull(ItemCollectionEdge.INSTANCE.getType())))).selections(listListOf26).build());
        __itemCollectionConnection2 = listListOf27;
        List<CompiledSelection> listListOf28 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __ownedBy2 = listListOf28;
        List<CompiledSelection> listListOf29 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __updatedBy2 = listListOf29;
        List<CompiledSelection> listListOf30 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __parent2 = listListOf30;
        List<CompiledSelection> listListOf31 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("canInviteCollaborator", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canSetShareAccess", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canDownload", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canPreview", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canComment", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canUpload", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canRename", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canDelete", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canShare", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canViewAnnotations", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canCreateAnnotations", GraphQLBoolean.INSTANCE.getType()).build()});
        __permissionsV2Api2 = listListOf31;
        List<CompiledSelection> listListOf32 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("url", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("effectiveAccess", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("effectivePermission", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("isPasswordEnabled", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("unsharedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("canDownload", GraphQLBoolean.INSTANCE.getType()).build()});
        __sharedLink2 = listListOf32;
        List<CompiledSelection> listListOf33 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("type", CompiledGraphQL.m11195notNull(ItemType.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("createdAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("description", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("updatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("isRooted", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("itemCollectionConnection", ItemCollectionConnection.INSTANCE.getType()).selections(listListOf27).build(), new CompiledField.Builder("url", URL.INSTANCE.getType()).build(), new CompiledField.Builder("ownedBy", User.INSTANCE.getType()).selections(listListOf28).build(), new CompiledField.Builder("updatedBy", User.INSTANCE.getType()).selections(listListOf29).build(), new CompiledField.Builder("parent", Folder.INSTANCE.getType()).selections(listListOf30).build(), new CompiledField.Builder("permissionsV2Api", PermissionsV2API.INSTANCE.getType()).selections(listListOf31).build(), new CompiledField.Builder(BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, SharedLink.INSTANCE.getType()).selections(listListOf32).build()});
        __onWeblink = listListOf33;
        List<CompiledSelection> listListOf34 = CollectionsKt.listOf((Object[]) new CompiledSelection[]{new CompiledField.Builder(GQLCacheConstants.TYPENAME_KEY, CompiledGraphQL.m11195notNull(GraphQLString.INSTANCE.getType())).build(), new CompiledFragment.Builder("File", CollectionsKt.listOf("File")).selections(listListOf14).build(), new CompiledFragment.Builder("Folder", CollectionsKt.listOf("Folder")).selections(listListOf24).build(), new CompiledFragment.Builder("Weblink", CollectionsKt.listOf("Weblink")).selections(listListOf33).build()});
        __item = listListOf34;
        __root = CollectionsKt.listOf(new CompiledField.Builder("item", Item.INSTANCE.getType()).arguments(CollectionsKt.listOf((Object[]) new CompiledArgument[]{new CompiledArgument.Builder("id", new CompiledVariable("itemId")).build(), new CompiledArgument.Builder("type", new CompiledVariable("type")).build()})).selections(listListOf34).build());
    }

    public final List<CompiledSelection> get__root() {
        return __root;
    }
}
