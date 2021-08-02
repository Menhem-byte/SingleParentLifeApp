package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.SingleParent;

public class SingleParentDB {

    public List<SingleParent> getAll() throws Exception {
        List<SingleParent> singleParents = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM singleparent";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String email = rs.getString(1);
                String password = rs.getString(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                Date dateOfBirth = rs.getDate(5);
                char gender = rs.getString(6).charAt(0);
                String phoneNumber = rs.getString(7);
                String occupation = rs.getString(8);
                String aboutUser = rs.getString(9);
                char crimeClearanceChecked = rs.getString(10).charAt(0);
                char isActive = rs.getString(11).charAt(0);
                String photo = rs.getString(12);
                String path = rs.getString(13);

                SingleParent singleParent = new SingleParent(email, password, firstName, lastName, dateOfBirth, gender, phoneNumber, occupation, aboutUser, crimeClearanceChecked, isActive,photo,path);
                singleParents.add(singleParent);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return singleParents;
    }

    public SingleParent getByEmail(String email) throws Exception {
        SingleParent singleParent = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM singleparent WHERE email=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                String password = rs.getString(2);
                String firstName = rs.getString(3);
                String lastName = rs.getString(4);
                Date dateOfBirth = rs.getDate(5);
                char gender = rs.getString(6).charAt(0);
                String phoneNumber = rs.getString(7);
                String occupation = rs.getString(8);
                String aboutUser = rs.getString(9);
                char crimeClearanceChecked = rs.getString(10).charAt(0);
                char isActive = rs.getString(11).charAt(0);
                  String photo = rs.getString(12);
                String path = rs.getString(13);

                singleParent = new SingleParent(email, password, firstName, lastName, dateOfBirth, gender, phoneNumber, occupation, aboutUser, crimeClearanceChecked, isActive,photo,path);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return singleParent;
    }

    public void insert(SingleParent singleParent) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO singleparent (email, password, first_name, last_name, date_of_birth, gender, phone_number, occupation, about_user,\n"
                + "crime_clearance_checked, is_active) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '1')";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, singleParent.getEmail());
            ps.setString(2, singleParent.getPassword());
            ps.setString(3, singleParent.getFirstName());
            ps.setString(4, singleParent.getLastName());
            ps.setDate(5, (java.sql.Date) (Date) singleParent.getDateOfBirth());
            ps.setString(6, String.valueOf(singleParent.getGender()));
            ps.setString(7, singleParent.getPhoneNumber());
            ps.setString(8, singleParent.getOccupation());
            ps.setString(9, singleParent.getAboutUser());
            ps.setString(10, String.valueOf(singleParent.getCrimeClearanceChecked()));
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void update(SingleParent singleParent) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE singleparent SET first_name=?, last_name=?, date_of_birth=?, gender=?, phone_number=?, occupation=?, about_user=?,\n"
                + "crime_clearance_checked=?  WHERE email=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, singleParent.getFirstName());
            ps.setString(2, singleParent.getLastName());
            ps.setDate(3, (java.sql.Date) (Date) singleParent.getDateOfBirth());
            ps.setString(4, String.valueOf(singleParent.getGender()));
            ps.setString(5, singleParent.getPhoneNumber());
            ps.setString(6, singleParent.getOccupation());
            ps.setString(7, singleParent.getAboutUser());
            ps.setString(8, String.valueOf(singleParent.getCrimeClearanceChecked()));
            ps.setString(9, singleParent.getEmail());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void delete(SingleParent singleParent) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE singleparent SET is_active = '0' WHERE email=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, singleParent.getEmail());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
}
