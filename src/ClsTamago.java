public class ClsTamago {
    //atributs
    private String name;

    private int energy;
    private int hunger;
    private int happiness;

    private int age;

    private int score;


    //setters 
    public void setScore(int score){
        this.score=score;
    }
    
    public void setAge(int age){
        this.age=age;
    }

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
    public int getScore(){
        return this.score;
    }   

    public int getAge(){
        return this.age;
    }
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
        setAge(0);
    }
    //methodes
    public String growing(){
        if (age > 0 && age < 5) return "Baby";
        else if (age >= 5 && age < 20) return "Childhood";
        else if (age >= 20 && age < 65) return "Adulthood";
        else if (age >= 65 && age < 100) return "Elder";
        else return "Dust";   
    }

    public int scoreTable(int energy, int hunger, int happiness){
        int point=0;
        if (energy>=70){point+=20;}
            else if  (energy>=50){point+=10;}
            else if (energy>=30){point+=0;}
            else {point-=10;}

        if (hunger<=30){point+=20;}
            else if  (hunger<=50){point+=10;}
            else if (hunger<=70){point+=0;}
            else {point-=10;}

        if (happiness>=70){point+=20;}
            else if  (happiness>=50){point+=10;}
            else if (happiness>=30){point+=0;}
            else {point-=10;}
      
        return point;
    }

    public void updScore(){
        int point=scoreTable(getEnergy(), getHunger(), getHappiness());
        this.score+=point;
    }
       
    public void timeLapse(){
        energy-=20;
        hunger+=20;
        happiness-=20;
        age+=1;

        if(energy<0)energy=0;
        if(hunger>100)hunger=100;
        if(happiness<0)happiness=0;

        updScore();
    }


    public void eat(){
        hunger-=20;
        happiness+=10;
        energy+=5;

        if(hunger<0)hunger=0;
        if(happiness>100)happiness=100;
        if(energy>100)energy=100;

        /*System.out.println("ClsTamago func " +getName()+".eat  :OK");*/
        System.out.println("°.O");

    }
    public void sleep(){
        energy+=20;
        hunger+=10;
        happiness+=5;
        

        if(energy>100)energy=100;
        if(hunger>100)hunger=100;
        if(happiness>100)happiness=100;


        /*System.out.println("ClsTamago func " +getName()+".sleep  :OK");*/
        System.out.println("*.+");


    }
    public void play(){
        happiness+=20;
        energy-=10;
        hunger+=5;

        if(hunger<0)hunger=0;
        if(happiness>100)happiness=100;
        if(energy<0)energy=0;
       
        /*System.out.println("ClsTamago func " +getName()+".play  :OK");*/
        System.out.println("<3");


    }

    public Boolean isAlive(){
        if(energy<=0 || hunger>=100 || happiness<=0 || age>=100){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("  YOUR TAMAGOCHI "+getName()+" is DEAD!!.");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            return false;
        }
        return true;
        
    }   

    public void status(){
        /*System.out.println("ClsTamago func " +getName()+".status  :OK");*/
        System.out.println(" Name: "+getName()+" - Age: "+getAge()+" - Periode: "+growing()+ " - Score: "+getScore());
        System.out.println(" Energy: "+getEnergy()+" - Hunger: "+getHunger()+" - Happiness: "+getHappiness());
    }
}
