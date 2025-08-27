package model;

public class FullTimeProfessor extends Professor {

    public FullTimeProfessor(String name, double bSalary, int eYears) {
        super(name, bSalary, eYears);
    }

    @Override
    public double calculateSalary() {
        try {
            //for full time p, the base salary + 10% of base salary for each year of experience
            return getBaseSalary() + (getBaseSalary() * 0.1 * getExperienceYears());
        } catch (Exception e) {
            System.out.println("There was an error calculating salary for FullTimeProfessor: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public String toString() {
        return "FullTimeProfessor{" +
                "name='" + getName() + '\'' +
                ", baseSalary=" + getBaseSalary() +
                ", experienceYears=" + getExperienceYears() +
                ", finalSalary=" + calculateSalary() +
                '}';
    }
}
