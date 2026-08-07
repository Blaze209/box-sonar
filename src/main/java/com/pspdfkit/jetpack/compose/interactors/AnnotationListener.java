package com.pspdfkit.jetpack.compose.interactors;

import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\"\b\u0002\u0010\u0002\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\"\b\u0002\u0010\n\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eR+\u0010\u0002\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R+\u0010\n\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R%\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/pspdfkit/jetpack/compose/interactors/AnnotationListener;", "", "onPrepareAnnotationSelection", "Lkotlin/Function3;", "Lcom/pspdfkit/ui/special_mode/controller/AnnotationSelectionController;", "Lcom/pspdfkit/annotations/Annotation;", "", "onAnnotationSelected", "Lkotlin/Function2;", "", "onAnnotationSelectionFinished", "", "onAnnotationDeselected", "<init>", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getOnPrepareAnnotationSelection", "()Lkotlin/jvm/functions/Function3;", "getOnAnnotationSelected", "()Lkotlin/jvm/functions/Function2;", "getOnAnnotationSelectionFinished", "getOnAnnotationDeselected", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnnotationListener {
    public static final int $stable = 0;
    private final Function2<Annotation, Boolean, Unit> onAnnotationDeselected;
    private final Function2<Annotation, Boolean, Unit> onAnnotationSelected;
    private final Function2<List<? extends Annotation>, Boolean, Unit> onAnnotationSelectionFinished;
    private final Function3<AnnotationSelectionController, Annotation, Boolean, Boolean> onPrepareAnnotationSelection;

    public AnnotationListener() {
        this(null, null, null, null, 15, null);
    }

    public final Function2<Annotation, Boolean, Unit> getOnAnnotationDeselected() {
        return this.onAnnotationDeselected;
    }

    public final Function2<Annotation, Boolean, Unit> getOnAnnotationSelected() {
        return this.onAnnotationSelected;
    }

    public final Function2<List<? extends Annotation>, Boolean, Unit> getOnAnnotationSelectionFinished() {
        return this.onAnnotationSelectionFinished;
    }

    public final Function3<AnnotationSelectionController, Annotation, Boolean, Boolean> getOnPrepareAnnotationSelection() {
        return this.onPrepareAnnotationSelection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotationListener(Function3<? super AnnotationSelectionController, ? super Annotation, ? super Boolean, Boolean> function3, Function2<? super Annotation, ? super Boolean, Unit> function2, Function2<? super List<? extends Annotation>, ? super Boolean, Unit> function4, Function2<? super Annotation, ? super Boolean, Unit> function5) {
        this.onPrepareAnnotationSelection = function3;
        this.onAnnotationSelected = function2;
        this.onAnnotationSelectionFinished = function4;
        this.onAnnotationDeselected = function5;
    }

    public /* synthetic */ AnnotationListener(Function3 function3, Function2 function2, Function2 function4, Function2 function5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function3, (i & 2) != 0 ? null : function2, (i & 4) != 0 ? null : function4, (i & 8) != 0 ? null : function5);
    }
}
