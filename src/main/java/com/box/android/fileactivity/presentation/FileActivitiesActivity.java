package com.box.android.fileactivity.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.content.IntentCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.base.presentation.components.commentbar.TimestampedCommentConfig;
import com.box.android.base.presentation.utilities.EdgeToEdgeUtils;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.models.item.FileModel;
import com.box.android.fileactivity.model.UserUIModel;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.views.DefaultAvatarController;
import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.lifecycle.HiltViewModelExtensions;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: FileActivitiesActivity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000bH\u0007R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "fileActivitiesVM", "Lcom/box/android/fileactivity/presentation/FileActivitiesViewModel;", "getFileActivitiesVM", "()Lcom/box/android/fileactivity/presentation/FileActivitiesViewModel;", "fileActivitiesVM$delegate", "Lkotlin/Lazy;", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "closeFileActivities", "activitiesCount", "Companion", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class FileActivitiesActivity extends Hilt_FileActivitiesActivity {
    public static final String FILE_MODEL_KEY = "FILE_MODEL_KEY";
    public static final String SELECTED_ACTIVITY_ID_KEY = "Selected_ActivityId";
    public static final String TIMESTAMPED_COMMENT_CONFIG_KEY = "TimestampedCommentConfig";

    /* JADX INFO: renamed from: fileActivitiesVM$delegate, reason: from kotlin metadata */
    private final Lazy fileActivitiesVM;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public FileActivitiesActivity() {
        final FileActivitiesActivity fileActivitiesActivity = this;
        final Function0<CreationExtras> function0 = new Function0<CreationExtras>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesActivity$special$$inlined$viewModelsWithArgs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras defaultViewModelCreationExtras = fileActivitiesActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "<get-defaultViewModelCreationExtras>(...)");
                final FileActivitiesActivity fileActivitiesActivity2 = this;
                return HiltViewModelExtensions.withCreationCallback(defaultViewModelCreationExtras, new Function1<ViewModelAssistedFactory<FileActivitiesViewModel>, ViewModel>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesActivity$special$$inlined$viewModelsWithArgs$1.1
                    /* JADX WARN: Code duplicated, block: B:13:0x0035  */
                    @Override // kotlin.jvm.functions.Function1
                    public final ViewModel invoke(ViewModelAssistedFactory<FileActivitiesViewModel> factory) {
                        Parcelable parcelable;
                        Intrinsics.checkNotNullParameter(factory, "factory");
                        Bundle bundle = new Bundle();
                        Bundle extras = fileActivitiesActivity2.getIntent().getExtras();
                        Parcelable parcelable2 = null;
                        if (extras != null) {
                            if (Build.VERSION.SDK_INT >= 33) {
                                parcelable = (Parcelable) extras.getParcelable("FILE_MODEL_KEY", Parcelable.class);
                            } else {
                                parcelable = extras.getParcelable("FILE_MODEL_KEY");
                                if (parcelable instanceof Parcelable) {
                                }
                                if (parcelable2 == null) {
                                    throw new IllegalArgumentException("Parcelable with key FILE_MODEL_KEY not found in Bundle".toString());
                                }
                            }
                            parcelable2 = parcelable;
                            if (parcelable2 == null) {
                                throw new IllegalArgumentException("Parcelable with key FILE_MODEL_KEY not found in Bundle".toString());
                            }
                        }
                        bundle.putParcelable("FILE_MODEL_KEY", parcelable2);
                        bundle.putString("Selected_ActivityId", fileActivitiesActivity2.getIntent().getStringExtra("Selected_ActivityId"));
                        bundle.putParcelable("TimestampedCommentConfig", (Parcelable) IntentCompat.getParcelableExtra(fileActivitiesActivity2.getIntent(), "TimestampedCommentConfig", TimestampedCommentConfig.class));
                        return factory.create(bundle);
                    }
                });
            }
        };
        this.fileActivitiesVM = new ViewModelLazy(Reflection.getOrCreateKotlinClass(FileActivitiesViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesActivity$special$$inlined$viewModelsWithArgs$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return fileActivitiesActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesActivity$special$$inlined$viewModelsWithArgs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return fileActivitiesActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.fileactivity.presentation.FileActivitiesActivity$special$$inlined$viewModelsWithArgs$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? fileActivitiesActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    private final FileActivitiesViewModel getFileActivitiesVM() {
        return (FileActivitiesViewModel) this.fileActivitiesVM.getValue();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        FileActivitiesActivity fileActivitiesActivity = this;
        EdgeToEdgeUtils.INSTANCE.enableDarkEdgeToEdge(fileActivitiesActivity);
        super.onMAMCreate(bundle);
        final BoxSession boxSession = this.mUserContextManager.getBoxSession(this);
        ComponentActivityKt.setContent$default(fileActivitiesActivity, null, ComposableLambdaKt.composableLambdaInstance(513816682, true, new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FileActivitiesActivity.onCreate$lambda$0(this.f$0, boxSession, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
        getFileActivitiesVM().getStore().send(FileActivitiesReducer.Action.Initialize.INSTANCE);
        OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), null, false, new Function1() { // from class: com.box.android.fileactivity.presentation.FileActivitiesActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileActivitiesActivity.onCreate$lambda$1(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(final FileActivitiesActivity fileActivitiesActivity, final BoxSession boxSession, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C45@2184L470,45@2094L560:FileActivitiesActivity.kt#dcyg9a");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(513816682, i, -1, "com.box.android.fileactivity.presentation.FileActivitiesActivity.onCreate.<anonymous> (FileActivitiesActivity.kt:45)");
            }
            FeatureFlips mFeatureFlips = fileActivitiesActivity.mFeatureFlips;
            Intrinsics.checkNotNullExpressionValue(mFeatureFlips, "mFeatureFlips");
            FileActivityFeatureFlipProviderKt.ProvideFileActivityFeatureFlips(new DelegatingFileActivityFeatureFlipProvider(mFeatureFlips), ComposableLambdaKt.rememberComposableLambda(-1920178022, true, new Function2() { // from class: com.box.android.fileactivity.presentation.FileActivitiesActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileActivitiesActivity.onCreate$lambda$0$0(this.f$0, boxSession, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(FileActivitiesActivity fileActivitiesActivity, BoxSession boxSession, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C50@2512L21,46@2202L438:FileActivitiesActivity.kt#dcyg9a");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1920178022, i, -1, "com.box.android.fileactivity.presentation.FileActivitiesActivity.onCreate.<anonymous>.<anonymous> (FileActivitiesActivity.kt:46)");
            }
            Store<FileActivitiesReducer.State, FileActivitiesReducer.Action> store = fileActivitiesActivity.getFileActivitiesVM().getStore();
            DefaultAvatarControllerWrapper defaultAvatarControllerWrapper = new DefaultAvatarControllerWrapper(new DefaultAvatarController(boxSession));
            String id = fileActivitiesActivity.getUserInfo().getUserId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            UserUIModel userUIModel = new UserUIModel(id, fileActivitiesActivity.getUserInfo().getUserName(), null, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1544868655, "CC(remember):FileActivitiesActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(fileActivitiesActivity);
            FileActivitiesActivity$onCreate$1$1$1$1 fileActivitiesActivity$onCreate$1$1$1$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || fileActivitiesActivity$onCreate$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                fileActivitiesActivity$onCreate$1$1$1$1RememberedValue = new FileActivitiesActivity$onCreate$1$1$1$1(fileActivitiesActivity);
                composer.updateRememberedValue(fileActivitiesActivity$onCreate$1$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FileActivitiesScreenKt.FileActivitiesScreen(store, defaultAvatarControllerWrapper, userUIModel, fileActivitiesActivity.mFeatureFlips.getMainScreenRedesign().getEnabled(), (Function1) ((KFunction) fileActivitiesActivity$onCreate$1$1$1$1RememberedValue), composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(FileActivitiesActivity fileActivitiesActivity, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        fileActivitiesActivity.getFileActivitiesVM().getStore().send(FileActivitiesReducer.Action.ToolbarAction.INSTANCE);
        return Unit.INSTANCE;
    }

    public final void closeFileActivities(int activitiesCount) {
        Intent intent = new Intent();
        intent.putExtra(IntentConstants.EXTRA_ACTIVITY_COUNT, activitiesCount);
        Unit unit = Unit.INSTANCE;
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: compiled from: FileActivitiesActivity.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivitiesActivity$Companion;", "", "<init>", "()V", "FILE_MODEL_KEY", "", "SELECTED_ACTIVITY_ID_KEY", "TIMESTAMPED_COMMENT_CONFIG_KEY", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "selectedActivityID", "timestampedCommentConfig", "Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Intent getIntent$default(Companion companion, Context context, FileModel fileModel, String str, TimestampedCommentConfig timestampedCommentConfig, int i, Object obj) {
            if ((i & 8) != 0) {
                timestampedCommentConfig = null;
            }
            return companion.getIntent(context, fileModel, str, timestampedCommentConfig);
        }

        public final Intent getIntent(Context context, FileModel fileModel, String selectedActivityID, TimestampedCommentConfig timestampedCommentConfig) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intent intent = new Intent(context, (Class<?>) FileActivitiesActivity.class);
            intent.putExtra("FILE_MODEL_KEY", fileModel);
            intent.putExtra("Selected_ActivityId", selectedActivityID);
            intent.putExtra("TimestampedCommentConfig", timestampedCommentConfig);
            return intent;
        }
    }
}
