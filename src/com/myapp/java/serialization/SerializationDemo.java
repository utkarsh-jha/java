package com.myapp.java.serialization;

import com.myapp.java.common.domain.Student;

import java.io.*;

public class SerializationDemo {
    static void serialize() throws FileNotFoundException, IOException {
        Student s = new Student("raghav", 10);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("f.txt"));
        oos.writeObject(s);
        oos.flush();
        oos.close();
    }



    static void deSerialize() throws IOException, ClassNotFoundException {
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream("f.txt"));) {
            Student s = (Student) oin.readObject();
            System.out.println(s);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("EXECUTING");
//            serialize();
            deSerialize();
            System.out.println("EXECUTION COMPLETE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
