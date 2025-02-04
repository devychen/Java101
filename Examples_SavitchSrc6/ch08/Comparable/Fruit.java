public class Fruit implements Comparable
{
	private String fruitName;

	public Fruit()
	{
		fruitName = "";
	}
	public Fruit(String name)
	{
		fruitName = name;
	}
	public void setName(String name)
	{
		fruitName = name;
	}
	public String getName()
	{
		return fruitName;
	}
	public int compareTo(Object o)
	{
		if ((o != null) &&
		    (o instanceof Fruit))
		{
			Fruit otherFruit = (Fruit) o;
			return (fruitName.compareTo(otherFruit.fruitName));
/*** Alternate definition of comparison using fruit length ***/
/*
			if (fruitName.length() > otherFruit.fruitName.length())
				return 1;
			else if (fruitName.length() < otherFruit.fruitName.length())
				return -1;
			else
				return 0;
*/
		}
		return -1;		// Default if other object is not a Fruit
	}
}