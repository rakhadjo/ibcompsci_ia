/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compsci_ia;

/**
 *
 * @author 42087
 */
public class Student {

    String firstName, lastName, ID, distr;

    public Student(String fn, String ln, String id, String dist) {

        this.firstName = fn;
        this.lastName = ln;
        this.ID = id;
        this.distr = dist;

    }

    public Student(String fullname, String id, String dist) {
        splitName(fullname);
        this.ID = id;
        this.distr = dist;
    }

    public String getID() {
        return ID;
    }

    public void splitName(String s) {
        for (int index = 0; index < s.length(); index++) {
            if (Character.isSpaceChar(s.charAt(index))) {
                this.firstName = s.substring(0, index);
                this.lastName = s.substring(index++);
            }
        }
    }

    public String getDestination() {
        return distr;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String printStudent() {
        return firstName + " " + lastName;
    }
}
