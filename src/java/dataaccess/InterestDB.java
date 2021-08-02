package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Interest;

public class InterestDB {

    public List<Interest> getByOwner(String owner) throws Exception {
        List<Interest> interests = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM interest WHERE owner=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, owner);
            rs = ps.executeQuery();
            if (rs.next()) {
                String interestName = rs.getString(1);
                Interest interest = new Interest(interestName, owner);
                interests.add(interest);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return interests;
    }

    public List<Interest> getByInterestName(String interestName) throws Exception {
        List<Interest> interests = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM interest WHERE interest_name=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, interestName);
            rs = ps.executeQuery();
            if (rs.next()) {
                String owner = rs.getString(2);
                Interest interest = new Interest(interestName, owner);
                interests.add(interest);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return interests;
    }

    public void insert(Interest interest) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO interest (interest_name, owner) VALUES (?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, interest.getInterestName());
            ps.setString(2, interest.getOwner());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void delete(Interest interest) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM interest WHERE owner=? and  interest_name=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, interest.getOwner());
            ps.setString(2, interest.getInterestName());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
}
