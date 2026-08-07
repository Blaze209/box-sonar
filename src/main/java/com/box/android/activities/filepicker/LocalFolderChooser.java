package com.box.android.activities.filepicker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.Insets;
import androidx.core.os.BundleCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.android.R;
import com.box.android.adapters.SDFileListAdapter;
import com.box.android.base.presentation.utilities.EdgeToEdgeUtils;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.dao.FileInfo;
import com.box.android.data.service.impl.thumbnail.ThumbnailService;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.android.utilities.BoxUtils;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;

/* JADX INFO: compiled from: LocalFolderChooser.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 ]2\u00020\u0001:\u0002]^B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u00103\u001a\u0004\u0018\u000104H\u0014¢\u0006\u0002\u00105J\u0012\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0014J\b\u0010:\u001a\u000207H\u0002J\b\u0010;\u001a\u000207H\u0014J\u000e\u0010<\u001a\u000207H\u0082@¢\u0006\u0002\u0010=J\"\u0010>\u001a\u0002072\u0006\u0010?\u001a\u0002042\u0006\u0010@\u001a\u0002042\b\u0010A\u001a\u0004\u0018\u00010BH\u0014J\u001a\u0010C\u001a\u0002072\b\u0010D\u001a\u0004\u0018\u00010\n2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u0002072\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u0002072\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u000207H\u0002J \u0010N\u001a\u0002072\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002J\b\u0010O\u001a\u000207H\u0016J\u0010\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u000207H\u0002J0\u0010T\u001a\u0002072\f\u0010U\u001a\b\u0012\u0002\b\u0003\u0018\u00010V2\b\u0010W\u001a\u0004\u0018\u00010\u00142\u0006\u0010X\u001a\u0002042\u0006\u0010Y\u001a\u00020ZH\u0002J\u0010\u0010[\u001a\u0002072\u0006\u0010\\\u001a\u000209H\u0014R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006_"}, d2 = {"Lcom/box/android/activities/filepicker/LocalFolderChooser;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "fileList", "Ljava/util/ArrayList;", "Lcom/box/android/dao/FileInfo;", "Lkotlin/collections/ArrayList;", "navigationStack", "Ljava/util/Stack;", "", "rawBreadCrumb", "cancelButton", "Landroid/widget/Button;", "selectButton", "progressBar", "Landroid/widget/ProgressBar;", "listView", "Landroid/widget/ListView;", "emptyView", "Landroid/view/View;", "fileAdapter", "Lcom/box/android/adapters/SDFileListAdapter;", "getFileAdapter", "()Lcom/box/android/adapters/SDFileListAdapter;", "setFileAdapter", "(Lcom/box/android/adapters/SDFileListAdapter;)V", "mocoBoxTransfers", "Lcom/box/android/coreservices/modelcontroller/IMoCoBoxTransfers;", "getMocoBoxTransfers", "()Lcom/box/android/coreservices/modelcontroller/IMoCoBoxTransfers;", "setMocoBoxTransfers", "(Lcom/box/android/coreservices/modelcontroller/IMoCoBoxTransfers;)V", "browseController", "Lcom/box/android/domain/controller/IBrowseController;", "getBrowseController", "()Lcom/box/android/domain/controller/IBrowseController;", "setBrowseController", "(Lcom/box/android/domain/controller/IBrowseController;)V", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "getThumbnailService", "Lcom/box/android/data/service/impl/thumbnail/ThumbnailService;", "getGetThumbnailService", "()Lcom/box/android/data/service/impl/thumbnail/ThumbnailService;", "setGetThumbnailService", "(Lcom/box/android/data/service/impl/thumbnail/ThumbnailService;)V", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "onBoxCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupEdgeToEdge", "onBoxStart", "handleFolderSelection", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleOnActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "navigateToDirectory", "directoryAbsolutePath", "keepNavigationHistory", "", "setItemLoadingState", "state", "Lcom/box/android/activities/filepicker/LocalFolderChooser$ItemLoadingState;", "loadFilesAsync", KeyManagementAlgorithmIdentifiers.DIRECT, "Ljava/io/File;", "updateNavigationButtons", "setListView", "onBackPressed", "onOptionsItemSelected", "menuItem", "Landroid/view/MenuItem;", "navigateUpDirectory", "onItemClick", BoxNoteConstants.BOX_NOTE_STYLE_TYPE_LIST, "Landroid/widget/AdapterView;", "view", ViewProps.POSITION, "id", "", "onSaveInstanceState", "outState", "Companion", "ItemLoadingState", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class LocalFolderChooser extends Hilt_LocalFolderChooser {
    public static final String EXTRA_NAVIGATION_STACK = "extra_navigation_stack";
    private static final String PREFIX_FOR_TEMP = "testTempFile";

    @Inject
    public IBrowseController browseController;
    private Button cancelButton;
    private View emptyView;
    public SDFileListAdapter fileAdapter;

    @Inject
    public ThumbnailService getThumbnailService;
    private ListView listView;

    @Inject
    public IMoCoBoxTransfers mocoBoxTransfers;
    private Stack<String> navigationStack;
    private ProgressBar progressBar;
    private Button selectButton;

    @Inject
    public IUserContextManager userContextManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private ArrayList<FileInfo> fileList = new ArrayList<>();
    private String rawBreadCrumb = "";

    /* JADX INFO: compiled from: LocalFolderChooser.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/activities/filepicker/LocalFolderChooser$ItemLoadingState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "EMPTY", "POPULATED", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private enum ItemLoadingState {
        LOADING,
        EMPTY,
        POPULATED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<ItemLoadingState> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: LocalFolderChooser.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemLoadingState.values().length];
            try {
                iArr[ItemLoadingState.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemLoadingState.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemLoadingState.POPULATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: compiled from: LocalFolderChooser.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/activities/filepicker/LocalFolderChooser$Companion;", "", "<init>", "()V", "EXTRA_NAVIGATION_STACK", "", "PREFIX_FOR_TEMP", "newLocalFolderChooserIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "startingPath", "title", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent newLocalFolderChooserIntent(Context context, String startingPath, String title) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) LocalFolderChooser.class);
            intent.putExtra(IntentConstants.LocalFolderChooser.EXTRA_STARTING_FOLDER_PATH, startingPath);
            intent.putExtra(IntentConstants.LocalFolderChooser.EXTRA_TITLE, title);
            return intent;
        }
    }

    public final SDFileListAdapter getFileAdapter() {
        SDFileListAdapter sDFileListAdapter = this.fileAdapter;
        if (sDFileListAdapter != null) {
            return sDFileListAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fileAdapter");
        return null;
    }

    public final void setFileAdapter(SDFileListAdapter sDFileListAdapter) {
        Intrinsics.checkNotNullParameter(sDFileListAdapter, "<set-?>");
        this.fileAdapter = sDFileListAdapter;
    }

    public final IMoCoBoxTransfers getMocoBoxTransfers() {
        IMoCoBoxTransfers iMoCoBoxTransfers = this.mocoBoxTransfers;
        if (iMoCoBoxTransfers != null) {
            return iMoCoBoxTransfers;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mocoBoxTransfers");
        return null;
    }

    public final void setMocoBoxTransfers(IMoCoBoxTransfers iMoCoBoxTransfers) {
        Intrinsics.checkNotNullParameter(iMoCoBoxTransfers, "<set-?>");
        this.mocoBoxTransfers = iMoCoBoxTransfers;
    }

    public final IBrowseController getBrowseController() {
        IBrowseController iBrowseController = this.browseController;
        if (iBrowseController != null) {
            return iBrowseController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("browseController");
        return null;
    }

    public final void setBrowseController(IBrowseController iBrowseController) {
        Intrinsics.checkNotNullParameter(iBrowseController, "<set-?>");
        this.browseController = iBrowseController;
    }

    public final IUserContextManager getUserContextManager() {
        IUserContextManager iUserContextManager = this.userContextManager;
        if (iUserContextManager != null) {
            return iUserContextManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userContextManager");
        return null;
    }

    public final void setUserContextManager(IUserContextManager iUserContextManager) {
        Intrinsics.checkNotNullParameter(iUserContextManager, "<set-?>");
        this.userContextManager = iUserContextManager;
    }

    public final ThumbnailService getGetThumbnailService() {
        ThumbnailService thumbnailService = this.getThumbnailService;
        if (thumbnailService != null) {
            return thumbnailService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("getThumbnailService");
        return null;
    }

    public final void setGetThumbnailService(ThumbnailService thumbnailService) {
        Intrinsics.checkNotNullParameter(thumbnailService, "<set-?>");
        this.getThumbnailService = thumbnailService;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.auto_upload_local_folder_chooser);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle savedInstanceState) {
        Stack<String> stack;
        super.onBoxCreate(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey(EXTRA_NAVIGATION_STACK)) {
            Serializable serializable = BundleCompat.getSerializable(savedInstanceState, EXTRA_NAVIGATION_STACK, BoxUtils.SerializableHolder.class);
            Intrinsics.checkNotNull(serializable);
            Serializable serializable2 = ((BoxUtils.SerializableHolder) serializable).get();
            Intrinsics.checkNotNull(serializable2, "null cannot be cast to non-null type java.util.Stack<kotlin.String>");
            stack = (Stack) serializable2;
        } else {
            stack = new Stack<>();
        }
        this.navigationStack = stack;
        Toolbar toolbar = (Toolbar) findViewById(R.id.picker_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_toolbar_back_btn);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        Stack<String> stack2 = null;
        if (supportActionBar2 != null) {
            Bundle extras = getIntent().getExtras();
            supportActionBar2.setTitle(extras != null ? extras.getString(IntentConstants.LocalFolderChooser.EXTRA_TITLE) : null);
        }
        View viewFindViewById = findViewById(android.R.id.list);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.listView = (ListView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.emptyView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.emptyView = viewFindViewById2;
        setFileAdapter(new SDFileListAdapter(this, this.fileList, true, getBrowseController(), getUserContextManager(), getGetThumbnailService(), this.mFeatureFlips));
        ListView listView = this.listView;
        if (listView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView = null;
        }
        listView.setAdapter((ListAdapter) getFileAdapter());
        ListView listView2 = this.listView;
        if (listView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView2 = null;
        }
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.box.android.activities.filepicker.LocalFolderChooser$$ExternalSyntheticLambda1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                LocalFolderChooser.onBoxCreate$lambda$0(this.f$0, adapterView, view, i, j);
            }
        });
        View viewFindViewById3 = findViewById(R.id.cancel_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.cancelButton = (Button) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.select_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.selectButton = (Button) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.progressBar = (ProgressBar) viewFindViewById5;
        Bundle extras2 = getIntent().getExtras();
        String string = extras2 != null ? extras2.getString(IntentConstants.LocalFolderChooser.EXTRA_STARTING_FOLDER_PATH) : null;
        Stack<String> stack3 = this.navigationStack;
        if (stack3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationStack");
        } else {
            stack2 = stack3;
        }
        navigateToDirectory(string, stack2.isEmpty());
        setupEdgeToEdge();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBoxCreate$lambda$0(LocalFolderChooser localFolderChooser, AdapterView adapterView, View view, int i, long j) {
        if (localFolderChooser.getFileAdapter().isItemEnabled(i)) {
            localFolderChooser.onItemClick(adapterView, view, i, j);
        }
    }

    private final void setupEdgeToEdge() {
        EdgeToEdgeUtils.INSTANCE.enableDarkEdgeToEdge(this);
        EdgeToEdgeUtils.INSTANCE.setInsets(findViewById(R.id.parent_container), new EdgeToEdgeUtils.OnInsetsAppliedListener() { // from class: com.box.android.activities.filepicker.LocalFolderChooser$$ExternalSyntheticLambda0
            @Override // com.box.android.base.presentation.utilities.EdgeToEdgeUtils.OnInsetsAppliedListener
            public final void onInsetsApplied(View view, Insets insets, WindowInsetsCompat windowInsetsCompat) {
                LocalFolderChooser.setupEdgeToEdge$lambda$0(view, insets, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupEdgeToEdge$lambda$0(View parentLayout, Insets insets, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(parentLayout, "parentLayout");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "<unused var>");
        ViewGroup.LayoutParams layoutParams = parentLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = insets.bottom;
            parentLayout.setLayoutParams(layoutParams);
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxStart() {
        super.onBoxStart();
        Button button = this.cancelButton;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.filepicker.LocalFolderChooser$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalFolderChooser.onBoxStart$lambda$0(this.f$0, view);
            }
        });
        Button button3 = this.selectButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectButton");
        } else {
            button2 = button3;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.filepicker.LocalFolderChooser$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalFolderChooser.onBoxStart$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBoxStart$lambda$0(LocalFolderChooser localFolderChooser, View view) {
        localFolderChooser.setResult(0);
        localFolderChooser.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBoxStart$lambda$1(LocalFolderChooser localFolderChooser, View view) {
        if (Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted")) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(localFolderChooser), null, null, new LocalFolderChooser$onBoxStart$2$1(localFolderChooser, null), 3, null);
        } else {
            Toast.makeText(localFolderChooser.getApplicationContext(), R.string.LS_The_SD_card_is_, 1).show();
        }
    }

    /* JADX INFO: renamed from: com.box.android.activities.filepicker.LocalFolderChooser$handleFolderSelection$2, reason: invalid class name */
    /* JADX INFO: compiled from: LocalFolderChooser.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.activities.filepicker.LocalFolderChooser$handleFolderSelection$2", f = "LocalFolderChooser.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {183, 195, 202}, m = "invokeSuspend", n = {"data", "tempFile", "data", "tempFile", "e", "docFile", "data", "tempFile", "e", "docFile", "e1", "openLibraryIntent"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LocalFolderChooser.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:38:0x00c9 A[PHI: r6
          0x00c9: PHI (r6v5 java.io.File) = (r6v3 java.io.File), (r6v6 java.io.File) binds: [B:37:0x00c7, B:72:0x01a1] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:49:0x0133  */
        /* JADX WARN: Code duplicated, block: B:64:0x018d  */
        /* JADX WARN: Code duplicated, block: B:66:0x0190 A[Catch: all -> 0x006b, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x006b, blocks: (B:66:0x0190, B:79:0x01ac, B:80:0x01b3, B:22:0x0067, B:30:0x009e), top: B:95:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:69:0x019a  */
        /* JADX WARN: Code duplicated, block: B:71:0x01a0  */
        /* JADX WARN: Code duplicated, block: B:82:0x01b6  */
        /* JADX WARN: Code duplicated, block: B:84:0x01bc  */
        /* JADX WARN: Code duplicated, block: B:86:0x01bf  */
        /* JADX WARN: Code duplicated, block: B:98:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00ba, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.box.android.activities.filepicker.LocalFolderChooser.AnonymousClass2.AnonymousClass1(r13.this$0, r14, null), r13) == r0) goto L63;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.io.File] */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.io.File] */
        /* JADX WARN: Type inference failed for: r6v2 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 455
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.activities.filepicker.LocalFolderChooser.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.box.android.activities.filepicker.LocalFolderChooser$handleFolderSelection$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: LocalFolderChooser.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.activities.filepicker.LocalFolderChooser$handleFolderSelection$2$1", f = "LocalFolderChooser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Intent $data;
            int label;
            final /* synthetic */ LocalFolderChooser this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(LocalFolderChooser localFolderChooser, Intent intent, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = localFolderChooser;
                this.$data = intent;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$data, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.setResult(-1, this.$data);
                this.this$0.finish();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.box.android.activities.filepicker.LocalFolderChooser$handleFolderSelection$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: LocalFolderChooser.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.activities.filepicker.LocalFolderChooser$handleFolderSelection$2$2", f = "LocalFolderChooser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01122 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Intent $data;
            int label;
            final /* synthetic */ LocalFolderChooser this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01122(LocalFolderChooser localFolderChooser, Intent intent, Continuation<? super C01122> continuation) {
                super(2, continuation);
                this.this$0 = localFolderChooser;
                this.$data = intent;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01122(this.this$0, this.$data, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01122) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.setResult(-1, this.$data);
                this.this$0.finish();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.box.android.activities.filepicker.LocalFolderChooser$handleFolderSelection$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: LocalFolderChooser.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.activities.filepicker.LocalFolderChooser$handleFolderSelection$2$3", f = "LocalFolderChooser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Intent $openLibraryIntent;
            int label;
            final /* synthetic */ LocalFolderChooser this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(LocalFolderChooser localFolderChooser, Intent intent, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = localFolderChooser;
                this.$openLibraryIntent = intent;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, this.$openLibraryIntent, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (CommonBoxUtil.isIntentAvailable(this.this$0, this.$openLibraryIntent)) {
                    MaterialAlertDialogBuilder negativeButton = new MaterialAlertDialogBuilder(this.this$0).setMessage(R.string.use_device_library_to_select).setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.box.android.activities.filepicker.LocalFolderChooser$handleFolderSelection$2$3$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    final LocalFolderChooser localFolderChooser = this.this$0;
                    final Intent intent = this.$openLibraryIntent;
                    negativeButton.setPositiveButton(R.string.use_device_library, new DialogInterface.OnClickListener() { // from class: com.box.android.activities.filepicker.LocalFolderChooser$handleFolderSelection$2$3$$ExternalSyntheticLambda1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            localFolderChooser.startActivityForResult(intent, 113);
                        }
                    }).show();
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleFolderSelection(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 113 && data != null) {
            if (resultCode == -1) {
                Intent intent = new Intent();
                LocalFolderChooser localFolderChooser = this;
                if (TextUtils.isEmpty(CommonBoxUtil.getDirectoryFromDocProviderResult(localFolderChooser, data))) {
                    setResult(0, data);
                } else {
                    intent.putExtra(IntentConstants.LocalFolderChooser.EXTRA_SELECTED_DIR, CommonBoxUtil.getDirectoryFromDocProviderResult(localFolderChooser, data));
                    setResult(resultCode, intent);
                }
            } else {
                setResult(resultCode, data);
            }
            finish();
        }
        super.handleOnActivityResult(requestCode, resultCode, data);
    }

    private final void navigateToDirectory(String directoryAbsolutePath, boolean keepNavigationHistory) {
        String strPeek;
        Stack<String> stack = null;
        if (keepNavigationHistory && !TextUtils.isEmpty(directoryAbsolutePath)) {
            Stack<String> stack2 = this.navigationStack;
            if (stack2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationStack");
                stack2 = null;
            }
            stack2.push(directoryAbsolutePath);
        }
        Stack<String> stack3 = this.navigationStack;
        if (stack3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationStack");
            stack3 = null;
        }
        if (stack3.isEmpty()) {
            strPeek = "";
        } else {
            Stack<String> stack4 = this.navigationStack;
            if (stack4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationStack");
            } else {
                stack = stack4;
            }
            strPeek = stack.peek();
        }
        File directory = BoxUtils.getDirectory(strPeek);
        if (directory != null) {
            String absolutePath = directory.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            this.rawBreadCrumb = absolutePath;
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setSubtitle(directory.getName());
            }
            ArrayList<FileInfo> arrayList = new ArrayList<>();
            this.fileList = arrayList;
            setListView(arrayList);
            loadFilesAsync(directory);
        } else {
            ArrayList<FileInfo> arrayList2 = new ArrayList<>();
            this.fileList = arrayList2;
            setListView(arrayList2);
            setItemLoadingState(ItemLoadingState.EMPTY);
        }
        updateNavigationButtons();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setItemLoadingState(ItemLoadingState state) {
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        View view = null;
        if (i == 1) {
            ProgressBar progressBar = this.progressBar;
            if (progressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                progressBar = null;
            }
            progressBar.setVisibility(0);
            View view2 = this.emptyView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        if (i == 2) {
            ProgressBar progressBar2 = this.progressBar;
            if (progressBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                progressBar2 = null;
            }
            progressBar2.setVisibility(8);
            View view3 = this.emptyView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emptyView");
            } else {
                view = view3;
            }
            view.setVisibility(0);
            return;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        ProgressBar progressBar3 = this.progressBar;
        if (progressBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            progressBar3 = null;
        }
        progressBar3.setVisibility(8);
        View view4 = this.emptyView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyView");
        } else {
            view = view4;
        }
        view.setVisibility(8);
    }

    /* JADX INFO: renamed from: com.box.android.activities.filepicker.LocalFolderChooser$loadFilesAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: LocalFolderChooser.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.activities.filepicker.LocalFolderChooser$loadFilesAsync$1", f = "LocalFolderChooser.kt", i = {}, l = {TypedValues.AttributesType.TYPE_PIVOT_TARGET}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $dir;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(File file, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$dir = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LocalFolderChooser.this.new AnonymousClass1(this.$dir, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = BuildersKt.withContext(Dispatchers.getIO(), new LocalFolderChooser$loadFilesAsync$1$fileInfos$1(LocalFolderChooser.this, this.$dir, null), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                LocalFolderChooser.this.fileList = new ArrayList((List) obj);
                LocalFolderChooser localFolderChooser = LocalFolderChooser.this;
                localFolderChooser.setListView(localFolderChooser.fileList);
            } catch (Exception unused) {
                LocalFolderChooser.this.fileList = new ArrayList();
                LocalFolderChooser localFolderChooser2 = LocalFolderChooser.this;
                localFolderChooser2.setListView(localFolderChooser2.fileList);
            }
            LocalFolderChooser localFolderChooser3 = LocalFolderChooser.this;
            localFolderChooser3.setItemLoadingState(localFolderChooser3.fileList.isEmpty() ? ItemLoadingState.EMPTY : ItemLoadingState.POPULATED);
            return Unit.INSTANCE;
        }
    }

    private final void loadFilesAsync(File dir) {
        setItemLoadingState(ItemLoadingState.LOADING);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(dir, null), 3, null);
    }

    private final void updateNavigationButtons() {
        if (this.rawBreadCrumb.length() == 1) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeButtonEnabled(false);
            }
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setDisplayHomeAsUpEnabled(false);
                return;
            }
            return;
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setHomeButtonEnabled(true);
        }
        ActionBar supportActionBar4 = getSupportActionBar();
        if (supportActionBar4 != null) {
            supportActionBar4.setDisplayHomeAsUpEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setListView(ArrayList<FileInfo> fileList) {
        getFileAdapter().setList(fileList);
        getFileAdapter().notifyDataSetChanged();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Stack<String> stack = this.navigationStack;
        Stack<String> stack2 = null;
        if (stack == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationStack");
            stack = null;
        }
        if (stack.size() <= 1) {
            finish();
            return;
        }
        Stack<String> stack3 = this.navigationStack;
        if (stack3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationStack");
            stack3 = null;
        }
        stack3.pop();
        Stack<String> stack4 = this.navigationStack;
        if (stack4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationStack");
        } else {
            stack2 = stack4;
        }
        navigateToDirectory(stack2.peek(), false);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        if (menuItem.getItemId() == 16908332) {
            navigateUpDirectory();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private final void navigateUpDirectory() {
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) this.rawBreadCrumb, '/', 0, false, 6, (Object) null);
        if (iLastIndexOf$default < 0 || this.rawBreadCrumb.length() <= 1) {
            return;
        }
        String strSubstring = this.rawBreadCrumb.substring(0, iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        if (strSubstring.length() < 1) {
            strSubstring = "/";
        }
        navigateToDirectory(strSubstring, true);
    }

    private final void onItemClick(AdapterView<?> list, View view, int position, long id) {
        FileInfo fileInfo = this.fileList.get(position);
        Intrinsics.checkNotNullExpressionValue(fileInfo, "get(...)");
        FileInfo fileInfo2 = fileInfo;
        if (fileInfo2.isFolder()) {
            navigateToDirectory(fileInfo2.getAbsolutePath(), true);
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        Stack<String> stack = this.navigationStack;
        if (stack == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationStack");
            stack = null;
        }
        outState.putSerializable(EXTRA_NAVIGATION_STACK, new BoxUtils.SerializableHolder(stack));
        super.onMAMSaveInstanceState(outState);
    }
}
