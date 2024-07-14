class Animal {
    public void makeSound() {
        System.out.println("Animal is making a sound.");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

class Tiger extends Cat {
    @Override
    public void makeSound() {
        System.out.println("hahaha!");
    }
}
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
    public static void main(String[] args) {
        Animal animal1 = new Cat();  // Upcasting
        Animal animal2 = new Dog();  // Upcasting
        Animal obj=new Tiger();
        animal1.makeSound();  // Output: Meow!
        animal2.makeSound();// Output: Woof!
        obj.makeSound();  //here the the subclass method is called with the super class's object
    }
}


