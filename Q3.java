import java.util.Scanner;

class Q3{

  private static int matA[][], matB[][], inverseA[][], sol[][], temp[][];
  private static int N;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Input : \n");
    /*
    First line contains number of stocks = N,
    next N line contains Number of shares in each stock
    and total value
    */
    N = sc.nextInt();
    matA = new int[N][N];
    matB = new int[N][1];

    for(int i=0; i<N; i++){
      for(int j=0; j<N+1; j++){
        if(j==N){
          matB[i][0] = sc.nextInt();
        }
        else{
          matA[i][j] = sc.nextInt();
        }
      }
    }

    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){

          System.out.println(matA[i][j]);

      }
    }

    int det = determinant(matA, N);
    System.out.println(det);
    if(det!=0){
      System.out.println("Unsolvable");
      return;
    }
    System.out.println(det);

    //inverseA = new double[N][N];
    //inverseOfMat(matA, N);

    //sol= new double[N][1];
    //mulOfMats(inverseA, matB, N);
  }

  public static int determinant(int matA[][], int N){
    int det = 0;
    int sign = 1;

    if(N==2){

      det = (matA[0][0]*matA[1][1])-(matA[0][1]*matA[1][0]);
      System.out.println(det);
      return det;
    }

    for(int i=0; i<N; i++){
      System.out.println("S2");
      getTempMat(matA, N, 0, i);
      det = det + sign*(matA[0][i])*determinant(temp, N-1);
      System.out.println(det);
      sign = 0 - sign;
    }
    return det;
  }

  public static void getTempMat(int mat[][], int N, int posX, int posY){
    int n = N-1;
    temp = new int[N][N];
    System.out.println("S3");
    int tempi = 0, tempj=0;
    for(int i=0; i<=n; i++){
      if(i != posX){
        for(int j=0; j<=n; j++){
          if(j!=posY){
            temp[tempi][tempj] = matA[i][j];
            if(tempj == n-1){
              tempj=0;
            }else{
              tempj++;
            }
          }
        }
      }
      tempi++;
    }
    System.out.println("s4");
  }




}
