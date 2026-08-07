package com.pspdfkit.ui.toolbar.popup;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.pspdfkit.Nutrient;
import com.pspdfkit.R;
import com.pspdfkit.ai.AiAssistantHelpersKt;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.policy.ApplicationPolicy;
import com.pspdfkit.datastructures.TextSelection;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.sharing.DocumentSharingManager;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.c60;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.wb;
import com.pspdfkit.internal.z8;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PopupToolbar;
import com.pspdfkit.ui.special_mode.controller.TextSelectionController;
import com.pspdfkit.utils.PdfUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0002R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/pspdfkit/ui/toolbar/popup/TextSelectionPopupToolbar;", "Lcom/pspdfkit/ui/PopupToolbar;", "pdfFragment", "Lcom/pspdfkit/ui/PdfFragment;", "<init>", "(Lcom/pspdfkit/ui/PdfFragment;)V", "value", "Lcom/pspdfkit/ui/special_mode/controller/TextSelectionController;", "controller", "getController", "()Lcom/pspdfkit/ui/special_mode/controller/TextSelectionController;", "viewId", "", "getViewId", "()I", "bindController", "", "textSelectionController", "unbindController", "showForSelectedText", BoxAnalyticsParams.ACTION_DISMISS, "buildMenuItems", "", "Lcom/pspdfkit/ui/toolbar/popup/PopupToolbarMenuItem;", "handleDefaultItemClick", "", "clickedItemId", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class TextSelectionPopupToolbar extends PopupToolbar {
    public static final int $stable = 8;
    private TextSelectionController controller;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextSelectionPopupToolbar(PdfFragment pdfFragment) {
        super(pdfFragment);
        pdfFragment.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bindController$lambda$0(TextSelectionPopupToolbar textSelectionPopupToolbar, PopupToolbarMenuItem popupToolbarMenuItem) {
        popupToolbarMenuItem.getClass();
        return textSelectionPopupToolbar.handleDefaultItemClick(popupToolbarMenuItem.getId());
    }

    private final List<PopupToolbarMenuItem> buildMenuItems(TextSelectionController textSelectionController) {
        ArrayList arrayList = new ArrayList();
        PdfConfiguration configuration = getPdfFragment().getConfiguration();
        configuration.getClass();
        PdfDocument document = textSelectionController.getFragment().getDocument();
        boolean z = false;
        boolean z2 = document != null && document.getDocumentSources().size() == 1;
        if (configuration.isAiAssistantEnabled() && z2) {
            arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_aia, R.string.pspdf__action_menu_ai_assistant, R.drawable.pspdf__ic_ai_assistant, true));
        }
        if (configuration.isCopyPasteEnabled()) {
            arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_copy, R.string.pspdf__action_menu_copy, R.drawable.pspdf__ic_content_copy, textSelectionController.isTextExtractionEnabledByDocumentPermissions() && Nutrient.getApplicationPolicy().hasPermissionForEvent(ApplicationPolicy.PolicyEvent.TEXT_COPY_PASTE)));
        }
        arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_highlight, R.string.pspdf__edit_menu_highlight, R.drawable.pspdf__ic_highlight, textSelectionController.isTextHighlightingEnabledByConfiguration()));
        if (textSelectionController.isInstantHighlightCommentingEnabledByConfiguration()) {
            arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_instantHighlightComment, R.string.pspdf__annotation_type_instantComments, R.drawable.pspdf__ic_instant_comment, true));
        }
        if (textSelectionController.isTextHighlightingEnabledByConfiguration()) {
            arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_strikeout, R.string.pspdf__edit_menu_strikeout, R.drawable.pspdf__ic_strikeout, textSelectionController.isTextHighlightingEnabledByConfiguration()));
            arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_underline, R.string.pspdf__edit_menu_underline, R.drawable.pspdf__ic_underline, textSelectionController.isTextHighlightingEnabledByConfiguration()));
        }
        if (textSelectionController.isRedactionEnabledByConfiguration()) {
            arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_redact, R.string.pspdf__redaction_redact, R.drawable.pspdf__ic_redaction, true));
        }
        lm lmVar = document instanceof lm ? (lm) document : null;
        wb wbVar = lmVar != null ? lmVar.o : null;
        if (configuration.isCopyPasteEnabled() && wbVar != null && wbVar.a()) {
            arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_paste_annotation, R.string.pspdf__paste, R.drawable.pspdf__ic_content_paste, true));
        }
        arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_speak, R.string.pspdf__action_menu_speak, R.drawable.pspdf__ic_hearing, textSelectionController.isTextExtractionEnabledByDocumentPermissions() || textSelectionController.isTextSpeakEnabledByDocumentPermissions()));
        arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_search, R.string.pspdf__activity_menu_search, R.drawable.pspdf__ic_search, true));
        if (textSelectionController.isTextSharingEnabledByConfiguration()) {
            if (textSelectionController.isTextExtractionEnabledByDocumentPermissions() && Nutrient.getApplicationPolicy().hasPermissionForEvent(ApplicationPolicy.PolicyEvent.TEXT_COPY_PASTE)) {
                z = true;
            }
            arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_share, R.string.pspdf__share, R.drawable.pspdf__ic_share, z));
        }
        if (textSelectionController.isLinkCreationEnabledByConfiguration()) {
            arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_link, R.string.pspdf__create_link, R.drawable.pspdf__ic_link, true));
        }
        return arrayList;
    }

    private final boolean handleDefaultItemClick(int clickedItemId) {
        TextSelection textSelection;
        Context context;
        TextSelectionController textSelectionController = this.controller;
        if (textSelectionController == null || (textSelection = textSelectionController.getTextSelection()) == null || (context = getPdfFragment().getContext()) == null) {
            return false;
        }
        if (clickedItemId == R.id.pspdf__text_selection_toolbar_item_share) {
            if (TextUtils.isEmpty(textSelection.text)) {
                return true;
            }
            DocumentSharingManager.shareText(context, textSelection.text);
            i0 i0VarA = ar.a();
            i0VarA.getClass();
            Bundle bundle = new Bundle();
            bundle.putString(Analytics.Data.ACTION, "share");
            bundle.putInt(Analytics.Data.PAGE_INDEX, textSelection.pageIndex);
            i0VarA.a(Analytics.Event.PERFORM_TEXT_SELECTION_ACTION, bundle);
            return true;
        }
        if (clickedItemId == R.id.pspdf__text_selection_toolbar_item_copy) {
            z8.a(textSelection.text, "", context, R.string.pspdf__text_copied_to_clipboard, 48);
            textSelectionController.exitActiveMode();
            i0 i0VarA2 = ar.a();
            i0VarA2.getClass();
            Bundle bundle2 = new Bundle();
            bundle2.putString(Analytics.Data.ACTION, "clipboard");
            bundle2.putInt(Analytics.Data.PAGE_INDEX, textSelection.pageIndex);
            i0VarA2.a(Analytics.Event.PERFORM_TEXT_SELECTION_ACTION, bundle2);
            return true;
        }
        if (clickedItemId == R.id.pspdf__text_selection_toolbar_item_aia) {
            FragmentActivity fragmentActivityRequireActivity = getPdfFragment().requireActivity();
            fragmentActivityRequireActivity.getClass();
            AiAssistantHelpersKt.showAiAssistant(fragmentActivityRequireActivity, textSelection);
            return true;
        }
        if (clickedItemId == R.id.pspdf__text_selection_toolbar_item_highlight) {
            textSelectionController.highlightSelectedText();
            return true;
        }
        if (clickedItemId == R.id.pspdf__text_selection_toolbar_item_instantHighlightComment) {
            textSelectionController.highlightSelectedTextAndBeginCommenting();
            return true;
        }
        if (clickedItemId == R.id.pspdf__text_selection_toolbar_item_redact) {
            textSelectionController.redactSelectedText();
            return true;
        }
        if (clickedItemId == R.id.pspdf__text_selection_toolbar_item_strikeout) {
            textSelectionController.strikeoutSelectedText();
            return true;
        }
        if (clickedItemId == R.id.pspdf__text_selection_toolbar_item_underline) {
            textSelectionController.underlineSelectedText();
            return true;
        }
        if (clickedItemId == R.id.pspdf__text_selection_toolbar_item_speak) {
            String str = textSelection.text;
            c60.a aVar = c60.a;
            if (aVar != null) {
                aVar.a();
                c60.a = null;
            }
            if (str != null) {
                c60.a = new c60.a(context, str);
            }
            i0 i0VarA3 = ar.a();
            i0VarA3.getClass();
            Bundle bundle3 = new Bundle();
            bundle3.putString(Analytics.Data.ACTION, "tts");
            bundle3.putInt(Analytics.Data.PAGE_INDEX, textSelection.pageIndex);
            i0VarA3.a(Analytics.Event.PERFORM_TEXT_SELECTION_ACTION, bundle3);
            return true;
        }
        if (clickedItemId == R.id.pspdf__text_selection_toolbar_item_search) {
            textSelectionController.searchSelectedText();
            return true;
        }
        if (clickedItemId == R.id.pspdf__text_selection_toolbar_item_link) {
            textSelectionController.createLinkAboveSelectedText();
            return true;
        }
        if (clickedItemId != R.id.pspdf__text_selection_toolbar_item_paste_annotation) {
            return true;
        }
        PdfDocument document = textSelectionController.getFragment().getDocument();
        lm lmVar = document instanceof lm ? (lm) document : null;
        wb wbVar = lmVar != null ? lmVar.o : null;
        if (wbVar == null || !wbVar.a()) {
            return true;
        }
        RectF rectFCreatePdfRectUnion = PdfUtils.createPdfRectUnion(textSelection.textBlocks);
        rectFCreatePdfRectUnion.getClass();
        wbVar.a(textSelection.pageIndex, new PointF((rectFCreatePdfRectUnion.right + rectFCreatePdfRectUnion.left) / 2, rectFCreatePdfRectUnion.top)).subscribe();
        dismiss();
        return true;
    }

    public final void bindController(TextSelectionController textSelectionController) {
        textSelectionController.getClass();
        this.controller = textSelectionController;
        setMenuItems(buildMenuItems(textSelectionController));
        setDefaultItemHandler(new PopupToolbar.DefaultItemHandler() { // from class: com.pspdfkit.ui.toolbar.popup.TextSelectionPopupToolbar$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.ui.PopupToolbar.DefaultItemHandler
            public final boolean onItemClicked(PopupToolbarMenuItem popupToolbarMenuItem) {
                return TextSelectionPopupToolbar.bindController$lambda$0(this.f$0, popupToolbarMenuItem);
            }
        });
    }

    @Override // com.pspdfkit.ui.PopupToolbar
    public void dismiss() {
        super.dismiss();
        c60.a aVar = c60.a;
        if (aVar != null) {
            aVar.a();
            c60.a = null;
        }
    }

    public final TextSelectionController getController() {
        return this.controller;
    }

    @Override // com.pspdfkit.ui.PopupToolbar
    public int getViewId() {
        return R.id.pspdf__text_selection_toolbar;
    }

    public final void showForSelectedText() {
        TextSelection textSelection;
        TextSelectionController textSelectionController = this.controller;
        if (textSelectionController == null || (textSelection = textSelectionController.getTextSelection()) == null || textSelection.textBlocks.isEmpty()) {
            return;
        }
        RectF rectFCreatePdfRectUnion = PdfUtils.createPdfRectUnion(textSelection.textBlocks);
        rectFCreatePdfRectUnion.getClass();
        RectF rectF = new RectF();
        getPdfFragment().getVisiblePdfRect(rectF, textSelection.pageIndex);
        if (new RectF(rectF.left, rectF.bottom, rectF.right, rectF.top).intersect(new RectF(rectFCreatePdfRectUnion.left, rectFCreatePdfRectUnion.bottom, rectFCreatePdfRectUnion.right, rectFCreatePdfRectUnion.top))) {
            show(textSelection.pageIndex, (rectFCreatePdfRectUnion.left + rectFCreatePdfRectUnion.right) / 2.0f, Math.max(rectFCreatePdfRectUnion.bottom, rectFCreatePdfRectUnion.top));
        }
    }

    public final void unbindController() {
        this.controller = null;
        c60.a aVar = c60.a;
        if (aVar != null) {
            aVar.a();
            c60.a = null;
        }
    }
}
