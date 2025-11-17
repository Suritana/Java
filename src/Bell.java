public class Bell {
    private boolean counter = true;

    void doBell(){
        if (counter==true){
            System.out.println("ding");
            counter=false;
        }
        else{
            System.out.println(("dong"));
            counter=true;
        }

    }


}
