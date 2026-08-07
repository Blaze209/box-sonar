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
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.capture.R;
import com.box.android.capture.databinding.FragmentIntegratedDocumentScanReviewBinding;
import com.box.android.capture.databinding.FragmentIntegratedDocumentScanReviewBottomBarBinding;
import com.box.android.capture.documentscanning.ReviewScanPageReducer;
import com.box.android.capture.documentscanning.logic.ScannedDocumentPageToGeniusMapperKt;
import com.box.android.capture.documentscanning.presentation.dialogs.FilterDialog;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.RotateTransformation;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.models.DocumentPageFilterType;
import com.box.android.domain.models.DocumentPosition;
import com.box.android.domain.models.ScannedDocumentPage;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.signature.ObjectKey;
import com.geniusscansdk.core.Quadrangle;
import com.geniusscansdk.core.RotationAngle;
import com.geniusscansdk.ui.BorderDetectionImageView;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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

/* JADX INFO: compiled from: IntegratedDocumentScanReviewFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'H\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/box/android/capture/documentscanning/presentation/IntegratedDocumentScanReviewFragment;", "Lcom/box/android/base/presentation/fragments/BoxFragment;", "Lcom/box/android/capture/documentscanning/presentation/dialogs/FilterDialog$FilterDialogListener;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$State;", "Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "getStore", "()Lcom/box/android/cpl/Store;", "binding", "Lcom/box/android/capture/databinding/FragmentIntegratedDocumentScanReviewBinding;", "controlBinding", "Lcom/box/android/capture/databinding/FragmentIntegratedDocumentScanReviewBottomBarBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "supportEdgeToEdge", "updateReviewScan", "scannedPage", "Lcom/box/android/domain/models/ScannedDocumentPage;", "cropImage", "updateDocumentPosition", "initializeBorderDetectionQuad", "updateControls", "isCropping", "", "showFiltersDialog", "filterSelected", "filterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class IntegratedDocumentScanReviewFragment extends Hilt_IntegratedDocumentScanReviewFragment implements FilterDialog.FilterDialogListener {
    public static final int $stable = 8;
    private FragmentIntegratedDocumentScanReviewBinding binding;
    private FragmentIntegratedDocumentScanReviewBottomBarBinding controlBinding;
    private final Store<ReviewScanPageReducer.State, ReviewScanPageReducer.Action> store;

    public IntegratedDocumentScanReviewFragment(Store<ReviewScanPageReducer.State, ReviewScanPageReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    public final Store<ReviewScanPageReducer.State, ReviewScanPageReducer.Action> getStore() {
        return this.store;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), getViewLifecycleOwner(), false, new Function1() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IntegratedDocumentScanReviewFragment.onCreateView$lambda$0(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 2, null);
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBindingInflate = FragmentIntegratedDocumentScanReviewBinding.inflate(getLayoutInflater(), container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentIntegratedDocumentScanReviewBindingInflate, "inflate(...)");
        this.binding = fragmentIntegratedDocumentScanReviewBindingInflate;
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding = null;
        if (fragmentIntegratedDocumentScanReviewBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanReviewBindingInflate = null;
        }
        FragmentIntegratedDocumentScanReviewBottomBarBinding fragmentIntegratedDocumentScanReviewBottomBarBindingBind = FragmentIntegratedDocumentScanReviewBottomBarBinding.bind(fragmentIntegratedDocumentScanReviewBindingInflate.getRoot());
        Intrinsics.checkNotNullExpressionValue(fragmentIntegratedDocumentScanReviewBottomBarBindingBind, "bind(...)");
        this.controlBinding = fragmentIntegratedDocumentScanReviewBottomBarBindingBind;
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding2 = this.binding;
        if (fragmentIntegratedDocumentScanReviewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentIntegratedDocumentScanReviewBinding = fragmentIntegratedDocumentScanReviewBinding2;
        }
        ConstraintLayout root = fragmentIntegratedDocumentScanReviewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(IntegratedDocumentScanReviewFragment integratedDocumentScanReviewFragment, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        integratedDocumentScanReviewFragment.store.send(ReviewScanPageReducer.Action.UserRejectedPhoto.INSTANCE);
        addCallback.setEnabled(false);
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        supportEdgeToEdge();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding = null;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(null), 3, null);
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding2 = this.binding;
        if (fragmentIntegratedDocumentScanReviewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanReviewBinding2 = null;
        }
        BorderDetectionImageView borderDetectionImageView = fragmentIntegratedDocumentScanReviewBinding2.documentScanCropBorderDetection;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        borderDetectionImageView.setOverlayColor(CommonBoxUtil.getColorFromAttribute(contextRequireContext, R.attr.colorAccent));
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding3 = this.binding;
        if (fragmentIntegratedDocumentScanReviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanReviewBinding3 = null;
        }
        fragmentIntegratedDocumentScanReviewBinding3.retakeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IntegratedDocumentScanReviewFragment.onViewCreated$lambda$0(this.f$0, view2);
            }
        });
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding4 = this.binding;
        if (fragmentIntegratedDocumentScanReviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanReviewBinding4 = null;
        }
        fragmentIntegratedDocumentScanReviewBinding4.usePhotoBtn.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IntegratedDocumentScanReviewFragment.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
        FragmentIntegratedDocumentScanReviewBottomBarBinding fragmentIntegratedDocumentScanReviewBottomBarBinding = this.controlBinding;
        if (fragmentIntegratedDocumentScanReviewBottomBarBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlBinding");
            fragmentIntegratedDocumentScanReviewBottomBarBinding = null;
        }
        fragmentIntegratedDocumentScanReviewBottomBarBinding.cropImage.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IntegratedDocumentScanReviewFragment.onViewCreated$lambda$2(this.f$0, view2);
            }
        });
        FragmentIntegratedDocumentScanReviewBottomBarBinding fragmentIntegratedDocumentScanReviewBottomBarBinding2 = this.controlBinding;
        if (fragmentIntegratedDocumentScanReviewBottomBarBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlBinding");
            fragmentIntegratedDocumentScanReviewBottomBarBinding2 = null;
        }
        fragmentIntegratedDocumentScanReviewBottomBarBinding2.colorFilter.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.showFiltersDialog();
            }
        });
        FragmentIntegratedDocumentScanReviewBottomBarBinding fragmentIntegratedDocumentScanReviewBottomBarBinding3 = this.controlBinding;
        if (fragmentIntegratedDocumentScanReviewBottomBarBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controlBinding");
            fragmentIntegratedDocumentScanReviewBottomBarBinding3 = null;
        }
        fragmentIntegratedDocumentScanReviewBottomBarBinding3.rotateImage.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IntegratedDocumentScanReviewFragment.onViewCreated$lambda$4(this.f$0, view2);
            }
        });
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding5 = this.binding;
        if (fragmentIntegratedDocumentScanReviewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentIntegratedDocumentScanReviewBinding = fragmentIntegratedDocumentScanReviewBinding5;
        }
        fragmentIntegratedDocumentScanReviewBinding.cancelCrop.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IntegratedDocumentScanReviewFragment.onViewCreated$lambda$5(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: IntegratedDocumentScanReviewFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$onViewCreated$1", f = "IntegratedDocumentScanReviewFragment.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IntegratedDocumentScanReviewFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: IntegratedDocumentScanReviewFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$onViewCreated$1$1", f = "IntegratedDocumentScanReviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ IntegratedDocumentScanReviewFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01441(IntegratedDocumentScanReviewFragment integratedDocumentScanReviewFragment, Continuation<? super C01441> continuation) {
                super(2, continuation);
                this.this$0 = integratedDocumentScanReviewFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01441(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Store<ReviewScanPageReducer.State, ReviewScanPageReducer.Action> store = this.this$0.getStore();
                C01451 c01451 = new PropertyReference1Impl() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment.onViewCreated.1.1.1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return ((ReviewScanPageReducer.State) obj2).getScannedPage();
                    }
                };
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.this$0);
                final IntegratedDocumentScanReviewFragment integratedDocumentScanReviewFragment = this.this$0;
                StoreKt.observe(store, c01451, lifecycleScope, new Function1() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$onViewCreated$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return IntegratedDocumentScanReviewFragment.AnonymousClass1.C01441.invokeSuspend$lambda$0(integratedDocumentScanReviewFragment, (ScannedDocumentPage) obj2);
                    }
                });
                Store<ReviewScanPageReducer.State, ReviewScanPageReducer.Action> store2 = this.this$0.getStore();
                AnonymousClass3 anonymousClass3 = new PropertyReference1Impl() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment.onViewCreated.1.1.3
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj2) {
                        return Boolean.valueOf(((ReviewScanPageReducer.State) obj2).isCropping());
                    }
                };
                LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(this.this$0);
                final IntegratedDocumentScanReviewFragment integratedDocumentScanReviewFragment2 = this.this$0;
                StoreKt.observeAndReturnState(store2, anonymousClass3, lifecycleScope2, new Function1() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$onViewCreated$1$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return IntegratedDocumentScanReviewFragment.AnonymousClass1.C01441.invokeSuspend$lambda$1(integratedDocumentScanReviewFragment2, (ReviewScanPageReducer.State) obj2);
                    }
                });
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0(IntegratedDocumentScanReviewFragment integratedDocumentScanReviewFragment, ScannedDocumentPage scannedDocumentPage) {
                integratedDocumentScanReviewFragment.updateReviewScan(scannedDocumentPage);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$1(IntegratedDocumentScanReviewFragment integratedDocumentScanReviewFragment, ReviewScanPageReducer.State state) {
                if (state.isCropping()) {
                    integratedDocumentScanReviewFragment.cropImage(state.getScannedPage());
                } else {
                    integratedDocumentScanReviewFragment.updateReviewScan(state.getScannedPage());
                }
                integratedDocumentScanReviewFragment.updateControls(state.isCropping());
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LifecycleOwner viewLifecycleOwner = IntegratedDocumentScanReviewFragment.this.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.CREATED, new C01441(IntegratedDocumentScanReviewFragment.this, null), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(IntegratedDocumentScanReviewFragment integratedDocumentScanReviewFragment, View view) {
        integratedDocumentScanReviewFragment.store.send(ReviewScanPageReducer.Action.UserRejectedPhoto.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(IntegratedDocumentScanReviewFragment integratedDocumentScanReviewFragment, View view) {
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding = integratedDocumentScanReviewFragment.binding;
        if (fragmentIntegratedDocumentScanReviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanReviewBinding = null;
        }
        Quadrangle quad = fragmentIntegratedDocumentScanReviewBinding.documentScanCropBorderDetection.getQuad();
        if (quad != null) {
            integratedDocumentScanReviewFragment.store.send(new ReviewScanPageReducer.Action.UserAcceptedPhoto(ScannedDocumentPageToGeniusMapperKt.toDocumentPosition(quad)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(IntegratedDocumentScanReviewFragment integratedDocumentScanReviewFragment, View view) {
        integratedDocumentScanReviewFragment.store.send(ReviewScanPageReducer.Action.CropImage.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(IntegratedDocumentScanReviewFragment integratedDocumentScanReviewFragment, View view) {
        integratedDocumentScanReviewFragment.store.send(ReviewScanPageReducer.Action.RotateImage.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(IntegratedDocumentScanReviewFragment integratedDocumentScanReviewFragment, View view) {
        integratedDocumentScanReviewFragment.store.send(ReviewScanPageReducer.Action.CancelCropping.INSTANCE);
    }

    private final void supportEdgeToEdge() {
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding = this.binding;
        if (fragmentIntegratedDocumentScanReviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanReviewBinding = null;
        }
        ViewCompat.setOnApplyWindowInsetsListener(fragmentIntegratedDocumentScanReviewBinding.getRoot(), new OnApplyWindowInsetsListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return IntegratedDocumentScanReviewFragment.supportEdgeToEdge$lambda$0(this.f$0, view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat supportEdgeToEdge$lambda$0(IntegratedDocumentScanReviewFragment integratedDocumentScanReviewFragment, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int i = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding = integratedDocumentScanReviewFragment.binding;
        if (fragmentIntegratedDocumentScanReviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanReviewBinding = null;
        }
        ConstraintLayout bottomBar = fragmentIntegratedDocumentScanReviewBinding.bottomBar;
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
    public final void updateReviewScan(ScannedDocumentPage scannedPage) {
        RequestBuilder requestBuilderTransform = Glide.with(requireContext()).load(scannedPage.getEnhancedImagePath()).signature(new ObjectKey(Integer.valueOf(scannedPage.getVersion()))).fitCenter().transform(new RotateTransformation(requireContext(), scannedPage.getRotationAngle()));
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding = this.binding;
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding2 = null;
        if (fragmentIntegratedDocumentScanReviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanReviewBinding = null;
        }
        requestBuilderTransform.into(fragmentIntegratedDocumentScanReviewBinding.documentScanBorderDetection);
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding3 = this.binding;
        if (fragmentIntegratedDocumentScanReviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentIntegratedDocumentScanReviewBinding2 = fragmentIntegratedDocumentScanReviewBinding3;
        }
        fragmentIntegratedDocumentScanReviewBinding2.documentScanCropBorderDetection.setVisibility(8);
        initializeBorderDetectionQuad(scannedPage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cropImage(final ScannedDocumentPage scannedPage) {
        RequestBuilder requestBuilderTransform = Glide.with(requireContext()).load(scannedPage.getOriginalImagePath()).signature(new ObjectKey(Integer.valueOf(scannedPage.getVersion()))).fitCenter().transform(new RotateTransformation(requireContext(), scannedPage.getRotationAngle()));
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding = this.binding;
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding2 = null;
        if (fragmentIntegratedDocumentScanReviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanReviewBinding = null;
        }
        requestBuilderTransform.into(fragmentIntegratedDocumentScanReviewBinding.documentScanCropBorderDetection);
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding3 = this.binding;
        if (fragmentIntegratedDocumentScanReviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanReviewBinding3 = null;
        }
        fragmentIntegratedDocumentScanReviewBinding3.documentScanCropBorderDetection.setVisibility(0);
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding4 = this.binding;
        if (fragmentIntegratedDocumentScanReviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentIntegratedDocumentScanReviewBinding2 = fragmentIntegratedDocumentScanReviewBinding4;
        }
        fragmentIntegratedDocumentScanReviewBinding2.doneCrop.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.IntegratedDocumentScanReviewFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.updateDocumentPosition(scannedPage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDocumentPosition(ScannedDocumentPage scannedPage) {
        RotationAngle rotationAngleFromDegrees = RotationAngle.fromDegrees(-scannedPage.getRotationAngle());
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding = this.binding;
        if (fragmentIntegratedDocumentScanReviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanReviewBinding = null;
        }
        Quadrangle quad = fragmentIntegratedDocumentScanReviewBinding.documentScanCropBorderDetection.getQuad();
        if (quad != null) {
            Store<ReviewScanPageReducer.State, ReviewScanPageReducer.Action> store = this.store;
            Intrinsics.checkNotNull(rotationAngleFromDegrees);
            store.send(new ReviewScanPageReducer.Action.Cropped(ScannedDocumentPageToGeniusMapperKt.toDocumentPosition(quad.rotate(rotationAngleFromDegrees))));
        }
    }

    private final void initializeBorderDetectionQuad(ScannedDocumentPage scannedPage) {
        Quadrangle quadrangle;
        RotationAngle rotationAngleFromDegrees = RotationAngle.fromDegrees(scannedPage.getRotationAngle());
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding = this.binding;
        Quadrangle quadrangleRotate = null;
        if (fragmentIntegratedDocumentScanReviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanReviewBinding = null;
        }
        BorderDetectionImageView borderDetectionImageView = fragmentIntegratedDocumentScanReviewBinding.documentScanCropBorderDetection;
        DocumentPosition quadrangle2 = scannedPage.getQuadrangle();
        if (quadrangle2 != null && (quadrangle = ScannedDocumentPageToGeniusMapperKt.toQuadrangle(quadrangle2)) != null) {
            Intrinsics.checkNotNull(rotationAngleFromDegrees);
            quadrangleRotate = quadrangle.rotate(rotationAngleFromDegrees);
        }
        borderDetectionImageView.setQuad(quadrangleRotate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateControls(boolean isCropping) {
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding = this.binding;
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding2 = null;
        if (fragmentIntegratedDocumentScanReviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanReviewBinding = null;
        }
        fragmentIntegratedDocumentScanReviewBinding.documentScanReviewEditBar.setVisibility(isCropping ? 8 : 0);
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding3 = this.binding;
        if (fragmentIntegratedDocumentScanReviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentIntegratedDocumentScanReviewBinding3 = null;
        }
        fragmentIntegratedDocumentScanReviewBinding3.croppingButtons.setVisibility(isCropping ? 0 : 4);
        FragmentIntegratedDocumentScanReviewBinding fragmentIntegratedDocumentScanReviewBinding4 = this.binding;
        if (fragmentIntegratedDocumentScanReviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentIntegratedDocumentScanReviewBinding2 = fragmentIntegratedDocumentScanReviewBinding4;
        }
        fragmentIntegratedDocumentScanReviewBinding2.reviewButtons.setVisibility(isCropping ? 4 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFiltersDialog() {
        new FilterDialog(this.store.getState().getValue().getScannedPage().getFilterType()).show(getChildFragmentManager(), (String) null);
    }

    @Override // com.box.android.capture.documentscanning.presentation.dialogs.FilterDialog.FilterDialogListener
    public void filterSelected(DocumentPageFilterType filterType) {
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        this.store.send(new ReviewScanPageReducer.Action.FilterImage(filterType));
    }
}
