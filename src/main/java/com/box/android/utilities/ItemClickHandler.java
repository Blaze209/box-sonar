package com.box.android.utilities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import com.box.android.R;
import com.box.android.activities.MainPhone;
import com.box.android.base.analytics.NavigationAnalyticsUtils;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.base.routing.preview.PreviewNavigationTarget;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.android.preview.boxcanvas.BoxCanvasActivity;
import com.box.android.preview.preview.PreviewActivity;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxRecentItem;
import com.box.boxandroidlibv2private.model.BoxRecentBoxFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemClickHandler.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001,B=\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0017J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020#H\u0002J\u0018\u0010)\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00182\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/box/android/utilities/ItemClickHandler;", "Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "previewLauncher", "Lcom/box/android/base/cpl/IPreviewLauncher;", "baseModelController", "Lcom/box/android/coreservices/modelcontroller/IBaseModelController;", "boxExtendedApiFolder", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "context", "Landroid/content/Context;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/base/cpl/IPreviewLauncher;Lcom/box/android/coreservices/modelcontroller/IBaseModelController;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;Landroid/content/Context;Landroidx/appcompat/app/AppCompatActivity;)V", ViewProps.ON_CLICK, "", "item", "Lcom/box/androidsdk/content/models/BoxItem;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "shouldLog", "", "onBookmarkClick", "boxBookmark", "Lcom/box/androidsdk/content/models/BoxBookmark;", "config", "Lcom/box/android/base/presentation/utilities/IItemClickHandler$BookmarkClickConfig;", "onFileClick", "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "Lcom/box/android/base/presentation/utilities/IItemClickHandler$FileClickConfig;", "onFolderClick", "boxFolder", "Lcom/box/androidsdk/content/models/BoxFolder;", "Lcom/box/android/base/presentation/utilities/IItemClickHandler$FolderClickConfig;", "handleBoxFileClicked", "logItemClickedIfNeeded", "launchActivity", "intent", "Factory", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemClickHandler implements IItemClickHandler {
    public static final int $stable = 8;
    private final AppCompatActivity activity;
    private final IBaseModelController baseModelController;
    private final BoxExtendedApiFolder boxExtendedApiFolder;
    private final Context context;
    private final IPreviewLauncher previewLauncher;
    private final IUserContextManager userContextManager;

    /* JADX INFO: compiled from: ItemClickHandler.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/utilities/ItemClickHandler$Factory;", "Lcom/box/android/base/presentation/utilities/IItemClickHandler$Factory;", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/utilities/ItemClickHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory extends IItemClickHandler.Factory {
        @Override // com.box.android.base.presentation.utilities.IItemClickHandler.Factory
        ItemClickHandler create(AppCompatActivity activity);
    }

    @AssistedInject
    public ItemClickHandler(IUserContextManager userContextManager, IPreviewLauncher previewLauncher, IBaseModelController baseModelController, BoxExtendedApiFolder boxExtendedApiFolder, @ApplicationContext Context context, @Assisted AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(previewLauncher, "previewLauncher");
        Intrinsics.checkNotNullParameter(baseModelController, "baseModelController");
        Intrinsics.checkNotNullParameter(boxExtendedApiFolder, "boxExtendedApiFolder");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.userContextManager = userContextManager;
        this.previewLauncher = previewLauncher;
        this.baseModelController = baseModelController;
        this.boxExtendedApiFolder = boxExtendedApiFolder;
        this.context = context;
        this.activity = activity;
    }

    @Override // com.box.android.base.presentation.utilities.IItemClickHandler
    public void onClick(BoxItem item, PreviewSource previewSource, ActivityResultLauncher<Intent> launcher, boolean shouldLog) {
        BoxRecentItem recentItem;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        if (item instanceof BoxBookmark) {
            onBookmarkClick((BoxBookmark) item, new IItemClickHandler.BookmarkClickConfig(launcher, shouldLog));
            return;
        }
        if (item instanceof BoxFile) {
            BoxFile boxFile = (BoxFile) item;
            String interactionSharedLink = null;
            if ((item instanceof BoxRecentBoxFile) && (recentItem = ((BoxRecentBoxFile) item).getRecentItem()) != null) {
                interactionSharedLink = recentItem.getInteractionSharedLink();
            }
            onFileClick(boxFile, new IItemClickHandler.FileClickConfig(previewSource, interactionSharedLink, launcher, null, null, null, null, false, shouldLog, 248, null));
            return;
        }
        if (!(item instanceof BoxFolder)) {
            throw new IllegalStateException("Unsupported BoxItem must be BoxBookmark, BoxFile or BoxFolder");
        }
        onFolderClick((BoxFolder) item, new IItemClickHandler.FolderClickConfig(null, 0, launcher, shouldLog, 3, null));
    }

    @Override // com.box.android.base.presentation.utilities.IItemClickHandler
    public void onBookmarkClick(BoxBookmark boxBookmark, IItemClickHandler.BookmarkClickConfig config) {
        Intrinsics.checkNotNullParameter(boxBookmark, "boxBookmark");
        Intrinsics.checkNotNullParameter(config, "config");
        String url = boxBookmark.getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
        launchActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)), config.getLauncher());
        logItemClickedIfNeeded(boxBookmark, config.getShouldLog());
    }

    @Override // com.box.android.base.presentation.utilities.IItemClickHandler
    public void onFileClick(BoxFile boxFile, IItemClickHandler.FileClickConfig config) {
        Intrinsics.checkNotNullParameter(boxFile, "boxFile");
        Intrinsics.checkNotNullParameter(config, "config");
        handleBoxFileClicked(boxFile, config);
        logItemClickedIfNeeded(boxFile, config.getShouldLog());
    }

    @Override // com.box.android.base.presentation.utilities.IItemClickHandler
    public void onFolderClick(BoxFolder boxFolder, IItemClickHandler.FolderClickConfig config) {
        Intrinsics.checkNotNullParameter(boxFolder, "boxFolder");
        Intrinsics.checkNotNullParameter(config, "config");
        Function1<BoxFolder, Unit> customNavigationHandler = config.getCustomNavigationHandler();
        if (customNavigationHandler != null) {
            customNavigationHandler.invoke(boxFolder);
        } else {
            Intent intent = new Intent();
            intent.setClass(this.activity, MainPhone.class);
            intent.setFlags(config.getFlags());
            intent.putExtra(IntentConstants.EXTRA_INIT_FOLDER_ID, boxFolder.getUserId());
            intent.putExtra(IntentConstants.EXTRA_ITEM_NAME, boxFolder.getName());
            launchActivity(intent, config.getLauncher());
        }
        logItemClickedIfNeeded(boxFolder, config.getShouldLog());
    }

    private final void handleBoxFileClicked(BoxFile boxFile, IItemClickHandler.FileClickConfig config) {
        if (boxFile.getPermissions() != null && !boxFile.getPermissions().contains(BoxItem.Permission.CAN_PREVIEW) && !Intrinsics.areEqual((Object) config.isRecentSharedFileValue(), (Object) true)) {
            BoxPresentationUtils.displayToast(R.string.you_do_not_have_permission_to_preview_this_item, this.context, new String[0]);
            Function0<Unit> onPermissionDenied = config.getOnPermissionDenied();
            if (onPermissionDenied != null) {
                onPermissionDenied.invoke();
                return;
            }
            return;
        }
        String fileExtension = CommonBoxUtil.getFileExtension(boxFile.getName(), "");
        Intent launchIntent = SupportedFileExtensions.INSTANCE.isBoxCanvasExtension(fileExtension) ? BoxCanvasActivity.INSTANCE.getLaunchIntent(this.activity, boxFile, false, config.getSharedLinkUrl()) : null;
        if (launchIntent != null) {
            Function1<Intent, Unit> intentConfigurator = config.getIntentConfigurator();
            if (intentConfigurator != null) {
                intentConfigurator.invoke(launchIntent);
            }
            launchActivity(launchIntent, config.getLauncher());
            return;
        }
        boolean zIsMicrosoftOfficeExtension = SupportedFileExtensions.INSTANCE.isMicrosoftOfficeExtension(fileExtension);
        if (config.isNewlyCreatedFile() && !zIsMicrosoftOfficeExtension && config.getUploadName() != null) {
            BoxUtils.startPreviewIntent(this.activity, boxFile.getUserId(), config.getUploadName());
            return;
        }
        AppCompatActivity appCompatActivity = this.activity;
        FileModel fileModel$default = FileModelMapper.toFileModel$default(FileModelMapper.INSTANCE, boxFile, false, 1, null);
        PreviewSource previewSource = config.getPreviewSource();
        PreviewNavigationTarget previewNavigationTarget = null;
        String sharedLinkUrl = config.getSharedLinkUrl();
        Intent intent = this.activity.getIntent();
        if (intent != null) {
            previewNavigationTarget = (PreviewNavigationTarget) intent.getParcelableExtra(PreviewActivity.NAVIGATION_TARGET);
        }
        IPreviewLauncher.launchPreview$default(this.previewLauncher, new IPreviewLauncher.NavigationData(appCompatActivity, fileModel$default, previewSource, sharedLinkUrl, previewNavigationTarget, config.isNewlyCreatedFile() && zIsMicrosoftOfficeExtension, config.isNewlyCreatedFile()), config.getLauncher(), null, 4, null);
    }

    private final void logItemClickedIfNeeded(BoxItem item, boolean shouldLog) {
        if (shouldLog) {
            BoxAmplitudeAnalytics.EventPropertyBuilder contentOwnershipType = BoxAmplitudeAnalytics.createEventBuilder().setBoxItem(item).setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation("body").setTimeOnPage().setPageExperience(BoxAnalyticsParams.PAGE_EXPERIENCE_POPULATED).setContentOwnershipType(NavigationAnalyticsUtils.calculateContentOwnership(item, this.baseModelController, this.boxExtendedApiFolder, this.userContextManager));
            String fileExtension = CommonBoxUtil.getFileExtension(item.getName(), "");
            if (item instanceof BoxFolder) {
                contentOwnershipType.setCtaTarget(BoxAnalyticsParams.PAGE_NAME_FOLDER).logEvent(BoxAnalyticsParams.EVENT_SELECT_FOLDER_CTA_TRIGGERED);
            } else if (SupportedFileExtensions.INSTANCE.isBoxNoteExtension(fileExtension)) {
                contentOwnershipType.setCtaTarget(BoxAnalyticsParams.PAGE_NAME_BOX_NOTE).logEvent(BoxAnalyticsParams.EVENT_SELECT_FILE_CTA_TRIGGERED);
            }
        }
    }

    private final void launchActivity(Intent intent, ActivityResultLauncher<Intent> launcher) {
        if (launcher != null) {
            launcher.launch(intent);
        } else {
            this.activity.startActivity(intent);
        }
    }
}
