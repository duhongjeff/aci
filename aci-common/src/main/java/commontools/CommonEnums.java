package commontools;

public class CommonEnums {

	   public enum DateFormat{
	      yyyyMMdd;
	   }
	   
	   public enum Status{
		   
		   A("Active"),C("Closed");
		   
		    Status(String desc) {
				this.desc = desc;
			}

			private final String desc;

			public String getStatus() {
				return desc;
			}
			
		   
	   }
}
