package Problem1;

public class DemoMultiStackArray {
    public static void main(String[] args) {
        //creating new MultiStackArray object
        MultiStackArray multiStackArray = new  MultiStackArray(20);


        //pushing some random keys
        multiStackArray.push(0,90);
        multiStackArray.push(0, 12);


        multiStackArray.push(1, 43);
        multiStackArray.push(1, 43);

        multiStackArray.push(2, 23);


        multiStackArray.push(3, 32);
        multiStackArray.push(3, 9);

        //displaying values from array

        multiStackArray.displayValues();
    }
}
