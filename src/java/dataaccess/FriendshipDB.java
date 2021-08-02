package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.SingleParent;

public class FriendshipDB{
    
    //This method is used to list all favourited persons of a user, which means one have marked another as favourited but  have not yet been marked  favourited in turn
    //The value 0 of status indicates this situation 
    public List<SingleParent> getFavourited(String ownerEmail) throws Exception {
        List<SingleParent> singleParents = new ArrayList<>();
        SingleParentDB singleParentDB = new SingleParentDB();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM friendship WHERE owner = ? and status = '0'";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ownerEmail);
            rs = ps.executeQuery();
            while (rs.next()) {
                String friendEmail = rs.getString(1);
                SingleParent singleParent = singleParentDB.getByEmail(friendEmail);
                singleParents.add(singleParent);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return singleParents;
    }
    
      
    
    //This method is used to list all matchted persons of a user, which means they have been marked as favourited by each other
    //The value 1 of status indicates this situation 
        public List<SingleParent> getMatched(String ownerEmail) throws Exception {
        List<SingleParent> singleParents = new ArrayList<>();
        SingleParentDB singleParentDB = new SingleParentDB();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM friendship WHERE owner = ? and status = '1'";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ownerEmail);
            rs = ps.executeQuery();
            while (rs.next()) {
                String friendEmail = rs.getString(1);
                SingleParent singleParent = singleParentDB.getByEmail(friendEmail);
                singleParents.add(singleParent);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return singleParents;
    }

    //This method is used to add friends. There are two possibilities depending on whether or not the person who the user is adding have added the user already. 
    //So firstly a select query will be run to check which one of the two possibilities is the case.
    //If no, just a new record will be inserted into the table with the value 0 of status.
    //If yes, apart from inserting a new record with the value 1 of status, the original record which already exists since the friend added the user should be updated as well, changing 
    //status from 0 to 1.
    public void addFrineds (String ownerEmail, String friendEmail) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        PreparedStatement ps4 = null;
        ResultSet rs = null;
        String sql1 = "INSERT INTO friendship (friend, owner, status) VALUES (?, ?, '0')";
        String sql2 = "INSERT INTO friendship (friend, owner, status) VALUES (?, ?, '1')";
        String sql3 = "UPDATE friendship SET status = '1' WHERE friend = ? and owner = ?";
        String sql4 = "SELECT * FROM friendship WHERE friend = ? and owner = ? and status = '0'";
        
        try {
            ps1 = con.prepareStatement(sql1);
            ps2 = con.prepareStatement(sql2);
            ps3 = con.prepareStatement(sql3);
            ps4 = con.prepareStatement(sql4);
            ps1.setString(1,friendEmail);
            ps1.setString(2,ownerEmail);
            ps2.setString(1,friendEmail);
            ps2.setString(2,ownerEmail);
            ps3.setString(1,ownerEmail);
            ps3.setString(2,friendEmail);
            ps4.setString(1, ownerEmail);
            ps4.setString(2, friendEmail);
            rs = ps4.executeQuery();
           
            if (rs.next()) {
                ps2.executeUpdate();
                ps3.executeUpdate();
            }
            
            else {
                ps1.executeUpdate();
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps1);
            DBUtil.closePreparedStatement(ps2);
            DBUtil.closePreparedStatement(ps3);
            DBUtil.closePreparedStatement(ps4);
            cp.freeConnection(con);
        }
    }
    
    
    ////This method is used to delete friends. There are also  two possibilities depending on whether or not they have been matched already. 
    //So firstly a select query will be run to check which one of the two possibilities is the case.
    //If no, just one record will be deleted from the table.
    //If yes, apart from deleting the record, the corresponding record should be updated as well, changing status from 1 to 0.
    public void deleteFrineds (String ownerEmail, String friendEmail) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        ResultSet rs = null;
        String sql1 = "DELETE FROM friendship WHERE friend = ? and owner = ?";
        String sql2 = "UPDATE friendship SET status = '0' WHERE friend = ? and owner = ?";
        String sql3 = "SELECT * FROM friendship WHERE friend = ? and owner = ?";
        
        try {
            ps1 = con.prepareStatement(sql1);
            ps2 = con.prepareStatement(sql2);
            ps3 = con.prepareStatement(sql3);
            ps1.setString(1, friendEmail);
            ps1.setString(2, ownerEmail);
            ps2.setString(1, ownerEmail);
            ps2.setString(2, friendEmail);
            ps3.setString(1, friendEmail);
            ps3.setString(2, ownerEmail);
            rs = ps3.executeQuery();
            
            char status = rs.getString(3).charAt(0);
           
            if ('0' == status) {
                ps1.executeUpdate();
            }
            
            else {
                ps1.executeUpdate();
                ps2.executeUpdate();
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps1);
            DBUtil.closePreparedStatement(ps2);
            DBUtil.closePreparedStatement(ps3);
            cp.freeConnection(con);
        }
    } 
}
