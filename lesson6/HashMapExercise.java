package lesson6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapExercise {
    public static void main(String[] args) {

        // • Đếm tần suất từ trong một đoạn văn bằng merge
        // • Nhóm nhân viên theo phòng ban bằng computeIfAbsent

        String[] words = { "tea", "mango", "tea", "not", "tea", "mango" };

        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.merge(w, 1, Integer::sum);
        }
        System.out.println(freq);

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Tea", "IT"));
        employees.add(new Employee("Mango", "IT"));
        employees.add(new Employee("Dung", "HR"));
        employees.add(new Employee("MPA", "IT"));

        Map<String, List<String>> byDept = new HashMap<>();
        for (Employee e : employees) {
            byDept.computeIfAbsent(e.department, d -> new ArrayList<>()).add(e.name);

        }
        System.out.println(byDept);

        // System.out.println("\"C01\".hashCode() = " + "C01".hashCode());
        // System.out.println("\"C01\".hashCode() = " + "C01".hashCode());
        // System.out.println("\"C02\".hashCode() = " + "C02".hashCode());
        // System.out.println("Integer 42 = " + Integer.valueOf(42).hashCode());

        CustomerData customerData1 = new CustomerData(1, "null");
        CustomerData customerData2 = new CustomerData(1, "null");
        System.out.println("customerData1.hashCode()      = " + customerData1.hashCode());
        System.out.println("customerData2.hashCode()      = " + customerData2.hashCode());

        Map<CustomerData, String> map1 = new HashMap<>();
        map1.put(customerData1, "VIP");
        System.out.println("map1.get(customerData1) = " + map1.get(customerData2));

        CustomerDataWithOverride customerDataOverride1 = new CustomerDataWithOverride(1, "null");
        CustomerDataWithOverride customerDataOverride2 = new CustomerDataWithOverride(1, "null");

        Map<CustomerDataWithOverride, String> map2 = new HashMap<>();
        map2.put(customerDataOverride1, "TEA");
        System.out.println("map2.get(customerDataOverride2 = " + map2.get(customerDataOverride2));

    }

}

class CustomerData {

    private final int id;
    private final String name;

    public CustomerData(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
}

class CustomerDataWithOverride {
    private final int id;
    private final String name;

    public CustomerDataWithOverride(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        CustomerDataWithOverride other = (CustomerDataWithOverride) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
