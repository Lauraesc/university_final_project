package model;

public abstract class Professor {
    private String name;
    private double bSalary;
    private int eYears;

    /*"each teacher has a name, years of experience and
    a salary calculated by the following rules" */
    public Professor(String name, double bSalary, int eYears) {
        try {
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("The Name cannot be null or empty :(");
            }
            if (bSalary < 0) {
                throw new IllegalArgumentException("Base salary cannot be negative :(");
            }
            if (eYears < 0) {
                throw new IllegalArgumentException("Experience years cannot be negative :(");
            }

            this.name = name;
            this.bSalary = bSalary;
            this.eYears = eYears;

        } catch (IllegalArgumentException e) {
            System.out.println("Error creating Professor: " + e.getMessage());
            //these are the default values if invalid input
            this.name = "Unknown";
            this.bSalary = 0;
            this.eYears = 0;
        }
    }

    //polymorphic method: each subclass implements differently
    public abstract double calculateSalary();

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return bSalary;
    }

    public int getExperienceYears() {
        return eYears;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", baseSalary=" + bSalary +
                ", experienceYears=" + eYears +
                ", finalSalary=" + calculateSalary() +
                '}';
    }
}
