package com.pspdfkit.ui.settings;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.compose.DialogNavigator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.R;
import com.pspdfkit.compose.theme.UiThemeKt;
import com.pspdfkit.configuration.page.PageLayoutMode;
import com.pspdfkit.configuration.page.PageScrollMode;
import com.pspdfkit.configuration.settings.SettingsMenuItemType;
import com.pspdfkit.internal.a10;
import com.pspdfkit.internal.d10;
import com.pspdfkit.internal.e10;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.uc;
import com.pspdfkit.internal.y9;
import com.pspdfkit.internal.yq;
import com.pspdfkit.internal.z00;
import com.pspdfkit.ui.settings.components.SettingsComponentsKt;
import io.nutrient.ui.settings.SettingsOptions;
import io.nutrient.ui.theme.ThemeWrapperKt;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0002\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\rJ\u000f\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u001f\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0017¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006*²\u0006\f\u0010)\u001a\u00020(8\nX\u008a\u0084\u0002"}, d2 = {"Lcom/pspdfkit/ui/settings/SettingsDialog;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "<init>", "()V", "Lcom/pspdfkit/ui/settings/SettingsDialogListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/nutrient/ui/settings/SettingsOptions;", "options", "(Lcom/pspdfkit/ui/settings/SettingsDialogListener;Lio/nutrient/ui/settings/SettingsOptions;)V", "Landroid/os/Bundle;", "bundle", "", "onRestoreState", "(Landroid/os/Bundle;)V", "updateListener", "(Lcom/pspdfkit/ui/settings/SettingsDialogListener;)V", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "outState", "onSaveInstanceState", "onResume", "onStart", DialogNavigator.NAME, "", "style", "setupDialog", "(Landroid/app/Dialog;I)V", "Lcom/pspdfkit/ui/settings/SettingsDialogListener;", "originalOptions", "Lio/nutrient/ui/settings/SettingsOptions;", "currentOptions", "Lcom/pspdfkit/internal/e10;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/pspdfkit/internal/e10;", "viewModel", "Companion", "Lcom/pspdfkit/internal/z00;", "state", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class SettingsDialog extends AppCompatDialogFragment {
    public static final String FRAGMENT_TAG = "com.pspdfkit.ui.dialog.SettingsDialog.FRAGMENT_TAG";
    public static final String OPTIONS_KEY = "SETTINGS_OPTIONS";
    public static final String ORIGINAL_OPTIONS_KEY = "SETTINGS_ORIGINAL_OPTIONS";
    private SettingsOptions currentOptions;
    private SettingsDialogListener listener;
    private SettingsOptions originalOptions;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/ui/settings/SettingsDialog$Companion;", "", "<init>", "()V", "FRAGMENT_TAG", "", "ORIGINAL_OPTIONS_KEY", "OPTIONS_KEY", "show", "Lcom/pspdfkit/ui/settings/SettingsDialog;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/pspdfkit/ui/settings/SettingsDialogListener;", "options", "Lio/nutrient/ui/settings/SettingsOptions;", "restore", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final SettingsDialog restore(FragmentManager fragmentManager, SettingsDialogListener listener) {
            fragmentManager.getClass();
            listener.getClass();
            Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(SettingsDialog.FRAGMENT_TAG);
            SettingsDialog settingsDialog = fragmentFindFragmentByTag instanceof SettingsDialog ? (SettingsDialog) fragmentFindFragmentByTag : null;
            if (settingsDialog == null) {
                return null;
            }
            settingsDialog.updateListener(listener);
            return settingsDialog;
        }

        @JvmStatic
        public final SettingsDialog show(FragmentManager fragmentManager, SettingsDialogListener listener, SettingsOptions options) {
            fragmentManager.getClass();
            listener.getClass();
            options.getClass();
            SettingsDialog settingsDialogRestore = restore(fragmentManager, listener);
            if (settingsDialogRestore != null) {
                settingsDialogRestore.originalOptions = options;
            } else {
                settingsDialogRestore = new SettingsDialog(listener, options);
            }
            if (!settingsDialogRestore.isAdded()) {
                settingsDialogRestore.show(fragmentManager, SettingsDialog.FRAGMENT_TAG);
            }
            return settingsDialogRestore;
        }

        private Companion() {
        }
    }

    public SettingsDialog() {
        Function0 function0 = new Function0() { // from class: com.pspdfkit.ui.settings.SettingsDialog$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return e10.d;
            }
        };
        final Function0<Fragment> function1 = new Function0<Fragment>() { // from class: com.pspdfkit.ui.settings.SettingsDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.pspdfkit.ui.settings.SettingsDialog$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function1.invoke();
            }
        });
        final Function0 function2 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(e10.class), new Function0<ViewModelStore>() { // from class: com.pspdfkit.ui.settings.SettingsDialog$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m10254viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.pspdfkit.ui.settings.SettingsDialog$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function3 = function2;
                if (function3 != null && (creationExtras = (CreationExtras) function3.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM10254viewModels$lambda1 = FragmentViewModelLazyKt.m10254viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM10254viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM10254viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function0);
    }

    private final e10 getViewModel() {
        return (e10) this.viewModel.getValue();
    }

    private final void onRestoreState(Bundle bundle) {
        Serializable serializable = bundle.getSerializable(ORIGINAL_OPTIONS_KEY);
        SettingsOptions settingsOptions = serializable instanceof SettingsOptions ? (SettingsOptions) serializable : null;
        if (settingsOptions != null) {
            this.originalOptions = settingsOptions;
        }
        Serializable serializable2 = bundle.getSerializable(OPTIONS_KEY);
        SettingsOptions settingsOptions2 = serializable2 instanceof SettingsOptions ? (SettingsOptions) serializable2 : null;
        if (settingsOptions2 != null) {
            this.currentOptions = settingsOptions2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onResume$lambda$0(SettingsDialog settingsDialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        z00 value = settingsDialog.getViewModel().b.getValue();
        if (!value.b) {
            return false;
        }
        settingsDialog.dismiss();
        SettingsDialogListener settingsDialogListener = settingsDialog.listener;
        if (settingsDialogListener == null) {
            return false;
        }
        settingsDialogListener.onSettingsSave(value.a);
        return false;
    }

    @JvmStatic
    public static final SettingsDialog restore(FragmentManager fragmentManager, SettingsDialogListener settingsDialogListener) {
        return INSTANCE.restore(fragmentManager, settingsDialogListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupDialog$lambda$0(final SettingsDialog settingsDialog, final SettingsDialog$setupDialog$dialogStyle$1 settingsDialog$setupDialog$dialogStyle$1, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(337498560, i, -1, "com.pspdfkit.ui.settings.SettingsDialog.setupDialog.<anonymous> (SettingsDialog.kt:164)");
            }
            ThemeWrapperKt.WithUiTheme(UiThemeKt.getUiColors(composer, 0), ComposableLambdaKt.rememberComposableLambda(-196184477, true, new Function2() { // from class: com.pspdfkit.ui.settings.SettingsDialog$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsDialog.setupDialog$lambda$0$0(this.f$0, settingsDialog$setupDialog$dialogStyle$1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupDialog$lambda$0$0(final SettingsDialog settingsDialog, final SettingsDialog$setupDialog$dialogStyle$1 settingsDialog$setupDialog$dialogStyle$1, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-196184477, i, -1, "com.pspdfkit.ui.settings.SettingsDialog.setupDialog.<anonymous>.<anonymous> (SettingsDialog.kt:165)");
            }
            final State stateCollectAsState = SnapshotStateKt.collectAsState(settingsDialog.getViewModel().b, null, composer, 0, 1);
            settingsDialog.currentOptions = setupDialog$lambda$0$0$0(stateCollectAsState).a;
            z00 z00Var = setupDialog$lambda$0$0$0(stateCollectAsState);
            boolean z = !uc.a(settingsDialog.getResources(), R.dimen.pspdf__electronic_signature_dialog_width, R.dimen.pspdf__electronic_signature_dialog_height);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-16654196, true, new Function2() { // from class: com.pspdfkit.ui.settings.SettingsDialog$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SettingsDialog.setupDialog$lambda$0$0$1(settingsDialog$setupDialog$dialogStyle$1, stateCollectAsState, settingsDialog, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
            boolean zChangedInstance = composer.changedInstance(settingsDialog);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.ui.settings.SettingsDialog$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsDialog.setupDialog$lambda$0$0$2$0(this.f$0, (SettingsOptions) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            d10.a(z00Var, z, composableLambdaRememberComposableLambda, (Function1<? super SettingsOptions, Unit>) objRememberedValue, composer, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final z00 setupDialog$lambda$0$0$0(State<z00> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupDialog$lambda$0$0$1(SettingsDialog$setupDialog$dialogStyle$1 settingsDialog$setupDialog$dialogStyle$1, final State state, final SettingsDialog settingsDialog, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-16654196, i, -1, "com.pspdfkit.ui.settings.SettingsDialog.setupDialog.<anonymous>.<anonymous>.<anonymous> (SettingsDialog.kt:168)");
            }
            boolean zChanged = composer.changed(state) | composer.changedInstance(settingsDialog);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.ui.settings.SettingsDialog$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SettingsDialog.setupDialog$lambda$0$0$1$0$0(this.f$0, state);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            SettingsComponentsKt.SettingsTopbar(null, settingsDialog$setupDialog$dialogStyle$1, (Function0) objRememberedValue, composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupDialog$lambda$0$0$1$0$0(SettingsDialog settingsDialog, State state) {
        if (setupDialog$lambda$0$0$0(state).b) {
            SettingsDialogListener settingsDialogListener = settingsDialog.listener;
            if (settingsDialogListener != null) {
                settingsDialogListener.onSettingsSave(setupDialog$lambda$0$0$0(state).a);
            }
        } else {
            SettingsDialogListener settingsDialogListener2 = settingsDialog.listener;
            if (settingsDialogListener2 != null) {
                settingsDialogListener2.onSettingsClose();
            }
        }
        settingsDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupDialog$lambda$0$0$2$0(SettingsDialog settingsDialog, SettingsOptions settingsOptions) {
        settingsOptions.getClass();
        e10 viewModel = settingsDialog.getViewModel();
        viewModel.getClass();
        settingsOptions.getClass();
        MutableStateFlow<z00> mutableStateFlow = viewModel.a;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new z00(settingsOptions, !viewModel.c.compare(settingsOptions), viewModel.b.getValue().c)));
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final SettingsDialog show(FragmentManager fragmentManager, SettingsDialogListener settingsDialogListener, SettingsOptions settingsOptions) {
        return INSTANCE.show(fragmentManager, settingsDialogListener, settingsOptions);
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            onRestoreState(savedInstanceState);
        }
        setStyle(2, !uc.a(getResources(), R.dimen.pspdf__electronic_signature_dialog_width, R.dimen.pspdf__electronic_signature_dialog_height) ? R.style.PSPDFKit_Dialog_Light_Panel : R.style.PSPDFKit_Dialog_Light_Panel_Dim);
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        dialogOnCreateDialog.getClass();
        dialogOnCreateDialog.setCancelable(true);
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.pspdfkit.ui.settings.SettingsDialog$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return SettingsDialog.onResume$lambda$0(this.f$0, dialogInterface, i, keyEvent);
                }
            });
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        outState.getClass();
        super.onSaveInstanceState(outState);
        SettingsOptions settingsOptions = this.originalOptions;
        if (settingsOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("originalOptions");
            settingsOptions = null;
        }
        outState.putSerializable(ORIGINAL_OPTIONS_KEY, settingsOptions);
        outState.putSerializable(OPTIONS_KEY, this.currentOptions);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        boolean zA = uc.a(getResources(), R.dimen.pspdf__electronic_signature_dialog_width, R.dimen.pspdf__electronic_signature_dialog_height);
        window.setLayout(!zA ? -1 : (int) getResources().getDimension(R.dimen.pspdf__electronic_signature_dialog_width), zA ? (int) getResources().getDimension(R.dimen.pspdf__electronic_signature_dialog_height) : -1);
        window.setGravity(17);
        dialog.setCanceledOnTouchOutside(false);
        window.addFlags(67108864);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.pspdfkit.ui.settings.SettingsDialog$setupDialog$dialogStyle$1] */
    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int style) {
        z00 value;
        boolean z;
        a10 a10Var;
        dialog.getClass();
        super.setupDialog(dialog, style);
        final ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(requireContext(), f60.b(requireContext(), R.attr.pspdf__settingsDialogStyle, R.style.PSPDFKit_SettingsDialog));
        final ?? r0 = new yq(contextThemeWrapper) { // from class: com.pspdfkit.ui.settings.SettingsDialog$setupDialog$dialogStyle$1
            @Override // com.pspdfkit.internal.wc.a
            public int getBackButtonIcon() {
                return getCloseButtonIcon();
            }
        };
        e10 viewModel = getViewModel();
        SettingsOptions settingsOptions = this.originalOptions;
        if (settingsOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("originalOptions");
            settingsOptions = null;
        }
        SettingsOptions settingsOptions2 = this.currentOptions;
        viewModel.getClass();
        settingsOptions.getClass();
        long screenTimeoutMillis = settingsOptions.getScreenTimeoutMillis();
        if (screenTimeoutMillis != 0 && screenTimeoutMillis != Long.MAX_VALUE) {
            settingsOptions.getVisibleItems().remove(SettingsMenuItemType.SCREEN_AWAKE);
        }
        if (settingsOptions.getScrollMode() == PageScrollMode.CONTINUOUS) {
            settingsOptions.setLayoutMode(PageLayoutMode.AUTO);
        }
        if (settingsOptions2 == null) {
            settingsOptions2 = settingsOptions;
        }
        viewModel.c = settingsOptions;
        MutableStateFlow<z00> mutableStateFlow = viewModel.a;
        do {
            value = mutableStateFlow.getValue();
            z00 value2 = viewModel.b.getValue();
            z = !viewModel.c.compare(settingsOptions2);
            a10Var = new a10(contextThemeWrapper);
            value2.getClass();
        } while (!mutableStateFlow.compareAndSet(value, new z00(settingsOptions2, z, a10Var)));
        dialog.setContentView(y9.a(contextThemeWrapper, ComposableLambdaKt.composableLambdaInstance(337498560, true, new Function2() { // from class: com.pspdfkit.ui.settings.SettingsDialog$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SettingsDialog.setupDialog$lambda$0(this.f$0, r0, (Composer) obj, ((Integer) obj2).intValue());
            }
        })));
    }

    public final void updateListener(SettingsDialogListener listener) {
        listener.getClass();
        this.listener = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SettingsDialog(SettingsDialogListener settingsDialogListener, SettingsOptions settingsOptions) {
        this();
        settingsDialogListener.getClass();
        settingsOptions.getClass();
        this.listener = settingsDialogListener;
        this.originalOptions = settingsOptions;
    }
}
