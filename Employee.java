package home.work;

public class Employee {

    private String nameone;
    private String nametwo;
    private String email;
    private String phonenumber;
    private String position;
    private int age;
    private int the_salary;


    public Employee(String nameone, String nametwo, String email, String phonenumber, String position, int age, int the_salary) {
        this.nameone = nameone;
        this.nametwo = nametwo;
        this.email = email;
        this.phonenumber = phonenumber;
        this.position = position;
        this.age = age;
        this.the_salary = the_salary;
    }

    public void printinfo() {
        System.out.println(this);
    }

    public String getNameone() {
        return nameone;
    }

    public void setNameone(String nameone) {
        this.nameone = nameone;
    }

    public String getNametwo() {
        return nametwo;
    }

    public void setNametwo(String nametwo) {
        this.nametwo = nametwo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getThe_salary() {
        return the_salary;
    }

    public void setThe_salary(int the_salary) {
        this.the_salary = the_salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nameone='" + nameone + '\'' +
                ", nametwo='" + nametwo + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", the_salary=" + the_salary +
                '}';
    }
}
