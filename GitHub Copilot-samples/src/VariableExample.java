public class VariableExample {

    //create static variable, local variable and instance variable and print them
    static int staticVariable = 10; //static variable
    int instanceVariable = 20; //instance variable

    public void printVariables() {
        int localVariable = 30; //local variable
        System.out.println("Static variable: " + staticVariable);
        System.out.println("Instance variable: " + instanceVariable);
        System.out.println("Local variable: " + localVariable);
    }
    public static void main(String[] args) {

        //create object of VariableExample class
        VariableExample obj = new VariableExample();
        obj.printVariables(); //calling method to print variables

        System.out.println("Hello world!");
    }

    //write a method to add to numbers and print them
}