public class TestLength {

    public static void main(String[] args) {
        Length myLength = new Length(10,6);
        System.out.println(myLength.toString());

    Length length1 = new Length(10,5);
    Length length2 = new Length(5,10);

    System.out.println(length1.toString());
    System.out.println(length2.toString());

    Length length3 = new Length();

    length3 = length1.add(length2);
    System.out.println(length1.toString() + " + " + length2.toString() + " = " + length3.toString());

    Length length4 = new Length();
    length4 = length1.subtract(length2);
    System.out.println(length1.toString() + " - " + length2.toString() + " = " + length4.toString());
}
}