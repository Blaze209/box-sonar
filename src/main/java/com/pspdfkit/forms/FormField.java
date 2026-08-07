package com.pspdfkit.forms;

import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.AnnotationTriggerEvent;
import com.pspdfkit.internal.d;
import com.pspdfkit.internal.em;
import com.pspdfkit.internal.jni.NativeActionService;
import com.pspdfkit.internal.jni.NativeFormChoiceFlags;
import com.pspdfkit.internal.jni.NativeFormControl;
import com.pspdfkit.internal.jni.NativeFormField;
import com.pspdfkit.internal.jni.NativeFormFlags;
import com.pspdfkit.internal.jni.NativeFormTextFlags;
import com.pspdfkit.internal.mr;
import com.pspdfkit.internal.p;
import com.pspdfkit.internal.t0;
import com.pspdfkit.internal.uw;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FormField {
    private p additionalActions;
    private final String alternateFieldName;
    private List<Integer> annotationWidgetIds;
    private EnumSet<NativeFormChoiceFlags> choiceFlags;
    private EnumSet<NativeFormFlags> flags;
    private NativeFormControl formControl;
    private List<? extends FormElement> formElements;
    private final String fqn;
    private final String mappingName;
    private final String name;
    private final NativeFormField nativeFormField;
    private final int providerIndex;
    private EnumSet<NativeFormTextFlags> textFlags;
    private final FormType type;
    private boolean didTryLoadAdditionalActions = false;
    private final em internalAPI = new em() { // from class: com.pspdfkit.forms.FormField.1
        @Override // com.pspdfkit.internal.em
        public EnumSet<NativeFormChoiceFlags> getChoiceFlags() {
            EnumSet<NativeFormChoiceFlags> enumSet;
            synchronized (this) {
                FormField formField = FormField.this;
                if (formField.choiceFlags == null) {
                    formField.choiceFlags = getNativeFormField().getChoiceFlags();
                }
                enumSet = FormField.this.choiceFlags;
            }
            return enumSet;
        }

        @Override // com.pspdfkit.internal.em
        public EnumSet<NativeFormFlags> getFlags() {
            EnumSet<NativeFormFlags> enumSet;
            synchronized (this) {
                FormField formField = FormField.this;
                if (formField.flags == null) {
                    formField.flags = getNativeFormField().getFlags();
                }
                enumSet = FormField.this.flags;
            }
            return enumSet;
        }

        @Override // com.pspdfkit.internal.em
        public NativeFormControl getNativeFormControl() {
            NativeFormControl nativeFormControl;
            synchronized (FormField.this) {
                FormField formField = FormField.this;
                if (formField.formControl == null) {
                    formField.formControl = NativeFormControl.create(formField.nativeFormField);
                }
                nativeFormControl = FormField.this.formControl;
            }
            return nativeFormControl;
        }

        @Override // com.pspdfkit.internal.em
        public NativeFormField getNativeFormField() {
            return FormField.this.nativeFormField;
        }

        @Override // com.pspdfkit.internal.em
        public EnumSet<NativeFormTextFlags> getTextFlags() {
            EnumSet<NativeFormTextFlags> enumSet;
            synchronized (this) {
                FormField formField = FormField.this;
                if (formField.textFlags == null) {
                    formField.textFlags = getNativeFormField().getTextFlags();
                }
                enumSet = FormField.this.textFlags;
            }
            return enumSet;
        }

        @Override // com.pspdfkit.internal.em
        public void setChoiceFlags(EnumSet<NativeFormChoiceFlags> enumSet) {
            synchronized (this) {
                EnumSet<NativeFormChoiceFlags> choiceFlags = getChoiceFlags();
                if (enumSet.equals(choiceFlags)) {
                    return;
                }
                choiceFlags.clear();
                choiceFlags.addAll(enumSet);
                getNativeFormField().setChoiceFlags(enumSet);
            }
        }

        @Override // com.pspdfkit.internal.em
        public void setFlags(EnumSet<NativeFormFlags> enumSet) {
            synchronized (this) {
                EnumSet<NativeFormFlags> flags = getFlags();
                if (enumSet.equals(flags)) {
                    return;
                }
                flags.clear();
                flags.addAll(enumSet);
                getNativeFormField().setFlags(enumSet);
            }
        }

        @Override // com.pspdfkit.internal.em
        public void setTextFlags(EnumSet<NativeFormTextFlags> enumSet) {
            synchronized (this) {
                EnumSet<NativeFormTextFlags> textFlags = getTextFlags();
                if (enumSet.equals(textFlags)) {
                    return;
                }
                textFlags.clear();
                textFlags.addAll(enumSet);
                getNativeFormField().setTextFlags(enumSet);
            }
        }
    };

    public FormField(int i, NativeFormField nativeFormField) {
        this.nativeFormField = nativeFormField;
        this.providerIndex = i;
        this.type = mr.a(nativeFormField.getType());
        this.name = nativeFormField.getName();
        this.fqn = nativeFormField.getFQN();
        this.mappingName = nativeFormField.getMappingName();
        this.alternateFieldName = nativeFormField.getAlternateFieldName();
    }

    public void attachFormElements(List<FormElement> list) {
        this.formElements = Collections.unmodifiableList(list);
        this.annotationWidgetIds = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormField)) {
            return false;
        }
        FormField formField = (FormField) obj;
        return this.providerIndex == formField.providerIndex && this.fqn.equals(formField.fqn);
    }

    public Action getAdditionalAction(AnnotationTriggerEvent annotationTriggerEvent) {
        uw.a(annotationTriggerEvent, "triggerEvent", null);
        synchronized (this) {
            if (!this.didTryLoadAdditionalActions && this.additionalActions == null) {
                this.didTryLoadAdditionalActions = true;
                byte[] flatbufferAdditionalActionsFormField = NativeActionService.getFlatbufferAdditionalActionsFormField(this.nativeFormField);
                if (flatbufferAdditionalActionsFormField != null) {
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(flatbufferAdditionalActionsFormField);
                    byteBufferWrap.getClass();
                    t0 t0Var = new t0();
                    byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                    t0Var.a(byteBufferWrap.position() + byteBufferWrap.getInt(byteBufferWrap.position()), byteBufferWrap);
                    this.additionalActions = d.a(t0Var);
                }
            }
        }
        p pVar = this.additionalActions;
        if (pVar == null) {
            return null;
        }
        return pVar.a.get(annotationTriggerEvent);
    }

    public String getAlternateFieldName() {
        return this.alternateFieldName;
    }

    public List<Integer> getAnnotationObjectNumbers() {
        List<Integer> list;
        synchronized (this) {
            if (this.annotationWidgetIds == null) {
                this.annotationWidgetIds = this.nativeFormField.getAnnotationWidgetIds();
            }
            list = this.annotationWidgetIds;
        }
        return list;
    }

    public FormElement getFormElement() {
        List<? extends FormElement> list = this.formElements;
        if (list == null || list.size() <= 0) {
            throw new IllegalStateException("Form field has no elements!");
        }
        return this.formElements.get(0);
    }

    public List<? extends FormElement> getFormElements() {
        List<? extends FormElement> list = this.formElements;
        return list != null ? list : Collections.EMPTY_LIST;
    }

    public String getFullyQualifiedName() {
        return this.fqn;
    }

    public String getFullyQualifiedNameForFormElement(FormElement formElement) {
        uw.a(formElement, "formElement", null);
        return getFormElements().contains(formElement) ? getInternal().getNativeFormField().getFQNForAnnotationWidgetId(formElement.getObjectNumber()) : "";
    }

    public em getInternal() {
        return this.internalAPI;
    }

    public String getMappingName() {
        return this.mappingName;
    }

    public String getName() {
        return this.name;
    }

    public String getNameForFormElement(FormElement formElement) {
        uw.a(formElement, "formElement", null);
        return getFormElements().contains(formElement) ? getInternal().getNativeFormField().getNameForAnnotationWidgetId(formElement.getObjectNumber()) : "";
    }

    public int getProviderIndex() {
        return this.providerIndex;
    }

    public FormType getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.fqn.hashCode() * 31) + this.providerIndex;
    }

    public boolean isDirty() {
        return getInternal().getNativeFormControl().isDirty();
    }

    public boolean isExported() {
        return !this.internalAPI.getFlags().contains(NativeFormFlags.NOEXPORT);
    }

    public boolean isReadOnly() {
        return this.internalAPI.getFlags().contains(NativeFormFlags.READONLY);
    }

    public boolean isRequired() {
        return this.internalAPI.getFlags().contains(NativeFormFlags.REQUIRED);
    }

    public boolean reset() {
        return getInternal().getNativeFormControl().reset();
    }
}
