package services;

import dataaccess.FriendshipDB;
import java.util.ArrayList;
import java.util.List;
import models.SingleParent;

public class FriendshipService {
    
    public List<SingleParent> getFavourited(String owner) throws Exception{
        List<SingleParent> singleParents = new ArrayList<>();
        FriendshipDB friendshipDB = new FriendshipDB();
        singleParents = friendshipDB.getFavourited(owner);
        return singleParents;
    }
    
    public List<SingleParent> getMatched(String owner) throws Exception{
        List<SingleParent> singleParents = new ArrayList<>();
        FriendshipDB friendshipDB = new FriendshipDB();
        singleParents = friendshipDB.getMatched(owner);
        return singleParents;
    }
   
    public void addFriends(String ownerEmail, String friendEmail) throws Exception{
        FriendshipDB friendshipDB = new FriendshipDB();
        friendshipDB.addFrineds(ownerEmail, friendEmail);
    }
    
    public void deleteFriends(String ownerEmail, String friendEmail) throws Exception{
        FriendshipDB friendshipDB = new FriendshipDB();
        friendshipDB.deleteFrineds(ownerEmail, friendEmail);
    }
}
