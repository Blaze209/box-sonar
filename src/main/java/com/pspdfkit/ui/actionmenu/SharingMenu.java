package com.pspdfkit.ui.actionmenu;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.pspdfkit.R;
import com.pspdfkit.document.sharing.DocumentSharingIntentHelper;
import com.pspdfkit.document.sharing.ShareAction;
import com.pspdfkit.document.sharing.ShareTarget;
import com.pspdfkit.internal.no;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class SharingMenu extends ActionMenu {
    private static final String LOG_TAG = "Nutri.SharingMenu";
    private final SharingMenuListener listener;
    private ShareAction shareAction;
    private List<Intent> shareIntents;
    private String sharedFileName;

    public interface SharingMenuListener {
        void performShare(ShareTarget shareTarget);
    }

    public SharingMenu(FragmentActivity fragmentActivity, SharingMenuListener sharingMenuListener) {
        super(fragmentActivity);
        this.shareIntents = Collections.EMPTY_LIST;
        this.listener = sharingMenuListener;
    }

    private static String getDialogTitle(Context context, ShareAction shareAction) {
        return shareAction == ShareAction.VIEW ? no.a(context, R.string.pspdf__open, null) : no.a(context, R.string.pspdf__share, null);
    }

    private static Observable<List<ShareTarget>> getDocumentSharingTargetsAsync(Context context, List<Intent> list) {
        return DocumentSharingIntentHelper.getShareTargetsAsync(context, list).map(new Function() { // from class: com.pspdfkit.ui.actionmenu.SharingMenu$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Function
            public final Object apply(Object obj) {
                return SharingMenu.lambda$getDocumentSharingTargetsAsync$1((List) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread());
    }

    private static List<ActionMenuItem> getMenuItems(List<ShareTarget> list) {
        ArrayList arrayList = new ArrayList(list != null ? list.size() : 0);
        if (list != null) {
            for (ShareTarget shareTarget : list) {
                arrayList.add(new SharingMenuItem(shareTarget, shareTarget.getIcon(), shareTarget.getLabel()));
            }
        }
        return arrayList;
    }

    static /* synthetic */ List lambda$getDocumentSharingTargetsAsync$1(List list) throws Throwable {
        Collections.sort(list, new Comparator() { // from class: com.pspdfkit.ui.actionmenu.SharingMenu$$ExternalSyntheticLambda4
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((ShareTarget) obj).getLabel().compareTo(((ShareTarget) obj2).getLabel());
            }
        });
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refreshSharingTargets$3(Callable callable, List list) throws Throwable {
        clearStandardMenuItems();
        addMenuItems(getMenuItems(list));
        sanitizeMenuItems();
        if (callable != null) {
            try {
                callable.call();
            } catch (Exception e) {
                PdfLog.e(LOG_TAG, e, "Error in endAction while refreshing sharing targets.", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$show$2() throws Exception {
        return Boolean.valueOf(super.show());
    }

    private boolean refreshSharingTargets(final Callable<Boolean> callable) {
        if (getContext() == null) {
            return false;
        }
        if (!this.shareIntents.isEmpty()) {
            getDocumentSharingTargetsAsync(getContext(), this.shareIntents).subscribe(new Consumer() { // from class: com.pspdfkit.ui.actionmenu.SharingMenu$$ExternalSyntheticLambda2
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) throws Throwable {
                    this.f$0.lambda$refreshSharingTargets$3(callable, (List) obj);
                }
            }, new Consumer() { // from class: com.pspdfkit.ui.actionmenu.SharingMenu$$ExternalSyntheticLambda3
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) {
                    PdfLog.e(SharingMenu.LOG_TAG, (Throwable) obj, "Error while refreshing sharing targets.", new Object[0]);
                }
            });
            return true;
        }
        clearStandardMenuItems();
        if (callable == null) {
            return true;
        }
        try {
            return callable.call().booleanValue();
        } catch (Exception e) {
            PdfLog.e(LOG_TAG, e, "Error in endAction while refreshing sharing targets.", new Object[0]);
            return true;
        }
    }

    public ShareAction getShareAction() {
        return this.shareAction;
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenu
    public boolean onMenuItemClicked(ActionMenuItem actionMenuItem) {
        if (super.onMenuItemClicked(actionMenuItem)) {
            return true;
        }
        if (this.listener == null || !(actionMenuItem instanceof SharingMenuItem)) {
            return false;
        }
        dismiss();
        this.listener.performShare(((SharingMenuItem) actionMenuItem).getShareTarget());
        return true;
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenu
    public boolean onMenuItemLongClicked(ActionMenuItem actionMenuItem) {
        if (super.onMenuItemLongClicked(actionMenuItem)) {
            return true;
        }
        if (!(actionMenuItem instanceof SharingMenuItem) || getContext() == null) {
            return false;
        }
        DocumentSharingIntentHelper.showShareTargetDetails(getContext(), ((SharingMenuItem) actionMenuItem).getShareTarget());
        return true;
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenu
    public void onNoActionsVisible() {
        if (getContext() == null) {
            return;
        }
        Toast.makeText(getContext(), no.a(getContext(), R.string.pspdf__no_applications_found, null), 0).show();
    }

    public void sanitizeMenuItems() {
    }

    public void setShareAction(ShareAction shareAction) {
        if (getContext() == null) {
            throw new IllegalStateException("Can't set share action when sharing menu is detached from activity!");
        }
        this.shareAction = shareAction;
        if (shareAction != null) {
            setShareIntents(Collections.singletonList(DocumentSharingIntentHelper.getShareIntent(getContext(), shareAction, this.sharedFileName)));
        } else {
            setShareIntents(Collections.EMPTY_LIST);
        }
        setTitle(getDialogTitle(getContext(), shareAction));
    }

    public ActionMenu setShareIntents(List<Intent> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        this.shareIntents = new ArrayList(list);
        if (getDialog() != null) {
            refreshSharingTargets(null);
        }
        return this;
    }

    public void setSharedFileName(String str) {
        this.sharedFileName = str;
    }

    @Override // com.pspdfkit.ui.actionmenu.ActionMenu
    public boolean show() {
        return refreshSharingTargets(new Callable() { // from class: com.pspdfkit.ui.actionmenu.SharingMenu$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$show$2();
            }
        });
    }
}
