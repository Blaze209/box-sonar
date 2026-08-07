package com.box.android.coreservices.modelcontroller.messages;

import com.box.android.coreservices.jobmanager.jobcollections.OfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.OfflineBoxJob;
import com.box.android.coreservices.jobmanager.jobs.RemoveOfflineBoxJob;
import com.box.androidsdk.content.requests.BoxRequestsBookmark;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.boxandroidlibv2private.requests.BoxRequestCreateBoxNote;
import com.box.boxandroidlibv2private.requests.BoxRequestDeleteCollaboration;

/* JADX INFO: loaded from: classes9.dex */
public final class Controller {
    public static final String ACTION_COPIED_ITEMS = "com.box.android.copiedItems";
    public static final String ACTION_DELETED_COLLABORATION_SELF = "com.box.android.deletedCollaborationSelf";
    public static final String ACTION_DELETED_ITEMS = "com.box.android.deletedItems";
    public static final String ACTION_DISMISS_SPINNER = "com.box.android.dismissSpinner";
    public static final String ACTION_EXPORTED_FILE = "com.box.android.exportedFile";
    public static final String ACTION_EXPORTING_FILE = "com.box.android.exportingFile";
    public static final String ACTION_FETCHED_EVENTS_RECENTS = "com.box.android.fetchedEventsRecentsUpdates";
    public static final String ACTION_FETCHED_EVENT_UPDATES = "com.box.android.fetchedEventUpdates";
    public static final String ACTION_FETCHED_ITEM_FROM_SHARED_LINK = "com.box.android.fetchedItemFromSharedLink";
    public static final String ACTION_FETCHED_OFFLINE_FOLDER_ITEMS = "com.box.android.fetchedOfflineFolderItems";
    public static final String ACTION_FETCHED_RECENTS = "com.box.android.fetchedRecents";
    public static final String ACTION_MADE_FILE_AVAILABLE_OFFLINE = "com.box.android.madeFileAvailableOffline";
    public static final String ACTION_MAKING_FILE_AVAILABLE_OFFLINE = "com.box.android.makingFileAvailableOffline";
    public static final String ACTION_MOVED_ITEMS = "com.box.android.movedItems";
    public static final String ACTION_REMOVED_ALL_OFFLINE = "com.box.android.removedAllOffline";
    public static final String ACTION_REMOVED_OFFLINE_ITEMS = "com.box.android.removedOfflineItems";
    public static final String ACTION_SEARCHED = "com.box.android.searched";
    public static final String ACTION_SORT_PREFERENCES_CHANGED = "com.box.android.sort_preferences_changed";
    public static final String ACTION_UPLOADING_FILE = "com.box.android.uploadingFile";
    public static final String ARG_BOXITEM = "boxitem";
    public static final String ARG_CUSTOM_LOGOUT_MSG = "custom_logout_message";
    public static final String ARG_FOLDER_ID = "folder_id";
    public static final String ARG_ITEM_ID = "item_id";
    public static final String ARG_ITEM_TYPE = "item_type";
    public static final String ARG_KILL_PROCESS_AT_LOGOUT = "kill_process_at_logout";
    public static final String ARG_SUCCESS = "success";
    public static final String ARG_TAG = "com.box.android.tag";
    public static final String ACTION_UPLOADED_FILE = BoxRequestsFile.UploadFile.class.getName();
    public static final String ACTION_DELETED_FILE = BoxRequestsFile.DeleteFile.class.getName();
    public static final String ACTION_DELETED_FOLDER = BoxRequestsFolder.DeleteFolder.class.getName();
    public static final String ACTION_CREATED_FOLDER = BoxRequestsFolder.CreateFolder.class.getName();
    public static final String ACTION_DELETED_BOOKMARK = BoxRequestsBookmark.DeleteBookmark.class.getName();
    public static final String ACTION_DELETED_COLLABORATION = BoxRequestDeleteCollaboration.class.getName();
    public static final String ACTION_REMOVE_OFFLINE_ITEM = RemoveOfflineBoxJob.class.getName();
    public static final String ACTION_ADD_OFFLINE_ITEM = OfflineBoxJob.class.getName();
    public static final String ACTION_ADD_OFFLINE_ITEM_ALL_FINISHED = OfflineBoxJobCollection.class.getName();
    public static final String ACTION_GET_FILE_INFO = BoxRequestsFile.GetFileInfo.class.getName();
    public static final String ACTION_BOX_NOTE_CREATED = BoxRequestCreateBoxNote.class.getName();
}
