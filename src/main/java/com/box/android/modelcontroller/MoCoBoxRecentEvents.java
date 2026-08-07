package com.box.android.modelcontroller;

import android.content.Context;
import android.content.SharedPreferences;
import com.box.android.activities.UpdatesConfig;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.coreservices.modelcontroller.BoxCallable;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents;
import com.box.android.coreservices.modelcontroller.messages.BoxFilenameFilteredItemsMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxItemsMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxLocalMetadataMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxRecentItemsMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxVoidMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.coreservices.models.BoxFragmentFilenameFilter;
import com.box.android.coreservices.models.BoxLocalMetadata;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.data.controller.impl.BaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.localrepo.sqlitetables.BoxEventSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxFileSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxRecentFileSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxRecentItemSQLData;
import com.box.android.utilities.BoxEventUtils;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxEvent;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxIteratorEvents;
import com.box.androidsdk.content.models.BoxIteratorItems;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.model.BoxRecentBoxFile;
import com.box.boxandroidlibv2private.requests.BoxRequestGetUpdates;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes12.dex */
public class MoCoBoxRecentEvents extends BaseModelController implements IMoCoBoxRecentEvents {
    private static final double EVENTS_RECENTS_RATIO = 1.0d;
    private static final int MAX_EVENTS = 20;
    public static final String SHARED_PREF_EVERYONE_KEY = "isEveryoneSelected";
    private final BoxExtendedApiFile mFileApi;
    private final BoxExtendedApiFolder mFolderApi;
    private final BoxApiPrivate mPrivateApi;
    private static final String[] EVENT_ACTIONS_UPLOADS_AND_NEW_VERSIONS = {BoxEvent.EVENT_TYPE_ITEM_CREATE, BoxEvent.EVENT_TYPE_ITEM_UPLOAD};
    private static final String[] EVENT_ACTIONS_PREVIEWS_AND_DOWNLOADS = {BoxEvent.EVENT_TYPE_ITEM_PREVIEW, BoxEvent.EVENT_TYPE_ITEM_DOWNLOAD};
    private static final String[] EVENT_ACTIONS_COMMENTS_AND_OTHERS = {BoxEvent.EVENT_TYPE_COMMENT_CREATE, BoxEvent.EVENT_TYPE_ITEM_MOVE, BoxEvent.EVENT_TYPE_ITEM_COPY, BoxEvent.EVENT_TYPE_TASK_ASSIGNMENT_CREATE, BoxEvent.EVENT_TYPE_ITEM_RENAME, BoxEvent.EVENT_TYPE_ITEM_SHARED};

    public MoCoBoxRecentEvents(Context context, IUserContextManager iUserContextManager, BoxApiPrivate boxApiPrivate, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiFile boxExtendedApiFile) {
        super(iUserContextManager, context);
        this.mPrivateApi = boxApiPrivate;
        this.mFolderApi = boxExtendedApiFolder;
        this.mFileApi = boxExtendedApiFile;
    }

    private static void addArrayValuesToList(List<String> list, String[] strArr) {
        for (String str : strArr) {
            list.add(str);
        }
    }

    public void saveLocalMetadata(BoxLocalMetadata boxLocalMetadata) throws BoxException {
        getKeyValueStore().saveLocalMetadata(boxLocalMetadata);
    }

    public BoxLocalMetadata getOrCreateLocalMetadata(String str, String str2) {
        BoxLocalMetadata boxLocalMetadata = (BoxLocalMetadata) getKeyValueStore().getLocalMetadataForObject(str, str2);
        if (boxLocalMetadata == null) {
            boxLocalMetadata = new BoxLocalMetadata(str, str2);
            try {
                saveLocalMetadata(boxLocalMetadata);
            } catch (BoxException unused) {
            }
        }
        return boxLocalMetadata;
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents
    public BoxFutureTask<BoxVoidMessage> addFileToRecents(String str, String str2) {
        return addFileToRecents(BoxFile.createFromId(str), str2);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents
    public BoxFutureTask<BoxVoidMessage> addFileToRecents(final BoxFile boxFile, final String str) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        return asyncBuildAndRunFutureTask(new BoxCallable<BoxVoidMessage>() { // from class: com.box.android.modelcontroller.MoCoBoxRecentEvents.1
            @Override // java.util.concurrent.Callable
            public BoxVoidMessage call() throws Exception {
                BoxVoidMessage boxVoidMessage = new BoxVoidMessage();
                boxVoidMessage.setRequestId(getRequestId());
                boxVoidMessage.setSuccess(true);
                try {
                    BoxFileSQLData boxFileSQLData = (BoxFileSQLData) MoCoBoxRecentEvents.this.getSqlHelper().getQueryManager().queryForId(BoxFileSQLData.class, boxFile.getUserId());
                    if (boxFileSQLData == null) {
                        MoCoBoxRecentEvents moCoBoxRecentEvents = MoCoBoxRecentEvents.this;
                        moCoBoxRecentEvents.performRemote(moCoBoxRecentEvents.mFileApi.getInfoRequest(boxFile.getUserId())).get();
                        boxFileSQLData = (BoxFileSQLData) MoCoBoxRecentEvents.this.getSqlHelper().getQueryManager().queryForId(BoxFileSQLData.class, boxFile.getUserId());
                    }
                    if (str != null) {
                        MoCoBoxRecentEvents.this.getSqlHelper().getQueryManager().createOrUpdate(new BoxRecentItemSQLData(boxFileSQLData.getId(), "file", new Date(), BoxRecentBoxFile.RECENT_INTERACTION_TYPE_PREVIEW, str));
                    }
                    MoCoBoxRecentEvents.this.getSqlHelper().getQueryManager().createOrUpdate(new BoxRecentFileSQLData(boxFileSQLData, jCurrentTimeMillis));
                    BoxLocalMetadata orCreateLocalMetadata = MoCoBoxRecentEvents.this.getOrCreateLocalMetadata(boxFile.getType(), boxFile.getUserId());
                    orCreateLocalMetadata.put(BoxLocalMetadata.FIELD_RECENT_TIMESTAMP, Long.valueOf(jCurrentTimeMillis));
                    MoCoBoxRecentEvents.this.saveLocalMetadata(orCreateLocalMetadata);
                    if (MoCoBoxRecentEvents.this.getSqlHelper().getBoxRecentDao().countOf() > 500) {
                        MoCoBoxRecentEvents.this.getSqlHelper().getQueryManager().deleteWhereLessThanThreshold(BoxRecentFileSQLData.class, "timestamp", ((BoxRecentFileSQLData) MoCoBoxRecentEvents.this.getSqlHelper().getQueryManager().queryForNth(BoxRecentFileSQLData.class, "timestamp", false, 100L)).getTimestamp());
                    }
                    return boxVoidMessage;
                } catch (Exception e) {
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    boxVoidMessage.setException(e);
                    boxVoidMessage.setSuccess(false);
                    return boxVoidMessage;
                }
            }
        }, getExecutorPool().getLocalModelExecutor());
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents
    public BoxFutureTask<BoxItemsMessage> getRecents(int i, boolean z) {
        return getRecentsLocalFiltered(i, z, null);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents
    public BoxFutureTask<BoxItemsMessage> getRecentsLocalFiltered(final int i, final boolean z, final BoxFragmentFilenameFilter boxFragmentFilenameFilter) {
        return asyncBuildAndRunFutureTask(new BoxCallable<BoxItemsMessage>() { // from class: com.box.android.modelcontroller.MoCoBoxRecentEvents.2
            @Override // java.util.concurrent.Callable
            public BoxItemsMessage call() throws Exception {
                BoxFragmentFilenameFilter boxFragmentFilenameFilter2;
                BoxFragmentFilenameFilter boxFragmentFilenameFilter3 = boxFragmentFilenameFilter;
                BoxFilenameFilteredItemsMessage boxFilenameFilteredItemsMessage = new BoxFilenameFilteredItemsMessage(MoCoBoxRecentEvents.this.getKeyValueStore(), BoxCommonConstants.RECENTS_ROOT_FOLDER_ID, boxFragmentFilenameFilter3 != null ? boxFragmentFilenameFilter3.getFilterType() : null);
                boxFilenameFilteredItemsMessage.setRequestId(getRequestId());
                boxFilenameFilteredItemsMessage.setAction(Controller.ACTION_FETCHED_RECENTS);
                boxFilenameFilteredItemsMessage.setSuccess(true);
                try {
                    List<BoxRecentFileSQLData> recentSQLData = MoCoBoxRecentEvents.this.getRecentSQLData(i, z);
                    BoxIteratorItems boxIteratorItems = new BoxIteratorItems();
                    JsonArray jsonArray = new JsonArray();
                    int i2 = 0;
                    for (BoxRecentFileSQLData boxRecentFileSQLData : recentSQLData) {
                        int i3 = i2 + 1;
                        if (i2 >= i) {
                            break;
                        }
                        BoxFile boxFile = (BoxFile) MoCoBoxRecentEvents.this.getKeyValueStore().getBoxJsonObject("file", MoCoBoxRecentEvents.this.getKeyValueStore().keyNamer().getId(MoCoBoxRecentEvents.this.getKeyValueStore().keyNamer().getBoxObjectKey(boxRecentFileSQLData.getItemType(), boxRecentFileSQLData.getItemId())));
                        if (boxFile != null && ((boxFragmentFilenameFilter2 = boxFragmentFilenameFilter) == null || boxFragmentFilenameFilter2.accept(boxFile.getName()))) {
                            jsonArray.add(boxFile.toJsonObject());
                        }
                        i2 = i3;
                    }
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.set("entries", jsonArray);
                    boxIteratorItems.createFromJson(jsonObject);
                    boxFilenameFilteredItemsMessage.setBoxIteratorItems(boxIteratorItems);
                } catch (Exception e) {
                    boxFilenameFilteredItemsMessage.setException(e);
                    boxFilenameFilteredItemsMessage.setSuccess(false);
                }
                CoreServiceUtils.broadcastIntent(MoCoBoxRecentEvents.this.mUserContextManager, boxFilenameFilteredItemsMessage);
                return boxFilenameFilteredItemsMessage;
            }
        }, getExecutorPool().getLocalModelExecutor());
    }

    protected List<BoxRecentFileSQLData> getRecentSQLData(int i, boolean z) throws SQLException {
        HashMap map = new HashMap();
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(false);
            map.put("user_dismissed", arrayList);
        }
        return getSqlHelper().getQueryManager().queryForColumnWithMaxWhileFilteringWithJoin(BoxRecentFileSQLData.class, BoxFileSQLData.class, "timestamp", false, Long.valueOf(i), map);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents
    public BoxFutureTask<BoxVoidMessage> setItemUserDismissed(final BoxEntity boxEntity, final boolean z) {
        return asyncBuildAndRunFutureTask(new BoxCallable<BoxVoidMessage>() { // from class: com.box.android.modelcontroller.MoCoBoxRecentEvents.3
            @Override // java.util.concurrent.Callable
            public BoxVoidMessage call() throws Exception {
                BoxVoidMessage boxVoidMessage = new BoxVoidMessage();
                boxVoidMessage.setRequestId(getRequestId());
                boxVoidMessage.setSuccess(true);
                try {
                    BoxEntity boxEntity2 = boxEntity;
                    if (boxEntity2 instanceof BoxEvent) {
                        BoxEventSQLData boxEventSQLData = (BoxEventSQLData) MoCoBoxRecentEvents.this.getSqlHelper().getQueryManager().queryForColumn(BoxEventSQLData.class, "id", boxEntity.getUserId()).get(0);
                        boxEventSQLData.setUserDismissed(z);
                        MoCoBoxRecentEvents.this.getSqlHelper().getQueryManager().update(boxEventSQLData);
                        return boxVoidMessage;
                    }
                    if (boxEntity2 instanceof BoxFile) {
                        BoxRecentFileSQLData boxRecentFileSQLData = (BoxRecentFileSQLData) MoCoBoxRecentEvents.this.getSqlHelper().getQueryManager().queryForColumn(BoxRecentFileSQLData.class, "item_id", boxEntity.getUserId()).get(0);
                        boxRecentFileSQLData.setUserDismissed(z);
                        MoCoBoxRecentEvents.this.getSqlHelper().getQueryManager().update(boxRecentFileSQLData);
                    }
                    return boxVoidMessage;
                } catch (Exception e) {
                    boxVoidMessage.setException(e);
                    boxVoidMessage.setSuccess(false);
                    return boxVoidMessage;
                }
            }
        }, getExecutorPool().getLocalModelExecutor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> buildDefaultFilterList() {
        SharedPreferences userSharedPrefs = this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.updatesPreferences);
        boolean z = userSharedPrefs.getBoolean(UpdatesConfig.PREFS_KEY_SHOW_UPDATED_OR_UPLOADED, true);
        boolean z2 = userSharedPrefs.getBoolean(UpdatesConfig.PREFS_KEY_SHOW_DOWNLOADED_OR_PREVIEWED, true);
        boolean z3 = userSharedPrefs.getBoolean(UpdatesConfig.PREFS_KEY_SHOW_OTHER, true);
        ArrayList arrayList = new ArrayList();
        if (z) {
            addArrayValuesToList(arrayList, EVENT_ACTIONS_UPLOADS_AND_NEW_VERSIONS);
        }
        if (z2) {
            addArrayValuesToList(arrayList, EVENT_ACTIONS_PREVIEWS_AND_DOWNLOADS);
        }
        if (z3) {
            addArrayValuesToList(arrayList, EVENT_ACTIONS_COMMENTS_AND_OTHERS);
        }
        return arrayList;
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents
    public void setIsEveryoneSelected(boolean z) {
        SharedPreferences.Editor editorEdit = getUserSharedPrefs().edit();
        editorEdit.putBoolean(SHARED_PREF_EVERYONE_KEY, z);
        editorEdit.apply();
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents
    public boolean isEveryoneSelected() {
        return getUserSharedPrefs().getBoolean(SHARED_PREF_EVERYONE_KEY, true);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents
    public BoxFutureTask<BoxRecentItemsMessage> getInterleavedRecentsAndEvents(boolean z) {
        if (this.mUserContextManager.getUserInfo() == null) {
            return asyncBuildAndRunFutureTask(new BoxCallable<BoxRecentItemsMessage>() { // from class: com.box.android.modelcontroller.MoCoBoxRecentEvents.4
                @Override // java.util.concurrent.Callable
                public BoxRecentItemsMessage call() {
                    BoxRecentItemsMessage boxRecentItemsMessage = new BoxRecentItemsMessage(MoCoBoxRecentEvents.this.getKeyValueStore());
                    boxRecentItemsMessage.setRequestId(getRequestId());
                    boxRecentItemsMessage.setAction(Controller.ACTION_FETCHED_EVENTS_RECENTS);
                    boxRecentItemsMessage.setSuccess(false);
                    return boxRecentItemsMessage;
                }
            }, getExecutor(z));
        }
        String id = this.mUserContextManager.getUserInfo().getUserId();
        if (isEveryoneSelected()) {
            return getInterleavedRecentsAndEvents(z, 20);
        }
        return getInterleavedRecentsAndEvents(z, 20, id, null);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents
    public BoxFutureTask<BoxRecentItemsMessage> getInterleavedRecentsAndEvents(boolean z, int i) {
        return getInterleavedRecentsAndEvents(z, i, null, null);
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents
    public BoxFutureTask<BoxRecentItemsMessage> getInterleavedRecentsAndEvents(final boolean z, final int i, final String str, final List<String> list) {
        return asyncBuildAndRunFutureTask(new BoxCallable<BoxRecentItemsMessage>() { // from class: com.box.android.modelcontroller.MoCoBoxRecentEvents.5
            @Override // java.util.concurrent.Callable
            public BoxRecentItemsMessage call() {
                List listBuildDefaultFilterList = list;
                if (listBuildDefaultFilterList == null) {
                    listBuildDefaultFilterList = MoCoBoxRecentEvents.this.buildDefaultFilterList();
                }
                List list2 = listBuildDefaultFilterList;
                BoxRecentItemsMessage boxRecentItemsMessage = new BoxRecentItemsMessage(MoCoBoxRecentEvents.this.getKeyValueStore());
                boxRecentItemsMessage.setRequestId(getRequestId());
                boxRecentItemsMessage.setAction(Controller.ACTION_FETCHED_EVENTS_RECENTS);
                boxRecentItemsMessage.setSuccess(true);
                boxRecentItemsMessage.setEveryoneSelected(str == null);
                SharedPreferences sharedPreferences = MoCoBoxRecentEvents.this.getSharedPreferences(ILocalSharedPreferences.PreferenceName.updatesPreferences);
                try {
                    boxRecentItemsMessage.setTypedIds(MoCoBoxRecentEvents.this.getInterleavedRecentsAndEventsTypeIds(MoCoBoxRecentEvents.this.getRecentEventsSQLData(z, i, str, false, list2), MoCoBoxRecentEvents.this.getRecentSQLData(i, true), i));
                } catch (Exception e) {
                    boxRecentItemsMessage.setSuccess(false);
                    boxRecentItemsMessage.setException(e);
                }
                if (sharedPreferences.getBoolean(UpdatesConfig.PREFS_KEY_HAS_FETCHED_REMOTE_EVENTS, false) || (boxRecentItemsMessage.wasSuccessful() && boxRecentItemsMessage.getPayload().getCount() > 0)) {
                    CoreServiceUtils.broadcastIntent(MoCoBoxRecentEvents.this.mUserContextManager, boxRecentItemsMessage);
                }
                return boxRecentItemsMessage;
            }
        }, getExecutor(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BoxEventSQLData> getRecentEventsSQLData(boolean z, long j, String str, boolean z2, List<String> list) throws SQLException {
        SharedPreferences userSharedPrefs = this.mUserContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.updatesPreferences);
        if (z) {
            try {
                String[] strArr = new String[list.size()];
                list.toArray(strArr);
                BoxRequestGetUpdates updatesRequest = this.mPrivateApi.getUpdatesRequest();
                updatesRequest.setLimit((int) j);
                updatesRequest.setEventTypes(strArr);
                BoxResponse boxResponse = performRemote(updatesRequest).get();
                if (boxResponse.isSuccess()) {
                    BoxEventUtils.refreshItemsInEvents(this, this.mFolderApi, this.mFileApi, (BoxIteratorEvents) boxResponse.getResult());
                }
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                BoxLogUtils.logException(e);
            }
            userSharedPrefs.edit().putBoolean(UpdatesConfig.PREFS_KEY_HAS_FETCHED_REMOTE_EVENTS, true).commit();
        }
        HashMap map = new HashMap();
        map.put("event_type", list);
        if (!z2) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(false);
            map.put("user_dismissed", arrayList);
        }
        if (StringUtils.isNotEmpty(str) && !"*".equals(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str);
            map.put(BoxEventSQLData.COL_EVENT_OWNER_ID, arrayList2);
        }
        return getSqlHelper().getQueryManager().queryForColumnWithMaxWhileFiltering(BoxEventSQLData.class, "created_at", false, Long.valueOf(j), map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> getInterleavedRecentsAndEventsTypeIds(List<BoxEventSQLData> list, List<BoxRecentFileSQLData> list2, int i) throws SQLException {
        if (this.mUserContextManager.getUserInfo() == null) {
            return null;
        }
        removeSelfPreviewEvents(list);
        List<BoxEventSQLData> listRemoveDuplicateEvents = removeDuplicateEvents(list);
        removeDuplicateRecents(list2, listRemoveDuplicateEvents);
        int size = listRemoveDuplicateEvents.size();
        int size2 = list2.size();
        if (size + size2 > i) {
            int i2 = (int) (((double) i) / 2.0d);
            if (size < i - i2) {
                size2 = i - size;
            }
            if (size2 < i2) {
                size = i - size2;
            }
            list2 = list2.subList(0, size2);
            listRemoveDuplicateEvents = listRemoveDuplicateEvents.subList(0, size);
        }
        TreeMap treeMap = new TreeMap();
        for (BoxEventSQLData boxEventSQLData : listRemoveDuplicateEvents) {
            treeMap.put(Long.valueOf(boxEventSQLData.getCreatedAt()), getKeyValueStore().keyNamer().getBoxObjectKey("event", boxEventSQLData.getId()));
        }
        for (BoxRecentFileSQLData boxRecentFileSQLData : list2) {
            treeMap.put(Long.valueOf(boxRecentFileSQLData.getTimestamp()), getKeyValueStore().keyNamer().getBoxObjectKey(boxRecentFileSQLData.getItemType(), boxRecentFileSQLData.getItemId()));
        }
        return new ArrayList(treeMap.descendingMap().values());
    }

    private void removeSelfPreviewEvents(List<BoxEventSQLData> list) {
        Iterator<BoxEventSQLData> it = list.iterator();
        String id = this.mUserContextManager.getUserInfo().getUserId();
        while (it.hasNext()) {
            BoxEventSQLData next = it.next();
            if (BoxEvent.EVENT_TYPE_ITEM_PREVIEW.equalsIgnoreCase(next.getEventType()) && id.equals(next.getOwnerId())) {
                it.remove();
            }
        }
    }

    private void removeDuplicateRecents(List<BoxRecentFileSQLData> list, List<BoxEventSQLData> list2) {
        HashMap map = new HashMap();
        for (BoxEventSQLData boxEventSQLData : list2) {
            map.put(boxEventSQLData.getSourceItemId(), boxEventSQLData.getSourceItemType());
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            BoxRecentFileSQLData boxRecentFileSQLData = list.get(i);
            if (boxRecentFileSQLData.getItemType().equals((String) map.get(boxRecentFileSQLData.getItemId()))) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            list.remove(((Integer) arrayList.get(size)).intValue());
        }
    }

    private String eventToActionIdString(BoxEventSQLData boxEventSQLData) {
        return boxEventSQLData.getSourceItemType() + "_" + boxEventSQLData.getSourceItemId() + "_" + boxEventSQLData.getEventType();
    }

    private List<BoxEventSQLData> removeDuplicateEvents(List<BoxEventSQLData> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (BoxEventSQLData boxEventSQLData : list) {
            BoxEventSQLData boxEventSQLData2 = (BoxEventSQLData) linkedHashMap.get(eventToActionIdString(boxEventSQLData));
            if (boxEventSQLData2 == null || boxEventSQLData2.getCreatedAt() < boxEventSQLData.getCreatedAt()) {
                linkedHashMap.put(eventToActionIdString(boxEventSQLData), boxEventSQLData);
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add((BoxEventSQLData) it.next());
        }
        return arrayList;
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents
    public BoxFutureTask<BoxLocalMetadataMessage> updateItemLocalMetadata(final BoxEntity boxEntity, final String str, final Object obj) {
        return asyncBuildAndRunFutureTask(new BoxCallable<BoxLocalMetadataMessage>() { // from class: com.box.android.modelcontroller.MoCoBoxRecentEvents.6
            @Override // java.util.concurrent.Callable
            public BoxLocalMetadataMessage call() throws Exception {
                BoxLocalMetadataMessage boxLocalMetadataMessage = new BoxLocalMetadataMessage();
                boxLocalMetadataMessage.setRequestId(getRequestId());
                boxLocalMetadataMessage.setSuccess(true);
                try {
                    BoxLocalMetadata orCreateLocalMetadata = MoCoBoxRecentEvents.this.getOrCreateLocalMetadata(boxEntity.getUserId(), boxEntity.getType());
                    orCreateLocalMetadata.put(str, obj);
                    MoCoBoxRecentEvents.this.saveLocalMetadata(orCreateLocalMetadata);
                    boxLocalMetadataMessage.setSourceObjectId(boxEntity.getUserId());
                    boxLocalMetadataMessage.setSourceObjectType(boxEntity.getType());
                    boxLocalMetadataMessage.setPayload(orCreateLocalMetadata);
                    return boxLocalMetadataMessage;
                } catch (Exception e) {
                    boxLocalMetadataMessage.setException(e);
                    boxLocalMetadataMessage.setSuccess(false);
                    return boxLocalMetadataMessage;
                }
            }
        }, getExecutorPool().getLocalModelExecutor());
    }
}
