package Resources;

//A enum is special class which has collection of constants or methods
//In Enum Constructor is executed and then parsed in it
public enum APIResources 
{
	AddPlaceAPI("maps/api/place/add/json"),
	getPlaceAPI("maps/api/place/get/json"),
	deletePlaceAPI("maps/api/place/delete/json");
	private String resource;
	
	
	APIResources(String resource) 
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
}

