package com.pspdfkit.jetpack.compose.interactors;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.configuration.sharing.ShareFeatures;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.printing.DocumentPrintManager;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.bv;
import com.pspdfkit.internal.cd;
import com.pspdfkit.internal.gc;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.sg;
import com.pspdfkit.internal.tg;
import com.pspdfkit.listeners.OnVisibilityChangedListener;
import com.pspdfkit.ui.PSPDFKitViews;
import com.pspdfkit.ui.PdfActivity;
import com.pspdfkit.ui.PdfReaderView;
import com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout;
import com.pspdfkit.utils.PdfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001d\u0010\u0016J\u0015\u0010 \u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0010\u0010$\u001a\u00020\u0014H\u0080@¢\u0006\u0004\b\"\u0010#J\u0011\u0010&\u001a\u0004\u0018\u00010%H&¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0017¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020\u00142\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00142\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b/\u0010.J\u000f\u00102\u001a\u00020\u0014H\u0000¢\u0006\u0004\b0\u00101J\u0015\u0010$\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b$\u00103J\u000f\u00104\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u0004\u0018\u000106¢\u0006\u0004\b7\u00108J\u0019\u0010:\u001a\u00020\u00142\n\b\u0002\u00109\u001a\u0004\u0018\u000106¢\u0006\u0004\b:\u0010;J\u0019\u0010>\u001a\u00020\u00142\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u0004\u0018\u00010<¢\u0006\u0004\b@\u0010AR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010BR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010C\u001a\u0004\bD\u00105R$\u0010F\u001a\u0004\u0018\u00010E8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR(\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00140L8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR.\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00140S8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\u000e0Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010!R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\n0Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010\\R\u001d\u0010b\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010\u0010R\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020\n0Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010\\R\u001d\u0010f\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006¢\u0006\f\n\u0004\bf\u0010c\u001a\u0004\bg\u0010\u0010R\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020h0Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010\\R\u001d\u0010j\u001a\b\u0012\u0004\u0012\u00020h0\r8\u0006¢\u0006\f\n\u0004\bj\u0010c\u001a\u0004\bk\u0010\u0010R\"\u0010m\u001a\u00020l8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u0014\u0010t\u001a\u0002068 X \u0004¢\u0006\u0006\u001a\u0004\bs\u00108R$\u0010{\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010v0u8 @ X \u000e¢\u0006\f\u001a\u0004\bw\u0010x\"\u0004\by\u0010z¨\u0006|"}, d2 = {"Lcom/pspdfkit/jetpack/compose/interactors/DocumentState;", "Lcom/pspdfkit/listeners/OnVisibilityChangedListener;", "Landroid/content/Context;", "context", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "configuration", "<init>", "(Landroid/content/Context;Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;)V", "Lcom/pspdfkit/ui/PSPDFKitViews$Type;", "type", "", "isToolbarOverlappingView", "(Lcom/pspdfkit/ui/PSPDFKitViews$Type;)Z", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/pspdfkit/internal/bv;", "getMenuConfigurationState$sdk_nutrient", "()Lkotlinx/coroutines/flow/StateFlow;", "getMenuConfigurationState", "isDefaultViewerActive", "()Z", "", "exitCurrentState", "()Lkotlin/Unit;", "", "pixels", "setContentViewTopPadding", "(I)Lkotlin/Unit;", "getContextualToolbarSizePx", "()I", "handleBackPress", "Lcom/pspdfkit/ui/toolbar/ToolbarCoordinatorLayout$OnContextualToolbarLifecycleListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnContextualToolbarLifecycleListener", "(Lcom/pspdfkit/ui/toolbar/ToolbarCoordinatorLayout$OnContextualToolbarLifecycleListener;)V", "updateConfiguration$sdk_nutrient", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConfiguration", "", "getTitle", "()Ljava/lang/String;", "option", "toggleView", "(I)V", "Landroid/view/View;", "view", "onShow", "(Landroid/view/View;)V", "onHide", "onDispose$sdk_nutrient", "()V", "onDispose", "(Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;)V", "getCurrentConfiguration", "()Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "Landroid/os/Bundle;", "getViewState", "()Landroid/os/Bundle;", "bundle", "setViewState", "(Landroid/os/Bundle;)V", "Lcom/pspdfkit/document/DocumentSource;", "source", "setCustomPdfSource", "(Lcom/pspdfkit/document/DocumentSource;)V", "getDocumentSource", "()Lcom/pspdfkit/document/DocumentSource;", "Landroid/content/Context;", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "getConfiguration$sdk_nutrient", "Lcom/pspdfkit/internal/gc;", "customPdfActions", "Lcom/pspdfkit/internal/gc;", "getCustomPdfActions$sdk_nutrient", "()Lcom/pspdfkit/internal/gc;", "setCustomPdfActions$sdk_nutrient", "(Lcom/pspdfkit/internal/gc;)V", "Lkotlin/Function0;", "onDocumentLoadedCallback", "Lkotlin/jvm/functions/Function0;", "getOnDocumentLoadedCallback$sdk_nutrient", "()Lkotlin/jvm/functions/Function0;", "setOnDocumentLoadedCallback$sdk_nutrient", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "onMenuVisibleCallback", "Lkotlin/jvm/functions/Function1;", "getOnMenuVisibleCallback$sdk_nutrient", "()Lkotlin/jvm/functions/Function1;", "setOnMenuVisibleCallback$sdk_nutrient", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "menuConfigStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/pspdfkit/ui/toolbar/ToolbarCoordinatorLayout$OnContextualToolbarLifecycleListener;", "getListener$sdk_nutrient", "()Lcom/pspdfkit/ui/toolbar/ToolbarCoordinatorLayout$OnContextualToolbarLifecycleListener;", "setListener$sdk_nutrient", "_viewWithOverlappingToolbarShown", "viewWithOverlappingToolbarShown", "Lkotlinx/coroutines/flow/StateFlow;", "getViewWithOverlappingToolbarShown", "_searchViewShown", "searchViewShown", "getSearchViewShown", "Lcom/pspdfkit/internal/bv$a;", "_activeViewState", "activeViewState", "getActiveViewState", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentConnection;", "documentConnection", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentConnection;", "getDocumentConnection", "()Lcom/pspdfkit/jetpack/compose/interactors/DocumentConnection;", "setDocumentConnection", "(Lcom/pspdfkit/jetpack/compose/interactors/DocumentConnection;)V", "getArguments$sdk_nutrient", "arguments", "Landroidx/compose/runtime/MutableState;", "Landroidx/fragment/app/Fragment$SavedState;", "getState$sdk_nutrient", "()Landroidx/compose/runtime/MutableState;", "setState$sdk_nutrient", "(Landroidx/compose/runtime/MutableState;)V", "state", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class DocumentState implements OnVisibilityChangedListener {
    public static final int $stable = 8;
    private final MutableStateFlow<bv.a> _activeViewState;
    private final MutableStateFlow<Boolean> _searchViewShown;
    private final MutableStateFlow<Boolean> _viewWithOverlappingToolbarShown;
    private final StateFlow<bv.a> activeViewState;
    private final PdfActivityConfiguration configuration;
    private final Context context;
    private gc customPdfActions;
    private DocumentConnection documentConnection;
    private ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener listener;
    private final MutableStateFlow<bv> menuConfigStateFlow;
    private Function0<Unit> onDocumentLoadedCallback;
    private Function1<? super Boolean, Unit> onMenuVisibleCallback;
    private final StateFlow<Boolean> searchViewShown;
    private final StateFlow<Boolean> viewWithOverlappingToolbarShown;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PSPDFKitViews.Type.values().length];
            try {
                iArr[PSPDFKitViews.Type.VIEW_THUMBNAIL_GRID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PSPDFKitViews.Type.VIEW_DOCUMENT_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PSPDFKitViews.Type.VIEW_OUTLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PSPDFKitViews.Type.VIEW_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PSPDFKitViews.Type.VIEW_SEARCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PSPDFKitViews.Type.VIEW_THUMBNAIL_BAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PSPDFKitViews.Type.VIEW_READER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.jetpack.compose.interactors.DocumentState$updateConfiguration$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/pspdfkit/internal/bv;", "menuConfig", "", "<anonymous>", "(Lcom/pspdfkit/internal/bv;)V"}, k = 3, mv = {2, 3, 0})
    @DebugMetadata(c = "com.pspdfkit.jetpack.compose.interactors.DocumentState$updateConfiguration$2", f = "DocumentState.kt", i = {0}, l = {247}, m = "invokeSuspend", n = {"menuConfig"}, nl = {248}, s = {"L$0"}, v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<bv, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = DocumentState.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(bv bvVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(bvVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            bv bvVar = (bv) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow = DocumentState.this.menuConfigStateFlow;
                this.L$0 = SpillingKt.nullOutSpilledVariable(bvVar);
                this.label = 1;
                if (mutableStateFlow.emit(bvVar, this) == coroutine_suspended) {
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

    public DocumentState(Context context, PdfActivityConfiguration pdfActivityConfiguration) {
        context.getClass();
        pdfActivityConfiguration.getClass();
        this.context = context;
        this.configuration = pdfActivityConfiguration;
        this.onDocumentLoadedCallback = new Function0() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };
        this.onMenuVisibleCallback = new Function1() { // from class: com.pspdfkit.jetpack.compose.interactors.DocumentState$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DocumentState.onMenuVisibleCallback$lambda$0(((Boolean) obj).booleanValue());
            }
        };
        this.menuConfigStateFlow = StateFlowKt.MutableStateFlow(new bv(context, pdfActivityConfiguration));
        Boolean bool = Boolean.FALSE;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(bool);
        this._viewWithOverlappingToolbarShown = MutableStateFlow;
        this.viewWithOverlappingToolbarShown = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(bool);
        this._searchViewShown = MutableStateFlow2;
        this.searchViewShown = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<bv.a> MutableStateFlow3 = StateFlowKt.MutableStateFlow(bv.a.NONE);
        this._activeViewState = MutableStateFlow3;
        this.activeViewState = FlowKt.asStateFlow(MutableStateFlow3);
        this.documentConnection = new cd();
    }

    private final boolean isToolbarOverlappingView(PSPDFKitViews.Type type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            case 4:
            case 5:
            case 6:
            case 7:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onMenuVisibleCallback$lambda$0(boolean z) {
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void setCustomPdfSource$default(DocumentState documentState, DocumentSource documentSource, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCustomPdfSource");
        }
        if ((i & 1) != 0) {
            documentSource = null;
        }
        documentState.setCustomPdfSource(documentSource);
    }

    public static /* synthetic */ void setViewState$default(DocumentState documentState, Bundle bundle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setViewState");
        }
        if ((i & 1) != 0) {
            bundle = null;
        }
        documentState.setViewState(bundle);
    }

    public final Unit exitCurrentState() {
        gc gcVar = this.customPdfActions;
        if (gcVar == null) {
            return null;
        }
        gcVar.b();
        return Unit.INSTANCE;
    }

    public final StateFlow<bv.a> getActiveViewState() {
        return this.activeViewState;
    }

    public abstract Bundle getArguments$sdk_nutrient();

    /* JADX INFO: renamed from: getConfiguration$sdk_nutrient, reason: from getter */
    public final PdfActivityConfiguration getConfiguration() {
        return this.configuration;
    }

    public final int getContextualToolbarSizePx() {
        gc gcVar = this.customPdfActions;
        if (gcVar != null) {
            return gcVar.c();
        }
        return 0;
    }

    public final PdfActivityConfiguration getCurrentConfiguration() {
        gc gcVar = this.customPdfActions;
        if (gcVar != null) {
            return gcVar.h();
        }
        return null;
    }

    /* JADX INFO: renamed from: getCustomPdfActions$sdk_nutrient, reason: from getter */
    public final gc getCustomPdfActions() {
        return this.customPdfActions;
    }

    public final DocumentConnection getDocumentConnection() {
        return this.documentConnection;
    }

    public final DocumentSource getDocumentSource() {
        gc gcVar = this.customPdfActions;
        if (gcVar != null) {
            return gcVar.getDocumentSource();
        }
        return null;
    }

    /* JADX INFO: renamed from: getListener$sdk_nutrient, reason: from getter */
    public final ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener getListener() {
        return this.listener;
    }

    public final StateFlow<bv> getMenuConfigurationState$sdk_nutrient() {
        return FlowKt.asStateFlow(this.menuConfigStateFlow);
    }

    public final Function0<Unit> getOnDocumentLoadedCallback$sdk_nutrient() {
        return this.onDocumentLoadedCallback;
    }

    public final Function1<Boolean, Unit> getOnMenuVisibleCallback$sdk_nutrient() {
        return this.onMenuVisibleCallback;
    }

    public final StateFlow<Boolean> getSearchViewShown() {
        return this.searchViewShown;
    }

    public abstract MutableState<Fragment.SavedState> getState$sdk_nutrient();

    public abstract String getTitle();

    public final Bundle getViewState() {
        gc gcVar = this.customPdfActions;
        if (gcVar != null) {
            return gcVar.e();
        }
        return null;
    }

    public final StateFlow<Boolean> getViewWithOverlappingToolbarShown() {
        return this.viewWithOverlappingToolbarShown;
    }

    public final Unit handleBackPress() {
        gc gcVar = this.customPdfActions;
        if (gcVar == null) {
            return null;
        }
        gcVar.i();
        return Unit.INSTANCE;
    }

    public final boolean isDefaultViewerActive() {
        gc gcVar = this.customPdfActions;
        if (gcVar != null) {
            return gcVar.f();
        }
        return true;
    }

    public final void onDispose$sdk_nutrient() {
        this.menuConfigStateFlow.getValue().d = null;
        this.documentConnection = new cd();
        this.customPdfActions = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.pspdfkit.listeners.OnVisibilityChangedListener
    public void onHide(View view) {
        view.getClass();
        PSPDFKitViews.PSPDFView pSPDFView = view instanceof PSPDFKitViews.PSPDFView ? (PSPDFKitViews.PSPDFView) view : null;
        if (pSPDFView == null) {
            return;
        }
        PSPDFKitViews.Type pSPDFViewType = pSPDFView.getPSPDFViewType();
        pSPDFViewType.getClass();
        boolean z = pSPDFViewType == PSPDFKitViews.Type.VIEW_SEARCH;
        if (isToolbarOverlappingView(pSPDFViewType) || z) {
            this._viewWithOverlappingToolbarShown.tryEmit(Boolean.FALSE);
        }
        if (z) {
            this._searchViewShown.tryEmit(Boolean.FALSE);
        }
        if (pSPDFViewType == PSPDFKitViews.Type.VIEW_THUMBNAIL_GRID || pSPDFViewType == PSPDFKitViews.Type.VIEW_OUTLINE || z) {
            this._activeViewState.tryEmit(bv.a.NONE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.pspdfkit.listeners.OnVisibilityChangedListener
    public void onShow(View view) {
        view.getClass();
        bv.a aVar = null;
        PSPDFKitViews.PSPDFView pSPDFView = view instanceof PSPDFKitViews.PSPDFView ? (PSPDFKitViews.PSPDFView) view : null;
        if (pSPDFView == null) {
            return;
        }
        PSPDFKitViews.Type pSPDFViewType = pSPDFView.getPSPDFViewType();
        pSPDFViewType.getClass();
        boolean z = pSPDFViewType == PSPDFKitViews.Type.VIEW_SEARCH;
        if (isToolbarOverlappingView(pSPDFViewType) || z) {
            this._viewWithOverlappingToolbarShown.tryEmit(Boolean.TRUE);
        }
        if (z) {
            this._searchViewShown.tryEmit(Boolean.TRUE);
        }
        if (pSPDFViewType == PSPDFKitViews.Type.VIEW_THUMBNAIL_GRID) {
            aVar = bv.a.THUMBNAIL_GRID;
        } else if (pSPDFViewType == PSPDFKitViews.Type.VIEW_OUTLINE) {
            aVar = bv.a.OUTLINE;
        } else if (z) {
            aVar = bv.a.SEARCH;
        }
        if (aVar != null) {
            this._activeViewState.tryEmit(aVar);
        }
    }

    public final Unit setContentViewTopPadding(int pixels) {
        gc gcVar = this.customPdfActions;
        if (gcVar == null) {
            return null;
        }
        gcVar.a(pixels);
        return Unit.INSTANCE;
    }

    public final void setCustomPdfActions$sdk_nutrient(gc gcVar) {
        this.customPdfActions = gcVar;
    }

    public final void setCustomPdfSource(DocumentSource source) {
        gc gcVar = this.customPdfActions;
        if (gcVar != null) {
            gcVar.a(source);
        }
    }

    public final void setDocumentConnection(DocumentConnection documentConnection) {
        documentConnection.getClass();
        this.documentConnection = documentConnection;
    }

    public final void setListener$sdk_nutrient(ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener onContextualToolbarLifecycleListener) {
        this.listener = onContextualToolbarLifecycleListener;
    }

    public final void setOnContextualToolbarLifecycleListener(ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener listener) {
        listener.getClass();
        this.listener = listener;
    }

    public final void setOnDocumentLoadedCallback$sdk_nutrient(Function0<Unit> function0) {
        function0.getClass();
        this.onDocumentLoadedCallback = function0;
    }

    public final void setOnMenuVisibleCallback$sdk_nutrient(Function1<? super Boolean, Unit> function1) {
        function1.getClass();
        this.onMenuVisibleCallback = function1;
    }

    public abstract void setState$sdk_nutrient(MutableState<Fragment.SavedState> mutableState);

    public final void setViewState(Bundle bundle) {
        gc gcVar = this.customPdfActions;
        if (gcVar != null) {
            gcVar.a(bundle);
        }
    }

    /* JADX WARN: Code duplicated, block: B:65:0x00cf  */
    public final void toggleView(int option) {
        PdfActivityConfiguration pdfActivityConfiguration = this.configuration;
        Context context = this.context;
        pdfActivityConfiguration.getClass();
        context.getClass();
        tg tgVarB = ar.b();
        tgVarB.getClass();
        boolean zIsAiAssistantEnabled = true;
        if (option == PdfActivity.MENU_OPTION_EDIT_ANNOTATIONS) {
            PdfConfiguration configuration = pdfActivityConfiguration.getConfiguration();
            synchronized (tgVarB) {
                configuration.getClass();
                if (!tgVarB.a(NativeLicenseFeatures.ANNOTATION_EDITING) || !configuration.isAnnotationEditingEnabled()) {
                    zIsAiAssistantEnabled = false;
                }
            }
        } else if (option == PdfActivity.MENU_OPTION_EDIT_CONTENT) {
            zIsAiAssistantEnabled = tgVarB.d(pdfActivityConfiguration.getConfiguration());
        } else if (option == PdfActivity.MENU_OPTION_SIGNATURE) {
            zIsAiAssistantEnabled = sg.a(pdfActivityConfiguration, tgVarB);
        } else if (option == PdfActivity.MENU_OPTION_OUTLINE) {
            if (!pdfActivityConfiguration.isOutlineEnabled() && !pdfActivityConfiguration.isAnnotationListEnabled() && !pdfActivityConfiguration.isBookmarkListEnabled()) {
                zIsAiAssistantEnabled = false;
            }
        } else if (option == PdfActivity.MENU_OPTION_READER_VIEW) {
            if (!pdfActivityConfiguration.isReaderViewEnabled() || !PdfReaderView.doesDeviceSupportReaderView(context)) {
                zIsAiAssistantEnabled = false;
            }
        } else if (option == PdfActivity.MENU_OPTION_SEARCH) {
            zIsAiAssistantEnabled = pdfActivityConfiguration.isSearchEnabled();
        } else if (option == PdfActivity.MENU_OPTION_SETTINGS) {
            zIsAiAssistantEnabled = pdfActivityConfiguration.isSettingsItemEnabled();
        } else if (option == PdfActivity.MENU_OPTION_SHARE) {
            if (!pdfActivityConfiguration.getConfiguration().getEnabledShareFeatures().contains(ShareFeatures.DOCUMENT_SHARING) && !DocumentPrintManager.get().isPrintingAvailable(pdfActivityConfiguration)) {
                zIsAiAssistantEnabled = false;
            }
        } else if (option == PdfActivity.MENU_OPTION_THUMBNAIL_GRID) {
            zIsAiAssistantEnabled = pdfActivityConfiguration.isThumbnailGridEnabled();
        } else if (option == PdfActivity.MENU_OPTION_DOCUMENT_INFO) {
            if (!pdfActivityConfiguration.isDocumentInfoViewEnabled() || !pdfActivityConfiguration.isDocumentInfoViewSeparated()) {
                zIsAiAssistantEnabled = false;
            }
        } else if (option == PdfActivity.MENU_OPTION_AI_ASSISTANT) {
            zIsAiAssistantEnabled = pdfActivityConfiguration.getConfiguration().isAiAssistantEnabled();
        } else {
            zIsAiAssistantEnabled = false;
        }
        if (!zIsAiAssistantEnabled) {
            PdfLog.w("DocumentState.toggleView", "Feature is either disabled or not available.", new Object[0]);
            return;
        }
        gc gcVar = this.customPdfActions;
        if (gcVar != null) {
            gcVar.b(option);
        }
    }

    public final void updateConfiguration(PdfActivityConfiguration configuration) {
        configuration.getClass();
        gc gcVar = this.customPdfActions;
        if (gcVar != null) {
            gcVar.a(configuration);
        }
    }

    public final Object updateConfiguration$sdk_nutrient(Continuation<? super Unit> continuation) {
        gc gcVar = this.customPdfActions;
        if (gcVar == null) {
            return Unit.INSTANCE;
        }
        Object objA = gcVar.a(this.context, this, this.listener, new AnonymousClass2(null), continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }
}
