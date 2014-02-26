package project;
/**
 * Course is a class that will be used to add a course in a gradebook application
 * @author mgurnett
 *
 */
public class Course
{
/************************************************************* * Instance Variables *************************************************************/
// The course title
private String title;
// The course code
private String code ;
// The course term
private String term;
// The course isActive label
private boolean isActive;

/**
* Constructor.
* @param title Title
* @param c Code
* @param t Term
* @param act isActive  
*/
public Course(String title, String c, String t, boolean act) {
	this.title=title;
	this.code=c;
	this.term=t;
	this.isActive=act;
}

/************************************************************* * Accessor Methods *************************************************************/
/**
* Gets the courses ’s title
* @return the title of the course */
public String getTitle()
{
	return this.title;
}
/**
* Gets the courses ’s code
* @return the code of the course */
public String getCode()
{
	return this.code;
}
/**
* Gets the courses ’s term
* @return the term of the course */
public String getTerm()
{
	return this.code;
}
/**
* Returns true if the course is the active course
* @return true if the course is active */
public boolean isActive()
{
	return this.isActive;
}
/************************************************************* * Mutator Methods *************************************************************/
/**
* Sets the courses ’s title
* @param tle the new title of the course */
public void setTitle(String title)
{
	this.title=title;
}
/**
* Sets the courses ’s code
* @param c the code of the course */
public void getCode(String c)
{
    this.code=c;
}
/**
* Sets the courses ’s term
* @param t the term of the course */
public void getTerm(String t)
{
	this.term=t;
}
/**
* Sets the active course label
* @param act the active label for the course*/
public void isActive(boolean act)
{
	this.isActive=act;
}
}