package Entity;

public class Subject
{
    private int id;
    private String subName;

    public Subject() {
    }

    public Subject(int id, String subName) {
        this.id = id;
        this.subName = subName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }
}
