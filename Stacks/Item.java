import java.util.Date;
/***********************************************************************************************************************
 *Class Name:			Item
 *Author/s Name:		Josue Carlos Zenteno Yave
 *						Marina Prieto Pech
 *						Ismael Camacho Talavera
 *Class Version:		1.0
 *Class Description:	Each Item is composed of:
 *                       - Title: Title or headline of the news item
 *                       - Category: Category of the news item. Each item can only be from one of the following
 *                       - Description: Brief summary of the news item
 *                       - Author: Author
 *                       - Date: Publication date of the news item
 **********************************************************************************************************************/
public class Item {
//Creating the variables
    private String Title, Category, Description, Author;
    private Date Date;
/***********************************************************************************************************************
 *Method Name: Item (Constructor)
 *Author/s Name:	Josue Carlos Zenteno Yave
 *					Marina Prieto Pech
 *					Ismael Camacho Talavera
 *Description of the Method: Constructor of the class Item.
 * Calling arguments: String Title, String Category, String Description, String Author, Date Date.
 **********************************************************************************************************************/
    public Item (String Title, String Category, String Description, String Author, Date Date) {
       this.Title = Title;
       this.Category = Category;
       this.Description = Description;
       this.Author = Author;
       this.Date = Date;
    }
    //Getters and Setters
    public String getTitle() { return Title; }

    public void setTitle(String title) { Title = title; }

    public String getCategory() { return Category; }

    public void setCategory(String category) { Category = category; }

    public String getDescription() { return Description; }

    public void setDescription(String description) { Description = description; }

    public String getAuthor() { return Author; }

    public void setAuthor(String author) { Author = author; }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }
/***********************************************************************************************************************
 *Method Name: toString
 *Author/s Name:	Josue Carlos Zenteno Yave
 *					Marina Prieto Pech
 *					Ismael Camacho Talavera
 *Description of the Method: Method that returns all the information  of an Item
 *Return Value: String
 **********************************************************************************************************************/
    public String toString() {
        return
                "-----------------------------------------------------------------------------------------------------------------------------------------------\n"+
                "Title: " + Title + "\n" +
                "Category: " + Category + "\n" +
                "Description: " + Description + "\n" +
                "Author: " + Author + "\n" +
                "Date: " + Date + "\n" +
                "------------------------------------------------------------------------------------------------------------------------------------------------\n";
    }
}
