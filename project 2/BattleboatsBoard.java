import java.util.Scanner;

public class BattleboatsBoard {
    Scanner scanner= new Scanner(System.in);
    private int row;
    private int col;
    private int [][] board;
    private boolean horizontal;
    private boolean vertical;
    private int x;
    private int y;

    private int mode;
    private String [][] demoBoard;
    private int turnCount=0;
    private String [][] rawboard;

    private int droneUsed;

    public BattleboatsBoard(int mode) {
        this.mode=mode;
        if(mode==1){
            this.row=8;
            this.col=8;
            board= new int [row][col];
            placeBoats();
        }
        else if(mode==2){
            this.row=12;
            this.col=12;
            board= new int [row][col];
            placeBoats();
        }
        demoBoard= new String[row][col];
        for(int i=0; i< row; i++){
            for(int j=0; j<col; j++){
                demoBoard[i][j]="_";
            }
        }
    }
    public void placeBoats(){
        if (mode == 1){ 
            //1st boat, length 5
            boolean setBoat= false;
            if((int) (Math.random()*((7)+1)+0)%2==0){
                vertical= true;
                horizontal= false;
            }
            else{
                vertical= false;
                horizontal= true;
            }
            while (!setBoat){
                x=(int) (Math.random()*((7)+1)+0);
                y=(int) (Math.random()*((7)+1)+0);
                String s = 5 + "";
                if(vertical){
                    if(board[x][y]==0 && y+4<=7 && board[x][y+1]==0 && board[x][y+2]==0 && board[x][y+3]==0 && board[x][y+4]==0){
                        board[x][y]=1;
                        board[x][y+1]=1;
                        board[x][y+2]=1;
                        board[x][y+3]=1;
                        board[x][y+4]=1;
                        //String s = 5 + "";
                        rawboard[x][y]=s;
                        rawboard[x][y+1]=s;
                        rawboard[x][y+2]=s;
                        rawboard[x][y+3]=s;
                        rawboard[x][y+4]=s;
                        setBoat= true;
                    }
                }
                else {
                    if(board[x][y]==0 && x+4<=7 && board[x+1][y]==0 && board[x+2][y]==0 && board[x+3][y]==0 && board[x+4][y]==0){
                        board[x][y]=1;
                        board[x+1][y]=1;
                        board[x+2][y]=1;
                        board[x+3][y]=1;
                        board[x+4][y]=1;
                        //String s = 5 + "";
                        rawboard[x][y]= s;
                        rawboard[x][y+1]=s;
                        rawboard[x][y+2]=s;
                        rawboard[x][y+3]=s;
                        rawboard[x][y+4]=s;
                        setBoat= true;
                    }
                }
            }
            //2nd boat. length 4
            setBoat= false;
            if((int) (Math.random()*((7)+1)+0)%2==0){
                vertical= true;
                horizontal= false;
            }
            else{
                vertical= false;
                horizontal= true;
            }
            while (!setBoat){
                x=(int) (Math.random()*((7)+1)+0);
                y=(int) (Math.random()*((7)+1)+0);
                if(vertical){
                    if(board[x][y]==0 && y+3<=7 && board[x][y+1]==0 && board[x][y+2]==0 && board[x][y+3]==0 ){
                        board[x][y]=1;
                        board[x][y+1]=1;
                        board[x][y+2]=1;
                        board[x][y+3]=1;
                        String s = 4 + "";
                        rawboard[x][y]=s;
                        rawboard[x][y+1]=s;
                        rawboard[x][y+2]=s;
                        rawboard[x][y+3]=s;
                        setBoat= true;
                    }
                }
                else {
                    if(board[x][y]==0 && x+3<=7 && board[x+1][y]==0 && board[x+2][y]==0 && board[x+3][y]==0){
                        board[x][y]=1;
                        board[x+1][y]=1;
                        board[x+2][y]=1;
                        board[x+3][y]=1;
                        String s = 4 + "";
                        rawboard[x][y]=s;
                        rawboard[x][y+1]=s;
                        rawboard[x][y+2]=s;
                        rawboard[x][y+3]=s;
                        setBoat= true;
                    }
                }
            }
            //3rd and 4th boat(2), length 3
            for(int i=0; i<2; i++){
                setBoat= false;
                if((int) (Math.random()*((7)+1)+0)%2==0){
                    vertical= true;
                    horizontal= false;
                }
                else{
                    vertical= false;
                    horizontal= true;
                }
                while (!setBoat){
                    x=(int) (Math.random()*((7)+1)+0);
                    y=(int) (Math.random()*((7)+1)+0);
                    if(vertical){
                        if(board[x][y]==0 && y+2<=7 && board[x][y+1]==0 && board[x][y+2]==0 ){
                            board[x][y]=1;
                            board[x][y+1]=1;
                            board[x][y+2]=1;
                            String s = 3 + "";
                            rawboard[x][y]=s;
                            rawboard[x][y+1]=s;
                            rawboard[x][y+2]=s;
                            setBoat= true;
                        }
                    }
                    else {
                        if(board[x][y]==0 && x+2<=7 && board[x+1][y]==0 && board[x+2][y]==0 ){
                            board[x][y]=1;
                            board[x+1][y]=1;
                            board[x+2][y]=1;
                            String s = 3 + "";
                            rawboard[x][y]=s;
                            rawboard[x][y+1]=s;
                            rawboard[x][y+2]=s;
                            setBoat= true;
                        }
                    }
                }
            }
            //5th boat length 2
            setBoat= false;
            if((int) (Math.random()*((7)+1)+0)%2==0){
                vertical= true;
                horizontal= false;
            }
            else{
                vertical= false;
                horizontal= true;
            }
            while (!setBoat){
                x=(int) (Math.random()*((7)+1)+0);
                y=(int) (Math.random()*((7)+1)+0);
                if(vertical){
                    if(board[x][y]==0 && y+1<=7 && board[x][y+1]==0 ){
                        board[x][y]=1;
                        board[x][y+1]=1;
                        setBoat= true;
                        String s = 2 + "";
                        rawboard[x][y]=s;
                        rawboard[x][y+1]=s;
                    }
                }
                else {
                    if(board[x][y]==0 && x+1<=7 && board[x+1][y]==0 ){
                        board[x][y]=1;
                        board[x+1][y]=1;
                        String s = 2 + "";
                        rawboard[x][y]=s;
                        rawboard[x][y+1]=s;
                        setBoat= true;
                    }
                }
            }
            //setting up rest of the boat
            for(int i=0; i<row; i++){
                for(int j=0; j< col; j++){
                    if(board[i][j]!=1){
                        board[i][j]=0;
                    }
                }
            }
        }
        if(mode == 2){
            //1st and 2nd boat, length 5
            boolean setBoat;
            for(int i=0; i<2; i++){
                setBoat= false;
                if((int) (Math.random()*((11)+1)+0)%2==0){
                    vertical= true;
                    horizontal= false;
                }
                else{
                    vertical= false;
                    horizontal= true;
                }
                while (!setBoat){
                    x=(int) (Math.random()*((11)+1)+0);
                    y=(int) (Math.random()*((11)+1)+0);
                    if(vertical){
                        if(board[x][y]==0 && y+4<=11 && board[x][y+1]==0 && board[x][y+2]==0 && board[x][y+3]==0 && board[x][y+4]==0){
                            board[x][y]=1;
                            board[x][y+1]=1;
                            board[x][y+2]=1;
                            board[x][y+3]=1;
                            board[x][y+4]=1;
                            String s = 5 + "";
                            rawboard[x][y]=s;
                            rawboard[x][y+1]=s;
                            rawboard[x][y+2]=s;
                            rawboard[x][y+3]=s;
                            rawboard[x][y+4]=s;
                            setBoat= true;
                        }
                    }
                    else {
                        if(board[x][y]==0 && x+4<=11 && board[x+1][y]==0 && board[x+2][y]==0 && board[x+3][y]==0 && board[x+4][y]==0){
                            board[x][y]=1;
                            board[x+1][y]=1;
                            board[x+2][y]=1;
                            board[x+3][y]=1;
                            board[x+4][y]=1;
                            String s = 5 + "";
                            rawboard[x][y]=s;
                            rawboard[x][y+1]=s;
                            rawboard[x][y+2]=s;
                            rawboard[x][y+3]=s;
                            rawboard[x][y+4]=s;
                            setBoat= true;
                        }
                    }
                }
            }
            //3rd and 4th boat. length 4
            for(int i=0; i<2; i++){
                setBoat= false;
                if((int) (Math.random()*((11)+1)+0)%2==0){
                    vertical= true;
                    horizontal= false;
                }
                else{
                    vertical= false;
                    horizontal= true;
                }
                while (!setBoat){
                    x=(int) (Math.random()*((11)+1)+0);
                    y=(int) (Math.random()*((11)+1)+0);
                    if(vertical){
                        if(board[x][y]==0 && y+3<=11 && board[x][y+1]==0 && board[x][y+2]==0 && board[x][y+3]==0 ){
                            board[x][y]=1;
                            board[x][y+1]=1;
                            board[x][y+2]=1;
                            board[x][y+3]=1;
                            String s = 4 + "";
                            rawboard[x][y]=s;
                            rawboard[x][y+1]=s;
                            rawboard[x][y+2]=s;
                            rawboard[x][y+3]=s;
                            
                            setBoat= true;
                        }
                    }
                    else {
                        if(board[x][y]==0 && x+3<=11 && board[x+1][y]==0 && board[x+2][y]==0 && board[x+3][y]==0){
                            board[x][y]=1;
                            board[x+1][y]=1;
                            board[x+2][y]=1;
                            board[x+3][y]=1;
                            String s = 4 + "";
                            rawboard[x][y]=s;
                            rawboard[x][y+1]=s;
                            rawboard[x][y+2]=s;
                            rawboard[x][y+3]=s;
                            
                            setBoat= true;
                        }
                    }
                }
            }

            //5rd, 6th, 7th, 8th boat(4), length 3
            for(int i=0; i<4; i++){
                setBoat= false;
                if((int) (Math.random()*((11)+1)+0)%2==0){
                    vertical= true;
                    horizontal= false;
                }else{
                    vertical= false;
                    horizontal= true;
                }
                while (!setBoat){
                    x=(int) (Math.random()*((11)+1)+0);
                    y=(int) (Math.random()*((11)+1)+0);
                    if(vertical){
                        if(board[x][y]==0 && y+2<=11 && board[x][y+1]==0 && board[x][y+2]==0 ){
                            board[x][y]=1;
                            board[x][y+1]=1;
                            board[x][y+2]=1;
                            String s = 3 + "";
                            rawboard[x][y]=s;
                            rawboard[x][y+1]=s;
                            rawboard[x][y+2]=s;
                            
                            
                            setBoat= true;
                        }
                    }
                    else {
                        if(board[x][y]==0 && x+2<=11 && board[x+1][y]==0 && board[x+2][y]==0 ){
                            board[x][y]=1;
                            board[x+1][y]=1;
                            board[x+2][y]=1;
                            String s = 3 + "";
                            rawboard[x][y]=s;
                            rawboard[x][y+1]=s;
                            rawboard[x][y+2]=s;
                            
                            

                            setBoat= true;
                        }
                    }
                }
            }
            //9th and 10th boat length 2
            for(int i=0; i<2; i++){
                setBoat= false;
                if((int) (Math.random()*((11)+1)+0)%2==0){
                    vertical= true;
                    horizontal= false;
                }else{
                    vertical= false;
                    horizontal= true;
                }
                while (!setBoat){
                    x=(int) (Math.random()*((11)+1)+0);
                    y=(int) (Math.random()*((11)+1)+0);
                    if(vertical){
                        if(board[x][y]==0 && y+1<=11 && board[x][y+1]==0 ){
                            board[x][y]=1;
                            board[x][y+1]=1;
                            String s = 2 + "";
                            rawboard[x][y]=s;
                            rawboard[x][y+1]=s;
                            setBoat= true;
                        }
                    }
                    else {
                        if(board[x][y]==0 && x+1<=11 && board[x+1][y]==0 ){
                            board[x][y]=1;
                            board[x+1][y]=1;
                            String s = 2 + "";
                            rawboard[x][y]=s;
                            rawboard[x][y+1]=s;
                            
                            setBoat= true;
                        }
                    }
                }
            }
            //setting up rest of the boat
            for(int i=0; i<row; i++){
                for(int j=0; j< col; j++){
                    if(board[i][j]!=1){
                        board[i][j]=0;
                    }
                }
            }
        }
    }

    public void turns(){
        boolean gameOver= false;
        String sx;
        String sy;
        int turnX;
        int turnY;
        String decision= null;
        int check;
        while (!gameOver){
            check=0;
            System.out.println("Enter cordinate you want to hit");
            sx= scanner.nextLine();
            if(sx.equals("drone")){
                if(mode==1){
                    if(droneUsed>0){
                        System.out.println("You have used max number of drone");
                        continue;
                    }
                }else if(mode ==2){
                    if(droneUsed>1){
                        System.out.println("You have used max number of drone");
                        continue;
                    }
                }
                drone();
                continue;
            }
            turnX= Integer.parseInt(sx);
            sy=scanner.nextLine();
            turnY= Integer.parseInt(sy);
            turnCount++;
            if(turnX<0 || turnX>=row || turnY<0 || turnY>=col){
                decision="penalty";
            }
            else if(board[turnX][turnY]!=1){
                decision= "miss";
                demoBoard[turnX][turnY]="O";
            }
            else if( demoBoard[turnX][turnY].equals("O") ||demoBoard[turnX][turnY].equals("X")){
                decision= "penalty";
            }
            else if(board[turnX][turnY]==1){
                decision= "hit";
                demoBoard[turnX][turnY]="X";
                board[turnX][turnY]=0;
            }
            System.out.println("Turn "+ turnCount+": "+ "user selects ( "+turnX+","+turnY+") and "+decision);
            if(decision.equals("penalty")){
                turnCount++;
                System.out.println("Turn "+ turnCount+": skipped");
                continue;
            }
            for(int i=0; i< row; i++){
                for(int j=0; j<col; j++){
                    System.out.print(demoBoard[i][j]+" ");
                    if(board[i][j]==1){
                        check++;
                    }
                }
                System.out.println();
            }
            if(check==0){
                System.out.println("You have hit all target with "+turnCount+" turns");
                gameOver= true;
            }
        }
    }
    public void drone(){
        boolean gameOver= false;
        String choice;
        int number=0;
        System.out.println("Would you like to scan a row or col, type in r for row or c for col");
        choice= scanner.nextLine();
        while(!gameOver){
            if(!choice.equals("r") && !choice.equals("c")){
                System.out.println("invalid input. Please type r for row or c for col");
                choice= scanner.nextLine();
                continue;
            }
            System.out.println("Which row or col would you like to scan");
            number= scanner.nextInt();
            scanner.nextLine();
            if(number<0 || number>=row || number>= col){
                System.out.println("Invalid input");
                continue;
            }
            gameOver= true;
            droneUsed++;
        }
        int target=0;
        if(choice.equals("r")){
            for(int i=0; i< col; i++){
                if(board[number][i]==1){
                    target++;
                }
            }
        }
        else if(choice.equals("c")){
            for(int i=0; i< row; i++){
                if(board[i][number]==1){
                    target++;
                }
            }
        }
        System.out.println("Drone has scanned "+target+" targets in the area");

    }
    public void fire(int x, int y){
        Scanner fire = new Scanner(System.in);
        System.out.println("Where would you like to fire:");
        x = fire.nextInt();
        y = fire.nextInt();
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length ; col++){
                if(x < board.length && y < board[row].length){
                    BattleboatsBoard fireme = new BattleboatsBoard(mode);
                    fireme.turns();//calls turns method to hit at desired position
                }
                else{
                    System.out.println("Could not fire at that position, Please enter valid coordinates:");
                }
            }
        }
    } 

    public void missile(int x, int y){
        Scanner misel = new Scanner(System.in);
        System.out.println("Please type missile:");
        String checkMis = misel.nextLine();
        if(checkMis.equals("missile")){
            System.out.println("Where would you like to fire missile?, Enter valid coordinates:");
            x = misel.nextInt();
            y = misel.nextInt();
            for(int row = 0; row < board.length; row++){
                for(int col = 0; col < board[row].length ; col++){
                    if(x < board.length && y < board[row].length){
                        BattleboatsBoard miselFire = new BattleboatsBoard(mode);
                        miselFire.fire(x,y);//calls fire method
                        System.out.println("You have successfully fired a missile at your desired location:");
                    }
                    else{
                        System.out.println("Please enter valid coordinates:");
                    }
                }
            }
        }
    } //

    
    public void print(){

        String [][] demoBoard;
        String [][] rawboard;
        int m = demoboard[0].length;
        int n = rawboard[0].length;
        String [][] result;
        Scanner printme = new Scanner(System.in);
        System.out.println("Please type Print if you want to print:");
        String printer = printme.nextLine(); // error
        if (printer.equals("Print")){
            result = new String[2][n+m];
            for (int j=0; j<2; j++){
                for (int i=0;i<m+n;i++){
                    if (i < m){
                        result[i] = demoBoard[i];
                    }
                    else{
                        result[i] = rawBoard[i%m];
                    }
                }
            }
        }//  merge demoboard and raw board here.first//
        //Put two loop check if demo[][].equal(0) newarray[][] == 0  and same with X 
        //then print out raw board
                

    public void display(){
        for(int row = 0; row < board.length ; row++){
            for(int col = 0; col < board[row].length ; col++){
                System.out.print( "\t");
            }
            
        }
                
    }

    public int[][] getBoard() {
        return board;
    }

    public static void main(String[] args) {
        boolean play = true;
        while(true){
            int  mode;
            Scanner scan = new Scanner(System.in);
            System.out.println("Hello welcome to BattleBoats! Please enter 1 to play in Standard mode or enter 2 to play in Expert mode:");
            mode = scan.nextInt();
            if (mode == 1 || mode == 2){
                BattleboatsBoard bb = new BattleboatsBoard(mode);
                bb.turns();
                bb.drone();
                bb.display();
            }
            
            else {
                System.out.println("Invalid Input");
            }
            // and here if the user inputs string then it should show invalid input and ask for input again
    
        }
    }
}  

