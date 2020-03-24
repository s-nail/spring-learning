package com.mine.jna;//package com.sun.jna;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Structure;
import com.sun.jna.WString;


public class TestDll1Service {

    /*
     * 定义一个类，模拟C语言的结构
     *
     */

    public static class UserStruct extends Structure {

        public static class ByReference extends UserStruct implements Structure.ByReference {
            public ByReference() {
            }
            //public ByReference(Pointer p){ super(p);}
        }

        public static class ByValue extends UserStruct implements Structure.ByValue {
            public ByValue() {
            }
            //public ByValue(Pointer p) { super(p);}
        }

        public NativeLong id;
        public WString name;
        public int age;

        // 字段顺序与SO中结构体声明一致
        @Override
        protected List getFieldOrder() {
            return Arrays.asList(new String[]{
                    "id", "name", "age"
            });
        }
    }

    public static class CompanyStruct extends Structure {
        public static class ByReference extends CompanyStruct implements Structure.ByReference {
            public ByReference() {
            }
            //public ByReference(Pointer p){ super(p);}
        }

        public static class ByValue extends CompanyStruct implements Structure.ByValue {
            public ByValue() {
            }
            //public ByValue(Pointer p) { super(p);}
        }

        public NativeLong id;
        public WString name;
        // 嵌套的结构体数组,下面三种声明都可以，注意每种声明的赋值方式        
        // Declare 1
        // public UserStruct[] users = (UserStruct[])new UserStruct().toArray(100);
        // Declare 2
        // public UserStruct.ByValue[] users = new UserStruct.ByValue[100]; 
        // Declare 3
        public UserStruct[] users = new UserStruct[100];
        public int count;
        @Override
        protected List getFieldOrder() {
            return Arrays.asList(new String[]{
                    "id", "name", "users", "count"
            });
        }


    }

    public static class CompanyStruct2 extends Structure {
        public static class ByReference extends CompanyStruct2 implements Structure.ByReference {
            public ByReference() {
            }
            //public ByReference(Pointer p){ super(p);}
        }

        public static class ByValue extends CompanyStruct2 implements Structure.ByValue {
            public ByValue() {
            }
            //public ByReference(Pointer p){ super(p);}
        }

        public NativeLong id;
        public WString name;
        // 嵌套的结构体指针数组
        public UserStruct.ByReference[] users = new UserStruct.ByReference[100];
        public int count;
        @Override
        protected List getFieldOrder() {
            return Arrays.asList(new String[]{
                    "id", "name", "users", "count"
            });
        }


    }

    public static class NestedStruct extends Structure {
        public static class ByValue extends NestedStruct implements Structure.ByValue {
        }

        // 声明内存对齐方式，与SO中声明的结构体对齐保持一致
        public NestedStruct() {
            super(ALIGN_NONE);
        }

        // 注意C/C++中的char 对应java中的byte,其它类型之间的映射请参考官方文档
        public byte pwd[] = new byte[16];
        public byte key[] = new byte[16];
        public byte padding[] = new byte[113];
        @Override
        protected List getFieldOrder() {
            return Arrays.asList(new String[]{
                    "pwd", "key", "padding"});
        }
    }

    public static class SimpleStruct extends Structure {
        public static class ByReference extends SimpleStruct implements Structure.ByReference {
        }

        public NestedStruct.ByValue nested = new NestedStruct.ByValue();
        public int a;
        public byte b;
        public int c;
        public int d;
        public byte name[] = new byte[100];

        public SimpleStruct() {
            super(ALIGN_NONE);
        }

        @Override
        protected List getFieldOrder() {
            return Arrays.asList(new String[]{
                    "nested", "a", "b", "c", "d", "name"
            });
        }
    }


    public interface TestDll1 extends Library {
        /**
         * 当前路径是在项目下，而不是bin输出目录下。
         */
        TestDll1 INSTANCE = (TestDll1) Native.load("D:\\logs\\TestDll1", TestDll1.class);


        public void say(WString value);


        public void sayUser(UserStruct.ByReference struct);


        public void sayCompany(CompanyStruct.ByReference pCompanyStruct);

        public void sayCompany2(CompanyStruct2.ByReference pCompanyStruct);

        //public void getCompany(TestStruct.ByReference pCompanyStruct);
        public void getSimpleStruct(SimpleStruct simp);

        public void getSimpleStruct(SimpleStruct.ByReference simp);

        public void saySimpleStruct(SimpleStruct simp);

    }

    public class TestClass {
        int a;
        int b;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        TestDll1.INSTANCE.say(new WString("Hello World!"));
        System.out.println("HHEEH中文");


        UserStruct.ByReference userStruct = new UserStruct.ByReference();
        userStruct.id = new NativeLong(100);
        userStruct.age = 30;
        userStruct.name = new WString("yifan");
        TestDll1.INSTANCE.sayUser(userStruct);
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");

        CompanyStruct.ByReference companyStruct = new CompanyStruct.ByReference();
        companyStruct.id = new NativeLong(1);
        companyStruct.name = new WString("Google");
        companyStruct.count = 9;
        System.out.println("UserStruct size = " + userStruct.size());
        System.out.println("TestStruct size = " + companyStruct.size());
        for (int i = 0; i < companyStruct.count; i++) {
           /*
            * Declare 1
           companyStruct.users[i].id = new NativeLong(i);
           companyStruct.users[i].name = new WString("yifan" + i);
           companyStruct.users[i].age = 20 + i;
           */
           /*
            * Declare 2
           UserStruct.ByValue user = new UserStruct.ByValue();
           user.id = new NativeLong(i + 1);
           user.name = new WString("yifan" + i);
           user.age = 20 + i;
           companyStruct.users[i] = user;
           */
            /*
             * Declare 3
             */
            UserStruct user2 = new UserStruct();
            user2.id = new NativeLong(i);
            user2.name = new WString("yifan " + i);
            user2.age = 20 + i;
            companyStruct.users[i] = user2;
        }
        TestDll1.INSTANCE.sayCompany(companyStruct);

        System.out.println("++++++++++++++");

        CompanyStruct2.ByReference companyStruct2 = new CompanyStruct2.ByReference();
        companyStruct2.id = new NativeLong(2);
        companyStruct2.name = new WString("Yahoo");
        companyStruct2.count = 10;
        System.out.println("CompanyStruct2 size = " + companyStruct2.size());
        for (int i = 0; i < companyStruct2.count; i++) {
            companyStruct2.users[i] = new UserStruct.ByReference();
            companyStruct2.users[i].id = new NativeLong(i);
            companyStruct2.users[i].name = new WString("Yahoo user" + i);
            companyStruct2.users[i].age = 20 + i;
        }
        //companyStruct.write(); 
        TestDll1.INSTANCE.sayCompany2(companyStruct2);

        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCC");
        SimpleStruct.ByReference simple = new SimpleStruct.ByReference();
        TestDll1.INSTANCE.getSimpleStruct(simple);
        System.out.println("simple: size = " + simple.size());
        System.out.println("simple: a = " + simple.a);
        System.out.println("simple: b = " + simple.b);
        System.out.println("simple: c = " + simple.c);
        System.out.println("simple: d = " + simple.d);
        System.out.println("simple: name = " + new String(simple.name));
        System.out.println("simple: nested: pwd = " + new String(simple.nested.pwd));
        System.out.println("simple: nested: key = " + new String(simple.nested.key));
        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");

        SimpleStruct simp2 = new SimpleStruct();
        byte[] pwd = "simp2_pwd".getBytes();
        byte[] key = "simp2_key".getBytes();
        byte[] name = "simp2".getBytes();
        simp2.a = 5;
        simp2.b = 6;
        simp2.c = 7;
        simp2.d = 8;
        //
        // 对于已经声明大小的数组，使用下面数组赋值方式，
        // 不要使用simp2.nested.pwd = "11".getBytes() 这种赋值方式
        // 

        System.arraycopy(name, 0, simp2.name, 0, name.length);
        System.arraycopy(pwd, 0, simp2.nested.pwd, 0, pwd.length);
        System.arraycopy(key, 0, simp2.nested.key, 0, key.length);
        TestDll1.INSTANCE.saySimpleStruct(simp2);
        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEE");

    }

}