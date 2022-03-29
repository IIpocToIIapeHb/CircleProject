package by.home;

public class IdGenerator {
    private static Integer id;

    public Integer getId(){
        return id++;
    }
}
