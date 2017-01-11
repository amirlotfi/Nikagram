package ir.nikagram.Nika.Helper;

import java.util.Date;
import java.util.HashMap;

public class UserHistorysend {
    private static HashMap<Long,Long> list=new HashMap<>();
    public static boolean isok(Long userid) {
        if(list.size()==0)return true;
        if(list.containsKey(userid)){
            if(list.get(userid).longValue()< new Date().getTime()){
                list.remove(userid);
                return true;

            }else{
                return false;
            }
        }else{
            return true;
        }
    }

    public static void add(long userid) {
        list.remove(userid);
        list.put(userid, new Date().getTime()+(20*1000));
    }
}
