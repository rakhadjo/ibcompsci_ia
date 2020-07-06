/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compsci_ia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 42087
 */
public class ParkingLot {

    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    public static ResultSet rs = null;

    private static Connection connect2 = null;
    private static Statement statement2 = null;
    private static ResultSet resultSet2 = null;
    public static ResultSet rs2 = null;

    public static String address;
    public static Integer number_of_students;

    Box[] boxes = new Box[4];
    String tempDist;
    public String firstTemp, lastTemp, distrTemp, idTemp;

    public ParkingLot() {
        createBoxes();
        connectRealDB();
    }

    public static void connectRealDB() {
        System.out.println("Connecting to Database .. trying to get 1 record");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://raka.chubluyihzk4.ap-southeast-1.rds.amazonaws.com/dbraka?" + "user=mysqlbbg&password=MampangRaya60");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from userinfo where "
                    + "last = 'nugroho' and first = 'prasetyo' and id = 1"); //test, taken from first value
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {
                System.out.println("Something Wrong " + e.getMessage());
            }

        }
    }

    public static boolean getUserInfo(String first, String last, int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://raka.chubluyihzk4.ap-southeast-1.rds.amazonaws.com/dbraka?" + "user=mysqlbbg&password=MampangRaya60");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from userinfo where last = '" + last + "' and first = '" + first + "' and id = " + id);
            rs = resultSet;
            writeResultSet(resultSet);
        } catch (Exception e) {
            System.out.println("Something Wrong.. " + e.getMessage());
            return false;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {
                System.out.println("Something Wrong.. " + e.getMessage());
                return false;
            }

        }
        return true;
    }

    private void writeResultSet2(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            firstTemp = resultSet.getString("first");
            lastTemp = resultSet.getString("last");
            distrTemp = resultSet.getString("address");
            System.out.println("IM WITH YA BUDDY" + distrTemp);
        }
    }

    public boolean getUserInfo2(String fullname) {
        try {
            for (int index = 0; index < fullname.length(); index++) {
                if (Character.isSpaceChar(fullname.charAt(index))) {
                    firstTemp = fullname.substring(0, index);
                    lastTemp = fullname.substring(index);
                    System.out.println(firstTemp + lastTemp);
                }
            }
            Class.forName("com.mysql.jdbc.Driver");
            connect2 = DriverManager.getConnection("jdbc:mysql://raka.chubluyihzk4.ap-southeast-1.rds.amazonaws.com/dbraka?" + "user=mysqlbbg&password=MampangRaya60");
            statement2 = connect2.createStatement();
            resultSet2 = statement2.executeQuery("select * from userinfo where last = '" + lastTemp + "' and first = '" + firstTemp + "'");
            rs2 = resultSet2;
            writeResultSet2(resultSet2);
        } catch (Exception e) {
            System.out.println("Something Wrong.. " + e.getMessage());
            return false;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {
                System.out.println("Something Wrong.. " + e.getMessage());
                return false;
            }

        }
        return true;
    }

    private static void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String first = resultSet.getString("first");
            String last = resultSet.getString("last");
            String address = resultSet.getString("address");
            int id = resultSet.getInt("id");
            System.out.println("----- WRITING RESULT SET FROM DATABASE -----");
            System.out.println("First: " + first);
            System.out.println("Last: " + last);
            System.out.println("Address: " + address);
            System.out.println("Id: " + id);

            ParkingLot.address = address;
            System.out.println("----- LOT : " + ParkingLot.address + "-----");
        }
    }

    public void createBoxes() {
        int destinationIndex = 0;
        String[] boxName = {"bogor", "banda", "mampang", "gading"};
        for (int boxy = 0; boxy < boxes.length; boxy++) {
            Student[] studys = new Student[5];
            ArrayList stds = new ArrayList<Student>(5);
            boxes[boxy] = new Box(stds, boxName[destinationIndex]);
            destinationIndex++;
        }

        System.out.println("Print Box Information ..");
        for (int boxy = 0; boxy < boxes.length; boxy++) {
            System.out.println("Box " + boxy + " is destined to " + boxes[boxy].getDest());
        }

    }

    

}
