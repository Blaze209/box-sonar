package com.pspdfkit.ui.special_mode.controller;

import com.pspdfkit.datastructures.TextSelection;
import com.pspdfkit.ui.special_mode.controller.base.FragmentSpecialModeController;
import com.pspdfkit.ui.special_mode.manager.TextSelectionManager;

/* JADX INFO: loaded from: classes3.dex */
public interface TextSelectionController extends FragmentSpecialModeController {

    public interface OnSearchSelectedTextListener {
        void onSearchSelectedText(String str);
    }

    void createLinkAboveSelectedText();

    TextSelection getTextSelection();

    TextSelectionManager getTextSelectionManager();

    void highlightSelectedText();

    default void highlightSelectedTextAndBeginCommenting() {
        highlightSelectedText();
    }

    default boolean isInstantHighlightCommentingEnabledByConfiguration() {
        return false;
    }

    boolean isLinkCreationEnabledByConfiguration();

    boolean isRedactionEnabledByConfiguration();

    boolean isTextExtractionEnabledByDocumentPermissions();

    boolean isTextHighlightingEnabledByConfiguration();

    boolean isTextSharingEnabledByConfiguration();

    boolean isTextSpeakEnabledByDocumentPermissions();

    void redactSelectedText();

    void searchSelectedText();

    void setOnSearchSelectedTextListener(OnSearchSelectedTextListener onSearchSelectedTextListener);

    void setTextSelection(TextSelection textSelection);

    void strikeoutSelectedText();

    void underlineSelectedText();
}
