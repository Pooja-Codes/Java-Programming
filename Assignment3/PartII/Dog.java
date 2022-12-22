
public class Dog {
        private int age;
        private String owner;
        private String breed;
        public Dog() {
        	this.age=0;
        	this.owner="unknown";
        	this.breed="unknown";
        }
        public Dog(int age,String owner,String breed) {
        	this.age=age;
        	this.owner=owner;
        	this.breed=breed;
        }
        
        public static boolean hasSameOwner(Dog d1,Dog d2) {
        	return d1.owner.equals(d2.owner);
        }
        public static double avgAge(Dog[] dogs) {
        	double sum=0;
        	for (int i=0;i<dogs.length;i++) {
        		sum+=dogs[i].age;
        	}
        	return sum/dogs.length;
        }
        
        public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getOwner() {
			return owner;
		}

		public void setOwner(String owner) {
			this.owner = owner;
		}

		public String getBreed() {
			return breed;
		}

		public void setBreed(String breed) {
			this.breed = breed;
		}
		public String toString() {
			return this.breed+":"+"Owner:"+this.owner+",Age:"+this.age;
		}
		public static void main(String[] args) {
                
                Dog[] dogs = new Dog[5];
                dogs[0] = new Dog(4, "Stephen Colbert", "Boxer");
                dogs[1]= new Dog(1,"Worship","Maltipoo");
                dogs[2]=new Dog(3,"Stephen Colbert","Dobermann");
                dogs[3]=new Dog(12,"John Smith","Labrador");
                dogs[4]=new Dog(2,"Alice","Bichon");
                System.out.println(hasSameOwner(dogs[0],dogs[1]));//different so false
                System.out.println(hasSameOwner(dogs[0],dogs[2]));//same so true
                System.out.println(avgAge(dogs));
                
                System.out.println("old owner of dog1 -> "+dogs[1].getOwner());
                dogs[1].setOwner("Pooja");
                System.out.println("new owner of dog1 -> "+dogs[1].getOwner());
                
                System.out.println(dogs[3].toString());
                Dog myDog=new Dog(8,"Dexter Morgan","Corgi");
                System.out.println(myDog.toString());
        }
}