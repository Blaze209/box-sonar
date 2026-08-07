package com.box.boxandroidlibv2private.resourcemanagers;

import com.box.androidsdk.content.BoxApi;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxComment;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxHttpResponse;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.dao.BoxNoteCreation;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.box.boxandroidlibv2private.model.BoxTask;
import com.box.boxandroidlibv2private.requests.BoxRequestAddPushNotificationDevice;
import com.box.boxandroidlibv2private.requests.BoxRequestCreateBoxNote;
import com.box.boxandroidlibv2private.requests.BoxRequestCreateTask;
import com.box.boxandroidlibv2private.requests.BoxRequestDeleteTask;
import com.box.boxandroidlibv2private.requests.BoxRequestGetAllInbox;
import com.box.boxandroidlibv2private.requests.BoxRequestGetFeatures;
import com.box.boxandroidlibv2private.requests.BoxRequestGetInbox;
import com.box.boxandroidlibv2private.requests.BoxRequestGetNotificationCategories;
import com.box.boxandroidlibv2private.requests.BoxRequestGetPushNotifications;
import com.box.boxandroidlibv2private.requests.BoxRequestGetTask;
import com.box.boxandroidlibv2private.requests.BoxRequestGetTaskBadge;
import com.box.boxandroidlibv2private.requests.BoxRequestGetTaskCollaborators;
import com.box.boxandroidlibv2private.requests.BoxRequestGetUpdates;
import com.box.boxandroidlibv2private.requests.BoxRequestGetUserDeviceTokenSettings;
import com.box.boxandroidlibv2private.requests.BoxRequestGetUserItemSettings;
import com.box.boxandroidlibv2private.requests.BoxRequestPreflightCheck;
import com.box.boxandroidlibv2private.requests.BoxRequestStorePushNotification;
import com.box.boxandroidlibv2private.requests.BoxRequestUpdatePushNotificationDevice;
import com.box.boxandroidlibv2private.requests.BoxRequestUpdateTaskCollaborator;
import com.box.boxandroidlibv2private.requests.BoxRequestUpdateTaskCollaboratorAndGetTask;
import com.box.boxandroidlibv2private.requests.BoxRequestUpdateUserDeviceTokenSettings;
import com.box.boxandroidlibv2private.requests.BoxRequestUpdateUserItemSettings;
import com.box.boxandroidlibv2private.requests.BoxRequestUpdateUserNotificationCategories;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes13.dex */
public class BoxApiPrivate extends BoxApi {
    public static final String[] BASE_FIELDS;
    public static final String[] COLLAB_ROLE_FIELDS = {BoxCollaborationItem.FIELD_ALLOWED_INVITEE_ROLES, "permissions", BoxItem.FIELD_OWNED_BY, BoxCollaborationItem.FIELD_DEFAULT_INVITEE_ROLE};
    public static final String[] COMMENTS_FIELDS;
    public static final String[] FILE_FIELDS;
    public static final String[] FOLDER_FIELDS;
    public static final String[] SEARCH_FIELDS;
    protected BoxExtendedApiCollections mCollectionsApi;
    protected BoxExtendedApiFile mFileApi;
    protected BoxExtendedApiFolder mFolderApi;
    protected BoxExtendedApiWeblink mWeblinkApi;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add("parent");
        arrayList.add(BoxItem.FIELD_PATH_COLLECTION);
        arrayList.add("name");
        arrayList.add("size");
        arrayList.add("modified_at");
        arrayList.add("url");
        arrayList.add("shared_link");
        arrayList.add("sha1");
        arrayList.add(BoxItem.FIELD_OWNED_BY);
        arrayList.add("comment_count");
        arrayList.add("annotation_count");
        arrayList.add("content_created_at");
        arrayList.add("content_modified_at");
        arrayList.add("modified_by");
        arrayList.add("permissions");
        arrayList.add(BoxItem.FIELD_COLLECTIONS);
        arrayList.add(BoxCollaborationItem.FIELD_HAS_COLLABORATIONS);
        arrayList.add(BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED);
        arrayList.add("file_version");
        arrayList.add(BoxFile.FIELD_LOCK);
        arrayList.add(BoxFile.FIELD_WATERMARK);
        arrayList.add("description");
        BASE_FIELDS = (String[]) arrayList.toArray(new String[arrayList.size()]);
        ArrayList arrayList2 = new ArrayList(arrayList);
        arrayList2.add(BoxFile.FIELD_REPRESENTATIONS);
        FILE_FIELDS = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
        ArrayList arrayList3 = new ArrayList(arrayList);
        arrayList3.add(BoxFolder.FIELD_ITEM_COLLECTION);
        FOLDER_FIELDS = (String[]) arrayList3.toArray(new String[arrayList3.size()]);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add("item");
        arrayList4.add("created_at");
        arrayList4.add("created_by");
        arrayList4.add("message");
        arrayList4.add(BoxComment.FIELD_IS_REPLY_COMMENT);
        arrayList4.add(BoxComment.FIELD_TAGGED_MESSAGE);
        COMMENTS_FIELDS = (String[]) arrayList4.toArray(new String[arrayList4.size()]);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add("size");
        arrayList5.add("modified_at");
        arrayList5.add("sha1");
        arrayList5.add(BoxItem.FIELD_PATH_COLLECTION);
        arrayList5.add("name");
        arrayList5.add(BoxCollaborationItem.FIELD_HAS_COLLABORATIONS);
        arrayList5.add(BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED);
        arrayList5.add(BoxItem.FIELD_OWNED_BY);
        arrayList5.add("url");
        SEARCH_FIELDS = (String[]) arrayList5.toArray(new String[arrayList5.size()]);
    }

    public BoxApiPrivate(BoxSession boxSession, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiWeblink boxExtendedApiWeblink, BoxExtendedApiCollections boxExtendedApiCollections) {
        super(boxSession);
        this.mFolderApi = boxExtendedApiFolder;
        this.mFileApi = boxExtendedApiFile;
        this.mWeblinkApi = boxExtendedApiWeblink;
        this.mCollectionsApi = boxExtendedApiCollections;
    }

    public BoxApiPrivate(BoxSession boxSession) {
        super(boxSession);
        this.mFolderApi = new BoxExtendedApiFolder(boxSession);
        this.mFileApi = new BoxExtendedApiFile(boxSession);
        this.mWeblinkApi = new BoxExtendedApiWeblink(boxSession);
        this.mCollectionsApi = new BoxExtendedApiCollections(boxSession);
    }

    public String getApiUrl(String str) {
        boolean zStartsWith = str.startsWith("/");
        Object[] objArr = {getBaseUri(), str};
        return zStartsWith ? String.format("%s%s", objArr) : String.format(CommandParameters.APPLICATION_IDENTIFIER_FORMAT, objArr);
    }

    public BoxRequestAddPushNotificationDevice getAddPushNotificationDeviceRequest(String str, String str2, String str3) {
        BoxRequestAddPushNotificationDevice boxRequestAddPushNotificationDevice = new BoxRequestAddPushNotificationDevice(getApiUrl(BoxRequestAddPushNotificationDevice.getUri()), str, str2, str3, this.mSession);
        checkSession(boxRequestAddPushNotificationDevice);
        return boxRequestAddPushNotificationDevice;
    }

    private void checkSession(BoxRequest boxRequest) {
        if (this.mSession == null || this.mSession.getAuthInfo() == null) {
            BoxLogUtils.logException("Request created with null session", "request " + boxRequest + " session " + this.mSession, new RuntimeException("request constructed with invalid session"));
        } else if (countString(this.mSession.getAuthInfo().accessToken()) < 3 || countString(this.mSession.getAuthInfo().refreshToken()) < 3) {
            BoxLogUtils.logException("Request created with blank access or refresh token ", "request " + boxRequest + " access " + countString(this.mSession.getAuthInfo().accessToken()) + " refresh " + countString(this.mSession.getAuthInfo().refreshToken()), new RuntimeException("request constructed with invalid session"));
        }
    }

    private int countString(String str) {
        if (str == null) {
            return -1;
        }
        return str.length();
    }

    public BoxRequestUpdatePushNotificationDevice getUpdatePushNotificationDevice(String str, String str2, String str3, String str4) {
        BoxRequestUpdatePushNotificationDevice boxRequestUpdatePushNotificationDevice = new BoxRequestUpdatePushNotificationDevice(getApiUrl(BoxRequestUpdatePushNotificationDevice.getUri(str)), this.mSession);
        if (!SdkUtils.isBlank(str2)) {
            boxRequestUpdatePushNotificationDevice.setPlatform(str2);
        }
        if (!SdkUtils.isBlank(str3)) {
            boxRequestUpdatePushNotificationDevice.setDeviceToken(str3);
        }
        if (!SdkUtils.isBlank(str4)) {
            boxRequestUpdatePushNotificationDevice.setLanguage(str4);
        }
        checkSession(boxRequestUpdatePushNotificationDevice);
        return boxRequestUpdatePushNotificationDevice;
    }

    public BoxRequestGetFeatures getFeaturesRequest() {
        return new BoxRequestGetFeatures(getApiUrl(BoxRequestGetFeatures.getUri()), this.mSession);
    }

    public BoxRequestCreateBoxNote getBoxNoteCreation(String str, String str2, String str3) {
        String completeUri = BoxRequestCreateBoxNote.getCompleteUri(str3);
        if (this.mSession.getAuthInfo() != null && this.mSession.getAuthInfo().getBaseDomain() != null && this.mSession.getAuthInfo().getBaseDomain().contains("devpod.apps-global.gcp001.dev.box.net")) {
            completeUri = "https://app." + this.mSession.getAuthInfo().getBaseDomain() + "/document/boxnote/new";
        }
        BoxRequestCreateBoxNote boxRequestCreateBoxNote = new BoxRequestCreateBoxNote(completeUri, this.mSession, str, str2);
        boxRequestCreateBoxNote.setRequestHandler(new BoxNoteRequestHandler(boxRequestCreateBoxNote));
        return boxRequestCreateBoxNote;
    }

    private class BoxNoteRequestHandler extends BoxRequest.BoxRequestHandler {
        public BoxNoteRequestHandler(BoxRequest boxRequest) {
            super(boxRequest);
        }

        @Override // com.box.androidsdk.content.requests.BoxRequest.BoxRequestHandler
        public BoxObject onResponse(Class cls, BoxHttpResponse boxHttpResponse) throws IllegalAccessException, BoxException, InstantiationException {
            BoxNoteCreation boxNoteCreation;
            BoxObject boxObjectOnResponse = super.onResponse(cls, boxHttpResponse);
            if ((boxObjectOnResponse instanceof BoxNoteCreation) && (boxNoteCreation = (BoxNoteCreation) boxObjectOnResponse) != null && boxNoteCreation.getSuccess() == Boolean.FALSE) {
                String errorMessage = boxNoteCreation.getErrorMessage();
                if (BoxNoteCreation.ERROR_INVALID_OAUTH_TOKEN.equals(errorMessage)) {
                    try {
                        BoxResponse boxResponse = BoxApiPrivate.this.mSession.refresh().get();
                        if (boxResponse.isSuccess()) {
                            return this.mRequest.send();
                        }
                        if (boxResponse.getException() != null && (boxResponse.getException() instanceof BoxException.RefreshFailure)) {
                            throw ((BoxException.RefreshFailure) boxResponse.getException());
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new BoxException(e.getMessage(), e);
                    } catch (ExecutionException e2) {
                        throw new BoxException(e2.getMessage(), e2);
                    }
                } else {
                    throw new BoxException(errorMessage);
                }
            }
            return boxObjectOnResponse;
        }
    }

    public BoxRequestPreflightCheck getCanUploadFile() {
        return new BoxRequestPreflightCheck(getApiUrl(BoxRequestPreflightCheck.URI), this.mSession);
    }

    public BoxRequestPreflightCheck getCanUploadNewVersion(String str) {
        return new BoxRequestPreflightCheck(getApiUrl(String.format(BoxRequestPreflightCheck.FILE_URI, str)), this.mSession);
    }

    public BoxRequestGetUpdates getUpdatesRequest() {
        return new BoxRequestGetUpdates(getApiUrl(BoxRequestGetUpdates.getUri()), this.mSession);
    }

    public BoxRequestStorePushNotification getStorePushNotificationRequest(BoxPushNotification boxPushNotification) {
        return new BoxRequestStorePushNotification(this.mSession, boxPushNotification);
    }

    public BoxRequestGetPushNotifications getPushNotificationsRequest() {
        return new BoxRequestGetPushNotifications(this.mSession);
    }

    public BoxRequestGetTask getTask(String str) {
        return new BoxRequestGetTask(getApiUrl(BoxRequestGetTask.getUri(str)), str, this.mSession);
    }

    public BoxRequestGetInbox getInbox() {
        return new BoxRequestGetInbox(getApiUrl(BoxRequestGetInbox.getUri()), this.mSession);
    }

    public BoxRequestGetAllInbox getInboxAll() {
        return new BoxRequestGetAllInbox(getApiUrl(BoxRequestGetInbox.getUri()), this.mSession);
    }

    public BoxRequestDeleteTask getDeleteTask(String str) {
        return new BoxRequestDeleteTask(getApiUrl(BoxRequestDeleteTask.getUri(str)), str, this.mSession);
    }

    public BoxRequestGetTaskBadge getTaskBadge() {
        return new BoxRequestGetTaskBadge(getApiUrl(BoxRequestGetTaskBadge.getUri()), this.mSession);
    }

    public BoxRequestGetTaskCollaborators getTaskCollaborators(String str) {
        return new BoxRequestGetTaskCollaborators(getApiUrl(BoxRequestGetTaskCollaborators.getUri(str)), str, this.mSession);
    }

    public BoxRequestCreateTask createTask(String str) {
        return new BoxRequestCreateTask(getApiUrl(BoxRequestCreateTask.getUri()), str, this.mSession);
    }

    public BoxRequestUpdateTaskCollaborator updateTaskCollaborator(String str, String str2) {
        return new BoxRequestUpdateTaskCollaborator(getApiUrl(BoxRequestUpdateTaskCollaborator.getUri(str)), str, str2, this.mSession);
    }

    public BoxRequestUpdateTaskCollaboratorAndGetTask updateTaskAssignmentCollaborator(BoxTask boxTask, String str) {
        return new BoxRequestUpdateTaskCollaboratorAndGetTask(getApiUrl(BoxRequestGetTask.getUri(boxTask.getUserId())), boxTask.getUserId(), this.mSession, new BoxRequestUpdateTaskCollaborator(boxTask, str, getSession(), this));
    }

    public BoxRequestGetUserItemSettings getUserItemSettings(String str, BoxRequestGetUserItemSettings.UserSettingsBoxItemType userSettingsBoxItemType) {
        return new BoxRequestGetUserItemSettings(getApiUrl(BoxRequestGetUserItemSettings.getUri()), str, userSettingsBoxItemType, this.mSession);
    }

    public BoxRequestGetUserDeviceTokenSettings getUserDeviceTokenSettings(String str) {
        return new BoxRequestGetUserDeviceTokenSettings(getApiUrl(BoxRequestGetUserDeviceTokenSettings.getUri()), str, this.mSession);
    }

    public BoxRequestGetNotificationCategories getNotificationCategories() {
        return new BoxRequestGetNotificationCategories(getApiUrl(BoxRequestGetNotificationCategories.getUri()), this.mSession);
    }

    public BoxRequestUpdateUserItemSettings updateUserItemSettings(String str, Boolean bool) {
        return new BoxRequestUpdateUserItemSettings(getApiUrl(BoxRequestUpdateUserItemSettings.getUri(str)), bool.booleanValue(), this.mSession);
    }

    public BoxRequestUpdateUserDeviceTokenSettings updateUserDeviceTokenSettings(String str, Boolean bool) {
        return new BoxRequestUpdateUserDeviceTokenSettings(getApiUrl(BoxRequestUpdateUserDeviceTokenSettings.getUri(str)), bool.booleanValue(), this.mSession);
    }

    public BoxRequestUpdateUserNotificationCategories updateUserNotificationCategories(BoxRequestUpdateUserNotificationCategories.NotificationCategories notificationCategories, Boolean bool) {
        return new BoxRequestUpdateUserNotificationCategories(getApiUrl(BoxRequestUpdateUserNotificationCategories.getUri()), notificationCategories, bool.booleanValue(), this.mSession);
    }

    public BoxSession getSession() {
        return this.mSession;
    }
}
