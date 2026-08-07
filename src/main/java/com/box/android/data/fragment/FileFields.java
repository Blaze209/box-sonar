package com.box.android.data.fragment;

import com.apollographql.apollo3.api.Fragment;
import com.box.android.data.type.ItemType;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.util.Date;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileFields.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bT\b\u0086\b\u0018\u00002\u00020\u0001:\fopqrstuvwxyzBé\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010!\u0012\b\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\b\u0010&\u001a\u0004\u0018\u00010'¢\u0006\u0004\b(\u0010)J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0006HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010Z\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00107J\u0010\u0010[\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u00107J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010c\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010#HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010%HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010'HÆ\u0003J\u009e\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'HÆ\u0001¢\u0006\u0002\u0010jJ\u0013\u0010k\u001a\u00020\r2\b\u0010l\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010m\u001a\u00020\u000fHÖ\u0001J\t\u0010n\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b2\u00100R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b3\u00100R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00105\u001a\u0004\b\f\u00104R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u00108\u001a\u0004\b9\u00107R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00105\u001a\u0004\bH\u00104R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u00105\u001a\u0004\b\u001e\u00104R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010+R\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\bP\u0010Q¨\u0006{"}, d2 = {"Lcom/box/android/data/fragment/FileFields;", "Lcom/apollographql/apollo3/api/Fragment$Data;", "id", "", "name", "type", "Lcom/box/android/data/type/ItemType;", "createdAt", "Ljava/util/Date;", "updatedAt", "contentCreatedAt", "contentUpdatedAt", "isRooted", "", "commentCount", "", "annotationCount", "ownedBy", "Lcom/box/android/data/fragment/FileFields$OwnedBy;", "updatedBy", "Lcom/box/android/data/fragment/FileFields$UpdatedBy;", "parent", "Lcom/box/android/data/fragment/FileFields$Parent;", "fileVersion", "Lcom/box/android/data/fragment/FileFields$FileVersion;", "itemCollectionConnection", "Lcom/box/android/data/fragment/FileFields$ItemCollectionConnection;", "size", "", "hasCollaborations", "isExternallyOwned", "sha1", "watermark", "Lcom/box/android/data/fragment/FileFields$Watermark;", "permissionsV2Api", "Lcom/box/android/data/fragment/FileFields$PermissionsV2Api;", "fileLock", "Lcom/box/android/data/fragment/FileFields$FileLock;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/data/fragment/FileFields$SharedLink;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/box/android/data/fragment/FileFields$OwnedBy;Lcom/box/android/data/fragment/FileFields$UpdatedBy;Lcom/box/android/data/fragment/FileFields$Parent;Lcom/box/android/data/fragment/FileFields$FileVersion;Lcom/box/android/data/fragment/FileFields$ItemCollectionConnection;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/box/android/data/fragment/FileFields$Watermark;Lcom/box/android/data/fragment/FileFields$PermissionsV2Api;Lcom/box/android/data/fragment/FileFields$FileLock;Lcom/box/android/data/fragment/FileFields$SharedLink;)V", "getId", "()Ljava/lang/String;", "getName", "getType", "()Lcom/box/android/data/type/ItemType;", "getCreatedAt", "()Ljava/util/Date;", "getUpdatedAt", "getContentCreatedAt", "getContentUpdatedAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCommentCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAnnotationCount", "getOwnedBy", "()Lcom/box/android/data/fragment/FileFields$OwnedBy;", "getUpdatedBy", "()Lcom/box/android/data/fragment/FileFields$UpdatedBy;", "getParent", "()Lcom/box/android/data/fragment/FileFields$Parent;", "getFileVersion", "()Lcom/box/android/data/fragment/FileFields$FileVersion;", "getItemCollectionConnection$annotations", "()V", "getItemCollectionConnection", "()Lcom/box/android/data/fragment/FileFields$ItemCollectionConnection;", "getSize", "()Ljava/lang/Object;", "getHasCollaborations", "getSha1", "getWatermark", "()Lcom/box/android/data/fragment/FileFields$Watermark;", "getPermissionsV2Api", "()Lcom/box/android/data/fragment/FileFields$PermissionsV2Api;", "getFileLock", "()Lcom/box/android/data/fragment/FileFields$FileLock;", "getSharedLink", "()Lcom/box/android/data/fragment/FileFields$SharedLink;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/box/android/data/fragment/FileFields$OwnedBy;Lcom/box/android/data/fragment/FileFields$UpdatedBy;Lcom/box/android/data/fragment/FileFields$Parent;Lcom/box/android/data/fragment/FileFields$FileVersion;Lcom/box/android/data/fragment/FileFields$ItemCollectionConnection;Ljava/lang/Object;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/box/android/data/fragment/FileFields$Watermark;Lcom/box/android/data/fragment/FileFields$PermissionsV2Api;Lcom/box/android/data/fragment/FileFields$FileLock;Lcom/box/android/data/fragment/FileFields$SharedLink;)Lcom/box/android/data/fragment/FileFields;", "equals", "other", "hashCode", "toString", "OwnedBy", "UpdatedBy", "Parent", "FileVersion", "ItemCollectionConnection", "Watermark", "PermissionsV2Api", "FileLock", "SharedLink", "Edge", "Node", "CreatedBy", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileFields implements Fragment.Data {
    private final Integer annotationCount;
    private final Integer commentCount;
    private final Date contentCreatedAt;
    private final Date contentUpdatedAt;
    private final Date createdAt;
    private final FileLock fileLock;
    private final FileVersion fileVersion;
    private final Boolean hasCollaborations;
    private final String id;
    private final Boolean isExternallyOwned;
    private final Boolean isRooted;
    private final ItemCollectionConnection itemCollectionConnection;
    private final String name;
    private final OwnedBy ownedBy;
    private final Parent parent;
    private final PermissionsV2Api permissionsV2Api;
    private final String sha1;
    private final SharedLink sharedLink;
    private final Object size;
    private final ItemType type;
    private final Date updatedAt;
    private final UpdatedBy updatedBy;
    private final Watermark watermark;

    public static /* synthetic */ FileFields copy$default(FileFields fileFields, String str, String str2, ItemType itemType, Date date, Date date2, Date date3, Date date4, Boolean bool, Integer num, Integer num2, OwnedBy ownedBy, UpdatedBy updatedBy, Parent parent, FileVersion fileVersion, ItemCollectionConnection itemCollectionConnection, Object obj, Boolean bool2, Boolean bool3, String str3, Watermark watermark, PermissionsV2Api permissionsV2Api, FileLock fileLock, SharedLink sharedLink, int i, Object obj2) {
        SharedLink sharedLink2;
        FileLock fileLock2;
        String str4 = (i & 1) != 0 ? fileFields.id : str;
        String str5 = (i & 2) != 0 ? fileFields.name : str2;
        ItemType itemType2 = (i & 4) != 0 ? fileFields.type : itemType;
        Date date5 = (i & 8) != 0 ? fileFields.createdAt : date;
        Date date6 = (i & 16) != 0 ? fileFields.updatedAt : date2;
        Date date7 = (i & 32) != 0 ? fileFields.contentCreatedAt : date3;
        Date date8 = (i & 64) != 0 ? fileFields.contentUpdatedAt : date4;
        Boolean bool4 = (i & 128) != 0 ? fileFields.isRooted : bool;
        Integer num3 = (i & 256) != 0 ? fileFields.commentCount : num;
        Integer num4 = (i & 512) != 0 ? fileFields.annotationCount : num2;
        OwnedBy ownedBy2 = (i & 1024) != 0 ? fileFields.ownedBy : ownedBy;
        UpdatedBy updatedBy2 = (i & 2048) != 0 ? fileFields.updatedBy : updatedBy;
        Parent parent2 = (i & 4096) != 0 ? fileFields.parent : parent;
        FileVersion fileVersion2 = (i & 8192) != 0 ? fileFields.fileVersion : fileVersion;
        String str6 = str4;
        ItemCollectionConnection itemCollectionConnection2 = (i & 16384) != 0 ? fileFields.itemCollectionConnection : itemCollectionConnection;
        Object obj3 = (i & 32768) != 0 ? fileFields.size : obj;
        Boolean bool5 = (i & 65536) != 0 ? fileFields.hasCollaborations : bool2;
        Boolean bool6 = (i & 131072) != 0 ? fileFields.isExternallyOwned : bool3;
        String str7 = (i & 262144) != 0 ? fileFields.sha1 : str3;
        Watermark watermark2 = (i & 524288) != 0 ? fileFields.watermark : watermark;
        PermissionsV2Api permissionsV2Api2 = (i & 1048576) != 0 ? fileFields.permissionsV2Api : permissionsV2Api;
        FileLock fileLock3 = (i & 2097152) != 0 ? fileFields.fileLock : fileLock;
        if ((i & 4194304) != 0) {
            fileLock2 = fileLock3;
            sharedLink2 = fileFields.sharedLink;
        } else {
            sharedLink2 = sharedLink;
            fileLock2 = fileLock3;
        }
        return fileFields.copy(str6, str5, itemType2, date5, date6, date7, date8, bool4, num3, num4, ownedBy2, updatedBy2, parent2, fileVersion2, itemCollectionConnection2, obj3, bool5, bool6, str7, watermark2, permissionsV2Api2, fileLock2, sharedLink2);
    }

    @Deprecated(message = "use collectionConnection query")
    public static /* synthetic */ void getItemCollectionConnection$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getAnnotationCount() {
        return this.annotationCount;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final OwnedBy getOwnedBy() {
        return this.ownedBy;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final UpdatedBy getUpdatedBy() {
        return this.updatedBy;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Parent getParent() {
        return this.parent;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final FileVersion getFileVersion() {
        return this.fileVersion;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final ItemCollectionConnection getItemCollectionConnection() {
        return this.itemCollectionConnection;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Object getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Boolean getHasCollaborations() {
        return this.hasCollaborations;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Boolean getIsExternallyOwned() {
        return this.isExternallyOwned;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getSha1() {
        return this.sha1;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Watermark getWatermark() {
        return this.watermark;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final PermissionsV2Api getPermissionsV2Api() {
        return this.permissionsV2Api;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final FileLock getFileLock() {
        return this.fileLock;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final SharedLink getSharedLink() {
        return this.sharedLink;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ItemType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Date getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Date getContentCreatedAt() {
        return this.contentCreatedAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Date getContentUpdatedAt() {
        return this.contentUpdatedAt;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getIsRooted() {
        return this.isRooted;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getCommentCount() {
        return this.commentCount;
    }

    public final FileFields copy(String id, String name, ItemType type, Date createdAt, Date updatedAt, Date contentCreatedAt, Date contentUpdatedAt, Boolean isRooted, Integer commentCount, Integer annotationCount, OwnedBy ownedBy, UpdatedBy updatedBy, Parent parent, FileVersion fileVersion, ItemCollectionConnection itemCollectionConnection, Object size, Boolean hasCollaborations, Boolean isExternallyOwned, String sha1, Watermark watermark, PermissionsV2Api permissionsV2Api, FileLock fileLock, SharedLink sharedLink) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new FileFields(id, name, type, createdAt, updatedAt, contentCreatedAt, contentUpdatedAt, isRooted, commentCount, annotationCount, ownedBy, updatedBy, parent, fileVersion, itemCollectionConnection, size, hasCollaborations, isExternallyOwned, sha1, watermark, permissionsV2Api, fileLock, sharedLink);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileFields)) {
            return false;
        }
        FileFields fileFields = (FileFields) other;
        return Intrinsics.areEqual(this.id, fileFields.id) && Intrinsics.areEqual(this.name, fileFields.name) && this.type == fileFields.type && Intrinsics.areEqual(this.createdAt, fileFields.createdAt) && Intrinsics.areEqual(this.updatedAt, fileFields.updatedAt) && Intrinsics.areEqual(this.contentCreatedAt, fileFields.contentCreatedAt) && Intrinsics.areEqual(this.contentUpdatedAt, fileFields.contentUpdatedAt) && Intrinsics.areEqual(this.isRooted, fileFields.isRooted) && Intrinsics.areEqual(this.commentCount, fileFields.commentCount) && Intrinsics.areEqual(this.annotationCount, fileFields.annotationCount) && Intrinsics.areEqual(this.ownedBy, fileFields.ownedBy) && Intrinsics.areEqual(this.updatedBy, fileFields.updatedBy) && Intrinsics.areEqual(this.parent, fileFields.parent) && Intrinsics.areEqual(this.fileVersion, fileFields.fileVersion) && Intrinsics.areEqual(this.itemCollectionConnection, fileFields.itemCollectionConnection) && Intrinsics.areEqual(this.size, fileFields.size) && Intrinsics.areEqual(this.hasCollaborations, fileFields.hasCollaborations) && Intrinsics.areEqual(this.isExternallyOwned, fileFields.isExternallyOwned) && Intrinsics.areEqual(this.sha1, fileFields.sha1) && Intrinsics.areEqual(this.watermark, fileFields.watermark) && Intrinsics.areEqual(this.permissionsV2Api, fileFields.permissionsV2Api) && Intrinsics.areEqual(this.fileLock, fileFields.fileLock) && Intrinsics.areEqual(this.sharedLink, fileFields.sharedLink);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode()) * 31;
        Date date = this.createdAt;
        int iHashCode3 = (iHashCode2 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.updatedAt;
        int iHashCode4 = (iHashCode3 + (date2 == null ? 0 : date2.hashCode())) * 31;
        Date date3 = this.contentCreatedAt;
        int iHashCode5 = (iHashCode4 + (date3 == null ? 0 : date3.hashCode())) * 31;
        Date date4 = this.contentUpdatedAt;
        int iHashCode6 = (iHashCode5 + (date4 == null ? 0 : date4.hashCode())) * 31;
        Boolean bool = this.isRooted;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.commentCount;
        int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.annotationCount;
        int iHashCode9 = (iHashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        OwnedBy ownedBy = this.ownedBy;
        int iHashCode10 = (iHashCode9 + (ownedBy == null ? 0 : ownedBy.hashCode())) * 31;
        UpdatedBy updatedBy = this.updatedBy;
        int iHashCode11 = (iHashCode10 + (updatedBy == null ? 0 : updatedBy.hashCode())) * 31;
        Parent parent = this.parent;
        int iHashCode12 = (iHashCode11 + (parent == null ? 0 : parent.hashCode())) * 31;
        FileVersion fileVersion = this.fileVersion;
        int iHashCode13 = (iHashCode12 + (fileVersion == null ? 0 : fileVersion.hashCode())) * 31;
        ItemCollectionConnection itemCollectionConnection = this.itemCollectionConnection;
        int iHashCode14 = (iHashCode13 + (itemCollectionConnection == null ? 0 : itemCollectionConnection.hashCode())) * 31;
        Object obj = this.size;
        int iHashCode15 = (iHashCode14 + (obj == null ? 0 : obj.hashCode())) * 31;
        Boolean bool2 = this.hasCollaborations;
        int iHashCode16 = (iHashCode15 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isExternallyOwned;
        int iHashCode17 = (iHashCode16 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str2 = this.sha1;
        int iHashCode18 = (iHashCode17 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Watermark watermark = this.watermark;
        int iHashCode19 = (iHashCode18 + (watermark == null ? 0 : watermark.hashCode())) * 31;
        PermissionsV2Api permissionsV2Api = this.permissionsV2Api;
        int iHashCode20 = (iHashCode19 + (permissionsV2Api == null ? 0 : permissionsV2Api.hashCode())) * 31;
        FileLock fileLock = this.fileLock;
        int iHashCode21 = (iHashCode20 + (fileLock == null ? 0 : fileLock.hashCode())) * 31;
        SharedLink sharedLink = this.sharedLink;
        return iHashCode21 + (sharedLink != null ? sharedLink.hashCode() : 0);
    }

    public String toString() {
        return "FileFields(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", contentCreatedAt=" + this.contentCreatedAt + ", contentUpdatedAt=" + this.contentUpdatedAt + ", isRooted=" + this.isRooted + ", commentCount=" + this.commentCount + ", annotationCount=" + this.annotationCount + ", ownedBy=" + this.ownedBy + ", updatedBy=" + this.updatedBy + ", parent=" + this.parent + ", fileVersion=" + this.fileVersion + ", itemCollectionConnection=" + this.itemCollectionConnection + ", size=" + this.size + ", hasCollaborations=" + this.hasCollaborations + ", isExternallyOwned=" + this.isExternallyOwned + ", sha1=" + this.sha1 + ", watermark=" + this.watermark + ", permissionsV2Api=" + this.permissionsV2Api + ", fileLock=" + this.fileLock + ", sharedLink=" + this.sharedLink + ")";
    }

    public FileFields(String id, String str, ItemType type, Date date, Date date2, Date date3, Date date4, Boolean bool, Integer num, Integer num2, OwnedBy ownedBy, UpdatedBy updatedBy, Parent parent, FileVersion fileVersion, ItemCollectionConnection itemCollectionConnection, Object obj, Boolean bool2, Boolean bool3, String str2, Watermark watermark, PermissionsV2Api permissionsV2Api, FileLock fileLock, SharedLink sharedLink) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.name = str;
        this.type = type;
        this.createdAt = date;
        this.updatedAt = date2;
        this.contentCreatedAt = date3;
        this.contentUpdatedAt = date4;
        this.isRooted = bool;
        this.commentCount = num;
        this.annotationCount = num2;
        this.ownedBy = ownedBy;
        this.updatedBy = updatedBy;
        this.parent = parent;
        this.fileVersion = fileVersion;
        this.itemCollectionConnection = itemCollectionConnection;
        this.size = obj;
        this.hasCollaborations = bool2;
        this.isExternallyOwned = bool3;
        this.sha1 = str2;
        this.watermark = watermark;
        this.permissionsV2Api = permissionsV2Api;
        this.fileLock = fileLock;
        this.sharedLink = sharedLink;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final ItemType getType() {
        return this.type;
    }

    public final Date getCreatedAt() {
        return this.createdAt;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final Date getContentCreatedAt() {
        return this.contentCreatedAt;
    }

    public final Date getContentUpdatedAt() {
        return this.contentUpdatedAt;
    }

    public final Boolean isRooted() {
        return this.isRooted;
    }

    public final Integer getCommentCount() {
        return this.commentCount;
    }

    public final Integer getAnnotationCount() {
        return this.annotationCount;
    }

    public final OwnedBy getOwnedBy() {
        return this.ownedBy;
    }

    public final UpdatedBy getUpdatedBy() {
        return this.updatedBy;
    }

    public final Parent getParent() {
        return this.parent;
    }

    public final FileVersion getFileVersion() {
        return this.fileVersion;
    }

    public final ItemCollectionConnection getItemCollectionConnection() {
        return this.itemCollectionConnection;
    }

    public final Object getSize() {
        return this.size;
    }

    public final Boolean getHasCollaborations() {
        return this.hasCollaborations;
    }

    public final Boolean isExternallyOwned() {
        return this.isExternallyOwned;
    }

    public final String getSha1() {
        return this.sha1;
    }

    public final Watermark getWatermark() {
        return this.watermark;
    }

    public final PermissionsV2Api getPermissionsV2Api() {
        return this.permissionsV2Api;
    }

    public final FileLock getFileLock() {
        return this.fileLock;
    }

    public final SharedLink getSharedLink() {
        return this.sharedLink;
    }

    /* JADX INFO: compiled from: FileFields.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/fragment/FileFields$OwnedBy;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OwnedBy {
        private final String id;
        private final String name;

        public static /* synthetic */ OwnedBy copy$default(OwnedBy ownedBy, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ownedBy.id;
            }
            if ((i & 2) != 0) {
                str2 = ownedBy.name;
            }
            return ownedBy.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final OwnedBy copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new OwnedBy(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OwnedBy)) {
                return false;
            }
            OwnedBy ownedBy = (OwnedBy) other;
            return Intrinsics.areEqual(this.id, ownedBy.id) && Intrinsics.areEqual(this.name, ownedBy.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "OwnedBy(id=" + this.id + ", name=" + this.name + ")";
        }

        public OwnedBy(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: FileFields.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/fragment/FileFields$UpdatedBy;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpdatedBy {
        private final String id;
        private final String name;

        public static /* synthetic */ UpdatedBy copy$default(UpdatedBy updatedBy, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updatedBy.id;
            }
            if ((i & 2) != 0) {
                str2 = updatedBy.name;
            }
            return updatedBy.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final UpdatedBy copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new UpdatedBy(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatedBy)) {
                return false;
            }
            UpdatedBy updatedBy = (UpdatedBy) other;
            return Intrinsics.areEqual(this.id, updatedBy.id) && Intrinsics.areEqual(this.name, updatedBy.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "UpdatedBy(id=" + this.id + ", name=" + this.name + ")";
        }

        public UpdatedBy(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: FileFields.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/fragment/FileFields$Parent;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Parent {
        private final String id;
        private final String name;

        public static /* synthetic */ Parent copy$default(Parent parent, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parent.id;
            }
            if ((i & 2) != 0) {
                str2 = parent.name;
            }
            return parent.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Parent copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Parent(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Parent)) {
                return false;
            }
            Parent parent = (Parent) other;
            return Intrinsics.areEqual(this.id, parent.id) && Intrinsics.areEqual(this.name, parent.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Parent(id=" + this.id + ", name=" + this.name + ")";
        }

        public Parent(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: FileFields.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/fragment/FileFields$FileVersion;", "", "id", "", "sha1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSha1", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileVersion {
        private final String id;
        private final String sha1;

        public static /* synthetic */ FileVersion copy$default(FileVersion fileVersion, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileVersion.id;
            }
            if ((i & 2) != 0) {
                str2 = fileVersion.sha1;
            }
            return fileVersion.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSha1() {
            return this.sha1;
        }

        public final FileVersion copy(String id, String sha1) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(sha1, "sha1");
            return new FileVersion(id, sha1);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileVersion)) {
                return false;
            }
            FileVersion fileVersion = (FileVersion) other;
            return Intrinsics.areEqual(this.id, fileVersion.id) && Intrinsics.areEqual(this.sha1, fileVersion.sha1);
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.sha1.hashCode();
        }

        public String toString() {
            return "FileVersion(id=" + this.id + ", sha1=" + this.sha1 + ")";
        }

        public FileVersion(String id, String sha1) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(sha1, "sha1");
            this.id = id;
            this.sha1 = sha1;
        }

        public final String getId() {
            return this.id;
        }

        public final String getSha1() {
            return this.sha1;
        }
    }

    /* JADX INFO: compiled from: FileFields.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/fragment/FileFields$ItemCollectionConnection;", "", "edges", "", "Lcom/box/android/data/fragment/FileFields$Edge;", "<init>", "(Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemCollectionConnection {
        private final List<Edge> edges;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemCollectionConnection copy$default(ItemCollectionConnection itemCollectionConnection, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = itemCollectionConnection.edges;
            }
            return itemCollectionConnection.copy(list);
        }

        public final List<Edge> component1() {
            return this.edges;
        }

        public final ItemCollectionConnection copy(List<Edge> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            return new ItemCollectionConnection(edges);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ItemCollectionConnection) && Intrinsics.areEqual(this.edges, ((ItemCollectionConnection) other).edges);
        }

        public int hashCode() {
            return this.edges.hashCode();
        }

        public String toString() {
            return "ItemCollectionConnection(edges=" + this.edges + ")";
        }

        public ItemCollectionConnection(List<Edge> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            this.edges = edges;
        }

        public final List<Edge> getEdges() {
            return this.edges;
        }
    }

    /* JADX INFO: compiled from: FileFields.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/fragment/FileFields$Watermark;", "", "isWatermarked", "", "<init>", "(Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;)Lcom/box/android/data/fragment/FileFields$Watermark;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Watermark {
        private final Boolean isWatermarked;

        public static /* synthetic */ Watermark copy$default(Watermark watermark, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = watermark.isWatermarked;
            }
            return watermark.copy(bool);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getIsWatermarked() {
            return this.isWatermarked;
        }

        public final Watermark copy(Boolean isWatermarked) {
            return new Watermark(isWatermarked);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Watermark) && Intrinsics.areEqual(this.isWatermarked, ((Watermark) other).isWatermarked);
        }

        public int hashCode() {
            Boolean bool = this.isWatermarked;
            if (bool == null) {
                return 0;
            }
            return bool.hashCode();
        }

        public String toString() {
            return "Watermark(isWatermarked=" + this.isWatermarked + ")";
        }

        public Watermark(Boolean bool) {
            this.isWatermarked = bool;
        }

        public final Boolean isWatermarked() {
            return this.isWatermarked;
        }
    }

    /* JADX INFO: compiled from: FileFields.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0092\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u0011R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011¨\u00060"}, d2 = {"Lcom/box/android/data/fragment/FileFields$PermissionsV2Api;", "", "canComment", "", "canDelete", "canDownload", "canInviteCollaborator", "canPreview", "canRename", "canSetShareAccess", "canShare", "canUpload", "canViewAnnotations", "canCreateAnnotations", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanComment", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanDelete", "getCanDownload", "getCanInviteCollaborator", "getCanPreview", "getCanRename", "getCanSetShareAccess", "getCanShare", "getCanUpload", "getCanViewAnnotations", "getCanCreateAnnotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/fragment/FileFields$PermissionsV2Api;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionsV2Api {
        private final Boolean canComment;
        private final Boolean canCreateAnnotations;
        private final Boolean canDelete;
        private final Boolean canDownload;
        private final Boolean canInviteCollaborator;
        private final Boolean canPreview;
        private final Boolean canRename;
        private final Boolean canSetShareAccess;
        private final Boolean canShare;
        private final Boolean canUpload;
        private final Boolean canViewAnnotations;

        public static /* synthetic */ PermissionsV2Api copy$default(PermissionsV2Api permissionsV2Api, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = permissionsV2Api.canComment;
            }
            if ((i & 2) != 0) {
                bool2 = permissionsV2Api.canDelete;
            }
            if ((i & 4) != 0) {
                bool3 = permissionsV2Api.canDownload;
            }
            if ((i & 8) != 0) {
                bool4 = permissionsV2Api.canInviteCollaborator;
            }
            if ((i & 16) != 0) {
                bool5 = permissionsV2Api.canPreview;
            }
            if ((i & 32) != 0) {
                bool6 = permissionsV2Api.canRename;
            }
            if ((i & 64) != 0) {
                bool7 = permissionsV2Api.canSetShareAccess;
            }
            if ((i & 128) != 0) {
                bool8 = permissionsV2Api.canShare;
            }
            if ((i & 256) != 0) {
                bool9 = permissionsV2Api.canUpload;
            }
            if ((i & 512) != 0) {
                bool10 = permissionsV2Api.canViewAnnotations;
            }
            if ((i & 1024) != 0) {
                bool11 = permissionsV2Api.canCreateAnnotations;
            }
            Boolean bool12 = bool10;
            Boolean bool13 = bool11;
            Boolean bool14 = bool8;
            Boolean bool15 = bool9;
            Boolean bool16 = bool6;
            Boolean bool17 = bool7;
            Boolean bool18 = bool5;
            Boolean bool19 = bool3;
            return permissionsV2Api.copy(bool, bool2, bool19, bool4, bool18, bool16, bool17, bool14, bool15, bool12, bool13);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getCanComment() {
            return this.canComment;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanRename() {
            return this.canRename;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getCanShare() {
            return this.canShare;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getCanUpload() {
            return this.canUpload;
        }

        public final PermissionsV2Api copy(Boolean canComment, Boolean canDelete, Boolean canDownload, Boolean canInviteCollaborator, Boolean canPreview, Boolean canRename, Boolean canSetShareAccess, Boolean canShare, Boolean canUpload, Boolean canViewAnnotations, Boolean canCreateAnnotations) {
            return new PermissionsV2Api(canComment, canDelete, canDownload, canInviteCollaborator, canPreview, canRename, canSetShareAccess, canShare, canUpload, canViewAnnotations, canCreateAnnotations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionsV2Api)) {
                return false;
            }
            PermissionsV2Api permissionsV2Api = (PermissionsV2Api) other;
            return Intrinsics.areEqual(this.canComment, permissionsV2Api.canComment) && Intrinsics.areEqual(this.canDelete, permissionsV2Api.canDelete) && Intrinsics.areEqual(this.canDownload, permissionsV2Api.canDownload) && Intrinsics.areEqual(this.canInviteCollaborator, permissionsV2Api.canInviteCollaborator) && Intrinsics.areEqual(this.canPreview, permissionsV2Api.canPreview) && Intrinsics.areEqual(this.canRename, permissionsV2Api.canRename) && Intrinsics.areEqual(this.canSetShareAccess, permissionsV2Api.canSetShareAccess) && Intrinsics.areEqual(this.canShare, permissionsV2Api.canShare) && Intrinsics.areEqual(this.canUpload, permissionsV2Api.canUpload) && Intrinsics.areEqual(this.canViewAnnotations, permissionsV2Api.canViewAnnotations) && Intrinsics.areEqual(this.canCreateAnnotations, permissionsV2Api.canCreateAnnotations);
        }

        public int hashCode() {
            Boolean bool = this.canComment;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.canDelete;
            int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.canDownload;
            int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.canInviteCollaborator;
            int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.canPreview;
            int iHashCode5 = (iHashCode4 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.canRename;
            int iHashCode6 = (iHashCode5 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Boolean bool7 = this.canSetShareAccess;
            int iHashCode7 = (iHashCode6 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Boolean bool8 = this.canShare;
            int iHashCode8 = (iHashCode7 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.canUpload;
            int iHashCode9 = (iHashCode8 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Boolean bool10 = this.canViewAnnotations;
            int iHashCode10 = (iHashCode9 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.canCreateAnnotations;
            return iHashCode10 + (bool11 != null ? bool11.hashCode() : 0);
        }

        public String toString() {
            return "PermissionsV2Api(canComment=" + this.canComment + ", canDelete=" + this.canDelete + ", canDownload=" + this.canDownload + ", canInviteCollaborator=" + this.canInviteCollaborator + ", canPreview=" + this.canPreview + ", canRename=" + this.canRename + ", canSetShareAccess=" + this.canSetShareAccess + ", canShare=" + this.canShare + ", canUpload=" + this.canUpload + ", canViewAnnotations=" + this.canViewAnnotations + ", canCreateAnnotations=" + this.canCreateAnnotations + ")";
        }

        public PermissionsV2Api(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11) {
            this.canComment = bool;
            this.canDelete = bool2;
            this.canDownload = bool3;
            this.canInviteCollaborator = bool4;
            this.canPreview = bool5;
            this.canRename = bool6;
            this.canSetShareAccess = bool7;
            this.canShare = bool8;
            this.canUpload = bool9;
            this.canViewAnnotations = bool10;
            this.canCreateAnnotations = bool11;
        }

        public final Boolean getCanComment() {
            return this.canComment;
        }

        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        public final Boolean getCanRename() {
            return this.canRename;
        }

        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        public final Boolean getCanShare() {
            return this.canShare;
        }

        public final Boolean getCanUpload() {
            return this.canUpload;
        }

        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }

        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }
    }

    /* JADX INFO: compiled from: FileFields.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016JT\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\n\u0010\u0016¨\u0006%"}, d2 = {"Lcom/box/android/data/fragment/FileFields$FileLock;", "", "id", "", "appType", "createdAt", "Ljava/util/Date;", "createdBy", "Lcom/box/android/data/fragment/FileFields$CreatedBy;", "expiresAt", "isDownloadPrevented", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lcom/box/android/data/fragment/FileFields$CreatedBy;Ljava/util/Date;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getAppType", "getCreatedAt", "()Ljava/util/Date;", "getCreatedBy", "()Lcom/box/android/data/fragment/FileFields$CreatedBy;", "getExpiresAt", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Lcom/box/android/data/fragment/FileFields$CreatedBy;Ljava/util/Date;Ljava/lang/Boolean;)Lcom/box/android/data/fragment/FileFields$FileLock;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileLock {
        private final String appType;
        private final Date createdAt;
        private final CreatedBy createdBy;
        private final Date expiresAt;
        private final String id;
        private final Boolean isDownloadPrevented;

        public static /* synthetic */ FileLock copy$default(FileLock fileLock, String str, String str2, Date date, CreatedBy createdBy, Date date2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fileLock.id;
            }
            if ((i & 2) != 0) {
                str2 = fileLock.appType;
            }
            if ((i & 4) != 0) {
                date = fileLock.createdAt;
            }
            if ((i & 8) != 0) {
                createdBy = fileLock.createdBy;
            }
            if ((i & 16) != 0) {
                date2 = fileLock.expiresAt;
            }
            if ((i & 32) != 0) {
                bool = fileLock.isDownloadPrevented;
            }
            Date date3 = date2;
            Boolean bool2 = bool;
            return fileLock.copy(str, str2, date, createdBy, date3, bool2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getAppType() {
            return this.appType;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Date getCreatedAt() {
            return this.createdAt;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final CreatedBy getCreatedBy() {
            return this.createdBy;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getExpiresAt() {
            return this.expiresAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getIsDownloadPrevented() {
            return this.isDownloadPrevented;
        }

        public final FileLock copy(String id, String appType, Date createdAt, CreatedBy createdBy, Date expiresAt, Boolean isDownloadPrevented) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new FileLock(id, appType, createdAt, createdBy, expiresAt, isDownloadPrevented);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileLock)) {
                return false;
            }
            FileLock fileLock = (FileLock) other;
            return Intrinsics.areEqual(this.id, fileLock.id) && Intrinsics.areEqual(this.appType, fileLock.appType) && Intrinsics.areEqual(this.createdAt, fileLock.createdAt) && Intrinsics.areEqual(this.createdBy, fileLock.createdBy) && Intrinsics.areEqual(this.expiresAt, fileLock.expiresAt) && Intrinsics.areEqual(this.isDownloadPrevented, fileLock.isDownloadPrevented);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.appType;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Date date = this.createdAt;
            int iHashCode3 = (iHashCode2 + (date == null ? 0 : date.hashCode())) * 31;
            CreatedBy createdBy = this.createdBy;
            int iHashCode4 = (iHashCode3 + (createdBy == null ? 0 : createdBy.hashCode())) * 31;
            Date date2 = this.expiresAt;
            int iHashCode5 = (iHashCode4 + (date2 == null ? 0 : date2.hashCode())) * 31;
            Boolean bool = this.isDownloadPrevented;
            return iHashCode5 + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "FileLock(id=" + this.id + ", appType=" + this.appType + ", createdAt=" + this.createdAt + ", createdBy=" + this.createdBy + ", expiresAt=" + this.expiresAt + ", isDownloadPrevented=" + this.isDownloadPrevented + ")";
        }

        public FileLock(String id, String str, Date date, CreatedBy createdBy, Date date2, Boolean bool) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.appType = str;
            this.createdAt = date;
            this.createdBy = createdBy;
            this.expiresAt = date2;
            this.isDownloadPrevented = bool;
        }

        public final String getId() {
            return this.id;
        }

        public final String getAppType() {
            return this.appType;
        }

        public final Date getCreatedAt() {
            return this.createdAt;
        }

        public final CreatedBy getCreatedBy() {
            return this.createdBy;
        }

        public final Date getExpiresAt() {
            return this.expiresAt;
        }

        public final Boolean isDownloadPrevented() {
            return this.isDownloadPrevented;
        }
    }

    /* JADX INFO: compiled from: FileFields.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0006\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lcom/box/android/data/fragment/FileFields$SharedLink;", "", "url", "", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "", "unsharedAt", "Ljava/util/Date;", "canDownload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)V", "getUrl", "()Ljava/lang/String;", "getEffectiveAccess", "getEffectivePermission", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUnsharedAt", "()Ljava/util/Date;", "getCanDownload", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)Lcom/box/android/data/fragment/FileFields$SharedLink;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SharedLink {
        private final Boolean canDownload;
        private final String effectiveAccess;
        private final String effectivePermission;
        private final Boolean isPasswordEnabled;
        private final Date unsharedAt;
        private final String url;

        public static /* synthetic */ SharedLink copy$default(SharedLink sharedLink, String str, String str2, String str3, Boolean bool, Date date, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sharedLink.url;
            }
            if ((i & 2) != 0) {
                str2 = sharedLink.effectiveAccess;
            }
            if ((i & 4) != 0) {
                str3 = sharedLink.effectivePermission;
            }
            if ((i & 8) != 0) {
                bool = sharedLink.isPasswordEnabled;
            }
            if ((i & 16) != 0) {
                date = sharedLink.unsharedAt;
            }
            if ((i & 32) != 0) {
                bool2 = sharedLink.canDownload;
            }
            Date date2 = date;
            Boolean bool3 = bool2;
            return sharedLink.copy(str, str2, str3, bool, date2, bool3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getIsPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final SharedLink copy(String url, String effectiveAccess, String effectivePermission, Boolean isPasswordEnabled, Date unsharedAt, Boolean canDownload) {
            return new SharedLink(url, effectiveAccess, effectivePermission, isPasswordEnabled, unsharedAt, canDownload);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharedLink)) {
                return false;
            }
            SharedLink sharedLink = (SharedLink) other;
            return Intrinsics.areEqual(this.url, sharedLink.url) && Intrinsics.areEqual(this.effectiveAccess, sharedLink.effectiveAccess) && Intrinsics.areEqual(this.effectivePermission, sharedLink.effectivePermission) && Intrinsics.areEqual(this.isPasswordEnabled, sharedLink.isPasswordEnabled) && Intrinsics.areEqual(this.unsharedAt, sharedLink.unsharedAt) && Intrinsics.areEqual(this.canDownload, sharedLink.canDownload);
        }

        public int hashCode() {
            String str = this.url;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.effectiveAccess;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.effectivePermission;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Boolean bool = this.isPasswordEnabled;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            Date date = this.unsharedAt;
            int iHashCode5 = (iHashCode4 + (date == null ? 0 : date.hashCode())) * 31;
            Boolean bool2 = this.canDownload;
            return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "SharedLink(url=" + this.url + ", effectiveAccess=" + this.effectiveAccess + ", effectivePermission=" + this.effectivePermission + ", isPasswordEnabled=" + this.isPasswordEnabled + ", unsharedAt=" + this.unsharedAt + ", canDownload=" + this.canDownload + ")";
        }

        public SharedLink(String str, String str2, String str3, Boolean bool, Date date, Boolean bool2) {
            this.url = str;
            this.effectiveAccess = str2;
            this.effectivePermission = str3;
            this.isPasswordEnabled = bool;
            this.unsharedAt = date;
            this.canDownload = bool2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        public final Boolean isPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }
    }

    /* JADX INFO: compiled from: FileFields.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/fragment/FileFields$Edge;", "", "id", "", "node", "Lcom/box/android/data/fragment/FileFields$Node;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/fragment/FileFields$Node;)V", "getId", "()Ljava/lang/String;", "getNode", "()Lcom/box/android/data/fragment/FileFields$Node;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Edge {
        private final String id;
        private final Node node;

        public static /* synthetic */ Edge copy$default(Edge edge, String str, Node node, int i, Object obj) {
            if ((i & 1) != 0) {
                str = edge.id;
            }
            if ((i & 2) != 0) {
                node = edge.node;
            }
            return edge.copy(str, node);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Node getNode() {
            return this.node;
        }

        public final Edge copy(String id, Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return new Edge(id, node);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Edge)) {
                return false;
            }
            Edge edge = (Edge) other;
            return Intrinsics.areEqual(this.id, edge.id) && Intrinsics.areEqual(this.node, edge.node);
        }

        public int hashCode() {
            String str = this.id;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.node.hashCode();
        }

        public String toString() {
            return "Edge(id=" + this.id + ", node=" + this.node + ")";
        }

        public Edge(String str, Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.id = str;
            this.node = node;
        }

        public final String getId() {
            return this.id;
        }

        public final Node getNode() {
            return this.node;
        }
    }

    /* JADX INFO: compiled from: FileFields.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/fragment/FileFields$Node;", "", "id", "", "name", "collectionType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCollectionType", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Node {
        private final String collectionType;
        private final String id;
        private final String name;

        public static /* synthetic */ Node copy$default(Node node, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = node.id;
            }
            if ((i & 2) != 0) {
                str2 = node.name;
            }
            if ((i & 4) != 0) {
                str3 = node.collectionType;
            }
            return node.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCollectionType() {
            return this.collectionType;
        }

        public final Node copy(String id, String name, String collectionType) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Node(id, name, collectionType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Node)) {
                return false;
            }
            Node node = (Node) other;
            return Intrinsics.areEqual(this.id, node.id) && Intrinsics.areEqual(this.name, node.name) && Intrinsics.areEqual(this.collectionType, node.collectionType);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.collectionType;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Node(id=" + this.id + ", name=" + this.name + ", collectionType=" + this.collectionType + ")";
        }

        public Node(String id, String str, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
            this.collectionType = str2;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getCollectionType() {
            return this.collectionType;
        }
    }

    /* JADX INFO: compiled from: FileFields.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/fragment/FileFields$CreatedBy;", "", "id", "", "name", "login", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getLogin", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CreatedBy {
        private final String id;
        private final String login;
        private final String name;

        public static /* synthetic */ CreatedBy copy$default(CreatedBy createdBy, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = createdBy.id;
            }
            if ((i & 2) != 0) {
                str2 = createdBy.name;
            }
            if ((i & 4) != 0) {
                str3 = createdBy.login;
            }
            return createdBy.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLogin() {
            return this.login;
        }

        public final CreatedBy copy(String id, String name, String login) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new CreatedBy(id, name, login);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreatedBy)) {
                return false;
            }
            CreatedBy createdBy = (CreatedBy) other;
            return Intrinsics.areEqual(this.id, createdBy.id) && Intrinsics.areEqual(this.name, createdBy.name) && Intrinsics.areEqual(this.login, createdBy.login);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.login;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "CreatedBy(id=" + this.id + ", name=" + this.name + ", login=" + this.login + ")";
        }

        public CreatedBy(String id, String str, String str2) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
            this.login = str2;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final String getLogin() {
            return this.login;
        }
    }
}
