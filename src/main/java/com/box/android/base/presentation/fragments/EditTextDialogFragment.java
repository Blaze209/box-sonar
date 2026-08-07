package com.box.android.base.presentation.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.box.android.base.databinding.DialogLayoutEdittextBinding;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EditTextDialogFragment.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/box/android/base/presentation/fragments/EditTextDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "positiveButtonCallback", "Lkotlin/Function1;", "", "", "getPositiveButtonCallback", "()Lkotlin/jvm/functions/Function1;", "setPositiveButtonCallback", "(Lkotlin/jvm/functions/Function1;)V", "negativeButtonCallback", "Lkotlin/Function0;", "getNegativeButtonCallback", "()Lkotlin/jvm/functions/Function0;", "setNegativeButtonCallback", "(Lkotlin/jvm/functions/Function0;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "Factory", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EditTextDialogFragment extends DialogFragment {
    public static final String TAG = "edit_text_dialog_fragment";
    private Function0<Unit> negativeButtonCallback = new Function0() { // from class: com.box.android.base.presentation.fragments.EditTextDialogFragment$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EditTextDialogFragment.negativeButtonCallback$lambda$0(this.f$0);
        }
    };
    public Function1<? super String, Unit> positiveButtonCallback;

    /* JADX INFO: renamed from: Factory, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.box.android.base.presentation.fragments.EditTextDialogFragment$Factory, reason: from kotlin metadata */
    /* JADX INFO: compiled from: EditTextDialogFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011J\u001a\u0010\u0012\u001a\u00020\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/base/presentation/fragments/EditTextDialogFragment$Factory;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/box/android/base/presentation/fragments/EditTextDialogFragment;", "title", "subtext", "hint", "positiveButtonText", "negativeButtonText", "positiveButtonCallback", "Lkotlin/Function1;", "", "negativeButtonCallback", "Lkotlin/Function0;", "logEvent", "error", "event", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EditTextDialogFragment newInstance(String title, String subtext, String hint, String positiveButtonText, String negativeButtonText, Function1<? super String, Unit> positiveButtonCallback, Function0<Unit> negativeButtonCallback) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(subtext, "subtext");
            Intrinsics.checkNotNullParameter(hint, "hint");
            Intrinsics.checkNotNullParameter(positiveButtonText, "positiveButtonText");
            Intrinsics.checkNotNullParameter(negativeButtonText, "negativeButtonText");
            Intrinsics.checkNotNullParameter(positiveButtonCallback, "positiveButtonCallback");
            EditTextDialogFragment editTextDialogFragment = new EditTextDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString(EditTextDialogFragmentKt.EXTRA_EDIT_TEXT_DIALOG_TITLE, title);
            bundle.putString(EditTextDialogFragmentKt.EXTRA_EDIT_TEXT_DIALOG_SUBTEXT, subtext);
            bundle.putString(EditTextDialogFragmentKt.EXTRA_EDIT_TEXT_DIALOG_EDIT_TEXT_HINT, hint);
            bundle.putString(EditTextDialogFragmentKt.EXTRA_EDIT_TEXT_DIALOG_POSITIVE_TEXT, positiveButtonText);
            bundle.putString(EditTextDialogFragmentKt.EXTRA_EDIT_TEXT_DIALOG_NEGATIVE_TEXT, negativeButtonText);
            editTextDialogFragment.setArguments(bundle);
            editTextDialogFragment.setPositiveButtonCallback(positiveButtonCallback);
            if (negativeButtonCallback != null) {
                editTextDialogFragment.setNegativeButtonCallback(negativeButtonCallback);
            }
            return editTextDialogFragment;
        }

        public static /* synthetic */ void logEvent$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            companion.logEvent(str, str2);
        }

        public final void logEvent(String error, String event) {
            Intrinsics.checkNotNullParameter(event, "event");
            BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = BoxAmplitudeAnalytics.createEventBuilder();
            Intrinsics.checkNotNullExpressionValue(eventPropertyBuilderCreateEventBuilder, "createEventBuilder(...)");
            eventPropertyBuilderCreateEventBuilder.setIsSuccessfulCreation(error == null);
            if (error != null) {
                eventPropertyBuilderCreateEventBuilder.setCreateCollectionErrorType(error);
            }
            eventPropertyBuilderCreateEventBuilder.logEvent(event);
        }
    }

    public final Function1<String, Unit> getPositiveButtonCallback() {
        Function1 function1 = this.positiveButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("positiveButtonCallback");
        return null;
    }

    public final void setPositiveButtonCallback(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.positiveButtonCallback = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit negativeButtonCallback$lambda$0(EditTextDialogFragment editTextDialogFragment) {
        Dialog dialog = editTextDialogFragment.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    public final Function0<Unit> getNegativeButtonCallback() {
        return this.negativeButtonCallback;
    }

    public final void setNegativeButtonCallback(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.negativeButtonCallback = function0;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setRetainInstance(true);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(EditTextDialogFragmentKt.EXTRA_EDIT_TEXT_DIALOG_TITLE) : null;
        Intrinsics.checkNotNull(string);
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(EditTextDialogFragmentKt.EXTRA_EDIT_TEXT_DIALOG_SUBTEXT) : null;
        Intrinsics.checkNotNull(string2);
        Bundle arguments3 = getArguments();
        String string3 = arguments3 != null ? arguments3.getString(EditTextDialogFragmentKt.EXTRA_EDIT_TEXT_DIALOG_EDIT_TEXT_HINT) : null;
        Intrinsics.checkNotNull(string3);
        Bundle arguments4 = getArguments();
        String string4 = arguments4 != null ? arguments4.getString(EditTextDialogFragmentKt.EXTRA_EDIT_TEXT_DIALOG_POSITIVE_TEXT) : null;
        Intrinsics.checkNotNull(string4);
        Bundle arguments5 = getArguments();
        String string5 = arguments5 != null ? arguments5.getString(EditTextDialogFragmentKt.EXTRA_EDIT_TEXT_DIALOG_NEGATIVE_TEXT) : null;
        Intrinsics.checkNotNull(string5);
        final DialogLayoutEdittextBinding dialogLayoutEdittextBindingInflate = DialogLayoutEdittextBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(dialogLayoutEdittextBindingInflate, "inflate(...)");
        dialogLayoutEdittextBindingInflate.dialogTitle.setText(string);
        dialogLayoutEdittextBindingInflate.dialogSubtext.setText(string2);
        dialogLayoutEdittextBindingInflate.dialogEdittext.setHint(string3);
        AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(requireContext()).setView((View) dialogLayoutEdittextBindingInflate.getRoot()).setPositiveButton((CharSequence) string4, new DialogInterface.OnClickListener() { // from class: com.box.android.base.presentation.fragments.EditTextDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EditTextDialogFragment.onCreateDialog$lambda$0(this.f$0, dialogLayoutEdittextBindingInflate, dialogInterface, i);
            }
        }).setNegativeButton((CharSequence) string5, new DialogInterface.OnClickListener() { // from class: com.box.android.base.presentation.fragments.EditTextDialogFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EditTextDialogFragment.onCreateDialog$lambda$1(this.f$0, dialogInterface, i);
            }
        }).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(EditTextDialogFragment editTextDialogFragment, DialogLayoutEdittextBinding dialogLayoutEdittextBinding, DialogInterface dialogInterface, int i) {
        editTextDialogFragment.getPositiveButtonCallback().invoke(StringsKt.trim((CharSequence) dialogLayoutEdittextBinding.dialogEdittext.getText().toString()).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(EditTextDialogFragment editTextDialogFragment, DialogInterface dialogInterface, int i) {
        editTextDialogFragment.negativeButtonCallback.invoke();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }
}
