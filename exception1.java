class exception {
        public static void main(String arg[])
        {
            try{
                try{
                    int a=10/0;
                    System.out.println("try block 1");
                }
                catch(ArithmeticException e)
                {
                    System.out.println(e);
                }
            }
            catch(Exception e)
            {
                System.out.println("Exception handle in main block");
            }
        }                                
}
