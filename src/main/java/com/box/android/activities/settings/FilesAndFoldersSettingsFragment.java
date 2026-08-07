package com.box.android.activities.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.browse.databinding.GenericComposeViewBinding;
import com.box.android.cpl.Store;
import com.box.android.preview.filesandfolders.FilesAndFoldersReducer;
import com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesAndFoldersSettingsFragment.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/activities/settings/FilesAndFoldersSettingsFragment;", "Landroidx/fragment/app/Fragment;", "storeFactory", "Lcom/box/android/activities/settings/IFilesAndFoldersSettingsStoreFactory;", "<init>", "(Lcom/box/android/activities/settings/IFilesAndFoldersSettingsStoreFactory;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$State;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilesAndFoldersSettingsFragment extends Fragment {
    public static final int $stable = 8;
    private Store<FilesAndFoldersReducer.State, FilesAndFoldersReducer.Action> store;
    private final IFilesAndFoldersSettingsStoreFactory storeFactory;

    public FilesAndFoldersSettingsFragment(IFilesAndFoldersSettingsStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        this.storeFactory = storeFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FilesAndFoldersSettingsFragment filesAndFoldersSettingsFragment = this;
        this.store = this.storeFactory.createStore(LifecycleOwnerKt.getLifecycleScope(filesAndFoldersSettingsFragment));
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), filesAndFoldersSettingsFragment, false, new Function1() { // from class: com.box.android.activities.settings.FilesAndFoldersSettingsFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FilesAndFoldersSettingsFragment.onCreate$lambda$0(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(FilesAndFoldersSettingsFragment filesAndFoldersSettingsFragment, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        Store<FilesAndFoldersReducer.State, FilesAndFoldersReducer.Action> store = filesAndFoldersSettingsFragment.store;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("store");
            store = null;
        }
        store.send(FilesAndFoldersReducer.Action.CloseScreen.INSTANCE);
        addCallback.setEnabled(false);
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        GenericComposeViewBinding genericComposeViewBindingInflate = GenericComposeViewBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(genericComposeViewBindingInflate, "inflate(...)");
        ComposeView composeView = genericComposeViewBindingInflate.composeView;
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-611457779, true, new Function2() { // from class: com.box.android.activities.settings.FilesAndFoldersSettingsFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FilesAndFoldersSettingsFragment.onCreateView$lambda$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        ConstraintLayout root = genericComposeViewBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(final FilesAndFoldersSettingsFragment filesAndFoldersSettingsFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C37@1693L493,37@1684L502:FilesAndFoldersSettingsFragment.kt#k04f05");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-611457779, i, -1, "com.box.android.activities.settings.FilesAndFoldersSettingsFragment.onCreateView.<anonymous>.<anonymous> (FilesAndFoldersSettingsFragment.kt:37)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(-1159754270, true, new Function2() { // from class: com.box.android.activities.settings.FilesAndFoldersSettingsFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesAndFoldersSettingsFragment.onCreateView$lambda$0$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0(final FilesAndFoldersSettingsFragment filesAndFoldersSettingsFragment, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C40@1823L323,38@1715L453:FilesAndFoldersSettingsFragment.kt#k04f05");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1159754270, i, -1, "com.box.android.activities.settings.FilesAndFoldersSettingsFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (FilesAndFoldersSettingsFragment.kt:38)");
            }
            Store<FilesAndFoldersReducer.State, FilesAndFoldersReducer.Action> store = filesAndFoldersSettingsFragment.store;
            if (store == null) {
                Intrinsics.throwUninitializedPropertyAccessException("store");
                store = null;
            }
            ComposerKt.sourceInformationMarkerStart(composer, -2127319323, "CC(remember):FilesAndFoldersSettingsFragment.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(filesAndFoldersSettingsFragment);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.activities.settings.FilesAndFoldersSettingsFragment$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesAndFoldersSettingsFragment.onCreateView$lambda$0$0$0$0$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FilesAndFoldersSettingsScreenKt.FilesAndFoldersSettingsScreen(store, (Function0) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0$0(FilesAndFoldersSettingsFragment filesAndFoldersSettingsFragment) {
        Bundle arguments = filesAndFoldersSettingsFragment.getArguments();
        if (arguments != null && arguments.getBoolean(FilesAndFoldersSettingsFragmentKt.SHOULD_FINISH_PARENT_ACTIVITY_KEY)) {
            FragmentActivity activity = filesAndFoldersSettingsFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        } else {
            filesAndFoldersSettingsFragment.getParentFragmentManager().popBackStackImmediate();
        }
        return Unit.INSTANCE;
    }
}
