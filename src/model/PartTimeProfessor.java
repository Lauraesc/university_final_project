package model;

public class PartTimeProfessor extends Professor {
    private int hoursPerWeek;

    public PartTimeProfessor(String name, double bSalary, int eYears, int hoursPerWeek) {
        super(name, bSalary, eYears);
        try {
            if (hoursPerWeek <= 0 || hoursPerWeek > 40) {
                throw new IllegalArgumentException("The hours per week must be between 1 and 40 :o");
            }
            this.hoursPerWeek = hoursPerWeek;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating PartTimeProfessor: " + e.getMessage());
            this.hoursPerWeek = 0; //hours per default
        }
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    @Override
    public double calculateSalary() {
        try {
            return getBaseSalary() * ((double) hoursPerWeek / 40);
        } catch (Exception e) {
            System.out.println("Error calculating salary for PartTimeProfessor: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public String toString() {
        return "PartTimeProfessor{" +
                "name='" + getName() + '\'' +
                ", baseSalary=" + getBaseSalary() +
                ", experienceYears=" + getExperienceYears() +
                ", hoursPerWeek=" + hoursPerWeek +
                ", finalSalary=" + calculateSalary() +
                '}';
    }
}
