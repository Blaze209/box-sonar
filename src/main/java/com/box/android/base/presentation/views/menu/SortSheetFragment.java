package com.box.android.base.presentation.views.menu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.box.android.base.R;
import com.box.android.base.models.BottomSheetMenuItem;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.messages.BoxSortPreferencesMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.domain.localrepo.LocalSortPreferences;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes9.dex */
public class SortSheetFragment extends Hilt_SortSheetFragment {

    @Inject
    protected IBaseModelController mBaseMoco;
    private LocalSortPreferences.SortBy mSortBy;
    private LocalSortPreferences.SortOrder mSortOrder;

    @Inject
    protected LocalSortPreferences mSortPrefs;

    @Override // com.box.android.base.presentation.views.menu.Hilt_SortSheetFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mSortBy = this.mSortPrefs.getSortBy();
        this.mSortOrder = this.mSortPrefs.getSortOrder();
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        super.setupDialog(dialog, i);
        ((LinearLayout) this.mContentView).addView(View.inflate(getContext(), R.layout.sort_order_menu_header, null), 0);
        this.mRecyclerView.setHasFixedSize(true);
        updateViews();
    }

    @Override // com.box.android.base.presentation.fragments.BottomSheetMenuFragment
    protected void onMenuItemClicked(BottomSheetMenuItem bottomSheetMenuItem) {
        this.mSortBy = getSortByFromId(bottomSheetMenuItem.getId());
        if (bottomSheetMenuItem.getIcon() != null) {
            this.mSortOrder = this.mSortOrder == LocalSortPreferences.SortOrder.ASC ? LocalSortPreferences.SortOrder.DESC : LocalSortPreferences.SortOrder.ASC;
        } else {
            this.mSortOrder = LocalSortPreferences.SortOrder.ASC;
        }
        this.mSortPrefs.saveSortOrder(this.mSortOrder);
        this.mSortPrefs.saveSortBy(this.mSortBy);
        updateViews();
        BoxSortPreferencesMessage boxSortPreferencesMessage = new BoxSortPreferencesMessage();
        boxSortPreferencesMessage.setAction(Controller.ACTION_SORT_PREFERENCES_CHANGED);
        boxSortPreferencesMessage.setSuccess(true);
        CoreServiceUtils.broadcastIntent(this.mUserContextManager, boxSortPreferencesMessage);
    }

    private void updateViews() {
        int menuItemId = getMenuItemId(this.mSortBy);
        updateMenuItemIcon(menuItemId, this.mSortOrder == LocalSortPreferences.SortOrder.ASC ? R.drawable.arrow_up_dark : R.drawable.arrow_down_dark);
        for (BottomSheetMenuItem bottomSheetMenuItem : getMenuItems()) {
            if (bottomSheetMenuItem.getId() != menuItemId && bottomSheetMenuItem.getIcon() != null) {
                updateMenuItemIcon(bottomSheetMenuItem.getId(), 0);
            }
        }
    }

    private static LocalSortPreferences.SortBy getSortByFromId(int i) {
        if (i == R.id.sort_by_date) {
            return LocalSortPreferences.SortBy.MODIFIED_AT;
        }
        if (i == R.id.sort_by_name) {
            return LocalSortPreferences.SortBy.NAME;
        }
        return LocalSortPreferences.SortBy.SIZE;
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.views.menu.SortSheetFragment$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$domain$localrepo$LocalSortPreferences$SortBy;

        static {
            int[] iArr = new int[LocalSortPreferences.SortBy.values().length];
            $SwitchMap$com$box$android$domain$localrepo$LocalSortPreferences$SortBy = iArr;
            try {
                iArr[LocalSortPreferences.SortBy.SIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$domain$localrepo$LocalSortPreferences$SortBy[LocalSortPreferences.SortBy.NAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static int getMenuItemId(LocalSortPreferences.SortBy sortBy) {
        int i = AnonymousClass1.$SwitchMap$com$box$android$domain$localrepo$LocalSortPreferences$SortBy[sortBy.ordinal()];
        if (i == 1) {
            return R.id.sort_by_size;
        }
        if (i == 2) {
            return R.id.sort_by_name;
        }
        return R.id.sort_by_date;
    }

    public void showAndHideSoftInput(FragmentActivity fragmentActivity, IBinder iBinder) {
        ((InputMethodManager) fragmentActivity.getSystemService("input_method")).hideSoftInputFromWindow(iBinder, 0);
        show(fragmentActivity.getSupportFragmentManager(), BottomSheetMenuFragment.TAG);
    }

    public static SortSheetFragment newInstance(Activity activity) {
        SortSheetFragment sortSheetFragment = new SortSheetFragment();
        sortSheetFragment.setArguments(getBundle(activity, R.menu.folder_sort_options, true));
        return sortSheetFragment;
    }
}
