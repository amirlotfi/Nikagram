package ir.nikagram.ui.Adapters;

import android.location.Location;

import org.json.JSONArray;
import org.json.JSONObject;
import ir.nikagram.messenger.AndroidUtilities;
import ir.nikagram.messenger.volley.Request;
import ir.nikagram.messenger.volley.RequestQueue;
import ir.nikagram.messenger.volley.Response;
import ir.nikagram.messenger.volley.VolleyError;
import ir.nikagram.messenger.volley.toolbox.JsonObjectRequest;
import ir.nikagram.messenger.volley.toolbox.Volley;
import ir.nikagram.messenger.ApplicationLoader;
import ir.nikagram.messenger.BuildVars;
import ir.nikagram.messenger.FileLog;
import ir.nikagram.tgnet.TLRPC;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class BaseLocationAdapter extends BaseFragmentAdapter {

    public interface BaseLocationAdapterDelegate {
        void didLoadedSearchResult(ArrayList<TLRPC.TL_messageMediaVenue> places);
    }

    private RequestQueue requestQueue;
    protected boolean searching;
    protected ArrayList<TLRPC.TL_messageMediaVenue> places = new ArrayList<>();
    protected ArrayList<String> iconUrls = new ArrayList<>();
    private Location lastSearchLocation;
    private BaseLocationAdapterDelegate delegate;
    private Timer searchTimer;

    public BaseLocationAdapter() {
        requestQueue = Volley.newRequestQueue(ApplicationLoader.applicationContext);
    }

    public void destroy() {
        if (requestQueue != null) {
            requestQueue.cancelAll("search");
            requestQueue.stop();
        }
    }

    public void setDelegate(BaseLocationAdapterDelegate delegate) {
        this.delegate = delegate;
    }

    public void searchDelayed(final String query, final Location coordinate) {
        if (query == null || query.length() == 0) {
            places.clear();
            notifyDataSetChanged();
        } else {
            try {
                if (searchTimer != null) {
                    searchTimer.cancel();
                }
            } catch (Exception e) {
                FileLog.e("tmessages", e);
            }
            searchTimer = new Timer();
            searchTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        searchTimer.cancel();
                        searchTimer = null;
                    } catch (Exception e) {
                        FileLog.e("tmessages", e);
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() {
                        @Override
                        public void run() {
                            lastSearchLocation = null;
                        }
                    });
                }
            }, 200, 500);
        }
    }
}
