package com.box.android.preview.annotations;

import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.annotations.model.Annotation;
import com.box.android.preview.annotations.model.DocumentSize;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.PdfUiFragment;
import com.pspdfkit.utils.Size;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationUpdateListenerImpl.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011R\"\u0010\u0002\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/annotations/AnnotationUpdateListenerImpl;", "Lcom/box/android/preview/annotations/AnnotationUpdateListener;", "getCreateAnnotationStore", "Lkotlin/Function0;", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "pdfUiFragment", "Lcom/pspdfkit/ui/PdfUiFragment;", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/pspdfkit/ui/PdfUiFragment;)V", "onAnnotationUpdated", "", "annotation", "Lcom/box/android/preview/annotations/model/Annotation;", "pageIndex", "", "(Lcom/box/android/preview/annotations/model/Annotation;Ljava/lang/Integer;)V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationUpdateListenerImpl implements AnnotationUpdateListener {
    public static final int $stable = 8;
    private final Function0<Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action>> getCreateAnnotationStore;
    private final PdfUiFragment pdfUiFragment;

    public AnnotationUpdateListenerImpl(Function0<Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action>> getCreateAnnotationStore, PdfUiFragment pdfUiFragment) {
        Intrinsics.checkNotNullParameter(getCreateAnnotationStore, "getCreateAnnotationStore");
        Intrinsics.checkNotNullParameter(pdfUiFragment, "pdfUiFragment");
        this.getCreateAnnotationStore = getCreateAnnotationStore;
        this.pdfUiFragment = pdfUiFragment;
    }

    @Override // com.box.android.preview.annotations.AnnotationUpdateListener
    public void onAnnotationUpdated(Annotation annotation, Integer pageIndex) {
        Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action> storeInvoke;
        Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action> storeInvoke2 = this.getCreateAnnotationStore.invoke();
        CreateAnnotationReducer.State state = storeInvoke2 != null ? (CreateAnnotationReducer.State) StoreKt.stateValue(storeInvoke2) : null;
        PdfDocument document = this.pdfUiFragment.getDocument();
        if (document == null || state == null) {
            BoxLogUtils.w("AnnotationUpdateListener", "Document was not loaded or in createAnnotationState despite annotation update Document:" + document + " CreateAnnotation:" + state);
            return;
        }
        if (annotation == null || pageIndex == null) {
            Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action> storeInvoke3 = this.getCreateAnnotationStore.invoke();
            if (storeInvoke3 != null) {
                storeInvoke3.send(new CreateAnnotationReducer.Action.SetActivePage(null));
            }
        } else if (state.getPageWithAnnotation() == null) {
            Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action> storeInvoke4 = this.getCreateAnnotationStore.invoke();
            if (storeInvoke4 != null) {
                int iIntValue = pageIndex.intValue();
                Size pageSize = document.getPageSize(pageIndex.intValue());
                storeInvoke4.send(new CreateAnnotationReducer.Action.SetActivePage(new CreateAnnotationReducer.PageInfo(iIntValue, new DocumentSize(pageSize.width, pageSize.height))));
            }
        } else if (state.getPageWithAnnotation().getIndex() != pageIndex.intValue() && (storeInvoke = this.getCreateAnnotationStore.invoke()) != null) {
            storeInvoke.send(CreateAnnotationReducer.Action.AnnotationDrawnOutsideActivePage.INSTANCE);
        }
        Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action> storeInvoke5 = this.getCreateAnnotationStore.invoke();
        if (storeInvoke5 != null) {
            storeInvoke5.send(new CreateAnnotationReducer.Action.UpdateCreatedAnnotation(annotation));
        }
    }
}
