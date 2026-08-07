package com.pspdfkit.jetpack.compose.interactors;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0004\u0012%\b\u0002\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012:\b\u0002\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b\u0018\u00010\f\u0012%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012:\b\u0002\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\f\u0012%\b\u0002\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012%\b\u0002\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012%\b\u0002\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ&\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J&\u0010+\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J&\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J;\u0010-\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b\u0018\u00010\fHÆ\u0003J&\u0010.\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J&\u0010/\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J&\u00100\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J&\u00101\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J;\u00102\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\fHÆ\u0003J&\u00103\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J&\u00104\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J&\u00105\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\u0087\u0004\u00106\u001a\u00020\u00002%\b\u0002\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032:\b\u0002\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b\u0018\u00010\f2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032%\b\u0002\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032:\b\u0002\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\f2%\b\u0002\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032%\b\u0002\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032%\b\u0002\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0001J\u0014\u00107\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00109\u001a\u00020:HÖ\u0081\u0004J\n\u0010;\u001a\u00020\rHÖ\u0081\u0004R.\u0010\u0002\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR.\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR.\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dRC\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R.\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR.\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR.\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR.\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dRC\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R.\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR.\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR.\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001d¨\u0006<"}, d2 = {"Lcom/pspdfkit/jetpack/compose/interactors/FormListener;", "", "onFormElementClickedListener", "Lkotlin/Function1;", "Lcom/pspdfkit/forms/FormElement;", "Lkotlin/ParameterName;", "name", "formElement", "", "onFormElementViewUpdatedListener", "onFormElementValidationSuccess", "onFormElementValidationFailed", "Lkotlin/Function2;", "", "validationError", "onEnterFormElementEditingMode", "Lcom/pspdfkit/ui/special_mode/controller/FormEditingController;", "formEditingController", "onChangeFormElementEditingMode", "onExitFormElementEditingMode", "onFormElementUpdatedListener", "onFormElementDeselectedListener", "reselected", "onFormElementSelectedListener", "onIsFormElementClickableListener", "onPrepareFormElementSelection", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnFormElementClickedListener", "()Lkotlin/jvm/functions/Function1;", "getOnFormElementViewUpdatedListener", "getOnFormElementValidationSuccess", "getOnFormElementValidationFailed", "()Lkotlin/jvm/functions/Function2;", "getOnEnterFormElementEditingMode", "getOnChangeFormElementEditingMode", "getOnExitFormElementEditingMode", "getOnFormElementUpdatedListener", "getOnFormElementDeselectedListener", "getOnFormElementSelectedListener", "getOnIsFormElementClickableListener", "getOnPrepareFormElementSelection", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class FormListener {
    public static final int $stable = 0;
    private final Function1<FormEditingController, Boolean> onChangeFormElementEditingMode;
    private final Function1<FormEditingController, Boolean> onEnterFormElementEditingMode;
    private final Function1<FormEditingController, Boolean> onExitFormElementEditingMode;
    private final Function1<FormElement, Boolean> onFormElementClickedListener;
    private final Function2<FormElement, Boolean, Boolean> onFormElementDeselectedListener;
    private final Function1<FormElement, Boolean> onFormElementSelectedListener;
    private final Function1<FormElement, Boolean> onFormElementUpdatedListener;
    private final Function2<FormElement, String, Boolean> onFormElementValidationFailed;
    private final Function1<FormElement, Boolean> onFormElementValidationSuccess;
    private final Function1<FormElement, Boolean> onFormElementViewUpdatedListener;
    private final Function1<FormElement, Boolean> onIsFormElementClickableListener;
    private final Function1<FormElement, Boolean> onPrepareFormElementSelection;

    public FormListener() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FormListener copy$default(FormListener formListener, Function1 function1, Function1 function2, Function1 function3, Function2 function4, Function1 function5, Function1 function6, Function1 function7, Function1 function8, Function2 function9, Function1 function10, Function1 function11, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = formListener.onFormElementClickedListener;
        }
        if ((i & 2) != 0) {
            function2 = formListener.onFormElementViewUpdatedListener;
        }
        if ((i & 4) != 0) {
            function3 = formListener.onFormElementValidationSuccess;
        }
        if ((i & 8) != 0) {
            function4 = formListener.onFormElementValidationFailed;
        }
        if ((i & 16) != 0) {
            function5 = formListener.onEnterFormElementEditingMode;
        }
        if ((i & 32) != 0) {
            function6 = formListener.onChangeFormElementEditingMode;
        }
        if ((i & 64) != 0) {
            function7 = formListener.onExitFormElementEditingMode;
        }
        if ((i & 128) != 0) {
            function8 = formListener.onFormElementUpdatedListener;
        }
        if ((i & 256) != 0) {
            function9 = formListener.onFormElementDeselectedListener;
        }
        if ((i & 512) != 0) {
            function10 = formListener.onFormElementSelectedListener;
        }
        if ((i & 1024) != 0) {
            function11 = formListener.onIsFormElementClickableListener;
        }
        if ((i & 2048) != 0) {
            function12 = formListener.onPrepareFormElementSelection;
        }
        Function1 function13 = function11;
        Function1 function14 = function12;
        Function2 function15 = function9;
        Function1 function16 = function10;
        Function1 function17 = function7;
        Function1 function18 = function8;
        Function1 function19 = function5;
        Function1 function20 = function6;
        return formListener.copy(function1, function2, function3, function4, function19, function20, function17, function18, function15, function16, function13, function14);
    }

    public final Function1<FormElement, Boolean> component1() {
        return this.onFormElementClickedListener;
    }

    public final Function1<FormElement, Boolean> component10() {
        return this.onFormElementSelectedListener;
    }

    public final Function1<FormElement, Boolean> component11() {
        return this.onIsFormElementClickableListener;
    }

    public final Function1<FormElement, Boolean> component12() {
        return this.onPrepareFormElementSelection;
    }

    public final Function1<FormElement, Boolean> component2() {
        return this.onFormElementViewUpdatedListener;
    }

    public final Function1<FormElement, Boolean> component3() {
        return this.onFormElementValidationSuccess;
    }

    public final Function2<FormElement, String, Boolean> component4() {
        return this.onFormElementValidationFailed;
    }

    public final Function1<FormEditingController, Boolean> component5() {
        return this.onEnterFormElementEditingMode;
    }

    public final Function1<FormEditingController, Boolean> component6() {
        return this.onChangeFormElementEditingMode;
    }

    public final Function1<FormEditingController, Boolean> component7() {
        return this.onExitFormElementEditingMode;
    }

    public final Function1<FormElement, Boolean> component8() {
        return this.onFormElementUpdatedListener;
    }

    public final Function2<FormElement, Boolean, Boolean> component9() {
        return this.onFormElementDeselectedListener;
    }

    public final FormListener copy(Function1<? super FormElement, Boolean> onFormElementClickedListener, Function1<? super FormElement, Boolean> onFormElementViewUpdatedListener, Function1<? super FormElement, Boolean> onFormElementValidationSuccess, Function2<? super FormElement, ? super String, Boolean> onFormElementValidationFailed, Function1<? super FormEditingController, Boolean> onEnterFormElementEditingMode, Function1<? super FormEditingController, Boolean> onChangeFormElementEditingMode, Function1<? super FormEditingController, Boolean> onExitFormElementEditingMode, Function1<? super FormElement, Boolean> onFormElementUpdatedListener, Function2<? super FormElement, ? super Boolean, Boolean> onFormElementDeselectedListener, Function1<? super FormElement, Boolean> onFormElementSelectedListener, Function1<? super FormElement, Boolean> onIsFormElementClickableListener, Function1<? super FormElement, Boolean> onPrepareFormElementSelection) {
        return new FormListener(onFormElementClickedListener, onFormElementViewUpdatedListener, onFormElementValidationSuccess, onFormElementValidationFailed, onEnterFormElementEditingMode, onChangeFormElementEditingMode, onExitFormElementEditingMode, onFormElementUpdatedListener, onFormElementDeselectedListener, onFormElementSelectedListener, onIsFormElementClickableListener, onPrepareFormElementSelection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormListener)) {
            return false;
        }
        FormListener formListener = (FormListener) other;
        return Intrinsics.areEqual(this.onFormElementClickedListener, formListener.onFormElementClickedListener) && Intrinsics.areEqual(this.onFormElementViewUpdatedListener, formListener.onFormElementViewUpdatedListener) && Intrinsics.areEqual(this.onFormElementValidationSuccess, formListener.onFormElementValidationSuccess) && Intrinsics.areEqual(this.onFormElementValidationFailed, formListener.onFormElementValidationFailed) && Intrinsics.areEqual(this.onEnterFormElementEditingMode, formListener.onEnterFormElementEditingMode) && Intrinsics.areEqual(this.onChangeFormElementEditingMode, formListener.onChangeFormElementEditingMode) && Intrinsics.areEqual(this.onExitFormElementEditingMode, formListener.onExitFormElementEditingMode) && Intrinsics.areEqual(this.onFormElementUpdatedListener, formListener.onFormElementUpdatedListener) && Intrinsics.areEqual(this.onFormElementDeselectedListener, formListener.onFormElementDeselectedListener) && Intrinsics.areEqual(this.onFormElementSelectedListener, formListener.onFormElementSelectedListener) && Intrinsics.areEqual(this.onIsFormElementClickableListener, formListener.onIsFormElementClickableListener) && Intrinsics.areEqual(this.onPrepareFormElementSelection, formListener.onPrepareFormElementSelection);
    }

    public final Function1<FormEditingController, Boolean> getOnChangeFormElementEditingMode() {
        return this.onChangeFormElementEditingMode;
    }

    public final Function1<FormEditingController, Boolean> getOnEnterFormElementEditingMode() {
        return this.onEnterFormElementEditingMode;
    }

    public final Function1<FormEditingController, Boolean> getOnExitFormElementEditingMode() {
        return this.onExitFormElementEditingMode;
    }

    public final Function1<FormElement, Boolean> getOnFormElementClickedListener() {
        return this.onFormElementClickedListener;
    }

    public final Function2<FormElement, Boolean, Boolean> getOnFormElementDeselectedListener() {
        return this.onFormElementDeselectedListener;
    }

    public final Function1<FormElement, Boolean> getOnFormElementSelectedListener() {
        return this.onFormElementSelectedListener;
    }

    public final Function1<FormElement, Boolean> getOnFormElementUpdatedListener() {
        return this.onFormElementUpdatedListener;
    }

    public final Function2<FormElement, String, Boolean> getOnFormElementValidationFailed() {
        return this.onFormElementValidationFailed;
    }

    public final Function1<FormElement, Boolean> getOnFormElementValidationSuccess() {
        return this.onFormElementValidationSuccess;
    }

    public final Function1<FormElement, Boolean> getOnFormElementViewUpdatedListener() {
        return this.onFormElementViewUpdatedListener;
    }

    public final Function1<FormElement, Boolean> getOnIsFormElementClickableListener() {
        return this.onIsFormElementClickableListener;
    }

    public final Function1<FormElement, Boolean> getOnPrepareFormElementSelection() {
        return this.onPrepareFormElementSelection;
    }

    public int hashCode() {
        Function1<FormElement, Boolean> function1 = this.onFormElementClickedListener;
        int iHashCode = (function1 == null ? 0 : function1.hashCode()) * 31;
        Function1<FormElement, Boolean> function2 = this.onFormElementViewUpdatedListener;
        int iHashCode2 = (iHashCode + (function2 == null ? 0 : function2.hashCode())) * 31;
        Function1<FormElement, Boolean> function3 = this.onFormElementValidationSuccess;
        int iHashCode3 = (iHashCode2 + (function3 == null ? 0 : function3.hashCode())) * 31;
        Function2<FormElement, String, Boolean> function4 = this.onFormElementValidationFailed;
        int iHashCode4 = (iHashCode3 + (function4 == null ? 0 : function4.hashCode())) * 31;
        Function1<FormEditingController, Boolean> function5 = this.onEnterFormElementEditingMode;
        int iHashCode5 = (iHashCode4 + (function5 == null ? 0 : function5.hashCode())) * 31;
        Function1<FormEditingController, Boolean> function6 = this.onChangeFormElementEditingMode;
        int iHashCode6 = (iHashCode5 + (function6 == null ? 0 : function6.hashCode())) * 31;
        Function1<FormEditingController, Boolean> function7 = this.onExitFormElementEditingMode;
        int iHashCode7 = (iHashCode6 + (function7 == null ? 0 : function7.hashCode())) * 31;
        Function1<FormElement, Boolean> function8 = this.onFormElementUpdatedListener;
        int iHashCode8 = (iHashCode7 + (function8 == null ? 0 : function8.hashCode())) * 31;
        Function2<FormElement, Boolean, Boolean> function9 = this.onFormElementDeselectedListener;
        int iHashCode9 = (iHashCode8 + (function9 == null ? 0 : function9.hashCode())) * 31;
        Function1<FormElement, Boolean> function10 = this.onFormElementSelectedListener;
        int iHashCode10 = (iHashCode9 + (function10 == null ? 0 : function10.hashCode())) * 31;
        Function1<FormElement, Boolean> function11 = this.onIsFormElementClickableListener;
        int iHashCode11 = (iHashCode10 + (function11 == null ? 0 : function11.hashCode())) * 31;
        Function1<FormElement, Boolean> function12 = this.onPrepareFormElementSelection;
        return iHashCode11 + (function12 != null ? function12.hashCode() : 0);
    }

    public String toString() {
        return "FormListener(onFormElementClickedListener=" + this.onFormElementClickedListener + ", onFormElementViewUpdatedListener=" + this.onFormElementViewUpdatedListener + ", onFormElementValidationSuccess=" + this.onFormElementValidationSuccess + ", onFormElementValidationFailed=" + this.onFormElementValidationFailed + ", onEnterFormElementEditingMode=" + this.onEnterFormElementEditingMode + ", onChangeFormElementEditingMode=" + this.onChangeFormElementEditingMode + ", onExitFormElementEditingMode=" + this.onExitFormElementEditingMode + ", onFormElementUpdatedListener=" + this.onFormElementUpdatedListener + ", onFormElementDeselectedListener=" + this.onFormElementDeselectedListener + ", onFormElementSelectedListener=" + this.onFormElementSelectedListener + ", onIsFormElementClickableListener=" + this.onIsFormElementClickableListener + ", onPrepareFormElementSelection=" + this.onPrepareFormElementSelection + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FormListener(Function1<? super FormElement, Boolean> function1, Function1<? super FormElement, Boolean> function2, Function1<? super FormElement, Boolean> function3, Function2<? super FormElement, ? super String, Boolean> function4, Function1<? super FormEditingController, Boolean> function5, Function1<? super FormEditingController, Boolean> function6, Function1<? super FormEditingController, Boolean> function7, Function1<? super FormElement, Boolean> function8, Function2<? super FormElement, ? super Boolean, Boolean> function9, Function1<? super FormElement, Boolean> function10, Function1<? super FormElement, Boolean> function11, Function1<? super FormElement, Boolean> function12) {
        this.onFormElementClickedListener = function1;
        this.onFormElementViewUpdatedListener = function2;
        this.onFormElementValidationSuccess = function3;
        this.onFormElementValidationFailed = function4;
        this.onEnterFormElementEditingMode = function5;
        this.onChangeFormElementEditingMode = function6;
        this.onExitFormElementEditingMode = function7;
        this.onFormElementUpdatedListener = function8;
        this.onFormElementDeselectedListener = function9;
        this.onFormElementSelectedListener = function10;
        this.onIsFormElementClickableListener = function11;
        this.onPrepareFormElementSelection = function12;
    }

    public /* synthetic */ FormListener(Function1 function1, Function1 function2, Function1 function3, Function2 function4, Function1 function5, Function1 function6, Function1 function7, Function1 function8, Function2 function9, Function1 function10, Function1 function11, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1, (i & 2) != 0 ? null : function2, (i & 4) != 0 ? null : function3, (i & 8) != 0 ? null : function4, (i & 16) != 0 ? null : function5, (i & 32) != 0 ? null : function6, (i & 64) != 0 ? null : function7, (i & 128) != 0 ? null : function8, (i & 256) != 0 ? null : function9, (i & 512) != 0 ? null : function10, (i & 1024) != 0 ? null : function11, (i & 2048) != 0 ? null : function12);
    }
}
