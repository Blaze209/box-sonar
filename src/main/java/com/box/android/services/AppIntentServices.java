package com.box.android.services;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.box.android.activities.BetaFeedbackActivity;
import com.box.android.activities.DeleteItemsActivity;
import com.box.android.activities.EmailSupportActivity;
import com.box.android.activities.ExpiredVersionDialogActivity;
import com.box.android.activities.InfoDialogActivity;
import com.box.android.activities.MainPhone;
import com.box.android.activities.OpenFile;
import com.box.android.activities.addcontent.CreateDocumentTaskActivity;
import com.box.android.activities.addcontent.QuickNoteCreationActivity;
import com.box.android.activities.filepicker.LocalFolderChooser;
import com.box.android.activities.login.CustomOAuthActivity;
import com.box.android.activities.login.StartScreenActivity;
import com.box.android.activities.settings.SettingsActivity;
import com.box.android.activities.share.UsxCollaborationsActivity;
import com.box.android.activities.share.UsxInviteCollaboratorsActivity;
import com.box.android.activities.share.UsxShareActivity;
import com.box.android.activities.tasks.RenameTaskActivity;
import com.box.android.activities.urlsinterceptor.router.FileRouterActivity;
import com.box.android.activities.urlsinterceptor.router.HubDetailsRouterActivity;
import com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity;
import com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivityKt;
import com.box.android.capture.activities.CaptureActivity;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.contentpicker.ContentPickerActivity;
import com.box.android.contentpicker.multitabitempicker.ItemPickerTab;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.NewNoteLocation;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.models.search.SearchMode;
import com.box.android.hubs.hubDetails.presentation.HubDetailsActivity;
import com.box.android.navigation.Navigation;
import com.box.android.navigation.NavigationTarget;
import com.box.android.navigationmodernization.MainActivity;
import com.box.android.navigationmodernization.MainNavigationTarget;
import com.box.android.preview.gallery.GalleryItemsActivity;
import com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistActivity;
import com.box.android.search.presentation.SearchActivity;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxSession;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.BuildConfig;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppIntentServices.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J6\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\nH\u0016J(\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u0016J\"\u0010#\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0018\u0010(\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u0010)\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J.\u0010-\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\nH\u0016J$\u0010.\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u0001002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010.\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010,2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u00102\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u00010,2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017J\"\u00102\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00103\u001a\u0002002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u00104\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00105\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u00106\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00107\u001a\u00020,H\u0016J*\u00108\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00109\u001a\u00020:2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010;\u001a\u0004\u0018\u00010<H\u0017J*\u00108\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010/\u001a\u0002002\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\"\u0010=\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010A\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J \u0010D\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010E\u001a\u00020F2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010G\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010H\u001a\u00020IH\u0016J \u0010J\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010K\u001a\u00020F2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010L\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010M\u001a\u00020\nH\u0016J \u0010N\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020%H\u0016J\u001a\u0010Q\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u0018\u0010T\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u00020\u0006H\u0016J4\u0010X\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010Y\u001a\u0004\u0018\u00010\n2\u0006\u0010Z\u001a\u00020%2\b\u0010[\u001a\u0004\u0018\u00010\n2\u0006\u0010\\\u001a\u00020%H\u0016J\u001a\u0010]\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010^\u001a\u0004\u0018\u00010SH\u0016J\u0010\u0010_\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\f\u0010`\u001a\u00020a*\u00020'H\u0002J\f\u0010b\u001a\u00020c*\u00020'H\u0002¨\u0006d"}, d2 = {"Lcom/box/android/services/AppIntentServices;", "Lcom/box/android/coreservices/services/IntentServices;", "Ljava/io/Serializable;", "<init>", "()V", "createDocumentTaskIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "folderId", "", CreateDocumentTaskActivity.EXTRA_ASSET_NAME, "quickNoteCreationIntent", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/NewNoteLocation;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "emailSupportActivityIntent", "createOAuthActivityIntent", "session", "Lcom/box/androidsdk/content/models/BoxSession;", "restrictedUserId", "analyticsFlow", "analyticsPage", "startScreenActivityIntent", "tag", "expiredVersionDialogActivityIntent", "title", "message", "buttonText", "mainPhoneActivityIntent", "Lcom/box/android/domain/models/ItemId;", BoxCommonConstants.EXTRA_FOLDER_NAME, "flags", "", "navigationActivityIntent", "needOpenNewHomeScreen", "", "navigationIntentTarget", "Lcom/box/android/coreservices/services/IntentServices$NavigationIntentTarget;", "fileRouterActivityIntent", "newDeleteTaskIntent", "itemsToDelete", "", "Lcom/box/androidsdk/content/models/BoxItem;", "newInfoDialogIntent", "inviteCollaboratorsActivityIntent", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "boxItem", "shareActivityIntent", "item", "localFolderChooserIntent", "startingPath", "renameTaskActivityIntent", "itemToRename", "collaborationsActivityIntent", "collaborationItem", "Lcom/box/androidsdk/content/models/BoxCollaborationItem;", "collaborations", "Lcom/box/androidsdk/content/models/BoxIteratorCollaborations;", "openFileIntent", "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "launchIntent", "settingsActivityIntent", BuildConfig.FLAVOR, "Lcom/box/android/coreservices/services/IntentServices$SettingsFragment;", "galleryItemsActivityIntent", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "captureMediaIntent", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "playlistItemsActivityIntent", "initialFileModel", "hubDetailsActivityIntent", "id", "openCollectionIntent", BoxItemJob.COLLECTION_ID, "useNewHomeScreen", "hubDetailsRouterActivityIntent", "uri", "Landroid/net/Uri;", "searchActivityIntent", "searchMode", "Lcom/box/android/domain/models/search/SearchMode;", "playStoreBoxPageIntent", "boxIntuneMAMAuthActivityIntent", BoxIntuneMAMAuthActivityKt.USER_EMAIL_EXTRA, BoxIntuneMAMAuthActivityKt.IS_MSAL_AUTH_EXTRA, BoxIntuneMAMAuthActivityKt.CODE_CHALLENGE_EXTRA, BoxIntuneMAMAuthActivityKt.SHOW_BLOCKING_UI_EXTRA, "betaFeedbackActivityIntent", "screenshotUri", "contentPickerActivityIntent", "toNavigationTarget", "Lcom/box/android/navigation/NavigationTarget;", "toMainNavigationTarget", "Lcom/box/android/navigationmodernization/MainNavigationTarget;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppIntentServices implements IntentServices, Serializable {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: AppIntentServices.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[IntentServices.SettingsFragment.values().length];
            try {
                iArr[IntentServices.SettingsFragment.FILES_AND_FOLDERS_SETTINGS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[IntentServices.NavigationIntentTarget.values().length];
            try {
                iArr2[IntentServices.NavigationIntentTarget.ALL_FILES.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[IntentServices.NavigationIntentTarget.RECENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[IntentServices.NavigationIntentTarget.OFFLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[IntentServices.NavigationIntentTarget.FAVORITES.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[IntentServices.NavigationIntentTarget.HUBS.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[IntentServices.NavigationIntentTarget.NOTIFICATIONS.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[IntentServices.NavigationIntentTarget.MY_TASKS.ordinal()] = 7;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[IntentServices.NavigationIntentTarget.SENT_TASKS.ordinal()] = 8;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[IntentServices.NavigationIntentTarget.COLLECTIONS.ordinal()] = 9;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Inject
    public AppIntentServices() {
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent createDocumentTaskIntent(Context context, String folderId, String assetName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intent intentNewCreateDocumentTask = CreateDocumentTaskActivity.newCreateDocumentTask(context, folderId, assetName);
        Intrinsics.checkNotNullExpressionValue(intentNewCreateDocumentTask, "newCreateDocumentTask(...)");
        return intentNewCreateDocumentTask;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent quickNoteCreationIntent(Context context, NewNoteLocation location, PreviewSource previewSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        return QuickNoteCreationActivity.INSTANCE.createIntent(context, location, previewSource);
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent emailSupportActivityIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent launchIntent = EmailSupportActivity.getLaunchIntent(context);
        Intrinsics.checkNotNullExpressionValue(launchIntent, "getLaunchIntent(...)");
        return launchIntent;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent createOAuthActivityIntent(Context context, BoxSession session, String restrictedUserId, String analyticsFlow, String analyticsPage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(session, "session");
        Intent intentCreateOAuthActivityIntent = CustomOAuthActivity.createOAuthActivityIntent(context, session, restrictedUserId, analyticsFlow, analyticsPage);
        Intrinsics.checkNotNullExpressionValue(intentCreateOAuthActivityIntent, "createOAuthActivityIntent(...)");
        return intentCreateOAuthActivityIntent;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent startScreenActivityIntent(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intent startScreenActivity = StartScreenActivity.getInstance(tag);
        Intrinsics.checkNotNullExpressionValue(startScreenActivity, "getInstance(...)");
        return startScreenActivity;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent expiredVersionDialogActivityIntent(Context context, String title, String message, String buttonText) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intent intentNewInstance = ExpiredVersionDialogActivity.newInstance(context, title, message, buttonText);
        Intrinsics.checkNotNullExpressionValue(intentNewInstance, "newInstance(...)");
        return intentNewInstance;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent mainPhoneActivityIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new Intent(context, (Class<?>) MainPhone.class);
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent mainPhoneActivityIntent(Context context, ItemId folderId, String folderName, int flags) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        Intrinsics.checkNotNullParameter(folderName, "folderName");
        Intent intentMainPhoneActivityIntent = mainPhoneActivityIntent(context);
        ItemId.Remote remote = folderId instanceof ItemId.Remote ? (ItemId.Remote) folderId : null;
        String boxId = remote != null ? remote.getBoxId() : null;
        intentMainPhoneActivityIntent.setFlags(flags);
        intentMainPhoneActivityIntent.putExtra(IntentConstants.EXTRA_INIT_FOLDER_ID, boxId);
        intentMainPhoneActivityIntent.putExtra(IntentConstants.EXTRA_ITEM_NAME, folderName);
        return intentMainPhoneActivityIntent;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent navigationActivityIntent(Context context, boolean needOpenNewHomeScreen, IntentServices.NavigationIntentTarget navigationIntentTarget) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (needOpenNewHomeScreen) {
            return MainActivity.INSTANCE.createIntent(context, navigationIntentTarget != null ? toMainNavigationTarget(navigationIntentTarget) : null);
        }
        if (navigationIntentTarget == null) {
            return new Intent(context, (Class<?>) Navigation.class);
        }
        Intent intentCreateInstance = Navigation.createInstance(context, toNavigationTarget(navigationIntentTarget));
        Intrinsics.checkNotNull(intentCreateInstance);
        return intentCreateInstance;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent fileRouterActivityIntent(Context context, PreviewSource previewSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        Intent intent = new Intent(context, (Class<?>) FileRouterActivity.class);
        intent.putExtra(IntentConstants.EXTRA_ENTRYPOINT, previewSource);
        return intent;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent newDeleteTaskIntent(Context context, List<? extends BoxItem> itemsToDelete) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemsToDelete, "itemsToDelete");
        Intent intentNewDeleteTaskIntent = DeleteItemsActivity.newDeleteTaskIntent(context, (List<BoxItem>) itemsToDelete);
        Intrinsics.checkNotNullExpressionValue(intentNewDeleteTaskIntent, "newDeleteTaskIntent(...)");
        return intentNewDeleteTaskIntent;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent newInfoDialogIntent(Context context, String title, String message, String buttonText) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intentNewInfoDialog = InfoDialogActivity.newInfoDialog(context, title, message, buttonText);
        Intrinsics.checkNotNullExpressionValue(intentNewInfoDialog, "newInfoDialog(...)");
        return intentNewInfoDialog;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent inviteCollaboratorsActivityIntent(Context context, ItemModel itemModel, BoxSession session) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent launchIntent = UsxInviteCollaboratorsActivity.getLaunchIntent(context, itemModel != null ? ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, itemModel, false, 1, null) : null, session);
        Intrinsics.checkNotNullExpressionValue(launchIntent, "getLaunchIntent(...)");
        return launchIntent;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent inviteCollaboratorsActivityIntent(Context context, BoxItem boxItem, BoxSession session) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent launchIntent = UsxInviteCollaboratorsActivity.getLaunchIntent(context, boxItem, session);
        Intrinsics.checkNotNullExpressionValue(launchIntent, "getLaunchIntent(...)");
        return launchIntent;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    @Deprecated(message = "Use shareActivityIntent with ItemModel")
    public Intent shareActivityIntent(Context context, BoxItem item, BoxSession session) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent launchIntent = UsxShareActivity.getLaunchIntent(context, item, session);
        Intrinsics.checkNotNullExpressionValue(launchIntent, "getLaunchIntent(...)");
        return launchIntent;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent shareActivityIntent(Context context, ItemModel item, BoxSession session) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        return shareActivityIntent(context, ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, item, false, 1, null), session);
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent localFolderChooserIntent(Context context, String startingPath, String title) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(startingPath, "startingPath");
        return LocalFolderChooser.INSTANCE.newLocalFolderChooserIntent(context, startingPath, title);
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent renameTaskActivityIntent(Context context, BoxItem itemToRename) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemToRename, "itemToRename");
        Intent launchIntent = RenameTaskActivity.getLaunchIntent(context, itemToRename);
        Intrinsics.checkNotNullExpressionValue(launchIntent, "getLaunchIntent(...)");
        return launchIntent;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    @Deprecated(message = "Use collaborationsActivityIntent with ItemModel")
    public Intent collaborationsActivityIntent(Context context, BoxCollaborationItem collaborationItem, BoxSession session, BoxIteratorCollaborations collaborations) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(collaborationItem, "collaborationItem");
        Intrinsics.checkNotNullParameter(session, "session");
        Intent launchIntent = UsxCollaborationsActivity.getLaunchIntent(context, collaborationItem, session, collaborations);
        Intrinsics.checkNotNullExpressionValue(launchIntent, "getLaunchIntent(...)");
        return launchIntent;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent collaborationsActivityIntent(Context context, ItemModel itemModel, BoxSession session, BoxIteratorCollaborations collaborations) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Intrinsics.checkNotNullParameter(session, "session");
        BoxItem boxItem$default = ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, itemModel, false, 1, null);
        Intrinsics.checkNotNull(boxItem$default, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxCollaborationItem");
        return collaborationsActivityIntent(context, (BoxCollaborationItem) boxItem$default, session, collaborations);
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent openFileIntent(Context context, BoxFile boxFile, Intent launchIntent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(boxFile, "boxFile");
        Intent intentCreateIntent = OpenFile.createIntent(context, boxFile, launchIntent);
        Intrinsics.checkNotNullExpressionValue(intentCreateIntent, "createIntent(...)");
        return intentCreateIntent;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent settingsActivityIntent(Context context, IntentServices.SettingsFragment fragment) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent startIntent = SettingsActivity.getStartIntent(context, (fragment == null ? -1 : WhenMappings.$EnumSwitchMapping$0[fragment.ordinal()]) == 1 ? SettingsActivity.FILES_AND_FOLDERS_FRAGMENT : null);
        Intrinsics.checkNotNullExpressionValue(startIntent, "getStartIntent(...)");
        return startIntent;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent galleryItemsActivityIntent(Context context, FileModel fileModel, PreviewSource previewSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        return GalleryItemsActivity.INSTANCE.getIntent(context, fileModel, previewSource);
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent captureMediaIntent(Context context, FolderModel folder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(folder, "folder");
        return CaptureActivity.INSTANCE.getLaunchIntent(context, null, folder.boxIdOrNull());
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent playlistItemsActivityIntent(Context context, FileModel initialFileModel, PreviewSource previewSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initialFileModel, "initialFileModel");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        return PreviewPlaylistActivity.INSTANCE.getIntent(context, initialFileModel, previewSource);
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent hubDetailsActivityIntent(Context context, String id) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(id, "id");
        return HubDetailsActivity.INSTANCE.getIntent(context, id);
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent openCollectionIntent(Context context, String collectionId, boolean useNewHomeScreen) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        if (useNewHomeScreen) {
            return MainActivity.INSTANCE.createIntent(context, new MainNavigationTarget.PersonalCollection(collectionId));
        }
        Intent intentMainPhoneActivityIntent = mainPhoneActivityIntent(context);
        intentMainPhoneActivityIntent.putExtra(IntentConstants.EXTRA_INIT_COLLECTION_ID, collectionId);
        return intentMainPhoneActivityIntent;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent hubDetailsRouterActivityIntent(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, (Class<?>) HubDetailsRouterActivity.class);
        intent.setData(uri);
        return intent;
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent searchActivityIntent(Context context, SearchMode searchMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(searchMode, "searchMode");
        return SearchActivity.INSTANCE.getIntent(context, searchMode);
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent playStoreBoxPageIntent() {
        return new Intent("android.intent.action.VIEW", Uri.parse(BoxCommonConstants.BOX_PLAY_STORE_URL));
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent boxIntuneMAMAuthActivityIntent(Context context, String userEmail, boolean isMSALAuth, String codeChallenge, boolean showBlockingUI) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BoxIntuneMAMAuthActivity.INSTANCE.getIntent(context, userEmail, isMSALAuth, codeChallenge, showBlockingUI);
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent betaFeedbackActivityIntent(Context context, Uri screenshotUri) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BetaFeedbackActivity.INSTANCE.getLaunchIntent(context, screenshotUri);
    }

    @Override // com.box.android.coreservices.services.IntentServices
    public Intent contentPickerActivityIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ContentPickerActivity.Companion.getIntent$default(ContentPickerActivity.INSTANCE, context, ItemPickerTab.getEntries(), null, 4, null);
    }

    private final NavigationTarget toNavigationTarget(IntentServices.NavigationIntentTarget navigationIntentTarget) {
        switch (WhenMappings.$EnumSwitchMapping$1[navigationIntentTarget.ordinal()]) {
            case 1:
                return NavigationTarget.ALL_FILES;
            case 2:
                return NavigationTarget.RECENT;
            case 3:
                return NavigationTarget.OFFLINE;
            case 4:
                return NavigationTarget.FAVORITES;
            case 5:
                return NavigationTarget.HUBS;
            case 6:
                return NavigationTarget.INBOX;
            case 7:
                return NavigationTarget.MY_TASKS;
            case 8:
                return NavigationTarget.SENT_TASKS;
            case 9:
                return NavigationTarget.MY_COLLECTIONS;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final MainNavigationTarget toMainNavigationTarget(IntentServices.NavigationIntentTarget navigationIntentTarget) {
        switch (WhenMappings.$EnumSwitchMapping$1[navigationIntentTarget.ordinal()]) {
            case 1:
                return MainNavigationTarget.AllFiles.INSTANCE;
            case 2:
                return MainNavigationTarget.Recents.INSTANCE;
            case 3:
                return MainNavigationTarget.Offline.INSTANCE;
            case 4:
                return MainNavigationTarget.FavoritesCollection.INSTANCE;
            case 5:
                return MainNavigationTarget.Hubs.INSTANCE;
            case 6:
                return MainNavigationTarget.Notifications.INSTANCE;
            case 7:
                return MainNavigationTarget.MyTasks.INSTANCE;
            case 8:
                return MainNavigationTarget.SentTasks.INSTANCE;
            case 9:
                return MainNavigationTarget.Collections.INSTANCE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
