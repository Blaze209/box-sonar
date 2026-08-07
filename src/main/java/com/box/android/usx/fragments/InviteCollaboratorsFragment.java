package com.box.android.usx.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.coreservices.models.BoxInvitee;
import com.box.android.coreservices.models.BoxIteratorInvitees;
import com.box.android.databinding.UsxFragmentInviteCollaboratorsBinding;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.usx.adapters.InviteeAdapter;
import com.box.android.utilities.InviteCollaboratorsErrorMessageBuilder;
import com.box.android.vm.ActionbarTitleVM;
import com.box.android.vm.InviteCollaboratorsPresenterData;
import com.box.android.vm.InviteCollaboratorsShareVM;
import com.box.android.vm.PresenterData;
import com.box.android.vm.SelectRoleShareVM;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.tokenautocomplete.CharacterTokenizer;
import com.tokenautocomplete.TokenCompleteTextView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public class InviteCollaboratorsFragment extends BoxShareFragment implements TokenCompleteTextView.TokenListener<BoxInvitee> {
    public static final String EXTRA_COLLAB_SELECTED_ROLE = "collabSelectedRole";
    public static final String EXTRA_USE_CONTACTS_PROVIDER = "InviteCollaboratorsFragment.ExtraUseContactsProvider";
    private static final Integer MY_PERMISSIONS_REQUEST_READ_CONTACTS = 32;
    public static final String TAG = InviteCollaboratorsFragment.class.getName();
    private UsxFragmentInviteCollaboratorsBinding binding;
    private String mFilterTerm;
    private InviteCollaboratorsShareVM mInviteCollaboratorsShareVM;
    private ClickListener mListener;
    private SelectRoleShareVM mSelectRoleShareVM;
    private String mLastFilterConstraint = "";
    private Snackbar snackbar = null;
    private Observer<PresenterData<BoxCollaborationItem>> onRoleItemChange = new Observer() { // from class: com.box.android.usx.fragments.InviteCollaboratorsFragment$$ExternalSyntheticLambda2
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$0((PresenterData) obj);
        }
    };
    private Observer<PresenterData<BoxIteratorInvitees>> onInviteesChanged = new Observer() { // from class: com.box.android.usx.fragments.InviteCollaboratorsFragment$$ExternalSyntheticLambda3
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$1((PresenterData) obj);
        }
    };
    private Observer<InviteCollaboratorsPresenterData> onInviteCollabs = new Observer() { // from class: com.box.android.usx.fragments.InviteCollaboratorsFragment$$ExternalSyntheticLambda4
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            this.f$0.lambda$new$2((InviteCollaboratorsPresenterData) obj);
        }
    };

    public interface ClickListener {
        void editAccessClicked();
    }

    @Override // com.tokenautocomplete.TokenCompleteTextView.TokenListener
    public void onTokenIgnored(BoxInvitee boxInvitee) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        UsxFragmentInviteCollaboratorsBinding usxFragmentInviteCollaboratorsBinding = (UsxFragmentInviteCollaboratorsBinding) DataBindingUtil.inflate(layoutInflater, R.layout.usx_fragment_invite_collaborators, viewGroup, false);
        this.binding = usxFragmentInviteCollaboratorsBinding;
        return usxFragmentInviteCollaboratorsBinding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(PresenterData presenterData) {
        if (presenterData.isHandled()) {
            return;
        }
        dismissSpinner();
        if (presenterData.isSuccess() && getCollaborationItem() != null) {
            if (getCollaborationItem().getPermissions().contains(BoxItem.Permission.CAN_INVITE_COLLABORATOR)) {
                BoxCollaborationItem boxCollaborationItem = (BoxCollaborationItem) presenterData.getData();
                this.mSelectRoleShareVM.setRoles(boxCollaborationItem.getAllowedInviteeRoles());
                BoxCollaboration.Role value = this.mSelectRoleShareVM.getSelectedRole().getValue();
                if (value != null) {
                    setSelectedRole(value);
                } else {
                    List<BoxCollaboration.Role> roles = this.mSelectRoleShareVM.getRoles();
                    setSelectedRole((roles == null || roles.size() <= 0) ? null : getBestDefaultRole(boxCollaborationItem.getDefaultInviteeRole(), roles));
                }
                this.mInviteCollaboratorsShareVM.setShareItem(boxCollaborationItem);
                return;
            }
            showNoPermissionToast();
            getActivity().finish();
            return;
        }
        BoxLogUtils.e(InviteCollaboratorsFragment.class.getName(), "Fetch roles request failed", presenterData.getException());
        showToast(getString(presenterData.getStrCode()));
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(PresenterData presenterData) {
        if (presenterData.isHandled()) {
            return;
        }
        if (presenterData.isSuccess()) {
            this.binding.getAdapter().setInvitees((BoxIteratorInvitees) presenterData.getData());
        } else {
            BoxLogUtils.e(InviteCollaboratorsFragment.class.getName(), "get invitees request failed", presenterData.getException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(InviteCollaboratorsPresenterData inviteCollaboratorsPresenterData) {
        String string;
        if (inviteCollaboratorsPresenterData.isHandled()) {
            return;
        }
        dismissSpinner();
        if (!inviteCollaboratorsPresenterData.isStrCodeSet()) {
            string = "";
        } else if (inviteCollaboratorsPresenterData.isNonNullData()) {
            string = getString(inviteCollaboratorsPresenterData.getStrCode(), inviteCollaboratorsPresenterData.getData());
        } else {
            string = getString(inviteCollaboratorsPresenterData.getStrCode());
        }
        int i = AnonymousClass2.$SwitchMap$com$box$android$vm$InviteCollaboratorsPresenterData$MessageUIType[inviteCollaboratorsPresenterData.getUIType().ordinal()];
        if (i == 1) {
            showDialog(inviteCollaboratorsPresenterData.getDataMap());
        } else if (i == 2) {
            showSnackBar(string);
        } else {
            showToast(string);
            getActivity().finish();
        }
        this.mInviteCollaboratorsShareVM.setInvitationSucceded(inviteCollaboratorsPresenterData.isSuccess());
    }

    /* JADX INFO: renamed from: com.box.android.usx.fragments.InviteCollaboratorsFragment$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$vm$InviteCollaboratorsPresenterData$MessageUIType;

        static {
            int[] iArr = new int[InviteCollaboratorsPresenterData.MessageUIType.values().length];
            $SwitchMap$com$box$android$vm$InviteCollaboratorsPresenterData$MessageUIType = iArr;
            try {
                iArr[InviteCollaboratorsPresenterData.MessageUIType.ALERT_DIALOG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$vm$InviteCollaboratorsPresenterData$MessageUIType[InviteCollaboratorsPresenterData.MessageUIType.SNACKBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$android$vm$InviteCollaboratorsPresenterData$MessageUIType[InviteCollaboratorsPresenterData.MessageUIType.TOAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment
    protected void setTitles() {
        ActionbarTitleVM actionbarTitleVM = (ActionbarTitleVM) new ViewModelProvider(getActivity()).get(ActionbarTitleVM.class);
        actionbarTitleVM.setTitle(getString(R.string.box_sharesdk_invite_collaborators_activity_title));
        actionbarTitleVM.setSubtitle(null);
    }

    public void showSnackBar(String str) {
        this.snackbar = BoxPresentationUtils.displaySnackBar(requireContext(), getView(), str, 0, (View.OnClickListener) null);
    }

    protected void showDialog(Map<Integer, List<String>> map) {
        SpannableStringBuilder spannableStringBuilderBuildDialogMessage = InviteCollaboratorsErrorMessageBuilder.buildDialogMessage(requireContext(), map, getCollaborationItem() instanceof BoxFolder);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.alert_dialog_scrollable_text, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.message_view);
        textView.setText(spannableStringBuilderBuildDialogMessage);
        textView.setMovementMethod(new ScrollingMovementMethod());
        new MaterialAlertDialogBuilder(getContext()).setTitle(R.string.invitations_could_not_be_sent).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null).setView(viewInflate).show();
    }

    private BoxCollaboration.Role getBestDefaultRole(String str, List<BoxCollaboration.Role> list) {
        try {
            return BoxCollaboration.Role.fromString(str);
        } catch (IllegalArgumentException e) {
            BoxLogUtils.e("invalid role name " + str, e);
            return list.get(0);
        }
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment
    public Class<InviteCollaboratorsShareVM> getVMClass() {
        return InviteCollaboratorsShareVM.class;
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (this.mSelectRoleShareVM.getSelectedRole() != null && this.mSelectRoleShareVM.getSelectedRole().getValue() != null) {
            bundle.putString(EXTRA_COLLAB_SELECTED_ROLE, this.mSelectRoleShareVM.getSelectedRole().getValue().toString());
        }
        this.mInviteCollaboratorsShareVM.setPendingInviteText(this.binding.inviteCollaboratorAutocomplete.pendingInviteText());
        super.onSaveInstanceState(bundle);
    }

    private InviteeAdapter createInviteeAdapter(Context context) {
        return new InviteeAdapter(context) { // from class: com.box.android.usx.fragments.InviteCollaboratorsFragment.1
            @Override // com.box.android.usx.adapters.InviteeAdapter
            protected boolean isReadContactsPermissionAvailable() {
                return InviteCollaboratorsFragment.this.getArguments().getBoolean(InviteCollaboratorsFragment.EXTRA_USE_CONTACTS_PROVIDER, true) && super.isReadContactsPermissionAvailable();
            }
        };
    }

    private InviteeAdapter.InviteeAdapterListener createInviteeAdapterListener() {
        return new InviteeAdapter.InviteeAdapterListener() { // from class: com.box.android.usx.fragments.InviteCollaboratorsFragment$$ExternalSyntheticLambda0
            @Override // com.box.android.usx.adapters.InviteeAdapter.InviteeAdapterListener
            public final void onFilterTermChanged(CharSequence charSequence) {
                this.f$0.lambda$createInviteeAdapterListener$3(charSequence);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createInviteeAdapterListener$3(CharSequence charSequence) {
        String string = charSequence.toString();
        if (!string.isEmpty() && !string.equals(this.mLastFilterConstraint)) {
            dismissSnackbar();
        }
        this.mLastFilterConstraint = string;
        if (charSequence.length() >= 3) {
            String string2 = charSequence.subSequence(0, 3).toString();
            if (string2.equals(this.mFilterTerm)) {
                return;
            }
            this.mFilterTerm = string2;
            fetchInvitees();
        }
    }

    private void dismissSnackbar() {
        Snackbar snackbar = this.snackbar;
        if (snackbar != null) {
            snackbar.dismiss();
        }
    }

    @Override // com.box.android.usx.fragments.BoxShareFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        String string;
        super.onActivityCreated(bundle);
        this.binding.setLifecycleOwner(getViewLifecycleOwner());
        setTitles();
        this.mSelectRoleShareVM = (SelectRoleShareVM) new ViewModelProvider(getActivity()).get(SelectRoleShareVM.class);
        InviteeAdapter inviteeAdapterCreateInviteeAdapter = createInviteeAdapter(getActivity());
        CharacterTokenizer characterTokenizer = new CharacterTokenizer(Collections.singletonList(Character.valueOf(AbstractJsonLexerKt.COMMA)), ",");
        inviteeAdapterCreateInviteeAdapter.setInviteeAdapterListener(createInviteeAdapterListener());
        this.binding.setAdapter(inviteeAdapterCreateInviteeAdapter);
        this.binding.setTokenizer(characterTokenizer);
        this.binding.setOnRoleClickedListener(new View.OnClickListener() { // from class: com.box.android.usx.fragments.InviteCollaboratorsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onActivityCreated$4(view);
            }
        });
        this.binding.setTokenListener(this);
        this.binding.inviteCollaboratorAutocomplete.requestFocus();
        this.mFilterTerm = "";
        InviteCollaboratorsShareVM inviteCollaboratorsShareVM = (InviteCollaboratorsShareVM) new ViewModelProvider(getActivity(), ((BoxShareFragment.ShareVMFactoryProvider) getActivity()).getShareVMFactory()).get(InviteCollaboratorsShareVM.class);
        this.mInviteCollaboratorsShareVM = inviteCollaboratorsShareVM;
        inviteCollaboratorsShareVM.setInvitationSucceded(true);
        this.mInviteCollaboratorsShareVM.getRoleItem().observe(getViewLifecycleOwner(), this.onRoleItemChange);
        this.mInviteCollaboratorsShareVM.getInvitees().observe(getViewLifecycleOwner(), this.onInviteesChanged);
        this.mInviteCollaboratorsShareVM.getInviteCollabs().observe(getViewLifecycleOwner(), this.onInviteCollabs);
        if (this.mSelectRoleShareVM.getSelectedRole() == null && bundle != null && (string = bundle.getString(EXTRA_COLLAB_SELECTED_ROLE)) != null) {
            setSelectedRole(BoxCollaboration.Role.fromString(string));
        }
        if (getCollaborationItem() != null && getCollaborationItem().getAllowedInviteeRoles() != null) {
            if (getCollaborationItem().getPermissions().contains(BoxItem.Permission.CAN_INVITE_COLLABORATOR)) {
                this.mSelectRoleShareVM.setRoles(getCollaborationItem().getAllowedInviteeRoles());
                if (this.mSelectRoleShareVM.getSelectedRole().getValue() == null) {
                    setSelectedRole(getBestDefaultRole(getCollaborationItem().getDefaultInviteeRole(), this.mSelectRoleShareVM.getRoles()));
                }
            } else {
                showNoPermissionToast();
                getActivity().finish();
            }
        } else {
            fetchRoles();
        }
        fetchInvitees();
        if (getArguments().getBoolean(EXTRA_USE_CONTACTS_PROVIDER) && !this.mInviteCollaboratorsShareVM.isContactsPermissionRequested()) {
            requestPermissionsIfNecessary();
        }
        Iterator<BoxInvitee> it = this.mInviteCollaboratorsShareVM.getInviteesList().iterator();
        while (it.hasNext()) {
            this.binding.inviteCollaboratorAutocomplete.addObjectSync(it.next());
        }
        this.binding.inviteCollaboratorAutocomplete.getText().append((CharSequence) this.mInviteCollaboratorsShareVM.getPendingInviteText());
        this.binding.setRole(this.mSelectRoleShareVM.getSelectedRole());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityCreated$4(View view) {
        this.mListener.editAccessClicked();
    }

    private void requestPermissionsIfNecessary() {
        if (ContextCompat.checkSelfPermission(getActivity(), "android.permission.READ_CONTACTS") != 0) {
            this.mInviteCollaboratorsShareVM.setContactsPermissionRequested(true);
            ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.READ_CONTACTS"}, MY_PERMISSIONS_REQUEST_READ_CONTACTS.intValue());
        }
    }

    private void fetchRoles() {
        if (getCollaborationItem() == null || SdkUtils.isBlank(getCollaborationItem().getUserId())) {
            return;
        }
        showSpinner(R.string.box_sharesdk_fetching_roles);
        this.mInviteCollaboratorsShareVM.fetchRoles(getCollaborationItem());
    }

    private void fetchInvitees() {
        if (getCollaborationItem() instanceof BoxFolder) {
            this.mInviteCollaboratorsShareVM.fetchInvitees(getCollaborationItem(), this.mFilterTerm);
        }
    }

    public void addCollaborations() {
        if (this.mSelectRoleShareVM.getSelectedRole() != null) {
            List<BoxInvitee> inviteesList = this.mInviteCollaboratorsShareVM.getInviteesList();
            String[] strArr = new String[inviteesList.size()];
            Iterator<BoxInvitee> it = inviteesList.iterator();
            int i = 0;
            while (it.hasNext()) {
                strArr[i] = it.next().getEmail();
                logCollaboratorAdded(this.mSelectRoleShareVM.getSelectedRole().getValue());
                i++;
            }
            showSpinner(R.string.box_sharesdk_adding_collaborators);
            this.mInviteCollaboratorsShareVM.inviteCollabs(getCollaborationItem(), this.mSelectRoleShareVM.getSelectedRole().getValue(), strArr);
            return;
        }
        showToast(R.string.box_sharesdk_unable_to_invite);
        getActivity().finish();
    }

    private void logCollaboratorAdded(BoxCollaboration.Role role) {
        BoxAmplitudeAnalytics.ShareEventPropertyBuilder shareEventPropertyBuilderCreateShareEventBuilder = BoxAmplitudeAnalytics.createShareEventBuilder();
        shareEventPropertyBuilderCreateShareEventBuilder.setAccessType(role);
        shareEventPropertyBuilderCreateShareEventBuilder.logEvent(BoxAnalyticsParams.EVENT_SHARE_COLLABORATOR_ADDED);
    }

    private void showNoPermissionToast() {
        showToast(R.string.box_sharesdk_insufficient_permissions);
    }

    private void setSelectedRole(BoxCollaboration.Role role) {
        if (role == null) {
            showNoPermissionToast();
            getActivity().finish();
        }
        this.mSelectRoleShareVM.setSelectedRole(role);
    }

    protected BoxCollaborationItem getCollaborationItem() {
        return (BoxCollaborationItem) this.mInviteCollaboratorsShareVM.getShareItem();
    }

    public static InviteCollaboratorsFragment newInstance(BoxCollaborationItem boxCollaborationItem, ClickListener clickListener) {
        return newInstance(boxCollaborationItem, clickListener, true);
    }

    public static InviteCollaboratorsFragment newInstance(BoxCollaborationItem boxCollaborationItem, ClickListener clickListener, boolean z) {
        Bundle bundle = BoxShareFragment.getBundle(boxCollaborationItem);
        InviteCollaboratorsFragment inviteCollaboratorsFragment = new InviteCollaboratorsFragment();
        bundle.putBoolean(EXTRA_USE_CONTACTS_PROVIDER, z);
        inviteCollaboratorsFragment.setArguments(bundle);
        inviteCollaboratorsFragment.mListener = clickListener;
        return inviteCollaboratorsFragment;
    }

    @Override // com.tokenautocomplete.TokenCompleteTextView.TokenListener
    public void onTokenAdded(BoxInvitee boxInvitee) {
        this.mInviteCollaboratorsShareVM.setInviteesList(this.binding.inviteCollaboratorAutocomplete.getObjects());
        this.mSelectRoleShareVM.setSendInvitationEnabled(true);
    }

    @Override // com.tokenautocomplete.TokenCompleteTextView.TokenListener
    public void onTokenRemoved(BoxInvitee boxInvitee) {
        this.mInviteCollaboratorsShareVM.setInviteesList(this.binding.inviteCollaboratorAutocomplete.getObjects());
        if (this.mInviteCollaboratorsShareVM.getInviteesList().isEmpty()) {
            this.mSelectRoleShareVM.setSendInvitationEnabled(false);
        }
    }
}
