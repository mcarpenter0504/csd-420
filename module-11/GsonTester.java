// Resource - https://www.tutorialspoint.com/gson/gson_quick_guide.htm

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}

public class GsonTester {
    public static void main(String[] args) {

        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        // Convert JSON to Java object
        Student student = gson.fromJson(jsonString, Student.class);
        System.out.println(student);

        // Convert Java object back to JSON
        jsonString = gson.toJson(student);
        System.out.println(jsonString);
    }
}