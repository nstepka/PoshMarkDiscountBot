# PoshMarkDiscountBot  
This bot will auto send a 10% discount to all likers of your poshmark items for sale.  Built on java and the selenium webdriver.

Please star this project if you liked it!

You will need to download Java 8, selenium, and an IDE, I used Eclipse, and to download the google chrome driver of your browser.

Java 8 JDK can be downloaded here.
https://www.oracle.com/technetwork/java/javase/downloads/index.html

Selenium can be downloaded here, as well as the chromedriver.exe
https://www.seleniumhq.org/download/

Eclipse can be downloaded here.
https://www.eclipse.org/downloads/

You will need to update the emailAddress, password, closetSize and closetURL for it to work correctly before compile.

Thoughts for improvement.  

1. Should I leave the login as empty but just make time delay of 30 seconds to sign in?
2. Find the difference bettween an item that is for sale or has been sold?
3. Does the program get captcha? I havent seen it get caught yet.
4. Only works with items less then $200.

Known issues:
1.  Program crashes if the item for sale has no likes.  I need to create a condition that if the item does not any likes to skip.  There is a heart on the main tile, and there is also a notification that pops up.  I will implement the first solution i find out first, and then document the other way to do it as well and implement it if it is better.

If you run into any trouble feel free to send me a message!
