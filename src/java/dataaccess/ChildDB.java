package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Child;

public class ChildDB {

    public List<Child> getAll() throws Exception {
        List<Child> children = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM child";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
                Date dateOfBirth = rs.getDate(3);
                char gender = rs.getString(4).charAt(0);
                char isVisible = rs.getString(5).charAt(0);
                String owner = rs.getString(6);

                Child child = new Child(firstName, lastName, dateOfBirth, gender, isVisible, owner);
                children.add(child);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return children;
    }

    public List<Child> getByOwner(String owner) throws Exception {
        List<Child> children = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM child WHERE owner=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, owner);
            rs = ps.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString(1);
                String lastName = rs.getString(2);
                Date dateOfBirth = rs.getDate(3);
                char gender = rs.getString(4).charAt(0);
                char isVisible = rs.getString(5).charAt(0);

                Child child = new Child(firstName, lastName, dateOfBirth, gender, isVisible, owner);
                children.add(child);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return children;
    }

    public void insert(Child child) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO child (first_name, last_name, date_of_birth, gender, is_visible, owner) VALUES (?, ?, ?, ?, '1', ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, child.getFirstName());
            ps.setString(2, child.getLastName());
            ps.setDate(3, (java.sql.Date) (Date) child.getDateOfBirth());
            ps.setString(4, String.valueOf(child.getGender()));
            ps.setString(5, child.getOwner());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void update(Child child) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE child SET first_name=?, last_name=?, date_of_birth=?, gender=? WHERE owner=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, child.getFirstName());
            ps.setString(2, child.getLastName());
            ps.setDate(3, (java.sql.Date) (Date) child.getDateOfBirth());
            ps.setString(4, String.valueOf(child.getGender()));
            ps.setString(5, child.getOwner());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void delete(Child child) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE child SET is_visible = '0' WHERE owner=? and  first_name=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, child.getOwner());
            ps.setString(2, child.getFirstName());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
}
