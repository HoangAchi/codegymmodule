package mylist;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> myarraylist = new MyArrayList<>();
        myarraylist.add("Hoang");
        myarraylist.add("Duc Anh");
        System.out.println("element 0 " + myarraylist.get(0));
        System.out.println("element 1 " + myarraylist.get(1));
        myarraylist.add(1,"Duc");
        System.out.println("element 0 " + myarraylist.get(0));
        System.out.println("element 1 " + myarraylist.get(1));
        System.out.println("element 2 " + myarraylist.get(2));
        myarraylist.remove(0);
        System.out.println("element 0 " + myarraylist.get(0));
        System.out.println("element 1 " + myarraylist.get(1));
        System.out.println("element 2 " + myarraylist.get(2));
    }
}
