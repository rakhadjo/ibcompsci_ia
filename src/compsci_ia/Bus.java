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
public class Bus {
    
    public String destination;
    public Student[] passengers = new Student[5];
    int present = -1;
    
    public Bus(String d) {
        this.destination = d;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public void assignStudentToBus(Student s) {
        if (passengers[5] != null) {
            System.out.println("Full");
        }
        else {
            passengers[present++] = s;
        }
    }
}
