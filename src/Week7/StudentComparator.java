package Week7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y)
    {
        //Complete your code
        if (x.getCgpa() < y.getCgpa()) {
            return 1;
        } else if (x.getCgpa() > y.getCgpa()) {
            return -1;
        } else {
            if (x.getFname().compareTo(y.getFname()) > 0) {
                return 1;
            } else if (x.getFname().compareTo(y.getFname()) < 0) {
                return -1;
            } else {
                return x.getId() > y.getId() ? -1 : 1;
            }
        }
    }

    public static void main(String[] args) {
        List<Student> listStudents = new ArrayList<Student>();
        listStudents.add(new Student(1, "Vinh", 19));
        listStudents.add(new Student(2, "Hoa", 19));
        listStudents.add(new Student(3, "Phu", 20));
        Collections.sort(listStudents, new StudentComparator());
        for (int i = 0; i < listStudents.size(); i++) {
            System.out.println(listStudents.get(i).getFname());
        }
    }
}
