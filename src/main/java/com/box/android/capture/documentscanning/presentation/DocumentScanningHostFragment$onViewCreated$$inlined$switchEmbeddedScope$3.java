package com.box.android.capture.documentscanning.presentation;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.android.capture.documentscanning.DocumentProcessingState;
import com.box.android.capture.documentscanning.DocumentScanningReducer;
import com.box.android.capture.documentscanning.ScanPageReducer;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.cpl.Wrapped;
import com.box.androidsdk.content.utils.BoxLogUtils;
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
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.KClassesJvm;

/* JADX INFO: compiled from: Store.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\u0010\b\u0002\u0010\u0005\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0003\u0010\b\"\u0004\b\u0004\u0010\u00072\u0006\u0010\t\u001a\u0002H\u0005H\u008a@¨\u0006\n"}, d2 = {"<anonymous>", "", "GlobalState", "", "Action", "ConcreteState", "Lcom/box/android/cpl/Embedded;", "LocalState", "LocalAction", "it", "com/box/android/cpl/StoreKt$switchEmbeddedScope$3"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$3", f = "DocumentScanningHostFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$3 extends SuspendLambda implements Function2<DocumentScanningReducer.State.ScanPage, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $fromLocalAction;
    final /* synthetic */ KClass $switchCase;
    final /* synthetic */ Store $this_switchEmbeddedScope;
    int label;
    final /* synthetic */ DocumentScanningHostFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$3(Store store, KClass kClass, Function1 function1, Continuation continuation, DocumentScanningHostFragment documentScanningHostFragment) {
        super(2, continuation);
        this.$this_switchEmbeddedScope = store;
        this.$switchCase = kClass;
        this.$fromLocalAction = function1;
        this.this$0 = documentScanningHostFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$3(this.$this_switchEmbeddedScope, this.$switchCase, this.$fromLocalAction, continuation, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DocumentScanningReducer.State.ScanPage scanPage, Continuation<? super Unit> continuation) {
        return ((DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$3) create(scanPage, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Store<ScanPageReducer.State, ScanPageReducer.Action> storeScope = this.$this_switchEmbeddedScope.scope(KClassesJvm.getJvmName(this.$switchCase), new Function1<DocumentScanningReducer.State, Wrapped<ScanPageReducer.State>>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$$inlined$switchEmbeddedScope$3.1
            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<ScanPageReducer.State> invoke(DocumentScanningReducer.State globalState) {
                ScanPageReducer.State action;
                Intrinsics.checkNotNullParameter(globalState, "globalState");
                if (!(globalState instanceof DocumentScanningReducer.State.ScanPage)) {
                    globalState = null;
                }
                DocumentScanningReducer.State.ScanPage scanPage = (DocumentScanningReducer.State.ScanPage) globalState;
                if (scanPage == null || (action = scanPage.getAction()) == null) {
                    return null;
                }
                return StoreKt.wrap(action);
            }
        }, this.$fromLocalAction);
        DocumentScanningHostFragment$onViewCreated$4$1$1 documentScanningHostFragment$onViewCreated$4$1$1 = new PropertyReference1Impl() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$4$1$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj2) {
                return ((ScanPageReducer.State) obj2).getProcessingState();
            }
        };
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.this$0);
        final DocumentScanningHostFragment documentScanningHostFragment = this.this$0;
        StoreKt.observe(storeScope, documentScanningHostFragment$onViewCreated$4$1$1, lifecycleScope, new Function1<DocumentProcessingState, Unit>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$4$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DocumentProcessingState documentProcessingState) {
                invoke2(documentProcessingState);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DocumentProcessingState processingState) {
                Intrinsics.checkNotNullParameter(processingState, "processingState");
                documentScanningHostFragment.updateProcessingState(processingState);
            }
        });
        DocumentScanningHostFragment$onViewCreated$4$1$3 documentScanningHostFragment$onViewCreated$4$1$3 = new PropertyReference1Impl() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$4$1$3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj2) {
                return ((ScanPageReducer.State) obj2).getDisplayedError();
            }
        };
        LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(this.this$0);
        final DocumentScanningHostFragment documentScanningHostFragment2 = this.this$0;
        StoreKt.observe(storeScope, documentScanningHostFragment$onViewCreated$4$1$3, lifecycleScope2, new Function1<ScanPageReducer.ScanPageError, Unit>() { // from class: com.box.android.capture.documentscanning.presentation.DocumentScanningHostFragment$onViewCreated$4$1$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScanPageReducer.ScanPageError scanPageError) {
                invoke2(scanPageError);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ScanPageReducer.ScanPageError scanPageError) {
                if (scanPageError instanceof ScanPageReducer.ScanPageError.GenericError) {
                    documentScanningHostFragment2.showErrorDialog(((ScanPageReducer.ScanPageError.GenericError) scanPageError).getMessage());
                } else if (scanPageError instanceof ScanPageReducer.ScanPageError.SkipOrRetryError) {
                    documentScanningHostFragment2.showSkipOcrDialog(((ScanPageReducer.ScanPageError.SkipOrRetryError) scanPageError).getMessage());
                } else {
                    BoxLogUtils.e("DocumentScanningHostFragment", "Unexpected else branch");
                }
            }
        });
        this.this$0.setScanPageChildStore(storeScope);
        this.this$0.replaceFragment(new IntegratedDocumentScanFragment(storeScope));
        return Unit.INSTANCE;
    }
}
