/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.FriendshipDB;
import dataaccess.SingleParentDB;
import java.util.ArrayList;
import java.util.List;
import models.SingleParent;

/**
 *
 * @author itsupport
 */
public class SingleParentService {
      public List<SingleParent> getAll() throws Exception{
        List<SingleParent> singleParents = new ArrayList<>();
        SingleParentDB singleparentdbDB = new   SingleParentDB();
        singleParents = singleparentdbDB.getAll();
        return singleParents;
    }
    
}
