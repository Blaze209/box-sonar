package com.pspdfkit.forms;

import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.AnnotationTriggerEvent;
import com.pspdfkit.annotations.actions.JavaScriptAction;
import com.pspdfkit.internal.jni.NativeFormTextFlags;
import com.pspdfkit.internal.sh;
import com.pspdfkit.internal.uw;
import java.util.EnumSet;
import java.util.List;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public class TextFormElement extends FormElement {
    public TextFormElement(TextFormField textFormField, WidgetAnnotation widgetAnnotation) {
        super(textFormField, widgetAnnotation);
    }

    private EnumSet<NativeFormTextFlags> getTextFlags() {
        return getFormField().getInternal().getTextFlags();
    }

    public String getEditingContents() {
        return getFormField().getInternal().getNativeFormField().getEditingContents();
    }

    public String getFormattedContents() {
        return getFormField().getInternal().getNativeFormField().getFormattedContents();
    }

    public TextInputFormat getInputFormat() {
        return sh.a(this);
    }

    public String getInputFormatString() {
        MatchResult matchResultFind$default;
        List<String> groupValues;
        AnnotationTriggerEvent annotationTriggerEvent = AnnotationTriggerEvent.FORM_CHANGED;
        annotationTriggerEvent.getClass();
        Action additionalAction = getAnnotation().getInternal().getAdditionalAction(annotationTriggerEvent);
        JavaScriptAction javaScriptAction = additionalAction instanceof JavaScriptAction ? (JavaScriptAction) additionalAction : null;
        if (javaScriptAction == null) {
            Action additionalAction2 = getFormField().getAdditionalAction(annotationTriggerEvent);
            javaScriptAction = additionalAction2 instanceof JavaScriptAction ? (JavaScriptAction) additionalAction2 : null;
        }
        String script = javaScriptAction != null ? javaScriptAction.getScript() : null;
        if (script == null) {
            AnnotationTriggerEvent annotationTriggerEvent2 = AnnotationTriggerEvent.FIELD_FORMAT;
            annotationTriggerEvent2.getClass();
            Action additionalAction3 = getAnnotation().getInternal().getAdditionalAction(annotationTriggerEvent2);
            JavaScriptAction javaScriptAction2 = additionalAction3 instanceof JavaScriptAction ? (JavaScriptAction) additionalAction3 : null;
            if (javaScriptAction2 == null) {
                Action additionalAction4 = getFormField().getAdditionalAction(annotationTriggerEvent2);
                javaScriptAction2 = additionalAction4 instanceof JavaScriptAction ? (JavaScriptAction) additionalAction4 : null;
            }
            script = javaScriptAction2 != null ? javaScriptAction2.getScript() : null;
        }
        if (script == null || (matchResultFind$default = Regex.find$default(new Regex("AF\\w+_\\w+\\(\"(.*)\"\\)"), script, 0, 2, null)) == null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
            return null;
        }
        return groupValues.get(1);
    }

    public int getMaxLength() {
        return getFormControl().getMaxLength();
    }

    public String getRichText() {
        return getFormControl().getRichText();
    }

    public String getText() {
        return getFormControl().getText();
    }

    @Override // com.pspdfkit.forms.FormElement
    public FormType getType() {
        return FormType.TEXT;
    }

    public boolean isComb() {
        return getTextFlags().contains(NativeFormTextFlags.COMB);
    }

    public boolean isFileSelect() {
        return getTextFlags().contains(NativeFormTextFlags.FILE_SELECT);
    }

    public boolean isMultiLine() {
        return getTextFlags().contains(NativeFormTextFlags.MULTI_LINE);
    }

    public boolean isPassword() {
        return getTextFlags().contains(NativeFormTextFlags.PASSWORD);
    }

    public boolean isRichText() {
        return getTextFlags().contains(NativeFormTextFlags.RICH_TEXT);
    }

    public boolean isScrollEnabled() {
        return !getTextFlags().contains(NativeFormTextFlags.DO_NOT_SCROLL);
    }

    public boolean isSpellCheckEnabled() {
        return !getTextFlags().contains(NativeFormTextFlags.DO_NOT_SPELL_CHECK);
    }

    public void setRichText(String str) {
        uw.a(str, "richText", null);
        getFormControl().setRichText(str);
    }

    public boolean setText(String str) {
        uw.a(str, "text", null);
        return getFormControl().setText(str);
    }

    @Override // com.pspdfkit.forms.FormElement
    public TextFormField getFormField() {
        return (TextFormField) super.getFormField();
    }
}
