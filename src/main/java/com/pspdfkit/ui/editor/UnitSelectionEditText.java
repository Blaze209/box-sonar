package com.pspdfkit.ui.editor;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.box.android.data.api.models.MetadataReservedKeys;
import com.pspdfkit.internal.c30;
import com.pspdfkit.internal.hn;
import com.pspdfkit.internal.uw;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class UnitSelectionEditText extends ScreenAdjustingEditText {
    private static final int ACTION_ID = 6;
    private static final String EMPTY = "";
    private static final String REGEX_ALL_NOT_DIGITS = "[^0-9]";
    private static final String REGEX_ONLY_DIGITS = "[0-9]";
    private Pattern compiledInputStringPattern;
    private int defaultValue;
    private UnitSelectionListener listener;
    private int maximumValue;
    private int minimumValue;
    private TextView.OnEditorActionListener onEditorActionListener;
    private View.OnFocusChangeListener onFocusChangeListener;
    private TextWatcher textWatcher;
    private String unit;
    private String unitLabel;
    private int unitLengthNotSelectable;

    public interface UnitSelectionListener {
        void onValueSet(UnitSelectionEditText unitSelectionEditText, int i);
    }

    public UnitSelectionEditText(Context context) {
        super(context);
        this.unitLabel = "";
        init();
    }

    private void generateCompiledInputStringPattern(int i) {
        int length = String.valueOf(i).length();
        Locale locale = Locale.US;
        this.compiledInputStringPattern = Pattern.compile("^\\d{0," + length + "}" + this.unit + MetadataReservedKeys.PREFIX);
    }

    private void init() {
        this.unitLengthNotSelectable = 0;
        setImeOptions(6);
        this.unitLabel = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setUnitLabel$0(View view, boolean z) {
        if (z) {
            setSelection(0, getText().toString().lastIndexOf(this.unit));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setUnitLabel$1(UnitSelectionListener unitSelectionListener, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        hn.c(textView);
        if (unitSelectionListener != null) {
            unitSelectionListener.onValueSet(this, getValue());
        }
        clearFocus();
        return true;
    }

    public void focusCheck() {
        if (hasFocus()) {
            setSelection(0, getText().toString().lastIndexOf(this.unit));
        }
    }

    public int getDefaultValue() {
        return this.defaultValue;
    }

    public int getMaximumValue() {
        return this.maximumValue;
    }

    public int getMinimumValue() {
        return this.minimumValue;
    }

    public String getUnitLabel() {
        return this.unitLabel;
    }

    public int getUnitLengthNotSelectable() {
        return this.unitLengthNotSelectable;
    }

    public int getValue() {
        Editable text = getText();
        return text == null ? this.defaultValue : parseValue(text.toString());
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (this.unitLengthNotSelectable > length()) {
            return;
        }
        if (i > length() - this.unitLengthNotSelectable || i2 > length() - this.unitLengthNotSelectable) {
            setSelection(length() - this.unitLengthNotSelectable);
        }
    }

    public int parseValue(String str) {
        try {
            return Math.max(this.minimumValue, Math.min(Integer.parseInt(str.replaceAll(REGEX_ALL_NOT_DIGITS, "").trim()), this.maximumValue));
        } catch (NumberFormatException unused) {
            return this.defaultValue;
        }
    }

    public void setDefaultValue(int i) {
        this.defaultValue = i;
    }

    public void setMaximumValue(int i) {
        generateCompiledInputStringPattern(i);
        this.maximumValue = i;
    }

    public void setMinimumValue(int i) {
        this.minimumValue = i;
    }

    public void setTextToDefault() {
        setTextToFormat(this.defaultValue);
        UnitSelectionListener unitSelectionListener = this.listener;
        if (unitSelectionListener != null) {
            unitSelectionListener.onValueSet(this, this.defaultValue);
        }
    }

    public void setTextToFormat(int i) {
        setText(String.format(Locale.US, this.unitLabel, Integer.valueOf(Math.max(this.minimumValue, Math.min(i, this.maximumValue)))));
    }

    public void setUnitLabel(String str, int i, int i2, int i3, final UnitSelectionListener unitSelectionListener) {
        uw.a(str, "unitLabel", null);
        this.unitLabel = str;
        String strReplaceAll = String.format(Locale.US, str, Integer.valueOf(i)).replaceAll(REGEX_ONLY_DIGITS, "");
        this.unit = strReplaceAll;
        this.unitLengthNotSelectable = strReplaceAll.length();
        this.defaultValue = i;
        if (i2 > i) {
            this.minimumValue = i;
        } else {
            this.minimumValue = i2;
        }
        if (i3 < i) {
            this.maximumValue = i;
        } else {
            this.maximumValue = i3;
        }
        generateCompiledInputStringPattern(this.maximumValue);
        this.listener = unitSelectionListener;
        TextWatcher textWatcher = this.textWatcher;
        if (textWatcher != null) {
            removeTextChangedListener(textWatcher);
        }
        c30 c30Var = new c30() { // from class: com.pspdfkit.ui.editor.UnitSelectionEditText.1
            @Override // com.pspdfkit.internal.c30, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (UnitSelectionEditText.this.compiledInputStringPattern.matcher(editable.toString()).matches()) {
                    return;
                }
                int value = UnitSelectionEditText.this.getValue();
                UnitSelectionEditText unitSelectionEditText = UnitSelectionEditText.this;
                int iMax = Math.max(unitSelectionEditText.minimumValue, Math.min(value, unitSelectionEditText.maximumValue));
                UnitSelectionEditText.this.removeTextChangedListener(this);
                UnitSelectionEditText unitSelectionEditText2 = UnitSelectionEditText.this;
                unitSelectionEditText2.setText(String.format(unitSelectionEditText2.unitLabel, Integer.valueOf(iMax)));
                UnitSelectionEditText.this.addTextChangedListener(this);
                if (UnitSelectionEditText.this.getText() != null) {
                    UnitSelectionEditText unitSelectionEditText3 = UnitSelectionEditText.this;
                    unitSelectionEditText3.setSelection(0, unitSelectionEditText3.getText().toString().lastIndexOf(UnitSelectionEditText.this.unit));
                }
            }
        };
        this.textWatcher = c30Var;
        addTextChangedListener(c30Var);
        if (this.onFocusChangeListener != null) {
            setOnFocusChangeListener(null);
        }
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.pspdfkit.ui.editor.UnitSelectionEditText$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                this.f$0.lambda$setUnitLabel$0(view, z);
            }
        };
        this.onFocusChangeListener = onFocusChangeListener;
        setOnFocusChangeListener(onFocusChangeListener);
        if (this.onEditorActionListener != null) {
            setOnEditorActionListener(null);
        }
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.pspdfkit.ui.editor.UnitSelectionEditText$$ExternalSyntheticLambda1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
                return this.f$0.lambda$setUnitLabel$1(unitSelectionListener, textView, i4, keyEvent);
            }
        };
        this.onEditorActionListener = onEditorActionListener;
        setOnEditorActionListener(onEditorActionListener);
    }

    public UnitSelectionEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.unitLabel = "";
        init();
    }

    public UnitSelectionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.unitLabel = "";
        init();
    }
}
