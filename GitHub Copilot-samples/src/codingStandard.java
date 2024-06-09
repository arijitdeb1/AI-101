public class codingStandard {

    public static void main(String[] args) {
        //create object of codingStandard class
        codingStandard obj = new codingStandard();

        //calling method to add 2 numbers
        int sum = obj.Add(10, 20);
        System.out.println("Sum of 2 numbers: " + sum);

        //calling method to subtract 2 numbers
        int difference = obj.Subtract(20, 10);
        System.out.println("Difference of 2 numbers: " + difference);
    }

    //write a function to add 2 integers
    public int Add(int a, int b) {
        return a + b;
    }

    //write a function to subtract 2 integers
    public int Subtract(int a, int b) {
        return a - b;
    }
}
