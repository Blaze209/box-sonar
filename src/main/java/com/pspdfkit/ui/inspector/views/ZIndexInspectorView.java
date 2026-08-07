package com.pspdfkit.ui.inspector.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.annotations.AnnotationZIndexMove;
import com.pspdfkit.internal.ex;
import com.pspdfkit.internal.f60;
import com.pspdfkit.ui.inspector.PropertyInspectorController;
import com.pspdfkit.ui.inspector.PropertyInspectorView;

/* JADX INFO: loaded from: classes3.dex */
public class ZIndexInspectorView extends FrameLayout implements PropertyInspectorView, View.OnClickListener {
    private final ImageButton moveBackward;
    private final ImageButton moveForward;
    private final ImageButton moveToBack;
    private final ImageButton moveToFront;
    private final ZIndexChangeListener zIndexChangeListener;

    public interface ZIndexChangeListener {
        void onMoveExecuted(ZIndexInspectorView zIndexInspectorView, AnnotationZIndexMove annotationZIndexMove);
    }

    public ZIndexInspectorView(Context context, String str, ZIndexChangeListener zIndexChangeListener) {
        super(context);
        this.zIndexChangeListener = zIndexChangeListener;
        Context context2 = getContext();
        TypedArray typedArrayA = ex.a(context2);
        int dimensionPixelSize = typedArrayA.getDimensionPixelSize(R.styleable.pspdf__PropertyInspector_pspdf__itemHeight, context2.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_item_height));
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__backgroundColor, -1);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__progressBackgroundTint, -7829368);
        int color = typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__textColor, -7829368);
        typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__errorColor, ContextCompat.getColor(context2, R.color.pspdf__errorContainerLight));
        ContextCompat.getColor(context2, R.color.pspdf__outlineVariantLight);
        typedArrayA.getBoolean(R.styleable.pspdf__PropertyInspector_pspdf__searchVisible, false);
        int color2 = typedArrayA.getColor(R.styleable.pspdf__PropertyInspector_pspdf__buttonIconTint, f60.a(context2, androidx.appcompat.R.attr.colorAccent, R.color.pspdf__primaryLight));
        typedArrayA.recycle();
        float dimension = context2.getResources().getDimension(R.dimen.pspdf__inspector_text_size);
        context2.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_preview_item_height);
        context2.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_padding);
        context2.getResources().getDimensionPixelSize(R.dimen.pspdf__inspector_vertical_padding);
        View.inflate(getContext(), R.layout.pspdf__view_inspector_z_index_picker, this).setMinimumHeight(dimensionPixelSize);
        TextView textView = (TextView) findViewById(R.id.pspdf__label);
        textView.setTextSize(0, dimension);
        textView.setTextColor(color);
        textView.setText(str);
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(color2);
        this.moveToFront = initImageButton(R.id.pspdf__move_to_front, colorStateListValueOf);
        this.moveForward = initImageButton(R.id.pspdf__move_forward, colorStateListValueOf);
        this.moveBackward = initImageButton(R.id.pspdf__move_backward, colorStateListValueOf);
        this.moveToBack = initImageButton(R.id.pspdf__move_to_back, colorStateListValueOf);
    }

    private ImageButton initImageButton(int i, ColorStateList colorStateList) {
        ImageButton imageButton = (ImageButton) findViewById(i);
        if (imageButton == null) {
            throw new IllegalStateException("Button with ID " + i + " not found in ZIndexInspectorView.");
        }
        imageButton.setOnClickListener(this);
        imageButton.setImageTintList(colorStateList);
        return imageButton;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void bindController(PropertyInspectorController propertyInspectorController) {
    }

    public void disableBackwardMovements() {
        this.moveToBack.setEnabled(false);
        this.moveToBack.setAlpha(0.5f);
        this.moveBackward.setEnabled(false);
        this.moveBackward.setAlpha(0.5f);
    }

    public void disableForwardMovements() {
        this.moveToFront.setEnabled(false);
        this.moveToFront.setAlpha(0.5f);
        this.moveForward.setEnabled(false);
        this.moveForward.setAlpha(0.5f);
    }

    public void enableAllMovements() {
        this.moveToFront.setEnabled(true);
        this.moveToFront.setAlpha(1.0f);
        this.moveForward.setEnabled(true);
        this.moveForward.setAlpha(1.0f);
        this.moveToBack.setEnabled(true);
        this.moveToBack.setAlpha(1.0f);
        this.moveBackward.setEnabled(true);
        this.moveBackward.setAlpha(1.0f);
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMaxHeight() {
        return getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getPropertyInspectorMinHeight() {
        return getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public int getSuggestedHeight() {
        return getMeasuredHeight();
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public View getView() {
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.zIndexChangeListener == null) {
            return;
        }
        if (this.moveToFront.equals(view)) {
            this.zIndexChangeListener.onMoveExecuted(this, AnnotationZIndexMove.MOVE_TO_FRONT);
            return;
        }
        if (this.moveForward.equals(view)) {
            this.zIndexChangeListener.onMoveExecuted(this, AnnotationZIndexMove.MOVE_FORWARD);
        } else if (this.moveBackward.equals(view)) {
            this.zIndexChangeListener.onMoveExecuted(this, AnnotationZIndexMove.MOVE_BACKWARD);
        } else if (this.moveToBack.equals(view)) {
            this.zIndexChangeListener.onMoveExecuted(this, AnnotationZIndexMove.MOVE_TO_BACK);
        }
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorView
    public void unbindController() {
    }
}
