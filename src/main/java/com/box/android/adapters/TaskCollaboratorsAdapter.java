package com.box.android.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.box.android.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.androidsdk.content.views.BoxAvatarView;
import com.box.androidsdk.content.views.DefaultAvatarController;
import com.box.boxandroidlibv2private.model.BoxIteratorTaskCollaborators;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import java.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public class TaskCollaboratorsAdapter extends RecyclerView.Adapter<CollaboratorViewHolder> {
    private static final int VIEW_TYPE_COMPLETION_RULE = 1;
    private DefaultAvatarController mAvatarController;
    private boolean mShouldShowCompletionRule;
    private BoxIteratorTaskCollaborators mTaskCollaborators = null;

    public TaskCollaboratorsAdapter(IUserContextManager iUserContextManager) {
        this.mAvatarController = iUserContextManager.getPreviewStorage().getAvatarController();
    }

    public void updateTaskCollaborators(BoxIteratorTaskCollaborators boxIteratorTaskCollaborators) {
        if (this.mTaskCollaborators != null) {
            DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new TasksCollaboratorsDiff(this.mTaskCollaborators, boxIteratorTaskCollaborators));
            this.mTaskCollaborators = boxIteratorTaskCollaborators;
            diffResultCalculateDiff.dispatchUpdatesTo(this);
        } else {
            this.mTaskCollaborators = boxIteratorTaskCollaborators;
            notifyDataSetChanged();
        }
    }

    public void setShouldShowCompletionRule(boolean z) {
        if (this.mShouldShowCompletionRule != z) {
            this.mShouldShowCompletionRule = z;
            notifyDataSetChanged();
        }
    }

    private String filterStatus(String str) {
        if (str.equalsIgnoreCase("COMPLETED")) {
            return CommonBoxUtil.LS(R.string.Completed);
        }
        if (str.equalsIgnoreCase("APPROVED")) {
            return CommonBoxUtil.LS(R.string.Approved);
        }
        if (str.equalsIgnoreCase("REJECTED")) {
            return CommonBoxUtil.LS(R.string.Rejected);
        }
        return "";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CollaboratorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        if (i == 1) {
            CollaboratorViewHolder collaboratorViewHolder = new CollaboratorViewHolder(layoutInflaterFrom.inflate(R.layout.task_any_description_list_item, viewGroup, false));
            collaboratorViewHolder.mIsDescription = true;
            return collaboratorViewHolder;
        }
        return new CollaboratorViewHolder(layoutInflaterFrom.inflate(R.layout.task_collaborator_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.mShouldShowCompletionRule && i == 0) {
            return 1;
        }
        return super.getItemViewType(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CollaboratorViewHolder collaboratorViewHolder, int i) {
        if (collaboratorViewHolder.mIsDescription) {
            return;
        }
        if (this.mShouldShowCompletionRule) {
            i--;
        }
        BoxTaskCollaborator boxTaskCollaborator = this.mTaskCollaborators.get(i);
        String userName = boxTaskCollaborator.getTarget().getUserName();
        if (SdkUtils.isBlank(userName)) {
            userName = CommonBoxUtil.LS(R.string.Prior_Collaborator);
        }
        collaboratorViewHolder.mNameView.setText(userName);
        String strFilterStatus = filterStatus(boxTaskCollaborator.getStatus());
        if (!strFilterStatus.isEmpty()) {
            collaboratorViewHolder.mStatusView.setText(strFilterStatus);
            collaboratorViewHolder.mStatusView.setVisibility(0);
        } else {
            collaboratorViewHolder.mStatusView.setVisibility(8);
        }
        collaboratorViewHolder.mAvatar.loadUser(boxTaskCollaborator.getTarget(), this.mAvatarController);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        BoxIteratorTaskCollaborators boxIteratorTaskCollaborators = this.mTaskCollaborators;
        if (boxIteratorTaskCollaborators == null) {
            return 0;
        }
        return this.mShouldShowCompletionRule ? boxIteratorTaskCollaborators.size() + 1 : boxIteratorTaskCollaborators.size();
    }

    private static class TasksCollaboratorsDiff extends DiffUtil.Callback {
        private BoxIteratorTaskCollaborators mNewTaskCollaborators;
        private BoxIteratorTaskCollaborators mOldTaskCollaborators;

        TasksCollaboratorsDiff(BoxIteratorTaskCollaborators boxIteratorTaskCollaborators, BoxIteratorTaskCollaborators boxIteratorTaskCollaborators2) {
            this.mOldTaskCollaborators = boxIteratorTaskCollaborators;
            this.mNewTaskCollaborators = boxIteratorTaskCollaborators2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            BoxIteratorTaskCollaborators boxIteratorTaskCollaborators = this.mOldTaskCollaborators;
            if (boxIteratorTaskCollaborators == null) {
                return 0;
            }
            return boxIteratorTaskCollaborators.getEntries().size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            BoxIteratorTaskCollaborators boxIteratorTaskCollaborators = this.mNewTaskCollaborators;
            if (boxIteratorTaskCollaborators == null) {
                return 0;
            }
            return boxIteratorTaskCollaborators.getEntries().size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i, int i2) {
            return this.mOldTaskCollaborators.getEntries().get(i).getUserId().equals(this.mNewTaskCollaborators.getEntries().get(i2).getUserId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            return Objects.equals(this.mOldTaskCollaborators.getEntries().get(i), this.mNewTaskCollaborators.getEntries().get(i2));
        }
    }

    static class CollaboratorViewHolder extends RecyclerView.ViewHolder {
        private BoxAvatarView mAvatar;
        private boolean mIsDescription;
        private TextView mNameView;
        private TextView mStatusView;

        CollaboratorViewHolder(View view) {
            super(view);
            this.mAvatar = (BoxAvatarView) view.findViewById(R.id.avatar);
            this.mNameView = (TextView) view.findViewById(R.id.name);
            this.mStatusView = (TextView) view.findViewById(R.id.status);
        }
    }
}
