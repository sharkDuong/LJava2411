package baiktModulle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private List<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi sinh viên: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập mã sinh viên: ");
        String studentId = scanner.nextLine();

        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                System.out.println("Mã sinh viên đã tồn tại, không thể thêm sinh viên.");
                return;
            }
        }
        students.add(new Student(name, age, studentId));
        System.out.println("Sinh viên đã được thêm vào danh sách.");
    }

    public void editStudent() {
        System.out.print("Nhập mã sinh viên cần chỉnh sửa: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);

        if (student == null) {
            System.out.println("Không tìm thấy sinh viên với mã " + studentId + ".");
        } else {
            System.out.println("Thông tin sinh viên hiện tại:\n" + student);
            System.out.print("Nhập tên sinh viên chỉnh sửa: ");
            student.setName(scanner.nextLine());
            System.out.print("Nhập tuổi sinh viên chỉnh sửa: ");
            student.setAge(Integer.parseInt(scanner.nextLine()));
            System.out.print("Nhập mã sinh viên chỉnh sửa: ");
            student.setStudentId(scanner.nextLine());
            System.out.println("Thông tin sinh viên đã được cập nhật.");
        }
    }

    public void deleteStudent() {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);

        if (student == null) {
            System.out.println("Không tìm thấy sinh viên với mã " + studentId + ".");
        } else {
            students.remove(student);
            System.out.println("Sinh viên đã được xóa khỏi danh sách.");
        }
    }

    public void searchStudentByName() {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String name = scanner.nextLine();
        List<Student> results = new ArrayList<>();

        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                results.add(s);
            }
        }

        if (results.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên nào có tên " + name + ".");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (Student s : results) {
                System.out.println(s);
            }
        }
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên hiện đang trống.");
        } else {
            System.out.println("Danh sách sinh viên hiện tại:");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\nMenu Quản Lý Danh Sách Sinh Viên");
            System.out.println("1. Thêm sinh viên vào danh sách.");
            System.out.println("2. Sửa thông tin sinh viên.");
            System.out.println("3. Xóa sinh viên khỏi danh sách.");
            System.out.println("4. Tìm kiếm sinh viên theo tên.");
            System.out.println("5. Hiển thị danh sách sinh viên.");
            System.out.println("6. Thoát.");

            System.out.print("Nhập lựa chọn của bạn: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    editStudent();
                    break;
                case "3":
                    deleteStudent();
                    break;
                case "4":
                    searchStudentByName();
                    break;
                case "5":
                    displayStudents();
                    break;
                case "6":
                    System.out.println("Đã thoát khỏi chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    private Student findStudentById(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }
}


