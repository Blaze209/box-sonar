package com.box.android.preview.annotations.ui.views;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.ChangeBounds;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.preview.R;
import com.box.android.preview.annotations.managers.BoxAnnotationMarkupType;
import com.box.android.preview.annotations.managers.BoxAnnotationTool;
import com.box.android.preview.annotations.managers.MarkupState;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.intune.mam.client.widget.MAMPopupWindow;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationToolbarView.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u0000 q2\u00020\u00012\u00020\u0002:\u0001qB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010S\u001a\u00020!H\u0002J\u0012\u0010T\u001a\u00020!2\b\u0010U\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u00020(J\u0016\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u00020(2\u0006\u0010X\u001a\u00020 J\u0010\u0010Y\u001a\u00020!2\u0006\u0010W\u001a\u00020(H\u0002J\u0010\u0010Z\u001a\u00020!2\u0006\u0010[\u001a\u00020\u0013H\u0002J\u0016\u0010\\\u001a\u00020!2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020/J\u0010\u0010_\u001a\u00020!2\u0006\u0010]\u001a\u00020\u0007H\u0002J\u0010\u0010`\u001a\u00020(2\u0006\u0010]\u001a\u00020\u0007H\u0007J\u0012\u0010a\u001a\u0004\u0018\u00010E2\u0006\u0010]\u001a\u00020\u0007H\u0007J\u000e\u0010b\u001a\u00020!2\u0006\u0010]\u001a\u00020\u0007J\u0018\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u0007H\u0002J\u000e\u0010g\u001a\u00020!2\u0006\u0010h\u001a\u00020 J\u0006\u0010i\u001a\u00020!J*\u0010j\u001a\u00020!2\b\u0010k\u001a\u0004\u0018\u00010\u00042\u0006\u0010l\u001a\u00020(2\u0006\u0010m\u001a\u00020(2\u0006\u0010n\u001a\u00020(H\u0016J\b\u0010o\u001a\u00020!H\u0016J\u0006\u0010p\u001a\u00020!R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R.\u0010&\u001a\u0016\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R4\u0010-\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070.\u0012\u0004\u0012\u00020!\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\"\u00102\u001a\n\u0012\u0004\u0012\u00020!\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00108\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b9\u0010\u0015\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010>\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b?\u0010\u0015\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010J\u001a\u00020K8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bL\u0010\u0015\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u000e\u0010Q\u001a\u00020RX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/box/android/preview/annotations/ui/views/AnnotationToolbarView;", "Landroid/widget/PopupWindow;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/View;", "additionalSupportedMarkups", "", "Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;", "<init>", "(Landroid/view/View;Ljava/util/List;)V", "getView", "()Landroid/view/View;", "markerTool", "Lcom/box/android/preview/annotations/ui/views/MarkerToolView;", "pencilTool", "Lcom/box/android/preview/annotations/ui/views/PencilToolView;", "eraserTool", "Lcom/box/android/preview/annotations/ui/views/EraserToolView;", "selectedTool", "Lcom/box/android/preview/annotations/ui/views/AnnotationToolView;", "getSelectedTool$annotations", "()V", "getSelectedTool", "()Lcom/box/android/preview/annotations/ui/views/AnnotationToolView;", "setSelectedTool", "(Lcom/box/android/preview/annotations/ui/views/AnnotationToolView;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "onSelectedToolChanged", "Lkotlin/Function1;", "Lcom/box/android/preview/annotations/managers/BoxAnnotationTool;", "", "getOnSelectedToolChanged", "()Lkotlin/jvm/functions/Function1;", "setOnSelectedToolChanged", "(Lkotlin/jvm/functions/Function1;)V", "onToolColorChanged", "Lkotlin/Function2;", "", "getOnToolColorChanged", "()Lkotlin/jvm/functions/Function2;", "setOnToolColorChanged", "(Lkotlin/jvm/functions/Function2;)V", "onMarkupTypeChanged", "Lkotlin/Pair;", "Lcom/box/android/preview/annotations/managers/MarkupState;", "getOnMarkupTypeChanged", "setOnMarkupTypeChanged", "onColorPickerClicked", "Lkotlin/Function0;", "getOnColorPickerClicked", "()Lkotlin/jvm/functions/Function0;", "setOnColorPickerClicked", "(Lkotlin/jvm/functions/Function0;)V", "currMarkupState", "getCurrMarkupState$annotations", "getCurrMarkupState", "()Lcom/box/android/preview/annotations/managers/MarkupState;", "setCurrMarkupState", "(Lcom/box/android/preview/annotations/managers/MarkupState;)V", "currentMarkupType", "getCurrentMarkupType$annotations", "getCurrentMarkupType", "()Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;", "setCurrentMarkupType", "(Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;)V", "drawButton", "Lcom/box/android/preview/annotations/ui/views/MarkupButton;", "colorPicker", "Landroidx/appcompat/widget/AppCompatImageButton;", "regionButton", "highlightButton", "constraintSet", "Landroidx/constraintlayout/widget/ConstraintSet;", "getConstraintSet$annotations", "getConstraintSet", "()Landroidx/constraintlayout/widget/ConstraintSet;", "setConstraintSet", "(Landroidx/constraintlayout/widget/ConstraintSet;)V", "constraint", "Landroidx/constraintlayout/widget/ConstraintLayout;", "showAdditionalSupportedMarkups", ViewProps.ON_CLICK, "v", "setColor", "color", "tool", "setColorPickerColor", "selectToolView", "annotationToolView", "handleMarkupTypeSelected", "annotationMarkupType", "newMarkupState", "animateLayoutChanges", "selectLayout", "getButton", "selectAnnotationCreationMode", "shouldExit", "", "selectedMarkupType", "previousMarkupType", "selectTool", "annotationTool", "exitCreationMode", "showAtLocation", "parent", "gravity", "x", "y", BoxAnalyticsParams.ACTION_DISMISS, "setMarkUpStateToActive", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationToolbarView extends MAMPopupWindow implements View.OnClickListener {
    private static final String LOG_TAG = "AnnotationToolbarView";
    public static final long MARKUP_SWITCH_ANIM_DURATION = 150;
    private final List<BoxAnnotationMarkupType> additionalSupportedMarkups;
    private AppCompatImageButton colorPicker;
    private ConstraintLayout constraint;
    private ConstraintSet constraintSet;
    private final Context context;
    private MarkupState currMarkupState;
    private BoxAnnotationMarkupType currentMarkupType;
    private MarkupButton drawButton;
    private EraserToolView eraserTool;
    private MarkupButton highlightButton;
    private MarkerToolView markerTool;
    private Function0<Unit> onColorPickerClicked;
    private Function1<? super Pair<? extends MarkupState, ? extends BoxAnnotationMarkupType>, Unit> onMarkupTypeChanged;
    private Function1<? super BoxAnnotationTool, Unit> onSelectedToolChanged;
    private Function2<? super Integer, ? super BoxAnnotationTool, Unit> onToolColorChanged;
    private PencilToolView pencilTool;
    private MarkupButton regionButton;
    private AnnotationToolView selectedTool;
    private final View view;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: AnnotationToolbarView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[BoxAnnotationTool.values().length];
            try {
                iArr[BoxAnnotationTool.MARKER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BoxAnnotationTool.PENCIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BoxAnnotationTool.ERASER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BoxAnnotationMarkupType.values().length];
            try {
                iArr2[BoxAnnotationMarkupType.DRAW.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[BoxAnnotationMarkupType.REGION.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[BoxAnnotationMarkupType.HIGHLIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[BoxAnnotationMarkupType.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static /* synthetic */ void getConstraintSet$annotations() {
    }

    public static /* synthetic */ void getCurrMarkupState$annotations() {
    }

    public static /* synthetic */ void getCurrentMarkupType$annotations() {
    }

    public static /* synthetic */ void getSelectedTool$annotations() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AnnotationToolbarView(View view, List<? extends BoxAnnotationMarkupType> additionalSupportedMarkups) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(additionalSupportedMarkups, "additionalSupportedMarkups");
        this.view = view;
        this.additionalSupportedMarkups = additionalSupportedMarkups;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.context = context;
        this.currMarkupState = MarkupState.INACTIVE;
        this.currentMarkupType = BoxAnnotationMarkupType.NONE;
        this.constraintSet = new ConstraintSet();
        setHeight((int) context.getResources().getDimension(R.dimen.box_previewsdk_annotation_bar_height));
        setWidth(-1);
        setOutsideTouchable(false);
        setBackgroundDrawable(new ColorDrawable(0));
        View viewFindViewById = view.findViewById(R.id.annotation_toolbar_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.constraint = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.marker_tool);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.markerTool = (MarkerToolView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.pencil_tool);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.pencilTool = (PencilToolView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.eraser_tool);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.eraserTool = (EraserToolView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.annotations_region);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.regionButton = (MarkupButton) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.annotations_highlight);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.highlightButton = (MarkupButton) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.annotations_draw);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.drawButton = (MarkupButton) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.color_picker);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.colorPicker = (AppCompatImageButton) viewFindViewById8;
        AnnotationToolbarView annotationToolbarView = this;
        this.markerTool.setOnClickListener(annotationToolbarView);
        this.pencilTool.setOnClickListener(annotationToolbarView);
        this.eraserTool.setOnClickListener(annotationToolbarView);
        this.drawButton.setOnClickListener(annotationToolbarView);
        this.colorPicker.setOnClickListener(annotationToolbarView);
        this.regionButton.setOnClickListener(annotationToolbarView);
        showAdditionalSupportedMarkups();
        view.setOnClickListener(annotationToolbarView);
    }

    public final View getView() {
        return this.view;
    }

    public final AnnotationToolView getSelectedTool() {
        return this.selectedTool;
    }

    public final void setSelectedTool(AnnotationToolView annotationToolView) {
        this.selectedTool = annotationToolView;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Function1<BoxAnnotationTool, Unit> getOnSelectedToolChanged() {
        return this.onSelectedToolChanged;
    }

    public final void setOnSelectedToolChanged(Function1<? super BoxAnnotationTool, Unit> function1) {
        this.onSelectedToolChanged = function1;
    }

    public final Function2<Integer, BoxAnnotationTool, Unit> getOnToolColorChanged() {
        return this.onToolColorChanged;
    }

    public final void setOnToolColorChanged(Function2<? super Integer, ? super BoxAnnotationTool, Unit> function2) {
        this.onToolColorChanged = function2;
    }

    public final Function1<Pair<? extends MarkupState, ? extends BoxAnnotationMarkupType>, Unit> getOnMarkupTypeChanged() {
        return this.onMarkupTypeChanged;
    }

    public final void setOnMarkupTypeChanged(Function1<? super Pair<? extends MarkupState, ? extends BoxAnnotationMarkupType>, Unit> function1) {
        this.onMarkupTypeChanged = function1;
    }

    public final Function0<Unit> getOnColorPickerClicked() {
        return this.onColorPickerClicked;
    }

    public final void setOnColorPickerClicked(Function0<Unit> function0) {
        this.onColorPickerClicked = function0;
    }

    public final MarkupState getCurrMarkupState() {
        return this.currMarkupState;
    }

    public final void setCurrMarkupState(MarkupState markupState) {
        Intrinsics.checkNotNullParameter(markupState, "<set-?>");
        this.currMarkupState = markupState;
    }

    public final BoxAnnotationMarkupType getCurrentMarkupType() {
        return this.currentMarkupType;
    }

    public final void setCurrentMarkupType(BoxAnnotationMarkupType boxAnnotationMarkupType) {
        Intrinsics.checkNotNullParameter(boxAnnotationMarkupType, "<set-?>");
        this.currentMarkupType = boxAnnotationMarkupType;
    }

    public final ConstraintSet getConstraintSet() {
        return this.constraintSet;
    }

    public final void setConstraintSet(ConstraintSet constraintSet) {
        Intrinsics.checkNotNullParameter(constraintSet, "<set-?>");
        this.constraintSet = constraintSet;
    }

    private final void showAdditionalSupportedMarkups() {
        Iterator<T> it = this.additionalSupportedMarkups.iterator();
        while (it.hasNext()) {
            MarkupButton button = getButton((BoxAnnotationMarkupType) it.next());
            if (button != null) {
                button.setVisibility(0);
            }
            if (button != null) {
                button.setOnClickListener(this);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Function0<Unit> function0;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.marker_tool;
        if (numValueOf != null && numValueOf.intValue() == i) {
            selectTool(BoxAnnotationTool.MARKER);
            return;
        }
        int i2 = R.id.pencil_tool;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            selectTool(BoxAnnotationTool.PENCIL);
            return;
        }
        int i3 = R.id.eraser_tool;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            selectTool(BoxAnnotationTool.ERASER);
            return;
        }
        int i4 = R.id.annotations_draw;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            selectAnnotationCreationMode(BoxAnnotationMarkupType.DRAW);
            return;
        }
        int i5 = R.id.annotations_region;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            selectAnnotationCreationMode(BoxAnnotationMarkupType.REGION);
            return;
        }
        int i6 = R.id.annotations_highlight;
        if (numValueOf != null && numValueOf.intValue() == i6) {
            selectAnnotationCreationMode(BoxAnnotationMarkupType.HIGHLIGHT);
            return;
        }
        int i7 = R.id.color_picker;
        if (numValueOf == null || numValueOf.intValue() != i7 || (function0 = this.onColorPickerClicked) == null) {
            return;
        }
        function0.invoke();
    }

    public final void setColor(int color) {
        BoxAnnotationTool boxAnnotationTool;
        Function2<? super Integer, ? super BoxAnnotationTool, Unit> function2;
        setColorPickerColor(color);
        AnnotationToolView annotationToolView = this.selectedTool;
        if (annotationToolView != null) {
            annotationToolView.setColor(color);
        }
        AnnotationToolView annotationToolView2 = this.selectedTool;
        if (annotationToolView2 instanceof MarkerToolView) {
            boxAnnotationTool = BoxAnnotationTool.MARKER;
        } else {
            boxAnnotationTool = annotationToolView2 instanceof PencilToolView ? BoxAnnotationTool.PENCIL : null;
        }
        if (boxAnnotationTool == null || (function2 = this.onToolColorChanged) == null) {
            return;
        }
        function2.invoke(Integer.valueOf(color), boxAnnotationTool);
    }

    public final void setColor(int color, BoxAnnotationTool tool) {
        MarkerToolView markerToolView;
        Intrinsics.checkNotNullParameter(tool, "tool");
        int i = WhenMappings.$EnumSwitchMapping$0[tool.ordinal()];
        if (i == 1) {
            markerToolView = this.markerTool;
        } else {
            markerToolView = i != 2 ? null : this.pencilTool;
        }
        if (markerToolView != null) {
            markerToolView.setColor(color);
            if (Intrinsics.areEqual(this.selectedTool, markerToolView)) {
                setColorPickerColor(color);
            }
        }
    }

    private final void setColorPickerColor(int color) {
        Drawable drawable = this.colorPicker.getDrawable();
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        ((LayerDrawable) drawable).findDrawableByLayerId(R.id.color_indicator).setTint(color);
    }

    private final void selectToolView(AnnotationToolView annotationToolView) {
        AnnotationToolView annotationToolView2 = this.selectedTool;
        if (annotationToolView2 != null) {
            annotationToolView2.deselectTool();
        }
        annotationToolView.selectTool();
        this.selectedTool = annotationToolView;
    }

    public final void handleMarkupTypeSelected(BoxAnnotationMarkupType annotationMarkupType, MarkupState newMarkupState) {
        Intrinsics.checkNotNullParameter(annotationMarkupType, "annotationMarkupType");
        Intrinsics.checkNotNullParameter(newMarkupState, "newMarkupState");
        if (newMarkupState != MarkupState.ACTIVE || annotationMarkupType == BoxAnnotationMarkupType.NONE) {
            if (annotationMarkupType == BoxAnnotationMarkupType.NONE) {
                this.currentMarkupType = BoxAnnotationMarkupType.NONE;
                return;
            }
            return;
        }
        this.currentMarkupType = annotationMarkupType;
        if (annotationMarkupType != BoxAnnotationMarkupType.DRAW) {
            selectToolView(this.markerTool);
            Integer selectedColorResource = this.markerTool.getSelectedColorResource();
            if (selectedColorResource != null) {
                setColor(selectedColorResource.intValue());
            }
        }
        Iterator<BoxAnnotationMarkupType> it = BoxAnnotationMarkupType.getEntries().iterator();
        while (it.hasNext()) {
            BoxAnnotationMarkupType next = it.next();
            MarkupButton button = getButton(next);
            if (button != null) {
                button.selectButton(next == annotationMarkupType);
            }
        }
        animateLayoutChanges(annotationMarkupType);
        showAdditionalSupportedMarkups();
    }

    private final void animateLayoutChanges(BoxAnnotationMarkupType annotationMarkupType) {
        ChangeBounds slide;
        if (annotationMarkupType == BoxAnnotationMarkupType.DRAW) {
            slide = new Slide();
        } else {
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.setStartDelay(0L);
            changeBounds.setDuration(150L);
            slide = changeBounds;
        }
        this.constraintSet.clone(this.context, selectLayout(annotationMarkupType));
        TransitionManager.beginDelayedTransition(this.constraint, slide);
        this.constraintSet.applyTo(this.constraint);
    }

    public final int selectLayout(BoxAnnotationMarkupType annotationMarkupType) {
        Intrinsics.checkNotNullParameter(annotationMarkupType, "annotationMarkupType");
        int i = WhenMappings.$EnumSwitchMapping$1[annotationMarkupType.ordinal()];
        if (i == 1) {
            return R.layout.annotation_toolbar_draw;
        }
        if (i == 2) {
            return R.layout.annotation_toolbar_non_draw;
        }
        if (i == 3) {
            return R.layout.annotation_toolbar_non_draw;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return R.layout.annotation_toolbar_draw;
    }

    public final MarkupButton getButton(BoxAnnotationMarkupType annotationMarkupType) {
        Intrinsics.checkNotNullParameter(annotationMarkupType, "annotationMarkupType");
        int i = WhenMappings.$EnumSwitchMapping$1[annotationMarkupType.ordinal()];
        if (i == 1) {
            return this.drawButton;
        }
        if (i == 2) {
            return this.regionButton;
        }
        if (i == 3) {
            return this.highlightButton;
        }
        if (i == 4) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void selectAnnotationCreationMode(BoxAnnotationMarkupType annotationMarkupType) {
        Intrinsics.checkNotNullParameter(annotationMarkupType, "annotationMarkupType");
        MarkupState markupState = this.currMarkupState == MarkupState.ACTIVE ? MarkupState.SWITCHING : MarkupState.ACTIVE;
        if (shouldExit(this.currentMarkupType, annotationMarkupType)) {
            markupState = MarkupState.EXITING;
        } else {
            handleMarkupTypeSelected(annotationMarkupType, markupState);
        }
        this.currMarkupState = markupState;
        Function1<? super Pair<? extends MarkupState, ? extends BoxAnnotationMarkupType>, Unit> function1 = this.onMarkupTypeChanged;
        if (function1 != null) {
            function1.invoke(new Pair(markupState, annotationMarkupType));
        }
    }

    private final boolean shouldExit(BoxAnnotationMarkupType selectedMarkupType, BoxAnnotationMarkupType previousMarkupType) {
        return selectedMarkupType == previousMarkupType && this.currMarkupState == MarkupState.ACTIVE;
    }

    public final void selectTool(BoxAnnotationTool annotationTool) {
        Intrinsics.checkNotNullParameter(annotationTool, "annotationTool");
        Function1<? super BoxAnnotationTool, Unit> function1 = this.onSelectedToolChanged;
        if (function1 != null) {
            function1.invoke(annotationTool);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[annotationTool.ordinal()];
        if (i == 1) {
            if (Intrinsics.areEqual(this.markerTool, this.selectedTool)) {
                return;
            }
            selectToolView(this.markerTool);
            Integer selectedColorResource = this.markerTool.getSelectedColorResource();
            if (selectedColorResource != null) {
                setColor(selectedColorResource.intValue());
                return;
            }
            return;
        }
        if (i != 2) {
            if (i == 3) {
                if (Intrinsics.areEqual(this.eraserTool, this.selectedTool)) {
                    return;
                }
                selectToolView(this.eraserTool);
                return;
            }
            BoxLogUtils.e(LOG_TAG, "Unexpected else branch");
            return;
        }
        if (Intrinsics.areEqual(this.pencilTool, this.selectedTool)) {
            return;
        }
        selectToolView(this.pencilTool);
        Integer selectedColorResource2 = this.pencilTool.getSelectedColorResource();
        if (selectedColorResource2 != null) {
            setColor(selectedColorResource2.intValue());
        }
    }

    public final void exitCreationMode() {
        AnnotationToolView annotationToolView = this.selectedTool;
        if (annotationToolView != null) {
            annotationToolView.deselectTool();
        }
        this.selectedTool = null;
        this.currentMarkupType = BoxAnnotationMarkupType.NONE;
        Function1<? super Pair<? extends MarkupState, ? extends BoxAnnotationMarkupType>, Unit> function1 = this.onMarkupTypeChanged;
        if (function1 != null) {
            function1.invoke(new Pair(MarkupState.INACTIVE, this.currentMarkupType));
        }
        dismiss();
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View parent, int gravity, int x, int y) {
        getContentView().setAnimation(AnimationUtils.loadAnimation(this.context, R.anim.slide_up));
        super.showAtLocation(parent, gravity, x, y);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        new ConstraintSet().clone(this.constraint);
        Slide slide = new Slide(80);
        slide.setDuration(this.context.getResources().getInteger(android.R.integer.config_shortAnimTime));
        slide.addTarget(getContentView());
        TransitionManager.beginDelayedTransition(this.constraint, slide);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.slide_down);
        getContentView().startAnimation(animationLoadAnimation);
        getContentView().postDelayed(new Runnable() { // from class: com.box.android.preview.annotations.ui.views.AnnotationToolbarView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                super/*com.microsoft.intune.mam.client.widget.MAMPopupWindow*/.dismiss();
            }
        }, (long) (animationLoadAnimation.getDuration() * 0.95d));
    }

    public final void setMarkUpStateToActive() {
        this.currMarkupState = MarkupState.ACTIVE;
    }
}
