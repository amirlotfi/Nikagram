package ir.nikagram.ui.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import ir.nikagram.tgnet.TLRPC;
import ir.nikagram.ui.Cells.LocationCell;

public class LocationActivitySearchAdapter extends BaseLocationAdapter {

    private Context mContext;

    public LocationActivitySearchAdapter(Context context) {
        super();
        mContext = context;
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public boolean isEmpty() {
        return places.isEmpty();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new LocationCell(mContext);
        }
        ((LocationCell) view).setLocation(places.get(i), iconUrls.get(i), i != places.size() - 1);
        return view;
    }

    @Override
    public TLRPC.TL_messageMediaVenue getItem(int i) {
        if (i >= 0 && i < places.size()) {
            return places.get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
