package com.box.androidsdk.content.auth;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.box.android.dataaccess.content.R;
import com.microsoft.intune.mam.client.app.MAMFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class ChooseAuthenticationFragment extends MAMFragment {
    private static final String EXTRA_BOX_AUTHENTICATION_INFOS = "boxAuthenticationInfos";
    private ListView mListView;

    public interface OnAuthenticationChosen {
        void onAuthenticationChosen(BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo);

        void onDifferentAuthenticationChosen();
    }

    @Override // com.microsoft.intune.mam.client.app.MAMFragment, com.microsoft.intune.mam.client.app.HookedFragmentBase
    public View onMAMCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ArrayList<BoxAuthentication.BoxAuthenticationInfo> authenticationInfoList = getAuthenticationInfoList();
        View viewInflate = layoutInflater.inflate(R.layout.boxsdk_choose_auth_activity, (ViewGroup) null);
        ListView listView = (ListView) viewInflate.findViewById(R.id.boxsdk_accounts_list);
        this.mListView = listView;
        if (authenticationInfoList == null) {
            getActivity().getFragmentManager().beginTransaction().remove(this).commit();
            return viewInflate;
        }
        listView.setAdapter((ListAdapter) new AuthenticatedAccountsAdapter(getActivity(), R.layout.boxsdk_list_item_account, authenticationInfoList));
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.box.androidsdk.content.auth.ChooseAuthenticationFragment.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (adapterView.getAdapter() instanceof AuthenticatedAccountsAdapter) {
                    BoxAuthentication.BoxAuthenticationInfo item = ((AuthenticatedAccountsAdapter) adapterView.getAdapter()).getItem(i);
                    if (item instanceof AuthenticatedAccountsAdapter.DifferentAuthenticationInfo) {
                        if (ChooseAuthenticationFragment.this.getActivity() instanceof OnAuthenticationChosen) {
                            ((OnAuthenticationChosen) ChooseAuthenticationFragment.this.getActivity()).onDifferentAuthenticationChosen();
                        }
                    } else if (ChooseAuthenticationFragment.this.getActivity() instanceof OnAuthenticationChosen) {
                        ((OnAuthenticationChosen) ChooseAuthenticationFragment.this.getActivity()).onAuthenticationChosen(item);
                    }
                }
            }
        });
        return viewInflate;
    }

    public ArrayList<BoxAuthentication.BoxAuthenticationInfo> getAuthenticationInfoList() {
        if (getArguments() != null && getArguments().getCharSequenceArrayList(EXTRA_BOX_AUTHENTICATION_INFOS) != null) {
            ArrayList<CharSequence> charSequenceArrayList = getArguments().getCharSequenceArrayList(EXTRA_BOX_AUTHENTICATION_INFOS);
            ArrayList<BoxAuthentication.BoxAuthenticationInfo> arrayList = new ArrayList<>(charSequenceArrayList.size());
            for (CharSequence charSequence : charSequenceArrayList) {
                BoxAuthentication.BoxAuthenticationInfo boxAuthenticationInfo = new BoxAuthentication.BoxAuthenticationInfo();
                boxAuthenticationInfo.createFromJson(charSequence.toString());
                arrayList.add(boxAuthenticationInfo);
            }
            return arrayList;
        }
        Map<String, BoxAuthentication.BoxAuthenticationInfo> storedAuthInfo = BoxAuthentication.getInstance().getStoredAuthInfo(getActivity());
        if (storedAuthInfo == null) {
            return null;
        }
        ArrayList<BoxAuthentication.BoxAuthenticationInfo> arrayList2 = new ArrayList<>(storedAuthInfo.size());
        Iterator<String> it = storedAuthInfo.keySet().iterator();
        while (it.hasNext()) {
            arrayList2.add(storedAuthInfo.get(it.next()));
        }
        return arrayList2;
    }

    public static ChooseAuthenticationFragment createAuthenticationActivity(Context context) {
        return new ChooseAuthenticationFragment();
    }
}
