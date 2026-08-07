package com.box.android.utilities;

import com.box.android.R;
import com.box.android.coreservices.models.BoxFeatures;
import com.box.android.coreservices.models.BoxIteratorInvitees;
import com.box.android.vm.InviteCollaboratorsPresenterData;
import com.box.android.vm.PresenterData;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.models.BoxVoid;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestItem;
import com.box.androidsdk.content.requests.BoxRequestUpdateSharedItem;
import com.box.androidsdk.content.requests.BoxRequestsShare;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.requests.BoxResponseBatch;
import com.box.androidsdk.content.utils.SdkUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public class ShareSDKTransformer {
    private static char divider = ' ';
    private static HashSet<Integer> failureCodes = getFailureCodes();

    public static int getShieldErrorPrimaryStringRes(int i, boolean z) {
        if (i == 1) {
            return z ? R.string.box_sharesdk_could_not_be_invited_to_folder : R.string.box_sharesdk_could_not_be_invited_to_file;
        }
        return z ? R.string.box_sharesdk_people_could_not_be_invited_to_folder : R.string.box_sharesdk_people_could_not_be_invited_to_file;
    }

    public PresenterData<BoxCollaborationItem> getFetchRolesItemPresenterData(BoxResponse<BoxCollaborationItem> boxResponse) {
        PresenterData<BoxCollaborationItem> presenterData = new PresenterData<>();
        if (boxResponse.isSuccess()) {
            presenterData.success((BoxCollaborationItem) boxResponse.getResult());
            return presenterData;
        }
        presenterData.failure(R.string.box_sharesdk_network_error, boxResponse.getException());
        return presenterData;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003b  */
    public PresenterData<BoxIteratorInvitees> getInviteesPresenterData(BoxResponse<BoxIteratorInvitees> boxResponse) {
        int i;
        PresenterData<BoxIteratorInvitees> presenterData = new PresenterData<>();
        if (boxResponse.isSuccess()) {
            presenterData.success((BoxIteratorInvitees) boxResponse.getResult());
            return presenterData;
        }
        if (boxResponse.getException() instanceof BoxException) {
            BoxException boxException = (BoxException) boxResponse.getException();
            if (boxException.getResponseCode() == 403) {
                i = R.string.box_sharesdk_insufficient_permissions;
            } else if (boxException.getErrorType() == BoxException.ErrorType.NETWORK_ERROR) {
                i = R.string.box_sharesdk_network_error;
            } else {
                i = R.string.box_sharesdk_generic_error;
            }
        } else {
            i = R.string.box_sharesdk_generic_error;
        }
        presenterData.failure(i, boxResponse.getException());
        return presenterData;
    }

    public InviteCollaboratorsPresenterData getInviteCollabsPresenterDataFromBoxResponse(BoxResponse<BoxResponseBatch> boxResponse) {
        return getInviteCollabsPresenterData((BoxResponseBatch) boxResponse.getResult());
    }

    private InviteCollaboratorsPresenterData getInviteCollabsPresenterData(BoxResponseBatch boxResponseBatch) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z = true;
        int i = 0;
        String login = "";
        for (BoxResponse boxResponse : boxResponseBatch.getResponses()) {
            if (!boxResponse.isSuccess()) {
                if (isKnownFailure(boxResponse, failureCodes)) {
                    String code = ((BoxException) boxResponse.getException()).getAsBoxError().getCode();
                    BoxUser boxUser = (BoxUser) ((BoxRequestsShare.AddCollaboration) boxResponse.getRequest()).getAccessibleBy();
                    login = boxUser == null ? "" : boxUser.getLogin();
                    if (isAlreadyAddedFailure(code)) {
                        i++;
                    } else if (isForbiddenByShieldPolicyFailure(code)) {
                        arrayList2.add(login);
                    } else {
                        arrayList.add(login);
                    }
                }
                z = false;
            }
        }
        if (z) {
            return getPresenterDataForSuccessfulRequest(boxResponseBatch);
        }
        HashMap map = new HashMap();
        if (!arrayList.isEmpty()) {
            map.put(Integer.valueOf(R.string.box_sharesdk_unable_to_invite), arrayList);
        }
        if (!arrayList2.isEmpty()) {
            map.put(Integer.valueOf(R.string.box_share_forbidden_due_to_shield), arrayList2);
        }
        return getPresenterDataForFailedRequest(map, login, i);
    }

    InviteCollaboratorsPresenterData getPresenterDataForSuccessfulRequest(BoxResponseBatch boxResponseBatch) {
        if (boxResponseBatch.getResponses().size() == 1) {
            BoxCollaboration boxCollaboration = (BoxCollaboration) boxResponseBatch.getResponses().get(0).getResult();
            if (boxCollaboration.getAccessibleBy() == null) {
                return new InviteCollaboratorsPresenterData(null, R.string.box_sharesdk_a_collaborator_invited);
            }
            return new InviteCollaboratorsPresenterData(((BoxUser) boxCollaboration.getAccessibleBy()).getLogin(), R.string.box_sharesdk_collaborator_invited);
        }
        return new InviteCollaboratorsPresenterData(null, R.string.box_sharesdk_collaborators_invited);
    }

    InviteCollaboratorsPresenterData getPresenterDataForFailedRequest(Map<Integer, List<String>> map, String str, int i) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            if (i == 1) {
                return new InviteCollaboratorsPresenterData(InviteCollaboratorsPresenterData.MessageUIType.TOAST, str, R.string.box_sharesdk_has_already_been_invited, false);
            }
            if (i > 1) {
                return new InviteCollaboratorsPresenterData(InviteCollaboratorsPresenterData.MessageUIType.TOAST, String.valueOf(i), R.string.box_sharesdk_num_has_already_been_invited, false);
            }
            return new InviteCollaboratorsPresenterData(InviteCollaboratorsPresenterData.MessageUIType.TOAST, null, R.string.box_sharesdk_unable_to_invite, true);
        }
        Set<Map.Entry<Integer, List<String>>> setEntrySet = map.entrySet();
        Map.Entry<Integer, List<String>> next = setEntrySet.iterator().next();
        if (setEntrySet.size() == 1 && next.getKey().intValue() != R.string.box_share_forbidden_due_to_shield) {
            List<String> value = next.getValue();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < value.size(); i2++) {
                sb.append(value.get(i2));
                if (i2 < value.size() - 1) {
                    sb.append(divider);
                }
            }
            return new InviteCollaboratorsPresenterData(InviteCollaboratorsPresenterData.MessageUIType.SNACKBAR, sb.toString(), R.string.box_sharesdk_following_collaborators_error, true);
        }
        return new InviteCollaboratorsPresenterData(InviteCollaboratorsPresenterData.MessageUIType.ALERT_DIALOG, true, map);
    }

    private boolean isAlreadyAddedFailure(String str) {
        return !SdkUtils.isBlank(str) && str.equals("user_already_collaborator");
    }

    private boolean isForbiddenByShieldPolicyFailure(String str) {
        return !SdkUtils.isBlank(str) && str.equals(BoxRequestsShare.AddCollaboration.ERROR_CODE_FORBIDDEN_BY_POLICY);
    }

    private boolean isKnownFailure(BoxResponse<BoxCollaboration> boxResponse, HashSet<Integer> hashSet) {
        return (boxResponse.getException() instanceof BoxException) && hashSet.contains(Integer.valueOf(((BoxException) boxResponse.getException()).getResponseCode()));
    }

    private static HashSet<Integer> getFailureCodes() {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(400);
        hashSet.add(403);
        return hashSet;
    }

    public PresenterData<BoxItem> getSharedLinkItemPresenterData(BoxResponse<BoxItem> boxResponse, BoxItem boxItem) {
        PresenterData<BoxItem> presenterData = new PresenterData<>();
        if (boxResponse.isSuccess()) {
            if (boxResponse.getRequest() instanceof BoxRequestItem) {
                presenterData.success((BoxItem) boxResponse.getResult());
            }
            return presenterData;
        }
        if (boxResponse.getException() instanceof BoxException) {
            BoxException boxException = (BoxException) boxResponse.getException();
            int responseCode = boxException.getResponseCode();
            if (responseCode == 304) {
                presenterData.setException(boxResponse.getException());
            } else if (responseCode == 403) {
                presenterData.failure(R.string.box_sharesdk_insufficient_permissions, boxException);
                return presenterData;
            }
        }
        if ((boxResponse.getRequest() instanceof BoxRequestItem) && boxItem.getUserId().equals(((BoxRequestItem) boxResponse.getRequest()).getId())) {
            if (boxResponse.getRequest() instanceof BoxRequestUpdateSharedItem) {
                presenterData.failure(R.string.box_sharesdk_unable_to_modify_toast, boxResponse.getException());
                return presenterData;
            }
            presenterData.failure(R.string.box_sharesdk_problem_accessing_this_shared_link, boxResponse.getException());
            return presenterData;
        }
        presenterData.setException(boxResponse.getException());
        return presenterData;
    }

    public PresenterData<BoxRequest> getDeleteCollaborationPresenterData(BoxResponse<BoxVoid> boxResponse) {
        PresenterData<BoxRequest> presenterData = new PresenterData<>();
        if (boxResponse.isSuccess()) {
            presenterData.success(boxResponse.getRequest());
            return presenterData;
        }
        presenterData.failure(R.string.box_sharesdk_network_error, boxResponse.getException());
        return presenterData;
    }

    public PresenterData<BoxVoid> getUpdateOwnerPresenterData(BoxResponse<BoxVoid> boxResponse) {
        PresenterData<BoxVoid> presenterData = new PresenterData<>();
        if (boxResponse.isSuccess()) {
            presenterData.success(null);
            return presenterData;
        }
        if (boxResponse.getException() instanceof BoxException) {
            BoxException boxException = (BoxException) boxResponse.getException();
            int i = AnonymousClass1.$SwitchMap$com$box$androidsdk$content$BoxException$ErrorType[boxException.getErrorType().ordinal()];
            if (i == 1) {
                presenterData.failure(R.string.box_sharedsdk_new_owner_not_collaborator, boxException);
                return presenterData;
            }
            if (i == 2) {
                presenterData.failure(R.string.box_sharesdk_network_error, boxException);
                return presenterData;
            }
            presenterData.failure(R.string.box_sharedsdk_unable_to_update_owner, boxException);
            return presenterData;
        }
        presenterData.setException(boxResponse.getException());
        return presenterData;
    }

    /* JADX INFO: renamed from: com.box.android.utilities.ShareSDKTransformer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$androidsdk$content$BoxException$ErrorType;

        static {
            int[] iArr = new int[BoxException.ErrorType.values().length];
            $SwitchMap$com$box$androidsdk$content$BoxException$ErrorType = iArr;
            try {
                iArr[BoxException.ErrorType.NEW_OWNER_NOT_COLLABORATOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$BoxException$ErrorType[BoxException.ErrorType.NETWORK_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PresenterData<BoxCollaboration> getUpdateCollaborationPresenterData(BoxResponse<BoxCollaboration> boxResponse) {
        PresenterData<BoxCollaboration> presenterData = new PresenterData<>();
        if (boxResponse.isSuccess()) {
            presenterData.success((BoxCollaboration) boxResponse.getResult());
            return presenterData;
        }
        if (boxResponse.getException() instanceof BoxException) {
            BoxException boxException = (BoxException) boxResponse.getException();
            if (boxException.getResponseCode() == 403) {
                presenterData.failure(R.string.box_sharesdk_insufficient_permissions, boxException);
                return presenterData;
            }
            if (AnonymousClass1.$SwitchMap$com$box$androidsdk$content$BoxException$ErrorType[boxException.getErrorType().ordinal()] == 2) {
                presenterData.failure(R.string.box_sharesdk_network_error, boxException);
                return presenterData;
            }
            presenterData.failure(R.string.box_sharesdk_cannot_get_collaborators, boxException);
            return presenterData;
        }
        presenterData.setException(boxResponse.getException());
        return presenterData;
    }

    public PresenterData<BoxIteratorCollaborations> getCollaborationsPresenterData(BoxResponse<BoxIteratorCollaborations> boxResponse) {
        PresenterData<BoxIteratorCollaborations> presenterData = new PresenterData<>();
        if (boxResponse.isSuccess()) {
            presenterData.success((BoxIteratorCollaborations) boxResponse.getResult());
            return presenterData;
        }
        if (boxResponse.getException() instanceof BoxException) {
            BoxException boxException = (BoxException) boxResponse.getException();
            if (boxException.getResponseCode() == 403) {
                presenterData.failure(R.string.box_sharesdk_insufficient_permissions, boxException);
                return presenterData;
            }
            if (AnonymousClass1.$SwitchMap$com$box$androidsdk$content$BoxException$ErrorType[boxException.getErrorType().ordinal()] == 2) {
                presenterData.failure(R.string.box_sharesdk_network_error, boxException);
                return presenterData;
            }
            presenterData.failure(R.string.box_sharesdk_cannot_get_collaborators, boxException);
            return presenterData;
        }
        presenterData.setException(boxResponse.getException());
        return presenterData;
    }

    public PresenterData<BoxIteratorCollaborations> getIntialsViewCollabsPresenterData(BoxResponse<BoxIteratorCollaborations> boxResponse, BoxIteratorCollaborations boxIteratorCollaborations) {
        PresenterData<BoxIteratorCollaborations> presenterData = new PresenterData<>();
        if (boxResponse.isSuccess()) {
            presenterData.success((BoxIteratorCollaborations) boxResponse.getResult());
            return presenterData;
        }
        if ((boxResponse.getException() instanceof BoxException) && ((BoxException) boxResponse.getException()).getResponseCode() == 404) {
            presenterData.failure(R.string.box_sharesdk_item_unavailable, boxResponse.getException());
            return presenterData;
        }
        presenterData.failure(boxIteratorCollaborations, -1, boxResponse.getException());
        return presenterData;
    }

    public PresenterData<BoxFeatures> getSupportedFeaturePresenterData(BoxResponse<BoxFeatures> boxResponse) {
        PresenterData<BoxFeatures> presenterData = new PresenterData<>();
        if (boxResponse.isSuccess()) {
            presenterData.success((BoxFeatures) boxResponse.getResult());
            return presenterData;
        }
        presenterData.setException(boxResponse.getException());
        return presenterData;
    }
}
