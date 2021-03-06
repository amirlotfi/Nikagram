
package ir.nikagram.ui.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import ir.nikagram.messenger.AndroidUtilities;
import ir.nikagram.messenger.LocaleController;
import ir.nikagram.messenger.MessagesController;
import ir.nikagram.messenger.R;
import ir.nikagram.messenger.UserConfig;
import ir.nikagram.ui.Cells.DrawerActionCell;
import ir.nikagram.ui.Cells.DividerCell;
import ir.nikagram.ui.Cells.EmptyCell;
import ir.nikagram.ui.Cells.DrawerProfileCell;

public class DrawerLayoutAdapter extends BaseAdapter {

    private Context mContext;

    public DrawerLayoutAdapter(Context context) {
        mContext = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int i) {
        return !(i == 1 || i == 5);
    }

    @Override
    public int getCount() {
        return UserConfig.isClientActivated() ? 15 : 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int type = getItemViewType(i);
        if (type == 0) {
            DrawerProfileCell drawerProfileCell;
            if (view == null) {
                view = drawerProfileCell = new DrawerProfileCell(mContext);
            } else {
                drawerProfileCell = (DrawerProfileCell) view;
            }
            drawerProfileCell.setUser(MessagesController.getInstance().getUser(UserConfig.getClientUserId()));
        } else if (type == 1) {
            if (view == null) {
                view = new EmptyCell(mContext, AndroidUtilities.dp(8));
            }
        } else if (type == 2) {
            if (view == null) {
                view = new DividerCell(mContext);
            }
        } else if (type == 3) {
            if (view == null) {
                view = new DrawerActionCell(mContext);
            }
            DrawerActionCell actionCell = (DrawerActionCell) view;
            if (i == 2) {
                actionCell.setTextAndIcon(LocaleController.getString("NewGroup", R.string.NewGroup), R.drawable.menu_newgroup);
            } else if (i == 3) {
                actionCell.setTextAndIcon(LocaleController.getString("NewSecretChat", R.string.NewSecretChat), R.drawable.menu_secret);
            } else if (i == 4) {
                actionCell.setTextAndIcon(LocaleController.getString("NewChannel", R.string.NewChannel), R.drawable.menu_broadcast);
            } else if (i == 6) {
                actionCell.setTextAndIcon(LocaleController.getString("Contacts", R.string.Contacts), R.drawable.menu_contacts);
            } else if (i == 7) {
                actionCell.setTextAndIcon(LocaleController.getString("InviteFriends", R.string.InviteFriends), R.drawable.menu_invite);
            } else if (i == 8) {
                actionCell.setTextAndIcon(LocaleController.getString("UsernameFinder", R.string.UsernameFinder), R.drawable.ic_user_search);
            } else if (i == 9) {
                actionCell.setTextAndIcon(LocaleController.getString("Settings", R.string.Settings), R.drawable.menu_settings);
            } else if (i == 10) {
                actionCell.setTextAndIcon(LocaleController.getString("TelegramFaq", R.string.TelegramFaq), R.drawable.menu_help);
            } else if (i == 12) {
                actionCell.setTextAndIcon(LocaleController.getString("Rate", R.string.Rate), R.drawable.menu_rate);
            } else if (i == 13) {
                actionCell.setTextAndIcon(LocaleController.getString("Apps", R.string.Apps), R.drawable.menu_apps);
            } else if (i == 14) {
                actionCell.setTextAndIcon(LocaleController.getString("InviteToNikagram", R.string.InviteToNikagram), R.drawable.menu_invite);
            }
        }
        return view;
    }

    @Override
    public int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else if (i == 5 || i==11) {
            return 2;
        }
        return 3;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public boolean isEmpty() {
        return !UserConfig.isClientActivated();
    }
}
