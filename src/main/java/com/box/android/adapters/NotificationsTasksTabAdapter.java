package com.box.android.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.fragments.boxitem.InboxFragment;
import com.box.android.fragments.boxitem.MyTasksFragment;
import com.box.android.fragments.boxitem.SentTasksFragment;

/* JADX INFO: loaded from: classes9.dex */
public class NotificationsTasksTabAdapter extends FragmentStatePagerAdapter {

    public enum TabOrder {
        NOTIFICATION,
        MY_TASKS,
        SENT_TASKS
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 3;
    }

    public NotificationsTasksTabAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int i) {
        if (i >= TabOrder.values().length) {
            return null;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$box$android$adapters$NotificationsTasksTabAdapter$TabOrder[TabOrder.values()[i].ordinal()];
        if (i2 == 1) {
            return new InboxFragment();
        }
        if (i2 == 2) {
            return new MyTasksFragment();
        }
        if (i2 != 3) {
            return null;
        }
        return new SentTasksFragment();
    }

    /* JADX INFO: renamed from: com.box.android.adapters.NotificationsTasksTabAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$adapters$NotificationsTasksTabAdapter$TabOrder;

        static {
            int[] iArr = new int[TabOrder.values().length];
            $SwitchMap$com$box$android$adapters$NotificationsTasksTabAdapter$TabOrder = iArr;
            try {
                iArr[TabOrder.NOTIFICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$adapters$NotificationsTasksTabAdapter$TabOrder[TabOrder.MY_TASKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$android$adapters$NotificationsTasksTabAdapter$TabOrder[TabOrder.SENT_TASKS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return ((BoxFragmentInterface) getItem(i)).getTitle(BoxBaseApplication.getInstance());
    }
}
