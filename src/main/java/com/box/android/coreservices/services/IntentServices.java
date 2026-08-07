package com.box.android.coreservices.services;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.box.android.activities.addcontent.CreateDocumentTaskActivity;
import com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivityKt;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.NewNoteLocation;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.models.search.SearchMode;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxSession;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.BuildConfig;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: IntentServices.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001:\u0002]^J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J6\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0007H&J(\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u001fH&J$\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H&J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J\u001e\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H&J.\u0010*\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H&J$\u0010+\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010)2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J$\u0010+\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J$\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010)2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H'J\"\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00100\u001a\u00020.2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\"\u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H&J\u0018\u00103\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00104\u001a\u000205H&J\u0018\u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00107\u001a\u00020)H&J*\u00108\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00109\u001a\u00020:2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010;\u001a\u0004\u0018\u00010<H'J,\u00108\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<H&J\"\u0010=\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010A\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010B\u001a\u0004\u0018\u00010CH&J \u0010D\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010E\u001a\u00020F2\u0006\u0010\f\u001a\u00020\rH&J \u0010G\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010H\u001a\u00020F2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010I\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u0007H&J\u001a\u0010K\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u00010MH&J \u0010N\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\"H&J\u0018\u0010Q\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010R\u001a\u00020SH&J\b\u0010T\u001a\u00020\u0003H&J<\u0010U\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010W\u001a\u00020\"2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010Y\u001a\u00020\"H&J\u001c\u0010Z\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010[\u001a\u0004\u0018\u00010MH&J\u0010\u0010\\\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006_À\u0006\u0003"}, d2 = {"Lcom/box/android/coreservices/services/IntentServices;", "", "createDocumentTaskIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "folderId", "", CreateDocumentTaskActivity.EXTRA_ASSET_NAME, "quickNoteCreationIntent", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/NewNoteLocation;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "emailSupportActivityIntent", "createOAuthActivityIntent", "session", "Lcom/box/androidsdk/content/models/BoxSession;", "restrictedUserId", "analyticsFlow", "analyticsPage", "startScreenActivityIntent", "tag", "expiredVersionDialogActivityIntent", "title", "message", "buttonText", "mainPhoneActivityIntent", "Lcom/box/android/domain/models/ItemId;", BoxCommonConstants.EXTRA_FOLDER_NAME, "flags", "", "navigationActivityIntent", "needOpenNewHomeScreen", "", "navigationIntentTarget", "Lcom/box/android/coreservices/services/IntentServices$NavigationIntentTarget;", "fileRouterActivityIntent", "newDeleteTaskIntent", "itemsToDelete", "", "Lcom/box/androidsdk/content/models/BoxItem;", "newInfoDialogIntent", "inviteCollaboratorsActivityIntent", "boxItem", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "shareActivityIntent", "item", "localFolderChooserIntent", "startingPath", "captureMediaIntent", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "renameTaskActivityIntent", "itemToRename", "collaborationsActivityIntent", "collaborationItem", "Lcom/box/androidsdk/content/models/BoxCollaborationItem;", "collaborations", "Lcom/box/androidsdk/content/models/BoxIteratorCollaborations;", "openFileIntent", "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "launchIntent", "settingsActivityIntent", BuildConfig.FLAVOR, "Lcom/box/android/coreservices/services/IntentServices$SettingsFragment;", "galleryItemsActivityIntent", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "playlistItemsActivityIntent", "initialFileModel", "hubDetailsActivityIntent", "id", "hubDetailsRouterActivityIntent", "uri", "Landroid/net/Uri;", "openCollectionIntent", BoxItemJob.COLLECTION_ID, "useNewHomeScreen", "searchActivityIntent", "searchMode", "Lcom/box/android/domain/models/search/SearchMode;", "playStoreBoxPageIntent", "boxIntuneMAMAuthActivityIntent", BoxIntuneMAMAuthActivityKt.USER_EMAIL_EXTRA, BoxIntuneMAMAuthActivityKt.IS_MSAL_AUTH_EXTRA, BoxIntuneMAMAuthActivityKt.CODE_CHALLENGE_EXTRA, BoxIntuneMAMAuthActivityKt.SHOW_BLOCKING_UI_EXTRA, "betaFeedbackActivityIntent", "screenshotUri", "contentPickerActivityIntent", "NavigationIntentTarget", "SettingsFragment", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IntentServices {

    /* JADX INFO: compiled from: IntentServices.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/box/android/coreservices/services/IntentServices$NavigationIntentTarget;", "", "<init>", "(Ljava/lang/String;I)V", "ALL_FILES", "RECENT", "OFFLINE", "FAVORITES", "HUBS", "NOTIFICATIONS", "MY_TASKS", "SENT_TASKS", "COLLECTIONS", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum NavigationIntentTarget {
        ALL_FILES,
        RECENT,
        OFFLINE,
        FAVORITES,
        HUBS,
        NOTIFICATIONS,
        MY_TASKS,
        SENT_TASKS,
        COLLECTIONS;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<NavigationIntentTarget> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: IntentServices.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/box/android/coreservices/services/IntentServices$SettingsFragment;", "", "<init>", "(Ljava/lang/String;I)V", "FILES_AND_FOLDERS_SETTINGS", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum SettingsFragment {
        FILES_AND_FOLDERS_SETTINGS;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<SettingsFragment> getEntries() {
            return $ENTRIES;
        }
    }

    Intent betaFeedbackActivityIntent(Context context, Uri screenshotUri);

    Intent boxIntuneMAMAuthActivityIntent(Context context, String userEmail, boolean isMSALAuth, String codeChallenge, boolean showBlockingUI);

    Intent captureMediaIntent(Context context, FolderModel folder);

    Intent collaborationsActivityIntent(Context context, ItemModel itemModel, BoxSession session, BoxIteratorCollaborations collaborations);

    @Deprecated(message = "Use collaborationsActivityIntent with ItemModel")
    Intent collaborationsActivityIntent(Context context, BoxCollaborationItem collaborationItem, BoxSession session, BoxIteratorCollaborations collaborations);

    Intent contentPickerActivityIntent(Context context);

    Intent createDocumentTaskIntent(Context context, String folderId, String assetName);

    Intent createOAuthActivityIntent(Context context, BoxSession session, String restrictedUserId, String analyticsFlow, String analyticsPage);

    Intent emailSupportActivityIntent(Context context);

    Intent expiredVersionDialogActivityIntent(Context context, String title, String message, String buttonText);

    Intent fileRouterActivityIntent(Context context, PreviewSource previewSource);

    Intent galleryItemsActivityIntent(Context context, FileModel fileModel, PreviewSource previewSource);

    Intent hubDetailsActivityIntent(Context context, String id);

    Intent hubDetailsRouterActivityIntent(Context context, Uri uri);

    Intent inviteCollaboratorsActivityIntent(Context context, ItemModel itemModel, BoxSession session);

    Intent inviteCollaboratorsActivityIntent(Context context, BoxItem boxItem, BoxSession session);

    Intent localFolderChooserIntent(Context context, String startingPath, String title);

    Intent mainPhoneActivityIntent(Context context);

    Intent mainPhoneActivityIntent(Context context, ItemId folderId, String folderName, int flags);

    Intent navigationActivityIntent(Context context, boolean needOpenNewHomeScreen, NavigationIntentTarget navigationIntentTarget);

    Intent newDeleteTaskIntent(Context context, List<? extends BoxItem> itemsToDelete);

    Intent newInfoDialogIntent(Context context, String title, String message, String buttonText);

    Intent openCollectionIntent(Context context, String collectionId, boolean useNewHomeScreen);

    Intent openFileIntent(Context context, BoxFile boxFile, Intent launchIntent);

    Intent playStoreBoxPageIntent();

    Intent playlistItemsActivityIntent(Context context, FileModel initialFileModel, PreviewSource previewSource);

    Intent quickNoteCreationIntent(Context context, NewNoteLocation location, PreviewSource previewSource);

    Intent renameTaskActivityIntent(Context context, BoxItem itemToRename);

    Intent searchActivityIntent(Context context, SearchMode searchMode);

    Intent settingsActivityIntent(Context context, SettingsFragment fragment);

    Intent shareActivityIntent(Context context, ItemModel item, BoxSession session);

    @Deprecated(message = "Use shareActivityIntent with ItemModel")
    Intent shareActivityIntent(Context context, BoxItem item, BoxSession session);

    Intent startScreenActivityIntent(String tag);

    /* JADX INFO: compiled from: IntentServices.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Intent mainPhoneActivityIntent$default(IntentServices intentServices, Context context, ItemId itemId, String str, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mainPhoneActivityIntent");
        }
        if ((i2 & 8) != 0) {
            i = 335544320;
        }
        return intentServices.mainPhoneActivityIntent(context, itemId, str, i);
    }

    static /* synthetic */ Intent navigationActivityIntent$default(IntentServices intentServices, Context context, boolean z, NavigationIntentTarget navigationIntentTarget, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigationActivityIntent");
        }
        if ((i & 4) != 0) {
            navigationIntentTarget = null;
        }
        return intentServices.navigationActivityIntent(context, z, navigationIntentTarget);
    }

    static /* synthetic */ Intent collaborationsActivityIntent$default(IntentServices intentServices, Context context, ItemModel itemModel, BoxSession boxSession, BoxIteratorCollaborations boxIteratorCollaborations, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collaborationsActivityIntent");
        }
        if ((i & 8) != 0) {
            boxIteratorCollaborations = null;
        }
        return intentServices.collaborationsActivityIntent(context, itemModel, boxSession, boxIteratorCollaborations);
    }

    static /* synthetic */ Intent settingsActivityIntent$default(IntentServices intentServices, Context context, SettingsFragment settingsFragment, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: settingsActivityIntent");
        }
        if ((i & 2) != 0) {
            settingsFragment = null;
        }
        return intentServices.settingsActivityIntent(context, settingsFragment);
    }

    static /* synthetic */ Intent boxIntuneMAMAuthActivityIntent$default(IntentServices intentServices, Context context, String str, boolean z, String str2, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: boxIntuneMAMAuthActivityIntent");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        return intentServices.boxIntuneMAMAuthActivityIntent(context, str, z, str2, z2);
    }

    static /* synthetic */ Intent betaFeedbackActivityIntent$default(IntentServices intentServices, Context context, Uri uri, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: betaFeedbackActivityIntent");
        }
        if ((i & 2) != 0) {
            uri = null;
        }
        return intentServices.betaFeedbackActivityIntent(context, uri);
    }
}
