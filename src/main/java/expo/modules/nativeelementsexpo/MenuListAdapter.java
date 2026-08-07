package expo.modules.nativeelementsexpo;

import android.R;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenu;
import com.facebook.react.modules.dialog.AlertFragment;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.intune.mam.client.widget.MAMTextView;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MenuListAdapter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\u0014\u0010'\u001a\u00020\u000e*\u00020\u001b2\u0006\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0011H\u0002J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lexpo/modules/nativeelementsexpo/MenuListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", AlertFragment.ARG_ITEMS, "", "Lexpo/modules/nativeelementsexpo/MenuListItem;", "verticalPaddingDp", "", "horizontalPaddingDp", "<init>", "(Landroid/content/Context;Ljava/util/List;FF)V", "", "updateItems", "", "newItems", "getCount", "", "getItem", ViewProps.POSITION, "getItemId", "", "getViewTypeCount", "getItemViewType", "isEnabled", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "buildActionView", "item", "Lexpo/modules/nativeelementsexpo/MenuListItem$Action;", "buildHeaderView", "Lexpo/modules/nativeelementsexpo/MenuListItem$SectionHeader;", "buildSubmenuView", "Lexpo/modules/nativeelementsexpo/MenuListItem$Submenu;", "buildDividerView", "setPaddingForItem", "isSectionHeader", "resolveTextColor", "dpToPx", "dp", "Companion", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MenuListAdapter extends BaseAdapter {
    private static final float ACTION_ROW_HEIGHT_DP = 56.0f;
    private static final int TYPE_ACTION = 0;
    private static final int TYPE_DIVIDER = 3;
    private static final int TYPE_HEADER = 1;
    private static final int TYPE_SUBMENU = 2;
    private final Context context;
    private final float horizontalPaddingDp;
    private final List<MenuListItem> items;
    private final float verticalPaddingDp;
    public static final int $stable = 8;
    private static final int MENU_DIVIDER_COLOR = -3488560;

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 4;
    }

    public /* synthetic */ MenuListAdapter(Context context, List list, float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, list, (i & 4) != 0 ? 8.0f : f, (i & 8) != 0 ? 16.0f : f2);
    }

    public MenuListAdapter(Context context, List<? extends MenuListItem> items, float f, float f2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(items, "items");
        this.context = context;
        this.verticalPaddingDp = f;
        this.horizontalPaddingDp = f2;
        this.items = CollectionsKt.toMutableList((Collection) items);
    }

    public final void updateItems(List<? extends MenuListItem> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.items.clear();
        this.items.addAll(newItems);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size();
    }

    @Override // android.widget.Adapter
    public MenuListItem getItem(int position) {
        return this.items.get(position);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        MenuListItem menuListItem = this.items.get(position);
        if (menuListItem instanceof MenuListItem.Action) {
            return 0;
        }
        if (menuListItem instanceof MenuListItem.SectionHeader) {
            return 1;
        }
        if (menuListItem instanceof MenuListItem.Submenu) {
            return 2;
        }
        if (menuListItem instanceof MenuListItem.Divider) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int position) {
        MenuListItem menuListItem = this.items.get(position);
        if (menuListItem instanceof MenuListItem.Action) {
            return !((MenuListItem.Action) menuListItem).getDisabled();
        }
        if (menuListItem instanceof MenuListItem.SectionHeader) {
            return false;
        }
        if (menuListItem instanceof MenuListItem.Submenu) {
            return !((MenuListItem.Submenu) menuListItem).getDisabled();
        }
        if (menuListItem instanceof MenuListItem.Divider) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewBuildDividerView;
        MenuListItem menuListItem = this.items.get(position);
        if (menuListItem instanceof MenuListItem.Action) {
            viewBuildDividerView = buildActionView((MenuListItem.Action) menuListItem);
        } else if (menuListItem instanceof MenuListItem.SectionHeader) {
            viewBuildDividerView = buildHeaderView((MenuListItem.SectionHeader) menuListItem);
        } else if (menuListItem instanceof MenuListItem.Submenu) {
            viewBuildDividerView = buildSubmenuView((MenuListItem.Submenu) menuListItem);
        } else {
            if (!(menuListItem instanceof MenuListItem.Divider)) {
                throw new NoWhenBranchMatchedException();
            }
            viewBuildDividerView = buildDividerView();
        }
        int iDpToPx = position == 0 ? dpToPx(this.verticalPaddingDp) : 0;
        int iDpToPx2 = position == this.items.size() + (-1) ? dpToPx(this.verticalPaddingDp) : 0;
        if (iDpToPx <= 0 && iDpToPx2 <= 0) {
            return viewBuildDividerView;
        }
        viewBuildDividerView.setPadding(viewBuildDividerView.getPaddingLeft(), Math.max(viewBuildDividerView.getPaddingTop(), iDpToPx), viewBuildDividerView.getPaddingRight(), Math.max(viewBuildDividerView.getPaddingBottom(), iDpToPx2));
        return viewBuildDividerView;
    }

    private final View buildActionView(MenuListItem.Action item) {
        int iIntValue;
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight(dpToPx(56.0f));
        LinearLayout linearLayout2 = linearLayout;
        setPaddingForItem(linearLayout2, false);
        int iIntValue2 = -7829368;
        if (item.getDisabled()) {
            Integer disabledTextColor = item.getDisabledTextColor();
            iIntValue = disabledTextColor != null ? disabledTextColor.intValue() : -7829368;
        } else {
            Integer textColor = item.getTextColor();
            iIntValue = textColor != null ? textColor.intValue() : resolveTextColor();
        }
        if (item.getDisabled()) {
            Integer disabledTextColor2 = item.getDisabledTextColor();
            if (disabledTextColor2 != null) {
                iIntValue2 = disabledTextColor2.intValue();
            }
        } else if (item.getDestructive()) {
            Integer destructiveColor = item.getDestructiveColor();
            iIntValue2 = destructiveColor != null ? destructiveColor.intValue() : SupportMenu.CATEGORY_MASK;
        } else {
            Integer textColor2 = item.getTextColor();
            iIntValue2 = textColor2 != null ? textColor2.intValue() : resolveTextColor();
        }
        if (item.getIcon() != null) {
            Drawable drawableMutate = DrawableCompat.wrap(item.getIcon()).mutate();
            Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
            DrawableCompat.setTint(drawableMutate, iIntValue2);
            ImageView imageView = new ImageView(this.context);
            imageView.setImageDrawable(drawableMutate);
            int iDpToPx = dpToPx(24.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iDpToPx, iDpToPx);
            layoutParams.setMarginEnd(dpToPx(12.0f));
            imageView.setLayoutParams(layoutParams);
            linearLayout.addView(imageView);
        }
        MAMTextView mAMTextView = new MAMTextView(this.context);
        mAMTextView.setText(item.getTitle());
        mAMTextView.setMaxLines(2);
        mAMTextView.setEllipsize(TextUtils.TruncateAt.END);
        mAMTextView.setTextSize(2, 16.0f);
        mAMTextView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        mAMTextView.setTextColor(iIntValue);
        if (item.getDisabled()) {
            mAMTextView.setAlpha(0.38f);
        }
        linearLayout.addView(mAMTextView);
        return linearLayout2;
    }

    private final View buildHeaderView(MenuListItem.SectionHeader item) {
        MAMTextView mAMTextView = new MAMTextView(this.context);
        mAMTextView.setText(item.getTitle());
        mAMTextView.setMaxLines(1);
        mAMTextView.setEllipsize(TextUtils.TruncateAt.END);
        mAMTextView.setTextSize(2, 12.0f);
        mAMTextView.setTypeface(Typeface.DEFAULT_BOLD);
        MAMTextView mAMTextView2 = mAMTextView;
        setPaddingForItem(mAMTextView2, true);
        Integer titleColor = item.getTitleColor();
        if (titleColor != null) {
            mAMTextView.setTextColor(titleColor.intValue());
            return mAMTextView2;
        }
        mAMTextView.setTextColor(-7829368);
        return mAMTextView2;
    }

    private final View buildSubmenuView(MenuListItem.Submenu item) {
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight(dpToPx(56.0f));
        LinearLayout linearLayout2 = linearLayout;
        setPaddingForItem(linearLayout2, false);
        MAMTextView mAMTextView = new MAMTextView(this.context);
        mAMTextView.setText(item.getTitle());
        mAMTextView.setMaxLines(1);
        mAMTextView.setEllipsize(TextUtils.TruncateAt.END);
        mAMTextView.setTextSize(2, 16.0f);
        mAMTextView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        mAMTextView.setTextColor(resolveTextColor());
        if (item.getDisabled()) {
            mAMTextView.setAlpha(0.38f);
        }
        linearLayout.addView(mAMTextView);
        MAMTextView mAMTextView2 = new MAMTextView(this.context);
        mAMTextView2.setText("›");
        mAMTextView2.setTextSize(2, 18.0f);
        mAMTextView2.setTextColor(-7829368);
        linearLayout.addView(mAMTextView2);
        return linearLayout2;
    }

    private final View buildDividerView() {
        View view = new View(this.context);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, dpToPx(1.0f)));
        view.setBackgroundColor(MENU_DIVIDER_COLOR);
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, dpToPx(this.verticalPaddingDp), 0, dpToPx(this.verticalPaddingDp));
        linearLayout.addView(view);
        return linearLayout;
    }

    private final void setPaddingForItem(View view, boolean z) {
        int iDpToPx = dpToPx(this.verticalPaddingDp);
        int iDpToPx2 = dpToPx(this.horizontalPaddingDp);
        if (!z) {
            iDpToPx = 0;
        }
        view.setPadding(iDpToPx2, iDpToPx, iDpToPx2, 0);
    }

    private final int resolveTextColor() {
        return MenuUtilsKt.resolveThemeColor(this.context, R.attr.textColorPrimary, -16777216);
    }

    private final int dpToPx(float dp) {
        return MenuUtilsKt.dpToPx(this.context, dp);
    }
}
