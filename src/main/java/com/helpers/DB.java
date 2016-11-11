

package com.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**jdbc:mysql://127.0.0.1:3306/
 *
 * @author Anidu
 */
public class DB {

    static Connection connection;

    public static Connection createConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/performance", "root1", "root");
        return c;
    }

    public static boolean delete(String table, String column, Object q) throws Exception {
        if (connection == null) {
            connection = createConnection();
        }
        int a = connection.createStatement().executeUpdate("delete from " + table + " where " + column + "='" + q+"'");
//        connection.commit();
        if (a > 0) {
            return true;
        }
        return false;
    }

    public static int update(String sql) throws Exception {
        if (connection == null) {
            connection = createConnection();
        }
        int a = connection.createStatement().executeUpdate(sql);
//        connection.commit();
        return a;
    }

    
    public static int update(String table, Map<String, Object> map, String w_col, Object w_value) throws Exception {
        if (connection == null) {
            connection = createConnection();
        }

        String q = "update " + table + " set " + getupdateQ(map) + " where " + w_col + "='" + w_value + "'";

        PreparedStatement st = createConnection().prepareStatement(q);
        Set<String> set = map.keySet();
        int col = 1;
        for (String key : set) {
            st.setString(col, ""+map.get(key));
            col++;
        }
        int a = st.executeUpdate();
        st.close();
//        connector.commit();
        return a;
    }

    public static int insert(String table, Map<String, Object> map) throws Exception {
        if (connection == null) {
            connection = createConnection();
        }
        String q = "insert into " + table + " (" + getColumns(map) + ") values (" + getValueQs(map) + ")";

        int col = 1;
        PreparedStatement st = connection.prepareStatement(q);
        Set<String> set = map.keySet();
        for (String key : set) {
            st.setString(col, ""+map.get(key));
            col++;
        }
        int a = st.executeUpdate();
        st.close();
//        connection.commit();
        return a;
    }

    public static ResultSet result(String sql) throws Exception {
        if (connection == null) {
            connection = createConnection();
        }
        ResultSet result = connection.createStatement().executeQuery(sql);
//        connection.commit();
        return result;
    }

    public static String getColumns(Map<String, Object> map) {
        String st = map.keySet().toString();
        st = st.replaceAll("[\\[\\]]", "");
        return st;
    }

    public static String getupdateQ(Map<String, Object> map) {
        String[] ar = new String[map.size()];
        int col = 0;
        Set<String> set = map.keySet();
        for (String key : set) {
            ar[col] = key + "=?";
            col++;
        }
        String st = Arrays.toString(ar);
        st = st.replaceAll("[\\[\\]]", "");
        return st;
    }

    public static String getValueQs(Map<String, Object> map) {
        String val_arr[] = new String[map.size()];
        for (int i = 0; i < val_arr.length; i++) {
            val_arr[i] = "?";
        }
        String st = Arrays.toString(val_arr);
        st = st.replaceAll("[\\[\\]]", "");
        return st;
    }

}
