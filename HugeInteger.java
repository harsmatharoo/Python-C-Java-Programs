import java.util.Random;

import com.sun.net.httpserver.Authenticator.Result;


public class HugeInteger {
	
	public int[] HugeInt; 
	 private boolean sign;
	 public int size;
	
	

	 public HugeInteger(String val){
		 
		 String tempor_str = "";
		 boolean negative = true;
		 boolean positive = false;
		 
		 // ascii conversion of some characters used to check the input conditions for the constructors, this one for naegative sign
	        if ((int)val.charAt(0)== 45){  
	        	
	        	// the input is deemed negative, if and only if the first character of the string consists of a negative sign
	            if (val.length() == 1 ){
	                throw new IllegalArgumentException("horrible Input, is not good for manipulation");
	            }
	            
	            
	            if ((int)val.charAt(0)== 48 && (val.length() - 1) > 1){
	               
	            	
	            	
	            	for(;(int)val.charAt(0)== 48 && val.length() != 0 && (val.length() - 1) > 1;){  // any string starting with zeroes, will have leading zeroes removed
	                    tempor_str = val.substring(1, val.length());
	                    val = tempor_str;
	                }
	            }
	            
	            
	            
	            for (int x = 1; x <= val.length() - 1; x++) {
	   			 
	   			 if (((int)val.charAt(x) < 48 || (int)val.charAt(x) > 57) ) {
	   				 
	   				 throw new NumberFormatException("the string input consists a character not a number after index 0 ");
	   				 
	   			 }
	   			 
	   		 }
	            
	            if (((int)val.charAt(0)== 48 && (int)val.charAt(0)== 48) && val != null &&!(val.length() < 0) && val.length() == 2){
	                sign = positive; //positive sign
	            }
	            else{
	                sign = negative; // negative sign                                                    
	            }
	            
	            
	            int index = 1; // controls the index at the string not the array
	            size = val.length() - 1;                // smaller size due to negative sign taking up the first index                            
	            HugeInt = new int[size];                                          
	            
	            
	            
	            for (int i = 1; i < this.size + 1; i++){              // starts at index 1 instead of 0 due to the negative sign being at the first spot                 
	                if (Character.isDigit(val.charAt(i)) == false){      // the method of this kind has been used to check if the value at index is a digit or not
	                    throw new IllegalArgumentException("The input doesnt correspond to the requirements");
	                }
	            }
	            for (int i = 0; i < this.size; i++){                    // the element at each string index is copied into the array of the hugeinteger member of the class
	            	HugeInt[i] = val.charAt(index) - 48;
	            	index++;
	            	//subtract by 48 to adjust for typecast and ascii
	            }
	            
	            
	           
	            if ((int)(val.charAt(1)) == 48) {
	            	
	            	for (int m = 1; m < val.length(); m++) {
	            		if (val.charAt(m) != 48) {
	            			
	            			tempor_str = val.substring(m, val.length()); //detect where the leading zeroes go upto and cut them off, to make a number without leading zeroes
	            		val= tempor_str;
	            		
	            		
	            		}
	            		
	            	}
	            }
	           
	            
	        }
	        else{
	            if (val.length() == 0){
	                throw new IllegalArgumentException("The input doesnt correspond to the requirements");
	            }
	            
	            int index_first = 1;
	            
	            
	            if ((int)val.charAt(0)== 48 && val.length() > 1 &&  val != null) {
	                for(; (int)val.charAt(0)== 48&& val.length() != 0 && val.length() > 1 && val != null;){
	                    val = val.substring(index_first, val.length());
	                }
	            }
	            int index = 0;
	            
	            sign = positive; 
	                                           
	            size = val.length();  //size is not subtracting one, since we start at i = 0 for the loop to check, no negative sign
	            
	            HugeInt = new int[size];    //initializes the array
	            
	            
	            
	            for (int i = 0; i < size; i++){                                     //iterates through the string
	                if (Character.isDigit(val.charAt(i)) == false){                // check for an invalid input character not included in our lab requirements
	                    throw new NumberFormatException("The input does not meet the requirements to run the code");
	                }
	            }
	            
	            
	            for (int i = 0; i < size; i++){                                     //loop to copy elements from the string and input them into the array of this current class being evaluated
	            	HugeInt[i] = val.charAt(index) - 48;    
	                index ++;         //adjust for typecast
	            }
	        }
	    }
	
	
	
	public HugeInteger(int n) {
		
		
		if (n <= 0) {
            throw new IllegalArgumentException("incorrect input");
        }
		

		HugeInt = new int[n];
		this.size = n;
		this.sign = false;
		Random rand_intgen = new Random();
		
		for (int i = 0; i <= n - 1; i++) {
			
			if (i == 0) {
				
				this.HugeInt[0] = (int)((rand_intgen.nextInt(8) + 1)); // since first integer is bounded to the number 9 we add 1
			}
			
			else if (i > 0) {
			this.HugeInt[i] = (int)(Math.random()*9);
			}		}
		
		
	}
	

public HugeInteger add(HugeInteger h) {
	
	
// the idea of basic addition operations is used using sum and carry, but with arrays now
	
	
	// declaration of a huge integer object to store the answer
	 
	 int temp_add = 0;
	 int carry_dig = 0;
	 int temp_add2 = 0;
	 int carry_temp = 0;
	 int f;
	 int temp_hold = 0;
	 
	 final int zero = 0;
	 HugeInteger result = new HugeInteger("000");
	 
	 if ((this.sign == false && h.sign == false && this != null && h != null)){
		 
		 
		 if(this.size == h.size){ // for the case of equal sizes
			 
			 if (this.size > 1 && h.size > 1) { // for the cases of sizes of only 1
				
				 
				 
				 result.HugeInt = new int[this.size]; // result stores the resultant array
				 
				 result.size = this.size; // set the size 
				 
				 
				 for (int i = result.size - 1; i >= 0; i--) {
					 
					 if (i == 1 || i == 0) {           // this corresponds to the cases when i = first or second index (0th and 1st)
						 
						 if (i == 1) {
							 if (this.HugeInt[i] + h.HugeInt[i] + carry_temp == 10) {
								 
								 result.HugeInt[i] = 0;               //if result is 10, we only store the zero, carry the 1
								 carry_temp = 1;           // carry_temp is detected by the next iteration and manipulated
								 
							 }
							 
							 
							 
							 
							 if (this.HugeInt[i] + h.HugeInt[i] + carry_temp > 10) {  // if > 10, subtract 10, store the digit without carry, carry is 1 for the next index
								 
								 result.HugeInt[i] = this.HugeInt[i] + h.HugeInt[i] + carry_temp - 10;
								 carry_temp = 1;
								 
							 }
							 
							 if (this.HugeInt[i] + h.HugeInt[i] + carry_temp < 10) {
								 
								 result.HugeInt[i] = this.HugeInt[i] + h.HugeInt[i] + carry_temp;   // less than 10 means we dont have to subtract by 10
								 
								 
							 }
							 
						 }
						 
						 if (i == 0) {
							 
			
								 
								 result.HugeInt[i] = this.HugeInt[i] + h.HugeInt[i] + carry_temp;
								
								 
								 // for the 0th index, we don't need to subtract we can store the two digit number on the 0th index, as it's converted to string anyways			 
						 }	 }
					 
					 
					 
					 else {
						 
						 //considering all cases of temp_hold, the variable that stores whether addition of the last index that was done was > 10 or < 10 or = 10
					 
					 
					 if (temp_hold >= 10) {
						 
						 temp_add2 = this.HugeInt[i] + h.HugeInt[i] + 1;
						 
						 // >= 10 means we have to add 1 due to carry
						 
						
						 }
					 
					 
					 
					 if (temp_hold < 10){
						 
						 temp_add2 = this.HugeInt[i] + h.HugeInt[i];
						 
						 //no carry
					 
					 }
					 
					 
					 
					 
					 if (temp_add2 < 10) {
						 carry_dig = 0;
						 
						 // temp_add2 stores current addition, as opposed to the previous index's addition
						 // if less than 10, no carry digit
					 }
					 
					 if (temp_add2 >= 10) {
						 carry_dig = 1;
						 temp_add2 -= 10;
						
					 }
					 
					 
					 
				
						 result.HugeInt[i] = temp_add2  + carry_temp;
					 
					 
					 
				 
					 
			 carry_temp = carry_dig;
			 temp_hold = temp_add2;
					 
					 
				 }				 
				 }
				 
				 
			 }
			 
	
			 
			 else if (this.size == 1 && h.size == 1) {
			 
			 if (this.HugeInt[0] + h.HugeInt[0] >= 10) {
				 
				 result.HugeInt = new int[this.size + 1] ;
				 
				 result.size = this.size + 1;
				 
				 result.HugeInt[0] = 1;
				 result.HugeInt[1] = this.HugeInt[0] + h.HugeInt[0] - 10;
				 
				 
			 }
				 
				 
				 
				 if (this.HugeInt[0] + h.HugeInt[0] < 10) {
					 
					 result.HugeInt = new int[this.size];
					 
					 result.size = this.size;
					 
					
						 
						 result.HugeInt[0] = this.HugeInt[0] + h.HugeInt[0];
				 }
			 
			 
			 }
			 
			 
		
		 
		 
	 }
		 
		 
		 
		 
		 
		 else if (this.size != h.size) {
			 
			 int temp_carr = 0;
			 
			 if (this.size > h.size) {
				 
				 
				
				 result.size = this.size;
				 result.HugeInt = new int[this.size];
				 int temp_index = h.size - 1;
				 result.sign = false;
				 
				 int temp_add3 = 0;
				 int carry2 = 0;
				 
				 
				 for (int k = result.size - 1; k >= 0; k--) {
					 
					 
					 if (temp_index < 0) {
						 
						 
						 
						 
						 
						 if (k == 0) {
							 
							 //case for 0th index, store the result without subtracting 10
							 
							 //same idea repeated for all the other cases
							 
							 result.HugeInt[k] = this.HugeInt[k] + carry_temp;
						 }
						 
						 
						 
						 else {
						 
						 if((this.HugeInt[k] + carry_temp) >= 10) {
							 
							 result.HugeInt[k] = this.HugeInt[k] + carry_temp - 10;
							 carry_temp = 1;
							 
							 
							 
					 }
						 
						 if (this.HugeInt[k] + carry_temp < 10){
							 
							 result.HugeInt[k] = this.HugeInt[k] + carry_temp;
							 carry_temp = 0;
						 }
					 
						 }
					 }
					 
					 
					 else {
					 
						 if (temp_hold >= 10) {
							 
							 temp_add2 = this.HugeInt[k] + h.HugeInt[temp_index] + 1;
							 
							 
							 
							
							 }
						 
						 
						 
						 if (temp_hold < 10){
							 
							 temp_add2 = this.HugeInt[k] + h.HugeInt[temp_index];
						 
						 }
						 
						 
						 
						 
						 if (temp_add2 < 10) {
							 carry_dig = 0;
						 }
						 
						 if (temp_add2 >= 10) {
							 carry_dig = 1;
							 temp_add2 -= 10;
							
						 }
						 
						 
						 
					
							 result.HugeInt[k] = temp_add2  + carry_temp;
						 
						 
						 
					 
						 
				 carry_temp = carry_dig;
				 temp_hold = temp_add2;
					 
					 }
					 
					 
					 temp_index--;		 
				 } 
			 }
				 
			 
			 
			 if (this.size < h.size) {
				 
				 
					
				 result.size = h.size;
				 result.HugeInt = new int[h.size];
				 int temp_index = this.size - 1;
				 result.sign = false;
				 
				 int temp_add3 = 0;
				 int carry2 = 0;
				 
				 
				 for (int k = result.size - 1; k >= 0; k--) {
					 
					 
					 if (temp_index < 0) {
						 
						 
						 
						 
						 
						 if (k == 0) {
							 
							 //case for 0th index, store the result without subtracting 10
							 
							 //same idea repeated for all the other cases
							 
							 result.HugeInt[k] = h.HugeInt[k] + carry_temp;
						 }
						 
						 
						 
						 else {
						 
						 if((h.HugeInt[k] + carry_temp) >= 10) {
							 
							 result.HugeInt[k] = h.HugeInt[k] + carry_temp - 10;
							 carry_temp = 1;
							 
							 
							 
					 }
						 
						 if (h.HugeInt[k] + carry_temp < 10){
							 
							 result.HugeInt[k] = h.HugeInt[k] + carry_temp;
							 carry_temp = 0;
						 }
					 
						 }
					 }
					 
					 
					 else {
					 
						 if (temp_hold >= 10) {
							 
							 temp_add2 = h.HugeInt[k] + this.HugeInt[temp_index] + 1;
							 
							 
							 
							
							 }
						 
						 
						 
						 if (temp_hold < 10){
							 
							 temp_add2 = h.HugeInt[k] + this.HugeInt[temp_index];
						 
						 }
						 
						 
						 
						 
						 if (temp_add2 < 10) {
							 carry_dig = 0;
						 }
						 
						 if (temp_add2 >= 10) {
							 carry_dig = 1;
							 temp_add2 -= 10;
							
						 }
						 
						 
						 
					
							 result.HugeInt[k] = temp_add2  + carry_temp;
						 
						 
						 
					 
						 
				 carry_temp = carry_dig;
				 temp_hold = temp_add2;
					 
					 }
					 
					 
					 temp_index--;		 
				 } }		 
		 }	 
		 }
	 
	 
	 
	 if (this.sign == false && h.sign == true) {
		 
		 h.sign = false;
		 
		 
		 result = this.subtract(h);
		 
	
		 return result;
		 
		 
	 }
	 
if (this.sign == true && h.sign == true) {
	this.sign = false;
	h.sign = false;
	
		 
		 
		 result = this.add(h);
		 result.sign = true;
		 return result;
		 
		 
	 }

if (this.sign == true && h.sign == false) {
	 
	this.sign = false;
	 
	 
	 result = h.subtract(this);
	 

	 return result;
	 
	 
}


	 
	 

	 
	 return result;}



public HugeInteger subtract(HugeInteger h) {
	
	
	int borrow_num = 0;
	int temp_sub = 0;
	int temp_substore = 0;
	int borrow_store = 0;
	int temp = 0;
	
	int index_x = 0;
	
	HugeInteger result = new HugeInteger("000");
	


	
	if (this.size == h.size) {
		
		if (this.size == 1 && h.size == 1) {
			
			 result.HugeInt = new int[this.size] ;
			 
			 result.size = this.size ;
			 
			 if (h.sign == true && this.sign == false) {
				 result.HugeInt[0] = h.HugeInt[0]  + this.HugeInt[0];
					
				}
			 
			 if (h.sign == true && this.sign == true) {
				 result.HugeInt[0] =  (-1)*this.HugeInt[0] + h.HugeInt[0];
					
				}
			 
			 if (h.sign == false && this.sign == false) {
				 result.HugeInt[0] =  this.HugeInt[0] - h.HugeInt[0];
					
				}
			 
			 
			 if (h.sign == false && this.sign == true) {
				 result.HugeInt[0] =  (-1)*(this.HugeInt[0]) - h.HugeInt[0];
					
				}
			
		}
		
		else if (this.size > 1) {
			
			result.size = this.size;
			 result.HugeInt = new int[this.size];
			 
			 if (this.sign == false && h.sign == true) {
				 
				 h.sign = false;
				 
				 result = this.add(h);
				 return result;
				}
			 
			 
 if (this.sign == true && h.sign == false) {
				 
				 this.sign = false;
				 
				 result = this.add(h);
				 
				 result.sign = true;
				 
				 return result;
				}
			 // end case 1
			 
 if (this.sign == false && h.sign == true) {
	 
	 h.sign = false;
	 
	 result = this.add(h);
	 
	 result.sign = false;
	 
	 return result;
	}
			 
	
			
			 // end case 2
			 
			 
			 
			 if (this.sign == false && h.sign == false) {
					 
				 if (this.HugeInt[0] < h.HugeInt[0]) {
						 for (int k = result.size - 1; k >= 0; k--) {
							 
							 if (this.HugeInt[k] > h.HugeInt[k]) {
								 
								 if (k == 0) { // absolute used since signs are changed up towards the end of the loop
									 result.HugeInt[k] = Math.abs(h.HugeInt[k] - this.HugeInt[k] - borrow_num);}
								 
								 else {
									 
									 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] + 10 - borrow_num;
								 
								 borrow_num = 1;

								 }}
							 
							 if (this.HugeInt[k] < h.HugeInt[k]) {
								 
								 
								 if (k == 0) {
									 
									 result.HugeInt[k] = Math.abs(h.HugeInt[k] - this.HugeInt[k] - borrow_num);}
								 
								 else {
									 
									 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] - borrow_num;
								 
								 borrow_num = 0;
								 
								 
								 }} 
							 
						 
							 if (this.HugeInt[k] == h.HugeInt[k]) {
								 
								 if (k == 0) {
									 
									 result.HugeInt[k] = Math.abs(h.HugeInt[k] - this.HugeInt[k] - borrow_num);}
								 
								 else {
								 
								 if (h.HugeInt[k] - this.HugeInt[k] - borrow_num < 0) {
									result.HugeInt[k] = h.HugeInt[k] + 10 - this.HugeInt[k] - borrow_num;
										 borrow_num = 1;}
									
									
									if (h.HugeInt[k] - this.HugeInt[k] - borrow_num > 0) {
										
										 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] - borrow_num;
												borrow_num = 0;}
									
									
									
									if (this.HugeInt[k] - h.HugeInt[k] - borrow_num == 0) {
										result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] - borrow_num;
												borrow_num = 0;}
								 }
							 
							 }
							 
						 } 
						 
				 result.sign = true;}
				 
				 // ---------------------------------------------------------------------------------
					 
					 if (this.HugeInt[0] > h.HugeInt[0]) {
						 
						 for (int k = result.size - 1; k >= 0; k--) {
							
							 
							 if (this.HugeInt[k] > h.HugeInt[k]) {
								 
								 if (k == 0) {
									 result.HugeInt[k] = Math.abs(this.HugeInt[k] - h.HugeInt[k] - borrow_store);}
								 
								 else {
									 
									 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[k] - borrow_store;
								 
								 borrow_num = 0;
								 
								 
								 }
								 
								}
							 
							 if (this.HugeInt[k] < h.HugeInt[k]) {
								 
								 
								 if (k == 0) {
									 
									 result.HugeInt[k] = Math.abs(this.HugeInt[k] - h.HugeInt[k] - borrow_store);}
								 
								
								 else {
									 
									 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[k] + 10 - borrow_store;
								 
								 borrow_num = 1;

								 }} 
							 
						 
							 if (this.HugeInt[k] == h.HugeInt[k]) {
								 
								 if (k == 0) {
									 
									 result.HugeInt[k] = Math.abs(this.HugeInt[k] - h.HugeInt[k] - borrow_store);}
								 
								 else {
								 
								 if (h.HugeInt[k] - this.HugeInt[k] - borrow_num < 0) {
									result.HugeInt[k] = this.HugeInt[k] + 10 - h.HugeInt[k] - borrow_store;
										 borrow_num = 1;}
									
									
									if (h.HugeInt[k] - this.HugeInt[k] - borrow_num > 0) {
										
										 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[k] - borrow_store;
												borrow_num = 0;}
									
									
									
									if (this.HugeInt[k] - h.HugeInt[k] - borrow_num == 0) {
										result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[k] - borrow_store;
												borrow_num = 0;}
								 }
							 
							 }
							 
						 
						 
							 borrow_store = borrow_num; } 
						 result.sign = false;}
					 
					 // -----^^^^-----------------------------------------------------------------------------------------------------
					 
					         if (this.HugeInt[0] == h.HugeInt[0]) {
					        	 
					        	 for (int k = result.size - 1; k > 0; k--) {
					        		 
					        		 // compare to see which digit, after the first digit, is greater on either integer number
					        		 
					        		 for (int cmp = 1; cmp < this.size; cmp++) {
					        			 if (this.HugeInt[cmp] > h.HugeInt[cmp]) {
					        				 temp = 0;
					        				 break;}
					        			 
					        			 if (this.HugeInt[cmp] < h.HugeInt[cmp]) {
					        				 temp = 1;
					        				 break;}
					        			 
					        			 if (this.HugeInt[cmp] == h.HugeInt[cmp]) {
					        				 temp = -5;}}
					        		 
					        		 if (temp == 0) {
					        			 
					        			 if (this.HugeInt[k] > h.HugeInt[k]) {
					        				 
					        				 if (k == 0) {
												 
												 result.HugeInt[k] = Math.abs(this.HugeInt[k] - h.HugeInt[k] - borrow_num);}
					        				 else {
					        				 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[k] - borrow_num ;
					        				 borrow_num = 0; }}
								 
								 
								 if (this.HugeInt[k] < h.HugeInt[k]) {
									 
									 if (k == 0) {
										 
										 result.HugeInt[k] = Math.abs(this.HugeInt[k] - h.HugeInt[k] - borrow_num);}
			        				 else {
									 result.HugeInt[k] = this.HugeInt[k] + 10 - h.HugeInt[k] - borrow_num;
								     borrow_num = 1;}}
								 
								 
								 if (this.HugeInt[k] == h.HugeInt[k]) {
									 
									 if (k == 0) {
										 
										 result.HugeInt[k] = Math.abs(this.HugeInt[k] - h.HugeInt[k] - borrow_num);}
			        				 else {
									 
									 
									 
									 if (this.HugeInt[k] - h.HugeInt[k] - borrow_num < 0) {
										result.HugeInt[k] = this.HugeInt[k] + 10 - h.HugeInt[k] - borrow_num;
											 borrow_num = 1;}
										
										
										if (this.HugeInt[k] - h.HugeInt[k] - borrow_num > 0) {
											
											 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[k] - borrow_num;
													borrow_num = 0;}
										
										
										
										if (this.HugeInt[k] - h.HugeInt[k] - borrow_num == 0) {
											result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[k] - borrow_num;
													borrow_num = 0;}}} result.sign = false;}
							 
							 
							 
							if (temp == 1) {
								if (this.HugeInt[k] < h.HugeInt[k]) {
									
									if (k == 0) {
										 
										 result.HugeInt[k] = Math.abs(h.HugeInt[k] - this.HugeInt[k] - borrow_num);}
			        				 else {
									result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] - borrow_num ;
									borrow_num = 0;}}
								 
								 
								 if (this.HugeInt[k] > h.HugeInt[k]) {
									
									 if (k == 0) {
										 
										 result.HugeInt[k] = Math.abs(h.HugeInt[k] - this.HugeInt[k] - borrow_num);}
			        				 else {
									 result.HugeInt[k] = h.HugeInt[k] + 10 - this.HugeInt[k] - borrow_num;
											 borrow_num = 1;}}
								 
								 
								 if (this.HugeInt[k] == h.HugeInt[k]) {
									 
									 if (k == 0) {
										 
										 result.HugeInt[k] = Math.abs(h.HugeInt[k] - this.HugeInt[k] - borrow_num);}
			        				 else {
									 
									 
										if (  h.HugeInt[k] - this.HugeInt[k] - borrow_num < 0) {
										
									 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] + 10 - borrow_num;
											 borrow_num = 1;}
										
										
										if (h.HugeInt[k] - this.HugeInt[k] - borrow_num > 0) {
											result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] - borrow_num;
											borrow_num = 0;}
										
										
										
										if (h.HugeInt[k] - this.HugeInt[k] - borrow_num == 0) {
											
											 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] - borrow_num;
											 borrow_num = 0;}}} result.sign = true;}		 }
					        	 
					         }}
			 
			 
			 
			 // another case
			 
			 
			 if (this.sign == true && h.sign == true) {
				 
				 if (this.HugeInt[0] == h.HugeInt[0]) {
					 
					 
				for (int k = result.size - 1; k >= 0; k--) {
						 
						 for (int cmp = 1; cmp < this.size; cmp++) {
							 
							 if (this.HugeInt[cmp] > h.HugeInt[cmp]) {
								 
								 temp = 0;
								 
								 break;}
							 
						if (this.HugeInt[cmp] < h.HugeInt[cmp]) {
								 
								 temp = 1;
								 
								 break;}
						
						if (this.HugeInt[cmp] == h.HugeInt[cmp]) {
							
							 temp = -1;
						 }	 }
						 
						 if (temp == 0) {
							 
							 if (this.HugeInt[k] > h.HugeInt[k]) {
								 
								 if (k == 0) {
									 
									 result.HugeInt[k] = Math.abs(this.HugeInt[k] - h.HugeInt[k] - borrow_num);}
		        				 else {
								 
								
									 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[k] - borrow_num ;
									 
									 borrow_num = 0;}}
							 
							 
							 if (this.HugeInt[k] < h.HugeInt[k]) {
								 
								 if (k == 0) {
									 
									 result.HugeInt[k] = Math.abs(this.HugeInt[k] - h.HugeInt[k] - borrow_num);}
		        				 else {
								 result.HugeInt[k] = this.HugeInt[k] + 10 - h.HugeInt[k] - borrow_num;
								  borrow_num = 1;}}
							 
							 
							 if (this.HugeInt[k] == h.HugeInt[k]) {
								 
								 if (k == 0) {
									 
									 result.HugeInt[k] = Math.abs(this.HugeInt[k] - h.HugeInt[k] - borrow_num);}
		        				 else {
								 
								 
								 
									if (this.HugeInt[k] - h.HugeInt[k] - borrow_num < 0) {
									
								 result.HugeInt[k] = this.HugeInt[k] + 10 - h.HugeInt[k] - borrow_num;
								 borrow_num = 1;}
									
									
									if (this.HugeInt[k] - h.HugeInt[k] - borrow_num > 0) {
										
										 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[k] - borrow_num;
												 
												 
										  borrow_num = 0;}
									
									
									
									if (this.HugeInt[k] - h.HugeInt[k] - borrow_num == 0) {
										
										 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[k] - borrow_num;
												 
												 
										  borrow_num = 0;
												 
												 
											}}} result.sign = true;}
						 
						 
						 
						if (temp == 1) {
							
							
							 
							 if (this.HugeInt[k] < h.HugeInt[k]) {
								 
								 if (k == 0) {
									 
									 result.HugeInt[k] = Math.abs(h.HugeInt[k] - this.HugeInt[k] - borrow_num);}
		        				 else {
								 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] - borrow_num ;
									 
									 borrow_num = 0;}}
							 
							 
							 if (this.HugeInt[k] > h.HugeInt[k]) {
								 
								 if (k == 0) {
									 
									 result.HugeInt[k] = Math.abs(h.HugeInt[k] - this.HugeInt[k] - borrow_num);}
		        				 else {
								 result.HugeInt[k] = h.HugeInt[k] + 10 - this.HugeInt[k] - borrow_num;
								 borrow_num = 1;
								 }}
							 
							 
							 if (this.HugeInt[k] == h.HugeInt[k]) {
								 
								 if (k == 0) {
									 
									 result.HugeInt[k] = Math.abs(h.HugeInt[k] - this.HugeInt[k] - borrow_num);}
		        				 else {
								 
								 if (  h.HugeInt[k] - this.HugeInt[k] - borrow_num < 0) {
									
								 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] + 10 - borrow_num;
								 borrow_num = 1;
								 }
									
									
									if (h.HugeInt[k] - this.HugeInt[k] - borrow_num > 0) {
										
										 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] - borrow_num;
										 borrow_num = 0;}
									
									
									
									if (h.HugeInt[k] - this.HugeInt[k] - borrow_num == 0) {
										
										 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] - borrow_num;
												 
												 
										  borrow_num = 0;
												 
												 
											} }	}  result.sign = false;} }}
				 
				 // ------------------------------------------------------------------------------------------------------------------
				 
				 if (this.HugeInt[0] < h.HugeInt[0]) {
					 
					 
					 for (int k = result.size - 1; k >= 0; k--) {
						 
						 if (this.HugeInt[k] > h.HugeInt[k]) {
							 
							 if (k == 0) {
								 result.HugeInt[k] = Math.abs(h.HugeInt[k] - this.HugeInt[k] - borrow_num);}
							 
							 else {
								 
								 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] + 10 - borrow_num;
							 
							 borrow_num = 1;

							 }}
						 
						 if (this.HugeInt[k] < h.HugeInt[k]) {
							 
							 
							 if (k == 0) {
								 
								 result.HugeInt[k] = Math.abs(h.HugeInt[k] - this.HugeInt[k] - borrow_num);}
							 
							 else {
								 
								 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] - borrow_num;
							 
							 borrow_num = 0;
							 
							 
							 }}
						 

						 if (this.HugeInt[k] == h.HugeInt[k]) {
							 
							 if (k == 0) {
								 
								 result.HugeInt[k] = Math.abs(h.HugeInt[k] - this.HugeInt[k] - borrow_num);}
							 
							 else {
							 
							 if (h.HugeInt[k] - this.HugeInt[k] - borrow_num < 0) {
								result.HugeInt[k] = h.HugeInt[k] + 10 - this.HugeInt[k] - borrow_num;
									 borrow_num = 1;}
								
								
								if (h.HugeInt[k] - this.HugeInt[k] - borrow_num > 0) {
									
									 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] - borrow_num;
											borrow_num = 0;}
								
								
								
								if (this.HugeInt[k] - h.HugeInt[k] - borrow_num == 0) {
									result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[k] - borrow_num;
											borrow_num = 0;}
							 }
						 
						 }} result.sign = false;}
				 
				 //=========================================================================================================================
				 
				 if (this.HugeInt[0] > h.HugeInt[0]) {
					 
					 for (int k = result.size - 1; k >= 0; k--) {
							
						 
						 if (this.HugeInt[k] > h.HugeInt[k]) {
							 
							 if (k == 0) {
								 result.HugeInt[k] = Math.abs(this.HugeInt[k] - h.HugeInt[k] - borrow_num);}
							 
							 else {
								 
								 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[k] - borrow_num;
							 
							 borrow_num = 0;
							 
							 
							 }
							 
							}
						 
						 if (this.HugeInt[k] < h.HugeInt[k]) {
							 
							 
							 if (k == 0) {
								 
								 result.HugeInt[k] = Math.abs(this.HugeInt[k] - h.HugeInt[k] - borrow_num);}
							 
							
							 else {
								 
								 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[k] + 10 - borrow_num;
							 
							 borrow_num = 1;

							 }} 
						 
					 
						 if (this.HugeInt[k] == h.HugeInt[k]) {
							 
							 if (k == 0) {
								 
								 result.HugeInt[k] = Math.abs(this.HugeInt[k] - h.HugeInt[k] - borrow_num);}
							 
							 else {
							 
							 if (h.HugeInt[k] - this.HugeInt[k] - borrow_num < 0) {
								result.HugeInt[k] = this.HugeInt[k] + 10 - h.HugeInt[k] - borrow_num;
									 borrow_num = 1;}
								
								
								if (h.HugeInt[k] - this.HugeInt[k] - borrow_num > 0) {
									
									 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[k] - borrow_num;
											borrow_num = 0;}
								
								
								
								if (this.HugeInt[k] - h.HugeInt[k] - borrow_num == 0) {
									result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[k] - borrow_num;
											borrow_num = 0;}
							 }
						 
						 }
						 
					 
					 
					 } 
					 result.sign = true;}}}
		
	}
	
	
	if (this.size != h.size) {
		
		
		
		if (this.size > h.size) {
			
			int index2 = h.size - 1;
			
			
			 if (this.sign == false && h.sign == false) {
				 
				 result.size = this.size;
				 result.HugeInt = new int[this.size];
	
					 for (int k = result.size - 1; k >= 0; k--) {
						 
						 
						 if (index2 <= -1) {
							 
							 if (this.HugeInt[k] - borrow_num < 0) {
							
							 
							 result.HugeInt[k] = this.HugeInt[k] - borrow_num + 10;
							 borrow_num = 1;}
							 
							 else {result.HugeInt[k] = this.HugeInt[k] - borrow_num;
							 borrow_num = 0;}
							 
						 }
						 
						 
						 
						 
						 
						 else {
						 
							 if (this.HugeInt[k] > h.HugeInt[index2]) {
								 
								
									 
									 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[index2] - borrow_num;
								 
								 borrow_num = 0;
								 
								 
								 
								 
								}
							 
							 if (this.HugeInt[k] < h.HugeInt[index2]) {
								 
								 
							
									 
									 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[index2] + 10 - borrow_num;
								 
								 borrow_num = 1;

								 }
							 
							 
							 
							 if (this.HugeInt[k] == h.HugeInt[index2]) {
								 
								 
								 
								 if (this.HugeInt[k] - h.HugeInt[index2] - borrow_num < 0) {
									result.HugeInt[k] = this.HugeInt[k] + 10 - h.HugeInt[index2] - borrow_num;
										 borrow_num = 1;}
									
									
									if (this.HugeInt[k] - h.HugeInt[index2] - borrow_num > 0) {
										
										 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[index2] - borrow_num;
												borrow_num = 0;}
									
									
									
									if (this.HugeInt[k] - h.HugeInt[index2] - borrow_num == 0) {
										result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[index2] - borrow_num;
												borrow_num = 0;}
								 
							 
							 }
							 
							 
							 
						 }
						 index2--;} 
					 result.sign = false;}
			 
			 
			 
if (this.sign == true && h.sign == true) {
	 result.size = this.size;
	 result.HugeInt = new int[this.size];

		 for (int k = result.size - 1; k >= 0; k--) {
			 
			 
			 if (index2 <= -1) {
				 
				 if (this.HugeInt[k] - borrow_num < 0) {
				
				 
				 result.HugeInt[k] = this.HugeInt[k] - borrow_num + 10;
				 borrow_num = 1;}
				 
				 else {result.HugeInt[k] = this.HugeInt[k] - borrow_num;
				 borrow_num = 0;}
				 
			 }
			 
			 
			 
			 
			 
			 else {
			 
				 if (this.HugeInt[k] > h.HugeInt[index2]) {
					 
					
						 
						 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[index2] - borrow_num;
					 
					 borrow_num = 0;
					 
					 
					 
					 
					}
				 
				 if (this.HugeInt[k] < h.HugeInt[index2]) {
					 
					 
				
						 
						 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[index2] + 10 - borrow_num;
					 
					 borrow_num = 1;

					 }
				 
				 
				 
				 if (this.HugeInt[k] == h.HugeInt[index2]) {
					 
					 
					 
					 if (this.HugeInt[k] - h.HugeInt[index2] - borrow_num < 0) {
						result.HugeInt[k] = this.HugeInt[k] + 10 - h.HugeInt[index2] - borrow_num;
							 borrow_num = 1;}
						
						
						if (this.HugeInt[k] - h.HugeInt[index2] - borrow_num > 0) {
							
							 result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[index2] - borrow_num;
									borrow_num = 0;}
						
						
						
						if (this.HugeInt[k] - h.HugeInt[index2] - borrow_num == 0) {
							result.HugeInt[k] = this.HugeInt[k] - h.HugeInt[index2] - borrow_num;
									borrow_num = 0;}
					 
				 
				 }
				 
				 
				 
			 }
			 index2--;}
					 result.sign = true;}


if (this.sign == true && h.sign == false) {
	
	this.sign = false;
	
	result = this.add(h);
	
	result.sign = true;
			
}
			 
if (this.sign == false && h.sign == true) {
	
	h.sign = false;
	
	result = this.add(h);
	result.sign = false;
	
	return result;
			
}			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
				}
		// -------------------------------------------------------------------------------------------------------------
		
		
		if (this.size < h.size) {
			
			int index2 = this.size - 1;
			
			
			 if (this.sign == false && h.sign == false) {
				 
				 result.size = h.size;
				 result.HugeInt = new int[h.size];
	
					 for (int k = result.size - 1; k >= 0; k--) {
						 
						 
						 if (index2 <= -1) {
							 
							 if (h.HugeInt[k] - borrow_num < 0) {
							
							 
							 result.HugeInt[k] = h.HugeInt[k] - borrow_num + 10;
							 borrow_num = 1;}
							 
							 else {result.HugeInt[k] = h.HugeInt[k] - borrow_num;
							 borrow_num = 0;}
							 
						 }
						 
						 
						 
						 
						 
						 else {
						 
							 if (h.HugeInt[k] > this.HugeInt[index2]) {
								 
								
									 
									 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[index2] - borrow_num;
								 
								 borrow_num = 0;
								 
								 
								 
								 
								}
							 
							 if (h.HugeInt[k] < this.HugeInt[index2]) {
								 
								 
							
									 
									 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[index2] + 10 - borrow_num;
								 
								 borrow_num = 1;

								 }
							 
							 
							 
							 if (h.HugeInt[k] == this.HugeInt[index2]) {
								 
								 
								 
								 if (h.HugeInt[k] - this.HugeInt[index2] - borrow_num < 0) {
									result.HugeInt[k] = h.HugeInt[k] + 10 - this.HugeInt[index2] - borrow_num;
										 borrow_num = 1;}
									
									
									if (h.HugeInt[k] - this.HugeInt[index2] - borrow_num > 0) {
										
										 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[index2] - borrow_num;
												borrow_num = 0;}
									
									
									
									if (h.HugeInt[k] - this.HugeInt[index2] - borrow_num == 0) {
										result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[index2] - borrow_num;
												borrow_num = 0;}
								 
							 
							 }
							 
							 
							 
						 }
						 index2--;}
					 result.sign = true;}
			 
			
			
if (this.sign == true && h.sign == true) {
				 
	 result.size = h.size;
	 result.HugeInt = new int[h.size];

	 
		 for (int k = result.size - 1; k >= 0; k--) {
			 
			 
			 if (index2 <= -1) {
				 
				 if (h.HugeInt[k] - borrow_num < 0) {
				
				 
				 result.HugeInt[k] = h.HugeInt[k] - borrow_num + 10;
				 borrow_num = 1;}
				 
				 else {result.HugeInt[k] = h.HugeInt[k] - borrow_num;
				 borrow_num = 0;}
				 
			 }
			 
			 
			 
			 
			 
			 else {
			 
				 if (h.HugeInt[k] > this.HugeInt[index2]) {
					 
					
						 
						 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[index2] - borrow_num;
					 
					 borrow_num = 0;
					 
					 
					 
					 
					}
				 
				 if (h.HugeInt[k] < this.HugeInt[index2]) {
					 
					 
				
						 
						 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[index2] + 10 - borrow_num;
					 
					 borrow_num = 1;

					 }
				 
				 
				 
				 if (h.HugeInt[k] == this.HugeInt[index2]) {
					 
					 
					 
					 if (h.HugeInt[k] - this.HugeInt[index2] - borrow_num < 0) {
						result.HugeInt[k] = h.HugeInt[k] + 10 - this.HugeInt[index2] - borrow_num;
							 borrow_num = 1;}
						
						
						if (h.HugeInt[k] - this.HugeInt[index2] - borrow_num > 0) {
							
							 result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[index2] - borrow_num;
									borrow_num = 0;}
						
						
						
						if (h.HugeInt[k] - this.HugeInt[index2] - borrow_num == 0) {
							result.HugeInt[k] = h.HugeInt[k] - this.HugeInt[index2] - borrow_num;
									borrow_num = 0;}
					 
				 
				 }
				 
				 
				 
			 }
			 index2--;}
					 result.sign = false;}




if (this.sign == true && h.sign == false) {
	this.sign = false;
	
	result = this.add(h);
	
	result.sign = true;
	
	
}
			
if (this.sign == false && h.sign == true) {
	
	h.sign = false;
	
	result = this.add(h);
	
	result.sign = false;
	
	
}		
			
			
		}
		
	}
	
	
	int  check = 0;
	int check2 = 0;
	int p = 0;
		
		
		if (result.HugeInt[0] == 0) {
			
			for (p = 0; p < result.size; p++) {
				
				if (result.HugeInt[p] == 0) {
					check += 1;
					
				}
				
				else {
					
				
					
				}
				
				if (check == result.size  ) {
					
					result.size = 0;
					break;
					
			
				}
				
			}
			int ind = -1; 
			int store_ind = 0;
			int index_stored = 0;
			  
		    // traverse in the array and find the first 
		    // non-zero number 
		    for (int i = 0; i < result.size ; i++) { 
		        if (result.HugeInt[i] != 0) { 
		            ind = i; 
		            break; 
		        } 
		    }
		    
		    store_ind = ind;
			
		    for (int i = 0; i < result.size ; i++) { 
		    	
		    	if (i < ind) {
		       
		    	if (result.HugeInt[i] == 0){
		    		
		    	}}
		    	
		    	else {
		    	
		    
		    		result.HugeInt[index_stored] = result.HugeInt[i];
		    		index_stored++;
		    	
			

		    	}
			

		}
		   
		    
		    
		result.size -= store_ind;
		
		    
		  
		
		
		}

	return result;
	
}




public int compareTo(HugeInteger h){
	
	int count = 0;
	boolean positive = false;
	boolean negative = true;
    
	// false means positive number and true means negative
	if (this.sign == positive && h.sign == positive && h!= null && this != null){        
        if (this.size > h.size){
            return 1;
        }
        else if (h.size > this.size){
            return -1;
        }
        else if (this.size == h.size){
            
        	while(count <= this.size - 1){
        		
        		 if (this.HugeInt[count] == h.HugeInt[count]){
                     // nothing is executed for this condition
                 }
                if (this.HugeInt[count] > h.HugeInt[count]){ // check for the numbers after first digit and compare them rightly so
                    return 1;
                }
                if (this.HugeInt[count] < h.HugeInt[count]){
                    return -1;
                }
            count++;}
        	
     
            return 0;       // return the default value 0, of integers being equal
        }
    }
   if (this.sign == negative && h.sign == negative && h!= null && this != null){   
	   // if both are negative, the negative number with a bigger magnitude is considered the smaller one, so bigger size of this means its smaller
        if (this.size > h.size){
            return (-1);
        }
        else if (h.size > this.size){
            return 1;
        }
        else if (this.size == h.size){
        	while(count <= h.size - 1){ // size doesn't matter here, can use h or this
        		
        		 if (this.HugeInt[count] == h.HugeInt[count]){
        			 
                     // nothing is executed for this condition
                 }
                if (this.HugeInt[count] > h.HugeInt[count]){
                    return -1;
                }
                if (this.HugeInt[count] < h.HugeInt[count]){
                    return 1;
                }
            count++;}
        	
            return 0; // default return
        }
    }
   
   if (this.sign == negative && h.sign == positive ) {
	   
	   return -1;
	   
   }
   
 if (this.sign == positive && h.sign == negative ) {
	   
	   return 1;
	   
   }
    
    return 1; // default return
}




public HugeInteger multiply(HugeInteger h){
	
	HugeInteger resultant = new HugeInteger("000");
	
	if (this.size == 1 && h.size == 1) {
		
		 resultant.HugeInt = new int[this.size] ;
		 
		 resultant.size = this.size;
		 
		 
		 resultant.HugeInt[0] = (this.HugeInt[0])*(h.HugeInt[0]);
		 
		 if (this.sign == true && h.sign == true && this.HugeInt[0] != 0 && h.HugeInt[0] != 0 && resultant != null) {
			 
			 resultant.sign = false;
		 }
		 
		 if (this.sign == false && h.sign == false && this.HugeInt[0] != 0 && h.HugeInt[0] != 0 && resultant != null) {
			 
			 resultant.sign = false;
		 }
		 
		 
		 if (this.sign == true && h.sign == false && this.HugeInt[0] != 0 && h.HugeInt[0] != 0 && resultant != null) {
			 
			 resultant.sign = true;}
		 
		 
		 if (this.sign == false && h.sign == true && this.HugeInt[0] != 0 && h.HugeInt[0] != 0 && resultant != null) {
			 
			 resultant.sign = true;}
		 
		return resultant;
		
		
	}
	
	else {
	
	int sum_store = 0;
	int sum_total = 0;
	int carry_mul = 0;
	int temp = 0;
	int counter = 0;
	String array_string2 = "";
	int carry_checker;
	int mul_nums;
	
	if (this.size >h.size) {
		
		
		if ((h.size == 1 && h.HugeInt[0] == 0) || h.size == 0) {
			
			resultant.size = 1;
			 resultant.HugeInt = new int[resultant.size];
			 resultant.HugeInt[0] = 0;
			
			resultant.sign = false;
			return resultant;
		}
		
		else {
		resultant.size = this.size + h.size;
		 resultant.HugeInt = new int[resultant.size];
		
		 for(int i = h.size - 1; i >= 0; i--){
			 
			 int store_ind = i + resultant.size - h.size; // reset the index value after each iteration of the outer loop, for the next addition
		 // index reset, as we must store the sums on the same indexes, not separate arrays to be added later
     
	            for (int j = this.size - 1; j >= 0; j--) {
	            	
	            	   mul_nums = h.HugeInt[i] * this.HugeInt[j];
	            	   
	                   resultant.HugeInt[store_ind] +=  mul_nums % 10; // last index isn't updated later at all unless 10
	                   
	                   mul_nums /=  10;                                // store the first digit of the result of multipication, due to the / operator, which is added to another value of modulo
	                   
	                   resultant.HugeInt[store_ind - 1] +=  mul_nums; // indexes before last are updated as values later on are added on to them
	                   
	                   store_ind -= 1; // update the index to move to the left
	           
	            
	        }
		
		 }
		 
		 carry_checker = resultant.size - 1;
		 
		 while (carry_checker > 0){
	            
	            if(resultant.HugeInt[carry_checker] >= 10){
	            	
	                int carry= resultant.HugeInt[carry_checker];
	                
	                resultant.HugeInt[carry_checker] %= 10; // the modulo expression stores the leats significant digit, division takes the most significant for addition to the next index
	                resultant.HugeInt[carry_checker - 1] += (carry/10);
	            }
	            
	            carry_checker--;
	        }
			
		}
	
		
	}
	
	if (this.size < h.size) {
		
		
	if ((this.size == 1 && this.HugeInt[0] == 0) || this.size == 0) {
			
			resultant.size = 1;
			 resultant.HugeInt = new int[resultant.size];
			 resultant.HugeInt[0] = 0;
			
			resultant.sign = false;
			return resultant;
	}
	
	else {
		
		resultant.size = this.size + h.size;
		 resultant.HugeInt = new int[resultant.size];
		
		 for(int i = this.size - 1; i >= 0; i--){
			 
			 int store_ind = i + resultant.size - this.size;
			 
		     
	            for (int j = h.size - 1; j >= 0; j--) {
	            	
	            	   mul_nums = h.HugeInt[j] * this.HugeInt[i];
	            	   
	                   resultant.HugeInt[store_ind] +=  mul_nums % 10;
	                   
	                   mul_nums /=  10;
	                   
	                   resultant.HugeInt[store_ind - 1] +=  mul_nums;
	                   
	                   store_ind -= 1;
	           
	            
	        }
		
		 }
		 
		
		 
	 carry_checker = resultant.size - 1;
		 
		 while (carry_checker > 0){
	            
	            if(resultant.HugeInt[carry_checker] >= 10){
	            	
	                int carry= resultant.HugeInt[carry_checker];
	                
	                
	                resultant.HugeInt[carry_checker] %= 10; 
	                
	                
	                resultant.HugeInt[carry_checker - 1] += (carry/10);
	            }
	            
	            carry_checker--;
	        }
		
		
	}
	}
	
if (this.size == h.size) {
		
		resultant.size = this.size + h.size;
		 resultant.HugeInt = new int[resultant.size];
		 
		 // doesn't matter which way we use the loop, both arrays are the same size
		
		 for(int i = this.size - 1; i >= 0; i--){
			 
			 int store_ind = i + resultant.size - this.size; //
		 
    
		     for (int j = h.size - 1; j >= 0; j--) {
	            	
          	   mul_nums = h.HugeInt[j] * this.HugeInt[i];
          	   
                 resultant.HugeInt[store_ind] +=  mul_nums % 10;
                 
                 mul_nums /=  10;
                 
                 resultant.HugeInt[store_ind - 1] +=  mul_nums;
                 
                 store_ind -= 1;
         
          
      }
		
		 }
		 
		 
 carry_checker = resultant.size - 1;
		 
		 while (carry_checker > 0){
	            
	            if(resultant.HugeInt[carry_checker] >= 10){
	            	
	                int carry= resultant.HugeInt[carry_checker];
	                
	                resultant.HugeInt[carry_checker] %= 10;
	                
	                
	                
	                resultant.HugeInt[carry_checker - 1] += (carry/10);
	            }
	            
	            carry_checker--;
	        }
		
		
		
		
	}




int  check = 0;
int check2 = 0;
int p = 0;
	
	
	if (resultant.HugeInt[0] == 0) {
		
		for (p = 0; p < resultant.size; p++) {
			
			if (resultant.HugeInt[p] == 0) {
				check += 1;
				
			}
			
			else {
				
			
				
			}
			
			if (check == resultant.size  ) {
				
				resultant.size = 0;
				resultant.sign = false;
				
				break;
				
		
			}
			
			
			
		}
		
		
		
		
		int ind = -1; 
		int store_ind = 0;
		int index_stored = 0;
		  
	    // traverse in the array and find the first 
	    // non-zero number 
	    for (int i = 0; i < resultant.size ; i++) { 
	        if (resultant.HugeInt[i] != 0) { 
	            ind = i; 
	            break; 
	        } 
	    }
	    
	    store_ind = ind;
		
	    for (int i = 0; i < resultant.size ; i++) { 
	    	
	    	if (i < ind) {
	       
	    	if (resultant.HugeInt[i] == 0){
	    		
	    	}}
	    	
	    	else {
	    	
	    
	    		resultant.HugeInt[index_stored] = resultant.HugeInt[i];
	    		index_stored++;
	    	
		

	    	}
		

	}
	   
	    
	    
	resultant.size -= store_ind;
	
	    
	  
	
	
	}
	
	if (resultant.size == 0) {
		resultant.sign = false;
	}
	
	
	else {
	
	if (this.sign == true && h.sign == true) {
		if (this.size == 0 || h.size == 0) {
			resultant.sign = false;
		}
		else {
		resultant.sign = false;}
	}
	if (this.sign == false && h.sign == true) {
		
		if (h.size == 0 || this.size == 0) {
			resultant.sign = false;
		}
		else {
		resultant.sign = true;}
	}
if (this.sign == true && h.sign == false) {
		
		resultant.sign = true;
	}

if (this.sign == false && h.sign == false) {
	
	resultant.sign = false;
}
	
	}
	
	
	if (resultant.size == 0) {
		resultant.HugeInt[0] = 0;
		resultant.sign = false;
	}
	
	return resultant;
    

}

}

public String toString(){
	
	 boolean negative2 = true;
    String string_result = "";
    if (sign == negative2){
    	string_result += "-";
    }
    
    int str_index = 0;
    while( str_index < size ){
    	string_result += HugeInt[str_index];
    	str_index++;
    }
    return string_result;
}}
	


