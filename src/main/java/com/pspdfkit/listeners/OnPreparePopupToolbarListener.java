package com.pspdfkit.listeners;

import android.graphics.PointF;
import com.pspdfkit.ui.PopupToolbar;
import com.pspdfkit.ui.toolbar.popup.AnnotationPopupToolbar;
import com.pspdfkit.ui.toolbar.popup.TextSelectionPopupToolbar;

/* JADX INFO: loaded from: classes3.dex */
public interface OnPreparePopupToolbarListener {
    default void onPrepareAnnotationPopupToolbar(AnnotationPopupToolbar annotationPopupToolbar) {
    }

    default void onPrepareContentEditingPopupToolbar(PopupToolbar popupToolbar, int i, PointF pointF) {
    }

    default void onPrepareLongPressPopupToolbar(PopupToolbar popupToolbar, int i, PointF pointF) {
    }

    default void onPrepareTextSelectionPopupToolbar(TextSelectionPopupToolbar textSelectionPopupToolbar) {
    }
}
