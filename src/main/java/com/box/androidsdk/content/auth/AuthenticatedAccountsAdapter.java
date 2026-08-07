package com.box.androidsdk.content.auth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.box.android.dataaccess.content.R;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.androidsdk.content.views.BoxAvatarView;
import com.box.androidsdk.content.views.OfflineAvatarController;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class AuthenticatedAccountsAdapter extends ArrayAdapter<BoxAuthentication.BoxAuthenticationInfo> {
    private static final int CREATE_NEW_TYPE_ID = 1;
    private OfflineAvatarController mAvatarController;

    public static class DifferentAuthenticationInfo extends BoxAuthentication.BoxAuthenticationInfo {
    }

    public static class ViewHolder {
        public TextView descriptionView;
        public BoxAvatarView initialsView;
        public TextView titleView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public AuthenticatedAccountsAdapter(Context context, int i, List<BoxAuthentication.BoxAuthenticationInfo> list) {
        super(context, i, list);
        this.mAvatarController = new OfflineAvatarController(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public BoxAuthentication.BoxAuthenticationInfo getItem(int i) {
        if (i == getCount() - 1) {
            return new DifferentAuthenticationInfo();
        }
        return (BoxAuthentication.BoxAuthenticationInfo) super.getItem(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (i == getCount() - 1) {
            return 1;
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) == 1) {
            return LayoutInflater.from(getContext()).inflate(R.layout.boxsdk_list_item_new_account, viewGroup, false);
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.boxsdk_list_item_account, viewGroup, false);
        ViewHolder viewHolder = (ViewHolder) viewInflate.getTag();
        if (viewHolder == null) {
            viewHolder = new ViewHolder();
            viewHolder.titleView = (TextView) viewInflate.findViewById(R.id.box_account_title);
            viewHolder.descriptionView = (TextView) viewInflate.findViewById(R.id.box_account_description);
            viewHolder.initialsView = (BoxAvatarView) viewInflate.findViewById(R.id.box_account_initials);
            viewInflate.setTag(viewHolder);
        }
        BoxAuthentication.BoxAuthenticationInfo item = getItem(i);
        if (item == null || item.getUser() == null) {
            if (item != null) {
                BoxLogUtils.e("invalid account info", item.toJson());
            }
            return viewInflate;
        }
        boolean zIsEmptyString = SdkUtils.isEmptyString(item.getUser().getUserName());
        BoxUser user = item.getUser();
        viewHolder.titleView.setText(!zIsEmptyString ? user.getUserName() : user.getLogin());
        if (!zIsEmptyString) {
            viewHolder.descriptionView.setText(item.getUser().getLogin());
        }
        viewHolder.initialsView.loadUser(item.getUser(), this.mAvatarController);
        return viewInflate;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return super.getCount() + 1;
    }
}
