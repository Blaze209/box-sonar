package com.pspdfkit.forms;

import android.graphics.RectF;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.AnnotationTriggerEvent;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormField;
import com.pspdfkit.internal.jni.NativeFormFlags;
import com.pspdfkit.internal.n70;
import com.pspdfkit.internal.p;
import com.pspdfkit.internal.uw;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FormElementConfiguration<T extends FormElement, K extends FormField> {
    private final p additionalActions;
    protected final RectF boundingBox;
    private final EnumSet<NativeFormFlags> formFlags;
    protected final FormElement nextElement;
    protected final int pageIndex;
    protected final FormElement previousElement;

    public static abstract class BaseBuilder<V extends FormElementConfiguration, B extends BaseBuilder<V, B>> {
        final RectF boundingBox;
        FormElement nextElement;
        final int pageIndex;
        FormElement previousElement;
        final EnumSet<NativeFormFlags> formFlags = EnumSet.noneOf(NativeFormFlags.class);
        p additionalActions = new p();

        public BaseBuilder(int i, RectF rectF) {
            uw.a(rectF, "boundingBox", null);
            this.pageIndex = i;
            this.boundingBox = rectF;
        }

        public abstract V build();

        public abstract B getThis();

        public B setAdditionalAction(AnnotationTriggerEvent annotationTriggerEvent, Action action) {
            uw.a(annotationTriggerEvent, "triggerEvent", null);
            p pVar = this.additionalActions;
            pVar.getClass();
            HashMap<AnnotationTriggerEvent, Action> map = pVar.a;
            if (action == null) {
                map.remove(annotationTriggerEvent);
            } else {
                map.put(annotationTriggerEvent, action);
            }
            return (B) getThis();
        }

        public B setNextElement(FormElement formElement) {
            this.nextElement = formElement;
            return (B) getThis();
        }

        public B setPreviousElement(FormElement formElement) {
            this.previousElement = formElement;
            return (B) getThis();
        }

        public B setReadOnly(boolean z) {
            n70.a(this.formFlags, NativeFormFlags.READONLY, z);
            return (B) getThis();
        }

        public B setRequired(boolean z) {
            n70.a(this.formFlags, NativeFormFlags.REQUIRED, z);
            return (B) getThis();
        }
    }

    public FormElementConfiguration(BaseBuilder baseBuilder) {
        this.pageIndex = baseBuilder.pageIndex;
        this.boundingBox = baseBuilder.boundingBox;
        this.previousElement = baseBuilder.previousElement;
        this.nextElement = baseBuilder.nextElement;
        this.additionalActions = baseBuilder.additionalActions;
        this.formFlags = EnumSet.copyOf((EnumSet) baseBuilder.formFlags);
    }

    public void applyToFormElement(FormElement formElement) {
        formElement.setNextElement(this.nextElement);
        formElement.setPreviousElement(this.previousElement);
        Set<Map.Entry<AnnotationTriggerEvent, Action>> setEntrySet = this.additionalActions.a.entrySet();
        setEntrySet.getClass();
        for (Map.Entry<AnnotationTriggerEvent, Action> entry : setEntrySet) {
            formElement.getAnnotation().setAdditionalAction(entry.getKey(), entry.getValue());
        }
        formElement.getFormField().getInternal().setFlags(this.formFlags);
    }

    public abstract T createFormElement(K k, WidgetAnnotation widgetAnnotation);

    public Map<AnnotationTriggerEvent, Action> getAdditionalActions() {
        Map<AnnotationTriggerEvent, Action> mapUnmodifiableMap = Collections.unmodifiableMap(this.additionalActions.a);
        mapUnmodifiableMap.getClass();
        return mapUnmodifiableMap;
    }

    public RectF getBoundingBox() {
        RectF rectF = new RectF();
        rectF.set(this.boundingBox);
        return rectF;
    }

    public abstract String getButtonValue(int i);

    public FormElement getNextElement() {
        return this.nextElement;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public FormElement getPreviousElement() {
        return this.previousElement;
    }

    public abstract FormType getType();

    public boolean isReadOnly() {
        return this.formFlags.contains(NativeFormFlags.READONLY);
    }

    public boolean isRequired() {
        return this.formFlags.contains(NativeFormFlags.REQUIRED);
    }
}
