package com.pspdfkit.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.c30;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.uw;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class AnnotationCreatorInputDialogFragment extends DialogFragment {
    private static final String BUNDLE_ARGUMENT_CREATOR_SUGGESTION = "BUNDLE_ARGUMENT_CREATOR_SUGGESTION";
    private static final String BUNDLE_INSTANCE_STATE_CLEAR_CREATOR_NAME_INPUT_ONCLICK = "BUNDLE_INSTANCE_STATE_CLEAR_CREATOR_NAME_INPUT_ONCLICK";
    private static final String BUNDLE_INSTANCE_STATE_CREATOR_NAME = "BUNDLE_INSTANCE_STATE_CREATOR_NAME";
    private static final String FRAGMENT_TAG = "com.pspdfkit.ui.AnnotationCreatorInputDialogFragment.FRAGMENT_TAG";
    private final AtomicBoolean clearCreatorNameInputOnClick = new AtomicBoolean(true);
    private EditText creatorNameInput;
    private DialogInterface.OnClickListener dialogClickListener;
    private OnAnnotationCreatorSetListener onAnnotationCreatorSetListener;

    public interface OnAnnotationCreatorSetListener {
        void onAbort();

        void onAnnotationCreatorSet(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disallowCreatorNameInputOnClick() {
        this.creatorNameInput.setOnClickListener(null);
        this.clearCreatorNameInputOnClick.set(false);
    }

    private String getCreatorNameFromEditText() {
        return this.creatorNameInput.getText().toString();
    }

    public static void hide(FragmentManager fragmentManager) {
        AnnotationCreatorInputDialogFragment annotationCreatorInputDialogFragment = (AnnotationCreatorInputDialogFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (annotationCreatorInputDialogFragment != null) {
            annotationCreatorInputDialogFragment.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onCreate$0(DialogInterface dialogInterface, int i) {
        if (i == -2) {
            OnAnnotationCreatorSetListener onAnnotationCreatorSetListener = this.onAnnotationCreatorSetListener;
            if (onAnnotationCreatorSetListener != null) {
                onAnnotationCreatorSetListener.onAbort();
            }
            i0 i0VarA = ar.a();
            i0VarA.getClass();
            i0VarA.a(Analytics.Event.CANCEL_ANNOTATION_CREATOR_DIALOG, new Bundle());
            return;
        }
        if (i != -1) {
            return;
        }
        String creatorNameFromEditText = getCreatorNameFromEditText();
        PSPDFKitPreferences.get(requireContext()).setAnnotationCreator(creatorNameFromEditText);
        OnAnnotationCreatorSetListener onAnnotationCreatorSetListener2 = this.onAnnotationCreatorSetListener;
        if (onAnnotationCreatorSetListener2 != null) {
            onAnnotationCreatorSetListener2.onAnnotationCreatorSet(creatorNameFromEditText);
        }
        i0 i0VarA2 = ar.a();
        i0VarA2.getClass();
        i0VarA2.a(Analytics.Event.SET_ANNOTATION_CREATOR, new Bundle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreateDialog$1(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 66 || !((AlertDialog) dialogInterface).getButton(-1).isEnabled()) {
            return false;
        }
        this.dialogClickListener.onClick(dialogInterface, -1);
        dialogInterface.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$2(View view) {
        this.creatorNameInput.setText("");
        disallowCreatorNameInputOnClick();
    }

    private static AnnotationCreatorInputDialogFragment newInstance() {
        AnnotationCreatorInputDialogFragment annotationCreatorInputDialogFragment = new AnnotationCreatorInputDialogFragment();
        annotationCreatorInputDialogFragment.setArguments(new Bundle());
        return annotationCreatorInputDialogFragment;
    }

    private void restoreState(Bundle bundle) {
        this.creatorNameInput.setText(bundle.getString(BUNDLE_INSTANCE_STATE_CREATOR_NAME));
        this.clearCreatorNameInputOnClick.set(bundle.getBoolean(BUNDLE_INSTANCE_STATE_CLEAR_CREATOR_NAME_INPUT_ONCLICK));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOkButtonEnabledState() {
        AlertDialog alertDialog;
        if (isResumed() && (alertDialog = (AlertDialog) getDialog()) != null) {
            alertDialog.getButton(-1).setEnabled(!getCreatorNameFromEditText().isEmpty());
        }
    }

    private void setSuggestedCreator(String str) {
        getArguments().putString(BUNDLE_ARGUMENT_CREATOR_SUGGESTION, str);
    }

    public static void show(FragmentManager fragmentManager, String str, OnAnnotationCreatorSetListener onAnnotationCreatorSetListener) {
        uw.a(onAnnotationCreatorSetListener, "onAnnotationCreatorSetListener", null);
        AnnotationCreatorInputDialogFragment annotationCreatorInputDialogFragmentNewInstance = (AnnotationCreatorInputDialogFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (annotationCreatorInputDialogFragmentNewInstance == null) {
            annotationCreatorInputDialogFragmentNewInstance = newInstance();
        }
        annotationCreatorInputDialogFragmentNewInstance.onAnnotationCreatorSetListener = onAnnotationCreatorSetListener;
        annotationCreatorInputDialogFragmentNewInstance.setSuggestedCreator(str);
        if (annotationCreatorInputDialogFragmentNewInstance.isAdded() || annotationCreatorInputDialogFragmentNewInstance.isStateSaved()) {
            return;
        }
        annotationCreatorInputDialogFragmentNewInstance.show(fragmentManager, FRAGMENT_TAG);
    }

    public String getSuggestedCreator() {
        return getArguments().getString(BUNDLE_ARGUMENT_CREATOR_SUGGESTION);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dialogClickListener = new DialogInterface.OnClickListener() { // from class: com.pspdfkit.ui.AnnotationCreatorInputDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$onCreate$0(dialogInterface, i);
            }
        };
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        View viewInflate = getLayoutInflater().inflate(R.layout.pspdf__annotation_creator_input_dialog, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(viewInflate).setTitle(R.string.pspdf__annotation_creator_author_name).setPositiveButton(no.a(requireContext(), R.string.pspdf__ok, null), this.dialogClickListener).setNegativeButton(no.a(requireContext(), R.string.pspdf__cancel, null), this.dialogClickListener).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.pspdfkit.ui.AnnotationCreatorInputDialogFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$onCreateDialog$1(dialogInterface, i, keyEvent);
            }
        }).create();
        EditText editText = (EditText) viewInflate.findViewById(R.id.pspdf__creator_name_input);
        this.creatorNameInput = editText;
        editText.requestFocus();
        String suggestedCreator = getSuggestedCreator();
        if (bundle != null) {
            restoreState(bundle);
        } else if (PSPDFKitPreferences.get(requireContext()).isAnnotationCreatorSet()) {
            this.creatorNameInput.setText(PSPDFKitPreferences.get(requireContext()).getAnnotationCreator(""));
        } else if (suggestedCreator != null) {
            this.creatorNameInput.setText(suggestedCreator);
        }
        if (this.clearCreatorNameInputOnClick.get()) {
            this.creatorNameInput.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.AnnotationCreatorInputDialogFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreateDialog$2(view);
                }
            });
        }
        this.creatorNameInput.addTextChangedListener(new c30() { // from class: com.pspdfkit.ui.AnnotationCreatorInputDialogFragment.1
            @Override // com.pspdfkit.internal.c30, android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AnnotationCreatorInputDialogFragment.this.disallowCreatorNameInputOnClick();
                AnnotationCreatorInputDialogFragment.this.setOkButtonEnabledState();
            }
        });
        alertDialogCreate.getWindow().setSoftInputMode(4);
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setOkButtonEnabledState();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString(BUNDLE_INSTANCE_STATE_CREATOR_NAME, getCreatorNameFromEditText());
        bundle.putBoolean(BUNDLE_INSTANCE_STATE_CLEAR_CREATOR_NAME_INPUT_ONCLICK, this.clearCreatorNameInputOnClick.get());
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void setOnAnnotationCreatorSetListener(OnAnnotationCreatorSetListener onAnnotationCreatorSetListener) {
        this.onAnnotationCreatorSetListener = onAnnotationCreatorSetListener;
    }
}
