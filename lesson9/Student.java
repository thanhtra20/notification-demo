package lesson9;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String name;
    private final int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + "(" + score + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + score;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (score != other.score)
            return false;
        return true;
    }

    // lấy tên học sinh có điểm từ 8 trở lên
    static List<String> goodNamesFor(List<Student> students) {
        List<String> good = new ArrayList<>();
        for (Student s : students) {
            if (s.getScore() >= 8) {
                good.add(s.getName());
            }
        }
        return good;
    }

    //lấy stream
    static List<String> goodNamesStream(List<Student> students) {
        return students.stream()
                .filter(s -> s.getScore() >= 8)
                .map(Student::getName)
                .toList();
    }

    //tính điểm trung bình
    static double averageFor(List<Student> students) {
        int sum = 0;
        for (Student s : students) {
            sum += s.getScore();
        }
        return students.isEmpty() ? 0 : (double) sum / students.size();
    }

    static double averageStream(List<Student> students) {
        return students.stream()
                .mapToInt(Student::getScore)
                .average()
                .orElse(0);
    }

    // 
    static boolean checkScores(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            int score = students.get(i).getScore();
            if (score < 0 || score > 10) {
                System.out.println("Failed" + (i + 1));
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("An", 9),
                new Student("Binh", 6),
                new Student("Chi", 8),
                new Student("Dung", 7));

        System.out.println("Vòng for 1 (for)    : " + goodNamesFor(students));
        System.out.println("Vòng for 1 (Stream) : " + goodNamesStream(students));

        System.out.println("Vòng for 2 (for)    : " + averageFor(students));
        System.out.println("Vòng for 2 (Stream) : " + averageStream(students));

        System.out.println("Dữ liệu hợp lệ?     : " + checkScores(students));

        List<Student> badList = List.of(
                new Student("An", 9),
                new Student("Binh", 15),
                new Student("Chi", 8));
        System.out.println("Dữ liệu lỗi hợp lệ? : " + checkScores(badList));
    }
}