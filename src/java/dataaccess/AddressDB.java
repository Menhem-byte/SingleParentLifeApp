package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Address;

public class AddressDB {

    public List<Address> getAll() throws Exception {
        List<Address> addresses = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM address";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String owner = rs.getString(1);
                String zipcode = rs.getString(2);
                String city = rs.getString(3);
                String province = rs.getString(4);
                String country = rs.getString(5);
                char isValid = rs.getString(6).charAt(0);
                

                Address address = new Address(owner, zipcode, city, province, country, isValid);
                addresses.add(address);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return addresses;
    }

    public Address getByOwner(String owner) throws Exception {
        Address address = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM address WHERE owner=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, owner);
            rs = ps.executeQuery();
            if (rs.next()) {
                String zipcode = rs.getString(2);
                String city = rs.getString(3);
                String province = rs.getString(4);
                String country = rs.getString(5);
                char isValid = rs.getString(6).charAt(0);

                address = new Address(owner, zipcode, city, province, country, isValid);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return address;
    }

    public void insert(Address address) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO address (owner, zipcode, city, province, country, is_valid) VALUES (?, ?, ?, ?, ?, '1')";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, address.getOwner());
            ps.setString(2, address.getZipcode());
            ps.setString(3, address.getCity());
            ps.setString(4, address.getProvince());
            ps.setString(5, address.getCountry());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void update(Address address) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE address SET zipcode=?, city=?, province=?, countryr=? WHERE owner=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, address.getZipcode());
            ps.setString(2, address.getCity());
            ps.setString(3, address.getProvince());
            ps.setString(4, address.getCountry());
            ps.setString(5, address.getOwner());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    public void delete(Address address) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE address SET is_visible = '0' WHERE owner=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, address.getOwner());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
}

