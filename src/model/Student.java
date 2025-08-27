package model;

public class Student {
    private String id;
    private String name;
    private int age;

    public Student(String name, String id, int age) {
        try {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty :(");
            }
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("ID cannot be null or empty :(");
            }
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative :(");
            }

            this.name = name;
            this.id = id;
            this.age = age;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating Student: " + e.getMessage());
            this.name = "Unknown";
            this.id = "0000";
            this.age = 0;
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
