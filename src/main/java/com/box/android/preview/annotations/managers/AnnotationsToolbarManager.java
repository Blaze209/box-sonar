package com.box.android.preview.annotations.managers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.box.android.preview.R;
import com.box.android.preview.annotations.ui.views.AnnotationToolbarView;
import com.box.android.preview.annotations.ui.views.ColorPickerFragment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationsToolbarManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\b\u0010&\u001a\u00020$H\u0002J\u0006\u0010'\u001a\u00020$J\u0006\u0010(\u001a\u00020$J\u0006\u0010)\u001a\u00020$J\u0006\u0010*\u001a\u00020$J\u0006\u0010+\u001a\u00020$J\u0006\u0010,\u001a\u00020$J\b\u0010-\u001a\u00020$H\u0007J\u0010\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0006H\u0002J\u0018\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\u0006H\u0002J\u0006\u00103\u001a\u00020$J\u0010\u00104\u001a\u00020$2\b\b\u0002\u00105\u001a\u00020\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/box/android/preview/annotations/managers/AnnotationsToolbarManager;", "", "<init>", "()V", "_selectedToolLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/box/android/preview/annotations/managers/BoxAnnotationTool;", "selectedToolLiveData", "Landroidx/lifecycle/LiveData;", "getSelectedToolLiveData", "()Landroidx/lifecycle/LiveData;", "_selectedColorLiveData", "Lkotlin/Pair;", "", "selectedColorLiveData", "getSelectedColorLiveData", "_markupTypeLiveData", "Lcom/box/android/preview/annotations/managers/MarkupState;", "Lcom/box/android/preview/annotations/managers/BoxAnnotationMarkupType;", "markupTypeLiveData", "getMarkupTypeLiveData", "value", "Lcom/box/android/preview/annotations/ui/views/AnnotationToolbarView;", "annotationToolbar", "getAnnotationToolbar", "()Lcom/box/android/preview/annotations/ui/views/AnnotationToolbarView;", "setAnnotationToolbar", "(Lcom/box/android/preview/annotations/ui/views/AnnotationToolbarView;)V", "parent", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "selectedAnnotationTool", "displayAnnotationToolbar", "", "resetToMarker", "setupToolbar", "exitCreationMode", "showToolbar", "hideToolbar", "showToolbarAlt", "hideToolbarAlt", "closeAnnotationToolbar", "displayColorPicker", "handleToolSelection", "annotationTool", "handleColorSelection", "color", "tool", "cancelExitOrSwitch", "enterAnnotationMarkupMode", "annotationMarkupType", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationsToolbarManager {
    public static final int $stable = 8;
    private final MutableLiveData<Pair<MarkupState, BoxAnnotationMarkupType>> _markupTypeLiveData;
    private final MutableLiveData<Pair<Integer, BoxAnnotationTool>> _selectedColorLiveData;
    private final MutableLiveData<BoxAnnotationTool> _selectedToolLiveData;
    private AnnotationToolbarView annotationToolbar;
    private final LiveData<Pair<MarkupState, BoxAnnotationMarkupType>> markupTypeLiveData;
    public ViewGroup parent;
    private BoxAnnotationTool selectedAnnotationTool;
    private final LiveData<Pair<Integer, BoxAnnotationTool>> selectedColorLiveData;
    private final LiveData<BoxAnnotationTool> selectedToolLiveData;

    /* JADX INFO: compiled from: AnnotationsToolbarManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BoxAnnotationMarkupType.values().length];
            try {
                iArr[BoxAnnotationMarkupType.DRAW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BoxAnnotationMarkupType.REGION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BoxAnnotationMarkupType.HIGHLIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BoxAnnotationMarkupType.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public AnnotationsToolbarManager() {
        MutableLiveData<BoxAnnotationTool> mutableLiveData = new MutableLiveData<>();
        this._selectedToolLiveData = mutableLiveData;
        this.selectedToolLiveData = mutableLiveData;
        MutableLiveData<Pair<Integer, BoxAnnotationTool>> mutableLiveData2 = new MutableLiveData<>();
        this._selectedColorLiveData = mutableLiveData2;
        this.selectedColorLiveData = mutableLiveData2;
        MutableLiveData<Pair<MarkupState, BoxAnnotationMarkupType>> mutableLiveData3 = new MutableLiveData<>();
        this._markupTypeLiveData = mutableLiveData3;
        this.markupTypeLiveData = mutableLiveData3;
    }

    public final LiveData<BoxAnnotationTool> getSelectedToolLiveData() {
        return this.selectedToolLiveData;
    }

    public final LiveData<Pair<Integer, BoxAnnotationTool>> getSelectedColorLiveData() {
        return this.selectedColorLiveData;
    }

    public final LiveData<Pair<MarkupState, BoxAnnotationMarkupType>> getMarkupTypeLiveData() {
        return this.markupTypeLiveData;
    }

    public final AnnotationToolbarView getAnnotationToolbar() {
        return this.annotationToolbar;
    }

    public final void setAnnotationToolbar(AnnotationToolbarView annotationToolbarView) {
        this.annotationToolbar = annotationToolbarView;
        setupToolbar();
    }

    public final ViewGroup getParent() {
        ViewGroup viewGroup = this.parent;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("parent");
        return null;
    }

    public final void setParent(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.parent = viewGroup;
    }

    public final void displayAnnotationToolbar() {
        AnnotationToolbarView annotationToolbarView = this.annotationToolbar;
        if (annotationToolbarView != null) {
            annotationToolbarView.showAtLocation(getParent(), 80, 0, 0);
        }
        enterAnnotationMarkupMode$default(this, null, 1, null);
        AnnotationToolbarView annotationToolbarView2 = this.annotationToolbar;
        if (annotationToolbarView2 != null) {
            annotationToolbarView2.selectTool(BoxAnnotationTool.MARKER);
        }
    }

    public final void resetToMarker() {
        AnnotationToolbarView annotationToolbarView = this.annotationToolbar;
        if (annotationToolbarView != null) {
            annotationToolbarView.selectTool(BoxAnnotationTool.MARKER);
        }
    }

    private final void setupToolbar() {
        AnnotationToolbarView annotationToolbarView = this.annotationToolbar;
        if (annotationToolbarView != null) {
            annotationToolbarView.setOnSelectedToolChanged(new Function1() { // from class: com.box.android.preview.annotations.managers.AnnotationsToolbarManager$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AnnotationsToolbarManager.setupToolbar$lambda$0(this.f$0, (BoxAnnotationTool) obj);
                }
            });
        }
        AnnotationToolbarView annotationToolbarView2 = this.annotationToolbar;
        if (annotationToolbarView2 != null) {
            annotationToolbarView2.setOnMarkupTypeChanged(new Function1() { // from class: com.box.android.preview.annotations.managers.AnnotationsToolbarManager$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AnnotationsToolbarManager.setupToolbar$lambda$1(this.f$0, (Pair) obj);
                }
            });
        }
        AnnotationToolbarView annotationToolbarView3 = this.annotationToolbar;
        if (annotationToolbarView3 != null) {
            annotationToolbarView3.setOnColorPickerClicked(new Function0() { // from class: com.box.android.preview.annotations.managers.AnnotationsToolbarManager$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AnnotationsToolbarManager.setupToolbar$lambda$2(this.f$0);
                }
            });
        }
        AnnotationToolbarView annotationToolbarView4 = this.annotationToolbar;
        if (annotationToolbarView4 != null) {
            annotationToolbarView4.setOnToolColorChanged(new Function2() { // from class: com.box.android.preview.annotations.managers.AnnotationsToolbarManager$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AnnotationsToolbarManager.setupToolbar$lambda$3(this.f$0, ((Integer) obj).intValue(), (BoxAnnotationTool) obj2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupToolbar$lambda$0(AnnotationsToolbarManager annotationsToolbarManager, BoxAnnotationTool newTool) {
        Intrinsics.checkNotNullParameter(newTool, "newTool");
        annotationsToolbarManager.handleToolSelection(newTool);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupToolbar$lambda$1(AnnotationsToolbarManager annotationsToolbarManager, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        annotationsToolbarManager._markupTypeLiveData.postValue(new Pair<>((MarkupState) pair.component1(), (BoxAnnotationMarkupType) pair.component2()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupToolbar$lambda$2(AnnotationsToolbarManager annotationsToolbarManager) {
        annotationsToolbarManager.displayColorPicker();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupToolbar$lambda$3(AnnotationsToolbarManager annotationsToolbarManager, int i, BoxAnnotationTool tool) {
        Intrinsics.checkNotNullParameter(tool, "tool");
        annotationsToolbarManager.handleColorSelection(i, tool);
        return Unit.INSTANCE;
    }

    public final void exitCreationMode() {
        AnnotationToolbarView annotationToolbarView = this.annotationToolbar;
        if (annotationToolbarView != null) {
            annotationToolbarView.exitCreationMode();
        }
    }

    public final void showToolbar() {
        View contentView;
        AnnotationToolbarView annotationToolbarView = this.annotationToolbar;
        if (annotationToolbarView == null || (contentView = annotationToolbarView.getContentView()) == null) {
            return;
        }
        contentView.setVisibility(0);
    }

    public final void hideToolbar() {
        View contentView;
        AnnotationToolbarView annotationToolbarView = this.annotationToolbar;
        if (annotationToolbarView == null || (contentView = annotationToolbarView.getContentView()) == null) {
            return;
        }
        contentView.setVisibility(4);
    }

    public final void showToolbarAlt() {
        AnnotationToolbarView annotationToolbarView = this.annotationToolbar;
        if (annotationToolbarView != null) {
            annotationToolbarView.update(-1, (int) getParent().getResources().getDimension(R.dimen.box_previewsdk_annotation_bar_height));
        }
    }

    public final void hideToolbarAlt() {
        AnnotationToolbarView annotationToolbarView = this.annotationToolbar;
        if (annotationToolbarView != null) {
            annotationToolbarView.update(-1, 1);
        }
    }

    public final void closeAnnotationToolbar() {
        AnnotationToolbarView annotationToolbarView = this.annotationToolbar;
        if (annotationToolbarView != null) {
            annotationToolbarView.dismiss();
        }
    }

    public final void displayColorPicker() {
        ColorPickerFragment.Companion companion = ColorPickerFragment.INSTANCE;
        Pair<Integer, BoxAnnotationTool> value = this._selectedColorLiveData.getValue();
        ColorPickerFragment colorPickerFragmentNewInstance = companion.newInstance(value != null ? value.getFirst() : null);
        colorPickerFragmentNewInstance.setOnColorPicked(new Function1() { // from class: com.box.android.preview.annotations.managers.AnnotationsToolbarManager$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AnnotationsToolbarManager.displayColorPicker$lambda$0$0(this.f$0, ((Integer) obj).intValue());
            }
        });
        AnnotationToolbarView annotationToolbarView = this.annotationToolbar;
        Context context = annotationToolbarView != null ? annotationToolbarView.getContext() : null;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        colorPickerFragmentNewInstance.show(((AppCompatActivity) context).getSupportFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit displayColorPicker$lambda$0$0(AnnotationsToolbarManager annotationsToolbarManager, int i) {
        AnnotationToolbarView annotationToolbarView = annotationsToolbarManager.annotationToolbar;
        if (annotationToolbarView != null) {
            annotationToolbarView.setColor(i);
        }
        return Unit.INSTANCE;
    }

    private final void handleToolSelection(BoxAnnotationTool annotationTool) {
        this.selectedAnnotationTool = annotationTool;
        this._selectedToolLiveData.postValue(annotationTool);
    }

    private final void handleColorSelection(int color, BoxAnnotationTool tool) {
        this._selectedColorLiveData.postValue(new Pair<>(Integer.valueOf(color), tool));
    }

    public final void cancelExitOrSwitch() {
        AnnotationToolbarView annotationToolbarView = this.annotationToolbar;
        if (annotationToolbarView != null) {
            annotationToolbarView.setMarkUpStateToActive();
        }
    }

    public static /* synthetic */ void enterAnnotationMarkupMode$default(AnnotationsToolbarManager annotationsToolbarManager, BoxAnnotationMarkupType boxAnnotationMarkupType, int i, Object obj) {
        if ((i & 1) != 0) {
            boxAnnotationMarkupType = BoxAnnotationMarkupType.DRAW;
        }
        annotationsToolbarManager.enterAnnotationMarkupMode(boxAnnotationMarkupType);
    }

    public final void enterAnnotationMarkupMode(BoxAnnotationMarkupType annotationMarkupType) {
        Intrinsics.checkNotNullParameter(annotationMarkupType, "annotationMarkupType");
        AnnotationToolbarView annotationToolbarView = this.annotationToolbar;
        if (annotationToolbarView != null) {
            annotationToolbarView.selectAnnotationCreationMode(annotationMarkupType);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[annotationMarkupType.ordinal()];
        if (i == 1) {
            handleToolSelection(BoxAnnotationTool.MARKER);
        } else if (i != 2 && i != 3 && i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
