package com.slz.javalearing.day16;

import java.io.*;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/27
 */
public class TestExternalizable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Hero hero = new Hero("曹操", 5000, 10);
        // 序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(".\\javabase\\resource\\obj.h"));
        objectOutputStream.writeObject(hero);
        objectOutputStream.close();
        // 反序列化
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(".\\javabase\\resource\\obj.h"));
        Hero h = (Hero) objectInputStream.readObject();
        System.out.println(h);
    }
}

class Hero implements Externalizable {
    private static final long serialVersionUID = 6182993074377375044L;
    private static String test;
    public String name;
    public Integer blood;
    public transient Integer buff;

    public Hero() { // Externalizable 序列化会调用无参构造，若无参构造不存在会报错
        System.out.println("调用无参构造");
    }

    public Hero(String name, Integer blood, Integer buff) {
        this.name = name;
        this.blood = blood;
        this.buff = buff;
        System.out.println("调用有参构造");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException { // Externalizable 序列化字段自己控制，不受限于 static 和 transient
        out.writeUTF(name);
        out.writeInt(blood);
        out.writeInt(buff);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException { // Externalizable 序列化字段自己控制，不受限于 static 和 transient
        name = in.readUTF();
        blood = in.readInt();
        buff = in.readInt();
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", blood=" + blood +
                ", buff=" + buff +
                '}';
    }
}