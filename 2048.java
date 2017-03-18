import java.util.*;
class mypuzzle{
	int[][] grid=new int[4][4];
	int wins;
	public mypuzzle(){
		int i,j;
		wins=0;
		for(i=0;i<4;i++){
			for(j=0;j<4;j++){
				grid[i][j]=0;
			}
		}
	}
	public void generateTile(){
		int[][] ran=new int[16][2];
		int i,j;
		int count=0;
		for(i=0;i<4;i++){                     
			for(j=0;j<4;j++){
				if (grid[i][j]==0){
					ran[count][0]=i;     
					ran[count][1]=j;      //gives the i,j of cells with 0
					count+=1;
				}
			}
		}
		Random a=new Random();
		if(count!=0){
		int pos=a.nextInt(count);      // gives the position in ran array where there is a 0, as the next tile should be generated
		int no=a.nextInt(2); //setting 0 as 2, 1 as 4
		if(no==0){
			grid[ran[pos][0]][ran[pos][1]]=2;
		}
		else if(no==1){
			grid[ran[pos][0]][ran[pos][1]]=4;
		}
	}

	}

	public void displayGrid(){
		int i,j;
		for(i=0;i<4;i++){
			for(j=0;j<4;j++){
				System.out.print(grid[i][j]+"\t");
			}
			System.out.print("\n");
		}

	}

	public void moveLeft(){
		int i,j,k;
		for(k=0;k<4;k++){
			for(i=0;i<=2;i++){
				for(j=i+1;j<=3;j++){
					if(grid[k][j]==0){
						continue;
					}
					else if (grid[k][i]!=grid[k][j]){
						break;
					}
					else if(grid[k][i]==grid[k][j]){
						grid[k][i]=grid[k][i]+grid[k][j];
						grid[k][j]=0;
						break;
					}
				
				}
			}

			for(i=0;i<=3;i++){
				if(grid[k][i]!=0){
					for(j=i;j>0;j--){
						if(grid[k][j-1]==0){
							grid[k][j-1]=grid[k][j];
							grid[k][j]=0;
						}
					}
				}
			}
		

		}
	

	}

	public void moveRight(){
		int i,j,k;
		for(k=0;k<4;k++){
    		for(i=3;i>=1;i--){
				for(j=i-1;j>=0;j--){
					if(grid[k][j]==0){
						continue;
					}
					else if (grid[k][i]!=grid[k][j]){
						break;
					}
					else if(grid[k][i]==grid[k][j]){
						grid[k][i]=grid[k][i]+grid[k][j];
						grid[k][j]=0;
						break;
					}
				
				}
			}

			for(i=3;i>=0;i--){
				if(grid[k][i]!=0){
					for(j=i;j<3;j++){
						if(grid[k][j+1]==0){
							grid[k][j+1]=grid[k][j];
							grid[k][j]=0;
						}
					}
				}
			}
		

		}
	

	}

	public void moveDown(){
		int i,j,k;
		for(k=0;k<4;k++){
    		for(i=3;i>=1;i--){
				for(j=i-1;j>=0;j--){
					if(grid[j][k]==0){
						continue;
					}
					else if (grid[i][k]!=grid[j][k]){
						break;
					}
					else if(grid[i][k]==grid[j][k]){
						grid[i][k]=grid[i][k]+grid[j][k];
						grid[j][k]=0;
						break;
					}
				
				}
			}

			for(i=3;i>=0;i--){
				if(grid[i][k]!=0){
					for(j=i;j<3;j++){
						if(grid[j+1][k]==0){
							grid[j+1][k]=grid[j][k];
							grid[j][k]=0;
						}
					}
				}
			}
		

		}
	

	}

	public void moveUp(){
		int i,j,k;
		for(k=0;k<4;k++){
			for(i=0;i<=2;i++){
				for(j=i+1;j<=3;j++){
					if(grid[j][k]==0){
						continue;
					}
					else if (grid[i][k]!=grid[j][k]){
						break;
					}
					else if(grid[i][k]==grid[j][k]){
						grid[i][k]=grid[i][k]+grid[j][k];
						grid[j][k]=0;
						break;
					}
				
				}
			}

			for(i=0;i<=3;i++){
				if(grid[i][k]!=0){
					for(j=i;j>0;j--){
						if(grid[j-1][k]==0){
							grid[j-1][k]=grid[j][k];
							grid[j][k]=0;
						}
					}
				}
			}
		

		}
	

	}

	
	public void haswon(){
		int i,j;
		int count=0;
		for(i=0;i<4;i++){
			for(j=0;j<4;j++){
				if(grid[i][j]==2048){
					count+=1;
				}
			}
		}
		if(count>0 && wins==0){
			wins+=1;
			System.out.print("You Win!");
		}
		
	}

	public int isover(){
		int check=0;
		int ult_check=0;
		int count=0;
		int i,j;
		for(i=0;i<4;i++){
			if((grid[i][0]==grid[i][1])||(grid[i][1]==grid[i][2])||(grid[i][2]==grid[i][3])){
				ult_check=1;
			}
		}
		for(i=0;i<4;i++){
			if((grid[0][i]==grid[1][i])||(grid[1][i]==grid[2][i])||(grid[2][i]==grid[3][i])){
				ult_check=1;
			}
		}
		for(i=0;i<4;i++){
			for(j=0;j<4;j++){
				if(grid[i][j]==0){
					count+=1;
				}
			}
		}
		if(count>0||ult_check==1){
			check=1;
		}
		else{
			check=0;
		}

	return check;}



}

class playgame{
	public static void main(String[] args){
		System.out.print("\n");
		System.out.println("w - Move Up");
		System.out.println("a - Move Left");
		System.out.println("s - Move Down");
		System.out.println("d - Move Right");
		System.out.println("q - Quit");
		System.out.print("\n");
		int check;
		mypuzzle game = new mypuzzle();
		game.generateTile();
		game.displayGrid();
		check=game.isover();
		System.out.print("\n");
		Scanner s= new Scanner(System.in);
		char input = s.next().charAt(0);
		while (Character.toLowerCase(input)!='q'&&check!=0){
			if (Character.toLowerCase(input)=='w'){
				System.out.print("\n");
				game.moveUp();
				
			}
			else if (Character.toLowerCase(input)=='a'){
				System.out.print("\n");
				game.moveLeft();
				
			}
			else if (Character.toLowerCase(input)=='s'){
				System.out.print("\n");
				game.moveDown();
				
			}
			else if (Character.toLowerCase(input)=='d'){
				System.out.print("\n");
				game.moveRight();
				
			}
			game.generateTile();
			game.displayGrid();
			game.haswon();
			System.out.print("\n");
			check=game.isover();
			input = s.next().charAt(0);
			if(Character.toLowerCase(input)=='q'){
				System.out.println("You Quit");
			}
		}
		if(check==0){
			System.out.print("You Lost\n");
			game.displayGrid();
		}


	}
}