package com.box.android.preview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.box.android.preview.R;
import com.box.android.preview.annotations.ui.views.EraserToolView;
import com.box.android.preview.annotations.ui.views.MarkerToolView;
import com.box.android.preview.annotations.ui.views.MarkupButton;
import com.box.android.preview.annotations.ui.views.PencilToolView;

/* JADX INFO: loaded from: classes12.dex */
public final class AnnotationToolbarDrawBinding implements ViewBinding {
    public final ConstraintLayout annotationToolbarContainer;
    public final MarkupButton annotationsDraw;
    public final MarkupButton annotationsHighlight;
    public final MarkupButton annotationsRegion;
    public final AppCompatImageButton colorPicker;
    public final Group drawTools;
    public final EraserToolView eraserTool;
    public final MarkerToolView markerTool;
    public final PencilToolView pencilTool;
    private final ConstraintLayout rootView;
    public final View visibleToolbar;

    private AnnotationToolbarDrawBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, MarkupButton markupButton, MarkupButton markupButton2, MarkupButton markupButton3, AppCompatImageButton appCompatImageButton, Group group, EraserToolView eraserToolView, MarkerToolView markerToolView, PencilToolView pencilToolView, View view) {
        this.rootView = constraintLayout;
        this.annotationToolbarContainer = constraintLayout2;
        this.annotationsDraw = markupButton;
        this.annotationsHighlight = markupButton2;
        this.annotationsRegion = markupButton3;
        this.colorPicker = appCompatImageButton;
        this.drawTools = group;
        this.eraserTool = eraserToolView;
        this.markerTool = markerToolView;
        this.pencilTool = pencilToolView;
        this.visibleToolbar = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AnnotationToolbarDrawBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AnnotationToolbarDrawBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.annotation_toolbar_draw, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AnnotationToolbarDrawBinding bind(View view) {
        View viewFindChildViewById;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.annotations_draw;
        MarkupButton markupButton = (MarkupButton) ViewBindings.findChildViewById(view, i);
        if (markupButton != null) {
            i = R.id.annotations_highlight;
            MarkupButton markupButton2 = (MarkupButton) ViewBindings.findChildViewById(view, i);
            if (markupButton2 != null) {
                i = R.id.annotations_region;
                MarkupButton markupButton3 = (MarkupButton) ViewBindings.findChildViewById(view, i);
                if (markupButton3 != null) {
                    i = R.id.color_picker;
                    AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageButton != null) {
                        i = R.id.draw_tools;
                        Group group = (Group) ViewBindings.findChildViewById(view, i);
                        if (group != null) {
                            i = R.id.eraser_tool;
                            EraserToolView eraserToolView = (EraserToolView) ViewBindings.findChildViewById(view, i);
                            if (eraserToolView != null) {
                                i = R.id.marker_tool;
                                MarkerToolView markerToolView = (MarkerToolView) ViewBindings.findChildViewById(view, i);
                                if (markerToolView != null) {
                                    i = R.id.pencil_tool;
                                    PencilToolView pencilToolView = (PencilToolView) ViewBindings.findChildViewById(view, i);
                                    if (pencilToolView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.visible_toolbar))) != null) {
                                        return new AnnotationToolbarDrawBinding(constraintLayout, constraintLayout, markupButton, markupButton2, markupButton3, appCompatImageButton, group, eraserToolView, markerToolView, pencilToolView, viewFindChildViewById);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
