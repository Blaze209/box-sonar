package com.box.android.usx.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.databinding.DataBindingUtil;
import com.box.android.R;
import com.box.android.databinding.UsxListItemCollaborationBinding;
import com.box.android.utilities.CollaborationUtils;
import com.box.android.vm.BaseShareVM;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborator;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxUser;
import com.eclipsesource.json.JsonObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class CollaboratorsAdapter extends BaseAdapter {
    private final BoxCollaborator mAnotherPersonCollaborator;
    private BaseShareVM mBaseShareVM;
    private Context mContext;
    private ArrayList<BoxCollaboration> mItems = new ArrayList<>();
    String userId;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public CollaboratorsAdapter(Context context, BaseShareVM baseShareVM) {
        this.mContext = context;
        this.mBaseShareVM = baseShareVM;
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("name", this.mContext.getString(R.string.box_sharesdk_another_person));
        this.mAnotherPersonCollaborator = new BoxUser(jsonObject);
    }

    public List<BoxCollaboration> getBoxCollaborationList() {
        return this.mItems;
    }

    public BoxItem getShareItem() {
        return this.mBaseShareVM.getShareItem();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mItems.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mItems.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (getShareItem().getPermissions().contains(BoxItem.Permission.CAN_INVITE_COLLABORATOR)) {
            return true;
        }
        BoxCollaboration boxCollaboration = this.mItems.get(i);
        return (boxCollaboration == null || boxCollaboration.getAccessibleBy() == null || !boxCollaboration.getAccessibleBy().getUserId().equals(this.mBaseShareVM.getUserId())) ? false : true;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        UsxListItemCollaborationBinding usxListItemCollaborationBinding;
        String inviteEmail;
        String collaborationStatusText;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.usx_list_item_collaboration, viewGroup, false);
            usxListItemCollaborationBinding = (UsxListItemCollaborationBinding) DataBindingUtil.bind(view);
            view.setTag(usxListItemCollaborationBinding);
        } else {
            usxListItemCollaborationBinding = (UsxListItemCollaborationBinding) view.getTag();
        }
        BoxCollaboration boxCollaboration = this.mItems.get(i);
        if (boxCollaboration != null) {
            BoxCollaborator accessibleBy = boxCollaboration.getAccessibleBy();
            if (accessibleBy == null) {
                inviteEmail = boxCollaboration.getInviteEmail();
                JsonObject jsonObject = new JsonObject();
                jsonObject.add("name", inviteEmail);
                BoxUser boxUser = new BoxUser(jsonObject);
                if (inviteEmail != null && !inviteEmail.isEmpty()) {
                    usxListItemCollaborationBinding.collaboratorInitials.loadUser(boxUser, (Serializable) this.mBaseShareVM.getAvatarController());
                } else {
                    inviteEmail = this.mContext.getString(R.string.box_sharesdk_another_person);
                    usxListItemCollaborationBinding.collaboratorInitials.loadUser(this.mAnotherPersonCollaborator, (Serializable) this.mBaseShareVM.getAvatarController());
                }
            } else {
                String userName = accessibleBy.getUserName();
                usxListItemCollaborationBinding.collaboratorInitials.loadUser(accessibleBy, (Serializable) this.mBaseShareVM.getAvatarController());
                inviteEmail = userName;
            }
            if (boxCollaboration.getStatus() == BoxCollaboration.Status.ACCEPTED) {
                collaborationStatusText = CollaborationUtils.getRoleName(this.mContext, boxCollaboration.getRole());
            } else {
                collaborationStatusText = CollaborationUtils.getCollaborationStatusText(this.mContext, boxCollaboration.getStatus());
            }
            usxListItemCollaborationBinding.collaboratorRoleTitle.setText(inviteEmail);
            usxListItemCollaborationBinding.collaboratorRole.setText(collaborationStatusText);
        }
        if (isEnabled(i)) {
            view.setAlpha(1.0f);
            return view;
        }
        view.setAlpha(0.25f);
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void setItems(BoxIteratorCollaborations boxIteratorCollaborations) {
        this.mItems.clear();
        for (int i = 0; i < boxIteratorCollaborations.size(); i++) {
            this.mItems.add((BoxCollaboration) boxIteratorCollaborations.get(i));
        }
        notifyDataSetChanged();
    }

    public synchronized void setItems(List<BoxCollaboration> list) {
        this.mItems.clear();
        this.mItems.addAll(list);
        notifyDataSetChanged();
    }

    public synchronized void update(BoxCollaboration boxCollaboration) {
        Integer position = getPosition(boxCollaboration.getUserId());
        if (position != null) {
            this.mItems.set(position.intValue(), boxCollaboration);
        }
        notifyDataSetChanged();
    }

    public synchronized void delete(String str) {
        Integer position = getPosition(str);
        if (position != null) {
            this.mItems.remove(position.intValue());
        }
        notifyDataSetChanged();
    }

    public Integer getPosition(String str) {
        for (int i = 0; i < this.mItems.size(); i++) {
            if (this.mItems.get(i).getUserId().equals(str)) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }
}
