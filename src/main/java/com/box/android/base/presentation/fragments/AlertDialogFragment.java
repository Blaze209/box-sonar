package com.box.android.base.presentation.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.compose.DialogNavigator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlertDialogFragment.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J$\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0002J$\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0002J$\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0002J\u001e\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0002J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0010J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u000eJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u000eJ\u000e\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/box/android/base/presentation/fragments/AlertDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "dialogArguments", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "", DialogNavigator.NAME, "Landroid/content/DialogInterface;", "getIntArgumentOrNull", "", "key", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "getAlertDialogListener", "Lcom/box/android/base/presentation/fragments/AlertDialogFragmentListener;", "activity", "Landroid/app/Activity;", "getPositiveButtonListener", "Lkotlin/Function2;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getNeutralButtonListener", "getNegativeButtonListener", "getOnDismissListener", "Lkotlin/Function1;", "setTitle", AlertDialogFragment.TITLE_ID, "setMessage", AlertDialogFragment.MESSAGE_ID, "message", "setPositiveButtonId", AlertDialogFragment.POSITIVE_BUTTON_ID, "setNeutralButtonId", AlertDialogFragment.NEUTRAL_BUTTON_ID, "setNegativeButtonId", AlertDialogFragment.NEGATIVE_BUTTON_ID, "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AlertDialogFragment extends DialogFragment {
    private static final String MESSAGE = "message";
    private static final String MESSAGE_ID = "messageId";
    private static final String NEGATIVE_BUTTON_ID = "negativeButtonId";
    private static final String NEUTRAL_BUTTON_ID = "neutralButtonId";
    private static final String POSITIVE_BUTTON_ID = "positiveButtonId";
    private static final String TITLE_ID = "titleId";
    private final Bundle dialogArguments;
    public static final int $stable = 8;

    public AlertDialogFragment() {
        Bundle bundle = new Bundle();
        this.dialogArguments = bundle;
        setArguments(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String string;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Bundle arguments = getArguments();
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(activity);
            Integer intArgumentOrNull = getIntArgumentOrNull(TITLE_ID);
            if (intArgumentOrNull != null) {
                materialAlertDialogBuilder.setTitle(intArgumentOrNull.intValue());
            }
            Integer intArgumentOrNull2 = getIntArgumentOrNull(MESSAGE_ID);
            if (intArgumentOrNull2 != null) {
                materialAlertDialogBuilder.setMessage(intArgumentOrNull2.intValue());
            }
            if (arguments != null && (string = arguments.getString("message")) != null) {
                materialAlertDialogBuilder.setMessage((CharSequence) string);
            }
            AlertDialogFragmentListener alertDialogListener = getAlertDialogListener(activity);
            Integer intArgumentOrNull3 = getIntArgumentOrNull(POSITIVE_BUTTON_ID);
            if (intArgumentOrNull3 != null) {
                int iIntValue = intArgumentOrNull3.intValue();
                final Function2<DialogInterface, Integer, Unit> positiveButtonListener = getPositiveButtonListener(alertDialogListener);
                materialAlertDialogBuilder.setPositiveButton(iIntValue, new DialogInterface.OnClickListener() { // from class: com.box.android.base.presentation.fragments.AlertDialogFragment$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialogFragment.onCreateDialog$lambda$0$3$0(positiveButtonListener, dialogInterface, i);
                    }
                });
            }
            Integer intArgumentOrNull4 = getIntArgumentOrNull(NEUTRAL_BUTTON_ID);
            if (intArgumentOrNull4 != null) {
                int iIntValue2 = intArgumentOrNull4.intValue();
                final Function2<DialogInterface, Integer, Unit> neutralButtonListener = getNeutralButtonListener(alertDialogListener);
                materialAlertDialogBuilder.setNeutralButton(iIntValue2, new DialogInterface.OnClickListener() { // from class: com.box.android.base.presentation.fragments.AlertDialogFragment$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialogFragment.onCreateDialog$lambda$0$4$0(neutralButtonListener, dialogInterface, i);
                    }
                });
            }
            Integer intArgumentOrNull5 = getIntArgumentOrNull(NEGATIVE_BUTTON_ID);
            if (intArgumentOrNull5 != null) {
                int iIntValue3 = intArgumentOrNull5.intValue();
                final Function2<DialogInterface, Integer, Unit> negativeButtonListener = getNegativeButtonListener(alertDialogListener);
                materialAlertDialogBuilder.setNegativeButton(iIntValue3, new DialogInterface.OnClickListener() { // from class: com.box.android.base.presentation.fragments.AlertDialogFragment$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialogFragment.onCreateDialog$lambda$0$5$0(negativeButtonListener, dialogInterface, i);
                    }
                });
            }
            final Function1<DialogInterface, Unit> onDismissListener = getOnDismissListener(alertDialogListener);
            materialAlertDialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.box.android.base.presentation.fragments.AlertDialogFragment$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    onDismissListener.invoke(dialogInterface);
                }
            });
            AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
            if (alertDialogCreate != null) {
                return alertDialogCreate;
            }
        }
        throw new IllegalStateException("Activity cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0$3$0(Function2 function2, DialogInterface dialogInterface, int i) {
        function2.invoke(dialogInterface, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0$4$0(Function2 function2, DialogInterface dialogInterface, int i) {
        function2.invoke(dialogInterface, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0$5$0(Function2 function2, DialogInterface dialogInterface, int i) {
        function2.invoke(dialogInterface, Integer.valueOf(i));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        AlertDialogFragmentListener alertDialogListener;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        FragmentActivity activity = getActivity();
        if (activity != null && (alertDialogListener = getAlertDialogListener(activity)) != null) {
            alertDialogListener.onAlertDialogFragmentDismissed(getTag());
        }
        super.onDismiss(dialog);
    }

    private final Integer getIntArgumentOrNull(String key) {
        Bundle arguments = getArguments();
        Object obj = arguments != null ? arguments.get(key) : null;
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final AlertDialogFragmentListener getAlertDialogListener(Activity activity) {
        ActivityResultCaller parentFragment = getParentFragment();
        AlertDialogFragmentListener alertDialogFragmentListener = parentFragment instanceof AlertDialogFragmentListener ? (AlertDialogFragmentListener) parentFragment : null;
        if (alertDialogFragmentListener != null) {
            return alertDialogFragmentListener;
        }
        if (activity instanceof AlertDialogFragmentListener) {
            return (AlertDialogFragmentListener) activity;
        }
        return null;
    }

    private final Function2<DialogInterface, Integer, Unit> getPositiveButtonListener(final AlertDialogFragmentListener listener) {
        return new Function2() { // from class: com.box.android.base.presentation.fragments.AlertDialogFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AlertDialogFragment.getPositiveButtonListener$lambda$0(listener, this, (DialogInterface) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPositiveButtonListener$lambda$0(AlertDialogFragmentListener alertDialogFragmentListener, AlertDialogFragment alertDialogFragment, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogInterface, "<unused var>");
        if (alertDialogFragmentListener != null) {
            alertDialogFragmentListener.onAlertDialogFragmentPositiveButton(alertDialogFragment.getTag());
        }
        return Unit.INSTANCE;
    }

    private final Function2<DialogInterface, Integer, Unit> getNeutralButtonListener(final AlertDialogFragmentListener listener) {
        return new Function2() { // from class: com.box.android.base.presentation.fragments.AlertDialogFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AlertDialogFragment.getNeutralButtonListener$lambda$0(listener, this, (DialogInterface) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNeutralButtonListener$lambda$0(AlertDialogFragmentListener alertDialogFragmentListener, AlertDialogFragment alertDialogFragment, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogInterface, "<unused var>");
        if (alertDialogFragmentListener != null) {
            alertDialogFragmentListener.onAlertDialogFragmentNeutralButton(alertDialogFragment.getTag());
        }
        return Unit.INSTANCE;
    }

    private final Function2<DialogInterface, Integer, Unit> getNegativeButtonListener(final AlertDialogFragmentListener listener) {
        return new Function2() { // from class: com.box.android.base.presentation.fragments.AlertDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AlertDialogFragment.getNegativeButtonListener$lambda$0(listener, this, (DialogInterface) obj, ((Integer) obj2).intValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNegativeButtonListener$lambda$0(AlertDialogFragmentListener alertDialogFragmentListener, AlertDialogFragment alertDialogFragment, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogInterface, "<unused var>");
        if (alertDialogFragmentListener != null) {
            alertDialogFragmentListener.onAlertDialogFragmentNegativeButton(alertDialogFragment.getTag());
        }
        return Unit.INSTANCE;
    }

    private final Function1<DialogInterface, Unit> getOnDismissListener(final AlertDialogFragmentListener listener) {
        return new Function1() { // from class: com.box.android.base.presentation.fragments.AlertDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AlertDialogFragment.getOnDismissListener$lambda$0(listener, this, (DialogInterface) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getOnDismissListener$lambda$0(AlertDialogFragmentListener alertDialogFragmentListener, AlertDialogFragment alertDialogFragment, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "<unused var>");
        if (alertDialogFragmentListener != null) {
            alertDialogFragmentListener.onAlertDialogFragmentDismissed(alertDialogFragment.getTag());
        }
        return Unit.INSTANCE;
    }

    public final AlertDialogFragment setTitle(int titleId) {
        this.dialogArguments.putInt(TITLE_ID, titleId);
        return this;
    }

    public final AlertDialogFragment setMessage(int messageId) {
        this.dialogArguments.putInt(MESSAGE_ID, messageId);
        return this;
    }

    public final AlertDialogFragment setMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.dialogArguments.putString("message", message);
        return this;
    }

    public final AlertDialogFragment setPositiveButtonId(int positiveButtonId) {
        this.dialogArguments.putInt(POSITIVE_BUTTON_ID, positiveButtonId);
        return this;
    }

    public final AlertDialogFragment setNeutralButtonId(int neutralButtonId) {
        this.dialogArguments.putInt(NEUTRAL_BUTTON_ID, neutralButtonId);
        return this;
    }

    public final AlertDialogFragment setNegativeButtonId(int negativeButtonId) {
        this.dialogArguments.putInt(NEGATIVE_BUTTON_ID, negativeButtonId);
        return this;
    }
}
