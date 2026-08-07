package com.box.android.capture.documentscanning.presentation.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.compose.DialogNavigator;
import com.box.android.capture.R;
import com.box.android.capture.databinding.DialogColorFiltersBinding;
import com.box.android.domain.models.DocumentPageFilterType;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilterDialog.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/capture/documentscanning/presentation/dialogs/FilterDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "selectedFilterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "(Lcom/box/android/domain/models/DocumentPageFilterType;)V", "binding", "Lcom/box/android/capture/databinding/DialogColorFiltersBinding;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "setUpListeners", "", DialogNavigator.NAME, "dismissAndSendSelectedFilter", "filterType", "FilterDialogListener", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilterDialog extends DialogFragment {
    public static final String SELECTED_FILTER = "selectedFilter";
    private DialogColorFiltersBinding binding;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: FilterDialog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/box/android/capture/documentscanning/presentation/dialogs/FilterDialog$FilterDialogListener;", "", "filterSelected", "", "filterType", "Lcom/box/android/domain/models/DocumentPageFilterType;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface FilterDialogListener {
        void filterSelected(DocumentPageFilterType filterType);
    }

    /* JADX INFO: compiled from: FilterDialog.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DocumentPageFilterType.values().length];
            try {
                iArr[DocumentPageFilterType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DocumentPageFilterType.BLACK_AND_WHITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DocumentPageFilterType.MONOCHROME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DocumentPageFilterType.PHOTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FilterDialog() {
    }

    public FilterDialog(DocumentPageFilterType documentPageFilterType) {
        this();
        Bundle bundle = new Bundle();
        bundle.putSerializable(SELECTED_FILTER, documentPageFilterType);
        setArguments(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        TextView textView;
        if (getActivity() != null) {
            DialogColorFiltersBinding dialogColorFiltersBindingInflate = DialogColorFiltersBinding.inflate(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(dialogColorFiltersBindingInflate, "inflate(...)");
            this.binding = dialogColorFiltersBindingInflate;
            Bundle arguments = getArguments();
            DialogColorFiltersBinding dialogColorFiltersBinding = null;
            Serializable serializable = arguments != null ? arguments.getSerializable(SELECTED_FILTER) : null;
            DocumentPageFilterType documentPageFilterType = serializable instanceof DocumentPageFilterType ? (DocumentPageFilterType) serializable : null;
            int i = documentPageFilterType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[documentPageFilterType.ordinal()];
            if (i == 1) {
                DialogColorFiltersBinding dialogColorFiltersBinding2 = this.binding;
                if (dialogColorFiltersBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogColorFiltersBinding2 = null;
                }
                textView = dialogColorFiltersBinding2.filterNone;
            } else if (i == 2) {
                DialogColorFiltersBinding dialogColorFiltersBinding3 = this.binding;
                if (dialogColorFiltersBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogColorFiltersBinding3 = null;
                }
                textView = dialogColorFiltersBinding3.filterBlackAndWhite;
            } else if (i == 3) {
                DialogColorFiltersBinding dialogColorFiltersBinding4 = this.binding;
                if (dialogColorFiltersBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogColorFiltersBinding4 = null;
                }
                textView = dialogColorFiltersBinding4.filterMonochrome;
            } else if (i == 4) {
                DialogColorFiltersBinding dialogColorFiltersBinding5 = this.binding;
                if (dialogColorFiltersBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogColorFiltersBinding5 = null;
                }
                textView = dialogColorFiltersBinding5.filterPhoto;
            } else {
                DialogColorFiltersBinding dialogColorFiltersBinding6 = this.binding;
                if (dialogColorFiltersBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    dialogColorFiltersBinding6 = null;
                }
                textView = dialogColorFiltersBinding6.filterNone;
            }
            textView.setSelected(true);
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(requireActivity());
            DialogColorFiltersBinding dialogColorFiltersBinding7 = this.binding;
            if (dialogColorFiltersBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogColorFiltersBinding = dialogColorFiltersBinding7;
            }
            AlertDialog alertDialogCreate = materialAlertDialogBuilder.setView((View) dialogColorFiltersBinding.getRoot()).setTitle(R.string.document_scan_select_filter).create();
            Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
            AlertDialog alertDialog = alertDialogCreate;
            setUpListeners(alertDialog);
            if (alertDialogCreate != null) {
                return alertDialog;
            }
        }
        throw new IllegalStateException("Activity cannot be null");
    }

    private final void setUpListeners(final Dialog dialog) {
        DialogColorFiltersBinding dialogColorFiltersBinding = this.binding;
        DialogColorFiltersBinding dialogColorFiltersBinding2 = null;
        if (dialogColorFiltersBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogColorFiltersBinding = null;
        }
        dialogColorFiltersBinding.filterNone.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.dialogs.FilterDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterDialog.setUpListeners$lambda$0(this.f$0, dialog, view);
            }
        });
        DialogColorFiltersBinding dialogColorFiltersBinding3 = this.binding;
        if (dialogColorFiltersBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogColorFiltersBinding3 = null;
        }
        dialogColorFiltersBinding3.filterMonochrome.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.dialogs.FilterDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterDialog.setUpListeners$lambda$1(this.f$0, dialog, view);
            }
        });
        DialogColorFiltersBinding dialogColorFiltersBinding4 = this.binding;
        if (dialogColorFiltersBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogColorFiltersBinding4 = null;
        }
        dialogColorFiltersBinding4.filterBlackAndWhite.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.dialogs.FilterDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterDialog.setUpListeners$lambda$2(this.f$0, dialog, view);
            }
        });
        DialogColorFiltersBinding dialogColorFiltersBinding5 = this.binding;
        if (dialogColorFiltersBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogColorFiltersBinding2 = dialogColorFiltersBinding5;
        }
        dialogColorFiltersBinding2.filterPhoto.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.capture.documentscanning.presentation.dialogs.FilterDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterDialog.setUpListeners$lambda$3(this.f$0, dialog, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpListeners$lambda$0(FilterDialog filterDialog, Dialog dialog, View view) {
        filterDialog.dismissAndSendSelectedFilter(dialog, DocumentPageFilterType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpListeners$lambda$1(FilterDialog filterDialog, Dialog dialog, View view) {
        filterDialog.dismissAndSendSelectedFilter(dialog, DocumentPageFilterType.MONOCHROME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpListeners$lambda$2(FilterDialog filterDialog, Dialog dialog, View view) {
        filterDialog.dismissAndSendSelectedFilter(dialog, DocumentPageFilterType.BLACK_AND_WHITE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpListeners$lambda$3(FilterDialog filterDialog, Dialog dialog, View view) {
        filterDialog.dismissAndSendSelectedFilter(dialog, DocumentPageFilterType.PHOTO);
    }

    private final void dismissAndSendSelectedFilter(Dialog dialog, DocumentPageFilterType filterType) {
        dialog.dismiss();
        ActivityResultCaller parentFragment = getParentFragment();
        FilterDialogListener filterDialogListener = parentFragment instanceof FilterDialogListener ? (FilterDialogListener) parentFragment : null;
        if (filterDialogListener != null) {
            filterDialogListener.filterSelected(filterType);
        }
    }
}
