package com.box.android.utilities;

import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.R;
import com.box.android.activities.DeleteItemsActivity;
import com.box.android.activities.InfoDialogActivity;
import com.box.android.activities.MainPhone;
import com.box.android.activities.filepicker.LocalFolderChooser;
import com.box.android.activities.share.CopyLinkService;
import com.box.android.activities.share.UsxShareActivity;
import com.box.android.activities.tasks.RenameTaskActivity;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.analytics.NavigationAnalyticsUtils;
import com.box.android.base.analytics.UploadAnalyticsUtils;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.utilities.FTUXController;
import com.box.android.base.presentation.utilities.IItemActionHandler;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.base.presentation.views.menu.BookmarkSheetFragment;
import com.box.android.base.presentation.views.menu.FileSheetFragment;
import com.box.android.base.presentation.views.menu.FolderSheetFragment;
import com.box.android.base.presentation.watermarking.WatermarkingActivity;
import com.box.android.base.routing.preview.PreviewNavigationTarget;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.collections.presentation.fragments.CollectionsMultiSelectDialogFragment;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.common.utilities.OSPermissionUtils;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.dao.UploadModelBoxFile;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.BoxTransferFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.modelcontroller.messages.BoxDownloadFileMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxFileTransferMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.models.BoxStaticUploadModel;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.coreservices.utilities.Permissions;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.mappers.ItemIdRemoteIdMapper;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.AdminSettingsDomainError;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.WatermarkableItem;
import com.box.android.domain.models.item.WatermarkableItemKt;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IOfflineService;
import com.box.android.domain.usecases.collections.CollectionMembershipsInteractor;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.domain.utils.result.Result;
import com.box.android.jobsui.JobsUIActivity;
import com.box.android.localrepo.LocalSharedPreferences;
import com.box.android.navigation.Navigation;
import com.box.android.navigationmodernization.MainActivity;
import com.box.android.preview.iteminformation.ItemInformationActivity;
import com.box.android.preview.preview.PreviewActivity;
import com.box.android.utilities.notificationmanager.BoxNotificationHelper;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.models.BoxRecentItem;
import com.box.androidsdk.content.models.BoxSearchItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.box.androidsdk.content.requests.BoxRequestsBookmark;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.model.IBoxRecentHolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollections;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.microsoft.intune.mam.client.app.ui.MAMUIHelper;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import com.microsoft.intune.mam.client.content.MAMClipboard;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import com.microsoft.intune.mam.policy.SaveLocation;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ItemActionHandler.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000Ð\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0001\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 ¤\u00012\u00020\u0001:\u0004¤\u0001¥\u0001B\u008b\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0001\u0010 \u001a\u00020!¢\u0006\u0004\b\"\u0010#J\b\u0010G\u001a\u00020.H\u0016J\b\u0010H\u001a\u00020.H\u0016J\u001e\u0010K\u001a\u00020.2\u0014\u0010L\u001a\u0010\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0004\u0018\u0001`/H\u0016JH\u0010M\u001a\u00020.2>\u0010L\u001a:\u0012\u0013\u0012\u001102¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u001106¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020.\u0018\u000101j\u0004\u0018\u0001`8H\u0016J\b\u0010N\u001a\u00020.H\u0002J\"\u0010O\u001a\u00020.2\u0006\u00107\u001a\u0002062\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u0010\u0010T\u001a\u00020.2\u0006\u00107\u001a\u000206H\u0016J\u0010\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020'H\u0016J\u0010\u0010V\u001a\u00020.2\u0006\u0010W\u001a\u00020XH\u0007J\u0018\u0010Y\u001a\u00020.2\u0006\u0010W\u001a\u00020X2\u0006\u0010Z\u001a\u00020[H\u0007J,\u0010O\u001a\u00020.2\u0006\u0010U\u001a\u00020'2\u0006\u0010P\u001a\u00020Q2\b\u0010\\\u001a\u0004\u0018\u00010)2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u0010\u0010]\u001a\u00020.2\u0006\u0010^\u001a\u00020AH\u0002J\u0010\u0010_\u001a\n `*\u0004\u0018\u00010A0AH\u0002J\u001c\u0010a\u001a\u0004\u0018\u00010)2\u0006\u0010b\u001a\u00020Q2\b\u0010c\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010d\u001a\u00020.2\u0006\u0010^\u001a\u00020AH\u0002J \u0010e\u001a\u00020.2\u0006\u00105\u001a\u0002022\u0006\u0010f\u001a\u00020g2\u0006\u0010U\u001a\u00020'H\u0002J\u0010\u0010h\u001a\u00020.2\u0006\u0010U\u001a\u00020'H\u0002J\u0010\u0010i\u001a\u00020.2\u0006\u0010U\u001a\u00020'H\u0002J\u0010\u0010j\u001a\u00020.2\u0006\u0010U\u001a\u00020'H\u0002J\u0018\u0010k\u001a\u00020.2\u0006\u0010f\u001a\u00020g2\u0006\u0010U\u001a\u00020'H\u0002J\u0010\u0010l\u001a\u00020.2\u0006\u0010U\u001a\u00020'H\u0002J\b\u0010m\u001a\u00020nH\u0002J\u0012\u0010o\u001a\u00020.2\b\u0010p\u001a\u0004\u0018\u00010AH\u0002J<\u0010q\u001a\u000e\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020t0r2\u0006\u00107\u001a\u0002062\u0006\u0010u\u001a\u00020)2\u0006\u0010v\u001a\u00020)2\b\b\u0002\u0010w\u001a\u00020xH\u0087@¢\u0006\u0002\u0010yJ\u0010\u0010z\u001a\u00020.2\u0006\u0010{\u001a\u00020'H\u0002J\u0018\u0010|\u001a\u00020.2\u0006\u0010^\u001a\u00020A2\u0006\u0010}\u001a\u000202H\u0002J\u0010\u0010~\u001a\u00020.2\u0006\u0010^\u001a\u00020AH\u0002J\u0013\u0010\u007f\u001a\u00020)2\t\b\u0001\u0010\u0080\u0001\u001a\u000202H\u0002J\u0011\u0010\u0081\u0001\u001a\u00020.2\u0006\u00107\u001a\u000206H\u0002J\u001a\u0010\u0082\u0001\u001a\u00020.2\u0006\u0010U\u001a\u00020'2\u0007\u0010\u0083\u0001\u001a\u00020)H\u0002J\u001a\u0010\u0084\u0001\u001a\u00020.2\u0006\u0010U\u001a\u00020'2\u0007\u0010\u0085\u0001\u001a\u00020)H\u0002J\u0011\u0010\u0086\u0001\u001a\u00020.2\u0006\u0010U\u001a\u00020'H\u0002J\u0011\u0010\u0087\u0001\u001a\u00020.2\u0006\u0010{\u001a\u00020'H\u0002J\n\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002J&\u0010\u008a\u0001\u001a\u00020Q2\u0007\u0010\u008b\u0001\u001a\u0002022\u0007\u0010\u008c\u0001\u001a\u0002022\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010AH\u0016J\u001d\u0010\u008e\u0001\u001a\u00020.2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010'2\u0007\u0010\u008d\u0001\u001a\u00020AH\u0002JA\u0010\u0090\u0001\u001a\u00020.2\u0006\u00107\u001a\u0002062\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u000e\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0098\u0001H\u0016J&\u0010\u0099\u0001\u001a\u00020.2\u0006\u00107\u001a\u0002062\u0007\u0010\u009a\u0001\u001a\u00020)2\n\b\u0002\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0007J\u001a\u0010\u009d\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020'0\u009e\u00012\u0006\u0010{\u001a\u00020'H\u0002JA\u0010\u0090\u0001\u001a\u00020.2\u0006\u0010{\u001a\u00020'2\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u000e\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0098\u0001H\u0016JH\u0010\u009f\u0001\u001a\u00020.2\u0007\u0010{\u001a\u00030 \u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\n\b\u0002\u0010\u0093\u0001\u001a\u00030\u0094\u00012\f\b\u0002\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u0010\b\u0002\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u0002020\u0098\u0001H\u0002J\u0013\u0010¡\u0001\u001a\u00020.2\b\u0010¢\u0001\u001a\u00030£\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010 \u001a\u00020!8\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0018\u00010-j\u0004\u0018\u0001`/X\u0082\u000e¢\u0006\u0002\n\u0000RF\u00100\u001a:\u0012\u0013\u0012\u001102¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0013\u0012\u001106¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020.\u0018\u000101j\u0004\u0018\u0001`8X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b;\u0010<R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020A0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¦\u0001"}, d2 = {"Lcom/box/android/utilities/ItemActionHandler;", "Lcom/box/android/base/presentation/utilities/IItemActionHandler;", "collectionMembershipsInteractor", "Lcom/box/android/domain/usecases/collections/CollectionMembershipsInteractor;", "boxExtendedApiFile", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;", "boxExtendedApiFolder", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "boxExtendedApiBookmark", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiWeblink;", "baseMoco", "Lcom/box/android/coreservices/modelcontroller/IBaseModelController;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "ftuxController", "Lcom/box/android/base/presentation/utilities/FTUXController;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "copyOrMoveHelper", "Lcom/box/android/browse/utilities/CopyOrMoveHelper;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "offlineService", "Lcom/box/android/domain/services/IOfflineService;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "transfersModelController", "Lcom/box/android/coreservices/modelcontroller/IMoCoBoxTransfers;", "fileActionsManager", "Lcom/box/android/coreservices/utilities/FileActionsManager;", "itemClickHandlerFactory", "Lcom/box/android/utilities/ItemClickHandler$Factory;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "(Lcom/box/android/domain/usecases/collections/CollectionMembershipsInteractor;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiWeblink;Lcom/box/android/coreservices/modelcontroller/IBaseModelController;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/base/presentation/utilities/FTUXController;Lcom/box/android/domain/configuration/FeatureFlips;Lcom/box/android/browse/utilities/CopyOrMoveHelper;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/domain/services/IOfflineService;Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/coreservices/modelcontroller/IMoCoBoxTransfers;Lcom/box/android/coreservices/utilities/FileActionsManager;Lcom/box/android/utilities/ItemClickHandler$Factory;Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "itemToExport", "Lcom/box/androidsdk/content/models/BoxItem;", "fileIdForUpdateNewVersion", "", "boxSession", "Lcom/box/android/coreservices/models/CustomBoxSession;", "onItemClosedListener", "Lkotlin/Function0;", "", "Lcom/box/android/base/presentation/utilities/ItemClosedListener;", "bottomSheetActionListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "menuItemId", "Lcom/box/android/domain/models/item/ItemModel;", "itemModel", "Lcom/box/android/base/presentation/utilities/BottomSheetActionListener;", "itemClickHandler", "Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "getItemClickHandler", "()Lcom/box/android/base/presentation/utilities/IItemClickHandler;", "itemClickHandler$delegate", "Lkotlin/Lazy;", "previewActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "browseActivityResultLauncher", "supportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getSupportFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "registerItemActionHandler", "unregisterItemActionHandler", "overflowMenuItemActionReceiver", "Landroid/content/BroadcastReceiver;", "setOnItemClosedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnBottomSheetActionListener", "invokeAndResetOnItemClosedListener", "onItemClick", "shouldLog", "", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "onItemPicked", "boxItem", "handleErrorOnSaveForOffline", "error", "Lcom/box/android/domain/models/AdminSettingsDomainError;", "handleAnalyticsForErrorOnSaveForOffline", "analyticsBuilder", "Lcom/box/android/domain/analytics/BoxAmplitudeAnalytics$EventPropertyBuilder;", "sharedLinkUrl", "setupNavTargetForFilePreview", "intent", "getIntent", "kotlin.jvm.PlatformType", "getSharedLinkInfo", "isRecent", "recentSharedLink", "setSharedLinkInfo", "handleMenuClick", "completionDialogType", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuCompletionDialog;", "handleWatermarkingMenuClick", "handleDownloadMenuClick", "handleCopyLinkMenuClick", "handleCollectionsMenuClick", "handleOfflineItemMenuClick", "getUserSharedPrefs", "Landroid/content/SharedPreferences;", "uploadNewVersion", "selectedFile", "newVersionUploadWithJobService", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/domain/models/DomainError;", BoxCommonConstants.EXTRA_FILE_NAME, "filePath", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/box/android/domain/models/item/ItemModel;Ljava/lang/String;Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exportItem", "item", "startActivityForResult", "code", "startActivity", "getString", "resId", "showCollectionDialog", "showCollectionConfirmationDialog", BoxItemJob.COLLECTION_ID, "logOverflowMenu", "menuItemName", "logDeleteItem", "logShareStarted", "throwIllegalStateException", "", "handleActivityResult", "requestCode", "resultCode", "data", "handleItemDownloadAction", "itemToDownload", "showBottomSheet", "bottomSheetMenuType", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "launchContext", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "onShowListener", "Landroid/content/DialogInterface$OnShowListener;", "availableActions", "", "downloadWithJobSystem", "targetDirectoryPath", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getItemInfoFutureTask", "Lcom/box/android/coreservices/modelcontroller/BoxAppFutureTask;", "doShowBottomSheet", "Lcom/box/androidsdk/content/models/BoxObject;", "handleBoxFilePicked", "boxFile", "Lcom/box/androidsdk/content/models/BoxFile;", "Companion", "Factory", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemActionHandler implements IItemActionHandler {
    private static final int DOWNLOAD = 0;
    private static final int RENAME = 1;
    private static final int SHARE = 2;
    private static final int UPLOAD_NEW_VERSION = 3;
    private final AppCompatActivity activity;
    private final IBaseModelController baseMoco;
    private Function2<? super Integer, ? super ItemModel, Unit> bottomSheetActionListener;
    private final BoxExtendedApiWeblink boxExtendedApiBookmark;
    private final BoxExtendedApiFile boxExtendedApiFile;
    private final BoxExtendedApiFolder boxExtendedApiFolder;
    private final CustomBoxSession boxSession;
    private final ActivityResultLauncher<Intent> browseActivityResultLauncher;
    private final CollectionMembershipsInteractor collectionMembershipsInteractor;
    private final CopyOrMoveHelper copyOrMoveHelper;
    private final FeatureFlips featureFlips;
    private final FileActionsManager fileActionsManager;
    private String fileIdForUpdateNewVersion;
    private final FTUXController ftuxController;
    private final IntentServices intentServices;

    /* JADX INFO: renamed from: itemClickHandler$delegate, reason: from kotlin metadata */
    private final Lazy itemClickHandler;
    private final ItemClickHandler.Factory itemClickHandlerFactory;
    private BoxItem itemToExport;
    private final ILocalItemService localItemService;
    private final IOfflineService offlineService;
    private Function0<Unit> onItemClosedListener;
    private final BroadcastReceiver overflowMenuItemActionReceiver;
    private final ActivityResultLauncher<Intent> previewActivityResultLauncher;
    private final IMoCoBoxTransfers transfersModelController;
    private final IUserContextManager userContextManager;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ItemActionHandler.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/utilities/ItemActionHandler$Factory;", "Lcom/box/android/base/presentation/utilities/IItemActionHandler$Factory;", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/utilities/ItemActionHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Factory extends IItemActionHandler.Factory {
        @Override // com.box.android.base.presentation.utilities.IItemActionHandler.Factory
        ItemActionHandler create(AppCompatActivity activity);
    }

    @AssistedInject
    public ItemActionHandler(CollectionMembershipsInteractor collectionMembershipsInteractor, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiWeblink boxExtendedApiBookmark, IBaseModelController baseMoco, IUserContextManager userContextManager, FTUXController ftuxController, FeatureFlips featureFlips, CopyOrMoveHelper copyOrMoveHelper, IntentServices intentServices, IOfflineService offlineService, ILocalItemService localItemService, IMoCoBoxTransfers transfersModelController, FileActionsManager fileActionsManager, ItemClickHandler.Factory itemClickHandlerFactory, @Assisted AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(collectionMembershipsInteractor, "collectionMembershipsInteractor");
        Intrinsics.checkNotNullParameter(boxExtendedApiFile, "boxExtendedApiFile");
        Intrinsics.checkNotNullParameter(boxExtendedApiFolder, "boxExtendedApiFolder");
        Intrinsics.checkNotNullParameter(boxExtendedApiBookmark, "boxExtendedApiBookmark");
        Intrinsics.checkNotNullParameter(baseMoco, "baseMoco");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(ftuxController, "ftuxController");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        Intrinsics.checkNotNullParameter(copyOrMoveHelper, "copyOrMoveHelper");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(offlineService, "offlineService");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(transfersModelController, "transfersModelController");
        Intrinsics.checkNotNullParameter(fileActionsManager, "fileActionsManager");
        Intrinsics.checkNotNullParameter(itemClickHandlerFactory, "itemClickHandlerFactory");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.collectionMembershipsInteractor = collectionMembershipsInteractor;
        this.boxExtendedApiFile = boxExtendedApiFile;
        this.boxExtendedApiFolder = boxExtendedApiFolder;
        this.boxExtendedApiBookmark = boxExtendedApiBookmark;
        this.baseMoco = baseMoco;
        this.userContextManager = userContextManager;
        this.ftuxController = ftuxController;
        this.featureFlips = featureFlips;
        this.copyOrMoveHelper = copyOrMoveHelper;
        this.intentServices = intentServices;
        this.offlineService = offlineService;
        this.localItemService = localItemService;
        this.transfersModelController = transfersModelController;
        this.fileActionsManager = fileActionsManager;
        this.itemClickHandlerFactory = itemClickHandlerFactory;
        this.activity = activity;
        BoxSession boxSession = userContextManager.getBoxSession(activity);
        Intrinsics.checkNotNull(boxSession, "null cannot be cast to non-null type com.box.android.coreservices.models.CustomBoxSession");
        this.boxSession = (CustomBoxSession) boxSession;
        this.itemClickHandler = LazyKt.lazy(new Function0() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ItemActionHandler.itemClickHandler_delegate$lambda$0(this.f$0);
            }
        });
        this.previewActivityResultLauncher = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ItemActionHandler.previewActivityResultLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        this.browseActivityResultLauncher = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda6
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ItemActionHandler.browseActivityResultLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        this.overflowMenuItemActionReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.utilities.ItemActionHandler$overflowMenuItemActionReceiver$1
            @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
            public void onMAMReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                intent.setExtrasClassLoader(getClass().getClassLoader());
                Serializable serializableExtra = intent.getSerializableExtra(BottomSheetMenuFragment.EXTRA_BOX_MENU_ITEM_DIALOG_TYPE);
                Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.box.android.base.presentation.fragments.models.BottomSheetAttributes.BottomSheetMenuCompletionDialog");
                ItemActionHandler itemActionHandler = this.this$0;
                int intExtra = intent.getIntExtra(BottomSheetMenuFragment.EXTRA_BOX_MENU_ITEM_ID, 0);
                Serializable serializableExtra2 = intent.getSerializableExtra(BottomSheetMenuFragment.EXTRA_BOX_ITEM);
                Intrinsics.checkNotNull(serializableExtra2, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxItem");
                itemActionHandler.handleMenuClick(intExtra, (BottomSheetAttributes.BottomSheetMenuCompletionDialog) serializableExtra, (BoxItem) serializableExtra2);
            }
        };
    }

    public final AppCompatActivity getActivity() {
        return this.activity;
    }

    private final IItemClickHandler getItemClickHandler() {
        return (IItemClickHandler) this.itemClickHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ItemClickHandler itemClickHandler_delegate$lambda$0(ItemActionHandler itemActionHandler) {
        return itemActionHandler.itemClickHandlerFactory.create(itemActionHandler.activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewActivityResultLauncher$lambda$0(ItemActionHandler itemActionHandler, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        itemActionHandler.invokeAndResetOnItemClosedListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void browseActivityResultLauncher$lambda$0(ItemActionHandler itemActionHandler, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        itemActionHandler.invokeAndResetOnItemClosedListener();
    }

    private final FragmentManager getSupportFragmentManager() {
        FragmentManager supportFragmentManager = this.activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        return supportFragmentManager;
    }

    @Override // com.box.android.base.presentation.utilities.IItemActionHandler
    public void registerItemActionHandler() {
        LocalBroadcastManager.getInstance(this.activity).registerReceiver(this.overflowMenuItemActionReceiver, new IntentFilter(BottomSheetMenuFragment.EXTRA_ACTION_BOX_ITEM_OVERFLOW_MENU_ITEM_SET));
    }

    @Override // com.box.android.base.presentation.utilities.IItemActionHandler
    public void unregisterItemActionHandler() {
        LocalBroadcastManager.getInstance(this.activity).unregisterReceiver(this.overflowMenuItemActionReceiver);
    }

    @Override // com.box.android.base.presentation.utilities.IItemActionHandler
    public void setOnItemClosedListener(Function0<Unit> listener) {
        this.onItemClosedListener = listener;
    }

    @Override // com.box.android.base.presentation.utilities.IItemActionHandler
    public void setOnBottomSheetActionListener(Function2<? super Integer, ? super ItemModel, Unit> listener) {
        this.bottomSheetActionListener = listener;
    }

    private final void invokeAndResetOnItemClosedListener() {
        Function0<Unit> function0 = this.onItemClosedListener;
        if (function0 != null) {
            function0.invoke();
        }
        this.onItemClosedListener = null;
    }

    @Override // com.box.android.base.presentation.utilities.IItemActionHandler
    public void onItemClick(ItemModel itemModel, boolean shouldLog, PreviewSource previewSource) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        onItemClick(ItemModelMapper.INSTANCE.toBoxItem(itemModel, true), shouldLog, null, previewSource);
    }

    @Override // com.box.android.base.presentation.utilities.IItemActionHandler
    public void onItemPicked(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        onItemPicked(ItemModelMapper.INSTANCE.toBoxItem(itemModel, true));
    }

    @Override // com.box.android.base.presentation.utilities.IItemActionHandler
    public void onItemPicked(BoxItem boxItem) {
        Intrinsics.checkNotNullParameter(boxItem, "boxItem");
        if (boxItem instanceof BoxFile) {
            handleBoxFilePicked((BoxFile) boxItem);
        } else if (boxItem instanceof BoxFolder) {
            IItemActionHandler.onItemClick$default(this, boxItem, false, null, null, 14, null);
        } else {
            BoxPresentationUtils.displayToast(R.string.this_file_type_or_application_is_currently_not_supported, this.activity, new String[0]);
        }
    }

    public final void handleErrorOnSaveForOffline(AdminSettingsDomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (error instanceof AdminSettingsDomainError.EncryptedDeviceRequired) {
            BoxNotificationHelper.displayDialog(R.string.Feature_disabled, R.string.Encrypted_device_requird_for_this_feature);
        } else {
            BoxNotificationHelper.displayDialog(R.string.Feature_disabled, R.string.This_feature_has_been_disabled_by_your_or_your_administrator);
        }
    }

    public final void handleAnalyticsForErrorOnSaveForOffline(AdminSettingsDomainError error, BoxAmplitudeAnalytics.EventPropertyBuilder analyticsBuilder) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(analyticsBuilder, "analyticsBuilder");
        if (error instanceof AdminSettingsDomainError.EncryptedDeviceRequired) {
            analyticsBuilder.setError("other", CommonBoxUtil.getUSLocaleString(R.string.Encrypted_device_requird_for_this_feature), (String) null);
            analyticsBuilder.logEvent(BoxAnalyticsParams.EVENT_ITEM_OFFLINE_CTA_TRIGGERED);
        } else {
            analyticsBuilder.setError("other", CommonBoxUtil.getUSLocaleString(R.string.This_feature_has_been_disabled_by_your_or_your_administrator), (String) null);
            analyticsBuilder.logEvent(BoxAnalyticsParams.EVENT_ITEM_OFFLINE_CTA_TRIGGERED);
        }
    }

    @Override // com.box.android.base.presentation.utilities.IItemActionHandler
    public void onItemClick(BoxItem boxItem, boolean shouldLog, String sharedLinkUrl, PreviewSource previewSource) {
        BoxRecentItem recentItem;
        BoxItem boxItem2 = boxItem;
        Intrinsics.checkNotNullParameter(boxItem2, "boxItem");
        if (boxItem2 instanceof BoxSearchItem) {
            BoxSearchItem boxSearchItem = (BoxSearchItem) boxItem2;
            String accessibleSharedLink = boxSearchItem.getAccessibleSharedLink();
            if (accessibleSharedLink != null) {
                this.boxSession.setSharedLink(accessibleSharedLink);
            }
            boxItem2 = boxSearchItem.getItem();
        }
        if (boxItem2 instanceof BoxFolder) {
            AppCompatActivity appCompatActivity = this.activity;
            if (appCompatActivity instanceof MainPhone) {
                getItemClickHandler().onFolderClick((BoxFolder) boxItem2, new IItemClickHandler.FolderClickConfig(new Function1() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ItemActionHandler.onItemClick$lambda$0(this.f$0, (BoxFolder) obj);
                    }
                }, 0, null, shouldLog, 6, null));
                return;
            } else {
                if ((appCompatActivity instanceof Navigation) || (appCompatActivity instanceof JobsUIActivity) || (appCompatActivity instanceof MainActivity)) {
                    getItemClickHandler().onFolderClick((BoxFolder) boxItem2, new IItemClickHandler.FolderClickConfig(null, 0, null, shouldLog, 7, null));
                    return;
                }
                return;
            }
        }
        if (boxItem2 instanceof BoxFile) {
            boolean z = boxItem2 instanceof IBoxRecentHolder;
            final String interactionSharedLink = null;
            IBoxRecentHolder iBoxRecentHolder = z ? (IBoxRecentHolder) boxItem2 : null;
            if (iBoxRecentHolder != null && (recentItem = iBoxRecentHolder.getRecentItem()) != null) {
                interactionSharedLink = recentItem.getInteractionSharedLink();
            }
            final boolean z2 = z && !SdkUtils.isBlank(interactionSharedLink);
            PreviewSource previewSource2 = previewSource == null ? PreviewSource.Unknown.INSTANCE : previewSource;
            String sharedLinkInfo = getSharedLinkInfo(z2, interactionSharedLink);
            getItemClickHandler().onFileClick((BoxFile) boxItem2, new IItemClickHandler.FileClickConfig(previewSource2, sharedLinkInfo == null ? sharedLinkUrl : sharedLinkInfo, this.previewActivityResultLauncher, new Function0() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ItemActionHandler.onItemClick$lambda$1(this.f$0);
                }
            }, new Function1() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ItemActionHandler.onItemClick$lambda$2(this.f$0, z2, interactionSharedLink, (Intent) obj);
                }
            }, Boolean.valueOf(z2), null, false, shouldLog, 192, null));
            return;
        }
        if (boxItem2 instanceof BoxBookmark) {
            getItemClickHandler().onBookmarkClick((BoxBookmark) boxItem2, new IItemClickHandler.BookmarkClickConfig(this.browseActivityResultLauncher, shouldLog));
        } else {
            throwIllegalStateException();
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onItemClick$lambda$0(ItemActionHandler itemActionHandler, BoxFolder folder) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        ((MainPhone) itemActionHandler.activity).navigateToFolder(folder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onItemClick$lambda$1(ItemActionHandler itemActionHandler) {
        itemActionHandler.invokeAndResetOnItemClosedListener();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onItemClick$lambda$2(ItemActionHandler itemActionHandler, boolean z, String str, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        itemActionHandler.setupNavTargetForFilePreview(intent);
        itemActionHandler.setSharedLinkInfo(intent);
        if (z) {
            intent.putExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_URL, str);
        }
        return Unit.INSTANCE;
    }

    private final void setupNavTargetForFilePreview(Intent intent) {
        PreviewNavigationTarget previewNavigationTarget;
        if (getIntent() != null) {
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "getIntent(...)");
            if (Build.VERSION.SDK_INT >= 33) {
                previewNavigationTarget = (Parcelable) intent2.getParcelableExtra(PreviewActivity.NAVIGATION_TARGET, PreviewNavigationTarget.class);
            } else {
                Parcelable parcelableExtra = intent2.getParcelableExtra(PreviewActivity.NAVIGATION_TARGET);
                if (!(parcelableExtra instanceof PreviewNavigationTarget)) {
                    parcelableExtra = null;
                }
                previewNavigationTarget = (PreviewNavigationTarget) parcelableExtra;
            }
            PreviewNavigationTarget previewNavigationTarget2 = previewNavigationTarget instanceof PreviewNavigationTarget ? (PreviewNavigationTarget) previewNavigationTarget : null;
            if (previewNavigationTarget2 != null) {
                intent.putExtra(PreviewActivity.NAVIGATION_TARGET, previewNavigationTarget2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent getIntent() {
        return this.activity.getIntent();
    }

    private final String getSharedLinkInfo(boolean isRecent, String recentSharedLink) {
        String stringExtra;
        if (isRecent) {
            return recentSharedLink;
        }
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_URL)) == null || StringsKt.isBlank(stringExtra)) {
            return null;
        }
        return stringExtra;
    }

    private final void setSharedLinkInfo(Intent intent) {
        if (getIntent() == null || SdkUtils.isBlank(getIntent().getStringExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_URL))) {
            return;
        }
        intent.putExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_URL, getIntent().getStringExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_URL));
        if (SdkUtils.isBlank(getIntent().getStringExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_PASSWORD))) {
            return;
        }
        intent.putExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_PASSWORD, getIntent().getStringExtra(BoxFragmentActivity.EXTRA_SHAREDLINK_PASSWORD));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMenuClick(int menuItemId, BottomSheetAttributes.BottomSheetMenuCompletionDialog completionDialogType, BoxItem boxItem) {
        Function2<? super Integer, ? super ItemModel, Unit> function2;
        String name;
        switch (menuItemId) {
            case R.id.menu_box_ai /* 2131362648 */:
                logOverflowMenu(boxItem, "menu_box_ai");
                break;
            case R.id.menu_collections /* 2131362649 */:
                handleCollectionsMenuClick(completionDialogType, boxItem);
                break;
            case R.id.menu_copy_link /* 2131362650 */:
                handleCopyLinkMenuClick(boxItem);
                break;
            case R.id.menu_copy_or_move /* 2131362651 */:
                logOverflowMenu(boxItem, "menu_copy_or_move");
                CopyOrMoveHelper copyOrMoveHelper = this.copyOrMoveHelper;
                AppCompatActivity appCompatActivity = this.activity;
                List listListOf = CollectionsKt.listOf(boxItem);
                ArrayList arrayList = new ArrayList();
                Iterator it = listListOf.iterator();
                while (it.hasNext()) {
                    ItemModel itemModel = ItemModelMapper.INSTANCE.toItemModel((BoxItem) it.next());
                    if (itemModel != null) {
                        arrayList.add(itemModel);
                    }
                }
                copyOrMoveHelper.startCopyOrMoveFlow(appCompatActivity, arrayList);
                break;
            case R.id.menu_delete /* 2131362652 */:
                logOverflowMenu(boxItem, "menu_delete");
                logDeleteItem(boxItem);
                Intent intentNewDeleteTaskIntent = DeleteItemsActivity.newDeleteTaskIntent(this.activity, boxItem);
                Intrinsics.checkNotNullExpressionValue(intentNewDeleteTaskIntent, "newDeleteTaskIntent(...)");
                startActivity(intentNewDeleteTaskIntent);
                break;
            case R.id.menu_download /* 2131362653 */:
                handleDownloadMenuClick(boxItem);
                break;
            case R.id.menu_file_info /* 2131362654 */:
            case R.id.menu_folder_info /* 2131362655 */:
                logOverflowMenu(boxItem, "menu_item_info");
                ItemInformationActivity.Companion companion = ItemInformationActivity.INSTANCE;
                AppCompatActivity appCompatActivity2 = this.activity;
                ItemModel itemModel2 = ItemModelMapper.INSTANCE.toItemModel(boxItem);
                Intrinsics.checkNotNull(itemModel2);
                startActivity(companion.getIntent(appCompatActivity2, itemModel2));
                break;
            case R.id.menu_leave_file /* 2131362656 */:
            case R.id.menu_leave_folder /* 2131362657 */:
                logOverflowMenu(boxItem, "menu_leave");
                Intent intentNewDeleteTaskIntent2 = DeleteItemsActivity.newDeleteTaskIntent(this.activity, boxItem);
                Intrinsics.checkNotNullExpressionValue(intentNewDeleteTaskIntent2, "newDeleteTaskIntent(...)");
                startActivity(intentNewDeleteTaskIntent2);
                break;
            case R.id.menu_remove_offline /* 2131362662 */:
                logOverflowMenu(boxItem, "menu_remove_offline");
                ItemModel itemModel3 = ItemModelMapper.INSTANCE.toItemModel(boxItem);
                if (itemModel3 != null) {
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.activity), null, null, new ItemActionHandler$handleMenuClick$2$1(this, itemModel3, null), 3, null);
                }
                break;
            case R.id.menu_rename /* 2131362663 */:
                logOverflowMenu(boxItem, "menu_rename");
                Intent launchIntent = RenameTaskActivity.getLaunchIntent(this.activity.getBaseContext(), boxItem);
                Intrinsics.checkNotNullExpressionValue(launchIntent, "getLaunchIntent(...)");
                startActivityForResult(launchIntent, 1);
                break;
            case R.id.menu_save_for_offline /* 2131362664 */:
                handleOfflineItemMenuClick(boxItem);
                break;
            case R.id.menu_share /* 2131362665 */:
                logOverflowMenu(boxItem, "menu_share");
                logShareStarted(boxItem);
                Intent launchIntent2 = UsxShareActivity.getLaunchIntent(this.activity, boxItem, this.boxSession);
                Intrinsics.checkNotNullExpressionValue(launchIntent2, "getLaunchIntent(...)");
                startActivityForResult(launchIntent2, 2);
                break;
            case R.id.menu_upload_new_version /* 2131362666 */:
                logOverflowMenu(boxItem, "menu_upload_new_version");
                this.fileIdForUpdateNewVersion = boxItem.getUserId();
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
                intent.setType("*/*");
                this.fileIdForUpdateNewVersion = boxItem.getUserId();
                startActivityForResult(intent, 3);
                break;
            case R.id.menu_view_containing_folder /* 2131362667 */:
                ItemModelMapper itemModelMapper = ItemModelMapper.INSTANCE;
                BoxFolder parent = boxItem.getParent();
                Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
                ItemModel itemModel4 = itemModelMapper.toItemModel(parent);
                if (itemModel4 != null) {
                    IntentServices intentServices = this.intentServices;
                    AppCompatActivity appCompatActivity3 = this.activity;
                    ItemId itemId = itemModel4.getItemId();
                    FolderModel parentFolder = itemModel4.getParentFolder();
                    if (parentFolder == null || (name = parentFolder.getName()) == null) {
                        name = "";
                    }
                    startActivity(IntentServices.mainPhoneActivityIntent$default(intentServices, appCompatActivity3, itemId, name, 0, 8, null));
                }
                break;
            case R.id.menu_watermarking /* 2131362668 */:
                logOverflowMenu(boxItem, "menu_watermarking");
                handleWatermarkingMenuClick(boxItem);
                break;
        }
        ItemModel itemModel5 = ItemModelMapper.INSTANCE.toItemModel(boxItem);
        if (itemModel5 == null || (function2 = this.bottomSheetActionListener) == null) {
            return;
        }
        function2.invoke(Integer.valueOf(menuItemId), itemModel5);
    }

    private final void handleWatermarkingMenuClick(BoxItem boxItem) {
        WatermarkableItem watermarkableItem;
        ItemModel itemModel = ItemModelMapper.INSTANCE.toItemModel(boxItem);
        if (itemModel == null || (watermarkableItem = WatermarkableItemKt.toWatermarkableItem(itemModel)) == null) {
            return;
        }
        startActivity(WatermarkingActivity.INSTANCE.getLaunchIntent(this.activity, watermarkableItem));
    }

    private final void handleDownloadMenuClick(BoxItem boxItem) {
        logOverflowMenu(boxItem, "menu_download");
        if (!CoreServiceUtils.getIsSaveToLocationAllowed(SaveLocation.LOCAL, null)) {
            MAMUIHelper.showSharingBlockedDialog(this.activity);
            return;
        }
        if (!BoxAccountManager.isMobileOpenInEnabled(this.userContextManager)) {
            BoxNotificationHelper.displayDialog(R.string.Feature_disabled, R.string.This_feature_has_been_disabled_by_your_or_your_administrator);
            return;
        }
        if (!OSPermissionUtils.hasStoragePermission$default(OSPermissionUtils.INSTANCE, false, 1, null)) {
            OSPermissionUtils.INSTANCE.requestStoragePermission(this.activity, 0);
            return;
        }
        Result<Unit, AdminSettingsDomainError> resultCheckOfflineActionAdminSettings = this.fileActionsManager.checkOfflineActionAdminSettings();
        if (resultCheckOfflineActionAdminSettings instanceof Result.Success) {
            exportItem(boxItem);
        } else {
            if (resultCheckOfflineActionAdminSettings instanceof Result.Error) {
                handleErrorOnSaveForOffline((AdminSettingsDomainError) ((Result.Error) resultCheckOfflineActionAdminSettings).getValue());
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void handleCopyLinkMenuClick(BoxItem boxItem) {
        logOverflowMenu(boxItem, "menu_copy_link");
        EnumSet<BoxItem.Permission> permissions = boxItem.getPermissions();
        if (permissions != null && permissions.contains(BoxItem.Permission.CAN_SHARE)) {
            BoxSharedLink sharedLink = boxItem.getSharedLink();
            if (sharedLink != null) {
                Object systemService = this.activity.getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                MAMClipboard.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("", sharedLink.getURL()));
                BoxPresentationUtils.displayToast(R.string.box_sharesdk_link_copied_to_clipboard, this.activity, new String[0]);
                return;
            }
            CopyLinkService.startCopyLinkService(this.activity.getApplicationContext(), boxItem);
            return;
        }
        Intent intentNewInfoDialog = InfoDialogActivity.newInfoDialog(this.activity, null, getString(R.string.no_permission_to_share_item), getString(R.string.boxsdk_button_ok));
        Intrinsics.checkNotNullExpressionValue(intentNewInfoDialog, "newInfoDialog(...)");
        startActivity(intentNewInfoDialog);
    }

    private final void handleCollectionsMenuClick(BottomSheetAttributes.BottomSheetMenuCompletionDialog completionDialogType, BoxItem boxItem) {
        if (completionDialogType instanceof BottomSheetAttributes.BottomSheetMenuCompletionDialog.ConfirmationDialog) {
            logOverflowMenu(boxItem, "menu_remove_from_collections");
            showCollectionConfirmationDialog(boxItem, ((BottomSheetAttributes.BottomSheetMenuCompletionDialog.ConfirmationDialog) completionDialogType).getCollectionId());
            return;
        }
        logOverflowMenu(boxItem, "menu_collections");
        ItemModel itemModel = ItemModelMapper.INSTANCE.toItemModel(boxItem);
        if (itemModel != null) {
            showCollectionDialog(itemModel);
        }
    }

    private final void handleOfflineItemMenuClick(BoxItem boxItem) {
        logOverflowMenu(boxItem, "menu_save_for_offline");
        final BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = BoxAmplitudeAnalytics.createEventBuilder();
        eventPropertyBuilderCreateEventBuilder.setTimeOnPage().setPageExperience(BoxAnalyticsParams.PAGE_EXPERIENCE_OVERLAY).setBoxItem(boxItem).setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setContentOwnershipType(NavigationAnalyticsUtils.calculateContentOwnership(boxItem, this.baseMoco, this.boxExtendedApiFolder, this.userContextManager)).setCtaPageLocation(BoxAnalyticsParams.CTA_LOCATION_NATIVE_OVERLAY);
        Result<Unit, AdminSettingsDomainError> resultCheckOfflineActionAdminSettings = this.fileActionsManager.checkOfflineActionAdminSettings();
        if (resultCheckOfflineActionAdminSettings instanceof Result.Success) {
            this.ftuxController.evaluateTrigger(FTUXController.FTUXTrigger.OFFLINING_ITEM);
            final ItemModel itemModel = ItemModelMapper.INSTANCE.toItemModel(boxItem);
            if (itemModel == null) {
                return;
            }
            final Function1 function1 = new Function1() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ItemActionHandler.handleOfflineItemMenuClick$lambda$1(this.f$0, eventPropertyBuilderCreateEventBuilder, itemModel, ((Boolean) obj).booleanValue());
                }
            };
            if (this.offlineService.isSizeBigEnoughToSaveOnlyPreviews(itemModel)) {
                this.activity.runOnUiThread(new Runnable() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        ItemActionHandler.handleOfflineItemMenuClick$lambda$2(this.f$0, function1);
                    }
                });
                return;
            } else {
                function1.invoke(true);
                return;
            }
        }
        if (!(resultCheckOfflineActionAdminSettings instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        AdminSettingsDomainError adminSettingsDomainError = (AdminSettingsDomainError) ((Result.Error) resultCheckOfflineActionAdminSettings).getValue();
        handleErrorOnSaveForOffline(adminSettingsDomainError);
        Intrinsics.checkNotNull(eventPropertyBuilderCreateEventBuilder);
        handleAnalyticsForErrorOnSaveForOffline(adminSettingsDomainError, eventPropertyBuilderCreateEventBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleOfflineItemMenuClick$lambda$1(ItemActionHandler itemActionHandler, BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilder, ItemModel itemModel, boolean z) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(itemActionHandler.activity), null, null, new ItemActionHandler$handleOfflineItemMenuClick$saveToOffline$1$1(itemActionHandler, itemModel, z, null), 3, null);
        eventPropertyBuilder.logEvent(BoxAnalyticsParams.EVENT_ITEM_OFFLINE_CTA_TRIGGERED);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleOfflineItemMenuClick$lambda$2(ItemActionHandler itemActionHandler, final Function1 function1) {
        new MaterialAlertDialogBuilder(itemActionHandler.activity).setTitle((CharSequence) CommonBoxUtil.LS(R.string.save_for_offline_access_dialog_title)).setMessage((CharSequence) CommonBoxUtil.LS(R.string.save_for_offline_access_dialog_text)).setNegativeButton(R.string.use_preview_button, new DialogInterface.OnClickListener() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ItemActionHandler.handleOfflineItemMenuClick$lambda$2$0(function1, dialogInterface, i);
            }
        }).setPositiveButton(R.string.download_original_button, new DialogInterface.OnClickListener() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ItemActionHandler.handleOfflineItemMenuClick$lambda$2$1(function1, dialogInterface, i);
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleOfflineItemMenuClick$lambda$2$0(Function1 function1, DialogInterface dialogInterface, int i) {
        function1.invoke(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleOfflineItemMenuClick$lambda$2$1(Function1 function1, DialogInterface dialogInterface, int i) {
        function1.invoke(true);
    }

    private final SharedPreferences getUserSharedPrefs() {
        IUserContextComponent userContextComponent = this.userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_SHARED_PREFERENCES);
        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.localrepo.LocalSharedPreferences");
        SharedPreferences sharedPreferences = ((LocalSharedPreferences) userContextComponent).getSharedPreferences();
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "<get-sharedPreferences>(...)");
        return sharedPreferences;
    }

    private final void uploadNewVersion(Intent selectedFile) {
        if ((selectedFile != null ? selectedFile.getData() : null) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.activity), Dispatchers.getIO(), null, new C17261(selectedFile, null), 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.utilities.ItemActionHandler$uploadNewVersion$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemActionHandler.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.utilities.ItemActionHandler$uploadNewVersion$1", f = "ItemActionHandler.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {666}, m = "invokeSuspend", n = {"originalFile", "fileUri", "newVersionFile", "cursor", "filename", "itemModel", "$i$a$-use-ItemActionHandler$uploadNewVersion$1$1", "$i$a$-let-ItemActionHandler$uploadNewVersion$1$1$1"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class C17261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Intent $selectedFile;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17261(Intent intent, Continuation<? super C17261> continuation) {
            super(2, continuation);
            this.$selectedFile = intent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ItemActionHandler.this.new C17261(this.$selectedFile, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17261) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            C17261 c17261;
            BoxFile boxFile;
            Throwable th;
            Closeable closeable;
            String string;
            BoxFile boxFile2;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        String str2 = ItemActionHandler.this.fileIdForUpdateNewVersion;
                        if (str2 != null && str2.length() != 0) {
                            IBaseModelController iBaseModelController = ItemActionHandler.this.baseMoco;
                            BoxRequestsFile.GetFileInfo infoRequest = ItemActionHandler.this.boxExtendedApiFile.getInfoRequest(ItemActionHandler.this.fileIdForUpdateNewVersion);
                            Intrinsics.checkNotNullExpressionValue(infoRequest, "getInfoRequest(...)");
                            BoxObject result = iBaseModelController.performLocal(infoRequest).get().getResult();
                            Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                            boxFile = (BoxFile) result;
                            Uri data = this.$selectedFile.getData();
                            Intrinsics.checkNotNull(data);
                            UploadModelBoxFile.UriFile file = BoxStaticUploadModel.parseUri(this.$selectedFile.getData()).getFile(ItemActionHandler.this.userContextManager);
                            Intrinsics.checkNotNullExpressionValue(file, "getFile(...)");
                            UploadModelBoxFile.UriFile uriFile = file;
                            Cursor cursorQuery = MAMContentResolverManagement.query(ItemActionHandler.this.getActivity().getContentResolver(), data, null, null, null, null);
                            if (cursorQuery != null) {
                                Cursor cursor = cursorQuery;
                                ItemActionHandler itemActionHandler = ItemActionHandler.this;
                                try {
                                    Cursor cursor2 = cursor;
                                    if (cursor2.moveToFirst()) {
                                        string = cursor2.getString(cursor2.getColumnIndexOrThrow("_display_name"));
                                        ItemModel itemModel = ItemModelMapper.INSTANCE.toItemModel(boxFile);
                                        if (itemModel != null) {
                                            Intrinsics.checkNotNull(string);
                                            String absolutePath = uriFile.getAbsolutePath();
                                            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                                            this.L$0 = boxFile;
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(data);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable(uriFile);
                                            this.L$3 = cursor;
                                            this.L$4 = SpillingKt.nullOutSpilledVariable(cursor2);
                                            this.L$5 = string;
                                            this.L$6 = SpillingKt.nullOutSpilledVariable(itemModel);
                                            this.I$0 = 0;
                                            this.I$1 = 0;
                                            this.label = 1;
                                            c17261 = this;
                                            try {
                                                Object objNewVersionUploadWithJobService$default = ItemActionHandler.newVersionUploadWithJobService$default(itemActionHandler, itemModel, string, absolutePath, null, c17261, 8, null);
                                                if (objNewVersionUploadWithJobService$default == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                boxFile2 = boxFile;
                                                closeable = cursor;
                                                str = string;
                                                obj = objNewVersionUploadWithJobService$default;
                                                string = str;
                                                boxFile = boxFile2;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                th = th;
                                                closeable = cursor;
                                                throw th;
                                            }
                                        } else {
                                            c17261 = this;
                                            closeable = cursor;
                                        }
                                    } else {
                                        c17261 = this;
                                        closeable = cursor;
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(closeable, null);
                                } catch (Throwable th3) {
                                    th = th3;
                                    c17261 = this;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    } catch (Exception e) {
                        e = e;
                        c17261 = this;
                        BoxLogUtils.logException(e);
                        BoxPresentationUtils.displayToast(R.string.unable_to_upload_try_again_later, ItemActionHandler.this.getActivity(), new String[0]);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) this.L$5;
                    closeable = (Closeable) this.L$3;
                    boxFile2 = (BoxFile) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        c17261 = this;
                        try {
                            string = str;
                            boxFile = boxFile2;
                        } catch (Throwable th4) {
                            th = th4;
                            try {
                                throw th;
                            } catch (Throwable th5) {
                                CloseableKt.closeFinally(closeable, th);
                                throw th5;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        c17261 = this;
                        throw th;
                    }
                }
                Long size = boxFile.getSize();
                UploadAnalyticsUtils.logNewFileUploadCtaEvent(string, size != null ? size.longValue() : 0L);
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(closeable, null);
            } catch (Exception e2) {
                e = e2;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.utilities.ItemActionHandler$newVersionUploadWithJobService$2, reason: invalid class name */
    /* JADX INFO: compiled from: ItemActionHandler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.utilities.ItemActionHandler$newVersionUploadWithJobService$2", f = "ItemActionHandler.kt", i = {0, 0, 0, 0}, l = {700}, m = "invokeSuspend", n = {"sourceFileItemId", "parentFolderId", "contentUri", "tags"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends FileModel, ? extends DomainError>>, Object> {
        final /* synthetic */ String $fileName;
        final /* synthetic */ String $filePath;
        final /* synthetic */ ItemModel $itemModel;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ ItemActionHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ItemModel itemModel, String str, ItemActionHandler itemActionHandler, String str2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$itemModel = itemModel;
            this.$filePath = str;
            this.this$0 = itemActionHandler;
            this.$fileName = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$itemModel, this.$filePath, this.this$0, this.$fileName, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends FileModel, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<FileModel, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<FileModel, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws UnsupportedEncodingException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            ItemId itemId = this.$itemModel.getItemId();
            ItemId itemIdParentWithRoot = ItemModelKt.parentWithRoot(this.$itemModel);
            String strEncode = URLEncoder.encode(this.$filePath, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(strEncode, "encode(...)");
            Uri uri = Uri.parse(strEncode);
            Set of = SetsKt.setOf("job_source:" + JobTags.JobSource.NEW_VERSION_UPLOAD);
            this.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            this.L$1 = SpillingKt.nullOutSpilledVariable(itemIdParentWithRoot);
            this.L$2 = SpillingKt.nullOutSpilledVariable(uri);
            this.L$3 = SpillingKt.nullOutSpilledVariable(of);
            this.label = 1;
            Object objUploadFile$default = ILocalItemService.uploadFile$default(this.this$0.localItemService, this.$fileName, itemIdParentWithRoot, uri, of, false, itemId, this, 16, null);
            return objUploadFile$default == coroutine_suspended ? coroutine_suspended : objUploadFile$default;
        }
    }

    public static /* synthetic */ Object newVersionUploadWithJobService$default(ItemActionHandler itemActionHandler, ItemModel itemModel, String str, String str2, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            coroutineDispatcher = Dispatchers.getIO();
        }
        return itemActionHandler.newVersionUploadWithJobService(itemModel, str, str2, coroutineDispatcher, continuation);
    }

    public final Object newVersionUploadWithJobService(ItemModel itemModel, String str, String str2, CoroutineDispatcher coroutineDispatcher, Continuation<? super Result<FileModel, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(coroutineDispatcher, new AnonymousClass2(itemModel, str2, this, str, null), continuation);
    }

    private final void exportItem(BoxItem item) {
        this.itemToExport = item;
        startActivityForResult(LocalFolderChooser.INSTANCE.newLocalFolderChooserIntent(this.activity, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath(), getString(R.string.pick_destination)), 0);
    }

    private final void startActivityForResult(Intent intent, int code) {
        this.activity.startActivityForResult(intent, code);
    }

    private final void startActivity(Intent intent) {
        this.activity.startActivity(intent);
    }

    private final String getString(int resId) {
        String string = this.activity.getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final void showCollectionDialog(ItemModel itemModel) {
        CollectionsMultiSelectDialogFragment.INSTANCE.newInstance(itemModel).show(this.activity.getSupportFragmentManager(), CollectionsMultiSelectDialogFragment.TAG);
    }

    private final void showCollectionConfirmationDialog(final BoxItem boxItem, final String collectionId) {
        new AlertDialog.Builder(this.activity, 2132083682).setCancelable(false).setMessage(R.string.remove_from_collection_confirm).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ItemActionHandler.showCollectionConfirmationDialog$lambda$0(boxItem, collectionId, this, dialogInterface, i);
            }
        }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCollectionConfirmationDialog$lambda$0(BoxItem boxItem, String str, ItemActionHandler itemActionHandler, DialogInterface dialogInterface, int i) {
        ItemId.Remote itemIdRemoteId = ItemIdRemoteIdMapper.INSTANCE.toItemIdRemoteId(boxItem);
        if (itemIdRemoteId != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ItemActionHandler$showCollectionConfirmationDialog$1$1(itemActionHandler, itemIdRemoteId, arrayList, null), 3, null);
        }
        dialogInterface.dismiss();
    }

    private final void logOverflowMenu(BoxItem boxItem, String menuItemName) {
        BoxAmplitudeAnalytics.createEventBuilder().setItemType(BoxAnalyticsParams.INSTANCE.calculateItemType(boxItem)).setIsCollectionItem(BoxExtendedApiCollections.isItemInAnyCollection(boxItem)).setMenuItemSelected(menuItemName).logEvent(BoxAnalyticsParams.EVENT_OVERFLOW_MENU_CTA_TRIGGERED);
    }

    private final void logDeleteItem(BoxItem boxItem) {
        BoxAmplitudeAnalytics.createEventBuilder().setItemType(BoxAnalyticsParams.INSTANCE.calculateItemType(boxItem)).setIsCollectionItem(BoxExtendedApiCollections.isItemInAnyCollection(boxItem)).logEvent(BoxAnalyticsParams.EVENT_DELETE_TRIGGERED);
    }

    private final void logShareStarted(BoxItem item) {
        BoxAmplitudeAnalytics.ShareEventPropertyBuilder shareEventPropertyBuilderCreateShareEventBuilder = BoxAmplitudeAnalytics.createShareEventBuilder();
        shareEventPropertyBuilderCreateShareEventBuilder.setBoxItem(item);
        shareEventPropertyBuilderCreateShareEventBuilder.logEvent(BoxAnalyticsParams.EVENT_SHARE_STARTED);
    }

    private final Void throwIllegalStateException() {
        throw new IllegalStateException("Must be BoxFolder/BoxFile/BoxBookmark/BoxSearchItem");
    }

    @Override // com.box.android.base.presentation.utilities.IItemActionHandler
    public boolean handleActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != -1) {
            UploadAnalyticsUtils.logUploadFlowCancelCtaEvent("os");
            return true;
        }
        if (requestCode == 0) {
            BoxItem boxItem = this.itemToExport;
            if (boxItem != null) {
                Intrinsics.checkNotNull(data);
                handleItemDownloadAction(boxItem, data);
                this.itemToExport = null;
            }
            return true;
        }
        if (requestCode == 1 || requestCode == 2) {
            if (requestCode != 1) {
                this.ftuxController.evaluateTrigger(FTUXController.FTUXTrigger.SHARED_OR_COLLABORATED_ITEM);
            }
            return true;
        }
        if (requestCode != 3) {
            return false;
        }
        uploadNewVersion(data);
        return true;
    }

    private final void handleItemDownloadAction(BoxItem itemToDownload, Intent data) {
        FileModel fileModel;
        if ((itemToDownload instanceof BoxFile) && this.featureFlips.getFileDownloadJobMigration().getEnabled()) {
            ItemModel itemModel = ItemModelMapper.INSTANCE.toItemModel(itemToDownload);
            if (itemModel == null || (fileModel = ItemModelKt.fileModel(itemModel)) == null) {
                return;
            }
            String stringExtra = data.getStringExtra(IntentConstants.LocalFolderChooser.EXTRA_SELECTED_DIR);
            Intrinsics.checkNotNull(stringExtra);
            downloadWithJobSystem$default(this, fileModel, stringExtra, null, 4, null);
            return;
        }
        if ((itemToDownload instanceof BoxFolder) && this.featureFlips.getDownloadFolderJobMigration().getEnabled()) {
            FolderModel folderModel = FolderModelMapper.INSTANCE.toFolderModel((BoxFolder) itemToDownload, true);
            String stringExtra2 = data.getStringExtra(IntentConstants.LocalFolderChooser.EXTRA_SELECTED_DIR);
            Intrinsics.checkNotNull(stringExtra2);
            downloadWithJobSystem$default(this, folderModel, stringExtra2, null, 4, null);
            return;
        }
        BoxBaseApplication.getInstance().getJobManager().exportItems(CollectionsKt.listOf(itemToDownload), data.getStringExtra(IntentConstants.LocalFolderChooser.EXTRA_SELECTED_DIR));
    }

    @Override // com.box.android.base.presentation.utilities.IItemActionHandler
    public void showBottomSheet(ItemModel itemModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, DialogInterface.OnShowListener onShowListener, List<Integer> availableActions) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Intrinsics.checkNotNullParameter(bottomSheetMenuType, "bottomSheetMenuType");
        Intrinsics.checkNotNullParameter(launchContext, "launchContext");
        Intrinsics.checkNotNullParameter(availableActions, "availableActions");
        showBottomSheet(ItemModelMapper.INSTANCE.toBoxItem(itemModel, true), bottomSheetMenuType, launchContext, onShowListener, availableActions);
    }

    public static /* synthetic */ void downloadWithJobSystem$default(ItemActionHandler itemActionHandler, ItemModel itemModel, String str, CoroutineScope coroutineScope, int i, Object obj) {
        if ((i & 4) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        }
        itemActionHandler.downloadWithJobSystem(itemModel, str, coroutineScope);
    }

    /* JADX INFO: renamed from: com.box.android.utilities.ItemActionHandler$downloadWithJobSystem$1, reason: invalid class name */
    /* JADX INFO: compiled from: ItemActionHandler.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.utilities.ItemActionHandler$downloadWithJobSystem$1", f = "ItemActionHandler.kt", i = {}, l = {887}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemModel $itemModel;
        final /* synthetic */ String $targetDirectoryPath;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ItemModel itemModel, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$itemModel = itemModel;
            this.$targetDirectoryPath = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ItemActionHandler.this.new AnonymousClass1(this.$itemModel, this.$targetDirectoryPath, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ItemActionHandler.this.localItemService.enqueueDownloadJobForItems(CollectionsKt.listOf(this.$itemModel), this.$targetDirectoryPath, JobTags.JobSource.DOWNLOAD_FROM_BROWSE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void downloadWithJobSystem(ItemModel itemModel, String targetDirectoryPath, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Intrinsics.checkNotNullParameter(targetDirectoryPath, "targetDirectoryPath");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(itemModel, targetDirectoryPath, null), 3, null);
    }

    private final BoxAppFutureTask<? extends BoxItem> getItemInfoFutureTask(BoxItem item) {
        if (item instanceof BoxFolder) {
            IBaseModelController iBaseModelController = this.baseMoco;
            BoxRequestsFolder.GetFolderInfo limit = this.boxExtendedApiFolder.getInfoRequest(((BoxFolder) item).getUserId()).setLimit(0);
            Intrinsics.checkNotNullExpressionValue(limit, "setLimit(...)");
            return iBaseModelController.performRemote(limit);
        }
        if (item instanceof BoxFile) {
            IBaseModelController iBaseModelController2 = this.baseMoco;
            BoxRequestsFile.GetFileInfo infoRequest = this.boxExtendedApiFile.getInfoRequest(((BoxFile) item).getUserId());
            Intrinsics.checkNotNullExpressionValue(infoRequest, "getInfoRequest(...)");
            return iBaseModelController2.performRemote(infoRequest);
        }
        if (item instanceof BoxBookmark) {
            IBaseModelController iBaseModelController3 = this.baseMoco;
            BoxRequestsBookmark.GetBookmarkInfo infoRequest2 = this.boxExtendedApiBookmark.getInfoRequest(((BoxBookmark) item).getUserId());
            Intrinsics.checkNotNullExpressionValue(infoRequest2, "getInfoRequest(...)");
            return iBaseModelController3.performRemote(infoRequest2);
        }
        if (!(item instanceof BoxSearchItem)) {
            throwIllegalStateException();
            throw new KotlinNothingValueException();
        }
        BoxItem item2 = ((BoxSearchItem) item).getItem();
        Intrinsics.checkNotNullExpressionValue(item2, "getItem(...)");
        return getItemInfoFutureTask(item2);
    }

    @Override // com.box.android.base.presentation.utilities.IItemActionHandler
    public void showBottomSheet(BoxItem item, final BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, final BottomSheetAttributes.LaunchContext launchContext, final DialogInterface.OnShowListener onShowListener, List<Integer> availableActions) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(bottomSheetMenuType, "bottomSheetMenuType");
        Intrinsics.checkNotNullParameter(launchContext, "launchContext");
        Intrinsics.checkNotNullParameter(availableActions, "availableActions");
        BoxAppFutureTask<? extends BoxItem> itemInfoFutureTask = getItemInfoFutureTask(item);
        if (!(item instanceof BoxSearchItem)) {
            doShowBottomSheet(item, bottomSheetMenuType, launchContext, onShowListener, availableActions);
        } else {
            final Function1 function1 = new Function1() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ItemActionHandler.showBottomSheet$lambda$0(this.f$0, bottomSheetMenuType, launchContext, onShowListener, (BoxResponse) obj);
                }
            };
            itemInfoFutureTask.addOnCompletedListener(new BoxAppFutureTask.OnCompletedListener(function1) { // from class: com.box.android.utilities.ItemActionHandler$sam$com_box_android_coreservices_modelcontroller_BoxAppFutureTask_OnCompletedListener$0
                private final /* synthetic */ Function1 function;

                {
                    Intrinsics.checkNotNullParameter(function1, "function");
                    this.function = function1;
                }

                @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
                public final /* synthetic */ void onCompleted(BoxResponse boxResponse) {
                    this.function.invoke(boxResponse);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showBottomSheet$lambda$0(ItemActionHandler itemActionHandler, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, DialogInterface.OnShowListener onShowListener, BoxResponse boxResponse) {
        if (boxResponse != null && boxResponse.isSuccess()) {
            BoxObject result = boxResponse.getResult();
            Intrinsics.checkNotNull(result);
            doShowBottomSheet$default(itemActionHandler, result, bottomSheetMenuType, launchContext, onShowListener, null, 16, null);
        } else {
            BoxPresentationUtils.displayToast(R.string.box_browsesdk_network_error, itemActionHandler.activity, new String[0]);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void doShowBottomSheet$default(ItemActionHandler itemActionHandler, BoxObject boxObject, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, DialogInterface.OnShowListener onShowListener, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            launchContext = BottomSheetAttributes.LaunchContext.Default.INSTANCE;
        }
        BottomSheetAttributes.LaunchContext launchContext2 = launchContext;
        if ((i & 8) != 0) {
            onShowListener = null;
        }
        DialogInterface.OnShowListener onShowListener2 = onShowListener;
        if ((i & 16) != 0) {
            list = CollectionsKt.emptyList();
        }
        itemActionHandler.doShowBottomSheet(boxObject, bottomSheetMenuType, launchContext2, onShowListener2, list);
    }

    private final void doShowBottomSheet(final BoxObject item, final BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, final BottomSheetAttributes.LaunchContext launchContext, final DialogInterface.OnShowListener onShowListener, final List<Integer> availableActions) {
        this.activity.runOnUiThread(new Runnable() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ItemActionHandler.doShowBottomSheet$lambda$0(item, this, bottomSheetMenuType, launchContext, availableActions, onShowListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void doShowBottomSheet$lambda$0(BoxObject boxObject, final ItemActionHandler itemActionHandler, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, List list, DialogInterface.OnShowListener onShowListener) {
        BottomSheetMenuFragment bottomSheetMenuFragmentNewInstance;
        BoxRecentItem recentItem;
        String interactionSharedLink;
        if (boxObject instanceof BoxFolder) {
            bottomSheetMenuFragmentNewInstance = FolderSheetFragment.newInstance(itemActionHandler.activity, (BoxFolder) boxObject, bottomSheetMenuType, launchContext, itemActionHandler.featureFlips.getMainScreenRedesign().getEnabled());
        } else if (boxObject instanceof BoxFile) {
            bottomSheetMenuFragmentNewInstance = FileSheetFragment.newInstance(itemActionHandler.activity, (BoxFile) boxObject, bottomSheetMenuType, launchContext, list, itemActionHandler.featureFlips.getMainScreenRedesign().getEnabled());
        } else if (boxObject instanceof BoxBookmark) {
            bottomSheetMenuFragmentNewInstance = BookmarkSheetFragment.newInstance(itemActionHandler.activity, (BoxBookmark) boxObject, bottomSheetMenuType, launchContext, itemActionHandler.featureFlips.getMainScreenRedesign().getEnabled());
        } else {
            if (boxObject instanceof BoxSearchItem) {
                BoxItem item = ((BoxSearchItem) boxObject).getItem();
                Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
                doShowBottomSheet$default(itemActionHandler, item, bottomSheetMenuType, launchContext, onShowListener, null, 16, null);
                return;
            }
            itemActionHandler.throwIllegalStateException();
            throw new KotlinNothingValueException();
        }
        IBoxRecentHolder iBoxRecentHolder = boxObject instanceof IBoxRecentHolder ? (IBoxRecentHolder) boxObject : null;
        if (iBoxRecentHolder != null && (recentItem = iBoxRecentHolder.getRecentItem()) != null && (interactionSharedLink = recentItem.getInteractionSharedLink()) != null) {
            itemActionHandler.boxSession.setSharedLink(interactionSharedLink);
        }
        BottomSheetMenuFragment bottomSheetMenuFragment = bottomSheetMenuFragmentNewInstance;
        BoxAmplitudeAnalytics.sendAnalyticsEventForOptions(bottomSheetMenuFragment.getAmplitudePageName(), BoxAnalyticsParams.CTA_PAGE_LOCATION_LIST_ITEM);
        itemActionHandler.getSupportFragmentManager().setFragmentResultListener(BottomSheetMenuFragment.BOTTOM_SHEET_REQUEST_KEY, itemActionHandler.activity, new FragmentResultListener() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda9
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                ItemActionHandler.doShowBottomSheet$lambda$0$1(this.f$0, str, bundle);
            }
        });
        bottomSheetMenuFragment.setOnShowListener(onShowListener).show(itemActionHandler.getSupportFragmentManager(), BottomSheetMenuFragment.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doShowBottomSheet$lambda$0$1(ItemActionHandler itemActionHandler, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "<unused var>");
        itemActionHandler.invokeAndResetOnItemClosedListener();
        itemActionHandler.getSupportFragmentManager().clearFragmentResultListener(BottomSheetMenuFragment.BOTTOM_SHEET_REQUEST_KEY);
    }

    /* JADX WARN: Type inference failed for: r0v18, types: [com.box.android.utilities.ItemActionHandler$handleBoxFilePicked$3] */
    private final void handleBoxFilePicked(BoxFile boxFile) {
        this.activity.setResult(0);
        if (!CoreServiceUtils.getIsSaveToLocationAllowed(SaveLocation.LOCAL, null)) {
            MAMUIHelper.showSharingBlockedDialog(this.activity);
            return;
        }
        Result<Unit, AdminSettingsDomainError> resultCheckOfflineActionAdminSettings = this.fileActionsManager.checkOfflineActionAdminSettings();
        if (!(resultCheckOfflineActionAdminSettings instanceof Result.Success)) {
            if (resultCheckOfflineActionAdminSettings instanceof Result.Error) {
                handleErrorOnSaveForOffline((AdminSettingsDomainError) ((Result.Error) resultCheckOfflineActionAdminSettings).getValue());
                this.activity.finish();
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (!BoxAccountManager.isMobileOpenInEnabled(this.userContextManager)) {
            BoxNotificationHelper.displayDialog(R.string.Feature_disabled, R.string.This_feature_has_been_disabled_by_your_or_your_administrator);
            this.activity.finish();
            return;
        }
        if (Permissions.hasPermission(boxFile, Permissions.ACTION.DOWNLOAD, false, getUserSharedPrefs())) {
            String externalStorageState = Environment.getExternalStorageState();
            if (externalStorageState != null && !Intrinsics.areEqual(externalStorageState, "mounted")) {
                BoxPresentationUtils.displayToast(R.string.toast_sdcard1, this.activity, new String[0]);
                this.activity.finish();
                return;
            }
            final BoxTransferFutureTask<BoxDownloadFileMessage> boxTransferFutureTaskMakeWorkingFile = this.transfersModelController.makeWorkingFile(boxFile, new ProgressReporter.FileTransferProgressListener());
            Intrinsics.checkNotNullExpressionValue(boxTransferFutureTaskMakeWorkingFile, "makeWorkingFile(...)");
            AppCompatActivity appCompatActivity = this.activity;
            BoxFragmentActivity boxFragmentActivity = appCompatActivity instanceof BoxFragmentActivity ? (BoxFragmentActivity) appCompatActivity : null;
            if (boxFragmentActivity != null) {
                boxFragmentActivity.showSpinner(true);
            }
            AppCompatActivity appCompatActivity2 = this.activity;
            BoxFragmentActivity boxFragmentActivity2 = appCompatActivity2 instanceof BoxFragmentActivity ? (BoxFragmentActivity) appCompatActivity2 : null;
            if (boxFragmentActivity2 != null) {
                boxFragmentActivity2.setSpinnerOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.box.android.utilities.ItemActionHandler$$ExternalSyntheticLambda10
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        ItemActionHandler.handleBoxFilePicked$lambda$1(boxTransferFutureTaskMakeWorkingFile, this, dialogInterface);
                    }
                });
            }
            new Thread() { // from class: com.box.android.utilities.ItemActionHandler.handleBoxFilePicked.3
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        BoxMessage boxMessageRunAndGet = boxTransferFutureTaskMakeWorkingFile.runAndGet();
                        Intrinsics.checkNotNullExpressionValue(boxMessageRunAndGet, "runAndGet(...)");
                        File javaFilePayload = ((BoxFileTransferMessage) boxMessageRunAndGet).getJavaFilePayload();
                        if (javaFilePayload != null && javaFilePayload.exists()) {
                            Uri uriForFile = FileProvider.getUriForFile(this.getActivity().getApplicationContext(), this.getActivity().getResources().getString(R.string.fileProviderAuthority), javaFilePayload);
                            this.getIntent().addFlags(1);
                            this.getActivity().setResult(-1, this.getIntent().setData(uriForFile));
                        }
                    } catch (InterruptedException e) {
                        BoxLogUtils.logException(e);
                        Thread.currentThread().interrupt();
                    } catch (ExecutionException e2) {
                        BoxLogUtils.logException(e2);
                    }
                    this.getActivity().finish();
                    AppCompatActivity activity = this.getActivity();
                    BoxFragmentActivity boxFragmentActivity3 = activity instanceof BoxFragmentActivity ? (BoxFragmentActivity) activity : null;
                    if (boxFragmentActivity3 != null) {
                        boxFragmentActivity3.broadcastDismissSpinner();
                    }
                }
            }.start();
            return;
        }
        BoxPresentationUtils.displayToast(R.string.you_do_not_have_permission_to_open_or_download_this_item, this.activity, new String[0]);
        this.activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleBoxFilePicked$lambda$1(BoxTransferFutureTask boxTransferFutureTask, ItemActionHandler itemActionHandler, DialogInterface dialogInterface) {
        boxTransferFutureTask.cancel(true);
        itemActionHandler.activity.finish();
    }
}
