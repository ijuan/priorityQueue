import java.util.Scanner;
import java.security.DrbgParameters.NextBytes;
import java.util.PriorityQueue;

class Main {
    
  public static void main(String[] args) {
    System.out.println("Hello world!");
                //Datatype specifier... what's gonna be in the priority queue??
    PriorityQueue<Person> q = new PriorityQueue<Person>();

    Person pablo = new Person(5,"Pablo",0.0);
    Person KingHotdog = new Person(1,"Sir Hotdog", 1.1);
    Person ButterDog = new Person(609,"Budda dog", 91.8);

    //now its time to add in our persons to the queue
    addToQueue(pablo, q);
    addToQueue(ButterDog, q);
    addToQueue(KingHotdog, q);
    addToQueue(KingHotdog, q);
    printQueueMenu(q);
    Scanner e = new Scanner(System.in);
    int u = getOperator(e,0,5);
   
    while (true) {
      if (u == 4) {
        break;
     }
    operationpotat(q, u);
    printQueueMenu(q);
    u = getOperator(e,0,5);
    
    }
    System.out.println("I hope you enjoyed your stay...GoodBYE!");
  }
  public static int getOperator(Scanner o, int min, int max) {
    int a = 0;
    boolean invalid = false;
    do{
    
    
    while (!o.hasNextInt()){
    o.nextLine();
    System.out.println("Hey! Give me a number!!");
    System.out.print(": ");
    }
    a = o.nextInt();
    if (a >= max || a <= min) {
      invalid = true;
      System.out.println("Hey! You gave me the wrong number!");
      System.out.print(": ");
    }
    else {
      invalid = false;
    }
  } while(invalid);
    return a;
  }
  
  public static void operationpotat(PriorityQueue<Person> q, int o) {
    if(o == 1) {
      q.poll();
    }
    else if (o == 2){
      Object [] ar = q.toArray(); // creates and sets toArray to the variable ar...
      System.out.println("Who do you want to remove...\n");
      for (int i = 0; i < ar.length; i++) {
        System.out.print(i); 
        System.out.println(") " + ar[i].toString()); 
      }
      int mnm = getOperator(new Scanner(System.in), 0, q.size());
      
     if(q.remove(ar[mnm])){
       System.out.println("It worked!");
     }
     else{
       System.out.println("It don't work D:");
     }
    }
    else {
      Scanner ScannerIn = new Scanner (System.in);
      System.out.println("Please Print Out Your Name:");
      String popeyes = ScannerIn.nextLine();
      System.out.println("Hey! What's your rank?!");
      int rrrank = ScannerIn.nextInt();
      System.out.println("Are you a hotdog? Please tell me what % you are...");
      double dog = ScannerIn.nextDouble();
      Person plood = new Person(rrrank, popeyes, dog);
      addToQueue(plood, q);
    }
  }
  public static void printQueueMenu(PriorityQueue<Person> q) {
    //Print out the entirety of the queue, and then poll....
    // q.toArray(); --> Person []
    // for (int i = 0; i < q.toArray().length; i++)
      // q.toArray()[i]; Why we sometimes want a middleman....
    Object [] ar = q.toArray(); // creates and sets toArray to the variable ar...
    System.out.println("Here is the menu...\n");
    for (int i = 0; i < ar.length; i++) {
        System.out.println(ar[i].toString()); //Which means any object gets the toString...
    }
    //poll "1) poll"
    System.out.println("1) Pulling you into the party!");
    //remove a random person from queue
    System.out.println("2) Grab a random person and throw them to this party.");
    //add a random Person that we made
    System.out.println("3) add a innocent bystander to the queue");
    System.out.println("4) Stop the program");
    System.out.print(": ");

  }


  public static void addToQueue(Person p, PriorityQueue<Person> q ) {
    //make sure that person to be added, is not already in the priority queue....

    //contains takes in a object to see if its in the queue
    //returns a true or false
    //boolean inQueue =  false;
            //True or False
    //inQueue = q.contains(p);

    if (q.contains(p) == true) {
      System.out.println("Already in queue skipping. There's an impasta here.");
    }
    else{

      System.out.println("Adding to queue....");
      System.out.println(p.toString());
      
      //q.add returns a true or false depending on if the add function worked on not...
      // if q.add works let us know that the add was successful
      //otherwise tell us that it failed

      if ( q.add(p) == true ) {
        System.out.println("The add was successful!");
      } else {
        System.out.println("The queue was unsuccessful, please call 295-HOT-DOGS.");
      }
    }
  }


}

