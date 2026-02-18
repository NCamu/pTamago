public class ClsTamago {
    //atributs
    private String name;
    private int energy;
    private int hunger;
    private int happiness;


    //setters  
    public void setEnergy(int energy){
        this.energy=energy;
    }
    public void setHunger(int hunger){
        this.hunger=hunger;
    }
    public void setHappiness(int happiness){
        this.happiness=happiness;
    }
    public void setName(String name){
        this.name=name;
    }

    
    //getters
    public int getEnergy(){
        return this.energy;
    }
    public int getHunger(){
        return this.hunger;
    }
    public int getHappiness(){
        return this.happiness;
    }
    public String getName(){
        return this.name;
    }
    //constructeurs
    public ClsTamago(String name){
        setName(name);
        setEnergy(100);
        setHunger(0);
        setHappiness(100);
    }
    //methodes
    public Boolean isAlive(){
        if(energy<=0 || hunger>=100 || happiness<=0){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("  YOUR TAMAGOCHI "+getName()+" is DEAD!!.");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            return false;
        }
        return true;
        
    }   

    public void timeLapse(){
        energy-=5;
        hunger+=5;
        happiness-=5;

        if(energy<0)energy=0;
        if(hunger>100)hunger=100;
        if(happiness<0)happiness=0;

        /*System.out.println("ClsTamago func " +getName()+".timeLapse  :OK");*/

    }


    public void eat(){
        hunger-=10;
        happiness+=5;
        energy+=5;

        if(hunger<0)hunger=0;
        if(happiness>100)happiness=100;
        if(energy>100)energy=100;

        /*System.out.println("ClsTamago func " +getName()+".eat  :OK");*/
        System.out.println("°.O");

    }
    public void sleep(){
        energy+=10;
        hunger+=5;
        happiness+=5;

        if(energy>100)energy=100;
        if(hunger>100)hunger=100;
        if(happiness>100)happiness=100;


        /*System.out.println("ClsTamago func " +getName()+".sleep  :OK");*/
        System.out.println("*.+");


    }
    public void play(){
        happiness+=10;
        energy-=5;
        hunger+=5;

        if(hunger<0)hunger=0;
        if(happiness>100)happiness=100;
        if(energy<0)energy=0;
       
        /*System.out.println("ClsTamago func " +getName()+".play  :OK");*/
        System.out.println("<3");


    }


    public void status(){
        /*System.out.println("ClsTamago func " +getName()+".status  :OK");*/
        System.out.println(" Name: "+getName()+" Energy: "+getEnergy()+" Hunger: "+getHunger()+" Happiness: "+getHappiness());
    }
}
