package com.box.android.capture.documentscanning.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity;
import com.box.android.base.presentation.fragments.AlertDialogFragment;
import com.box.android.base.presentation.fragments.AlertDialogFragmentListener;
import com.box.android.capture.R;
import com.box.android.capture.documentscanning.DocumentProcessingState;
import com.box.android.capture.documentscanning.DocumentScanningReducer;
import com.box.android.capture.documentscanning.EditScanPageReducer;
import com.box.android.capture.documentscanning.ReviewScanPageReducer;
import com.box.android.capture.documentscanning.ScanPageReducer;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.utilities.CoroutineExtensionsKt;
import com.pspdfkit.BuildConfig;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.KClassesJvm;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: DocumentScanningHostFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\u0012\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0002J\u0012\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010(\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010$H\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\b¨\u0006*"}, d2 = {"Lcom/box/android/capture/documentscanning/presentation/DocumentScanningHostFragment;", "Lcom/box/android/base/presentation/fragments/BoxFragment;", "Lcom/box/android/base/presentation/fragments/AlertDialogFragmentListener;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$State;", "Lcom/box/android/capture/documentscanning/DocumentScanningReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "getStore", "()Lcom/box/android/cpl/Store;", "scanPageChildStore", "Lcom/box/android/capture/documentscanning/ScanPageReducer$State;", "Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;", "getScanPageChildStore", "setScanPageChildStore", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "replaceFragment", BuildConfig.FLAVOR, "Landroidx/fragment/app/Fragment;", "updateProcessingState", "processingState", "Lcom/box/android/capture/documentscanning/DocumentProcessingState;", "showLicenseExpiredDialog", "showErrorDialog", "message", "", "showSkipOcrDialog", "onAlertDialogFragmentDismissed", "tag", "onAlertDialogFragmentPositiveButton", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class DocumentScanningHostFragment extends Hilt_DocumentScanningHostFragment implements AlertDialogFragmentListener {
    private static final String ERROR_DIALOG_TAG = "document_scanning_error_dialog";
    private static final String LICENSE_EXPIRATION_DIALOG_TAG = "document_scanning_license_expiration_dialog";
    private static final String LOG_TAG = "DocumentScanningHostFragment";
    private static final String OCR_ERROR_DIALOG_TAG = "ocr_missing_error_dialog_tag";
    public Store<ScanPageReducer.State, ScanPageReducer.Action> scanPageChildStore;
    private final Store<DocumentScanningReducer.State, DocumentScanningReducer.Action> store;
    public static final int $stable = 8;

    public DocumentScanningHostFragment(Store<DocumentScanningReducer.State, DocumentScanningReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    @Override // com.box.android.base.presentation.fragments.AlertDialogFragmentListener
    public /* bridge */ void onAlertDialogFragmentNegativeButton(String str) {
        super.onAlertDialogFragmentNegativeButton(str);
    }

    @Override // com.box.android.base.presentation.fragments.AlertDialogFragmentListener
    public /* bridge */ void onAlertDialogFragmentNeutralButton(String str) {
        super.onAlertDialogFragmentNeutralButton(str);
    }

    public final Store<DocumentScanningReducer.State, DocumentScanningReducer.Action> getStore() {
        return this.store;
    }

    public final Store<ScanPageReducer.State, ScanPageReducer.Action> getScanPageChildStore() {
        Store<ScanPageReducer.State, ScanPageReducer.Action> store = this.scanPageChildStore;
        if (store != null) {
            return store;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scanPageChildStore");
        return null;
    }

    public final void setScanPageChildStore(Store<ScanPageReducer.State, ScanPageReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "<set-?>");
        this.scanPageChildStore = store;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.layout_container, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Store<DocumentScanningReducer.State, DocumentScanningReducer.Action> store = this.store;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DocumentScanningReducer.State.LicenseExpired.class);
        DocumentScanningHostFragment documentScanningHostFragment = this;
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(documentScanningHostFragment);
        DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$1 documentScanningHostFragment$onViewCreated$$inlined$switchScope$1 = new Function1<DocumentScanningReducer.Action, DocumentScanningReducer.Action>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$1
            @Override // kotlin.jvm.functions.Function1
            public final DocumentScanningReducer.Action invoke(DocumentScanningReducer.Action action) {
                return action;
            }
        };
        final Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(store.getState(), new Function2<DocumentScanningReducer.State, DocumentScanningReducer.State, Boolean>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$2
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(DocumentScanningReducer.State old, DocumentScanningReducer.State state) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(state, "new");
                return Boolean.valueOf((old instanceof DocumentScanningReducer.State.LicenseExpired) && (state instanceof DocumentScanningReducer.State.LicenseExpired));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<DocumentScanningReducer.State.LicenseExpired>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$3

            /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$switchScope$2$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$3$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$3$2", f = "DocumentScanningHostFragment.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        DocumentScanningReducer.State.LicenseExpired licenseExpired = (DocumentScanningReducer.State.LicenseExpired) (!(obj instanceof DocumentScanningReducer.State.LicenseExpired) ? null : obj);
                        if (licenseExpired != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(licenseExpired);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(licenseExpired, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super DocumentScanningReducer.State.LicenseExpired> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$4(store, orCreateKotlinClass, documentScanningHostFragment$onViewCreated$$inlined$switchScope$1, null, this)), StoreKt.registerCoroutineScope(store, CoroutineExtensionsKt.getChildScope(lifecycleScope), KClassesJvm.getJvmName(orCreateKotlinClass)));
        Store<DocumentScanningReducer.State, DocumentScanningReducer.Action> store2 = this.store;
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(DocumentScanningReducer.State.PermissionRequired.class);
        LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(documentScanningHostFragment);
        DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$5 documentScanningHostFragment$onViewCreated$$inlined$switchScope$5 = new Function1<DocumentScanningReducer.Action, DocumentScanningReducer.Action>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$5
            @Override // kotlin.jvm.functions.Function1
            public final DocumentScanningReducer.Action invoke(DocumentScanningReducer.Action action) {
                return action;
            }
        };
        final Flow flowDistinctUntilChanged2 = FlowKt.distinctUntilChanged(store2.getState(), new Function2<DocumentScanningReducer.State, DocumentScanningReducer.State, Boolean>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$6
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(DocumentScanningReducer.State old, DocumentScanningReducer.State state) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(state, "new");
                return Boolean.valueOf((old instanceof DocumentScanningReducer.State.PermissionRequired) && (state instanceof DocumentScanningReducer.State.PermissionRequired));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<DocumentScanningReducer.State.PermissionRequired>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$7

            /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$7$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$switchScope$2$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$7$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$7$2", f = "DocumentScanningHostFragment.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        DocumentScanningReducer.State.PermissionRequired permissionRequired = (DocumentScanningReducer.State.PermissionRequired) (!(obj instanceof DocumentScanningReducer.State.PermissionRequired) ? null : obj);
                        if (permissionRequired != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(permissionRequired);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(permissionRequired, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super DocumentScanningReducer.State.PermissionRequired> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged2.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new DocumentScanningHostFragment$onViewCreated$$inlined$switchScope$8(store2, orCreateKotlinClass2, documentScanningHostFragment$onViewCreated$$inlined$switchScope$5, null, this)), StoreKt.registerCoroutineScope(store2, CoroutineExtensionsKt.getChildScope(lifecycleScope2), KClassesJvm.getJvmName(orCreateKotlinClass2)));
        Store<DocumentScanningReducer.State, DocumentScanningReducer.Action> store3 = this.store;
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(DocumentScanningReducer.State.ScanPage.class);
        AnonymousClass3 anonymousClass3 = AnonymousClass3.INSTANCE;
        LifecycleCoroutineScope lifecycleScope3 = LifecycleOwnerKt.getLifecycleScope(documentScanningHostFragment);
        final Flow flowDistinctUntilChanged3 = FlowKt.distinctUntilChanged(store3.getState(), new Function2<DocumentScanningReducer.State, DocumentScanningReducer.State, Boolean>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$1
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(DocumentScanningReducer.State old, DocumentScanningReducer.State state) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(state, "new");
                return Boolean.valueOf((old instanceof DocumentScanningReducer.State.ScanPage) && (state instanceof DocumentScanningReducer.State.ScanPage));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<DocumentScanningReducer.State.ScanPage>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$2

            /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$2$2", f = "DocumentScanningHostFragment.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        DocumentScanningReducer.State.ScanPage scanPage = (DocumentScanningReducer.State.ScanPage) (!(obj instanceof DocumentScanningReducer.State.ScanPage) ? null : obj);
                        if (scanPage != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(scanPage);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(scanPage, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super DocumentScanningReducer.State.ScanPage> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged3.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$3(store3, orCreateKotlinClass3, anonymousClass3, null, this)), StoreKt.registerCoroutineScope(store3, CoroutineExtensionsKt.getChildScope(lifecycleScope3), KClassesJvm.getJvmName(orCreateKotlinClass3)));
        Store<DocumentScanningReducer.State, DocumentScanningReducer.Action> store4 = this.store;
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(DocumentScanningReducer.State.Edit.class);
        AnonymousClass5 anonymousClass5 = AnonymousClass5.INSTANCE;
        LifecycleCoroutineScope lifecycleScope4 = LifecycleOwnerKt.getLifecycleScope(documentScanningHostFragment);
        final Flow flowDistinctUntilChanged4 = FlowKt.distinctUntilChanged(store4.getState(), new Function2<DocumentScanningReducer.State, DocumentScanningReducer.State, Boolean>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$4
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(DocumentScanningReducer.State old, DocumentScanningReducer.State state) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(state, "new");
                return Boolean.valueOf((old instanceof DocumentScanningReducer.State.Edit) && (state instanceof DocumentScanningReducer.State.Edit));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<DocumentScanningReducer.State.Edit>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$5

            /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$5$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$5$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$5$2", f = "DocumentScanningHostFragment.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        DocumentScanningReducer.State.Edit edit = (DocumentScanningReducer.State.Edit) (!(obj instanceof DocumentScanningReducer.State.Edit) ? null : obj);
                        if (edit != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(edit);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(edit, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super DocumentScanningReducer.State.Edit> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged4.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$6(store4, orCreateKotlinClass4, anonymousClass5, null, this)), StoreKt.registerCoroutineScope(store4, CoroutineExtensionsKt.getChildScope(lifecycleScope4), KClassesJvm.getJvmName(orCreateKotlinClass4)));
        Store<DocumentScanningReducer.State, DocumentScanningReducer.Action> store5 = this.store;
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(DocumentScanningReducer.State.Review.class);
        AnonymousClass7 anonymousClass7 = AnonymousClass7.INSTANCE;
        LifecycleCoroutineScope lifecycleScope5 = LifecycleOwnerKt.getLifecycleScope(documentScanningHostFragment);
        final Flow flowDistinctUntilChanged5 = FlowKt.distinctUntilChanged(store5.getState(), new Function2<DocumentScanningReducer.State, DocumentScanningReducer.State, Boolean>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$7
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(DocumentScanningReducer.State old, DocumentScanningReducer.State state) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(state, "new");
                return Boolean.valueOf((old instanceof DocumentScanningReducer.State.Review) && (state instanceof DocumentScanningReducer.State.Review));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<DocumentScanningReducer.State.Review>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$8

            /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$8$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$8$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$8$2", f = "DocumentScanningHostFragment.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        DocumentScanningReducer.State.Review review = (DocumentScanningReducer.State.Review) (!(obj instanceof DocumentScanningReducer.State.Review) ? null : obj);
                        if (review != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(review);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(review, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super DocumentScanningReducer.State.Review> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged5.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$9(store5, orCreateKotlinClass5, anonymousClass7, null, this)), StoreKt.registerCoroutineScope(store5, CoroutineExtensionsKt.getChildScope(lifecycleScope5), KClassesJvm.getJvmName(orCreateKotlinClass5)));
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentScanningHostFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<ScanPageReducer.Action, DocumentScanningReducer.Action.Scanning> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(1, DocumentScanningReducer.Action.Scanning.class, "<init>", "<init>(Lcom/box/android/capture/documentscanning/ScanPageReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final DocumentScanningReducer.Action.Scanning invoke(ScanPageReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new DocumentScanningReducer.Action.Scanning(p0);
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$5, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentScanningHostFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<EditScanPageReducer.Action, DocumentScanningReducer.Action.Edit> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        AnonymousClass5() {
            super(1, DocumentScanningReducer.Action.Edit.class, "<init>", "<init>(Lcom/box/android/capture/documentscanning/EditScanPageReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final DocumentScanningReducer.Action.Edit invoke(EditScanPageReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new DocumentScanningReducer.Action.Edit(p0);
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$7, reason: invalid class name */
    /* JADX INFO: compiled from: DocumentScanningHostFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1<ReviewScanPageReducer.Action, DocumentScanningReducer.Action.Review> {
        public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

        AnonymousClass7() {
            super(1, DocumentScanningReducer.Action.Review.class, "<init>", "<init>(Lcom/box/android/capture/documentscanning/ReviewScanPageReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final DocumentScanningReducer.Action.Review invoke(ReviewScanPageReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new DocumentScanningReducer.Action.Review(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void replaceFragment(Fragment fragment) {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
        FragmentTransaction fragmentTransactionBeginTransaction = parentFragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.setReorderingAllowed(true);
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransactionBeginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateProcessingState(DocumentProcessingState processingState) {
        FragmentActivity activity = getActivity();
        BoxSpinnerDialogFragmentActivity boxSpinnerDialogFragmentActivity = activity instanceof BoxSpinnerDialogFragmentActivity ? (BoxSpinnerDialogFragmentActivity) activity : null;
        if (boxSpinnerDialogFragmentActivity != null) {
            if (Intrinsics.areEqual(processingState, DocumentProcessingState.NotProcessing.INSTANCE)) {
                boxSpinnerDialogFragmentActivity.dismissSpinnerSynchronous();
            } else {
                if (!(processingState instanceof DocumentProcessingState.Processing)) {
                    throw new NoWhenBranchMatchedException();
                }
                boxSpinnerDialogFragmentActivity.showSpinner(((DocumentProcessingState.Processing) processingState).getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLicenseExpiredDialog() {
        new AlertDialogFragment().setTitle(R.string.document_scan_license_expired_title).setMessage(R.string.document_scan_license_expired_message).setPositiveButtonId(R.string.document_scan_license_expired_close_button).show(getParentFragmentManager(), LICENSE_EXPIRATION_DIALOG_TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorDialog(String message) {
        if (message != null) {
            new AlertDialogFragment().setMessage(message).setNeutralButtonId(R.string.button_ok).show(getParentFragmentManager(), ERROR_DIALOG_TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSkipOcrDialog(String message) {
        new AlertDialogFragment().setTitle(R.string.document_scan_error_ocr_title).setMessage(message).setPositiveButtonId(R.string.document_scan_error_ocr_save).setNeutralButtonId(R.string.document_scan_error_ocr_cancel).show(getChildFragmentManager(), OCR_ERROR_DIALOG_TAG);
    }

    @Override // com.box.android.base.presentation.fragments.AlertDialogFragmentListener
    public void onAlertDialogFragmentDismissed(String tag) {
        if (Intrinsics.areEqual(tag, ERROR_DIALOG_TAG)) {
            this.store.send(DocumentScanningReducer.Action.ErrorDismissed.INSTANCE);
        } else if (Intrinsics.areEqual(tag, OCR_ERROR_DIALOG_TAG)) {
            this.store.send(DocumentScanningReducer.Action.ErrorDismissed.INSTANCE);
        }
    }

    @Override // com.box.android.base.presentation.fragments.AlertDialogFragmentListener
    public void onAlertDialogFragmentPositiveButton(String tag) {
        if (Intrinsics.areEqual(tag, OCR_ERROR_DIALOG_TAG)) {
            getScanPageChildStore().send(new ScanPageReducer.Action.SaveDocument(true));
        }
    }
}
