package com.box.android.application;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.work.Data;
import com.box.android.activities.AutoContentUploadPaywallActivity;
import com.box.android.activities.BetaFeedbackActivity;
import com.box.android.activities.BetaFeedbackActivity_MembersInjector;
import com.box.android.activities.BoxBetaFeatureFlips;
import com.box.android.activities.BoxBetaFeatureFlips_MembersInjector;
import com.box.android.activities.BoxItemShortcutActivity;
import com.box.android.activities.BoxItemShortcutActivity_MembersInjector;
import com.box.android.activities.CreateBoxItemShortcutActivity;
import com.box.android.activities.CreateBoxItemShortcutActivity_MembersInjector;
import com.box.android.activities.DeleteItemsActivity;
import com.box.android.activities.DeleteItemsActivity_MembersInjector;
import com.box.android.activities.EmailSupportActivity;
import com.box.android.activities.ExpiredVersionDialogActivity;
import com.box.android.activities.ExpiredVersionDialogActivity_MembersInjector;
import com.box.android.activities.FeatureFlipDeepLinkHandler;
import com.box.android.activities.InfoDialogActivity;
import com.box.android.activities.IntentProcessorGetContent;
import com.box.android.activities.IntentProcessorSend;
import com.box.android.activities.LogoutWarningActivity;
import com.box.android.activities.MainParent_MembersInjector;
import com.box.android.activities.MainPhone;
import com.box.android.activities.MainPhone_MembersInjector;
import com.box.android.activities.MfaCallbackActivity;
import com.box.android.activities.NotificationInterceptorActivity;
import com.box.android.activities.NotificationInterceptorActivity_MembersInjector;
import com.box.android.activities.OpenFile;
import com.box.android.activities.OpenFile_MembersInjector;
import com.box.android.activities.RefreshDialogActivity;
import com.box.android.activities.SwitchAccountActivity;
import com.box.android.activities.SwitchingAccountDialogActivity;
import com.box.android.activities.UploadOverwriteDialogActivity;
import com.box.android.activities.addcontent.CreateDocumentTaskActivity;
import com.box.android.activities.addcontent.CreateDocumentTaskActivity_MembersInjector;
import com.box.android.activities.addcontent.NewNoteCreationViewModel;
import com.box.android.activities.addcontent.NewNoteCreationViewModel_HiltModules;
import com.box.android.activities.addcontent.NewNoteCreationViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.activities.addcontent.NewNoteCreationViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.activities.addcontent.QuickNoteCreationActivity;
import com.box.android.activities.addcontent.QuickNoteCreationActivity_MembersInjector;
import com.box.android.activities.filepicker.LocalFolderChooser;
import com.box.android.activities.filepicker.LocalFolderChooser_MembersInjector;
import com.box.android.activities.filepicker.MainFilePicker;
import com.box.android.activities.login.BoxThirdPartyAuthenticatorActivity;
import com.box.android.activities.login.BoxThirdPartyAuthenticatorActivity_MembersInjector;
import com.box.android.activities.login.CustomOAuthActivity;
import com.box.android.activities.login.CustomOAuthActivity_MembersInjector;
import com.box.android.activities.login.StartScreenActivity;
import com.box.android.activities.login.StartScreenActivity_MembersInjector;
import com.box.android.activities.login.WopiOAuthActivity;
import com.box.android.activities.login.WopiOAuthActivity_MembersInjector;
import com.box.android.activities.settings.FilesAndFoldersFragmentFactory;
import com.box.android.activities.settings.FilesAndFoldersSettingsStoreFactory;
import com.box.android.activities.settings.SettingsActivity;
import com.box.android.activities.settings.SettingsActivity_MembersInjector;
import com.box.android.activities.settings.SettingsNotificationsFragment;
import com.box.android.activities.settings.SettingsNotificationsFragment_MembersInjector;
import com.box.android.activities.share.CopyLinkService;
import com.box.android.activities.share.CopyLinkService_MembersInjector;
import com.box.android.activities.share.UsxCollaborationsActivity;
import com.box.android.activities.share.UsxInviteCollaboratorsActivity;
import com.box.android.activities.share.UsxShareActivity;
import com.box.android.activities.share.UsxShareBaseActivity_MembersInjector;
import com.box.android.activities.tasks.RenameTaskActivity;
import com.box.android.activities.tasks.RenameTaskActivity_MembersInjector;
import com.box.android.activities.tasks.SingleTaskActivity;
import com.box.android.activities.tasks.TaskCollaboratorsActivity;
import com.box.android.activities.urlsinterceptor.BoxNotesInterceptorActivity;
import com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity;
import com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity_MembersInjector;
import com.box.android.activities.urlsinterceptor.SharedLinkStopScreenActivity;
import com.box.android.activities.urlsinterceptor.WebUrlsInterceptorActivity;
import com.box.android.activities.urlsinterceptor.WebUrlsInterceptorActivity_MembersInjector;
import com.box.android.activities.urlsinterceptor.router.FileRouterActivity;
import com.box.android.activities.urlsinterceptor.router.FileRouterActivity_MembersInjector;
import com.box.android.activities.urlsinterceptor.router.HubDetailsRouterActivity;
import com.box.android.activities.urlsinterceptor.router.HubDetailsRouterActivity_MembersInjector;
import com.box.android.auth.AuthenticationActivity;
import com.box.android.auth.AuthenticationCredentialsProvider;
import com.box.android.autoupload.AutoContentUploadFragment;
import com.box.android.autoupload.AutoContentUploadFragment_MembersInjector;
import com.box.android.autoupload.AutoUploadSwitchListener;
import com.box.android.base.FeatureFlipsToggleFragment;
import com.box.android.base.FeatureFlipsToggleFragment_MembersInjector;
import com.box.android.base.cpl.ClipboardService;
import com.box.android.base.cpl.DeleteEnvironment;
import com.box.android.base.cpl.EndCollaborationEnvironment;
import com.box.android.base.cpl.ItemNameValidator;
import com.box.android.base.cpl.ItemThumbnailEnvironment;
import com.box.android.base.di.BaseModule_Companion_ProvideApiExecutorFactory;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.base.presentation.activities.BoxFragmentActivity_MembersInjector;
import com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity;
import com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity_MembersInjector;
import com.box.android.base.presentation.activities.CreatePincodeActivity;
import com.box.android.base.presentation.activities.IntentChooserActivity;
import com.box.android.base.presentation.activities.NotificationPermissionRationaleActivity;
import com.box.android.base.presentation.activities.Pincode;
import com.box.android.base.presentation.components.commentbar.CommentWithMentionsEnvironment;
import com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsEnvironment;
import com.box.android.base.presentation.components.fileactions.DownloadEnvironment;
import com.box.android.base.presentation.components.fileactions.OfflineFilesEnvironment;
import com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository;
import com.box.android.base.presentation.components.topbar.component.inbox.InboxCountEnvironment;
import com.box.android.base.presentation.components.topbar.component.inbox.InboxCountViewModel;
import com.box.android.base.presentation.components.topbar.component.inbox.InboxCountViewModel_HiltModules;
import com.box.android.base.presentation.components.topbar.component.inbox.InboxCountViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.base.presentation.components.topbar.component.inbox.InboxCountViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressEnvironment;
import com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressViewModel;
import com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressViewModel_HiltModules;
import com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.base.presentation.components.topbar.component.settings.DefaultAvatarComponentDataProvider;
import com.box.android.base.presentation.components.topbar.component.settings.UserAvatarViewModel;
import com.box.android.base.presentation.components.topbar.component.settings.UserAvatarViewModel_HiltModules;
import com.box.android.base.presentation.components.topbar.component.settings.UserAvatarViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.base.presentation.components.topbar.component.settings.UserAvatarViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.base.presentation.fragments.BaseFTUX;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment_MembersInjector;
import com.box.android.base.presentation.fragments.BoxFragment_MembersInjector;
import com.box.android.base.presentation.fragments.EmptyFragmentWithCallbackOnResume;
import com.box.android.base.presentation.fragments.LibraryFragment;
import com.box.android.base.presentation.fragments.ShowFTUXDialogFragment;
import com.box.android.base.presentation.fragments.ShowFTUXDialogFragment_MembersInjector;
import com.box.android.base.presentation.fragments.TabLayoutFragment_MembersInjector;
import com.box.android.base.presentation.message.BoxMessageDispatcher;
import com.box.android.base.presentation.multiselect.MultiselectEnvironment;
import com.box.android.base.presentation.multiselect.SelectionManager;
import com.box.android.base.presentation.shake.BetaFeedbackManager;
import com.box.android.base.presentation.utilities.FTUXController;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.base.presentation.utilities.PermissionsHandler;
import com.box.android.base.presentation.views.menu.BookmarkSheetFragment;
import com.box.android.base.presentation.views.menu.FileSheetFragment;
import com.box.android.base.presentation.views.menu.FileSheetFragment_MembersInjector;
import com.box.android.base.presentation.views.menu.FolderSheetFragment;
import com.box.android.base.presentation.views.menu.FolderSheetFragment_MembersInjector;
import com.box.android.base.presentation.views.menu.NotificationsFilterFragment;
import com.box.android.base.presentation.views.menu.PushNotificationSheetFragment;
import com.box.android.base.presentation.views.menu.PushNotificationSheetFragment_MembersInjector;
import com.box.android.base.presentation.views.menu.RecentItemsFilterFragment;
import com.box.android.base.presentation.views.menu.SortSheetFragment;
import com.box.android.base.presentation.views.menu.SortSheetFragment_MembersInjector;
import com.box.android.base.presentation.views.menu.UploadOptionsFragment;
import com.box.android.base.presentation.watermarking.WatermarkingActivity;
import com.box.android.base.presentation.watermarking.WatermarkingEnvironment;
import com.box.android.base.presentation.watermarking.WatermarkingViewModel;
import com.box.android.base.presentation.watermarking.WatermarkingViewModel_HiltModules;
import com.box.android.base.presentation.watermarking.WatermarkingViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.base.presentation.watermarking.WatermarkingViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.base.utilities.ScreenshotCapture;
import com.box.android.base.vm.BiometricsVM;
import com.box.android.base.vm.BiometricsVM_HiltModules;
import com.box.android.base.vm.BiometricsVM_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.base.vm.BiometricsVM_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.boxai.AiCenterActivity;
import com.box.android.boxai.AiCenterActivity_MembersInjector;
import com.box.android.boxai.AiCenterSessionInfoProviderImpl;
import com.box.android.boxai.BoxAiAnalytics;
import com.box.android.boxai.BoxAiEnvironment;
import com.box.android.boxai.homescreen.BoxAiHomeEnvironment;
import com.box.android.boxai.homescreen.BoxAiHomeViewModel;
import com.box.android.boxai.homescreen.BoxAiHomeViewModel_HiltModules;
import com.box.android.boxai.homescreen.BoxAiHomeViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.boxai.homescreen.BoxAiHomeViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.boxai.voice.SpeechRecognitionManager;
import com.box.android.boxai.voice.VoiceInputEnvironment;
import com.box.android.browse.activities.FilterSearchResults;
import com.box.android.browse.activities.FilterSearchResultsActivity;
import com.box.android.browse.activities.FilterSearchResults_MembersInjector;
import com.box.android.browse.activities.UploadToFolderActivity;
import com.box.android.browse.activities.UploadToFolderActivity_MembersInjector;
import com.box.android.browse.cpl.RecentsItemPickerViewModel;
import com.box.android.browse.cpl.RecentsItemPickerViewModel_HiltModules;
import com.box.android.browse.cpl.RecentsItemPickerViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.browse.cpl.RecentsItemPickerViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.browse.cpl.browse.ActionableFolderViewEnvironment;
import com.box.android.browse.cpl.browse.AllFilesViewModel;
import com.box.android.browse.cpl.browse.AllFilesViewModel_HiltModules;
import com.box.android.browse.cpl.browse.AllFilesViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.browse.cpl.browse.AllFilesViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.browse.cpl.browse.BrowseEnvironment;
import com.box.android.browse.cpl.browse.FolderViewEnvironment;
import com.box.android.browse.cpl.browse.fab.FabManager;
import com.box.android.browse.cpl.browse.fab.FilesFabAnalytics;
import com.box.android.browse.cpl.browse.fab.FilesFabEnvironment;
import com.box.android.browse.cpl.browse.fab.UploadHelper;
import com.box.android.browse.cpl.browse.fab.newfile.NewFileMenuFragment;
import com.box.android.browse.cpl.browse.fab.newfile.NewFileMenuFragment_MembersInjector;
import com.box.android.browse.cpl.browse.fab.newfile.NewFileMenuUtils;
import com.box.android.browse.cpl.copymove.CopyOrMoveActivity;
import com.box.android.browse.cpl.copymove.CopyOrMoveEnvironment;
import com.box.android.browse.cpl.copymove.CopyOrMoveViewModel;
import com.box.android.browse.cpl.copymove.CopyOrMoveViewModel_HiltModules;
import com.box.android.browse.cpl.copymove.CopyOrMoveViewModel_HiltModules_BindsModule_Bind_LazyMapKey;
import com.box.android.browse.cpl.copymove.CopyOrMoveViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.browse.cpl.createfolder.CreateFolderEnvironment;
import com.box.android.browse.cpl.helpers.FabHelper;
import com.box.android.browse.cpl.itempicker.FolderItemPickerEnvironment;
import com.box.android.browse.cpl.itempicker.FolderItemPickerViewModel;
import com.box.android.browse.cpl.itempicker.FolderItemPickerViewModel_HiltModules;
import com.box.android.browse.cpl.itempicker.FolderItemPickerViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.browse.cpl.itempicker.FolderItemPickerViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.browse.cpl.itempicker.ItemPickerActivity;
import com.box.android.browse.cpl.itempicker.ItemPickerActivity_MembersInjector;
import com.box.android.browse.cpl.itempicker.ItemPickerViewModel;
import com.box.android.browse.cpl.itempicker.ItemPickerViewModel_HiltModules;
import com.box.android.browse.cpl.itempicker.ItemPickerViewModel_HiltModules_BindsModule_Bind_LazyMapKey;
import com.box.android.browse.cpl.itempicker.ItemPickerViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.browse.cpl.itempicker.RecentItemPickerEnvironment;
import com.box.android.browse.cpl.itemsList.ItemEnvironment;
import com.box.android.browse.cpl.itemsList.ItemModelStateMapper;
import com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsEnvironment;
import com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsViewModel;
import com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsViewModel_HiltModules;
import com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.browse.cpl.navigationmodernization.tabsscreen.BrowseTabsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.browse.cpl.offlined.ActionableOfflinedViewEnvironment;
import com.box.android.browse.cpl.offlined.OfflinedEnvironment;
import com.box.android.browse.cpl.offlined.OfflinedViewEnvironment;
import com.box.android.browse.cpl.offlined.OfflinedViewModel;
import com.box.android.browse.cpl.offlined.OfflinedViewModel_HiltModules;
import com.box.android.browse.cpl.offlined.OfflinedViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.browse.cpl.offlined.OfflinedViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.browse.cpl.recents.ActionableRecentViewEnvironment;
import com.box.android.browse.cpl.recents.RecentsEnvironment;
import com.box.android.browse.cpl.recents.RecentsViewEnvironment;
import com.box.android.browse.cpl.recents.RecentsViewModel;
import com.box.android.browse.cpl.recents.RecentsViewModel_HiltModules;
import com.box.android.browse.cpl.recents.RecentsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.browse.cpl.recents.RecentsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.browse.fragments.BoxBrowseFragment_MembersInjector;
import com.box.android.browse.fragments.SearchFragment;
import com.box.android.browse.fragments.SearchFragment_MembersInjector;
import com.box.android.browse.search.FilesSearchEnvironment;
import com.box.android.browse.search.FilesSearchViewModel;
import com.box.android.browse.search.FilesSearchViewModel_HiltModules;
import com.box.android.browse.search.FilesSearchViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.browse.search.FilesSearchViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.browse.utilities.BoxFeatureBannerUtils;
import com.box.android.browse.utilities.BoxSearchItemClickHandler;
import com.box.android.browse.utilities.BrowseAnalytics;
import com.box.android.browse.utilities.BrowseFragmentFactory;
import com.box.android.browse.utilities.CollectionsHelper;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.browse.utilities.CreateFolderHelper;
import com.box.android.browse.utilities.FilesSearchHelper;
import com.box.android.capture.CameraSession;
import com.box.android.capture.CaptureErrorFragment;
import com.box.android.capture.CaptureHistoryButtonView;
import com.box.android.capture.CaptureHistoryButtonView_MembersInjector;
import com.box.android.capture.CaptureHistoryFragment;
import com.box.android.capture.CaptureHistoryFragment_MembersInjector;
import com.box.android.capture.CaptureShutterSoundHelper;
import com.box.android.capture.CaptureUploadFileManager;
import com.box.android.capture.ImageCaptureHostFragment;
import com.box.android.capture.activities.CaptureActivity;
import com.box.android.capture.activities.CaptureActivity_MembersInjector;
import com.box.android.capture.activities.CaptureShortcutActivity;
import com.box.android.capture.activities.CreateCaptureShortcutActivity;
import com.box.android.capture.audiorecording.RecorderService;
import com.box.android.capture.audiorecording.RecorderService_MembersInjector;
import com.box.android.capture.audiorecording.RecordingFileManager;
import com.box.android.capture.audiorecording.cpl.AudioCaptureEnvironment;
import com.box.android.capture.audiorecording.logic.AudioRecordingHelper;
import com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment;
import com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment;
import com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment_MembersInjector;
import com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment;
import com.box.android.capture.audiorecording.viewmodel.RecorderServiceManager;
import com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel;
import com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel_HiltModules;
import com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.capture.audiorecording.viewmodel.RecorderServiceViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.capture.cpl.CaptureEnvironment;
import com.box.android.capture.cpl.CaptureSettingsEnvironment;
import com.box.android.capture.di.CaptureModule_Companion_ProvideMediaActionSoundFactory;
import com.box.android.capture.documentscanning.DocumentScanningEnvironment;
import com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor;
import com.box.android.capture.documentscanning.logic.DocumentScanningHelper;
import com.box.android.capture.documentscanning.logic.GeniusScanLicenseInitializer;
import com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment;
import com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment;
import com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment;
import com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment;
import com.box.android.capture.fragments.CaptureSettingsFragment;
import com.box.android.capture.imagecapture.logic.ImageCaptureHelper;
import com.box.android.capture.imagecapture.presentation.CameraPreviewFragment;
import com.box.android.capture.imagecapture.presentation.PhotoReviewFragment;
import com.box.android.capture.videorecording.VideoRecordingFileManager;
import com.box.android.capture.videorecording.presentation.VideoCaptureHostFragment;
import com.box.android.capture.videorecording.presentation.VideoRecordingFragment;
import com.box.android.capture.videorecording.presentation.VideoReviewFragment;
import com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel;
import com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel_HiltModules;
import com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.capture.viewmodel.CaptureHistoryViewModel;
import com.box.android.capture.viewmodel.CaptureHistoryViewModel_HiltModules;
import com.box.android.capture.viewmodel.CaptureHistoryViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.capture.viewmodel.CaptureHistoryViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.capture.viewmodel.CaptureSettingsViewModel;
import com.box.android.capture.viewmodel.CaptureSettingsViewModel_HiltModules;
import com.box.android.capture.viewmodel.CaptureSettingsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.capture.viewmodel.CaptureSettingsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.capture.viewmodel.CaptureViewModel;
import com.box.android.capture.viewmodel.CaptureViewModel_HiltModules;
import com.box.android.capture.viewmodel.CaptureViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.capture.viewmodel.CaptureViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.clientadmin.BoxAdminSettingsProvider;
import com.box.android.clientadmin.integrity.DeviceIntegrityVerifier;
import com.box.android.collections.presentation.fragments.CollectionItemsFragment;
import com.box.android.collections.presentation.fragments.CollectionItemsFragment_MembersInjector;
import com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment;
import com.box.android.collections.presentation.fragments.CollectionsTabFragment;
import com.box.android.collections.presentation.fragments.FavoritesCollectionItemsFragment;
import com.box.android.collections.presentation.fragments.FavoritesCollectionItemsFragment_MembersInjector;
import com.box.android.collections.presentation.fragments.MyCollectionsFragment;
import com.box.android.collections.presentation.fragments.MyCollectionsFragment_MembersInjector;
import com.box.android.collections.presentation.navigationmodernization.CollectionsAnalytics;
import com.box.android.collections.presentation.navigationmodernization.CollectionsEnvironment;
import com.box.android.collections.presentation.navigationmodernization.CollectionsViewModel;
import com.box.android.collections.presentation.navigationmodernization.CollectionsViewModel_HiltModules;
import com.box.android.collections.presentation.navigationmodernization.CollectionsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.collections.presentation.navigationmodernization.CollectionsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListEnvironment;
import com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListViewModel;
import com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListViewModel_HiltModules;
import com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListEnvironment;
import com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel;
import com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel_HiltModules;
import com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel_HiltModules_BindsModule_Bind_LazyMapKey;
import com.box.android.collections.presentation.viewmodel.CollectionItemsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.collections.presentation.viewmodel.CollectionMembershipsViewModel;
import com.box.android.collections.presentation.viewmodel.CollectionMembershipsViewModel_HiltModules;
import com.box.android.collections.presentation.viewmodel.CollectionMembershipsViewModel_HiltModules_BindsModule_Bind_LazyMapKey;
import com.box.android.collections.presentation.viewmodel.CollectionMembershipsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.collections.presentation.viewmodel.FavoritesCollectionItemsViewModel;
import com.box.android.collections.presentation.viewmodel.FavoritesCollectionItemsViewModel_HiltModules;
import com.box.android.collections.presentation.viewmodel.FavoritesCollectionItemsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.collections.presentation.viewmodel.FavoritesCollectionItemsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.collections.presentation.viewmodel.MyCollectionsViewModel;
import com.box.android.collections.presentation.viewmodel.MyCollectionsViewModel_HiltModules;
import com.box.android.collections.presentation.viewmodel.MyCollectionsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.collections.presentation.viewmodel.MyCollectionsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.common.di.CommonModule_ProvidesClockFactory;
import com.box.android.common.di.CommonModule_ProvidesDefaultDispatcherFactory;
import com.box.android.common.di.CommonModule_ProvidesIoDispatcherFactory;
import com.box.android.common.di.CommonModule_ProvidesMainDispatcherFactory;
import com.box.android.common.di.CommonModule_ProvidesResourcesProviderFactory;
import com.box.android.common.di.CommonModule_ProvidesStoreFactoryFactory;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.contentpicker.ContentPickerActivity;
import com.box.android.contentpicker.ContentPickerActivity_MembersInjector;
import com.box.android.contentpicker.ContentPickerAnalytics;
import com.box.android.contentpicker.ContentPickerEnvironment;
import com.box.android.contentpicker.ContentPickerEventPropertyBuilder;
import com.box.android.contentpicker.ContentPickerViewModel;
import com.box.android.contentpicker.ContentPickerViewModel_HiltModules;
import com.box.android.contentpicker.ContentPickerViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.contentpicker.ContentPickerViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.contentpicker.uploadcontent.CaptureMediaEnvironment;
import com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerViewModel;
import com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerViewModel_HiltModules;
import com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.contentpicker.uploadcontent.UploadContentEnvironment;
import com.box.android.contentpicker.uploadcontent.UploadContentHandlerViewModel;
import com.box.android.contentpicker.uploadcontent.UploadContentHandlerViewModel_HiltModules;
import com.box.android.contentpicker.uploadcontent.UploadContentHandlerViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.contentpicker.uploadcontent.UploadContentHandlerViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.controller.AndroidForWorkController;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.modelcontroller.IMoCoAdminSettings;
import com.box.android.coreservices.modelcontroller.IMoCoBatchOperations;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.modelcontroller.MoCoBoxGlobalSettings;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.models.BoxAccountSettings;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.coreservices.observability.appstart.AppStartHandler;
import com.box.android.coreservices.observability.appstart.IAppStartDestinationPageHolder;
import com.box.android.coreservices.observability.appstart.apdex.AppStartApdexTracker;
import com.box.android.coreservices.observability.appstart.helpers.ColdStartCalculation;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.coreservices.utilities.BoxAccountManagerHelper;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.coreservices.utilities.intune.IntuneAuthManager;
import com.box.android.coreservices.utilities.intune.IntuneComponentCreator;
import com.box.android.cpl.mainphone.BrowseSavedStateBuilder;
import com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper;
import com.box.android.cpl.mainphone.MainPhoneEnvironment;
import com.box.android.cpl.mainphone.MainPhoneViewModel;
import com.box.android.cpl.navigation.NavigationBrowseToolbarHelper;
import com.box.android.cpl.navigation.NavigationEnvironment;
import com.box.android.cpl.navigation.NavigationViewModel;
import com.box.android.cpl.navigation.NavigationViewModel_HiltModules;
import com.box.android.cpl.navigation.NavigationViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.cpl.navigation.NavigationViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.data.api.graphql.GetAIAgentsGraphQLQuery;
import com.box.android.data.api.graphql.GetAiSessionsGraphQLQuery;
import com.box.android.data.api.graphql.GetHubsGraphQLQuery;
import com.box.android.data.api.interceptors.AiRequestInterceptor;
import com.box.android.data.api.interceptors.DevpodInterceptor;
import com.box.android.data.api.interceptors.EmptyBodyInterceptor;
import com.box.android.data.api.interceptors.GQLClientRequestInterceptor;
import com.box.android.data.api.interceptors.GQLForceUpdateInterceptor;
import com.box.android.data.api.interceptors.Gen204RequestInterceptor;
import com.box.android.data.api.interceptors.RetryRequestInterceptor;
import com.box.android.data.api.interceptors.auth.AuthInterceptor;
import com.box.android.data.api.interceptors.auth.RequestHeaderInterceptor;
import com.box.android.data.api.interceptors.auth.SharedLinkAuthInterceptor;
import com.box.android.data.api.models.upload.CommitSessionState;
import com.box.android.data.api.models.upload.InitialState;
import com.box.android.data.api.models.upload.PreflightCheckState;
import com.box.android.data.api.models.upload.UploadChunksState;
import com.box.android.data.api.models.upload.UploadSessionCreationState;
import com.box.android.data.api.models.upload.UploadWholeFileState;
import com.box.android.data.api.requests.AnnotationsRequest;
import com.box.android.data.api.requests.AuthRequest;
import com.box.android.data.api.requests.BoxAiRequest;
import com.box.android.data.api.requests.ChunkedFileUploadRequest;
import com.box.android.data.api.requests.ClientSettingsRequest;
import com.box.android.data.api.requests.CollectionItemsRequest;
import com.box.android.data.api.requests.CollectionsRequest;
import com.box.android.data.api.requests.CommentRequest;
import com.box.android.data.api.requests.CommentV2Request;
import com.box.android.data.api.requests.CreateFolderRequest;
import com.box.android.data.api.requests.DefaultNoteFolderRequest;
import com.box.android.data.api.requests.DeleteItemRequest;
import com.box.android.data.api.requests.DownloadFileRequest;
import com.box.android.data.api.requests.FileActivitiesRequest;
import com.box.android.data.api.requests.FileMetadataRequest;
import com.box.android.data.api.requests.FileRepresentationsRequest;
import com.box.android.data.api.requests.FileVersionRequest;
import com.box.android.data.api.requests.FilesSearchRequest;
import com.box.android.data.api.requests.FolderItemsRequest;
import com.box.android.data.api.requests.HubAssetDownloadRequest;
import com.box.android.data.api.requests.InboxCollaborationRequest;
import com.box.android.data.api.requests.InboxNotificationRequest;
import com.box.android.data.api.requests.ItemCollaborationsRequest;
import com.box.android.data.api.requests.ItemInfoRequest;
import com.box.android.data.api.requests.MetadataTemplatesRequest;
import com.box.android.data.api.requests.MetricsLoggingRequest;
import com.box.android.data.api.requests.PreflightCheckRequest;
import com.box.android.data.api.requests.PreviewDownloadRequest;
import com.box.android.data.api.requests.PushNotificationSettingsRequest;
import com.box.android.data.api.requests.RecentNotesRequest;
import com.box.android.data.api.requests.RecentsRequest;
import com.box.android.data.api.requests.RequestFactory;
import com.box.android.data.api.requests.TaskRequest;
import com.box.android.data.api.requests.UpdateItemInfoRequest;
import com.box.android.data.api.requests.UpdateItemRequest;
import com.box.android.data.api.requests.UploadFileRequest;
import com.box.android.data.api.requests.WatermarkRequest;
import com.box.android.data.api.utils.HttpStreamLoggingInterceptor;
import com.box.android.data.api.utils.UpdateSharedLinkPasswordErrorConverter;
import com.box.android.data.controller.impl.BaseModelController;
import com.box.android.data.controller.impl.BoxPreviewController;
import com.box.android.data.controller.impl.CommentControllerBridge;
import com.box.android.data.controller.impl.LegacyCommentsController;
import com.box.android.data.datasource.DocumentScanCacheDataSource;
import com.box.android.data.datasource.ItemRemoteDataSource;
import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.data.datasource.PreviewDownloadRemoteDataSource;
import com.box.android.data.datasource.PushNotificationSettingsRemoteDataSource;
import com.box.android.data.datasource.RecentsRemoteDataSource;
import com.box.android.data.datasource.SharedLinkCredentialsCacheDatasource;
import com.box.android.data.datasource.SharedLinkTokenRetryHelper;
import com.box.android.data.datasource.VersionsPreviewCache;
import com.box.android.data.datasource.WatermarkRemoteDataSource;
import com.box.android.data.datasource.annotations.AnnotationsCacheDataSource;
import com.box.android.data.datasource.annotations.AnnotationsRemoteDataSource;
import com.box.android.data.datasource.annotations.FileActivityCacheDataSource;
import com.box.android.data.datasource.annotations.FileActivityRemoteDataSource;
import com.box.android.data.datasource.auth.AuthenticationRemoteDataSource;
import com.box.android.data.datasource.boxai.BoxAiRemoteDataSource;
import com.box.android.data.datasource.capture.CaptureHistoryCacheDataSource;
import com.box.android.data.datasource.clientsettings.ClientSettingsCacheDataSource;
import com.box.android.data.datasource.clientsettings.ClientSettingsRemoteDataSource;
import com.box.android.data.datasource.collaboration.InboxCollaborationRemoteDataSource;
import com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource;
import com.box.android.data.datasource.collection.CollectionsRemoteDataSource;
import com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLCollectionsResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLCollectionsWithItemResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLCreateCollectionItemResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLCreateCollectionResponseInterceptor;
import com.box.android.data.datasource.collection.interceptors.GQLRemoveCollectionItemResponseInterceptor;
import com.box.android.data.datasource.comment.CommentCacheDataSource;
import com.box.android.data.datasource.comment.CommentRemoteDataSource;
import com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource;
import com.box.android.data.datasource.files.DeleteFileRemoteDataSource;
import com.box.android.data.datasource.files.DownloadFileRemoteDataSource;
import com.box.android.data.datasource.files.FileMetadataRemoteDataSource;
import com.box.android.data.datasource.files.MetadataTemplatesRemoteDataSource;
import com.box.android.data.datasource.files.UploadFileRemoteDataSource;
import com.box.android.data.datasource.fileversions.FileVersionsRemoteDataSource;
import com.box.android.data.datasource.gql.BoxGraphQL;
import com.box.android.data.datasource.gql.DateProviding;
import com.box.android.data.datasource.gql.GQLApolloClientConfigurator;
import com.box.android.data.datasource.gql.GQLCache;
import com.box.android.data.datasource.gql.GQLRequestParser;
import com.box.android.data.datasource.gql.GQLResponseInterceptor;
import com.box.android.data.datasource.gql.QueryDebouncer;
import com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor;
import com.box.android.data.datasource.gql.cache.partial.GQLPartialMiniItemsSorter;
import com.box.android.data.datasource.gql.cache.partial.GQLPartialModelParser;
import com.box.android.data.datasource.hubs.HubAssetLocalDataSource;
import com.box.android.data.datasource.hubs.HubAssetRemoteDataSource;
import com.box.android.data.datasource.hubs.HubsDataSource;
import com.box.android.data.datasource.inboxnotifications.InboxNotificationLocalDataSource;
import com.box.android.data.datasource.inboxnotifications.InboxNotificationRemoteDataSource;
import com.box.android.data.datasource.item.ItemCollaborationsRemoteDataSource;
import com.box.android.data.datasource.item.UpdateItemInfoRemoteDataSource;
import com.box.android.data.datasource.items.interceptors.GQLCopyItemResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLCreateFolderResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetFolderMiniResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetFolderMiniWithParentResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetItemResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLGetItemWithWatermarkDataResponseInterceptor;
import com.box.android.data.datasource.items.interceptors.GQLMoveItemResponseInterceptor;
import com.box.android.data.datasource.jobs.JobsDataSource;
import com.box.android.data.datasource.localItems.LocalItemsDataSource;
import com.box.android.data.datasource.logging.MetricsCacheDataSource;
import com.box.android.data.datasource.logging.MetricsRemoteDataSource;
import com.box.android.data.datasource.notes.DefaultNoteFolderRemoteDataSource;
import com.box.android.data.datasource.observability.LogsCacheDataSource;
import com.box.android.data.datasource.recentnotes.RecentNotesLocalDataSource;
import com.box.android.data.datasource.recentnotes.RecentNotesRemoteDataSource;
import com.box.android.data.datasource.representations.Mp3RepresentationUriProvider;
import com.box.android.data.datasource.representations.RepresentationsCacheDataSource;
import com.box.android.data.datasource.representations.RepresentationsRemoteDataSource;
import com.box.android.data.datasource.search.FilesSearchRemoteDataSource;
import com.box.android.data.datasource.tasks.TaskRemoteDataSource;
import com.box.android.data.di.DataProvidesModule;
import com.box.android.data.di.DataProvidesModule_AppUpdatesSharedPreferencesFactory;
import com.box.android.data.di.DataProvidesModule_CaptureSharedPreferencesFactory;
import com.box.android.data.di.DataProvidesModule_FeatureFlipDebugSharedPreferencesFactory;
import com.box.android.data.di.DataProvidesModule_GeniusScanLicenseSharedPreferencesFactory;
import com.box.android.data.di.DataProvidesModule_ProvideAnnotationRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideAnonymousAuthRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideBoxAiRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideChunkedUploadFileRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideClientSettingsRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideCollectionItemsRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideCollectionRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideCommentRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideCommentV2RequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideCommentsControllerFactory;
import com.box.android.data.di.DataProvidesModule_ProvideCreateFolderRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideDefaultNoteFolderRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideDeleteItemRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideEmptyBodyInterceptorFactory;
import com.box.android.data.di.DataProvidesModule_ProvideFileActivitiesRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideFileDownloadRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideFileMetadataRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideFileRepresentationsRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideFileVersionRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideFilesSearchRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideGen204RequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideGen204RequestInterceptorFactory;
import com.box.android.data.di.DataProvidesModule_ProvideGetFolderItemsRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideHttpLoggingInterceptorFactory;
import com.box.android.data.di.DataProvidesModule_ProvideHttpStreamLoggingInterceptorFactory;
import com.box.android.data.di.DataProvidesModule_ProvideHubAssetDownloadRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideInboxCollaborationRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideInboxNotificationRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideInterceptorsFactory;
import com.box.android.data.di.DataProvidesModule_ProvideItemCollaborationsRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideItemInfoRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideLastUsedTabDataStoreFactory;
import com.box.android.data.di.DataProvidesModule_ProvideMetadataTemplatesRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideMoshiFactory;
import com.box.android.data.di.DataProvidesModule_ProvideNetworkInterceptorFactory;
import com.box.android.data.di.DataProvidesModule_ProvidePreferencesDataStoreFactory;
import com.box.android.data.di.DataProvidesModule_ProvidePreflightCheckRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvidePreviewDownloadRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvidePushNotificationSettingsRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideRecentNotesRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideRecentsRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideRumServiceFactory;
import com.box.android.data.di.DataProvidesModule_ProvideTaskRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideUpdateItemInfoRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideUpdateItemRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideUploadFileRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvideWatermarkRequestFactory;
import com.box.android.data.di.DataProvidesModule_ProvidesApdexServiceFactory;
import com.box.android.data.di.DataProvidesModule_ProvidesBoxCsrfTokenManagerFactory;
import com.box.android.data.di.DataProvidesModule_ProvidesBrowseControllerFactory;
import com.box.android.data.di.DataProvidesModule_ProvidesCookieManagerFactory;
import com.box.android.data.di.DataProvidesModule_ProvidesFileCanBePreviewedCheckerFactory;
import com.box.android.data.di.DataProvidesModule_ProvidesFirebaseRemoteConfigFactory;
import com.box.android.data.di.DataProvidesModule_ProvidesIdMappingServiceFactory;
import com.box.android.data.jobs.AutoUploadJob;
import com.box.android.data.jobs.ChunkUploadJob;
import com.box.android.data.jobs.CopyItemJob;
import com.box.android.data.jobs.CreateFolderJob;
import com.box.android.data.jobs.DeleteCollaborationJob;
import com.box.android.data.jobs.DeleteFileJob;
import com.box.android.data.jobs.DownloadChunkJob;
import com.box.android.data.jobs.DownloadFileJob;
import com.box.android.data.jobs.DownloadFolderJob;
import com.box.android.data.jobs.JobFactory;
import com.box.android.data.jobs.JobManagerBridgeService;
import com.box.android.data.jobs.JobService;
import com.box.android.data.jobs.JobWorkerFactory;
import com.box.android.data.jobs.MarkForOfflineFolderJob;
import com.box.android.data.jobs.MarkForOfflineJob;
import com.box.android.data.jobs.MoveCopyJobInputValidator;
import com.box.android.data.jobs.MoveItemJob;
import com.box.android.data.jobs.UploadFileJobV2;
import com.box.android.data.jobs.UploadFolderJob;
import com.box.android.data.jobs.UploadStatesFactory;
import com.box.android.data.mappers.annotation.AnnotationDTOEntityMapper;
import com.box.android.data.mappers.annotation.AnnotationEntityDomainMapper;
import com.box.android.data.mappers.annotation.CommentDTODomainMapper;
import com.box.android.data.mappers.annotation.CommentDTOEntityMapper;
import com.box.android.data.mappers.annotation.CommentEntityDomainMapper;
import com.box.android.data.mappers.annotation.FileActivityDTOEntityMapper;
import com.box.android.data.mappers.annotation.FileActivityEntityDomainMapper;
import com.box.android.data.mappers.annotation.FileActivityStatusDTOEntityMapper;
import com.box.android.data.mappers.annotation.FileVersionDTOV1EntityMapper;
import com.box.android.data.mappers.annotation.GroupedFileVersionEntitiesDomainMapper;
import com.box.android.data.mappers.annotation.VersionsDTOGroupedFileVersionEntitiesMapper;
import com.box.android.data.mappers.annotation.VersionsDTOGroupedFileVersionsEntityMapper;
import com.box.android.data.mappers.observability.MetricsEntityDTOMapper;
import com.box.android.data.mappers.representations.RepresentationDTOEntityMapper;
import com.box.android.data.mappers.tasks.TaskDTOToTaskModelMapper;
import com.box.android.data.observability.OpenTelemetryInstrumentationImpl;
import com.box.android.data.observability.SplunkRumInstrumentation;
import com.box.android.data.persistence.FileSystem;
import com.box.android.data.persistence.ForceUpdateRepository;
import com.box.android.data.persistence.ObservabilityDatabaseCreator;
import com.box.android.data.persistence.ObservabilityDatabaseProvider;
import com.box.android.data.persistence.gql.GQLDbHelper;
import com.box.android.data.persistence.offline.OfflineMigrationService;
import com.box.android.data.persistence.offline.OfflineServiceLocalDataSource;
import com.box.android.data.persistence.offline.OfflineStateStorage;
import com.box.android.data.service.ContentFileService;
import com.box.android.data.service.UploadFileProvider;
import com.box.android.data.service.impl.AnnotationsService;
import com.box.android.data.service.impl.ApdexScoreProvider;
import com.box.android.data.service.impl.AppRestrictionsManager;
import com.box.android.data.service.impl.AuthenticationService;
import com.box.android.data.service.impl.BVEManager;
import com.box.android.data.service.impl.CaptureHistoryFilesService;
import com.box.android.data.service.impl.CapturePreferencesService;
import com.box.android.data.service.impl.CaptureThumbnailService;
import com.box.android.data.service.impl.ClientSettingsService;
import com.box.android.data.service.impl.CollectionsService;
import com.box.android.data.service.impl.CommentService;
import com.box.android.data.service.impl.CommonServiceUtils;
import com.box.android.data.service.impl.CreateFolderService;
import com.box.android.data.service.impl.DefaultNoteFolderService;
import com.box.android.data.service.impl.DeleteFileService;
import com.box.android.data.service.impl.DocumentScanService;
import com.box.android.data.service.impl.DownloadFileService;
import com.box.android.data.service.impl.FavoritesService;
import com.box.android.data.service.impl.FileActivitiesService;
import com.box.android.data.service.impl.FileMetadataService;
import com.box.android.data.service.impl.FileVersionService;
import com.box.android.data.service.impl.ForceUpdateConfigSynchronizer;
import com.box.android.data.service.impl.GeniusScanLicenseService;
import com.box.android.data.service.impl.HubsService;
import com.box.android.data.service.impl.InboxCollaborationService;
import com.box.android.data.service.impl.InboxNotificationService;
import com.box.android.data.service.impl.ItemCollaborationsService;
import com.box.android.data.service.impl.ItemIdMappingService;
import com.box.android.data.service.impl.LegacyBridgeService;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.MetricsLoggingService;
import com.box.android.data.service.impl.OAuthAccessTokenService;
import com.box.android.data.service.impl.ObservabilityService;
import com.box.android.data.service.impl.OfflineFilesPolicyEnforcer;
import com.box.android.data.service.impl.OfflineService;
import com.box.android.data.service.impl.PreviewSettingsService;
import com.box.android.data.service.impl.PushNotificationSettingsService;
import com.box.android.data.service.impl.RecentNotesService;
import com.box.android.data.service.impl.RecentsService;
import com.box.android.data.service.impl.RemoteConfig;
import com.box.android.data.service.impl.RemoteItemService;
import com.box.android.data.service.impl.RepresentationsService;
import com.box.android.data.service.impl.SearchService;
import com.box.android.data.service.impl.SessionManager;
import com.box.android.data.service.impl.SharedLinkService;
import com.box.android.data.service.impl.TabPersistenceService;
import com.box.android.data.service.impl.TaskService;
import com.box.android.data.service.impl.UpdateItemInfoService;
import com.box.android.data.service.impl.UploadFileCleanupService;
import com.box.android.data.service.impl.UploadFileService;
import com.box.android.data.service.impl.UserService;
import com.box.android.data.service.impl.WatermarkService;
import com.box.android.data.service.impl.boxai.BoxAiService;
import com.box.android.data.service.impl.preview.AudioPlaylistItemsService;
import com.box.android.data.service.impl.preview.BridgedPreviewService;
import com.box.android.data.service.impl.preview.FileWithRepresentationsService;
import com.box.android.data.service.impl.preview.GalleryItemsService;
import com.box.android.data.service.impl.preview.PreviewLocalDataSource;
import com.box.android.data.service.impl.preview.PreviewerMappingsService;
import com.box.android.data.service.impl.preview.PreviousVersionPreviewService;
import com.box.android.data.service.impl.preview.helpers.FileCanBePreviewedChecker;
import com.box.android.data.service.impl.preview.helpers.PreviewFileWithRepresentationsWrapper;
import com.box.android.data.service.impl.preview.helpers.download.PreviewDownloadOriginalWrapper;
import com.box.android.data.service.impl.preview.helpers.download.PreviewDownloadRepresentationWrapper;
import com.box.android.data.service.impl.preview.helpers.legacycache.PreviewFromLegacyCacheFetcher;
import com.box.android.data.service.impl.preview.helpers.legacycache.PreviewerTypeLegacyCacheMapper;
import com.box.android.data.service.impl.thumbnail.FileToBitmapDecoder;
import com.box.android.data.service.impl.thumbnail.GetThumbnailRepresentationsService;
import com.box.android.data.service.impl.thumbnail.ThumbnailService;
import com.box.android.data.user.DatabaseProvider;
import com.box.android.data.user.UserData;
import com.box.android.data.utilities.BoxUriSupportChecker;
import com.box.android.data.utilities.GQLCacheHelper;
import com.box.android.data.utilities.LocalItemServiceItemsCreator;
import com.box.android.data.webBridgeAuth.BoxWebBridgeAuthenticator;
import com.box.android.di.BoxModule_Companion_AppInBackgroundServiceFactory;
import com.box.android.di.BoxModule_Companion_ProvideApiExecutorFactory;
import com.box.android.di.BoxModule_Companion_ProvideAppFlavorStringFactory;
import com.box.android.di.BoxModule_Companion_ProvideApplicationContextFactory;
import com.box.android.di.BoxModule_Companion_ProvideAuthorizerOkHttpClientFactory;
import com.box.android.di.BoxModule_Companion_ProvideBoxApiFileFactory;
import com.box.android.di.BoxModule_Companion_ProvideGlobalExecutorFactory;
import com.box.android.di.BoxModule_Companion_ProvideGlobalSharedPreferencesFactory;
import com.box.android.di.BoxModule_Companion_ProvideIntegrityAPICallerFactory;
import com.box.android.di.BoxModule_Companion_ProvideLevelDBKeyValueStoreFactory;
import com.box.android.di.BoxModule_Companion_ProvideTasksRepoFactory;
import com.box.android.di.BoxModule_Companion_ProvideThumbnailExecutorFactory;
import com.box.android.di.BoxModule_Companion_ProvidesAppStartTargetHolderFactory;
import com.box.android.di.BoxModule_Companion_ProvidesAuthenticationCredentialsProviderFactory;
import com.box.android.di.BoxModule_Companion_ProvidesBoxStorageFactory;
import com.box.android.di.BoxModule_Companion_ProvidesBrowseTabAppStartDestinationPageFactory;
import com.box.android.di.BoxModule_Companion_ProvidesIMoCoBoxGlobalSettingsFactory;
import com.box.android.di.BoxModule_Companion_ProvidesSplashScreenAppStartIntermediatePageFactory;
import com.box.android.di.DefaultModule_Companion_ProvideAndroidForWorkControllerFactory;
import com.box.android.di.DefaultModule_Companion_ProvideBoxApiBookmarkFactory;
import com.box.android.di.DefaultModule_Companion_ProvideBoxApiCollaborationFactory;
import com.box.android.di.DefaultModule_Companion_ProvideBoxApiCollectionsFactory;
import com.box.android.di.DefaultModule_Companion_ProvideBoxApiFeaturesFactory;
import com.box.android.di.DefaultModule_Companion_ProvideBoxApiInviteeFactory;
import com.box.android.di.DefaultModule_Companion_ProvideBoxApiLocalRecentItemsFactory;
import com.box.android.di.DefaultModule_Companion_ProvideBoxApiPrivateFactory;
import com.box.android.di.DefaultModule_Companion_ProvideBoxApiRecentItemsFactory;
import com.box.android.di.DefaultModule_Companion_ProvideBoxApiShareFactory;
import com.box.android.di.DefaultModule_Companion_ProvideBoxApiUserFactory;
import com.box.android.di.DefaultModule_Companion_ProvideBoxApiWeblinkFactory;
import com.box.android.di.DefaultModule_Companion_ProvideBoxExtendedApiFolderFactory;
import com.box.android.di.DefaultModule_Companion_ProvideBoxExtendedApiPreviewFactory;
import com.box.android.di.DefaultModule_Companion_ProvideDeviceIdFactory;
import com.box.android.di.DefaultModule_Companion_ProvideDeviceIdStorageFactory;
import com.box.android.di.DefaultModule_Companion_ProvideIMoCoAdminSettingsFactory;
import com.box.android.di.DefaultModule_Companion_ProvideIMoCoBoxTransfersFactory;
import com.box.android.di.DefaultModule_Companion_ProvideSearchActionLogHelperFactory;
import com.box.android.di.DefaultModule_Companion_ProvideSearchApiFactory;
import com.box.android.di.DefaultModule_Companion_ProvideStorageFactory;
import com.box.android.di.DefaultModule_Companion_ProvideTimeLogHelperFactory;
import com.box.android.di.DefaultModule_Companion_ProvideUserContextMigrationFactory;
import com.box.android.di.DefaultModule_Companion_ProvidesIMoCoBatchOperationsFactory;
import com.box.android.di.DefaultModule_Companion_ProvidesIMoCoBoxRecentEventsFactory;
import com.box.android.di.DefaultModule_Companion_ProvidesSortPreferencesFactory;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.WopiPropertyBuilder;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.configuration.FeatureFlipEvaluator;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.SplitConfiguration;
import com.box.android.domain.configuration.UserSessionInfo;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.controller.ICommentsController;
import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.di.DomainProvidesModule_ProvideEventPropertyBuilderFactory;
import com.box.android.domain.di.MetricDecoratorsModule_ProvidesDeviceMetricDecoratorFactory;
import com.box.android.domain.di.MetricDecoratorsModule_ProvidesUserMetricDecoratorFactory;
import com.box.android.domain.identity.DeviceId;
import com.box.android.domain.identity.IDeviceIdStorage;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.initialisation.ClientSettingsInitialisation;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.localrepo.HubsScreenPreferences;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.localrepo.LocalSortPreferences;
import com.box.android.domain.metrics.ForceUpdateObservability;
import com.box.android.domain.metrics.Gen204DownloadEventLogger;
import com.box.android.domain.metrics.Gen204FileActivityEventLogger;
import com.box.android.domain.metrics.Gen204FolderItemsEventLogger;
import com.box.android.domain.metrics.Gen204JobServiceHelper;
import com.box.android.domain.metrics.Gen204MoveCopyEventLogger;
import com.box.android.domain.metrics.Gen204OfflineEventLogger;
import com.box.android.domain.metrics.Gen204PerformanceLogger;
import com.box.android.domain.metrics.Gen204UploadEventLogger;
import com.box.android.domain.metrics.Gen204WatermarkingEventLogger;
import com.box.android.domain.metrics.boxai.BoxAiObservability;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.box.android.domain.metrics.msal.MsalObservability;
import com.box.android.domain.metrics.preview.PreviewObservability;
import com.box.android.domain.metrics.preview.PreviousVersionPreviewObservability;
import com.box.android.domain.preview.IFileCanBePreviewedChecker;
import com.box.android.domain.preview.PreviewerTypeResolverImpl;
import com.box.android.domain.services.ApdexService;
import com.box.android.domain.services.IAppInBackgroundService;
import com.box.android.domain.services.IAppRestrictionsManager;
import com.box.android.domain.services.IDefaultNoteFolderService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.services.RumService;
import com.box.android.domain.usecases.UserInteractor;
import com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityInteractor;
import com.box.android.domain.usecases.browse.CreateFolderInteractor;
import com.box.android.domain.usecases.browse.FolderInteractor;
import com.box.android.domain.usecases.browse.FolderViewInteractor;
import com.box.android.domain.usecases.browse.OfflinedViewInteractor;
import com.box.android.domain.usecases.browse.RecentsViewInteractor;
import com.box.android.domain.usecases.capture.CaptureFolderInteractor;
import com.box.android.domain.usecases.capture.CaptureHistoryInteractor;
import com.box.android.domain.usecases.capture.CaptureLocalItemsInteractor;
import com.box.android.domain.usecases.capture.DeleteCaptureHistoryInteractor;
import com.box.android.domain.usecases.capture.LaunchIntoCaptureInteractor;
import com.box.android.domain.usecases.capture.LaunchIntoCaptureUseCase;
import com.box.android.domain.usecases.collections.CollectionMembershipsInteractor;
import com.box.android.domain.usecases.collections.CreateCollectionInteractor;
import com.box.android.domain.usecases.collections.GetFavoritesCollectionIdInteractor;
import com.box.android.domain.usecases.collections.ListCollectionItemsInteractor;
import com.box.android.domain.usecases.collections.ListCollectionsInteractor;
import com.box.android.domain.usecases.documentscanning.DocumentScanInteractor;
import com.box.android.domain.usecases.fileactivities.GetFileActivitiesInteractor;
import com.box.android.domain.usecases.fileactivities.annotation.CreateAnnotationInteractor;
import com.box.android.domain.usecases.fileactivities.annotation.DeleteAnnotationInteractor;
import com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor;
import com.box.android.domain.usecases.fileactivities.annotation.UpdateAnnotationInteractor;
import com.box.android.domain.usecases.fileactivities.comment.CreateCommentInteractor;
import com.box.android.domain.usecases.fileactivities.comment.CreateReplyInteractor;
import com.box.android.domain.usecases.fileactivities.comment.DeleteCommentInteractor;
import com.box.android.domain.usecases.fileactivities.comment.UpdateCommentInteractor;
import com.box.android.domain.usecases.notes.NoteNameGenerator;
import com.box.android.domain.usecases.notes.NotesFavoritesViewInteractor;
import com.box.android.domain.usecases.notes.NotesRecentsViewInteractor;
import com.box.android.domain.usecases.notes.ResolveNewNoteDataInteractor;
import com.box.android.domain.usecases.notes.ResolveNewNoteLocationInteractor;
import com.box.android.domain.usecases.notes.SetDefaultNoteFolderInteractor;
import com.box.android.domain.usecases.observability.AuthenticationInteractor;
import com.box.android.domain.usecases.observability.CreateLogArchiveInteractor;
import com.box.android.domain.usecases.observability.MetricDecorator;
import com.box.android.domain.usecases.observability.MetricsInteractor;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.android.domain.usecases.observability.UploadLogsInteractor;
import com.box.android.domain.usecases.preview.TrackRecentPreviewItemInteractor;
import com.box.android.domain.usecases.pushnotifications.NotificationCategoriesInteractor;
import com.box.android.domain.usecases.pushnotifications.RegisterPushDeviceInteractor;
import com.box.android.domain.usecases.pushnotifications.UpdateDeviceRegistrationInteractor;
import com.box.android.domain.usecases.thumbnail.ThumbnailPreviewInteractor;
import com.box.android.domain.utils.ItemSorter;
import com.box.android.domain.webBridgeAuth.BoxCsrfTokenManager;
import com.box.android.fileactivity.presentation.FileActivitiesActivity;
import com.box.android.fileactivity.presentation.FileActivitiesEnvironment;
import com.box.android.fileactivity.presentation.FileActivitiesLauncher;
import com.box.android.fileactivity.presentation.FileActivitiesViewModel;
import com.box.android.fileactivity.presentation.FileActivitiesViewModel_HiltModules;
import com.box.android.fileactivity.presentation.FileActivitiesViewModel_HiltModules_BindsModule_Bind_LazyMapKey;
import com.box.android.fileactivity.presentation.FileActivitiesViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.fragments.ChooseAuthenticationFragment;
import com.box.android.fragments.ChooseAuthenticationFragment_MembersInjector;
import com.box.android.fragments.EmailSupportFragment;
import com.box.android.fragments.EmailSupportFragment_MembersInjector;
import com.box.android.fragments.NavigationTabFragment;
import com.box.android.fragments.NavigationTabFragment_MembersInjector;
import com.box.android.fragments.NotificationsTasksTabFragment;
import com.box.android.fragments.PushRegistrationDialogFragment;
import com.box.android.fragments.PushRegistrationDialogFragment_MembersInjector;
import com.box.android.fragments.boxitem.InboxFragment;
import com.box.android.fragments.boxitem.InboxFragment_MembersInjector;
import com.box.android.fragments.boxitem.MyTasksFragment;
import com.box.android.fragments.boxitem.MyTasksFragment_MembersInjector;
import com.box.android.fragments.boxitem.PushNotificationsFragment;
import com.box.android.fragments.boxitem.PushNotificationsFragment_MembersInjector;
import com.box.android.fragments.boxitem.SentTasksFragment;
import com.box.android.fragments.boxitem.SentTasksFragment_MembersInjector;
import com.box.android.fragments.boxitem.SingleTaskFragment;
import com.box.android.fragments.boxitem.TaskCollaboratorsFragment;
import com.box.android.fragments.boxitem.TaskCollaboratorsFragment_MembersInjector;
import com.box.android.fragments.boxitem.TasksFragment_MembersInjector;
import com.box.android.hubs.hubDetails.domain.HubSpecificUrlHandler;
import com.box.android.hubs.hubDetails.presentation.HubDetailsActivity;
import com.box.android.hubs.hubDetails.presentation.HubDetailsActivity_MembersInjector;
import com.box.android.hubs.hubDetails.presentation.HubDetailsEnvironment;
import com.box.android.hubs.hubDetails.presentation.HubDetailsViewModel;
import com.box.android.hubs.hubDetails.presentation.HubDetailsViewModel_HiltModules;
import com.box.android.hubs.hubDetails.presentation.HubDetailsViewModel_HiltModules_BindsModule_Bind_LazyMapKey;
import com.box.android.hubs.hubDetails.presentation.HubDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.hubs.presentation.HubsAnalytics;
import com.box.android.hubs.presentation.HubsEnvironment;
import com.box.android.hubs.presentation.HubsFragment;
import com.box.android.hubs.presentation.HubsFragment_MembersInjector;
import com.box.android.hubs.presentation.HubsItemPickerViewModel;
import com.box.android.hubs.presentation.HubsItemPickerViewModel_HiltModules;
import com.box.android.hubs.presentation.HubsItemPickerViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.hubs.presentation.HubsItemPickerViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.hubs.presentation.HubsViewModel;
import com.box.android.hubs.presentation.HubsViewModel_HiltModules;
import com.box.android.hubs.presentation.HubsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.hubs.presentation.HubsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.inbox.InboxAnalytics;
import com.box.android.inbox.MfaCallbackIntentHandler;
import com.box.android.inbox.mfasetup.MfaSetupAnalytics;
import com.box.android.inbox.mfasetup.MfaSetupDialogEnvironment;
import com.box.android.inbox.mfasetup.MfaSetupUrlBuilder;
import com.box.android.inbox.notifications.InboxEnvironment;
import com.box.android.inbox.notifications.InboxItemEnvironment;
import com.box.android.inbox.notifications.InboxItemsListEnvironment;
import com.box.android.inbox.notifications.InboxViewModel;
import com.box.android.inbox.notifications.InboxViewModel_HiltModules;
import com.box.android.inbox.notifications.InboxViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.inbox.notifications.InboxViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationEnvironment;
import com.box.android.inbox.notifications.router.InboxNotificationRoutingMapper;
import com.box.android.inbox.notifications.router.InboxRouter;
import com.box.android.inbox.tabsscreen.InboxTabsEnvironment;
import com.box.android.inbox.tabsscreen.InboxTabsViewModel;
import com.box.android.inbox.tabsscreen.InboxTabsViewModel_HiltModules;
import com.box.android.inbox.tabsscreen.InboxTabsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.inbox.tabsscreen.InboxTabsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.jobmanager.JobManagerNotificationCenter;
import com.box.android.jobsui.JobsReducer;
import com.box.android.jobsui.JobsUIActivity;
import com.box.android.jobsui.JobsUIActivity_MembersInjector;
import com.box.android.jobsui.JobsUICoreHelper;
import com.box.android.jobsui.JobsUIEnvironment;
import com.box.android.jobsui.JobsUIViewModel;
import com.box.android.jobsui.JobsUIViewModel_HiltModules;
import com.box.android.jobsui.JobsUIViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.jobsui.JobsUIViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.jobsui.helpers.TransfersHelper;
import com.box.android.localrepo.BoxLocalCache;
import com.box.android.localrepo.LevelDBKeyValueStore;
import com.box.android.localrepo.LocalSharedPreferences;
import com.box.android.modelcontroller.MoCoAdminSettings;
import com.box.android.modelcontroller.MoCoBatchOperations;
import com.box.android.modelcontroller.MoCoBoxTransfers;
import com.box.android.modelcontroller.ShareModelController;
import com.box.android.models.BoxSessionFactory;
import com.box.android.navigation.Navigation;
import com.box.android.navigation.NavigationBottomBar;
import com.box.android.navigation.Navigation_MembersInjector;
import com.box.android.navigationmodernization.MainActivity;
import com.box.android.navigationmodernization.MainActivity_MembersInjector;
import com.box.android.navigationmodernization.MainBaseActivity_MembersInjector;
import com.box.android.navigationmodernization.MainNavigationViewModel;
import com.box.android.navigationmodernization.MainNavigationViewModel_HiltModules;
import com.box.android.navigationmodernization.MainNavigationViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.navigationmodernization.MainNavigationViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.navigationmodernization.homescreen.HomeScreenEnvironment;
import com.box.android.navigationmodernization.homescreen.HomeScreenViewModel;
import com.box.android.navigationmodernization.homescreen.HomeScreenViewModel_HiltModules;
import com.box.android.navigationmodernization.homescreen.HomeScreenViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.navigationmodernization.homescreen.HomeScreenViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.navigationmodernization.homescreen.helpers.FTUXMessageReceiverHelper;
import com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenInnerNavigatorsProviderFactory;
import com.box.android.navigationmodernization.navigation.configuration.MainNavigationTargetConfigFactory;
import com.box.android.navigationmodernization.navigation.navigator.RootInnerNavigatorsProviderFactory;
import com.box.android.notes.navigationmodernization.NotesAnalytics;
import com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsEnvironment;
import com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsViewModel;
import com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsViewModel_HiltModules;
import com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.notes.presentation.cpl.NotesFavoritesListEnvironment;
import com.box.android.notes.presentation.cpl.NotesFavoritesViewModel;
import com.box.android.notes.presentation.cpl.NotesFavoritesViewModel_HiltModules;
import com.box.android.notes.presentation.cpl.NotesFavoritesViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.notes.presentation.cpl.NotesFavoritesViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.notes.presentation.cpl.NotesRecentsListEnvironment;
import com.box.android.notes.presentation.cpl.NotesRecentsViewModel;
import com.box.android.notes.presentation.cpl.NotesRecentsViewModel_HiltModules;
import com.box.android.notes.presentation.cpl.NotesRecentsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.notes.presentation.cpl.NotesRecentsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.observability.DiagnosticsNotificationHandler;
import com.box.android.observability.DiagnosticsNotificationHandler_MembersInjector;
import com.box.android.observability.MetricsUploadScheduler;
import com.box.android.observability.ObservabilitySettingsManager;
import com.box.android.observability.WorkManagerWorkerFactory;
import com.box.android.observability.appstart.AuthenticationAppStartDestinationPage;
import com.box.android.observability.appstart.BrowseTabAppStartDestinationPage;
import com.box.android.preview.BoxThumbnailRequests;
import com.box.android.preview.annotations.PdfAnnotationModelMapper;
import com.box.android.preview.annotations.cpl.AnnotationsEnvironment;
import com.box.android.preview.annotations.cpl.CreateAnnotationEnvironment;
import com.box.android.preview.annotations.managers.AnnotationManagersProvider;
import com.box.android.preview.boxcanvas.BoxCanvasActivity;
import com.box.android.preview.boxcanvas.BoxCanvasActivity_MembersInjector;
import com.box.android.preview.boxcanvas.BoxCanvasIntentBuilder;
import com.box.android.preview.boxcanvas.CanvasAuthorizer;
import com.box.android.preview.di.PreviewModule_Companion_ProvideVideoMediaSourceFactoryFactory;
import com.box.android.preview.document.copytext.CopySelectedTextEnvironment;
import com.box.android.preview.fileactions.FileActionsEnvironment;
import com.box.android.preview.fileactions.UpdateItemInfoEnvironment;
import com.box.android.preview.fileactions.copylink.CopyLinkEnvironment;
import com.box.android.preview.fileactions.openin.OpenInEnvironment;
import com.box.android.preview.gallery.GalleryItemsActivity;
import com.box.android.preview.gallery.GalleryItemsEnvironment;
import com.box.android.preview.gallery.GalleryItemsViewModel;
import com.box.android.preview.gallery.GalleryItemsViewModel_HiltModules;
import com.box.android.preview.gallery.GalleryItemsViewModel_HiltModules_BindsModule_Bind_LazyMapKey;
import com.box.android.preview.gallery.GalleryItemsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.preview.integration.media3.Media3DataSourceFactory;
import com.box.android.preview.integration.media3.WatermarkResolvingDataSourceFactory;
import com.box.android.preview.item.ItemPreviewEnvironment;
import com.box.android.preview.item.ScrollableFileTypeResolver;
import com.box.android.preview.item.labels.ItemPreviewLabelsEnvironment;
import com.box.android.preview.item.labels.offline.PreviewOfflineLabelEnvironment;
import com.box.android.preview.iteminformation.ItemInformationActivity;
import com.box.android.preview.iteminformation.ItemInformationActivity_MembersInjector;
import com.box.android.preview.iteminformation.ItemInformationAnalytics;
import com.box.android.preview.iteminformation.ItemInformationEnvironment;
import com.box.android.preview.iteminformation.ItemInformationViewModel;
import com.box.android.preview.iteminformation.ItemInformationViewModel_HiltModules;
import com.box.android.preview.iteminformation.ItemInformationViewModel_HiltModules_BindsModule_Bind_LazyMapKey;
import com.box.android.preview.iteminformation.ItemInformationViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.preview.preview.PreviewActivity;
import com.box.android.preview.preview.PreviewActivityIntentHandler;
import com.box.android.preview.preview.PreviewActivity_MembersInjector;
import com.box.android.preview.preview.PreviewAnalytics;
import com.box.android.preview.preview.PreviewEnvironment;
import com.box.android.preview.preview.PreviewViewModel;
import com.box.android.preview.preview.PreviewViewModel_HiltModules;
import com.box.android.preview.preview.PreviewViewModel_HiltModules_BindsModule_Bind_LazyMapKey;
import com.box.android.preview.preview.PreviewViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.preview.preview.previewbar.bottombar.BottomBarEnvironment;
import com.box.android.preview.preview.previewbar.topbar.TopBarEnvironment;
import com.box.android.preview.previewtype.audio.AudioPlayerService;
import com.box.android.preview.previewtype.audio.AudioPlayerService_MembersInjector;
import com.box.android.preview.previewtype.audio.Media3AudioPlayerManager;
import com.box.android.preview.previewtype.audio.helper.AudioMediaItemCreator;
import com.box.android.preview.previewtype.audio.helper.CoverArtExtractor;
import com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistActivity;
import com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistActivity_MembersInjector;
import com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistEnvironment;
import com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistViewModel;
import com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistViewModel_HiltModules;
import com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistViewModel_HiltModules_BindsModule_Bind_LazyMapKey;
import com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.preview.previewtype.boxnote.BoxNoteEditModeEnvironment;
import com.box.android.preview.previewtype.boxnote.BoxNoteRequestBuilder;
import com.box.android.preview.previewtype.boxnote.BoxNotesEnvironment;
import com.box.android.preview.previewtype.boxnote.BoxNotesUrlBuilder;
import com.box.android.preview.previewtype.code.CodeFileReader;
import com.box.android.preview.previewtype.code.CodePreviewEnvironment;
import com.box.android.preview.previewtype.document.CitationHighlightEnvironment;
import com.box.android.preview.previewtype.document.DocumentPreviewEnvironment;
import com.box.android.preview.previewtype.document.copytext.TextSelectionManager;
import com.box.android.preview.previewtype.document.print.PrintEnvironment;
import com.box.android.preview.previewtype.document.search.DocumentSearchEnvironment;
import com.box.android.preview.previewtype.document.search.SearchOptionsProvider;
import com.box.android.preview.previewtype.document.search.TextSearchManager;
import com.box.android.preview.previewtype.gif.GifPreviewEnvironment;
import com.box.android.preview.previewtype.image.ImagePreviewEnvironment;
import com.box.android.preview.previewtype.video.FrameAnnotationEnvironment;
import com.box.android.preview.previewtype.video.FrameExporter;
import com.box.android.preview.previewtype.video.VideoMediaSourceFactory;
import com.box.android.preview.previewtype.video.VideoPlayerInteractor;
import com.box.android.preview.previewtype.video.VideoPlayersProvider;
import com.box.android.preview.previewtype.video.VideoPreviewEnvironment;
import com.box.android.preview.previousversion.PreviousVersionEnvironment;
import com.box.android.preview.previousversion.PreviousVersionPreviewActivity;
import com.box.android.preview.previousversion.PreviousVersionPreviewActivity_MembersInjector;
import com.box.android.preview.previousversion.PreviousVersionViewModel;
import com.box.android.preview.previousversion.PreviousVersionViewModel_HiltModules;
import com.box.android.preview.previousversion.PreviousVersionViewModel_HiltModules_BindsModule_Bind_LazyMapKey;
import com.box.android.preview.previousversion.PreviousVersionViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.preview.utils.PreviewLauncher;
import com.box.android.preview.utils.PreviewPrefetcher;
import com.box.android.preview.wopi.OfficeAppDetector;
import com.box.android.preview.wopi.WopiService;
import com.box.android.receiver.BoxDeviceConfigChangeInfoReceiver;
import com.box.android.receiver.BoxDeviceConfigChangeInfoReceiver_MembersInjector;
import com.box.android.receiver.CommentsReplyReceiver;
import com.box.android.receiver.CommentsReplyReceiver_MembersInjector;
import com.box.android.receiver.DelayedNotificationReceiver;
import com.box.android.receiver.DelayedNotificationReceiver_MembersInjector;
import com.box.android.receiver.ReferralReceiver;
import com.box.android.receiver.ReferralReceiver_MembersInjector;
import com.box.android.repo.NotificationRegistrationCategoriesRepo;
import com.box.android.requests.BoxApiFeatures;
import com.box.android.requests.BoxApiInvitee;
import com.box.android.routers.BoxPreviewRouter;
import com.box.android.search.analytics.BrowseSearchAnalytics;
import com.box.android.search.presentation.SearchActivity;
import com.box.android.search.presentation.SearchActivity_MembersInjector;
import com.box.android.search.presentation.cpl.SearchEnvironment;
import com.box.android.search.presentation.vm.NotesSearchViewModel;
import com.box.android.search.presentation.vm.NotesSearchViewModel_HiltModules;
import com.box.android.search.presentation.vm.NotesSearchViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.search.presentation.vm.NotesSearchViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.search.presentation.vm.SearchItemPickerViewModel;
import com.box.android.search.presentation.vm.SearchItemPickerViewModel_HiltModules;
import com.box.android.search.presentation.vm.SearchItemPickerViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.search.presentation.vm.SearchItemPickerViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.search.presentation.vm.SearchViewModel;
import com.box.android.search.presentation.vm.SearchViewModel_HiltModules;
import com.box.android.search.presentation.vm.SearchViewModel_HiltModules_BindsModule_Bind_LazyMapKey;
import com.box.android.search.presentation.vm.SearchViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.services.AppIntentServices;
import com.box.android.services.AppNotificationServices;
import com.box.android.services.FirebaseMessagingListenerService;
import com.box.android.services.FirebaseMessagingListenerServiceHelper;
import com.box.android.services.FirebaseMessagingListenerService_MembersInjector;
import com.box.android.services.FirebaseTokenHandlerService;
import com.box.android.services.FirebaseTokenHandlerService_MembersInjector;
import com.box.android.services.FirebaseTokenRegistration;
import com.box.android.services.JobsNotificationService;
import com.box.android.sync.AuthenticatorService;
import com.box.android.sync.AuthenticatorService_MembersInjector;
import com.box.android.tasks.addtask.activity.AddTaskActivity;
import com.box.android.tasks.addtask.cpl.AddTaskEnvironment;
import com.box.android.tasks.addtask.cpl.AddTaskFormEnvironment;
import com.box.android.tasks.addtask.cpl.AssigneePickerEnvironment;
import com.box.android.tasks.addtask.viewmodel.AddTaskViewModel;
import com.box.android.tasks.addtask.viewmodel.AddTaskViewModel_HiltModules;
import com.box.android.tasks.addtask.viewmodel.AddTaskViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.tasks.addtask.viewmodel.AddTaskViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.tasksrepo.SingleTaskRepo;
import com.box.android.tasksrepo.TaskCollaboratorsRepo;
import com.box.android.tasksrepo.TasksRepo;
import com.box.android.updates.UpdatesManager;
import com.box.android.updates.di.AppUpdatesModule_Companion_ProvideAppUpdateManagerFactory;
import com.box.android.updates.force.ForceUpdateActionHandler;
import com.box.android.updates.force.ForceUpdateCoordinator;
import com.box.android.updates.force.ForceUpdateDialogConfigProvider;
import com.box.android.updates.force.ForceUpdateEvaluator;
import com.box.android.updates.force.ForceUpdateVersionValidator;
import com.box.android.updates.force.analytics.ForceUpdateAnalytics;
import com.box.android.updates.force.ui.ForceUpdateActivity;
import com.box.android.updates.force.ui.ForceUpdateActivity_MembersInjector;
import com.box.android.updates.proposal.AppUpdateProposalAnalytics;
import com.box.android.updates.proposal.AppUpdateProposalManager;
import com.box.android.updates.proposal.presentation.AppUpdateProposalEnvironment;
import com.box.android.updates.proposal.presentation.AppUpdateProposalViewModel;
import com.box.android.updates.proposal.presentation.AppUpdateProposalViewModel_HiltModules;
import com.box.android.updates.proposal.presentation.AppUpdateProposalViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.updates.proposal.presentation.AppUpdateProposalViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.usercontext.UserContext;
import com.box.android.usercontext.UserContextManager;
import com.box.android.utilities.AppInfoService;
import com.box.android.utilities.BetaFeedbackEmailSender;
import com.box.android.utilities.EmailChooserHelper;
import com.box.android.utilities.IStorage;
import com.box.android.utilities.ItemActionHandler;
import com.box.android.utilities.ItemClickHandler;
import com.box.android.utilities.ItemMoreActionsHandler;
import com.box.android.utilities.LegacyMessageToGQLBridge;
import com.box.android.utilities.SystemInfo;
import com.box.android.vm.InboxBadgeVM;
import com.box.android.vm.InboxBadgeVM_HiltModules;
import com.box.android.vm.InboxBadgeVM_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.vm.InboxBadgeVM_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.vm.PushNotificationSettingsViewModelFactory;
import com.box.android.vm.PushRegistrationDialogVM;
import com.box.android.vm.PushRegistrationDialogVM_HiltModules;
import com.box.android.vm.PushRegistrationDialogVM_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.vm.PushRegistrationDialogVM_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.vm.SingleTaskVM;
import com.box.android.vm.SingleTaskVM_HiltModules;
import com.box.android.vm.SingleTaskVM_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.vm.SingleTaskVM_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.vm.TaskCollaboratorsVM;
import com.box.android.vm.TaskCollaboratorsVM_HiltModules;
import com.box.android.vm.TaskCollaboratorsVM_HiltModules_BindsModule_Binds_LazyMapKey;
import com.box.android.vm.TaskCollaboratorsVM_HiltModules_KeyModule_Provide_LazyMapKey;
import com.box.android.vm.TasksVMFactory;
import com.box.android.workers.AllWorkerFactories;
import com.box.androidsdk.content.BoxApiBookmark;
import com.box.androidsdk.content.BoxApiRecentItems;
import com.box.androidsdk.content.BoxApiShare;
import com.box.androidsdk.content.BoxApiUser;
import com.box.androidsdk.content.BoxCache;
import com.box.androidsdk.content.BoxExtendedApiPreview;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollaboration;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollections;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiRecentItems;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiSearch;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import com.box.cirrus.CirrusLoader;
import com.box.cirrus.providers.BoxAccountSettingsProvider;
import com.box.cirrus.providers.BoxAnalyticsProvider;
import com.box.cirrus.providers.BoxAuthProvider;
import com.box.cirrus.providers.BoxConfigProvider;
import com.box.cirrus.providers.BoxContentUploadService;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import com.squareup.moshi.Moshi;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SingleCheck;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: classes9.dex */
public final class DaggerBoxApplication_HiltComponents_SingletonC {
    private DaggerBoxApplication_HiltComponents_SingletonC() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private ApplicationContextModule applicationContextModule;
        private DataProvidesModule dataProvidesModule;

        private Builder() {
        }

        public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
            this.applicationContextModule = (ApplicationContextModule) Preconditions.checkNotNull(applicationContextModule);
            return this;
        }

        public Builder dataProvidesModule(DataProvidesModule dataProvidesModule) {
            this.dataProvidesModule = (DataProvidesModule) Preconditions.checkNotNull(dataProvidesModule);
            return this;
        }

        public BoxApplication_HiltComponents.SingletonC build() {
            Preconditions.checkBuilderRequirement(this.applicationContextModule, ApplicationContextModule.class);
            if (this.dataProvidesModule == null) {
                this.dataProvidesModule = new DataProvidesModule();
            }
            return new SingletonCImpl(this.applicationContextModule, this.dataProvidesModule);
        }
    }

    private static final class ActivityRetainedCBuilder implements BoxApplication_HiltComponents.ActivityRetainedC.Builder {
        private SavedStateHandleHolder savedStateHandleHolder;
        private final SingletonCImpl singletonCImpl;

        private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
            this.singletonCImpl = singletonCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder
        public ActivityRetainedCBuilder savedStateHandleHolder(SavedStateHandleHolder savedStateHandleHolder) {
            this.savedStateHandleHolder = (SavedStateHandleHolder) Preconditions.checkNotNull(savedStateHandleHolder);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder
        public BoxApplication_HiltComponents.ActivityRetainedC build() {
            Preconditions.checkBuilderRequirement(this.savedStateHandleHolder, SavedStateHandleHolder.class);
            return new ActivityRetainedCImpl(this.singletonCImpl, this.savedStateHandleHolder);
        }
    }

    private static final class ActivityCBuilder implements BoxApplication_HiltComponents.ActivityC.Builder {
        private Activity activity;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;

        private ActivityCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ActivityComponentBuilder
        public ActivityCBuilder activity(Activity activity) {
            this.activity = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ActivityComponentBuilder
        public BoxApplication_HiltComponents.ActivityC build() {
            Preconditions.checkBuilderRequirement(this.activity, Activity.class);
            return new ActivityCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activity);
        }
    }

    private static final class FragmentCBuilder implements BoxApplication_HiltComponents.FragmentC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Fragment fragment;
        private final SingletonCImpl singletonCImpl;

        private FragmentCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.FragmentComponentBuilder
        public FragmentCBuilder fragment(Fragment fragment) {
            this.fragment = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.FragmentComponentBuilder
        public BoxApplication_HiltComponents.FragmentC build() {
            Preconditions.checkBuilderRequirement(this.fragment, Fragment.class);
            return new FragmentCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragment);
        }
    }

    private static final class ViewWithFragmentCBuilder implements BoxApplication_HiltComponents.ViewWithFragmentC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final SingletonCImpl singletonCImpl;
        private View view;

        private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, FragmentCImpl fragmentCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
            this.fragmentCImpl = fragmentCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder
        public ViewWithFragmentCBuilder view(View view) {
            this.view = (View) Preconditions.checkNotNull(view);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder
        public BoxApplication_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(this.view, View.class);
            return new ViewWithFragmentCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl, this.view);
        }
    }

    private static final class ViewCBuilder implements BoxApplication_HiltComponents.ViewC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;
        private View view;

        private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ViewComponentBuilder
        public ViewCBuilder view(View view) {
            this.view = (View) Preconditions.checkNotNull(view);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ViewComponentBuilder
        public BoxApplication_HiltComponents.ViewC build() {
            Preconditions.checkBuilderRequirement(this.view, View.class);
            return new ViewCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.view);
        }
    }

    private static final class ViewModelCBuilder implements BoxApplication_HiltComponents.ViewModelC.Builder {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private SavedStateHandle savedStateHandle;
        private final SingletonCImpl singletonCImpl;
        private ViewModelLifecycle viewModelLifecycle;

        private ViewModelCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ViewModelComponentBuilder
        public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
            this.savedStateHandle = (SavedStateHandle) Preconditions.checkNotNull(handle);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ViewModelComponentBuilder
        public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
            this.viewModelLifecycle = (ViewModelLifecycle) Preconditions.checkNotNull(viewModelLifecycle);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ViewModelComponentBuilder
        public BoxApplication_HiltComponents.ViewModelC build() {
            Preconditions.checkBuilderRequirement(this.savedStateHandle, SavedStateHandle.class);
            Preconditions.checkBuilderRequirement(this.viewModelLifecycle, ViewModelLifecycle.class);
            return new ViewModelCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.savedStateHandle, this.viewModelLifecycle);
        }
    }

    private static final class ServiceCBuilder implements BoxApplication_HiltComponents.ServiceC.Builder {
        private Service service;
        private final SingletonCImpl singletonCImpl;

        private ServiceCBuilder(SingletonCImpl singletonCImpl) {
            this.singletonCImpl = singletonCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ServiceComponentBuilder
        public ServiceCBuilder service(Service service) {
            this.service = (Service) Preconditions.checkNotNull(service);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ServiceComponentBuilder
        public BoxApplication_HiltComponents.ServiceC build() {
            Preconditions.checkBuilderRequirement(this.service, Service.class);
            return new ServiceCImpl(this.singletonCImpl, this.service);
        }
    }

    private static final class ViewWithFragmentCImpl extends BoxApplication_HiltComponents.ViewWithFragmentC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final SingletonCImpl singletonCImpl;
        private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

        ViewWithFragmentCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, FragmentCImpl fragmentCImpl, View viewParam) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
            this.fragmentCImpl = fragmentCImpl;
        }
    }

    private static final class FragmentCImpl extends BoxApplication_HiltComponents.FragmentC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        Provider<AutoUploadSwitchListener.Factory> factoryProvider;
        private final FragmentCImpl fragmentCImpl = this;
        private final SingletonCImpl singletonCImpl;

        @Override // com.box.android.capture.fragments.CaptureSettingsFragment_GeneratedInjector
        public void injectCaptureSettingsFragment(CaptureSettingsFragment arg0) {
        }

        @Override // com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment_GeneratedInjector
        public void injectCollectionsMultiSelectDialogFragment(CollectionsMultiSelectDialogFragment arg0) {
        }

        FragmentCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, Fragment fragmentParam) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
            initialize(fragmentParam);
        }

        PushNotificationSettingsViewModelFactory pushNotificationSettingsViewModelFactory() {
            return new PushNotificationSettingsViewModelFactory(this.singletonCImpl.notificationCategoriesInteractor());
        }

        MfaCallbackIntentHandler mfaCallbackIntentHandler() {
            return new MfaCallbackIntentHandler(new MfaSetupAnalytics());
        }

        TasksVMFactory tasksVMFactory() {
            return new TasksVMFactory(this.singletonCImpl.provideTasksRepoProvider.get());
        }

        private void initialize(final Fragment fragmentParam) {
            this.factoryProvider = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl, 0));
        }

        @Override // com.box.android.activities.settings.SettingsNotificationsFragment_GeneratedInjector
        public void injectSettingsNotificationsFragment(SettingsNotificationsFragment arg0) {
            injectSettingsNotificationsFragment2(arg0);
        }

        @Override // com.box.android.autoupload.AutoContentUploadFragment_GeneratedInjector
        public void injectAutoContentUploadFragment(AutoContentUploadFragment arg0) {
            injectAutoContentUploadFragment2(arg0);
        }

        @Override // com.box.android.base.FeatureFlipsToggleFragment_GeneratedInjector
        public void injectFeatureFlipsToggleFragment(FeatureFlipsToggleFragment arg0) {
            injectFeatureFlipsToggleFragment2(arg0);
        }

        @Override // com.box.android.base.presentation.fragments.EmptyFragmentWithCallbackOnResume_GeneratedInjector
        public void injectEmptyFragmentWithCallbackOnResume(EmptyFragmentWithCallbackOnResume arg0) {
            injectEmptyFragmentWithCallbackOnResume2(arg0);
        }

        @Override // com.box.android.base.presentation.fragments.LibraryFragment_GeneratedInjector
        public void injectLibraryFragment(LibraryFragment arg0) {
            injectLibraryFragment2(arg0);
        }

        @Override // com.box.android.base.presentation.fragments.ShowFTUXDialogFragment_GeneratedInjector
        public void injectShowFTUXDialogFragment(ShowFTUXDialogFragment arg0) {
            injectShowFTUXDialogFragment2(arg0);
        }

        @Override // com.box.android.base.presentation.views.menu.BookmarkSheetFragment_GeneratedInjector
        public void injectBookmarkSheetFragment(BookmarkSheetFragment arg0) {
            injectBookmarkSheetFragment2(arg0);
        }

        @Override // com.box.android.base.presentation.views.menu.FileSheetFragment_GeneratedInjector
        public void injectFileSheetFragment(FileSheetFragment arg0) {
            injectFileSheetFragment2(arg0);
        }

        @Override // com.box.android.base.presentation.views.menu.FolderSheetFragment_GeneratedInjector
        public void injectFolderSheetFragment(FolderSheetFragment arg0) {
            injectFolderSheetFragment2(arg0);
        }

        @Override // com.box.android.base.presentation.views.menu.NotificationsFilterFragment_GeneratedInjector
        public void injectNotificationsFilterFragment(NotificationsFilterFragment arg0) {
            injectNotificationsFilterFragment2(arg0);
        }

        @Override // com.box.android.base.presentation.views.menu.PushNotificationSheetFragment_GeneratedInjector
        public void injectPushNotificationSheetFragment(PushNotificationSheetFragment arg0) {
            injectPushNotificationSheetFragment2(arg0);
        }

        @Override // com.box.android.base.presentation.views.menu.RecentItemsFilterFragment_GeneratedInjector
        public void injectRecentItemsFilterFragment(RecentItemsFilterFragment arg0) {
            injectRecentItemsFilterFragment2(arg0);
        }

        @Override // com.box.android.base.presentation.views.menu.SortSheetFragment_GeneratedInjector
        public void injectSortSheetFragment(SortSheetFragment arg0) {
            injectSortSheetFragment2(arg0);
        }

        @Override // com.box.android.base.presentation.views.menu.UploadOptionsFragment_GeneratedInjector
        public void injectUploadOptionsFragment(UploadOptionsFragment arg0) {
            injectUploadOptionsFragment2(arg0);
        }

        @Override // com.box.android.browse.cpl.browse.fab.newfile.NewFileMenuFragment_GeneratedInjector
        public void injectNewFileMenuFragment(NewFileMenuFragment arg0) {
            injectNewFileMenuFragment2(arg0);
        }

        @Override // com.box.android.browse.fragments.SearchFragment_GeneratedInjector
        public void injectSearchFragment(SearchFragment arg0) {
            injectSearchFragment2(arg0);
        }

        @Override // com.box.android.capture.CaptureErrorFragment_GeneratedInjector
        public void injectCaptureErrorFragment(CaptureErrorFragment arg0) {
            injectCaptureErrorFragment2(arg0);
        }

        @Override // com.box.android.capture.CaptureHistoryFragment_GeneratedInjector
        public void injectCaptureHistoryFragment(CaptureHistoryFragment arg0) {
            injectCaptureHistoryFragment2(arg0);
        }

        @Override // com.box.android.capture.ImageCaptureHostFragment_GeneratedInjector
        public void injectImageCaptureHostFragment(ImageCaptureHostFragment arg0) {
            injectImageCaptureHostFragment2(arg0);
        }

        @Override // com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingHostFragment_GeneratedInjector
        public void injectAudioRecordingHostFragment(AudioRecordingHostFragment arg0) {
            injectAudioRecordingHostFragment2(arg0);
        }

        @Override // com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedFragment_GeneratedInjector
        public void injectAudioRecordingIntegratedFragment(AudioRecordingIntegratedFragment arg0) {
            injectAudioRecordingIntegratedFragment2(arg0);
        }

        @Override // com.box.android.capture.audiorecording.presentation.integrated.AudioRecordingIntegratedReviewFragment_GeneratedInjector
        public void injectAudioRecordingIntegratedReviewFragment(AudioRecordingIntegratedReviewFragment arg0) {
            injectAudioRecordingIntegratedReviewFragment2(arg0);
        }

        @Override // com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment_GeneratedInjector
        public void injectDocumentScanningHostFragment(DocumentScanningHostFragment arg0) {
            injectDocumentScanningHostFragment2(arg0);
        }

        @Override // com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment_GeneratedInjector
        public void injectIntegratedDocumentScanEditFragment(IntegratedDocumentScanEditFragment arg0) {
            injectIntegratedDocumentScanEditFragment2(arg0);
        }

        @Override // com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanFragment_GeneratedInjector
        public void injectIntegratedDocumentScanFragment(IntegratedDocumentScanFragment arg0) {
            injectIntegratedDocumentScanFragment2(arg0);
        }

        @Override // com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment_GeneratedInjector
        public void injectIntegratedDocumentScanReviewFragment(IntegratedDocumentScanReviewFragment arg0) {
            injectIntegratedDocumentScanReviewFragment2(arg0);
        }

        @Override // com.box.android.capture.imagecapture.presentation.CameraPreviewFragment_GeneratedInjector
        public void injectCameraPreviewFragment(CameraPreviewFragment arg0) {
            injectCameraPreviewFragment2(arg0);
        }

        @Override // com.box.android.capture.imagecapture.presentation.PhotoReviewFragment_GeneratedInjector
        public void injectPhotoReviewFragment(PhotoReviewFragment arg0) {
            injectPhotoReviewFragment2(arg0);
        }

        @Override // com.box.android.capture.videorecording.presentation.VideoCaptureHostFragment_GeneratedInjector
        public void injectVideoCaptureHostFragment(VideoCaptureHostFragment arg0) {
            injectVideoCaptureHostFragment2(arg0);
        }

        @Override // com.box.android.capture.videorecording.presentation.VideoRecordingFragment_GeneratedInjector
        public void injectVideoRecordingFragment(VideoRecordingFragment arg0) {
            injectVideoRecordingFragment2(arg0);
        }

        @Override // com.box.android.capture.videorecording.presentation.VideoReviewFragment_GeneratedInjector
        public void injectVideoReviewFragment(VideoReviewFragment arg0) {
            injectVideoReviewFragment2(arg0);
        }

        @Override // com.box.android.collections.presentation.fragments.CollectionItemsFragment_GeneratedInjector
        public void injectCollectionItemsFragment(CollectionItemsFragment arg0) {
            injectCollectionItemsFragment2(arg0);
        }

        @Override // com.box.android.collections.presentation.fragments.CollectionsTabFragment_GeneratedInjector
        public void injectCollectionsTabFragment(CollectionsTabFragment arg0) {
            injectCollectionsTabFragment2(arg0);
        }

        @Override // com.box.android.collections.presentation.fragments.FavoritesCollectionItemsFragment_GeneratedInjector
        public void injectFavoritesCollectionItemsFragment(FavoritesCollectionItemsFragment arg0) {
            injectFavoritesCollectionItemsFragment2(arg0);
        }

        @Override // com.box.android.collections.presentation.fragments.MyCollectionsFragment_GeneratedInjector
        public void injectMyCollectionsFragment(MyCollectionsFragment arg0) {
            injectMyCollectionsFragment2(arg0);
        }

        @Override // com.box.android.fragments.ChooseAuthenticationFragment_GeneratedInjector
        public void injectChooseAuthenticationFragment(ChooseAuthenticationFragment arg0) {
            injectChooseAuthenticationFragment2(arg0);
        }

        @Override // com.box.android.fragments.EmailSupportFragment_GeneratedInjector
        public void injectEmailSupportFragment(EmailSupportFragment arg0) {
            injectEmailSupportFragment2(arg0);
        }

        @Override // com.box.android.fragments.NavigationTabFragment_GeneratedInjector
        public void injectNavigationTabFragment(NavigationTabFragment arg0) {
            injectNavigationTabFragment2(arg0);
        }

        @Override // com.box.android.fragments.NotificationsTasksTabFragment_GeneratedInjector
        public void injectNotificationsTasksTabFragment(NotificationsTasksTabFragment arg0) {
            injectNotificationsTasksTabFragment2(arg0);
        }

        @Override // com.box.android.fragments.PushRegistrationDialogFragment_GeneratedInjector
        public void injectPushRegistrationDialogFragment(PushRegistrationDialogFragment arg0) {
            injectPushRegistrationDialogFragment2(arg0);
        }

        @Override // com.box.android.fragments.boxitem.InboxFragment_GeneratedInjector
        public void injectInboxFragment(InboxFragment arg0) {
            injectInboxFragment2(arg0);
        }

        @Override // com.box.android.fragments.boxitem.MyTasksFragment_GeneratedInjector
        public void injectMyTasksFragment(MyTasksFragment arg0) {
            injectMyTasksFragment2(arg0);
        }

        @Override // com.box.android.fragments.boxitem.PushNotificationsFragment_GeneratedInjector
        public void injectPushNotificationsFragment(PushNotificationsFragment arg0) {
            injectPushNotificationsFragment2(arg0);
        }

        @Override // com.box.android.fragments.boxitem.SentTasksFragment_GeneratedInjector
        public void injectSentTasksFragment(SentTasksFragment arg0) {
            injectSentTasksFragment2(arg0);
        }

        @Override // com.box.android.fragments.boxitem.SingleTaskFragment_GeneratedInjector
        public void injectSingleTaskFragment(SingleTaskFragment arg0) {
            injectSingleTaskFragment2(arg0);
        }

        @Override // com.box.android.fragments.boxitem.TaskCollaboratorsFragment_GeneratedInjector
        public void injectTaskCollaboratorsFragment(TaskCollaboratorsFragment arg0) {
            injectTaskCollaboratorsFragment2(arg0);
        }

        @Override // com.box.android.hubs.presentation.HubsFragment_GeneratedInjector
        public void injectHubsFragment(HubsFragment arg0) {
            injectHubsFragment2(arg0);
        }

        @Override // dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories.FragmentEntryPoint
        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
            return this.activityCImpl.getHiltInternalFactoryFactory();
        }

        @Override // dagger.hilt.android.internal.managers.ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
            return new ViewWithFragmentCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl);
        }

        private SettingsNotificationsFragment injectSettingsNotificationsFragment2(SettingsNotificationsFragment instance) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance, this.singletonCImpl.userContextManagerProvider.get());
            SettingsNotificationsFragment_MembersInjector.injectMPushNotificationSettingsViewModelFactory(instance, pushNotificationSettingsViewModelFactory());
            SettingsNotificationsFragment_MembersInjector.injectMGlobalSettings(instance, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            SettingsNotificationsFragment_MembersInjector.injectMFeatureFlips(instance, this.singletonCImpl.featureFlipsProvider.get());
            SettingsNotificationsFragment_MembersInjector.injectUserContextManager(instance, this.singletonCImpl.userContextManagerProvider.get());
            return instance;
        }

        private AutoContentUploadFragment injectAutoContentUploadFragment2(AutoContentUploadFragment instance2) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance2, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance2, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance2, this.singletonCImpl.userContextManagerProvider.get());
            AutoContentUploadFragment_MembersInjector.injectMFolderApi(instance2, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            AutoContentUploadFragment_MembersInjector.injectMFeatureFlips(instance2, this.singletonCImpl.featureFlipsProvider.get());
            AutoContentUploadFragment_MembersInjector.injectMLocalItemService(instance2, this.singletonCImpl.localItemServiceProvider.get());
            AutoContentUploadFragment_MembersInjector.injectFactory(instance2, this.factoryProvider.get());
            return instance2;
        }

        private FeatureFlipsToggleFragment injectFeatureFlipsToggleFragment2(FeatureFlipsToggleFragment instance3) {
            FeatureFlipsToggleFragment_MembersInjector.injectFeatureFlips(instance3, this.singletonCImpl.featureFlipsProvider.get());
            return instance3;
        }

        private EmptyFragmentWithCallbackOnResume injectEmptyFragmentWithCallbackOnResume2(EmptyFragmentWithCallbackOnResume instance4) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance4, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance4, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance4, this.singletonCImpl.userContextManagerProvider.get());
            return instance4;
        }

        private LibraryFragment injectLibraryFragment2(LibraryFragment instance5) {
            BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(instance5, this.singletonCImpl.userContextManagerProvider.get());
            BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(instance5, this.singletonCImpl.featureFlipsProvider.get());
            return instance5;
        }

        private ShowFTUXDialogFragment injectShowFTUXDialogFragment2(ShowFTUXDialogFragment instance6) {
            ShowFTUXDialogFragment_MembersInjector.injectMUserContextManager(instance6, this.singletonCImpl.userContextManagerProvider.get());
            ShowFTUXDialogFragment_MembersInjector.injectMIntentServices(instance6, new AppIntentServices());
            ShowFTUXDialogFragment_MembersInjector.injectFtuxFactory(instance6, this.activityCImpl.fTUXFactory());
            return instance6;
        }

        private BookmarkSheetFragment injectBookmarkSheetFragment2(BookmarkSheetFragment instance7) {
            BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(instance7, this.singletonCImpl.userContextManagerProvider.get());
            BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(instance7, this.singletonCImpl.featureFlipsProvider.get());
            return instance7;
        }

        private FileSheetFragment injectFileSheetFragment2(FileSheetFragment instance8) {
            BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(instance8, this.singletonCImpl.userContextManagerProvider.get());
            BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(instance8, this.singletonCImpl.featureFlipsProvider.get());
            FileSheetFragment_MembersInjector.injectMThumbnailManager(instance8, this.singletonCImpl.thumbnailManagerProvider.get());
            FileSheetFragment_MembersInjector.injectMGetBoxAiAvailabilityUseCase(instance8, this.singletonCImpl.getBoxAiAvailabilityInteractor());
            FileSheetFragment_MembersInjector.injectMFeatureFlips(instance8, this.singletonCImpl.featureFlipsProvider.get());
            return instance8;
        }

        private FolderSheetFragment injectFolderSheetFragment2(FolderSheetFragment instance9) {
            BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(instance9, this.singletonCImpl.userContextManagerProvider.get());
            BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(instance9, this.singletonCImpl.featureFlipsProvider.get());
            FolderSheetFragment_MembersInjector.injectMFeatureFlips(instance9, this.singletonCImpl.featureFlipsProvider.get());
            return instance9;
        }

        private NotificationsFilterFragment injectNotificationsFilterFragment2(NotificationsFilterFragment instance10) {
            BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(instance10, this.singletonCImpl.userContextManagerProvider.get());
            BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(instance10, this.singletonCImpl.featureFlipsProvider.get());
            return instance10;
        }

        private PushNotificationSheetFragment injectPushNotificationSheetFragment2(PushNotificationSheetFragment instance11) {
            BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(instance11, this.singletonCImpl.userContextManagerProvider.get());
            BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(instance11, this.singletonCImpl.featureFlipsProvider.get());
            PushNotificationSheetFragment_MembersInjector.injectMBoxExtendedApiFile(instance11, this.singletonCImpl.provideBoxApiFileProvider.get());
            PushNotificationSheetFragment_MembersInjector.injectMThumbnailManager(instance11, this.singletonCImpl.thumbnailManagerProvider.get());
            PushNotificationSheetFragment_MembersInjector.injectMUserContextManager(instance11, this.singletonCImpl.userContextManagerProvider.get());
            return instance11;
        }

        private RecentItemsFilterFragment injectRecentItemsFilterFragment2(RecentItemsFilterFragment instance12) {
            BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(instance12, this.singletonCImpl.userContextManagerProvider.get());
            BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(instance12, this.singletonCImpl.featureFlipsProvider.get());
            return instance12;
        }

        private SortSheetFragment injectSortSheetFragment2(SortSheetFragment instance13) {
            BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(instance13, this.singletonCImpl.userContextManagerProvider.get());
            BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(instance13, this.singletonCImpl.featureFlipsProvider.get());
            SortSheetFragment_MembersInjector.injectMSortPrefs(instance13, this.singletonCImpl.providesSortPreferencesProvider.get());
            SortSheetFragment_MembersInjector.injectMBaseMoco(instance13, this.singletonCImpl.baseModelController());
            return instance13;
        }

        private UploadOptionsFragment injectUploadOptionsFragment2(UploadOptionsFragment instance14) {
            BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(instance14, this.singletonCImpl.userContextManagerProvider.get());
            BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(instance14, this.singletonCImpl.featureFlipsProvider.get());
            return instance14;
        }

        private NewFileMenuFragment injectNewFileMenuFragment2(NewFileMenuFragment instance15) {
            BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(instance15, this.singletonCImpl.userContextManagerProvider.get());
            BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(instance15, this.singletonCImpl.featureFlipsProvider.get());
            NewFileMenuFragment_MembersInjector.injectMIntentServices(instance15, new AppIntentServices());
            return instance15;
        }

        private SearchFragment injectSearchFragment2(SearchFragment instance16) {
            BoxBrowseFragment_MembersInjector.injectMController(instance16, this.singletonCImpl.providesBrowseControllerProvider.get());
            BoxBrowseFragment_MembersInjector.injectMThumbnailManager(instance16, this.singletonCImpl.thumbnailManagerProvider.get());
            BoxBrowseFragment_MembersInjector.injectGen204PerformanceLogger(instance16, this.singletonCImpl.gen204PerformanceLoggerProvider.get());
            BoxBrowseFragment_MembersInjector.injectFeatureFlips(instance16, this.singletonCImpl.featureFlipsProvider.get());
            SearchFragment_MembersInjector.injectMBaseMoco(instance16, this.singletonCImpl.baseModelController());
            SearchFragment_MembersInjector.injectMTimeLogHelper(instance16, DefaultModule_Companion_ProvideTimeLogHelperFactory.provideTimeLogHelper());
            return instance16;
        }

        private CaptureErrorFragment injectCaptureErrorFragment2(CaptureErrorFragment instance17) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance17, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance17, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance17, this.singletonCImpl.userContextManagerProvider.get());
            return instance17;
        }

        private CaptureHistoryFragment injectCaptureHistoryFragment2(CaptureHistoryFragment instance18) {
            CaptureHistoryFragment_MembersInjector.injectThumbnailManager(instance18, this.singletonCImpl.thumbnailManagerProvider.get());
            CaptureHistoryFragment_MembersInjector.injectFeatureFlips(instance18, this.singletonCImpl.featureFlipsProvider.get());
            CaptureHistoryFragment_MembersInjector.injectUserContextManager(instance18, this.singletonCImpl.userContextManagerProvider.get());
            CaptureHistoryFragment_MembersInjector.injectOfflineService(instance18, this.singletonCImpl.offlineService());
            CaptureHistoryFragment_MembersInjector.injectOfflineManagerWrapper(instance18, this.singletonCImpl.boxModelOfflineManagerWrapper());
            return instance18;
        }

        private ImageCaptureHostFragment injectImageCaptureHostFragment2(ImageCaptureHostFragment instance19) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance19, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance19, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance19, this.singletonCImpl.userContextManagerProvider.get());
            return instance19;
        }

        private AudioRecordingHostFragment injectAudioRecordingHostFragment2(AudioRecordingHostFragment instance20) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance20, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance20, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance20, this.singletonCImpl.userContextManagerProvider.get());
            return instance20;
        }

        private AudioRecordingIntegratedFragment injectAudioRecordingIntegratedFragment2(AudioRecordingIntegratedFragment instance21) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance21, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance21, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance21, this.singletonCImpl.userContextManagerProvider.get());
            AudioRecordingIntegratedFragment_MembersInjector.injectAudioRecordingHelper(instance21, new AudioRecordingHelper());
            return instance21;
        }

        private AudioRecordingIntegratedReviewFragment injectAudioRecordingIntegratedReviewFragment2(AudioRecordingIntegratedReviewFragment instance22) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance22, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance22, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance22, this.singletonCImpl.userContextManagerProvider.get());
            return instance22;
        }

        private DocumentScanningHostFragment injectDocumentScanningHostFragment2(DocumentScanningHostFragment instance23) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance23, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance23, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance23, this.singletonCImpl.userContextManagerProvider.get());
            return instance23;
        }

        private IntegratedDocumentScanEditFragment injectIntegratedDocumentScanEditFragment2(IntegratedDocumentScanEditFragment instance24) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance24, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance24, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance24, this.singletonCImpl.userContextManagerProvider.get());
            return instance24;
        }

        private IntegratedDocumentScanFragment injectIntegratedDocumentScanFragment2(IntegratedDocumentScanFragment instance25) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance25, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance25, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance25, this.singletonCImpl.userContextManagerProvider.get());
            return instance25;
        }

        private IntegratedDocumentScanReviewFragment injectIntegratedDocumentScanReviewFragment2(IntegratedDocumentScanReviewFragment instance26) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance26, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance26, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance26, this.singletonCImpl.userContextManagerProvider.get());
            return instance26;
        }

        private CameraPreviewFragment injectCameraPreviewFragment2(CameraPreviewFragment instance27) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance27, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance27, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance27, this.singletonCImpl.userContextManagerProvider.get());
            return instance27;
        }

        private PhotoReviewFragment injectPhotoReviewFragment2(PhotoReviewFragment instance28) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance28, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance28, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance28, this.singletonCImpl.userContextManagerProvider.get());
            return instance28;
        }

        private VideoCaptureHostFragment injectVideoCaptureHostFragment2(VideoCaptureHostFragment instance29) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance29, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance29, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance29, this.singletonCImpl.userContextManagerProvider.get());
            return instance29;
        }

        private VideoRecordingFragment injectVideoRecordingFragment2(VideoRecordingFragment instance30) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance30, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance30, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance30, this.singletonCImpl.userContextManagerProvider.get());
            return instance30;
        }

        private VideoReviewFragment injectVideoReviewFragment2(VideoReviewFragment instance31) {
            BoxFragment_MembersInjector.injectMBaseModelController(instance31, this.singletonCImpl.baseModelController());
            BoxFragment_MembersInjector.injectMBoxApiUser(instance31, this.singletonCImpl.provideBoxApiUserProvider.get());
            BoxFragment_MembersInjector.injectMUserContextManager(instance31, this.singletonCImpl.userContextManagerProvider.get());
            return instance31;
        }

        private CollectionItemsFragment injectCollectionItemsFragment2(CollectionItemsFragment instance32) {
            CollectionItemsFragment_MembersInjector.injectUserContextManager(instance32, this.singletonCImpl.userContextManagerProvider.get());
            CollectionItemsFragment_MembersInjector.injectThumbnailManager(instance32, this.singletonCImpl.thumbnailManagerProvider.get());
            CollectionItemsFragment_MembersInjector.injectFeatureFlips(instance32, this.singletonCImpl.featureFlipsProvider.get());
            CollectionItemsFragment_MembersInjector.injectCollectionsHelper(instance32, new CollectionsHelper());
            return instance32;
        }

        private CollectionsTabFragment injectCollectionsTabFragment2(CollectionsTabFragment instance33) {
            TabLayoutFragment_MembersInjector.injectMUserContextManager(instance33, this.singletonCImpl.userContextManagerProvider.get());
            return instance33;
        }

        private FavoritesCollectionItemsFragment injectFavoritesCollectionItemsFragment2(FavoritesCollectionItemsFragment instance34) {
            FavoritesCollectionItemsFragment_MembersInjector.injectUserContextManager(instance34, this.singletonCImpl.userContextManagerProvider.get());
            FavoritesCollectionItemsFragment_MembersInjector.injectThumbnailManager(instance34, this.singletonCImpl.thumbnailManagerProvider.get());
            FavoritesCollectionItemsFragment_MembersInjector.injectFeatureFlips(instance34, this.singletonCImpl.featureFlipsProvider.get());
            return instance34;
        }

        private MyCollectionsFragment injectMyCollectionsFragment2(MyCollectionsFragment instance35) {
            MyCollectionsFragment_MembersInjector.injectIntentServices(instance35, new AppIntentServices());
            return instance35;
        }

        private ChooseAuthenticationFragment injectChooseAuthenticationFragment2(ChooseAuthenticationFragment instance36) {
            ChooseAuthenticationFragment_MembersInjector.injectMGlobalSettings(instance36, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            return instance36;
        }

        private EmailSupportFragment injectEmailSupportFragment2(EmailSupportFragment instance37) {
            EmailSupportFragment_MembersInjector.injectMUserContextManager(instance37, this.singletonCImpl.userContextManagerProvider.get());
            return instance37;
        }

        private NavigationTabFragment injectNavigationTabFragment2(NavigationTabFragment instance38) {
            TabLayoutFragment_MembersInjector.injectMUserContextManager(instance38, this.singletonCImpl.userContextManagerProvider.get());
            NavigationTabFragment_MembersInjector.injectMFeatureFlips(instance38, this.singletonCImpl.featureFlipsProvider.get());
            NavigationTabFragment_MembersInjector.injectBrowseFragmentFactory(instance38, new BrowseFragmentFactory());
            return instance38;
        }

        private NotificationsTasksTabFragment injectNotificationsTasksTabFragment2(NotificationsTasksTabFragment instance39) {
            TabLayoutFragment_MembersInjector.injectMUserContextManager(instance39, this.singletonCImpl.userContextManagerProvider.get());
            return instance39;
        }

        private PushRegistrationDialogFragment injectPushRegistrationDialogFragment2(PushRegistrationDialogFragment instance40) {
            PushRegistrationDialogFragment_MembersInjector.injectMGlobalSettings(instance40, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            return instance40;
        }

        private InboxFragment injectInboxFragment2(InboxFragment instance41) {
            InboxFragment_MembersInjector.injectUserContextManager(instance41, this.singletonCImpl.userContextManagerProvider.get());
            InboxFragment_MembersInjector.injectInboxRouter(instance41, this.singletonCImpl.inboxRouter());
            InboxFragment_MembersInjector.injectRoutingMapper(instance41, new InboxNotificationRoutingMapper());
            InboxFragment_MembersInjector.injectMfaCallbackIntentHandler(instance41, mfaCallbackIntentHandler());
            return instance41;
        }

        private MyTasksFragment injectMyTasksFragment2(MyTasksFragment instance42) {
            TasksFragment_MembersInjector.injectMUserContextManager(instance42, this.singletonCImpl.userContextManagerProvider.get());
            TasksFragment_MembersInjector.injectMBoxExtendedApiFile(instance42, this.singletonCImpl.provideBoxApiFileProvider.get());
            TasksFragment_MembersInjector.injectMFeatureFlips(instance42, this.singletonCImpl.featureFlipsProvider.get());
            MyTasksFragment_MembersInjector.injectMTasksVMFactory(instance42, tasksVMFactory());
            return instance42;
        }

        private PushNotificationsFragment injectPushNotificationsFragment2(PushNotificationsFragment instance43) {
            PushNotificationsFragment_MembersInjector.injectMBaseMoco(instance43, this.singletonCImpl.baseModelController());
            PushNotificationsFragment_MembersInjector.injectMBoxApiPrivate(instance43, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            PushNotificationsFragment_MembersInjector.injectMUserContextManager(instance43, this.singletonCImpl.userContextManagerProvider.get());
            return instance43;
        }

        private SentTasksFragment injectSentTasksFragment2(SentTasksFragment instance44) {
            TasksFragment_MembersInjector.injectMUserContextManager(instance44, this.singletonCImpl.userContextManagerProvider.get());
            TasksFragment_MembersInjector.injectMBoxExtendedApiFile(instance44, this.singletonCImpl.provideBoxApiFileProvider.get());
            TasksFragment_MembersInjector.injectMFeatureFlips(instance44, this.singletonCImpl.featureFlipsProvider.get());
            SentTasksFragment_MembersInjector.injectMTasksVMFactory(instance44, tasksVMFactory());
            return instance44;
        }

        private SingleTaskFragment injectSingleTaskFragment2(SingleTaskFragment instance45) {
            TasksFragment_MembersInjector.injectMUserContextManager(instance45, this.singletonCImpl.userContextManagerProvider.get());
            TasksFragment_MembersInjector.injectMBoxExtendedApiFile(instance45, this.singletonCImpl.provideBoxApiFileProvider.get());
            TasksFragment_MembersInjector.injectMFeatureFlips(instance45, this.singletonCImpl.featureFlipsProvider.get());
            return instance45;
        }

        private TaskCollaboratorsFragment injectTaskCollaboratorsFragment2(TaskCollaboratorsFragment instance46) {
            TaskCollaboratorsFragment_MembersInjector.injectMUserContextManager(instance46, this.singletonCImpl.userContextManagerProvider.get());
            return instance46;
        }

        private HubsFragment injectHubsFragment2(HubsFragment instance47) {
            HubsFragment_MembersInjector.injectIntentServices(instance47, new AppIntentServices());
            return instance47;
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityCImpl activityCImpl;
            private final ActivityRetainedCImpl activityRetainedCImpl;
            private final FragmentCImpl fragmentCImpl;
            private final int id;
            private final SingletonCImpl singletonCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, FragmentCImpl fragmentCImpl, int id) {
                this.singletonCImpl = singletonCImpl;
                this.activityRetainedCImpl = activityRetainedCImpl;
                this.activityCImpl = activityCImpl;
                this.fragmentCImpl = fragmentCImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                if (this.id == 0) {
                    return (T) new AutoUploadSwitchListener.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.FragmentCImpl.SwitchingProvider.1
                        @Override // com.box.android.autoupload.AutoUploadSwitchListener.Factory
                        public AutoUploadSwitchListener createListener(FragmentActivity activity, Function1<? super Boolean, Unit> onAutoUploadStatusChanged, Function0<Unit> resetSwitchState) {
                            return new AutoUploadSwitchListener(activity, onAutoUploadStatusChanged, resetSwitchState, SwitchingProvider.this.singletonCImpl.userContextManagerProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get());
                        }
                    };
                }
                throw new AssertionError(this.id);
            }
        }
    }

    private static final class ViewCImpl extends BoxApplication_HiltComponents.ViewC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;
        private final ViewCImpl viewCImpl = this;

        ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, View viewParam) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }

        @Override // com.box.android.capture.CaptureHistoryButtonView_GeneratedInjector
        public void injectCaptureHistoryButtonView(CaptureHistoryButtonView arg0) {
            injectCaptureHistoryButtonView2(arg0);
        }

        private CaptureHistoryButtonView injectCaptureHistoryButtonView2(CaptureHistoryButtonView instance) {
            CaptureHistoryButtonView_MembersInjector.injectThumbnailManager(instance, this.singletonCImpl.thumbnailManagerProvider.get());
            return instance;
        }
    }

    private static final class ActivityCImpl extends BoxApplication_HiltComponents.ActivityC {
        private final ActivityCImpl activityCImpl = this;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        Provider<FabHelper.Factory> factoryProvider;
        Provider<BoxSearchItemClickHandler.Factory> factoryProvider2;
        Provider<RootInnerNavigatorsProviderFactory.Factory> factoryProvider3;
        Provider<HomeScreenInnerNavigatorsProviderFactory.Factory> factoryProvider4;
        private final SingletonCImpl singletonCImpl;

        ActivityCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            initialize(activityParam);
        }

        ClientSettingsInitialisation clientSettingsInitialisation() {
            return new ClientSettingsInitialisation(this.singletonCImpl.clientSettingsService(), this.singletonCImpl.geniusScanLicenseService(), this.singletonCImpl.provideRumServiceProvider.get(), this.singletonCImpl.featureFlipsProvider.get());
        }

        FeatureFlipDeepLinkHandler featureFlipDeepLinkHandler() {
            return new FeatureFlipDeepLinkHandler(this.singletonCImpl.featureFlipsProvider.get());
        }

        FabManager fabManager() {
            return new FabManager(new AppIntentServices(), this.singletonCImpl.featureFlipsProvider.get(), this.singletonCImpl.resolveNewNoteDataInteractor());
        }

        UploadHelper uploadHelper() {
            return new UploadHelper(this.singletonCImpl.remoteItemService(), this.singletonCImpl.localItemServiceProvider.get(), this.singletonCImpl.userContextManagerProvider.get(), CommonModule_ProvidesDefaultDispatcherFactory.providesDefaultDispatcher(), CommonModule_ProvidesMainDispatcherFactory.providesMainDispatcher());
        }

        BaseFTUX.FTUXFactory fTUXFactory() {
            return new BaseFTUX.FTUXFactory(this.singletonCImpl.userContextManagerProvider.get());
        }

        FTUXMessageReceiverHelper fTUXMessageReceiverHelper() {
            return new FTUXMessageReceiverHelper(fTUXFactory());
        }

        FolderViewInteractor folderViewInteractor() {
            return new FolderViewInteractor(this.singletonCImpl.remoteItemService(), this.singletonCImpl.itemSorter());
        }

        ItemThumbnailEnvironment itemThumbnailEnvironment() {
            return new ItemThumbnailEnvironment(this.singletonCImpl.thumbnailManagerProvider.get(), this.singletonCImpl.hubsService());
        }

        BoxFeatureBannerUtils boxFeatureBannerUtils() {
            return new BoxFeatureBannerUtils(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.appInBackgroundServiceProvider.get());
        }

        MultiselectEnvironment multiselectEnvironment() {
            return new MultiselectEnvironment(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.boxAccountManagerHelper(), this.activityRetainedCImpl.selectionManagerProvider.get());
        }

        BrowseAnalytics browseAnalytics() {
            return new BrowseAnalytics(this.singletonCImpl.baseModelController(), this.singletonCImpl.provideBoxExtendedApiFolderProvider.get(), this.singletonCImpl.userContextManagerProvider.get());
        }

        AppStartApdexTracker appStartApdexTracker() {
            return new AppStartApdexTracker(this.singletonCImpl.providesApdexServiceProvider.get(), this.singletonCImpl.providesAppStartTargetHolderProvider.get());
        }

        ItemModelStateMapper itemModelStateMapper() {
            return new ItemModelStateMapper(this.singletonCImpl.boxModelOfflineManagerWrapper(), this.singletonCImpl.thumbnailManagerProvider.get());
        }

        FolderViewEnvironment folderViewEnvironment() {
            return new FolderViewEnvironment(folderViewInteractor(), itemThumbnailEnvironment(), this.singletonCImpl.gen204PerformanceLoggerProvider.get(), boxFeatureBannerUtils(), this.singletonCImpl.userContextManagerProvider.get(), multiselectEnvironment(), browseAnalytics(), this.singletonCImpl.sessionManagerProvider.get(), this.singletonCImpl.metricsInteractorProvider.get(), this.singletonCImpl.providesApdexServiceProvider.get(), appStartApdexTracker(), itemModelStateMapper(), this.singletonCImpl.boxModelOfflineManagerWrapper(), CommonModule_ProvidesDefaultDispatcherFactory.providesDefaultDispatcher(), this.singletonCImpl.providesSortPreferencesProvider.get());
        }

        OfflineFilesEnvironment offlineFilesEnvironment() {
            return new OfflineFilesEnvironment(this.singletonCImpl.fileActionsManager(), this.singletonCImpl.offlineService());
        }

        DownloadEnvironment downloadEnvironment() {
            return new DownloadEnvironment(this.singletonCImpl.fileActionsManager(), this.singletonCImpl.jobManagerProvider.get(), this.singletonCImpl.featureFlipsProvider.get(), this.singletonCImpl.localItemServiceProvider.get());
        }

        VoiceInputEnvironment voiceInputEnvironment() {
            return new VoiceInputEnvironment(this.singletonCImpl.speechRecognitionManager());
        }

        BoxAiEnvironment boxAiEnvironment() {
            return new BoxAiEnvironment(this.singletonCImpl.boxAiService(), this.singletonCImpl.clipboardService(), new BoxAiAnalytics(), this.singletonCImpl.boxAiObservabilityProvider.get(), this.singletonCImpl.featureFlipsProvider.get(), this.singletonCImpl.boxAccountSettings(), voiceInputEnvironment(), new PermissionsHandler(), this.singletonCImpl.fileActionsManager(), this.singletonCImpl.getBoxAiAvailabilityInteractor());
        }

        ActionableFolderViewEnvironment actionableFolderViewEnvironment() {
            return new ActionableFolderViewEnvironment(folderViewEnvironment(), browseAnalytics(), this.singletonCImpl.boxAccountManagerHelper(), this.singletonCImpl.fileActionsManager(), offlineFilesEnvironment(), downloadEnvironment(), boxAiEnvironment());
        }

        NewFileMenuUtils newFileMenuUtils() {
            return new NewFileMenuUtils(this.singletonCImpl.provideApplicationContextProvider.get());
        }

        FilesFabEnvironment filesFabEnvironment() {
            return new FilesFabEnvironment(fabManager(), this.singletonCImpl.userContextManagerProvider.get(), uploadHelper(), newFileMenuUtils(), new FilesFabAnalytics());
        }

        CreateFolderEnvironment createFolderEnvironment() {
            return new CreateFolderEnvironment(this.singletonCImpl.createFolderInteractor(), this.singletonCImpl.createFolderHelper(), new ItemNameValidator());
        }

        BrowseEnvironment browseEnvironment() {
            return new BrowseEnvironment(actionableFolderViewEnvironment(), filesFabEnvironment(), browseAnalytics(), this.singletonCImpl.folderInteractor(), this.singletonCImpl.userContextManagerProvider.get(), createFolderEnvironment(), this.singletonCImpl.providesApdexServiceProvider.get());
        }

        MainPhoneEnvironment mainPhoneEnvironment() {
            return new MainPhoneEnvironment(browseEnvironment(), this.singletonCImpl.configManagerProvider.get(), this.singletonCImpl.userContextManagerProvider.get());
        }

        MainPhoneViewModel.Factory mainPhoneViewModelFactory() {
            return new MainPhoneViewModel.Factory(mainPhoneEnvironment(), new BrowseSavedStateBuilder(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
        }

        DeviceIntegrityVerifier deviceIntegrityVerifier() {
            return new DeviceIntegrityVerifier(BoxModule_Companion_ProvideIntegrityAPICallerFactory.provideIntegrityAPICaller());
        }

        FilesAndFoldersFragmentFactory filesAndFoldersFragmentFactory() {
            return new FilesAndFoldersFragmentFactory(this.singletonCImpl.filesAndFoldersSettingsStoreFactory());
        }

        UpdateSharedLinkPasswordErrorConverter updateSharedLinkPasswordErrorConverter() {
            return new UpdateSharedLinkPasswordErrorConverter(this.singletonCImpl.provideMoshiProvider.get());
        }

        NavigationBottomBar navigationBottomBar() {
            return new NavigationBottomBar(this.singletonCImpl.featureFlipsProvider.get(), this.singletonCImpl.boxAccountSettings(), this.singletonCImpl.userContextManagerProvider.get());
        }

        UpdatesManager updatesManager() {
            return new UpdatesManager(this.singletonCImpl.forceUpdateEvaluatorProvider.get(), this.singletonCImpl.appUpdateProposalManagerProvider.get());
        }

        MainNavigationTargetConfigFactory mainNavigationTargetConfigFactory() {
            return new MainNavigationTargetConfigFactory(this.singletonCImpl.getFavoritesCollectionIdInteractor(), this.singletonCImpl.featureFlipsProvider.get(), this.singletonCImpl.boxAccountSettings());
        }

        CanvasAuthorizer canvasAuthorizer() {
            return new CanvasAuthorizer(BoxModule_Companion_ProvideAuthorizerOkHttpClientFactory.provideAuthorizerOkHttpClient());
        }

        BoxCanvasIntentBuilder boxCanvasIntentBuilder() {
            return new BoxCanvasIntentBuilder(this.singletonCImpl.configManagerProvider.get(), canvasAuthorizer());
        }

        ForceUpdateDialogConfigProvider forceUpdateDialogConfigProvider() {
            return new ForceUpdateDialogConfigProvider(this.singletonCImpl.boxAccountSettings());
        }

        private void initialize(final Activity activityParam) {
            this.factoryProvider = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, 0));
            this.factoryProvider2 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, 2));
            this.factoryProvider3 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, 1));
            this.factoryProvider4 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, 3));
        }

        @Override // com.box.android.activities.AutoContentUploadPaywallActivity_GeneratedInjector
        public void injectAutoContentUploadPaywallActivity(AutoContentUploadPaywallActivity arg0) {
            injectAutoContentUploadPaywallActivity2(arg0);
        }

        @Override // com.box.android.activities.BetaFeedbackActivity_GeneratedInjector
        public void injectBetaFeedbackActivity(BetaFeedbackActivity arg0) {
            injectBetaFeedbackActivity2(arg0);
        }

        @Override // com.box.android.activities.BoxBetaFeatureFlips_GeneratedInjector
        public void injectBoxBetaFeatureFlips(BoxBetaFeatureFlips arg0) {
            injectBoxBetaFeatureFlips2(arg0);
        }

        @Override // com.box.android.activities.BoxItemShortcutActivity_GeneratedInjector
        public void injectBoxItemShortcutActivity(BoxItemShortcutActivity arg0) {
            injectBoxItemShortcutActivity2(arg0);
        }

        @Override // com.box.android.activities.CreateBoxItemShortcutActivity_GeneratedInjector
        public void injectCreateBoxItemShortcutActivity(CreateBoxItemShortcutActivity arg0) {
            injectCreateBoxItemShortcutActivity2(arg0);
        }

        @Override // com.box.android.activities.DeleteItemsActivity_GeneratedInjector
        public void injectDeleteItemsActivity(DeleteItemsActivity arg0) {
            injectDeleteItemsActivity2(arg0);
        }

        @Override // com.box.android.activities.EmailSupportActivity_GeneratedInjector
        public void injectEmailSupportActivity(EmailSupportActivity arg0) {
            injectEmailSupportActivity2(arg0);
        }

        @Override // com.box.android.activities.ExpiredVersionDialogActivity_GeneratedInjector
        public void injectExpiredVersionDialogActivity(ExpiredVersionDialogActivity arg0) {
            injectExpiredVersionDialogActivity2(arg0);
        }

        @Override // com.box.android.activities.InfoDialogActivity_GeneratedInjector
        public void injectInfoDialogActivity(InfoDialogActivity arg0) {
            injectInfoDialogActivity2(arg0);
        }

        @Override // com.box.android.activities.IntentProcessorGetContent_GeneratedInjector
        public void injectIntentProcessorGetContent(IntentProcessorGetContent arg0) {
            injectIntentProcessorGetContent2(arg0);
        }

        @Override // com.box.android.activities.IntentProcessorSend_GeneratedInjector
        public void injectIntentProcessorSend(IntentProcessorSend arg0) {
            injectIntentProcessorSend2(arg0);
        }

        @Override // com.box.android.activities.LogoutWarningActivity_GeneratedInjector
        public void injectLogoutWarningActivity(LogoutWarningActivity arg0) {
            injectLogoutWarningActivity2(arg0);
        }

        @Override // com.box.android.activities.MainPhone_GeneratedInjector
        public void injectMainPhone(MainPhone arg0) {
            injectMainPhone2(arg0);
        }

        @Override // com.box.android.activities.MfaCallbackActivity_GeneratedInjector
        public void injectMfaCallbackActivity(MfaCallbackActivity arg0) {
            injectMfaCallbackActivity2(arg0);
        }

        @Override // com.box.android.activities.NotificationInterceptorActivity_GeneratedInjector
        public void injectNotificationInterceptorActivity(NotificationInterceptorActivity arg0) {
            injectNotificationInterceptorActivity2(arg0);
        }

        @Override // com.box.android.activities.OpenFile_GeneratedInjector
        public void injectOpenFile(OpenFile arg0) {
            injectOpenFile2(arg0);
        }

        @Override // com.box.android.activities.RefreshDialogActivity_GeneratedInjector
        public void injectRefreshDialogActivity(RefreshDialogActivity arg0) {
            injectRefreshDialogActivity2(arg0);
        }

        @Override // com.box.android.activities.SwitchAccountActivity_GeneratedInjector
        public void injectSwitchAccountActivity(SwitchAccountActivity arg0) {
            injectSwitchAccountActivity2(arg0);
        }

        @Override // com.box.android.activities.SwitchingAccountDialogActivity_GeneratedInjector
        public void injectSwitchingAccountDialogActivity(SwitchingAccountDialogActivity arg0) {
            injectSwitchingAccountDialogActivity2(arg0);
        }

        @Override // com.box.android.activities.UploadOverwriteDialogActivity_GeneratedInjector
        public void injectUploadOverwriteDialogActivity(UploadOverwriteDialogActivity arg0) {
            injectUploadOverwriteDialogActivity2(arg0);
        }

        @Override // com.box.android.activities.addcontent.CreateDocumentTaskActivity_GeneratedInjector
        public void injectCreateDocumentTaskActivity(CreateDocumentTaskActivity arg0) {
            injectCreateDocumentTaskActivity2(arg0);
        }

        @Override // com.box.android.activities.addcontent.QuickNoteCreationActivity_GeneratedInjector
        public void injectQuickNoteCreationActivity(QuickNoteCreationActivity arg0) {
            injectQuickNoteCreationActivity2(arg0);
        }

        @Override // com.box.android.activities.filepicker.LocalFolderChooser_GeneratedInjector
        public void injectLocalFolderChooser(LocalFolderChooser arg0) {
            injectLocalFolderChooser2(arg0);
        }

        @Override // com.box.android.activities.filepicker.MainFilePicker_GeneratedInjector
        public void injectMainFilePicker(MainFilePicker arg0) {
            injectMainFilePicker2(arg0);
        }

        @Override // com.box.android.activities.login.BoxThirdPartyAuthenticatorActivity_GeneratedInjector
        public void injectBoxThirdPartyAuthenticatorActivity(BoxThirdPartyAuthenticatorActivity arg0) {
            injectBoxThirdPartyAuthenticatorActivity2(arg0);
        }

        @Override // com.box.android.activities.login.CustomOAuthActivity_GeneratedInjector
        public void injectCustomOAuthActivity(CustomOAuthActivity arg0) {
            injectCustomOAuthActivity2(arg0);
        }

        @Override // com.box.android.activities.login.StartScreenActivity_GeneratedInjector
        public void injectStartScreenActivity(StartScreenActivity arg0) {
            injectStartScreenActivity2(arg0);
        }

        @Override // com.box.android.activities.login.WopiOAuthActivity_GeneratedInjector
        public void injectWopiOAuthActivity(WopiOAuthActivity arg0) {
            injectWopiOAuthActivity2(arg0);
        }

        @Override // com.box.android.activities.settings.SettingsActivity_GeneratedInjector
        public void injectSettingsActivity(SettingsActivity arg0) {
            injectSettingsActivity2(arg0);
        }

        @Override // com.box.android.activities.share.UsxCollaborationsActivity_GeneratedInjector
        public void injectUsxCollaborationsActivity(UsxCollaborationsActivity arg0) {
            injectUsxCollaborationsActivity2(arg0);
        }

        @Override // com.box.android.activities.share.UsxInviteCollaboratorsActivity_GeneratedInjector
        public void injectUsxInviteCollaboratorsActivity(UsxInviteCollaboratorsActivity arg0) {
            injectUsxInviteCollaboratorsActivity2(arg0);
        }

        @Override // com.box.android.activities.share.UsxShareActivity_GeneratedInjector
        public void injectUsxShareActivity(UsxShareActivity arg0) {
            injectUsxShareActivity2(arg0);
        }

        @Override // com.box.android.activities.tasks.RenameTaskActivity_GeneratedInjector
        public void injectRenameTaskActivity(RenameTaskActivity arg0) {
            injectRenameTaskActivity2(arg0);
        }

        @Override // com.box.android.activities.tasks.SingleTaskActivity_GeneratedInjector
        public void injectSingleTaskActivity(SingleTaskActivity arg0) {
            injectSingleTaskActivity2(arg0);
        }

        @Override // com.box.android.activities.tasks.TaskCollaboratorsActivity_GeneratedInjector
        public void injectTaskCollaboratorsActivity(TaskCollaboratorsActivity arg0) {
            injectTaskCollaboratorsActivity2(arg0);
        }

        @Override // com.box.android.activities.urlsinterceptor.BoxNotesInterceptorActivity_GeneratedInjector
        public void injectBoxNotesInterceptorActivity(BoxNotesInterceptorActivity arg0) {
            injectBoxNotesInterceptorActivity2(arg0);
        }

        @Override // com.box.android.activities.urlsinterceptor.SharedLinkInterceptorActivity_GeneratedInjector
        public void injectSharedLinkInterceptorActivity(SharedLinkInterceptorActivity arg0) {
            injectSharedLinkInterceptorActivity2(arg0);
        }

        @Override // com.box.android.activities.urlsinterceptor.SharedLinkStopScreenActivity_GeneratedInjector
        public void injectSharedLinkStopScreenActivity(SharedLinkStopScreenActivity arg0) {
            injectSharedLinkStopScreenActivity2(arg0);
        }

        @Override // com.box.android.activities.urlsinterceptor.WebUrlsInterceptorActivity_GeneratedInjector
        public void injectWebUrlsInterceptorActivity(WebUrlsInterceptorActivity arg0) {
            injectWebUrlsInterceptorActivity2(arg0);
        }

        @Override // com.box.android.activities.urlsinterceptor.router.FileRouterActivity_GeneratedInjector
        public void injectFileRouterActivity(FileRouterActivity arg0) {
            injectFileRouterActivity2(arg0);
        }

        @Override // com.box.android.activities.urlsinterceptor.router.HubDetailsRouterActivity_GeneratedInjector
        public void injectHubDetailsRouterActivity(HubDetailsRouterActivity arg0) {
            injectHubDetailsRouterActivity2(arg0);
        }

        @Override // com.box.android.auth.AuthenticationActivity_GeneratedInjector
        public void injectAuthenticationActivity(AuthenticationActivity arg0) {
            injectAuthenticationActivity2(arg0);
        }

        @Override // com.box.android.base.presentation.activities.BoxFragmentActivity_GeneratedInjector
        public void injectBoxFragmentActivity(BoxFragmentActivity arg0) {
            injectBoxFragmentActivity2(arg0);
        }

        @Override // com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivity_GeneratedInjector
        public void injectBoxIntuneMAMAuthActivity(BoxIntuneMAMAuthActivity arg0) {
            injectBoxIntuneMAMAuthActivity2(arg0);
        }

        @Override // com.box.android.base.presentation.activities.CreatePincodeActivity_GeneratedInjector
        public void injectCreatePincodeActivity(CreatePincodeActivity arg0) {
            injectCreatePincodeActivity2(arg0);
        }

        @Override // com.box.android.base.presentation.activities.IntentChooserActivity_GeneratedInjector
        public void injectIntentChooserActivity(IntentChooserActivity arg0) {
            injectIntentChooserActivity2(arg0);
        }

        @Override // com.box.android.base.presentation.activities.NotificationPermissionRationaleActivity_GeneratedInjector
        public void injectNotificationPermissionRationaleActivity(NotificationPermissionRationaleActivity arg0) {
            injectNotificationPermissionRationaleActivity2(arg0);
        }

        @Override // com.box.android.base.presentation.activities.Pincode_GeneratedInjector
        public void injectPincode(Pincode arg0) {
            injectPincode2(arg0);
        }

        @Override // com.box.android.base.presentation.watermarking.WatermarkingActivity_GeneratedInjector
        public void injectWatermarkingActivity(WatermarkingActivity arg0) {
            injectWatermarkingActivity2(arg0);
        }

        @Override // com.box.android.boxai.AiCenterActivity_GeneratedInjector
        public void injectAiCenterActivity(AiCenterActivity arg0) {
            injectAiCenterActivity2(arg0);
        }

        @Override // com.box.android.browse.activities.FilterSearchResultsActivity_GeneratedInjector
        public void injectFilterSearchResultsActivity(FilterSearchResultsActivity arg0) {
            injectFilterSearchResultsActivity2(arg0);
        }

        @Override // com.box.android.browse.activities.FilterSearchResults_GeneratedInjector
        public void injectFilterSearchResults(FilterSearchResults arg0) {
            injectFilterSearchResults2(arg0);
        }

        @Override // com.box.android.browse.activities.UploadToFolderActivity_GeneratedInjector
        public void injectUploadToFolderActivity(UploadToFolderActivity arg0) {
            injectUploadToFolderActivity2(arg0);
        }

        @Override // com.box.android.browse.cpl.copymove.CopyOrMoveActivity_GeneratedInjector
        public void injectCopyOrMoveActivity(CopyOrMoveActivity arg0) {
            injectCopyOrMoveActivity2(arg0);
        }

        @Override // com.box.android.browse.cpl.itempicker.ItemPickerActivity_GeneratedInjector
        public void injectItemPickerActivity(ItemPickerActivity arg0) {
            injectItemPickerActivity2(arg0);
        }

        @Override // com.box.android.capture.activities.CaptureActivity_GeneratedInjector
        public void injectCaptureActivity(CaptureActivity arg0) {
            injectCaptureActivity2(arg0);
        }

        @Override // com.box.android.capture.activities.CaptureShortcutActivity_GeneratedInjector
        public void injectCaptureShortcutActivity(CaptureShortcutActivity arg0) {
            injectCaptureShortcutActivity2(arg0);
        }

        @Override // com.box.android.capture.activities.CreateCaptureShortcutActivity_GeneratedInjector
        public void injectCreateCaptureShortcutActivity(CreateCaptureShortcutActivity arg0) {
            injectCreateCaptureShortcutActivity2(arg0);
        }

        @Override // com.box.android.contentpicker.ContentPickerActivity_GeneratedInjector
        public void injectContentPickerActivity(ContentPickerActivity arg0) {
            injectContentPickerActivity2(arg0);
        }

        @Override // com.box.android.fileactivity.presentation.FileActivitiesActivity_GeneratedInjector
        public void injectFileActivitiesActivity(FileActivitiesActivity arg0) {
            injectFileActivitiesActivity2(arg0);
        }

        @Override // com.box.android.hubs.hubDetails.presentation.HubDetailsActivity_GeneratedInjector
        public void injectHubDetailsActivity(HubDetailsActivity arg0) {
            injectHubDetailsActivity2(arg0);
        }

        @Override // com.box.android.jobsui.JobsUIActivity_GeneratedInjector
        public void injectJobsUIActivity(JobsUIActivity arg0) {
            injectJobsUIActivity2(arg0);
        }

        @Override // com.box.android.navigation.Navigation_GeneratedInjector
        public void injectNavigation(Navigation arg0) {
            injectNavigation2(arg0);
        }

        @Override // com.box.android.navigationmodernization.MainActivity_GeneratedInjector
        public void injectMainActivity(MainActivity arg0) {
            injectMainActivity2(arg0);
        }

        @Override // com.box.android.preview.boxcanvas.BoxCanvasActivity_GeneratedInjector
        public void injectBoxCanvasActivity(BoxCanvasActivity arg0) {
            injectBoxCanvasActivity2(arg0);
        }

        @Override // com.box.android.preview.gallery.GalleryItemsActivity_GeneratedInjector
        public void injectGalleryItemsActivity(GalleryItemsActivity arg0) {
            injectGalleryItemsActivity2(arg0);
        }

        @Override // com.box.android.preview.iteminformation.ItemInformationActivity_GeneratedInjector
        public void injectItemInformationActivity(ItemInformationActivity arg0) {
            injectItemInformationActivity2(arg0);
        }

        @Override // com.box.android.preview.preview.PreviewActivity_GeneratedInjector
        public void injectPreviewActivity(PreviewActivity arg0) {
            injectPreviewActivity2(arg0);
        }

        @Override // com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistActivity_GeneratedInjector
        public void injectPreviewPlaylistActivity(PreviewPlaylistActivity arg0) {
            injectPreviewPlaylistActivity2(arg0);
        }

        @Override // com.box.android.preview.previousversion.PreviousVersionPreviewActivity_GeneratedInjector
        public void injectPreviousVersionPreviewActivity(PreviousVersionPreviewActivity arg0) {
            injectPreviousVersionPreviewActivity2(arg0);
        }

        @Override // com.box.android.search.presentation.SearchActivity_GeneratedInjector
        public void injectSearchActivity(SearchActivity arg0) {
            injectSearchActivity2(arg0);
        }

        @Override // com.box.android.tasks.addtask.activity.AddTaskActivity_GeneratedInjector
        public void injectAddTaskActivity(AddTaskActivity arg0) {
            injectAddTaskActivity2(arg0);
        }

        @Override // com.box.android.updates.force.ui.ForceUpdateActivity_GeneratedInjector
        public void injectForceUpdateActivity(ForceUpdateActivity arg0) {
            injectForceUpdateActivity2(arg0);
        }

        @Override // dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories.ActivityEntryPoint
        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
            return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(this.singletonCImpl, this.activityRetainedCImpl));
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ActivityCreatorEntryPoint
        public Map<Class<?>, Boolean> getViewModelKeys() {
            return LazyClassKeyMap.of(ImmutableMap.builderWithExpectedSize(57).put(AddTaskViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(AddTaskViewModel_HiltModules.KeyModule.provide())).put(AllFilesViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(AllFilesViewModel_HiltModules.KeyModule.provide())).put(AppUpdateProposalViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(AppUpdateProposalViewModel_HiltModules.KeyModule.provide())).put(BiometricsVM_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(BiometricsVM_HiltModules.KeyModule.provide())).put(BoxAiHomeViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(BoxAiHomeViewModel_HiltModules.KeyModule.provide())).put(BrowseTabsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(BrowseTabsViewModel_HiltModules.KeyModule.provide())).put(CaptureHistoryButtonViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CaptureHistoryButtonViewModel_HiltModules.KeyModule.provide())).put(CaptureHistoryViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CaptureHistoryViewModel_HiltModules.KeyModule.provide())).put(CaptureMediaHandlerViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CaptureMediaHandlerViewModel_HiltModules.KeyModule.provide())).put(CaptureSettingsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CaptureSettingsViewModel_HiltModules.KeyModule.provide())).put(CaptureViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CaptureViewModel_HiltModules.KeyModule.provide())).put(CollectionItemsListViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CollectionItemsListViewModel_HiltModules.KeyModule.provide())).put(CollectionItemsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CollectionItemsViewModel_HiltModules.KeyModule.provide())).put(CollectionMembershipsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CollectionMembershipsViewModel_HiltModules.KeyModule.provide())).put(CollectionsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CollectionsViewModel_HiltModules.KeyModule.provide())).put(ContentPickerViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ContentPickerViewModel_HiltModules.KeyModule.provide())).put(CopyOrMoveViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(CopyOrMoveViewModel_HiltModules.KeyModule.provide())).put(FavoritesCollectionItemsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(FavoritesCollectionItemsViewModel_HiltModules.KeyModule.provide())).put(FileActivitiesViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(FileActivitiesViewModel_HiltModules.KeyModule.provide())).put(FilesSearchViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(FilesSearchViewModel_HiltModules.KeyModule.provide())).put(FolderItemPickerViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(FolderItemPickerViewModel_HiltModules.KeyModule.provide())).put(GalleryItemsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(GalleryItemsViewModel_HiltModules.KeyModule.provide())).put(HomeScreenViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(HomeScreenViewModel_HiltModules.KeyModule.provide())).put(HubDetailsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(HubDetailsViewModel_HiltModules.KeyModule.provide())).put(HubsItemPickerViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(HubsItemPickerViewModel_HiltModules.KeyModule.provide())).put(HubsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(HubsViewModel_HiltModules.KeyModule.provide())).put(InboxBadgeVM_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(InboxBadgeVM_HiltModules.KeyModule.provide())).put(InboxCountViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(InboxCountViewModel_HiltModules.KeyModule.provide())).put(InboxTabsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(InboxTabsViewModel_HiltModules.KeyModule.provide())).put(InboxViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(InboxViewModel_HiltModules.KeyModule.provide())).put(ItemInformationViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ItemInformationViewModel_HiltModules.KeyModule.provide())).put(ItemPickerViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(ItemPickerViewModel_HiltModules.KeyModule.provide())).put(JobsProgressViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(JobsProgressViewModel_HiltModules.KeyModule.provide())).put(JobsUIViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(JobsUIViewModel_HiltModules.KeyModule.provide())).put(MainNavigationViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(MainNavigationViewModel_HiltModules.KeyModule.provide())).put(MyCollectionsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(MyCollectionsViewModel_HiltModules.KeyModule.provide())).put(NavigationViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(NavigationViewModel_HiltModules.KeyModule.provide())).put(NewNoteCreationViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(NewNoteCreationViewModel_HiltModules.KeyModule.provide())).put(NotesFavoritesViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(NotesFavoritesViewModel_HiltModules.KeyModule.provide())).put(NotesRecentsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(NotesRecentsViewModel_HiltModules.KeyModule.provide())).put(NotesSearchViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(NotesSearchViewModel_HiltModules.KeyModule.provide())).put(NotesTabsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(NotesTabsViewModel_HiltModules.KeyModule.provide())).put(OfflinedViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(OfflinedViewModel_HiltModules.KeyModule.provide())).put(PreviewPlaylistViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(PreviewPlaylistViewModel_HiltModules.KeyModule.provide())).put(PreviewViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(PreviewViewModel_HiltModules.KeyModule.provide())).put(PreviousVersionViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(PreviousVersionViewModel_HiltModules.KeyModule.provide())).put(PushRegistrationDialogVM_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(PushRegistrationDialogVM_HiltModules.KeyModule.provide())).put(RecentsItemPickerViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(RecentsItemPickerViewModel_HiltModules.KeyModule.provide())).put(RecentsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(RecentsViewModel_HiltModules.KeyModule.provide())).put(RecorderServiceViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(RecorderServiceViewModel_HiltModules.KeyModule.provide())).put(SearchItemPickerViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SearchItemPickerViewModel_HiltModules.KeyModule.provide())).put(SearchViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SearchViewModel_HiltModules.KeyModule.provide())).put(SingleTaskVM_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(SingleTaskVM_HiltModules.KeyModule.provide())).put(TaskCollaboratorsVM_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(TaskCollaboratorsVM_HiltModules.KeyModule.provide())).put(UploadContentHandlerViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(UploadContentHandlerViewModel_HiltModules.KeyModule.provide())).put(UserAvatarViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(UserAvatarViewModel_HiltModules.KeyModule.provide())).put(WatermarkingViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(WatermarkingViewModel_HiltModules.KeyModule.provide())).build());
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ActivityCreatorEntryPoint
        public ViewModelComponentBuilder getViewModelComponentBuilder() {
            return new ViewModelCBuilder(this.singletonCImpl, this.activityRetainedCImpl);
        }

        @Override // dagger.hilt.android.internal.managers.FragmentComponentManager.FragmentComponentBuilderEntryPoint
        public FragmentComponentBuilder fragmentComponentBuilder() {
            return new FragmentCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl);
        }

        @Override // dagger.hilt.android.internal.managers.ViewComponentManager.ViewComponentBuilderEntryPoint
        public ViewComponentBuilder viewComponentBuilder() {
            return new ViewCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl);
        }

        private AutoContentUploadPaywallActivity injectAutoContentUploadPaywallActivity2(AutoContentUploadPaywallActivity instance) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance;
        }

        private BetaFeedbackActivity injectBetaFeedbackActivity2(BetaFeedbackActivity instance2) {
            BetaFeedbackActivity_MembersInjector.injectUserContextManager(instance2, this.singletonCImpl.userContextManagerProvider.get());
            BetaFeedbackActivity_MembersInjector.injectBetaFeedbackManager(instance2, this.singletonCImpl.betaFeedbackManagerProvider.get());
            BetaFeedbackActivity_MembersInjector.injectBetaFeedbackEmailSender(instance2, this.singletonCImpl.betaFeedbackEmailSenderProvider.get());
            return instance2;
        }

        private BoxBetaFeatureFlips injectBoxBetaFeatureFlips2(BoxBetaFeatureFlips instance3) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance3, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance3, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance3, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance3, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance3, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance3, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance3, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance3, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance3, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance3, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance3, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance3, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance3, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance3, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance3, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance3, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance3, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance3, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance3, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance3, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance3, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance3, this.singletonCImpl.betaFeedbackManagerProvider.get());
            BoxBetaFeatureFlips_MembersInjector.injectDeepLinkHandler(instance3, featureFlipDeepLinkHandler());
            return instance3;
        }

        private BoxItemShortcutActivity injectBoxItemShortcutActivity2(BoxItemShortcutActivity instance4) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance4, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance4, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance4, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance4, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance4, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance4, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance4, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance4, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance4, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance4, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance4, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance4, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance4, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance4, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance4, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance4, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance4, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance4, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance4, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance4, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance4, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance4, this.singletonCImpl.betaFeedbackManagerProvider.get());
            BoxItemShortcutActivity_MembersInjector.injectMIntentServices(instance4, new AppIntentServices());
            return instance4;
        }

        private CreateBoxItemShortcutActivity injectCreateBoxItemShortcutActivity2(CreateBoxItemShortcutActivity instance5) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance5, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance5, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance5, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance5, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance5, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance5, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance5, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance5, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance5, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance5, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance5, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance5, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance5, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance5, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance5, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance5, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance5, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance5, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance5, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance5, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance5, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance5, this.singletonCImpl.betaFeedbackManagerProvider.get());
            CreateBoxItemShortcutActivity_MembersInjector.injectMThumbnailManager(instance5, this.singletonCImpl.thumbnailManagerProvider.get());
            return instance5;
        }

        private DeleteItemsActivity injectDeleteItemsActivity2(DeleteItemsActivity instance6) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance6, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance6, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance6, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance6, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance6, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance6, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance6, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance6, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance6, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance6, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance6, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance6, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance6, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance6, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance6, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance6, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance6, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance6, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance6, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance6, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance6, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance6, this.singletonCImpl.betaFeedbackManagerProvider.get());
            DeleteItemsActivity_MembersInjector.injectMBatchOperationsMoCo(instance6, this.singletonCImpl.providesIMoCoBatchOperationsProvider.get());
            DeleteItemsActivity_MembersInjector.injectMBookmarkApi(instance6, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            return instance6;
        }

        private EmailSupportActivity injectEmailSupportActivity2(EmailSupportActivity instance7) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance7, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance7, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance7, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance7, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance7, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance7, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance7, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance7, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance7, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance7, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance7, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance7, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance7, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance7, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance7, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance7, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance7, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance7, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance7, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance7, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance7, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance7, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance7;
        }

        private ExpiredVersionDialogActivity injectExpiredVersionDialogActivity2(ExpiredVersionDialogActivity instance8) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance8, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance8, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance8, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance8, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance8, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance8, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance8, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance8, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance8, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance8, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance8, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance8, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance8, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance8, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance8, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance8, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance8, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance8, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance8, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance8, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance8, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance8, this.singletonCImpl.betaFeedbackManagerProvider.get());
            ExpiredVersionDialogActivity_MembersInjector.injectMIntentServices(instance8, new AppIntentServices());
            return instance8;
        }

        private InfoDialogActivity injectInfoDialogActivity2(InfoDialogActivity instance9) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance9, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance9, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance9, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance9, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance9, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance9, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance9, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance9, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance9, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance9, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance9, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance9, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance9, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance9, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance9, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance9, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance9, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance9, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance9, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance9, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance9, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance9, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance9;
        }

        private IntentProcessorGetContent injectIntentProcessorGetContent2(IntentProcessorGetContent instance10) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance10, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance10, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance10, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance10, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance10, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance10, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance10, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance10, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance10, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance10, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance10, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance10, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance10, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance10, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance10, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance10, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance10, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance10, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance10, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance10, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance10, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance10, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance10;
        }

        private IntentProcessorSend injectIntentProcessorSend2(IntentProcessorSend instance11) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance11, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance11, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance11, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance11, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance11, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance11, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance11, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance11, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance11, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance11, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance11, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance11, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance11, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance11, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance11, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance11, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance11, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance11, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance11, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance11, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance11, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance11, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance11;
        }

        private LogoutWarningActivity injectLogoutWarningActivity2(LogoutWarningActivity instance12) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance12, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance12, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance12, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance12, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance12, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance12, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance12, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance12, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance12, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance12, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance12, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance12, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance12, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance12, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance12, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance12, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance12, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance12, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance12, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance12, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance12, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance12, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance12;
        }

        private MainPhone injectMainPhone2(MainPhone instance13) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance13, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance13, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance13, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance13, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance13, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance13, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance13, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance13, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance13, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance13, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance13, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance13, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance13, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance13, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance13, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance13, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance13, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance13, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance13, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance13, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance13, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance13, this.singletonCImpl.betaFeedbackManagerProvider.get());
            MainParent_MembersInjector.injectMAdminSettingsModelController(instance13, this.singletonCImpl.provideIMoCoAdminSettingsProvider.get());
            MainParent_MembersInjector.injectMBoxApiUser(instance13, this.singletonCImpl.provideBoxApiUserProvider.get());
            MainParent_MembersInjector.injectMBrowseController(instance13, this.singletonCImpl.providesBrowseControllerProvider.get());
            MainParent_MembersInjector.injectMApiPreviewPrivate(instance13, this.singletonCImpl.provideBoxExtendedApiPreviewProvider.get());
            MainParent_MembersInjector.injectMJobManager(instance13, this.singletonCImpl.jobManagerProvider.get());
            MainParent_MembersInjector.injectMJobService(instance13, this.singletonCImpl.jobServiceProvider.get());
            MainParent_MembersInjector.injectMTransfersHelper(instance13, new TransfersHelper());
            MainParent_MembersInjector.injectMFabHelperFactory(instance13, this.factoryProvider.get());
            MainParent_MembersInjector.injectLocalItemService(instance13, this.singletonCImpl.localItemServiceProvider.get());
            MainParent_MembersInjector.injectBoxAdminSettingsProvider(instance13, this.singletonCImpl.boxAdminSettingsProvider());
            MainParent_MembersInjector.injectMUploadHelper(instance13, uploadHelper());
            MainParent_MembersInjector.injectMIntentServices(instance13, new AppIntentServices());
            MainParent_MembersInjector.injectFtuxMessageReceiverHelper(instance13, fTUXMessageReceiverHelper());
            MainParent_MembersInjector.injectAppUpdateProposalManager(instance13, this.singletonCImpl.appUpdateProposalManagerProvider.get());
            MainParent_MembersInjector.injectMOfflineMigrationService(instance13, this.singletonCImpl.offlineMigrationServiceProvider.get());
            MainParent_MembersInjector.injectMOfflineStateStorage(instance13, this.singletonCImpl.offlineStateStorageProvider.get());
            MainParent_MembersInjector.injectMOfflineFilesPolicyEnforcer(instance13, this.singletonCImpl.offlineFilesPolicyEnforcer());
            MainParent_MembersInjector.injectMItemActionHandlerFactory(instance13, this.singletonCImpl.factoryProvider23.get());
            MainParent_MembersInjector.injectMSearchActionLogHelper(instance13, DefaultModule_Companion_ProvideSearchActionLogHelperFactory.provideSearchActionLogHelper());
            MainPhone_MembersInjector.injectMainPhoneViewModelFactory(instance13, mainPhoneViewModelFactory());
            MainPhone_MembersInjector.injectMainPhoneBrowseToolbarHelper(instance13, new MainPhoneBrowseToolbarHelper());
            MainPhone_MembersInjector.injectIntentServices(instance13, new AppIntentServices());
            MainPhone_MembersInjector.injectCopyOrMoveHelper(instance13, new CopyOrMoveHelper());
            MainPhone_MembersInjector.injectBrowseFragmentFactory(instance13, new BrowseFragmentFactory());
            return instance13;
        }

        private MfaCallbackActivity injectMfaCallbackActivity2(MfaCallbackActivity instance14) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance14, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance14, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance14, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance14, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance14, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance14, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance14, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance14, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance14, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance14, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance14, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance14, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance14, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance14, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance14, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance14, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance14, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance14, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance14, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance14, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance14, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance14, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance14;
        }

        private NotificationInterceptorActivity injectNotificationInterceptorActivity2(NotificationInterceptorActivity instance15) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance15, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance15, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance15, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance15, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance15, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance15, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance15, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance15, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance15, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance15, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance15, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance15, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance15, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance15, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance15, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance15, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance15, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance15, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance15, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance15, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance15, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance15, this.singletonCImpl.betaFeedbackManagerProvider.get());
            NotificationInterceptorActivity_MembersInjector.injectMApiPrivate(instance15, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            NotificationInterceptorActivity_MembersInjector.injectMIntentServices(instance15, new AppIntentServices());
            NotificationInterceptorActivity_MembersInjector.injectPreviewLauncher(instance15, this.singletonCImpl.previewLauncher());
            return instance15;
        }

        private OpenFile injectOpenFile2(OpenFile instance16) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance16, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance16, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance16, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance16, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance16, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance16, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance16, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance16, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance16, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance16, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance16, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance16, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance16, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance16, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance16, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance16, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance16, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance16, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance16, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance16, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance16, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance16, this.singletonCImpl.betaFeedbackManagerProvider.get());
            OpenFile_MembersInjector.injectMMoCoBoxTransfers(instance16, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            return instance16;
        }

        private RefreshDialogActivity injectRefreshDialogActivity2(RefreshDialogActivity instance17) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance17, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance17, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance17, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance17, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance17, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance17, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance17, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance17, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance17, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance17, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance17, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance17, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance17, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance17, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance17, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance17, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance17, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance17, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance17, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance17, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance17, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance17, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance17;
        }

        private SwitchAccountActivity injectSwitchAccountActivity2(SwitchAccountActivity instance18) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance18, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance18, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance18, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance18, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance18, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance18, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance18, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance18, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance18, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance18, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance18, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance18, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance18, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance18, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance18, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance18, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance18, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance18, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance18, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance18, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance18, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance18, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance18;
        }

        private SwitchingAccountDialogActivity injectSwitchingAccountDialogActivity2(SwitchingAccountDialogActivity instance19) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance19, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance19, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance19, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance19, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance19, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance19, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance19, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance19, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance19, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance19, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance19, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance19, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance19, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance19, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance19, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance19, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance19, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance19, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance19, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance19, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance19, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance19, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance19;
        }

        private UploadOverwriteDialogActivity injectUploadOverwriteDialogActivity2(UploadOverwriteDialogActivity instance20) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance20, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance20, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance20, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance20, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance20, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance20, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance20, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance20, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance20, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance20, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance20, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance20, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance20, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance20, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance20, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance20, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance20, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance20, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance20, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance20, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance20, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance20, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance20;
        }

        private CreateDocumentTaskActivity injectCreateDocumentTaskActivity2(CreateDocumentTaskActivity instance21) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance21, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance21, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance21, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance21, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance21, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance21, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance21, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance21, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance21, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance21, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance21, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance21, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance21, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance21, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance21, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance21, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance21, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance21, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance21, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance21, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance21, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance21, this.singletonCImpl.betaFeedbackManagerProvider.get());
            CreateDocumentTaskActivity_MembersInjector.injectItemClickHandlerFactory(instance21, this.singletonCImpl.factoryProvider22.get());
            CreateDocumentTaskActivity_MembersInjector.injectBveManager(instance21, this.singletonCImpl.bVEManager());
            return instance21;
        }

        private QuickNoteCreationActivity injectQuickNoteCreationActivity2(QuickNoteCreationActivity instance22) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance22, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance22, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance22, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance22, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance22, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance22, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance22, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance22, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance22, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance22, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance22, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance22, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance22, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance22, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance22, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance22, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance22, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance22, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance22, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance22, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance22, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance22, this.singletonCImpl.betaFeedbackManagerProvider.get());
            QuickNoteCreationActivity_MembersInjector.injectItemClickHandlerFactory(instance22, this.singletonCImpl.factoryProvider22.get());
            QuickNoteCreationActivity_MembersInjector.injectBveManager(instance22, this.singletonCImpl.bVEManager());
            return instance22;
        }

        private LocalFolderChooser injectLocalFolderChooser2(LocalFolderChooser instance23) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance23, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance23, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance23, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance23, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance23, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance23, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance23, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance23, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance23, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance23, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance23, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance23, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance23, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance23, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance23, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance23, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance23, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance23, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance23, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance23, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance23, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance23, this.singletonCImpl.betaFeedbackManagerProvider.get());
            LocalFolderChooser_MembersInjector.injectMocoBoxTransfers(instance23, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            LocalFolderChooser_MembersInjector.injectBrowseController(instance23, this.singletonCImpl.providesBrowseControllerProvider.get());
            LocalFolderChooser_MembersInjector.injectUserContextManager(instance23, this.singletonCImpl.userContextManagerProvider.get());
            LocalFolderChooser_MembersInjector.injectGetThumbnailService(instance23, this.singletonCImpl.thumbnailServiceProvider.get());
            return instance23;
        }

        private MainFilePicker injectMainFilePicker2(MainFilePicker instance24) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance24, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance24, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance24, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance24, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance24, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance24, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance24, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance24, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance24, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance24, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance24, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance24, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance24, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance24, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance24, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance24, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance24, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance24, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance24, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance24, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance24, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance24, this.singletonCImpl.betaFeedbackManagerProvider.get());
            MainParent_MembersInjector.injectMAdminSettingsModelController(instance24, this.singletonCImpl.provideIMoCoAdminSettingsProvider.get());
            MainParent_MembersInjector.injectMBoxApiUser(instance24, this.singletonCImpl.provideBoxApiUserProvider.get());
            MainParent_MembersInjector.injectMBrowseController(instance24, this.singletonCImpl.providesBrowseControllerProvider.get());
            MainParent_MembersInjector.injectMApiPreviewPrivate(instance24, this.singletonCImpl.provideBoxExtendedApiPreviewProvider.get());
            MainParent_MembersInjector.injectMJobManager(instance24, this.singletonCImpl.jobManagerProvider.get());
            MainParent_MembersInjector.injectMJobService(instance24, this.singletonCImpl.jobServiceProvider.get());
            MainParent_MembersInjector.injectMTransfersHelper(instance24, new TransfersHelper());
            MainParent_MembersInjector.injectMFabHelperFactory(instance24, this.factoryProvider.get());
            MainParent_MembersInjector.injectLocalItemService(instance24, this.singletonCImpl.localItemServiceProvider.get());
            MainParent_MembersInjector.injectBoxAdminSettingsProvider(instance24, this.singletonCImpl.boxAdminSettingsProvider());
            MainParent_MembersInjector.injectMUploadHelper(instance24, uploadHelper());
            MainParent_MembersInjector.injectMIntentServices(instance24, new AppIntentServices());
            MainParent_MembersInjector.injectFtuxMessageReceiverHelper(instance24, fTUXMessageReceiverHelper());
            MainParent_MembersInjector.injectAppUpdateProposalManager(instance24, this.singletonCImpl.appUpdateProposalManagerProvider.get());
            MainParent_MembersInjector.injectMOfflineMigrationService(instance24, this.singletonCImpl.offlineMigrationServiceProvider.get());
            MainParent_MembersInjector.injectMOfflineStateStorage(instance24, this.singletonCImpl.offlineStateStorageProvider.get());
            MainParent_MembersInjector.injectMOfflineFilesPolicyEnforcer(instance24, this.singletonCImpl.offlineFilesPolicyEnforcer());
            MainParent_MembersInjector.injectMItemActionHandlerFactory(instance24, this.singletonCImpl.factoryProvider23.get());
            MainParent_MembersInjector.injectMSearchActionLogHelper(instance24, DefaultModule_Companion_ProvideSearchActionLogHelperFactory.provideSearchActionLogHelper());
            MainPhone_MembersInjector.injectMainPhoneViewModelFactory(instance24, mainPhoneViewModelFactory());
            MainPhone_MembersInjector.injectMainPhoneBrowseToolbarHelper(instance24, new MainPhoneBrowseToolbarHelper());
            MainPhone_MembersInjector.injectIntentServices(instance24, new AppIntentServices());
            MainPhone_MembersInjector.injectCopyOrMoveHelper(instance24, new CopyOrMoveHelper());
            MainPhone_MembersInjector.injectBrowseFragmentFactory(instance24, new BrowseFragmentFactory());
            return instance24;
        }

        private BoxThirdPartyAuthenticatorActivity injectBoxThirdPartyAuthenticatorActivity2(BoxThirdPartyAuthenticatorActivity instance25) {
            BoxThirdPartyAuthenticatorActivity_MembersInjector.injectMGlobalSettings(instance25, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxThirdPartyAuthenticatorActivity_MembersInjector.injectForceUpdateCoordinator(instance25, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            return instance25;
        }

        private CustomOAuthActivity injectCustomOAuthActivity2(CustomOAuthActivity instance26) {
            CustomOAuthActivity_MembersInjector.injectMRestrictionsManager(instance26, this.singletonCImpl.appRestrictionsManager2());
            CustomOAuthActivity_MembersInjector.injectAppIntentService(instance26, new AppIntentServices());
            CustomOAuthActivity_MembersInjector.injectMDeviceId(instance26, this.singletonCImpl.provideDeviceIdProvider.get());
            CustomOAuthActivity_MembersInjector.injectMUserContextManager(instance26, this.singletonCImpl.userContextManagerProvider.get());
            CustomOAuthActivity_MembersInjector.injectMApiPrivate(instance26, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            CustomOAuthActivity_MembersInjector.injectMAdminSettings(instance26, this.singletonCImpl.provideIMoCoAdminSettingsProvider.get());
            CustomOAuthActivity_MembersInjector.injectMConfigManager(instance26, this.singletonCImpl.configManagerProvider.get());
            CustomOAuthActivity_MembersInjector.injectMMetricsUseCase(instance26, this.singletonCImpl.metricsInteractorProvider.get());
            CustomOAuthActivity_MembersInjector.injectMObservabilityManager(instance26, new ObservabilitySettingsManager());
            CustomOAuthActivity_MembersInjector.injectDeviceIntegrityVerifier(instance26, deviceIntegrityVerifier());
            CustomOAuthActivity_MembersInjector.injectAuthRequestService(instance26, this.singletonCImpl.authenticationService());
            CustomOAuthActivity_MembersInjector.injectUserContextManager(instance26, this.singletonCImpl.userContextManagerProvider.get());
            CustomOAuthActivity_MembersInjector.injectBveManager(instance26, this.singletonCImpl.bVEManager());
            CustomOAuthActivity_MembersInjector.injectForceUpdateCoordinator(instance26, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            CustomOAuthActivity_MembersInjector.injectFeatureFlips(instance26, this.singletonCImpl.featureFlipsProvider.get());
            return instance26;
        }

        private StartScreenActivity injectStartScreenActivity2(StartScreenActivity instance27) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance27, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance27, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance27, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance27, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance27, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance27, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance27, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance27, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance27, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance27, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance27, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance27, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance27, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance27, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance27, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance27, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance27, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance27, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance27, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance27, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance27, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance27, this.singletonCImpl.betaFeedbackManagerProvider.get());
            StartScreenActivity_MembersInjector.injectMObservabilityManager(instance27, new ObservabilitySettingsManager());
            return instance27;
        }

        private WopiOAuthActivity injectWopiOAuthActivity2(WopiOAuthActivity instance28) {
            WopiOAuthActivity_MembersInjector.injectMUserContextManager(instance28, this.singletonCImpl.userContextManagerProvider.get());
            WopiOAuthActivity_MembersInjector.injectMBveManager(instance28, this.singletonCImpl.bVEManager());
            WopiOAuthActivity_MembersInjector.injectSetForceUpdateCoordinator(instance28, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            return instance28;
        }

        private SettingsActivity injectSettingsActivity2(SettingsActivity instance29) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance29, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance29, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance29, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance29, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance29, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance29, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance29, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance29, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance29, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance29, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance29, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance29, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance29, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance29, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance29, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance29, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance29, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance29, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance29, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance29, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance29, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance29, this.singletonCImpl.betaFeedbackManagerProvider.get());
            SettingsActivity_MembersInjector.injectCreateLogArchiveInteractor(instance29, this.singletonCImpl.createLogArchiveInteractor());
            SettingsActivity_MembersInjector.injectMJobManager(instance29, this.singletonCImpl.jobManagerProvider.get());
            SettingsActivity_MembersInjector.injectMJobService(instance29, this.singletonCImpl.jobServiceProvider.get());
            SettingsActivity_MembersInjector.injectFilesAndFoldersFragmentFactory(instance29, filesAndFoldersFragmentFactory());
            SettingsActivity_MembersInjector.injectSharedPreferences(instance29, this.singletonCImpl.provideGlobalSharedPreferencesProvider.get());
            SettingsActivity_MembersInjector.injectSplitConfiguration(instance29, this.singletonCImpl.splitConfigurationProvider.get());
            return instance29;
        }

        private UsxCollaborationsActivity injectUsxCollaborationsActivity2(UsxCollaborationsActivity instance30) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance30, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance30, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance30, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance30, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance30, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance30, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance30, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance30, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance30, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance30, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance30, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance30, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance30, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance30, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance30, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance30, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance30, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance30, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance30, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance30, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance30, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance30, this.singletonCImpl.betaFeedbackManagerProvider.get());
            UsxShareBaseActivity_MembersInjector.injectMLegacyCacheDataSource(instance30, this.singletonCImpl.legacyCacheDataSource());
            UsxShareBaseActivity_MembersInjector.injectMController(instance30, this.singletonCImpl.shareModelControllerProvider.get());
            UsxShareBaseActivity_MembersInjector.injectUpdateSharedLinkPasswordErrorConverter(instance30, updateSharedLinkPasswordErrorConverter());
            return instance30;
        }

        private UsxInviteCollaboratorsActivity injectUsxInviteCollaboratorsActivity2(UsxInviteCollaboratorsActivity instance31) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance31, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance31, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance31, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance31, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance31, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance31, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance31, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance31, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance31, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance31, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance31, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance31, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance31, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance31, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance31, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance31, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance31, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance31, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance31, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance31, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance31, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance31, this.singletonCImpl.betaFeedbackManagerProvider.get());
            UsxShareBaseActivity_MembersInjector.injectMLegacyCacheDataSource(instance31, this.singletonCImpl.legacyCacheDataSource());
            UsxShareBaseActivity_MembersInjector.injectMController(instance31, this.singletonCImpl.shareModelControllerProvider.get());
            UsxShareBaseActivity_MembersInjector.injectUpdateSharedLinkPasswordErrorConverter(instance31, updateSharedLinkPasswordErrorConverter());
            return instance31;
        }

        private UsxShareActivity injectUsxShareActivity2(UsxShareActivity instance32) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance32, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance32, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance32, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance32, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance32, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance32, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance32, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance32, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance32, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance32, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance32, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance32, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance32, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance32, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance32, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance32, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance32, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance32, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance32, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance32, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance32, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance32, this.singletonCImpl.betaFeedbackManagerProvider.get());
            UsxShareBaseActivity_MembersInjector.injectMLegacyCacheDataSource(instance32, this.singletonCImpl.legacyCacheDataSource());
            UsxShareBaseActivity_MembersInjector.injectMController(instance32, this.singletonCImpl.shareModelControllerProvider.get());
            UsxShareBaseActivity_MembersInjector.injectUpdateSharedLinkPasswordErrorConverter(instance32, updateSharedLinkPasswordErrorConverter());
            return instance32;
        }

        private RenameTaskActivity injectRenameTaskActivity2(RenameTaskActivity instance33) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance33, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance33, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance33, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance33, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance33, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance33, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance33, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance33, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance33, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance33, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance33, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance33, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance33, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance33, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance33, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance33, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance33, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance33, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance33, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance33, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance33, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance33, this.singletonCImpl.betaFeedbackManagerProvider.get());
            RenameTaskActivity_MembersInjector.injectUpdateItemInfoService(instance33, this.singletonCImpl.updateItemInfoService());
            return instance33;
        }

        private SingleTaskActivity injectSingleTaskActivity2(SingleTaskActivity instance34) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance34, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance34, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance34, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance34, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance34, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance34, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance34, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance34, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance34, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance34, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance34, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance34, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance34, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance34, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance34, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance34, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance34, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance34, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance34, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance34, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance34, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance34, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance34;
        }

        private TaskCollaboratorsActivity injectTaskCollaboratorsActivity2(TaskCollaboratorsActivity instance35) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance35, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance35, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance35, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance35, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance35, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance35, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance35, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance35, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance35, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance35, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance35, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance35, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance35, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance35, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance35, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance35, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance35, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance35, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance35, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance35, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance35, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance35, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance35;
        }

        private BoxNotesInterceptorActivity injectBoxNotesInterceptorActivity2(BoxNotesInterceptorActivity instance36) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance36, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance36, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance36, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance36, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance36, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance36, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance36, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance36, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance36, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance36, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance36, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance36, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance36, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance36, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance36, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance36, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance36, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance36, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance36, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance36, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance36, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance36, this.singletonCImpl.betaFeedbackManagerProvider.get());
            SharedLinkInterceptorActivity_MembersInjector.injectMIntentServices(instance36, new AppIntentServices());
            SharedLinkInterceptorActivity_MembersInjector.injectMSharedLinkService(instance36, this.singletonCImpl.sharedLinkService());
            return instance36;
        }

        private SharedLinkInterceptorActivity injectSharedLinkInterceptorActivity2(SharedLinkInterceptorActivity instance37) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance37, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance37, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance37, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance37, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance37, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance37, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance37, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance37, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance37, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance37, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance37, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance37, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance37, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance37, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance37, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance37, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance37, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance37, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance37, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance37, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance37, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance37, this.singletonCImpl.betaFeedbackManagerProvider.get());
            SharedLinkInterceptorActivity_MembersInjector.injectMIntentServices(instance37, new AppIntentServices());
            SharedLinkInterceptorActivity_MembersInjector.injectMSharedLinkService(instance37, this.singletonCImpl.sharedLinkService());
            return instance37;
        }

        private SharedLinkStopScreenActivity injectSharedLinkStopScreenActivity2(SharedLinkStopScreenActivity instance38) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance38, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance38, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance38, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance38, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance38, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance38, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance38, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance38, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance38, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance38, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance38, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance38, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance38, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance38, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance38, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance38, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance38, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance38, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance38, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance38, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance38, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance38, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance38;
        }

        private WebUrlsInterceptorActivity injectWebUrlsInterceptorActivity2(WebUrlsInterceptorActivity instance39) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance39, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance39, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance39, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance39, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance39, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance39, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance39, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance39, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance39, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance39, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance39, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance39, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance39, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance39, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance39, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance39, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance39, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance39, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance39, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance39, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance39, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance39, this.singletonCImpl.betaFeedbackManagerProvider.get());
            WebUrlsInterceptorActivity_MembersInjector.injectMIntentServices(instance39, new AppIntentServices());
            WebUrlsInterceptorActivity_MembersInjector.injectMObservabilityManager(instance39, new ObservabilitySettingsManager());
            return instance39;
        }

        private FileRouterActivity injectFileRouterActivity2(FileRouterActivity instance40) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance40, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance40, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance40, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance40, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance40, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance40, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance40, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance40, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance40, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance40, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance40, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance40, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance40, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance40, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance40, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance40, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance40, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance40, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance40, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance40, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance40, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance40, this.singletonCImpl.betaFeedbackManagerProvider.get());
            FileRouterActivity_MembersInjector.injectMItemActionHandlerFactory(instance40, this.singletonCImpl.factoryProvider23.get());
            return instance40;
        }

        private HubDetailsRouterActivity injectHubDetailsRouterActivity2(HubDetailsRouterActivity instance41) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance41, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance41, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance41, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance41, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance41, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance41, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance41, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance41, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance41, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance41, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance41, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance41, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance41, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance41, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance41, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance41, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance41, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance41, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance41, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance41, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance41, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance41, this.singletonCImpl.betaFeedbackManagerProvider.get());
            HubDetailsRouterActivity_MembersInjector.injectIntentServices(instance41, new AppIntentServices());
            HubDetailsRouterActivity_MembersInjector.injectFeatureFlips(instance41, this.singletonCImpl.featureFlipsProvider.get());
            HubDetailsRouterActivity_MembersInjector.injectBoxAccountSettings(instance41, this.singletonCImpl.boxAccountSettings());
            return instance41;
        }

        private AuthenticationActivity injectAuthenticationActivity2(AuthenticationActivity instance42) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance42, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance42, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance42, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance42, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance42, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance42, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance42, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance42, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance42, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance42, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance42, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance42, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance42, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance42, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance42, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance42, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance42, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance42, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance42, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance42, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance42, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance42, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance42;
        }

        private BoxFragmentActivity injectBoxFragmentActivity2(BoxFragmentActivity instance43) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance43, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance43, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance43, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance43, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance43, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance43, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance43, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance43, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance43, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance43, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance43, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance43, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance43, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance43, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance43, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance43, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance43, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance43, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance43, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance43, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance43, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance43, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance43;
        }

        private BoxIntuneMAMAuthActivity injectBoxIntuneMAMAuthActivity2(BoxIntuneMAMAuthActivity instance44) {
            BoxIntuneMAMAuthActivity_MembersInjector.injectIntuneAuthManager(instance44, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxIntuneMAMAuthActivity_MembersInjector.injectAppIntentService(instance44, new AppIntentServices());
            BoxIntuneMAMAuthActivity_MembersInjector.injectAuthRequestService(instance44, this.singletonCImpl.authenticationService());
            BoxIntuneMAMAuthActivity_MembersInjector.injectUserContextManager(instance44, this.singletonCImpl.userContextManagerProvider.get());
            BoxIntuneMAMAuthActivity_MembersInjector.injectMsalObservability(instance44, this.singletonCImpl.msalObservabilityProvider.get());
            BoxIntuneMAMAuthActivity_MembersInjector.injectFeatureFlips(instance44, this.singletonCImpl.featureFlipsProvider.get());
            return instance44;
        }

        private CreatePincodeActivity injectCreatePincodeActivity2(CreatePincodeActivity instance45) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance45, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance45, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance45, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance45, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance45, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance45, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance45, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance45, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance45, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance45, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance45, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance45, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance45, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance45, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance45, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance45, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance45, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance45, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance45, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance45, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance45, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance45, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance45;
        }

        private IntentChooserActivity injectIntentChooserActivity2(IntentChooserActivity instance46) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance46, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance46, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance46, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance46, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance46, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance46, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance46, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance46, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance46, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance46, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance46, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance46, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance46, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance46, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance46, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance46, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance46, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance46, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance46, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance46, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance46, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance46, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance46;
        }

        private NotificationPermissionRationaleActivity injectNotificationPermissionRationaleActivity2(NotificationPermissionRationaleActivity instance47) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance47, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance47, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance47, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance47, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance47, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance47, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance47, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance47, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance47, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance47, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance47, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance47, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance47, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance47, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance47, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance47, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance47, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance47, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance47, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance47, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance47, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance47, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance47;
        }

        private Pincode injectPincode2(Pincode instance48) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance48, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance48, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance48, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance48, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance48, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance48, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance48, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance48, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance48, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance48, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance48, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance48, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance48, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance48, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance48, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance48, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance48, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance48, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance48, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance48, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance48, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance48, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance48;
        }

        private WatermarkingActivity injectWatermarkingActivity2(WatermarkingActivity instance49) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance49, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance49, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance49, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance49, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance49, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance49, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance49, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance49, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance49, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance49, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance49, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance49, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance49, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance49, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance49, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance49, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance49, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance49, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance49, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance49, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance49, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance49, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance49;
        }

        private AiCenterActivity injectAiCenterActivity2(AiCenterActivity instance50) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance50, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance50, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance50, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance50, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance50, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance50, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance50, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance50, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance50, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance50, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance50, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance50, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance50, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance50, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance50, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance50, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance50, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance50, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance50, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance50, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance50, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance50, this.singletonCImpl.betaFeedbackManagerProvider.get());
            AiCenterActivity_MembersInjector.injectIntentServices(instance50, new AppIntentServices());
            AiCenterActivity_MembersInjector.injectPreviewLauncher(instance50, this.singletonCImpl.previewLauncher());
            return instance50;
        }

        private FilterSearchResultsActivity injectFilterSearchResultsActivity2(FilterSearchResultsActivity instance51) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance51, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance51, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance51, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance51, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance51, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance51, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance51, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance51, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance51, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance51, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance51, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance51, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance51, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance51, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance51, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance51, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance51, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance51, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance51, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance51, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance51, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance51, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance51;
        }

        private FilterSearchResults injectFilterSearchResults2(FilterSearchResults instance52) {
            FilterSearchResults_MembersInjector.injectMFeatureFlips(instance52, this.singletonCImpl.featureFlipsProvider.get());
            return instance52;
        }

        private UploadToFolderActivity injectUploadToFolderActivity2(UploadToFolderActivity instance53) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance53, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance53, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance53, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance53, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance53, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance53, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance53, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance53, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance53, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance53, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance53, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance53, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance53, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance53, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance53, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance53, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance53, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance53, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance53, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance53, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance53, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance53, this.singletonCImpl.betaFeedbackManagerProvider.get());
            UploadToFolderActivity_MembersInjector.injectMBoxFolderApi(instance53, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            UploadToFolderActivity_MembersInjector.injectMBoxFileApi(instance53, this.singletonCImpl.provideBoxApiFileProvider.get());
            UploadToFolderActivity_MembersInjector.injectMLocalItemService(instance53, this.singletonCImpl.localItemServiceProvider.get());
            UploadToFolderActivity_MembersInjector.injectMBaseModelController(instance53, this.singletonCImpl.baseModelController());
            UploadToFolderActivity_MembersInjector.injectIntentServices(instance53, new AppIntentServices());
            UploadToFolderActivity_MembersInjector.injectUserContextManager(instance53, this.singletonCImpl.userContextManagerProvider.get());
            return instance53;
        }

        private CopyOrMoveActivity injectCopyOrMoveActivity2(CopyOrMoveActivity instance54) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance54, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance54, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance54, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance54, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance54, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance54, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance54, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance54, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance54, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance54, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance54, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance54, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance54, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance54, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance54, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance54, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance54, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance54, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance54, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance54, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance54, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance54, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance54;
        }

        private ItemPickerActivity injectItemPickerActivity2(ItemPickerActivity instance55) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance55, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance55, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance55, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance55, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance55, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance55, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance55, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance55, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance55, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance55, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance55, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance55, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance55, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance55, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance55, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance55, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance55, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance55, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance55, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance55, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance55, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance55, this.singletonCImpl.betaFeedbackManagerProvider.get());
            ItemPickerActivity_MembersInjector.injectIntentServices(instance55, new AppIntentServices());
            ItemPickerActivity_MembersInjector.injectUserContextManager(instance55, this.singletonCImpl.userContextManagerProvider.get());
            return instance55;
        }

        private CaptureActivity injectCaptureActivity2(CaptureActivity instance56) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance56, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance56, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance56, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance56, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance56, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance56, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance56, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance56, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance56, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance56, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance56, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance56, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance56, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance56, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance56, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance56, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance56, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance56, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance56, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance56, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance56, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance56, this.singletonCImpl.betaFeedbackManagerProvider.get());
            CaptureActivity_MembersInjector.injectItemActionHandlerFactory(instance56, this.singletonCImpl.factoryProvider23.get());
            CaptureActivity_MembersInjector.injectIntentServices(instance56, new AppIntentServices());
            return instance56;
        }

        private CaptureShortcutActivity injectCaptureShortcutActivity2(CaptureShortcutActivity instance57) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance57, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance57, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance57, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance57, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance57, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance57, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance57, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance57, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance57, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance57, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance57, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance57, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance57, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance57, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance57, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance57, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance57, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance57, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance57, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance57, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance57, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance57, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance57;
        }

        private CreateCaptureShortcutActivity injectCreateCaptureShortcutActivity2(CreateCaptureShortcutActivity instance58) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance58, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance58, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance58, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance58, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance58, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance58, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance58, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance58, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance58, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance58, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance58, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance58, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance58, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance58, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance58, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance58, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance58, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance58, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance58, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance58, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance58, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance58, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance58;
        }

        private ContentPickerActivity injectContentPickerActivity2(ContentPickerActivity instance59) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance59, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance59, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance59, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance59, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance59, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance59, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance59, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance59, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance59, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance59, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance59, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance59, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance59, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance59, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance59, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance59, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance59, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance59, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance59, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance59, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance59, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance59, this.singletonCImpl.betaFeedbackManagerProvider.get());
            ContentPickerActivity_MembersInjector.injectSelectionManager(instance59, this.activityRetainedCImpl.selectionManagerProvider.get());
            return instance59;
        }

        private FileActivitiesActivity injectFileActivitiesActivity2(FileActivitiesActivity instance60) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance60, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance60, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance60, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance60, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance60, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance60, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance60, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance60, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance60, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance60, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance60, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance60, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance60, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance60, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance60, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance60, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance60, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance60, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance60, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance60, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance60, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance60, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance60;
        }

        private HubDetailsActivity injectHubDetailsActivity2(HubDetailsActivity instance61) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance61, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance61, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance61, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance61, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance61, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance61, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance61, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance61, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance61, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance61, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance61, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance61, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance61, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance61, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance61, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance61, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance61, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance61, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance61, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance61, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance61, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance61, this.singletonCImpl.betaFeedbackManagerProvider.get());
            HubDetailsActivity_MembersInjector.injectWebBridgeAuthenticator(instance61, this.singletonCImpl.boxWebBridgeAuthenticator());
            return instance61;
        }

        private JobsUIActivity injectJobsUIActivity2(JobsUIActivity instance62) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance62, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance62, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance62, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance62, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance62, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance62, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance62, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance62, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance62, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance62, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance62, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance62, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance62, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance62, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance62, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance62, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance62, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance62, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance62, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance62, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance62, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance62, this.singletonCImpl.betaFeedbackManagerProvider.get());
            JobsUIActivity_MembersInjector.injectItemActionHandlerFactory(instance62, this.singletonCImpl.factoryProvider23.get());
            JobsUIActivity_MembersInjector.injectAppIntentServices(instance62, new AppIntentServices());
            JobsUIActivity_MembersInjector.injectPreviewHelper(instance62, this.singletonCImpl.previewLauncher());
            return instance62;
        }

        private Navigation injectNavigation2(Navigation instance63) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance63, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance63, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance63, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance63, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance63, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance63, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance63, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance63, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance63, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance63, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance63, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance63, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance63, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance63, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance63, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance63, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance63, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance63, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance63, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance63, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance63, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance63, this.singletonCImpl.betaFeedbackManagerProvider.get());
            MainParent_MembersInjector.injectMAdminSettingsModelController(instance63, this.singletonCImpl.provideIMoCoAdminSettingsProvider.get());
            MainParent_MembersInjector.injectMBoxApiUser(instance63, this.singletonCImpl.provideBoxApiUserProvider.get());
            MainParent_MembersInjector.injectMBrowseController(instance63, this.singletonCImpl.providesBrowseControllerProvider.get());
            MainParent_MembersInjector.injectMApiPreviewPrivate(instance63, this.singletonCImpl.provideBoxExtendedApiPreviewProvider.get());
            MainParent_MembersInjector.injectMJobManager(instance63, this.singletonCImpl.jobManagerProvider.get());
            MainParent_MembersInjector.injectMJobService(instance63, this.singletonCImpl.jobServiceProvider.get());
            MainParent_MembersInjector.injectMTransfersHelper(instance63, new TransfersHelper());
            MainParent_MembersInjector.injectMFabHelperFactory(instance63, this.factoryProvider.get());
            MainParent_MembersInjector.injectLocalItemService(instance63, this.singletonCImpl.localItemServiceProvider.get());
            MainParent_MembersInjector.injectBoxAdminSettingsProvider(instance63, this.singletonCImpl.boxAdminSettingsProvider());
            MainParent_MembersInjector.injectMUploadHelper(instance63, uploadHelper());
            MainParent_MembersInjector.injectMIntentServices(instance63, new AppIntentServices());
            MainParent_MembersInjector.injectFtuxMessageReceiverHelper(instance63, fTUXMessageReceiverHelper());
            MainParent_MembersInjector.injectAppUpdateProposalManager(instance63, this.singletonCImpl.appUpdateProposalManagerProvider.get());
            MainParent_MembersInjector.injectMOfflineMigrationService(instance63, this.singletonCImpl.offlineMigrationServiceProvider.get());
            MainParent_MembersInjector.injectMOfflineStateStorage(instance63, this.singletonCImpl.offlineStateStorageProvider.get());
            MainParent_MembersInjector.injectMOfflineFilesPolicyEnforcer(instance63, this.singletonCImpl.offlineFilesPolicyEnforcer());
            MainParent_MembersInjector.injectMItemActionHandlerFactory(instance63, this.singletonCImpl.factoryProvider23.get());
            MainParent_MembersInjector.injectMSearchActionLogHelper(instance63, DefaultModule_Companion_ProvideSearchActionLogHelperFactory.provideSearchActionLogHelper());
            Navigation_MembersInjector.injectCopyOrMoveHelper(instance63, new CopyOrMoveHelper());
            Navigation_MembersInjector.injectIntentServices(instance63, new AppIntentServices());
            Navigation_MembersInjector.injectNavigationBrowseToolbarHelper(instance63, new NavigationBrowseToolbarHelper());
            Navigation_MembersInjector.injectMLocalItemService(instance63, this.singletonCImpl.localItemServiceProvider.get());
            Navigation_MembersInjector.injectMBottomBarHelper(instance63, navigationBottomBar());
            Navigation_MembersInjector.injectUpdatesManager(instance63, updatesManager());
            return instance63;
        }

        private MainActivity injectMainActivity2(MainActivity instance64) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance64, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance64, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance64, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance64, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance64, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance64, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance64, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance64, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance64, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance64, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance64, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance64, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance64, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance64, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance64, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance64, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance64, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance64, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance64, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance64, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance64, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance64, this.singletonCImpl.betaFeedbackManagerProvider.get());
            MainBaseActivity_MembersInjector.injectItemMoreActionsHandlerFactory(instance64, this.singletonCImpl.factoryProvider24.get());
            MainBaseActivity_MembersInjector.injectJobManager(instance64, this.singletonCImpl.jobManagerProvider.get());
            MainBaseActivity_MembersInjector.injectJobService(instance64, this.singletonCImpl.jobServiceProvider.get());
            MainBaseActivity_MembersInjector.injectIntentServices(instance64, new AppIntentServices());
            MainBaseActivity_MembersInjector.injectApiPreviewPrivate(instance64, this.singletonCImpl.provideBoxExtendedApiPreviewProvider.get());
            MainBaseActivity_MembersInjector.injectBoxMessageDispatcher(instance64, new BoxMessageDispatcher());
            MainBaseActivity_MembersInjector.injectFtuxMessageReceiverHelper(instance64, fTUXMessageReceiverHelper());
            MainBaseActivity_MembersInjector.injectOfflineStateStorage(instance64, this.singletonCImpl.offlineStateStorageProvider.get());
            MainBaseActivity_MembersInjector.injectOfflineMigrationService(instance64, this.singletonCImpl.offlineMigrationServiceProvider.get());
            MainBaseActivity_MembersInjector.injectBoxAdminSettingsProvider(instance64, this.singletonCImpl.boxAdminSettingsProvider());
            MainBaseActivity_MembersInjector.injectAdminSettingsModelController(instance64, this.singletonCImpl.provideIMoCoAdminSettingsProvider.get());
            MainBaseActivity_MembersInjector.injectBoxApiUser(instance64, this.singletonCImpl.provideBoxApiUserProvider.get());
            MainBaseActivity_MembersInjector.injectLocalItemService(instance64, this.singletonCImpl.localItemServiceProvider.get());
            MainBaseActivity_MembersInjector.injectBoxAccountSettings(instance64, this.singletonCImpl.boxAccountSettings());
            MainBaseActivity_MembersInjector.injectOfflineFilesPolicyEnforcer(instance64, this.singletonCImpl.offlineFilesPolicyEnforcer());
            MainActivity_MembersInjector.injectItemClickHandlerFactory(instance64, this.singletonCImpl.factoryProvider22.get());
            MainActivity_MembersInjector.injectRootInnerNavigatorsProviderFactory(instance64, this.factoryProvider3.get());
            MainActivity_MembersInjector.injectHomeScreenInnerNavigatorsProviderFactory(instance64, this.factoryProvider4.get());
            MainActivity_MembersInjector.injectTabPersistenceService(instance64, this.singletonCImpl.tabPersistenceService());
            MainActivity_MembersInjector.injectPreviewLauncher(instance64, this.singletonCImpl.previewLauncher());
            MainActivity_MembersInjector.injectMainNavigationTargetConfigFactory(instance64, mainNavigationTargetConfigFactory());
            return instance64;
        }

        private BoxCanvasActivity injectBoxCanvasActivity2(BoxCanvasActivity instance65) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance65, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance65, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance65, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance65, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance65, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance65, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance65, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance65, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance65, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance65, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance65, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance65, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance65, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance65, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance65, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance65, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance65, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance65, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance65, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance65, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance65, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance65, this.singletonCImpl.betaFeedbackManagerProvider.get());
            BoxCanvasActivity_MembersInjector.injectBoxCanvasHelper(instance65, boxCanvasIntentBuilder());
            BoxCanvasActivity_MembersInjector.injectUserContextManager(instance65, this.singletonCImpl.userContextManagerProvider.get());
            return instance65;
        }

        private GalleryItemsActivity injectGalleryItemsActivity2(GalleryItemsActivity instance66) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance66, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance66, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance66, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance66, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance66, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance66, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance66, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance66, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance66, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance66, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance66, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance66, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance66, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance66, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance66, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance66, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance66, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance66, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance66, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance66, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance66, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance66, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance66;
        }

        private ItemInformationActivity injectItemInformationActivity2(ItemInformationActivity instance67) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance67, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance67, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance67, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance67, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance67, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance67, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance67, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance67, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance67, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance67, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance67, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance67, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance67, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance67, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance67, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance67, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance67, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance67, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance67, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance67, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance67, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance67, this.singletonCImpl.betaFeedbackManagerProvider.get());
            ItemInformationActivity_MembersInjector.injectUserContextManager(instance67, this.singletonCImpl.userContextManagerProvider.get());
            ItemInformationActivity_MembersInjector.injectIntentServices(instance67, new AppIntentServices());
            return instance67;
        }

        private PreviewActivity injectPreviewActivity2(PreviewActivity instance68) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance68, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance68, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance68, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance68, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance68, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance68, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance68, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance68, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance68, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance68, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance68, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance68, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance68, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance68, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance68, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance68, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance68, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance68, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance68, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance68, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance68, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance68, this.singletonCImpl.betaFeedbackManagerProvider.get());
            PreviewActivity_MembersInjector.injectIntentServices(instance68, new AppIntentServices());
            PreviewActivity_MembersInjector.injectIdMappingService(instance68, this.singletonCImpl.idMappingService());
            PreviewActivity_MembersInjector.injectCopyOrMoveHelper(instance68, new CopyOrMoveHelper());
            PreviewActivity_MembersInjector.injectPreviewActivityIntentHandler(instance68, new PreviewActivityIntentHandler());
            PreviewActivity_MembersInjector.injectFileActivitiesLauncher(instance68, new FileActivitiesLauncher());
            PreviewActivity_MembersInjector.injectUserContextManager(instance68, this.singletonCImpl.userContextManagerProvider.get());
            PreviewActivity_MembersInjector.injectFeatureFlips(instance68, this.singletonCImpl.featureFlipsProvider.get());
            PreviewActivity_MembersInjector.injectNotificationServices(instance68, new AppNotificationServices());
            PreviewActivity_MembersInjector.injectAudioPlayerManager(instance68, this.singletonCImpl.media3AudioPlayerManagerProvider.get());
            PreviewActivity_MembersInjector.injectFtuxController(instance68, this.singletonCImpl.fTUXController());
            PreviewActivity_MembersInjector.injectVideoPlayersProvider(instance68, this.activityRetainedCImpl.videoPlayersProvider.get());
            PreviewActivity_MembersInjector.injectVideoMediaSourceFactory(instance68, this.singletonCImpl.videoMediaSourceFactory());
            return instance68;
        }

        private PreviewPlaylistActivity injectPreviewPlaylistActivity2(PreviewPlaylistActivity instance69) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance69, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance69, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance69, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance69, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance69, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance69, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance69, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance69, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance69, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance69, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance69, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance69, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance69, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance69, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance69, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance69, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance69, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance69, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance69, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance69, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance69, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance69, this.singletonCImpl.betaFeedbackManagerProvider.get());
            PreviewPlaylistActivity_MembersInjector.injectAudioPlayerManager(instance69, this.singletonCImpl.media3AudioPlayerManagerProvider.get());
            return instance69;
        }

        private PreviousVersionPreviewActivity injectPreviousVersionPreviewActivity2(PreviousVersionPreviewActivity instance70) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance70, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance70, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance70, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance70, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance70, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance70, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance70, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance70, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance70, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance70, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance70, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance70, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance70, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance70, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance70, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance70, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance70, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance70, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance70, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance70, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance70, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance70, this.singletonCImpl.betaFeedbackManagerProvider.get());
            PreviousVersionPreviewActivity_MembersInjector.injectFileActivitiesLauncher(instance70, new FileActivitiesLauncher());
            PreviousVersionPreviewActivity_MembersInjector.injectUserContextManager(instance70, this.singletonCImpl.userContextManagerProvider.get());
            PreviousVersionPreviewActivity_MembersInjector.injectAudioPlayerManager(instance70, this.singletonCImpl.media3AudioPlayerManagerProvider.get());
            PreviousVersionPreviewActivity_MembersInjector.injectFeatureFlips(instance70, this.singletonCImpl.featureFlipsProvider.get());
            PreviousVersionPreviewActivity_MembersInjector.injectVideoPlayersProvider(instance70, this.activityRetainedCImpl.videoPlayersProvider.get());
            PreviousVersionPreviewActivity_MembersInjector.injectVideoMediaSourceFactory(instance70, this.singletonCImpl.videoMediaSourceFactory());
            return instance70;
        }

        private SearchActivity injectSearchActivity2(SearchActivity instance71) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance71, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance71, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance71, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance71, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance71, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance71, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance71, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance71, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance71, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance71, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance71, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance71, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance71, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance71, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance71, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance71, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance71, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance71, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance71, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance71, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance71, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance71, this.singletonCImpl.betaFeedbackManagerProvider.get());
            SearchActivity_MembersInjector.injectIntentServices(instance71, new AppIntentServices());
            SearchActivity_MembersInjector.injectFeatureFlips(instance71, this.singletonCImpl.featureFlipsProvider.get());
            SearchActivity_MembersInjector.injectItemClickHandlerFactory(instance71, this.singletonCImpl.factoryProvider22.get());
            SearchActivity_MembersInjector.injectBoxSearchItemClickHandlerFactory(instance71, this.factoryProvider2.get());
            SearchActivity_MembersInjector.injectItemMoreActionsHandlerFactory(instance71, this.singletonCImpl.factoryProvider24.get());
            return instance71;
        }

        private AddTaskActivity injectAddTaskActivity2(AddTaskActivity instance72) {
            BoxFragmentActivity_MembersInjector.injectMTransfersModelController(instance72, this.singletonCImpl.provideIMoCoBoxTransfersProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFile(instance72, this.singletonCImpl.provideBoxApiFileProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiBookmark(instance72, this.singletonCImpl.provideBoxApiWeblinkProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxExtendedApiFolder(instance72, this.singletonCImpl.provideBoxExtendedApiFolderProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBaseMoco(instance72, this.singletonCImpl.baseModelController());
            BoxFragmentActivity_MembersInjector.injectMBoxApiShare(instance72, this.singletonCImpl.provideBoxApiShareProvider.get());
            BoxFragmentActivity_MembersInjector.injectMRestrictionsManager(instance72, this.singletonCImpl.appRestrictionsManager2());
            BoxFragmentActivity_MembersInjector.injectMUserContextManager(instance72, this.singletonCImpl.userContextManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMGlobalSettings(instance72, this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMMigration(instance72, this.singletonCImpl.provideUserContextMigrationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxApiPrivate(instance72, this.singletonCImpl.provideBoxApiPrivateProvider.get());
            BoxFragmentActivity_MembersInjector.injectMFeatureFlips(instance72, this.singletonCImpl.featureFlipsProvider.get());
            BoxFragmentActivity_MembersInjector.injectMBoxAccountSettings(instance72, this.singletonCImpl.boxAccountSettings());
            BoxFragmentActivity_MembersInjector.injectMIntentServices(instance72, new AppIntentServices());
            BoxFragmentActivity_MembersInjector.injectMSplitConfiguration(instance72, this.singletonCImpl.splitConfigurationProvider.get());
            BoxFragmentActivity_MembersInjector.injectMConfigManager(instance72, this.singletonCImpl.configManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectForceUpdateCoordinator(instance72, this.singletonCImpl.forceUpdateCoordinatorProvider.get());
            BoxFragmentActivity_MembersInjector.injectMNotificationServices(instance72, new AppNotificationServices());
            BoxFragmentActivity_MembersInjector.injectMIntuneAuthManager(instance72, this.singletonCImpl.intuneAuthManagerProvider.get());
            BoxFragmentActivity_MembersInjector.injectMLaunchIntoCapture(instance72, this.singletonCImpl.launchIntoCaptureInteractorProvider.get());
            BoxFragmentActivity_MembersInjector.injectClientSettingsInitialisation(instance72, clientSettingsInitialisation());
            BoxFragmentActivity_MembersInjector.injectBetaFeedbackManager(instance72, this.singletonCImpl.betaFeedbackManagerProvider.get());
            return instance72;
        }

        private ForceUpdateActivity injectForceUpdateActivity2(ForceUpdateActivity instance73) {
            ForceUpdateActivity_MembersInjector.injectForceUpdateActionHandler(instance73, this.singletonCImpl.forceUpdateActionHandlerProvider.get());
            ForceUpdateActivity_MembersInjector.injectDialogConfigProvider(instance73, forceUpdateDialogConfigProvider());
            ForceUpdateActivity_MembersInjector.injectAnalytics(instance73, new ForceUpdateAnalytics());
            return instance73;
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityCImpl activityCImpl;
            private final ActivityRetainedCImpl activityRetainedCImpl;
            private final int id;
            private final SingletonCImpl singletonCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, int id) {
                this.singletonCImpl = singletonCImpl;
                this.activityRetainedCImpl = activityRetainedCImpl;
                this.activityCImpl = activityCImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                int i = this.id;
                if (i == 0) {
                    return (T) new FabHelper.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ActivityCImpl.SwitchingProvider.1
                        @Override // com.box.android.browse.cpl.helpers.FabHelper.Factory
                        public FabHelper create(BoxFragmentActivity activity) {
                            return new FabHelper(SwitchingProvider.this.singletonCImpl.userContextManagerProvider.get(), SwitchingProvider.this.activityCImpl.fabManager(), activity);
                        }
                    };
                }
                if (i == 1) {
                    return (T) new RootInnerNavigatorsProviderFactory.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ActivityCImpl.SwitchingProvider.2
                        @Override // com.box.android.navigationmodernization.navigation.navigator.RootInnerNavigatorsProviderFactory.Factory
                        public RootInnerNavigatorsProviderFactory create(AppCompatActivity activity3, IItemClickHandler itemClickHandler2, IItemMoreActionsHandler itemMoreActionsHandler) {
                            return new RootInnerNavigatorsProviderFactory(SwitchingProvider.this.activityCImpl.factoryProvider2.get(), new AppIntentServices(), activity3, itemClickHandler2, itemMoreActionsHandler);
                        }
                    };
                }
                if (i == 2) {
                    return (T) new BoxSearchItemClickHandler.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ActivityCImpl.SwitchingProvider.3
                        @Override // com.box.android.browse.utilities.BoxSearchItemClickHandler.Factory
                        public BoxSearchItemClickHandler create(AppCompatActivity activity2, IItemClickHandler itemClickHandler) {
                            return new BoxSearchItemClickHandler(SwitchingProvider.this.singletonCImpl.userContextManagerProvider.get(), itemClickHandler, activity2);
                        }
                    };
                }
                if (i == 3) {
                    return (T) new HomeScreenInnerNavigatorsProviderFactory.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ActivityCImpl.SwitchingProvider.4
                        @Override // com.box.android.navigationmodernization.homescreen.navigation.compose.HomeScreenInnerNavigatorsProviderFactory.Factory
                        public HomeScreenInnerNavigatorsProviderFactory create(AppCompatActivity activity4, IItemClickHandler itemClickHandler3, IItemMoreActionsHandler itemMoreActionsHandler2) {
                            return new HomeScreenInnerNavigatorsProviderFactory(new AppIntentServices(), SwitchingProvider.this.singletonCImpl.userContextManagerProvider.get(), new CopyOrMoveHelper(), SwitchingProvider.this.activityCImpl.fabManager(), activity4, itemClickHandler3, itemMoreActionsHandler2);
                        }
                    };
                }
                throw new AssertionError(this.id);
            }
        }
    }

    private static final class ViewModelCImpl extends BoxApplication_HiltComponents.ViewModelC {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        Provider<AddTaskViewModel> addTaskViewModelProvider;
        Provider<AllFilesViewModel> allFilesViewModelProvider;
        Provider<AppUpdateProposalViewModel> appUpdateProposalViewModelProvider;
        Provider<BiometricsVM> biometricsVMProvider;
        Provider<BoxAiHomeViewModel> boxAiHomeViewModelProvider;
        Provider<BrowseTabsViewModel> browseTabsViewModelProvider;
        Provider<CaptureHistoryButtonViewModel> captureHistoryButtonViewModelProvider;
        Provider<CaptureHistoryViewModel> captureHistoryViewModelProvider;
        Provider<CaptureMediaHandlerViewModel> captureMediaHandlerViewModelProvider;
        Provider<CaptureSettingsViewModel> captureSettingsViewModelProvider;
        Provider<CaptureViewModel> captureViewModelProvider;
        Provider<CollectionItemsListViewModel> collectionItemsListViewModelProvider;
        Provider<CollectionsViewModel> collectionsViewModelProvider;
        Provider<ContentPickerViewModel> contentPickerViewModelProvider;
        Provider<CollectionItemsViewModel.Factory> factoryProvider;
        Provider<PreviewViewModel.Factory> factoryProvider10;
        Provider<PreviousVersionViewModel.Factory> factoryProvider11;
        Provider<SearchViewModel.Factory> factoryProvider12;
        Provider<CollectionMembershipsViewModel.Factory> factoryProvider2;
        Provider<CopyOrMoveViewModel.Factory> factoryProvider3;
        Provider<FileActivitiesViewModel.Factory> factoryProvider4;
        Provider<GalleryItemsViewModel.Factory> factoryProvider5;
        Provider<HubDetailsViewModel.Factory> factoryProvider6;
        Provider<ItemInformationViewModel.Factory> factoryProvider7;
        Provider<ItemPickerViewModel.Factory> factoryProvider8;
        Provider<PreviewPlaylistViewModel.Factory> factoryProvider9;
        Provider<FavoritesCollectionItemsViewModel> favoritesCollectionItemsViewModelProvider;
        Provider<FilesSearchViewModel> filesSearchViewModelProvider;
        Provider<FolderItemPickerViewModel> folderItemPickerViewModelProvider;
        Provider<HomeScreenViewModel> homeScreenViewModelProvider;
        Provider<HubsItemPickerViewModel> hubsItemPickerViewModelProvider;
        Provider<HubsViewModel> hubsViewModelProvider;
        Provider<InboxBadgeVM> inboxBadgeVMProvider;
        Provider<InboxCountViewModel> inboxCountViewModelProvider;
        Provider<InboxTabsViewModel> inboxTabsViewModelProvider;
        Provider<InboxViewModel> inboxViewModelProvider;
        Provider<JobsProgressViewModel> jobsProgressViewModelProvider;
        Provider<JobsUIViewModel> jobsUIViewModelProvider;
        Provider<MainNavigationViewModel> mainNavigationViewModelProvider;
        Provider<MyCollectionsViewModel> myCollectionsViewModelProvider;
        Provider<NavigationViewModel> navigationViewModelProvider;
        Provider<NewNoteCreationViewModel> newNoteCreationViewModelProvider;
        Provider<NotesFavoritesViewModel> notesFavoritesViewModelProvider;
        Provider<NotesRecentsViewModel> notesRecentsViewModelProvider;
        Provider<NotesSearchViewModel> notesSearchViewModelProvider;
        Provider<NotesTabsViewModel> notesTabsViewModelProvider;
        Provider<OfflinedViewModel> offlinedViewModelProvider;
        Provider<PushRegistrationDialogVM> pushRegistrationDialogVMProvider;
        Provider<RecentsItemPickerViewModel> recentsItemPickerViewModelProvider;
        Provider<RecentsViewModel> recentsViewModelProvider;
        Provider<RecorderServiceViewModel> recorderServiceViewModelProvider;
        private final SavedStateHandle savedStateHandle;
        Provider<SearchItemPickerViewModel> searchItemPickerViewModelProvider;
        Provider<SingleTaskVM> singleTaskVMProvider;
        private final SingletonCImpl singletonCImpl;
        Provider<TaskCollaboratorsVM> taskCollaboratorsVMProvider;
        Provider<UploadContentHandlerViewModel> uploadContentHandlerViewModelProvider;
        Provider<UserAvatarViewModel> userAvatarViewModelProvider;
        private final ViewModelCImpl viewModelCImpl = this;
        Provider<WatermarkingViewModel> watermarkingViewModelProvider;

        ViewModelCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam, ViewModelLifecycle viewModelLifecycleParam) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.savedStateHandle = savedStateHandleParam;
            initialize(savedStateHandleParam, viewModelLifecycleParam);
            initialize2(savedStateHandleParam, viewModelLifecycleParam);
            initialize3(savedStateHandleParam, viewModelLifecycleParam);
        }

        AssigneePickerEnvironment assigneePickerEnvironment() {
            return new AssigneePickerEnvironment(this.singletonCImpl.commentControllerBridge());
        }

        AddTaskFormEnvironment addTaskFormEnvironment() {
            return new AddTaskFormEnvironment(this.singletonCImpl.taskService(), assigneePickerEnvironment());
        }

        AddTaskEnvironment addTaskEnvironment() {
            return new AddTaskEnvironment(addTaskFormEnvironment());
        }

        FolderViewInteractor folderViewInteractor() {
            return new FolderViewInteractor(this.singletonCImpl.remoteItemService(), this.singletonCImpl.itemSorter());
        }

        ItemThumbnailEnvironment itemThumbnailEnvironment() {
            return new ItemThumbnailEnvironment(this.singletonCImpl.thumbnailManagerProvider.get(), this.singletonCImpl.hubsService());
        }

        BoxFeatureBannerUtils boxFeatureBannerUtils() {
            return new BoxFeatureBannerUtils(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.appInBackgroundServiceProvider.get());
        }

        MultiselectEnvironment multiselectEnvironment() {
            return new MultiselectEnvironment(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.boxAccountManagerHelper(), this.activityRetainedCImpl.selectionManagerProvider.get());
        }

        BrowseAnalytics browseAnalytics() {
            return new BrowseAnalytics(this.singletonCImpl.baseModelController(), this.singletonCImpl.provideBoxExtendedApiFolderProvider.get(), this.singletonCImpl.userContextManagerProvider.get());
        }

        AppStartApdexTracker appStartApdexTracker() {
            return new AppStartApdexTracker(this.singletonCImpl.providesApdexServiceProvider.get(), this.singletonCImpl.providesAppStartTargetHolderProvider.get());
        }

        ItemModelStateMapper itemModelStateMapper() {
            return new ItemModelStateMapper(this.singletonCImpl.boxModelOfflineManagerWrapper(), this.singletonCImpl.thumbnailManagerProvider.get());
        }

        FolderViewEnvironment folderViewEnvironment() {
            return new FolderViewEnvironment(folderViewInteractor(), itemThumbnailEnvironment(), this.singletonCImpl.gen204PerformanceLoggerProvider.get(), boxFeatureBannerUtils(), this.singletonCImpl.userContextManagerProvider.get(), multiselectEnvironment(), browseAnalytics(), this.singletonCImpl.sessionManagerProvider.get(), this.singletonCImpl.metricsInteractorProvider.get(), this.singletonCImpl.providesApdexServiceProvider.get(), appStartApdexTracker(), itemModelStateMapper(), this.singletonCImpl.boxModelOfflineManagerWrapper(), CommonModule_ProvidesDefaultDispatcherFactory.providesDefaultDispatcher(), this.singletonCImpl.providesSortPreferencesProvider.get());
        }

        OfflineFilesEnvironment offlineFilesEnvironment() {
            return new OfflineFilesEnvironment(this.singletonCImpl.fileActionsManager(), this.singletonCImpl.offlineService());
        }

        DownloadEnvironment downloadEnvironment() {
            return new DownloadEnvironment(this.singletonCImpl.fileActionsManager(), this.singletonCImpl.jobManagerProvider.get(), this.singletonCImpl.featureFlipsProvider.get(), this.singletonCImpl.localItemServiceProvider.get());
        }

        VoiceInputEnvironment voiceInputEnvironment() {
            return new VoiceInputEnvironment(this.singletonCImpl.speechRecognitionManager());
        }

        BoxAiEnvironment boxAiEnvironment() {
            return new BoxAiEnvironment(this.singletonCImpl.boxAiService(), this.singletonCImpl.clipboardService(), new BoxAiAnalytics(), this.singletonCImpl.boxAiObservabilityProvider.get(), this.singletonCImpl.featureFlipsProvider.get(), this.singletonCImpl.boxAccountSettings(), voiceInputEnvironment(), new PermissionsHandler(), this.singletonCImpl.fileActionsManager(), this.singletonCImpl.getBoxAiAvailabilityInteractor());
        }

        ActionableFolderViewEnvironment actionableFolderViewEnvironment() {
            return new ActionableFolderViewEnvironment(folderViewEnvironment(), browseAnalytics(), this.singletonCImpl.boxAccountManagerHelper(), this.singletonCImpl.fileActionsManager(), offlineFilesEnvironment(), downloadEnvironment(), boxAiEnvironment());
        }

        FabManager fabManager() {
            return new FabManager(new AppIntentServices(), this.singletonCImpl.featureFlipsProvider.get(), this.singletonCImpl.resolveNewNoteDataInteractor());
        }

        UploadHelper uploadHelper() {
            return new UploadHelper(this.singletonCImpl.remoteItemService(), this.singletonCImpl.localItemServiceProvider.get(), this.singletonCImpl.userContextManagerProvider.get(), CommonModule_ProvidesDefaultDispatcherFactory.providesDefaultDispatcher(), CommonModule_ProvidesMainDispatcherFactory.providesMainDispatcher());
        }

        NewFileMenuUtils newFileMenuUtils() {
            return new NewFileMenuUtils(this.singletonCImpl.provideApplicationContextProvider.get());
        }

        FilesFabEnvironment filesFabEnvironment() {
            return new FilesFabEnvironment(fabManager(), this.singletonCImpl.userContextManagerProvider.get(), uploadHelper(), newFileMenuUtils(), new FilesFabAnalytics());
        }

        CreateFolderEnvironment createFolderEnvironment() {
            return new CreateFolderEnvironment(this.singletonCImpl.createFolderInteractor(), this.singletonCImpl.createFolderHelper(), new ItemNameValidator());
        }

        BrowseEnvironment browseEnvironment() {
            return new BrowseEnvironment(actionableFolderViewEnvironment(), filesFabEnvironment(), browseAnalytics(), this.singletonCImpl.folderInteractor(), this.singletonCImpl.userContextManagerProvider.get(), createFolderEnvironment(), this.singletonCImpl.providesApdexServiceProvider.get());
        }

        UpdatesManager updatesManager() {
            return new UpdatesManager(this.singletonCImpl.forceUpdateEvaluatorProvider.get(), this.singletonCImpl.appUpdateProposalManagerProvider.get());
        }

        AppUpdateProposalEnvironment appUpdateProposalEnvironment() {
            return new AppUpdateProposalEnvironment(updatesManager(), this.singletonCImpl.appUpdateProposalManagerProvider.get());
        }

        BoxAiHomeEnvironment boxAiHomeEnvironment() {
            return new BoxAiHomeEnvironment(new BoxAiAnalytics(), this.singletonCImpl.aiCenterSessionInfoProviderImplProvider.get());
        }

        BrowseTabsEnvironment browseTabsEnvironment() {
            return new BrowseTabsEnvironment(browseAnalytics());
        }

        CaptureMediaEnvironment captureMediaEnvironment() {
            return new CaptureMediaEnvironment(this.singletonCImpl.uploadFileProvider());
        }

        CaptureSettingsEnvironment captureSettingsEnvironment() {
            return new CaptureSettingsEnvironment(this.singletonCImpl.launchIntoCaptureInteractorProvider.get(), this.singletonCImpl.capturePreferencesService());
        }

        CaptureUploadFileManager captureUploadFileManager() {
            return new CaptureUploadFileManager(this.singletonCImpl.userContextManagerProvider.get());
        }

        VideoRecordingFileManager videoRecordingFileManager() {
            return new VideoRecordingFileManager(this.singletonCImpl.userContextManagerProvider.get(), captureUploadFileManager());
        }

        GeniusScanLicenseInitializer geniusScanLicenseInitializer() {
            return new GeniusScanLicenseInitializer(this.singletonCImpl.geniusScanLicenseService());
        }

        DocumentScanningEnvironment documentScanningEnvironment() {
            return new DocumentScanningEnvironment(this.singletonCImpl.capturePreferencesService(), this.singletonCImpl.documentScanInteractor(), geniusScanLicenseInitializer(), new PermissionsHandler(), this.singletonCImpl.documentScanPageProcessor(), new DocumentScanningHelper(), captureUploadFileManager(), this.singletonCImpl.captureThumbnailService());
        }

        RecordingFileManager recordingFileManager() {
            return new RecordingFileManager(this.singletonCImpl.userContextManagerProvider.get(), captureUploadFileManager());
        }

        AudioCaptureEnvironment audioCaptureEnvironment() {
            return new AudioCaptureEnvironment(new RecorderServiceManager(), recordingFileManager(), new AudioRecordingHelper());
        }

        CaptureEnvironment captureEnvironment() {
            return new CaptureEnvironment(this.singletonCImpl.capturePreferencesService(), this.singletonCImpl.captureLocalItemsInteractor(), new CameraSession(), captureUploadFileManager(), this.singletonCImpl.provideBoxExtendedApiFolderProvider.get(), new PermissionsHandler(), videoRecordingFileManager(), documentScanningEnvironment(), captureSettingsEnvironment(), audioCaptureEnvironment(), this.singletonCImpl.captureFolderInteractor(), new ImageCaptureHelper(), this.singletonCImpl.captureShutterSoundHelper(), this.singletonCImpl.idMappingService());
        }

        ListCollectionItemsInteractor listCollectionItemsInteractor() {
            return new ListCollectionItemsInteractor(this.singletonCImpl.collectionsService());
        }

        ItemEnvironment itemEnvironment() {
            return new ItemEnvironment(itemThumbnailEnvironment(), this.singletonCImpl.boxModelOfflineManagerWrapper());
        }

        CollectionItemsListEnvironment collectionItemsListEnvironment() {
            return new CollectionItemsListEnvironment(listCollectionItemsInteractor(), itemEnvironment(), multiselectEnvironment(), new CollectionsAnalytics());
        }

        CollectionsListEnvironment collectionsListEnvironment() {
            return new CollectionsListEnvironment(this.singletonCImpl.listCollectionsInteractor());
        }

        CreateCollectionInteractor createCollectionInteractor() {
            return new CreateCollectionInteractor(this.singletonCImpl.collectionsService());
        }

        CollectionsEnvironment collectionsEnvironment() {
            return new CollectionsEnvironment(collectionsListEnvironment(), createCollectionInteractor(), new CollectionsAnalytics());
        }

        ContentPickerAnalytics contentPickerAnalytics() {
            return new ContentPickerAnalytics(new ContentPickerEventPropertyBuilder(), this.singletonCImpl.aiCenterSessionInfoProviderImplProvider.get());
        }

        ContentPickerEnvironment contentPickerEnvironment() {
            return new ContentPickerEnvironment(this.activityRetainedCImpl.selectionManagerProvider.get(), this.singletonCImpl.clientSettingsService(), contentPickerAnalytics());
        }

        FilesSearchHelper filesSearchHelper() {
            return new FilesSearchHelper(this.singletonCImpl.providesBrowseControllerProvider.get(), this.singletonCImpl.userContextManagerProvider.get(), DefaultModule_Companion_ProvideSearchActionLogHelperFactory.provideSearchActionLogHelper(), ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
        }

        FilesSearchEnvironment filesSearchEnvironment() {
            return new FilesSearchEnvironment(filesSearchHelper());
        }

        FolderItemPickerEnvironment folderItemPickerEnvironment() {
            return new FolderItemPickerEnvironment(folderViewEnvironment(), createFolderEnvironment());
        }

        HomeScreenEnvironment homeScreenEnvironment() {
            return new HomeScreenEnvironment(this.singletonCImpl.tabPersistenceService());
        }

        HubsScreenPreferences hubsScreenPreferences() {
            return new HubsScreenPreferences(this.singletonCImpl.userContextManagerProvider.get());
        }

        HubsEnvironment hubsEnvironment() {
            return new HubsEnvironment(this.singletonCImpl.hubsService(), hubsScreenPreferences(), this.singletonCImpl.hubsObservabilityProvider.get(), itemThumbnailEnvironment(), multiselectEnvironment(), new HubsAnalytics());
        }

        InboxCountEnvironment inboxCountEnvironment() {
            return new InboxCountEnvironment(this.singletonCImpl.inboxBadgeRepositoryProvider.get());
        }

        InboxTabsEnvironment inboxTabsEnvironment() {
            return new InboxTabsEnvironment(new InboxAnalytics());
        }

        MfaSetupUrlBuilder mfaSetupUrlBuilder() {
            return new MfaSetupUrlBuilder(this.singletonCImpl.configManagerProvider.get());
        }

        MfaSetupDialogEnvironment mfaSetupDialogEnvironment() {
            return new MfaSetupDialogEnvironment(new MfaSetupAnalytics(), mfaSetupUrlBuilder(), ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), CommonModule_ProvidesClockFactory.providesClock());
        }

        InboxItemCollaborationEnvironment inboxItemCollaborationEnvironment() {
            return new InboxItemCollaborationEnvironment(new MfaSetupAnalytics(), this.singletonCImpl.inboxCollaborationService(), mfaSetupDialogEnvironment(), CommonModule_ProvidesClockFactory.providesClock());
        }

        InboxItemEnvironment inboxItemEnvironment() {
            return new InboxItemEnvironment(this.singletonCImpl.userContextManagerProvider.get(), inboxItemCollaborationEnvironment(), this.singletonCImpl.inboxNotificationService());
        }

        InboxItemsListEnvironment inboxItemsListEnvironment() {
            return new InboxItemsListEnvironment(inboxItemEnvironment(), this.singletonCImpl.inboxNotificationService(), this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.inboxBadgeRepositoryProvider.get(), CommonModule_ProvidesDefaultDispatcherFactory.providesDefaultDispatcher());
        }

        InboxEnvironment inboxEnvironment() {
            return new InboxEnvironment(inboxItemsListEnvironment());
        }

        JobsProgressEnvironment jobsProgressEnvironment() {
            return new JobsProgressEnvironment(this.singletonCImpl.jobManagerBridgeService(), this.singletonCImpl.jobServiceProvider.get());
        }

        JobsUIEnvironment jobsUIEnvironment() {
            return new JobsUIEnvironment(this.singletonCImpl.jobManagerBridgeService(), this.singletonCImpl.jobServiceProvider.get(), this.singletonCImpl.thumbnailManagerProvider.get(), new JobsUICoreHelper(), this.singletonCImpl.jobsNotificationServiceProvider.get());
        }

        JobsReducer jobsReducer() {
            return new JobsReducer(jobsUIEnvironment());
        }

        RecentsViewInteractor recentsViewInteractor() {
            return new RecentsViewInteractor(this.singletonCImpl.recentsService());
        }

        RecentsViewEnvironment recentsViewEnvironment() {
            return new RecentsViewEnvironment(recentsViewInteractor(), itemThumbnailEnvironment(), this.singletonCImpl.gen204PerformanceLoggerProvider.get(), boxFeatureBannerUtils(), this.singletonCImpl.userContextManagerProvider.get(), multiselectEnvironment(), browseAnalytics(), this.singletonCImpl.sessionManagerProvider.get(), this.singletonCImpl.metricsInteractorProvider.get(), this.singletonCImpl.providesApdexServiceProvider.get(), appStartApdexTracker(), itemModelStateMapper(), this.singletonCImpl.boxModelOfflineManagerWrapper(), CommonModule_ProvidesDefaultDispatcherFactory.providesDefaultDispatcher(), this.singletonCImpl.providesSortPreferencesProvider.get());
        }

        ActionableRecentViewEnvironment actionableRecentViewEnvironment() {
            return new ActionableRecentViewEnvironment(recentsViewEnvironment(), browseAnalytics(), this.singletonCImpl.boxAccountManagerHelper(), this.singletonCImpl.fileActionsManager(), offlineFilesEnvironment(), downloadEnvironment(), boxAiEnvironment());
        }

        RecentsEnvironment recentsEnvironment() {
            return new RecentsEnvironment(actionableRecentViewEnvironment());
        }

        OfflinedViewInteractor offlinedViewInteractor() {
            return new OfflinedViewInteractor(this.singletonCImpl.offlineService());
        }

        OfflinedViewEnvironment offlinedViewEnvironment() {
            return new OfflinedViewEnvironment(offlinedViewInteractor(), itemThumbnailEnvironment(), this.singletonCImpl.gen204PerformanceLoggerProvider.get(), boxFeatureBannerUtils(), this.singletonCImpl.userContextManagerProvider.get(), multiselectEnvironment(), browseAnalytics(), this.singletonCImpl.sessionManagerProvider.get(), this.singletonCImpl.metricsInteractorProvider.get(), this.singletonCImpl.providesApdexServiceProvider.get(), appStartApdexTracker(), itemModelStateMapper(), this.singletonCImpl.boxModelOfflineManagerWrapper(), CommonModule_ProvidesDefaultDispatcherFactory.providesDefaultDispatcher(), this.singletonCImpl.providesSortPreferencesProvider.get());
        }

        ActionableOfflinedViewEnvironment actionableOfflinedViewEnvironment() {
            return new ActionableOfflinedViewEnvironment(offlinedViewEnvironment(), browseAnalytics(), this.singletonCImpl.boxAccountManagerHelper(), this.singletonCImpl.fileActionsManager(), offlineFilesEnvironment(), downloadEnvironment(), boxAiEnvironment());
        }

        OfflinedEnvironment offlinedEnvironment() {
            return new OfflinedEnvironment(actionableOfflinedViewEnvironment(), offlinedViewInteractor());
        }

        NavigationEnvironment navigationEnvironment() {
            return new NavigationEnvironment(browseEnvironment(), recentsEnvironment(), offlinedEnvironment());
        }

        NotesFavoritesViewInteractor notesFavoritesViewInteractor() {
            return new NotesFavoritesViewInteractor(this.singletonCImpl.collectionsService(), this.singletonCImpl.getFavoritesCollectionIdInteractor(), this.activityRetainedCImpl.favoritesServiceProvider.get());
        }

        NotesFavoritesListEnvironment notesFavoritesListEnvironment() {
            return new NotesFavoritesListEnvironment(notesFavoritesViewInteractor(), itemThumbnailEnvironment(), this.singletonCImpl.gen204PerformanceLoggerProvider.get(), boxFeatureBannerUtils(), this.singletonCImpl.userContextManagerProvider.get(), multiselectEnvironment(), browseAnalytics(), this.singletonCImpl.sessionManagerProvider.get(), this.singletonCImpl.metricsInteractorProvider.get(), this.singletonCImpl.providesApdexServiceProvider.get(), appStartApdexTracker(), itemModelStateMapper(), this.singletonCImpl.boxModelOfflineManagerWrapper(), CommonModule_ProvidesDefaultDispatcherFactory.providesDefaultDispatcher(), this.singletonCImpl.providesSortPreferencesProvider.get());
        }

        NotesRecentsViewInteractor notesRecentsViewInteractor() {
            return new NotesRecentsViewInteractor(this.singletonCImpl.recentNotesServiceProvider.get(), this.activityRetainedCImpl.favoritesServiceProvider.get());
        }

        NotesRecentsListEnvironment notesRecentsListEnvironment() {
            return new NotesRecentsListEnvironment(notesRecentsViewInteractor(), itemThumbnailEnvironment(), this.singletonCImpl.gen204PerformanceLoggerProvider.get(), boxFeatureBannerUtils(), this.singletonCImpl.userContextManagerProvider.get(), multiselectEnvironment(), browseAnalytics(), this.singletonCImpl.sessionManagerProvider.get(), this.singletonCImpl.metricsInteractorProvider.get(), this.singletonCImpl.providesApdexServiceProvider.get(), appStartApdexTracker(), itemModelStateMapper(), this.singletonCImpl.boxModelOfflineManagerWrapper(), CommonModule_ProvidesDefaultDispatcherFactory.providesDefaultDispatcher(), this.singletonCImpl.providesSortPreferencesProvider.get());
        }

        SearchEnvironment searchEnvironment() {
            return new SearchEnvironment(this.singletonCImpl.searchServiceProvider.get(), hubsEnvironment(), itemEnvironment(), multiselectEnvironment(), this.singletonCImpl.clientSettingsService(), this.singletonCImpl.boxAiService(), this.singletonCImpl.boxAccountSettings(), this.singletonCImpl.offlineService(), this.singletonCImpl.featureFlipsProvider.get());
        }

        NotesTabsEnvironment notesTabsEnvironment() {
            return new NotesTabsEnvironment(new NotesAnalytics());
        }

        NotificationRegistrationCategoriesRepo notificationRegistrationCategoriesRepo() {
            return new NotificationRegistrationCategoriesRepo(this.singletonCImpl.baseModelController(), this.singletonCImpl.provideBoxApiPrivateProvider.get(), this.singletonCImpl.userContextManagerProvider.get());
        }

        RecentItemPickerEnvironment recentItemPickerEnvironment() {
            return new RecentItemPickerEnvironment(recentsViewEnvironment(), createFolderEnvironment());
        }

        SingleTaskRepo singleTaskRepo() {
            return new SingleTaskRepo(this.singletonCImpl.baseModelController(), this.singletonCImpl.provideBoxApiPrivateProvider.get());
        }

        TaskCollaboratorsRepo taskCollaboratorsRepo() {
            return new TaskCollaboratorsRepo(this.singletonCImpl.baseModelController(), this.singletonCImpl.provideBoxApiPrivateProvider.get());
        }

        UploadContentEnvironment uploadContentEnvironment() {
            return new UploadContentEnvironment(this.singletonCImpl.uploadFileProvider(), this.singletonCImpl.contentFileService());
        }

        DefaultAvatarComponentDataProvider defaultAvatarComponentDataProvider() {
            return new DefaultAvatarComponentDataProvider(this.singletonCImpl.userContextManagerProvider.get());
        }

        WatermarkingEnvironment watermarkingEnvironment() {
            return new WatermarkingEnvironment(this.singletonCImpl.watermarkService(), this.singletonCImpl.remoteItemService(), this.singletonCImpl.gen204WatermarkingEventLoggerProvider.get());
        }

        CopyOrMoveEnvironment copyOrMoveEnvironment() {
            return new CopyOrMoveEnvironment(folderViewEnvironment(), createFolderEnvironment(), this.singletonCImpl.localItemServiceProvider.get());
        }

        GetFileActivitiesInteractor getFileActivitiesInteractor() {
            return new GetFileActivitiesInteractor(this.singletonCImpl.fileActivitiesService());
        }

        CreateCommentInteractor createCommentInteractor() {
            return new CreateCommentInteractor(this.singletonCImpl.commentService(), this.singletonCImpl.idMappingService(), this.singletonCImpl.provideCommentsControllerProvider.get(), this.singletonCImpl.remoteItemService(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        UpdateCommentInteractor updateCommentInteractor() {
            return new UpdateCommentInteractor(this.singletonCImpl.commentService(), this.singletonCImpl.idMappingService());
        }

        DeleteCommentInteractor deleteCommentInteractor() {
            return new DeleteCommentInteractor(this.singletonCImpl.commentService(), this.singletonCImpl.remoteItemService());
        }

        CreateReplyInteractor createReplyInteractor() {
            return new CreateReplyInteractor(this.singletonCImpl.commentService(), this.singletonCImpl.idMappingService());
        }

        UpdateAnnotationInteractor updateAnnotationInteractor() {
            return new UpdateAnnotationInteractor(this.singletonCImpl.annotationsService(), this.singletonCImpl.idMappingService());
        }

        DeleteAnnotationInteractor deleteAnnotationInteractor() {
            return new DeleteAnnotationInteractor(this.singletonCImpl.annotationsService(), this.singletonCImpl.remoteItemService());
        }

        Gen204FileActivityEventLogger gen204FileActivityEventLogger() {
            return new Gen204FileActivityEventLogger(this.singletonCImpl.metricsInteractorProvider.get());
        }

        CollaboratorsMentionsEnvironment collaboratorsMentionsEnvironment() {
            return new CollaboratorsMentionsEnvironment(gen204FileActivityEventLogger(), this.singletonCImpl.commentControllerBridge());
        }

        CommentWithMentionsEnvironment commentWithMentionsEnvironment() {
            return new CommentWithMentionsEnvironment(collaboratorsMentionsEnvironment());
        }

        FileActivitiesEnvironment fileActivitiesEnvironment() {
            return new FileActivitiesEnvironment(getFileActivitiesInteractor(), this.singletonCImpl.boxPreviewRouter(), this.singletonCImpl.userContextManagerProvider.get(), createCommentInteractor(), updateCommentInteractor(), deleteCommentInteractor(), createReplyInteractor(), createReplyInteractor(), updateAnnotationInteractor(), deleteAnnotationInteractor(), gen204FileActivityEventLogger(), commentWithMentionsEnvironment(), this.singletonCImpl.featureFlipsProvider.get(), this.singletonCImpl.remoteItemService());
        }

        GalleryItemsEnvironment galleryItemsEnvironment() {
            return new GalleryItemsEnvironment(this.singletonCImpl.galleryItemsService(), itemThumbnailEnvironment());
        }

        HubSpecificUrlHandler hubSpecificUrlHandler() {
            return new HubSpecificUrlHandler(this.singletonCImpl.remoteItemService());
        }

        HubDetailsEnvironment hubDetailsEnvironment() {
            return new HubDetailsEnvironment(this.singletonCImpl.boxUriSupportChecker(), hubSpecificUrlHandler(), this.singletonCImpl.bVEManager());
        }

        UpdateItemInfoEnvironment updateItemInfoEnvironment() {
            return new UpdateItemInfoEnvironment(this.singletonCImpl.updateItemInfoService(), new ItemNameValidator());
        }

        ItemInformationEnvironment itemInformationEnvironment() {
            return new ItemInformationEnvironment(this.singletonCImpl.itemCollaborationsService(), updateItemInfoEnvironment(), itemThumbnailEnvironment(), this.singletonCImpl.remoteItemService(), this.singletonCImpl.fileMetadataService(), new ItemInformationAnalytics());
        }

        PreviewPlaylistEnvironment previewPlaylistEnvironment() {
            return new PreviewPlaylistEnvironment(this.singletonCImpl.audioPlaylistItemsService(), this.singletonCImpl.media3AudioPlayerManagerProvider.get());
        }

        GetAnnotationForFileVersionInteractor getAnnotationForFileVersionInteractor() {
            return new GetAnnotationForFileVersionInteractor(this.singletonCImpl.annotationsService(), this.singletonCImpl.idMappingService());
        }

        PdfAnnotationModelMapper pdfAnnotationModelMapper() {
            return new PdfAnnotationModelMapper(this.singletonCImpl.provideApplicationContextProvider.get());
        }

        AnnotationsEnvironment annotationsEnvironment() {
            return new AnnotationsEnvironment(getAnnotationForFileVersionInteractor(), pdfAnnotationModelMapper(), this.activityRetainedCImpl.annotationManagersProvider.get(), deleteAnnotationInteractor(), this.singletonCImpl.featureFlipsProvider.get());
        }

        CreateAnnotationInteractor createAnnotationInteractor() {
            return new CreateAnnotationInteractor(this.singletonCImpl.annotationsService(), this.singletonCImpl.remoteItemService());
        }

        CreateAnnotationEnvironment createAnnotationEnvironment() {
            return new CreateAnnotationEnvironment(commentWithMentionsEnvironment(), pdfAnnotationModelMapper(), createAnnotationInteractor(), this.activityRetainedCImpl.annotationManagersProvider.get());
        }

        CopySelectedTextEnvironment copySelectedTextEnvironment() {
            return new CopySelectedTextEnvironment(this.singletonCImpl.clipboardService(), new TextSelectionManager());
        }

        DocumentSearchEnvironment documentSearchEnvironment() {
            return new DocumentSearchEnvironment(this.singletonCImpl.textSearchManagerProvider.get());
        }

        PrintEnvironment printEnvironment() {
            return new PrintEnvironment(this.singletonCImpl.fileActionsManager());
        }

        CitationHighlightEnvironment citationHighlightEnvironment() {
            return new CitationHighlightEnvironment(this.singletonCImpl.textSearchManagerProvider.get());
        }

        DocumentPreviewEnvironment documentPreviewEnvironment() {
            return new DocumentPreviewEnvironment(annotationsEnvironment(), createAnnotationEnvironment(), this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.previewSettingsService(), new ScrollableFileTypeResolver(), this.singletonCImpl.previewObservabilityProvider.get(), this.singletonCImpl.boxAccountManagerHelper(), copySelectedTextEnvironment(), documentSearchEnvironment(), this.activityRetainedCImpl.previewAnalyticsProvider.get(), printEnvironment(), citationHighlightEnvironment());
        }

        ImagePreviewEnvironment imagePreviewEnvironment() {
            return new ImagePreviewEnvironment(annotationsEnvironment(), createAnnotationEnvironment(), this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.previewObservabilityProvider.get());
        }

        GifPreviewEnvironment gifPreviewEnvironment() {
            return new GifPreviewEnvironment(this.singletonCImpl.previewObservabilityProvider.get());
        }

        PreviewOfflineLabelEnvironment previewOfflineLabelEnvironment() {
            return new PreviewOfflineLabelEnvironment(this.singletonCImpl.fileActionsManager(), this.singletonCImpl.offlineService(), this.singletonCImpl.boxModelOfflineManagerWrapper());
        }

        ItemPreviewLabelsEnvironment itemPreviewLabelsEnvironment() {
            return new ItemPreviewLabelsEnvironment(previewOfflineLabelEnvironment(), this.singletonCImpl.featureFlipsProvider.get());
        }

        VideoPlayerInteractor videoPlayerInteractor() {
            return new VideoPlayerInteractor(this.activityRetainedCImpl.videoPlayersProvider.get());
        }

        FrameExporter frameExporter() {
            return new FrameExporter(this.activityRetainedCImpl.videoPlayersProvider.get(), this.singletonCImpl.videoMediaSourceFactory());
        }

        FrameAnnotationEnvironment frameAnnotationEnvironment() {
            return new FrameAnnotationEnvironment(videoPlayerInteractor(), createAnnotationEnvironment(), this.singletonCImpl.userContextManagerProvider.get(), frameExporter(), annotationsEnvironment());
        }

        VideoPreviewEnvironment videoPreviewEnvironment() {
            return new VideoPreviewEnvironment(this.singletonCImpl.previewObservabilityProvider.get(), this.activityRetainedCImpl.previewAnalyticsProvider.get(), videoPlayerInteractor(), frameAnnotationEnvironment());
        }

        CodeFileReader codeFileReader() {
            return new CodeFileReader(CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        CodePreviewEnvironment codePreviewEnvironment() {
            return new CodePreviewEnvironment(codeFileReader());
        }

        BoxNotesUrlBuilder boxNotesUrlBuilder() {
            return new BoxNotesUrlBuilder(this.singletonCImpl.configManagerProvider.get());
        }

        BoxNoteEditModeEnvironment boxNoteEditModeEnvironment() {
            return new BoxNoteEditModeEnvironment(new BoxNoteRequestBuilder(), this.singletonCImpl.clipboardService(), this.singletonCImpl.userContextManagerProvider.get());
        }

        BoxNotesEnvironment boxNotesEnvironment() {
            return new BoxNotesEnvironment(this.singletonCImpl.sessionManagerProvider.get(), boxNotesUrlBuilder(), boxNoteEditModeEnvironment(), this.singletonCImpl.remoteItemService(), this.singletonCImpl.providesFileCanBePreviewedCheckerProvider.get(), this.activityRetainedCImpl.previewAnalyticsProvider.get());
        }

        ItemPreviewEnvironment itemPreviewEnvironment() {
            return new ItemPreviewEnvironment(this.singletonCImpl.bridgedPreviewServiceProvider.get(), this.singletonCImpl.localItemServiceProvider.get(), this.singletonCImpl.offlineService(), this.singletonCImpl.thumbnailPreviewInteractorProvider.get(), documentPreviewEnvironment(), imagePreviewEnvironment(), gifPreviewEnvironment(), itemPreviewLabelsEnvironment(), videoPreviewEnvironment(), codePreviewEnvironment(), boxNotesEnvironment(), this.singletonCImpl.fileActionsManager(), this.singletonCImpl.previewObservabilityProvider.get(), this.singletonCImpl.boxAiService(), this.activityRetainedCImpl.previewAnalyticsProvider.get(), this.singletonCImpl.featureFlipsProvider.get(), this.singletonCImpl.getBoxAiAvailabilityInteractor());
        }

        TrackRecentPreviewItemInteractor trackRecentPreviewItemInteractor() {
            return new TrackRecentPreviewItemInteractor(this.singletonCImpl.recentsService(), this.singletonCImpl.recentNotesServiceProvider.get());
        }

        CopyLinkEnvironment copyLinkEnvironment() {
            return new CopyLinkEnvironment(this.singletonCImpl.clipboardService(), this.singletonCImpl.sharedLinkService());
        }

        DeleteEnvironment deleteEnvironment() {
            return new DeleteEnvironment(this.singletonCImpl.localItemServiceProvider.get());
        }

        EndCollaborationEnvironment endCollaborationEnvironment() {
            return new EndCollaborationEnvironment(this.singletonCImpl.localItemServiceProvider.get(), this.singletonCImpl.userContextManagerProvider.get());
        }

        OpenInEnvironment openInEnvironment() {
            return new OpenInEnvironment(this.singletonCImpl.fileActionsManager(), this.singletonCImpl.wopiService());
        }

        FileActionsEnvironment fileActionsEnvironment() {
            return new FileActionsEnvironment(this.singletonCImpl.fileActionsManager(), this.singletonCImpl.offlineService(), copyLinkEnvironment(), deleteEnvironment(), endCollaborationEnvironment(), updateItemInfoEnvironment(), openInEnvironment(), downloadEnvironment(), offlineFilesEnvironment(), boxAiEnvironment(), this.activityRetainedCImpl.previewAnalyticsProvider.get(), this.singletonCImpl.boxModelOfflineManagerWrapper(), this.singletonCImpl.featureFlipsProvider.get());
        }

        TopBarEnvironment topBarEnvironment() {
            return new TopBarEnvironment(this.singletonCImpl.boxAccountManagerHelper());
        }

        BottomBarEnvironment bottomBarEnvironment() {
            return new BottomBarEnvironment(this.singletonCImpl.fileActionsManager(), this.singletonCImpl.boxAiService());
        }

        PreviewEnvironment previewEnvironment() {
            return new PreviewEnvironment(itemPreviewEnvironment(), this.singletonCImpl.jobManagerProvider.get(), this.singletonCImpl.featureFlipsProvider.get(), this.singletonCImpl.fileActionsManager(), trackRecentPreviewItemInteractor(), this.singletonCImpl.localItemServiceProvider.get(), this.activityRetainedCImpl.previewAnalyticsProvider.get(), fileActionsEnvironment(), this.singletonCImpl.galleryItemsService(), this.singletonCImpl.audioPlaylistItemsService(), topBarEnvironment(), bottomBarEnvironment());
        }

        PreviousVersionEnvironment previousVersionEnvironment() {
            return new PreviousVersionEnvironment(this.singletonCImpl.previousVersionPreviewService(), this.singletonCImpl.fileVersionService(), this.singletonCImpl.fileActionsManager(), documentPreviewEnvironment(), imagePreviewEnvironment(), videoPreviewEnvironment(), this.activityRetainedCImpl.previewAnalyticsProvider.get(), this.singletonCImpl.previousVersionPreviewObservabilityProvider.get());
        }

        private void initialize(final SavedStateHandle savedStateHandleParam, final ViewModelLifecycle viewModelLifecycleParam) {
            this.addTaskViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 0);
            this.allFilesViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 1);
            this.appUpdateProposalViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 2);
            this.biometricsVMProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 3);
            this.boxAiHomeViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 4);
            this.browseTabsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 5);
            this.captureHistoryButtonViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 6);
            this.captureHistoryViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 7);
            this.captureMediaHandlerViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 8);
            this.captureSettingsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 9);
            this.captureViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 10);
            this.collectionItemsListViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 11);
            this.collectionsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 12);
            this.contentPickerViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 13);
            this.favoritesCollectionItemsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 14);
            this.filesSearchViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 15);
            this.folderItemPickerViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 16);
            this.homeScreenViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 17);
            this.hubsItemPickerViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 18);
            this.hubsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 19);
            this.inboxBadgeVMProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 20);
            this.inboxCountViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 21);
            this.inboxTabsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 22);
            this.inboxViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 23);
            this.jobsProgressViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 24);
        }

        private void initialize2(final SavedStateHandle savedStateHandleParam, final ViewModelLifecycle viewModelLifecycleParam) {
            this.jobsUIViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 25);
            this.mainNavigationViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 26);
            this.myCollectionsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 27);
            this.navigationViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 28);
            this.newNoteCreationViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 29);
            this.notesFavoritesViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 30);
            this.notesRecentsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 31);
            this.notesSearchViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 32);
            this.notesTabsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 33);
            this.offlinedViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 34);
            this.pushRegistrationDialogVMProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 35);
            this.recentsItemPickerViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 36);
            this.recentsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 37);
            this.recorderServiceViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 38);
            this.searchItemPickerViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 39);
            this.singleTaskVMProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 40);
            this.taskCollaboratorsVMProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 41);
            this.uploadContentHandlerViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 42);
            this.userAvatarViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 43);
            this.watermarkingViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 44);
            this.factoryProvider = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 45));
            this.factoryProvider2 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 46));
            this.factoryProvider3 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 47));
            this.factoryProvider4 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 48));
            this.factoryProvider5 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 49));
        }

        private void initialize3(final SavedStateHandle savedStateHandleParam, final ViewModelLifecycle viewModelLifecycleParam) {
            this.factoryProvider6 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 50));
            this.factoryProvider7 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 51));
            this.factoryProvider8 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 52));
            this.factoryProvider9 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 53));
            this.factoryProvider10 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 54));
            this.factoryProvider11 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 55));
            this.factoryProvider12 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 56));
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ViewModelFactoriesEntryPoint
        public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
            return LazyClassKeyMap.of(ImmutableMap.builderWithExpectedSize(45).put(AddTaskViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.addTaskViewModelProvider).put(AllFilesViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.allFilesViewModelProvider).put(AppUpdateProposalViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.appUpdateProposalViewModelProvider).put(BiometricsVM_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.biometricsVMProvider).put(BoxAiHomeViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.boxAiHomeViewModelProvider).put(BrowseTabsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.browseTabsViewModelProvider).put(CaptureHistoryButtonViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.captureHistoryButtonViewModelProvider).put(CaptureHistoryViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.captureHistoryViewModelProvider).put(CaptureMediaHandlerViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.captureMediaHandlerViewModelProvider).put(CaptureSettingsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.captureSettingsViewModelProvider).put(CaptureViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.captureViewModelProvider).put(CollectionItemsListViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.collectionItemsListViewModelProvider).put(CollectionsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.collectionsViewModelProvider).put(ContentPickerViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.contentPickerViewModelProvider).put(FavoritesCollectionItemsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.favoritesCollectionItemsViewModelProvider).put(FilesSearchViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.filesSearchViewModelProvider).put(FolderItemPickerViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.folderItemPickerViewModelProvider).put(HomeScreenViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.homeScreenViewModelProvider).put(HubsItemPickerViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.hubsItemPickerViewModelProvider).put(HubsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.hubsViewModelProvider).put(InboxBadgeVM_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.inboxBadgeVMProvider).put(InboxCountViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.inboxCountViewModelProvider).put(InboxTabsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.inboxTabsViewModelProvider).put(InboxViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.inboxViewModelProvider).put(JobsProgressViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.jobsProgressViewModelProvider).put(JobsUIViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.jobsUIViewModelProvider).put(MainNavigationViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.mainNavigationViewModelProvider).put(MyCollectionsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.myCollectionsViewModelProvider).put(NavigationViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.navigationViewModelProvider).put(NewNoteCreationViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.newNoteCreationViewModelProvider).put(NotesFavoritesViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.notesFavoritesViewModelProvider).put(NotesRecentsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.notesRecentsViewModelProvider).put(NotesSearchViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.notesSearchViewModelProvider).put(NotesTabsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.notesTabsViewModelProvider).put(OfflinedViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.offlinedViewModelProvider).put(PushRegistrationDialogVM_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.pushRegistrationDialogVMProvider).put(RecentsItemPickerViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.recentsItemPickerViewModelProvider).put(RecentsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.recentsViewModelProvider).put(RecorderServiceViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.recorderServiceViewModelProvider).put(SearchItemPickerViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.searchItemPickerViewModelProvider).put(SingleTaskVM_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.singleTaskVMProvider).put(TaskCollaboratorsVM_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.taskCollaboratorsVMProvider).put(UploadContentHandlerViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.uploadContentHandlerViewModelProvider).put(UserAvatarViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.userAvatarViewModelProvider).put(WatermarkingViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.watermarkingViewModelProvider).build());
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ViewModelFactoriesEntryPoint
        public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
            return LazyClassKeyMap.of(ImmutableMap.builderWithExpectedSize(12).put(CollectionItemsViewModel_HiltModules_BindsModule_Bind_LazyMapKey.lazyClassKeyName, this.factoryProvider.get()).put(CollectionMembershipsViewModel_HiltModules_BindsModule_Bind_LazyMapKey.lazyClassKeyName, this.factoryProvider2.get()).put(CopyOrMoveViewModel_HiltModules_BindsModule_Bind_LazyMapKey.lazyClassKeyName, this.factoryProvider3.get()).put(FileActivitiesViewModel_HiltModules_BindsModule_Bind_LazyMapKey.lazyClassKeyName, this.factoryProvider4.get()).put(GalleryItemsViewModel_HiltModules_BindsModule_Bind_LazyMapKey.lazyClassKeyName, this.factoryProvider5.get()).put(HubDetailsViewModel_HiltModules_BindsModule_Bind_LazyMapKey.lazyClassKeyName, this.factoryProvider6.get()).put(ItemInformationViewModel_HiltModules_BindsModule_Bind_LazyMapKey.lazyClassKeyName, this.factoryProvider7.get()).put(ItemPickerViewModel_HiltModules_BindsModule_Bind_LazyMapKey.lazyClassKeyName, this.factoryProvider8.get()).put(PreviewPlaylistViewModel_HiltModules_BindsModule_Bind_LazyMapKey.lazyClassKeyName, this.factoryProvider9.get()).put(PreviewViewModel_HiltModules_BindsModule_Bind_LazyMapKey.lazyClassKeyName, this.factoryProvider10.get()).put(PreviousVersionViewModel_HiltModules_BindsModule_Bind_LazyMapKey.lazyClassKeyName, this.factoryProvider11.get()).put(SearchViewModel_HiltModules_BindsModule_Bind_LazyMapKey.lazyClassKeyName, this.factoryProvider12.get()).build());
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityRetainedCImpl activityRetainedCImpl;
            private final int id;
            private final SingletonCImpl singletonCImpl;
            private final ViewModelCImpl viewModelCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ViewModelCImpl viewModelCImpl, int id) {
                this.singletonCImpl = singletonCImpl;
                this.activityRetainedCImpl = activityRetainedCImpl;
                this.viewModelCImpl = viewModelCImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        return (T) new AddTaskViewModel(this.viewModelCImpl.addTaskEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory(), this.viewModelCImpl.savedStateHandle);
                    case 1:
                        return (T) new AllFilesViewModel(this.viewModelCImpl.browseEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 2:
                        return (T) new AppUpdateProposalViewModel(this.viewModelCImpl.appUpdateProposalEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 3:
                        return (T) new BiometricsVM(ApplicationContextModule_ProvideApplicationFactory.provideApplication(this.singletonCImpl.applicationContextModule), this.singletonCImpl.userContextManagerProvider.get(), BaseModule_Companion_ProvideApiExecutorFactory.provideApiExecutor());
                    case 4:
                        return (T) new BoxAiHomeViewModel(this.viewModelCImpl.boxAiHomeEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory(), this.viewModelCImpl.savedStateHandle);
                    case 5:
                        return (T) new BrowseTabsViewModel(this.viewModelCImpl.browseTabsEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 6:
                        return (T) new CaptureHistoryButtonViewModel(this.singletonCImpl.captureHistoryInteractor(), this.singletonCImpl.captureThumbnailService());
                    case 7:
                        return (T) new CaptureHistoryViewModel(this.singletonCImpl.captureHistoryInteractor(), this.singletonCImpl.deleteCaptureHistoryInteractor());
                    case 8:
                        return (T) new CaptureMediaHandlerViewModel(this.viewModelCImpl.captureMediaEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 9:
                        return (T) new CaptureSettingsViewModel(this.viewModelCImpl.captureSettingsEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 10:
                        return (T) new CaptureViewModel(this.viewModelCImpl.captureUploadFileManager(), this.viewModelCImpl.captureEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 11:
                        return (T) new CollectionItemsListViewModel(this.viewModelCImpl.collectionItemsListEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory(), this.viewModelCImpl.savedStateHandle);
                    case 12:
                        return (T) new CollectionsViewModel(this.viewModelCImpl.collectionsEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 13:
                        return (T) new ContentPickerViewModel(this.viewModelCImpl.contentPickerEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 14:
                        return (T) new FavoritesCollectionItemsViewModel(this.viewModelCImpl.listCollectionItemsInteractor(), this.singletonCImpl.getFavoritesCollectionIdInteractor());
                    case 15:
                        return (T) new FilesSearchViewModel(CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory(), this.viewModelCImpl.filesSearchEnvironment());
                    case 16:
                        return (T) new FolderItemPickerViewModel(this.viewModelCImpl.folderItemPickerEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory(), CommonModule_ProvidesResourcesProviderFactory.providesResourcesProvider(), this.viewModelCImpl.savedStateHandle);
                    case 17:
                        return (T) new HomeScreenViewModel(this.viewModelCImpl.homeScreenEnvironment());
                    case 18:
                        return (T) new HubsItemPickerViewModel(this.viewModelCImpl.hubsEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory(), new AppIntentServices());
                    case 19:
                        return (T) new HubsViewModel(this.viewModelCImpl.hubsEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 20:
                        return (T) new InboxBadgeVM(this.singletonCImpl.inboxBadgeRepositoryProvider.get());
                    case 21:
                        return (T) new InboxCountViewModel(this.viewModelCImpl.inboxCountEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 22:
                        return (T) new InboxTabsViewModel(this.viewModelCImpl.inboxTabsEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 23:
                        return (T) new InboxViewModel(this.viewModelCImpl.inboxEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 24:
                        return (T) new JobsProgressViewModel(this.viewModelCImpl.jobsProgressEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 25:
                        return (T) new JobsUIViewModel(this.viewModelCImpl.jobsReducer(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 26:
                        return (T) new MainNavigationViewModel();
                    case 27:
                        return (T) new MyCollectionsViewModel(this.singletonCImpl.listCollectionsInteractor(), this.viewModelCImpl.createCollectionInteractor());
                    case 28:
                        return (T) new NavigationViewModel(this.viewModelCImpl.navigationEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 29:
                        return (T) new NewNoteCreationViewModel(this.singletonCImpl.resolveNewNoteLocationInteractor(), this.singletonCImpl.setDefaultNoteFolderInteractor(), this.singletonCImpl.defaultNoteFolderServiceProvider.get(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 30:
                        return (T) new NotesFavoritesViewModel(this.viewModelCImpl.notesFavoritesListEnvironment(), this.activityRetainedCImpl.favoritesServiceProvider.get(), new NotesAnalytics(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 31:
                        return (T) new NotesRecentsViewModel(this.viewModelCImpl.notesRecentsListEnvironment(), this.activityRetainedCImpl.favoritesServiceProvider.get(), new NotesAnalytics(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 32:
                        return (T) new NotesSearchViewModel(CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory(), this.viewModelCImpl.searchEnvironment());
                    case 33:
                        return (T) new NotesTabsViewModel(this.viewModelCImpl.notesTabsEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 34:
                        return (T) new OfflinedViewModel(this.viewModelCImpl.offlinedEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 35:
                        return (T) new PushRegistrationDialogVM(this.viewModelCImpl.notificationRegistrationCategoriesRepo(), this.singletonCImpl.systemInfoProvider.get());
                    case 36:
                        return (T) new RecentsItemPickerViewModel(this.viewModelCImpl.recentItemPickerEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 37:
                        return (T) new RecentsViewModel(this.viewModelCImpl.recentsEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 38:
                        return (T) new RecorderServiceViewModel(this.singletonCImpl.recordingFileManager());
                    case 39:
                        return (T) new SearchItemPickerViewModel(CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory(), this.viewModelCImpl.searchEnvironment(), new AppIntentServices(), this.viewModelCImpl.savedStateHandle);
                    case 40:
                        return (T) new SingleTaskVM(this.singletonCImpl.provideTasksRepoProvider.get(), this.viewModelCImpl.singleTaskRepo());
                    case 41:
                        return (T) new TaskCollaboratorsVM(this.viewModelCImpl.taskCollaboratorsRepo(), this.viewModelCImpl.singleTaskRepo());
                    case 42:
                        return (T) new UploadContentHandlerViewModel(this.viewModelCImpl.uploadContentEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                    case 43:
                        return (T) new UserAvatarViewModel(this.viewModelCImpl.defaultAvatarComponentDataProvider());
                    case 44:
                        return (T) new WatermarkingViewModel(this.viewModelCImpl.watermarkingEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory(), this.viewModelCImpl.savedStateHandle);
                    case 45:
                        return (T) new CollectionItemsViewModel.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ViewModelCImpl.SwitchingProvider.1
                            @Override // com.box.android.common.utilities.ViewModelAssistedFactory
                            public CollectionItemsViewModel create(Bundle args) {
                                return new CollectionItemsViewModel(args, SwitchingProvider.this.viewModelCImpl.listCollectionItemsInteractor(), SwitchingProvider.this.singletonCImpl.listCollectionsInteractor());
                            }
                        };
                    case 46:
                        return (T) new CollectionMembershipsViewModel.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ViewModelCImpl.SwitchingProvider.2
                            @Override // com.box.android.common.utilities.ViewModelAssistedFactory
                            public CollectionMembershipsViewModel create(Bundle args2) {
                                return new CollectionMembershipsViewModel(args2, SwitchingProvider.this.singletonCImpl.listCollectionsInteractor(), SwitchingProvider.this.singletonCImpl.collectionMembershipsInteractor(), SwitchingProvider.this.viewModelCImpl.createCollectionInteractor());
                            }
                        };
                    case 47:
                        return (T) new CopyOrMoveViewModel.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ViewModelCImpl.SwitchingProvider.3
                            @Override // com.box.android.common.utilities.ViewModelAssistedFactory
                            public CopyOrMoveViewModel create(Bundle args3) {
                                return new CopyOrMoveViewModel(args3, SwitchingProvider.this.viewModelCImpl.copyOrMoveEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                            }
                        };
                    case 48:
                        return (T) new FileActivitiesViewModel.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ViewModelCImpl.SwitchingProvider.4
                            @Override // com.box.android.common.utilities.ViewModelAssistedFactory
                            public FileActivitiesViewModel create(Bundle args4) {
                                return new FileActivitiesViewModel(args4, SwitchingProvider.this.viewModelCImpl.fileActivitiesEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                            }
                        };
                    case 49:
                        return (T) new GalleryItemsViewModel.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ViewModelCImpl.SwitchingProvider.5
                            @Override // com.box.android.common.utilities.ViewModelAssistedFactory
                            public GalleryItemsViewModel create(Bundle args5) {
                                return new GalleryItemsViewModel(args5, SwitchingProvider.this.viewModelCImpl.galleryItemsEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                            }
                        };
                    case 50:
                        return (T) new HubDetailsViewModel.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ViewModelCImpl.SwitchingProvider.6
                            @Override // com.box.android.common.utilities.ViewModelAssistedFactory
                            public HubDetailsViewModel create(Bundle args6) {
                                return new HubDetailsViewModel(args6, CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory(), SwitchingProvider.this.viewModelCImpl.hubDetailsEnvironment());
                            }
                        };
                    case 51:
                        return (T) new ItemInformationViewModel.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ViewModelCImpl.SwitchingProvider.7
                            @Override // com.box.android.common.utilities.ViewModelAssistedFactory
                            public ItemInformationViewModel create(Bundle args7) {
                                return new ItemInformationViewModel(args7, SwitchingProvider.this.viewModelCImpl.itemInformationEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                            }
                        };
                    case 52:
                        return (T) new ItemPickerViewModel.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ViewModelCImpl.SwitchingProvider.8
                            @Override // com.box.android.common.utilities.ViewModelAssistedFactory
                            public ItemPickerViewModel create(Bundle args8) {
                                return new ItemPickerViewModel(args8, SwitchingProvider.this.viewModelCImpl.folderItemPickerEnvironment(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                            }
                        };
                    case 53:
                        return (T) new PreviewPlaylistViewModel.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ViewModelCImpl.SwitchingProvider.9
                            @Override // com.box.android.common.utilities.ViewModelAssistedFactory
                            public PreviewPlaylistViewModel create(Bundle args9) {
                                return new PreviewPlaylistViewModel(args9, CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory(), SwitchingProvider.this.viewModelCImpl.previewPlaylistEnvironment());
                            }
                        };
                    case 54:
                        return (T) new PreviewViewModel.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ViewModelCImpl.SwitchingProvider.10
                            @Override // com.box.android.common.utilities.ViewModelAssistedFactory
                            public PreviewViewModel create(Bundle args10) {
                                return new PreviewViewModel(args10, SwitchingProvider.this.viewModelCImpl.previewEnvironment(), SwitchingProvider.this.singletonCImpl.previewPrefetcher(), CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory());
                            }
                        };
                    case 55:
                        return (T) new PreviousVersionViewModel.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ViewModelCImpl.SwitchingProvider.11
                            @Override // com.box.android.common.utilities.ViewModelAssistedFactory
                            public PreviousVersionViewModel create(Bundle args11) {
                                return new PreviousVersionViewModel(args11, CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory(), SwitchingProvider.this.viewModelCImpl.previousVersionEnvironment());
                            }
                        };
                    case 56:
                        return (T) new SearchViewModel.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.ViewModelCImpl.SwitchingProvider.12
                            @Override // com.box.android.common.utilities.ViewModelAssistedFactory
                            public SearchViewModel create(Bundle args12) {
                                return new SearchViewModel(CommonModule_ProvidesStoreFactoryFactory.providesStoreFactory(), SwitchingProvider.this.viewModelCImpl.searchEnvironment(), new BrowseSearchAnalytics(), args12);
                            }
                        };
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }

    private static final class ActivityRetainedCImpl extends BoxApplication_HiltComponents.ActivityRetainedC {
        private final ActivityRetainedCImpl activityRetainedCImpl = this;
        Provider<AnnotationManagersProvider> annotationManagersProvider;
        Provider<FavoritesService> favoritesServiceProvider;
        Provider<PreviewAnalytics> previewAnalyticsProvider;
        Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;
        Provider<SelectionManager> selectionManagerProvider;
        private final SingletonCImpl singletonCImpl;
        Provider<VideoPlayersProvider> videoPlayersProvider;

        ActivityRetainedCImpl(SingletonCImpl singletonCImpl, SavedStateHandleHolder savedStateHandleHolderParam) {
            this.singletonCImpl = singletonCImpl;
            initialize(savedStateHandleHolderParam);
        }

        BoxModelOfflineManager.Manager manager() {
            return new BoxModelOfflineManager.Manager(this.singletonCImpl.userContextManagerProvider.get());
        }

        private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
            this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, 0));
            this.selectionManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, 1));
            this.videoPlayersProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, 2));
            this.favoritesServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, 3));
            this.annotationManagersProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, 4));
            this.previewAnalyticsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, 5));
        }

        @Override // dagger.hilt.android.internal.managers.ActivityComponentManager.ActivityComponentBuilderEntryPoint
        public ActivityComponentBuilder activityComponentBuilder() {
            return new ActivityCBuilder(this.singletonCImpl, this.activityRetainedCImpl);
        }

        @Override // dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.ActivityRetainedLifecycleEntryPoint
        public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
            return this.provideActivityRetainedLifecycleProvider.get();
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityRetainedCImpl activityRetainedCImpl;
            private final int id;
            private final SingletonCImpl singletonCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, int id) {
                this.singletonCImpl = singletonCImpl;
                this.activityRetainedCImpl = activityRetainedCImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                int i = this.id;
                if (i == 0) {
                    return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();
                }
                if (i == 1) {
                    return (T) new SelectionManager(this.activityRetainedCImpl.manager(), new BoxAccountManager.Manager());
                }
                if (i == 2) {
                    return (T) new VideoPlayersProvider();
                }
                if (i == 3) {
                    return (T) new FavoritesService(this.singletonCImpl.collectionsService(), this.singletonCImpl.getFavoritesCollectionIdInteractor(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                }
                if (i == 4) {
                    return (T) new AnnotationManagersProvider();
                }
                if (i == 5) {
                    return (T) new PreviewAnalytics(this.singletonCImpl.wopiPropertyBuilderProvider.get());
                }
                throw new AssertionError(this.id);
            }
        }
    }

    private static final class ServiceCImpl extends BoxApplication_HiltComponents.ServiceC {
        private final ServiceCImpl serviceCImpl = this;
        private final SingletonCImpl singletonCImpl;

        ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
            this.singletonCImpl = singletonCImpl;
        }

        FirebaseMessagingListenerServiceHelper firebaseMessagingListenerServiceHelper() {
            return new FirebaseMessagingListenerServiceHelper(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideBoxApiPrivateProvider.get(), this.singletonCImpl.featureFlipsProvider.get());
        }

        FirebaseTokenRegistration firebaseTokenRegistration() {
            return new FirebaseTokenRegistration(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideBoxApiPrivateProvider.get(), this.singletonCImpl.featureFlipsProvider.get(), this.singletonCImpl.registerPushDeviceInteractorProvider.get(), this.singletonCImpl.updateDeviceRegistrationInteractorProvider.get(), this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get());
        }

        @Override // com.box.android.activities.share.CopyLinkService_GeneratedInjector
        public void injectCopyLinkService(CopyLinkService arg0) {
            injectCopyLinkService2(arg0);
        }

        @Override // com.box.android.capture.audiorecording.RecorderService_GeneratedInjector
        public void injectRecorderService(RecorderService arg0) {
            injectRecorderService2(arg0);
        }

        @Override // com.box.android.preview.previewtype.audio.AudioPlayerService_GeneratedInjector
        public void injectAudioPlayerService(AudioPlayerService arg0) {
            injectAudioPlayerService2(arg0);
        }

        @Override // com.box.android.services.FirebaseMessagingListenerService_GeneratedInjector
        public void injectFirebaseMessagingListenerService(FirebaseMessagingListenerService arg0) {
            injectFirebaseMessagingListenerService2(arg0);
        }

        @Override // com.box.android.services.FirebaseTokenHandlerService_GeneratedInjector
        public void injectFirebaseTokenHandlerService(FirebaseTokenHandlerService arg0) {
            injectFirebaseTokenHandlerService2(arg0);
        }

        @Override // com.box.android.sync.AuthenticatorService_GeneratedInjector
        public void injectAuthenticatorService(AuthenticatorService arg0) {
            injectAuthenticatorService2(arg0);
        }

        private CopyLinkService injectCopyLinkService2(CopyLinkService instance) {
            CopyLinkService_MembersInjector.injectMController(instance, this.singletonCImpl.shareModelControllerProvider.get());
            return instance;
        }

        private RecorderService injectRecorderService2(RecorderService instance2) {
            RecorderService_MembersInjector.injectRecordingFileManager(instance2, this.singletonCImpl.recordingFileManager());
            RecorderService_MembersInjector.injectUserContextManager(instance2, this.singletonCImpl.userContextManagerProvider.get());
            return instance2;
        }

        private AudioPlayerService injectAudioPlayerService2(AudioPlayerService instance3) {
            AudioPlayerService_MembersInjector.injectAudioPlayerManager(instance3, this.singletonCImpl.media3AudioPlayerManagerProvider.get());
            return instance3;
        }

        private FirebaseMessagingListenerService injectFirebaseMessagingListenerService2(FirebaseMessagingListenerService instance4) {
            FirebaseMessagingListenerService_MembersInjector.injectHelper(instance4, firebaseMessagingListenerServiceHelper());
            return instance4;
        }

        private FirebaseTokenHandlerService injectFirebaseTokenHandlerService2(FirebaseTokenHandlerService instance5) {
            FirebaseTokenHandlerService_MembersInjector.injectFirebaseTokenRegistration(instance5, firebaseTokenRegistration());
            return instance5;
        }

        private AuthenticatorService injectAuthenticatorService2(AuthenticatorService instance6) {
            AuthenticatorService_MembersInjector.injectMIntentServices(instance6, new AppIntentServices());
            return instance6;
        }
    }

    private static final class SingletonCImpl extends BoxApplication_HiltComponents.SingletonC {
        Provider<AiCenterSessionInfoProviderImpl> aiCenterSessionInfoProviderImplProvider;
        Provider<AllWorkerFactories> allWorkerFactoriesProvider;
        Provider<IAppInBackgroundService> appInBackgroundServiceProvider;
        Provider<AppStartHandler> appStartHandlerProvider;
        Provider<AppUpdateProposalManager> appUpdateProposalManagerProvider;
        private final ApplicationContextModule applicationContextModule;
        Provider<AuthInterceptor> authInterceptorProvider;
        Provider<BetaFeedbackEmailSender> betaFeedbackEmailSenderProvider;
        Provider<BetaFeedbackManager> betaFeedbackManagerProvider;
        Provider<BoxAiObservability> boxAiObservabilityProvider;
        Provider<BoxAiRemoteDataSource> boxAiRemoteDataSourceProvider;
        Provider<BoxGraphQL> boxGraphQLProvider;
        Provider<BoxLocalCache> boxLocalCacheProvider;
        Provider<BoxPreviewController> boxPreviewControllerProvider;
        Provider<BoxSessionFactory> boxSessionFactoryProvider;
        Provider<BoxThumbnailRequests> boxThumbnailRequestsProvider;
        Provider<BridgedPreviewService> bridgedPreviewServiceProvider;
        Provider<CaptureHistoryCacheDataSource> captureHistoryCacheDataSourceProvider;
        Provider<ColdStartCalculation> coldStartCalculationProvider;
        Provider<ConfigManager> configManagerProvider;
        private final DataProvidesModule dataProvidesModule;
        Provider<DefaultNoteFolderService> defaultNoteFolderServiceProvider;
        Provider<EmailChooserHelper> emailChooserHelperProvider;
        Provider<QueryDebouncer.Factory> factoryProvider;
        Provider<DeleteFileJob.Factory> factoryProvider10;
        Provider<ChunkUploadJob.Factory> factoryProvider11;
        Provider<DownloadFileJob.Factory> factoryProvider12;
        Provider<DownloadChunkJob.Factory> factoryProvider13;
        Provider<DeleteCollaborationJob.Factory> factoryProvider14;
        Provider<DownloadFolderJob.Factory> factoryProvider15;
        Provider<UploadFolderJob.Factory> factoryProvider16;
        Provider<MoveItemJob.Factory> factoryProvider17;
        Provider<CopyItemJob.Factory> factoryProvider18;
        Provider<AutoUploadJob.Factory> factoryProvider19;
        Provider<CreateFolderJob.Factory> factoryProvider2;
        Provider<MarkForOfflineJob.Factory> factoryProvider20;
        Provider<MarkForOfflineFolderJob.Factory> factoryProvider21;
        Provider<ItemClickHandler.Factory> factoryProvider22;
        Provider<ItemActionHandler.Factory> factoryProvider23;
        Provider<ItemMoreActionsHandler.Factory> factoryProvider24;
        Provider<InitialState.Factory> factoryProvider3;
        Provider<PreflightCheckState.Factory> factoryProvider4;
        Provider<UploadWholeFileState.Factory> factoryProvider5;
        Provider<UploadSessionCreationState.Factory> factoryProvider6;
        Provider<UploadChunksState.Factory> factoryProvider7;
        Provider<CommitSessionState.Factory> factoryProvider8;
        Provider<UploadFileJobV2.Factory> factoryProvider9;
        Provider<FeatureFlips> featureFlipsProvider;
        Provider<ForceUpdateActionHandler> forceUpdateActionHandlerProvider;
        Provider<ForceUpdateConfigSynchronizer> forceUpdateConfigSynchronizerProvider;
        Provider<ForceUpdateCoordinator> forceUpdateCoordinatorProvider;
        Provider<ForceUpdateEvaluator> forceUpdateEvaluatorProvider;
        Provider<ForceUpdateObservability> forceUpdateObservabilityProvider;
        Provider<ForceUpdateRepository> forceUpdateRepositoryProvider;
        Provider<ForceUpdateVersionValidator> forceUpdateVersionValidatorProvider;
        Provider<GQLApolloClientConfigurator> gQLApolloClientConfiguratorProvider;
        Provider<GQLCache> gQLCacheProvider;
        Provider<GQLCollectionItemsResponseInterceptor> gQLCollectionItemsResponseInterceptorProvider;
        Provider<GQLCollectionsResponseInterceptor> gQLCollectionsResponseInterceptorProvider;
        Provider<GQLCollectionsWithItemResponseInterceptor> gQLCollectionsWithItemResponseInterceptorProvider;
        Provider<GQLCopyItemResponseInterceptor> gQLCopyItemResponseInterceptorProvider;
        Provider<GQLCreateCollectionItemResponseInterceptor> gQLCreateCollectionItemResponseInterceptorProvider;
        Provider<GQLCreateCollectionResponseInterceptor> gQLCreateCollectionResponseInterceptorProvider;
        Provider<GQLCreateFolderResponseInterceptor> gQLCreateFolderResponseInterceptorProvider;
        Provider<GQLForceUpdateInterceptor> gQLForceUpdateInterceptorProvider;
        Provider<GQLGetFolderItemsResponseInterceptor> gQLGetFolderItemsResponseInterceptorProvider;
        Provider<GQLGetFolderMiniResponseInterceptor> gQLGetFolderMiniResponseInterceptorProvider;
        Provider<GQLGetFolderMiniWithParentResponseInterceptor> gQLGetFolderMiniWithParentResponseInterceptorProvider;
        Provider<GQLGetItemResponseInterceptor> gQLGetItemResponseInterceptorProvider;
        Provider<GQLGetItemWithWatermarkDataResponseInterceptor> gQLGetItemWithWatermarkDataResponseInterceptorProvider;
        Provider<GQLMoveItemResponseInterceptor> gQLMoveItemResponseInterceptorProvider;
        Provider<GQLPartialDataExtractor> gQLPartialDataExtractorProvider;
        Provider<GQLRemoveCollectionItemResponseInterceptor> gQLRemoveCollectionItemResponseInterceptorProvider;
        Provider<GQLResponseInterceptor> gQLResponseInterceptorProvider;
        Provider<Gen204JobServiceHelper> gen204JobServiceHelperProvider;
        Provider<Gen204MoveCopyEventLogger> gen204MoveCopyEventLoggerProvider;
        Provider<Gen204OfflineEventLogger> gen204OfflineEventLoggerProvider;
        Provider<Gen204PerformanceLogger> gen204PerformanceLoggerProvider;
        Provider<Gen204UploadEventLogger> gen204UploadEventLoggerProvider;
        Provider<Gen204WatermarkingEventLogger> gen204WatermarkingEventLoggerProvider;
        Provider<GetThumbnailRepresentationsService> getThumbnailRepresentationsServiceProvider;
        Provider<HubsObservability> hubsObservabilityProvider;
        Provider<InboxBadgeRepository> inboxBadgeRepositoryProvider;
        Provider<InboxNotificationLocalDataSource> inboxNotificationLocalDataSourceProvider;
        Provider<IntuneAuthManager> intuneAuthManagerProvider;
        Provider<JobManager> jobManagerProvider;
        Provider<JobService> jobServiceProvider;
        Provider<JobsNotificationService> jobsNotificationServiceProvider;
        Provider<LaunchIntoCaptureInteractor> launchIntoCaptureInteractorProvider;
        Provider<LegacyMessageToGQLBridge> legacyMessageToGQLBridgeProvider;
        Provider<LocalItemService> localItemServiceProvider;
        Provider<Media3AudioPlayerManager> media3AudioPlayerManagerProvider;
        Provider<MetricsInteractor> metricsInteractorProvider;
        Provider<MetricsLoggingService> metricsLoggingServiceProvider;
        Provider<MetricsUploadScheduler> metricsUploadSchedulerProvider;
        Provider<MsalObservability> msalObservabilityProvider;
        Provider<ObservabilityDatabaseProvider> observabilityDatabaseProvider;
        Provider<OfflineMigrationService> offlineMigrationServiceProvider;
        Provider<OfflineServiceLocalDataSource> offlineServiceLocalDataSourceProvider;
        Provider<OfflineStateStorage> offlineStateStorageProvider;
        Provider<PreviewObservability> previewObservabilityProvider;
        Provider<PreviousVersionPreviewObservability> previousVersionPreviewObservabilityProvider;
        Provider<AndroidForWorkController> provideAndroidForWorkControllerProvider;
        Provider<AnnotationsRequest> provideAnnotationRequestProvider;
        Provider<AuthRequest> provideAnonymousAuthRequestProvider;
        Provider<String> provideAppFlavorStringProvider;
        Provider<AppUpdateManager> provideAppUpdateManagerProvider;
        Provider<Context> provideApplicationContextProvider;
        Provider<BoxAiRequest> provideBoxAiRequestProvider;
        Provider<BoxApiBookmark> provideBoxApiBookmarkProvider;
        Provider<BoxExtendedApiCollaboration> provideBoxApiCollaborationProvider;
        Provider<BoxExtendedApiCollections> provideBoxApiCollectionsProvider;
        Provider<BoxApiFeatures> provideBoxApiFeaturesProvider;
        Provider<BoxExtendedApiFile> provideBoxApiFileProvider;
        Provider<BoxApiInvitee> provideBoxApiInviteeProvider;
        Provider<BoxExtendedApiRecentItems> provideBoxApiLocalRecentItemsProvider;
        Provider<BoxApiPrivate> provideBoxApiPrivateProvider;
        Provider<BoxApiRecentItems> provideBoxApiRecentItemsProvider;
        Provider<BoxApiShare> provideBoxApiShareProvider;
        Provider<BoxApiUser> provideBoxApiUserProvider;
        Provider<BoxExtendedApiWeblink> provideBoxApiWeblinkProvider;
        Provider<BoxExtendedApiFolder> provideBoxExtendedApiFolderProvider;
        Provider<BoxExtendedApiPreview> provideBoxExtendedApiPreviewProvider;
        Provider<IPreviewController> provideBoxPreviewControllerProvider;
        Provider<ChunkedFileUploadRequest> provideChunkedUploadFileRequestProvider;
        Provider<ClientSettingsRequest> provideClientSettingsRequestProvider;
        Provider<CollectionItemsRequest> provideCollectionItemsRequestProvider;
        Provider<CollectionsRequest> provideCollectionRequestProvider;
        Provider<CommentRequest> provideCommentRequestProvider;
        Provider<CommentV2Request> provideCommentV2RequestProvider;
        Provider<ICommentsController> provideCommentsControllerProvider;
        Provider<CreateFolderRequest> provideCreateFolderRequestProvider;
        Provider<DefaultNoteFolderRequest> provideDefaultNoteFolderRequestProvider;
        Provider<DeleteItemRequest> provideDeleteItemRequestProvider;
        Provider<DeviceId> provideDeviceIdProvider;
        Provider<IDeviceIdStorage> provideDeviceIdStorageProvider;
        Provider<EmptyBodyInterceptor> provideEmptyBodyInterceptorProvider;
        Provider<BoxAmplitudeAnalytics.EventPropertyBuilder> provideEventPropertyBuilderProvider;
        Provider<FileActivitiesRequest> provideFileActivitiesRequestProvider;
        Provider<DownloadFileRequest> provideFileDownloadRequestProvider;
        Provider<FileMetadataRequest> provideFileMetadataRequestProvider;
        Provider<FileRepresentationsRequest> provideFileRepresentationsRequestProvider;
        Provider<FileVersionRequest> provideFileVersionRequestProvider;
        Provider<FilesSearchRequest> provideFilesSearchRequestProvider;
        Provider<Gen204RequestInterceptor> provideGen204RequestInterceptorProvider;
        Provider<MetricsLoggingRequest> provideGen204RequestProvider;
        Provider<FolderItemsRequest> provideGetFolderItemsRequestProvider;
        Provider<ThreadPoolExecutor> provideGlobalExecutorProvider;
        Provider<SharedPreferences> provideGlobalSharedPreferencesProvider;
        Provider<HttpLoggingInterceptor> provideHttpLoggingInterceptorProvider;
        Provider<HttpStreamLoggingInterceptor> provideHttpStreamLoggingInterceptorProvider;
        Provider<HubAssetDownloadRequest> provideHubAssetDownloadRequestProvider;
        Provider<IMoCoAdminSettings> provideIMoCoAdminSettingsProvider;
        Provider<IMoCoBoxTransfers> provideIMoCoBoxTransfersProvider;
        Provider<InboxCollaborationRequest> provideInboxCollaborationRequestProvider;
        Provider<InboxNotificationRequest> provideInboxNotificationRequestProvider;
        Provider<List<Interceptor>> provideInterceptorsProvider;
        Provider<ItemCollaborationsRequest> provideItemCollaborationsRequestProvider;
        Provider<ItemInfoRequest> provideItemInfoRequestProvider;
        Provider<DataStore<Preferences>> provideLastUsedTabDataStoreProvider;
        Provider<LevelDBKeyValueStore> provideLevelDBKeyValueStoreProvider;
        Provider<MetadataTemplatesRequest> provideMetadataTemplatesRequestProvider;
        Provider<Moshi> provideMoshiProvider;
        Provider<RetryRequestInterceptor> provideNetworkInterceptorProvider;
        Provider<DataStore<Preferences>> providePreferencesDataStoreProvider;
        Provider<PreflightCheckRequest> providePreflightCheckRequestProvider;
        Provider<PreviewDownloadRequest> providePreviewDownloadRequestProvider;
        Provider<PushNotificationSettingsRequest> providePushNotificationSettingsRequestProvider;
        Provider<RecentNotesRequest> provideRecentNotesRequestProvider;
        Provider<RecentsRequest> provideRecentsRequestProvider;
        Provider<RumService> provideRumServiceProvider;
        Provider<BoxExtendedApiSearch> provideSearchApiProvider;
        Provider<IStorage> provideStorageProvider;
        Provider<TaskRequest> provideTaskRequestProvider;
        Provider<TasksRepo> provideTasksRepoProvider;
        Provider<UpdateItemInfoRequest> provideUpdateItemInfoRequestProvider;
        Provider<UpdateItemRequest> provideUpdateItemRequestProvider;
        Provider<UploadFileRequest> provideUploadFileRequestProvider;
        Provider<UserContextMigration> provideUserContextMigrationProvider;
        Provider<WatermarkRequest> provideWatermarkRequestProvider;
        Provider<ApdexService> providesApdexServiceProvider;
        Provider<IAppStartDestinationPageHolder> providesAppStartTargetHolderProvider;
        Provider<AuthenticationCredentialsProvider> providesAuthenticationCredentialsProvider;
        Provider<BoxCsrfTokenManager> providesBoxCsrfTokenManagerProvider;
        Provider<IBoxStorage> providesBoxStorageProvider;
        Provider<IBrowseController> providesBrowseControllerProvider;
        Provider<BrowseTabAppStartDestinationPage> providesBrowseTabAppStartDestinationPageProvider;
        Provider<CookieManager> providesCookieManagerProvider;
        Provider<IFileCanBePreviewedChecker> providesFileCanBePreviewedCheckerProvider;
        Provider<FirebaseRemoteConfig> providesFirebaseRemoteConfigProvider;
        Provider<IMoCoBatchOperations> providesIMoCoBatchOperationsProvider;
        Provider<IMoCoBoxGlobalSettings> providesIMoCoBoxGlobalSettingsProvider;
        Provider<IMoCoBoxRecentEvents> providesIMoCoBoxRecentEventsProvider;
        Provider<LocalSortPreferences> providesSortPreferencesProvider;
        Provider<AuthenticationAppStartDestinationPage> providesSplashScreenAppStartIntermediatePageProvider;
        Provider<RecentNotesLocalDataSource> recentNotesLocalDataSourceProvider;
        Provider<RecentNotesService> recentNotesServiceProvider;
        Provider<RegisterPushDeviceInteractor> registerPushDeviceInteractorProvider;
        Provider<RemoteConfig> remoteConfigProvider;
        Provider<ScreenshotCapture> screenshotCaptureProvider;
        Provider<SearchService> searchServiceProvider;
        Provider<SessionManager> sessionManagerProvider;
        Provider<ShareModelController> shareModelControllerProvider;
        private final SingletonCImpl singletonCImpl = this;
        Provider<SplitConfiguration> splitConfigurationProvider;
        Provider<SystemInfo> systemInfoProvider;
        Provider<TextSearchManager> textSearchManagerProvider;
        Provider<ThumbnailManager> thumbnailManagerProvider;
        Provider<ThumbnailPreviewInteractor> thumbnailPreviewInteractorProvider;
        Provider<ThumbnailService> thumbnailServiceProvider;
        Provider<UpdateDeviceRegistrationInteractor> updateDeviceRegistrationInteractorProvider;
        Provider<UploadFileCleanupService> uploadFileCleanupServiceProvider;
        Provider<UserContextManager> userContextManagerProvider;
        Provider<UserData> userDataProvider;
        Provider<UserSessionInfo> userSessionInfoProvider;
        Provider<WopiPropertyBuilder> wopiPropertyBuilderProvider;

        @Override // com.box.android.application.BoxApplication_GeneratedInjector
        public void injectBoxApplication(BoxApplication arg0) {
        }

        SingletonCImpl(ApplicationContextModule applicationContextModuleParam, DataProvidesModule dataProvidesModuleParam) {
            this.dataProvidesModule = dataProvidesModuleParam;
            this.applicationContextModule = applicationContextModuleParam;
            initialize(applicationContextModuleParam, dataProvidesModuleParam);
            initialize2(applicationContextModuleParam, dataProvidesModuleParam);
            initialize3(applicationContextModuleParam, dataProvidesModuleParam);
            initialize4(applicationContextModuleParam, dataProvidesModuleParam);
            initialize5(applicationContextModuleParam, dataProvidesModuleParam);
            initialize6(applicationContextModuleParam, dataProvidesModuleParam);
            initialize7(applicationContextModuleParam, dataProvidesModuleParam);
            initialize8(applicationContextModuleParam, dataProvidesModuleParam);
            initialize9(applicationContextModuleParam, dataProvidesModuleParam);
        }

        AppRestrictionsManager appRestrictionsManager2() {
            return new AppRestrictionsManager(this.provideApplicationContextProvider.get());
        }

        MoCoBoxGlobalSettings moCoBoxGlobalSettings() {
            return new MoCoBoxGlobalSettings(this.provideApplicationContextProvider.get(), new LocalSharedPreferences(), this.provideGlobalExecutorProvider.get());
        }

        UserContext userContext() {
            return new UserContext(this.provideApplicationContextProvider.get());
        }

        PushNotificationSettingsRemoteDataSource pushNotificationSettingsRemoteDataSource() {
            return new PushNotificationSettingsRemoteDataSource(this.providePushNotificationSettingsRequestProvider.get(), this.provideMoshiProvider.get());
        }

        PushNotificationSettingsService pushNotificationSettingsService() {
            return new PushNotificationSettingsService(pushNotificationSettingsRemoteDataSource(), this.userContextManagerProvider.get());
        }

        MetricsCacheDataSource metricsCacheDataSource() {
            return new MetricsCacheDataSource(this.observabilityDatabaseProvider.get());
        }

        BVEManager bVEManager() {
            return new BVEManager(new LocalSharedPreferences(), appRestrictionsManager2());
        }

        MetricsRemoteDataSource metricsRemoteDataSource() {
            return new MetricsRemoteDataSource(this.provideGen204RequestProvider.get(), this.provideMoshiProvider.get());
        }

        MetricsEntityDTOMapper metricsEntityDTOMapper() {
            return new MetricsEntityDTOMapper(this.provideMoshiProvider.get());
        }

        AppInfoService appInfoService() {
            return new AppInfoService(this.provideApplicationContextProvider.get());
        }

        MetricDecorator providesDeviceMetricDecorator() {
            return MetricDecoratorsModule_ProvidesDeviceMetricDecoratorFactory.providesDeviceMetricDecorator(appInfoService());
        }

        MetricDecorator providesUserMetricDecorator() {
            return MetricDecoratorsModule_ProvidesUserMetricDecoratorFactory.providesUserMetricDecorator(this.userContextManagerProvider.get());
        }

        Set<MetricDecorator> setOfMetricDecorator() {
            return ImmutableSet.of(providesDeviceMetricDecorator(), providesUserMetricDecorator());
        }

        BoxAccountSettings boxAccountSettings() {
            return new BoxAccountSettings(this.userContextManagerProvider.get(), appRestrictionsManager2());
        }

        SharedPreferences namedSharedPreferences() {
            return DataProvidesModule_FeatureFlipDebugSharedPreferencesFactory.featureFlipDebugSharedPreferences(this.dataProvidesModule, this.userContextManagerProvider.get());
        }

        FeatureFlipEvaluator featureFlipEvaluator() {
            return new FeatureFlipEvaluator(this.splitConfigurationProvider.get(), this.userContextManagerProvider.get());
        }

        RequestHeaderInterceptor requestHeaderInterceptor() {
            return new RequestHeaderInterceptor(this.sessionManagerProvider.get());
        }

        SharedLinkAuthInterceptor sharedLinkAuthInterceptor() {
            return new SharedLinkAuthInterceptor(this.sessionManagerProvider.get());
        }

        DevpodInterceptor devpodInterceptor() {
            return new DevpodInterceptor(this.configManagerProvider.get());
        }

        RequestFactory requestFactory() {
            return new RequestFactory(this.provideInterceptorsProvider.get(), this.provideMoshiProvider.get(), this.featureFlipsProvider.get(), new SplunkRumInstrumentation());
        }

        DefaultNoteFolderRemoteDataSource defaultNoteFolderRemoteDataSource() {
            return new DefaultNoteFolderRemoteDataSource(this.provideDefaultNoteFolderRequestProvider.get(), this.provideMoshiProvider.get());
        }

        GQLClientRequestInterceptor gQLClientRequestInterceptor() {
            return new GQLClientRequestInterceptor(boxAccountSettings(), appInfoService());
        }

        GQLRequestParser gQLRequestParser() {
            return new GQLRequestParser(this.provideMoshiProvider.get());
        }

        CollectionsRemoteDataSource collectionsRemoteDataSource() {
            return new CollectionsRemoteDataSource(this.provideCollectionRequestProvider.get(), this.provideMoshiProvider.get());
        }

        CollectionItemsRemoteDataSource collectionItemsRemoteDataSource() {
            return new CollectionItemsRemoteDataSource(this.provideCollectionItemsRequestProvider.get(), this.provideMoshiProvider.get());
        }

        BaseModelController baseModelController() {
            return new BaseModelController(this.userContextManagerProvider.get(), this.provideApplicationContextProvider.get());
        }

        Gen204FolderItemsEventLogger gen204FolderItemsEventLogger() {
            return new Gen204FolderItemsEventLogger(this.metricsInteractorProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        ItemRemoteDataSource itemRemoteDataSource() {
            return new ItemRemoteDataSource(this.provideCreateFolderRequestProvider.get(), this.provideGetFolderItemsRequestProvider.get(), this.provideUpdateItemRequestProvider.get(), this.provideItemInfoRequestProvider.get(), this.providesSortPreferencesProvider.get(), this.provideMoshiProvider.get(), gen204FolderItemsEventLogger());
        }

        SharedPreferences namedSharedPreferences2() {
            return DataProvidesModule_AppUpdatesSharedPreferencesFactory.appUpdatesSharedPreferences(this.dataProvidesModule, this.userContextManagerProvider.get());
        }

        GQLCacheHelper gQLCacheHelper() {
            return new GQLCacheHelper(this.gQLCacheProvider.get());
        }

        LegacyBridgeService legacyBridgeService() {
            return new LegacyBridgeService(this.captureHistoryCacheDataSourceProvider.get(), gQLCacheHelper());
        }

        ThreadPoolExecutor namedThreadPoolExecutor() {
            return BoxModule_Companion_ProvideThumbnailExecutorFactory.provideThumbnailExecutor(this.userContextManagerProvider.get());
        }

        ClientSettingsRemoteDataSource clientSettingsRemoteDataSource() {
            return new ClientSettingsRemoteDataSource(this.provideClientSettingsRequestProvider.get(), this.provideMoshiProvider.get());
        }

        ClientSettingsCacheDataSource clientSettingsCacheDataSource() {
            return new ClientSettingsCacheDataSource(this.userContextManagerProvider.get(), this.provideMoshiProvider.get());
        }

        ClientSettingsService clientSettingsService() {
            return new ClientSettingsService(this.userContextManagerProvider.get(), clientSettingsRemoteDataSource(), clientSettingsCacheDataSource());
        }

        BoxAdminSettingsProvider boxAdminSettingsProvider() {
            return new BoxAdminSettingsProvider(clientSettingsService());
        }

        MoCoAdminSettings moCoAdminSettings() {
            return new MoCoAdminSettings(this.provideApplicationContextProvider.get(), this.userContextManagerProvider.get(), boxAdminSettingsProvider());
        }

        MoCoBoxTransfers moCoBoxTransfers() {
            return new MoCoBoxTransfers(this.userContextManagerProvider.get(), this.provideApplicationContextProvider.get(), this.boxThumbnailRequestsProvider.get(), this.provideBoxApiFileProvider.get(), this.provideBoxExtendedApiFolderProvider.get(), this.provideBoxApiPrivateProvider.get(), this.provideBoxExtendedApiPreviewProvider.get(), this.provideBoxPreviewControllerProvider.get(), this.featureFlipsProvider.get());
        }

        MoCoBatchOperations moCoBatchOperations() {
            return new MoCoBatchOperations(this.provideApplicationContextProvider.get(), this.userContextManagerProvider.get(), this.provideBoxApiFileProvider.get(), this.provideBoxExtendedApiFolderProvider.get(), this.provideBoxApiWeblinkProvider.get());
        }

        LegacyCacheDataSource legacyCacheDataSource() {
            return new LegacyCacheDataSource(this.boxLocalCacheProvider.get());
        }

        GQLDbHelper gQLDbHelper() {
            return new GQLDbHelper(this.userDataProvider.get());
        }

        GQLPartialModelParser gQLPartialModelParser() {
            return new GQLPartialModelParser(this.provideMoshiProvider.get());
        }

        GQLPartialMiniItemsSorter gQLPartialMiniItemsSorter() {
            return new GQLPartialMiniItemsSorter(this.providesSortPreferencesProvider.get());
        }

        LocalItemsDataSource localItemsDataSource() {
            return new LocalItemsDataSource(this.userDataProvider.get());
        }

        ItemIdMappingService itemIdMappingService() {
            return new ItemIdMappingService(localItemsDataSource());
        }

        IdMappingService idMappingService() {
            return DataProvidesModule_ProvidesIdMappingServiceFactory.providesIdMappingService(this.dataProvidesModule, itemIdMappingService());
        }

        RemoteItemService remoteItemService() {
            return new RemoteItemService(this.boxGraphQLProvider.get(), legacyCacheDataSource(), gQLCacheHelper(), this.gen204PerformanceLoggerProvider.get(), baseModelController(), this.provideBoxExtendedApiFolderProvider.get(), this.gQLPartialDataExtractorProvider.get(), idMappingService(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        JobManagerNotificationCenter jobManagerNotificationCenter() {
            return new JobManagerNotificationCenter(this.provideApplicationContextProvider.get(), baseModelController(), this.shareModelControllerProvider.get(), this.userContextManagerProvider.get(), this.provideBoxExtendedApiFolderProvider.get());
        }

        AuthenticationRemoteDataSource authenticationRemoteDataSource() {
            return new AuthenticationRemoteDataSource(this.provideAnonymousAuthRequestProvider.get(), this.provideMoshiProvider.get(), appRestrictionsManager2(), bVEManager());
        }

        AuthenticationService authenticationService() {
            return new AuthenticationService(authenticationRemoteDataSource(), this.providesAuthenticationCredentialsProvider.get());
        }

        UploadFileRemoteDataSource uploadFileRemoteDataSource() {
            return new UploadFileRemoteDataSource(this.provideUploadFileRequestProvider.get(), this.providePreflightCheckRequestProvider.get(), this.provideMoshiProvider.get());
        }

        LogsCacheDataSource logsCacheDataSource() {
            return new LogsCacheDataSource(this.provideApplicationContextProvider.get(), this.provideMoshiProvider.get(), new FileSystem());
        }

        ObservabilityService observabilityService() {
            return new ObservabilityService(authenticationService(), authenticationRemoteDataSource(), clientSettingsRemoteDataSource(), uploadFileRemoteDataSource(), this.providesAuthenticationCredentialsProvider.get(), logsCacheDataSource(), this.sessionManagerProvider.get());
        }

        AuthenticationInteractor authenticationInteractor() {
            return new AuthenticationInteractor(observabilityService());
        }

        UploadLogsInteractor uploadLogsInteractor() {
            return new UploadLogsInteractor(observabilityService(), authenticationInteractor());
        }

        LocalItemServiceItemsCreator localItemServiceItemsCreator() {
            return new LocalItemServiceItemsCreator(this.userContextManagerProvider.get());
        }

        JobsDataSource jobsDataSource() {
            return new JobsDataSource(this.userDataProvider.get());
        }

        CommonServiceUtils commonServiceUtils() {
            return new CommonServiceUtils(legacyCacheDataSource(), this.provideMoshiProvider.get(), legacyBridgeService(), remoteItemService(), this.boxLocalCacheProvider.get());
        }

        CreateFolderService createFolderService() {
            return new CreateFolderService(itemRemoteDataSource(), commonServiceUtils(), idMappingService());
        }

        ChunkedFileUploadRemoteDataSource chunkedFileUploadRemoteDataSource() {
            return new ChunkedFileUploadRemoteDataSource(this.provideChunkedUploadFileRequestProvider.get(), this.provideMoshiProvider.get());
        }

        UploadFileService uploadFileService() {
            return new UploadFileService(uploadFileRemoteDataSource(), chunkedFileUploadRemoteDataSource(), this.userSessionInfoProvider.get(), commonServiceUtils());
        }

        FileMetadataRemoteDataSource fileMetadataRemoteDataSource() {
            return new FileMetadataRemoteDataSource(this.provideFileMetadataRequestProvider.get(), this.provideMoshiProvider.get());
        }

        MetadataTemplatesRemoteDataSource metadataTemplatesRemoteDataSource() {
            return new MetadataTemplatesRemoteDataSource(this.provideMetadataTemplatesRequestProvider.get(), this.provideMoshiProvider.get());
        }

        FileMetadataService fileMetadataService() {
            return new FileMetadataService(fileMetadataRemoteDataSource(), metadataTemplatesRemoteDataSource(), idMappingService());
        }

        UploadStatesFactory uploadStatesFactory() {
            return new UploadStatesFactory(this.factoryProvider3.get(), this.factoryProvider4.get(), this.factoryProvider5.get(), this.factoryProvider6.get(), this.factoryProvider7.get(), this.factoryProvider8.get());
        }

        DeleteFileRemoteDataSource deleteFileRemoteDataSource() {
            return new DeleteFileRemoteDataSource(this.provideDeleteItemRequestProvider.get(), this.provideMoshiProvider.get());
        }

        DeleteFileService deleteFileService() {
            return new DeleteFileService(deleteFileRemoteDataSource(), this.boxLocalCacheProvider.get(), idMappingService());
        }

        DownloadFileRemoteDataSource downloadFileRemoteDataSource() {
            return new DownloadFileRemoteDataSource(this.provideFileDownloadRequestProvider.get(), this.provideMoshiProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        DownloadFileService downloadFileService() {
            return new DownloadFileService(downloadFileRemoteDataSource());
        }

        UpdateItemInfoRemoteDataSource updateItemInfoRemoteDataSource() {
            return new UpdateItemInfoRemoteDataSource(this.provideUpdateItemInfoRequestProvider.get(), this.provideMoshiProvider.get());
        }

        SharedLinkCredentialsCacheDatasource sharedLinkCredentialsCacheDatasource() {
            return new SharedLinkCredentialsCacheDatasource(this.userDataProvider.get());
        }

        SharedLinkService sharedLinkService() {
            return new SharedLinkService(updateItemInfoRemoteDataSource(), legacyCacheDataSource(), idMappingService(), sharedLinkCredentialsCacheDatasource());
        }

        ItemCollaborationsRemoteDataSource itemCollaborationsRemoteDataSource() {
            return new ItemCollaborationsRemoteDataSource(this.provideItemCollaborationsRequestProvider.get(), this.provideMoshiProvider.get());
        }

        ItemCollaborationsService itemCollaborationsService() {
            return new ItemCollaborationsService(itemCollaborationsRemoteDataSource(), idMappingService(), this.userContextManagerProvider.get(), this.boxLocalCacheProvider.get());
        }

        MoveCopyJobInputValidator moveCopyJobInputValidator() {
            return new MoveCopyJobInputValidator(this.localItemServiceProvider.get(), idMappingService());
        }

        RepresentationsRemoteDataSource representationsRemoteDataSource() {
            return new RepresentationsRemoteDataSource(this.provideFileRepresentationsRequestProvider.get(), this.provideMoshiProvider.get());
        }

        RepresentationDTOEntityMapper representationDTOEntityMapper() {
            return new RepresentationDTOEntityMapper(this.provideMoshiProvider.get());
        }

        RepresentationsCacheDataSource representationsCacheDataSource() {
            return new RepresentationsCacheDataSource(this.userDataProvider.get(), representationDTOEntityMapper());
        }

        FileWithRepresentationsService fileWithRepresentationsService() {
            return new FileWithRepresentationsService(representationsRemoteDataSource(), representationsCacheDataSource(), legacyCacheDataSource(), idMappingService(), this.localItemServiceProvider.get());
        }

        VersionsPreviewCache versionsPreviewCache() {
            return new VersionsPreviewCache(this.provideApplicationContextProvider.get());
        }

        RepresentationsService representationsService() {
            return new RepresentationsService(representationsRemoteDataSource(), representationsCacheDataSource(), versionsPreviewCache(), idMappingService(), this.provideBoxPreviewControllerProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        PreviewDownloadRemoteDataSource previewDownloadRemoteDataSource() {
            return new PreviewDownloadRemoteDataSource(this.providePreviewDownloadRequestProvider.get(), this.provideMoshiProvider.get(), this.provideBoxPreviewControllerProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        AnnotationsRemoteDataSource annotationsRemoteDataSource() {
            return new AnnotationsRemoteDataSource(this.provideAnnotationRequestProvider.get(), this.provideMoshiProvider.get(), this.featureFlipsProvider.get());
        }

        AnnotationsCacheDataSource annotationsCacheDataSource() {
            return new AnnotationsCacheDataSource(this.userDataProvider.get());
        }

        AnnotationDTOEntityMapper annotationDTOEntityMapper() {
            return new AnnotationDTOEntityMapper(this.provideMoshiProvider.get(), new FileActivityStatusDTOEntityMapper());
        }

        CommentEntityDomainMapper commentEntityDomainMapper() {
            return new CommentEntityDomainMapper(this.provideMoshiProvider.get(), new CommentDTODomainMapper());
        }

        AnnotationEntityDomainMapper annotationEntityDomainMapper() {
            return new AnnotationEntityDomainMapper(this.provideMoshiProvider.get(), commentEntityDomainMapper());
        }

        AnnotationsService annotationsService() {
            return new AnnotationsService(annotationsRemoteDataSource(), annotationsCacheDataSource(), annotationDTOEntityMapper(), annotationEntityDomainMapper(), this.provideMoshiProvider.get());
        }

        FileActivityRemoteDataSource fileActivityRemoteDataSource() {
            return new FileActivityRemoteDataSource(this.provideFileActivitiesRequestProvider.get(), this.provideMoshiProvider.get(), this.featureFlipsProvider.get());
        }

        FileActivityCacheDataSource fileActivityCacheDataSource() {
            return new FileActivityCacheDataSource(this.userDataProvider.get());
        }

        CommentDTOEntityMapper commentDTOEntityMapper() {
            return new CommentDTOEntityMapper(this.provideMoshiProvider.get(), new FileActivityStatusDTOEntityMapper());
        }

        VersionsDTOGroupedFileVersionsEntityMapper versionsDTOGroupedFileVersionsEntityMapper() {
            return new VersionsDTOGroupedFileVersionsEntityMapper(this.provideMoshiProvider.get());
        }

        VersionsDTOGroupedFileVersionEntitiesMapper versionsDTOGroupedFileVersionEntitiesMapper() {
            return new VersionsDTOGroupedFileVersionEntitiesMapper(new FileVersionDTOV1EntityMapper(), versionsDTOGroupedFileVersionsEntityMapper());
        }

        FileActivityDTOEntityMapper fileActivityDTOEntityMapper() {
            return new FileActivityDTOEntityMapper(annotationDTOEntityMapper(), commentDTOEntityMapper(), versionsDTOGroupedFileVersionEntitiesMapper());
        }

        GroupedFileVersionEntitiesDomainMapper groupedFileVersionEntitiesDomainMapper() {
            return new GroupedFileVersionEntitiesDomainMapper(this.provideMoshiProvider.get());
        }

        FileActivityEntityDomainMapper fileActivityEntityDomainMapper() {
            return new FileActivityEntityDomainMapper(commentEntityDomainMapper(), groupedFileVersionEntitiesDomainMapper(), annotationEntityDomainMapper());
        }

        FileActivitiesService fileActivitiesService() {
            return new FileActivitiesService(fileActivityRemoteDataSource(), fileActivityCacheDataSource(), this.localItemServiceProvider.get(), fileActivityDTOEntityMapper(), fileActivityEntityDomainMapper(), commentDTOEntityMapper(), commentEntityDomainMapper(), idMappingService(), this.featureFlipsProvider.get());
        }

        JobFactory jobFactory() {
            return new JobFactory(this.factoryProvider2.get(), this.factoryProvider9.get(), this.factoryProvider10.get(), this.factoryProvider11.get(), this.factoryProvider12.get(), this.factoryProvider13.get(), this.factoryProvider14.get(), this.factoryProvider15.get(), this.factoryProvider16.get(), this.factoryProvider17.get(), this.factoryProvider18.get(), this.factoryProvider19.get(), this.factoryProvider20.get(), this.factoryProvider21.get());
        }

        ApdexScoreProvider apdexScoreProvider() {
            return new ApdexScoreProvider(this.remoteConfigProvider.get(), this.provideMoshiProvider.get());
        }

        Gen204DownloadEventLogger gen204DownloadEventLogger() {
            return new Gen204DownloadEventLogger(this.metricsInteractorProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher(), apdexScoreProvider());
        }

        WorkManagerWorkerFactory workManagerWorkerFactory() {
            return new WorkManagerWorkerFactory(uploadLogsInteractor(), this.metricsInteractorProvider.get(), this.userContextManagerProvider.get(), this.provideBoxApiPrivateProvider.get(), this.jobManagerProvider.get(), this.localItemServiceProvider.get());
        }

        JobWorkerFactory jobWorkerFactory() {
            return new JobWorkerFactory(this.jobServiceProvider.get(), this.userContextManagerProvider.get(), this.provideBoxApiPrivateProvider.get(), this.jobManagerProvider.get());
        }

        OAuthAccessTokenService oAuthAccessTokenService() {
            return new OAuthAccessTokenService(this.sessionManagerProvider.get());
        }

        BoxAuthProvider boxAuthProvider() {
            return new BoxAuthProvider(oAuthAccessTokenService());
        }

        BoxConfigProvider boxConfigProvider() {
            return new BoxConfigProvider(bVEManager());
        }

        BoxAnalyticsProvider boxAnalyticsProvider() {
            return new BoxAnalyticsProvider(this.metricsInteractorProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        UploadFileProvider uploadFileProvider() {
            return new UploadFileProvider(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        BoxContentUploadService boxContentUploadService() {
            return new BoxContentUploadService(uploadFileService(), uploadFileProvider(), CommonModule_ProvidesResourcesProviderFactory.providesResourcesProvider(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        BoxAccountSettingsProvider boxAccountSettingsProvider() {
            return new BoxAccountSettingsProvider(clientSettingsService());
        }

        CreateLogArchiveInteractor createLogArchiveInteractor() {
            return new CreateLogArchiveInteractor(observabilityService());
        }

        UserService userService() {
            return new UserService(this.userDataProvider.get());
        }

        SharedPreferences namedSharedPreferences3() {
            return DataProvidesModule_GeniusScanLicenseSharedPreferencesFactory.geniusScanLicenseSharedPreferences(this.dataProvidesModule, this.userContextManagerProvider.get());
        }

        GeniusScanLicenseService geniusScanLicenseService() {
            return new GeniusScanLicenseService(namedSharedPreferences3(), clientSettingsRemoteDataSource());
        }

        NoteNameGenerator noteNameGenerator() {
            return new NoteNameGenerator(CommonModule_ProvidesResourcesProviderFactory.providesResourcesProvider(), CommonModule_ProvidesClockFactory.providesClock());
        }

        ResolveNewNoteDataInteractor resolveNewNoteDataInteractor() {
            return new ResolveNewNoteDataInteractor(noteNameGenerator());
        }

        JobManagerBridgeService jobManagerBridgeService() {
            return new JobManagerBridgeService(this.jobManagerProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper() {
            return new BoxModelOfflineManagerWrapper(this.userContextManagerProvider.get(), remoteItemService(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        ItemSorter itemSorter() {
            return new ItemSorter(this.providesSortPreferencesProvider.get());
        }

        OfflineService offlineService() {
            return new OfflineService(this.jobManagerProvider.get(), jobManagerBridgeService(), idMappingService(), boxModelOfflineManagerWrapper(), this.localItemServiceProvider.get(), remoteItemService(), this.userContextManagerProvider.get(), this.jobServiceProvider.get(), this.featureFlipsProvider.get(), itemSorter(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        OfflineFilesPolicyEnforcer offlineFilesPolicyEnforcer() {
            return new OfflineFilesPolicyEnforcer(offlineService(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        CollectionsService collectionsService() {
            return new CollectionsService(this.boxGraphQLProvider.get(), this.gQLCacheProvider.get(), this.userContextManagerProvider.get(), this.provideBoxApiFileProvider.get(), this.provideBoxExtendedApiFolderProvider.get(), this.provideBoxApiWeblinkProvider.get());
        }

        CaptureHistoryFilesService captureHistoryFilesService() {
            return new CaptureHistoryFilesService(this.captureHistoryCacheDataSourceProvider.get());
        }

        CollectionMembershipsInteractor collectionMembershipsInteractor() {
            return new CollectionMembershipsInteractor(collectionsService(), this.provideBoxApiFileProvider.get(), this.provideBoxExtendedApiFolderProvider.get(), this.provideBoxApiWeblinkProvider.get(), baseModelController(), captureHistoryFilesService());
        }

        BaseFTUX.FTUXFactory fTUXFactory() {
            return new BaseFTUX.FTUXFactory(this.userContextManagerProvider.get());
        }

        FTUXController fTUXController() {
            return new FTUXController(fTUXFactory());
        }

        BoxAccountManagerHelper boxAccountManagerHelper() {
            return new BoxAccountManagerHelper(this.userContextManagerProvider.get(), this.featureFlipsProvider.get());
        }

        RecentsRemoteDataSource recentsRemoteDataSource() {
            return new RecentsRemoteDataSource(this.provideRecentsRequestProvider.get(), this.provideMoshiProvider.get());
        }

        RecentsService recentsService() {
            return new RecentsService(recentsRemoteDataSource(), this.provideBoxApiLocalRecentItemsProvider.get(), this.provideBoxApiRecentItemsProvider.get(), baseModelController(), this.providesIMoCoBoxRecentEventsProvider.get(), this.provideBoxPreviewControllerProvider.get(), idMappingService());
        }

        CaptureHistoryInteractor captureHistoryInteractor() {
            return new CaptureHistoryInteractor(captureHistoryFilesService(), this.localItemServiceProvider.get(), this.boxLocalCacheProvider.get(), this.jobServiceProvider.get(), idMappingService());
        }

        GalleryItemsService galleryItemsService() {
            return new GalleryItemsService(remoteItemService(), recentsService(), offlineService(), captureHistoryInteractor(), itemSorter());
        }

        PreviewLocalDataSource previewLocalDataSource() {
            return new PreviewLocalDataSource(this.provideBoxPreviewControllerProvider.get(), offlineService());
        }

        PreviewFromLegacyCacheFetcher previewFromLegacyCacheFetcher() {
            return new PreviewFromLegacyCacheFetcher(this.localItemServiceProvider.get(), new PreviewerTypeLegacyCacheMapper(), this.provideBoxPreviewControllerProvider.get());
        }

        AudioPlaylistItemsService audioPlaylistItemsService() {
            return new AudioPlaylistItemsService(this.localItemServiceProvider.get(), previewLocalDataSource(), previewFromLegacyCacheFetcher(), itemSorter(), new Mp3RepresentationUriProvider(), idMappingService(), recentsService(), offlineService(), captureHistoryInteractor());
        }

        FileActionsManager fileActionsManager() {
            return new FileActionsManager(idMappingService(), boxAccountManagerHelper(), this.userContextManagerProvider.get(), galleryItemsService(), audioPlaylistItemsService(), this.featureFlipsProvider.get());
        }

        OpenTelemetryInstrumentationImpl openTelemetryInstrumentationImpl() {
            return new OpenTelemetryInstrumentationImpl(this.metricsInteractorProvider.get(), apdexScoreProvider());
        }

        PreviewerMappingsService previewerMappingsService() {
            return new PreviewerMappingsService(new PreviewerTypeResolverImpl());
        }

        PreviewFileWithRepresentationsWrapper previewFileWithRepresentationsWrapper() {
            return new PreviewFileWithRepresentationsWrapper(this.previewObservabilityProvider.get(), fileWithRepresentationsService());
        }

        PreviewDownloadRepresentationWrapper previewDownloadRepresentationWrapper() {
            return new PreviewDownloadRepresentationWrapper(representationsService(), this.previewObservabilityProvider.get(), this.provideBoxPreviewControllerProvider.get());
        }

        PreviewDownloadOriginalWrapper previewDownloadOriginalWrapper() {
            return new PreviewDownloadOriginalWrapper(this.previewObservabilityProvider.get(), previewDownloadRemoteDataSource());
        }

        PreviewPrefetcher previewPrefetcher() {
            return new PreviewPrefetcher(this.bridgedPreviewServiceProvider.get(), this.thumbnailPreviewInteractorProvider.get());
        }

        PreviewLauncher previewLauncher() {
            return new PreviewLauncher(this.previewObservabilityProvider.get(), this.localItemServiceProvider.get(), previewPrefetcher(), this.userContextManagerProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        GetHubsGraphQLQuery getHubsGraphQLQuery() {
            return new GetHubsGraphQLQuery(this.boxGraphQLProvider.get());
        }

        HubsDataSource hubsDataSource() {
            return new HubsDataSource(getHubsGraphQLQuery());
        }

        HubAssetLocalDataSource hubAssetLocalDataSource() {
            return new HubAssetLocalDataSource(this.userContextManagerProvider.get());
        }

        HubAssetRemoteDataSource hubAssetRemoteDataSource() {
            return new HubAssetRemoteDataSource(this.provideHubAssetDownloadRequestProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        HubsService hubsService() {
            return new HubsService(hubsDataSource(), hubAssetLocalDataSource(), hubAssetRemoteDataSource(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        SharedLinkTokenRetryHelper sharedLinkTokenRetryHelper() {
            return new SharedLinkTokenRetryHelper(this.sessionManagerProvider.get(), this.provideAnonymousAuthRequestProvider.get());
        }

        GetAIAgentsGraphQLQuery getAIAgentsGraphQLQuery() {
            return new GetAIAgentsGraphQLQuery(this.boxGraphQLProvider.get());
        }

        GetAiSessionsGraphQLQuery getAiSessionsGraphQLQuery() {
            return new GetAiSessionsGraphQLQuery(this.boxGraphQLProvider.get());
        }

        BoxAiService boxAiService() {
            return new BoxAiService(this.boxAiRemoteDataSourceProvider.get(), idMappingService(), CommonModule_ProvidesDefaultDispatcherFactory.providesDefaultDispatcher());
        }

        ClipboardService clipboardService() {
            return new ClipboardService(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        SpeechRecognitionManager speechRecognitionManager() {
            return new SpeechRecognitionManager(this.provideApplicationContextProvider.get());
        }

        GetBoxAiAvailabilityInteractor getBoxAiAvailabilityInteractor() {
            return new GetBoxAiAvailabilityInteractor(boxAiService(), idMappingService(), boxAccountSettings(), this.featureFlipsProvider.get());
        }

        FolderInteractor folderInteractor() {
            return new FolderInteractor(remoteItemService());
        }

        CreateFolderInteractor createFolderInteractor() {
            return new CreateFolderInteractor(remoteItemService());
        }

        CreateFolderHelper createFolderHelper() {
            return new CreateFolderHelper(this.provideApplicationContextProvider.get());
        }

        PreviewSettingsService previewSettingsService() {
            return new PreviewSettingsService(this.userContextManagerProvider.get());
        }

        FilesAndFoldersSettingsStoreFactory filesAndFoldersSettingsStoreFactory() {
            return new FilesAndFoldersSettingsStoreFactory(previewSettingsService());
        }

        UpdateItemInfoService updateItemInfoService() {
            return new UpdateItemInfoService(updateItemInfoRemoteDataSource(), legacyCacheDataSource(), idMappingService());
        }

        BoxWebBridgeAuthenticator boxWebBridgeAuthenticator() {
            return new BoxWebBridgeAuthenticator(this.providesBoxCsrfTokenManagerProvider.get(), oAuthAccessTokenService());
        }

        TabPersistenceService tabPersistenceService() {
            return new TabPersistenceService(this.provideLastUsedTabDataStoreProvider.get(), this.userContextManagerProvider.get());
        }

        ListCollectionsInteractor listCollectionsInteractor() {
            return new ListCollectionsInteractor(collectionsService(), this.userContextManagerProvider.get());
        }

        GetFavoritesCollectionIdInteractor getFavoritesCollectionIdInteractor() {
            return new GetFavoritesCollectionIdInteractor(listCollectionsInteractor(), this.userContextManagerProvider.get());
        }

        VideoMediaSourceFactory videoMediaSourceFactory() {
            return PreviewModule_Companion_ProvideVideoMediaSourceFactoryFactory.provideVideoMediaSourceFactory(this.provideApplicationContextProvider.get(), this.userContextManagerProvider.get(), new Media3DataSourceFactory(), new WatermarkResolvingDataSourceFactory(), this.featureFlipsProvider.get());
        }

        NotificationCategoriesInteractor notificationCategoriesInteractor() {
            return new NotificationCategoriesInteractor(pushNotificationSettingsService());
        }

        InboxRouter inboxRouter() {
            return new InboxRouter(this.provideApplicationContextProvider.get(), new AppIntentServices());
        }

        TaskRemoteDataSource taskRemoteDataSource() {
            return new TaskRemoteDataSource(this.provideTaskRequestProvider.get(), this.provideMoshiProvider.get());
        }

        TaskService taskService() {
            return new TaskService(taskRemoteDataSource(), new TaskDTOToTaskModelMapper());
        }

        LegacyCommentsController legacyCommentsController() {
            return new LegacyCommentsController(this.provideApplicationContextProvider.get(), baseModelController(), this.provideBoxApiFileProvider.get(), this.userContextManagerProvider.get());
        }

        CommentControllerBridge commentControllerBridge() {
            return new CommentControllerBridge(legacyCommentsController(), idMappingService());
        }

        CaptureThumbnailService captureThumbnailService() {
            return new CaptureThumbnailService(this.userContextManagerProvider.get());
        }

        DeleteCaptureHistoryInteractor deleteCaptureHistoryInteractor() {
            return new DeleteCaptureHistoryInteractor(this.jobServiceProvider.get(), this.localItemServiceProvider.get(), captureHistoryFilesService(), idMappingService(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        SharedPreferences namedSharedPreferences4() {
            return DataProvidesModule_CaptureSharedPreferencesFactory.captureSharedPreferences(this.dataProvidesModule, this.userContextManagerProvider.get());
        }

        CapturePreferencesService capturePreferencesService() {
            return new CapturePreferencesService(namedSharedPreferences4());
        }

        CaptureLocalItemsInteractor captureLocalItemsInteractor() {
            return new CaptureLocalItemsInteractor(this.localItemServiceProvider.get(), captureHistoryFilesService(), captureThumbnailService());
        }

        DocumentScanCacheDataSource documentScanCacheDataSource() {
            return new DocumentScanCacheDataSource(this.userDataProvider.get());
        }

        DocumentScanService documentScanService() {
            return new DocumentScanService(documentScanCacheDataSource());
        }

        DocumentScanPageProcessor documentScanPageProcessor() {
            return new DocumentScanPageProcessor(this.userContextManagerProvider.get());
        }

        DocumentScanInteractor documentScanInteractor() {
            return new DocumentScanInteractor(documentScanService(), documentScanPageProcessor());
        }

        CaptureFolderInteractor captureFolderInteractor() {
            return new CaptureFolderInteractor(this.jobServiceProvider.get(), capturePreferencesService(), captureLocalItemsInteractor(), this.provideBoxExtendedApiFolderProvider.get(), idMappingService());
        }

        CaptureShutterSoundHelper captureShutterSoundHelper() {
            return new CaptureShutterSoundHelper(CaptureModule_Companion_ProvideMediaActionSoundFactory.provideMediaActionSound());
        }

        InboxNotificationRemoteDataSource inboxNotificationRemoteDataSource() {
            return new InboxNotificationRemoteDataSource(this.provideInboxNotificationRequestProvider.get(), this.provideMoshiProvider.get());
        }

        InboxNotificationService inboxNotificationService() {
            return new InboxNotificationService(inboxNotificationRemoteDataSource(), this.inboxNotificationLocalDataSourceProvider.get());
        }

        InboxCollaborationRemoteDataSource inboxCollaborationRemoteDataSource() {
            return new InboxCollaborationRemoteDataSource(this.provideInboxCollaborationRequestProvider.get(), this.provideMoshiProvider.get());
        }

        InboxCollaborationService inboxCollaborationService() {
            return new InboxCollaborationService(inboxCollaborationRemoteDataSource());
        }

        ResolveNewNoteLocationInteractor resolveNewNoteLocationInteractor() {
            return new ResolveNewNoteLocationInteractor(this.defaultNoteFolderServiceProvider.get(), noteNameGenerator());
        }

        SetDefaultNoteFolderInteractor setDefaultNoteFolderInteractor() {
            return new SetDefaultNoteFolderInteractor(this.defaultNoteFolderServiceProvider.get(), noteNameGenerator());
        }

        RecentNotesRemoteDataSource recentNotesRemoteDataSource() {
            return new RecentNotesRemoteDataSource(this.provideRecentNotesRequestProvider.get(), this.provideMoshiProvider.get());
        }

        FilesSearchRemoteDataSource filesSearchRemoteDataSource() {
            return new FilesSearchRemoteDataSource(this.provideFilesSearchRequestProvider.get(), this.provideMoshiProvider.get());
        }

        CaptureUploadFileManager captureUploadFileManager() {
            return new CaptureUploadFileManager(this.userContextManagerProvider.get());
        }

        RecordingFileManager recordingFileManager() {
            return new RecordingFileManager(this.userContextManagerProvider.get(), captureUploadFileManager());
        }

        ContentFileService contentFileService() {
            return new ContentFileService(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        WatermarkRemoteDataSource watermarkRemoteDataSource() {
            return new WatermarkRemoteDataSource(this.provideWatermarkRequestProvider.get());
        }

        WatermarkService watermarkService() {
            return new WatermarkService(watermarkRemoteDataSource(), idMappingService());
        }

        BoxPreviewRouter boxPreviewRouter() {
            return new BoxPreviewRouter(previewLauncher(), this.previousVersionPreviewObservabilityProvider.get());
        }

        CommentRemoteDataSource commentRemoteDataSource() {
            return new CommentRemoteDataSource(this.provideAnnotationRequestProvider.get(), this.provideCommentRequestProvider.get(), this.provideCommentV2RequestProvider.get(), this.provideMoshiProvider.get());
        }

        CommentCacheDataSource commentCacheDataSource() {
            return new CommentCacheDataSource(this.userDataProvider.get());
        }

        CommentService commentService() {
            return new CommentService(commentRemoteDataSource(), commentCacheDataSource(), commentDTOEntityMapper(), new CommentDTODomainMapper(), fileActivityDTOEntityMapper(), fileActivityCacheDataSource());
        }

        BoxUriSupportChecker boxUriSupportChecker() {
            return new BoxUriSupportChecker(this.provideApplicationContextProvider.get());
        }

        WopiService wopiService() {
            return new WopiService(this.userContextManagerProvider.get(), new OfficeAppDetector(), this.featureFlipsProvider.get(), clientSettingsService());
        }

        PreviousVersionPreviewService previousVersionPreviewService() {
            return new PreviousVersionPreviewService(representationsService(), new PreviewerTypeResolverImpl());
        }

        FileVersionsRemoteDataSource fileVersionsRemoteDataSource() {
            return new FileVersionsRemoteDataSource(this.provideFileVersionRequestProvider.get(), this.provideMoshiProvider.get());
        }

        FileVersionService fileVersionService() {
            return new FileVersionService(fileVersionsRemoteDataSource(), idMappingService());
        }

        private void initialize(final ApplicationContextModule applicationContextModuleParam, final DataProvidesModule dataProvidesModuleParam) {
            this.provideApplicationContextProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 6));
            this.provideAndroidForWorkControllerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 7));
            this.provideGlobalExecutorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 9));
            this.providesIMoCoBoxGlobalSettingsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 8));
            this.provideStorageProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 12));
            this.provideDeviceIdStorageProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 11));
            this.provideDeviceIdProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 10));
            this.boxSessionFactoryProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 13));
            this.providePushNotificationSettingsRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 15));
            this.provideMoshiProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 16));
            this.userContextManagerProvider = new DelegateFactory();
            this.registerPushDeviceInteractorProvider = new SwitchingProvider(this.singletonCImpl, 14);
            this.updateDeviceRegistrationInteractorProvider = new SwitchingProvider(this.singletonCImpl, 17);
            this.observabilityDatabaseProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 20));
            this.provideGen204RequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 21));
            this.metricsLoggingServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 19));
            this.metricsInteractorProvider = new SwitchingProvider(this.singletonCImpl, 18);
            this.provideGlobalSharedPreferencesProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 24));
            this.splitConfigurationProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 23));
            this.featureFlipsProvider = new SwitchingProvider(this.singletonCImpl, 22);
            this.msalObservabilityProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 26));
            this.intuneAuthManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 25));
            DelegateFactory.setDelegate((Provider) this.userContextManagerProvider, DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 5)));
            this.sessionManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 4));
            this.authInterceptorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 3));
        }

        private void initialize2(final ApplicationContextModule applicationContextModuleParam, final DataProvidesModule dataProvidesModuleParam) {
            this.provideGen204RequestInterceptorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 27));
            this.provideNetworkInterceptorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 28));
            this.provideEmptyBodyInterceptorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 29));
            this.configManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 30));
            this.provideHttpLoggingInterceptorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 32));
            this.provideHttpStreamLoggingInterceptorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 31));
            this.provideInterceptorsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 2));
            this.provideDefaultNoteFolderRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 1));
            this.defaultNoteFolderServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 0));
            this.providesSortPreferencesProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 34));
            this.userDataProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 36));
            this.captureHistoryCacheDataSourceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 35));
            this.gQLApolloClientConfiguratorProvider = new DelegateFactory();
            this.provideCollectionRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 41));
            this.gQLCollectionsResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 40);
            this.provideCollectionItemsRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 43));
            this.gQLCollectionItemsResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 42);
            this.provideBoxApiFileProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 45));
            this.provideBoxExtendedApiFolderProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 46));
            this.provideBoxApiWeblinkProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 47));
            this.gQLCollectionsWithItemResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 44);
            this.gQLCreateCollectionResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 48);
            this.gQLRemoveCollectionItemResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 49);
            this.gQLCreateCollectionItemResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 50);
            this.provideCreateFolderRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 52));
        }

        private void initialize3(final ApplicationContextModule applicationContextModuleParam, final DataProvidesModule dataProvidesModuleParam) {
            this.provideGetFolderItemsRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 53));
            this.provideUpdateItemRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 54));
            this.provideItemInfoRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 55));
            this.gQLCreateFolderResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 51);
            this.gQLGetFolderItemsResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 56);
            this.gQLCopyItemResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 57);
            this.gQLMoveItemResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 58);
            this.gQLGetItemResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 59);
            this.gQLGetItemWithWatermarkDataResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 60);
            this.gQLGetFolderMiniResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 61);
            this.gQLGetFolderMiniWithParentResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 62);
            this.gQLResponseInterceptorProvider = new SwitchingProvider(this.singletonCImpl, 39);
            this.forceUpdateRepositoryProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 66));
            this.forceUpdateVersionValidatorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 67));
            this.forceUpdateObservabilityProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 68));
            this.forceUpdateEvaluatorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 65));
            this.forceUpdateCoordinatorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 64));
            this.gQLForceUpdateInterceptorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 63));
            DelegateFactory.setDelegate((Provider) this.gQLApolloClientConfiguratorProvider, DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 38)));
            this.gQLCacheProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 37));
            this.boxLocalCacheProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 33));
            this.legacyMessageToGQLBridgeProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 69));
            this.boxThumbnailRequestsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 72));
            this.provideBoxApiCollectionsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 74));
            this.provideBoxApiPrivateProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 73));
        }

        private void initialize4(final ApplicationContextModule applicationContextModuleParam, final DataProvidesModule dataProvidesModuleParam) {
            this.provideBoxExtendedApiPreviewProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 75));
            this.provideSearchApiProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 78));
            this.providesBrowseControllerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 77));
            this.provideClientSettingsRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 80));
            this.provideIMoCoAdminSettingsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 79));
            SwitchingProvider switchingProvider = new SwitchingProvider(this.singletonCImpl, 76);
            this.boxPreviewControllerProvider = switchingProvider;
            this.provideBoxPreviewControllerProvider = DoubleCheck.provider((Provider) switchingProvider);
            this.provideIMoCoBoxTransfersProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 71));
            this.providesIMoCoBatchOperationsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 81));
            this.provideBoxApiCollaborationProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 82));
            this.factoryProvider = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 84));
            this.boxGraphQLProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 83));
            this.gen204PerformanceLoggerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 85));
            this.gQLPartialDataExtractorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 86));
            this.provideBoxApiBookmarkProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 88));
            this.provideBoxApiInviteeProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 89));
            this.provideBoxApiFeaturesProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 90));
            this.shareModelControllerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 87));
            this.gen204MoveCopyEventLoggerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 91));
            this.jobManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 70));
            this.provideAnonymousAuthRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 93));
            this.providesAuthenticationCredentialsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 94));
            this.provideUploadFileRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 95));
            this.providePreflightCheckRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 96));
            this.localItemServiceProvider = new DelegateFactory();
        }

        private void initialize5(final ApplicationContextModule applicationContextModuleParam, final DataProvidesModule dataProvidesModuleParam) {
            this.jobServiceProvider = new DelegateFactory();
            this.factoryProvider2 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 99));
            this.providesBoxStorageProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 101));
            this.provideChunkedUploadFileRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 103));
            this.userSessionInfoProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 104));
            this.factoryProvider3 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 102));
            this.factoryProvider4 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 105));
            this.provideFileMetadataRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 107));
            this.provideMetadataTemplatesRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 108));
            this.factoryProvider5 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 106));
            this.factoryProvider6 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 109));
            this.factoryProvider7 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 110));
            this.factoryProvider8 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 111));
            this.factoryProvider9 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 100));
            this.provideDeleteItemRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 113));
            this.factoryProvider10 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 112));
            this.factoryProvider11 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 114));
            this.provideFileDownloadRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 116));
            this.provideUpdateItemInfoRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 117));
            this.factoryProvider12 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 115));
            this.factoryProvider13 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 118));
            this.provideItemCollaborationsRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 120));
            this.factoryProvider14 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 119));
            this.factoryProvider15 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 121));
            this.factoryProvider16 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 122));
        }

        private void initialize6(final ApplicationContextModule applicationContextModuleParam, final DataProvidesModule dataProvidesModuleParam) {
            this.factoryProvider17 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 123));
            this.factoryProvider18 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 124));
            this.factoryProvider19 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 125));
            this.provideFileRepresentationsRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 127));
            this.providePreviewDownloadRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 128));
            this.provideAnnotationRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 129));
            this.provideFileActivitiesRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 130));
            this.factoryProvider20 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 126));
            this.factoryProvider21 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.LABEL));
            this.providesFirebaseRemoteConfigProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 135));
            this.forceUpdateConfigSynchronizerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 136));
            this.remoteConfigProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 134));
            this.gen204UploadEventLoggerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.LOOP));
            this.gen204OfflineEventLoggerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.SCRIPT));
            this.gen204JobServiceHelperProvider = new SwitchingProvider(this.singletonCImpl, Token.TARGET);
            this.provideRumServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 138));
            DelegateFactory.setDelegate((Provider) this.jobServiceProvider, DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 98)));
            DelegateFactory.setDelegate((Provider) this.localItemServiceProvider, (Provider) new SwitchingProvider(this.singletonCImpl, 97));
            this.allWorkerFactoriesProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 92));
            this.appInBackgroundServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 140));
            this.metricsUploadSchedulerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 139));
            this.jobsNotificationServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.SETELEM_OP));
            this.coldStartCalculationProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.SET_REF_OP));
            this.appStartHandlerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.LOCAL_BLOCK));
            this.providesSplashScreenAppStartIntermediatePageProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.COLONCOLON));
        }

        private void initialize7(final ApplicationContextModule applicationContextModuleParam, final DataProvidesModule dataProvidesModuleParam) {
            this.providesBrowseTabAppStartDestinationPageProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.XML));
            this.providesAppStartTargetHolderProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.DOTDOT));
            this.uploadFileCleanupServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.DOTQUERY));
            this.provideAppFlavorStringProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.XMLATTR));
            this.provideLevelDBKeyValueStoreProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.XMLEND));
            this.launchIntoCaptureInteractorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 150));
            this.provideBoxApiShareProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.TO_DOUBLE));
            this.provideUserContextMigrationProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.GET));
            this.screenshotCaptureProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.LET));
            this.betaFeedbackManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.SET));
            this.emailChooserHelperProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.SETCONST));
            this.betaFeedbackEmailSenderProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.CONST));
            this.getThumbnailRepresentationsServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.LETEXPR));
            this.thumbnailServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.ARRAYCOMP));
            this.thumbnailManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.SETCONSTVAR));
            this.provideBoxApiUserProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 160));
            this.provideAppUpdateManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.COMMENT));
            this.appUpdateProposalManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.DEBUGGER));
            this.offlineServiceLocalDataSourceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.METHOD));
            this.offlineMigrationServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.GENEXPR));
            this.offlineStateStorageProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.ARROW));
            this.provideRecentsRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.LAST_TOKEN));
            this.provideBoxApiLocalRecentItemsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 168));
            this.provideBoxApiRecentItemsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 169));
            this.providesIMoCoBoxRecentEventsProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, external.sdk.pendo.io.mozilla.javascript.Context.VERSION_1_7));
        }

        private void initialize8(final ApplicationContextModule applicationContextModuleParam, final DataProvidesModule dataProvidesModuleParam) {
            this.providesApdexServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 173));
            this.previewObservabilityProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, TsExtractor.TS_STREAM_TYPE_AC4));
            this.bridgedPreviewServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 174));
            this.thumbnailPreviewInteractorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 175));
            this.factoryProvider22 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 171));
            this.factoryProvider23 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, Token.YIELD_STAR));
            this.provideHubAssetDownloadRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 176));
            this.provideBoxAiRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 178));
            this.boxAiRemoteDataSourceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 177));
            this.boxAiObservabilityProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 179));
            this.providesCookieManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 181));
            this.providesBoxCsrfTokenManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 180));
            this.factoryProvider24 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 182));
            this.provideLastUsedTabDataStoreProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 183));
            this.media3AudioPlayerManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 184));
            this.forceUpdateActionHandlerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 185));
            this.provideTasksRepoProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, ContextualToolbar.DRAG_BUTTON_ALPHA));
            this.provideTaskRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 187));
            this.aiCenterSessionInfoProviderImplProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, TsExtractor.TS_PACKET_SIZE));
            this.hubsObservabilityProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, PsExtractor.PRIVATE_STREAM_1));
            this.provideInboxNotificationRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 191));
            this.inboxNotificationLocalDataSourceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 192));
            this.inboxBadgeRepositoryProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 190));
            this.provideInboxCollaborationRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 193));
            this.provideRecentNotesRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 195));
        }

        private void initialize9(final ApplicationContextModule applicationContextModuleParam, final DataProvidesModule dataProvidesModuleParam) {
            this.recentNotesLocalDataSourceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 196));
            this.recentNotesServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 194));
            this.provideFilesSearchRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 198));
            this.providePreferencesDataStoreProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 199));
            this.searchServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 197));
            this.systemInfoProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 200));
            this.provideWatermarkRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 201));
            this.gen204WatermarkingEventLoggerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 202));
            this.previousVersionPreviewObservabilityProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 203));
            this.provideCommentRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 204));
            this.provideCommentV2RequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 205));
            this.provideCommentsControllerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 206));
            this.textSearchManagerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 207));
            this.provideEventPropertyBuilderProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 209));
            this.wopiPropertyBuilderProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 208));
            this.providesFileCanBePreviewedCheckerProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, BoxCommonConstants.REQUEST_OPTIONS));
            this.provideFileVersionRequestProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, BoxCommonConstants.REQUEST_DELETE));
        }

        @Override // com.box.android.auth.UserContextProxyComponent.DefaultNoteFolderEntryPoint
        public IDefaultNoteFolderService defaultNoteFolderService() {
            return this.defaultNoteFolderServiceProvider.get();
        }

        @Override // com.box.android.coreservices.jobmanager.contentproviders.UploadSyncContentProvider.UploadSyncContentProviderEntryPoint, com.box.android.domain.analytics.BoxAmplitudeAnalytics.BoxAmplitudeAnalyticsEntryPoint, com.box.android.receiver.BoxBootReceiverEntryPoint
        public IUserContextManager userContextManager() {
            return this.userContextManagerProvider.get();
        }

        @Override // com.box.android.coreservices.utilities.CoreServiceUtils.CoreServiceUtilsEntryPoint
        public NotificationServices notificationServices() {
            return new AppNotificationServices();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public ConfigManager getConfigManager() {
            return this.configManagerProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public DeviceId getDeviceId() {
            return this.provideDeviceIdProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public BoxCache getBoxCache() {
            return this.boxLocalCacheProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public FeatureFlips getFeatureFlips() {
            return this.featureFlipsProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public LegacyMessageToGQLBridge getLegacyMessageToGQLBridge() {
            return this.legacyMessageToGQLBridgeProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public JobManager getJobManager() {
            return this.jobManagerProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public AllWorkerFactories getAllWorkerFactories() {
            return this.allWorkerFactoriesProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public IntuneAuthManager getIntuneAuthManager() {
            return this.intuneAuthManagerProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public MetricsUploadScheduler getMetricsUploadScheduler() {
            return this.metricsUploadSchedulerProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public JobsNotificationService getJobsNotificationService() {
            return this.jobsNotificationServiceProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public MetricsUseCase getMetricsUseCase() {
            return this.metricsInteractorProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public AppStartHandler getAppStartHandler() {
            return this.appStartHandlerProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public IAppStartDestinationPageHolder getAppStartTargetHolder() {
            return this.providesAppStartTargetHolderProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public RemoteConfig getRemoteConfig() {
            return this.remoteConfigProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public CirrusLoader getCirrusLoader() {
            return new CirrusLoader(boxAuthProvider(), boxConfigProvider(), boxAnalyticsProvider(), boxContentUploadService(), boxAccountSettingsProvider());
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public UploadFileCleanupService getUploadFileCleanupService() {
            return this.uploadFileCleanupServiceProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public SharedPreferences getGlobalSharedPreferences() {
            return this.provideGlobalSharedPreferencesProvider.get();
        }

        @Override // com.box.android.di.BoxApplicationEntryPoint
        public String getAppFlavor() {
            return this.provideAppFlavorStringProvider.get();
        }

        @Override // com.box.android.domain.analytics.BoxAmplitudeAnalytics.BoxAmplitudeAnalyticsEntryPoint
        public SharedPreferences globalSharedPreferences() {
            return this.provideGlobalSharedPreferencesProvider.get();
        }

        @Override // com.box.android.domain.analytics.BoxAmplitudeAnalytics.BoxAmplitudeAnalyticsEntryPoint
        public String appFlavor() {
            return this.provideAppFlavorStringProvider.get();
        }

        @Override // com.box.android.domain.analytics.BoxAmplitudeAnalytics.BoxAmplitudeAnalyticsEntryPoint
        public IAppRestrictionsManager appRestrictionsManager() {
            return appRestrictionsManager2();
        }

        @Override // com.box.android.domain.analytics.BoxAmplitudeAnalytics.BoxAmplitudeAnalyticsEntryPoint
        public IAppInBackgroundService appInBackgroundService() {
            return this.appInBackgroundServiceProvider.get();
        }

        @Override // com.box.android.domain.analytics.BoxAmplitudeAnalytics.BoxAmplitudeAnalyticsEntryPoint
        public FeatureFlips featureFlips() {
            return this.featureFlipsProvider.get();
        }

        @Override // com.box.android.observability.DiagnosticsNotificationHandler_GeneratedInjector
        public void injectDiagnosticsNotificationHandler(DiagnosticsNotificationHandler arg0) {
            injectDiagnosticsNotificationHandler2(arg0);
        }

        @Override // com.box.android.observers.BoxFileObserver.BoxFileObserverEntryPoint
        public ILocalItemService boxFileObserverLocalItemService() {
            return this.localItemServiceProvider.get();
        }

        @Override // com.box.android.receiver.BoxBootReceiverEntryPoint
        public BoxApiPrivate boxApiPrivate() {
            return this.provideBoxApiPrivateProvider.get();
        }

        @Override // com.box.android.receiver.BoxBootReceiverEntryPoint
        public LocalItemService localItemService() {
            return this.localItemServiceProvider.get();
        }

        @Override // com.box.android.receiver.BoxDeviceConfigChangeInfoReceiver_GeneratedInjector
        public void injectBoxDeviceConfigChangeInfoReceiver(BoxDeviceConfigChangeInfoReceiver arg0) {
            injectBoxDeviceConfigChangeInfoReceiver2(arg0);
        }

        @Override // com.box.android.receiver.CommentsReplyReceiver_GeneratedInjector
        public void injectCommentsReplyReceiver(CommentsReplyReceiver arg0) {
            injectCommentsReplyReceiver2(arg0);
        }

        @Override // com.box.android.receiver.DelayedNotificationReceiver_GeneratedInjector
        public void injectDelayedNotificationReceiver(DelayedNotificationReceiver arg0) {
            injectDelayedNotificationReceiver2(arg0);
        }

        @Override // com.box.android.receiver.ReferralReceiver_GeneratedInjector
        public void injectReferralReceiver(ReferralReceiver arg0) {
            injectReferralReceiver2(arg0);
        }

        @Override // com.box.android.usercontext.UserContext.UserContextEntryPoint
        public LevelDBKeyValueStore getLevelDBKeyValueStore() {
            return this.provideLevelDBKeyValueStoreProvider.get();
        }

        @Override // com.box.android.usercontext.UserContext.UserContextEntryPoint
        public UserInteractor getUserInteractor() {
            return new UserInteractor(userService());
        }

        @Override // com.box.android.usercontext.UserContext.UserContextEntryPoint
        public LaunchIntoCaptureUseCase getLaunchIntoCaptureUseCase() {
            return this.launchIntoCaptureInteractorProvider.get();
        }

        @Override // com.box.android.usercontext.UserContext.UserContextEntryPoint
        public JobService getJobService() {
            return this.jobServiceProvider.get();
        }

        @Override // dagger.hilt.android.flags.FragmentGetContextFix.FragmentGetContextFixEntryPoint
        public Set<Boolean> getDisableFragmentGetContextFix() {
            return ImmutableSet.of();
        }

        @Override // dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.ActivityRetainedComponentBuilderEntryPoint
        public ActivityRetainedComponentBuilder retainedComponentBuilder() {
            return new ActivityRetainedCBuilder(this.singletonCImpl);
        }

        @Override // dagger.hilt.android.internal.managers.ServiceComponentManager.ServiceComponentBuilderEntryPoint
        public ServiceComponentBuilder serviceComponentBuilder() {
            return new ServiceCBuilder(this.singletonCImpl);
        }

        private DiagnosticsNotificationHandler injectDiagnosticsNotificationHandler2(DiagnosticsNotificationHandler instance) {
            DiagnosticsNotificationHandler_MembersInjector.injectObservabilitySettingsManager(instance, new ObservabilitySettingsManager());
            DiagnosticsNotificationHandler_MembersInjector.injectCreateLogArchiveInteractor(instance, createLogArchiveInteractor());
            return instance;
        }

        private BoxDeviceConfigChangeInfoReceiver injectBoxDeviceConfigChangeInfoReceiver2(BoxDeviceConfigChangeInfoReceiver instance2) {
            BoxDeviceConfigChangeInfoReceiver_MembersInjector.injectMUserContextManager(instance2, this.userContextManagerProvider.get());
            BoxDeviceConfigChangeInfoReceiver_MembersInjector.injectMPrivateApi(instance2, this.provideBoxApiPrivateProvider.get());
            return instance2;
        }

        private CommentsReplyReceiver injectCommentsReplyReceiver2(CommentsReplyReceiver instance3) {
            CommentsReplyReceiver_MembersInjector.injectMFileApi(instance3, this.provideBoxApiFileProvider.get());
            CommentsReplyReceiver_MembersInjector.injectMBaseModelController(instance3, baseModelController());
            CommentsReplyReceiver_MembersInjector.injectMUserContextManager(instance3, this.userContextManagerProvider.get());
            CommentsReplyReceiver_MembersInjector.injectMApiPrivate(instance3, this.provideBoxApiPrivateProvider.get());
            return instance3;
        }

        private DelayedNotificationReceiver injectDelayedNotificationReceiver2(DelayedNotificationReceiver instance4) {
            DelayedNotificationReceiver_MembersInjector.injectMUserContextManager(instance4, this.userContextManagerProvider.get());
            DelayedNotificationReceiver_MembersInjector.injectMApiPrivate(instance4, this.provideBoxApiPrivateProvider.get());
            DelayedNotificationReceiver_MembersInjector.injectMGlobalSettings(instance4, this.providesIMoCoBoxGlobalSettingsProvider.get());
            DelayedNotificationReceiver_MembersInjector.injectMAppInBgService(instance4, this.appInBackgroundServiceProvider.get());
            return instance4;
        }

        private ReferralReceiver injectReferralReceiver2(ReferralReceiver instance5) {
            ReferralReceiver_MembersInjector.injectMGlobalSharedPreferences(instance5, this.provideGlobalSharedPreferencesProvider.get());
            ReferralReceiver_MembersInjector.injectMAppFlavor(instance5, this.provideAppFlavorStringProvider.get());
            return instance5;
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final int id;
            private final SingletonCImpl singletonCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
                this.singletonCImpl = singletonCImpl;
                this.id = id;
            }

            private T get0() {
                switch (this.id) {
                    case 0:
                        return (T) new DefaultNoteFolderService(this.singletonCImpl.defaultNoteFolderRemoteDataSource(), CommonModule_ProvidesClockFactory.providesClock());
                    case 1:
                        return (T) DataProvidesModule_ProvideDefaultNoteFolderRequestFactory.provideDefaultNoteFolderRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 2:
                        return (T) DataProvidesModule_ProvideInterceptorsFactory.provideInterceptors(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.authInterceptorProvider.get(), this.singletonCImpl.requestHeaderInterceptor(), this.singletonCImpl.provideGen204RequestInterceptorProvider.get(), this.singletonCImpl.provideNetworkInterceptorProvider.get(), this.singletonCImpl.provideEmptyBodyInterceptorProvider.get(), this.singletonCImpl.sharedLinkAuthInterceptor(), this.singletonCImpl.devpodInterceptor(), new AiRequestInterceptor(), this.singletonCImpl.provideHttpStreamLoggingInterceptorProvider.get());
                    case 3:
                        return (T) new AuthInterceptor(this.singletonCImpl.sessionManagerProvider.get());
                    case 4:
                        return (T) new SessionManager(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 5:
                        return (T) new UserContextManager(this.singletonCImpl.provideApplicationContextProvider.get(), this.singletonCImpl.provideAndroidForWorkControllerProvider.get(), this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get(), this.singletonCImpl.provideDeviceIdProvider.get(), this.singletonCImpl.boxSessionFactoryProvider.get(), DoubleCheck.lazy((Provider) this.singletonCImpl.registerPushDeviceInteractorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.updateDeviceRegistrationInteractorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.metricsInteractorProvider), this.singletonCImpl.appRestrictionsManager2(), this.singletonCImpl.bVEManager(), DoubleCheck.lazy((Provider) this.singletonCImpl.featureFlipsProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.intuneAuthManagerProvider));
                    case 6:
                        return (T) BoxModule_Companion_ProvideApplicationContextFactory.provideApplicationContext(ApplicationContextModule_ProvideApplicationFactory.provideApplication(this.singletonCImpl.applicationContextModule));
                    case 7:
                        return (T) DefaultModule_Companion_ProvideAndroidForWorkControllerFactory.provideAndroidForWorkController(this.singletonCImpl.appRestrictionsManager2(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 8:
                        return (T) BoxModule_Companion_ProvidesIMoCoBoxGlobalSettingsFactory.providesIMoCoBoxGlobalSettings(this.singletonCImpl.moCoBoxGlobalSettings());
                    case 9:
                        return (T) BoxModule_Companion_ProvideGlobalExecutorFactory.provideGlobalExecutor();
                    case 10:
                        return (T) DefaultModule_Companion_ProvideDeviceIdFactory.provideDeviceId(this.singletonCImpl.provideDeviceIdStorageProvider.get());
                    case 11:
                        return (T) DefaultModule_Companion_ProvideDeviceIdStorageFactory.provideDeviceIdStorage(this.singletonCImpl.provideStorageProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 12:
                        return (T) DefaultModule_Companion_ProvideStorageFactory.provideStorage();
                    case 13:
                        return (T) new BoxSessionFactory(this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get(), this.singletonCImpl.provideAndroidForWorkControllerProvider.get(), this.singletonCImpl.provideDeviceIdProvider.get(), new AppIntentServices(), this.singletonCImpl.appRestrictionsManager2(), this.singletonCImpl.userContext());
                    case 14:
                        return (T) new RegisterPushDeviceInteractor(this.singletonCImpl.pushNotificationSettingsService());
                    case 15:
                        return (T) DataProvidesModule_ProvidePushNotificationSettingsRequestFactory.providePushNotificationSettingsRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 16:
                        return (T) DataProvidesModule_ProvideMoshiFactory.provideMoshi(this.singletonCImpl.dataProvidesModule);
                    case 17:
                        return (T) new UpdateDeviceRegistrationInteractor(this.singletonCImpl.pushNotificationSettingsService());
                    case 18:
                        return (T) new MetricsInteractor(this.singletonCImpl.metricsLoggingServiceProvider.get(), this.singletonCImpl.setOfMetricDecorator());
                    case 19:
                        return (T) new MetricsLoggingService(this.singletonCImpl.metricsCacheDataSource(), this.singletonCImpl.metricsRemoteDataSource(), this.singletonCImpl.metricsEntityDTOMapper());
                    case 20:
                        return (T) new ObservabilityDatabaseProvider(new ObservabilityDatabaseCreator(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 21:
                        return (T) DataProvidesModule_ProvideGen204RequestFactory.provideGen204Request(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2(), this.singletonCImpl.bVEManager());
                    case 22:
                        return (T) new FeatureFlips(this.singletonCImpl.boxAccountSettings(), this.singletonCImpl.namedSharedPreferences(), this.singletonCImpl.featureFlipEvaluator());
                    case 23:
                        return (T) new SplitConfiguration(this.singletonCImpl.provideGlobalSharedPreferencesProvider.get(), this.singletonCImpl.boxAccountSettings(), this.singletonCImpl.bVEManager());
                    case 24:
                        return (T) BoxModule_Companion_ProvideGlobalSharedPreferencesFactory.provideGlobalSharedPreferences();
                    case 25:
                        return (T) new IntuneAuthManager(this.singletonCImpl.provideApplicationContextProvider.get(), this.singletonCImpl.userContextManagerProvider.get(), new IntuneComponentCreator(), new AppNotificationServices(), this.singletonCImpl.msalObservabilityProvider.get(), new AppIntentServices(), this.singletonCImpl.featureFlipsProvider.get());
                    case 26:
                        return (T) new MsalObservability(this.singletonCImpl.metricsInteractorProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case 27:
                        return (T) DataProvidesModule_ProvideGen204RequestInterceptorFactory.provideGen204RequestInterceptor(this.singletonCImpl.dataProvidesModule);
                    case 28:
                        return (T) DataProvidesModule_ProvideNetworkInterceptorFactory.provideNetworkInterceptor(this.singletonCImpl.dataProvidesModule);
                    case 29:
                        return (T) DataProvidesModule_ProvideEmptyBodyInterceptorFactory.provideEmptyBodyInterceptor(this.singletonCImpl.dataProvidesModule);
                    case 30:
                        return (T) new ConfigManager(this.singletonCImpl.provideApplicationContextProvider.get(), this.singletonCImpl.provideGlobalSharedPreferencesProvider.get(), new ProductFlavorConfigProvider());
                    case 31:
                        return (T) DataProvidesModule_ProvideHttpStreamLoggingInterceptorFactory.provideHttpStreamLoggingInterceptor(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.provideHttpLoggingInterceptorProvider.get());
                    case 32:
                        return (T) DataProvidesModule_ProvideHttpLoggingInterceptorFactory.provideHttpLoggingInterceptor(this.singletonCImpl.dataProvidesModule);
                    case 33:
                        return (T) new BoxLocalCache(this.singletonCImpl.provideApplicationContextProvider.get(), this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.providesSortPreferencesProvider.get(), this.singletonCImpl.legacyBridgeService(), this.singletonCImpl.configManagerProvider.get(), this.singletonCImpl.providesIMoCoBoxGlobalSettingsProvider.get(), this.singletonCImpl.appRestrictionsManager2());
                    case 34:
                        return (T) DefaultModule_Companion_ProvidesSortPreferencesFactory.providesSortPreferences(this.singletonCImpl.userContextManagerProvider.get());
                    case 35:
                        return (T) new CaptureHistoryCacheDataSource(this.singletonCImpl.userDataProvider.get());
                    case 36:
                        return (T) new UserData(this.singletonCImpl.provideApplicationContextProvider.get(), new DatabaseProvider());
                    case 37:
                        return (T) new GQLCache(this.singletonCImpl.gQLApolloClientConfiguratorProvider.get());
                    case 38:
                        return (T) new GQLApolloClientConfigurator(this.singletonCImpl.provideApplicationContextProvider.get(), this.singletonCImpl.userDataProvider.get(), this.singletonCImpl.authInterceptorProvider.get(), this.singletonCImpl.sharedLinkAuthInterceptor(), this.singletonCImpl.gQLClientRequestInterceptor(), this.singletonCImpl.bVEManager(), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLForceUpdateInterceptorProvider));
                    case 39:
                        return (T) new GQLResponseInterceptor(this.singletonCImpl.gQLApolloClientConfiguratorProvider.get(), this.singletonCImpl.gQLRequestParser(), this.singletonCImpl.provideMoshiProvider.get(), this.singletonCImpl.featureFlipsProvider.get(), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLCollectionsResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLCollectionItemsResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLCollectionsWithItemResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLCreateCollectionResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLRemoveCollectionItemResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLCreateCollectionItemResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLCreateFolderResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLGetFolderItemsResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLCopyItemResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLMoveItemResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLGetItemResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLGetItemWithWatermarkDataResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLGetFolderMiniResponseInterceptorProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.gQLGetFolderMiniWithParentResponseInterceptorProvider));
                    case 40:
                        return (T) new GQLCollectionsResponseInterceptor(this.singletonCImpl.collectionsRemoteDataSource(), this.singletonCImpl.provideMoshiProvider.get());
                    case 41:
                        return (T) DataProvidesModule_ProvideCollectionRequestFactory.provideCollectionRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 42:
                        return (T) new GQLCollectionItemsResponseInterceptor(this.singletonCImpl.collectionItemsRemoteDataSource(), this.singletonCImpl.gQLRequestParser(), this.singletonCImpl.provideMoshiProvider.get());
                    case 43:
                        return (T) DataProvidesModule_ProvideCollectionItemsRequestFactory.provideCollectionItemsRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 44:
                        return (T) new GQLCollectionsWithItemResponseInterceptor(this.singletonCImpl.gQLRequestParser(), this.singletonCImpl.provideBoxApiFileProvider.get(), this.singletonCImpl.provideBoxExtendedApiFolderProvider.get(), this.singletonCImpl.provideBoxApiWeblinkProvider.get(), this.singletonCImpl.baseModelController(), this.singletonCImpl.provideMoshiProvider.get());
                    case 45:
                        return (T) BoxModule_Companion_ProvideBoxApiFileFactory.provideBoxApiFile(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 46:
                        return (T) DefaultModule_Companion_ProvideBoxExtendedApiFolderFactory.provideBoxExtendedApiFolder(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 47:
                        return (T) DefaultModule_Companion_ProvideBoxApiWeblinkFactory.provideBoxApiWeblink(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 48:
                        return (T) new GQLCreateCollectionResponseInterceptor(this.singletonCImpl.collectionsRemoteDataSource(), this.singletonCImpl.provideMoshiProvider.get());
                    case 49:
                        return (T) new GQLRemoveCollectionItemResponseInterceptor(this.singletonCImpl.collectionItemsRemoteDataSource(), this.singletonCImpl.gQLRequestParser(), this.singletonCImpl.provideMoshiProvider.get());
                    case 50:
                        return (T) new GQLCreateCollectionItemResponseInterceptor(this.singletonCImpl.collectionItemsRemoteDataSource(), this.singletonCImpl.gQLRequestParser(), this.singletonCImpl.provideMoshiProvider.get());
                    case 51:
                        return (T) new GQLCreateFolderResponseInterceptor(this.singletonCImpl.itemRemoteDataSource(), this.singletonCImpl.gQLRequestParser(), this.singletonCImpl.provideMoshiProvider.get());
                    case 52:
                        return (T) DataProvidesModule_ProvideCreateFolderRequestFactory.provideCreateFolderRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 53:
                        return (T) DataProvidesModule_ProvideGetFolderItemsRequestFactory.provideGetFolderItemsRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 54:
                        return (T) DataProvidesModule_ProvideUpdateItemRequestFactory.provideUpdateItemRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 55:
                        return (T) DataProvidesModule_ProvideItemInfoRequestFactory.provideItemInfoRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 56:
                        return (T) new GQLGetFolderItemsResponseInterceptor(this.singletonCImpl.itemRemoteDataSource(), this.singletonCImpl.gQLRequestParser(), this.singletonCImpl.provideMoshiProvider.get(), this.singletonCImpl.gQLCacheHelper());
                    case 57:
                        return (T) new GQLCopyItemResponseInterceptor(this.singletonCImpl.itemRemoteDataSource(), this.singletonCImpl.gQLRequestParser(), this.singletonCImpl.provideMoshiProvider.get());
                    case 58:
                        return (T) new GQLMoveItemResponseInterceptor(this.singletonCImpl.itemRemoteDataSource(), this.singletonCImpl.gQLRequestParser(), this.singletonCImpl.provideMoshiProvider.get());
                    case 59:
                        return (T) new GQLGetItemResponseInterceptor(this.singletonCImpl.itemRemoteDataSource(), this.singletonCImpl.gQLRequestParser(), this.singletonCImpl.provideMoshiProvider.get());
                    case 60:
                        return (T) new GQLGetItemWithWatermarkDataResponseInterceptor(this.singletonCImpl.itemRemoteDataSource(), this.singletonCImpl.gQLRequestParser(), this.singletonCImpl.provideMoshiProvider.get());
                    case 61:
                        return (T) new GQLGetFolderMiniResponseInterceptor(this.singletonCImpl.itemRemoteDataSource(), this.singletonCImpl.gQLRequestParser(), this.singletonCImpl.provideMoshiProvider.get());
                    case 62:
                        return (T) new GQLGetFolderMiniWithParentResponseInterceptor(this.singletonCImpl.itemRemoteDataSource(), this.singletonCImpl.gQLRequestParser(), this.singletonCImpl.provideMoshiProvider.get());
                    case 63:
                        return (T) new GQLForceUpdateInterceptor(this.singletonCImpl.forceUpdateCoordinatorProvider.get(), this.singletonCImpl.provideMoshiProvider.get());
                    case 64:
                        return (T) new ForceUpdateCoordinator(this.singletonCImpl.forceUpdateEvaluatorProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 65:
                        return (T) new ForceUpdateEvaluator(this.singletonCImpl.forceUpdateRepositoryProvider.get(), this.singletonCImpl.forceUpdateVersionValidatorProvider.get(), this.singletonCImpl.forceUpdateObservabilityProvider.get(), new ForceUpdateAnalytics(), this.singletonCImpl.appInfoService());
                    case 66:
                        return (T) new ForceUpdateRepository(this.singletonCImpl.namedSharedPreferences2());
                    case 67:
                        return (T) new ForceUpdateVersionValidator();
                    case 68:
                        return (T) new ForceUpdateObservability(this.singletonCImpl.metricsInteractorProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case 69:
                        return (T) new LegacyMessageToGQLBridge(this.singletonCImpl.legacyBridgeService());
                    case 70:
                        return (T) new JobManager(this.singletonCImpl.provideIMoCoBoxTransfersProvider.get(), this.singletonCImpl.provideBoxApiFileProvider.get(), this.singletonCImpl.provideBoxExtendedApiFolderProvider.get(), this.singletonCImpl.provideBoxApiWeblinkProvider.get(), this.singletonCImpl.baseModelController(), this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.providesIMoCoBatchOperationsProvider.get(), this.singletonCImpl.provideIMoCoAdminSettingsProvider.get(), this.singletonCImpl.provideBoxApiPrivateProvider.get(), this.singletonCImpl.provideBoxApiCollaborationProvider.get(), new AppNotificationServices(), this.singletonCImpl.remoteItemService(), new AppIntentServices(), this.singletonCImpl.jobManagerNotificationCenter(), this.singletonCImpl.gen204MoveCopyEventLoggerProvider.get());
                    case 71:
                        return (T) DefaultModule_Companion_ProvideIMoCoBoxTransfersFactory.provideIMoCoBoxTransfers(this.singletonCImpl.moCoBoxTransfers());
                    case 72:
                        return (T) new BoxThumbnailRequests();
                    case 73:
                        return (T) DefaultModule_Companion_ProvideBoxApiPrivateFactory.provideBoxApiPrivate(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideBoxExtendedApiFolderProvider.get(), this.singletonCImpl.provideBoxApiFileProvider.get(), this.singletonCImpl.provideBoxApiWeblinkProvider.get(), this.singletonCImpl.provideBoxApiCollectionsProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 74:
                        return (T) DefaultModule_Companion_ProvideBoxApiCollectionsFactory.provideBoxApiCollections(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 75:
                        return (T) DefaultModule_Companion_ProvideBoxExtendedApiPreviewFactory.provideBoxExtendedApiPreview(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 76:
                        return (T) new BoxPreviewController(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideBoxExtendedApiPreviewProvider.get(), this.singletonCImpl.provideBoxExtendedApiFolderProvider.get(), this.singletonCImpl.providesBrowseControllerProvider.get(), this.singletonCImpl.provideIMoCoAdminSettingsProvider.get(), this.singletonCImpl.featureFlipsProvider.get());
                    case 77:
                        return (T) DataProvidesModule_ProvidesBrowseControllerFactory.providesBrowseController(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideBoxApiFileProvider.get(), this.singletonCImpl.provideBoxExtendedApiFolderProvider.get(), this.singletonCImpl.provideSearchApiProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get(), BoxModule_Companion_ProvideApiExecutorFactory.provideApiExecutor(), this.singletonCImpl.namedThreadPoolExecutor());
                    case 78:
                        return (T) DefaultModule_Companion_ProvideSearchApiFactory.provideSearchApi(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 79:
                        return (T) DefaultModule_Companion_ProvideIMoCoAdminSettingsFactory.provideIMoCoAdminSettings(this.singletonCImpl.moCoAdminSettings());
                    case 80:
                        return (T) DataProvidesModule_ProvideClientSettingsRequestFactory.provideClientSettingsRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 81:
                        return (T) DefaultModule_Companion_ProvidesIMoCoBatchOperationsFactory.providesIMoCoBatchOperations(this.singletonCImpl.moCoBatchOperations());
                    case 82:
                        return (T) DefaultModule_Companion_ProvideBoxApiCollaborationFactory.provideBoxApiCollaboration(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.boxLocalCacheProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 83:
                        return (T) new BoxGraphQL(this.singletonCImpl.gQLApolloClientConfiguratorProvider.get(), this.singletonCImpl.factoryProvider.get());
                    case 84:
                        return (T) new QueryDebouncer.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.1
                            @Override // com.box.android.data.datasource.gql.QueryDebouncer.Factory
                            public QueryDebouncer create(int exclusionPeriod, DateProviding dateProvider) {
                                return new QueryDebouncer(exclusionPeriod, dateProvider);
                            }
                        };
                    case 85:
                        return (T) new Gen204PerformanceLogger(this.singletonCImpl.metricsInteractorProvider.get());
                    case 86:
                        return (T) new GQLPartialDataExtractor(this.singletonCImpl.gQLDbHelper(), this.singletonCImpl.gQLPartialModelParser(), this.singletonCImpl.gQLPartialMiniItemsSorter(), this.singletonCImpl.gQLCacheHelper(), this.singletonCImpl.gQLCacheProvider.get());
                    case 87:
                        return (T) new ShareModelController(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get(), this.singletonCImpl.provideBoxExtendedApiFolderProvider.get(), this.singletonCImpl.provideBoxApiFileProvider.get(), this.singletonCImpl.provideBoxApiBookmarkProvider.get(), this.singletonCImpl.provideBoxApiInviteeProvider.get(), this.singletonCImpl.provideBoxApiCollaborationProvider.get(), this.singletonCImpl.provideBoxApiFeaturesProvider.get());
                    case 88:
                        return (T) DefaultModule_Companion_ProvideBoxApiBookmarkFactory.provideBoxApiBookmark(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 89:
                        return (T) DefaultModule_Companion_ProvideBoxApiInviteeFactory.provideBoxApiInvitee(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 90:
                        return (T) DefaultModule_Companion_ProvideBoxApiFeaturesFactory.provideBoxApiFeatures(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 91:
                        return (T) new Gen204MoveCopyEventLogger(this.singletonCImpl.metricsInteractorProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case 92:
                        return (T) new AllWorkerFactories(this.singletonCImpl.workManagerWorkerFactory(), this.singletonCImpl.jobWorkerFactory());
                    case 93:
                        return (T) DataProvidesModule_ProvideAnonymousAuthRequestFactory.provideAnonymousAuthRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 94:
                        return (T) BoxModule_Companion_ProvidesAuthenticationCredentialsProviderFactory.providesAuthenticationCredentialsProvider(this.singletonCImpl.configManagerProvider.get());
                    case 95:
                        return (T) DataProvidesModule_ProvideUploadFileRequestFactory.provideUploadFileRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 96:
                        return (T) DataProvidesModule_ProvidePreflightCheckRequestFactory.providePreflightCheckRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 97:
                        return (T) new LocalItemService(this.singletonCImpl.localItemsDataSource(), this.singletonCImpl.localItemServiceItemsCreator(), this.singletonCImpl.legacyCacheDataSource(), this.singletonCImpl.jobServiceProvider.get(), this.singletonCImpl.remoteItemService(), this.singletonCImpl.itemIdMappingService(), this.singletonCImpl.baseModelController(), this.singletonCImpl.provideBoxApiFileProvider.get(), this.singletonCImpl.userContextManagerProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case 98:
                        return (T) new JobService(this.singletonCImpl.provideApplicationContextProvider.get(), this.singletonCImpl.jobsDataSource(), this.singletonCImpl.jobFactory(), DoubleCheck.lazy((Provider) this.singletonCImpl.gen204JobServiceHelperProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.provideRumServiceProvider), DoubleCheck.lazy((Provider) this.singletonCImpl.featureFlipsProvider), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case 99:
                        return (T) new CreateFolderJob.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.2
                            @Override // com.box.android.data.jobs.CreateFolderJob.Factory
                            public CreateFolderJob createJob(JobId jobId, Data inputData) {
                                return new CreateFolderJob(SwitchingProvider.this.singletonCImpl.createFolderService(), SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get(), SwitchingProvider.this.singletonCImpl.idMappingService(), jobId, inputData, SwitchingProvider.this.singletonCImpl.provideApplicationContextProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get());
                            }
                        };
                    default:
                        throw new AssertionError(this.id);
                }
            }

            private T get1() {
                switch (this.id) {
                    case 100:
                        return (T) new UploadFileJobV2.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.3
                            @Override // com.box.android.data.jobs.UploadFileJobV2.Factory
                            public UploadFileJobV2 createJob(JobId jobId2, Data inputData2) {
                                return new UploadFileJobV2(SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get(), SwitchingProvider.this.singletonCImpl.provideMoshiProvider.get(), SwitchingProvider.this.singletonCImpl.providesBoxStorageProvider.get(), jobId2, inputData2, SwitchingProvider.this.singletonCImpl.provideApplicationContextProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), SwitchingProvider.this.singletonCImpl.uploadStatesFactory(), SwitchingProvider.this.singletonCImpl.idMappingService());
                            }
                        };
                    case 101:
                        return (T) BoxModule_Companion_ProvidesBoxStorageFactory.providesBoxStorage(this.singletonCImpl.provideApplicationContextProvider.get(), this.singletonCImpl.userContextManagerProvider.get());
                    case 102:
                        return (T) new InitialState.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.4
                            @Override // com.box.android.data.api.models.upload.InitialState.Factory
                            public InitialState createState(UploadFileJobV2 job) {
                                return new InitialState(SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), job, SwitchingProvider.this.singletonCImpl.uploadFileService(), SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get());
                            }
                        };
                    case 103:
                        return (T) DataProvidesModule_ProvideChunkedUploadFileRequestFactory.provideChunkedUploadFileRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 104:
                        return (T) new UserSessionInfo();
                    case 105:
                        return (T) new PreflightCheckState.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.5
                            @Override // com.box.android.data.api.models.upload.PreflightCheckState.Factory
                            public PreflightCheckState createState(UploadFileJobV2 job2) {
                                return new PreflightCheckState(SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), job2, SwitchingProvider.this.singletonCImpl.uploadFileService(), SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get(), SwitchingProvider.this.singletonCImpl.commonServiceUtils(), SwitchingProvider.this.singletonCImpl.idMappingService());
                            }
                        };
                    case 106:
                        return (T) new UploadWholeFileState.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.6
                            @Override // com.box.android.data.api.models.upload.UploadWholeFileState.Factory
                            public UploadWholeFileState createState(UploadFileJobV2 job3) {
                                return new UploadWholeFileState(SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), job3, SwitchingProvider.this.singletonCImpl.uploadFileService(), SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get(), SwitchingProvider.this.singletonCImpl.idMappingService(), SwitchingProvider.this.singletonCImpl.fileMetadataService(), DoubleCheck.lazy((Provider) SwitchingProvider.this.singletonCImpl.featureFlipsProvider));
                            }
                        };
                    case 107:
                        return (T) DataProvidesModule_ProvideFileMetadataRequestFactory.provideFileMetadataRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 108:
                        return (T) DataProvidesModule_ProvideMetadataTemplatesRequestFactory.provideMetadataTemplatesRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 109:
                        return (T) new UploadSessionCreationState.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.7
                            @Override // com.box.android.data.api.models.upload.UploadSessionCreationState.Factory
                            public UploadSessionCreationState createState(UploadFileJobV2 job4) {
                                return new UploadSessionCreationState(SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), job4, SwitchingProvider.this.singletonCImpl.uploadFileService(), SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get(), SwitchingProvider.this.singletonCImpl.commonServiceUtils(), SwitchingProvider.this.singletonCImpl.idMappingService());
                            }
                        };
                    case 110:
                        return (T) new UploadChunksState.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.8
                            @Override // com.box.android.data.api.models.upload.UploadChunksState.Factory
                            public UploadChunksState createState(UploadFileJobV2 job5) {
                                return new UploadChunksState(SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), job5, SwitchingProvider.this.singletonCImpl.uploadFileService(), SwitchingProvider.this.singletonCImpl.provideMoshiProvider.get(), SwitchingProvider.this.singletonCImpl.commonServiceUtils());
                            }
                        };
                    case 111:
                        return (T) new CommitSessionState.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.9
                            @Override // com.box.android.data.api.models.upload.CommitSessionState.Factory
                            public CommitSessionState createState(UploadFileJobV2 job6) {
                                return new CommitSessionState(SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), job6, SwitchingProvider.this.singletonCImpl.uploadFileService(), SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get(), SwitchingProvider.this.singletonCImpl.commonServiceUtils(), SwitchingProvider.this.singletonCImpl.fileMetadataService(), DoubleCheck.lazy((Provider) SwitchingProvider.this.singletonCImpl.featureFlipsProvider));
                            }
                        };
                    case 112:
                        return (T) new DeleteFileJob.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.10
                            @Override // com.box.android.data.jobs.DeleteFileJob.Factory
                            public DeleteFileJob createJob(JobId jobId3, Data inputData3) {
                                return new DeleteFileJob(SwitchingProvider.this.singletonCImpl.provideApplicationContextProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), SwitchingProvider.this.singletonCImpl.deleteFileService(), SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get(), SwitchingProvider.this.singletonCImpl.idMappingService(), jobId3, inputData3);
                            }
                        };
                    case 113:
                        return (T) DataProvidesModule_ProvideDeleteItemRequestFactory.provideDeleteItemRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 114:
                        return (T) new ChunkUploadJob.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.11
                            @Override // com.box.android.data.jobs.ChunkUploadJob.Factory
                            public ChunkUploadJob createJob(JobId jobId4, Data inputData4) {
                                return new ChunkUploadJob(SwitchingProvider.this.singletonCImpl.uploadFileService(), SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get(), SwitchingProvider.this.singletonCImpl.provideMoshiProvider.get(), jobId4, inputData4, SwitchingProvider.this.singletonCImpl.provideApplicationContextProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                            }
                        };
                    case 115:
                        return (T) new DownloadFileJob.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.12
                            @Override // com.box.android.data.jobs.DownloadFileJob.Factory
                            public DownloadFileJob createJob(JobId jobId5, Data inputData5) {
                                return new DownloadFileJob(SwitchingProvider.this.singletonCImpl.downloadFileService(), SwitchingProvider.this.singletonCImpl.remoteItemService(), SwitchingProvider.this.singletonCImpl.providesBoxStorageProvider.get(), SwitchingProvider.this.singletonCImpl.provideMoshiProvider.get(), SwitchingProvider.this.singletonCImpl.sharedLinkService(), jobId5, inputData5, SwitchingProvider.this.singletonCImpl.provideApplicationContextProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get());
                            }
                        };
                    case 116:
                        return (T) DataProvidesModule_ProvideFileDownloadRequestFactory.provideFileDownloadRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 117:
                        return (T) DataProvidesModule_ProvideUpdateItemInfoRequestFactory.provideUpdateItemInfoRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 118:
                        return (T) new DownloadChunkJob.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.13
                            @Override // com.box.android.data.jobs.DownloadChunkJob.Factory
                            public DownloadChunkJob createJob(JobId jobId6, Data inputData6) {
                                return new DownloadChunkJob(SwitchingProvider.this.singletonCImpl.downloadFileService(), SwitchingProvider.this.singletonCImpl.providesBoxStorageProvider.get(), SwitchingProvider.this.singletonCImpl.provideMoshiProvider.get(), jobId6, inputData6, SwitchingProvider.this.singletonCImpl.provideApplicationContextProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get());
                            }
                        };
                    case 119:
                        return (T) new DeleteCollaborationJob.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.14
                            @Override // com.box.android.data.jobs.DeleteCollaborationJob.Factory
                            public DeleteCollaborationJob createJob(JobId jobId7, Data inputData7) {
                                return new DeleteCollaborationJob(SwitchingProvider.this.singletonCImpl.provideApplicationContextProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), SwitchingProvider.this.singletonCImpl.itemCollaborationsService(), SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get(), jobId7, inputData7, SwitchingProvider.this.singletonCImpl.idMappingService());
                            }
                        };
                    case 120:
                        return (T) DataProvidesModule_ProvideItemCollaborationsRequestFactory.provideItemCollaborationsRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 121:
                        return (T) new DownloadFolderJob.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.15
                            @Override // com.box.android.data.jobs.DownloadFolderJob.Factory
                            public DownloadFolderJob createJob(JobId jobId8, Data inputData8) {
                                return new DownloadFolderJob(SwitchingProvider.this.singletonCImpl.remoteItemService(), SwitchingProvider.this.singletonCImpl.provideMoshiProvider.get(), jobId8, inputData8, SwitchingProvider.this.singletonCImpl.provideApplicationContextProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get());
                            }
                        };
                    case 122:
                        return (T) new UploadFolderJob.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.16
                            @Override // com.box.android.data.jobs.UploadFolderJob.Factory
                            public UploadFolderJob createJob(JobId jobId9, Data inputData9) {
                                return new UploadFolderJob(SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get(), SwitchingProvider.this.singletonCImpl.provideMoshiProvider.get(), jobId9, inputData9, SwitchingProvider.this.singletonCImpl.provideApplicationContextProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), SwitchingProvider.this.singletonCImpl.idMappingService(), SwitchingProvider.this.singletonCImpl.remoteItemService(), SwitchingProvider.this.singletonCImpl.providesBoxStorageProvider.get());
                            }
                        };
                    case 123:
                        return (T) new MoveItemJob.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.17
                            @Override // com.box.android.data.jobs.MoveItemJob.Factory
                            public MoveItemJob createJob(JobId jobId10, Data inputData10) {
                                return new MoveItemJob(SwitchingProvider.this.singletonCImpl.provideApplicationContextProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get(), SwitchingProvider.this.singletonCImpl.remoteItemService(), jobId10, inputData10, SwitchingProvider.this.singletonCImpl.idMappingService(), SwitchingProvider.this.singletonCImpl.moveCopyJobInputValidator());
                            }
                        };
                    case 124:
                        return (T) new CopyItemJob.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.18
                            @Override // com.box.android.data.jobs.CopyItemJob.Factory
                            public CopyItemJob createJob(JobId jobId11, Data inputData11) {
                                return new CopyItemJob(SwitchingProvider.this.singletonCImpl.provideApplicationContextProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get(), SwitchingProvider.this.singletonCImpl.remoteItemService(), jobId11, inputData11, SwitchingProvider.this.singletonCImpl.idMappingService(), SwitchingProvider.this.singletonCImpl.moveCopyJobInputValidator());
                            }
                        };
                    case 125:
                        return (T) new AutoUploadJob.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.19
                            @Override // com.box.android.data.jobs.AutoUploadJob.Factory
                            public AutoUploadJob createJob(JobId jobId12, Data inputData12) {
                                return new AutoUploadJob(SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get(), SwitchingProvider.this.singletonCImpl.provideMoshiProvider.get(), jobId12, inputData12, SwitchingProvider.this.singletonCImpl.provideApplicationContextProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), SwitchingProvider.this.singletonCImpl.remoteItemService(), SwitchingProvider.this.singletonCImpl.providesBoxStorageProvider.get(), SwitchingProvider.this.singletonCImpl.userContextManagerProvider.get());
                            }
                        };
                    case 126:
                        return (T) new MarkForOfflineJob.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.20
                            @Override // com.box.android.data.jobs.MarkForOfflineJob.Factory
                            public MarkForOfflineJob createJob(JobId jobId13, Data inputData13) {
                                return new MarkForOfflineJob(SwitchingProvider.this.singletonCImpl.provideMoshiProvider.get(), jobId13, inputData13, SwitchingProvider.this.singletonCImpl.provideApplicationContextProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), SwitchingProvider.this.singletonCImpl.remoteItemService(), SwitchingProvider.this.singletonCImpl.userContextManagerProvider.get(), SwitchingProvider.this.singletonCImpl.fileWithRepresentationsService(), SwitchingProvider.this.singletonCImpl.representationsService(), new PreviewerTypeResolverImpl(), SwitchingProvider.this.singletonCImpl.previewDownloadRemoteDataSource(), SwitchingProvider.this.singletonCImpl.annotationsService(), SwitchingProvider.this.singletonCImpl.fileActivitiesService(), SwitchingProvider.this.singletonCImpl.featureFlipsProvider.get());
                            }
                        };
                    case 127:
                        return (T) DataProvidesModule_ProvideFileRepresentationsRequestFactory.provideFileRepresentationsRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 128:
                        return (T) DataProvidesModule_ProvidePreviewDownloadRequestFactory.providePreviewDownloadRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 129:
                        return (T) DataProvidesModule_ProvideAnnotationRequestFactory.provideAnnotationRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 130:
                        return (T) DataProvidesModule_ProvideFileActivitiesRequestFactory.provideFileActivitiesRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case Token.LABEL /* 131 */:
                        return (T) new MarkForOfflineFolderJob.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.21
                            @Override // com.box.android.data.jobs.MarkForOfflineFolderJob.Factory
                            public MarkForOfflineFolderJob createJob(JobId jobId14, Data inputData14) {
                                return new MarkForOfflineFolderJob(SwitchingProvider.this.singletonCImpl.provideMoshiProvider.get(), jobId14, inputData14, SwitchingProvider.this.singletonCImpl.provideApplicationContextProvider.get(), SwitchingProvider.this.singletonCImpl.jobServiceProvider.get(), SwitchingProvider.this.singletonCImpl.remoteItemService(), SwitchingProvider.this.singletonCImpl.userContextManagerProvider.get());
                            }
                        };
                    case Token.TARGET /* 132 */:
                        return (T) new Gen204JobServiceHelper(this.singletonCImpl.gen204UploadEventLoggerProvider.get(), this.singletonCImpl.gen204DownloadEventLogger(), this.singletonCImpl.gen204MoveCopyEventLoggerProvider.get(), this.singletonCImpl.gen204OfflineEventLoggerProvider.get());
                    case Token.LOOP /* 133 */:
                        return (T) new Gen204UploadEventLogger(this.singletonCImpl.metricsInteractorProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher(), this.singletonCImpl.apdexScoreProvider());
                    case 134:
                        return (T) new RemoteConfig(this.singletonCImpl.providesFirebaseRemoteConfigProvider.get(), this.singletonCImpl.forceUpdateConfigSynchronizerProvider.get());
                    case 135:
                        return (T) DataProvidesModule_ProvidesFirebaseRemoteConfigFactory.providesFirebaseRemoteConfig(this.singletonCImpl.dataProvidesModule);
                    case 136:
                        return (T) new ForceUpdateConfigSynchronizer(this.singletonCImpl.forceUpdateRepositoryProvider.get(), this.singletonCImpl.forceUpdateCoordinatorProvider.get(), this.singletonCImpl.provideMoshiProvider.get());
                    case Token.SCRIPT /* 137 */:
                        return (T) new Gen204OfflineEventLogger(this.singletonCImpl.metricsInteractorProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case 138:
                        return (T) DataProvidesModule_ProvideRumServiceFactory.provideRumService(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.sessionManagerProvider.get(), this.singletonCImpl.bVEManager(), new SplunkRumInstrumentation());
                    case 139:
                        return (T) new MetricsUploadScheduler(this.singletonCImpl.appInBackgroundServiceProvider.get());
                    case 140:
                        return (T) BoxModule_Companion_AppInBackgroundServiceFactory.appInBackgroundService();
                    case Token.SETELEM_OP /* 141 */:
                        return (T) new JobsNotificationService(this.singletonCImpl.jobManagerProvider.get(), this.singletonCImpl.jobServiceProvider.get(), this.singletonCImpl.userContextManagerProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case Token.LOCAL_BLOCK /* 142 */:
                        return (T) new AppStartHandler(this.singletonCImpl.appInBackgroundServiceProvider.get(), this.singletonCImpl.coldStartCalculationProvider.get());
                    case Token.SET_REF_OP /* 143 */:
                        return (T) new ColdStartCalculation();
                    case Token.DOTDOT /* 144 */:
                        return (T) BoxModule_Companion_ProvidesAppStartTargetHolderFactory.providesAppStartTargetHolder(this.singletonCImpl.providesSplashScreenAppStartIntermediatePageProvider.get(), this.singletonCImpl.providesBrowseTabAppStartDestinationPageProvider.get());
                    case Token.COLONCOLON /* 145 */:
                        return (T) BoxModule_Companion_ProvidesSplashScreenAppStartIntermediatePageFactory.providesSplashScreenAppStartIntermediatePage();
                    case Token.XML /* 146 */:
                        return (T) BoxModule_Companion_ProvidesBrowseTabAppStartDestinationPageFactory.providesBrowseTabAppStartDestinationPage(this.singletonCImpl.userContextManagerProvider.get());
                    case Token.DOTQUERY /* 147 */:
                        return (T) new UploadFileCleanupService(this.singletonCImpl.jobsDataSource(), DoubleCheck.lazy((Provider) this.singletonCImpl.localItemServiceProvider), this.singletonCImpl.providesBoxStorageProvider.get(), new LocalSharedPreferences(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case Token.XMLATTR /* 148 */:
                        return (T) BoxModule_Companion_ProvideAppFlavorStringFactory.provideAppFlavorString();
                    case Token.XMLEND /* 149 */:
                        return (T) BoxModule_Companion_ProvideLevelDBKeyValueStoreFactory.provideLevelDBKeyValueStore(this.singletonCImpl.provideApplicationContextProvider.get());
                    case 150:
                        return (T) new LaunchIntoCaptureInteractor(new LocalSharedPreferences(), this.singletonCImpl.appInBackgroundServiceProvider.get());
                    case Token.TO_DOUBLE /* 151 */:
                        return (T) DefaultModule_Companion_ProvideBoxApiShareFactory.provideBoxApiShare(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case Token.GET /* 152 */:
                        return (T) DefaultModule_Companion_ProvideUserContextMigrationFactory.provideUserContextMigration(this.singletonCImpl.provideApplicationContextProvider.get(), this.singletonCImpl.appRestrictionsManager2());
                    case Token.SET /* 153 */:
                        return (T) new BetaFeedbackManager(new AppIntentServices(), this.singletonCImpl.screenshotCaptureProvider.get());
                    case Token.LET /* 154 */:
                        return (T) new ScreenshotCapture();
                    case Token.CONST /* 155 */:
                        return (T) new BetaFeedbackEmailSender(this.singletonCImpl.appInfoService(), this.singletonCImpl.emailChooserHelperProvider.get());
                    case Token.SETCONST /* 156 */:
                        return (T) new EmailChooserHelper(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case Token.SETCONSTVAR /* 157 */:
                        return (T) new ThumbnailManager(this.singletonCImpl.providesBrowseControllerProvider.get(), this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.thumbnailServiceProvider.get());
                    case Token.ARRAYCOMP /* 158 */:
                        return (T) new ThumbnailService(this.singletonCImpl.providesBrowseControllerProvider.get(), this.singletonCImpl.getThumbnailRepresentationsServiceProvider.get(), new FileToBitmapDecoder(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case Token.LETEXPR /* 159 */:
                        return (T) new GetThumbnailRepresentationsService(this.singletonCImpl.representationsService());
                    case 160:
                        return (T) DefaultModule_Companion_ProvideBoxApiUserFactory.provideBoxApiUser(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case Token.DEBUGGER /* 161 */:
                        return (T) new AppUpdateProposalManager(this.singletonCImpl.provideAppUpdateManagerProvider.get(), this.singletonCImpl.namedSharedPreferences2(), this.singletonCImpl.featureFlipsProvider.get(), CommonModule_ProvidesClockFactory.providesClock(), new AppUpdateProposalAnalytics(), this.singletonCImpl.boxAccountSettings());
                    case Token.COMMENT /* 162 */:
                        return (T) AppUpdatesModule_Companion_ProvideAppUpdateManagerFactory.provideAppUpdateManager(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case Token.GENEXPR /* 163 */:
                        return (T) new OfflineMigrationService(this.singletonCImpl.offlineServiceLocalDataSourceProvider.get(), this.singletonCImpl.userContextManagerProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case Token.METHOD /* 164 */:
                        return (T) new OfflineServiceLocalDataSource(this.singletonCImpl.userDataProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case Token.ARROW /* 165 */:
                        return (T) new OfflineStateStorage(this.singletonCImpl.offlineServiceLocalDataSourceProvider.get());
                    case Token.YIELD_STAR /* 166 */:
                        return (T) new ItemActionHandler.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.22
                            @Override // com.box.android.base.presentation.utilities.IItemActionHandler.Factory
                            public ItemActionHandler create(AppCompatActivity activity2) {
                                return new ItemActionHandler(SwitchingProvider.this.singletonCImpl.collectionMembershipsInteractor(), SwitchingProvider.this.singletonCImpl.provideBoxApiFileProvider.get(), SwitchingProvider.this.singletonCImpl.provideBoxExtendedApiFolderProvider.get(), SwitchingProvider.this.singletonCImpl.provideBoxApiWeblinkProvider.get(), SwitchingProvider.this.singletonCImpl.baseModelController(), SwitchingProvider.this.singletonCImpl.userContextManagerProvider.get(), SwitchingProvider.this.singletonCImpl.fTUXController(), SwitchingProvider.this.singletonCImpl.featureFlipsProvider.get(), new CopyOrMoveHelper(), new AppIntentServices(), SwitchingProvider.this.singletonCImpl.offlineService(), SwitchingProvider.this.singletonCImpl.localItemServiceProvider.get(), SwitchingProvider.this.singletonCImpl.provideIMoCoBoxTransfersProvider.get(), SwitchingProvider.this.singletonCImpl.fileActionsManager(), SwitchingProvider.this.singletonCImpl.factoryProvider22.get(), activity2);
                            }
                        };
                    case Token.LAST_TOKEN /* 167 */:
                        return (T) DataProvidesModule_ProvideRecentsRequestFactory.provideRecentsRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 168:
                        return (T) DefaultModule_Companion_ProvideBoxApiLocalRecentItemsFactory.provideBoxApiLocalRecentItems(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 169:
                        return (T) DefaultModule_Companion_ProvideBoxApiRecentItemsFactory.provideBoxApiRecentItems(this.singletonCImpl.userContextManagerProvider.get(), new AppIntentServices(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case external.sdk.pendo.io.mozilla.javascript.Context.VERSION_1_7 /* 170 */:
                        return (T) DefaultModule_Companion_ProvidesIMoCoBoxRecentEventsFactory.providesIMoCoBoxRecentEvents(this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideBoxApiPrivateProvider.get(), this.singletonCImpl.provideBoxApiFileProvider.get(), this.singletonCImpl.provideBoxExtendedApiFolderProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get());
                    case 171:
                        return (T) new ItemClickHandler.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.23
                            @Override // com.box.android.base.presentation.utilities.IItemClickHandler.Factory
                            public ItemClickHandler create(AppCompatActivity activity) {
                                return new ItemClickHandler(SwitchingProvider.this.singletonCImpl.userContextManagerProvider.get(), SwitchingProvider.this.singletonCImpl.previewLauncher(), SwitchingProvider.this.singletonCImpl.baseModelController(), SwitchingProvider.this.singletonCImpl.provideBoxExtendedApiFolderProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(SwitchingProvider.this.singletonCImpl.applicationContextModule), activity);
                            }
                        };
                    case TsExtractor.TS_STREAM_TYPE_AC4 /* 172 */:
                        return (T) new PreviewObservability(this.singletonCImpl.metricsInteractorProvider.get(), this.singletonCImpl.provideRumServiceProvider.get(), this.singletonCImpl.providesApdexServiceProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case 173:
                        return (T) DataProvidesModule_ProvidesApdexServiceFactory.providesApdexService(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.openTelemetryInstrumentationImpl(), this.singletonCImpl.provideRumServiceProvider.get());
                    case 174:
                        return (T) new BridgedPreviewService(this.singletonCImpl.localItemServiceProvider.get(), this.singletonCImpl.idMappingService(), this.singletonCImpl.previewerMappingsService(), this.singletonCImpl.previewObservabilityProvider.get(), this.singletonCImpl.previewLocalDataSource(), this.singletonCImpl.representationsService(), this.singletonCImpl.previewFileWithRepresentationsWrapper(), new FileCanBePreviewedChecker(), this.singletonCImpl.previewDownloadRepresentationWrapper(), this.singletonCImpl.previewDownloadOriginalWrapper(), this.singletonCImpl.previewFromLegacyCacheFetcher(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case 175:
                        return (T) new ThumbnailPreviewInteractor(this.singletonCImpl.thumbnailServiceProvider.get(), this.singletonCImpl.localItemServiceProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case 176:
                        return (T) DataProvidesModule_ProvideHubAssetDownloadRequestFactory.provideHubAssetDownloadRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.bVEManager());
                    case 177:
                        return (T) new BoxAiRemoteDataSource(this.singletonCImpl.provideBoxAiRequestProvider.get(), this.singletonCImpl.sharedLinkTokenRetryHelper(), this.singletonCImpl.provideMoshiProvider.get(), this.singletonCImpl.getAIAgentsGraphQLQuery(), this.singletonCImpl.getAiSessionsGraphQLQuery());
                    case 178:
                        return (T) DataProvidesModule_ProvideBoxAiRequestFactory.provideBoxAiRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.bVEManager());
                    case 179:
                        return (T) new BoxAiObservability(this.singletonCImpl.metricsInteractorProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case 180:
                        return (T) DataProvidesModule_ProvidesBoxCsrfTokenManagerFactory.providesBoxCsrfTokenManager(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.providesCookieManagerProvider.get());
                    case 181:
                        return (T) DataProvidesModule_ProvidesCookieManagerFactory.providesCookieManager(this.singletonCImpl.dataProvidesModule);
                    case 182:
                        return (T) new ItemMoreActionsHandler.Factory() { // from class: com.box.android.application.DaggerBoxApplication_HiltComponents_SingletonC.SingletonCImpl.SwitchingProvider.24
                            @Override // com.box.android.base.presentation.utilities.IItemMoreActionsHandler.Factory
                            public ItemMoreActionsHandler create(AppCompatActivity activity3) {
                                return new ItemMoreActionsHandler(SwitchingProvider.this.singletonCImpl.factoryProvider23.get(), activity3);
                            }
                        };
                    case 183:
                        return (T) DataProvidesModule_ProvideLastUsedTabDataStoreFactory.provideLastUsedTabDataStore(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.provideApplicationContextProvider.get());
                    case 184:
                        return (T) new Media3AudioPlayerManager(this.singletonCImpl.userContextManagerProvider.get(), new Media3DataSourceFactory(), new AudioMediaItemCreator(), new CoverArtExtractor());
                    case 185:
                        return (T) new ForceUpdateActionHandler(this.singletonCImpl.provideAppUpdateManagerProvider.get(), this.singletonCImpl.forceUpdateObservabilityProvider.get(), new ForceUpdateAnalytics());
                    case ContextualToolbar.DRAG_BUTTON_ALPHA /* 186 */:
                        return (T) BoxModule_Companion_ProvideTasksRepoFactory.provideTasksRepo(this.singletonCImpl.baseModelController(), this.singletonCImpl.provideBoxApiPrivateProvider.get(), this.singletonCImpl.userContextManagerProvider.get());
                    case 187:
                        return (T) DataProvidesModule_ProvideTaskRequestFactory.provideTaskRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case TsExtractor.TS_PACKET_SIZE /* 188 */:
                        return (T) new AiCenterSessionInfoProviderImpl();
                    case PsExtractor.PRIVATE_STREAM_1 /* 189 */:
                        return (T) new HubsObservability(this.singletonCImpl.metricsInteractorProvider.get(), this.singletonCImpl.provideRumServiceProvider.get(), this.singletonCImpl.providesApdexServiceProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case 190:
                        return (T) new InboxBadgeRepository(this.singletonCImpl.baseModelController(), this.singletonCImpl.provideBoxApiPrivateProvider.get(), this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.inboxNotificationService());
                    case 191:
                        return (T) DataProvidesModule_ProvideInboxNotificationRequestFactory.provideInboxNotificationRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 192:
                        return (T) new InboxNotificationLocalDataSource(this.singletonCImpl.userDataProvider.get(), this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideMoshiProvider.get());
                    case 193:
                        return (T) DataProvidesModule_ProvideInboxCollaborationRequestFactory.provideInboxCollaborationRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 194:
                        return (T) new RecentNotesService(this.singletonCImpl.recentNotesRemoteDataSource(), this.singletonCImpl.recentNotesLocalDataSourceProvider.get(), this.singletonCImpl.remoteItemService(), this.singletonCImpl.gQLCacheHelper(), this.singletonCImpl.legacyCacheDataSource(), this.singletonCImpl.idMappingService());
                    case 195:
                        return (T) DataProvidesModule_ProvideRecentNotesRequestFactory.provideRecentNotesRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 196:
                        return (T) new RecentNotesLocalDataSource(this.singletonCImpl.userDataProvider.get());
                    case 197:
                        return (T) new SearchService(this.singletonCImpl.hubsService(), this.singletonCImpl.filesSearchRemoteDataSource(), this.singletonCImpl.idMappingService(), this.singletonCImpl.providePreferencesDataStoreProvider.get(), this.singletonCImpl.provideMoshiProvider.get());
                    case 198:
                        return (T) DataProvidesModule_ProvideFilesSearchRequestFactory.provideFilesSearchRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 199:
                        return (T) DataProvidesModule_ProvidePreferencesDataStoreFactory.providePreferencesDataStore(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.provideApplicationContextProvider.get());
                    default:
                        throw new AssertionError(this.id);
                }
            }

            private T get2() {
                switch (this.id) {
                    case 200:
                        return (T) new SystemInfo(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 201:
                        return (T) DataProvidesModule_ProvideWatermarkRequestFactory.provideWatermarkRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 202:
                        return (T) new Gen204WatermarkingEventLogger(this.singletonCImpl.metricsInteractorProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case 203:
                        return (T) new PreviousVersionPreviewObservability(this.singletonCImpl.metricsInteractorProvider.get(), this.singletonCImpl.providesApdexServiceProvider.get(), this.singletonCImpl.provideRumServiceProvider.get(), CommonModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
                    case 204:
                        return (T) DataProvidesModule_ProvideCommentRequestFactory.provideCommentRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 205:
                        return (T) DataProvidesModule_ProvideCommentV2RequestFactory.provideCommentV2Request(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    case 206:
                        return (T) DataProvidesModule_ProvideCommentsControllerFactory.provideCommentsController(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.userContextManagerProvider.get(), this.singletonCImpl.provideApplicationContextProvider.get(), this.singletonCImpl.baseModelController());
                    case 207:
                        return (T) new TextSearchManager(CommonModule_ProvidesDefaultDispatcherFactory.providesDefaultDispatcher(), new SearchOptionsProvider());
                    case 208:
                        return (T) new WopiPropertyBuilder(this.singletonCImpl.provideEventPropertyBuilderProvider.get());
                    case 209:
                        return (T) DomainProvidesModule_ProvideEventPropertyBuilderFactory.provideEventPropertyBuilder();
                    case BoxCommonConstants.REQUEST_OPTIONS /* 210 */:
                        return (T) DataProvidesModule_ProvidesFileCanBePreviewedCheckerFactory.providesFileCanBePreviewedChecker(this.singletonCImpl.dataProvidesModule, new FileCanBePreviewedChecker());
                    case BoxCommonConstants.REQUEST_DELETE /* 211 */:
                        return (T) DataProvidesModule_ProvideFileVersionRequestFactory.provideFileVersionRequest(this.singletonCImpl.dataProvidesModule, this.singletonCImpl.requestFactory(), this.singletonCImpl.appRestrictionsManager2());
                    default:
                        throw new AssertionError(this.id);
                }
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                int i = this.id / 100;
                if (i == 0) {
                    return get0();
                }
                if (i == 1) {
                    return get1();
                }
                if (i == 2) {
                    return get2();
                }
                throw new AssertionError(this.id);
            }
        }
    }
}
