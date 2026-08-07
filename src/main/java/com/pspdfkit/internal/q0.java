package com.pspdfkit.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Pair;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.BorderStyle;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener;
import com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener;
import com.pspdfkit.ui.audio.AudioModeManager;
import com.pspdfkit.ui.fonts.Font;
import com.pspdfkit.ui.inspector.annotation.DefaultAnnotationEditingInspectorController;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationInspectorController;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.undo.edit.annotations.AnnotationZIndexEdit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 extends l30 implements AnnotatingController {
    public final z1 d;
    public final AudioModeManager e;
    public final PdfFragment f;
    public final AnnotationPreferencesManager g;
    public final PSPDFKitPreferences h;
    public final vo i;
    public final DocumentView j;
    public final go<OnAnnotatingModeChangeListener> k;
    public final go<OnAnnotatingModeSettingsChangeListener> l;
    public final ArrayList m;
    public i3 n;
    public final ArrayList o;
    public final a p;
    public final AtomicInteger q;
    public int r;
    public AnnotationTool s;
    public AnnotationToolVariant t;
    public boolean u;
    public AnnotationInspectorController v;
    public DefaultAnnotationEditingInspectorController w;
    public boolean x;
    public boolean y;
    public final PdfConfiguration z;

    public static final class a {
        public int b;
        public int c;
        public int d;
        public Pair<LineEndType, LineEndType> h;
        public float i;
        public String j;
        public boolean k;
        public Font a = ar.c().c;
        public float e = 40.0f;
        public float f = 18.0f;
        public BorderStylePreset g = new BorderStylePreset(BorderStyle.SOLID);

        public a() {
            LineEndType lineEndType = LineEndType.NONE;
            this.h = new Pair<>(lineEndType, lineEndType);
            this.i = 1.0f;
            this.j = "";
        }
    }

    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationTool.values().length];
            try {
                iArr[AnnotationTool.MEASUREMENT_SCALE_CALIBRATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.specialMode.handler.AnnotatingSpecialModeHandler$deleteAnnotations$1$1$1$1", f = "AnnotatingSpecialModeHandler.kt", i = {}, l = {661}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ o3 b;
        public final /* synthetic */ Annotation c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(o3 o3Var, Annotation annotation, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = o3Var;
            this.c = annotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new c(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o3 o3Var = this.b;
                Annotation annotation = this.c;
                this.a = 1;
                if (o3Var.removeAnnotationFromPage(annotation, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(z1 z1Var, AudioModeManager audioModeManager, PdfFragment pdfFragment, AnnotationPreferencesManager annotationPreferencesManager, PSPDFKitPreferences pSPDFKitPreferences, at atVar, vo voVar, DocumentView documentView) {
        super(pdfFragment.requireContext(), pdfFragment, atVar);
        z1Var.getClass();
        audioModeManager.getClass();
        pdfFragment.getClass();
        annotationPreferencesManager.getClass();
        pSPDFKitPreferences.getClass();
        atVar.getClass();
        voVar.getClass();
        this.d = z1Var;
        this.e = audioModeManager;
        this.f = pdfFragment;
        this.g = annotationPreferencesManager;
        this.h = pSPDFKitPreferences;
        this.i = voVar;
        this.j = documentView;
        this.k = new go<>();
        this.l = new go<>();
        this.m = new ArrayList();
        this.o = new ArrayList(3);
        a aVar = new a();
        this.p = aVar;
        this.q = new AtomicInteger(0);
        Font fontB = ar.c().b();
        fontB.getClass();
        aVar.a = fontB;
        PdfConfiguration configuration = pdfFragment.getConfiguration();
        configuration.getClass();
        this.z = configuration;
    }

    public final void a(d3 d3Var) {
        boolean z;
        au auVarL;
        vt pageEditor;
        d3Var.getClass();
        tg tgVarB = ar.b();
        tgVarB.getClass();
        if (!d3Var.e() && (auVarL = d3Var.l()) != null && (pageEditor = auVarL.getPageEditor()) != null) {
            vt.a(pageEditor, false, true, 13);
        }
        if (this.o.isEmpty()) {
            this.r = d3Var.f();
            this.s = d3Var.h();
            this.t = d3Var.i();
            this.o.add(d3Var);
            z = false;
        } else {
            if (d3Var.f() == this.r && d3Var.h() == this.s && Intrinsics.areEqual(d3Var.i(), this.t)) {
                this.o.add(d3Var);
                return;
            }
            this.o.clear();
            this.r = d3Var.f();
            this.s = d3Var.h();
            this.t = d3Var.i();
            this.o.add(d3Var);
            z = true;
        }
        if (tgVarB.a(NativeLicenseFeatures.ANNOTATION_EDITING)) {
            this.u = true;
            AnnotationTool annotationToolH = d3Var.h();
            AnnotationToolVariant annotationToolVariantI = d3Var.i();
            this.h.setLastAnnotationTool(annotationToolH, annotationToolVariantI);
            setColor(this.g.getColor(annotationToolH, annotationToolVariantI));
            setFillColor(this.g.getFillColor(annotationToolH, annotationToolVariantI));
            setOutlineColor(this.g.getOutlineColor(annotationToolH, annotationToolVariantI));
            setThickness(this.g.getThickness(annotationToolH, annotationToolVariantI));
            setTextSize(this.g.getTextSize(annotationToolH, annotationToolVariantI));
            BorderStylePreset borderStylePreset = this.g.getBorderStylePreset(annotationToolH, annotationToolVariantI);
            borderStylePreset.getClass();
            setBorderStylePreset(borderStylePreset);
            Pair<LineEndType, LineEndType> lineEnds = this.g.getLineEnds(annotationToolH, annotationToolVariantI);
            lineEnds.getClass();
            LineEndType lineEndType = lineEnds.first;
            lineEndType.getClass();
            LineEndType lineEndType2 = lineEnds.second;
            lineEndType2.getClass();
            setLineEnds(lineEndType, lineEndType2);
            setAlpha(this.g.getAlpha(annotationToolH, annotationToolVariantI));
            Font font = this.g.getFont(annotationToolH, annotationToolVariantI);
            font.getClass();
            setFont(font);
            String overlayText = this.g.getOverlayText(annotationToolH, annotationToolVariantI);
            overlayText.getClass();
            setOverlayText(overlayText);
            setRepeatOverlayText(this.g.getRepeatOverlayText(annotationToolH, annotationToolVariantI));
            if (z) {
                a();
            } else {
                if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                    throw new IllegalStateException("Annotation listeners touched on non ui thread.");
                }
                Iterator<OnAnnotatingModeChangeListener> it = this.k.iterator();
                it.getClass();
                while (it.hasNext()) {
                    it.next().onEnterAnnotatingMode(this);
                }
            }
            this.u = false;
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void addOnAnnotatingModeChangeListener(OnAnnotatingModeChangeListener onAnnotatingModeChangeListener) {
        onAnnotatingModeChangeListener.getClass();
        this.k.a(onAnnotatingModeChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void addOnSettingsChangeListener(OnAnnotatingModeSettingsChangeListener onAnnotatingModeSettingsChangeListener) {
        onAnnotatingModeSettingsChangeListener.getClass();
        this.l.a(onAnnotatingModeSettingsChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void bindAnnotationInspectorController(AnnotationInspectorController annotationInspectorController) {
        annotationInspectorController.getClass();
        if (this.v != null) {
            this.x = true;
        }
        this.v = annotationInspectorController;
        if (this.x) {
            a();
        }
    }

    public final void c(d3 d3Var) {
        d3Var.getClass();
        this.o.remove(d3Var);
        if (this.o.isEmpty()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.pspdfkit.internal.q0$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    q0.b(this.f$0);
                }
            });
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void changeAnnotationCreationMode(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        annotationTool.getClass();
        annotationToolVariant.getClass();
        this.b.enterAnnotatingMode(annotationTool, annotationToolVariant);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void clearSelection() {
        h60.a(new Runnable() { // from class: com.pspdfkit.internal.q0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                q0.a(this.f$0);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void deleteCurrentlySelectedAnnotations() {
        a(CollectionsKt.toList(this.m));
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void displayScalePicker() {
        if (this.m.isEmpty()) {
            AnnotationInspectorController annotationInspectorController = this.v;
            if (annotationInspectorController != null) {
                annotationInspectorController.displayScalePicker(true);
                return;
            }
            return;
        }
        DefaultAnnotationEditingInspectorController defaultAnnotationEditingInspectorController = this.w;
        if (defaultAnnotationEditingInspectorController != null) {
            defaultAnnotationEditingInspectorController.displayScalePicker(true);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void enterAudioPlaybackMode() {
        ArrayList arrayList = this.m;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (obj instanceof SoundAnnotation) {
                arrayList2.add(obj);
            }
        }
        SoundAnnotation soundAnnotation = (SoundAnnotation) CollectionsKt.singleOrNull((List) arrayList2);
        if (soundAnnotation != null) {
            this.e.enterAudioPlaybackMode(soundAnnotation);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void enterAudioRecordingMode() {
        ArrayList arrayList = this.m;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (obj instanceof SoundAnnotation) {
                arrayList2.add(obj);
            }
        }
        SoundAnnotation soundAnnotation = (SoundAnnotation) CollectionsKt.singleOrNull((List) arrayList2);
        if (soundAnnotation != null) {
            this.e.enterAudioRecordingMode(soundAnnotation);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final AnnotationTool getActiveAnnotationTool() {
        return this.s;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final AnnotationToolVariant getActiveAnnotationToolVariant() {
        return this.t;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final float getAlpha() {
        return this.p.i;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final AnnotationPreferencesManager getAnnotationPreferences() {
        return this.g;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final BorderStylePreset getBorderStylePreset() {
        return this.p.g;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final int getColor() {
        return this.p.b;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final PdfConfiguration getConfiguration() {
        return this.z;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final Annotation getCurrentSingleSelectedAnnotation() {
        if (this.m.size() == 1) {
            return (Annotation) this.m.get(0);
        }
        return null;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final List<Annotation> getCurrentlySelectedAnnotations() {
        return CollectionsKt.toList(this.m);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final int getFillColor() {
        return this.p.c;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final Font getFont() {
        return this.p.a;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.base.FragmentSpecialModeController
    public final PdfFragment getFragment() {
        return this.f;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final Pair<LineEndType, LineEndType> getLineEnds() {
        return this.p.h;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final MeasurementValueConfiguration getMeasurementValueConfiguration() {
        MeasurementValueConfiguration measurementValueConfiguration = e60.a;
        return measurementValueConfiguration == null ? MeasurementValueConfiguration.INSTANCE.defaultConfiguration() : measurementValueConfiguration;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final int getOutlineColor() {
        return this.p.d;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final String getOverlayText() {
        return this.p.j;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final boolean getRepeatOverlayText() {
        return this.p.k;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final float getTextSize() {
        return this.p.f;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final float getThickness() {
        return this.p.e;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final boolean hasCurrentlySelectedAnnotations() {
        return !this.m.isEmpty();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final boolean isCopyEnabled(List<? extends Annotation> list) {
        d1 d1Var;
        if (!this.z.isCopyPasteEnabled()) {
            return false;
        }
        synchronized (ar.class) {
            if (ar.h == null) {
                ar.h = new d1();
            }
            d1Var = ar.h;
        }
        d1Var.getClass();
        if (list == null) {
            return false;
        }
        if (list.isEmpty()) {
            return true;
        }
        for (Annotation annotation : list) {
            annotation.getClass();
            if (annotation.getInternal().isInstantCommentThreadRoot() || !d1Var.e.contains(annotation.getType())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final boolean isCutEnabled(List<? extends Annotation> list) {
        return isCopyEnabled(list) && isDeleteEnabled(list);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final boolean isDeleteEnabled() {
        return isDeleteEnabled(CollectionsKt.toList(this.m));
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void recordAnnotationZIndexEdit(Annotation annotation, int i, int i2) {
        annotation.getClass();
        this.c.a(new AnnotationZIndexEdit(annotation.getPageIndex(), annotation.getObjectNumber(), i, i2));
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void removeOnAnnotatingModeChangeListener(OnAnnotatingModeChangeListener onAnnotatingModeChangeListener) {
        onAnnotatingModeChangeListener.getClass();
        this.k.b(onAnnotatingModeChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void removeOnSettingsChangeListener(OnAnnotatingModeSettingsChangeListener onAnnotatingModeSettingsChangeListener) {
        onAnnotatingModeSettingsChangeListener.getClass();
        this.l.b(onAnnotatingModeSettingsChangeListener);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void selectAnnotations(final List<? extends Annotation> list) {
        list.getClass();
        if (list.isEmpty()) {
            clearSelection();
        } else {
            h60.a(new Runnable() { // from class: com.pspdfkit.internal.q0$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    q0.b(this.f$0, list);
                }
            });
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void setAlpha(float f) {
        a aVar = this.p;
        if (aVar.i == f) {
            return;
        }
        aVar.i = f;
        if (this.u) {
            return;
        }
        b();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void setBorderStylePreset(BorderStylePreset borderStylePreset) {
        borderStylePreset.getClass();
        a aVar = this.p;
        if (aVar.g != borderStylePreset) {
            aVar.g = borderStylePreset;
            if (this.u) {
                return;
            }
            b();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void setColor(int i) {
        a aVar = this.p;
        if (aVar.b != i) {
            aVar.b = i;
            if (this.u) {
                return;
            }
            b();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void setFillColor(int i) {
        a aVar = this.p;
        if (aVar.c != i) {
            aVar.c = i;
            if (this.u) {
                return;
            }
            b();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void setFont(Font font) {
        font.getClass();
        a aVar = this.p;
        if (aVar.a != font) {
            aVar.a = font;
            if (this.u) {
                return;
            }
            b();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void setLineEnds(LineEndType lineEndType, LineEndType lineEndType2) {
        lineEndType.getClass();
        lineEndType2.getClass();
        a aVar = this.p;
        Pair<LineEndType, LineEndType> pair = aVar.h;
        if (pair.first == lineEndType && pair.second == lineEndType2) {
            return;
        }
        aVar.h = new Pair<>(lineEndType, lineEndType2);
        if (this.u) {
            return;
        }
        b();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void setMeasurementValueConfiguration(MeasurementValueConfiguration measurementValueConfiguration) {
        if (Intrinsics.areEqual(e60.a, measurementValueConfiguration)) {
            MeasurementValueConfiguration measurementValueConfiguration2 = e60.a;
            if (Intrinsics.areEqual(measurementValueConfiguration2 != null ? measurementValueConfiguration2.getName() : null, measurementValueConfiguration != null ? measurementValueConfiguration.getName() : null)) {
                return;
            }
        }
        e60.a = measurementValueConfiguration;
        o00 o00Var = e60.b;
        if (o00Var != null) {
            o00Var.a(measurementValueConfiguration);
        }
        if (this.u) {
            return;
        }
        b();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void setOutlineColor(int i) {
        a aVar = this.p;
        if (aVar.d != i) {
            aVar.d = i;
            if (this.u) {
                return;
            }
            b();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void setOverlayText(String str) {
        str.getClass();
        if (Intrinsics.areEqual(this.p.j, str)) {
            return;
        }
        a aVar = this.p;
        aVar.getClass();
        aVar.j = str;
        if (this.u) {
            return;
        }
        b();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void setRepeatOverlayText(boolean z) {
        a aVar = this.p;
        if ((!aVar.k) == z) {
            aVar.k = z;
            if (this.u) {
                return;
            }
            b();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void setTextSize(float f) {
        a aVar = this.p;
        if (aVar.f == f) {
            return;
        }
        aVar.f = f;
        if (this.u) {
            return;
        }
        b();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void setThickness(float f) {
        if (f < 0.5f) {
            f = 0.5f;
        }
        a aVar = this.p;
        if (aVar.e == f) {
            return;
        }
        aVar.e = f;
        if (this.u) {
            return;
        }
        b();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final boolean shouldDisplayPicker() {
        AnnotationInspectorController annotationInspectorController = !this.m.isEmpty() ? this.w : this.v;
        ArrayList arrayList = this.m;
        if (annotationInspectorController == null) {
            if (arrayList.isEmpty()) {
                this.x = true;
            } else {
                this.y = true;
            }
            return false;
        }
        if (arrayList.isEmpty()) {
            AnnotationTool annotationTool = this.s;
            int i = annotationTool == null ? -1 : b.a[annotationTool.ordinal()];
            if (i == -1 || i == 1) {
                return false;
            }
        }
        return annotationInspectorController.hasAnnotationInspector();
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final boolean shouldDisplayPlayAudioButton() {
        ArrayList arrayList = this.m;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (obj instanceof SoundAnnotation) {
                arrayList2.add(obj);
            }
        }
        SoundAnnotation soundAnnotation = (SoundAnnotation) CollectionsKt.singleOrNull((List) arrayList2);
        return soundAnnotation != null && this.e.canPlay(soundAnnotation);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final boolean shouldDisplayRecordAudioButton() {
        ArrayList arrayList = this.m;
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (obj instanceof SoundAnnotation) {
                arrayList2.add(obj);
            }
        }
        SoundAnnotation soundAnnotation = (SoundAnnotation) CollectionsKt.singleOrNull((List) arrayList2);
        return soundAnnotation != null && this.e.canRecord(soundAnnotation);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void showAnnotationEditor(Annotation annotation) {
        annotation.getClass();
        this.d.a(annotation);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void showEditedAnnotationPositionOnThePage(int i) {
        DocumentView documentView = this.j;
        au auVarB = documentView != null ? documentView.b(i) : null;
        if (auVarB != null) {
            if (auVarB.getPageEditor().t.isEmpty()) {
                auVarB = null;
            }
            if (auVarB != null) {
                List listUnmodifiableList = Collections.unmodifiableList(auVarB.getPageEditor().t);
                listUnmodifiableList.getClass();
                Annotation annotation = (Annotation) CollectionsKt.first(listUnmodifiableList);
                i4 annotationRenderingCoordinator = auVarB.getAnnotationRenderingCoordinator();
                annotationRenderingCoordinator.getClass();
                annotation.getClass();
                if ((!annotationRenderingCoordinator.a() ? null : i4.a(annotation, annotationRenderingCoordinator.n)) == g4.OVERLAY) {
                    vt pageEditor = auVarB.getPageEditor();
                    Job job = pageEditor.C;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    pageEditor.C = null;
                    if (pageEditor.t.isEmpty()) {
                        return;
                    }
                    i4 annotationRenderingCoordinator2 = pageEditor.a.getAnnotationRenderingCoordinator();
                    List listUnmodifiableList2 = Collections.unmodifiableList(pageEditor.t);
                    listUnmodifiableList2.getClass();
                    pageEditor.C = pageEditor.b.a(Dispatchers.getMain(), new yt(pageEditor, annotationRenderingCoordinator2, (Annotation) CollectionsKt.first(listUnmodifiableList2), null));
                }
            }
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void startRecording() {
        i3 i3Var = this.n;
        if (i3Var != null) {
            i3Var.b();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void stopRecording() {
        i3 i3Var = this.n;
        if (i3Var != null) {
            i3Var.c();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void toggleAnnotationInspector() {
        DocumentView documentView = this.j;
        if (documentView != null) {
            documentView.a.a();
        }
        if (this.m.isEmpty()) {
            AnnotationInspectorController annotationInspectorController = this.v;
            if (annotationInspectorController != null) {
                annotationInspectorController.toggleAnnotationInspector(true);
                return;
            }
            return;
        }
        DefaultAnnotationEditingInspectorController defaultAnnotationEditingInspectorController = this.w;
        if (defaultAnnotationEditingInspectorController != null) {
            defaultAnnotationEditingInspectorController.toggleAnnotationInspector(true);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final void unbindAnnotationInspectorController() {
        this.v = null;
    }

    public final void b() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("Annotation listeners touched on non ui thread.");
        }
        Iterator<OnAnnotatingModeSettingsChangeListener> it = this.l.iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next().onAnnotatingModeSettingsChange(this);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final boolean isCutEnabled() {
        return isCopyEnabled(this.m) && isDeleteEnabled(CollectionsKt.toList(this.m));
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final boolean isDeleteEnabled(List<? extends Annotation> list) {
        if (list == null) {
            return false;
        }
        if (list.isEmpty()) {
            return true;
        }
        for (Annotation annotation : list) {
            if (annotation.getInternal().isInstantCommentThreadRoot() || annotation.isLocked()) {
                return false;
            }
        }
        return true;
    }

    public final void b(d3 d3Var) {
        this.o.remove(d3Var);
        if (this.o.isEmpty()) {
            this.r = 0;
            this.s = null;
            this.t = null;
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                Iterator<OnAnnotatingModeChangeListener> it = this.k.iterator();
                it.getClass();
                while (it.hasNext()) {
                    it.next().onExitAnnotatingMode(this);
                }
                return;
            }
            throw new IllegalStateException("Annotation listeners touched on non ui thread.");
        }
    }

    public static final void b(q0 q0Var) {
        if (q0Var.o.isEmpty()) {
            q0Var.r = 0;
            q0Var.s = null;
            q0Var.t = null;
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                Iterator<OnAnnotatingModeChangeListener> it = q0Var.k.iterator();
                it.getClass();
                while (it.hasNext()) {
                    it.next().onExitAnnotatingMode(q0Var);
                }
                return;
            }
            throw new IllegalStateException("Annotation listeners touched on non ui thread.");
        }
    }

    public static final void b(q0 q0Var, List list) {
        q0Var.f.setSelectedAnnotations(list);
    }

    public final void b(List<? extends Annotation> list) {
        List<? extends Annotation> list2 = (list == null || list.isEmpty()) ? null : list;
        boolean zIsEmpty = this.m.isEmpty();
        if (list != null && list.size() == this.m.size() && this.m.containsAll(list)) {
            return;
        }
        this.m.clear();
        if (list2 == null) {
            if (!zIsEmpty) {
                if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                    Iterator<OnAnnotatingModeChangeListener> it = this.k.iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        it.next().onExitAnnotatingMode(this);
                    }
                } else {
                    throw new IllegalStateException("Annotation listeners touched on non ui thread.");
                }
            }
            this.n = null;
            return;
        }
        at atVar = this.c;
        atVar.getClass();
        this.n = new i3(list2, atVar);
        this.m.addAll(list2);
        if (!zIsEmpty) {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                Iterator<OnAnnotatingModeChangeListener> it2 = this.k.iterator();
                it2.getClass();
                while (it2.hasNext()) {
                    it2.next().onChangeAnnotatingMode(this);
                }
                return;
            }
            throw new IllegalStateException("Annotation listeners touched on non ui thread.");
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Iterator<OnAnnotatingModeChangeListener> it3 = this.k.iterator();
            it3.getClass();
            while (it3.hasNext()) {
                it3.next().onEnterAnnotatingMode(this);
            }
            return;
        }
        throw new IllegalStateException("Annotation listeners touched on non ui thread.");
    }

    public final void a() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Iterator<OnAnnotatingModeChangeListener> it = this.k.iterator();
            it.getClass();
            while (it.hasNext()) {
                it.next().onChangeAnnotatingMode(this);
            }
            return;
        }
        throw new IllegalStateException("Annotation listeners touched on non ui thread.");
    }

    public static final void a(q0 q0Var) {
        q0Var.f.clearSelectedAnnotations();
    }

    public final void a(List<? extends Annotation> list) {
        lm document;
        list.getClass();
        if (list.isEmpty() || this.f.getActivity() == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            Annotation annotation = (Annotation) obj;
            if (!annotation.getInternal().isInstantCommentThreadRoot() && !annotation.isLocked()) {
                arrayList.add(obj);
            }
        }
        DocumentView documentView = this.j;
        if (documentView != null && (document = documentView.getDocument()) != null) {
            final o3 annotationProvider = document.getAnnotationProvider();
            Runnable runnable = new Runnable() { // from class: com.pspdfkit.internal.q0$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    q0.a(arrayList, annotationProvider);
                }
            };
            annotationProvider.getClass();
            annotationProvider.a((at) null, runnable);
        }
        h60.a(new Runnable() { // from class: com.pspdfkit.internal.q0$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                q0.a(this.f$0, arrayList);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.controller.AnnotatingController
    public final boolean isCopyEnabled() {
        return isCopyEnabled(this.m);
    }

    public static final void a(q0 q0Var, List list) {
        List<? extends Annotation> listMinus = CollectionsKt.minus((Iterable) q0Var.m, (Iterable) CollectionsKt.toSet(list));
        if (listMinus.isEmpty()) {
            q0Var.b((List<? extends Annotation>) null);
        } else {
            q0Var.b(listMinus);
        }
    }

    public static final void a(List list, o3 o3Var) throws InterruptedException {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Annotation annotation = (Annotation) it.next();
            BuildersKt__BuildersKt.runBlocking$default(null, new c(o3Var, annotation, null), 1, null);
            i0 i0VarA = ar.a();
            i0VarA.getClass();
            Bundle bundle = new Bundle();
            bundle.putString(Analytics.Data.ANNOTATION_TYPE, annotation.getType().name());
            bundle.putInt(Analytics.Data.PAGE_INDEX, annotation.getPageIndex());
            i0VarA.a(Analytics.Event.DELETE_ANNOTATION, bundle);
        }
    }
}
