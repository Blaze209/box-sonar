package com.box.android.capture.documentscanning.presentation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.box.android.base.presentation.fragments.AlertDialogFragment;
import com.box.android.base.presentation.fragments.AlertDialogFragmentListener;
import com.box.android.capture.R;
import com.box.android.capture.databinding.FragmentDocumentScanEditBinding;
import com.box.android.capture.databinding.FragmentDocumentScanEditBottomBarBinding;
import com.box.android.capture.documentscanning.EditScanPageReducer;
import com.box.android.capture.documentscanning.logic.ScannedDocumentPageToGeniusMapperKt;
import com.box.android.capture.documentscanning.presentation.adapter.ScannedPagesAdapter;
import com.box.android.capture.documentscanning.presentation.dialogs.FilterDialog;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.RotateTransformation;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.models.DocumentPageFilterType;
import com.box.android.domain.models.DocumentPosition;
import com.box.android.domain.models.ScannedDocumentPage;
import com.bumptech.glide.Glide;
import com.bumptech.glide.signature.ObjectKey;
import com.geniusscansdk.core.Quadrangle;
import com.geniusscansdk.core.RotationAngle;
import com.geniusscansdk.ui.BorderDetectionImageView;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IntegratedDocumentScanEditFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u0003:\u00017B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020!H\u0002J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020!2\u0006\u0010&\u001a\u00020'H\u0002J\u0012\u0010-\u001a\u00020!2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020!H\u0002J\b\u00104\u001a\u00020!H\u0002J\u0010\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\u0006H\u0002R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u00068"}, d2 = {"Lcom/box/android/capture/documentscanning/presentation/IntegratedDocumentScanEditFragment;", "Lcom/box/android/base/presentation/fragments/BoxFragment;", "Lcom/box/android/base/presentation/fragments/AlertDialogFragmentListener;", "Lcom/box/android/capture/documentscanning/presentation/dialogs/FilterDialog$FilterDialogListener;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$State;", "Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "getStore", "()Lcom/box/android/cpl/Store;", "binding", "Lcom/box/android/capture/databinding/FragmentDocumentScanEditBinding;", "getBinding", "()Lcom/box/android/capture/databinding/FragmentDocumentScanEditBinding;", "setBinding", "(Lcom/box/android/capture/databinding/FragmentDocumentScanEditBinding;)V", "controlBinding", "Lcom/box/android/capture/databinding/FragmentDocumentScanEditBottomBarBinding;", "getControlBinding", "()Lcom/box/android/capture/databinding/FragmentDocumentScanEditBottomBarBinding;", "setControlBinding", "(Lcom/box/android/capture/databinding/FragmentDocumentScanEditBottomBarBinding;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupUI", "supportEdgeToEdge", "openCropImageScreen", "scannedPage", "Lcom/box/android/domain/models/ScannedDocumentPage;", "closeCropImageScreen", "updateControls", "isCropping", "", "updateDocumentPosition", "onAlertDialogFragmentPositiveButton", "tag", "", "filterSelected", "filterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "showDiscardImageConfirmationDialog", "showFiltersDialog", "updatePageStatus", "state", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class IntegratedDocumentScanEditFragment extends Hilt_IntegratedDocumentScanEditFragment implements AlertDialogFragmentListener, FilterDialog.FilterDialogListener {
    private static final String DISCARD_IMAGE_CONFIRMATION_DIALOG_TAG = "document_scanning_discard_image_confirmation_dialog";
    public FragmentDocumentScanEditBinding binding;
    public FragmentDocumentScanEditBottomBarBinding controlBinding;
    private final Store<EditScanPageReducer.State, EditScanPageReducer.Action> store;
    public static final int $stable = 8;

    public IntegratedDocumentScanEditFragment(Store<EditScanPageReducer.State, EditScanPageReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    @Override // com.box.android.base.presentation.fragments.AlertDialogFragmentListener
    public /* bridge */ void onAlertDialogFragmentDismissed(String str) {
        super.onAlertDialogFragmentDismissed(str);
    }

    @Override // com.box.android.base.presentation.fragments.AlertDialogFragmentListener
    public /* bridge */ void onAlertDialogFragmentNegativeButton(String str) {
        super.onAlertDialogFragmentNegativeButton(str);
    }

    @Override // com.box.android.base.presentation.fragments.AlertDialogFragmentListener
    public /* bridge */ void onAlertDialogFragmentNeutralButton(String str) {
        super.onAlertDialogFragmentNeutralButton(str);
    }

    public final Store<EditScanPageReducer.State, EditScanPageReducer.Action> getStore() {
        return this.store;
    }

    public final FragmentDocumentScanEditBinding getBinding() {
        FragmentDocumentScanEditBinding fragmentDocumentScanEditBinding = this.binding;
        if (fragmentDocumentScanEditBinding != null) {
            return fragmentDocumentScanEditBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentDocumentScanEditBinding fragmentDocumentScanEditBinding) {
        Intrinsics.checkNotNullParameter(fragmentDocumentScanEditBinding, "<set-?>");
        this.binding = fragmentDocumentScanEditBinding;
    }

    public final FragmentDocumentScanEditBottomBarBinding getControlBinding() {
        FragmentDocumentScanEditBottomBarBinding fragmentDocumentScanEditBottomBarBinding = this.controlBinding;
        if (fragmentDocumentScanEditBottomBarBinding != null) {
            return fragmentDocumentScanEditBottomBarBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("controlBinding");
        return null;
    }

    public final void setControlBinding(FragmentDocumentScanEditBottomBarBinding fragmentDocumentScanEditBottomBarBinding) {
        Intrinsics.checkNotNullParameter(fragmentDocumentScanEditBottomBarBinding, "<set-?>");
        this.controlBinding = fragmentDocumentScanEditBottomBarBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), getViewLifecycleOwner(), false, new Function1() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntegratedDocumentScanEditFragment.onCreateView$lambda$0(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 2, null);
        FragmentDocumentScanEditBinding fragmentDocumentScanEditBindingInflate = FragmentDocumentScanEditBinding.inflate(getLayoutInflater(), container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentDocumentScanEditBindingInflate, "inflate(...)");
        setBinding(fragmentDocumentScanEditBindingInflate);
        FragmentDocumentScanEditBottomBarBinding fragmentDocumentScanEditBottomBarBindingBind = FragmentDocumentScanEditBottomBarBinding.bind(getBinding().root);
        Intrinsics.checkNotNullExpressionValue(fragmentDocumentScanEditBottomBarBindingBind, "bind(...)");
        setControlBinding(fragmentDocumentScanEditBottomBarBindingBind);
        ConstraintLayout root = getBinding().root;
        Intrinsics.checkNotNullExpressionValue(root, "root");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(IntegratedDocumentScanEditFragment integratedDocumentScanEditFragment, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        if (integratedDocumentScanEditFragment.store.getState().getValue().isCropping()) {
            integratedDocumentScanEditFragment.store.send(EditScanPageReducer.Action.CancelCropping.INSTANCE);
        } else {
            integratedDocumentScanEditFragment.store.send(EditScanPageReducer.Action.FinishEditing.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupUI();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(null), 3, null);
        this.store.send(EditScanPageReducer.Action.Initialize.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: IntegratedDocumentScanEditFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$onViewCreated$1", f = "IntegratedDocumentScanEditFragment.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IntegratedDocumentScanEditFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: IntegratedDocumentScanEditFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$onViewCreated$1$1", f = "IntegratedDocumentScanEditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ IntegratedDocumentScanEditFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01411(IntegratedDocumentScanEditFragment integratedDocumentScanEditFragment, Continuation<? super C01411> continuation) {
                super(2, continuation);
                this.this$0 = integratedDocumentScanEditFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01411(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Store<EditScanPageReducer.State, EditScanPageReducer.Action> store = this.this$0.getStore();
                final IntegratedDocumentScanEditFragment integratedDocumentScanEditFragment = this.this$0;
                IntegratedDocumentScanEditFragment integratedDocumentScanEditFragment2 = integratedDocumentScanEditFragment;
                StoreKt.observeAndReturnState(store, new PropertyReference1Impl() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$onViewCreated$1$1$1$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return ((EditScanPageReducer.State) obj2).getScannedPages();
                    }
                }, LifecycleOwnerKt.getLifecycleScope(integratedDocumentScanEditFragment2), new Function1() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$onViewCreated$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return IntegratedDocumentScanEditFragment.AnonymousClass1.C01411.invokeSuspend$lambda$0$0(integratedDocumentScanEditFragment, (EditScanPageReducer.State) obj2);
                    }
                });
                StoreKt.observeAndReturnState(store, new PropertyReference1Impl() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$onViewCreated$1$1$1$3
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return Integer.valueOf(((EditScanPageReducer.State) obj2).getCurrentlySelectedPage());
                    }
                }, LifecycleOwnerKt.getLifecycleScope(integratedDocumentScanEditFragment2), new Function1() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$onViewCreated$1$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return IntegratedDocumentScanEditFragment.AnonymousClass1.C01411.invokeSuspend$lambda$0$1(integratedDocumentScanEditFragment, (EditScanPageReducer.State) obj2);
                    }
                });
                StoreKt.observeAndReturnState(store, new PropertyReference1Impl() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$onViewCreated$1$1$1$5
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return Boolean.valueOf(((EditScanPageReducer.State) obj2).isCropping());
                    }
                }, LifecycleOwnerKt.getLifecycleScope(integratedDocumentScanEditFragment2), new Function1() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$onViewCreated$1$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return IntegratedDocumentScanEditFragment.AnonymousClass1.C01411.invokeSuspend$lambda$0$2(integratedDocumentScanEditFragment, (EditScanPageReducer.State) obj2);
                    }
                });
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0$0(IntegratedDocumentScanEditFragment integratedDocumentScanEditFragment, EditScanPageReducer.State state) {
                RecyclerView.Adapter adapter = integratedDocumentScanEditFragment.getBinding().scannedPages.getAdapter();
                ScannedPagesAdapter scannedPagesAdapter = adapter instanceof ScannedPagesAdapter ? (ScannedPagesAdapter) adapter : null;
                if (scannedPagesAdapter != null) {
                    scannedPagesAdapter.updateItems(state.getScannedPages());
                }
                integratedDocumentScanEditFragment.updatePageStatus(state);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0$1(IntegratedDocumentScanEditFragment integratedDocumentScanEditFragment, EditScanPageReducer.State state) {
                integratedDocumentScanEditFragment.updatePageStatus(state);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0$2(IntegratedDocumentScanEditFragment integratedDocumentScanEditFragment, EditScanPageReducer.State state) {
                ScannedDocumentPage currentPage = state.getCurrentPage();
                if (state.isCropping()) {
                    integratedDocumentScanEditFragment.openCropImageScreen(currentPage);
                } else {
                    integratedDocumentScanEditFragment.closeCropImageScreen();
                }
                integratedDocumentScanEditFragment.updateControls(state.isCropping());
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = IntegratedDocumentScanEditFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.CREATED, new C01411(IntegratedDocumentScanEditFragment.this, null), this) == coroutine_suspended) {
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

    private final void setupUI() {
        getBinding().scannedPages.setAdapter(new ScannedPagesAdapter(CollectionsKt.emptyList()));
        getBinding().scannedPages.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment.setupUI.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                IntegratedDocumentScanEditFragment.this.getStore().send(new EditScanPageReducer.Action.PageSelected(position));
            }
        });
        BorderDetectionImageView borderDetectionImageView = getBinding().borderDetectionImage;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        borderDetectionImageView.setOverlayColor(CommonBoxUtil.getColorFromAttribute(contextRequireContext, R.attr.colorAccent));
        getControlBinding().rotateImage.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntegratedDocumentScanEditFragment.setupUI$lambda$0(this.f$0, view);
            }
        });
        getControlBinding().deleteImage.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showDiscardImageConfirmationDialog();
            }
        });
        getControlBinding().colorFilter.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showFiltersDialog();
            }
        });
        getControlBinding().cropImage.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntegratedDocumentScanEditFragment.setupUI$lambda$3(this.f$0, view);
            }
        });
        getControlBinding().editDoneBtn.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntegratedDocumentScanEditFragment.setupUI$lambda$4(this.f$0, view);
            }
        });
        getControlBinding().cancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntegratedDocumentScanEditFragment.setupUI$lambda$5(this.f$0, view);
            }
        });
        supportEdgeToEdge();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$0(IntegratedDocumentScanEditFragment integratedDocumentScanEditFragment, View view) {
        integratedDocumentScanEditFragment.store.send(EditScanPageReducer.Action.RotateImage.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$3(IntegratedDocumentScanEditFragment integratedDocumentScanEditFragment, View view) {
        integratedDocumentScanEditFragment.store.send(EditScanPageReducer.Action.CropImage.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$4(IntegratedDocumentScanEditFragment integratedDocumentScanEditFragment, View view) {
        integratedDocumentScanEditFragment.store.send(EditScanPageReducer.Action.FinishEditing.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$5(IntegratedDocumentScanEditFragment integratedDocumentScanEditFragment, View view) {
        integratedDocumentScanEditFragment.store.send(EditScanPageReducer.Action.CancelCropping.INSTANCE);
    }

    private final void supportEdgeToEdge() {
        ViewCompat.setOnApplyWindowInsetsListener(getControlBinding().bottomBar, new OnApplyWindowInsetsListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return IntegratedDocumentScanEditFragment.supportEdgeToEdge$lambda$0(this.f$0, view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat supportEdgeToEdge$lambda$0(IntegratedDocumentScanEditFragment integratedDocumentScanEditFragment, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int i = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
        ConstraintLayout bottomBar = integratedDocumentScanEditFragment.getControlBinding().bottomBar;
        Intrinsics.checkNotNullExpressionValue(bottomBar, "bottomBar");
        ConstraintLayout constraintLayout = bottomBar;
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = i;
            constraintLayout.setLayoutParams(marginLayoutParams);
            return WindowInsetsCompat.CONSUMED;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openCropImageScreen(final ScannedDocumentPage scannedPage) {
        Quadrangle quadrangleRotate;
        Quadrangle quadrangle;
        Glide.with(requireContext()).load(scannedPage.getOriginalImagePath()).signature(new ObjectKey(Integer.valueOf(scannedPage.getVersion()))).fitCenter().transform(new RotateTransformation(requireContext(), scannedPage.getRotationAngle())).into(getBinding().borderDetectionImage);
        RotationAngle rotationAngleFromDegrees = RotationAngle.fromDegrees(scannedPage.getRotationAngle());
        BorderDetectionImageView borderDetectionImageView = getBinding().borderDetectionImage;
        DocumentPosition quadrangle2 = scannedPage.getQuadrangle();
        if (quadrangle2 == null || (quadrangle = ScannedDocumentPageToGeniusMapperKt.toQuadrangle(quadrangle2)) == null) {
            quadrangleRotate = null;
        } else {
            Intrinsics.checkNotNull(rotationAngleFromDegrees);
            quadrangleRotate = quadrangle.rotate(rotationAngleFromDegrees);
        }
        borderDetectionImageView.setQuad(quadrangleRotate);
        getBinding().borderDetectionImage.setVisibility(0);
        getControlBinding().cropImageDoneButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanEditFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.updateDocumentPosition(scannedPage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeCropImageScreen() {
        getBinding().borderDetectionImage.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateControls(boolean isCropping) {
        getControlBinding().cropBar.setVisibility(isCropping ? 0 : 4);
        getControlBinding().editButtons.setVisibility(isCropping ? 4 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDocumentPosition(ScannedDocumentPage scannedPage) {
        RotationAngle rotationAngleFromDegrees = RotationAngle.fromDegrees(-scannedPage.getRotationAngle());
        Quadrangle quad = getBinding().borderDetectionImage.getQuad();
        if (quad != null) {
            Store<EditScanPageReducer.State, EditScanPageReducer.Action> store = this.store;
            Intrinsics.checkNotNull(rotationAngleFromDegrees);
            store.send(new EditScanPageReducer.Action.CroppedImage(ScannedDocumentPageToGeniusMapperKt.toDocumentPosition(quad.rotate(rotationAngleFromDegrees))));
        }
    }

    @Override // com.box.android.base.presentation.fragments.AlertDialogFragmentListener
    public void onAlertDialogFragmentPositiveButton(String tag) {
        if (Intrinsics.areEqual(tag, DISCARD_IMAGE_CONFIRMATION_DIALOG_TAG)) {
            this.store.send(EditScanPageReducer.Action.DeletePage.INSTANCE);
        }
    }

    @Override // com.box.android.capture.documentscanning.presentation.dialogs.FilterDialog.FilterDialogListener
    public void filterSelected(DocumentPageFilterType filterType) {
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        this.store.send(new EditScanPageReducer.Action.FilterImage(filterType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDiscardImageConfirmationDialog() {
        new AlertDialogFragment().setTitle(R.string.document_scan_confirm_delete_title).setMessage(R.string.document_scan_confirm_delete_body).setPositiveButtonId(R.string.document_scan_confirm_delete).setNegativeButtonId(R.string.alert_dialog_cancel).show(getChildFragmentManager(), DISCARD_IMAGE_CONFIRMATION_DIALOG_TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFiltersDialog() {
        new FilterDialog(this.store.getState().getValue().getScannedPages().get(this.store.getState().getValue().getCurrentlySelectedPage()).getFilterType()).show(getChildFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePageStatus(EditScanPageReducer.State state) {
        getBinding().pageCounter.pagerNumberLabelText.setText(getString(R.string.box_previewsdk_page_overlay, Integer.valueOf(state.getCurrentlySelectedPage() + 1), Integer.valueOf(state.getScannedPages().size())));
    }
}
