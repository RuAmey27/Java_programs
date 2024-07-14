class Superclass {
    void superClassMethod() {
        System.out.println("Superclass method called");
    }
}

class Subclass extends Superclass {
    void subClassMethod() {
        System.out.println("Subclass method called");
    }
}

class Main1 {
    public static void main(String[] args) {
        Superclass superObj = new Subclass();

        // Downcast the object to Subclass type
        Subclass subObj = (Subclass) superObj;

        // Access the methods of Subclass
        subObj.subClassMethod();
        subObj.superClassMethod();
    }
}