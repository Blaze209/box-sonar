package com.box.android.localrepo;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.collection.LruCache;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.activities.UpdatesConfig;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.coreservices.models.BoxLevelDbFolder;
import com.box.android.coreservices.models.BoxLevelDbIteratorItems;
import com.box.android.coreservices.models.BoxPushNotificationV1;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.localrepo.ISQLHelper;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.box.android.domain.localrepo.sqlitetables.BoxCollectionItemSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxCollectionSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxCommentSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxEventSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxFileSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxFolderSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxItemSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxPushNotificationMuteSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxPushNotificationSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxRecentItemSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxSqlQueryManager;
import com.box.android.domain.localrepo.sqlitetables.BoxTaskCollaboratorsSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxTaskSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxWebLinkSQLData;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.domain.services.ILegacyBridgeService;
import com.box.android.domain.utils.result.Result;
import com.box.android.pushnotification.DeletedPushNotification;
import com.box.android.utilities.BoxCollectionUtils;
import com.box.android.utilities.BoxConstants;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;
import com.box.androidsdk.content.BoxCache;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxCollection;
import com.box.androidsdk.content.models.BoxComment;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxEvent;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxIteratorCollections;
import com.box.androidsdk.content.models.BoxIteratorComments;
import com.box.androidsdk.content.models.BoxIteratorEvents;
import com.box.androidsdk.content.models.BoxIteratorItems;
import com.box.androidsdk.content.models.BoxIteratorRecentItems;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.models.BoxRecentItem;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxFilePreviewRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestRecentItems;
import com.box.androidsdk.content.requests.BoxRequestsBookmark;
import com.box.androidsdk.content.requests.BoxRequestsCollections;
import com.box.androidsdk.content.requests.BoxRequestsComment;
import com.box.androidsdk.content.requests.BoxRequestsEvent;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.androidsdk.content.requests.BoxRequestsMetadata;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import com.box.androidsdk.content.requests.BoxRequestsShare;
import com.box.androidsdk.content.requests.BoxRequestsUser;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.requests.BoxResponsePartial;
import com.box.androidsdk.content.utils.BoxItemUtility;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.dao.BoxFeatures;
import com.box.boxandroidlibv2private.dao.BoxNoteCreation;
import com.box.boxandroidlibv2private.dao.BoxUserDeviceTokenSettings;
import com.box.boxandroidlibv2private.dao.BoxUserItemSettings;
import com.box.boxandroidlibv2private.model.BoxFileMute;
import com.box.boxandroidlibv2private.model.BoxIteratorBoxPushNotification;
import com.box.boxandroidlibv2private.model.BoxIteratorBoxRecentFiles;
import com.box.boxandroidlibv2private.model.BoxIteratorTaskCollaborators;
import com.box.boxandroidlibv2private.model.BoxIteratorTasks;
import com.box.boxandroidlibv2private.model.BoxLocalRecentItem;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.box.boxandroidlibv2private.model.BoxRecentBoxFile;
import com.box.boxandroidlibv2private.model.BoxTask;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import com.box.boxandroidlibv2private.model.BoxTaskLink;
import com.box.boxandroidlibv2private.model.BoxUserNotificationCategories;
import com.box.boxandroidlibv2private.requests.BoxFileNotificationMute;
import com.box.boxandroidlibv2private.requests.BoxRequestDeletePushNotification;
import com.box.boxandroidlibv2private.requests.BoxRequestGetAllInbox;
import com.box.boxandroidlibv2private.requests.BoxRequestGetFavoritesCollection;
import com.box.boxandroidlibv2private.requests.BoxRequestGetFeatures;
import com.box.boxandroidlibv2private.requests.BoxRequestGetInbox;
import com.box.boxandroidlibv2private.requests.BoxRequestGetNotificationCategories;
import com.box.boxandroidlibv2private.requests.BoxRequestGetPushNotifications;
import com.box.boxandroidlibv2private.requests.BoxRequestGetTask;
import com.box.boxandroidlibv2private.requests.BoxRequestGetTaskCollaborators;
import com.box.boxandroidlibv2private.requests.BoxRequestGetUserDeviceTokenSettings;
import com.box.boxandroidlibv2private.requests.BoxRequestGetUserItemSettings;
import com.box.boxandroidlibv2private.requests.BoxRequestLocalRecentItems;
import com.box.boxandroidlibv2private.requests.BoxRequestStorePushNotification;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiRecentItems;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
@Singleton
public class BoxLocalCache implements BoxCache, LocalSortPreferences.SortPreferencesListener {
    private static final List<String> EVENT_ACTIONS_COMMENTS_AND_OTHERS;
    private static final List<String> EVENT_ACTIONS_PREVIEWS_AND_DOWNLOADS;
    private static final List<String> EVENT_ACTIONS_UPLOADS_AND_NEW_VERSIONS;
    private static final long MAX_EVENTS = 20;
    private static final HashSet<String> REQUIRED_FILE_FIELDS;
    private static final HashSet<String> REQUIRED_FOLDER_FIELDS;
    private static final HashSet<String> REQUIRED_ITEM_FIELDS;
    private static final String SHARED_PREF_EVERYONE_KEY = "isEveryoneSelected";
    private static final String USER_INFO = "com.box.android.MoCoBoxUsers.userInfo";
    private final IAppRestrictionsManager mAppRestrictionsManager;
    private ConfigManager mConfigManager;
    private Context mContext;
    private final IMoCoBoxGlobalSettings mGlobalSettings;
    private ILegacyBridgeService mLegacyBridgeService;
    private final LocalSortPreferences mSortPrefs;
    private final IUserContextManager mUserContextManager;
    private final LruCache<String, BoxFolder> mCachedFolders = new LruCache<>(5);
    private final ConcurrentHashMap<String, List<BoxPushNotificationMuteSQLData>> mCachedMutedData = new ConcurrentHashMap<>();
    private final ReentrantReadWriteLock mPushNotifPrefLock = new ReentrantReadWriteLock();

    static {
        ArrayList arrayList = new ArrayList();
        EVENT_ACTIONS_UPLOADS_AND_NEW_VERSIONS = arrayList;
        ArrayList arrayList2 = new ArrayList();
        EVENT_ACTIONS_PREVIEWS_AND_DOWNLOADS = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        EVENT_ACTIONS_COMMENTS_AND_OTHERS = arrayList3;
        HashSet<String> hashSet = new HashSet<>();
        REQUIRED_ITEM_FIELDS = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        REQUIRED_FOLDER_FIELDS = hashSet2;
        HashSet<String> hashSet3 = new HashSet<>();
        REQUIRED_FILE_FIELDS = hashSet3;
        arrayList.add(BoxEvent.EVENT_TYPE_ITEM_CREATE);
        arrayList.add(BoxEvent.EVENT_TYPE_ITEM_UPLOAD);
        arrayList2.add(BoxEvent.EVENT_TYPE_ITEM_PREVIEW);
        arrayList2.add(BoxEvent.EVENT_TYPE_ITEM_DOWNLOAD);
        arrayList3.add(BoxEvent.EVENT_TYPE_COMMENT_CREATE);
        arrayList3.add(BoxEvent.EVENT_TYPE_ITEM_MOVE);
        arrayList3.add(BoxEvent.EVENT_TYPE_ITEM_COPY);
        arrayList3.add(BoxEvent.EVENT_TYPE_TASK_ASSIGNMENT_CREATE);
        arrayList3.add(BoxEvent.EVENT_TYPE_ITEM_RENAME);
        arrayList3.add(BoxEvent.EVENT_TYPE_ITEM_SHARED);
        hashSet.add("id");
        hashSet.add("name");
        hashSet.add("parent");
        hashSet.add(BoxItem.FIELD_PATH_COLLECTION);
        hashSet.add(BoxItem.FIELD_OWNED_BY);
        hashSet.add("permissions");
        hashSet2.add("size");
        hashSet2.add("modified_at");
        hashSet2.add(BoxFolder.FIELD_ITEM_COLLECTION);
        hashSet2.add(BoxCollaborationItem.FIELD_HAS_COLLABORATIONS);
        hashSet2.add(BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED);
        hashSet2.add("content_created_at");
        hashSet3.add("size");
        hashSet3.add("modified_at");
        hashSet3.add("sha1");
        hashSet3.add("comment_count");
    }

    @Inject
    public BoxLocalCache(Context context, IUserContextManager iUserContextManager, LocalSortPreferences localSortPreferences, ILegacyBridgeService iLegacyBridgeService, ConfigManager configManager, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings, IAppRestrictionsManager iAppRestrictionsManager) {
        this.mUserContextManager = iUserContextManager;
        this.mSortPrefs = localSortPreferences;
        localSortPreferences.setChangeListener(this);
        this.mContext = context;
        this.mLegacyBridgeService = iLegacyBridgeService;
        this.mConfigManager = configManager;
        this.mGlobalSettings = iMoCoBoxGlobalSettings;
        this.mAppRestrictionsManager = iAppRestrictionsManager;
    }

    protected ISQLHelper getSqlHelper() {
        return this.mUserContextManager.getCurrentContext().getSQLHelper();
    }

    public IKeyValueStore getKeyValueStore() {
        return this.mUserContextManager.getCurrentContext().getKVStore();
    }

    public SharedPreferences getSharedPreferences() {
        return this.mUserContextManager.getUserSharedPrefs();
    }

    @Override // com.box.androidsdk.content.BoxCache
    public <T extends BoxObject, R extends BoxRequest & BoxCacheableRequest> T get(R r) throws BoxException {
        BoxJsonObject taskCollaborators;
        try {
            if (r instanceof BoxRequestsFolder.GetFolderWithAllItems) {
                taskCollaborators = getFullFolderFromlocal(((BoxRequestsFolder.GetFolderWithAllItems) r).getId());
            } else if (r instanceof BoxRequestsFolder.GetFolderInfo) {
                taskCollaborators = getFullFolderFromlocal(((BoxRequestsFolder.GetFolderInfo) r).getId());
            } else if (r instanceof BoxRequestsFolder.GetFolderItems) {
                taskCollaborators = getFolderItemsFromLocal(((BoxRequestsFolder.GetFolderItems) r).getId());
            } else {
                BoxFileMute boxFileMute = null;
                if (!(r instanceof BoxRequestsFolder.GetTrashedItems) && !(r instanceof BoxRequestsFolder.GetCollaborations) && !(r instanceof BoxRequestsFolder.GetTrashedFolder)) {
                    if (r instanceof BoxRequestsFile.GetFileInfo) {
                        taskCollaborators = getKeyValueStore().getBoxJsonObject("file", ((BoxRequestsFile.GetFileInfo) r).getId());
                    } else if (!(r instanceof BoxRequestsFile.GetFileVersions)) {
                        if (r instanceof BoxRequestsFile.GetFileComments) {
                            taskCollaborators = getCommentsFromLocal(((BoxRequestsFile.GetFileComments) r).getId());
                        } else if (!(r instanceof BoxRequestsFile.GetTrashedFile)) {
                            if (r instanceof BoxRequestsBookmark.GetBookmarkInfo) {
                                taskCollaborators = getKeyValueStore().getBoxJsonObject(BoxBookmark.TYPE, ((BoxRequestsBookmark.GetBookmarkInfo) r).getId());
                            } else if (r instanceof BoxRequestsBookmark.GetBookmarkComments) {
                                taskCollaborators = getCommentsFromLocal(((BoxRequestsBookmark.GetBookmarkComments) r).getId());
                            } else if (!(r instanceof BoxRequestsBookmark.GetTrashedBookmark) && !(r instanceof BoxRequestsMetadata.GetFileMetadata) && !(r instanceof BoxRequestsShare.GetSharedLink) && !(r instanceof BoxRequestsShare.GetPendingCollaborations) && !(r instanceof BoxRequestsShare.GetCollaborationInfo)) {
                                if (r instanceof BoxRequestsCollections.GetCollections) {
                                    taskCollaborators = getCollectionsFromLocal();
                                } else if (r instanceof BoxRequestsCollections.GetCollectionItems) {
                                    taskCollaborators = getCollectionItemsFromLocal(((BoxRequestsCollections.GetCollectionItems) r).getId());
                                } else if (r instanceof BoxRequestsComment.GetCommentInfo) {
                                    taskCollaborators = getKeyValueStore().getBoxJsonObject("comment", ((BoxRequestsComment.GetCommentInfo) r).getId());
                                } else if (r instanceof BoxRequestsEvent.GetUserEvents) {
                                    taskCollaborators = getEventsFromLocal();
                                } else if (r instanceof BoxRequestsUser.GetUserInfo) {
                                    taskCollaborators = getUserInfoLocal();
                                } else if (!(r instanceof BoxRequestsUser.GetEnterpriseUsers) && !(r instanceof BoxRequestsSearch.Search) && !(r instanceof BoxRequestsMetadata.GetMetadataTemplates) && !(r instanceof BoxRequestsMetadata.GetMetadataTemplateSchema)) {
                                    if (r instanceof BoxRequestGetFeatures) {
                                        taskCollaborators = getFeaturesFromLocal();
                                    } else if (r instanceof BoxRequestGetFavoritesCollection) {
                                        String favoritesId = getFavoritesId();
                                        if (!SdkUtils.isBlank(favoritesId)) {
                                            taskCollaborators = getKeyValueStore().getBoxJsonObject(BoxCollection.TYPE, favoritesId);
                                        }
                                    } else if (r instanceof BoxRequestRecentItems.GetRecentItems) {
                                        taskCollaborators = getAllBoxRecentFiles();
                                    } else if (r instanceof BoxRequestLocalRecentItems) {
                                        taskCollaborators = getFilteredBoxRecentFiles((BoxRequestLocalRecentItems) r);
                                    } else {
                                        if (r instanceof BoxFileNotificationMute.AddFileMute) {
                                            BoxFileNotificationMute.AddFileMute addFileMute = (BoxFileNotificationMute.AddFileMute) r;
                                            addMuteCollectionForFile(addFileMute.getId(), addFileMute.getMuteCategory());
                                            return null;
                                        }
                                        if (r instanceof BoxFileNotificationMute.RemoveFileMute) {
                                            BoxFileNotificationMute.RemoveFileMute removeFileMute = (BoxFileNotificationMute.RemoveFileMute) r;
                                            removeMuteCollectionForFile(removeFileMute.getId(), removeFileMute.getMuteCategory());
                                            return null;
                                        }
                                        if (r instanceof BoxFileNotificationMute.GetFileMute) {
                                            BoxFile boxFile = (BoxFile) getKeyValueStore().getBoxJsonObject("file", ((BoxFileNotificationMute.GetFileMute) r).getId());
                                            if (boxFile != null) {
                                                boxFileMute = new BoxFileMute(boxFile.toJsonObject());
                                                populateMuteCollectionsForFile(boxFileMute);
                                            }
                                        } else {
                                            if (r instanceof BoxRequestGetPushNotifications) {
                                                return getStoredPushNotifications((BoxRequestGetPushNotifications) r);
                                            }
                                            if (r instanceof BoxRequestStorePushNotification) {
                                                return storePushNotification(((BoxRequestStorePushNotification) r).getPushNotification());
                                            }
                                            if (r instanceof BoxRequestDeletePushNotification) {
                                                return deletePushNotification(((BoxRequestDeletePushNotification) r).getPushNotification());
                                            }
                                            if (r instanceof BoxRequestGetInbox) {
                                                taskCollaborators = getTasks((BoxRequestGetInbox) r);
                                            } else if (r instanceof BoxRequestGetTask) {
                                                if (!SdkUtils.isBlank(((BoxRequestGetTask) r).getId())) {
                                                    taskCollaborators = getKeyValueStore().getBoxJsonObject("task", ((BoxRequestGetTask) r).getId());
                                                }
                                            } else if (r instanceof BoxRequestGetUserItemSettings) {
                                                BoxRequestGetUserItemSettings boxRequestGetUserItemSettings = (BoxRequestGetUserItemSettings) r;
                                                taskCollaborators = getUserItemSettingsFromLocal(boxRequestGetUserItemSettings.getFieldItemId(), boxRequestGetUserItemSettings.getFieldItemType());
                                            } else if (r instanceof BoxRequestGetUserDeviceTokenSettings) {
                                                taskCollaborators = getUserDeviceSettingsFromLocal(((BoxRequestGetUserDeviceTokenSettings) r).getFieldDeviceToken());
                                            } else if (r instanceof BoxRequestGetNotificationCategories) {
                                                taskCollaborators = getUserNotificationCategoriesFromLocal();
                                            } else if (r instanceof BoxRequestGetTaskCollaborators) {
                                                taskCollaborators = getTaskCollaborators((BoxRequestGetTaskCollaborators) r);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                taskCollaborators = boxFileMute;
            }
            if (taskCollaborators != null) {
                return taskCollaborators;
            }
            throw new BoxException.CacheResultUnavailable();
        } catch (SQLException e) {
            throw new BoxException("Error fetching from cache for request: " + r.getClass().getName(), e);
        }
    }

    private void removeMuteCollectionForFile(String str, String str2) {
        try {
            getSqlHelper().getQueryManager().deleteByItemId(BoxPushNotificationMuteSQLData.class, new BoxPushNotificationMuteSQLData(str, "file", str2).getId());
            this.mCachedMutedData.clear();
        } catch (SQLException e) {
            BoxLogUtils.logException(e);
        }
    }

    private void addMuteCollectionForFile(String str, String str2) {
        try {
            getSqlHelper().getQueryManager().createOrUpdate(new BoxPushNotificationMuteSQLData(str, "file", str2));
            this.mCachedMutedData.clear();
        } catch (SQLException e) {
            BoxLogUtils.logException(e);
        }
    }

    private synchronized ConcurrentHashMap<String, List<BoxPushNotificationMuteSQLData>> getMutedNotificationsMap() {
        if (this.mCachedMutedData.size() > 0) {
            return this.mCachedMutedData;
        }
        HashMap map = new HashMap();
        try {
            for (BoxPushNotificationMuteSQLData boxPushNotificationMuteSQLData : getSqlHelper().getQueryManager().getQueryBuilder(BoxPushNotificationMuteSQLData.class).execute()) {
                List arrayList = (List) map.get(boxPushNotificationMuteSQLData.getItemId());
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(boxPushNotificationMuteSQLData);
                map.put(boxPushNotificationMuteSQLData.getItemId(), arrayList);
            }
        } catch (SQLException e) {
            BoxLogUtils.e("getMutedNotifications", e);
        }
        this.mCachedMutedData.putAll(map);
        return this.mCachedMutedData;
    }

    private BoxIteratorBoxPushNotification getStoredPushNotifications(BoxRequestGetPushNotifications boxRequestGetPushNotifications) {
        List<BoxPushNotificationSQLData> listExecute;
        BoxPushNotification boxPushNotification;
        Set<String> stringSet = this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.PUSH_NOTIFICATION_GLOBAL).getStringSet(this.mUserContextManager.getCurrentContextId(), new HashSet());
        if (stringSet != null && stringSet.size() > 0) {
            Iterator<String> it = stringSet.iterator();
            while (it.hasNext()) {
                storePushNotification(BoxPushNotification.readFrom(it.next()));
            }
        }
        if (getSqlHelper() == null) {
            return null;
        }
        try {
            BoxSqlQueryManager.BoxQueryBuilder queryBuilder = getSqlHelper().getQueryManager().getQueryBuilder(BoxPushNotificationSQLData.class);
            queryBuilder.orderBy(BoxPushNotificationSQLData.EVENT_TIME_COLUMN_NAME, false);
            if (boxRequestGetPushNotifications.getFilterEventType() != null) {
                if (boxRequestGetPushNotifications.getFilterEventType().equals(BoxRequestGetPushNotifications.EVENT_TYPE_UPLOADS_AND_ITEM_MODIFIED)) {
                    queryBuilder.queryColumn(BoxPushNotificationSQLData.EVENT_TYPE_COLUMN_NAME, BoxPushNotification.PushNotifType.ITEM_UPLOAD.name(), BoxPushNotification.PushNotifType.ITEM_MODIFY.name());
                } else {
                    queryBuilder.queryColumn(BoxPushNotificationSQLData.EVENT_TYPE_COLUMN_NAME, boxRequestGetPushNotifications.getFilterEventType());
                }
            }
            if (boxRequestGetPushNotifications.getNotificationId() != null) {
                queryBuilder.queryColumn(BoxPushNotificationSQLData.NOTIF_ID_COLUMN_NAME, boxRequestGetPushNotifications.getNotificationId());
            }
            listExecute = queryBuilder.execute();
        } catch (SQLException e) {
            BoxLogUtils.e("getStoredPushNotifs", e);
            listExecute = null;
        }
        if (listExecute == null) {
            return null;
        }
        ConcurrentHashMap<String, List<BoxPushNotificationMuteSQLData>> mutedNotificationsMap = getMutedNotificationsMap();
        ArrayList arrayList = new ArrayList(listExecute.size());
        for (BoxPushNotificationSQLData boxPushNotificationSQLData : listExecute) {
            JsonObject jsonObject = getKeyValueStore().getJsonObject(getKeyValueStore().keyNamer().getBoxObjectKey(BoxPushNotification.TYPE_PUSH_NOTIFICATION, boxPushNotificationSQLData.getNotifId()));
            if (jsonObject != null) {
                if (jsonObject.get(BoxPushNotificationV1.FIELD_ALERT_TITLE) != null) {
                    boxPushNotification = new BoxPushNotificationV1(jsonObject);
                } else {
                    boxPushNotification = new BoxPushNotification(jsonObject);
                }
                boxPushNotification.clearMuteTypes();
                List<BoxPushNotificationMuteSQLData> list = mutedNotificationsMap.get(boxPushNotificationSQLData.getItemId());
                if (list != null) {
                    for (BoxPushNotificationMuteSQLData boxPushNotificationMuteSQLData : list) {
                        if (boxPushNotificationMuteSQLData.getItemType().equals(boxPushNotificationSQLData.getItemType())) {
                            boxPushNotification.addMuteType(boxPushNotificationMuteSQLData.getMuteType());
                        }
                    }
                }
                if (boxRequestGetPushNotifications.getShowNonProcessed() || boxPushNotification.isProcessed()) {
                    arrayList.add(boxPushNotification);
                }
            }
        }
        return new BoxIteratorBoxPushNotification(arrayList);
    }

    private BoxPushNotification deletePushNotification(BoxPushNotification boxPushNotification) {
        DeletedPushNotification deletedPushNotification = new DeletedPushNotification(boxPushNotification);
        deletedPushNotification.setDeleted(true);
        return storePushNotification(deletedPushNotification);
    }

    private BoxPushNotification storePushNotification(BoxPushNotification boxPushNotification) {
        ReentrantReadWriteLock.WriteLock writeLock = this.mPushNotifPrefLock.writeLock();
        writeLock.lock();
        try {
            String targetUserId = boxPushNotification.getTargetUserId();
            if (SdkUtils.isBlank(targetUserId)) {
                BoxLogUtils.e("trying to store invalid push notification", new RuntimeException("Invalid exception: " + boxPushNotification.toJson() + " Notif Class: " + boxPushNotification.getClass().getSimpleName()));
                writeLock.unlock();
                return null;
            }
            boolean z = false;
            if (!this.mUserContextManager.getCurrentContextId().equals(targetUserId)) {
                Iterator<BoxUser> it = BoxCollectionUtils.getUsersExcludingInvalid(this.mGlobalSettings).iterator();
                boolean z2 = false;
                while (it.hasNext()) {
                    if (targetUserId.equals(it.next().getUserId())) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    writeLock.unlock();
                    return null;
                }
            }
            SharedPreferences userSharedPrefs = this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.PUSH_NOTIFICATION_GLOBAL);
            HashSet<String> hashSet = new HashSet(userSharedPrefs.getStringSet(targetUserId, new HashSet()));
            if ((boxPushNotification.getNotifType() == BoxPushNotification.PushNotifType.ITEM_MODIFY || boxPushNotification.getNotifType() == BoxPushNotification.PushNotifType.ITEM_UPLOAD) && !DeletedPushNotification.isDeletedNotification(boxPushNotification)) {
                z = true;
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                for (String str : hashSet) {
                    BoxPushNotification from = BoxPushNotification.readFrom(str);
                    if (from.getNotifType() == boxPushNotification.getNotifType() && from.getSourceUserId().equals(boxPushNotification.getSourceUserId()) && from.getTargetResourceId().equals(boxPushNotification.getTargetResourceId())) {
                        arrayList.add(str);
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    hashSet.remove((String) it2.next());
                }
            }
            if (hashSet.size() > 200) {
                String str2 = null;
                Long sentTime = null;
                for (String str3 : hashSet) {
                    BoxPushNotification from2 = BoxPushNotification.readFrom(str3);
                    if (sentTime == null || (from2.getSentTime() != null && from2.getSentTime().longValue() < sentTime.longValue())) {
                        sentTime = from2.getSentTime();
                        str2 = str3;
                    }
                }
                hashSet.remove(str2);
            }
            if (!this.mUserContextManager.getCurrentContextId().equals(targetUserId)) {
                userSharedPrefs.edit().putStringSet(targetUserId, hashSet).commit();
                writeLock.unlock();
                return null;
            }
            if (z) {
                try {
                    BoxSqlQueryManager.BoxQueryBuilder queryBuilder = getSqlHelper().getQueryManager().getQueryBuilder(BoxPushNotificationSQLData.class);
                    queryBuilder.queryColumn("itemId", boxPushNotification.getTargetResourceId());
                    queryBuilder.queryColumn(BoxPushNotificationSQLData.EVENT_TYPE_COLUMN_NAME, boxPushNotification.getNotifTypeString());
                    Iterator it3 = queryBuilder.execute().iterator();
                    Long previousDismissTime = null;
                    while (it3.hasNext()) {
                        JsonObject jsonObject = getKeyValueStore().getJsonObject(getKeyValueStore().keyNamer().getBoxObjectKey(BoxPushNotification.TYPE_PUSH_NOTIFICATION, ((BoxPushNotificationSQLData) it3.next()).getNotifId()));
                        if (jsonObject != null) {
                            BoxPushNotification boxPushNotification2 = new BoxPushNotification(jsonObject);
                            if (boxPushNotification2.getSourceUserId().equals(boxPushNotification.getSourceUserId()) && boxPushNotification2.getTargetResourceId().equals(boxPushNotification.getTargetResourceId())) {
                                if (boxPushNotification2.getPreviousDismissTime() != null) {
                                    previousDismissTime = boxPushNotification2.getPreviousDismissTime();
                                }
                                if (boxPushNotification.isProcessed() && !boxPushNotification.getUserId().equals(boxPushNotification2.getUserId())) {
                                    deletePushNotification(boxPushNotification2);
                                }
                            }
                        }
                    }
                    if (previousDismissTime != null && !boxPushNotification.isDismissed().booleanValue()) {
                        boxPushNotification.setPreviousDismissTime(previousDismissTime.longValue());
                    }
                } catch (SQLException e) {
                    BoxLogUtils.e("getStoredPushNotifs", e);
                }
            }
            hashSet.add(boxPushNotification.toJson());
            Iterator it4 = hashSet.iterator();
            while (it4.hasNext()) {
                BoxPushNotification from3 = BoxPushNotification.readFrom((String) it4.next());
                BoxPushNotificationSQLData boxPushNotificationSQLData = new BoxPushNotificationSQLData(from3);
                if (DeletedPushNotification.isDeletedNotification(from3)) {
                    deleteItem(getKeyValueStore().keyNamer().getKey(from3));
                    try {
                        getSqlHelper().getQueryManager().deleteByItemId(BoxPushNotificationSQLData.class, boxPushNotificationSQLData.getId());
                        getSqlHelper().getQueryManager().createOrUpdate(boxPushNotificationSQLData);
                    } catch (SQLException e2) {
                        BoxLogUtils.logException("storePushNotification", "unable to store notifications", e2);
                    }
                } else {
                    getKeyValueStore().put(from3);
                    try {
                        getSqlHelper().getQueryManager().createOrUpdate(boxPushNotificationSQLData);
                    } catch (SQLException e3) {
                        BoxLogUtils.logException("storePushNotification", "unable to store notifications", e3);
                    }
                }
            }
            userSharedPrefs.edit().putStringSet(targetUserId, null).commit();
            try {
                getSqlHelper().getQueryManager().deleteWhereCountMoreThanThreshold(BoxPushNotificationSQLData.class, BoxPushNotificationSQLData.EVENT_TIME_COLUMN_NAME, false, 100L, null, true, BoxPushNotificationSQLData.NOTIF_ID_COLUMN_NAME);
            } catch (SQLException e4) {
                BoxLogUtils.e("delete old storePushNotification", e4);
            }
            List<BoxPushNotificationMuteSQLData> list = getMutedNotificationsMap().get(boxPushNotification.getTargetResourceId());
            if (list != null) {
                for (BoxPushNotificationMuteSQLData boxPushNotificationMuteSQLData : list) {
                    if (boxPushNotification.getTargetResourceType().equals(boxPushNotificationMuteSQLData.getItemType())) {
                        boxPushNotification.addMuteType(boxPushNotificationMuteSQLData.getMuteType());
                    }
                }
            }
            writeLock.unlock();
            return boxPushNotification;
        } catch (Throwable th) {
            writeLock.unlock();
            throw th;
        }
    }

    private void deleteItem(String str) {
        this.mLegacyBridgeService.delete(getKeyValueStore().keyNamer().getId(str), getKeyValueStore().keyNamer().getType(str), new Continuation<Object>() { // from class: com.box.android.localrepo.BoxLocalCache.1
            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
            }

            @Override // kotlin.coroutines.Continuation
            /* JADX INFO: renamed from: getContext */
            public CoroutineContext get$context() {
                return EmptyCoroutineContext.INSTANCE;
            }
        });
        getKeyValueStore().delete(str);
    }

    private BoxIteratorBoxRecentFiles getFilteredBoxRecentFiles(BoxRequestLocalRecentItems boxRequestLocalRecentItems) throws SQLException {
        BoxIteratorBoxRecentFiles allBoxRecentFiles;
        int i = AnonymousClass11.$SwitchMap$com$box$boxandroidlibv2private$resourcemanagers$BoxExtendedApiRecentItems$FILTER[boxRequestLocalRecentItems.getFilter().ordinal()];
        if (i == 1) {
            allBoxRecentFiles = getAllBoxRecentFiles();
        } else if (i == 2) {
            allBoxRecentFiles = getBoxIteratorRecentFilesFromSQLData(getSqlHelper().getQueryManager().getQueryBuilder(BoxRecentItemSQLData.class).queryColumnNotNull("interaction_shared_link").execute());
        } else if (i == 3) {
            allBoxRecentFiles = getPreviewedOrEditedRecentFiles(Arrays.asList(BoxRecentBoxFile.RECENT_INTERACTION_TYPE_OPEN, BoxRecentBoxFile.RECENT_INTERACTION_TYPE_PREVIEW));
        } else if (i == 4) {
            allBoxRecentFiles = getPreviewedOrEditedRecentFiles(Arrays.asList(BoxRecentBoxFile.RECENT_INTERACTION_TYPE_MODIFY, BoxRecentBoxFile.RECENT_INTERACTION_TYPE_UPLOAD));
        } else {
            allBoxRecentFiles = i != 5 ? null : getBoxIteratorRecentFilesFromSQLData(getSqlHelper().getQueryManager().getQueryBuilder(BoxRecentItemSQLData.class).queryColumn(BoxRecentItemSQLData.OFFLINE_COLUMN_NAME, true).orderBy("interacted_at", true).execute());
        }
        return (allBoxRecentFiles != null || SdkUtils.isBlank(getKeyValueStore().getString(BoxConstants.BOX_RECENT_ITEMS_KEY))) ? allBoxRecentFiles : new BoxIteratorBoxRecentFiles(new ArrayList(0));
    }

    private BoxIteratorBoxRecentFiles getPreviewedOrEditedRecentFiles(List<String> list) throws SQLException {
        long jCountOf = getSqlHelper().getBoxRecentItemDao().countOf();
        HashMap map = new HashMap();
        map.put("interaction_type", list);
        return getBoxIteratorRecentFilesFromSQLData(getSqlHelper().getQueryManager().queryForColumnWithMaxWhileFiltering(BoxRecentItemSQLData.class, "interacted_at", false, Long.valueOf(jCountOf), map));
    }

    private BoxIteratorBoxRecentFiles getBoxIteratorRecentFilesFromSQLData(List<BoxRecentItemSQLData> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (BoxRecentItemSQLData boxRecentItemSQLData : list) {
            BoxFile boxFile = (BoxFile) getKeyValueStore().getBoxJsonObject(getKeyValueStore().keyNamer().getBoxObjectKey(boxRecentItemSQLData.getItemType(), boxRecentItemSQLData.getItemId()));
            if (boxFile == null) {
                BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_ERRORS, BoxAnalyticsParams.ACTION_RECENTS, "Null_File_In_KV_Store");
            } else {
                arrayList.add(new BoxRecentBoxFile(boxFile, new BoxLocalRecentItem(boxFile, boxRecentItemSQLData.getInteractionType(), boxRecentItemSQLData.getInteractedAt(), boxRecentItemSQLData.getInteractionSharedLink())));
            }
        }
        return new BoxIteratorBoxRecentFiles(arrayList);
    }

    private BoxIteratorBoxRecentFiles getAllBoxRecentFiles() throws SQLException {
        BoxSqlQueryManager.BoxQueryBuilder queryBuilder = getSqlHelper().getQueryManager().getQueryBuilder(BoxRecentItemSQLData.class);
        queryBuilder.orderBy(BoxRecentItemSQLData.OFFLINE_COLUMN_NAME, false);
        queryBuilder.orderBy("interacted_at", false);
        List<BoxRecentItemSQLData> listExecute = queryBuilder.execute();
        if (listExecute.isEmpty()) {
            return null;
        }
        return new BoxIteratorBoxRecentFiles(getBoxIteratorRecentFilesFromSQLData(listExecute).getEntries());
    }

    private <T extends BoxObject> boolean isSpecialIgnoredCase(BoxResponse<T> boxResponse) {
        return (boxResponse.getResult() instanceof BoxCollaborationItem) && ((BoxCollaborationItem) boxResponse.getResult()).getAllowedInviteeRoles() != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.androidsdk.content.BoxCache
    public <T extends BoxObject> void put(BoxResponse<T> boxResponse) throws BoxException {
        try {
            BoxRequest request = boxResponse.getRequest();
            if (request instanceof BoxFilePreviewRequest) {
                saveOfflinePreviewToRecents((BoxFilePreviewRequest) request, !boxResponse.isSuccess());
            }
            if (boxResponse.isSuccess() && !isSpecialIgnoredCase(boxResponse)) {
                BoxObject result = boxResponse.getResult();
                if ((request instanceof BoxRequestsFolder.GetFolderWithAllItems) && checkFileorFolderForRequiredFields(result, boxResponse)) {
                    BoxFolder boxFolder = (BoxFolder) result;
                    for (BoxItem boxItem : boxFolder.getItemCollection()) {
                        if (boxItem instanceof BoxFile) {
                            if (checkFileorFolderForRequiredFields(boxItem, boxResponse)) {
                                break;
                            } else {
                                return;
                            }
                        }
                    }
                    if (boxResponse instanceof BoxResponsePartial) {
                        saveFolderToLocalRepo(boxFolder);
                    } else {
                        saveFolderAndAllItems(boxFolder);
                    }
                } else {
                    if (request instanceof BoxRequestsFolder.GetFolderItems) {
                        throw new BoxException("BoxRequestsFolder.GetFolderItems should not be used. Update this request to use BoxRequestsFolder.GetFolderWithAllItems");
                    }
                    if (request instanceof BoxRequestsFolder.DeleteFolder) {
                        deleteFolder(((BoxRequestsFolder.DeleteFolder) request).getId());
                    } else if (request instanceof BoxRequestsFile.DeleteFile) {
                        deleteFile(((BoxRequestsFile.DeleteFile) request).getId());
                    } else if (request instanceof BoxRequestsCollections.GetCollectionItems) {
                        saveCollectionItemsToLocal((BoxIteratorItems) result, ((BoxRequestsCollections.GetCollectionItems) request).getId());
                    } else if (request instanceof BoxRequestsFile.GetFileComments) {
                        saveCommentsToLocal((BoxRequestsFile.GetFileComments) request, (BoxIteratorComments) result);
                    } else if (!(request instanceof BoxRequestsBookmark.GetBookmarkComments)) {
                        if (request instanceof BoxRequestsComment.DeleteComment) {
                            deleteCommentFromLocal(((BoxRequestsComment.DeleteComment) request).getId());
                        } else if ((request instanceof BoxRequestsShare.GetSharedLink) && (result instanceof BoxFolder)) {
                            saveItem((BoxFolder) result, true);
                        } else if ((result instanceof BoxFolder) && checkFileorFolderForRequiredFields(result, boxResponse)) {
                            saveFolderToLocalRepo((BoxFolder) result);
                        } else if ((result instanceof BoxFile) && checkFileorFolderForRequiredFields(result, boxResponse)) {
                            saveEntityToLocalRepo((BoxFile) result, true);
                            if ((request instanceof BoxFileNotificationMute.GetFileMute) && (result instanceof BoxFileMute)) {
                                populateMuteCollectionsForFile((BoxFileMute) result);
                            }
                        } else if (result instanceof BoxBookmark) {
                            saveEntityToLocalRepo((BoxBookmark) result, true);
                        } else if (result instanceof BoxIteratorCollections) {
                            saveCollectionsToLocal((BoxIteratorCollections) result);
                        } else if (result instanceof BoxComment) {
                            saveEntityToLocalRepo((BoxComment) result, true);
                            if (request instanceof BoxRequestsFile.AddCommentToFile) {
                                BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_GENERAL_STATS, BoxAnalyticsParams.ACTION_COMMENT_POSTED);
                            }
                        } else if (result instanceof BoxIteratorEvents) {
                            saveEventsToLocal((BoxIteratorEvents) result);
                        } else if (result instanceof BoxUser) {
                            saveUserToLocal((BoxUser) result);
                        } else if (result instanceof BoxNoteCreation) {
                            saveEntityToLocalRepo(((BoxNoteCreation) result).getNewNote(), true);
                        } else if (result instanceof BoxIteratorRecentItems) {
                            saveRecentItemsToLocal((BoxIteratorRecentItems) result);
                        } else if (result instanceof BoxFeatures) {
                            getKeyValueStore().put("user_feature_list", ((BoxFeatures) result).toJson());
                        } else if (request instanceof BoxRequestGetAllInbox) {
                            saveAllTaskInbox(boxResponse);
                        } else if (request instanceof BoxRequestGetTask) {
                            getKeyValueStore().put((BoxTask) boxResponse.getResult());
                        } else if (result instanceof BoxUserItemSettings) {
                            saveAllUserItemSettings(boxResponse);
                        } else if (result instanceof BoxUserDeviceTokenSettings) {
                            saveAllUserDeviceSettings(boxResponse);
                        } else if (result instanceof BoxUserNotificationCategories) {
                            getKeyValueStore().put(BoxUserNotificationCategories.USER_NOTIFICATION_CATEGORIES, ((BoxUserNotificationCategories) result).toJson());
                        } else if (request instanceof BoxRequestGetTaskCollaborators) {
                            saveTaskCollaborators(boxResponse);
                        }
                    }
                }
                if (boxResponse instanceof BoxResponsePartial) {
                    LocalBroadcastManager.getInstance(BoxBaseApplication.getInstance()).sendBroadcast(new BoxResponseMessage(boxResponse, true));
                }
            }
        } catch (SQLException e) {
            throw new BoxException("Error while writing cache data to SQL", e);
        }
    }

    private void populateMuteCollectionsForFile(BoxFileMute boxFileMute) {
        try {
            BoxSqlQueryManager.BoxQueryBuilder queryBuilder = getSqlHelper().getQueryManager().getQueryBuilder(BoxPushNotificationMuteSQLData.class);
            queryBuilder.queryColumn("itemId", boxFileMute.getUserId());
            for (BoxPushNotificationMuteSQLData boxPushNotificationMuteSQLData : queryBuilder.execute()) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.add("collection_type", boxPushNotificationMuteSQLData.getMuteType());
                boxFileMute.addMuteCollection(new BoxCollection(jsonObject));
            }
        } catch (SQLException e) {
            BoxLogUtils.logException(e);
        }
    }

    private void saveTaskCollaborators(BoxResponse<BoxIteratorTaskCollaborators> boxResponse) {
        String id = ((BoxRequestGetTaskCollaborators) boxResponse.getRequest()).getId();
        deleteTaskCollaboratorsForTask(id);
        try {
            BoxSqlQueryManager queryManager = getSqlHelper().getQueryManager();
            BoxSqlQueryManager.BoxQueryBuilder queryBuilder = queryManager.getQueryBuilder(BoxTaskCollaboratorsSQLData.class);
            BoxIteratorTaskCollaborators boxIteratorTaskCollaborators = (BoxIteratorTaskCollaborators) boxResponse.getResult();
            for (int i = 0; i < boxIteratorTaskCollaborators.getEntries().size(); i++) {
                BoxTaskCollaborator boxTaskCollaborator = boxIteratorTaskCollaborators.getEntries().get(i);
                queryManager.create(new BoxTaskCollaboratorsSQLData(id, boxTaskCollaborator, Integer.valueOf(i)));
                getKeyValueStore().put(boxTaskCollaborator);
            }
            queryBuilder.execute();
        } catch (SQLException e) {
            BoxLogUtils.logException(e);
        }
    }

    private void deleteTaskCollaboratorsForTask(String str) {
        try {
            getSqlHelper().getQueryManager().delete(BoxTaskCollaboratorsSQLData.class, "task_id", str);
        } catch (SQLException e) {
            BoxLogUtils.logException(e);
        }
    }

    private BoxIteratorTaskCollaborators getTaskCollaborators(BoxRequestGetTaskCollaborators boxRequestGetTaskCollaborators) {
        BoxIteratorTaskCollaborators fullTaskCollaborators = getFullTaskCollaborators(boxRequestGetTaskCollaborators);
        return fullTaskCollaborators.getEntries().size() == 0 ? getTaskCollaboratorsFromTask(boxRequestGetTaskCollaborators) : fullTaskCollaborators;
    }

    private BoxIteratorTaskCollaborators getFullTaskCollaborators(BoxRequestGetTaskCollaborators boxRequestGetTaskCollaborators) {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        jsonObject.add("entries", jsonArray);
        try {
            BoxSqlQueryManager.BoxQueryBuilder queryBuilder = getSqlHelper().getQueryManager().getQueryBuilder(BoxTaskCollaboratorsSQLData.class);
            queryBuilder.queryColumn("task_id", boxRequestGetTaskCollaborators.getId());
            queryBuilder.orderBy(BoxTaskCollaboratorsSQLData.LIST_POSITION, true);
            Iterator it = queryBuilder.execute().iterator();
            while (it.hasNext()) {
                jsonArray.add(getKeyValueStore().getJsonObject(BoxTaskCollaborator.TYPE, ((BoxTaskCollaboratorsSQLData) it.next()).getTaskCollaboratorId()));
            }
        } catch (SQLException e) {
            BoxLogUtils.logException(e);
        }
        return new BoxIteratorTaskCollaborators(jsonObject);
    }

    private BoxIteratorTaskCollaborators getTaskCollaboratorsFromTask(BoxRequestGetTaskCollaborators boxRequestGetTaskCollaborators) {
        BoxTask boxTask = (BoxTask) getKeyValueStore().getBoxJsonObject("task", boxRequestGetTaskCollaborators.getId());
        if (boxTask != null) {
            return boxTask.getAssignmentCollaborators();
        }
        return null;
    }

    private synchronized void saveAllTaskInbox(BoxResponse<BoxIteratorTasks> boxResponse) {
        BoxSqlQueryManager queryManager = getSqlHelper().getQueryManager();
        try {
            String taskCollaboratorRoleLimit = BoxTaskCollaborator.ROLE_ASSIGNEE;
            if (!SdkUtils.isBlank(((BoxRequestGetAllInbox) boxResponse.getRequest()).getTaskCollaboratorRoleLimit())) {
                taskCollaboratorRoleLimit = ((BoxRequestGetAllInbox) boxResponse.getRequest()).getTaskCollaboratorRoleLimit();
                queryManager.delete(BoxTaskSQLData.class, BoxTaskSQLData.COLLABORATOR_ROLE_NAME, taskCollaboratorRoleLimit);
                getKeyValueStore().put("task_" + taskCollaboratorRoleLimit, true);
            }
            BoxSqlQueryManager.BoxQueryBuilder queryBuilder = queryManager.getQueryBuilder(BoxTaskSQLData.class);
            for (BoxTask boxTask : ((BoxIteratorTasks) boxResponse.getResult()).getEntries()) {
                queryManager.createOrUpdate(new BoxTaskSQLData(boxTask, taskCollaboratorRoleLimit));
                getKeyValueStore().put(boxTask);
            }
            queryBuilder.execute();
        } catch (SQLException e) {
            BoxLogUtils.logException(e);
        }
    }

    private boolean isTaskDisplayable(BoxTask boxTask) {
        if (!boxTask.getTaskType().equals(BoxTask.TASK_TYPE_GENERAL) && !boxTask.getTaskType().equals(BoxTask.TASK_TYPE_APPROVAL)) {
            return false;
        }
        Iterator<BoxTaskLink> it = boxTask.getTaskLinks().iterator();
        while (it.hasNext()) {
            if (!it.next().getTarget().getType().equals("file")) {
                return false;
            }
        }
        return true;
    }

    private synchronized BoxIteratorTasks getTasks(BoxRequestGetInbox boxRequestGetInbox) {
        JsonObject jsonObject;
        try {
            BoxSqlQueryManager.BoxQueryBuilder queryBuilder = getSqlHelper().getQueryManager().getQueryBuilder(BoxTaskSQLData.class);
            queryBuilder.orderBy("created_at", false);
            if (!SdkUtils.isBlank(boxRequestGetInbox.getTaskCollaboratorRoleLimit())) {
                queryBuilder.queryColumn(BoxTaskSQLData.COLLABORATOR_ROLE_NAME, boxRequestGetInbox.getTaskCollaboratorRoleLimit());
            }
            if (!SdkUtils.isBlank(boxRequestGetInbox.getTaskStatusLimit())) {
                queryBuilder.queryColumn("status", boxRequestGetInbox.getTaskCollaboratorStatusLimit());
            }
            List<BoxTaskSQLData> listExecute = queryBuilder.execute();
            if (listExecute.size() == 0) {
                String taskCollaboratorRoleLimit = SdkUtils.isBlank(boxRequestGetInbox.getTaskCollaboratorRoleLimit()) ? BoxTaskCollaborator.ROLE_ASSIGNEE : boxRequestGetInbox.getTaskCollaboratorRoleLimit();
                if (!getKeyValueStore().getBoolean("task_" + taskCollaboratorRoleLimit, false)) {
                    throw new SQLException("never stored " + taskCollaboratorRoleLimit + " tasks");
                }
            }
            jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            jsonObject.add("entries", jsonArray);
            for (BoxTaskSQLData boxTaskSQLData : listExecute) {
                JsonObject jsonObject2 = getKeyValueStore().getJsonObject(boxTaskSQLData.getItemType(), boxTaskSQLData.getItemId());
                if (isTaskDisplayable(new BoxTask(jsonObject2))) {
                    jsonArray.add(jsonObject2);
                }
            }
        } catch (SQLException e) {
            BoxLogUtils.e("tasks sql", e);
            return null;
        }
        return new BoxIteratorTasks(jsonObject);
    }

    private void saveOfflinePreviewToRecents(BoxFilePreviewRequest boxFilePreviewRequest, boolean z) {
        BoxSqlQueryManager queryManager = getSqlHelper().getQueryManager();
        BoxRecentItemSQLData boxRecentItemSQLData = new BoxRecentItemSQLData(boxFilePreviewRequest.getFileId(), "file", boxFilePreviewRequest.getPreviewTime(), BoxRecentBoxFile.RECENT_INTERACTION_TYPE_PREVIEW, boxFilePreviewRequest.getInteractionSharedLink());
        try {
            BoxRecentItemSQLData boxRecentItemSQLData2 = (BoxRecentItemSQLData) queryManager.queryForId(BoxRecentItemSQLData.class, boxRecentItemSQLData.getId());
            if (boxRecentItemSQLData2 != null && boxRecentItemSQLData2.getInteractedAt().after(boxRecentItemSQLData.getInteractedAt())) {
                boxRecentItemSQLData = boxRecentItemSQLData2;
            }
            boxRecentItemSQLData.setOffline(z);
            HashMap map = new HashMap(2);
            map.put(BoxRecentItemSQLData.OFFLINE_COLUMN_NAME, Boolean.valueOf(z));
            map.put("interacted_at", boxRecentItemSQLData.getInteractedAt());
            queryManager.createOrUpdateColumns(boxRecentItemSQLData, map);
            queryManager.deleteWhereCountMoreThanThreshold(BoxRecentItemSQLData.class, "interacted_at", false, 100L, BoxRecentItemSQLData.OFFLINE_COLUMN_NAME, true, "id");
        } catch (SQLException e) {
            BoxLogUtils.logException(e);
        }
    }

    private void saveRecentItemsToLocal(BoxIteratorRecentItems boxIteratorRecentItems) throws SQLException {
        BoxSqlQueryManager queryManager = getSqlHelper().getQueryManager();
        if (getSqlHelper().getBoxRecentItemDao().isTableExists()) {
            queryManager.delete(BoxRecentItemSQLData.class, BoxRecentItemSQLData.OFFLINE_COLUMN_NAME, (Object) false);
        }
        for (BoxRecentItem boxRecentItem : boxIteratorRecentItems.getEntries()) {
            saveEntityToLocalRepo(boxRecentItem.getItem(), true);
            BoxRecentItemSQLData boxRecentItemSQLData = (BoxRecentItemSQLData) getSqlHelper().newSQLDataInstance(boxRecentItem);
            BoxRecentItemSQLData boxRecentItemSQLData2 = (BoxRecentItemSQLData) queryManager.createIfNotExists(boxRecentItemSQLData);
            if (boxRecentItemSQLData != boxRecentItemSQLData2 && boxRecentItemSQLData2.getInteractedAt().before(boxRecentItemSQLData.getInteractedAt())) {
                queryManager.createOrUpdate(boxRecentItemSQLData);
            }
        }
        getKeyValueStore().put(BoxConstants.BOX_RECENT_ITEMS_KEY, boxIteratorRecentItems.toJson());
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.box.android.localrepo.BoxLocalCache$2] */
    private <T extends BoxObject> boolean checkFileorFolderForRequiredFields(T t, final BoxResponse<T> boxResponse) {
        int i;
        int i2;
        boolean z = t instanceof BoxFile;
        if (!z && !(t instanceof BoxFolder)) {
            return true;
        }
        final HashSet<String> hashSet = z ? REQUIRED_FILE_FIELDS : REQUIRED_FOLDER_FIELDS;
        if (t instanceof BoxItem) {
            i = 0;
            i2 = 0;
            for (String str : ((BoxItem) t).getPropertiesKeySet()) {
                if (hashSet.contains(str)) {
                    i2++;
                } else if (REQUIRED_ITEM_FIELDS.contains(str)) {
                    i++;
                }
            }
        } else {
            i = 0;
            i2 = 0;
        }
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            if (i2 < hashSet.size()) {
                String strBuildMissingFieldsString = buildMissingFieldsString(boxResponse, hashSet);
                BoxNotificationHelper.displayDialog(strBuildMissingFieldsString);
                throw new RuntimeException(strBuildMissingFieldsString);
            }
            HashSet<String> hashSet2 = REQUIRED_ITEM_FIELDS;
            if (i < hashSet2.size()) {
                String strBuildMissingFieldsString2 = buildMissingFieldsString(boxResponse, hashSet2);
                BoxNotificationHelper.displayDialog(strBuildMissingFieldsString2);
                throw new RuntimeException(strBuildMissingFieldsString2);
            }
        } else {
            final boolean z2 = i2 < hashSet.size();
            final boolean z3 = i < REQUIRED_ITEM_FIELDS.size();
            new Thread() { // from class: com.box.android.localrepo.BoxLocalCache.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        if (z2) {
                            BoxLogUtils.v(BoxLocalCache.this.buildMissingFieldsString(boxResponse, hashSet));
                        }
                        if (z3) {
                            BoxLogUtils.v(BoxLocalCache.this.buildMissingFieldsString(boxResponse, BoxLocalCache.REQUIRED_ITEM_FIELDS));
                        }
                    } catch (Exception unused) {
                    }
                }
            }.start();
            if (z3 || z2) {
                return false;
            }
        }
        return true;
    }

    private BoxFeatures getFeaturesFromLocal() {
        return new BoxFeatures(getKeyValueStore().getJsonObject("user_feature_list"));
    }

    private BoxUserItemSettings getUserItemSettingsFromLocal(String str, String str2) {
        try {
            JsonObject jsonObject = getKeyValueStore().getJsonObject(BoxUserItemSettings.createUserItemIdKey(str, str2));
            if (jsonObject == null) {
                return null;
            }
            return new BoxUserItemSettings(jsonObject);
        } catch (Exception unused) {
            return null;
        }
    }

    private void saveAllUserItemSettings(BoxResponse<BoxUserItemSettings> boxResponse) {
        try {
            Iterator<JsonValue> it = ((BoxUserItemSettings) boxResponse.getResult()).getPropertyValue("entries").asArray().iterator();
            while (it.hasNext()) {
                JsonObject jsonObjectAsObject = it.next().asObject();
                BoxRequestGetUserItemSettings boxRequestGetUserItemSettings = (BoxRequestGetUserItemSettings) boxResponse.getRequest();
                if (boxRequestGetUserItemSettings != null) {
                    getKeyValueStore().put(BoxUserItemSettings.createUserItemIdKey(boxRequestGetUserItemSettings.getFieldItemId(), boxRequestGetUserItemSettings.getFieldItemType()), jsonObjectAsObject.toString());
                }
            }
        } catch (Exception e) {
            BoxLogUtils.logException(e);
        }
    }

    private BoxUserDeviceTokenSettings getUserDeviceSettingsFromLocal(String str) {
        try {
            JsonObject jsonObject = getKeyValueStore().getJsonObject(str);
            if (jsonObject == null) {
                return null;
            }
            return new BoxUserDeviceTokenSettings(jsonObject);
        } catch (Exception unused) {
            return null;
        }
    }

    private void saveAllUserDeviceSettings(BoxResponse<BoxUserDeviceTokenSettings> boxResponse) {
        try {
            Iterator<JsonValue> it = ((BoxUserDeviceTokenSettings) boxResponse.getResult()).getPropertyValue("entries").asArray().iterator();
            while (it.hasNext()) {
                JsonObject jsonObjectAsObject = it.next().asObject();
                BoxRequestGetUserDeviceTokenSettings boxRequestGetUserDeviceTokenSettings = (BoxRequestGetUserDeviceTokenSettings) boxResponse.getRequest();
                if (boxRequestGetUserDeviceTokenSettings != null && boxRequestGetUserDeviceTokenSettings.getFieldDeviceToken() != null) {
                    getKeyValueStore().put(boxRequestGetUserDeviceTokenSettings.getFieldDeviceToken(), jsonObjectAsObject.toString());
                }
            }
        } catch (Exception e) {
            BoxLogUtils.logException(e);
        }
    }

    private BoxUserNotificationCategories getUserNotificationCategoriesFromLocal() {
        try {
            JsonObject jsonObject = getKeyValueStore().getJsonObject(BoxUserNotificationCategories.USER_NOTIFICATION_CATEGORIES);
            if (jsonObject == null) {
                return null;
            }
            return new BoxUserNotificationCategories(jsonObject);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends BoxObject> String buildMissingFieldsString(BoxResponse<T> boxResponse, HashSet<String> hashSet) {
        HashSet hashSet2 = (HashSet) hashSet.clone();
        Iterator<String> it = ((BoxItem) boxResponse.getResult()).getPropertiesKeySet().iterator();
        while (it.hasNext()) {
            hashSet2.remove(it.next());
        }
        StringBuilder sb = new StringBuilder("BoxLocalCache missing fields from ");
        sb.append(boxResponse.getRequest());
        sb.append("does not include ");
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next()).append(" ");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends BoxEntity> void saveEntitiesToLocalRepo(BoxIterator<T> boxIterator) throws SQLException {
        BoxFolder boxFolder;
        ArrayList arrayList = new ArrayList();
        if (boxIterator != null && boxIterator.size() > 0) {
            for (T boxFolder2 : boxIterator) {
                if (boxFolder2 instanceof BoxItem) {
                    BoxIterator<BoxFolder> pathCollection = ((BoxItem) boxFolder2).getPathCollection();
                    if (pathCollection != null) {
                        arrayList.add(pathCollection);
                    }
                    if ((boxFolder2 instanceof BoxFolder) && ((BoxFolder) boxFolder2).getItemCollection() == null && (boxFolder = (BoxFolder) getKeyValueStore().getBoxJsonObject(getKeyValueStore().keyNamer().getKey(boxFolder2))) != null && boxFolder.getItemCollection() != null) {
                        JsonObject jsonObjectAsObject = boxFolder.toJsonObject().get(BoxFolder.FIELD_ITEM_COLLECTION).asObject();
                        jsonObjectAsObject.set("entries", JsonValue.NULL);
                        JsonObject jsonObject = boxFolder2.toJsonObject();
                        jsonObject.set(BoxFolder.FIELD_ITEM_COLLECTION, jsonObjectAsObject);
                        boxFolder2 = new BoxFolder(jsonObject);
                    }
                }
                getSqlHelper().getQueryManager().createOrUpdate(getSqlHelper().newSQLDataInstance(boxFolder2));
                getKeyValueStore().put(boxFolder2);
            }
        }
        savePathCollectionsToLocal(arrayList);
    }

    protected void saveEntityToLocalRepo(BoxEntity boxEntity, boolean z) throws SQLException {
        BoxJsonObject boxJsonObject;
        boolean z2 = boxEntity instanceof BoxItem;
        if (z2) {
            removeParentFromCacheIfItemChanged((BoxItem) boxEntity);
        }
        if (z2 && !boxEntity.getPropertiesKeySet().contains(BoxItem.FIELD_PATH_COLLECTION) && (boxJsonObject = getKeyValueStore().getBoxJsonObject(getKeyValueStore().keyNamer().getKey(boxEntity))) != null && boxJsonObject.getPropertyValue(BoxItem.FIELD_PATH_COLLECTION) != null) {
            boxEntity = BoxEntity.createEntityFromJson(boxEntity.toJsonObject().add(BoxItem.FIELD_PATH_COLLECTION, boxJsonObject.getPropertyValue(BoxItem.FIELD_PATH_COLLECTION)));
        }
        getSqlHelper().getQueryManager().createOrUpdate(getSqlHelper().newSQLDataInstance(boxEntity));
        if (boxEntity instanceof BoxItem) {
            if (z) {
                saveItemToGQLCache((BoxItem) boxEntity);
            }
            BoxItem boxItem = (BoxItem) boxEntity;
            BoxIterator<BoxFolder> pathCollection = boxItem.getPathCollection();
            if (pathCollection != null) {
                savePathCollectionToLocal(pathCollection);
            }
            refreshItemCollections(boxItem);
        }
        getKeyValueStore().put(boxEntity);
    }

    private void saveItemToGQLCache(BoxItem boxItem) {
        this.mLegacyBridgeService.save(boxItem, new Continuation<Result<? extends Unit, ? extends DomainError>>() { // from class: com.box.android.localrepo.BoxLocalCache.3
            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
            }

            @Override // kotlin.coroutines.Continuation
            /* JADX INFO: renamed from: getContext */
            public CoroutineContext get$context() {
                return EmptyCoroutineContext.INSTANCE;
            }
        });
    }

    private BoxFolder getFullFolderFromlocal(String str) throws SQLException {
        JsonObject jsonObject = getKeyValueStore().getJsonObject("folder", str);
        if (jsonObject == null) {
            return null;
        }
        BoxLevelDbFolder boxLevelDbFolder = new BoxLevelDbFolder(jsonObject);
        BoxFolder boxFolder = this.mCachedFolders.get(str);
        if (boxFolder != null && boxFolder.getItemCollection() != null && boxFolder.getItemCollection().size() > 0 && boxLevelDbFolder.getItemCollection() != null && boxFolder.getItemCollection().fullSize().equals(boxLevelDbFolder.getItemCollection().fullSize())) {
            return boxFolder;
        }
        if (jsonObject.get(BoxFolder.FIELD_ITEM_COLLECTION) == null) {
            jsonObject.add(BoxFolder.FIELD_ITEM_COLLECTION, new JsonObject());
        }
        JsonObject jsonObjectAsObject = jsonObject.get(BoxFolder.FIELD_ITEM_COLLECTION).asObject();
        if (jsonObjectAsObject.get("entries") == null || jsonObjectAsObject.get("entries").isNull()) {
            jsonObjectAsObject.set("entries", new JsonArray());
        }
        List<String> folderItemIdsFromlocal = getFolderItemIdsFromlocal(str);
        JsonObject jsonObjectAsObject2 = jsonObject.get(BoxFolder.FIELD_ITEM_COLLECTION).asObject();
        if (folderItemIdsFromlocal.size() > 0 && jsonObjectAsObject2.get(BoxIterator.FIELD_TOTAL_COUNT) == null) {
            jsonObjectAsObject2.add(BoxIterator.FIELD_TOTAL_COUNT, folderItemIdsFromlocal.size());
        }
        boxLevelDbFolder.setItemCollection(new BoxLevelDbIteratorItems(this.mUserContextManager, jsonObjectAsObject2, folderItemIdsFromlocal));
        if (folderItemIdsFromlocal.size() > 0) {
            boxLevelDbFolder.getItemCollection().getEntries();
        }
        this.mCachedFolders.put(str, boxLevelDbFolder);
        return boxLevelDbFolder;
    }

    private BoxIteratorItems getFolderItemsFromLocal(String str) throws SQLException {
        List<String> folderItemIdsFromlocal = getFolderItemIdsFromlocal(str);
        IKeyValueStore keyValueStore = getKeyValueStore();
        JsonArray jsonArray = new JsonArray();
        Iterator<String> it = folderItemIdsFromlocal.iterator();
        while (it.hasNext()) {
            jsonArray.add(((BoxItem) keyValueStore.getBoxJsonObject(it.next())).toJsonObject());
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.set("entries", jsonArray);
        return new BoxIteratorItems(jsonObject);
    }

    private void saveFolderAndAllItems(final BoxFolder boxFolder) throws SQLException {
        try {
            getSqlHelper().getBoxFileDao().callBatchTasks(new Callable<Void>() { // from class: com.box.android.localrepo.BoxLocalCache.4
                @Override // java.util.concurrent.Callable
                public Void call() throws SQLException {
                    BoxLocalCache.this.getSqlHelper().getQueryManager().delete(BoxFolderSQLData.class, BoxItemSQLData.COL_PARENT_ID, boxFolder.getUserId());
                    BoxLocalCache.this.getSqlHelper().getQueryManager().delete(BoxFileSQLData.class, BoxItemSQLData.COL_PARENT_ID, boxFolder.getUserId());
                    BoxLocalCache.this.getSqlHelper().getQueryManager().delete(BoxWebLinkSQLData.class, BoxItemSQLData.COL_PARENT_ID, boxFolder.getUserId());
                    BoxLocalCache.this.saveFolderToLocalRepo(boxFolder);
                    return null;
                }
            });
        } catch (SQLException e) {
            throw e;
        } catch (Exception e2) {
            throw new SQLException("Unknown problem while executing batch sql.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveFolderToLocalRepo(BoxFolder boxFolder) throws SQLException {
        saveEntityToLocalRepo(BoxItemUtility.copyFolderWithNoItems(boxFolder), true);
        saveEntitiesToLocalRepo(boxFolder.getItemCollection());
        this.mCachedFolders.remove(boxFolder.getUserId());
    }

    @Override // com.box.androidsdk.content.BoxCache
    public void deleteFolder(String str) throws SQLException {
        removeParentFromCache(str, "folder");
        String parentId = CoreServiceUtils.getParentId(this.mUserContextManager, str, "folder");
        for (String str2 : getFolderItemIdsFromlocal(str)) {
            deleteItem(str2);
            if (getKeyValueStore().keyNamer().getType(str2).equals("folder")) {
                deleteFolder(getKeyValueStore().keyNamer().getId(str2));
            }
        }
        deleteItem(getKeyValueStore().keyNamer().getBoxObjectKey("folder", str));
        getSqlHelper().getQueryManager().delete(BoxFolderSQLData.class, "id", str);
        getSqlHelper().getQueryManager().delete(BoxFolderSQLData.class, BoxItemSQLData.COL_PARENT_ID, str);
        getSqlHelper().getQueryManager().delete(BoxFileSQLData.class, BoxItemSQLData.COL_PARENT_ID, str);
        getSqlHelper().getQueryManager().delete(BoxWebLinkSQLData.class, BoxItemSQLData.COL_PARENT_ID, str);
        deleteFolderFromGQLCache(str, parentId);
    }

    private List<String> getFolderItemIdsFromlocal(String str) throws SQLException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getFolderFolderItemIdsFromLocal(str).getTypedIds());
        arrayList.addAll(getFolderFileItemIdsFromLocal(str).getTypedIds());
        arrayList.addAll(getWebLinkFolderItemIdsFromLocal(str).getTypedIds());
        return arrayList;
    }

    private void deleteFolderFromGQLCache(String str, String str2) {
        ILegacyBridgeService iLegacyBridgeService = this.mLegacyBridgeService;
        BoxFolder boxFolderCreateFromId = BoxFolder.createFromId(str);
        if (str2 == null) {
            str2 = "0";
        }
        iLegacyBridgeService.deleteItemFromGQLCache(boxFolderCreateFromId, str2, new Continuation<Unit>() { // from class: com.box.android.localrepo.BoxLocalCache.5
            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
            }

            @Override // kotlin.coroutines.Continuation
            /* JADX INFO: renamed from: getContext */
            public CoroutineContext get$context() {
                return EmptyCoroutineContext.INSTANCE;
            }
        });
    }

    private void deleteFileFromGQLCache(String str, String str2) {
        ILegacyBridgeService iLegacyBridgeService = this.mLegacyBridgeService;
        BoxFile boxFileCreateFromIdForModelMapping = BoxFile.createFromIdForModelMapping(str);
        if (str2 == null) {
            str2 = "0";
        }
        iLegacyBridgeService.deleteItemFromGQLCache(boxFileCreateFromIdForModelMapping, str2, new Continuation<Unit>() { // from class: com.box.android.localrepo.BoxLocalCache.6
            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
            }

            @Override // kotlin.coroutines.Continuation
            /* JADX INFO: renamed from: getContext */
            public CoroutineContext get$context() {
                return EmptyCoroutineContext.INSTANCE;
            }
        });
    }

    private SQLReturnInfo getFolderFolderItemIdsFromLocal(String str) throws SQLException {
        String sortColumnForFolderItemsQuery = getSortColumnForFolderItemsQuery();
        boolean z = this.mSortPrefs.getSortOrder() == LocalSortPreferences.SortOrder.ASC;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BoxFolderSQLData boxFolderSQLData : getSqlHelper().getQueryManager().queryForColumn(BoxFolderSQLData.class, BoxItemSQLData.COL_PARENT_ID, str, sortColumnForFolderItemsQuery, z)) {
            arrayList2.add(getKeyValueStore().keyNamer().getBoxObjectKey("folder", boxFolderSQLData.getId()));
            arrayList.add(boxFolderSQLData.getName());
        }
        return new SQLReturnInfo(arrayList2, arrayList);
    }

    private SQLReturnInfo getFolderFileItemIdsFromLocal(String str) throws SQLException {
        String sortColumnForFolderItemsQuery = getSortColumnForFolderItemsQuery();
        boolean z = this.mSortPrefs.getSortOrder() == LocalSortPreferences.SortOrder.ASC;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BoxFileSQLData boxFileSQLData : getSqlHelper().getQueryManager().queryForColumn(BoxFileSQLData.class, BoxItemSQLData.COL_PARENT_ID, str, sortColumnForFolderItemsQuery, z)) {
            arrayList.add(getKeyValueStore().keyNamer().getBoxObjectKey("file", boxFileSQLData.getId()));
            arrayList2.add(boxFileSQLData.getName());
        }
        return new SQLReturnInfo(arrayList, arrayList2);
    }

    private SQLReturnInfo getWebLinkFolderItemIdsFromLocal(String str) throws SQLException {
        boolean z = this.mSortPrefs.getSortOrder() == LocalSortPreferences.SortOrder.ASC;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BoxWebLinkSQLData boxWebLinkSQLData : getSqlHelper().getQueryManager().queryForColumn(BoxWebLinkSQLData.class, BoxItemSQLData.COL_PARENT_ID, str, "name", z)) {
            arrayList.add(getKeyValueStore().keyNamer().getBoxObjectKey(BoxBookmark.TYPE, boxWebLinkSQLData.getId()));
            arrayList2.add(boxWebLinkSQLData.getName());
        }
        return new SQLReturnInfo(arrayList, arrayList2);
    }

    @Override // com.box.androidsdk.content.BoxCache
    public void deleteFile(String str) throws SQLException {
        removeParentFromCache(str, "file");
        String parentId = CoreServiceUtils.getParentId(this.mUserContextManager, str, "file");
        getSqlHelper().getQueryManager().deleteByItemId(BoxFileSQLData.class, str);
        getSqlHelper().getQueryManager().delete(BoxRecentItemSQLData.class, "item_id", str);
        deleteItem(getKeyValueStore().keyNamer().getBoxObjectKey("file", str));
        deleteFileFromGQLCache(str, parentId);
    }

    private void removeParentFromCache(String str, String str2) throws SQLException {
        String parentId = CoreServiceUtils.getParentId(this.mUserContextManager, str, str2);
        if (TextUtils.isEmpty(parentId)) {
            return;
        }
        this.mCachedFolders.remove(parentId);
    }

    private void removeParentFromCacheIfItemChanged(BoxItem boxItem) throws SQLException {
        BoxFolder parent;
        String id;
        BoxItem boxItem2 = (BoxItem) getKeyValueStore().getBoxJsonObject(boxItem.getType(), boxItem.getUserId());
        if (boxItem2 != null) {
            parent = boxItem2.getParent();
            if (TextUtils.equals(boxItem2.getName(), boxItem.getName()) && boxItem.getSize() != null && boxItem.getSize().equals(boxItem2.getSize()) && boxItem.getModifiedAt() != null && boxItem.getModifiedAt().equals(boxItem2.getModifiedAt()) && boxItem.getParent() != null && parent != null && TextUtils.equals(boxItem.getParent().getUserId(), boxItem2.getParent().getUserId())) {
                return;
            }
        } else {
            parent = null;
        }
        if (boxItem.getParent() == null) {
            id = CoreServiceUtils.getParentId(this.mUserContextManager, boxItem.getUserId(), boxItem.getType());
        } else {
            id = boxItem.getParent().getUserId();
        }
        if (TextUtils.isEmpty(id)) {
            return;
        }
        this.mCachedFolders.remove(id);
        if (parent != null) {
            this.mCachedFolders.remove(parent.getUserId());
        }
    }

    private BoxIteratorCollections getCollectionsFromLocal() throws SQLException, BoxException.CacheResultUnavilable {
        BoxIteratorCollections boxIteratorCollections = new BoxIteratorCollections();
        JsonArray jsonArray = new JsonArray();
        Iterator<BoxCollectionSQLData> it = getSqlHelper().getBoxCollectionDao().queryForAll().iterator();
        boolean z = false;
        while (it.hasNext()) {
            BoxJsonObject boxJsonObject = getKeyValueStore().getBoxJsonObject(BoxCollection.TYPE, it.next().getId());
            if (boxJsonObject instanceof BoxCollection) {
                jsonArray.add(boxJsonObject.toJsonObject());
                z = true;
            }
        }
        if (!z) {
            throw new BoxException.CacheResultUnavilable();
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.set("entries", jsonArray);
        boxIteratorCollections.createFromJson(jsonObject);
        return boxIteratorCollections;
    }

    private BoxIteratorItems getCollectionItemsFromLocal(String str) throws SQLException {
        QueryBuilder<BoxCollectionItemSQLData, String> queryBuilder = getSqlHelper().getBoxCollectionItemDao().queryBuilder();
        List<BoxCollectionItemSQLData> listQuery = queryBuilder.where().eq("collection_id", str).and().eq("item_type", "folder").query();
        List<BoxCollectionItemSQLData> listQuery2 = queryBuilder.where().eq("collection_id", str).and().eq("item_type", "file").or().eq("item_type", BoxBookmark.TYPE).query();
        ArrayList<BoxJsonObject> arrayList = new ArrayList(listQuery.size());
        ArrayList<BoxJsonObject> arrayList2 = new ArrayList(listQuery2.size());
        JsonArray jsonArray = new JsonArray();
        for (BoxCollectionItemSQLData boxCollectionItemSQLData : listQuery) {
            arrayList.add((BoxItem) getKeyValueStore().getBoxJsonObject(boxCollectionItemSQLData.getItemType(), boxCollectionItemSQLData.getItemId()));
        }
        for (BoxCollectionItemSQLData boxCollectionItemSQLData2 : listQuery2) {
            arrayList2.add((BoxItem) getKeyValueStore().getBoxJsonObject(boxCollectionItemSQLData2.getItemType(), boxCollectionItemSQLData2.getItemId()));
        }
        Comparator<BoxItem> boxItemSortComparator = getBoxItemSortComparator();
        Collections.sort(arrayList, boxItemSortComparator);
        Collections.sort(arrayList2, boxItemSortComparator);
        for (BoxJsonObject boxJsonObject : arrayList) {
            if (boxJsonObject instanceof BoxItem) {
                jsonArray.add(boxJsonObject.toJsonObject());
            }
        }
        for (BoxJsonObject boxJsonObject2 : arrayList2) {
            if (boxJsonObject2 instanceof BoxItem) {
                jsonArray.add(boxJsonObject2.toJsonObject());
            }
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.set("entries", jsonArray);
        return new BoxIteratorItems(jsonObject);
    }

    private Comparator<BoxItem> getBoxItemSortComparator() {
        final LocalSortPreferences.SortBy sortBy = this.mSortPrefs.getSortBy();
        final boolean z = this.mSortPrefs.getSortOrder() == LocalSortPreferences.SortOrder.ASC;
        return new Comparator<BoxItem>() { // from class: com.box.android.localrepo.BoxLocalCache.7
            @Override // java.util.Comparator
            public int compare(BoxItem boxItem, BoxItem boxItem2) {
                int iCompareTo;
                int i = AnonymousClass11.$SwitchMap$com$box$android$domain$localrepo$LocalSortPreferences$SortBy[sortBy.ordinal()];
                if (i != 1) {
                    iCompareTo = 0;
                    if (i != 2) {
                        if (i == 3) {
                            iCompareTo = boxItem.getSize().compareTo(boxItem2.getSize());
                        }
                    } else if (boxItem.getModifiedAt() != null && boxItem2.getModifiedAt() != null) {
                        iCompareTo = boxItem.getModifiedAt().compareTo(boxItem2.getModifiedAt());
                    }
                } else {
                    iCompareTo = boxItem.getName().compareTo(boxItem2.getName());
                }
                return !z ? iCompareTo * (-1) : iCompareTo;
            }
        };
    }

    /* JADX INFO: renamed from: com.box.android.localrepo.BoxLocalCache$11, reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$domain$localrepo$LocalSortPreferences$SortBy;
        static final /* synthetic */ int[] $SwitchMap$com$box$boxandroidlibv2private$resourcemanagers$BoxExtendedApiRecentItems$FILTER;

        static {
            int[] iArr = new int[LocalSortPreferences.SortBy.values().length];
            $SwitchMap$com$box$android$domain$localrepo$LocalSortPreferences$SortBy = iArr;
            try {
                iArr[LocalSortPreferences.SortBy.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$domain$localrepo$LocalSortPreferences$SortBy[LocalSortPreferences.SortBy.MODIFIED_AT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$android$domain$localrepo$LocalSortPreferences$SortBy[LocalSortPreferences.SortBy.SIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[BoxExtendedApiRecentItems.FILTER.values().length];
            $SwitchMap$com$box$boxandroidlibv2private$resourcemanagers$BoxExtendedApiRecentItems$FILTER = iArr2;
            try {
                iArr2[BoxExtendedApiRecentItems.FILTER.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$box$boxandroidlibv2private$resourcemanagers$BoxExtendedApiRecentItems$FILTER[BoxExtendedApiRecentItems.FILTER.SHARED_LINKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$box$boxandroidlibv2private$resourcemanagers$BoxExtendedApiRecentItems$FILTER[BoxExtendedApiRecentItems.FILTER.FILES_PREVIEWED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$box$boxandroidlibv2private$resourcemanagers$BoxExtendedApiRecentItems$FILTER[BoxExtendedApiRecentItems.FILTER.FILES_EDITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$box$boxandroidlibv2private$resourcemanagers$BoxExtendedApiRecentItems$FILTER[BoxExtendedApiRecentItems.FILTER.OFFLINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private void saveCollectionsToLocal(final BoxIteratorCollections boxIteratorCollections) throws SQLException {
        try {
            getSqlHelper().getBoxFileDao().callBatchTasks(new Callable<Void>() { // from class: com.box.android.localrepo.BoxLocalCache.8
                @Override // java.util.concurrent.Callable
                public Void call() throws SQLException {
                    BoxLocalCache.this.getSqlHelper().getQueryManager().delete(BoxCollectionSQLData.class, "name", "*");
                    BoxLocalCache.this.saveEntitiesToLocalRepo(boxIteratorCollections);
                    return null;
                }
            });
        } catch (SQLException e) {
            throw e;
        } catch (Exception e2) {
            throw new SQLException("Unknown problem while executing batch sql.", e2);
        }
    }

    private void saveCollectionItemsToLocal(final BoxIteratorItems boxIteratorItems, final String str) throws SQLException {
        try {
            getSqlHelper().getBoxFileDao().callBatchTasks(new Callable<Void>() { // from class: com.box.android.localrepo.BoxLocalCache.9
                @Override // java.util.concurrent.Callable
                public Void call() throws SQLException {
                    BoxLocalCache.this.getSqlHelper().getQueryManager().delete(BoxCollectionItemSQLData.class, "collection_id", str);
                    Iterator<E> it = boxIteratorItems.iterator();
                    while (it.hasNext()) {
                        BoxLocalCache.this.getSqlHelper().getQueryManager().createOrUpdate(new BoxCollectionItemSQLData((BoxItem) it.next(), str));
                    }
                    BoxLocalCache.this.saveEntitiesToLocalRepo(boxIteratorItems);
                    return null;
                }
            });
        } catch (SQLException e) {
            throw e;
        } catch (Exception e2) {
            throw new SQLException("Unknown problem while executing batch sql.", e2);
        }
    }

    @Override // com.box.androidsdk.content.BoxCache
    public String getFavoritesId() {
        List listQueryForColumn;
        try {
            listQueryForColumn = getSqlHelper().getQueryManager().queryForColumn(BoxCollectionSQLData.class, "collection_type", "favorites");
        } catch (SQLException e) {
            BoxLogUtils.logException(e);
            listQueryForColumn = null;
        }
        if (listQueryForColumn == null) {
            return null;
        }
        if (listQueryForColumn.size() == 1) {
            return ((BoxCollectionSQLData) listQueryForColumn.get(0)).getId();
        }
        if (listQueryForColumn.size() > 1) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_ERRORS, "favorites", "Unexpected_Size", Integer.valueOf(listQueryForColumn.size()));
        }
        return null;
    }

    private BoxIteratorComments getCommentsFromLocal(String str) throws SQLException {
        List listQueryForColumn = getSqlHelper().getQueryManager().queryForColumn(BoxCommentSQLData.class, "item_id", str, "created_at", true);
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        Iterator it = listQueryForColumn.iterator();
        boolean z = false;
        while (it.hasNext()) {
            jsonArray.add(getKeyValueStore().getBoxJsonObject("comment", ((BoxCommentSQLData) it.next()).getId()).toJsonObject());
            z = true;
        }
        jsonObject.set("entries", jsonArray);
        BoxIteratorComments boxIteratorComments = new BoxIteratorComments();
        boxIteratorComments.createFromJson(jsonObject);
        if (z) {
            return boxIteratorComments;
        }
        return null;
    }

    private void saveCommentsToLocal(BoxRequestsFile.GetFileComments getFileComments, BoxIteratorComments boxIteratorComments) throws SQLException {
        if (boxIteratorComments.getPropertyValue("offset").asInt() == 0) {
            getSqlHelper().getQueryManager().delete(BoxCommentSQLData.class, "item_id", getFileComments.getId());
        }
        Iterator<E> it = boxIteratorComments.iterator();
        while (it.hasNext()) {
            JsonObject from = JsonObject.readFrom(((BoxComment) it.next()).toJson());
            from.set("item", JsonObject.readFrom(BoxFile.createFromId(getFileComments.getId()).toJson()));
            BoxComment boxComment = new BoxComment();
            boxComment.createFromJson(from);
            saveEntityToLocalRepo(boxComment, true);
        }
    }

    private void deleteCommentFromLocal(String str) throws SQLException {
        getSqlHelper().getQueryManager().deleteByItemId(BoxFileSQLData.class, str);
        deleteItem(getKeyValueStore().keyNamer().getBoxObjectKey("comment", str));
    }

    private void saveEventsToLocal(BoxIteratorEvents boxIteratorEvents) throws SQLException {
        Iterator<E> it = boxIteratorEvents.iterator();
        while (it.hasNext()) {
            BoxEvent boxEvent = (BoxEvent) it.next();
            if ((boxEvent.getSource() instanceof BoxFile) || (boxEvent.getSource() instanceof BoxFolder) || (boxEvent.getSource() instanceof BoxComment)) {
                saveEntityToLocalRepo(boxEvent, true);
            }
        }
    }

    private BoxIteratorEvents getEventsFromLocal() throws SQLException {
        HashMap map = new HashMap();
        map.put("event_type", getEventFilterList());
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        arrayList.add(false);
        map.put("user_dismissed", arrayList);
        boolean z2 = this.mUserContextManager.getUserSharedPrefs().getBoolean("isEveryoneSelected", true);
        String userId = this.mUserContextManager.getBoxSession(this.mContext).getUserId();
        if (!z2) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(userId);
            map.put(BoxEventSQLData.COL_EVENT_OWNER_ID, arrayList2);
        }
        List listQueryForColumnWithMaxWhileFiltering = getSqlHelper().getQueryManager().queryForColumnWithMaxWhileFiltering(BoxEventSQLData.class, "created_at", false, 20L, map);
        BoxIteratorEvents boxIteratorEvents = new BoxIteratorEvents();
        JsonArray jsonArray = new JsonArray();
        Iterator it = listQueryForColumnWithMaxWhileFiltering.iterator();
        while (it.hasNext()) {
            BoxEvent boxEvent = (BoxEvent) getKeyValueStore().getBoxJsonObject("event", ((BoxEventSQLData) it.next()).getId());
            if (boxEvent != null) {
                jsonArray.add(boxEvent.toJsonObject());
            }
            z = true;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.set("entries", jsonArray);
        boxIteratorEvents.createFromJson(jsonObject);
        if (z) {
            return boxIteratorEvents;
        }
        return null;
    }

    private List<String> getEventFilterList() {
        SharedPreferences userSharedPrefs = this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.updatesPreferences);
        boolean z = userSharedPrefs.getBoolean(UpdatesConfig.PREFS_KEY_SHOW_UPDATED_OR_UPLOADED, true);
        boolean z2 = userSharedPrefs.getBoolean(UpdatesConfig.PREFS_KEY_SHOW_DOWNLOADED_OR_PREVIEWED, true);
        boolean z3 = userSharedPrefs.getBoolean(UpdatesConfig.PREFS_KEY_SHOW_OTHER, true);
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.addAll(EVENT_ACTIONS_UPLOADS_AND_NEW_VERSIONS);
        }
        if (z2) {
            arrayList.addAll(EVENT_ACTIONS_PREVIEWS_AND_DOWNLOADS);
        }
        if (z3) {
            arrayList.addAll(EVENT_ACTIONS_COMMENTS_AND_OTHERS);
        }
        return arrayList;
    }

    private BoxUser getUserInfoLocal() throws BoxException.CacheResultUnavilable {
        String string = this.mUserContextManager.getUserSharedPrefs().getString(USER_INFO, null);
        if (SdkUtils.isBlank(string)) {
            throw new BoxException.CacheResultUnavilable();
        }
        BoxUser boxUser = new BoxUser();
        boxUser.createFromJson(string);
        return boxUser;
    }

    private void saveUserToLocal(BoxUser boxUser) {
        if (boxUser == null || boxUser.getUserId() == null || !this.mUserContextManager.hasValidUserId() || !boxUser.getUserId().equals(this.mUserContextManager.getCurrentContextId())) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.mUserContextManager.getUserSharedPrefs().edit();
        editorEdit.putString(USER_INFO, boxUser.toJson());
        editorEdit.commit();
        BoxAuthentication.BoxAuthenticationInfo authInfo = this.mUserContextManager.getBoxSession(BoxBaseApplication.getInstance()).getAuthInfo();
        if (!authInfo.getUser().getUserId().equals(boxUser.getUserId()) || authInfo.getUser().equals(boxUser)) {
            return;
        }
        authInfo.setUser(boxUser);
        BoxAuthentication.getInstance().onAuthenticated(authInfo, BoxBaseApplication.getInstance(), this.mAppRestrictionsManager.isAppFedrampHighCompliant());
    }

    private void savePathCollectionToLocal(BoxIterator<BoxFolder> boxIterator) throws SQLException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(boxIterator);
        savePathCollectionsToLocal(arrayList);
    }

    private void savePathCollectionsToLocal(List<BoxIterator<BoxFolder>> list) throws SQLException {
        final HashMap map = new HashMap();
        final HashMap map2 = new HashMap();
        Iterator<BoxIterator<BoxFolder>> it = list.iterator();
        while (it.hasNext()) {
            String id = null;
            for (BoxFolder boxFolder : it.next()) {
                map.put(boxFolder.getUserId(), boxFolder.getName());
                map2.put(boxFolder.getUserId(), id);
                id = boxFolder.getUserId();
            }
        }
        try {
            getSqlHelper().getBoxFileDao().callBatchTasks(new Callable<Void>() { // from class: com.box.android.localrepo.BoxLocalCache.10
                @Override // java.util.concurrent.Callable
                public Void call() throws SQLException {
                    boolean z;
                    for (String str : map.keySet()) {
                        if (!str.equals("0")) {
                            BoxFolderSQLData boxFolderSQLData = (BoxFolderSQLData) BoxLocalCache.this.getSqlHelper().getQueryManager().queryForId(BoxFolderSQLData.class, str);
                            if (boxFolderSQLData == null) {
                                boxFolderSQLData = new BoxFolderSQLData(str);
                                z = true;
                            } else {
                                z = false;
                            }
                            if (map.get(str) != null) {
                                boxFolderSQLData.setName((String) map.get(str));
                            }
                            if (z) {
                                boxFolderSQLData.setParentId((String) map2.get(str));
                                BoxLocalCache.this.getSqlHelper().getQueryManager().create(boxFolderSQLData);
                            } else {
                                BoxLocalCache.this.getSqlHelper().getQueryManager().update(boxFolderSQLData);
                            }
                        }
                    }
                    return null;
                }
            });
        } catch (SQLException e) {
            throw e;
        } catch (Exception e2) {
            throw new SQLException("Unknown problem while executing batch sql.", e2);
        }
    }

    private void refreshItemCollections(BoxItem boxItem) throws SQLException {
        List<BoxCollection> arrayList;
        if (boxItem.getCollections() != null) {
            arrayList = boxItem.getCollections();
        } else {
            arrayList = new ArrayList<>();
        }
        HashSet hashSet = new HashSet();
        Iterator<BoxCollection> it = arrayList.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getUserId());
        }
        List<BoxCollectionItemSQLData> listQuery = getSqlHelper().getBoxCollectionItemDao().queryBuilder().where().eq("item_type", boxItem.getType()).and().eq("item_id", boxItem.getUserId()).query();
        HashSet hashSet2 = new HashSet();
        Iterator<BoxCollectionItemSQLData> it2 = listQuery.iterator();
        while (it2.hasNext()) {
            hashSet2.add(it2.next().getCollectionId());
        }
        HashSet hashSet3 = new HashSet(hashSet2);
        hashSet3.removeAll(hashSet);
        if (!hashSet3.isEmpty()) {
            DeleteBuilder<BoxCollectionItemSQLData, String> deleteBuilder = getSqlHelper().getBoxCollectionItemDao().deleteBuilder();
            deleteBuilder.where().eq("item_type", boxItem.getType()).and().eq("item_id", boxItem.getUserId()).and().in("collection_id", hashSet3);
            deleteBuilder.delete();
        }
        HashSet hashSet4 = new HashSet(hashSet);
        hashSet4.removeAll(hashSet2);
        Iterator it3 = hashSet4.iterator();
        while (it3.hasNext()) {
            getSqlHelper().getQueryManager().createOrUpdate(new BoxCollectionItemSQLData(boxItem, (String) it3.next()));
        }
    }

    private String getSortColumnForFolderItemsQuery() {
        if (this.mSortPrefs.getSortBy() == LocalSortPreferences.SortBy.SIZE) {
            return "size";
        }
        if (this.mSortPrefs.getSortBy() == LocalSortPreferences.SortBy.MODIFIED_AT) {
            return "modified_at";
        }
        return "name";
    }

    @Override // com.box.android.domain.localrepo.LocalSortPreferences.SortPreferencesListener
    public void onSortPreferencesChanged() {
        this.mCachedFolders.evictAll();
    }

    @Override // com.box.androidsdk.content.BoxCache
    public void saveItem(BoxItem boxItem, boolean z) throws SQLException {
        saveEntityToLocalRepo(boxItem, z);
    }

    @Override // com.box.androidsdk.content.BoxCache
    public void saveItemLegacyOnly(BoxItem boxItem) throws SQLException {
        saveEntityToLocalRepo(boxItem, true);
    }

    @Override // com.box.androidsdk.content.BoxCache
    public BoxItem getItem(String str, String str2) throws SQLException {
        ItemType itemTypeValueOfWithTransform = ItemType.valueOfWithTransform(str2, new Function1() { // from class: com.box.android.localrepo.BoxLocalCache$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ((String) obj).replace("_", "");
            }
        });
        if (itemTypeValueOfWithTransform == ItemType.FILE) {
            return (BoxItem) getKeyValueStore().getBoxJsonObject("file", str);
        }
        if (itemTypeValueOfWithTransform == ItemType.WEBLINK) {
            return (BoxItem) getKeyValueStore().getBoxJsonObject(BoxBookmark.TYPE, str);
        }
        if (itemTypeValueOfWithTransform == ItemType.FOLDER) {
            return getFullFolderFromlocal(str);
        }
        return null;
    }

    private class SQLReturnInfo {
        private final List<String> mNames;
        private final List<String> mTypedIds;

        public SQLReturnInfo(List<String> list, List<String> list2) {
            this.mNames = list2;
            this.mTypedIds = list;
        }

        public List<String> getNames() {
            return this.mNames;
        }

        public List<String> getTypedIds() {
            return this.mTypedIds;
        }
    }
}
