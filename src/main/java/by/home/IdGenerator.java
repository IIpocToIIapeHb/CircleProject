package by.home;

public class IdGenerator {
    private static Integer id = 0;

    public Integer getId(){
        return id++;
    }
}
