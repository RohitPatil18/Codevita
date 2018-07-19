import java.lang.Math;
import java.util.Scanner;

class Q4{


  public static void main(String[] args) {

    int[][] matA; //= {{10, 9, 8},{7, 15, 9},{12, 8, 1}};
    long[][] matB; //= {{56900},{63200},{49500}};
    int N; // = 3;


    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();

    matA = new int[N][N];
    matB = new long[N][1];

    for(int i=0; i<N; i++){
    	for(int j=0; j<N; j++){
    		matA[i][j] = sc.nextInt();
    	}
    	matB[i][0] = sc.nextLong();
    }

    int det = determinant(matA, N);
    System.out.println(det);
    double[][] invA = inverseOf(matA, N, det);
    double result[][] = multiplicationOf(invA, matB, N);

  }



  //To find Inverse of a matrix
  public static double[][] inverseOf(int matA[][], int N, int det){

  	double mult = 1/(double)det;
  	int[][] adjA = adjointOf(matA, N);
  	double invA[][] = new double[N][N];

  	for(int i=0; i<N; i++){
  		for(int j=0; j<N; j++){
  			invA[i][j] = mult*((double) adjA[i][j]);
  		}
  	}
  	//display(invA, N, N);
  	return invA;
  }




  //To find determinant of the matrix
  public static int determinant(int matA[][], int N){
    int det = 0;

    //If matrix is of 1*1 dimention, return the only element
    if(N == 1){
      return matA[0][0];
    }

    int sign = 1; //Variable to determine sign

    //Calculate the determinant by recursion
    for(int i = 0; i<N; i++){
      int[][] temp = cofactorOf(matA, N, 0, i); //Get the co-factor matrix
      det = det + sign*matA[0][i]*determinant(temp, N-1);
      sign = 0 - sign;
    }
    return det;
  }


  //Method to find co-factor matrix
  public static int[][] cofactorOf(int mat[][], int N, int posX, int posY){

    int temp[][] = new int[N-1][N-1]; //Declare size of co-factor matrix;

    int i1=0, j1=0; //Variables to traverse in co-factor matrix

    for(int i=0; i<N; i++){
      if(i==posX) //Skips the row of position X
        continue;

      for(int j=0; j<N; j++){
        if(j==posY) //Skips the column of position Y
          continue;

        temp[i1][j1] = mat[i][j];
        j1++;

        if(j1==(N-1)){
          j1 = 0;
        }
      }
      i1++;
    }
    return temp;
  } // End of cofactorOf




  //Find adjoint of matrix
  public static int[][] adjointOf(int matA[][], int N){

    int[][] adjA = new int[N][N];

    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        int temp[][] = cofactorOf(matA, N, i, j);
        adjA[j][i] = (int)(Math.pow(-1, i+j+2))* determinant(temp, N-1);
      }
     } 
    //display(adjA, N, N);
    return adjA;

  } //End of adjointOf



  //To display matrix with integer values
  public static void display(int[][] mat, int X,  int Y){
  	System.out.println();
    for(int i=0; i<X; i++){
      for(int j=0; j<Y; j++){
        System.out.format("%5d ",mat[i][j]);
      }
      System.out.println();
    }
  } //End of display method with integer parameters



  //Overload the method to display matrix with double values
   public static void display(double[][] mat, int X, int Y){
  	System.out.println();
    for(int i=0; i<X; i++){
      for(int j=0; j<Y; j++){
        System.out.format("%9.2f",mat[i][j]);
      }
      System.out.println();
    }
  } //End of display with double parameters


  //Multiplication of matrix
  public static double[][] multiplicationOf(double[][] matA, long[][] matB, int N){

  	int k = 0;
  	double result[][] = new double[N][1];
  	double sum = 0.0;
  	int r1=0, c2=0;

  	while(c2<1){
  		
  		for(r1=0; r1<N; r1++){

  			for(int i=0; i<N; i++){
  				sum  = sum + matA[r1][i]*((double)matB[i][c2]);
  			}
  			result[r1][c2] = sum;
  			sum = 0.0;

  		}

  		c2++;
  	}

  	display(result, N, 1);
  	return result;

  }//End of multiplicationOf

}
