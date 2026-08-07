package com.box.android.base.presentation.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: classes9.dex */
public class KeyboardListeningEditText extends AppCompatEditText {
    private KeyboardListener mListener;

    public interface KeyboardListener {
        void onKeyboardClosed();

        void onKeyboardOpened();
    }

    public KeyboardListeningEditText(Context context) {
        super(context);
        init();
    }

    public KeyboardListeningEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public KeyboardListeningEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.box.android.base.presentation.views.KeyboardListeningEditText.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (KeyboardListeningEditText.this.mListener == null) {
                    return false;
                }
                KeyboardListeningEditText.this.mListener.onKeyboardOpened();
                return false;
            }
        });
        setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.box.android.base.presentation.views.KeyboardListeningEditText.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6 || KeyboardListeningEditText.this.mListener == null) {
                    return false;
                }
                KeyboardListeningEditText.this.mListener.onKeyboardClosed();
                return false;
            }
        });
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        KeyboardListener keyboardListener;
        if (keyEvent.getKeyCode() == 4 && (keyboardListener = this.mListener) != null) {
            keyboardListener.onKeyboardClosed();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public void setKeyboardListener(KeyboardListener keyboardListener) {
        this.mListener = keyboardListener;
    }
}
