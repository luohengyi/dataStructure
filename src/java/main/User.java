package main;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/10/29
 * Time: 10:32 下午
 */
public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
