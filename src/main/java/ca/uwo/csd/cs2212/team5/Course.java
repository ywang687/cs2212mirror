package ca.uwo.csd.cs2212.team5;
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
* Gets the course title
* @return the title of the course */
public String getTitle()
{
	return this.title;
}
/**
* Gets the course code
* @return the code of the course */
public String getCode()
{
	return this.code;
}
/**
* Gets the course term
* @return the term of the course */
public String getTerm()
{
	return this.term;
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
* Sets the course title
* @param tle the new title of the course */
public void setTitle(String title)
{
	this.title=title;
}
/**
* Sets the course code
* @param c the code of the course */
public void setCode(String c)
{
    this.code=c;
}
/**
* Sets the course term
* @param t the term of the course */
public void setTerm(String t)
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