package m1_practice;
import java.util.*;

class Student {
    String name;
    String dept;
    int q1, q2, q3;

    Student(String name, String dept, int q1, int q2, int q3) {
        this.name = name;
        this.dept = dept;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    int total() {
        return q1 + q2 + q3;
    }
}

public class QuizPerformance {
    static List<Student> list = new ArrayList<>();
    
    static void record(String name, String dept, int q1, int q2, int q3) {
        list.add(new Student(name, dept, q1, q2, q3));
        System.out.println("Record Added: " + name);
    }

    static void topDepartment(String dept) {
        if(list.isEmpty()){
            System.out.println("No Records Available");
            return;
        }
        int max = -1;
        boolean found = false;
        for(Student s : list){
            if(s.dept.equals(dept)){
                found = true;
                max = Math.max(max, s.total());
            }
        }
        if(!found){
            System.out.println("Department Not Found");
            return;
        }
        for(Student s : list){
            if(s.dept.equals(dept) && s.total()==max){
                System.out.println(s.name + " " + s.total());
            }
        }
    }

    static void topQuiz(String quiz){
        int max = -1;
        if(quiz.equals("Q1")){
            for(Student s:list) {
            	max = Math.max(max,s.q1);
            }
            for(Student s:list) {
                if(s.q1==max) {
                    System.out.println(s.name+" "+s.q1);
                }
            }
        }else if(quiz.equals("Q2")){
            for(Student s:list) {
            	max = Math.max(max,s.q2);
            }
            for(Student s:list) {
                if(s.q2==max) {
                    System.out.println(s.name+" "+s.q2);
                }
            }
        }else if(quiz.equals("Q3")){
            for(Student s:list) {
            	max = Math.max(max,s.q3);
            }
            for(Student s:list) {
                if(s.q3==max) {
                    System.out.println(s.name+" "+s.q3);
                }
            }
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            String[] p = line.split(" ");
            if(p[0].equals("Record")){
                record(p[1],p[2],
                        Integer.parseInt(p[3]),
                        Integer.parseInt(p[4]),
                        Integer.parseInt(p[5]));
            }else if(p[0].equals("Top")){
                if(p[1].startsWith("Q")) {
                    topQuiz(p[1]);
                }else
                    topDepartment(p[1]);
            }
        }
    }
}