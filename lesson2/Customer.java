package lesson2;

import java.util.Objects;

public class Customer {

    private final int id;
    private final String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true; // 1. cùng tham chiếu
        if (o == null || getClass() != o.getClass())
            return false; // 2. null / khác lớp
        Customer other = (Customer) o; // 3. ép kiểu
        return id == other.id // 4. so sánh từng trường quan trọng
                && Objects.equals(name, other.name); // Objects.equals tự xử lý null
    }

}
