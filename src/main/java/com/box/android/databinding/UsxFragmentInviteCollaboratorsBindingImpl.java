package com.box.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import com.box.android.R;
import com.box.android.coreservices.models.BoxInvitee;
import com.box.android.usx.adapters.InviteeAdapter;
import com.box.android.usx.views.ChipCollaborationView;
import com.box.android.utilities.InviteCollaboratorsBindingAdapters;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.tokenautocomplete.CharacterTokenizer;
import com.tokenautocomplete.TokenCompleteTextView;

/* JADX INFO: loaded from: classes11.dex */
public class UsxFragmentInviteCollaboratorsBindingImpl extends UsxFragmentInviteCollaboratorsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final ConstraintLayout mboundView2;
    private final TextView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.invite_people_title, 7);
        sparseIntArray.put(R.id.invitation_layout_container, 8);
        sparseIntArray.put(R.id.invite_collaborator_role, 9);
        sparseIntArray.put(R.id.bottom_divider, 10);
        sparseIntArray.put(R.id.personal_message_text_view, 11);
    }

    public UsxFragmentInviteCollaboratorsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private UsxFragmentInviteCollaboratorsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Button) objArr[6], (View) objArr[10], (LinearLayout) objArr[8], (ChipCollaborationView) objArr[1], (TextView) objArr[9], (TextView) objArr[7], (EditText) objArr[5], (TextView) objArr[11], (TextView) objArr[3]);
        this.mDirtyFlags = -1L;
        this.addPersonalMessageButton.setTag(null);
        this.inviteCollaboratorAutocomplete.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[2];
        this.mboundView2 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        this.personalMessageEditText.setTag(null);
        this.roleName.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (16 == i) {
            setOnRoleClickedListener((View.OnClickListener) obj);
            return true;
        }
        if (29 == i) {
            setTokenizer((CharacterTokenizer) obj);
            return true;
        }
        if (28 == i) {
            setTokenListener((TokenCompleteTextView.TokenListener) obj);
            return true;
        }
        if (2 == i) {
            setAdapter((InviteeAdapter) obj);
            return true;
        }
        if (18 != i) {
            return false;
        }
        setRole((LiveData) obj);
        return true;
    }

    @Override // com.box.android.databinding.UsxFragmentInviteCollaboratorsBinding
    public void setOnRoleClickedListener(View.OnClickListener onClickListener) {
        this.mOnRoleClickedListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentInviteCollaboratorsBinding
    public void setTokenizer(CharacterTokenizer characterTokenizer) {
        this.mTokenizer = characterTokenizer;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(29);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentInviteCollaboratorsBinding
    public void setTokenListener(TokenCompleteTextView.TokenListener<BoxInvitee> tokenListener) {
        this.mTokenListener = tokenListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(28);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentInviteCollaboratorsBinding
    public void setAdapter(InviteeAdapter inviteeAdapter) {
        this.mAdapter = inviteeAdapter;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // com.box.android.databinding.UsxFragmentInviteCollaboratorsBinding
    public void setRole(LiveData<BoxCollaboration.Role> liveData) {
        updateLiveDataRegistration(0, liveData);
        this.mRole = liveData;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeRole((LiveData) obj, i2);
    }

    private boolean onChangeRole(LiveData<BoxCollaboration.Role> liveData, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mOnRoleClickedListener;
        CharacterTokenizer characterTokenizer = this.mTokenizer;
        TokenCompleteTextView.TokenListener<BoxInvitee> tokenListener = this.mTokenListener;
        InviteeAdapter inviteeAdapter = this.mAdapter;
        LiveData<BoxCollaboration.Role> liveData = this.mRole;
        long j2 = 34 & j;
        long j3 = 60 & j;
        long j4 = 33 & j;
        BoxCollaboration.Role value = (j4 == 0 || liveData == null) ? null : liveData.getValue();
        if ((j & 32) != 0) {
            InviteCollaboratorsBindingAdapters.onAddPersonalMessageBottom(this.addPersonalMessageButton, this.personalMessageEditText, this.personalMessageTextView, this.bottomDivider);
            InviteCollaboratorsBindingAdapters.onEmptyAndUnfocused(this.personalMessageEditText, this.personalMessageTextView, this.addPersonalMessageButton, this.bottomDivider);
        }
        if (j3 != 0) {
            InviteCollaboratorsBindingAdapters.setAdaptersAndListeners(this.inviteCollaboratorAutocomplete, inviteeAdapter, characterTokenizer, tokenListener);
        }
        if (j2 != 0) {
            this.mboundView2.setOnClickListener(onClickListener);
        }
        if (j4 != 0) {
            InviteCollaboratorsBindingAdapters.setRoleDescription(this.mboundView4, value);
            InviteCollaboratorsBindingAdapters.setRoleName(this.roleName, value);
        }
    }
}
