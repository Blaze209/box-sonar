package com.pspdfkit.internal;

import com.pspdfkit.annotations.LinkAnnotation;
import com.pspdfkit.annotations.actions.AnnotationTriggerEvent;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.internal.jni.NativeDocumentProvider;
import com.pspdfkit.internal.jni.NativeJSDocumentScriptExecutor;
import com.pspdfkit.internal.jni.NativeJSError;
import com.pspdfkit.internal.jni.NativeJSEventName;
import com.pspdfkit.internal.jni.NativeJSEventSourceTargetInfo;
import com.pspdfkit.internal.jni.NativeJSEventType;
import com.pspdfkit.internal.jni.NativeJSResult;
import com.pspdfkit.utils.PdfLog;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class ce {
    public final NativeDocumentProvider a;
    public final NativeJSDocumentScriptExecutor b;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationTriggerEvent.values().length];
            try {
                iArr[AnnotationTriggerEvent.CURSOR_ENTERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationTriggerEvent.CURSOR_EXITS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationTriggerEvent.MOUSE_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationTriggerEvent.MOUSE_UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationTriggerEvent.RECEIVE_FOCUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationTriggerEvent.LOOSE_FOCUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnnotationTriggerEvent.FIELD_FORMAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            a = iArr;
        }
    }

    public ce(NativeDocumentProvider nativeDocumentProvider, String str, or orVar) {
        nativeDocumentProvider.getClass();
        orVar.getClass();
        this.a = nativeDocumentProvider;
        nativeDocumentProvider.configureDocumentScriptExecutor(str);
        NativeJSDocumentScriptExecutor documentScriptExecutor = nativeDocumentProvider.getDocumentScriptExecutor();
        if (documentScriptExecutor == null) {
            throw new IllegalStateException("Document script executor could not be initialized!");
        }
        this.b = documentScriptExecutor;
        documentScriptExecutor.setPlatformDelegate(orVar);
    }

    public final boolean a(final String str) {
        str.getClass();
        NativeJSError error = ((NativeJSResult) new Function0() { // from class: com.pspdfkit.internal.ce$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ce.a(this.f$0, str);
            }
        }.invoke()).getError();
        if (error == null) {
            return true;
        }
        PdfLog.w("Nutri.DocProvJScriptExe", "Error executing script: %s", error.getMessage());
        return false;
    }

    public static final NativeJSResult a(ce ceVar, String str) {
        NativeJSResult nativeJSResultExecuteJavascriptAction = ceVar.b.executeJavascriptAction(str, NativeJSEventType.CONSOLE, NativeJSEventName.EXEC, new NativeJSEventSourceTargetInfo(ceVar.a, null));
        nativeJSResultExecuteJavascriptAction.getClass();
        return nativeJSResultExecuteJavascriptAction;
    }

    public final boolean a(final LinkAnnotation linkAnnotation) {
        NativeJSError error = ((NativeJSResult) new Function0() { // from class: com.pspdfkit.internal.ce$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ce.a(this.f$0, linkAnnotation);
            }
        }.invoke()).getError();
        if (error == null) {
            return true;
        }
        PdfLog.w("Nutri.DocProvJScriptExe", "Error executing script: %s", error.getMessage());
        return false;
    }

    public static final NativeJSResult a(ce ceVar, LinkAnnotation linkAnnotation) {
        NativeJSResult nativeJSResultOnLinkMouseUp = ceVar.b.onLinkMouseUp(linkAnnotation.getPageIndex(), linkAnnotation.getObjectNumber(), new NativeJSEventSourceTargetInfo(ceVar.a, null));
        nativeJSResultOnLinkMouseUp.getClass();
        return nativeJSResultOnLinkMouseUp;
    }

    public final boolean a(final FormElement formElement, final AnnotationTriggerEvent annotationTriggerEvent) {
        formElement.getClass();
        annotationTriggerEvent.getClass();
        NativeJSError error = ((NativeJSResult) new Function0() { // from class: com.pspdfkit.internal.ce$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ce.a(this.f$0, formElement, annotationTriggerEvent);
            }
        }.invoke()).getError();
        if (error == null) {
            return true;
        }
        PdfLog.w("Nutri.DocProvJScriptExe", "Error executing script: %s", error.getMessage());
        return false;
    }

    public static final NativeJSResult a(ce ceVar, FormElement formElement, AnnotationTriggerEvent annotationTriggerEvent) {
        NativeJSEventSourceTargetInfo nativeJSEventSourceTargetInfo = new NativeJSEventSourceTargetInfo(ceVar.a, formElement.getFullyQualifiedName());
        switch (a.a[annotationTriggerEvent.ordinal()]) {
            case 1:
                NativeJSResult nativeJSResultOnFieldMouseEnter = ceVar.b.onFieldMouseEnter(nativeJSEventSourceTargetInfo);
                nativeJSResultOnFieldMouseEnter.getClass();
                return nativeJSResultOnFieldMouseEnter;
            case 2:
                NativeJSResult nativeJSResultOnFieldMouseExit = ceVar.b.onFieldMouseExit(nativeJSEventSourceTargetInfo);
                nativeJSResultOnFieldMouseExit.getClass();
                return nativeJSResultOnFieldMouseExit;
            case 3:
                NativeJSResult nativeJSResultOnFieldMouseDown = ceVar.b.onFieldMouseDown(nativeJSEventSourceTargetInfo);
                nativeJSResultOnFieldMouseDown.getClass();
                return nativeJSResultOnFieldMouseDown;
            case 4:
                NativeJSResult nativeJSResultOnFieldMouseUp = ceVar.b.onFieldMouseUp(nativeJSEventSourceTargetInfo);
                nativeJSResultOnFieldMouseUp.getClass();
                return nativeJSResultOnFieldMouseUp;
            case 5:
                NativeJSResult nativeJSResultOnFieldFocus = ceVar.b.onFieldFocus(nativeJSEventSourceTargetInfo);
                nativeJSResultOnFieldFocus.getClass();
                return nativeJSResultOnFieldFocus;
            case 6:
                NativeJSResult nativeJSResultOnFieldBlur = ceVar.b.onFieldBlur(nativeJSEventSourceTargetInfo);
                nativeJSResultOnFieldBlur.getClass();
                return nativeJSResultOnFieldBlur;
            case 7:
                NativeJSResult nativeJSResultOnFieldFormat = ceVar.b.onFieldFormat(nativeJSEventSourceTargetInfo);
                nativeJSResultOnFieldFormat.getClass();
                return nativeJSResultOnFieldFormat;
            default:
                PdfLog.w("Nutri.DocProvJScriptExe", "JavaScript execution for event " + annotationTriggerEvent + " is not supported", new Object[0]);
                return new NativeJSResult(null, null, null);
        }
    }
}
