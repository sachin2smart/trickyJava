class A {

  int t() { 
	return 1; 
  }

  static A a =  new A() { 					// -----Anonymous static inner class-----//
	int t() { 	
		return 2; 
	} 
  };

  static class B {						// -----static inner class-----//
    static int t() {
	return 3;
    }

    static class C {						// -----Inner class of a static inner class-----//
    	static int t() {
		return 4;
    	}
    }

  }
   
  class D { 							// ------Non-static inner class-----//
	int t() {
		System.out.println(d.t());
		System.out.println(a.t());
		return 5;
    	}
  }

  D d = new D() { 						// -----Anonymous non-static inner class-----//
	int t() {
	    return 6;
        }
  };

  public static void main(String args[]){
      
	System.out.println(a.t());    // print : 2

	A a = new A();
	System.out.println(a.t());    // print : 1

	B b = new B();
	System.out.println(b.t());    // print : 3

	System.out.println(B.t());    // print : 3

	System.out.println(B.C.t());  // print : 4
	
	A.D ad = a.new D();
	System.out.println(ad.t());   // print : first it prints "6" then it will print "2" and then it will print "5"


// 	A c = new B();  //Not possible, the error is:- "incompatible types: B cannot be converted to A"

//	B d = new A();  //Not possible, the error is:- "incompatible types: A cannot be converted to B"        

//	C c = new C();  //Not possible, the error is:- "non-static variable this cannot be referenced from a static context"

  }

}