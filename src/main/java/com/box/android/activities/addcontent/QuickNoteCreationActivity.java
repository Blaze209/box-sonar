package com.box.android.activities.addcontent;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.R;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.browse.cpl.itempicker.ItemPickerActivity;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.NewNoteLocation;
import com.box.android.domain.models.NoteCreationError;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.usecases.notes.NewNoteData;
import com.box.android.utilities.ItemClickHandler;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.dao.BoxNoteCreation;
import com.box.boxandroidlibv2private.requests.BoxRequestCreateBoxNote;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.Serializable;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: QuickNoteCreationActivity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014¢\u0006\u0002\u0010\u001cJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\"\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u000200H\u0016J\u0014\u00101\u001a\u00020\u001e2\n\u00102\u001a\u0006\u0012\u0002\b\u000303H\u0014J\u0014\u00104\u001a\u00020\u001e2\n\u00105\u001a\u0006\u0012\u0002\b\u000306H\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/box/android/activities/addcontent/QuickNoteCreationActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "itemClickHandlerFactory", "Lcom/box/android/utilities/ItemClickHandler$Factory;", "getItemClickHandlerFactory", "()Lcom/box/android/utilities/ItemClickHandler$Factory;", "setItemClickHandlerFactory", "(Lcom/box/android/utilities/ItemClickHandler$Factory;)V", "bveManager", "Lcom/box/android/domain/services/IBVEManager;", "getBveManager", "()Lcom/box/android/domain/services/IBVEManager;", "setBveManager", "(Lcom/box/android/domain/services/IBVEManager;)V", "viewModel", "Lcom/box/android/activities/addcontent/NewNoteCreationViewModel;", "getViewModel", "()Lcom/box/android/activities/addcontent/NewNoteCreationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "itemClickHandler", "Lcom/box/android/utilities/ItemClickHandler;", QuickNoteCreationActivity.EXTRA_PREVIEW_SOURCE, "Lcom/box/android/domain/models/preview/PreviewSource;", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "onBoxCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "observeLoading", "observeCommands", "launchDefaultNoteFolderPicker", "handleOnActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "handlePreparationError", "error", "Lcom/box/android/domain/models/NoteCreationError;", "createNote", "noteData", "Lcom/box/android/domain/usecases/notes/NewNoteData;", "getIntentFilter", "Landroid/content/IntentFilter;", "processBoxMessage", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "handleCreationError", "response", "Lcom/box/androidsdk/content/requests/BoxResponse;", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class QuickNoteCreationActivity extends Hilt_QuickNoteCreationActivity {
    private static final String EXTRA_NEW_NOTE_LOCATION = "newNoteLocation";
    private static final String EXTRA_PREVIEW_SOURCE = "previewSource";
    private static final int SELECT_DEFAULT_NOTE_FOLDER_REQUEST = 4001;

    @Inject
    public IBVEManager bveManager;
    private ItemClickHandler itemClickHandler;

    @Inject
    public ItemClickHandler.Factory itemClickHandlerFactory;
    private PreviewSource previewSource = PreviewSource.Unknown.INSTANCE;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public QuickNoteCreationActivity() {
        final QuickNoteCreationActivity quickNoteCreationActivity = this;
        final Function0 function0 = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NewNoteCreationViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.activities.addcontent.QuickNoteCreationActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return quickNoteCreationActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.activities.addcontent.QuickNoteCreationActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return quickNoteCreationActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.activities.addcontent.QuickNoteCreationActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? quickNoteCreationActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    public final ItemClickHandler.Factory getItemClickHandlerFactory() {
        ItemClickHandler.Factory factory = this.itemClickHandlerFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemClickHandlerFactory");
        return null;
    }

    public final void setItemClickHandlerFactory(ItemClickHandler.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.itemClickHandlerFactory = factory;
    }

    public final IBVEManager getBveManager() {
        IBVEManager iBVEManager = this.bveManager;
        if (iBVEManager != null) {
            return iBVEManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bveManager");
        return null;
    }

    public final void setBveManager(IBVEManager iBVEManager) {
        Intrinsics.checkNotNullParameter(iBVEManager, "<set-?>");
        this.bveManager = iBVEManager;
    }

    private final NewNoteCreationViewModel getViewModel() {
        return (NewNoteCreationViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006c  */
    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle savedInstanceState) {
        Parcelable parcelable;
        PreviewSource.Unknown unknown;
        Parcelable parcelable2;
        super.onBoxCreate(savedInstanceState);
        this.itemClickHandler = getItemClickHandlerFactory().create((AppCompatActivity) this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) extras.getParcelable(EXTRA_NEW_NOTE_LOCATION, NewNoteLocation.class);
            } else {
                Parcelable parcelable3 = extras.getParcelable(EXTRA_NEW_NOTE_LOCATION);
                if (!(parcelable3 instanceof NewNoteLocation)) {
                    parcelable3 = null;
                }
                parcelable = (NewNoteLocation) parcelable3;
            }
            NewNoteLocation newNoteLocation = (NewNoteLocation) parcelable;
            if (newNoteLocation != null) {
                Bundle extras2 = getIntent().getExtras();
                if (extras2 == null) {
                    unknown = PreviewSource.Unknown.INSTANCE;
                } else {
                    if (Build.VERSION.SDK_INT >= 33) {
                        parcelable2 = (Parcelable) extras2.getParcelable(EXTRA_PREVIEW_SOURCE, PreviewSource.class);
                    } else {
                        Parcelable parcelable4 = extras2.getParcelable(EXTRA_PREVIEW_SOURCE);
                        parcelable2 = (PreviewSource) (parcelable4 instanceof PreviewSource ? parcelable4 : null);
                    }
                    unknown = (PreviewSource) parcelable2;
                    if (unknown == null) {
                        unknown = PreviewSource.Unknown.INSTANCE;
                    }
                }
                this.previewSource = unknown;
                observeLoading();
                observeCommands();
                getViewModel().getStore().send(new NewNoteCreationReducer.Action.Start(newNoteLocation));
                return;
            }
        }
        finish();
    }

    private final void observeLoading() {
        StoreKt.observe$default(getViewModel().getStore(), new PropertyReference1Impl() { // from class: com.box.android.activities.addcontent.QuickNoteCreationActivity.observeLoading.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(((NewNoteCreationReducer.State) obj).isLoading());
            }
        }, null, new Function1() { // from class: com.box.android.activities.addcontent.QuickNoteCreationActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QuickNoteCreationActivity.observeLoading$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeLoading$lambda$0(QuickNoteCreationActivity quickNoteCreationActivity, boolean z) {
        if (z) {
            quickNoteCreationActivity.showSpinner(CommonBoxUtil.LS(R.string.creating_dot_dot_dot));
        } else {
            quickNoteCreationActivity.broadcastDismissSpinner();
        }
        return Unit.INSTANCE;
    }

    private final void observeCommands() {
        StoreKt.observe$default(getViewModel().getStore(), new PropertyReference1Impl() { // from class: com.box.android.activities.addcontent.QuickNoteCreationActivity.observeCommands.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((NewNoteCreationReducer.State) obj).getViewEffect();
            }
        }, null, new Function1() { // from class: com.box.android.activities.addcontent.QuickNoteCreationActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QuickNoteCreationActivity.observeCommands$lambda$0(this.f$0, (NewNoteCreationReducer.ViewEffect) obj);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeCommands$lambda$0(QuickNoteCreationActivity quickNoteCreationActivity, NewNoteCreationReducer.ViewEffect viewEffect) {
        Intrinsics.checkNotNullParameter(viewEffect, "viewEffect");
        if (viewEffect instanceof NewNoteCreationReducer.ViewEffect.CreateNote) {
            quickNoteCreationActivity.createNote(((NewNoteCreationReducer.ViewEffect.CreateNote) viewEffect).getNoteData());
            quickNoteCreationActivity.getViewModel().getStore().send(NewNoteCreationReducer.Action.ViewEffectHandled.INSTANCE);
        } else if (viewEffect instanceof NewNoteCreationReducer.ViewEffect.PickDefaultNoteFolder) {
            if (((NewNoteCreationReducer.ViewEffect.PickDefaultNoteFolder) viewEffect).getPreviousFolderNotWritable()) {
                BoxPresentationUtils.displayToast(R.string.you_do_not_have_permission_to_create_boxnote_in_this_folder, quickNoteCreationActivity, new String[0]);
            }
            quickNoteCreationActivity.launchDefaultNoteFolderPicker();
            quickNoteCreationActivity.getViewModel().getStore().send(NewNoteCreationReducer.Action.ViewEffectHandled.INSTANCE);
        } else if (viewEffect instanceof NewNoteCreationReducer.ViewEffect.ShowError) {
            quickNoteCreationActivity.handlePreparationError(((NewNoteCreationReducer.ViewEffect.ShowError) viewEffect).getError());
            quickNoteCreationActivity.getViewModel().getStore().send(NewNoteCreationReducer.Action.ViewEffectHandled.INSTANCE);
        } else if (Intrinsics.areEqual(viewEffect, NewNoteCreationReducer.ViewEffect.Close.INSTANCE)) {
            quickNoteCreationActivity.finish();
        } else if (!Intrinsics.areEqual(viewEffect, NewNoteCreationReducer.ViewEffect.None.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    private final void launchDefaultNoteFolderPicker() {
        startActivityForResult(ItemPickerActivity.Companion.getLaunchIntent$default(ItemPickerActivity.INSTANCE, this, null, true, false, CommonBoxUtil.LS(R.string.pick_default_notes_folder), 10, null), 4001);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        super.handleOnActivityResult(requestCode, resultCode, data);
        if (requestCode != 4001) {
            return;
        }
        Serializable serializableExtra = data != null ? data.getSerializableExtra(ItemPickerActivity.EXTRA_FOLDER) : null;
        BoxFolder boxFolder = serializableExtra instanceof BoxFolder ? (BoxFolder) serializableExtra : null;
        if (resultCode == -1 && boxFolder != null) {
            getViewModel().getStore().send(new NewNoteCreationReducer.Action.DefaultNoteFolderPicked(FolderModelMapper.toFolderModel$default(FolderModelMapper.INSTANCE, boxFolder, false, 1, null)));
        } else {
            getViewModel().getStore().send(NewNoteCreationReducer.Action.DefaultNoteFolderSelectionCancelled.INSTANCE);
        }
    }

    private final void handlePreparationError(NoteCreationError error) {
        if (error instanceof NoteCreationError.PermissionDenied) {
            BoxPresentationUtils.displayToast(R.string.you_do_not_have_permission_to_create_boxnote_in_this_folder, this, new String[0]);
        } else {
            if (!(error instanceof NoteCreationError.DefaultNoteFolderNotAccessible) && !(error instanceof NoteCreationError.Failed)) {
                throw new NoWhenBranchMatchedException();
            }
            BoxPresentationUtils.displayToast(R.string.check_connection_try_again, this, new String[0]);
        }
        finish();
    }

    private final void createNote(NewNoteData noteData) {
        BoxAnalytics.INSTANCE.trackEvent("boxnote", PasskeyWebListener.CREATE_UNIQUE_KEY, "bytes", (Integer) 0);
        IBaseModelController iBaseModelController = this.mBaseMoco;
        BoxRequestCreateBoxNote boxNoteCreation = this.mBoxApiPrivate.getBoxNoteCreation(noteData.getFolderId(), noteData.getNoteName(), getBveManager().getBaseUri());
        Intrinsics.checkNotNullExpressionValue(boxNoteCreation, "getBoxNoteCreation(...)");
        iBaseModelController.performRemote(boxNoteCreation);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = super.getIntentFilter();
        intentFilter.addAction(BoxRequestCreateBoxNote.class.getName());
        Intrinsics.checkNotNullExpressionValue(intentFilter, "apply(...)");
        return intentFilter;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void processBoxMessage(BoxMessage<?> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        ItemClickHandler itemClickHandler = null;
        BoxResponseMessage boxResponseMessage = message instanceof BoxResponseMessage ? (BoxResponseMessage) message : null;
        if (boxResponseMessage == null || !(boxResponseMessage.getRequest() instanceof BoxRequestCreateBoxNote) || isFinishing()) {
            return;
        }
        BoxResponse<?> response = boxResponseMessage.getResponse();
        BoxObject result = response.getResult();
        BoxNoteCreation boxNoteCreation = result instanceof BoxNoteCreation ? (BoxNoteCreation) result : null;
        if (response.isSuccess()) {
            if (boxNoteCreation != null ? Intrinsics.areEqual((Object) boxNoteCreation.getSuccess(), (Object) true) : false) {
                BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_CREATE_NEW_BOX_NOTE_SUCCEEDED);
                ItemClickHandler itemClickHandler2 = this.itemClickHandler;
                if (itemClickHandler2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemClickHandler");
                } else {
                    itemClickHandler = itemClickHandler2;
                }
                BoxFile newNote = boxNoteCreation.getNewNote();
                Intrinsics.checkNotNullExpressionValue(newNote, "getNewNote(...)");
                itemClickHandler.onFileClick(newNote, new IItemClickHandler.FileClickConfig(this.previewSource, null, null, null, null, null, null, true, false, 382, null));
                setResult(-1);
                finish();
                return;
            }
        }
        Intrinsics.checkNotNull(response);
        handleCreationError(response);
    }

    private final void handleCreationError(BoxResponse<?> response) {
        Exception exception = response.getException();
        if (exception instanceof BoxException) {
            BoxException boxException = (BoxException) exception;
            if (Intrinsics.areEqual(BoxNoteCreation.ERROR_NAME_CONFLICT, boxException.getMessage())) {
                BoxPresentationUtils.displayToast(R.string.file_create_error_duplicate_name, this, new String[0]);
            } else if (boxException.getResponseCode() == 403) {
                BoxPresentationUtils.displayToast(R.string.permission_denied_general, this, new String[0]);
            } else {
                BoxPresentationUtils.displayToast(R.string.check_connection_try_again, this, new String[0]);
            }
        }
        getViewModel().getStore().send(NewNoteCreationReducer.Action.NoteCreationFailed.INSTANCE);
        broadcastDismissSpinner();
        finish();
    }

    /* JADX INFO: compiled from: QuickNoteCreationActivity.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/activities/addcontent/QuickNoteCreationActivity$Companion;", "", "<init>", "()V", "EXTRA_NEW_NOTE_LOCATION", "", "EXTRA_PREVIEW_SOURCE", "SELECT_DEFAULT_NOTE_FOLDER_REQUEST", "", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/NewNoteLocation;", QuickNoteCreationActivity.EXTRA_PREVIEW_SOURCE, "Lcom/box/android/domain/models/preview/PreviewSource;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent createIntent(Context context, NewNoteLocation location, PreviewSource previewSource) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(location, "location");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
            Intent intent = new Intent(context, (Class<?>) QuickNoteCreationActivity.class);
            intent.putExtra(QuickNoteCreationActivity.EXTRA_NEW_NOTE_LOCATION, location);
            intent.putExtra(QuickNoteCreationActivity.EXTRA_PREVIEW_SOURCE, previewSource);
            return intent;
        }
    }
}
