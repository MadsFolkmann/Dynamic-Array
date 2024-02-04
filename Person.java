
public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;

  public Person() {}

    public Person(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    public Person(String fullName) {
        setFullName(fullName);
    }

    public Person(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Person(String firstName, int age) {
        this(firstName, null, null, age);
    }

    public Person(String firstName, String lastName, int age) {
        this(firstName, null, lastName, age);
    }

    public Person(String firstName, String middleName, String lastName, int age) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(Person otherPerson) {
        this.firstName = otherPerson.firstName;
        this.middleName = otherPerson.middleName;
        this.lastName = otherPerson.lastName;
        this.age = otherPerson.age;
    }

    public String toString() {
        return firstName + " " + lastName + ", age:" + age;
    }

    public String getMiddleName() {
        return middleName;
    }
    
    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }

    public boolean hasMiddleName(){
        return middleName != null;
    }
    
    public String getFullName(){
        if(hasMiddleName()) {
        return firstName + " " + middleName + " " + lastName;
        } else{
        return firstName + " " + lastName;
        }
    }

    public void setFullName(String fullName){
        String[] parts = fullName.split(" ");
        firstName = parts[0];
         lastName = parts[parts.length - 1];

        if (parts.length > 1){
        middleName = parts[1];
        } else {
        middleName = null;
        }

    }


}