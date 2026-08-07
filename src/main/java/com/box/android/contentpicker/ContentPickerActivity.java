package com.box.android.contentpicker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.activity.compose.ComponentActivityKt;
import androidx.core.content.IntentCompat;
import com.box.android.base.presentation.multiselect.ContentPickerConstants;
import com.box.android.base.presentation.multiselect.SelectionItemInfo;
import com.box.android.base.presentation.multiselect.SelectionManager;
import com.box.android.contentpicker.multitabitempicker.ItemPickerTab;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ContentPickerActivity.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/box/android/contentpicker/ContentPickerActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "selectionManager", "Lcom/box/android/base/presentation/multiselect/SelectionManager;", "getSelectionManager", "()Lcom/box/android/base/presentation/multiselect/SelectionManager;", "setSelectionManager", "(Lcom/box/android/base/presentation/multiselect/SelectionManager;)V", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class ContentPickerActivity extends Hilt_ContentPickerActivity {
    private static final String EXTRA_ENABLED_TABS = "EXTRA_ENABLED_TABS";

    @Inject
    public SelectionManager selectionManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public final SelectionManager getSelectionManager() {
        SelectionManager selectionManager = this.selectionManager;
        if (selectionManager != null) {
            return selectionManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("selectionManager");
        return null;
    }

    public final void setSelectionManager(SelectionManager selectionManager) {
        Intrinsics.checkNotNullParameter(selectionManager, "<set-?>");
        this.selectionManager = selectionManager;
    }

    /* JADX INFO: compiled from: ContentPickerActivity.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007*\u00020\tJ\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007*\u00020\tJ,\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/contentpicker/ContentPickerActivity$Companion;", "", "<init>", "()V", ContentPickerActivity.EXTRA_ENABLED_TABS, "", "parseEnabledTabs", "", "Lcom/box/android/contentpicker/multitabitempicker/ItemPickerTab;", "Landroid/content/Intent;", "parseInitialSelections", "Lcom/box/android/base/presentation/multiselect/SelectionItemInfo;", "getIntent", "context", "Landroid/content/Context;", "enabledTabs", "initialSelections", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<ItemPickerTab> parseEnabledTabs(Intent intent) {
            ItemPickerTab next;
            Intrinsics.checkNotNullParameter(intent, "<this>");
            String[] stringArrayExtra = intent.getStringArrayExtra(ContentPickerActivity.EXTRA_ENABLED_TABS);
            if (stringArrayExtra == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : stringArrayExtra) {
                Iterator<ItemPickerTab> it = ItemPickerTab.getEntries().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!StringsKt.equals(next.name(), str, true));
                ItemPickerTab itemPickerTab = next;
                if (itemPickerTab != null) {
                    arrayList.add(itemPickerTab);
                }
            }
            return arrayList;
        }

        public final List<SelectionItemInfo> parseInitialSelections(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "<this>");
            ArrayList parcelableArrayListExtra = IntentCompat.getParcelableArrayListExtra(intent, ContentPickerConstants.EXTRA_INITIAL_SELECTIONS, SelectionItemInfo.class);
            return parcelableArrayListExtra != null ? parcelableArrayListExtra : CollectionsKt.emptyList();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Intent getIntent$default(Companion companion, Context context, List list, List list2, int i, Object obj) {
            if ((i & 4) != 0) {
                list2 = CollectionsKt.emptyList();
            }
            return companion.getIntent(context, list, list2);
        }

        public final Intent getIntent(Context context, List<? extends ItemPickerTab> enabledTabs, List<SelectionItemInfo> initialSelections) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(enabledTabs, "enabledTabs");
            Intrinsics.checkNotNullParameter(initialSelections, "initialSelections");
            Intent intent = new Intent(context, (Class<?>) ContentPickerActivity.class);
            List<? extends ItemPickerTab> list = enabledTabs;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((ItemPickerTab) it.next()).name());
            }
            intent.putExtra(ContentPickerActivity.EXTRA_ENABLED_TABS, (String[]) arrayList.toArray(new String[0]));
            intent.putParcelableArrayListExtra(ContentPickerConstants.EXTRA_INITIAL_SELECTIONS, new ArrayList<>(initialSelections));
            return intent;
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        ContentPickerActivity contentPickerActivity = this;
        EdgeToEdge.enable$default(contentPickerActivity, null, null, 3, null);
        super.onMAMCreate(bundle);
        Companion companion = INSTANCE;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        ContentPickerActivityKt.initialConfiguration(getSelectionManager(), companion.parseInitialSelections(intent));
        ComponentActivityKt.setContent$default(contentPickerActivity, null, ComposableSingletons$ContentPickerActivityKt.INSTANCE.getLambda$239491204$content_picker_generalProdRelease(), 1, null);
    }
}
