    
import java .util.Scanner;
import java.util.ArrayList;
public class Main {
public static void main(String[] args) {
Scanner sc= new Scanner (System.in);
ArrayList<Library>books = new ArrayList<>();
int c;
do {
System.out.println("***********************");

Library lib = new Library();
lib.addnew(sc);
books.add(lib);
System.out.println("Do you want to add more books? enter 0 to stop, 1 to continue)");
c = sc.nextInt();
sc.nextLine(); // Clear the buffer
} while(c != 0);
int ch=0;
Library ob=new Library();
do {
System.out.println("******MENU******\n1.Display\n2.Remove a book\n3.Issue a book\n4.Return abook\n5.EXIT:");

ch=sc.nextInt();
sc.nextLine();
switch(ch) {
case 1:

for (Library currentBook : books) {// get all the objects store inarrayList

currentBook.display();
}
break;

case 2:

ob.removerecord(sc,books);
break;

case 3:
ob.issue(sc,books);
break;

case 4:
ob.ReturnBook(sc, books, ob);
break;
case 5:
System.out.println("existingg!!....");
break;
}
}while(ch!=5);

}
}
class Library{
String name;
String authorname;
int id;
Library(){
}
void addnew(Scanner sc) {
System.out.println("enter name of book:");
name=sc.nextLine();
System.out.println("enter id:");

id = sc.nextInt();
sc.nextLine();
while (true) {
System.out.println("enter name of author of book:");
authorname = sc.nextLine();
if (authorname.matches("[a-zA-Z ]+")) {
break;
} else {

System.out.println("Invalid input! Author name should contain only letters.");
}
}

}
void display() {

System.out.println("------------------------------------------------------------");

System.out.printf("%-20s %-20s %-10s%n", "Book Name",

"Author", "ID");

System.out.printf("%-20s %-20s %-10s%n", name,

authorname, id);

}
void removerecord(Scanner sc, ArrayList<Library> books ) {
System.out.println("which book do you want to remove?");
int Remove_id=sc.nextInt();
int flag =0;
for(int i=0;i<books.size();i++) {
if (books.get(i).id==Remove_id) {
books.remove(i);
System.out.println("Book removed successfully!!.");
flag=1;
break;
}
}
if(flag!=1) {

System.out.println("book not found");
}else {
System.out.println("Now the number of books in thelibrary is "+books.size() +"\nThe updated list of the books is:");

System.out.println();
for (Library currentBook : books) {// get all the objectsstore in arrayList

currentBook.display();
}
}
}
void issue( Scanner sc, ArrayList<Library> books) {
System.out.println("All the books availabke in library are::");

for (Library currentBook : books) {// get all the objectstore in arraylist

currentBook.display();
}
System.out.println("which book do u want toissue?(enter ID)");

int issue_id=sc.nextInt();
int found=0;
for(int j=0;j<books.size();j++) {
if (books.get(j).id==issue_id) {
System.out.println("Issuestatus=1");
books.remove(j);
System.out.println("Now the number of books inthe library is "+books.size());

found=1;
break;

}
}if(found!=1) {
System.out.println("book not found:(");
}else {
for (Library currentBook : books) {// get all the objectsstore in arrayList

currentBook.display();
}
}
}
void ReturnBook(Scanner sc,ArrayList<Library>books,
Library lib) {

int flag=0;
System.out.println("Enter the name of the book to beReturned:");

lib.name=sc.nextLine();
System.out.println("Enter the Author of the book tobe Returned: ");

lib.authorname=sc.nextLine();
System.out.println("Enter the Id of the book tot be Returned: ");

lib.id=sc.nextInt();
books.add(lib);
System.out.println();
System.out.println("Now the number of books in thelibrary is "+books.size() +"The updated list of the books is:");

System.out.println();

for (Library currentBook : books) {// get all theobjects store in arrayList

currentBook.display();
}
}
}