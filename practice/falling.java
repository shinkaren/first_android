public class falling {

    public static final int SIZE = 30;
    public static final int SPACE_SIZE = 100;
    public static final int NUM_PERCENTAGE = 30;
    static int [] [] screen = new int [SIZE][SIZE];
    
    public static void init() {
	int i = 0;
	int j = 0;
	for (i=0;i<SIZE;i++)
	    for(j=0;j<SIZE;j++)
		screen[i][j]=0;
    }
	
    public static void print(){
	int i = 0;
	int j = 0;
	
	for (i=0;i<SIZE;i++){
	    System.out.println("");
	    for(j=0;j<SIZE;j++)
		System.out.print(screen[i][j] + " ");
	}
    }

    public static void print_spaces(){
	int i=0;
	for(i=0;i<SPACE_SIZE;i++)
	    System.out.println("");
    }

    public static void  next_screen (int[] new_top){
	int i= SIZE - 1;
	int j = 0;
	for (;0<=i;i--){

	    if(i == 0){
		for(j=0;j<SIZE;j++){
		    screen[i][j]=new_top[j];
		}
	    }
	    else{
		
		for(j=0;j<SIZE;j++)
		    screen[i][j]=screen[i-1][j];
	    }
	}
    }
    
    
    public static int[] make_newtop(){
	int[] array = new int[SIZE];
	int i=0;
	for(i=0;i<SIZE;i++){
	    int random_num =new java.util.Random().nextInt(99);
	    if(random_num<NUM_PERCENTAGE)
		array[i] = new java.util.Random().nextInt(9);
	    else
		array[i] = 0;
	}
	
	return array;
    }
    
    
    
	
			    
    public static void main(String[] args) {
	
	init();
	int[] top_array = new int[SIZE];

	
	while(true){
	    /*wait enter*/
	    String dummy = new java.util.Scanner(System.in).nextLine();
	    
	    print_spaces();
	    
	    top_array = make_newtop();

	    next_screen(top_array);

	    print();
	}

    }
	    
}
