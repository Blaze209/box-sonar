package com.box.android.usx.adapters;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.databinding.DataBindingUtil;
import com.box.android.R;
import com.box.android.coreservices.models.BoxInvitee;
import com.box.android.coreservices.models.BoxIteratorInvitees;
import com.box.android.databinding.UsxListItemCollaborationInviteeBinding;
import com.eclipsesource.json.JsonObject;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public class InviteeAdapter extends BaseAdapter implements Filterable {
    private Context mContext;
    private InviteeAdapterListener mListener;
    private final ArrayList<BoxInvitee> mInvitees = new ArrayList<>();
    private final ArrayList<BoxInvitee> mItems = new ArrayList<>();
    private InviteeFilter mInviteeFilter = new InviteeFilter();

    public interface InviteeAdapterListener {
        void onFilterTermChanged(CharSequence charSequence);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    private class InviteeFilter extends Filter {
        CharSequence mConstraint;

        private InviteeFilter() {
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null) {
                return filterResults;
            }
            this.mConstraint = charSequence;
            if (InviteeAdapter.this.mListener != null) {
                InviteeAdapter.this.mListener.onFilterTermChanged(charSequence);
            }
            ArrayList arrayList = new ArrayList();
            for (BoxInvitee boxInvitee : InviteeAdapter.this.mInvitees) {
                if (boxInvitee != null && ((boxInvitee.getName() != null && boxInvitee.getName().toLowerCase().contains(charSequence.toString().toLowerCase())) || (boxInvitee.getEmail() != null && boxInvitee.getEmail().toLowerCase().contains(charSequence.toString().toLowerCase())))) {
                    arrayList.add(boxInvitee);
                }
            }
            if (InviteeAdapter.this.isReadContactsPermissionAvailable()) {
                Cursor cursorQuery = MAMContentResolverManagement.query(InviteeAdapter.this.mContext.getContentResolver(), ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, "data1 LIKE '%" + ((Object) charSequence) + "%' OR display_name LIKE '%" + ((Object) charSequence) + "%'", null, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("display_name"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("data1"));
                        if (string.contains(charSequence) || string2.contains(charSequence)) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.add("name", string);
                            jsonObject.add("email", string2);
                            arrayList.add(new BoxInvitee(jsonObject));
                        }
                    }
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            InviteeAdapter.this.mItems.clear();
            if (filterResults != null && filterResults.count > 0) {
                InviteeAdapter.this.mItems.addAll((ArrayList) filterResults.values);
                InviteeAdapter.this.notifyDataSetChanged();
            } else {
                InviteeAdapter.this.notifyDataSetInvalidated();
            }
        }

        public void onInviteesChanged() {
            publishResults(this.mConstraint, performFiltering(this.mConstraint));
        }
    }

    public InviteeAdapter(Context context) {
        this.mContext = context;
    }

    public void setInviteeAdapterListener(InviteeAdapterListener inviteeAdapterListener) {
        this.mListener = inviteeAdapterListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mItems.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mItems.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.usx_list_item_collaboration_invitee, (ViewGroup) null);
        }
        BoxInvitee boxInvitee = this.mItems.get(i);
        UsxListItemCollaborationInviteeBinding usxListItemCollaborationInviteeBinding = (UsxListItemCollaborationInviteeBinding) DataBindingUtil.bind(view);
        usxListItemCollaborationInviteeBinding.setInviteeEmail(boxInvitee.getEmail());
        usxListItemCollaborationInviteeBinding.setInviteeName(boxInvitee.getName());
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return this.mInviteeFilter;
    }

    public void setInvitees(BoxIteratorInvitees boxIteratorInvitees) {
        this.mInvitees.clear();
        Iterator<BoxInvitee> it = boxIteratorInvitees.iterator();
        while (it.hasNext()) {
            this.mInvitees.add(it.next());
        }
        this.mInviteeFilter.onInviteesChanged();
    }

    protected boolean isReadContactsPermissionAvailable() {
        return this.mContext.checkCallingOrSelfPermission("android.permission.READ_CONTACTS") == 0;
    }
}
