package com.box.android.preview.annotations;

import android.content.DialogInterface;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.preview.R;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.annotations.managers.CreateAnnotationsManager;
import com.box.android.preview.annotations.model.Annotation;
import com.box.android.preview.annotations.ui.views.CommentPopupWindow;
import com.box.android.preview.integration.nutrient.NutrientPdfInitializeHelper;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfUiFragment;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationCreationFragmentImpl.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/preview/annotations/AnnotationCreationFragmentImpl;", "Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager$AnnotationCreationFragment;", "pdfUiFragment", "Lcom/pspdfkit/ui/PdfUiFragment;", "createAnnotationsManager", "Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;", "getCreateAnnotationStore", "Lkotlin/Function0;", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$State;", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "<init>", "(Lcom/pspdfkit/ui/PdfUiFragment;Lcom/box/android/preview/annotations/managers/CreateAnnotationsManager;Lkotlin/jvm/functions/Function0;)V", "documentPreviewFragment", "Lcom/box/android/preview/integration/nutrient/NutrientPdfInitializeHelper$DocumentPreviewFragmentImpl;", "commentPopupWindow", "Lcom/box/android/preview/annotations/ui/views/CommentPopupWindow;", "annotationsMaxSizeReachedDialog", "Landroidx/appcompat/app/AlertDialog;", "getPdfFragment", "Lcom/pspdfkit/ui/PdfFragment;", "getPreviewActivity", "Landroidx/fragment/app/FragmentActivity;", "showCommentPopupMenu", "", "hasToRecreatePopup", "", "showAlertDialogForMaxSizeReached", "dismissCommentPopupMenu", "isAnnotationPayloadSizeNotAboveLimit", "payload", "Lcom/box/android/preview/annotations/model/Annotation;", "(Lcom/box/android/preview/annotations/model/Annotation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationCreationFragmentImpl implements CreateAnnotationsManager.AnnotationCreationFragment {
    public static final int $stable = 8;
    private AlertDialog annotationsMaxSizeReachedDialog;
    private CommentPopupWindow commentPopupWindow;
    private final CreateAnnotationsManager createAnnotationsManager;
    private final NutrientPdfInitializeHelper.DocumentPreviewFragmentImpl documentPreviewFragment;
    private final Function0<Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action>> getCreateAnnotationStore;
    private final PdfUiFragment pdfUiFragment;

    public AnnotationCreationFragmentImpl(PdfUiFragment pdfUiFragment, CreateAnnotationsManager createAnnotationsManager, Function0<Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action>> getCreateAnnotationStore) {
        Intrinsics.checkNotNullParameter(pdfUiFragment, "pdfUiFragment");
        Intrinsics.checkNotNullParameter(createAnnotationsManager, "createAnnotationsManager");
        Intrinsics.checkNotNullParameter(getCreateAnnotationStore, "getCreateAnnotationStore");
        this.pdfUiFragment = pdfUiFragment;
        this.createAnnotationsManager = createAnnotationsManager;
        this.getCreateAnnotationStore = getCreateAnnotationStore;
        this.documentPreviewFragment = new NutrientPdfInitializeHelper.DocumentPreviewFragmentImpl(pdfUiFragment);
    }

    @Override // com.box.android.preview.annotations.managers.CreateAnnotationsManager.AnnotationCreationFragment
    public PdfFragment getPdfFragment() {
        return this.documentPreviewFragment.getPdfFragment();
    }

    @Override // com.box.android.preview.annotations.managers.CreateAnnotationsManager.AnnotationCreationFragment
    public FragmentActivity getPreviewActivity() {
        return this.documentPreviewFragment.getPreviewActivity();
    }

    @Override // com.box.android.preview.annotations.managers.CreateAnnotationsManager.AnnotationCreationFragment
    public void showCommentPopupMenu(boolean hasToRecreatePopup) {
        View view = this.pdfUiFragment.getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) view;
        if (this.commentPopupWindow == null) {
            Object systemService = this.pdfUiFragment.requireContext().getSystemService("layout_inflater");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
            View viewInflate = ((LayoutInflater) systemService).inflate(R.layout.box_preview_sdk_create_annotation_context_menu, viewGroup, false);
            Intrinsics.checkNotNull(viewInflate);
            this.commentPopupWindow = new CommentPopupWindow(viewInflate, new Function0() { // from class: com.box.android.preview.annotations.AnnotationCreationFragmentImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AnnotationCreationFragmentImpl.showCommentPopupMenu$lambda$0(this.f$0);
                }
            }, new Function0() { // from class: com.box.android.preview.annotations.AnnotationCreationFragmentImpl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AnnotationCreationFragmentImpl.showCommentPopupMenu$lambda$1(this.f$0);
                }
            }, new Function1() { // from class: com.box.android.preview.annotations.AnnotationCreationFragmentImpl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AnnotationCreationFragmentImpl.showCommentPopupMenu$lambda$2(this.f$0, (PopupWindow) obj);
                }
            }, new Function1() { // from class: com.box.android.preview.annotations.AnnotationCreationFragmentImpl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AnnotationCreationFragmentImpl.showCommentPopupMenu$lambda$3(this.f$0, (PopupWindow) obj);
                }
            });
        }
        CommentPopupWindow commentPopupWindow = this.commentPopupWindow;
        CommentPopupWindow commentPopupWindow2 = null;
        if (commentPopupWindow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentPopupWindow");
            commentPopupWindow = null;
        }
        commentPopupWindow.updateButtonStates(this.createAnnotationsManager.createMenuItemEnableVisibleMap());
        Pair<PointF, Integer> pairCalculateCommentPopupPosition = AnnotationUtils.calculateCommentPopupPosition(this.createAnnotationsManager.getCreatedAnnotations().values(), getPdfFragment());
        PointF pointFComponent1 = pairCalculateCommentPopupPosition.component1();
        int iIntValue = pairCalculateCommentPopupPosition.component2().intValue();
        CommentPopupWindow commentPopupWindow3 = this.commentPopupWindow;
        if (commentPopupWindow3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentPopupWindow");
            commentPopupWindow3 = null;
        }
        if (commentPopupWindow3.isShowing() && hasToRecreatePopup) {
            CommentPopupWindow commentPopupWindow4 = this.commentPopupWindow;
            if (commentPopupWindow4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentPopupWindow");
                commentPopupWindow4 = null;
            }
            commentPopupWindow4.dismiss();
        }
        CommentPopupWindow commentPopupWindow5 = this.commentPopupWindow;
        if (commentPopupWindow5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentPopupWindow");
        } else {
            commentPopupWindow2 = commentPopupWindow5;
        }
        commentPopupWindow2.showAtLocation(viewGroup, iIntValue, (int) pointFComponent1.x, (int) pointFComponent1.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showCommentPopupMenu$lambda$0(AnnotationCreationFragmentImpl annotationCreationFragmentImpl) {
        annotationCreationFragmentImpl.createAnnotationsManager.undoOperation();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showCommentPopupMenu$lambda$1(AnnotationCreationFragmentImpl annotationCreationFragmentImpl) {
        annotationCreationFragmentImpl.createAnnotationsManager.redoOperation();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showCommentPopupMenu$lambda$2(AnnotationCreationFragmentImpl annotationCreationFragmentImpl, PopupWindow it) throws InterruptedException {
        Intrinsics.checkNotNullParameter(it, "it");
        annotationCreationFragmentImpl.createAnnotationsManager.removePendingAnnotations();
        CommentPopupWindow commentPopupWindow = annotationCreationFragmentImpl.commentPopupWindow;
        if (commentPopupWindow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentPopupWindow");
            commentPopupWindow = null;
        }
        commentPopupWindow.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showCommentPopupMenu$lambda$3(AnnotationCreationFragmentImpl annotationCreationFragmentImpl, PopupWindow it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action> storeInvoke = annotationCreationFragmentImpl.getCreateAnnotationStore.invoke();
        if (storeInvoke != null) {
            storeInvoke.send(CreateAnnotationReducer.Action.Commenting.INSTANCE);
        }
        CommentPopupWindow commentPopupWindow = annotationCreationFragmentImpl.commentPopupWindow;
        if (commentPopupWindow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentPopupWindow");
            commentPopupWindow = null;
        }
        commentPopupWindow.dismiss();
        return Unit.INSTANCE;
    }

    @Override // com.box.android.preview.annotations.managers.CreateAnnotationsManager.AnnotationCreationFragment
    public void showAlertDialogForMaxSizeReached() {
        if (this.annotationsMaxSizeReachedDialog != null) {
            return;
        }
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this.pdfUiFragment.requireContext());
        materialAlertDialogBuilder.setTitle(R.string.annotation_size_alert_dialog_title);
        materialAlertDialogBuilder.setMessage(R.string.annotation_size_alert_dialog_message);
        materialAlertDialogBuilder.setPositiveButton(R.string.annotation_size_alert_dialog_save_drawings_continue, new DialogInterface.OnClickListener() { // from class: com.box.android.preview.annotations.AnnotationCreationFragmentImpl$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AnnotationCreationFragmentImpl.showAlertDialogForMaxSizeReached$lambda$0(this.f$0, dialogInterface, i);
            }
        });
        materialAlertDialogBuilder.setNegativeButton(R.string.annotation_size_alert_dialog_clear_drawing, new DialogInterface.OnClickListener() { // from class: com.box.android.preview.annotations.AnnotationCreationFragmentImpl$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) throws InterruptedException {
                AnnotationCreationFragmentImpl.showAlertDialogForMaxSizeReached$lambda$1(this.f$0, dialogInterface, i);
            }
        });
        materialAlertDialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.box.android.preview.annotations.AnnotationCreationFragmentImpl$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.annotationsMaxSizeReachedDialog = null;
            }
        });
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        this.annotationsMaxSizeReachedDialog = alertDialogCreate;
        Intrinsics.checkNotNull(alertDialogCreate);
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAlertDialogForMaxSizeReached$lambda$0(AnnotationCreationFragmentImpl annotationCreationFragmentImpl, DialogInterface dialogInterface, int i) {
        Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action> storeInvoke = annotationCreationFragmentImpl.getCreateAnnotationStore.invoke();
        if (storeInvoke != null) {
            storeInvoke.send(CreateAnnotationReducer.Action.Commenting.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAlertDialogForMaxSizeReached$lambda$1(AnnotationCreationFragmentImpl annotationCreationFragmentImpl, DialogInterface dialogInterface, int i) throws InterruptedException {
        annotationCreationFragmentImpl.createAnnotationsManager.removePendingAnnotations();
    }

    @Override // com.box.android.preview.annotations.managers.CreateAnnotationsManager.AnnotationCreationFragment
    public void dismissCommentPopupMenu() {
        CommentPopupWindow commentPopupWindow = this.commentPopupWindow;
        if (commentPopupWindow != null) {
            if (commentPopupWindow == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentPopupWindow");
                commentPopupWindow = null;
            }
            commentPopupWindow.dismiss();
        }
    }

    @Override // com.box.android.preview.annotations.managers.CreateAnnotationsManager.AnnotationCreationFragment
    public Object isAnnotationPayloadSizeNotAboveLimit(Annotation annotation, Continuation<? super Boolean> continuation) {
        CreateAnnotationReducer.State state;
        Store<CreateAnnotationReducer.State, CreateAnnotationReducer.Action> storeInvoke = this.getCreateAnnotationStore.invoke();
        boolean z = false;
        if (storeInvoke != null && (state = (CreateAnnotationReducer.State) StoreKt.stateValue(storeInvoke)) != null && state.isAnnotationBelowSizeLimit()) {
            z = true;
        }
        return Boxing.boxBoolean(z);
    }
}
