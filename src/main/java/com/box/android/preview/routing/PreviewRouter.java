package com.box.android.preview.routing;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Parcelable;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.android.base.presentation.components.fileactions.DownloadFilesReducer;
import com.box.android.base.presentation.watermarking.WatermarkingActivity;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.WatermarkableItem;
import com.box.android.domain.services.IdMappingService;
import com.box.android.fileactivity.presentation.FileActivitiesLauncher;
import com.box.android.preview.R;
import com.box.android.preview.fileactions.FileActionsReducer;
import com.box.android.preview.gallery.GalleryItemsActivity;
import com.box.android.preview.item.ItemPreviewReducer;
import com.box.android.preview.iteminformation.ItemInformationActivity;
import com.box.android.preview.preview.PreviewNavigationMethod;
import com.box.android.preview.preview.PreviewReducer;
import com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistActivity;
import com.box.android.tasks.addtask.activity.AddTaskActivity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: compiled from: PreviewRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0006\u0010#\u001a\u00020 J\u0018\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u0012\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/box/android/preview/routing/PreviewRouter;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "notificationServices", "Lcom/box/android/coreservices/services/NotificationServices;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "copyOrMoveHelper", "Lcom/box/android/browse/utilities/CopyOrMoveHelper;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "fileActivitiesLauncher", "Lcom/box/android/fileactivity/presentation/FileActivitiesLauncher;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/preview/PreviewReducer$State;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "activity", "Landroidx/fragment/app/FragmentActivity;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/coreservices/services/NotificationServices;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/browse/utilities/CopyOrMoveHelper;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/fileactivity/presentation/FileActivitiesLauncher;Lcom/box/android/cpl/Store;Landroidx/fragment/app/FragmentActivity;Lcom/box/android/domain/configuration/FeatureFlips;)V", "downloadToFolderLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "galleryLauncher", "playlistLauncher", "watermarkingLauncher", "addTaskLauncher", "onCreate", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "initRouting", "handleClosing", "closeSource", "Lcom/box/android/preview/routing/CloseSource;", "navigateToParentFolder", "parent", "Lcom/box/android/domain/models/item/FolderModel;", "Landroidx/activity/ComponentActivity;", "navigateToAllFiles", "registerLaunchers", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewRouter implements DefaultLifecycleObserver {
    private static final String ADD_TASK_LAUNCHER_KEY = "PreviewRouter:AddTaskLauncher";
    private static final String DOWNLOAD_LAUNCHER_KEY = "PreviewRouter:DownloadLauncher";
    private static final String GALLERY_LAUNCHER_KEY = "PreviewRouter:GalleryLauncher";
    private static final String PLAYLIST_LAUNCHER_KEY = "PreviewRouter:PlaylistLauncher";
    private static final String WATERMARKING_LAUNCHER_KEY = "PreviewRouter:WatermarkingLauncher";
    private final FragmentActivity activity;
    private ActivityResultLauncher<Intent> addTaskLauncher;
    private CopyOrMoveHelper copyOrMoveHelper;
    private ActivityResultLauncher<Intent> downloadToFolderLauncher;
    private final FeatureFlips featureFlips;
    private final FileActivitiesLauncher fileActivitiesLauncher;
    private ActivityResultLauncher<Intent> galleryLauncher;
    private final IdMappingService idMappingService;
    private final IntentServices intentServices;
    private final NotificationServices notificationServices;
    private ActivityResultLauncher<Intent> playlistLauncher;
    private final Store<PreviewReducer.State, PreviewReducer.Action> store;
    private IUserContextManager userContextManager;
    private ActivityResultLauncher<Intent> watermarkingLauncher;
    public static final int $stable = 8;

    public PreviewRouter(IntentServices intentServices, NotificationServices notificationServices, IdMappingService idMappingService, CopyOrMoveHelper copyOrMoveHelper, IUserContextManager userContextManager, FileActivitiesLauncher fileActivitiesLauncher, Store<PreviewReducer.State, PreviewReducer.Action> store, FragmentActivity activity, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(notificationServices, "notificationServices");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(copyOrMoveHelper, "copyOrMoveHelper");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(fileActivitiesLauncher, "fileActivitiesLauncher");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.intentServices = intentServices;
        this.notificationServices = notificationServices;
        this.idMappingService = idMappingService;
        this.copyOrMoveHelper = copyOrMoveHelper;
        this.userContextManager = userContextManager;
        this.fileActivitiesLauncher = fileActivitiesLauncher;
        this.store = store;
        this.activity = activity;
        this.featureFlips = featureFlips;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onDestroy(LifecycleOwner lifecycleOwner) {
        super.onDestroy(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onPause(LifecycleOwner lifecycleOwner) {
        super.onPause(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onResume(LifecycleOwner lifecycleOwner) {
        super.onResume(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onStart(LifecycleOwner lifecycleOwner) {
        super.onStart(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* bridge */ void onStop(LifecycleOwner lifecycleOwner) {
        super.onStop(lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onCreate(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        registerLaunchers(owner);
    }

    public final void initRouting() {
        StoreKt.observe(this.store, new PropertyReference1Impl() { // from class: com.box.android.preview.routing.PreviewRouter.initRouting.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviewReducer.State) obj).getClosingFrom();
            }
        }, LifecycleOwnerKt.getLifecycleScope(this.activity), new Function1() { // from class: com.box.android.preview.routing.PreviewRouter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewRouter.initRouting$lambda$0(this.f$0, (CloseSource) obj);
            }
        });
        StoreKt.observe(this.store, new PropertyReference1Impl() { // from class: com.box.android.preview.routing.PreviewRouter.initRouting.3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviewReducer.State) obj).getNavigationRoute();
            }
        }, LifecycleOwnerKt.getLifecycleScope(this.activity), new Function1() { // from class: com.box.android.preview.routing.PreviewRouter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviewRouter.initRouting$lambda$1(this.f$0, (PreviewRoute) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initRouting$lambda$0(PreviewRouter previewRouter, CloseSource closeSource) {
        if (closeSource != null) {
            previewRouter.handleClosing(closeSource, previewRouter.activity);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initRouting$lambda$1(PreviewRouter previewRouter, PreviewRoute it) throws InterruptedException {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof PreviewRoute.MoveOrCopy) {
            previewRouter.copyOrMoveHelper.startCopyOrMoveFlowItemModel(previewRouter.activity, CollectionsKt.listOf(((PreviewReducer.State) StoreKt.stateValue(previewRouter.store)).getFileModel()));
        } else if (it instanceof PreviewRoute.Share) {
            FragmentActivity fragmentActivity = previewRouter.activity;
            fragmentActivity.startActivity(previewRouter.intentServices.shareActivityIntent(fragmentActivity, ((PreviewReducer.State) StoreKt.stateValue(previewRouter.store)).getFileModel(), previewRouter.userContextManager.getBoxSession(previewRouter.activity)));
        } else {
            ActivityResultLauncher<Intent> activityResultLauncher = null;
            ActivityResultLauncher<Intent> activityResultLauncher2 = null;
            ActivityResultLauncher<Intent> activityResultLauncher3 = null;
            ActivityResultLauncher<Intent> activityResultLauncher4 = null;
            ActivityResultLauncher<Intent> activityResultLauncher5 = null;
            if (it instanceof PreviewRoute.Collections) {
                CollectionsMultiSelectDialogFragment collectionsMultiSelectDialogFragmentNewInstance = CollectionsMultiSelectDialogFragment.INSTANCE.newInstance(((PreviewReducer.State) StoreKt.stateValue(previewRouter.store)).getFileModel());
                FragmentActivity fragmentActivity2 = previewRouter.activity;
                AppCompatActivity appCompatActivity = fragmentActivity2 instanceof AppCompatActivity ? (AppCompatActivity) fragmentActivity2 : null;
                if (appCompatActivity != null) {
                    collectionsMultiSelectDialogFragmentNewInstance.show(appCompatActivity.getSupportFragmentManager(), CollectionsMultiSelectDialogFragment.TAG);
                }
            } else if (it instanceof PreviewRoute.ParentFolder) {
                previewRouter.navigateToParentFolder(((PreviewReducer.State) StoreKt.stateValue(previewRouter.store)).getFileModel().getParentFolder(), previewRouter.activity);
            } else if (it instanceof PreviewRoute.FileInformation) {
                previewRouter.activity.startActivity(ItemInformationActivity.INSTANCE.getIntent(previewRouter.activity, ((PreviewReducer.State) StoreKt.stateValue(previewRouter.store)).getFileModel()));
            } else if (it instanceof PreviewRoute.AddTask) {
                ActivityResultLauncher<Intent> activityResultLauncher6 = previewRouter.addTaskLauncher;
                if (activityResultLauncher6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("addTaskLauncher");
                } else {
                    activityResultLauncher2 = activityResultLauncher6;
                }
                activityResultLauncher2.launch(AddTaskActivity.INSTANCE.getIntent(previewRouter.activity, ((PreviewReducer.State) StoreKt.stateValue(previewRouter.store)).getFileModel()));
            } else if (it instanceof PreviewRoute.Settings) {
                FragmentActivity fragmentActivity3 = previewRouter.activity;
                fragmentActivity3.startActivity(previewRouter.intentServices.settingsActivityIntent(fragmentActivity3, IntentServices.SettingsFragment.FILES_AND_FOLDERS_SETTINGS));
            } else if (it instanceof PreviewRoute.SelectDownloadFolder) {
                ActivityResultLauncher<Intent> activityResultLauncher7 = previewRouter.downloadToFolderLauncher;
                if (activityResultLauncher7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("downloadToFolderLauncher");
                } else {
                    activityResultLauncher3 = activityResultLauncher7;
                }
                IntentServices intentServices = previewRouter.intentServices;
                FragmentActivity fragmentActivity4 = previewRouter.activity;
                String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                activityResultLauncher3.launch(intentServices.localFolderChooserIntent(fragmentActivity4, absolutePath, previewRouter.activity.getString(R.string.pick_destination)));
            } else if (it instanceof PreviewRoute.FileActivities) {
                PreviewRoute.FileActivities fileActivities = (PreviewRoute.FileActivities) it;
                previewRouter.fileActivitiesLauncher.openFileActivities(previewRouter.activity, ((PreviewReducer.State) StoreKt.stateValue(previewRouter.store)).getFileModel(), fileActivities.getActivityId(), fileActivities.getTimestampConfig());
            } else if (it instanceof PreviewRoute.OpenInExternalApp) {
                CoreServiceUtils.INSTANCE.openFileExternally(previewRouter.activity, previewRouter.userContextManager, ((PreviewReducer.State) StoreKt.stateValue(previewRouter.store)).getFileModel(), previewRouter.notificationServices, previewRouter.intentServices);
            } else if (it instanceof PreviewRoute.OpenUrl) {
                previewRouter.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((PreviewRoute.OpenUrl) it).getUrl())));
            } else if (it instanceof PreviewRoute.Gallery) {
                Intent intentGalleryItemsActivityIntent = previewRouter.intentServices.galleryItemsActivityIntent(previewRouter.activity, ((PreviewReducer.State) StoreKt.stateValue(previewRouter.store)).getFileModel(), ((PreviewReducer.State) StoreKt.stateValue(previewRouter.store)).getPreviewSource());
                ActivityResultLauncher<Intent> activityResultLauncher8 = previewRouter.galleryLauncher;
                if (activityResultLauncher8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("galleryLauncher");
                } else {
                    activityResultLauncher4 = activityResultLauncher8;
                }
                activityResultLauncher4.launch(intentGalleryItemsActivityIntent);
            } else if (it instanceof PreviewRoute.Playlist) {
                Intent intentPlaylistItemsActivityIntent = previewRouter.intentServices.playlistItemsActivityIntent(previewRouter.activity, ((PreviewReducer.State) StoreKt.stateValue(previewRouter.store)).getFileModel(), ((PreviewReducer.State) StoreKt.stateValue(previewRouter.store)).getPreviewSource());
                ActivityResultLauncher<Intent> activityResultLauncher9 = previewRouter.playlistLauncher;
                if (activityResultLauncher9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("playlistLauncher");
                } else {
                    activityResultLauncher5 = activityResultLauncher9;
                }
                activityResultLauncher5.launch(intentPlaylistItemsActivityIntent);
            } else if (it instanceof PreviewRoute.UpdateApp) {
                previewRouter.activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(BoxCommonConstants.BOX_PLAY_STORE_URL)));
            } else if (it instanceof PreviewRoute.Watermarking) {
                ActivityResultLauncher<Intent> activityResultLauncher10 = previewRouter.watermarkingLauncher;
                if (activityResultLauncher10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("watermarkingLauncher");
                } else {
                    activityResultLauncher = activityResultLauncher10;
                }
                activityResultLauncher.launch(WatermarkingActivity.INSTANCE.getLaunchIntent(previewRouter.activity, new WatermarkableItem.File(((PreviewReducer.State) StoreKt.stateValue(previewRouter.store)).getFileModel())));
            } else {
                if (!(it instanceof PreviewRoute.None)) {
                    throw new NoWhenBranchMatchedException();
                }
                return Unit.INSTANCE;
            }
        }
        previewRouter.store.send(new PreviewReducer.Action.Navigate(PreviewRoute.None.INSTANCE));
        return Unit.INSTANCE;
    }

    private final void handleClosing(CloseSource closeSource, FragmentActivity activity) {
        if ((closeSource instanceof CloseSource.AppButton) || (closeSource instanceof CloseSource.Delete)) {
            if (activity.isTaskRoot()) {
                navigateToAllFiles(activity);
            }
            activity.finish();
            return;
        }
        activity.finish();
    }

    private final void navigateToParentFolder(FolderModel parent, ComponentActivity activity) throws InterruptedException {
        if (parent != null && parent.getItemId() != null && !parent.isRoot()) {
            BuildersKt__BuildersKt.runBlocking$default(null, new PreviewRouter$navigateToParentFolder$1$1(this, parent, activity, null), 1, null);
        } else {
            navigateToAllFiles(activity);
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToAllFiles(ComponentActivity activity) {
        activity.startActivity(this.intentServices.navigationActivityIntent(activity, this.featureFlips.getMainScreenRedesign().getEnabled(), IntentServices.NavigationIntentTarget.ALL_FILES));
    }

    private final void registerLaunchers(LifecycleOwner owner) {
        this.downloadToFolderLauncher = this.activity.getActivityResultRegistry().register(DOWNLOAD_LAUNCHER_KEY, owner, new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.box.android.preview.routing.PreviewRouter$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PreviewRouter.registerLaunchers$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        this.galleryLauncher = this.activity.getActivityResultRegistry().register(GALLERY_LAUNCHER_KEY, owner, new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.box.android.preview.routing.PreviewRouter$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PreviewRouter.registerLaunchers$lambda$1(this.f$0, (ActivityResult) obj);
            }
        });
        this.playlistLauncher = this.activity.getActivityResultRegistry().register(PLAYLIST_LAUNCHER_KEY, owner, new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.box.android.preview.routing.PreviewRouter$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PreviewRouter.registerLaunchers$lambda$2(this.f$0, (ActivityResult) obj);
            }
        });
        this.watermarkingLauncher = this.activity.getActivityResultRegistry().register(WATERMARKING_LAUNCHER_KEY, owner, new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.box.android.preview.routing.PreviewRouter$$ExternalSyntheticLambda3
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PreviewRouter.registerLaunchers$lambda$3(this.f$0, (ActivityResult) obj);
            }
        });
        this.addTaskLauncher = this.activity.getActivityResultRegistry().register(ADD_TASK_LAUNCHER_KEY, owner, new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.box.android.preview.routing.PreviewRouter$$ExternalSyntheticLambda4
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PreviewRouter.registerLaunchers$lambda$4(this.f$0, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerLaunchers$lambda$0(PreviewRouter previewRouter, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intent data = result.getData();
        previewRouter.store.send(new PreviewReducer.Action.FileActionsAction(new FileActionsReducer.Action.Download(new DownloadFilesReducer.Action.DownloadToFolder(data != null ? data.getStringExtra(IntentConstants.LocalFolderChooser.EXTRA_SELECTED_DIR) : null))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerLaunchers$lambda$1(PreviewRouter previewRouter, ActivityResult it) {
        ItemModel itemModel;
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(it, "it");
        Intent data = it.getData();
        if (data != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) data.getParcelableExtra(GalleryItemsActivity.RESULT_SELECTED_ITEM_MODEL, ItemModel.class);
            } else {
                Parcelable parcelableExtra = data.getParcelableExtra(GalleryItemsActivity.RESULT_SELECTED_ITEM_MODEL);
                if (!(parcelableExtra instanceof ItemModel)) {
                    parcelableExtra = null;
                }
                parcelable = (ItemModel) parcelableExtra;
            }
            itemModel = (ItemModel) parcelable;
        } else {
            itemModel = null;
        }
        FileModel fileModel = itemModel instanceof FileModel ? (FileModel) itemModel : null;
        if (fileModel != null) {
            previewRouter.store.send(new PreviewReducer.Action.SetSelectedItem(fileModel, PreviewNavigationMethod.GALLERY_VIEW));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerLaunchers$lambda$2(PreviewRouter previewRouter, ActivityResult it) {
        ItemModel itemModel;
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(it, "it");
        Intent data = it.getData();
        if (data != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) data.getParcelableExtra(PreviewPlaylistActivity.RESULT_SELECTED_PLAYLIST_ITEM_MODEL, ItemModel.class);
            } else {
                Parcelable parcelableExtra = data.getParcelableExtra(PreviewPlaylistActivity.RESULT_SELECTED_PLAYLIST_ITEM_MODEL);
                if (!(parcelableExtra instanceof ItemModel)) {
                    parcelableExtra = null;
                }
                parcelable = (ItemModel) parcelableExtra;
            }
            itemModel = (ItemModel) parcelable;
        } else {
            itemModel = null;
        }
        FileModel fileModel = itemModel instanceof FileModel ? (FileModel) itemModel : null;
        if (fileModel != null) {
            previewRouter.store.send(new PreviewReducer.Action.SetSelectedItem(fileModel, PreviewNavigationMethod.PLAYLIST_VIEW));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerLaunchers$lambda$3(PreviewRouter previewRouter, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            previewRouter.store.send(new PreviewReducer.Action.SelectedItem(ItemPreviewReducer.Action.Retry.INSTANCE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerLaunchers$lambda$4(PreviewRouter previewRouter, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            previewRouter.store.send(PreviewReducer.Action.ShowTaskCreatedSnackbar.INSTANCE);
        }
    }
}
