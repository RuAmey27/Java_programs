class Student{  
    int id;  
    String name; 
    void print(){
        System.out.println(id+" "+name);//the method uses object as source of information
    } 
   }  
   class TestStudent2{  
    public static void main(String args[]){  
     Student s1=new Student();  
     s1.id=101;  
     s1.name="Sonoo";  
     s1.print();//printing members with a white space  
    }  
   }  