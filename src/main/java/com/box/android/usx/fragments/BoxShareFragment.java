package com.box.android.usx.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity;
import com.box.android.utilities.CollaborationUtils;
import com.box.android.vm.BaseShareVM;
import com.box.androidsdk.content.models.BoxItem;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BoxShareFragment extends Fragment {
    private static final long DEFAULT_SPINNER_DELAY = 500;
    protected static final String TAG = "com.box.android.usx.fragments.BoxShareFragment";
    private LastRunnableHandler mDialogHandler;
    private BaseShareVM vm;

    public interface ShareVMFactoryProvider {
        ViewModelProvider.Factory getShareVMFactory();
    }

    public abstract <T extends BaseShareVM> Class<T> getVMClass();

    protected abstract void setTitles();

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.mDialogHandler = new LastRunnableHandler();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        BoxItem boxItem;
        super.onActivityCreated(bundle);
        BaseShareVM baseShareVM = (BaseShareVM) new ViewModelProvider(getActivity(), ((ShareVMFactoryProvider) getActivity()).getShareVMFactory()).get(getVMClass());
        this.vm = baseShareVM;
        if (baseShareVM.getShareItem() == null) {
            if (bundle != null && bundle.getSerializable(CollaborationUtils.EXTRA_ITEM) != null) {
                boxItem = (BoxItem) bundle.getSerializable(CollaborationUtils.EXTRA_ITEM);
            } else {
                boxItem = getArguments() != null ? (BoxItem) getArguments().getSerializable(CollaborationUtils.EXTRA_ITEM) : null;
            }
            this.vm.setShareItem(boxItem);
        }
        if (this.vm.getShareItem() == null) {
            showToast(R.string.box_sharesdk_no_item_selected);
            getActivity().finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(CollaborationUtils.EXTRA_ITEM, this.vm.getShareItem());
        super.onSaveInstanceState(bundle);
    }

    public void addResult(Intent intent) {
        intent.putExtra(CollaborationUtils.EXTRA_ITEM, this.vm.getShareItem());
    }

    protected void dismissSpinner() {
        try {
            ((BoxSpinnerDialogFragmentActivity) requireActivity()).dismissSpinnerSynchronous();
            this.mDialogHandler.cancelLastRunnable();
        } catch (Exception unused) {
        }
    }

    protected void showSpinner() {
        showSpinner(500L);
    }

    protected void showSpinner(long j) {
        showSpinner(R.string.boxsdk_Please_wait, j);
    }

    protected void showSpinner(final int i, long j) {
        this.mDialogHandler.queue(new Runnable() { // from class: com.box.android.usx.fragments.BoxShareFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showSpinner$0(i);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSpinner$0(int i) {
        try {
            ((BoxSpinnerDialogFragmentActivity) requireActivity()).showSpinner(getString(i), true);
        } catch (Exception unused) {
        }
    }

    protected void showSpinner(int i) {
        showSpinner(i, 500L);
    }

    public static Bundle getBundle(BoxItem boxItem) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(CollaborationUtils.EXTRA_ITEM, boxItem);
        return bundle;
    }

    private class LastRunnableHandler extends Handler {
        private Runnable mLastRunable;

        private LastRunnableHandler() {
        }

        public void queue(Runnable runnable, long j) {
            cancelLastRunnable();
            postDelayed(runnable, j);
            this.mLastRunable = runnable;
        }

        public void cancelLastRunnable() {
            Runnable runnable = this.mLastRunable;
            if (runnable != null) {
                removeCallbacks(runnable);
            }
        }
    }

    protected void showToast(String str) {
        Toast.makeText(getContext(), str, 0).show();
    }

    protected void showToast(int i) {
        Toast.makeText(getContext(), getString(i), 0).show();
    }
}
