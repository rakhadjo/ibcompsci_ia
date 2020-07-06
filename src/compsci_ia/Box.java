/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compsci_ia;

import java.util.ArrayList;

/**
 *
 * @author 42087
 */
public class Box {

    Student[] studentList;
    String destination;
    ArrayList<Student> students;
    int boxSize = 0;

    public Box(ArrayList<Student> studints, String desti) {
        this.students = studints;
        this.destination = desti;
        
    }

    public String getDest() {
        return destination;
    }

    public boolean isStudentInBox(Student ide) {
        if (students.contains(ide)) {
            return true;
        } else {
            return false;
        }
    }

    public void unassignStudent(Student ide) {

//        for (int i = 0; i < studentList.length; i++) {
//            if (studentList[i].equals(ide)) {
//                studentList[i] = null;
//                boxValue--;
//                break;
//            }
//        }
        students.remove(ide);

    }

    public void assignStudent(Student s) {
//        if (isStudentInBox(s) == false && studentList[studentList.length - 1] == null && destination.equals(s.getDestination())) {
//            studentList[boxValue] = s;
//            boxValue++;
//            System.out.println(boxValue);
//        }
        if (isStudentInBox(s) == false && boxSize < 10 && destination.equals(s.getDestination())) {
            students.add(s);
            System.out.println("ASSIGN SUCCCCCCCCCCCCC");
        }
        System.out.println("ASSIGN UNSUCCCCC");
    }

    public void printStudents() {
//        for (Student std : studentList) {
//            if (std != null) {
//                System.out.println(std.printStudent());
//            } else {
//                System.out.println("null value exception bruvv");
//            }
//        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) != null) {
                System.out.println(students.get(i).getFirstName());
            }
        }
    }

}
