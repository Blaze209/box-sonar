package com.box.android.base.presentation.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.box.android.base.R;
import com.box.android.base.databinding.DialogMultiSelectBodyBinding;
import com.box.android.base.databinding.DialogMultiSelectCustomTitleBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MultiSelectDialogFragment.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0002J\u0016\u0010%\u001a\u00020$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0004J\u0012\u0010(\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0012H&J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020$H&J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020$H&J\b\u00100\u001a\u00020$H&R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0012X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/box/android/base/presentation/fragments/MultiSelectDialogFragment;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "adapter", "Landroidx/recyclerview/widget/ListAdapter;", "getAdapter", "()Landroidx/recyclerview/widget/ListAdapter;", "setAdapter", "(Landroidx/recyclerview/widget/ListAdapter;)V", "addButtonContentDescription", "", "getAddButtonContentDescription", "()Ljava/lang/String;", "setAddButtonContentDescription", "(Ljava/lang/String;)V", "title", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "setupRecyclerView", "", "renderList", "newList", "", "createAdapter", "isAddButtonAvailable", "", "onAddButton", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onPositiveButton", "onNegativeButton", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class MultiSelectDialogFragment<T> extends DialogFragment {
    public static final int $stable = 8;
    protected ListAdapter<T, ?> adapter;
    private String addButtonContentDescription;
    protected ProgressBar progressBar;
    protected RecyclerView recyclerView;
    private int title;

    public abstract ListAdapter<T, ?> createAdapter();

    public boolean isAddButtonAvailable() {
        return false;
    }

    public abstract void onAddButton();

    public abstract void onNegativeButton();

    public abstract void onPositiveButton();

    protected final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    protected final void setRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.recyclerView = recyclerView;
    }

    protected final ProgressBar getProgressBar() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            return progressBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        return null;
    }

    protected final void setProgressBar(ProgressBar progressBar) {
        Intrinsics.checkNotNullParameter(progressBar, "<set-?>");
        this.progressBar = progressBar;
    }

    protected final ListAdapter<T, ?> getAdapter() {
        ListAdapter<T, ?> listAdapter = this.adapter;
        if (listAdapter != null) {
            return listAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    protected final void setAdapter(ListAdapter<T, ?> listAdapter) {
        Intrinsics.checkNotNullParameter(listAdapter, "<set-?>");
        this.adapter = listAdapter;
    }

    protected final String getAddButtonContentDescription() {
        return this.addButtonContentDescription;
    }

    protected final void setAddButtonContentDescription(String str) {
        this.addButtonContentDescription = str;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt(MultiSelectDialogFragmentKt.DIALOG_TITLE)) : null;
        Intrinsics.checkNotNull(numValueOf);
        this.title = numValueOf.intValue();
        DialogMultiSelectCustomTitleBinding dialogMultiSelectCustomTitleBindingInflate = DialogMultiSelectCustomTitleBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(dialogMultiSelectCustomTitleBindingInflate, "inflate(...)");
        dialogMultiSelectCustomTitleBindingInflate.dialogTitle.setText(getString(this.title));
        if (isAddButtonAvailable()) {
            AppCompatImageButton appCompatImageButton = dialogMultiSelectCustomTitleBindingInflate.addItemButton;
            appCompatImageButton.setContentDescription(this.addButtonContentDescription);
            appCompatImageButton.setVisibility(0);
            appCompatImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.base.presentation.fragments.MultiSelectDialogFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.onAddButton();
                }
            });
        }
        DialogMultiSelectBodyBinding dialogMultiSelectBodyBindingInflate = DialogMultiSelectBodyBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(dialogMultiSelectBodyBindingInflate, "inflate(...)");
        RecyclerView recyclerView = dialogMultiSelectBodyBindingInflate.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        setRecyclerView(recyclerView);
        ProgressBar progressBar = dialogMultiSelectBodyBindingInflate.progressBar;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        setProgressBar(progressBar);
        setupRecyclerView();
        AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(requireContext()).setCustomTitle((View) dialogMultiSelectCustomTitleBindingInflate.getRoot()).setView((View) dialogMultiSelectBodyBindingInflate.getRoot()).setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() { // from class: com.box.android.base.presentation.fragments.MultiSelectDialogFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.onNegativeButton();
            }
        }).setPositiveButton(R.string.Done, new DialogInterface.OnClickListener() { // from class: com.box.android.base.presentation.fragments.MultiSelectDialogFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.onPositiveButton();
            }
        }).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        return alertDialogCreate;
    }

    private final void setupRecyclerView() {
        getRecyclerView().setLayoutManager(new LinearLayoutManager(getContext()));
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) getRecyclerView().getItemAnimator();
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        if (this.adapter == null) {
            setAdapter(createAdapter());
        }
        getRecyclerView().setAdapter(getAdapter());
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void renderList(List<? extends T> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        getProgressBar().setVisibility(8);
        getAdapter().submitList(newList);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        MultiSelectDialogFragment<T> multiSelectDialogFragment = this;
        getParentFragmentManager().beginTransaction().detach(multiSelectDialogFragment).commitNow();
        getParentFragmentManager().beginTransaction().attach(multiSelectDialogFragment).commitNow();
    }
}
