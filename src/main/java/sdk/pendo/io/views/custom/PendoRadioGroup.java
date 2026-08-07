package sdk.pendo.io.views.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;

/* JADX INFO: loaded from: classes5.dex */
public class PendoRadioGroup extends RadioGroup implements ViewBaseScriptBridge.RadioGroupScriptBridge {
    public PendoRadioGroup(Context context) {
        super(context);
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge.RadioGroupScriptBridge
    public String getSelectedResponseId() {
        PendoAbstractRadioButton pendoAbstractRadioButton = (PendoAbstractRadioButton) findViewById(getCheckedRadioButtonId());
        return (pendoAbstractRadioButton == null || pendoAbstractRadioButton.getResponseId() == null) ? "" : pendoAbstractRadioButton.getResponseId();
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge
    public String getType() {
        return null;
    }

    @Override // sdk.pendo.io.views.custom.ViewBaseScriptBridge
    public ViewBaseScriptBridge getViewScriptBridge() {
        return this;
    }

    public PendoRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
