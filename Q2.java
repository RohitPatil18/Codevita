//Program for Drunkard's walk

class Q2{

	public static void main(String[] args) {

			String d;
			int fm, bm, t, fbs, bbs;
		  String inp = "F 2 3 9 12 15"; //D BM FM T FBS BBS
		   /*
		   1. D ​denotes direction, either F (Forward) or B (Backward)
		   2. FM ​denotes the magnitude of forward movement in meters
		   3. BM ​denotes the magnitude of backward movement in meters
		   4. T ​denotes time taken to cover 1 meter
		   5. FBS ​denotes distance from Drunkards starting position and the banana skin in forward direction
		   6. BBS ​denotes distance from Drunkards' starting position and the banana skin in backward direction
		   */

			 String data[] = inp.split(" ");
			 d = data[0];
			 fm = Integer.parseInt(data[1]);
			 bm = Integer.parseInt(data[2]);
			 t = Integer.parseInt(data[3]);
			 fbs = Integer.parseInt(data[4]);
			 bbs = Integer.parseInt(data[5]);

			 boolean isError = false;
			 String errorMessage = "";

			 //Validation
			 if(fm < 0){
				 isError = true;
				 errorMessage = errorMessage + "\nInvalid input : FM must be greater than 0";
			 }
			 if(bm < 0){
				 isError = true;
				 errorMessage = errorMessage + "\nInvalid input : BM must be greater than 0";
			 }
			 if(t < 0){
				 isError = true;
				 errorMessage = errorMessage + "\nInvalid input : T must be greater than 0";
			 }
			 if(fbs < 0){
				 isError = true;
				 errorMessage = errorMessage + "\nInvalid input : FBS must be greater than 0";
			 }
			 if(bbs < 0){
				 isError = true;
				 errorMessage = errorMessage + "\nInvalid input : BBS must be greater than 0";
			 }

			 if(isError){
				 System.out.println(errorMessage);
				 return;                  //Program terminates in case of Invalid input
			 }

			 int tt = 0; //Total time

			 //If first step is in backward direction.
			 if(d == "B"){
					bbs = bbs - bm;
					fbs = fbs + bm;
					tt = tt + t*bm;
					if(bbs == 0){
						System.out.println(tt+"B");
						return;
					}
			 }

		   while(true){

				 //Checks whether drunkard is out of the trap
				 if(bbs < (0 - fm)){
					 System.out.println("Hurray");
					 break;
				 }
				 else if(fbs < (0-bm)){
					 System.out.println("Hurray");
					 break;
				 }

		   		//Forward direction
		   		fbs = fbs - fm;
		   		bbs = bbs + fm;
		   		tt = tt + t*fm;
		   		if(fbs == 0){
						System.out.println("F "+tt);
		   			break;
		   		}

		   		//Backward direction
		   		bbs = bbs - bm;
		   		fbs = fbs + bm;
		   		tt = tt + t*bm;
					if(bbs == 0){
						System.out.println("B "+tt);
		   			break;
		   		}

		   }



	}
}
