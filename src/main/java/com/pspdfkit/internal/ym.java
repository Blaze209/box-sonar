package com.pspdfkit.internal;

import android.text.TextUtils;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.LinkAnnotation;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionSender;
import com.pspdfkit.annotations.actions.AnnotationTriggerEvent;
import com.pspdfkit.annotations.actions.JavaScriptAction;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.utils.PdfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ym implements c<JavaScriptAction> {
    public final DocumentView a;

    public ym(DocumentView documentView) {
        documentView.getClass();
        this.a = documentView;
    }

    @Override // com.pspdfkit.internal.c
    public final boolean executeAction(Action action, ActionSender actionSender) {
        ce ceVarA;
        JavaScriptAction javaScriptAction = (JavaScriptAction) action;
        lm document = this.a.getDocument();
        String script = javaScriptAction.getScript();
        if (document != null && !TextUtils.isEmpty(script)) {
            an anVar = document.l;
            if (anVar.d) {
                AnnotationTriggerEvent annotationTriggerEvent = null;
                if (actionSender != null) {
                    Annotation annotation = actionSender.getAnnotation();
                    FormElement formElement = actionSender.getFormElement();
                    if (annotation != null && annotation.getType() == AnnotationType.LINK) {
                        LinkAnnotation linkAnnotation = (LinkAnnotation) annotation;
                        if (linkAnnotation.isAttached()) {
                            if (!anVar.a() || (ceVarA = anVar.a(linkAnnotation)) == null) {
                                return true;
                            }
                            ceVarA.a(linkAnnotation);
                            return true;
                        }
                        PdfLog.e("Nutri.JsActionExecutor", "Error executing javascript action for annotation %s. Annotation was not attached to document.", linkAnnotation);
                    } else {
                        if (formElement != null) {
                            WidgetAnnotation annotation2 = formElement.getAnnotation();
                            annotation2.getClass();
                            if (!Intrinsics.areEqual(annotation2.getInternal().getAction(), javaScriptAction)) {
                                for (AnnotationTriggerEvent annotationTriggerEvent2 : zm.a) {
                                    if (Intrinsics.areEqual(annotation2.getInternal().getAdditionalAction(annotationTriggerEvent2), javaScriptAction)) {
                                        annotationTriggerEvent = annotationTriggerEvent2;
                                        break;
                                    }
                                }
                            } else {
                                annotationTriggerEvent = AnnotationTriggerEvent.MOUSE_UP;
                            }
                            if (annotationTriggerEvent != null) {
                                if (!anVar.a()) {
                                    return true;
                                }
                                WidgetAnnotation annotation3 = formElement.getAnnotation();
                                annotation3.getClass();
                                ce ceVarA2 = anVar.a(annotation3);
                                if (ceVarA2 == null) {
                                    return true;
                                }
                                ceVarA2.a(formElement, annotationTriggerEvent);
                                return true;
                            }
                            String script2 = javaScriptAction.getScript();
                            ActionSender actionSender2 = new ActionSender(formElement);
                            script2.getClass();
                            if (!anVar.a()) {
                                return true;
                            }
                            Annotation annotation4 = actionSender2.getAnnotation();
                            FormElement formElement2 = actionSender2.getFormElement();
                            if (annotation4 != null) {
                                ce ceVarA3 = anVar.a(annotation4);
                                if (ceVarA3 == null) {
                                    return true;
                                }
                                ceVarA3.a(script2);
                                return true;
                            }
                            if (formElement2 == null) {
                                PdfLog.w("Nutri.JScriptProvImpl", "Trying to execute a JavaScript action on something that is not a form element is not supported yet.", new Object[0]);
                                return true;
                            }
                            WidgetAnnotation annotation5 = formElement2.getAnnotation();
                            annotation5.getClass();
                            ce ceVarA4 = anVar.a(annotation5);
                            if (ceVarA4 == null) {
                                return true;
                            }
                            ceVarA4.a(script2);
                            return true;
                        }
                        PdfLog.e("Nutri.JsActionExecutor", "Trying to execute a JavaScript action on something that is not a form element is not supported yet.", new Object[0]);
                    }
                }
                String script3 = javaScriptAction.getScript();
                script3.getClass();
                if (!anVar.a()) {
                    return true;
                }
                ce ceVar = anVar.c.isEmpty() ? null : anVar.c.get(0);
                if (ceVar == null) {
                    return true;
                }
                ceVar.a(script3);
                return true;
            }
        }
        return false;
    }
}
