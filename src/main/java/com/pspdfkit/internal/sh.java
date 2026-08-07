package com.pspdfkit.internal;

import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.AnnotationTriggerEvent;
import com.pspdfkit.annotations.actions.JavaScriptAction;
import com.pspdfkit.forms.CheckBoxFormElement;
import com.pspdfkit.forms.ChoiceFormElement;
import com.pspdfkit.forms.ComboBoxFormElement;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.RadioButtonFormElement;
import com.pspdfkit.forms.TextFormElement;
import com.pspdfkit.forms.TextInputFormat;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class sh {
    public static final TextInputFormat a(FormElement formElement) {
        AnnotationTriggerEvent annotationTriggerEvent = AnnotationTriggerEvent.FORM_CHANGED;
        annotationTriggerEvent.getClass();
        Action additionalAction = formElement.getAnnotation().getInternal().getAdditionalAction(annotationTriggerEvent);
        JavaScriptAction javaScriptAction = additionalAction instanceof JavaScriptAction ? (JavaScriptAction) additionalAction : null;
        if (javaScriptAction == null) {
            Action additionalAction2 = formElement.getFormField().getAdditionalAction(annotationTriggerEvent);
            javaScriptAction = additionalAction2 instanceof JavaScriptAction ? (JavaScriptAction) additionalAction2 : null;
        }
        String script = javaScriptAction != null ? javaScriptAction.getScript() : null;
        if (script == null) {
            AnnotationTriggerEvent annotationTriggerEvent2 = AnnotationTriggerEvent.FIELD_FORMAT;
            annotationTriggerEvent2.getClass();
            Action additionalAction3 = formElement.getAnnotation().getInternal().getAdditionalAction(annotationTriggerEvent2);
            JavaScriptAction javaScriptAction2 = additionalAction3 instanceof JavaScriptAction ? (JavaScriptAction) additionalAction3 : null;
            if (javaScriptAction2 == null) {
                Action additionalAction4 = formElement.getFormField().getAdditionalAction(annotationTriggerEvent2);
                javaScriptAction2 = additionalAction4 instanceof JavaScriptAction ? (JavaScriptAction) additionalAction4 : null;
            }
            script = javaScriptAction2 != null ? javaScriptAction2.getScript() : null;
        }
        if (script == null) {
            return TextInputFormat.NORMAL;
        }
        if (StringsKt.startsWith$default(script, "AFNumber_Keystroke", false, 2, (Object) null)) {
            return TextInputFormat.NUMBER;
        }
        if (StringsKt.startsWith$default(script, "AFDate_Keystroke", false, 2, (Object) null) || StringsKt.startsWith$default(script, "AFDate_Format", false, 2, (Object) null)) {
            return TextInputFormat.DATE;
        }
        return (StringsKt.startsWith$default(script, "AFTime_Keystroke", false, 2, (Object) null) || StringsKt.startsWith$default(script, "AFTime_Format", false, 2, (Object) null)) ? TextInputFormat.TIME : TextInputFormat.NORMAL;
    }

    public static final void b(ChoiceFormElement choiceFormElement, List list) {
        choiceFormElement.setSelectedIndexes(list);
    }

    public static final void b(ComboBoxFormElement comboBoxFormElement, String str) {
        comboBoxFormElement.setCustomText(str);
    }

    public static final Object a(final TextFormElement textFormElement, final String str, r50 r50Var) {
        return BuildersKt.withContext(Dispatchers.getIO(), new rh(new Function1() { // from class: com.pspdfkit.internal.sh$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(sh.a(textFormElement, str, (FormElement) obj));
            }
        }, textFormElement, null), r50Var);
    }

    public static final boolean a(TextFormElement textFormElement, String str, FormElement formElement) {
        formElement.getClass();
        return textFormElement.setText(str);
    }

    public static final Object a(final RadioButtonFormElement radioButtonFormElement, qh qhVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new rh(new Function1() { // from class: com.pspdfkit.internal.sh$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(sh.a(radioButtonFormElement, (FormElement) obj));
            }
        }, radioButtonFormElement, null), qhVar);
    }

    public static final boolean a(RadioButtonFormElement radioButtonFormElement, FormElement formElement) {
        formElement.getClass();
        return radioButtonFormElement.select();
    }

    public static final Object a(final CheckBoxFormElement checkBoxFormElement, ph phVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new rh(new Function1() { // from class: com.pspdfkit.internal.sh$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(sh.a(checkBoxFormElement, (FormElement) obj));
            }
        }, checkBoxFormElement, null), phVar);
    }

    public static final boolean a(CheckBoxFormElement checkBoxFormElement, FormElement formElement) {
        formElement.getClass();
        return checkBoxFormElement.toggleSelection();
    }

    public static final Completable a(final ChoiceFormElement choiceFormElement, final List<Integer> list) {
        choiceFormElement.getClass();
        list.getClass();
        Completable completableSubscribeOn = Completable.fromAction(new io.reactivex.rxjava3.functions.Action() { // from class: com.pspdfkit.internal.sh$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                sh.b(choiceFormElement, list);
            }
        }).subscribeOn(Schedulers.io());
        completableSubscribeOn.getClass();
        return completableSubscribeOn;
    }

    public static final Completable a(final ComboBoxFormElement comboBoxFormElement, final String str) {
        comboBoxFormElement.getClass();
        Completable completableSubscribeOn = Completable.fromAction(new io.reactivex.rxjava3.functions.Action() { // from class: com.pspdfkit.internal.sh$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                sh.b(comboBoxFormElement, str);
            }
        }).subscribeOn(Schedulers.io());
        completableSubscribeOn.getClass();
        return completableSubscribeOn;
    }
}
