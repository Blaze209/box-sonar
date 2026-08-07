package com.box.android.base.presentation.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.box.android.base.R;

/* JADX INFO: loaded from: classes9.dex */
public class OKCancelView extends LinearLayout {
    private Button mCancelButton;
    private Button mOkButton;

    public interface OKCancelClickListener {
        void onCancelClicked();

        void onOKClicked();
    }

    public OKCancelView(Context context, AttributeSet attributeSet) {
        String string;
        super(context, attributeSet);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.ok_cancel_layout, (ViewGroup) this, true);
        this.mOkButton = (Button) findViewById(R.id.btnOK);
        this.mCancelButton = (Button) findViewById(R.id.btnCancel);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OKCancelView);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R.styleable.OKCancelView_okButtonText) {
                String string2 = typedArrayObtainStyledAttributes.getString(index);
                if (string2 != null) {
                    this.mOkButton.setText(string2);
                }
            } else if (index == R.styleable.OKCancelView_cancelButtonText && (string = typedArrayObtainStyledAttributes.getString(index)) != null) {
                this.mCancelButton.setText(string);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setOnClickListener(final OKCancelClickListener oKCancelClickListener) {
        findViewById(R.id.btnOK).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.base.presentation.views.OKCancelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                oKCancelClickListener.onOKClicked();
            }
        });
        findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() { // from class: com.box.android.base.presentation.views.OKCancelView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                oKCancelClickListener.onCancelClicked();
            }
        });
    }

    public Button getOKButton() {
        return this.mOkButton;
    }

    public Button getCancelButton() {
        return this.mCancelButton;
    }

    public void hideOKButton() {
        this.mOkButton.setVisibility(8);
    }
}
