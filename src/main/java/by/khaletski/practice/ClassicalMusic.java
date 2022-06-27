package by.khaletski.practice;

public class ClassicalMusic implements Music {

    // The private constructor does not allow to create an object using the keyword "new"
    private ClassicalMusic() {}

    // Factory method pattern
    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }

    public void doMyInit() {
        System.out.println("Doing my initialization");
    }

    public void doMyDestroy() {
        System.out.println("Doing my destruction");
    }
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
