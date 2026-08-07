package com.box.android.data.selections;

import com.apollographql.apollo3.api.CompiledArgument;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledVariable;
import com.box.android.data.type.Collection;
import com.box.android.data.type.CreateFolderResponse;
import com.box.android.data.type.DateTime;
import com.box.android.data.type.Folder;
import com.box.android.data.type.GraphQLBoolean;
import com.box.android.data.type.GraphQLID;
import com.box.android.data.type.GraphQLString;
import com.box.android.data.type.ItemCollectionConnection;
import com.box.android.data.type.ItemCollectionEdge;
import com.box.android.data.type.ItemType;
import com.box.android.data.type.PermissionsV2API;
import com.box.android.data.type.SafeInt;
import com.box.android.data.type.User;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: CreateFolderMutationSelections.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/selections/CreateFolderMutationSelections;", "", "<init>", "()V", "__ownedBy", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "__parent", "__updatedBy", "__permissionsV2Api", "__node", "__edges", "__itemCollectionConnection", "__value", "__createFolder", "__root", "get__root", "()Ljava/util/List;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateFolderMutationSelections {
    public static final CreateFolderMutationSelections INSTANCE = new CreateFolderMutationSelections();
    private static final List<CompiledSelection> __createFolder;
    private static final List<CompiledSelection> __edges;
    private static final List<CompiledSelection> __itemCollectionConnection;
    private static final List<CompiledSelection> __node;
    private static final List<CompiledSelection> __ownedBy;
    private static final List<CompiledSelection> __parent;
    private static final List<CompiledSelection> __permissionsV2Api;
    private static final List<CompiledSelection> __root;
    private static final List<CompiledSelection> __updatedBy;
    private static final List<CompiledSelection> __value;

    private CreateFolderMutationSelections() {
    }

    static {
        List<CompiledSelection> listListOf = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __ownedBy = listListOf;
        List<CompiledSelection> listListOf2 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __parent = listListOf2;
        List<CompiledSelection> listListOf3 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build()});
        __updatedBy = listListOf3;
        List<CompiledSelection> listListOf4 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("canInviteCollaborator", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canSetShareAccess", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canDownload", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canPreview", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canComment", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canUpload", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canRename", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canDelete", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canShare", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canViewAnnotations", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("canCreateAnnotations", GraphQLBoolean.INSTANCE.getType()).build()});
        __permissionsV2Api = listListOf4;
        List<CompiledSelection> listListOf5 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("collectionType", GraphQLString.INSTANCE.getType()).build()});
        __node = listListOf5;
        List<CompiledSelection> listListOf6 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("cursor", GraphQLString.INSTANCE.getType()).alias("id").build(), new CompiledField.Builder("node", CompiledGraphQL.m11195notNull(Collection.INSTANCE.getType())).selections(listListOf5).build()});
        __edges = listListOf6;
        List<CompiledSelection> listListOf7 = CollectionsKt.listOf(new CompiledField.Builder("edges", CompiledGraphQL.m11195notNull(CompiledGraphQL.m11194list(CompiledGraphQL.m11195notNull(ItemCollectionEdge.INSTANCE.getType())))).selections(listListOf6).build());
        __itemCollectionConnection = listListOf7;
        List<CompiledSelection> listListOf8 = CollectionsKt.listOf((Object[]) new CompiledField[]{new CompiledField.Builder("id", CompiledGraphQL.m11195notNull(GraphQLID.INSTANCE.getType())).build(), new CompiledField.Builder("type", CompiledGraphQL.m11195notNull(ItemType.INSTANCE.getType())).build(), new CompiledField.Builder("name", GraphQLString.INSTANCE.getType()).build(), new CompiledField.Builder("size", SafeInt.INSTANCE.getType()).build(), new CompiledField.Builder("createdAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("updatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("contentCreatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("contentUpdatedAt", DateTime.INSTANCE.getType()).build(), new CompiledField.Builder("isRooted", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("ownedBy", User.INSTANCE.getType()).selections(listListOf).build(), new CompiledField.Builder("hasCollaborations", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("isExternallyOwned", GraphQLBoolean.INSTANCE.getType()).build(), new CompiledField.Builder("parent", Folder.INSTANCE.getType()).selections(listListOf2).build(), new CompiledField.Builder("updatedBy", User.INSTANCE.getType()).selections(listListOf3).build(), new CompiledField.Builder("permissionsV2Api", PermissionsV2API.INSTANCE.getType()).selections(listListOf4).build(), new CompiledField.Builder("itemCollectionConnection", ItemCollectionConnection.INSTANCE.getType()).selections(listListOf7).build()});
        __value = listListOf8;
        List<CompiledSelection> listListOf9 = CollectionsKt.listOf(new CompiledField.Builder("value", Folder.INSTANCE.getType()).selections(listListOf8).build());
        __createFolder = listListOf9;
        __root = CollectionsKt.listOf(new CompiledField.Builder("createFolder", CompiledGraphQL.m11195notNull(CreateFolderResponse.INSTANCE.getType())).arguments(CollectionsKt.listOf(new CompiledArgument.Builder("input", MapsKt.mapOf(TuplesKt.to("clientMutationId", new CompiledVariable("clientMutationId")), TuplesKt.to("name", new CompiledVariable("name")), TuplesKt.to(IdentificationData.FIELD_PARENT_ID, new CompiledVariable(IdentificationData.FIELD_PARENT_ID)))).build())).selections(listListOf9).build());
    }

    public final List<CompiledSelection> get__root() {
        return __root;
    }
}
