package designPatterns;

public class User {
	
	private int id;
	private String name;
	private String address;
	
	public User(userBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.address = builder.address;
	}
	
	public int getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public String getAddress() {
		return address;
	}



	static class userBuilder{
		private int id;
		private String name;
		private String address;
		
		public userBuilder() {
			
		}

		public userBuilder setId(int id) {
			this.id = id;
			return this;
		}

		public userBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public userBuilder setAddress(String address) {
			this.address = address;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
		
		 
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
	} 
	
	
}
