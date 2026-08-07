package com.box.android.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.box.android.R;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.modelcontroller.messages.BoxLocalUsersDataMessage;
import com.box.android.domain.models.BoxAuthMap;
import com.box.androidsdk.content.auth.AuthenticatedAccountsAdapter;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes11.dex */
public class ChooseAuthenticationFragment extends Hilt_ChooseAuthenticationFragment {
    private static final String EXTRA_BOX_AUTHENTICATION_INFOS = "boxAuthenticationInfos";

    @Inject
    protected IMoCoBoxGlobalSettings mGlobalSettings;

    public interface OnAuthenticationChosen {
        void onAuthenticationChosen(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo);

        void onDifferentAuthenticationChosen();
    }

    public static List<BoxAuthentication.BoxAuthenticationInfo> getCombinedUsers(IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings, List<String> list, String str) {
        BoxAuthMap payload;
        BoxIterator<BoxAuthentication.BoxAuthenticationInfo> boxIteratorConvertUsersList = convertUsersList(list, str);
        HashMap map = new HashMap();
        try {
            payload = ((BoxLocalUsersDataMessage) iMoCoBoxGlobalSettings.getAllUsersData().get()).getPayload();
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            BoxLogUtils.logException(e);
            payload = null;
        }
        if (payload != null) {
            for (BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo : payload) {
                BoxUser user = boxAuthenticationInfo.getUser();
                if (user != null) {
                    map.put(user.getUserId(), boxAuthenticationInfo);
                }
            }
        }
        for (BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo2 : boxIteratorConvertUsersList) {
            map.put(boxAuthenticationInfo2.getUser().getUserId(), boxAuthenticationInfo2);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((BoxAuthentication.BoxAuthenticationInfo) ((Map.Entry) it.next()).getValue());
        }
        return arrayList;
    }

    private static BoxIterator<BoxAuthentication.BoxAuthenticationInfo> convertUsersList(List<String> list, String str) {
        BoxIterator<BoxAuthentication.BoxAuthenticationInfo> boxIterator = new BoxIterator<BoxAuthentication.BoxAuthenticationInfo>() { // from class: com.box.android.fragments.ChooseAuthenticationFragment.1
            @Override // com.box.androidsdk.content.models.BoxIterator
            protected BoxJsonObject.BoxJsonObjectCreator getObjectCreator() {
                return BoxJsonObject.getBoxJsonObjectCreator(BoxAuthentication.BoxAuthenticationInfo.class);
            }
        };
        if (list != null) {
            for (String str2 : list) {
                BoxUser boxUser = new BoxUser();
                boxUser.createFromJson(str2);
                BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo = new BoxAuthentication.BoxAuthenticationInfo();
                boxAuthenticationInfo.setUser(boxUser);
                boxAuthenticationInfo.setClientId(str);
            }
        }
        return boxIterator;
    }

    public static ChooseAuthenticationFragment createAuthenticationActivity(Context context) {
        return new ChooseAuthenticationFragment();
    }

    public static ChooseAuthenticationFragment createChooseAuthenticationFragment(Context context, ArrayList<String> arrayList, String str) {
        ChooseAuthenticationFragment chooseAuthenticationFragmentCreateAuthenticationActivity = createAuthenticationActivity(context);
        Bundle arguments = chooseAuthenticationFragmentCreateAuthenticationActivity.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putStringArrayList(EXTRA_BOX_AUTHENTICATION_INFOS, arrayList);
        arguments.putString("client_id", str);
        chooseAuthenticationFragmentCreateAuthenticationActivity.setArguments(arguments);
        return chooseAuthenticationFragmentCreateAuthenticationActivity;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        ArrayList<String> stringArrayList = arguments.getStringArrayList(EXTRA_BOX_AUTHENTICATION_INFOS);
        String string = arguments.getString("client_id");
        View viewInflate = layoutInflater.inflate(R.layout.boxsdk_choose_auth_activity, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R.id.boxsdk_accounts_list);
        listView.setAdapter((ListAdapter) new AuthenticatedAccountsAdapter(getActivity(), R.layout.spinner_item, getCombinedUsers(this.mGlobalSettings, stringArrayList, string)));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.box.android.fragments.ChooseAuthenticationFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView.getAdapter() instanceof AuthenticatedAccountsAdapter) {
                    BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo = (BoxAuthentication.BoxAuthenticationInfo) adapterView.getAdapter().getItem(i);
                    if (ChooseAuthenticationFragment.this.getActivity() instanceof OnAuthenticationChosen) {
                        if (boxAuthenticationInfo instanceof AuthenticatedAccountsAdapter.DifferentAuthenticationInfo) {
                            ((OnAuthenticationChosen) ChooseAuthenticationFragment.this.getActivity()).onDifferentAuthenticationChosen();
                        } else {
                            ((OnAuthenticationChosen) ChooseAuthenticationFragment.this.getActivity()).onAuthenticationChosen(boxAuthenticationInfo);
                        }
                    }
                }
            }
        });
        return viewInflate;
    }
}
